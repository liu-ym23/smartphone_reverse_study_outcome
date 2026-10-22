package com.obric.oui.dropdown;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.f;
import com.obric.oui.common.util.h;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use CardListItem")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J0\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0018\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u0014@BX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170$X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/obric/oui/dropdown/ODropdownTrigger;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "active$delegate", "Lkotlin/properties/ReadWriteProperty;", "backgroundOff", "backgroundOn", "Lcom/obric/oui/dropdown/ODropdown;", "dropdown", EventBody.KEY_VALUE, "Landroid/app/Activity;", "dropdownActivity", "getDropdownActivity", "()Landroid/app/Activity;", "setDropdownActivity", "(Landroid/app/Activity;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconOff", "iconOn", "reference", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "getValue", "()Landroid/widget/TextView;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "popup", "defaultValue", "", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "showPopup", "turnOff", "turnOn", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODropdownTrigger extends OUILinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f13839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13840b;
    private final int c;
    private final int d;
    private final int e;
    private final TextView f;
    private final ImageView g;
    private b h;
    private final ReadWriteProperty i;
    private WeakReference<Activity> j;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ObservableProperty<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODropdownTrigger f13841a;

        public a(Object r1, ODropdownTrigger r2) {
            this.f13841a = r2;
            super(r1);
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty<?> r3, Boolean r4, Boolean r5) {
            Intrinsics.checkNotNullParameter((KProperty) ZeusTransformUtils.wrapperContextForParams(r3, KProperty.class, "com.obric.memorydata.plugin"), "property");
            boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == r6) goto L11;
            ODropdownTrigger r2 = this.f13841a;
            if (r6 == false) goto L8;
            r2.b();
            return;
        L8:
            r2.c();
            return;
        }
    }

    static {
        f13839a = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.mutableProperty1((MutablePropertyReference1) ZeusTransformUtils.preCheckCast(new MutablePropertyReference1Impl(ODropdownTrigger.class, "active", "getActive()Z", 0), MutablePropertyReference1.class, "com.obric.memorydata.plugin")), KProperty.class, "com.obric.memorydata.plugin")};
    }

    public ODropdownTrigger(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ODropdownTrigger(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ODropdownTrigger(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "context");
        super(r15, r16, r14, null, 8, null);
        Delegates r17 = Delegates.INSTANCE;
        this.i = (ReadWriteProperty) ZeusTransformUtils.preCheckCast(new a(false, this), ReadWriteProperty.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Activity.class) == false) goto L5;
        setDropdownActivity((Activity) ZeusTransformUtils.preCheckCast(r15, Activity.class, "com.obric.memorydata.plugin"));
    L5:
        TypedArray r18 = r15.getTheme().obtainStyledAttributes(r16, R.styleable.ODropdownTrigger, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r18, "context.theme.obtainStyl…           0, 0\n        )");
        this.f13840b = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_backgroundOff, "styleable", "ODropdownTrigger_oui_backgroundOff"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2"), r15.getTheme()));
        this.c = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_backgroundOn, "styleable", "ODropdownTrigger_oui_backgroundOn"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_active, TypedValues.Custom.S_COLOR, "oui_fill_active"), r15.getTheme()));
        this.d = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_iconOff, "styleable", "ODropdownTrigger_oui_iconOff"), ZeusTransformUtils.mapRes(R.drawable.dropdown_default_off, "drawable", "dropdown_default_off"));
        this.e = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_iconOn, "styleable", "ODropdownTrigger_oui_iconOn"), ZeusTransformUtils.mapRes(R.drawable.dropdown_default_on, "drawable", "dropdown_default_on"));
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(new OBaseTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r15, r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_textStyle, "styleable", "ODropdownTrigger_oui_textStyle"), ZeusTransformUtils.mapRes(R.style.ODropdownTriggerText, "style", "ODropdownTriggerText"))), Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null), TextView.class, "com.obric.memorydata.plugin");
        this.f = r0;
        addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(((OBaseTextView) ZeusTransformUtils.preCheckCast(r0, OBaseTextView.class, "com.obric.memorydata.plugin")).getLayoutParams());
        r3.weight = 1.0f;
        r3.rightMargin = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_midMargin, "styleable", "ODropdownTrigger_oui_midMargin"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0));
        ((OBaseTextView) ZeusTransformUtils.preCheckCast(r0, OBaseTextView.class, "com.obric.memorydata.plugin")).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ImageView r19 = new ImageView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r15, r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ODropdownTrigger_oui_imageStyle, "styleable", "ODropdownTrigger_oui_imageStyle"), ZeusTransformUtils.mapRes(R.style.ODropdownTriggerIcon, "style", "ODropdownTriggerIcon"))), Context.class, "com.obric.memorydata.plugin"));
        this.g = r19;
        addView((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin"));
        c();
        setOnClickListener(new $$Lambda$ODropdownTrigger$6vGKwrY8CcrTI0oAWalJUU_2jaY(this));
    }

    public /* synthetic */ ODropdownTrigger(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private static final void a(ODropdownTrigger r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.a();
    }

    public static /* synthetic */ void lambda$6vGKwrY8CcrTI0oAWalJUU_2jaY(ODropdownTrigger r0, View r1) {
        a(r0, r1);
    }

    public void a() {
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getDropdownActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != null) goto L6;
        f.a(f.f13501a, "ODropdownTrigger", "no activity for popup showing", null, 4, null);
        return;
    L6:
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getDropdownActivity(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L15;
        b r2 = this.h;
        if (r2 == null) goto L13;
        b.a.a(r2, this, r4, null, (Function1) ZeusTransformUtils.preCheckCast(new ODropdownTrigger$showPopup$1$1(this), Function1.class, "com.obric.memorydata.plugin"), 4, null);
        Unit r0 = Unit.INSTANCE;
    L13:
        setActive(true);
        return;
    }

    public void b() {
        this.g.setImageResource(this.e);
        setBackgroundColor(this.c);
    }

    public void c() {
        this.g.setImageResource(this.d);
        setBackgroundColor(this.f13840b);
    }

    public final boolean getActive() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.i.getValue(this, f13839a[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final Activity getDropdownActivity() {
        WeakReference<Activity> r2 = this.j;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("reference");
        r2 = null;
    L6:
        return (Activity) ZeusTransformUtils.preCheckCast(r2.get(), Activity.class, "com.obric.memorydata.plugin");
    }

    public final ImageView getIcon() {
        return this.g;
    }

    public final TextView getValue() {
        return this.f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setActive(boolean r4) {
        this.i.setValue(this, f13839a[0], Boolean.valueOf(r4));
    }

    public final void setDropdownActivity(Activity r3) {
        this.j = new WeakReference((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
    }
}
