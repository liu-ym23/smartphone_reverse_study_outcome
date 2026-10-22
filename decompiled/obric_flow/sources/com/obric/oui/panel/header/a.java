package com.obric.oui.panel.header;

import android.view.View;
import com.lynx.tasm.utils.d;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import um.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14004c;

    public a(e r5, String r10) {
        this.f14002a = 1;
        this.f14003b = new WeakReference(r5);
        this.f14004c = r10;
    }

    private final void a(View r5) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        switch(this.f14002a) {
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r5, "view");
        ((View) this.f14003b).removeOnAttachStateChangeListener(this);
        int r10 = com.lynx.tasm.utils.a.B(44, r5);
        b r11 = (b) this.f14004c;
        d.p(r11.f14008h, r10, r10, new View[]{r11.e, r11.d});
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
        switch(this.f14002a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        e r10 = (e) ((WeakReference) this.f14003b).get();
        if (r10 == null) goto L10;
        e.c(r10, (String) this.f14004c);
        return;
    L10:
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "view");
    }

    public a(View r5, b r10) {
        this.f14002a = 0;
        this.f14003b = r5;
        this.f14004c = r10;
    }
}
