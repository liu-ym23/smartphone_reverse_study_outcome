package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.conversation_settings.DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1", f = "DoraObricGDoubaoConversationSettingsFragment.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;
    final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment this$0;

    public DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1(boolean r1, DoraObricGDoubaoConversationSettingsFragment r2, Continuation<? super DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1> r3) {
        this.$isChecked = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1(this.$isChecked, this.this$0, r4);
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
        int r8 = ((Number) r7).intValue();
        t39.c r2 = j49.b.a;
        boolean r3 = this.$isChecked;
        Intrinsics.checkNotNullParameter("voice_wakeup", "action");
        j49.b.i("voice_wakeup", r3, j49.b.k(r8));
        if (r8 == 0) goto L17;
        WeakReference<com.obric.oui.toast.f> r9 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.this$0.requireContext(), 2131904037);
        final DoraObricGDoubaoConversationSettingsFragment r10 = this.this$0;
        com.larus.dora.impl.device.ailab.u r4 = r10.n;
        if ((r4 instanceof com.larus.dora.impl.device.ailab.u.a) == false) goto L16;
        r10.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.VOICE_WAKE, !this.$isChecked, new x(r10));
    L23:
        return Unit.INSTANCE;
    L16:
        r10.ba0(r4);
        goto L23
    L17:
        DoraSystemInfoManager r11 = DoraSystemInfoManager.a;
        if (this.$isChecked == false) goto L20;
        String r12 = "1";
    L21:
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("doubao_voice_wakeup", r12)));
        goto L23
    L20:
        r12 = "0";
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1 r5 = new DoraObricGDoubaoConversationSettingsFragment$updateVoiceWake$1$ret$1(this.this$0, this.$isChecked, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r13, r5, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
