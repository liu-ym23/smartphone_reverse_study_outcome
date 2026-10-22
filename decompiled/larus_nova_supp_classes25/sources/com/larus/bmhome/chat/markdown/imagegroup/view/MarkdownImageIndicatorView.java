package com.larus.bmhome.chat.markdown.imagegroup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownImageIndicatorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "dotContainer", "currentPosition", "currentLeftIndex", "currentRightIndex", "count", "setUpWithViewPager", "", "initView", "createDots", "updateIndicator", "targetPosition", "getPositionScaleRatio", "", "position", "needScroll", "", "getDotView", "Landroid/view/View;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MarkdownImageIndicatorView extends LinearLayout {
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public final String a;
    public ViewPager2 b;
    public final LinearLayout c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static final class a {
    }

    static {
        int r0 = i5.y0(c.b(2130971517, null, 2131167404));
        h = r0;
        int r1 = i5.y0(c.b(2130971367, null, 2131167105));
        i = r1;
        j = r0 + (r1 * 2);
    }

    public MarkdownImageIndicatorView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "MarkdownImageIndicatorView";
        this.c = new LinearLayout(getContext());
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }

    public final View a(int r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        return this.c.getChildAt(r3);
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Throwable r4 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r4 == null) goto L12;
        FLogger.a.i(this.a, r4.toString());
        return null;
    L12:
        return null;
    }

    public final float b(int r7) {
        int r0 = this.g;
        if (r0 > 8) goto L5;
        return 1.0f;
    L5:
        boolean r1 = false;
        if (1 <= r7) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L26;
        int r5 = this.f;
        if (r7 >= (r0 - 1)) goto L16;
        if (r5 > r7) goto L16;
        r1 = true;
    L16:
        if (r1 == true) goto L26;
        if (r7 != (this.e + 1)) goto L22;
        if (r7 <= 1) goto L22;
    L25:
        return 0.6666667f;
    L22:
        if (r7 == (r5 - 1)) goto L24;
        return 1.0f;
    L24:
        if (r7 < (r0 - 2)) goto L25;
        return 1.0f;
    L26:
        return 0.33333334f;
    L8:
        if (r7 > this.e) goto L10;
        r4 = true;
        goto L11
    }

    public final void setUpWithViewPager(ViewPager2 r9) {
        Intrinsics.checkNotNullParameter(r9, "viewPager2");
        this.b = r9;
        if (r9 == null) goto L7;
        RecyclerView.Adapter r10 = r9.getAdapter();
        if (r10 == null) goto L7;
        int r11 = r10.getItemCount();
    L8:
        this.g = r11;
        if (r11 > 1) goto L11;
        setVisibility(8);
        return;
    L11:
        ViewPager2 r12 = this.b;
        if (r12 == null) goto L14;
        r12.registerOnPageChangeCallback(new MarkdownImageIndicatorView$initView$1(this));
    L14:
        setClipChildren(false);
        this.c.setClipChildren(false);
        addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        int r13 = this.g;
        int r3 = 0;
    L15:
        if (r3 >= r13) goto L17;
        ImageView r5 = new ImageView(getContext());
        r5.setImageResource(2131239266);
        int r7 = h;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(r7, r7);
        int r8 = i;
        r6.setMargins(r8, 0, r8, 0);
        this.c.addView(r5, r6);
        r3 = r3 + 1;
        goto L15
    L17:
        this.d = 0;
        this.e = 0;
        this.f = Math.min(8, this.g) - 1;
        int r14 = this.g;
        int r4 = 0;
    L18:
        if (r4 >= r14) goto L33;
        View r15 = a(r4);
        if (r15 == null) goto L31;
        if (r4 != this.d) goto L24;
        r15.setAlpha(1.0f);
    L25:
        float r16 = b(r4);
        if (r16 != r15.getScaleX()) goto L28;
        boolean r17 = true;
    L29:
        if (r17 == true) goto L31;
        r15.setScaleY(r16);
        r15.setScaleX(r16);
        goto L31
    L28:
        r17 = false;
        goto L29
    L24:
        r15.setAlpha(0.4f);
    L31:
        r4 = r4 + 1;
        goto L18
    L33:
        if (this.g <= 8) goto L35;
        ViewGroup.LayoutParams r18 = getLayoutParams();
        r18.width = j * 8;
        return;
    L35:
        getLayoutParams().width = -2;
        return;
    L7:
        r11 = 0;
        goto L8
    }

    public MarkdownImageIndicatorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "MarkdownImageIndicatorView";
        this.c = new LinearLayout(getContext());
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }

    public MarkdownImageIndicatorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "MarkdownImageIndicatorView";
        this.c = new LinearLayout(getContext());
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }
}
