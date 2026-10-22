package com.suite.lark.platform.component.widget_biz_fileview;

import acc.d;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.a0;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class FileView extends ConstraintLayout {
    public Guideline a;
    public Guideline b;
    public FileNameView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public LKUIRoundedImageView h;
    public LKUIRoundedImageView i;
    public ProgressBar j;
    public View k;
    public LinearLayout l;
    public View m;
    public View n;
    public Guideline o;
    public View p;
    public b q;
    public c r;

    public static class FileState {
        public int a;
        public final String b;

        @Retention(RetentionPolicy.SOURCE)
        public @interface FileStateType {
            public static final int COMPRESSING = 4;
            public static final int DONE = 6;
            public static final int DOWNLOAD = 1;
            public static final int DOWNLOADING = 2;
            public static final int PAUSE = 5;
            public static final int UPLOADING = 3;
        }

        public FileState(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
        public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
        public static final ReceiveAuthorizationState NORMAL_STATE = null;
        public static final ReceiveAuthorizationState UNKNOWN = null;
        public static final /* synthetic */ ReceiveAuthorizationState[] a = null;

        static {
            ReceiveAuthorizationState r0 = new ReceiveAuthorizationState("UNKNOWN", 0);
            UNKNOWN = r0;
            ReceiveAuthorizationState r1 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1);
            MIDDLE_AUTHORIZATION_STATE = r1;
            ReceiveAuthorizationState r3 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2);
            FINAL_AUTHORIZATION_STATE_PASS = r3;
            ReceiveAuthorizationState r5 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3);
            FINAL_AUTHORIZATION_STATE_DENY = r5;
            ReceiveAuthorizationState r7 = new ReceiveAuthorizationState("NORMAL_STATE", 4);
            NORMAL_STATE = r7;
            a = new ReceiveAuthorizationState[]{r0, r1, r3, r5, r7};
        }

        public static ReceiveAuthorizationState[] values() {
            return (ReceiveAuthorizationState[]) a.clone();
        }

        public static ReceiveAuthorizationState valueOf(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return UNKNOWN;
        L14:
            return NORMAL_STATE;
        L16:
            return FINAL_AUTHORIZATION_STATE_DENY;
        L18:
            return FINAL_AUTHORIZATION_STATE_PASS;
        L20:
            return MIDDLE_AUTHORIZATION_STATE;
        L22:
            return UNKNOWN;
        }

        public static ReceiveAuthorizationState valueOf(String r1) {
            return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r1);
        }

        public ReceiveAuthorizationState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReceiveAuthorizationState.values().length];
            a = r0;
            r0[ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class b {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final String g;
        public final FileState h;
        public final String i;
        public final long j;
        public final int k;
        public final long l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final String q;
        public final int r;
        public final ResourceCleanScene s;
        public final String t;

        public b(boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, String r13, FileState r14, String r15, long r16, int r18, long r19, boolean r21, String r22, int r23, ResourceCleanScene r24, String r25) {
            this.a = r4;
            this.m = r5;
            this.n = r6;
            this.b = r7;
            this.c = r8;
            this.d = r9;
            this.e = r10;
            this.f = r11;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r18;
            this.p = r12;
            this.l = r19;
            this.o = r21;
            this.q = r22;
            this.r = r23;
            this.s = r24;
            this.t = r25;
        }
    }

    public static class c {
        public c() {
        }

        public void a() {
        }

        public void b(b r1) {
        }

        public void c(b r1) {
            throw null;
        }

        public void d(b r1) {
            throw null;
        }
    }

    public final void S5() {
        zz7.a.a(this.i, 16);
        TextView r0 = this.d;
        LarkFont r1 = LarkFont.CAPTION0;
        zz7.a.d(r0, r1);
        zz7.a.d(this.g, r1);
        zz7.a.d(this.f, r1);
        zz7.a.d(this.e, r1);
        zz7.a.d(this.c, LarkFont.HEADLINE);
        zz7.a.a(this.k, 20);
        zz7.a.b(this.h, 36, 36);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        ResourceType r1 = ResourceType.FILE;
        b r2 = this.q;
        d r0 = new d(r1, r2.s, acc.a.d(r2.t));
        acc.a.f(getContext(), r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        Context r0 = getContext();
        int r1 = UIUtils.dp2px(r0, 12.0f);
        this.o.getLayoutParams().guideBegin = UIUtils.dp2px(r0, 11.0f);
        this.a.getLayoutParams().guideBegin = r1;
        this.b.getLayoutParams().guideEnd = r1;
    }

    public LKUIRoundedImageView getFileIconView() {
        return this.h;
    }

    public FileView(Context r2) {
        this(r2, null);
    }

    public void setBottomMargin(boolean r2) {
        if (r2 == false) goto L4;
        this.n.setVisibility(0);
        return;
    L4:
        this.n.setVisibility(8);
    }

    public void setCallback(c r1) {
        this.r = r1;
    }

    public void setFileSizeVisibility(boolean r2) {
        if (r2 == false) goto L4;
        this.g.setGravity(8388613);
        this.d.setVisibility(0);
        return;
    L4:
        this.g.setGravity(8388611);
        this.d.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setInfo(b r10) {
        this.q = r10;
        if (r10 == null) goto L97;
        ReceiveAuthorizationState r0 = ReceiveAuthorizationState.valueOf(r10.r);
        int[] r1 = a.a;
        int r2 = r1[r0.ordinal()];
        boolean r3 = false;
        if (r2 == 1) goto L8;
        if (r2 == 2) goto L8;
        boolean r4 = false;
    L9:
        b r5 = this.q;
        if (r5.m == true) goto L12;
    L19:
        UIUtils.hide(this.e);
        UIUtils.hide(this.i);
        UIUtils.show(this.d);
        if (this.q.a == false) goto L22;
        UIUtils.show(this.f);
    L23:
        b r11 = this.q;
        if (r11.h.a != 3) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        this.j.setProgress(r11.k);
        UIUtils.show(this.j);
    L30:
        b r12 = this.q;
        if (r12.e == false) goto L34;
        this.g.setVisibility(0);
        this.g.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        this.g.setText(UIUtils.getString(getContext(), 2131891433));
    L44:
        if (this.q.p == false) goto L48;
        if (r4 == true) goto L48;
        this.c.setTextColor(UIUtils.getColor(getContext(), 2131106622));
    L49:
        b r13 = this.q;
        StringBuilder r7 = new StringBuilder(FileUtils.h(r13.j));
        int r8 = r1[ReceiveAuthorizationState.valueOf(r13.r).ordinal()];
        if (r8 == 1) goto L53;
        if (r8 == 2) goto L53;
        boolean r9 = false;
    L54:
        if (r9 == false) goto L59;
        r7 = new StringBuilder(UIHelper.getString(2131891419));
        if (ReceiveAuthorizationState.valueOf(this.q.r) != ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L59;
        r7 = new StringBuilder(UIHelper.getString(2131891244));
    L59:
        if (r13.p == true) goto L62;
        if (r9 == true) goto L62;
        r7 = new StringBuilder(UIHelper.getString(2131891415));
    L68:
        boolean r14 = false;
    L69:
        if (r14 == false) goto L72;
        r7.append(" ");
        r7.append(FileUtils.h(r13.l));
        r7.append("/s");
    L72:
        if (TextUtils.isEmpty(r13.q) == true) goto L74;
        r7.append(" ");
        r7.append(r13.q);
    L74:
        SpannableStringBuilder r15 = new SpannableStringBuilder(r7);
        if (r9 == false) goto L77;
    L78:
        r3 = true;
    L80:
        if (r13.s == null) goto L83;
        if (r3 == true) goto L83;
        String r16 = UIUtils.getString(getContext(), 2131891116);
        int r17 = UIUtils.getColor(getContext(), 2131102078);
        r15.append("  ").append(r16);
        r15.setSpan(new ForegroundColorSpan(r17), r15.length() - r16.length(), r15.length(), 18);
    L83:
        this.d.setText(r15);
    L84:
        this.c.setText(this.q.i);
        b r18 = this.q;
        if (r18.o == false) goto L87;
        this.c.setEllipsize(TextUtils.TruncateAt.END);
    L88:
        b r19 = this.q;
        if (r19.o == false) goto L91;
        this.h.setImageResource(a0.c(r19.g, r19.i, true));
        return;
    L91:
        String r110 = r19.i;
        if (TextUtils.isEmpty(r110) == false) goto L94;
        String r20 = this.q.g;
    L95:
        this.h.setImageResource(a0.b(r20, r110, 1));
        return;
    L94:
        r20 = null;
        goto L95
    L87:
        String r111 = FileUtils.m(r18.i);
        this.c.setTailContent(r111);
        goto L88
    L77:
        if (r13.p == true) goto L80;
    L62:
        int r21 = r13.h.a;
        if (r21 != 3) goto L65;
        r7.append(" ");
        r7.append(UIUtils.getString(getContext(), 2131892307));
    L67:
        r14 = true;
        goto L69
    L65:
        if (r21 != 2) goto L68;
        r7.append(" ");
        r7.append(UIUtils.getString(getContext(), 2131891738));
    L53:
        r9 = true;
    L48:
        this.c.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        goto L49
    L34:
        if (r12.b == false) goto L37;
        this.g.setVisibility(0);
        this.g.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        this.g.setText(UIUtils.getString(getContext(), 2131891757));
        goto L44
    L37:
        if (r12.c == false) goto L39;
    L42:
        this.g.setVisibility(0);
        this.g.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        this.g.setText(UIUtils.getString(getContext(), 2131890328));
        goto L44
    L39:
        if (r12.d == true) goto L42;
        this.g.setVisibility(8);
        this.g.setTextColor(UIUtils.getColor(getContext(), 2131105548));
        this.g.setText(this.q.h.b);
        goto L44
    L29:
        UIUtils.hide(this.j);
        goto L30
    L26:
        r6 = false;
        goto L27
    L22:
        UIUtils.hide(this.f);
        goto L23
    L12:
        if (r5.p == false) goto L19;
        if (r4 == true) goto L19;
        UIUtils.show(this.e);
        UIUtils.show(this.i);
        UIUtils.hide(this.d);
        UIUtils.hide(this.f);
        UIUtils.hide(this.j);
        TextView r22 = this.e;
        if (r10.n == false) goto L17;
        int r112 = 2131892394;
    L18:
        r22.setText(r112);
        goto L84
    L17:
        r112 = 2131892392;
    L8:
        r4 = true;
        goto L9
    }

    public void setTopBorderColor(int r2) {
        this.p.setBackgroundColor(r2);
    }

    public void setTopBorderVisibility(boolean r2) {
        View r0 = this.p;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public FileView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v42, types: [android.widget.TextView, com.suite.lark.platform.component.widget_biz_fileview.FileNameView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public FileView(Context r17, AttributeSet r18, int r19) {
        super(r17, r18, r19);
        Guideline r2 = new Guideline(r17);
        this.a = r2;
        r2.setId(2131377772);
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(-2, -2);
        r3.orientation = 1;
        addView(this.a, r3);
        Guideline r4 = new Guideline(r17);
        this.b = r4;
        r4.setId(2131384582);
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(-2, -2);
        r5.orientation = 1;
        addView(this.b, r5);
        Guideline r6 = new Guideline(r17);
        this.o = r6;
        r6.setId(2131389155);
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-2, -2);
        r7.orientation = 0;
        r7.topToTop = 0;
        addView(this.o, r7);
        ProgressBar r8 = new ProgressBar(r17, null, R.attr.progressBarStyleHorizontal);
        this.j = r8;
        r8.setId(2131383334);
        this.j.setProgressDrawable(UIUtils.getDrawable(r17, 2131235384));
        ConstraintLayout.LayoutParams r9 = xbc.b.a(0.0f, 3.0f);
        r9.bottomToBottom = 0;
        r9.startToStart = 0;
        r9.endToEnd = 0;
        addView(this.j, r9);
        Barrier r10 = new Barrier(r17);
        r10.setId(2131372410);
        r10.setType(3);
        r10.setDpMargin(4);
        r10.setReferencedIds(new int[]{2131390623});
        addView(r10);
        TextView r11 = new TextView(r17);
        this.d = r11;
        r11.setId(2131390624);
        this.d.setTextColor(UIUtils.getColor(r17, 2131106620));
        this.d.setTextSize(12.0f);
        this.d.setMaxLines(2);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-2, -2);
        r12.topToBottom = 2131372410;
        r12.startToStart = 2131390623;
        r12.endToStart = 2131390625;
        r12.constrainedWidth = true;
        addView(this.d, r12);
        Space r13 = new Space(r17);
        r13.setId(2131390625);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, 1);
        r14.startToEnd = 2131390624;
        r14.endToStart = 2131390626;
        r14.constrainedWidth = true;
        r14.matchConstraintMinWidth = 1;
        addView(r13, r14);
        TextView r15 = new TextView(r17);
        this.g = r15;
        r15.setId(2131390626);
        this.g.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.g.setSingleLine(true);
        this.g.setTextColor(UIUtils.getColor(r17, 2131105548));
        this.g.setTextSize(12.0f);
        this.g.setGravity(8388613);
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) r16).leftMargin = y9c.d.b(r17, 2.0f);
        r16.topToBottom = 2131372410;
        r16.endToStart = 2131390668;
        r16.startToEnd = 2131390625;
        r16.constrainedWidth = true;
        r16.goneStartMargin = 0;
        addView(this.g, r16);
        TextView r20 = new TextView(r17);
        this.f = r20;
        r20.setId(2131390668);
        this.f.setText(2131891740);
        this.f.setGravity(8388613);
        this.f.setTextColor(UIUtils.getColor(r17, 2131106620));
        this.f.setTextSize(12.0f);
        ConstraintLayout.LayoutParams r21 = new ConstraintLayout.LayoutParams(0, -2);
        r21.topToBottom = 2131372410;
        r21.endToStart = 2131364726;
        addView(this.f, r21);
        View r22 = new View(r17);
        r22.setVisibility(4);
        ConstraintLayout.LayoutParams r23 = xbc.b.a(-1.0f, 1.0f);
        r23.topToBottom = 0;
        r23.startToStart = 2131377772;
        r23.endToEnd = 2131384582;
        addView(r22, r23);
        View r24 = new View(r17);
        this.k = r24;
        r24.setId(2131364726);
        this.k.setBackgroundResource(2131254123);
        this.k.setBackgroundTintList(ColorStateList.valueOf(UDColorUtils.getColor(r17, 2131102418)));
        this.k.setVisibility(8);
        ConstraintLayout.LayoutParams r25 = xbc.b.a(20.0f, 20.0f);
        r25.topToBottom = 2131372410;
        r25.endToEnd = 2131384582;
        addView(this.k, r25);
        LKUIRoundedImageView r26 = new LKUIRoundedImageView(r17);
        this.h = r26;
        r26.setId(2131374983);
        this.h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.h.setOval(false);
        ConstraintLayout.LayoutParams r27 = xbc.b.a(36.0f, 36.0f);
        r27.startToStart = 2131377772;
        r27.topToTop = this.o.getId();
        addView(this.h, r27);
        ?? r28 = new FileNameView(r17);
        this.c = r28;
        r28.setId(2131390623);
        this.c.setMaxLines(3);
        this.c.setLineSpacing(2.5f, 1.0f);
        this.c.setTextColor(UIUtils.getColor(r17, 2131106622));
        this.c.setTextSize(17.0f);
        this.c.setIncludeFontPadding(false);
        ConstraintLayout.LayoutParams r29 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r29).leftMargin = y9c.d.b(r17, 8.0f);
        r29.topToTop = this.o.getId();
        r29.startToEnd = 2131374983;
        r29.endToEnd = 2131384582;
        addView(this.c, r29);
        TextView r30 = new TextView(r17);
        this.e = r30;
        r30.setId(2131377111);
        this.e.setMaxLines(3);
        this.e.setTextColor(UIUtils.getColor(r17, 2131106620));
        this.e.setTextSize(12.0f);
        ConstraintLayout.LayoutParams r31 = new ConstraintLayout.LayoutParams(0, -2);
        r31.topToBottom = 2131372410;
        r31.startToStart = 2131390623;
        r31.endToEnd = 2131384582;
        addView(this.e, r31);
        LKUIRoundedImageView r32 = new LKUIRoundedImageView(r17);
        this.i = r32;
        r32.setId(2131377110);
        this.i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.i.setOval(false);
        this.i.setImageResource(2131235934);
        ConstraintLayout.LayoutParams r33 = xbc.b.a(16.0f, 16.0f);
        r33.endToEnd = 2131374983;
        r33.bottomToBottom = 2131374983;
        addView(this.i, r33);
        Barrier r34 = new Barrier(r17);
        r34.setId(2131382901);
        r34.setReferencedIds(new int[]{2131374983, 2131390623, 2131390624, 2131390626, 2131390668, 2131377111});
        r34.setAllowsGoneWidget(false);
        r34.setType(3);
        addView(r34);
        LinearLayout r35 = new LinearLayout(r17);
        this.l = r35;
        r35.setId(2131382912);
        ConstraintLayout.LayoutParams r36 = new ConstraintLayout.LayoutParams(0, -2);
        r36.startToStart = 2131377772;
        r36.endToEnd = 2131384582;
        r36.topToBottom = 2131382901;
        ((ViewGroup.MarginLayoutParams) r36).topMargin = y9c.d.b(r17, 12.0f);
        addView(this.l, r36);
        View r37 = new View(r17);
        this.m = r37;
        r37.setId(2131382937);
        ConstraintLayout.LayoutParams r38 = new ConstraintLayout.LayoutParams(0, 0);
        r38.startToStart = 2131382912;
        r38.endToEnd = 2131382912;
        r38.topToTop = 2131382912;
        r38.bottomToBottom = 2131382912;
        addView(this.m, r38);
        Space r39 = new Space(r17);
        this.n = r39;
        r39.setId(2131364525);
        ConstraintLayout.LayoutParams r40 = new ConstraintLayout.LayoutParams(0, y9c.d.b(r17, 12.0f));
        r40.topToBottom = 2131382912;
        r40.startToStart = 2131377772;
        r40.endToEnd = 2131384582;
        addView(this.n, r40);
        this.p = new View(r17);
        ConstraintLayout.LayoutParams r41 = new ConstraintLayout.LayoutParams(0, y9c.d.b(r17, 1.0f));
        r41.topToTop = 0;
        r41.startToStart = 0;
        r41.endToEnd = 0;
        addView(this.p, r41);
        R5();
        setOnClickListener(new bpc.a(this));
        this.m.setOnClickListener(new bpc.b(this));
        this.m.setOnLongClickListener(new bpc.c(this));
        this.k.setOnClickListener(new com.suite.lark.platform.component.widget_biz_fileview.a(this));
    }
}
