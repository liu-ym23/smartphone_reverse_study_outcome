package com.obric.oui.view;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewPropertyAnimatorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f14815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f14816b;
    int c;

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat r1) {
            this.mVpa = r1;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r3) {
            Object r2 = r3.getTag(2113929216);
            if (ZeusTransformUtils.instanceOf(r2, ViewPropertyAnimatorListener.class) == false) goto L5;
            ViewPropertyAnimatorListener r4 = (ViewPropertyAnimatorListener) ZeusTransformUtils.preCheckCast(r2, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        L6:
            if (r4 == null) goto L9;
            r4.onAnimationCancel(r3);
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r4) {
            ViewPropertyAnimatorListener r2 = null;
            if (this.mVpa.c <= (-1)) goto L6;
            r4.setLayerType(this.mVpa.c, null);
            this.mVpa.c = -1;
        L6:
            if (Build.VERSION.SDK_INT >= 16) goto L10;
            if (this.mAnimEndCalled == false) goto L10;
            return;
        L10:
            if (this.mVpa.f14816b == null) goto L12;
            Runnable r0 = this.mVpa.f14816b;
            this.mVpa.f14816b = null;
            r0.run();
        L12:
            Object r1 = r4.getTag(2113929216);
            if (ZeusTransformUtils.instanceOf(r1, ViewPropertyAnimatorListener.class) == false) goto L15;
            r2 = (ViewPropertyAnimatorListener) ZeusTransformUtils.preCheckCast(r1, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        L15:
            if (r2 == null) goto L17;
            r2.onAnimationEnd(r4);
        L17:
            this.mAnimEndCalled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r4) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener r1 = null;
            if (this.mVpa.c <= (-1)) goto L6;
            r4.setLayerType(2, null);
        L6:
            if (this.mVpa.f14815a == null) goto L8;
            Runnable r0 = this.mVpa.f14815a;
            this.mVpa.f14815a = null;
            r0.run();
        L8:
            Object r3 = r4.getTag(2113929216);
            if (ZeusTransformUtils.instanceOf(r3, ViewPropertyAnimatorListener.class) == false) goto L11;
            r1 = (ViewPropertyAnimatorListener) ZeusTransformUtils.preCheckCast(r3, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        L11:
            if (r1 == null) goto L14;
            r1.onAnimationStart(r4);
            return;
        }
    }
}
