package com.bytedance.android.anniex.container.popup;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f3170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tc.a f3171c;

    public /* synthetic */ a(tc.a r5, Uri r10, int r11) {
        this.f3169a = r11;
        this.f3171c = r5;
        this.f3170b = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        switch(this.f3169a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        switch(this.f3169a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        switch(this.f3169a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        switch(this.f3169a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (((md.b) this.f3171c).f20063c == false) goto L20;
        md.c r10 = ((md.b) this.f3171c).d;
        if (r10 == null) goto L11;
        md.b r11 = (md.b) this.f3171c;
        Uri r12 = this.f3170b;
        r10.a(r5);
        ug.d r13 = r11.e;
        if (r13 == null) goto L11;
        md.b.d(r5, r12, r13, r10);
    L11:
        ((md.b) this.f3171c).f20063c = false;
        ((md.b) this.f3171c).d = null;
        ((md.b) this.f3171c).e = null;
        return;
    L20:
        return;
    L13:
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (((f) this.f3171c).f3178c == false) goto L21;
        ug.d r14 = ((f) this.f3171c).d;
        if (r14 == null) goto L18;
        ((f) this.f3171c).d(r5, this.f3170b, r14);
    L18:
        ((f) this.f3171c).f3178c = false;
        ((f) this.f3171c).d = null;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        switch(this.f3169a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        switch(this.f3169a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
        switch(this.f3169a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "activity");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "activity");
    }
}
