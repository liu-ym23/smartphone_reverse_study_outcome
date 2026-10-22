package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.d;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import u8.c;
import u8.e;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "use CardListItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "", "<set-?>", "s", "Lkotlin/properties/ReadWriteProperty;", "getActive", "()Z", "setActive", "(Z)V", "active", "Landroid/app/Activity;", EventBody.KEY_VALUE, "getDropdownActivity", "()Landroid/app/Activity;", "setDropdownActivity", "(Landroid/app/Activity;)V", "dropdownActivity", "Landroid/widget/ImageView;", "q", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "p", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class ODropdownTrigger extends OUILinearLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f6528u = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f6529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f6530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f6531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f6532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final TextView f6533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ImageView f6534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ODropdown f6535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ReadWriteProperty f6536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private WeakReference<Activity> f6537t;

    public static final class a extends ObservableProperty<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f6538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ODropdownTrigger f6539b;

        public a(Object r10, ODropdownTrigger r11) {
            this.f6538a = r10;
            this.f6539b = r11;
            super(r10);
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> r10, Boolean r11, Boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "property");
            boolean r13 = r12.booleanValue();
            if (r11.booleanValue() == r13) goto L11;
            ODropdownTrigger r14 = this.f6539b;
            if (r13 == false) goto L8;
            r14.d();
            return;
        L8:
            r14.c();
            return;
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ODropdownTrigger f6540c;

        b(ODropdownTrigger r10) {
            this.f6540c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6540c.b();
        }
    }

    static {
        f6528u = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ODropdownTrigger.class, "active", "getActive()Z", 0))};
    }

    @JvmOverloads
    public ODropdownTrigger(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public ODropdownTrigger(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public ODropdownTrigger(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        Delegates r13 = Delegates.INSTANCE;
        this.f6536s = new a(Boolean.FALSE, this);
        if ((r10 instanceof Activity) == false) goto L5;
        setDropdownActivity((Activity) r10);
    L5:
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(r11, l.ODropdownTrigger, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r14, "context.theme.obtainStyl…           0, 0\n        )");
        this.f6529l = r14.getColor(l.ODropdownTrigger_oui_backgroundOff, getResources().getColor(c.oui_fill_element_2, r10.getTheme()));
        this.f6530m = r14.getColor(l.ODropdownTrigger_oui_backgroundOn, getResources().getColor(c.oui_fill_active, r10.getTheme()));
        this.f6531n = r14.getResourceId(l.ODropdownTrigger_oui_iconOff, e.dropdown_default_off);
        this.f6532o = r14.getResourceId(l.ODropdownTrigger_oui_iconOn, e.dropdown_default_on);
        OBaseTextView r15 = new OBaseTextView(new ContextThemeWrapper(r10, r14.getResourceId(l.ODropdownTrigger_oui_textStyle, k.ODropdownTriggerText)), null, 0, 6, null);
        this.f6533p = r15;
        addView(r15);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(r15.getLayoutParams());
        r16.weight = 1.0f;
        int r17 = l.ODropdownTrigger_oui_midMargin;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        r16.rightMargin = r14.getDimensionPixelOffset(r17, MathKt.roundToInt(TypedValue.applyDimension(1, 0, r18.getDisplayMetrics())));
        r15.setLayoutParams(r16);
        ImageView r19 = new ImageView(new ContextThemeWrapper(r10, r14.getResourceId(l.ODropdownTrigger_oui_imageStyle, k.ODropdownTriggerIcon)));
        this.f6534q = r19;
        addView(r19);
        c();
        setOnClickListener(new b(this));
    }

    public /* synthetic */ ODropdownTrigger(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public void b() {
        if (getDropdownActivity() != null) goto L6;
        d.c(d.f6398b, "ODropdownTrigger", "no activity for popup showing", null, 4, null);
        return;
    L6:
        Activity r10 = getDropdownActivity();
        if (r10 == null) goto L13;
        ODropdown r11 = this.f6535r;
        if (r11 == null) goto L11;
        ODropdown.DefaultImpls.a(r11, this, r10, null, new ODropdownTrigger$showPopup$$inlined$let$lambda$1(this), 4, null);
        Unit r12 = Unit.INSTANCE;
    L11:
        setActive(true);
        return;
    }

    public void c() {
        this.f6534q.setImageResource(this.f6531n);
        setBackgroundColor(this.f6529l);
    }

    public void d() {
        this.f6534q.setImageResource(this.f6532o);
        setBackgroundColor(this.f6530m);
    }

    public final boolean getActive() {
        return ((Boolean) this.f6536s.getValue(this, f6528u[0])).booleanValue();
    }

    public final Activity getDropdownActivity() {
        WeakReference<Activity> r10 = this.f6537t;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("reference");
    L6:
        return r10.get();
    }

    protected final ImageView getIcon() {
        return this.f6534q;
    }

    public final TextView getValue() {
        return this.f6533p;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setActive(boolean r10) {
        this.f6536s.setValue(this, f6528u[0], Boolean.valueOf(r10));
    }

    public final void setDropdownActivity(Activity r10) {
        this.f6537t = new WeakReference(r10);
    }
}
