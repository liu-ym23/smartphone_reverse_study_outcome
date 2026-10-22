package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/TrayWaveControllerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrayWaveControllerView extends FrameLayout {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public List<AnimatorSet> a;
    public List<p> b;

    public static final class a {
    }

    public TrayWaveControllerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TrayWaveControllerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        c = s1.f(99.0f);
        d = s1.f(79.0f);
        e = s1.f(79.0f);
        f = s1.f(63.0f);
        g = s1.f(59.0f);
        h = s1.f(47.0f);
    }

    public final void a() {
        List<p> r0 = this.b;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((p) r1.next()).b();
    L8:
        List<AnimatorSet> r2 = this.a;
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L18;
        AnimatorSet r4 = (AnimatorSet) r3.next();
        if (r4 == null) goto L16;
        r4.removeAllListeners();
    L16:
        if (r4 == null) goto L12;
        r4.cancel();
    L18:
        List<p> r5 = this.b;
        if (r5 == null) goto L21;
        r5.clear();
    L21:
        List<AnimatorSet> r6 = this.a;
        if (r6 == null) goto L24;
        r6.clear();
    L24:
        this.b = null;
        this.a = null;
        removeAllViews();
    }

    public TrayWaveControllerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ TrayWaveControllerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
