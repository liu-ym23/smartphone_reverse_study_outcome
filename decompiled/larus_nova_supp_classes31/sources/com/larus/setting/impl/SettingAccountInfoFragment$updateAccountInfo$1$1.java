package com.larus.setting.impl;

import com.larus.account.base.api.IAccountService;
import com.larus.account.base.model.SettingsAccountInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.setting.impl.databinding.LarusPageSettingAccountInfoBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.SettingAccountInfoFragment$updateAccountInfo$1$1", f = "SettingAccountInfoFragment.kt", i = {}, l = {452, 462}, m = "invokeSuspend", n = {}, s = {})
public final class SettingAccountInfoFragment$updateAccountInfo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isForceRequest;
    final /* synthetic */ LarusPageSettingAccountInfoBinding $this_run;
    int label;
    final /* synthetic */ SettingAccountInfoFragment this$0;

    public SettingAccountInfoFragment$updateAccountInfo$1$1(boolean r1, LarusPageSettingAccountInfoBinding r2, SettingAccountInfoFragment r3, Continuation<? super SettingAccountInfoFragment$updateAccountInfo$1$1> r4) {
        this.$isForceRequest = r1;
        this.$this_run = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SettingAccountInfoFragment$updateAccountInfo$1$1(this.$isForceRequest, this.$this_run, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L23:
        com.larus.network.http.a r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof com.larus.network.http.f) == false) goto L26;
        SettingAccountInfoFragment r3 = this.this$0;
        r3.l = false;
        yp9.d.b.a(r3.e, "user account info request failed");
        this.$this_run.b.setVisibility(0);
        this.this$0.aa0(false);
    L28:
        return Unit.INSTANCE;
    L26:
        this.this$0.l = true;
        this.$this_run.b.setVisibility(0);
        SettingAccountInfoFragment r4 = this.this$0;
        SettingAccountInfoFragment.V90(r4, r4.f, (SettingsAccountInfo) r2.b);
        IAccountService.a.i((SettingsAccountInfo) r2.b);
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        Object r5 = r17;
    L17:
        com.larus.network.http.y r6 = (com.larus.network.http.a) r5;
        if ((r6 instanceof com.larus.network.http.y) == false) goto L28;
        SettingAccountInfoFragment r7 = this.this$0;
        r7.l = true;
        com.larus.network.http.y r8 = r6;
        SettingAccountInfoFragment.V90(r7, r7.f, (SettingsAccountInfo) ((com.larus.network.http.a) r8).b);
        IAccountService.a.i((SettingsAccountInfo) ((com.larus.network.http.a) r8).b);
        goto L28
    L10:
        ResultKt.throwOnFailure(r17);
        IAccountService.Companion r9 = IAccountService.a;
        if (r9.w() != null) goto L13;
    L20:
        String r10 = com.larus.login.api.i0.c;
        JSONObject r11 = new JSONObject();
        this.label = 2;
        r1 = HttpExtKt.k("Basic", SettingsAccountInfo.class, r10, r11, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L23;
        return r13;
    L13:
        if (this.$isForceRequest == true) goto L20;
        this.$this_run.b.setVisibility(0);
        SettingAccountInfoFragment r12 = this.this$0;
        SettingAccountInfoFragment.V90(r12, r12.f, r9.w());
        String r14 = com.larus.login.api.i0.c;
        JSONObject r15 = new JSONObject();
        this.label = 1;
        r5 = HttpExtKt.k("Basic", SettingsAccountInfo.class, r14, r15, null, null, false, null, null, null, this, 1008);
        if (r5 != r13) goto L17;
        return r13;
    }
}
