package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public s(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        com.larus.dora.impl.device.ailab.b r5 = (com.larus.dora.impl.device.ailab.b) r3;
        if ((r5 instanceof com.larus.dora.impl.device.ailab.b.C0032b) == false) goto L11;
        WeakReference<com.obric.oui.toast.f> r6 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), ((com.larus.dora.impl.device.ailab.b.C0032b) r5).a);
        DoraObricGDoubaoConversationSettingsFragment r7 = this.a;
        com.larus.dora.impl.device.ailab.u r8 = r7.n;
        if ((r8 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L7;
        com.larus.dora.impl.device.ailab.u.b r9 = (com.larus.dora.impl.device.ailab.u.b) r8;
    L8:
        if (r9 == null) goto L11;
        boolean r10 = r9.e;
        r7.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.CONVERSATION_START_END_SOUND, r10, new l(r7));
        goto L11
    L7:
        r9 = null;
    L11:
        return Unit.INSTANCE;
    }
}
