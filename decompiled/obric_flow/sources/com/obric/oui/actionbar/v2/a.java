package com.obric.oui.actionbar.v2;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11931a;

    public /* synthetic */ a(int r5) {
        this.f11931a = r5;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r5, Outline r10) {
        switch(this.f11931a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "outline");
        r10.setRect(new Rect(0, r5.getHeight() / 2, r5.getWidth(), r5.getHeight()));
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "outline");
        r10.setRect(new Rect(0, r5.getHeight() / 2, r5.getWidth(), r5.getHeight()));
    }
}
