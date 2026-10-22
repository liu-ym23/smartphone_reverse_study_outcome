package com.obric.matrix.platform.sdk.ones.ws;

import android.util.Log;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.SubscribeWsMsgResponse;
import com.obric.matrix.proto.SubscribeWsStatusResponse;
import com.obric.matrix.proto.WsMessageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import z8.e;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixWsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MatrixWsHelper f5914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.obric.matrix.platform.sdk.ones.ws.a f5915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<Function4<Integer, Integer, Integer, Boolean, Unit>> f5916c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit>> f5917d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2<? super Boolean, ? super Response, Unit> f5918e;

    public static final class a implements e {
        a() {
        }

        @Override // z8.e
        public void a(int r14, Response r15) {
            Intrinsics.checkNotNullParameter(r15, "response");
            ResponseBody r13 = r15.body;
            if (r13 == null) goto L10;
            SubscribeWsMsgResponse r16 = r13.subscribeWsMsgResponse;
            if (r16 == null) goto L11;
            ConcurrentHashMap r17 = MatrixWsHelper.a();
            Integer r18 = r16.wsMessageInfo.service;
            Intrinsics.checkNotNullExpressionValue(r18, "it.wsMessageInfo.service");
            int r19 = r18.intValue();
            Integer r10 = r16.wsMessageInfo.method;
            Intrinsics.checkNotNullExpressionValue(r10, "it.wsMessageInfo.method");
            Function9 r11 = (Function9) r17.get(com.obric.matrix.platform.sdk.ones.ws.b.a(r19, r10.intValue()));
            if (r11 == null) goto L12;
            Integer r12 = r16.wsMessageInfo.channelId;
            Intrinsics.checkNotNullExpressionValue(r12, "it.wsMessageInfo.channelId");
            Long r20 = r16.wsMessageInfo.seqId;
            Intrinsics.checkNotNullExpressionValue(r20, "it.wsMessageInfo.seqId");
            Long r21 = r16.wsMessageInfo.logId;
            Intrinsics.checkNotNullExpressionValue(r21, "it.wsMessageInfo.logId");
            Integer r22 = r16.wsMessageInfo.service;
            Intrinsics.checkNotNullExpressionValue(r22, "it.wsMessageInfo.service");
            Integer r23 = r16.wsMessageInfo.method;
            Intrinsics.checkNotNullExpressionValue(r23, "it.wsMessageInfo.method");
            WsMessageInfo r110 = r16.wsMessageInfo;
            r11.invoke(r12, r20, r21, r22, r23, r110.payloadEncoding, r110.payloadType, r110.payload.toByteArray(), r16.wsMessageInfo.headers);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements e {
        b() {
        }

        @Override // z8.e
        public void a(int r10, Response r11) {
            Intrinsics.checkNotNullParameter(r11, "response");
            ResponseBody r12 = r11.body;
            if (r12 == null) goto L10;
            SubscribeWsStatusResponse r13 = r12.subscribeWsStatusResponse;
            if (r13 == null) goto L10;
            Log.d("MatrixWsHelper", "wsStatusCallbackFromMatrix # onResult() called with subscribeWsStatusResponse = " + r13);
            MatrixWsHelper r14 = MatrixWsHelper.f5914a;
            Boolean r15 = r13.isConnected;
            Intrinsics.checkNotNullExpressionValue(r15, "it.isConnected");
            MatrixWsHelper.d(r15.booleanValue());
            Iterator r16 = MatrixWsHelper.b().iterator();
        L8:
            if (r16.hasNext() == false) goto L10;
            Function4 r17 = (Function4) r16.next();
            Integer r18 = r13.channelType;
            Intrinsics.checkNotNullExpressionValue(r18, "it.channelType");
            Integer r19 = r13.connectionState;
            Intrinsics.checkNotNullExpressionValue(r19, "it.connectionState");
            Integer r20 = r13.channelId;
            Intrinsics.checkNotNullExpressionValue(r20, "it.channelId");
            Boolean r21 = r13.isConnected;
            Intrinsics.checkNotNullExpressionValue(r21, "it.isConnected");
            r17.invoke(r18, r19, r20, r21);
        L10:
            Function2 r22 = MatrixWsHelper.c();
            if (r22 == null) goto L22;
            ResponseBody r23 = r11.body;
            if (r23 == null) goto L15;
            SubscribeWsStatusResponse r24 = r23.subscribeWsStatusResponse;
        L16:
            if (r24 == null) goto L18;
            boolean r25 = true;
        L19:
            r22.invoke(Boolean.valueOf(r25), r11);
            MatrixWsHelper r26 = MatrixWsHelper.f5914a;
            MatrixWsHelper.e(null);
            return;
        L18:
            r25 = false;
            goto L19
        L15:
            r24 = null;
            goto L16
        }
    }

    static {
        f5914a = new MatrixWsHelper();
        f5916c = new ArrayList();
        f5917d = new ConcurrentHashMap();
        new a();
        new b();
        new c(MatrixWsHelper$wsStatusReceiverFromMatrix$1.INSTANCE);
    }

    private MatrixWsHelper() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f5917d;
    }

    public static final /* synthetic */ List b() {
        return f5916c;
    }

    public static final /* synthetic */ Function2 c() {
        return f5918e;
    }

    public static final /* synthetic */ void d(boolean r10) {
    }

    public static final /* synthetic */ void e(Function2 r10) {
        f5918e = r10;
    }

    public final void f(int r16, long r17, long r19, int r21, int r22, String r23, String r24, byte[] r25, HashMap<String, String> r26) {
        e9.b.b("MatrixWsHelper", "onWsMsgReceivedByProvider() called with: channelId = " + r16 + ", seqId = " + r17 + ", logId = " + r19 + ", service = " + r21 + ", method = " + r22 + ", encoding = " + r23 + ", type = " + r24 + ", payload = " + r25 + ", headers = " + r26 + ", wsBridge is " + f5915b, null, 4, null);
        com.obric.matrix.platform.sdk.ones.ws.a r10 = f5915b;
        if (r10 == null) goto L6;
        r10.a(r16, r17, r19, r21, r22, r23, r24, r25, r26);
        return;
    }
}
