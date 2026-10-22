package com.larus.browsertakeover.ui;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.common_ui.dbx.component.DbxButton;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends FrameLayout {
    public static final float[] n = null;
    public final boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final List<ObjectAnimator> e;
    public final List<AppCompatImageView> f;
    public final LinearLayout g;
    public final AppCompatImageView h;
    public final TextView i;
    public final DbxButton j;
    public final LinearLayout k;
    public final C0071b l;
    public Function0<Unit> m;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.ui.b$b, reason: collision with other inner class name */
    public static final class C0071b extends ContentObserver {
        public final /* synthetic */ b a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r1) {
            this.a.d();
        }

        public C0071b(b r1, Handler r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
        n = new float[]{1.0f, 0.6f, 0.3f};
    }

    public final void c() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ObjectAnimator) r0.next()).cancel();
        goto L4
    L6:
        this.e.clear();
        Iterator<T> r1 = this.f.iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        ((AppCompatImageView) r3).setAlpha(n[r2]);
        r2 = r4;
        goto L8
    }

    public final void d() {
        if (this.b == true) goto L5;
    L33:
        c();
        return;
    L5:
        if (this.c == false) goto L33;
        if (isAttachedToWindow() == false) goto L33;
        if (isShown() == false) goto L33;
        if (getWindowVisibility() != 0) goto L33;
        if (Build.VERSION.SDK_INT < 26) goto L36;
        boolean r0 = ValueAnimator.areAnimatorsEnabled();
    L20:
        if (r0 == false) goto L33;
        if ((!this.e.isEmpty()) == false) goto L25;
        return;
    L25:
        PathInterpolator r1 = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        Iterator<T> r2 = this.f.iterator();
        int r6 = 0;
    L27:
        if (r2.hasNext() == false) goto L32;
        Object r7 = r2.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        AppCompatImageView r9 = (AppCompatImageView) r7;
        r9.setAlpha(0.3f);
        Keyframe r11 = Keyframe.ofFloat(0.2f, 1.0f);
        r11.setInterpolator(r1);
        Unit r12 = Unit.INSTANCE;
        Keyframe r13 = Keyframe.ofFloat(0.6f, 0.3f);
        r13.setInterpolator(r1);
        Keyframe r10 = Keyframe.ofFloat(1.0f, 0.3f);
        r10.setInterpolator(new LinearInterpolator());
        PropertyValuesHolder r14 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.3f), r11, r13, r10});
        List<ObjectAnimator> r15 = this.e;
        ObjectAnimator r16 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{r14});
        r16.setDuration(1200);
        r16.setStartDelay(((long) r6) * 200);
        r16.setInterpolator(new LinearInterpolator());
        r16.setRepeatCount(-1);
        r16.setRepeatMode(1);
        r16.start();
        r15.add(r16);
        r6 = r8;
        goto L27
    L32:
        return;
    L36:
        if (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) <= 0.0f) goto L19;
        r0 = true;
    L19:
        r0 = false;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.d == false) goto L5;
        getContext().getContentResolver().unregisterContentObserver(this.l);
        this.d = false;
    L5:
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor("animator_duration_scale"), false, this.l);     // Catch: SecurityException -> L5
        this.d = true;     // Catch: SecurityException -> L5
    L6:
        d();
        return;
    L5:
        FLogger.a.i("BrowserConnectionStatus", "animation_scale_observer_unavailable");
        goto L6
    }

    public final Function0<Unit> getOnRetry() {
        return this.m;
    }

    public b(Context r17) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(com.larus.common_ui.dbx.theme.a.c(r17));
        this.e = new ArrayList();
        List<AppCompatImageView> r2 = CollectionsKt.listOf(new AppCompatImageView[]{b(2131243479), b(2131243480), b(2131243481)});
        this.f = r2;
        LinearLayout r3 = new LinearLayout(getContext());
        r3.setOrientation(0);
        r3.setGravity(16);
        r3.setImportantForAccessibility(4);
        float r10 = 40;
        r3.addView(b(2131243483), new LinearLayout.LayoutParams(a(r10), a(r10)));
        FrameLayout r8 = new FrameLayout(r17);
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r8.addView((AppCompatImageView) r4.next(), new FrameLayout.LayoutParams(a(20.9375f), a(5), 17));
        goto L4
    L6:
        float r9 = 24;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(a(r9), a(r9));
        float r11 = 20;
        r5.setMarginStart(a(r11));
        Unit r12 = Unit.INSTANCE;
        r3.addView(r8, r5);
        AppCompatImageView r6 = b(2131243477);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(a(r10), a(r10));
        r13.setMarginStart(a(r11));
        r3.addView(r6, r13);
        this.g = r3;
        AppCompatImageView r7 = b(2131243482);
        this.h = r7;
        TextView r14 = new TextView(getContext());
        r14.setTextSize(17.0f);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        Typeface r15 = Typeface.create(Typeface.DEFAULT, 600, false);
    L10:
        r14.setTypeface(r15);
        r14.setTextColor(-1);
        r14.setGravity(17);
        r14.setIncludeFontPadding(false);
        r14.setMinimumHeight(a(26));
        r14.setLineSpacing(0.0f, 1.5f);
        r14.setAccessibilityLiveRegion(1);
        this.i = r14;
        final DbxButton r16 = new DbxButton(getContext(), null, 6, 0);
        r16.b(DbxButton.Style.SOLID, DbxButton.Size.L);
        r16.setLeadingIcon(null);
        r16.setTrailingIcon(null);
        r16.setMinimumWidth(a(116));
        r16.setOnClickListener(new com.larus.browsertakeover.ui.a(this, r16));
        this.j = r16;
        LinearLayout r18 = new LinearLayout(getContext());
        r18.setOrientation(1);
        r18.setGravity(1);
        FrameLayout r19 = new FrameLayout(r17);
        float r110 = 144;
        r19.addView(r3, new FrameLayout.LayoutParams(a(r110), a(r10), 17));
        r19.addView(r7, new FrameLayout.LayoutParams(a(r10), a(r10), 17));
        r18.addView(r19, new LinearLayout.LayoutParams(a(r110), a(r10)));
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        float r20 = 16;
        r1.topMargin = a(r20);
        r18.addView(r14, r1);
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-2, -2);
        r21.topMargin = a(r20);
        r18.addView(r16, r21);
        this.k = r18;
        this.l = new C0071b(this, new Handler(Looper.getMainLooper()));
        setBackgroundColor(-16777216);
        setClickable(true);
        setFocusable(false);
        setImportantForAccessibility(2);
        FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(-1, -2);
        float r23 = 32;
        r22.leftMargin = a(r23);
        r22.rightMargin = a(r23);
        addView(r18, r22);
        this.a = true;
        this.b = false;
        setVisibility(8);
        c();
        return;
    L9:
        r15 = Typeface.create("sans-serif-medium", 0);
        goto L10
    }

    public final int a(float r3) {
        Resources r0 = getResources();
        return MathKt.roundToInt(r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final AppCompatImageView b(int r3) {
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r0.setImageResource(r3);
        r0.setImportantForAccessibility(2);
        return r0;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (this.a == false) goto L6;
        d();
        return;
    }

    public final void setHostActive(boolean r1) {
        this.c = r1;
        d();
    }

    public final void setOnRetry(Function0<Unit> r1) {
        this.m = r1;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (this.a == false) goto L6;
        d();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = RangesKt.coerceIn(MathKt.roundToInt(((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.36437246f), 0, RangesKt.coerceAtLeast(((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.k.getMeasuredHeight(), 0));
        int r8 = (getWidth() - this.k.getMeasuredWidth()) / 2;
        this.k.layout(r8, getPaddingTop() + r7, this.k.getMeasuredWidth() + r8, (getPaddingTop() + r7) + this.k.getMeasuredHeight());
    }
}
