package lc;

import ac.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.cae.R;
import com.obric.oui.layout.OUIFrameLayout;
import he.i;
import j0.r;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class f extends OUIFrameLayout {
    public Drawable A;
    public boolean B;
    public boolean C;
    public float D;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f9218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f9219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f9220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f9221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f9222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f9223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ConstraintLayout f9224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f9225x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f9226y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f9227z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f9228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9229b;

        public a(View r8, f r10, boolean r11) {
            this.f9228a = r10;
            this.f9229b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r8 = this.f9229b;
            int r10 = R.color.oui_line_2;
            f r11 = this.f9228a;
            if (r8 == false) goto L5;
            int r12 = r11.getMClContent().getLeft();
            int r13 = android.aimedia.a.a("Resources.getSystem()", 1, (float) 0.6d);
            r10 = r11.getResources().getColor(R.color.oui_line_2);
            h r14 = r11.f6340o;
        L6:
            r14.H(r12, r13, r10);
            return;
        L5:
            r12 = r11.getMClContent().getLeft();
            r14 = r11.f6340o;
            r13 = 0;
            goto L6
        }
    }

    public f(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0, 12);
        b();
        ViewParent r11 = (ViewGroup) findViewById(R.id.ll_root);
        if (r11 != null) goto L6;
    L8:
        r11 = null;
    L9:
        ac.a r12 = (ac.a) r11;
        if (r12 == null) goto L12;
        r12.setChangeAlphaWhenPress(false);
    L12:
        View r13 = findViewById(R.id.fl_leading_element);
        i.e(r13, "findViewById(R.id.fl_leading_element)");
        this.f9218q = (FrameLayout) r13;
        View r14 = findViewById(R.id.fl_trailing_element);
        i.e(r14, "findViewById(R.id.fl_trailing_element)");
        this.f9219r = (FrameLayout) r14;
        View r15 = findViewById(R.id.fl_content_element);
        i.e(r15, "findViewById(R.id.fl_content_element)");
        this.f9220s = (FrameLayout) r15;
        View r16 = findViewById(R.id.iv_content_img);
        i.e(r16, "findViewById(R.id.iv_content_img)");
        this.f9221t = (ImageView) r16;
        View r17 = findViewById(R.id.cl_content_container);
        i.e(r17, "findViewById(R.id.cl_content_container)");
        this.f9224w = (ConstraintLayout) r17;
        View r18 = findViewById(R.id.tv_content_title);
        i.e(r18, "findViewById(R.id.tv_content_title)");
        this.f9222u = (TextView) r18;
        View r19 = findViewById(R.id.tv_content_subtitle);
        i.e(r19, "findViewById(R.id.tv_content_subtitle)");
        this.f9223v = (TextView) r19;
        TypedArray r20 = r8.obtainStyledAttributes(r10, nb.a.f9499m);
        setTitleString(r20.getString(5));
        setSubTitleString(r20.getString(4));
        setTrailingImage(r20.getDrawable(6));
        setContentImage(r20.getDrawable(0));
        setShowPreDefineBackground(r20.getBoolean(2, true));
        setShowDivider(r20.getBoolean(3, false));
        setMContentElementWidth(r20.getDimension(1, 0.0f));
        r20.recycle();
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r11 instanceof ac.a) == false) goto L8;
        goto L8
    }

    public static void h(FrameLayout r8, View r10, ViewGroup.LayoutParams r11) {
        if (r10 == null) goto L12;
        if (r8 == null) goto L5;
        bc.a.c(r8);
    L5:
        if (r8 == null) goto L7;
        r8.removeAllViews();
    L7:
        if (r11 != null) goto L10;
        if (r8 == null) goto L15;
        r8.addView(r10);
        return;
    L15:
        return;
    L10:
        if (r8 == null) goto L17;
        r8.addView(r10, r11);
        return;
    L17:
        return;
    L12:
        if (r8 == null) goto L19;
        bc.a.b(r8);
        return;
    }

    public void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_general, this);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r8);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, ac.b
    public final boolean f() {
        return true;
    }

    public int getContentDefaultOneChildWidth() {
        return l6.a.I0(getResources().getDimension(R.dimen.oui_listitem_content_width_middle));
    }

    public final Drawable getContentImage() {
        return this.f9227z;
    }

    public final ConstraintLayout getMClContent() {
        ConstraintLayout r8 = this.f9224w;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mClContent");
        throw null;
    }

    public final FrameLayout getMContentElement() {
        FrameLayout r8 = this.f9220s;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mContentElement");
        throw null;
    }

    public final float getMContentElementWidth() {
        return this.D;
    }

    public final ImageView getMIvContent() {
        ImageView r8 = this.f9221t;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mIvContent");
        throw null;
    }

    public final FrameLayout getMLeadingElement() {
        FrameLayout r8 = this.f9218q;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mLeadingElement");
        throw null;
    }

    public final FrameLayout getMTrailingElement() {
        FrameLayout r8 = this.f9219r;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mTrailingElement");
        throw null;
    }

    public final TextView getMTvSubtitle() {
        TextView r8 = this.f9223v;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mTvSubtitle");
        throw null;
    }

    public final TextView getMTvTitle() {
        TextView r8 = this.f9222u;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("mTvTitle");
        throw null;
    }

    public final boolean getShowBackground() {
        return this.B;
    }

    public final boolean getShowDivider() {
        return this.C;
    }

    public final boolean getShowPreDefineBackground() {
        return this.B;
    }

    public final CharSequence getSubTitleString() {
        return this.f9226y;
    }

    public final CharSequence getTitleString() {
        return this.f9225x;
    }

    public final Drawable getTrailingImage() {
        return this.A;
    }

    public final void i() {
        FrameLayout r8 = this.f9220s;
        if (r8 == null) goto L28;
        int r10 = r8.getChildCount();
        boolean r11 = false;
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L10;
        View r13 = r8.getChildAt(r12);
        i.e(r13, "child");
        if (r13.getVisibility() == 0) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        r11 = true;
    L10:
        FrameLayout r14 = this.f9220s;
        if (r11 == false) goto L16;
        if (r14 == null) goto L14;
        int r15 = getContentDefaultOneChildWidth();
    L18:
        defpackage.c.k0(r14, r15);
        float r16 = this.D;
        if (r16 == 0.0f) goto L25;
        FrameLayout r17 = this.f9220s;
        if (r17 == null) goto L23;
        defpackage.c.k0(r17, (int) r16);
        return;
    L23:
        i.j("mContentElement");
        throw null;
    L25:
        return;
    L14:
        i.j("mContentElement");
        throw null;
    L16:
        if (r14 == null) goto L26;
        r15 = l6.a.I0(getResources().getDimension(R.dimen.oui_listitem_content_width_empty));
        goto L18
    L26:
        i.j("mContentElement");
        throw null;
    L28:
        i.j("mContentElement");
        throw null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        setShowDivider(this.C);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r8, int r10, int r11, int r12) {
        super.onSizeChanged(r8, r10, r11, r12);
    }

    public final void setAlpha(boolean r8) {
        if (r8 == true) goto L4;
        float r10 = 0.3f;
    L5:
        setAlpha(r10);
        return;
    L4:
        r10 = 1.0f;
        goto L5
    }

    public final void setContentImage(Drawable r8) {
        this.f9227z = r8;
        if (r8 == null) goto L17;
        ImageView r10 = this.f9221t;
        if (r10 == null) goto L15;
        r10.setImageDrawable(r8);
        ImageView r11 = this.f9221t;
        if (r11 == null) goto L13;
        r11.setVisibility(0);
        FrameLayout r12 = this.f9220s;
        if (r12 == null) goto L11;
        r12.setVisibility(0);
    L20:
        i();
        return;
    L11:
        i.j("mContentElement");
        throw null;
    L13:
        i.j("mIvContent");
        throw null;
    L15:
        i.j("mIvContent");
        throw null;
    L17:
        ImageView r13 = this.f9221t;
        if (r13 == null) goto L22;
        r13.setVisibility(8);
        goto L20
    L22:
        i.j("mIvContent");
        throw null;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        if (r8 == false) goto L17;
        FrameLayout r10 = this.f9218q;
        if (r10 == null) goto L15;
        float r11 = 1.0f;
        r10.setAlpha(1.0f);
        ConstraintLayout r12 = this.f9224w;
        if (r12 == null) goto L13;
        r12.setAlpha(1.0f);
        FrameLayout r13 = this.f9220s;
        if (r13 != null) goto L23;
        i.j("mContentElement");
        throw null;
    L23:
        r13.setAlpha(r11);
        return;
    L13:
        i.j("mClContent");
        throw null;
    L15:
        i.j("mLeadingElement");
        throw null;
    L17:
        FrameLayout r14 = this.f9218q;
        if (r14 == null) goto L29;
        r11 = 0.3f;
        r14.setAlpha(0.3f);
        ConstraintLayout r15 = this.f9224w;
        if (r15 == null) goto L27;
        r15.setAlpha(0.3f);
        r13 = this.f9220s;
        if (r13 != null) goto L23;
        i.j("mContentElement");
        throw null;
    L27:
        i.j("mClContent");
        throw null;
    L29:
        i.j("mLeadingElement");
        throw null;
    }

    public final void setLeadingView(View r8) {
        if (r8 == null) goto L8;
        FrameLayout r10 = this.f9218q;
        if (r10 == null) goto L6;
        h(r10, r8, null);
        return;
    L6:
        i.j("mLeadingElement");
        throw null;
    }

    public final void setMClContent(ConstraintLayout r8) {
        i.f(r8, "<set-?>");
        this.f9224w = r8;
    }

    public final void setMContentElement(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f9220s = r8;
    }

    public final void setMContentElementWidth(float r8) {
        this.D = r8;
        if (r8 == 0.0f) goto L9;
        FrameLayout r10 = this.f9220s;
        if (r10 == null) goto L7;
        defpackage.c.k0(r10, (int) r8);
        return;
    L7:
        i.j("mContentElement");
        throw null;
    }

    public final void setMIvContent(ImageView r8) {
        i.f(r8, "<set-?>");
        this.f9221t = r8;
    }

    public final void setMLeadingElement(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f9218q = r8;
    }

    public final void setMTrailingElement(FrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f9219r = r8;
    }

    public final void setMTvSubtitle(TextView r8) {
        i.f(r8, "<set-?>");
        this.f9223v = r8;
    }

    public final void setMTvTitle(TextView r8) {
        i.f(r8, "<set-?>");
        this.f9222u = r8;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r8) {
        super.setSelected(r8);
        getAlphaHelper().d(this, r8);
    }

    public final void setShowBackground(boolean r8) {
        setShowPreDefineBackground(r8);
    }

    public final void setShowDivider(boolean r8) {
        this.C = r8;
        r.a(this, new a(this, this, r8));
    }

    public final void setShowPreDefineBackground(boolean r8) {
        this.B = r8;
        if (getBackground() != null) goto L9;
        ColorDrawable r10 = null;
        if (r8 == false) goto L7;
        r10 = new ColorDrawable(getResources().getColor(R.color.oui_fill_list_item_card, null));
    L7:
        setBackground(r10);
        return;
    }

    public final void setSubTitleString(CharSequence r8) {
        this.f9226y = r8;
        if (TextUtils.isEmpty(r8) == false) goto L9;
        TextView r10 = this.f9223v;
        if (r10 == null) goto L7;
        bc.a.b(r10);
        return;
    L7:
        i.j("mTvSubtitle");
        throw null;
    L9:
        TextView r11 = this.f9223v;
        if (r11 == null) goto L17;
        bc.a.c(r11);
        TextView r12 = this.f9223v;
        if (r12 == null) goto L15;
        r12.setText(this.f9226y);
        return;
    L15:
        i.j("mTvSubtitle");
        throw null;
    L17:
        i.j("mTvSubtitle");
        throw null;
    }

    public final void setTitleString(CharSequence r8) {
        this.f9225x = r8;
        TextView r10 = this.f9222u;
        if (r10 == null) goto L6;
        r10.setText(r8);
        return;
    L6:
        i.j("mTvTitle");
        throw null;
    }

    public final void setTrailingImage(Drawable r8) {
        this.A = r8;
        setTrailingImageView(r8);
    }

    public final void setTrailingImageView(Drawable r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        ImageView r10 = new ImageView(getContext());
        r10.setImageDrawable(r8);
        j r11 = j.f13877a;
        setTrailingView(r10);
    }

    public final void setTrailingView(View r8) {
        if (r8 == null) goto L8;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 8388629;
        FrameLayout r11 = this.f9219r;
        if (r11 == null) goto L6;
        h(r11, r8, r10);
        return;
    L6:
        i.j("mTrailingElement");
        throw null;
    }
}
