package com.bytedance.ai.debugscene;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AISDKDebugChannelManager$handleScanCode$1", f = "AISDKDebugChannelManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AISDKDebugChannelManager$handleScanCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $callback;
    final /* synthetic */ String $code;
    final /* synthetic */ long $openRequestId;
    final /* synthetic */ String $xToken;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AISDKDebugChannelManager$handleScanCode$1(String r1, String r10, long r11, Function2<? super Boolean, ? super String, Unit> r12, Continuation<? super AISDKDebugChannelManager$handleScanCode$1> r13) {
        this.$code = r1;
        this.$xToken = r10;
        this.$openRequestId = r11;
        this.$callback = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AISDKDebugChannelManager$handleScanCode$1(this.$code, this.$xToken, this.$openRequestId, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L166;
        ResultKt.throwOnFailure(r19);
        h1 r0 = h1.a;
        String r10 = this.$code;
        String r11 = this.$xToken;
        r0.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(UriProtector.parse(r10));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r12) == false) goto L12;
        r12 = null;
    L12:
        Uri r13 = (Uri) r12;
        boolean r14 = true;
        if (r13 != null) goto L16;
    L25:
        String r15 = null;
    L27:
        if (r15 == null) goto L29;
        h1.a.getClass();
        h1.b r16 = h1.k(r15, "", r11);
    L76:
        if ((r16 instanceof h1.b.a) == false) goto L79;
        Object r17 = new h1.d.a(((h1.b.a) r16).a);
    L120:
        if ((r17 instanceof h1.d.a) == false) goto L127;
        com.bytedance.ai.utils.g r18 = com.bytedance.ai.utils.g.a;
        StringBuilder r20 = new StringBuilder("handleScanCode failed to decode debug package info. reason: ");
        h1.d.a r21 = (h1.d.a) r17;
        r20.append(r21.a);
        r18.e("AppletDebugTool", r20.toString());
        h1 r22 = h1.a;
        Long r23 = Boxing.boxLong(this.$openRequestId);
        r22.getClass();
        h1.l(r23);
        Function2<Boolean, String, Unit> r24 = this.$callback;
        if (r24 == null) goto L125;
        r24.invoke(Boxing.boxBoolean(false), r21.a);
    L125:
        return Unit.INSTANCE;
    L127:
        if ((r17 instanceof h1.d.b) == false) goto L162;
        h1.c r25 = ((h1.d.b) r17).a;
        h1 r26 = h1.a;
        long r27 = this.$openRequestId;
        r26.getClass();
        Object r28 = h1.i;
        monitor-enter(r28);
    L158:
        th = move-exception;
        throw th;
    L131:
        if (h1.c == false) goto L136;
        if (h1.k != r27) goto L136;
        boolean r29 = true;
    L137:
        monitor-exit(r28);
        if (r29 == true) goto L145;
        Function2<Boolean, String, Unit> r30 = this.$callback;
        if (r30 == null) goto L143;
        r30.invoke(Boxing.boxBoolean(false), "Debug channel opening was cancelled.");
    L143:
        return Unit.INSTANCE;
    L145:
        if (h1.g == null) goto L149;
        boolean r31 = AppletDebugTool.f;
        AIDebugManager.a.getClass();
        if ((!AIDebugManager.e.isEmpty()) != true) goto L149;
    L150:
        if (r14 == false) goto L156;
        h1.l(Boxing.boxLong(this.$openRequestId));
        Function2<Boolean, String, Unit> r32 = this.$callback;
        if (r32 == null) goto L155;
        r32.invoke(Boxing.boxBoolean(false), "Please exit preview mode before enabling end-to-end debug mode.");
    L155:
        return Unit.INSTANCE;
    L156:
        h1.a(r26, r25, this.$openRequestId, this.$callback);
        return Unit.INSTANCE;
    L149:
        r14 = false;
    L136:
        r29 = false;
        goto L137
    L162:
        throw new NoWhenBranchMatchedException();
    L79:
        if ((r16 instanceof h1.b.C0039b) == false) goto L164;
        JSONObject r33 = h1.d(((h1.b.C0039b) r16).a);
        if (r33 != null) goto L83;
        r17 = new h1.d.a("failed to decode debug package info");
        goto L120
    L83:
        String r34 = StringsKt.trim(r33.optString("appletName")).toString();
        String r110 = h1.h(r33.optString("appletHost"));
        String r111 = h1.h(r33.optString("wifiConnectUrl"));
        if (r34.length() != 0) goto L86;
        boolean r35 = true;
    L87:
        if (r35 == true) goto L117;
        if (r110 != null) goto L90;
    L93:
        boolean r36 = true;
    L94:
        if (r36 == true) goto L117;
        boolean r112 = r33.optBoolean("isSigned", false);
        String r113 = r33.optString("signPublicKeyVersion", "");
        if (r112 == false) goto L106;
        if (r113 != null) goto L100;
    L103:
        boolean r37 = true;
    L104:
        if (r37 == false) goto L106;
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "signVersion is missing");
        Object r38 = new h1.d.a("signVersion is missing");
    L118:
        r17 = r38;
        goto L120
    L100:
        if (StringsKt.isBlank(r113) == true) goto L103;
        r37 = false;
    L106:
        String r39 = r33.optString("appletType", "");
        Intrinsics.checkNotNull(r39);
        if ((!StringsKt.isBlank(r39)) == true) goto L110;
        r39 = null;
    L110:
        if (r39 != null) goto L112;
        r39 = "0";
    L112:
        String r114 = r39;
        boolean r115 = r33.optBoolean("isEncrypted", false);
        String r40 = r33.optString("versionTag", "");
        Intrinsics.checkNotNull(r40);
        if ((!StringsKt.isBlank(r40)) == false) goto L115;
        String r116 = r40;
    L116:
        r17 = new h1.d.b(new h1.c(r34, r110, r114, r112, r113, r115, r116, r33.optBoolean("defaultDebugTagState", true), r111));
        goto L120
    L115:
        r116 = null;
        goto L116
    L90:
        if (r110.length() == 0) goto L93;
        r36 = false;
    L117:
        r38 = new h1.d.a("invalid debug package info");
        goto L118
    L86:
        r35 = false;
        goto L87
    L164:
        throw new NoWhenBranchMatchedException();
    L29:
        JSONObject r41 = h1.d(r10);
        if (r41 == null) goto L36;
        String r42 = r41.optString("debug_context");
        if (r42 == null) goto L36;
        if ((!StringsKt.isBlank(r42)) == false) goto L36;
    L37:
        if (r42 != null) goto L39;
    L42:
        boolean r43 = true;
    L43:
        if (r43 == true) goto L45;
        r16 = new h1.b.C0039b(r42);
        goto L76
    L45:
        if (r41 == null) goto L51;
        String r44 = r41.optString("debug_token");
        if (r44 == null) goto L51;
        if ((!StringsKt.isBlank(r44)) == false) goto L51;
    L52:
        if (r41 == null) goto L58;
        String r45 = r41.optString("encrypted_debug_payload");
        if (r45 == null) goto L58;
        if ((!StringsKt.isBlank(r45)) == false) goto L58;
    L59:
        if (r44 != null) goto L61;
    L64:
        boolean r46 = true;
    L65:
        if (r46 == true) goto L74;
        if (r45 != null) goto L68;
    L71:
        boolean r47 = true;
    L72:
        if (r47 == true) goto L74;
        r16 = h1.k(r44, r45, r11);
        goto L76
    L68:
        if (StringsKt.isBlank(r45) == true) goto L71;
        r47 = false;
    L74:
        r16 = new h1.b.C0039b(r10);
        goto L76
    L61:
        if (StringsKt.isBlank(r44) == true) goto L64;
        r46 = false;
    L58:
        r45 = null;
    L51:
        r44 = null;
        goto L52
    L39:
        if (StringsKt.isBlank(r42) == true) goto L42;
        r43 = false;
    L36:
        r42 = null;
        goto L37
    L16:
        if (Intrinsics.areEqual(r13.getScheme(), "doubaoapp") == false) goto L25;
        if (Intrinsics.areEqual(r13.getHost(), "local_debug") == false) goto L25;
        r15 = UriProtector.getQueryParameter(r13, "short_token");
        if (r15 == null) goto L25;
        if ((!StringsKt.isBlank(r15)) == false) goto L25;
    L7:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L166:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
