package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import hq9.v2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "data", "Lcom/larus/bmhome/auth/IMLaunchInfo;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$requestIMLaunch$2", f = "AuthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AuthViewModel$requestIMLaunch$2 extends SuspendLambda implements Function2<j0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $shouldQueryImConfig;
    final /* synthetic */ v2 $socialRequestSession;
    final /* synthetic */ String $socialRequestUid;
    /* synthetic */ Object L$0;
    int label;

    public AuthViewModel$requestIMLaunch$2(boolean r1, v2 r2, String r3, Continuation<? super AuthViewModel$requestIMLaunch$2> r4) {
        this.$shouldQueryImConfig = r1;
        this.$socialRequestSession = r2;
        this.$socialRequestUid = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AuthViewModel$requestIMLaunch$2 r0 = new AuthViewModel$requestIMLaunch$2(this.$shouldQueryImConfig, this.$socialRequestSession, this.$socialRequestUid, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(j0 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((j0) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r9);
        j0 r10 = (j0) this.L$0;
        FLogger r0 = FLogger.a;
        r0.d("AuthViewModel", "im launch resp: shouldQueryImConfig=" + this.$shouldQueryImConfig + " imConfig=" + r10.l());
        LarkSocialExp r1 = LarkSocialExp.a;
        IMConfig r2 = r10.l();
        String r3 = null;
        if (r2 == null) goto L7;
        Boolean r4 = r2.a();
    L8:
        v2 r5 = this.$socialRequestSession;
        String r6 = this.$socialRequestUid;
        r1.getClass();
        if (r6 == null) goto L31;
        boolean r7 = true;
        if ((!StringsKt.isBlank(r6)) == false) goto L13;
        r3 = r6;
    L13:
        if (r3 == null) goto L31;
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L31;
        LarkSocialExp.d().storeBoolean(LarkSocialExp.o("key_lark_social_im_invited", r3), true);
        LarkSocialExp.d().storeBoolean("key_lark_social_im_invited_device", true);
        v2 r8 = LarkSocialExp.a();
        if (r5 != null) goto L21;
    L23:
        r7 = false;
    L24:
        StringBuilder r11 = new StringBuilder("updateIMInviteCache generation=");
        if (r5 == null) goto L27;
        long r12 = r5.b;
    L28:
        r11.append(r12);
        r11.append(" isCurrent=");
        r11.append(r7);
        r0.i("LarkSocialExp", r11.toString());
        if (r7 == false) goto L31;
        r1.n("passive_invite");
        goto L31
    L27:
        r12 = -1;
        goto L28
    L21:
        if (Intrinsics.areEqual(r5, r8) == false) goto L23;
    L31:
        Gson r13 = z0.a;
        Intrinsics.checkNotNullParameter(r10, "imLaunchInfo");
        z0.n = r10;
        z0.n("launch_cache_im_info", r10);
        return Unit.INSTANCE;
    L7:
        r4 = null;
        goto L8
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
