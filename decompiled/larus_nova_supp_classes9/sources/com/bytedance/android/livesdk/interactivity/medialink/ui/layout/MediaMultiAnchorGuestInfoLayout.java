package com.bytedance.android.livesdk.interactivity.medialink.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.p;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y82.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/layout/MediaMultiAnchorGuestInfoLayout;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "maxEms", BuildConfig.FLAVOR, "setNickNameMaxEms", "getOtherElementWidth", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/p;", "getComponent", BuildConfig.FLAVOR, "isPad", "setIsPad", "windowCount", "setWindowCount", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/UILayout;", "uiLayout", "setUILayout", BuildConfig.FLAVOR, "getNickName", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorGuestInfoLayout extends FrameLayout {
    public final HSImageView a;
    public final HSImageView b;
    public final TextView c;
    public final ImageView d;
    public final LinearLayout e;
    public final p f;
    public boolean g;
    public int h;
    public UILayout i;
    public boolean j;
    public final FrameLayout k;

    public static final class a {
    }

    static {
    }

    public MediaMultiAnchorGuestInfoLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MediaMultiAnchorGuestInfoLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        setNickNameMaxEms(5);
    }

    private final int getOtherElementWidth() {
        int r1 = 0;
        if (this.d.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r1 = 14;
    L9:
        return s1.f(r1 + 13.0f);
    L5:
        r0 = false;
        goto L6
    }

    public final void a() {
        if (this.g == false) goto L6;
        c();
    L14:
        if (this.g == false) goto L16;
    L19:
        boolean r0 = true;
    L20:
        UtilityKotlinExtentionsKt.z(this.a, r0);
        if (this.j == true) goto L23;
    L27:
        boolean r1 = false;
    L28:
        UtilityKotlinExtentionsKt.z(this.b, r1);
        if (r1 == false) goto L39;
        HSImageView r2 = this.b;
        UILayout r4 = this.i;
        int r5 = h.a[r4.ordinal()];
        if (r5 == 1) goto L36;
        if (r5 != 2) goto L35;
        int r6 = 2131252447;
    L37:
        r2.setActualImageResource(r6);
        goto L39
    L35:
        throw new NoWhenBranchMatchedException();
    L36:
        r6 = 2131252596;
    L39:
        if (this.g == false) goto L41;
        UIUtils.updateLayoutMargin(this.k, -3, -3, UtilityKotlinExtentionsKt.i(4), -3);
        int r3 = s1.f(2.0f);
        this.e.setPadding(r3, r3, r3, r3);
        this.e.setBackground(s1.m(2131249515));
        return;
    L41:
        UILayout r7 = this.i;
        int r8 = h.b[r7.ordinal()];
        if (r8 == 1) goto L50;
        if (r8 == 2) goto L46;
        return;
    L46:
        if (this.j == false) goto L48;
        UIUtils.updateLayoutMargin(this.k, 0, 0, 0, 0);
        UIUtils.updateLayoutMargin(this.c, 0, 0, UtilityKotlinExtentionsKt.i(4), 0);
    L49:
        this.e.setPadding(0, 0, 0, 0);
        this.e.setBackground(s1.m(2131249513));
        return;
    L48:
        UIUtils.updateLayoutMargin(this.k, 0, 0, 0, 0);
        UIUtils.updateLayoutMargin(this.c, UtilityKotlinExtentionsKt.i(4), 0, UtilityKotlinExtentionsKt.i(4), 0);
        goto L49
    L50:
        UIUtils.updateLayoutMargin(this.k, 0, 0, UtilityKotlinExtentionsKt.i(4), 0);
        UIUtils.updateLayoutMargin(this.c, 0, 0, UtilityKotlinExtentionsKt.i(3), 0);
        int r9 = s1.f(2.0f);
        this.e.setPadding(r9, r9, r9, r9);
        this.e.setBackground(s1.m(2131249514));
        return;
    L23:
        if (this.g == false) goto L25;
    L26:
        r1 = true;
        goto L28
    L25:
        if (this.i != UILayout.Enlarge) goto L27;
    L16:
        if (this.h <= 2) goto L19;
        r0 = false;
        goto L20
    L6:
        if (this.h > 2) goto L8;
        this.c.setTextSize(1, 12.0f);
        UIUtils.updateLayout(this.a, UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        UIUtils.updateLayout(this.b, UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        UIUtils.updateLayout(this.d, UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        goto L14
    L8:
        this.c.setTextSize(1, 12.0f);
        if (this.i != UILayout.Enlarge) goto L11;
        int r10 = 20;
    L12:
        UIUtils.updateLayout(this.a, UtilityKotlinExtentionsKt.i(r10), UtilityKotlinExtentionsKt.i(r10));
        UIUtils.updateLayout(this.b, UtilityKotlinExtentionsKt.i(r10), UtilityKotlinExtentionsKt.i(r10));
        UIUtils.updateLayout(this.d, UtilityKotlinExtentionsKt.i(14), UtilityKotlinExtentionsKt.i(14));
        goto L14
    L11:
        r10 = 14;
        goto L12
    }

    public final void c() {
        this.c.setTextSize(1, 14.0f);
        UIUtils.updateLayout(this.a, UtilityKotlinExtentionsKt.i(28), UtilityKotlinExtentionsKt.i(28));
        UIUtils.updateLayout(this.b, UtilityKotlinExtentionsKt.i(28), UtilityKotlinExtentionsKt.i(28));
        UIUtils.updateLayout(this.d, UtilityKotlinExtentionsKt.i(28), UtilityKotlinExtentionsKt.i(28));
    }

    public final String getNickName() {
        CharSequence r0 = this.c.getText();
        if (r0 != null) goto L6;
        r0 = BuildConfig.FLAVOR;
    L6:
        return r0.toString();
    }

    public final p getComponent() {
        return this.f;
    }

    private final void setNickNameMaxEms(int r2) {
        if (this.c.getMaxEms() == r2) goto L6;
        this.c.setMaxEms(r2);
        return;
    }

    public final void setIsPad(boolean r2) {
        if (this.g != r2) goto L5;
        return;
    L5:
        this.g = r2;
        c();
        a();
    }

    public final void setUILayout(UILayout r2) {
        Intrinsics.checkNotNullParameter(r2, "uiLayout");
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        a();
    }

    public final void setWindowCount(int r2) {
        if (this.h != r2) goto L5;
        return;
    L5:
        this.h = r2;
        a();
    }

    public MediaMultiAnchorGuestInfoLayout(Context r10, AttributeSet r11, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r13);
        p r14 = new p(this, false, false, null, null, null, 510);
        r14.j(true);
        Unit r15 = Unit.INSTANCE;
        this.f = r14;
        this.i = UILayout.Normal;
        View r16 = LayoutInflater.from(r10).inflate(2131566913, null, false);
        addView(r16);
        this.a = r16.findViewById(2131374209);
        this.b = r16.findViewById(2131381787);
        this.k = (FrameLayout) r16.findViewById(2131374739);
        this.c = (TextView) r16.findViewById(2131380593);
        this.d = (ImageView) r16.findViewById(2131376256);
        this.e = (LinearLayout) r16.findViewById(2131378704);
    }

    public /* synthetic */ MediaMultiAnchorGuestInfoLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
