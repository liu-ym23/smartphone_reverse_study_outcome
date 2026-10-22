package com.bytedance.ies.bullet.service.preload;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Size;
import android.widget.LinearLayout;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.utils.j;
import com.obric.oui.dialog.base.g;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheetModal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6110b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f6109a = r10;
        this.f6110b = r5;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        switch(this.f6109a) {
            case 0: goto L21;
            case 1: goto L17;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        OSheetModal r10 = (OSheetModal) this.f6110b;
        r10.getClass();
        com.obric.oui.sheet.v2.d.h(r10);
        r10.getScaffoldController().b(r10.getFullWindowSize());
        r10.getClass();
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        com.obric.oui.sheet.v2.b r11 = (com.obric.oui.sheet.v2.b) this.f6110b;
        com.obric.oui.sheet.v2.d.h(r11);
        r11.getScaffoldController().b(r11.f14496q);
        b0 r12 = r11.s;
        if (r12 == null) goto L24;
        Intrinsics.checkNotNullParameter(r11, "dialog");
        Intrinsics.checkNotNullParameter(r5, "configuration");
        int r13 = r5.screenHeightDp;
        LinearLayout r14 = (LinearLayout) r12.d;
        Size r15 = j.n(r14.getContext());
        com.obric.oui.privacy.b r16 = (com.obric.oui.privacy.b) r12.f7247c;
        r16.getClass();
        com.obric.oui.privacy.b.a(r13, r14, r15, r12.f7246b);
        PrivacyTopDownAlphaMaskRecyclerView r17 = r16.d;
        if (r17 != null) goto L13;
        return;
    L13:
        if (r5.screenHeightDp <= 650) goto L15;
        r17.setPadding(0, com.lynx.tasm.utils.a.B(16, r17), 0, com.lynx.tasm.utils.a.B(16, r17));
        return;
    L15:
        r17.setPadding(0, 0, 0, 0);
        return;
    L24:
        return;
    L17:
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        com.obric.oui.dialog.base.j r18 = (com.obric.oui.dialog.base.j) this.f6110b;
        if (r18.f13136o == false) goto L26;
        r18.getDialogRootView().post(new g(r18, 1));
        r18.requestApplyInsets();
        return;
    L26:
        return;
    L21:
        Intrinsics.checkNotNullParameter(r5, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        switch(this.f6109a) {
            case 0: goto L5;
            case 1: goto L4;
            case 2: goto L4;
            default: goto L4;
        };
    L4:
        return;
    L5:
        ((b) this.f6110b).e.clear();
    }
}
