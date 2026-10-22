package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextToggle;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRestoring", "", "()Z", "setRestoring", "(Z)V", "setEnabled", "", "enabled", "subTextView", "Landroid/widget/TextView;", "getSubTextView", "()Landroid/widget/TextView;", "toggleView", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "getToggleView", "()Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "init", "setImageSrc", "resId", "setSubText", ShareType.TEXT, "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextToggle extends ItemTextView {
    public boolean c;
    public final TextView d;
    public final CustomSwitchCompat e;

    /* JADX WARN: Multi-variable type inference failed */
    private final void T5() {
        SwitchCompat r0 = this.e;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, i5.C());
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, r1);
        TextView r2 = this.d;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(0, -2);
        r3.topToBottom = getTextView().getId();
        r3.bottomToBottom = 0;
        r3.startToEnd = getImageView().getId();
        r3.verticalBias = 0.0f;
        boolean r5 = true;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        r3.setMarginStart(i5.q());
        r3.setMarginEnd(0);
    L10:
        if (this.e.getVisibility() != 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        r3.endToStart = this.e.getId();
    L16:
        this.d.setVisibility(8);
        addView(r2, r3);
        TextView r8 = getTextView();
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(0, -2);
        r9.topToTop = 0;
        r9.bottomToTop = this.d.getId();
        r9.startToEnd = getImageView().getId();
        if (getImageView().getVisibility() != 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L22;
        r9.setMarginStart(i5.q());
        r9.setMarginEnd(0);
    L24:
        if (this.e.getVisibility() != 0) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L29;
        r9.endToStart = this.e.getId();
    L30:
        r8.setLayoutParams(r9);
        ConstraintLayout.LayoutParams r12 = getTextView().getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L33;
        ConstraintLayout.LayoutParams r13 = r12;
    L34:
        if (r13 == null) goto L44;
        ((ViewGroup.MarginLayoutParams) r13).width = 0;
        r13.topToTop = 0;
        r13.bottomToBottom = 0;
        r13.startToEnd = getImageView().getId();
        r13.endToStart = this.e.getId();
        if (getImageView().getVisibility() == 0) goto L39;
        r5 = false;
    L39:
        if (r5 == false) goto L41;
        r13.setMarginStart(i5.q());
        r13.setMarginEnd(i5.q());
        r13.setMarginEnd(0);
    L42:
        getTextView().setGravity(8388611);
        return;
    L41:
        r13.setMarginStart(0);
        r13.setMarginEnd(0);
        goto L42
    L44:
        return;
    L33:
        r13 = null;
        goto L34
    L29:
        r9.endToEnd = 0;
        goto L30
    L26:
        r11 = false;
        goto L27
    L22:
        r9.setMarginStart(0);
        r9.setMarginEnd(0);
        goto L24
    L19:
        r10 = false;
        goto L20
    L15:
        r3.endToEnd = 0;
        goto L16
    L12:
        r7 = false;
        goto L13
    L8:
        r3.setMarginStart(0);
        r3.setMarginEnd(0);
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    public final TextView getSubTextView() {
        return this.d;
    }

    public final CustomSwitchCompat getToggleView() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.CompoundButton, androidx.appcompat.widget.SwitchCompat, com.larus.bmhome.view.item.CustomSwitchCompat] */
    public ItemTextToggle(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392531);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), c.b(2130972081, r6.getContext(), 2131103143)));
        r6.setTextSize(0, i5.k());
        r6.setGravity(16);
        this.d = r6;
        ?? r7 = new CustomSwitchCompat(getContext(), null);
        r7.setId(ViewGroup.generateViewId());
        r7.setChecked(true);
        r7.setThumbResource(2131239770);
        r7.setTrackResource(c.b(2130970849, r7.getContext(), 2131239772));
        this.e = r7;
        T5();
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
    @Override // com.larus.bmhome.view.item.ItemTextView
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.e.setEnabled(r2);
    }

    @Override // com.larus.bmhome.view.item.ItemTextView
    public void setImageSrc(int r3) {
        super.setImageSrc(r3);
        ViewGroup.LayoutParams r4 = this.d.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r5.setMarginStart(i5.q());
        r5.setMarginEnd(0);
    L9:
        this.d.setLayoutParams(r5);
        return;
    L8:
        r5.setMarginStart(0);
        r5.setMarginEnd(0);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final void setRestoring(boolean r1) {
        this.c = r1;
    }

    public final void setSubText(CharSequence r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        this.d.setText(r3);
        this.d.setVisibility(0);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.CompoundButton, androidx.appcompat.widget.SwitchCompat, com.larus.bmhome.view.item.CustomSwitchCompat] */
    public ItemTextToggle(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        super(r4, r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392531);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), c.b(2130972081, r6.getContext(), 2131103143)));
        r6.setTextSize(0, i5.k());
        r6.setGravity(16);
        this.d = r6;
        ?? r7 = new CustomSwitchCompat(getContext(), null);
        r7.setId(ViewGroup.generateViewId());
        r7.setChecked(true);
        r7.setThumbResource(2131239770);
        r7.setTrackResource(c.b(2130970849, r7.getContext(), 2131239772));
        this.e = r7;
        T5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.CompoundButton, androidx.appcompat.widget.SwitchCompat, com.larus.bmhome.view.item.CustomSwitchCompat] */
    public ItemTextToggle(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "attrs");
        super(r3, r4, r5);
        TextView r6 = new TextView(getContext());
        r6.setId(2131392531);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), c.b(2130972081, r6.getContext(), 2131103143)));
        r6.setTextSize(0, i5.k());
        r6.setGravity(16);
        this.d = r6;
        ?? r7 = new CustomSwitchCompat(getContext(), null);
        r7.setId(ViewGroup.generateViewId());
        r7.setChecked(true);
        r7.setThumbResource(2131239770);
        r7.setTrackResource(c.b(2130970849, r7.getContext(), 2131239772));
        this.e = r7;
        T5();
    }
}
