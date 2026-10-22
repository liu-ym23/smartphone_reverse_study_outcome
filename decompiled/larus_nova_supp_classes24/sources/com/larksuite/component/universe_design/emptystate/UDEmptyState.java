package com.larksuite.component.universe_design.emptystate;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.emptystate.databinding.UdLayoutEmptystateBinding;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 X2\u00020\u0001:\u0003WXYB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0015\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010)\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u0010,\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u0010\u0010-\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010-\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u0010\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u000e\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020(J\u0006\u00105\u001a\u00020(J\u000e\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u00109\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u0010\u0010:\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010;\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\nJ\u000e\u0010<\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u000e\u0010=\u001a\u00020\u00112\u0006\u00104\u001a\u00020(J\u0006\u0010>\u001a\u00020(J\u000e\u0010?\u001a\u00020\u00112\u0006\u00107\u001a\u000208J\u0010\u0010@\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010@\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010!J\u0010\u0010A\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010B\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(J\u000e\u0010C\u001a\u00020\u00112\u0006\u00104\u001a\u00020(J\u0006\u0010D\u001a\u00020(J\u0010\u0010E\u001a\u00020\u00112\b\u0010F\u001a\u0004\u0018\u00010GJ\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020JJ\u0018\u0010M\u001a\u00020\u00112\u0006\u0010L\u001a\u00020J2\u0006\u0010N\u001a\u00020(H\u0002J\u0010\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\nH\u0002J\u0010\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010U\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010V\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "viewBinding", "Lcom/larksuite/component/universe_design/emptystate/databinding/UdLayoutEmptystateBinding;", "init", "", "initProperty", "ta", "Landroid/content/res/TypedArray;", "initStyle", "setImageRes", "resId", "(Ljava/lang/Integer;)V", "setImageSize", "dp", "", "(Ljava/lang/Float;)V", "setImageSizeResource", "setTitle", "text", "", "", "setTitleTextAppearance", "textAppearanceRes", "setImageBottomMargin", "margin", "showTitle", "isShow", "", "setDesc", "setDescTextAppearance", "setTitleBottomMargin", "showDescription", "setPrimaryText", "setPrimaryClickListener", "listener", "Landroid/view/View$OnClickListener;", "setPrimaryActionTopMargin", "showPrimaryAction", "setPrimaryActionEnabled", "enabled", "isPrimaryActionEnabled", "setPrimaryActionStyle", "style", "Lcom/larksuite/component/universe_design/emptystate/UDEmptyState$ButtonStyle;", "setSecondaryText", "setSecondaryClickListener", "setSecondaryActionTopMargin", "showSecondaryAction", "setSecondaryActionEnabled", "isSecondaryActionEnabled", "setSecondaryActionStyle", "setLinkAction", "setOnLinkActionClickListener", "showLinkAction", "setLinkActionEnabled", "isLinkActionEnabled", "setContainer", "container", "Landroid/view/ViewGroup;", "reset", "getImageView", "Landroid/view/View;", "setImageView", "view", "setViewVisibility", "isVisible", "setImageSizeInternal", "px", "setButtonPrimaryTextLinkStyle", "button", "Lcom/larksuite/component/universe_design/button/UDButton;", "setButtonSecondaryTextLinkStyle", "setButtonPrimaryButtonStyle", "setButtonSecondaryButtonStyle", "OperableTextSpan", "Companion", "ButtonStyle", "universe-ui-emptystate_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDEmptyState extends LinearLayout {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final float IMAGE_LARGE = 0.0f;
    private static final float IMAGE_SMALL = 0.0f;
    private final UdLayoutEmptystateBinding viewBinding;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/emptystate/UDEmptyState$ButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON", "TEXT_LINK", "universe-ui-emptystate_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        public static final ButtonStyle BUTTON = null;
        public static final ButtonStyle TEXT_LINK = null;
        public static final /* synthetic */ ButtonStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ButtonStyle> getEntries() {
            return b;
        }

        static {
            ButtonStyle r0 = new ButtonStyle("BUTTON", 0);
            BUTTON = r0;
            ButtonStyle r1 = new ButtonStyle("TEXT_LINK", 1);
            TEXT_LINK = r1;
            ButtonStyle[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) a.clone();
        }

        public static ButtonStyle valueOf(String r1) {
            return (ButtonStyle) r27.a.a(ButtonStyle.class, r1);
        }

        public ButtonStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b extends ClickableSpan {
        public static int b;
        public final View.OnClickListener a;

        public static final class a {
        }

        static {
        }

        public b(View.OnClickListener r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            View.OnClickListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "drawState");
            super.updateDrawState(r2);
            r2.setColor(b);
            r2.setUnderlineText(false);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ButtonStyle.values().length];
            r0[ButtonStyle.BUTTON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ButtonStyle.TEXT_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ UDEmptyState a;

        public d(UDEmptyState r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            v08.a.a(UDEmptyState.access$getViewBinding$p(this.a).d, UDEmptyState.access$getViewBinding$p(this.a).c);
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ UDEmptyState a;

        public e(UDEmptyState r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            v08.a.a(UDEmptyState.access$getViewBinding$p(this.a).c, UDEmptyState.access$getViewBinding$p(this.a).d);
        }
    }

    public final void reset() {
        setImageRes(0);
        setTitle(null);
        setDesc(null);
        setPrimaryText(null);
        setPrimaryClickListener(null);
        setSecondaryText(null);
        setSecondaryClickListener(null);
        setLinkAction(null);
        setOnLinkActionClickListener(null);
    }

    static {
        Companion = new a();
        $stable = 8;
        IMAGE_LARGE = 245.0f;
        IMAGE_SMALL = 100.0f;
    }

    public final View getImageView() {
        return this.viewBinding.f;
    }

    public final boolean isLinkActionEnabled() {
        return this.viewBinding.b.isEnabled();
    }

    public final boolean isPrimaryActionEnabled() {
        return this.viewBinding.c.isEnabled();
    }

    public final boolean isSecondaryActionEnabled() {
        return this.viewBinding.d.isEnabled();
    }

    public static final /* synthetic */ float access$getIMAGE_LARGE$cp() {
        return IMAGE_LARGE;
    }

    public static final /* synthetic */ float access$getIMAGE_SMALL$cp() {
        return IMAGE_SMALL;
    }

    public UDEmptyState(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ UdLayoutEmptystateBinding access$getViewBinding$p(UDEmptyState r0) {
        return r0.viewBinding;
    }

    private final void initProperty(TypedArray r4) {
        setImageRes(Integer.valueOf(r4.getResourceId(2, 0)));
        CharSequence r2 = r4.getText(10);
        if (r2 == null) goto L6;
        String r3 = r2.toString();
        if (r3 == null) goto L6;
    L7:
        setTitle(r3);
        CharSequence r0 = r4.getText(0);
        if (r0 == null) goto L11;
        String r1 = r0.toString();
        if (r1 == null) goto L11;
    L12:
        setDesc(r1);
        CharSequence r5 = r4.getText(6);
        if (r5 == null) goto L16;
        String r6 = r5.toString();
        if (r6 == null) goto L16;
    L17:
        setPrimaryText(r6);
        CharSequence r7 = r4.getText(8);
        if (r7 == null) goto L21;
        String r8 = r7.toString();
        if (r8 == null) goto L21;
    L22:
        setSecondaryText(r8);
        CharSequence r9 = r4.getText(4);
        if (r9 == null) goto L26;
        String r10 = r9.toString();
        if (r10 == null) goto L26;
    L27:
        setLinkAction(r10);
        return;
    L26:
        r10 = r4.getString(4);
    L21:
        r8 = r4.getString(8);
    L16:
        r6 = r4.getString(6);
    L11:
        r1 = r4.getString(0);
    L6:
        r3 = r4.getString(10);
        goto L7
    }

    private final void initStyle(TypedArray r5) {
        int r0 = r5.getDimensionPixelSize(3, (int) h18.d.a(getContext(), IMAGE_SMALL));
        this.viewBinding.f.getLayoutParams().width = r0;
        this.viewBinding.f.getLayoutParams().height = r0;
        this.viewBinding.c.setTextSize(0, r5.getDimensionPixelSize(7, 14));
        this.viewBinding.d.setTextSize(0, r5.getDimensionPixelSize(9, 14));
        this.viewBinding.g.setTextColor(r5.getColor(11, UDColorUtils.getColor(getContext(), 2131106622)));
        this.viewBinding.e.setTextColor(r5.getColor(1, UDColorUtils.getColor(getContext(), 2131106607)));
        int r1 = b.b;
        b.b = r5.getInt(5, UDColorUtils.getColor(getContext(), 2131105548));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonPrimaryButtonStyle(UDButton r3) {
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131108881));
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131106521));
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.transparent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonPrimaryTextLinkStyle(UDButton r3) {
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131108889));
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131108883));
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.transparent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonSecondaryButtonStyle(UDButton r3) {
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131108890));
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131108884));
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), 2131103352));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonSecondaryTextLinkStyle(UDButton r3) {
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131108890));
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131108884));
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.transparent));
    }

    private final void setImageSizeInternal(int r2) {
        this.viewBinding.f.getLayoutParams().width = r2;
        this.viewBinding.f.getLayoutParams().height = r2;
    }

    public final void setContainer(ViewGroup r4) {
        if (getParent() == null) goto L5;
        ViewParent r0 = getParent();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r0).removeView(this);
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if ((r4 instanceof LinearLayout) == false) goto L9;
        int r1 = 0;
    L10:
        r4.addView(this, r1, new LinearLayout.LayoutParams(-1, -1));
        return;
    L9:
        r1 = r4.getChildCount() - 1;
        goto L10
    }

    public final void setDesc(CharSequence r3) {
        this.viewBinding.e.setText(r3);
        TextView r0 = this.viewBinding.e;
        int r1 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1 = 8;
    L11:
        r0.setVisibility(r1);
        this.viewBinding.e.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public final void setDescTextAppearance(int r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.viewBinding.e.setTextAppearance(r3);
        return;
    L5:
        this.viewBinding.e.setTextAppearance(getContext(), r3);
    }

    public final void setImageBottomMargin(int r3) {
        ViewGroup.LayoutParams r0 = this.viewBinding.f.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = r3;
        this.viewBinding.f.requestLayout();
    }

    public final void setImageRes(Integer r3) {
        View r0 = getImageView();
        if (r3 == null) goto L9;
        if (r3.intValue() != 0) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        if ((r0 instanceof ImageView) == false) goto L17;
        ImageView r1 = (ImageView) r0;
        if (r3 == null) goto L13;
        int r4 = r3.intValue();
    L14:
        r1.setImageResource(r4);
        r1.setVisibility(0);
        return;
    L13:
        r4 = 0;
        goto L14
    }

    public final void setImageSize(Float r2) {
        if (r2 == null) goto L5;
        r2.floatValue();
        setImageSizeInternal((int) h18.d.a(getContext(), r2.floatValue()));
        return;
    }

    public final void setImageSizeResource(int r2) {
        setImageSizeInternal((int) getContext().getResources().getDimension(r2));
    }

    public final void setImageView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        View r0 = getImageView();
        if (r0 == null) goto L6;
        removeView(r0);
        addView(r3, 0, r0.getLayoutParams());
        return;
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
    public final void setLinkAction(CharSequence r3) {
        this.viewBinding.b.setText(r3);
        AppCompatButton r0 = this.viewBinding.b;
        int r1 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1 = 8;
    L11:
        r0.setVisibility(r1);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
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
    public final void setLinkActionEnabled(boolean r2) {
        this.viewBinding.b.setEnabled(r2);
    }

    public final void setOnLinkActionClickListener(View.OnClickListener r2) {
        this.viewBinding.b.setOnClickListener(r2);
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
    public final void setPrimaryActionEnabled(boolean r2) {
        this.viewBinding.c.setEnabled(r2);
    }

    public final void setPrimaryActionStyle(ButtonStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        int r3 = c.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        setButtonPrimaryButtonStyle(this.viewBinding.c);
        return;
    L5:
        if (r3 != 2) goto L8;
        setButtonPrimaryTextLinkStyle(this.viewBinding.c);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void setPrimaryActionTopMargin(int r3) {
        ViewGroup.LayoutParams r0 = this.viewBinding.c.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r0).topMargin = r3;
        this.viewBinding.c.requestLayout();
    }

    public final void setPrimaryClickListener(View.OnClickListener r2) {
        this.viewBinding.c.setOnClickListener(r2);
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
    public final void setPrimaryText(CharSequence r3) {
        this.viewBinding.c.setText(r3);
        AppCompatButton r4 = this.viewBinding.c;
        CharSequence r0 = r4.getText();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r1 = 8;
    L11:
        r4.setVisibility(r1);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
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
    public final void setSecondaryActionEnabled(boolean r2) {
        this.viewBinding.d.setEnabled(r2);
    }

    public final void setSecondaryActionStyle(ButtonStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        int r3 = c.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        setButtonSecondaryButtonStyle(this.viewBinding.d);
        return;
    L5:
        if (r3 != 2) goto L8;
        setButtonSecondaryTextLinkStyle(this.viewBinding.d);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void setSecondaryActionTopMargin(int r3) {
        ViewGroup.LayoutParams r0 = this.viewBinding.d.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.topMargin = r3;
        this.viewBinding.d.requestLayout();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setSecondaryClickListener(View.OnClickListener r2) {
        this.viewBinding.d.setOnClickListener(r2);
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
    public final void setSecondaryText(CharSequence r3) {
        this.viewBinding.d.setText(r3);
        AppCompatButton r4 = this.viewBinding.d;
        CharSequence r0 = r4.getText();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r1 = 8;
    L11:
        r4.setVisibility(r1);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void setTitle(CharSequence r3) {
        this.viewBinding.g.setText(r3);
        TextView r0 = this.viewBinding.g;
        int r1 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1 = 8;
    L11:
        r0.setVisibility(r1);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public final void setTitleBottomMargin(int r3) {
        ViewGroup.LayoutParams r0 = this.viewBinding.g.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = r3;
        this.viewBinding.g.requestLayout();
    }

    public final void setTitleTextAppearance(int r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.viewBinding.g.setTextAppearance(r3);
        return;
    L5:
        this.viewBinding.g.setTextAppearance(getContext(), r3);
    }

    public final void showDescription(boolean r2) {
        setViewVisibility(this.viewBinding.e, r2);
    }

    public final void showLinkAction(boolean r2) {
        setViewVisibility(this.viewBinding.b, r2);
    }

    public final void showPrimaryAction(boolean r2) {
        setViewVisibility(this.viewBinding.c, r2);
    }

    public final void showSecondaryAction(boolean r2) {
        setViewVisibility(this.viewBinding.d, r2);
    }

    public final void showTitle(boolean r2) {
        setViewVisibility(this.viewBinding.g, r2);
    }

    public final void setDesc(String r1) {
        setDesc(r1);
    }

    public final void setLinkAction(String r1) {
        setLinkAction(r1);
    }

    public final void setPrimaryText(String r1) {
        setPrimaryText(r1);
    }

    public final void setSecondaryText(String r1) {
        setSecondaryText(r1);
    }

    public final void setTitle(String r1) {
        setTitle(r1);
    }

    public UDEmptyState(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    private final void setViewVisibility(View r1, boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 0;
    L5:
        r1.setVisibility(r3);
        return;
    L4:
        r3 = 8;
        goto L5
    }

    public UDEmptyState(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 2131953847);
    }

    private final void init(AttributeSet r3, int r4, int r5) {
        this.viewBinding.e.setHighlightColor(0);
        this.viewBinding.c.addOnLayoutChangeListener(new d(this));
        this.viewBinding.d.addOnLayoutChangeListener(new e(this));
        TypedArray r6 = getContext().obtainStyledAttributes(r3, new int[]{2130974893, 2130974894, 2130974895, 2130974896, 2130974897, 2130974898, 2130974899, 2130974900, 2130974901, 2130974902, 2130974903, 2130974904}, r4, r5);
        initProperty(r6);
        initStyle(r6);
        r6.recycle();
    }

    public UDEmptyState(Context r11, AttributeSet r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13, r14);
        View r15 = LayoutInflater.from(getContext()).inflate(2131568095, this, false);
        addView(r15);
        int r0 = 2131364624;
        UDButton r4 = (UDButton) ViewBindings.findChildViewById(r15, 2131364624);
        if (r4 == null) goto L17;
        r0 = 2131364625;
        UDButton r5 = (UDButton) ViewBindings.findChildViewById(r15, 2131364625);
        if (r5 == null) goto L17;
        r0 = 2131364628;
        UDButton r6 = (UDButton) ViewBindings.findChildViewById(r15, 2131364628);
        if (r6 == null) goto L17;
        r0 = 2131368819;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, 2131368819);
        if (r7 == null) goto L17;
        r0 = 2131374931;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r15, 2131374931);
        if (r8 == null) goto L17;
        r0 = 2131388772;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131388772);
        if (r9 == null) goto L17;
        this.viewBinding = new UdLayoutEmptystateBinding((LinearLayout) r15, r4, r5, r6, r7, r8, r9);
        init(r12, r13, r14);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
