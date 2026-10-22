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
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/CustomDiggTabCountView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "setBitmapSize", "setShowOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomDiggTabCountView extends FrameLayout {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public PointF e;
    public float f;
    public float g;
    public final HashSet<Integer> h;
    public final q4.b i;

    public static final class a {
    }

    static {
    }

    public CustomDiggTabCountView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomDiggTabCountView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setBitmapSize(float r1) {
        this.f = r1;
    }

    public final void setShowOffset(float r1) {
        this.g = r1;
    }

    public CustomDiggTabCountView(Context r5, AttributeSet r6, int r7) {
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
        Typeface r10 = Typeface.createFromAsset(r5.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L5
        r9.setTypeface(r10);     // Catch: Exception -> L5
        r0.setTypeface(r10);     // Catch: Exception -> L5
        ((TextView) r1.findViewById(2131390527)).setTypeface(r10);     // Catch: Exception -> L5
        ((TextView) r1.findViewById(2131390526)).setTypeface(r10);     // Catch: Exception -> L5
    L7:
        this.f = UtilityKotlinExtentionsKt.h(42);
        this.g = UtilityKotlinExtentionsKt.h(16);
        this.h = new HashSet();
        this.i = u4.b(false, new CustomDiggTabCountView$countAnimController$1(this));
        return;
    L5:
        e = move-exception;
        ALogger.e("DiggTabCountView", "load font asset exception: " + e.getMessage());
        goto L7
    }

    public /* synthetic */ CustomDiggTabCountView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
