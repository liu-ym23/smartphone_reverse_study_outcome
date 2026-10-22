package com.bytedance.android.livesdk.interactivity;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.publicscreen.AbsPublicScreenBottomWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends AbsExternalWidget {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final AbsPublicScreenBottomWidget e;
    public final long f;
    public final long g;

    public final View getView() {
        return this.e.getView();
    }

    public final void onLoad() {
        if (this.b == false) goto L5;
        return;
    L5:
        int r0 = t.a;
        ALogger.i("PSBottomWidget", this.e.getBusinessName() + " onLoad");
        this.e.onLoad();
        this.b = true;
    }

    public final void onUnload() {
        if (this.d == false) goto L5;
        return;
    L5:
        int r0 = t.a;
        ALogger.i("PSBottomWidget", this.e.getBusinessName() + " onUnload");
        this.e.onUnload();
        this.d = true;
    }

    public final void onViewDetached() {
        if (this.c == false) goto L5;
        return;
    L5:
        int r0 = t.a;
        ALogger.i("PSBottomWidget", this.e.getBusinessName() + " onViewDetached");
        this.e.onViewDetached();
        this.c = true;
    }

    public final void onViewWillDetach() {
        if (this.c == false) goto L5;
        return;
    L5:
        int r0 = t.a;
        ALogger.i("PSBottomWidget", this.e.getBusinessName() + " onViewWillDetach");
        this.e.onViewWillDetach();
    }

    public final void onViewAttached(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "viewContainerLayoutParam");
        int r0 = t.a;
        ALogger.i("PSBottomWidget", this.e.getBusinessName() + " onViewAttached,current container height:" + r3.getHeight() + ",width:" + r3.getWidth());
        this.e.onViewAttached(r3);
    }

    public final void onViewWillAttach(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "viewContainerLayoutParam");
        int r0 = t.a;
        ALogger.i("PSBottomWidget", this.e.getBusinessName() + " onViewWillAttach");
        this.e.onViewWillAttach(r3);
    }

    public v(AbsPublicScreenBottomWidget r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.e = r2;
        this.f = r3;
        this.g = r5;
    }
}
