package com.larus.dora.obric.device_management.device_home;

import com.obric.oui.segmentedtab.OBottomNavActionBar;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j1 implements OBottomNavActionBar.c {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public j1(DoraObricDeviceHomeFragment r1) {
        this.a = r1;
    }

    public final void a(int r3) {
        DoraObricDeviceHomeFragment r0 = this.a;
        int r1 = DoraObricDeviceHomeFragment.R;
        r1 r4 = (r1) CollectionsKt.getOrNull(((DoraObricDeviceHomeViewModel.c) r0.ia0().getUiState().getValue()).m, r3);
        if (r4 == null) goto L7;
        DoraObricDeviceHomeTabPage r5 = r4.b;
        if (r5 == null) goto L7;
    L8:
        int r2 = y69.a.a;
        y69.a.b(DoraObricDeviceHomeFragment.X90(this.a, r5));
        return;
    L7:
        r5 = DoraObricDeviceHomeTabPage.DEVICE;
        goto L8
    }

    public final void onSelect(int r6) {
        DoraObricDeviceHomeFragment r0 = this.a;
        if (r0.l == false) goto L5;
        return;
    L5:
        r0.C = null;
        List<r1> r1 = ((DoraObricDeviceHomeViewModel.c) r0.ia0().getUiState().getValue()).m;
        r1 r2 = (r1) CollectionsKt.getOrNull(r1, r6);
        if (r2 == null) goto L9;
        DoraObricDeviceHomeTabPage r3 = r2.b;
        if (r3 == null) goto L9;
    L10:
        DoraObricDeviceHomeTabPage r4 = this.a.ha0();
        int r5 = y69.a.a;
        y69.a.b(DoraObricDeviceHomeFragment.X90(this.a, r3));
        if (r3 == DoraObricDeviceHomeTabPage.DIARY) goto L13;
    L16:
        this.a.j = Integer.valueOf(r6);
        this.a.B.setValue(r3);
        g49.d.d("DoraObricDeviceHomeFragment", "bottom tab selected, position=" + r6);
        this.a.ma0(r1);
        DoraObricDeviceHomeFragment.pa0(this.a, r6);
        if (r4 != r3) goto L19;
        return;
    L19:
        if (this.a.ha0() != r3) goto L23;
        this.a.getClass();
        String r7 = DoraObricDeviceHomeFragment.ba0(r3);
        this.a.getClass();
        y69.a.a(r7, DoraObricDeviceHomeFragment.ba0(r4), "click_tab");
        return;
    L23:
        return;
    L13:
        if (this.a.ia0().onDiaryEntryRequested() == true) goto L16;
        this.a.ma0(r1);
        return;
    L9:
        r3 = DoraObricDeviceHomeTabPage.DEVICE;
        goto L10
    }
}
