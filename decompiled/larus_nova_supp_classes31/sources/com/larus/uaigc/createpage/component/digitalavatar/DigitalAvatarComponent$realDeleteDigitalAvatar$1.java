package com.larus.uaigc.createpage.component.digitalavatar;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.b0;
import com.larus.uaigc.avatar.api.DigitalAvatarApi;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$realDeleteDigitalAvatar$1", f = "DigitalAvatarComponent.kt", i = {}, l = {628}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarComponent$realDeleteDigitalAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $digitalAvatarId;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public DigitalAvatarComponent$realDeleteDigitalAvatar$1(DigitalAvatarComponent r1, String r2, Continuation<? super DigitalAvatarComponent$realDeleteDigitalAvatar$1> r3) {
        this.this$0 = r1;
        this.$digitalAvatarId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DigitalAvatarComponent$realDeleteDigitalAvatar$1(this.this$0, this.$digitalAvatarId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        dm9.a.b r8 = (dm9.a) r7;
        if ((r8 instanceof dm9.a.b) == false) goto L20;
        FLogger.a.i("DigitalAvatarComponent", "delete digital avatar success");
        if (r8.a.getCode() != 710019209) goto L16;
        t19.s r9 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r9.getClass();
        t19.s.b(r2, 2131908804, false);
    L23:
        return Unit.INSTANCE;
    L16:
        t19.s r10 = t19.s.a;
        Context r3 = this.this$0.getContext();
        r10.getClass();
        t19.s.o(r3, 2131907685, false);
        this.this$0.m.setValue(Boxing.boxBoolean(false));
        this.this$0.o.setValue(null);
        DigitalAvatarInfoManager.a.getClass();
        DigitalAvatarInfoManager.h = Boolean.FALSE;
        DigitalAvatarInfoManager.i = null;
        DigitalAvatarInfoManager.j.setValue(null);
        DigitalAvatarInfoManager.k();
        e1.o(this.this$0.F2().findViewById(2131388772).getBinding().f);
        b0 r11 = (b0) this.this$0.v.getValue();
        if (r11 == null) goto L23;
        r11.a();
        goto L23
    L20:
        if ((r8 instanceof dm9.a.a) == false) goto L25;
        FLogger.a.i("DigitalAvatarComponent", "delete digital avatar fail errorInfo is " + ((dm9.a.a) r8).c);
        t19.s r12 = t19.s.a;
        Context r4 = this.this$0.getContext();
        r12.getClass();
        t19.s.b(r4, 2131900187, false);
        goto L23
    L25:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DigitalAvatarApi.a r13 = DigitalAvatarApi.a;
        DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1 r5 = new DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1(this.$digitalAvatarId, null);
        this.label = 1;
        r13.getClass();
        r7 = DigitalAvatarApi.a.a("/alice/profile/avatar/delete", r5, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
