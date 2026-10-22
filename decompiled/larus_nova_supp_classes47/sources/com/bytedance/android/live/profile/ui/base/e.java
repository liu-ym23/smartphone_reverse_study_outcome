package com.bytedance.android.live.profile.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements d {
    public final View a;
    public final View b;
    public final View c;
    public final ViewGroup d;

    @Override // com.bytedance.android.live.profile.ui.base.d
    public Context getContext() {
        return this.d.getContext();
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void removeAllViews() {
        this.d.removeAllViews();
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final <T extends View> T a(int r2) {
        return (T) this.d.findViewById(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void c(int r2) {
        a1.k(this.d, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final boolean d(int r2) {
        View r0 = this.b;
        if (r0 != null) goto L6;
        return false;
    L6:
        a1.k(r0, r2);
        return true;
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.d.addView(r3, -1, -1);
    }

    public final void g(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.d.addView(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void removeView(View r2) {
        this.d.removeView(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        this.d.addView(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final View b(ProfilePreInflateViewInfo r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "viewInfo");
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        Lazy r1 = ProfilePreInflateUtil.a;
        return ProfilePreInflateUtil.c(r4, r0, LayoutInflater.from(r0), this.d, r5);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final View f(int r3, boolean r4) {
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return LayoutInflater.from(r0).inflate(r3, this.d, r4);
    }

    public e(View r3, ViewGroup r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        this.c = r3;
        this.d = r4;
        int r6 = -1;
        View r0 = null;
        if (r3 == null) goto L8;
        if (r5 == null) goto L6;
        int r1 = r5.c;
    L7:
        View r2 = r3.findViewById(r1);
    L9:
        this.a = r2;
        if (r3 == null) goto L14;
        if (r5 == null) goto L13;
        r6 = r5.b;
    L13:
        r0 = r3.findViewById(r6);
    L14:
        this.b = r0;
        return;
    L6:
        r1 = -1;
        goto L7
    L8:
        r2 = null;
        goto L9
    }
}
