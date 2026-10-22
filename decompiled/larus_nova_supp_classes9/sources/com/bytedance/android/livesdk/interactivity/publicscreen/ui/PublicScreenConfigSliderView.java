package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\n\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/PublicScreenConfigSliderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/PublicScreenConfigSliderView$a;", "callback", BuildConfig.FLAVOR, "setCallback", "Lla2/a;", "setDisableSettingCallback", BuildConfig.FLAVOR, "value", "a", "Z", "getDisable", "()Z", "setDisable", "(Z)V", "disable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenConfigSliderView extends FrameLayout {
    public static final int l = 0;
    public static final int m = 0;
    public boolean a;
    public final ViewGroup b;
    public final TextView c;
    public a d;
    public la2.a e;
    public int f;
    public final float[] g;
    public final String[] h;
    public boolean i;
    public float j;
    public float k;

    public interface a {
        void a(int r1);

        void b(float r1);
    }

    public static final class b {
    }

    public PublicScreenConfigSliderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PublicScreenConfigSliderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        int r0 = UtilityKotlinExtentionsKt.i(28);
        l = UtilityKotlinExtentionsKt.i(153);
        m = r0;
    }

    public final int a() {
        int r2 = 0;
        float r0 = Math.abs(this.b.getY() - this.g[0]);
        int r1 = 1;
    L4:
        if (r1 > 2) goto L9;
        float r3 = Math.abs(this.b.getY() - this.g[r1]);
        if (r3 >= r0) goto L8;
        r2 = r1;
        r0 = r3;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r2;
    }

    public final boolean getDisable() {
        return this.a;
    }

    public final void setCallback(a r1) {
        this.d = r1;
    }

    public final void setDisable(boolean r1) {
        this.a = r1;
        if (r1 == false) goto L5;
        float r2 = 0.5f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 1.0f;
        goto L6
    }

    public final void setDisableSettingCallback(la2.a r1) {
        this.e = r1;
    }

    public final void b(int r3, boolean r4) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (2 < r3) goto L13;
        float r0 = this.g[r3];
        if (r4 == false) goto L9;
        u4.c(new PublicScreenConfigSliderView$setPos$1(this, r3, r0)).c();
        return;
    L9:
        this.f = r3;
        this.c.setText(this.h[r3]);
        this.b.setY(r0);
        return;
    }

    public PublicScreenConfigSliderView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        this.f = -1;
        this.g = new float[3];
        String[] r0 = new String[3];
        int r2 = 0;
    L3:
        String r3 = BuildConfig.FLAVOR;
        if (r2 >= 3) goto L6;
        r0[r2] = BuildConfig.FLAVOR;
        r2 = r2 + 1;
        goto L3
    L6:
        this.h = r0;
        LayoutInflater.from(r13).inflate(2131567236, this, true);
        setClipChildren(false);
        ViewGroup r4 = (ViewGroup) findViewById(2131386027);
        this.b = r4;
        this.c = (TextView) findViewById(2131386028);
        TextView r5 = (TextView) findViewById(2131391638);
        TextView r6 = (TextView) findViewById(2131390953);
        TextView r7 = (TextView) findViewById(2131390237);
        float[] r8 = this.g;
        r8[2] = 0.0f;
        float r10 = l - m;
        r8[1] = r10 / 2;
        r8[0] = r10;
        TypedArray r16 = r13.obtainStyledAttributes(r14, new int[]{2130969058, 2130972755, 2130974629});
        String r17 = r16.getString(0);
        if (r17 != null) goto L9;
        r17 = BuildConfig.FLAVOR;
    L9:
        r0[0] = r17;
        String r18 = r16.getString(1);
        if (r18 != null) goto L12;
        r18 = BuildConfig.FLAVOR;
    L12:
        r0[1] = r18;
        String r19 = r16.getString(2);
        if (r19 == null) goto L16;
        r3 = r19;
    L16:
        r0[2] = r3;
        r7.setText(r0[0]);
        r6.setText(r0[1]);
        r5.setText(r0[2]);
        r5.setOnClickListener(new m(this));
        r6.setOnClickListener(new n(this));
        r7.setOnClickListener(new o(this));
        r4.setOnTouchListener(new p(this));
    }

    public /* synthetic */ PublicScreenConfigSliderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
