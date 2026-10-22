package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 implements w {
    public final AnchorUILayoutManager a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final UILayout B5() {
        AnchorUILayoutManager r0 = this.a;
        if (r0 == null) goto L9;
        o51.e r1 = r0.e;
        if (r1 == null) goto L9;
        UILayout r2 = o51.g.c(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return UILayout.Normal;
    }

    public c0(AnchorUILayoutManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final boolean t4(String r2) {
        AnchorUILayoutManager r0 = this.a;
        if (r0 == null) goto L7;
        o51.e r1 = r0.e;
        if (r1 == null) goto L7;
        String r3 = o51.g.b(r1);
    L9:
        return Intrinsics.areEqual(r3, r2);
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final boolean x5(String r4) {
        if (t4(r4) == false) goto L15;
        AnchorUILayoutManager r5 = this.a;
        if (r5 == null) goto L16;
        o51.e r6 = r5.e;
        if (r6 == null) goto L17;
        Intrinsics.checkNotNullParameter(r6, "$this$isAllRoom");
        if (r6.c != IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom) goto L11;
        boolean r7 = true;
    L12:
        if (r7 != true) goto L18;
        return true;
    L18:
        return false;
    L11:
        r7 = false;
        goto L12
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final void A5(String r3, boolean r4) {
        AnchorUILayoutManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r3, r4, false);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.w
    public final void P4(String r3, boolean r4) {
        AnchorUILayoutManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r3, r4, true);
        return;
    }
}
