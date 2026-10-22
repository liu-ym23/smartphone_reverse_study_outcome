package com.bytedance.ai.bridge.method.net;

import android.net.Uri;
import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsConnectSocketMethodIDL;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J.\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/ConnectSocketMethod;", "Lcom/bytedance/ai/bridge/network/AbsConnectSocketMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsConnectSocketMethodIDL$ConnectSocketParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsConnectSocketMethodIDL$ConnectSocketResultModel;", "connectSocket", com.bytedance.android.ec.core.event.a.KEY_URL, "", "maskUrl", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectSocketMethod extends AbsConnectSocketMethodIDL {
    public static final CoroutineScope b = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.ConnectSocketMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.ConnectSocketMethod$handle$1", f = "ConnectSocketMethod.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsConnectSocketMethodIDL.b> $callback;
        final /* synthetic */ AbsConnectSocketMethodIDL.a $params;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ ConnectSocketMethod this$0;

        public AnonymousClass1(String r1, String r10, f3.h<AbsConnectSocketMethodIDL.b> r11, ConnectSocketMethod r12, e3.d r13, AbsConnectSocketMethodIDL.a r14, Continuation<? super AnonymousClass1> r15) {
            this.$appletId = r1;
            this.$url = r10;
            this.$callback = r11;
            this.this$0 = r12;
            this.$bridgeContext = r13;
            this.$params = r14;
            super(2, r15);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appletId, this.$url, this.$callback, this.this$0, this.$bridgeContext, this.$params, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r24) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r24);
            Object r11 = r24;
        L11:
            com.bytedance.ai.applet.domain.e r12 = (com.bytedance.ai.applet.domain.e) r11;
            if (r12.a == true) goto L15;
            com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
            StringBuilder r13 = new StringBuilder("call failed, errNo=");
            f3.a r14 = f3.a.l;
            r13.append(r14.a);
            r13.append(", msg=");
            r13.append(r12.b);
            r1.e("AISDK_JSB_ConnectSocketMethod", r13.toString());
            f3.h.a.a(this.$callback, r12.b, r14, null, 10);
            return Unit.INSTANCE;
        L15:
            ConnectSocketMethod r15 = this.this$0;
            e3.d r16 = this.$bridgeContext;
            AbsConnectSocketMethodIDL.a r17 = this.$params;
            f3.h<AbsConnectSocketMethodIDL.b> r18 = this.$callback;
            String r19 = this.$url;
            CoroutineScope r20 = ConnectSocketMethod.b;
            r15.getClass();
            c4.a r110 = c4.b.a(r16);
            if (r110 != null) goto L18;
            com.bytedance.ai.utils.g r21 = com.bytedance.ai.utils.g.a;
            StringBuilder r22 = new StringBuilder("call failed, errNo=");
            f3.a r23 = f3.a.n;
            r22.append(r23.a);
            r22.append(", msg=bridge context is unavailable");
            r21.e("AISDK_JSB_ConnectSocketMethod", r22.toString());
            f3.h.a.a(r18, "bridge context is unavailable", r23, null, 10);
        L113:
            return Unit.INSTANCE;
        L18:
            Map<String, String> r25 = r17.getHeader();
            List<String> r26 = r17.getProtocols();
            if (r26 == null) goto L21;
            List r27 = CollectionsKt.toList(r26);
        L22:
            Intrinsics.checkNotNullParameter(r16, "bridgeContext");
            Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.KEY_URL);
            Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L25
            Object r29 = Result.constructor-impl(new URI(r19));     // Catch: Throwable -> L25
        L28:
            if (Result.isFailure-impl(r29) == false) goto L30;
            r29 = null;
        L30:
            URI r30 = (URI) r29;
            if (r30 == null) goto L35;
            String r31 = r30.getScheme();
            if (r31 == null) goto L35;
            String r32 = r31.toLowerCase(Locale.ROOT);
        L37:
            if (Intrinsics.areEqual(r32, "ws") == false) goto L39;
        L116:
            Map r33 = c4.a.e(r25, r27);     // Catch: IllegalArgumentException -> L97
            int r34 = c4.a.c.c;
            c4.a.c r35 = c4.a.c.C0009a.a(r16);
            if (r35 != null) goto L45;
            c4.a.b r36 = new c4.a.b(null, "bridge context is unavailable", f3.a.n, 1);
        L102:
            Long r37 = r36.a;
            if (r37 != null) goto L111;
            f3.a r38 = r36.c;
            if (r38 != null) goto L107;
            r38 = f3.a.y;
        L107:
            String r39 = r36.b;
            if (r39 != null) goto L110;
            r39 = "connectSocket failed";
        L110:
            com.bytedance.ai.utils.g.a.e("AISDK_JSB_ConnectSocketMethod", "call failed, errNo=" + r38.a + ", msg=" + r38.b);
            f3.h.a.a(r18, r39, r38, null, 10);
            goto L113
        L111:
            com.bytedance.ai.utils.g.a.i("AISDK_JSB_ConnectSocketMethod", "call success, socketTaskId=" + r37);
            Intrinsics.checkNotNullParameter(AbsConnectSocketMethodIDL.b.class, "<this>");
            BaseModel r40 = k3.c.a(AbsConnectSocketMethodIDL.b.class);
            ((AbsConnectSocketMethodIDL.b) r40).setSocketTaskId(r37.longValue());
            f3.h.a.b(r18, (ResultModel) r40);
            goto L113
        L45:
            Object r111 = r110.b;
            monitor-enter(r111);
            Map r41 = (Map) ((LinkedHashMap) r110.c).get(r35);     // Catch: Throwable -> L94
            if (r41 == null) goto L50;
            int r42 = r41.size();     // Catch: Throwable -> L94
        L52:
            if (r42 < 5) goto L56;
            f3.a.C0156a r43 = f3.a.c;     // Catch: Throwable -> L94
            f3.a r44 = f3.b.a;     // Catch: Throwable -> L94
            Intrinsics.checkNotNullParameter(r43, "<this>");     // Catch: Throwable -> L94
            r36 = new c4.a.b(null, "WebSocket connection count exceeds 5", f3.b.h, 1);     // Catch: Throwable -> L94
            monitor-exit(r111);
            goto L102
        L56:
            long r45 = r110.a.incrementAndGet();     // Catch: Throwable -> L94
            c4.a.e r112 = new c4.a.e(r110, r45, r35, r16);     // Catch: Throwable -> L87
            Map<Long, c4.a.e> r46 = (Map) ((LinkedHashMap) r110.c).get(r35);     // Catch: Throwable -> L94
            if (r46 != null) goto L61;
            r46 = new LinkedHashMap();     // Catch: Throwable -> L94
        L61:
            r46.put(Long.valueOf(r45), r112);     // Catch: Throwable -> L94
            r110.c.put(r35, r46);     // Catch: Throwable -> L94
            Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L94
            monitor-exit(r111);
            Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r33, "headers");
            r112.d.openConnection(MapsKt.emptyMap(), r33, CollectionsKt.listOf(r19), false, false);     // Catch: Throwable -> L66
            Object r48 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L66
        L68:
            Throwable r49 = Result.exceptionOrNull-impl(r48);
            if (r49 == null) goto L74;
            String r50 = r49.getMessage();
            if (r50 != null) goto L73;
            r50 = "connectSocket failed";
        L73:
            c4.a.d r51 = new c4.a.d(r50, f3.a.y);
        L75:
            if (r51 == null) goto L86;
            Object r52 = r110.b;
            monitor-enter(r52);
            r110.i(r45, r35, r112);     // Catch: Throwable -> L82
            monitor-exit(r52);
            r36 = new c4.a.b(null, r51.a, r51.b, 1);
        L82:
            th = move-exception;
            throw th;
        L86:
            r36 = new c4.a.b(Long.valueOf(r45), null, null, 6);
            goto L102
        L74:
            r51 = null;
        L66:
            th = move-exception;
            Result.Companion r53 = Result.Companion;
            r48 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L68
        L87:
            th = move-exception;
            String r54 = th.getMessage();     // Catch: Throwable -> L94
            if (r54 != null) goto L93;
            r54 = "connectSocket failed";
        L93:
            r36 = new c4.a.b(null, r54, f3.a.f, 1);     // Catch: Throwable -> L94
            goto L102
        L50:
            r42 = 0;
        L94:
            th = move-exception;
            throw th;
        L97:
            e = move-exception;
            String r55 = e.getMessage();
            if (r55 != null) goto L101;
            r55 = "invalid socket url";
        L101:
            r36 = new c4.a.b(null, r55, f3.a.h, 1);
            goto L102
        L39:
            if (Intrinsics.areEqual(r32, "wss") == true) goto L116;
            r36 = new c4.a.b(null, "invalid socket url", f3.a.h, 1);
        L35:
            r32 = null;
        L25:
            th = move-exception;
            Result.Companion r56 = Result.Companion;
            r29 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        L21:
            r27 = null;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r24);
            AppletDomainPolicyManager r57 = AppletDomainPolicyManager.a;
            String r58 = this.$appletId;
            String r59 = this.$url;
            this.label = 1;
            r11 = r57.e(r58, r59, this);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    static {
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public ConnectSocketMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r15, ParamModel r16, f3.h r17) {
        AbsConnectSocketMethodIDL.a r10 = (AbsConnectSocketMethodIDL.a) r16;
        Intrinsics.checkNotNullParameter(r15, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r17, "callback");
        String r11 = r10.getUrl();
        a0 r1 = r15.getContainerContext();
        com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
        StringBuilder r13 = new StringBuilder("call start, url=");
        Object r14 = "invalid_url";
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Uri r18 = UriProtector.parse(r11);     // Catch: Throwable -> L15
        String r19 = r18.getScheme();     // Catch: Throwable -> L15
        if (r19 == null) goto L8;
        String r110 = r18.getHost();     // Catch: Throwable -> L15
        if (r110 == null) goto L8;
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L15
        r111.append(r19);     // Catch: Throwable -> L15
        r111.append("://");     // Catch: Throwable -> L15
        r111.append(r110);     // Catch: Throwable -> L15
        String r20 = r18.getPath();     // Catch: Throwable -> L15
        if (r20 != null) goto L12;
        r20 = "";
    L12:
        r111.append(r20);     // Catch: Throwable -> L15
        String r21 = r111.toString();     // Catch: Throwable -> L15
    L13:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r22) == true) goto L21;
        r14 = r22;
    L21:
        r13.append((String) r14);
        r13.append(", headerCount=");
        Map<String, String> r23 = r10.getHeader();
        int r24 = 0;
        if (r23 == null) goto L24;
        int r25 = r23.size();
    L25:
        r13.append(r25);
        r13.append(", protocolCount=");
        List<String> r26 = r10.getProtocols();
        if (r26 == null) goto L28;
        r24 = r26.size();
    L28:
        r13.append(r24);
        r13.append(", appletId=");
        String r27 = null;
        if (r1 == null) goto L31;
        String r28 = r1.getAppletId();
    L32:
        r13.append(r28);
        r13.append(", containerId=");
        if (r1 == null) goto L35;
        String r29 = r1.getContainerId();
    L36:
        r13.append(r29);
        r12.i("AISDK_JSB_ConnectSocketMethod", r13.toString());
        if (StringsKt.isBlank(r11) == false) goto L39;
        com.bytedance.ai.utils.g r30 = com.bytedance.ai.utils.g.a;
        StringBuilder r31 = new StringBuilder("call failed, errNo=");
        f3.a r32 = f3.a.h;
        r31.append(r32.a);
        r31.append(", msg=url is empty");
        r30.e("AISDK_JSB_ConnectSocketMethod", r31.toString());
        f3.h.a.a(r17, "url is empty", r32, null, 10);
        return;
    L39:
        a0 r33 = r15.getContainerContext();
        if (r33 == null) goto L42;
        r27 = r33.getAppletId();
    L42:
        BuildersKt.launch$default(b, null, null, new AnonymousClass1(r27, r11, r17, this, r15, r10, null), 3, null);
        return;
    L35:
        r29 = null;
        goto L36
    L31:
        r28 = null;
        goto L32
    L24:
        r25 = 0;
    L8:
        r21 = "invalid_url";
    L15:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
