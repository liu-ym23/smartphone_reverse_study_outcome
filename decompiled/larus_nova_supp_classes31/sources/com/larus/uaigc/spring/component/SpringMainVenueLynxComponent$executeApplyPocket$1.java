package com.larus.uaigc.spring.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.component.SpringMainVenueLynxComponent$executeApplyPocket$1", f = "SpringMainVenueLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMainVenueLynxComponent$executeApplyPocket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $extra;
    final /* synthetic */ boolean $isFromAvatarResult;
    final /* synthetic */ Map<String, Object> $originData;
    int label;
    final /* synthetic */ SpringMainVenueLynxComponent this$0;

    public SpringMainVenueLynxComponent$executeApplyPocket$1(Map<String, ? extends Object> r1, SpringMainVenueLynxComponent r2, Map<String, ? extends Object> r3, boolean r4, Continuation<? super SpringMainVenueLynxComponent$executeApplyPocket$1> r5) {
        this.$originData = r1;
        this.this$0 = r2;
        this.$extra = r3;
        this.$isFromAvatarResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SpringMainVenueLynxComponent$executeApplyPocket$1(this.$originData, this.this$0, this.$extra, this.$isFromAvatarResult, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L86;
        ResultKt.throwOnFailure(r18);
        Map<String, Object> r3 = this.$originData;
        SpringMainVenueLynxComponent r4 = this.this$0;
        Map<String, Object> r5 = this.$extra;
        boolean r6 = this.$isFromAvatarResult;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L68
        Pocket r9 = com.larus.uaigc.lynx.pocket.d.e(r3);     // Catch: Throwable -> L68
        int r10 = SpringMainVenueLynxComponent.P;     // Catch: Throwable -> L68
        r4.I = null;     // Catch: Throwable -> L68
        zz9.d r11 = r4.Z3();     // Catch: Throwable -> L68
        if (r11 == null) goto L8;
        r11.O2(null);     // Catch: Throwable -> L68
    L8:
        FLogger r12 = FLogger.a;     // Catch: Throwable -> L68
        r12.i("SpringMainVenueComponent", "[clearAlbumClickPocketInfo] finish, currClickPocketInfo = null");     // Catch: Throwable -> L68
        Integer r13 = r9.getIntentionType();     // Catch: Throwable -> L68
        boolean r14 = true;
        if (r13 != null) goto L12;
    L13:
        if (r13 != null) goto L16;
    L38:
        r12.i("SpringMainVenueComponent", "[executeApplyPocket] pocketId = " + r9.getPocketId() + ", pocketType = " + r9.getPocketType());     // Catch: Throwable -> L68
        Integer r0 = r9.getPocketType();     // Catch: Throwable -> L68
        if (r0 != null) goto L42;
    L48:
        if (r0 != null) goto L51;
    L56:
        if (r0 != null) goto L59;
    L61:
        if (r0 != null) goto L64;
    L66:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L68
    L70:
        SpringMainVenueLynxComponent r2 = this.this$0;
        Map<String, Object> r7 = this.$originData;
        if (Result.exceptionOrNull-impl(r1) == null) goto L84;
        int r15 = SpringMainVenueLynxComponent.P;
        zz9.d r16 = r2.Z3();
        if (r16 == null) goto L84;
        Object r17 = r7.get("pocket_id");
        if (r17 == null) goto L78;
        String r19 = r17.toString();
        if (r19 == null) goto L78;
    L79:
        Object r20 = r7.get("pocket_type");
        int r21 = -1;
        if (r20 == null) goto L82;
        r21 = l3.e(r20, -1);
    L82:
        r16.W7(r19, 0, r21, "invalid_data");
    L78:
        r19 = "";
    L84:
        return Unit.INSTANCE;
    L64:
        if (r0.intValue() != 4) goto L66;
        SpringMainVenueLynxComponent.h3(r4, r9, r3, r5);     // Catch: Throwable -> L68
        goto L66
    L59:
        if (r0.intValue() != 3) goto L61;
        SpringMainVenueLynxComponent.z3(r4, r9, r3, r5);     // Catch: Throwable -> L68
        goto L66
    L51:
        if (r0.intValue() != 2) goto L56;
        if (r6 == true) goto L55;
        r14 = false;
    L55:
        SpringMainVenueLynxComponent.m3(r4, r9, r3, r5, r14);     // Catch: Throwable -> L68
        goto L66
    L42:
        if (r0.intValue() != 1) goto L48;
        r4.C3();     // Catch: Throwable -> L68
        if (r6 == true) goto L47;
        r14 = false;
    L47:
        SpringMainVenueLynxComponent.p3(r4, r9, r3, r5, r14);     // Catch: Throwable -> L68
        goto L66
    L16:
        if (r13.intValue() != 14) goto L38;
    L17:
        Integer r110 = r9.getPocketType();     // Catch: Throwable -> L68
        if (r110 != null) goto L21;
    L22:
        Integer r111 = r9.getPocketType();     // Catch: Throwable -> L68
        if (r111 == null) goto L38;
        if (r111.intValue() != 2) goto L38;
    L27:
        DigitalAvatarInfoManager.a.getClass();     // Catch: Throwable -> L68
        if (DigitalAvatarInfoManager.g() == false) goto L32;
        if (DigitalAvatarInfoManager.j() == true) goto L32;
    L34:
        boolean r112 = false;
    L35:
        if (r112 == false) goto L38;
        r4.J = new ClickPocketInfo(r9, r3, r5, Boxing.boxBoolean(true));     // Catch: Throwable -> L68
        r12.i("SpringMainVenueComponent", "[setAvatarPendingPocketInfo] finish, avatarPendingPocketInf = " + r4.J);     // Catch: Throwable -> L68
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new SpringMainVenueLynxComponent$jumpToCreateDigitalAvatar$1(r4, null), 3, null);     // Catch: Throwable -> L68
        return Unit.INSTANCE;
    L32:
        if (DigitalAvatarInfoManager.i() == true) goto L34;
        r112 = true;
        goto L35
    L21:
        if (r110.intValue() == 1) goto L27;
    L12:
        if (r13.intValue() == 13) goto L17;
    L68:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L86:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
