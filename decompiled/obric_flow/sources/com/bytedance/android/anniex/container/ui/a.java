package com.bytedance.android.anniex.container.ui;

import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.container.m;
import s3.d;
import s3.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f3194b;

    public /* synthetic */ a(Fragment r5, int r10) {
        this.f3193a = r10;
        this.f3194b = r5;
    }

    @Override // s3.f
    public final void a() {
        switch(this.f3193a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((AnnieXFragment) this.f3194b).requireActivity().finish();
        return;
    L6:
        ((AnnieXDialog) this.f3194b).dismiss();
    }

    @Override // s3.f
    public final void b() {
        switch(this.f3193a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        d r5 = ((AnnieXFragment) this.f3194b).f3185c;
        if (r5 == null) goto L12;
        k5.d.h(r5);
        return;
    L12:
        return;
    L8:
        m r10 = ((AnnieXDialog) this.f3194b).f3180a;
        if (r10 == null) goto L13;
        k5.d.h(r10);
        return;
    }
}
