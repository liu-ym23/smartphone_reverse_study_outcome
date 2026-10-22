package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.qn;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/DiggTabCountView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggTabCountView extends FrameLayout {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public PointF e;
    public final float f;
    public final float g;
    public final HashSet<Integer> h;
    public boolean i;
    public final q4.b j;

    public static final class a {
    }

    static {
    }

    public DiggTabCountView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DiggTabCountView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public DiggTabCountView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        View r8 = LayoutInflater.from(r5).inflate(2131566784, null);
        this.a = r8;
        TextView r9 = (TextView) r8.findViewById(2131390500);
        this.b = r9;
        TextView r0 = (TextView) r8.findViewById(2131390501);
        this.c = r0;
        View r1 = r8.findViewById(2131378666);
        this.d = r1;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r8.setAlpha(0.0f);
        addView(r8, r2);
        if (((Boolean) qn.a.getValue()).booleanValue() == true) goto L9;
        ALogger.i("DiggTabCountView", "set typeface in init");
        Typeface r10 = Typeface.createFromAsset(r5.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L7
        r9.setTypeface(r10);     // Catch: Exception -> L7
        r0.setTypeface(r10);     // Catch: Exception -> L7
        ((TextView) r1.findViewById(2131390527)).setTypeface(r10);     // Catch: Exception -> L7
        ((TextView) r1.findViewById(2131390526)).setTypeface(r10);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ALogger.e("DiggTabCountView", "load font asset exception: " + e.getMessage());
    L9:
        this.f = UtilityKotlinExtentionsKt.h(16);
        this.g = UtilityKotlinExtentionsKt.h(42);
        this.h = new HashSet();
        this.j = u4.b(false, new DiggTabCountView$countAnimController$1(this));
    }

    public /* synthetic */ DiggTabCountView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
