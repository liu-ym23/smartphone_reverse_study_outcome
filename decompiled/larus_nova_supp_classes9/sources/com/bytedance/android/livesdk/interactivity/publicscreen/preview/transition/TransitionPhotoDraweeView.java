package com.bytedance.android.livesdk.interactivity.publicscreen.preview.transition;

import android.content.Context;
import android.util.AttributeSet;
import ba2.e;
import ba2.f;
import ca2.a;
import ca2.b;
import ca2.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.PhotoDraweeView;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0002B'\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/transition/TransitionPhotoDraweeView;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/PhotoDraweeView;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isDragTransitionEnabled", "()Z", "setDragTransitionEnabled", "(Z)V", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", BuildConfig.FLAVOR, "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "transitionAnimationDuration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionPhotoDraweeView extends PhotoDraweeView {
    public final LinkedHashSet<a> n;
    public final c o;

    public TransitionPhotoDraweeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TransitionPhotoDraweeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public long getTransitionAnimationDuration() {
        return this.o.E;
    }

    public void setDragTransitionEnabled(boolean r2) {
        this.o.F = r2;
    }

    public void setSingleTagDismissEnabled(boolean r2) {
        this.o.G = r2;
    }

    public void setTransitionAnimationDuration(long r2) {
        this.o.E = r2;
    }

    public TransitionPhotoDraweeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        c r0 = new c(new e(), r3);
        super(r3, r4, r5);
        this.o = r0;
        this.n = new LinkedHashSet();
        b r6 = new b(this);
        Intrinsics.checkNotNullParameter(r6, "listener");
        r0.w.add(r6);
        setZoomableControllerImp(r0);
        setGestureHandler(new f(r0));
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
