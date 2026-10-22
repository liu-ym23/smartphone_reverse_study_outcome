package com.bytedance.android.livesdk.dslservice.lynxair.view;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.ecom.arch.slice.render.elements.g;
import com.bytedance.android.live.core.log.ALogger;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements f<b> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dslservice.lynxair.view.a$a, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC0302a implements ViewTreeObserver.OnGlobalLayoutListener {
        public int a;
        public final /* synthetic */ b b;
        public final /* synthetic */ yt1.b c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r0 = this.b.getWidth();
            int r1 = this.c.b();
            yt1.b r6 = null;
            int r4 = 0;
            int r5 = 0;
        L3:
            if (r4 >= r1) goto L27;
            yt1.b r7 = this.c.a(r4);
            if ((r7 instanceof yt1.b) == true) goto L7;
            r7 = null;
        L7:
            if (r7 == null) goto L26;
            r5 = (r5 + r7.f()) + (r7.c() + r7.d());
            if (r5 <= r0) goto L20;
            r7.g();
            if (r6 == null) goto L14;
            r6.g();
        L14:
            this.b.getAutoGoneViewSet().add(new WeakReference(r7.a));
            if (r6 == null) goto L19;
            LynxBaseUI r8 = (LynxBaseUI) r6.a;
            if (r8 == null) goto L19;
            this.b.getAutoGoneViewSet().add(new WeakReference(r8));
        L19:
            ALogger.i("PdpFlexWidthViewManager", "remove view.");
        L20:
            int r9 = com.bytedance.android.livesdk.dsl.util.c.a;
            Object r10 = r7.e();
            if (r10 == null) goto L23;
            boolean r11 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r10);
        L24:
            if (r11 == false) goto L26;
            r6 = r7;
            goto L26
        L23:
            r11 = false;
        L26:
            r4 = r4 + 1;
            goto L3
        L27:
            int r2 = this.a;
            this.a = r2 + 1;
            if (r2 <= 6) goto L30;
        L38:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L35
            this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);     // Catch: Throwable -> L35
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
            return;
        L35:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L30:
            if (this.b.getChildCount() != this.c.b()) goto L44;
            if (r0 <= 0) goto L45;
            if (r5 > 0) goto L38;
            return;
        L45:
            return;
        }

        public ViewTreeObserverOnGlobalLayoutListenerC0302a(b r1, yt1.b r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public a() {
    }

    @Override // yt1.f
    public int getType() {
        return 3;
    }

    @Override // yt1.f
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new b(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup, com.bytedance.android.livesdk.dslservice.lynxair.view.b] */
    @Override // yt1.f
    public final <D> void a(yt1.b<D, b> r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "viewDelegate");
        Intrinsics.checkNotNullParameter(r4, "props");
        boolean r5 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r4.get("default_hide"));
        ?? r0 = (b) r3.b;
        if (r0 == 0) goto L5;
        r0.reset();
    L5:
        if (r0 == 0) goto L9;
        if (r5 == false) goto L10;
        r0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0302a(r0, r3));
        return;
    L10:
        return;
    }

    @Override // yt1.f
    public final void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r1, g r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
    }
}
