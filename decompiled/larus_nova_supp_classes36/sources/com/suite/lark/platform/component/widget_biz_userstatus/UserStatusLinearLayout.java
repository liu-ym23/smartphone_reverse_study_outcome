package com.suite.lark.platform.component.widget_biz_userstatus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import hpc.b;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class UserStatusLinearLayout extends LinearLayout {
    public ImageView a;
    public UserStatusTextView b;
    public String c;

    public class a implements LinkEmojiTextView.i {
        public final /* synthetic */ LinkEmojiTextView.i a;
        public final /* synthetic */ UserStatusLinearLayout b;

        public a(UserStatusLinearLayout r1, LinkEmojiTextView.i r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void a(View r2, String r3) {
            LinkEmojiTextView.i r0 = this.a;
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            ipc.a r4 = b.a();
            this.b.getClass();
            r4.a();
            return;
        }

        public final boolean b(View r2, String r3) {
            LinkEmojiTextView.i r0 = this.a;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.b(r2, r3) == false) goto L7;
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View, android.widget.TextView, com.suite.lark.platform.component.widget_biz_userstatus.UserStatusTextView] */
    public final void a() {
        LinearLayout r0 = new LinearLayout(getContext());
        ViewGroup.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -1);
        r0.setGravity(16);
        r0.setOrientation(0);
        addView(r0, r1);
        ImageView r2 = new ImageView(getContext());
        r2.setId(2131376297);
        r2.setImageTintList(getContext().getResources().getColorStateList(2131103353));
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, UIUtils.dp2px(getContext(), 12.0f));
        r3.rightMargin = UIUtils.dp2px(getContext(), 6.0f);
        r3.topMargin = UIUtils.dp2px(getContext(), 1.0f);
        r0.addView(r2, r3);
        ?? r4 = new UserStatusTextView(getContext());
        r4.setId(2131390479);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r4.setEllipsize(TextUtils.TruncateAt.END);
        r4.setMaxLines(1);
        r4.setSingleLine(true);
        r4.setTextColor(UIUtils.getColor(getContext(), 2131106620));
        r0.addView(r4, r5);
        this.a = (ImageView) findViewById(2131376297);
        UserStatusTextView r6 = (UserStatusTextView) findViewById(2131390479);
        this.b = r6;
        r6.setUrlTextColor(getResources().getColor(2131106616));
        this.b.setPhoneTextColor(getResources().getColor(2131106616));
        this.c = "";
        setTextSize(12);
    }

    public int getMaxLines() {
        return this.b.getMaxLines();
    }

    @Override // android.view.View
    public int getMinimumWidth() {
        return Math.max(super.getMinimumWidth(), this.a.getMeasuredWidth());
    }

    public String getUserStatus() {
        return this.c;
    }

    public UserStatusLinearLayout(Context r1) {
        super(r1);
        a();
    }

    public void setDividerDrawableColor(int r3) {
        this.a.setImageTintList(getContext().getResources().getColorStateList(r3));
    }

    public void setIconGravity(int r2) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.a.getLayoutParams();
        r0.gravity = r2;
        this.a.setLayoutParams(r0);
    }

    public void setIconVisibility(int r2) {
        this.a.setVisibility(r2);
    }

    public void setMaxLines(int r2) {
        this.b.setMaxLines(r2);
    }

    public void setNeedToRecognize(boolean r2) {
        this.b.setNeedToRecognize(r2);
    }

    public void setOnPhoneClickListener(LinkEmojiTextView.h r2) {
        this.b.setPhoneStringClickListener(r2);
    }

    public void setOnURLClickListener(LinkEmojiTextView.i r3) {
        this.b.setUrlStringClickListner(new a(this, r3));
    }

    public void setRecognizeTextColor(int r2) {
        this.b.setPhoneTextColor(r2);
        this.b.setUrlTextColor(r2);
    }

    public void setShowArrow(boolean r2) {
        this.b.setShowArrow(r2);
    }

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
    public void setTextColor(int r2) {
        this.b.setTextColor(r2);
    }

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
    public void setTextMaxWidth(int r2) {
        this.b.setMaxWidth(r2);
    }

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
    public void setTextSize(int r4) {
        float r1 = r4;
        this.b.setTextSize(r1);
        this.b.setEmojiconSize(UIUtils.dp2px(getContext(), r1));
        this.b.setMinHeight(UIUtils.dp2px(getContext(), r4 + 2));
    }

    public void setUrlOrPhoneColor(int r2) {
        this.b.setUrlTextColor(r2);
        this.b.setPhoneTextColor(r2);
    }

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
    public void setWidth(int r2) {
        this.b.setWidth(r2);
    }

    public UserStatusLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public UserStatusLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }

    public final void b(String r5, String r6, Drawable r7, boolean r8, String r9, Long r10) {
        new WeakReference(this.b);
        String r11 = r6 + r5 + 10;
        if (r10 != null) goto L5;
    L7:
        f0 r12 = f0.a.a;
        RecogniseSpansResult r13 = r12.a(r11);
        if (TextUtils.isEmpty(r5) == false) goto L10;
        this.b.H(r5, null, r8, r11);
    L13:
        this.a.setImageDrawable(r7);
        this.c = r5;
        return;
    L10:
        if (r13 != null) goto L12;
        this.b.H(r5, r12.a(r5), r8, r11);
        b.a().b();
        goto L13
    L12:
        this.b.H(r5, r13, r8, r11);
        goto L13
    L5:
        if (r10.longValue() <= 0) goto L7;
        r11 = r11 + "_" + r10;
        goto L7
    }
}
