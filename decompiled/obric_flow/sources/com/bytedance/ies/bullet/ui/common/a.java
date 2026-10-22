package com.bytedance.ies.bullet.ui.common;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsBulletContainerActivity f6197b;

    public /* synthetic */ a(AbsBulletContainerActivity r5, int r10) {
        this.f6196a = r10;
        this.f6197b = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        switch(this.f6196a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f6197b.finish();
        return;
    L6:
        this.f6197b.finish();
    }
}
