package com.larus.bmhome.chat.layout.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewGroupKt;
import androidx.viewbinding.ViewBindings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.chat.common.databinding.LarusWidgetLoadingBinding;
import com.larus.common.apphost.AppHost;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000eJ\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 J\u0006\u0010*\u001a\u00020 J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u00020 H\u0002J\u0018\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u000eH\u0002J\b\u00106\u001a\u00020 H\u0014J\b\u00107\u001a\u00020 H\u0014J\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/MessageLoading;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/layout/widget/LoadingAnimationLifecycleAware;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "minAlpha", "", "maxAlpha", "animatorHasStart", "", "value", "curDuration", "getCurDuration", "()F", "setCurDuration", "(F)V", "animator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "binding", "Lcom/larus/chat/common/databinding/LarusWidgetLoadingBinding;", "registered", "isAppForeground", "init", "", "setProgressVisible", "visible", "setDotSize", "scale", "scaleDot", "view", "Landroid/view/View;", "setFailStatus", "startLoading", "cancelLoading", "onAppForeground", "onAppBackground", "setColor", "argb", "setLoadingText", "content", "", "setupUIToDuration", "setupChildUIToDuration", "child", "duration", "onDetachedFromWindow", "onAttachedToWindow", "setProgress", "progress", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageLoading extends LinearLayout implements q0 {
    public static final /* synthetic */ int i = 0;
    public final float a;
    public final float b;
    public boolean c;
    public float d;
    public final ObjectAnimator e;
    public LarusWidgetLoadingBinding f;
    public boolean g;
    public boolean h;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ MessageLoading b;

        public a(View r1, MessageLoading r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.b.g == true) goto L5;
            CopyOnWriteArrayList<WeakReference<q0>> r0 = s0.a;
            s0.a(this.b);
            this.b.h = !AppHost.a.a().isAppBackground();
            this.b.g = true;
        L5:
            MessageLoading r1 = this.b;
            if (r1.h == false) goto L9;
            r1.e.start();
            this.b.c = true;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppBackground() {
        this.h = false;
        this.e.cancel();
        this.c = false;
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppForeground() {
        this.h = true;
        c();
    }

    public final void c() {
        OneShotPreDrawListener.add(this, new a(this, this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c == false) goto L6;
        c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.cancel();
    }

    public final float getCurDuration() {
        return this.d;
    }

    public MessageLoading(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.a = 0.1f;
        this.b = 1.0f;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r0.setRepeatCount(-1);
        r0.setDuration(800);
        this.e = r0;
        this.h = true;
        a(r4, null);
    }

    public final void setColor(int r4) {
        Iterator r0 = SequencesKt.filter(ViewGroupKt.getChildren(this), new x0()).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Drawable r1 = ((View) r0.next()).getBackground();
        if ((r1 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r2 = (GradientDrawable) r1;
    L9:
        if (r2 == null) goto L4;
        r2.setColor(r4);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    public final void setCurDuration(float r11) {
        this.d = r11;
        IntProgression r0 = RangesKt.reversed(RangesKt.until(0, getChildCount()));
        int r2 = r0.getFirst();
        int r3 = r0.getLast();
        int r1 = r0.getStep();
        if (r1 <= 0) goto L5;
        if (r2 > r3) goto L5;
    L7:
        View r4 = getChildAt(r2);
        if (r4.getId() == 2131390903) goto L34;
        Intrinsics.checkNotNull(r4);
        if (r11 >= 0.0f) goto L14;
        float r7 = 0.0f;
    L17:
        boolean r8 = true;
        if (0.0f <= r7) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L26;
        float r6 = this.b;
        r4.setAlpha(r6 - (((r6 - this.a) * r7) / 0.5f));
    L33:
        r11 = r11 + 0.167f;
        goto L34
    L26:
        if (0.5f <= r7) goto L28;
    L30:
        r8 = false;
    L31:
        if (r8 == false) goto L33;
        float r9 = this.a;
        r4.setAlpha(r9 + (((this.b - r9) * (r7 - 0.5f)) / 0.5f));
        goto L33
    L28:
        if (r7 > 1.0f) goto L30;
    L20:
        if (r7 > 0.5f) goto L22;
        r5 = true;
        goto L23
    L14:
        if (r11 <= 1.0f) goto L16;
        r7 = r11 - 1.0f;
        goto L17
    L16:
        r7 = r11;
    L34:
        if (r2 == r3) goto L40;
        r2 = r2 + r1;
        goto L7
    L40:
        return;
    L5:
        if (r1 >= 0) goto L36;
        if (r3 <= r2) goto L7;
        return;
    }

    public final void setDotSize(float r3) {
        LarusWidgetLoadingBinding r0 = this.f;
        if (r0 == null) goto L6;
        b(r0.d, r3);
        b(r0.e, r3);
        b(r0.f, r3);
        return;
    }

    public final void setLoadingText(String r3) {
        LarusWidgetLoadingBinding r0 = this.f;
        if (r0 == null) goto L20;
        TextView r1 = r0.c;
        if (r1 == null) goto L21;
        if (r3 == null) goto L8;
        String r2 = r3;
    L9:
        r1.setText(r2);
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        com.larus.utils.e1.o(r1);
        return;
    L18:
        com.larus.utils.e1.x(r1);
        return;
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L8:
        r2 = "";
        goto L9
    L21:
        return;
    }

    public final void setProgress(int r3) {
        LarusWidgetLoadingBinding r0 = this.f;
        if (r0 == null) goto L8;
        TextView r1 = r0.b;
        if (r1 == null) goto L9;
        StringBuilder r2 = new StringBuilder();
        r2.append(r3);
        r2.append('%');
        r1.setText(r2.toString());
        return;
    L9:
        return;
    }

    public final void setProgressVisible(boolean r2) {
        LarusWidgetLoadingBinding r0 = this.f;
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        com.larus.utils.e1.x(r0.b);
        com.larus.utils.e1.o(r0.d);
        com.larus.utils.e1.o(r0.e);
        com.larus.utils.e1.o(r0.f);
        return;
    L6:
        com.larus.utils.e1.o(r0.b);
        com.larus.utils.e1.x(r0.d);
        com.larus.utils.e1.x(r0.e);
        com.larus.utils.e1.x(r0.f);
        return;
    }

    public MessageLoading(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.a = 0.1f;
        this.b = 1.0f;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r0.setRepeatCount(-1);
        r0.setDuration(800);
        this.e = r0;
        this.h = true;
        a(r4, r5);
    }

    public static void b(View r2, float r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L7;
        r0.width = (int) (i5.r0() * r3);
        r0.height = (int) (i5.r0() * r3);
        r2.setLayoutParams(r0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void a(Context r10, AttributeSet r11) {
        setGravity(17);
        LayoutInflater.from(r10).inflate(2131563255, this);
        int r0 = 2131383330;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131383330);
        if (r4 == null) goto L15;
        r0 = 2131390903;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131390903);
        if (r5 == null) goto L15;
        r0 = 2131392119;
        View r6 = ViewBindings.findChildViewById(this, 2131392119);
        if (r6 == null) goto L15;
        r0 = 2131392120;
        View r7 = ViewBindings.findChildViewById(this, 2131392120);
        if (r7 == null) goto L15;
        r0 = 2131392121;
        View r8 = ViewBindings.findChildViewById(this, 2131392121);
        if (r8 == null) goto L15;
        this.f = new LarusWidgetLoadingBinding(this, r4, r5, r6, r7, r8);
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{R.attr.color});
        setColor(r12.getColor(0, ContextCompat.getColor(r10, 2131103298)));
        r12.recycle();
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public MessageLoading(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = 0.1f;
        this.b = 1.0f;
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r6.setRepeatCount(-1);
        r6.setDuration(800);
        this.e = r6;
        this.h = true;
        a(r3, r4);
    }
}
