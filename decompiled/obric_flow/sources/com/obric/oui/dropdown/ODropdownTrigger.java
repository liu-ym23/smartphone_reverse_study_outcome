package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", "value", "Landroid/widget/ImageView;", "m", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "", "<set-?>", "n", "Lkotlin/properties/ReadWriteProperty;", "getActive", "()Z", "setActive", "(Z)V", Constant.ClientMessageType.ACTIVE, "Landroid/app/Activity;", "getDropdownActivity", "()Landroid/app/Activity;", "setDropdownActivity", "(Landroid/app/Activity;)V", "dropdownActivity", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODropdownTrigger extends OUILinearLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f13185p = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13189k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OBaseTextView f13190l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f13191m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f13192n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference f13193o;

    static {
        f13185p = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ODropdownTrigger.class, Constant.ClientMessageType.ACTIVE, "getActive()Z", 0))};
    }

    @JvmOverloads
    public ODropdownTrigger(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getActive() {
        KProperty<?> r5 = f13185p[0];
        return ((Boolean) this.f13192n.getValue(this, r5)).booleanValue();
    }

    public final Activity getDropdownActivity() {
        WeakReference r5 = this.f13193o;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("reference");
        r5 = null;
    L6:
        return (Activity) r5.get();
    }

    public final ImageView getIcon() {
        return this.f13191m;
    }

    public final TextView getValue() {
        return this.f13190l;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    public final void setActive(boolean r5) {
        KProperty<?> r10 = f13185p[0];
        Boolean r11 = Boolean.valueOf(r5);
        this.f13192n.setValue(this, r10, r11);
    }

    public final void setDropdownActivity(Activity r5) {
        this.f13193o = new WeakReference(r5);
    }

    @JvmOverloads
    public ODropdownTrigger(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ODropdownTrigger(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ODropdownTrigger(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 8);
        Delegates r13 = Delegates.INSTANCE;
        this.f13192n = new b(this);
        if ((r10 instanceof Activity) == false) goto L5;
        setDropdownActivity((Activity) r10);
    L5:
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.ODropdownTrigger, 0, 0);
        int r15 = r14.getColor(R$styleable.ODropdownTrigger_oui_backgroundOff, getResources().getColor(R$color.oui_fill_element_2, r10.getTheme()));
        this.f13186h = r15;
        this.f13187i = r14.getColor(R$styleable.ODropdownTrigger_oui_backgroundOn, getResources().getColor(R$color.oui_fill_active, r10.getTheme()));
        int r5 = r14.getResourceId(R$styleable.ODropdownTrigger_oui_iconOff, R$drawable.dropdown_default_off);
        this.f13188j = r5;
        this.f13189k = r14.getResourceId(R$styleable.ODropdownTrigger_oui_iconOn, R$drawable.dropdown_default_on);
        OBaseTextView r16 = new OBaseTextView(new ContextThemeWrapper(r10, r14.getResourceId(R$styleable.ODropdownTrigger_oui_textStyle, R$style.ODropdownTriggerText)), null, 6, 0);
        this.f13190l = r16;
        addView(r16);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(r16.getLayoutParams());
        r17.weight = 1.0f;
        r17.rightMargin = r14.getDimensionPixelOffset(R$styleable.ODropdownTrigger_oui_midMargin, com.lynx.tasm.utils.a.B(0, this));
        r16.setLayoutParams(r17);
        ImageView r18 = new ImageView(new ContextThemeWrapper(r10, r14.getResourceId(R$styleable.ODropdownTrigger_oui_imageStyle, R$style.ODropdownTriggerIcon)));
        this.f13191m = r18;
        addView(r18);
        r18.setImageResource(r5);
        setBackgroundColor(r15);
        setOnClickListener(new ar.a(this, 16));
    }
}
