package com.larus.basic.experience.downgrade.api;

import com.bytedance.ttnet.http.RequestContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.f;
import com.larus.network.http.v;
import java.util.Map;
import juc.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jª\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u001aJÐ\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007\"\b\b\u0001\u0010\u001b*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u0002H\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u001e2\u0006\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010 J¨\u0001\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010#Jª\u0001\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u001aJ¨\u0001\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010#Jy\u0010&\u001a\u0004\u0018\u00010\u0013\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"Lcom/larus/basic/experience/downgrade/api/FlowDowngradeServiceNoop;", "Lcom/larus/basic/experience/downgrade/api/IFlowDowngradeService;", "<init>", "()V", "requestPost", "Lcom/larus/network/http/Async;", "T", "", "tag", "", "outClazz", "Ljava/lang/Class;", "path", "bodyJson", "Lorg/json/JSONObject;", "contentType", "headerMap", "", "needTrace", "", "metric", "requestContext", "Lcom/bytedance/ttnet/http/RequestContext;", "requestChangeListener", "Lcom/larus/network/http/INetRequestListener;", "extra", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Lcom/larus/network/http/INetRequestListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Req", "requestBody", "bodySerializer", "Lkotlinx/serialization/KSerializer;", "responseSerializer", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Lcom/larus/network/http/INetRequestListener;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestGet", "queryMap", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLjava/util/Map;Lcom/bytedance/ttnet/http/RequestContext;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPostMock", "requestGetMock", "getIsAuto", "(Ljava/lang/String;Ljava/lang/Class;Lorg/json/JSONObject;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/Boolean;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FlowDowngradeServiceNoop implements IFlowDowngradeService {
    public FlowDowngradeServiceNoop() {
    }

    public <T> Boolean getIsAuto(String r1, Class<T> r2, JSONObject r3, Map<String, String> r4, Map<String, String> r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Intrinsics.checkNotNullParameter(r2, "outClazz");
        Intrinsics.checkNotNullParameter(r3, "bodyJson");
        return null;
    }

    public <T> Object requestGet(String r10, Class<T> r11, String r12, Map<String, String> r13, Map<String, String> r14, boolean r15, Map<String, ? extends Object> r16, RequestContext r17, Map<String, String> r18, Continuation<? super a<? extends T>> r19) {
        return HttpExtKt.g(r10, r11, r12, r13, r14, r15, r16, r17, r19);
    }

    public <T> Object requestGetMock(String r1, Class<T> r2, String r3, Map<String, String> r4, Map<String, String> r5, boolean r6, Map<String, ? extends Object> r7, RequestContext r8, Map<String, String> r9, Continuation<? super a<? extends T>> r10) {
        return new f(new AsyncThrowable(-99999, "service impl is null", new Throwable()), null);
    }

    public <T> Object requestPost(String r12, Class<T> r13, String r14, JSONObject r15, String r16, Map<String, String> r17, boolean r18, Map<String, ? extends Object> r19, RequestContext r20, v r21, Map<String, String> r22, Continuation<? super a<? extends T>> r23) {
        return HttpExtKt.l(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23);
    }

    public <T> Object requestPostMock(String r1, Class<T> r2, String r3, JSONObject r4, String r5, Map<String, String> r6, boolean r7, Map<String, ? extends Object> r8, RequestContext r9, v r10, Map<String, String> r11, Continuation<? super a<? extends T>> r12) {
        return new f(new AsyncThrowable(-99999, "service impl is null", new Throwable()), null);
    }

    public <T, Req> Object requestPost(String r14, Class<T> r15, String r16, Req r17, d<Req> r18, d<T> r19, String r20, Map<String, String> r21, boolean r22, Map<String, ? extends Object> r23, RequestContext r24, v r25, Map<String, String> r26, Continuation<? super a<? extends T>> r27) {
        return HttpExtKt.i(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27);
    }
}
