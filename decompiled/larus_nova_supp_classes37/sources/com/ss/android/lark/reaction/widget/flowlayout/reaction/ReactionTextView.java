package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 m2\u00020\u0001:\u0004mnopB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u0012J\u0016\u0010(\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010)\u001a\u00020$2\b\b\u0001\u0010*\u001a\u00020\u000fH\u0007J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020 J\u0012\u00102\u001a\u00020$2\n\u00103\u001a\u00060\u001aR\u00020\u001bJ\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0016J\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u000fJ\u000e\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\nJ\u000e\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020\nJ\u0016\u0010>\u001a\u00020$2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@J\u0018\u0010B\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\nH\u0002J\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\n0E2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0@H\u0002J$\u0010G\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u000f0E2\u0006\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020HH\u0002JH\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020N2\u0006\u0010I\u001a\u00020\r2\u0006\u0010Q\u001a\u00020N2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020FH\u0002JX\u0010T\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0006\u0012\u0004\u0018\u00010H0E2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010P\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\b\u0010U\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020A2\u0006\u0010V\u001a\u00020H2\u0006\u0010J\u001a\u00020HH\u0002J(\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010I\u001a\u00020A2\u0006\u0010Z\u001a\u00020H2\u0006\u0010L\u001a\u00020\u000fH\u0002J(\u0010[\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010]\u001a\u00020HH\u0002J(\u0010^\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010I\u001a\u00020A2\u0006\u0010Z\u001a\u00020H2\u0006\u0010_\u001a\u00020HH\u0002J\"\u0010`\u001a\u00020$2\u0006\u0010I\u001a\u00020A2\u0006\u0010X\u001a\u00020Y2\b\u0010U\u001a\u0004\u0018\u00010HH\u0002J\u0010\u0010a\u001a\u00020$2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010b\u001a\u00020$2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000fH\u0014J\u0010\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020gH\u0014J\u0010\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020HH\u0002J\u0010\u0010;\u001a\u00020\n2\u0006\u0010I\u001a\u00020AH\u0002J\u0010\u0010l\u001a\u00020\n2\u0006\u0010I\u001a\u00020AH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/ss/android/lark/reaction/widget/flowlayout/reaction/ReactionTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mAllowOnlyShowCount", "", "mViewDataList", "", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/FlowLayoutViewModel;", "mDividerColor", "", "Ljava/lang/Integer;", "mBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "extendIconDrawable", "isExtendIconEnable", "mReactionClickListener", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout$OnReactionItemClickListener;", "extendIconClickListener", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout$OnExtendIconClickListener;", "mOnContributorClickNew", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout$OnContributorClickNew;", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "shownNamesNumberLimit", "isTapAnimationEnabled", "sizeChanged", "resourceLoader", "Lcom/ss/android/lark/reaction/widget/flowlayout/reaction/ReactionResourceLoaderWrap;", "baseLineSpacingExtra", "extraLineHeight", "setMaxWidth", "", "maxPixels", "setLineBackground", "lineBackground", "setExtendIconInfo", "setExtendIconTint", "iconTint", "setDividerColor", "dividerColor", "setSeparatorWidth", "separatorWidth", "setExtraLineHeight", "setReactionResourceLoader", "loader", "setOnContributorClickNew", "onContributorClickNew", "setReactionClickListener", "listener", "setShownNamesNumberLimit", "limit", "setEnableLongClick", "enableLongClick", "setOnlyShowCount", "onlyShowCount", "setTapAnimationEnabled", "enabled", "setReactionData", "viewDataList", "", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/ReactionFlowLayoutViewModel;", "setupSeparatorDrawable", "forceUpdateColor", "getSpannableResult", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "getOriginalLineText", "", "reaction", "nameSeparator", "handleNewLine", "realEmojiWidth", "measuredWidth", "", "usedWidth", "lineMaxWidth", "dataSeparatorWidth", "firstReaction", "result", "handleLineText", "suffix", "lineOriginal", "setupEmojiSpan", "lineSpannable", "Landroid/text/SpannableString;", "emoji", "setupExtendSpan", "drawable", "extendIconText", "setupSeparatorSpan", "emojiSeparator", "setupClickSpan", "setupBackgroundSpan", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "needAdjustLineHeight", "startLine", "getDisplayWidth", "reactionKey", "needShowCountWithEllipsis", "Companion", "ReactionClickableSpan", "SeparatorDrawableSpan", "BackgroundSpan", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ReactionTextView extends AppCompatTextView {
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public static int w;
    public static Drawable x;
    public static Drawable y;
    public boolean a;
    public final List<q2c.b> b;
    public Integer c;
    public Drawable d;
    public Drawable e;
    public boolean f;
    public ReactionFlowLayout.f g;
    public ReactionFlowLayout.e h;
    public ReactionFlowLayout.d i;
    public int j;
    public boolean k;
    public boolean l;
    public final int m;
    public int n;

    public static final class a extends CharacterStyle {
        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r1) {
        }

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c extends ClickableSpan {
        public final String a;
        public final q2c.d b;
        public final boolean c;
        public final ReactionFlowLayout.d d;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r9) {
            Intrinsics.checkNotNullParameter(r9, "p0");
            ReactionFlowLayout.d r10 = this.d;
            if (r10 == null) goto L23;
            q2c.d r0 = this.b;
            if (r0 == null) goto L7;
            String r1 = r0.a;
        L8:
            String r2 = this.a;
            boolean r3 = this.c;
            long r4 = SystemClock.uptimeMillis();
            long r5 = r4 - r10.a;
            r10.a = r4;
            if (r5 >= 500) goto L11;
            Log.i("OnSingleClickListener", "elapsedTime is short than LENGTH_SHORT");
            return;
        L11:
            if (r3 == false) goto L18;
            if (r10.b.l != null) goto L15;
            return;
        L15:
            if (TextUtils.isEmpty(r2) == true) goto L26;
            r10.b.l.a(r2);
            return;
        L26:
            return;
        L18:
            if (r10.b.k != null) goto L20;
            return;
        L20:
            if (TextUtils.isEmpty(r1) == true) goto L29;
            r10.b.k.a(r1);
            return;
        L29:
            return;
        L7:
            r1 = null;
            goto L8
        }

        public c(String r2, q2c.d r3, boolean r4, ReactionFlowLayout.d r5) {
            Intrinsics.checkNotNullParameter(r2, "reactionType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class d extends com.ss.android.lark.reaction.widget.flowlayout.reaction.d {
        public d() {
            super(1);
        }

        @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan
        public final Drawable b() {
            Drawable r0 = ReactionTextView.y;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new ShapeDrawable();
        }
    }

    public static final class e implements View.OnLongClickListener {
        public final /* synthetic */ ReactionTextView a;

        public e(ReactionTextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r4) {
            AppCompatTextView r5 = this.a;
            if (r5 == null) goto L17;
            ViewParent r6 = r5.getParent();
        L6:
            if (r6 == null) goto L18;
            if ((r6 instanceof ViewGroup) == false) goto L19;
            ViewGroup r1 = (ViewGroup) r6;
            if (r1.isLongClickable() == true) goto L11;
            r6 = r6.getParent();
            goto L6
        L11:
            r1.performLongClick();
            return true;
        L19:
            return false;
        L18:
            return false;
        L17:
            return false;
        }
    }

    static {
        o = -1;
        p = -1;
        q = -1;
        r = -1;
        s = -1;
        t = -1;
        u = -1;
        v = -1;
        w = -1;
    }

    public ReactionTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setupBackgroundSpan(SpannableString r5) {
        r5.setSpan(new a(), 0, r5.length(), 17);
    }

    public final boolean A(q2c.c r3) {
        if (this.a == false) goto L14;
        List<q2c.d> r4 = r3.c;
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r4.isEmpty() == true) goto L10;
        r5 = false;
        goto L11
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        if ((getText() instanceof SpannableString) == true) goto L5;
    L42:
        super/*android.widget.TextView*/.onDraw(r17);
        return;
    L5:
        if (getLayout() == null) goto L42;
        CharSequence r2 = getText();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.text.SpannableString");
        SpannableString r3 = (SpannableString) r2;
        int r4 = this.n / 2;
        CharSequence r5 = getText();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.text.SpannableString");
        char r9 = 0;
        a[] r6 = (a[]) ((SpannableString) r5).getSpans(0, getText().length() - 1, a.class);
        if (r6 == null) goto L42;
        Iterator r7 = ArrayIteratorKt.iterator(r6);
    L10:
        if (r7.hasNext() == false) goto L42;
        a r8 = (a) r7.next();
        int r10 = r3.getSpanStart(r8);
        int r11 = r3.getSpanEnd(r8);
        int r12 = getLayout().getLineForOffset(r10);
        int r13 = getLayout().getLineForOffset(r11);
        int r14 = (int) ((getLayout().getPrimaryHorizontal(r10) + ((getLayout().getParagraphDirection(r12) * (-1)) * u)) + getPaddingLeft());
        int r15 = (int) ((getLayout().getPrimaryHorizontal(r11) + (getLayout().getParagraphDirection(r13) * u)) + getPaddingLeft());
        if (r12 == (getLineCount() - 1)) goto L14;
    L34:
        int r16 = ((getLayout().getLineTop(r12) + getPaddingTop()) - r4) + (v * 4);
        int r18 = (getLayout().getLineBottom(r12) + getPaddingTop()) - r4;
    L35:
        int r19 = Math.min(r14, r15);
        int r20 = Math.max(r14, r15);
        Drawable r110 = this.d;
        if (r110 == null) goto L38;
        r110.setBounds(r19, r16, r20, r18);
    L38:
        Drawable r21 = this.d;
        if (r21 == null) goto L41;
        r21.draw(r17);
    L41:
        r9 = 0;
        goto L10
    L14:
        if (y(r12) == false) goto L34;
        r16 = (((getLayout().getLineTop(r12) + getPaddingTop()) + this.m) - r4) - (v / 2);
        r18 = (((getLayout().getLineBottom(r12) + getPaddingTop()) + this.m) + r4) - v;
        CharSequence r111 = getText();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.text.SpannableString");
        com.ss.android.lark.reaction.widget.flowlayout.reaction.d[] r112 = (com.ss.android.lark.reaction.widget.flowlayout.reaction.d[]) ((SpannableString) r111).getSpans(r10, r11, com.ss.android.lark.reaction.widget.flowlayout.reaction.d.class);
        if (r112 != null) goto L18;
    L24:
        CharSequence r22 = getText();
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type android.text.SpannableString");
        d[] r23 = (d[]) ((SpannableString) r22).getSpans(r10, r11, d.class);
        if (r23 == null) goto L35;
        if (r23.length != 0) goto L29;
        boolean r24 = true;
    L31:
        if ((!r24) == false) goto L35;
        d r25 = r23[0];
        float r26 = getLineSpacingExtra();
        r25.c = 0.0f;
        r25.d = r26;
        goto L35
    L29:
        r24 = false;
        goto L31
    L18:
        if (r112.length != 0) goto L20;
        boolean r113 = true;
    L22:
        if ((!r113) == false) goto L24;
        com.ss.android.lark.reaction.widget.flowlayout.reaction.d r114 = r112[r9];
        float r115 = getLineSpacingExtra();
        r114.c = 0.0f;
        r114.d = r115;
        goto L24
    L20:
        r113 = false;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDividerColor(int r2) {
        this.c = Integer.valueOf(r2);
        B(getContext(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnableLongClick(boolean r1) {
        if (r1 == false) goto L4;
        setOnLongClickListener(new e(this));
        return;
    L4:
        setOnLongClickListener(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setExtendIconTint(int r2) {
        Drawable r0 = this.e;
        if (r0 == null) goto L5;
        r0.setTint(r2);
    L5:
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setExtraLineHeight(int r2) {
        if (r2 > 0) goto L5;
        r2 = 0;
    L5:
        this.n = r2;
        setLineSpacing(this.m + r2, 1.0f);
    }

    public final void setLineBackground(Drawable r1) {
        if (r1 == null) goto L5;
        this.d = r1;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxWidth(int r2) {
        if (getMaxWidth() == r2) goto L5;
        this.l = true;
    L5:
        super/*android.widget.TextView*/.setMaxWidth(r2);
    }

    public final void setOnContributorClickNew(ReactionFlowLayout.d r2) {
        Intrinsics.checkNotNullParameter(r2, "onContributorClickNew");
        this.i = r2;
    }

    public final void setOnlyShowCount(boolean r1) {
        this.a = r1;
    }

    public final void setReactionClickListener(ReactionFlowLayout.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setReactionData(List<? extends q2c.c> r37) {
        if (Intrinsics.areEqual(this.b, r37) == false) goto L8;
        if (this.l == true) goto L8;
        return;
    L8:
        if (r37 != null) goto L11;
        setText(null);
        return;
    L11:
        ((ArrayList) this.b).clear();
        ((ArrayList) this.b).addAll(r37);
        if (this.f == false) goto L14;
        List<q2c.b> r0 = this.b;
        q2c.a r1 = new q2c.a();
        r1.a = this.e;
        ((ArrayList) r0).add(r1);
    L14:
        long r10 = System.currentTimeMillis();
        List<q2c.b> r2 = this.b;
        String r12 = "ReactionView";
        Log.i("ReactionView", "use new reaction view");
        String r13 = v2c.a.getResources(getContext()).getString(2131892117);
        float r14 = getPaint().measureText("       ");
        float r15 = ((getMaxWidth() - getPaddingLeft()) - getPaddingRight()) - w;
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        Iterator r16 = ((ArrayList) r2).iterator();
        int r3 = 0;
        int r4 = 0;
        boolean r17 = false;
    L16:
        if (r16.hasNext() == false) goto L199;
        int r18 = r3 + 1;
        q2c.b r7 = (q2c.b) r16.next();
        SpannableString r6 = new SpannableString("");
        if ((r7 instanceof q2c.c) == false) goto L183;
        StringBuilder r5 = new StringBuilder("[");
        q2c.c r9 = (q2c.c) r7;
        r5.append(r9.a);
        r5.append(']');
        String r11 = r5.toString();
        String r19 = r9.a;
        int r20 = k2c.b.b(r19);
        int r21 = k2c.b.a(r19);
        if (r20 == (-1)) goto L25;
        if (r21 == (-1)) goto L25;
        if (r21 == 0) goto L25;
        int r22 = (p * r20) / r21;
    L26:
        Intrinsics.checkNotNull(r13);
        if (A(r9) == false) goto L29;
        Pair r110 = new Pair("", Integer.valueOf(r9.b));
        SpannableStringBuilder r23 = r8;
    L46:
        if (((Number) r110.getSecond()).intValue() != this.j) goto L50;
        if (r9.c.size() <= this.j) goto L50;
    L51:
        boolean r24 = true;
    L53:
        if (r24 == false) goto L55;
        String r25 = v2c.a.e(getContext(), String.valueOf(r9.b - ((Number) r110.getSecond()).intValue()));
        float r26 = ((q + r22) + getPaint().measureText((String) r110.getFirst())) + getPaint().measureText(r25);
    L56:
        String r27 = r25;
        float r28 = r26;
        if (r28 < getMaxWidth()) goto L59;
        r17 = true;
    L59:
        if (r3 != 0) goto L61;
        boolean r29 = true;
    L62:
        String r38 = r12;
        int r111 = r22;
        long r210 = r10;
        SpannableStringBuilder r211 = r23;
        int r30 = x(r22, r28, r4, r15, r7, r14, r29, r211);
        String r31 = (String) r110.getFirst();
        if (A(r9) == false) goto L66;
        Pair r32 = new Pair(" " + r9.b, String.valueOf(r9.b));
    L65:
        String r212 = r13;
    L148:
        String r33 = (String) r32.getFirst();
        String r34 = (String) r32.getSecond();
        int r35 = r30 + ((((int) getPaint().measureText(r33)) + r111) + q);
        if (A(r9) == false) goto L151;
        SpannableString r36 = new SpannableString(r11 + r33);
    L152:
        SpannableString r39 = r36;
        Context r213 = getContext();
        String r40 = r9.a;
        ReactionFlowLayout.f r41 = this.g;
        if (r41 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("mReactionClickListener");
        r41 = null;
    L155:
        r39.setSpan(new com.ss.android.lark.reaction.widget.flowlayout.reaction.a(r213, r40, r41, r111, new WeakReference(this), this.k), 0, r11.length(), 18);
        if (A(r9) == true) goto L160;
        r39.setSpan(new d(), r11.length(), r11.length() + 1, 18);
    L160:
        if (A(r9) == true) goto L182;
        Iterator<q2c.d> r42 = r9.c.iterator();
        int r43 = 0;
    L164:
        if (r42.hasNext() == false) goto L178;
        q2c.d r44 = r42.next();
        int r45 = StringsKt.indexOf$default(r39, r44.b, r43, false, 4, null);
        if (r45 <= 0) goto L169;
        r43 = r44.b.length() + r45;
        r39.setSpan(new c(r9.a, r44, false, this.i), r45, r44.b.length() + r45, 33);
        goto L164
    L169:
        if (r43 == (-1)) goto L178;
        if (r43 >= (r39.length() - 1)) goto L178;
        int r46 = StringsKt.lastIndexOf$default(r39, '+', 0, false, 6, null);
        if (r46 != (-1)) goto L175;
        r39.setSpan(new c(r9.a, r44, false, this.i), r43 + 1, r39.length() - 1, 33);
        goto L178
    L175:
        int r47 = r46 - 1;
        if (r43 >= r47) goto L178;
        r39.setSpan(new c(r9.a, r44, false, this.i), r43 + 1, r47, 33);
    L178:
        if (r34 == null) goto L182;
        int r48 = StringsKt.indexOf$default(r39, r34, 0, false, 6, null);
        if (r48 == (-1)) goto L182;
        r39.setSpan(new c(r9.a, null, true, this.i), r48 + 1, r48 + r34.length(), 33);
    L182:
        r4 = r35;
        r6 = r39;
    L198:
        setupBackgroundSpan(r6);
        SpannableStringBuilder r49 = r211;
        r49.append(r6);
        r12 = r38;
        r8 = r49;
        r3 = r18;
        r10 = r210;
        r13 = r212;
        goto L16
    L151:
        r36 = new SpannableString(r11 + '|' + r33);
        goto L152
    L66:
        float r50 = r30;
        float r51 = r15 - r50;
        if (r28 <= r51) goto L69;
    L77:
        if (r27 != null) goto L79;
    L82:
        boolean r52 = true;
    L83:
        if (r52 == false) goto L87;
        int r53 = 1;
        if (r9.c.size() <= 1) goto L88;
        r27 = v2c.a.e(getContext(), String.valueOf(r9.b));
    L88:
        String r54 = r27;
        if (r9.c.size() <= r53) goto L94;
        String r55 = String.valueOf(r9.b);
        StringBuilder r56 = new StringBuilder();
        int r57 = r55.length();
        int r58 = 0;
    L91:
        if (r58 >= r57) goto L93;
        r56.append("8");
        r58 = r58 + 1;
        goto L91
    L93:
        String r59 = v2c.a.e(getContext(), r56.toString());
    L95:
        if (r59 == null) goto L97;
        float r60 = getPaint().measureText(r59);
    L98:
        float r61 = (r15 - r60) - r50;
        float r62 = r111;
        CharSequence r63 = TextUtils.ellipsize(r31, getPaint(), (r61 - r62) - q, TextUtils.TruncateAt.END);
        if (r9.c.size() <= 1) goto L101;
    L103:
        Iterator r64 = r9.c.iterator();
        int r65 = 0;
        int r310 = 0;
    L105:
        if (r64.hasNext() == false) goto L139;
        int r66 = r65 + 1;
        q2c.d r67 = (q2c.d) r64.next();
        Intrinsics.checkNotNull(r63);
        Iterator r112 = r64;
        int r68 = StringsKt.indexOf$default(r63, r67.b, r310, false, 4, null);
        r310 = (r67.b.length() + r68) - 1;
        if (r68 == (-1)) goto L108;
        r64 = r112;
        r65 = r66;
        goto L105
    L108:
        int r69 = r9.b - r65;
        Intrinsics.checkNotNull(r63);
        if (r63.length() <= 0) goto L111;
        boolean r70 = true;
    L112:
        if (r70 == true) goto L114;
    L137:
        r212 = r13;
    L141:
        if (this.a == false) goto L144;
        if (r69 != 0) goto L144;
        r69 = r69 + (r9.b - r9.c.size());
    L144:
        if (r69 <= 0) goto L146;
        String r71 = v2c.a.e(getContext(), String.valueOf(r69));
        String r72 = r71;
        String r73 = r63 + r71;
    L147:
        r32 = new Pair(r73, r72);
        goto L148
    L146:
        r73 = TextUtils.ellipsize(r31, getPaint(), (r51 - r62) - q, TextUtils.TruncateAt.END).toString();
        r27 = null;
    L76:
        r72 = r27;
        goto L147
    L114:
        if (r13.length() <= 0) goto L116;
        boolean r74 = true;
    L117:
        if (r74 == false) goto L137;
        if (r63.length() < (r13.length() + 1)) goto L137;
        if (Intrinsics.areEqual(r13, r63.subSequence((r63.length() - 1) - r13.length(), r63.length() - 1)) == false) goto L123;
        r69 = r9.b - r65;
        Intrinsics.checkNotNull(r63);
        r63 = StringsKt.removeRange(r63, (r63.length() - 1) - r13.length(), r63.length() - 1);
    L123:
        if (r65 <= 0) goto L137;
        q2c.d r75 = (q2c.d) ListProtector.get(r9.c, r65 - 1);
        if (r75 == null) goto L128;
        String r76 = r75.b;
        if (r76 == null) goto L128;
    L130:
        if (r76.length() <= 0) goto L132;
        boolean r77 = true;
    L133:
        if (r77 == false) goto L137;
        Intrinsics.checkNotNull(r63);
        r212 = r13;
        if (StringsKt.endsWith$default(r63, r76.concat("…"), false, 2, null) == true) goto L141;
        r69 = r69 - 1;
        goto L141
    L132:
        r77 = false;
    L128:
        r76 = r5;
        goto L130
    L116:
        r74 = false;
        goto L117
    L111:
        r70 = false;
        goto L112
    L139:
        r212 = r13;
        r69 = 0;
        goto L141
    L101:
        if (z(r9) == true) goto L103;
        r32 = new Pair(r63.toString(), r54);
        goto L65
    L97:
        r60 = 0.0f;
        goto L98
    L94:
        r59 = r54;
        goto L95
    L87:
        r53 = 1;
        goto L88
    L79:
        if (r27.length() == 0) goto L82;
        r52 = false;
        goto L83
    L69:
        if (this.a == true) goto L77;
        StringBuilder r78 = new StringBuilder();
        r78.append(r31);
        if (r27 != null) goto L74;
        String r79 = "";
    L75:
        r78.append(r79);
        r73 = r78.toString();
        r212 = r13;
        goto L76
    L74:
        r79 = r27;
        goto L75
    L61:
        r29 = false;
        goto L62
    L55:
        r26 = getPaint().measureText((String) r110.getFirst()) + (q + r22);
        r25 = null;
    L50:
        if (z(r9) == true) goto L51;
        r24 = false;
        goto L53
    L29:
        StringBuilder r80 = new StringBuilder();
        Iterator r81 = r9.c.iterator();
        int r214 = 0;
        int r82 = 0;
    L31:
        if (r81.hasNext() == false) goto L39;
        int r113 = r82 + 1;
        Iterator r215 = r81;
        r80.append(((q2c.d) r81.next()).b);
        int r83 = r214 + 1;
        r23 = r8;
        if (r83 == this.j) goto L34;
        if (r82 >= (r9.c.size() - 1)) goto L38;
        r80.append(r13);
    L38:
        r214 = r83;
        r82 = r113;
        r8 = r23;
        r81 = r215;
        goto L31
    L34:
        r214 = r83;
    L41:
        if (z(r9) == false) goto L43;
        r80.append("...");
        String r84 = r80.toString();
    L44:
        r110 = new Pair(r84, Integer.valueOf(r214));
        goto L46
    L43:
        r84 = r80.toString();
        goto L44
    L39:
        r23 = r8;
    L25:
        r22 = p;
        goto L26
    L183:
        r211 = r8;
        r210 = r10;
        r38 = r12;
        r212 = r13;
        if ((r7 instanceof q2c.a) == false) goto L198;
        if (r3 != 0) goto L188;
        boolean r85 = true;
    L189:
        r4 = x(0, 0.0f, r4, r15, r7, r14, r85, r211);
        if (this.f == false) goto L196;
        r6 = new SpannableString("[ExtendIcon]");
        Drawable r86 = ((q2c.a) r7).a;
        if (r86 == null) goto L198;
        if (this.h == null) goto L198;
        Intrinsics.checkNotNull(r86);
        ReactionFlowLayout.e r87 = this.h;
        Intrinsics.checkNotNull(r87);
        r6.setSpan(new com.ss.android.lark.reaction.widget.flowlayout.reaction.c(r87, r86), r6.length() - 12, r6.length(), 18);
        goto L198
    L196:
        r6 = r6;
        goto L198
    L188:
        r85 = false;
        goto L189
    L199:
        Pair r88 = new Pair(r8, Boolean.valueOf(r17));
        StringBuilder r89 = new StringBuilder("getSpanableResult cost:");
        r89.append(System.currentTimeMillis() - r10);
        Log.d(r12, r89.toString());
        if (((Boolean) r88.getSecond()).booleanValue() == false) goto L202;
        ViewGroup.LayoutParams r90 = getLayoutParams();
        r90.width = getMaxWidth();
        setLayoutParams(r90);
    L202:
        this.l = false;
        setText((CharSequence) r88.getFirst());
    }

    public final void setReactionResourceLoader(com.ss.android.lark.reaction.widget.flowlayout.reaction.e r3) {
        Intrinsics.checkNotNullParameter(r3, "loader");
        Log.i("ReactionView", "setReactionResourceLoader: " + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSeparatorWidth(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (q == r2) goto L9;
        q = r2;
        B(getContext(), true);
        return;
    }

    public final void setShownNamesNumberLimit(int r1) {
        this.j = r1;
    }

    public final void setTapAnimationEnabled(boolean r1) {
        this.k = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean y(int r3) {
        if ((getLayout().getLineBottom(r3) - getLayout().getLineBaseline(r3)) >= getLineSpacingExtra()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean z(q2c.c r4) {
        List<q2c.d> r0 = r4.c;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.a == true) goto L8;
        return false;
    L8:
        if (r0.size() >= r4.b) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReactionTextView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        this.b = new ArrayList();
        this.j = 12;
        this.k = true;
        int r1 = v2c.a.a(r9, 5.0f);
        this.m = r1;
        if (o != (-1)) goto L6;
        o = v2c.a.a(r9, 20.0f);
    L6:
        if (p != (-1)) goto L9;
        p = v2c.a.a(r9, 20.0f);
    L9:
        if (q != (-1)) goto L12;
        q = v2c.a.a(r9, 14.5f);
    L12:
        if (r != (-1)) goto L15;
        r = v2c.a.a(r9, 0.5f);
    L15:
        if (s != (-1)) goto L18;
        s = v2c.a.a(r9, 5.0f);
    L18:
        if (t != (-1)) goto L21;
        t = v2c.a.a(r9, 2.0f);
    L21:
        if (v != (-1)) goto L24;
        v = v2c.a.a(r9, 1.0f);
    L24:
        if (u != (-1)) goto L27;
        u = v2c.a.a(r9, 7.0f);
    L27:
        if (w != (-1)) goto L30;
        w = v2c.a.a(r9, 3.0f);
    L30:
        if (x != null) goto L34;
        ShapeDrawable r0 = new ShapeDrawable();
        x = r0;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
        float[] r6 = new float[8];
        ArraysKt.fill(r6, 100.0f, 0, 8);
        r0.setShape(new RoundRectShape(r6, null, null));
        Drawable r2 = x;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
        Paint r3 = ((ShapeDrawable) r2).getPaint();
        if (r3 == null) goto L34;
        r3.setColor(167772160);
    L34:
        this.d = x;
        B(r9, false);
        getPaint().setAntiAlias(true);
        setHighlightColor(0);
        if (com.ss.android.lark.reaction.widget.flowlayout.reaction.b.a != null) goto L37;
        com.ss.android.lark.reaction.widget.flowlayout.reaction.b.a = new com.ss.android.lark.reaction.widget.flowlayout.reaction.b();
    L37:
        setMovementMethod(com.ss.android.lark.reaction.widget.flowlayout.reaction.b.a);
        setLineSpacing(r1, 1.0f);
        setPadding(getPaddingLeft() + u, getPaddingTop(), getPaddingRight() + u, getPaddingBottom());
    }

    public final void B(Context r8, boolean r9) {
        if (y == null) goto L5;
        if (r9 == true) goto L5;
        return;
    L5:
        Bitmap r10 = Bitmap.createBitmap(q, p, Bitmap.Config.ARGB_8888);
        Canvas r6 = new Canvas(r10);
        Paint r5 = new Paint(1);
        Integer r0 = this.c;
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
    L9:
        r5.setColor(r1);
        r5.setStrokeWidth(1.0f);
        float r3 = (q - r) / 2.0f;
        r6.drawLine(r3, s, r3, p - t, r5);
        r6.save();
        BitmapDrawable r2 = new BitmapDrawable(r8.getResources(), r10);
        y = r2;
        r2.setBounds(0, 0, q, p);
        return;
    L8:
        r1 = v2c.a.b(r8, 2131103353);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (getMeasuredHeight() > 0) goto L5;
        return;
    L5:
        if (getLineCount() > 0) goto L8;
        return;
    L8:
        if (y(getLineCount() - 1) == false) goto L12;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + ((int) getLineSpacingExtra()));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int x(int r7, float r8, int r9, float r10, q2c.b r11, float r12, boolean r13, SpannableStringBuilder r14) {
        int r3 = 0;
        if ((r11 instanceof q2c.c) == false) goto L23;
        float r0 = r9;
        if (((r8 + r0) + r12) <= r10) goto L19;
        q2c.c r15 = (q2c.c) r11;
        if ((!r15.c.isEmpty()) == false) goto L9;
        String r16 = ((q2c.d) ListProtector.get(r15.c, 0)).b;
    L10:
        StringBuilder r5 = new StringBuilder(r16);
        if (r15.c.size() <= 1) goto L13;
        r5.append(v2c.a.e(getContext(), String.valueOf(r15.c.size() - 1)));
    L13:
        float r17 = (getPaint().measureText(r5.toString()) + r7) + q;
        if (r0 <= (r10 / 2)) goto L16;
    L17:
        if (r13 == true) goto L19;
        r14.append("\n");
        r9 = 0;
        r3 = 1;
        goto L19
    L16:
        if (r17 <= ((r10 - r0) - r12)) goto L19;
    L9:
        r16 = "";
    L19:
        if (r3 != 0) goto L36;
        if (r13 == true) goto L37;
        r14.append("       ");
        return r9 + ((int) r12);
    L37:
        return r9;
    L36:
        return r9;
    L23:
        if ((r11 instanceof q2c.a) == false) goto L39;
        Drawable r18 = ((q2c.a) r11).a;
        if (r18 != null) goto L28;
        return r9;
    L28:
        if (r18.getIntrinsicHeight() == 0) goto L31;
        r3 = (r18.getIntrinsicWidth() / r18.getIntrinsicHeight()) * p;
    L31:
        if (r3 <= ((r10 - r9) - r12)) goto L33;
        r14.append("\n");
        return r9;
    L33:
        if (r13 == true) goto L41;
        r14.append("       ");
        return r9 + ((int) r12);
    L41:
        return r9;
    L39:
        return r9;
    }
}
