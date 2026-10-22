package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment a;

    public u(DoraObricGDoubaoConversationSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        com.larus.dora.impl.device.settings.lab.c r6 = (com.larus.dora.impl.device.settings.lab.c) r4;
        DoraObricGDoubaoConversationSettingsFragment r7 = this.a;
        r7.o = r6;
        boolean r8 = r7.ka0();
        DoraObricGDoubaoConversationSettingsFragment r0 = this.a;
        if (r8 == r0.t) goto L5;
    L6:
        this.a.ja0();
    L8:
        if ((r6 instanceof com.larus.dora.impl.device.settings.lab.c.b) == false) goto L33;
        d59.f r9 = this.a.fa0().getFeatureConfig();
        if (r9 == null) goto L12;
        Map<String, d59.i> r10 = r9.a();
    L13:
        com.larus.dora.impl.device.settings.lab.c.b r11 = (com.larus.dora.impl.device.settings.lab.c.b) r6;
        boolean r1 = false;
        if (r11.f == true) goto L16;
    L23:
        DoraObricGDoubaoConversationSettingsFragment r12 = this.a;
        if (r12.q == r1) goto L26;
        r12.q = r1;
        r12.ja0();
    L26:
        DoraObricGDoubaoConversationSettingsFragment r13 = this.a;
        r13.getClass();
        r13.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.ALLOW_DOUBAO_VIEW_IMAGES, r11.j, new k(r13));
        r13.aa0(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.NATURAL_WAKEUP, r11.g, new p(r13));
        r13.Z90(r11);
        Map<DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem, OCardListItem> r14 = r13.m;
        LinkedHashMap r15 = (LinkedHashMap) r14;
        OCardListItem r16 = (OCardListItem) r15.get(DoraObricGDoubaoConversationSettingsFragment.DoubaoConversationSettingItem.DATA_SAVING);
        if (r16 == null) goto L31;
        OSwitch r17 = r16.getEndSwitch();
        if (r17 == null) goto L31;
        r17.setChecked(r11.v);
    L31:
        this.a.ha0().refreshAutoStopTime();
        goto L33
    L16:
        if (r10 != null) goto L18;
    L20:
        boolean r18 = false;
    L21:
        if (r18 == false) goto L23;
        r1 = true;
        goto L23
    L18:
        if (r10.containsKey("fuzzy_wakeup") != true) goto L20;
        r18 = true;
        goto L21
    L12:
        r10 = null;
    L33:
        return Unit.INSTANCE;
    L5:
        if (r0.fa0().isDataSavingEntranceVisible() == this.a.s) goto L8;
        goto L6
    }
}
