package com.larus.slides.impl;

import androidx.fragment.app.Fragment;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x implements ax9.d {
    public final /* synthetic */ SlidesFragment a;

    public x(SlidesFragment r1) {
        this.a = r1;
    }

    @Override // ax9.d
    public final void P(boolean r4) {
        FLogger.a.i("SlidesFragment", "refSelectStateChange, isRefSelect:" + r4);
        SlidesFragment r0 = this.a;
        int r1 = SlidesFragment.O;
        Fragment r2 = ((OfficeBaseFragment) r0).f;
        if (r2 == null) goto L10;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L11;
        va8.k0 r5 = r3.getAbility(va8.k0.class);
        if (r5 == null) goto L12;
        r5.P(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ax9.d
    public final void Q(String r8) {
        SlidesFragment r1 = this.a;
        int r2 = SlidesFragment.O;
        Fragment r3 = ((OfficeBaseFragment) r1).f;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
        return;
    L10:
        if (com.larus.utils.o0.d(r8) == true) goto L54;
        Fragment r9 = ((OfficeBaseFragment) this.a).f;
        if (r9 == null) goto L50;
        t1a.b r10 = s1a.a.g(r9);
        if (r10 == null) goto L50;
        com.larus.bmhome.chat.component.bottom.reference.a r11 = r10.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);
        if (r11 == null) goto L50;
        r11.NR();
    L50:
        ym9.c r12 = com.larus.office.base.service.m.a("default_doc_logic_key");
        if (r12 == null) goto L56;
        r12.onEditPanelHeightChanged(200);
        return;
    L56:
        return;
    L54:
        JSONObject r5 = new JSONObject(r8);     // Catch: Exception -> L41
        String r6 = r5.optString("text");     // Catch: Exception -> L41
        if (com.larus.utils.o0.d(r6) == false) goto L20;
        Fragment r7 = ((OfficeBaseFragment) this.a).f;     // Catch: Exception -> L41
        if (r7 == null) goto L27;
        t1a.b r13 = s1a.a.g(r7);     // Catch: Exception -> L41
        if (r13 == null) goto L27;
        com.larus.bmhome.chat.component.bottom.reference.a r14 = r13.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);     // Catch: Exception -> L41
        if (r14 == null) goto L27;
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L41
        r14.Dk(r6);     // Catch: Exception -> L41
    L27:
        Fragment r15 = ((OfficeBaseFragment) this.a).f;     // Catch: Exception -> L41
        if (r15 == null) goto L35;
        t1a.b r16 = s1a.a.g(r15);     // Catch: Exception -> L41
        if (r16 == null) goto L35;
        va8.k0 r17 = r16.getAbility(va8.k0.class);     // Catch: Exception -> L41
        if (r17 == null) goto L35;
        r17.a6(r8);     // Catch: Exception -> L41
    L35:
        if (Intrinsics.areEqual(r5.optString("type"), "text") == false) goto L37;
        SlidesFragment.ka0(this.a, false, "onSelectionChanged:text");     // Catch: Exception -> L41
        goto L50
    L37:
        SlidesFragment r18 = this.a;     // Catch: Exception -> L41
        if (r18.i == true) goto L50;
        SlidesFragment.ka0(r18, !r18.E, "onSelectionChanged");     // Catch: Exception -> L41
        goto L50
    L20:
        Fragment r19 = ((OfficeBaseFragment) this.a).f;     // Catch: Exception -> L41
        if (r19 == null) goto L27;
        t1a.b r20 = s1a.a.g(r19);     // Catch: Exception -> L41
        if (r20 == null) goto L27;
        com.larus.bmhome.chat.component.bottom.reference.a r21 = r20.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);     // Catch: Exception -> L41
        if (r21 == null) goto L27;
        r21.NR();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        FLogger.a.e("SlidesFragment", "Parse selection data error: " + e.getMessage());
        goto L50
    L5:
        if (r3.isAdded() != true) goto L7;
        r4 = true;
        goto L8
    }
}
