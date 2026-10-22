package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0004\u001a\u00020\u0003R:\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/opt/ScrollTitleIndicator;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "", "update", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "k", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "", "l", "I", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "currentPos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollTitleIndicator extends RelativeLayout implements IIndicatorView {
    public final LinearLayout a;
    public final HorizontalScrollView b;
    public final LinearLayout c;
    public final ImageView d;
    public final List<GalleryTitleItemView> e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public int j;
    public List<String> k;
    public int l;
    public boolean m;

    public static final class a implements View.OnTouchListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r10) {
            return true;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ GalleryTitleItemView a;
        public final /* synthetic */ ScrollTitleIndicator b;

        public b(GalleryTitleItemView r1, ScrollTitleIndicator r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            ScrollTitleIndicator r0 = this.b;
            r0.b(r0.getCurrentPos(), 0.0f, 0);
            if (this.b.getCurrentPos() <= 0) goto L6;
            ViewGroup.LayoutParams r1 = this.b.c.getLayoutParams();
            r1.width = this.b.a(this.a.getWidth(), this.b.getCurrentPos());
            ScrollTitleIndicator r10 = this.b;
            r1.height = this.a.getHeight() + (r10.i * 2);
            this.b.c.setLayoutParams(r1);
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

    public ScrollTitleIndicator(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ScrollTitleIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "adapter");
    }

    public final void onTransitionChanged(int r1, float r10) {
    }

    public final void update() {
        if (this.m == false) goto L8;
        GalleryTitleItemView r0 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.e, this.l);
        if (r0 == null) goto L7;
        post(new b(r0, this));
    L7:
        this.m = false;
    L8:
        this.c.setVisibility(0);
        if (this.l != 0) goto L11;
        this.c.setBackgroundResource(2131234780);
        this.d.setVisibility(8);
    L12:
        Iterator<T> r1 = this.e.iterator();
    L14:
        if (r1.hasNext() == false) goto L16;
        ((GalleryTitleItemView) r1.next()).setCheckPos(this.l);
        goto L14
    L16:
        return;
    L11:
        this.c.setBackgroundResource(2131234779);
        this.d.setVisibility(0);
        goto L12
    }

    public final int getCurrentPos() {
        return this.l;
    }

    public final List<String> getData() {
        return this.k;
    }

    public final void onPageSelected(int r1) {
        setCurrentPos(r1);
    }

    public final void onTransitionBegin(int r10) {
        if (r10 != 0) goto L4;
    L7:
        setVisibility(8);
        return;
    L4:
        if (r10 == 3) goto L7;
        if (r10 == 2) goto L7;
    }

    public final void onTransitionEnd(int r10) {
        boolean r0 = true;
        if (r10 == 0) goto L5;
        if (r10 == 1) goto L5;
        return;
    L5:
        List<String> r11 = this.k;
        if (r11 != null) goto L8;
    L11:
        if (r0 == true) goto L15;
        setVisibility(0);
        return;
    L15:
        return;
    L8:
        if (r11.isEmpty() == true) goto L11;
        r0 = false;
        goto L11
    }

    public final void setCurrentPos(int r1) {
        this.l = r1;
        update();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, android.widget.TextView, com.bytedance.android.ec.core.gallery2.opt.GalleryTitleItemView, java.lang.Object] */
    public final void setData(List<String> r10) {
        this.k = r10;
        this.j = UIUtils.getScreenWidth(getContext());
        List<String> r11 = this.k;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        setVisibility(8);
        return;
    L11:
        setVisibility(0);
        this.a.removeAllViews();
        LinearLayout r13 = this.a;
        FrameLayout r1 = new FrameLayout(getContext());
        r1.setLayoutParams(new RelativeLayout.LayoutParams(this.j / 2, 0));
        Unit r14 = Unit.INSTANCE;
        r13.addView(r1);
        List<String> r15 = this.k;
        if (r15 == null) goto L27;
        Iterator<T> r16 = r15.iterator();
        int r17 = 0;
    L15:
        if (r16.hasNext() == false) goto L27;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        String r20 = (String) r18;
        ViewGroup.LayoutParams r21 = null;
        ?? r22 = new GalleryTitleItemView(getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r20, "title");
        r22.a = r17;
        r22.setText(r20);
        r22.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.ec.core.gallery2.opt.a(r22));
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r21 = r23;
    L23:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r21;
        if (r24 == null) goto L26;
        r24.leftMargin = vf4.a.b(Integer.valueOf(this.f));
        r22.setLayoutParams(r24);
    L26:
        this.a.addView(r22);
        ((ArrayList) this.e).add(r22);
        r17 = r19;
    L27:
        LinearLayout r25 = this.a;
        FrameLayout r26 = new FrameLayout(getContext());
        r26.setLayoutParams(new RelativeLayout.LayoutParams(this.j / 2, 0));
        Unit r0 = Unit.INSTANCE;
        r25.addView(r26);
        return;
    L5:
        if (r11.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }

    public final int a(int r1, int r10) {
        if (r10 != 0) goto L4;
        int r11 = this.h * 2;
    L6:
        return r1 + r11;
    L4:
        r1 = r1 + this.g;
        r11 = this.h;
        goto L6
    }

    public final void onAttach(int r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r10, r11);
    }

    public final void onDetach(int r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r10, r11);
    }

    public ScrollTitleIndicator(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.e = new ArrayList();
        this.f = vf4.a.b(40);
        this.g = vf4.a.b(40);
        int r13 = vf4.a.b(16);
        this.h = r13;
        this.i = vf4.a.b(10);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        r0.bottomMargin = vf4.a.b(34);
        r0.gravity = 80;
        Unit r14 = Unit.INSTANCE;
        setLayoutParams(r0);
        setMinimumHeight(vf4.a.b(120));
        LinearLayout r1 = new LinearLayout(r10);
        RelativeLayout.LayoutParams r15 = new RelativeLayout.LayoutParams(-2, -2);
        r15.addRule(13);
        r1.setLayoutParams(r15);
        r1.setPadding(r13, 0, r13, 0);
        r1.setBackgroundResource(2131234779);
        r1.setOrientation(0);
        ImageView r16 = new ImageView(r10);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(vf4.a.b(16), vf4.a.b(16));
        r17.gravity = 8388627;
        r16.setLayoutParams(r17);
        r16.setBackgroundResource(2131234781);
        this.d = r16;
        r1.addView(r16);
        r1.setVisibility(8);
        this.c = r1;
        addView(r1);
        HorizontalScrollView r18 = new HorizontalScrollView(r10);
        RelativeLayout.LayoutParams r19 = new RelativeLayout.LayoutParams(-1, -2);
        r19.addRule(13);
        r18.setLayoutParams(r19);
        r18.setHorizontalScrollBarEnabled(false);
        r18.setPadding(0, vf4.a.b(8), 0, vf4.a.b(8));
        this.b = r18;
        LinearLayout r110 = new LinearLayout(r10);
        ViewGroup.MarginLayoutParams r20 = new ViewGroup.MarginLayoutParams(-1, -2);
        r110.setGravity(17);
        r110.setLayoutParams(r20);
        this.a = r110;
        r110.setOrientation(0);
        r18.addView(r110);
        r18.setOnTouchListener(a.a);
        addView(r18);
        this.m = true;
    }

    public final void b(int r17, float r18, int r19) {
        int r10 = this.j;
        if (r10 <= 0) goto L5;
        float r11 = r18 / r10;
    L6:
        int r12 = this.f;
        int r13 = this.h;
        float r14 = r13;
        float r15 = (r12 + r13) - (r14 * r11);
        int r16 = this.g;
        float r20 = (r12 + r16) - ((r16 - r13) * r11);
        float r21 = r12;
        if (r17 == 1) goto L10;
        r14 = r16;
    L10:
        float r22 = r21 + (r14 * r11);
        int r23 = this.a.getPaddingLeft();
        int r24 = this.a.getPaddingLeft();
        int r25 = Math.min(((ArrayList) this.e).size(), r17 + 2);
        int r110 = 0;
    L11:
        AppCompatTextView r111 = null;
        if (r110 >= r25) goto L41;
        AppCompatTextView r112 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.e, r110);
        if (r112 == null) goto L40;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r113 = null;
    L18:
        AppCompatTextView r114 = (ViewGroup.MarginLayoutParams) r113;
        if (r114 == null) goto L39;
        int r115 = r17 - 1;
        if (r110 != r115) goto L24;
        if (r110 == 0) goto L30;
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = (int) r22;
    L30:
        if (r110 >= r17) goto L36;
        int r116 = r112.getWidth();
        int r117 = ((ViewGroup.MarginLayoutParams) r114).leftMargin;
        r23 = r23 + (r116 + r117);
        if (r110 == r115) goto L35;
        r117 = r112.getWidth() + ((ViewGroup.MarginLayoutParams) r114).leftMargin;
    L35:
        r24 = r24 + r117;
    L38:
        Unit r118 = Unit.INSTANCE;
        r111 = r114;
        goto L39
    L36:
        if (r110 != r17) goto L38;
        r23 = r23 + ((ViewGroup.MarginLayoutParams) r114).leftMargin;
        goto L38
    L24:
        if (r110 != r17) goto L27;
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = (int) r20;
        goto L30
    L27:
        if (r110 != (r17 + 1)) goto L29;
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = (int) r15;
        goto L30
    L29:
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = this.f;
    L39:
        r112.setLayoutParams(r111);
    L40:
        r110 = r110 + 1;
        goto L11
    L41:
        AppCompatTextView r26 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.e, r17);
        if (r17 <= 0) goto L44;
        r111 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.e, r17 - 1);
    L44:
        if (r26 != null) goto L47;
        return;
    L47:
        if (r17 <= 0) goto L49;
        int r27 = ((this.b.getWidth() / 2) + vf4.a.b(12)) + (-(r23 + (r26.getWidth() / 2)));
    L50:
        if (r17 <= 1) goto L53;
        if (r111 == null) goto L56;
        int r28 = (this.b.getWidth() / 2) + vf4.a.b(12);
        int r29 = r111.getWidth() / 2;
    L55:
        int r30 = r28 - (r24 + r29);
    L57:
        this.b.smoothScrollTo((int) ((this.j / 2) - (r27 + ((r30 - r27) * r11))), 0);
        int r31 = r17 - 1;
        AppCompatTextView r32 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.e, r31);
        AppCompatTextView r33 = (GalleryTitleItemView) CollectionsKt.getOrNull(this.e, r17);
        if (r33 == null) goto L75;
        float r34 = 0.0f;
        if (r11 != 0.0f) goto L63;
        r34 = a(r33.getWidth(), r17);
        float r1 = r33.getHeight() + (this.i * 2);
    L70:
        ViewGroup.LayoutParams r35 = this.c.getLayoutParams();
        r35.width = (int) r34;
        r35.height = (int) r1;
        this.c.setLayoutParams(r35);
        return;
    L63:
        if (r19 <= 0) goto L66;
        if (r32 == null) goto L66;
        float r36 = 1 - r11;
        r34 = a(r32.getWidth(), r31) + ((a(r33.getWidth(), r17) - a(r32.getWidth(), r31)) * r36);
        r1 = (r32.getHeight() + (this.i * 2)) + (((r33.getHeight() + (this.i * 2)) - (r32.getHeight() + (this.i * 2))) * r36);
    L66:
        if (r19 >= 0) goto L69;
        if (r32 == null) goto L69;
        r34 = a(r33.getWidth(), r17) + ((a(r32.getWidth(), r31) - a(r33.getWidth(), r17)) * r11);
        r1 = (r33.getHeight() + (this.i * 2)) + (((r32.getHeight() + (this.i * 2)) - (r33.getHeight() + (this.i * 2))) * r11);
    L69:
        r1 = 0.0f;
        goto L70
    L75:
        return;
    L56:
        r30 = r27;
        goto L57
    L53:
        if (r111 == null) goto L56;
        r28 = this.b.getWidth() / 2;
        r29 = r111.getWidth() / 2;
        goto L55
    L49:
        r27 = (this.b.getWidth() / 2) - (r23 + (r26.getWidth() / 2));
        goto L50
    L5:
        r11 = 1.0f;
        goto L6
    }

    public /* synthetic */ ScrollTitleIndicator(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
