package com.ss.android.lark.contact.customized.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007J2\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017H\u0007J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020(J\u0016\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020(J\u0006\u0010/\u001a\u00020\u001aJ\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/contact/customized/common/view/ContactOfficeTitleBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultTitleColor", "defaultRightTintColor", "defaultLeftTintColor", "ivLeftIcon", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "rightCustomContainer", "ivRightIcon", "leftButtonContainer", "Landroid/widget/FrameLayout;", "rightButtonContainer", "leftIconClickListener", "Landroid/view/View$OnClickListener;", "rightIconClickListener", "setTitle", BuildConfig.FLAVOR, "title", BuildConfig.FLAVOR, "setLeftIcon", "iconResId", "setLeftIconClickListener", "listener", "setRightIcon", "setRightIconClickListener", "setTitleColor", "color", "setLeftIconColor", "setRightIconColor", "addRightIconButton", "Landroid/view/View;", "iconTint", "contentDescription", "addRightCustomButton", "button", "index", "removeRightCustomButton", "clearRightCustomButtons", "dp", "value", "resolveColor", "colorOrResId", "updateTitleMaxWidth", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactOfficeTitleBar extends LinearLayout {
    public static final /* synthetic */ int i = 0;
    public final ImageView a;
    public final TextView b;
    public final LinearLayout c;
    public final ImageView d;
    public final FrameLayout e;
    public final FrameLayout f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ContactOfficeTitleBar a;

        public a(ContactOfficeTitleBar r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ContactOfficeTitleBar a;

        public b(ContactOfficeTitleBar r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ ContactOfficeTitleBar a;

        public c(ContactOfficeTitleBar r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ContactOfficeTitleBar r10 = this.a;
            int r11 = ContactOfficeTitleBar.i;
            int r12 = (r10.getWidth() - r10.getPaddingLeft()) - r10.getPaddingRight();
            if (r12 > 0) goto L6;
            return;
        L6:
            if (r10.e.getVisibility() != 8) goto L8;
            int r13 = 0;
        L10:
            if (r10.c.getVisibility() != 8) goto L12;
            int r14 = 0;
        L14:
            if (r10.f.getVisibility() != 8) goto L16;
            int r15 = 0;
        L17:
            int r16 = RangesKt.coerceAtLeast(r12 - (Math.max(r13, r14 + r15) * 2), 0);
            if (r10.b.getMaxWidth() == r16) goto L21;
            r10.b.setMaxWidth(r16);
            return;
        L21:
            return;
        L16:
            r15 = r10.f.getMeasuredWidth();
            goto L17
        L12:
            r14 = r10.c.getMeasuredWidth();
            goto L14
        L8:
            r13 = r10.e.getMeasuredWidth();
            goto L10
        }
    }

    public ContactOfficeTitleBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ContactOfficeTitleBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int b(int r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Integer.valueOf(ContextCompat.getColor(getContext(), r3)));     // Catch: Throwable -> L4
    L6:
        Integer r4 = Integer.valueOf(r3);
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r4;
    L10:
        return ((Number) r1).intValue();
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void setLeftIcon(int r2) {
        this.a.setImageResource(r2);
    }

    public final void setLeftIconClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }

    public final void setLeftIconColor(int r2) {
        this.a.setColorFilter(b(r2));
    }

    public final void setRightIcon(int r2) {
        this.d.setImageResource(r2);
    }

    public final void setRightIconClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h = r2;
    }

    public final void setRightIconColor(int r2) {
        this.d.setColorFilter(b(r2));
    }

    public final void setTitle(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.b.setText(r2);
    }

    public final void setTitleColor(int r2) {
        this.b.setTextColor(r2);
    }

    public ContactOfficeTitleBar(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        int r1 = UIUtils.getColor(r11, 2131102040);
        int r2 = UIUtils.getColor(r11, 2131102040);
        int r0 = UIUtils.getColor(r11, 2131102040);
        View r3 = LayoutInflater.from(r11).inflate(2131559902, this, true);
        FrameLayout r4 = (FrameLayout) r3.findViewById(2131372767);
        this.e = r4;
        ImageView r6 = (ImageView) r3.findViewById(2131376352);
        this.a = r6;
        TextView r7 = (TextView) r3.findViewById(2131391606);
        this.b = r7;
        this.c = (LinearLayout) r3.findViewById(2131378835);
        FrameLayout r8 = (FrameLayout) r3.findViewById(2131372826);
        this.f = r8;
        ImageView r5 = (ImageView) r3.findViewById(2131376563);
        this.d = r5;
        r4.setOnClickListener(new a(this));
        r8.setOnClickListener(new b(this));
        addOnLayoutChangeListener(new c(this));
        if (r12 == null) goto L15;
        TypedArray r14 = r11.obtainStyledAttributes(r12, new int[]{2130972500, 2130972503, 2130973781, 2130973784, 2130974574, 2130974575}, r13, 0);
        String r15 = r14.getString(4);
        if (TextUtils.isEmpty(r15) == true) goto L7;
        r7.setText(r15);
    L7:
        r7.setTextColor(r14.getColor(5, r1));
        int r16 = r14.getResourceId(0, 2131233630);
        if (r16 == (-1)) goto L10;
        r6.setImageResource(r16);
    L10:
        r6.setColorFilter(r14.getColor(1, r0));
        int r17 = r14.getResourceId(2, -1);
        if (r17 == (-1)) goto L13;
        r5.setImageResource(r17);
    L13:
        r5.setColorFilter(r14.getColor(3, r2));
        r14.recycle();
        return;
    }

    public /* synthetic */ ContactOfficeTitleBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
