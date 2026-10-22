package com.bytedance.forest.chain.fetchers;

import android.webkit.WebResourceResponse;
import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.p;
import com.bytedance.forest.model.w;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.PostProcessRequest;
import com.bytedance.forest.postprocessor.ProcessedData;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/MemoryFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Lcom/bytedance/forest/Forest;)V", "Lcom/bytedance/forest/model/w;", "response", "Lkotlin/Function1;", "", "callback", "finishWithCallback", "(Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "recordFinish", "(Lcom/bytedance/forest/model/w;)V", "Lcom/bytedance/forest/model/Request;", "request", "fetchSync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;)V", "fetchAsync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "cancel", "()V", "", "TAG", "Ljava/lang/String;", "Companion", "com/bytedance/forest/chain/fetchers/j", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class MemoryFetcher extends ResourceFetcher {
    public static final j Companion = null;
    private final String TAG;

    static {
        Companion = new j();
    }

    public MemoryFetcher(Forest r5) {
        super(r5);
        this.TAG = "MemoryFetcher";
    }

    private final void finishWithCallback(w r5, Function1<? super w, Unit> r10) {
        recordFinish(r5);
        r10.invoke(r5);
    }

    private final void recordFinish(w r5) {
        getContext$forest_release().b(new String[]{"memory_finish"});
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(Request r24, final w r25, Function1<? super w, Unit> r26) {
        getContext$forest_release().b(new String[]{"memory_start", "memory_get_cache_start"});
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, this.TAG, "start to fetch from memory", true, null, "memory_start", 16);
        com.bytedance.forest.utils.a r5 = r24.getCacheKey$forest_release();
        if (r5 != null) goto L6;
        com.bytedance.forest.model.c r10 = r25.s;
        ErrorInfo$Type r11 = ErrorInfo$Type.f4310b;
        r10.getClass();
        r10.f4360a += r10.a(r11, 1, "cannot build cache identifier");
        finishWithCallback(r25, r26);
        return;
    L6:
        com.bytedance.forest.utils.h r12 = getForest().getMemoryManager$forest_release().b(r5, r24.getEnableRequestReuse());
        getContext$forest_release().b(new String[]{"memory_get_cache_finish"});
        if (r12 != null) goto L10;
        com.bytedance.forest.model.c r13 = r25.s;
        ErrorInfo$Type r14 = ErrorInfo$Type.f4310b;
        r13.getClass();
        r13.f4360a += r13.a(r14, 2, "could not found memory cache");
        finishWithCallback(r25, r26);
        return;
    L10:
        w r15 = r12.d;
        p r16 = r12.f4625a;
        String r17 = r15.f4443t;
        if (r17 == null) goto L13;
        File r18 = new File(r17);
    L15:
        if (r18 != null) goto L17;
    L18:
        if (r16 != null) goto L21;
        com.bytedance.forest.model.c r19 = r25.s;
        ErrorInfo$Type r20 = ErrorInfo$Type.f4310b;
        r19.getClass();
        r19.f4360a += r19.a(r20, 5, "find cache but can not be consumed");
        getForest().getMemoryManager$forest_release().a(r5);
        finishWithCallback(r25, r26);
        return;
    L21:
        ResourceFrom r110 = r15.f4444u;
        if (r110 == null) goto L52;
        int r111 = r110.ordinal();
        String r112 = "[onlyOnline:1]";
        if (r111 == 0) goto L47;
        if (r111 == 1) goto L41;
        if (r111 != 2) goto L52;
        if (r24.getDisableCdn() == false) goto L33;
        r112 = "[disableCdn:1]";
    L54:
        if (com.lynx.tasm.behavior.utils.d.g(r112) == false) goto L57;
        com.bytedance.forest.model.c r21 = r25.s;
        r21.getClass();
        r21.f4360a += r21.a(ErrorInfo$Type.f4310b, 5, "found cache but disabled by request config " + r112);
        finishWithCallback(r25, r26);
        return;
    L57:
        ResourceFrom r22 = r15.f4444u;
        ResourceFrom r113 = ResourceFrom.d;
        if (r22 != r113) goto L61;
        r22 = null;
    L61:
        if (r22 != null) goto L65;
        r22 = r15.f4445v;
    L65:
        if (r22 != ResourceFrom.f4340c) goto L70;
        String r23 = r15.f4441q.getOriginUrl();
        getContext$forest_release().b(new String[]{"memory_check_cache_expired_start"});
        j r114 = Companion;
        com.bytedance.forest.pollyfill.l r115 = r15.b();
        com.bytedance.forest.utils.e r116 = getContext$forest_release();
        int r27 = r15.f4441q.getCustomHttpMaxAge();
        r114.getClass();
        boolean r28 = j.a(r23, r115, r18, r116, r27);
        getContext$forest_release().b(new String[]{"memory_check_cache_expired_finish"});
        if (r28 == false) goto L76;
        getForest().getMemoryManager$forest_release().a(r5);
        com.bytedance.forest.model.c r29 = r25.s;
        ErrorInfo$Type r30 = ErrorInfo$Type.f4310b;
        r29.getClass();
        r29.f4360a += r29.a(r30, 3, "cdn cache expired");
        finishWithCallback(r25, r26);
        return;
    L76:
        if ((r15 instanceof com.bytedance.forest.postprocessor.g) == false) goto L92;
        if (((com.bytedance.forest.postprocessor.g) r15).D == false) goto L92;
        if ((r24 instanceof PostProcessRequest) == true) goto L83;
        com.bytedance.forest.model.c r31 = r25.s;
        ErrorInfo$Type r32 = ErrorInfo$Type.f4310b;
        r31.getClass();
        r31.f4360a += r31.a(r32, 5, "cached response is an processed one and newly request no need to process");
        finishWithCallback(r25, r26);
        return;
    L83:
        Request r33 = r15.f4441q;
        if (r33 == null) goto L91;
        ForestPostProcessor r34 = ((PostProcessRequest) r33).getPostProcessor$forest_release();
        ForestPostProcessor r35 = ((PostProcessRequest) r24).getPostProcessor$forest_release();
        if (Intrinsics.areEqual(r34.getClass(), r35.getClass()) == true) goto L92;
        com.bytedance.forest.model.c r36 = r25.s;
        ErrorInfo$Type r37 = ErrorInfo$Type.f4310b;
        String r38 = "processor for cached response is " + r34.getClass() + ", required is " + r35.getClass();
        r36.getClass();
        r36.f4360a += r36.a(r37, 5, r38);
        finishWithCallback(r25, r26);
        return;
    L91:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.PostProcessRequest<*>");
    L92:
        r25.f4442r = true;
        r25.f4443t = r15.f4443t;
        r25.f4444u = r15.f4444u;
        r25.f4445v = r15.f4445v;
        r25.g = r15.f();
        r25.f4434j = r15.e();
        r25.f4446w = true;
        r25.f4435k = r15.f4435k;
        r25.f4449z = r15.f4449z;
        r25.e = r15.e;
        r25.f = r15.f;
        r25.f4448y = r15.f4448y;
        r25.f4447x = r15.f4447x;
        r25.f4439o = r15.f4439o;
        r25.f4440p = r15.f4440p;
        r25.s.b(r15.s, new ErrorInfo$Type[]{ErrorInfo$Type.f4310b});
        if (r16 == null) goto L95;
        r16.setContext$forest_release(getContext$forest_release());
        Unit r39 = Unit.INSTANCE;
        p r40 = r16;
    L96:
        r25.d(r40);
        if ((r16 instanceof ForestBuffer) == false) goto L102;
        WebResourceResponse r41 = r15.d;
        if (r41 == null) goto L118;
        Map<String, String> r42 = r41.getResponseHeaders();
        List r43 = com.bytedance.forest.utils.k.f4646a;
        r25.d = com.bytedance.forest.utils.k.a(r41.getMimeType(), r41.getEncoding(), r16.provideInputStream(r25), r24.getOriginUrl(), r42);
        Unit r44 = Unit.INSTANCE;
    L118:
        p r45 = r12.f4625a;
        if (r45 != null) goto L121;
    L130:
        Unit r46 = Unit.INSTANCE;
        finishWithCallback(r25, r26);
        return;
    L121:
        if (r45.isCacheProvided$forest_release() != true) goto L130;
        r25.f4444u = r113;
        ResourceFrom r47 = r15.f4444u;
        if (r47 == r113) goto L125;
        ResourceFrom r117 = r47;
    L126:
        if (r117 != null) goto L129;
        r117 = r15.f4445v;
    L129:
        r25.f4445v = r117;
        goto L130
    L125:
        r117 = null;
        goto L126
    L102:
        if ((r16 instanceof ProcessedData) == false) goto L118;
        if ((r25 instanceof com.bytedance.forest.postprocessor.g) == true) goto L106;
        w r48 = null;
    L107:
        com.bytedance.forest.postprocessor.g r49 = (com.bytedance.forest.postprocessor.g) r48;
        if (r49 == null) goto L117;
        if (r16 == null) goto L116;
        ProcessedData r50 = (ProcessedData) r16;
        if (r50 == null) goto L113;
        r49.D = true;
        r49.d(r50);
    L114:
        r49.C = r50;
        Unit r51 = Unit.INSTANCE;
        goto L118
    L113:
        r49.D = false;
        goto L114
    L116:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedData<kotlin.Any>");
    L117:
        final ProcessedData r52 = (ProcessedData) r16;
        com.bytedance.forest.utils.d.c(getContext$forest_release().g, 6, "MemoryFetcher", null, null, new MemoryFetcher$fetchAsync$$inlined$apply$lambda$1(r25, r52), 24);
        Unit r53 = Unit.INSTANCE;
        goto L118
    L106:
        r48 = r25;
        goto L107
    L95:
        r40 = null;
        goto L96
    L70:
        if (r18 == null) goto L76;
        if (r18.isFile() == true) goto L76;
        com.bytedance.forest.model.c r54 = r25.s;
        ErrorInfo$Type r55 = ErrorInfo$Type.f4310b;
        String r56 = "from " + r15.f4444u + " but " + r18.getAbsoluteFile() + " not exists or a directory";
        r54.getClass();
        r54.f4360a += r54.a(r55, 4, r56);
        getForest().getMemoryManager$forest_release().a(r5);
        finishWithCallback(r25, r26);
        return;
    L33:
        if (r24.getOnlyLocal() == false) goto L36;
        r112 = "[onlyLocal:1]";
        goto L54
    L36:
        if (r24.getEnableCDNCache() == true) goto L52;
        if (r15.f4446w == false) goto L52;
        r112 = "[enableCDNCache:0, isCache:1]";
        goto L54
    L41:
        if (r24.getDisableBuiltin() == false) goto L44;
        r112 = "[disableBuiltin:1]";
        goto L54
    L44:
        if (r24.getOnlyOnline() == false) goto L52;
    L47:
        if (r24.getDisableOffline() == false) goto L50;
        r112 = "[disableOffline:1]";
        goto L54
    L50:
        if (r24.getOnlyOnline() == true) goto L54;
    L52:
        r112 = null;
        goto L54
    L17:
        if (r18.isFile() == true) goto L21;
    L13:
        r18 = null;
        goto L15
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request r5, w r10) {
        fetchAsync(r5, r10, AnonymousClass1.f4282a);
    }
}
