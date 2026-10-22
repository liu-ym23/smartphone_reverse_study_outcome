package com.larus.dora.obric.device_management.setting.earbuds.doubao_agent;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.impl.device.ailab.AiLabViewModel;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.doubao_agent.DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1", f = "DoraObricEarbudsDoubaoAgentSettingsFragment.kt", i = {}, l = {467, 473}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;
    final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.doubao_agent.DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.doubao_agent.DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1$1", f = "DoraObricEarbudsDoubaoAgentSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        final /* synthetic */ int $ret;
        int label;
        final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment this$0;

        public AnonymousClass1(int r1, DoraObricEarbudsDoubaoAgentSettingsFragment r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.$ret = r1;
            this.this$0 = r2;
            this.$isChecked = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$ret, this.this$0, this.$isChecked, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r5);
            boolean r0 = false;
            if (this.$ret == 0) goto L13;
            FragmentActivity r6 = this.this$0.getActivity();
            if (r6 == null) goto L9;
            DoraObricEarbudsDoubaoAgentSettingsFragment r2 = this.this$0;
            Handler r3 = com.obric.oui.toast.f.n;
            com.obric.oui.toast.f.a.a(r6, r2.getString(2131904037));
        L9:
            DoraObricEarbudsDoubaoAgentSettingsFragment r7 = this.this$0;
            boolean r4 = !this.$isChecked;
            int r8 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
            r7.i = true;
            OSwitch r1 = r7.o;
            if (r1 == null) goto L12;
            r1.setChecked(r4);
        L12:
            r7.i = false;
        L26:
            return Unit.INSTANCE;
        L13:
            DoraObricEarbudsDoubaoAgentSettingsFragment r9 = this.this$0;
            int r10 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
            com.larus.dora.impl.device.ailab.a r11 = (com.larus.dora.impl.device.ailab.a) r9.fa0().getAbilityStateFlow().getValue();
            if (r11 != null) goto L16;
        L18:
            if (r0 == false) goto L21;
            this.this$0.W90();
        L21:
            if (this.$isChecked == false) goto L23;
            String r12 = "1";
        L24:
            DoraSystemInfoManager r13 = DoraSystemInfoManager.a;
            DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("doubao_voice_wakeup", r12)));
            goto L26
        L23:
            r12 = "0";
            goto L24
        L16:
            if (r11.a != true) goto L18;
            r0 = true;
            goto L18
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1(DoraObricEarbudsDoubaoAgentSettingsFragment r1, boolean r2, Continuation<? super DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1> r3) {
        this.this$0 = r1;
        this.$isChecked = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricEarbudsDoubaoAgentSettingsFragment$onVoiceWakeSwitchChanged$1(this.this$0, this.$isChecked, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        int r9 = ((Number) r8).intValue();
        t39.c r2 = j49.b.a;
        boolean r3 = this.$isChecked;
        Intrinsics.checkNotNullParameter("voice_wakeup", "action");
        j49.b.i("voice_wakeup", r3, j49.b.k(r9));
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass1 r5 = new AnonymousClass1(r9, this.this$0, this.$isChecked, null);
        this.label = 2;
        if (BuildersKt.withContext(r4, r5, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        DoraObricEarbudsDoubaoAgentSettingsFragment r10 = this.this$0;
        int r6 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
        AiLabViewModel r11 = r10.fa0();
        boolean r7 = this.$isChecked;
        this.label = 1;
        r8 = r11.setVoiceWakeEnable(r7, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
