package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public v(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        com.larus.dora.impl.device.settings.lab.b r5 = (com.larus.dora.impl.device.settings.lab.b) r3;
        com.larus.dora.impl.device.settings.lab.c.b r0 = null;
        if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.c) == false) goto L10;
        WeakReference<com.obric.oui.toast.f> r6 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), ((com.larus.dora.impl.device.settings.lab.b.c) r5).a);
        DoraObricGDoubaoConversationSettingsFragment r7 = this.a;
        com.larus.dora.impl.device.settings.lab.c r8 = r7.o;
        if ((r8 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L7;
        r0 = (com.larus.dora.impl.device.settings.lab.c.b) r8;
    L7:
        if (r0 == null) goto L20;
        r7.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.NATURAL_WAKEUP, r0.g, new p(r7));
    L20:
        return Unit.INSTANCE;
    L10:
        if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.a) == false) goto L17;
        WeakReference<com.obric.oui.toast.f> r9 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), ((com.larus.dora.impl.device.settings.lab.b.a) r5).a);
        DoraObricGDoubaoConversationSettingsFragment r10 = this.a;
        com.larus.dora.impl.device.settings.lab.c r11 = r10.o;
        if ((r11 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L14;
        r0 = (com.larus.dora.impl.device.settings.lab.c.b) r11;
    L14:
        if (r0 == null) goto L20;
        r10.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES, r0.j, new k(r10));
        goto L20
    L17:
        if ((r5 instanceof com.larus.dora.impl.device.settings.lab.b.d) == false) goto L20;
        WeakReference<com.obric.oui.toast.f> r12 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), ((com.larus.dora.impl.device.settings.lab.b.d) r5).a);
        goto L20
    }
}
