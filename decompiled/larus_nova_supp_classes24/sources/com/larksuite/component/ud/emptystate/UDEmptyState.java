package com.larksuite.component.ud.emptystate;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import com.larksuite.component.ud.button.UDButton;
import com.larksuite.component.ud.color.UDColorUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 W2\u00020\u0001:\u0003XYZB\u0011\b\u0016\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bR\u0010TB#\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bR\u0010UB+\b\u0016\u0012\u0006\u0010Q\u001a\u00020P\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\bR\u0010VJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0017\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00072\b\b\u0001\u0010\u001a\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010,\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010,\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u000e\u0010-\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u0010\u00100\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u00100\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u0010\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101J\u000e\u00104\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u000e\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\u000e\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u000209J\u0010\u0010<\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010<\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u0010\u0010=\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101J\u000e\u0010>\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010@\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000fJ\u0006\u0010A\u001a\u00020\u000fJ\u000e\u0010B\u001a\u00020\u00072\u0006\u0010:\u001a\u000209J\u0010\u0010C\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010C\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%J\u0010\u0010D\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101J\u000e\u0010E\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u000fJ\u0006\u0010G\u001a\u00020\u000fJ\u0010\u0010J\u001a\u00020\u00072\b\u0010I\u001a\u0004\u0018\u00010HJ\u0006\u0010K\u001a\u00020\u0007J\b\u0010L\u001a\u0004\u0018\u00010\rJ\u000e\u0010M\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006["}, d2 = {"Lcom/larksuite/component/ud/emptystate/UDEmptyState;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", "init", "Landroid/content/res/TypedArray;", "ta", "initProperty", "initStyle", "Landroid/view/View;", "view", "", "isVisible", "setViewVisibility", "px", "setImageSizeInternal", "Lcom/larksuite/component/ud/button/UDButton;", "button", "setButtonPrimaryTextLinkStyle", "setButtonSecondaryTextLinkStyle", "setButtonPrimaryButtonStyle", "setButtonSecondaryButtonStyle", "resId", "setImageRes", "(Ljava/lang/Integer;)V", "", "dp", "setImageSize", "(Ljava/lang/Float;)V", "setImageSizeResource", "", "text", "setTitle", "", "textAppearanceRes", "setTitleTextAppearance", "margin", "setImageBottomMargin", "isShow", "showTitle", "setDesc", "setDescTextAppearance", "setTitleBottomMargin", "showDescription", "setPrimaryText", "Landroid/view/View$OnClickListener;", "listener", "setPrimaryClickListener", "setPrimaryActionTopMargin", "showPrimaryAction", "enabled", "setPrimaryActionEnabled", "isPrimaryActionEnabled", "Lcom/larksuite/component/ud/emptystate/UDEmptyState$ButtonStyle;", "style", "setPrimaryActionStyle", "setSecondaryText", "setSecondaryClickListener", "setSecondaryActionTopMargin", "showSecondaryAction", "setSecondaryActionEnabled", "isSecondaryActionEnabled", "setSecondaryActionStyle", "setLinkAction", "setOnLinkActionClickListener", "showLinkAction", "setLinkActionEnabled", "isLinkActionEnabled", "Landroid/view/ViewGroup;", "container", "setContainer", "reset", "getImageView", "setImageView", "rootView", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "ButtonStyle", "a", "b", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
public class UDEmptyState extends LinearLayout {
    public static final a Companion = null;
    private static final float IMAGE_LARGE = 0.0f;
    private static final float IMAGE_SMALL = 0.0f;
    private View rootView;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larksuite/component/ud/emptystate/UDEmptyState$ButtonStyle;", "", "BUTTON", "TEXT_LINK", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        public static final ButtonStyle BUTTON = null;
        public static final ButtonStyle TEXT_LINK = null;
        public static final /* synthetic */ ButtonStyle[] a = null;

        public static ButtonStyle valueOf(String r1) {
            return (ButtonStyle) r27.a.a(ButtonStyle.class, r1);
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) a.clone();
        }

        static {
            ButtonStyle r0 = new ButtonStyle("BUTTON", 0);
            BUTTON = r0;
            ButtonStyle r1 = new ButtonStyle("TEXT_LINK", 1);
            TEXT_LINK = r1;
            a = new ButtonStyle[]{r0, r1};
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
        public static final /* synthetic */ int a = 0;

        public static final class a {
        }

        static {
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

    public static /* synthetic */ void a(UDEmptyState r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        init$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void b(UDEmptyState r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        init$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
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
        IMAGE_LARGE = 245.0f;
        IMAGE_SMALL = 100.0f;
    }

    public final View getImageView() {
        View r0 = this.rootView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ImageView) r0.findViewById(2131374931);
    }

    public final boolean isLinkActionEnabled() {
        View r0 = this.rootView;
        if (r0 == null) goto L7;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364624);
        if (r1 == null) goto L7;
        return r1.isEnabled();
    L7:
        return false;
    }

    public final boolean isPrimaryActionEnabled() {
        View r0 = this.rootView;
        if (r0 == null) goto L7;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364625);
        if (r1 == null) goto L7;
        return r1.isEnabled();
    L7:
        return false;
    }

    public final boolean isSecondaryActionEnabled() {
        View r0 = this.rootView;
        if (r0 == null) goto L7;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364628);
        if (r1 == null) goto L7;
        return r1.isEnabled();
    L7:
        return false;
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

    private final void initStyle(TypedArray r8) {
        Context r0 = getContext();
        float r1 = IMAGE_SMALL;
        int r2 = qz7.a.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Resources r3 = r0.getResources();
        int r4 = r8.getDimensionPixelSize(3, (int) TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        View r5 = this.rootView;
        ViewGroup.LayoutParams r6 = null;
        if (r5 == null) goto L7;
        ImageView r7 = (ImageView) r5.findViewById(2131374931);
        if (r7 == null) goto L7;
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
    L8:
        if (r9 == null) goto L11;
        r9.width = r4;
    L11:
        View r10 = this.rootView;
        if (r10 == null) goto L16;
        ImageView r11 = (ImageView) r10.findViewById(2131374931);
        if (r11 == null) goto L16;
        r6 = r11.getLayoutParams();
    L16:
        if (r6 == null) goto L19;
        r6.height = r4;
    L19:
        int r12 = r8.getDimensionPixelSize(7, 14);
        View r13 = this.rootView;
        if (r13 == null) goto L24;
        UDButton r14 = (UDButton) r13.findViewById(2131364625);
        if (r14 == null) goto L24;
        r14.setTextSize(0, r12);
    L24:
        int r15 = r8.getDimensionPixelSize(9, 14);
        View r16 = this.rootView;
        if (r16 == null) goto L29;
        UDButton r17 = (UDButton) r16.findViewById(2131364628);
        if (r17 == null) goto L29;
        r17.setTextSize(0, r15);
    L29:
        Context r19 = getContext();
        Lazy r20 = UDColorUtils.a;
        Intrinsics.checkNotNullParameter(r19, "context");
        int r21 = r8.getColor(11, r19.getResources().getColor(2131106622));
        View r22 = this.rootView;
        if (r22 == null) goto L34;
        TextView r23 = (TextView) r22.findViewById(2131388772);
        if (r23 == null) goto L34;
        r23.setTextColor(r21);
    L34:
        Context r24 = getContext();
        Intrinsics.checkNotNullParameter(r24, "context");
        int r25 = r8.getColor(1, r24.getResources().getColor(2131106607));
        View r26 = this.rootView;
        if (r26 == null) goto L39;
        TextView r27 = (TextView) r26.findViewById(2131368819);
        if (r27 == null) goto L39;
        r27.setTextColor(r25);
    L39:
        int r29 = b.a;
        Context r30 = getContext();
        Intrinsics.checkNotNullParameter(r30, "context");
        r8.getInt(5, r30.getResources().getColor(2131105548));
        return;
    L7:
        r9 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonPrimaryButtonStyle(UDButton r3) {
        if (r3 == 0) goto L4;
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131100790));
    L4:
        if (r3 == 0) goto L6;
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131106521));
    L6:
        if (r3 == 0) goto L9;
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.transparent));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonPrimaryTextLinkStyle(UDButton r3) {
        if (r3 == 0) goto L4;
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131100793));
    L4:
        if (r3 == 0) goto L6;
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131100791));
    L6:
        if (r3 == 0) goto L9;
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.transparent));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonSecondaryButtonStyle(UDButton r3) {
        if (r3 == 0) goto L4;
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131100794));
    L4:
        if (r3 == 0) goto L6;
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131100792));
    L6:
        if (r3 == 0) goto L9;
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), 2131103352));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setButtonSecondaryTextLinkStyle(UDButton r3) {
        if (r3 == 0) goto L4;
        r3.setBackgroundColor(AppCompatResources.getColorStateList(getContext(), 2131100794));
    L4:
        if (r3 == 0) goto L6;
        r3.setTextColor(AppCompatResources.getColorStateList(getContext(), 2131100792));
    L6:
        if (r3 == 0) goto L9;
        r3.setStrokeColor(AppCompatResources.getColorStateList(getContext(), R.color.transparent));
        return;
    }

    private final void setImageSizeInternal(int r4) {
        View r0 = this.rootView;
        ViewGroup.LayoutParams r2 = null;
        if (r0 == null) goto L7;
        ImageView r1 = (ImageView) r0.findViewById(2131374931);
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L8:
        if (r3 == null) goto L11;
        r3.width = r4;
    L11:
        View r5 = this.rootView;
        if (r5 == null) goto L16;
        ImageView r6 = (ImageView) r5.findViewById(2131374931);
        if (r6 == null) goto L16;
        r2 = r6.getLayoutParams();
    L16:
        if (r2 == null) goto L20;
        r2.height = r4;
        return;
    L20:
        return;
    L7:
        r3 = null;
        goto L8
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

    public final void setDesc(CharSequence r5) {
        View r0 = this.rootView;
        TextView r2 = null;
        if (r0 == null) goto L5;
        TextView r1 = (TextView) r0.findViewById(2131368819);
    L6:
        if (r1 == null) goto L9;
        r1.setText(r5);
    L9:
        View r3 = this.rootView;
        if (r3 == null) goto L12;
        TextView r4 = (TextView) r3.findViewById(2131368819);
    L13:
        if (r4 == null) goto L25;
        int r6 = 0;
        if (r5 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        r6 = 8;
    L24:
        r4.setVisibility(r6);
        goto L25
    L18:
        if (r5.length() == 0) goto L21;
        r7 = false;
    L25:
        View r8 = this.rootView;
        if (r8 == null) goto L28;
        r2 = (TextView) r8.findViewById(2131368819);
    L28:
        if (r2 == null) goto L32;
        r2.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L32:
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void setDescTextAppearance(int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L9;
        View r0 = this.rootView;
        if (r0 == null) goto L15;
        TextView r1 = (TextView) r0.findViewById(2131368819);
        if (r1 == null) goto L16;
        r1.setTextAppearance(r4);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r2 = this.rootView;
        if (r2 == null) goto L18;
        TextView r3 = (TextView) r2.findViewById(2131368819);
        if (r3 == null) goto L19;
        r3.setTextAppearance(getContext(), r4);
        return;
    L19:
        return;
    }

    public final void setImageBottomMargin(int r4) {
        View r0 = this.rootView;
        if (r0 == null) goto L7;
        ImageView r1 = (ImageView) r0.findViewById(2131374931);
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r4;
        View r5 = this.rootView;
        if (r5 == null) goto L14;
        ImageView r6 = (ImageView) r5.findViewById(2131374931);
        if (r6 == null) goto L15;
        r6.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void setImageRes(Integer r3) {
        View r0 = getImageView();
        if (r3 == null) goto L11;
        if (r3.intValue() != 0) goto L11;
        if (r0 == null) goto L20;
        r0.setVisibility(8);
        return;
    L20:
        return;
    L11:
        if ((r0 instanceof ImageView) == false) goto L19;
        ImageView r1 = (ImageView) r0;
        if (r3 == null) goto L15;
        int r4 = r3.intValue();
    L16:
        r1.setImageResource(r4);
        r1.setVisibility(0);
        return;
    L15:
        r4 = 0;
        goto L16
    }

    public final void setImageSize(Float r3) {
        if (r3 == null) goto L5;
        r3.floatValue();
        Context r0 = getContext();
        float r4 = r3.floatValue();
        int r1 = qz7.a.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Resources r2 = r0.getResources();
        setImageSizeInternal((int) TypedValue.applyDimension(1, r4, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
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

    public final void setLinkAction(CharSequence r4) {
        View r0 = this.rootView;
        AppCompatButton r2 = null;
        if (r0 == null) goto L5;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364624);
    L6:
        if (r1 == null) goto L9;
        r1.setText(r4);
    L9:
        View r3 = this.rootView;
        if (r3 == null) goto L12;
        r2 = (UDButton) r3.findViewById(2131364624);
    L12:
        if (r2 == null) goto L25;
        int r5 = 0;
        if (r4 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        r5 = 8;
    L23:
        r2.setVisibility(r5);
        return;
    L17:
        if (r4.length() == 0) goto L20;
        r6 = false;
        goto L21
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setLinkActionEnabled(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L5;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364624);
    L6:
        if (r1 == null) goto L10;
        r1.setEnabled(r3);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setOnLinkActionClickListener(View.OnClickListener r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364624);
        if (r1 == null) goto L9;
        r1.setOnClickListener(r3);
        return;
    L9:
        return;
    }

    public final void setPrimaryActionEnabled(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L5;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364625);
    L6:
        if (r1 == null) goto L10;
        r1.setEnabled(r3);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setPrimaryActionStyle(ButtonStyle r4) {
        Intrinsics.checkNotNullParameter(r4, "style");
        int r5 = c.a[r4.ordinal()];
        UDButton r2 = null;
        if (r5 != 1) goto L5;
        View r6 = this.rootView;
        if (r6 == null) goto L14;
        r2 = (UDButton) r6.findViewById(2131364625);
    L14:
        setButtonPrimaryButtonStyle(r2);
        return;
    L5:
        if (r5 != 2) goto L17;
        View r7 = this.rootView;
        if (r7 == null) goto L10;
        r2 = (UDButton) r7.findViewById(2131364625);
    L10:
        setButtonPrimaryTextLinkStyle(r2);
        return;
    }

    public final void setPrimaryActionTopMargin(int r4) {
        View r0 = this.rootView;
        if (r0 == null) goto L7;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364625);
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r2).topMargin = r4;
        View r5 = this.rootView;
        if (r5 == null) goto L14;
        AppCompatButton r6 = (UDButton) r5.findViewById(2131364625);
        if (r6 == null) goto L15;
        r6.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void setPrimaryClickListener(View.OnClickListener r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364625);
        if (r1 == null) goto L9;
        r1.setOnClickListener(r3);
        return;
    L9:
        return;
    }

    public final void setPrimaryText(CharSequence r4) {
        View r0 = this.rootView;
        CharSequence r2 = null;
        if (r0 == null) goto L5;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364625);
    L6:
        if (r1 == null) goto L9;
        r1.setText(r4);
    L9:
        View r5 = this.rootView;
        if (r5 == null) goto L12;
        AppCompatButton r6 = (UDButton) r5.findViewById(2131364625);
    L13:
        if (r6 == null) goto L31;
        View r3 = this.rootView;
        if (r3 == null) goto L20;
        AppCompatButton r7 = (UDButton) r3.findViewById(2131364625);
        if (r7 == null) goto L20;
        r2 = r7.getText();
    L20:
        int r8 = 0;
        if (r2 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        r8 = 8;
    L29:
        r6.setVisibility(r8);
        return;
    L23:
        if (r2.length() == 0) goto L26;
        r9 = false;
        goto L27
    L31:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void setSecondaryActionEnabled(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L5;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364628);
    L6:
        if (r1 == null) goto L10;
        r1.setEnabled(r3);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setSecondaryActionStyle(ButtonStyle r4) {
        Intrinsics.checkNotNullParameter(r4, "style");
        int r5 = c.a[r4.ordinal()];
        UDButton r2 = null;
        if (r5 != 1) goto L5;
        View r6 = this.rootView;
        if (r6 == null) goto L14;
        r2 = (UDButton) r6.findViewById(2131364628);
    L14:
        setButtonSecondaryButtonStyle(r2);
        return;
    L5:
        if (r5 != 2) goto L17;
        View r7 = this.rootView;
        if (r7 == null) goto L10;
        r2 = (UDButton) r7.findViewById(2131364628);
    L10:
        setButtonSecondaryTextLinkStyle(r2);
        return;
    }

    public final void setSecondaryActionTopMargin(int r5) {
        View r0 = this.rootView;
        ViewGroup.MarginLayoutParams r2 = null;
        if (r0 == null) goto L7;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364628);
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L9:
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        r2 = (ViewGroup.MarginLayoutParams) r3;
    L11:
        if (r2 == null) goto L18;
        r2.topMargin = r5;
        View r6 = this.rootView;
        if (r6 == null) goto L19;
        AppCompatButton r7 = (UDButton) r6.findViewById(2131364628);
        if (r7 == null) goto L20;
        r7.requestLayout();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void setSecondaryClickListener(View.OnClickListener r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364628);
        if (r1 == null) goto L9;
        r1.setOnClickListener(r3);
        return;
    L9:
        return;
    }

    public final void setSecondaryText(CharSequence r4) {
        View r0 = this.rootView;
        CharSequence r2 = null;
        if (r0 == null) goto L5;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364628);
    L6:
        if (r1 == null) goto L9;
        r1.setText(r4);
    L9:
        View r5 = this.rootView;
        if (r5 == null) goto L12;
        AppCompatButton r6 = (UDButton) r5.findViewById(2131364628);
    L13:
        if (r6 == null) goto L31;
        View r3 = this.rootView;
        if (r3 == null) goto L20;
        AppCompatButton r7 = (UDButton) r3.findViewById(2131364628);
        if (r7 == null) goto L20;
        r2 = r7.getText();
    L20:
        int r8 = 0;
        if (r2 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        r8 = 8;
    L29:
        r6.setVisibility(r8);
        return;
    L23:
        if (r2.length() == 0) goto L26;
        r9 = false;
        goto L27
    L31:
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void setTitle(CharSequence r4) {
        View r0 = this.rootView;
        TextView r2 = null;
        if (r0 == null) goto L5;
        TextView r1 = (TextView) r0.findViewById(2131388772);
    L6:
        if (r1 == null) goto L9;
        r1.setText(r4);
    L9:
        View r3 = this.rootView;
        if (r3 == null) goto L12;
        r2 = (TextView) r3.findViewById(2131388772);
    L12:
        if (r2 == null) goto L25;
        int r5 = 0;
        if (r4 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        r5 = 8;
    L23:
        r2.setVisibility(r5);
        return;
    L17:
        if (r4.length() == 0) goto L20;
        r6 = false;
        goto L21
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setTitleBottomMargin(int r4) {
        View r0 = this.rootView;
        if (r0 == null) goto L7;
        TextView r1 = (TextView) r0.findViewById(2131388772);
        if (r1 == null) goto L7;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = r4;
        View r5 = this.rootView;
        if (r5 == null) goto L14;
        TextView r6 = (TextView) r5.findViewById(2131388772);
        if (r6 == null) goto L15;
        r6.requestLayout();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void setTitleTextAppearance(int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L9;
        View r0 = this.rootView;
        if (r0 == null) goto L15;
        TextView r1 = (TextView) r0.findViewById(2131388772);
        if (r1 == null) goto L16;
        r1.setTextAppearance(r4);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        View r2 = this.rootView;
        if (r2 == null) goto L18;
        TextView r3 = (TextView) r2.findViewById(2131388772);
        if (r3 == null) goto L19;
        r3.setTextAppearance(getContext(), r4);
        return;
    L19:
        return;
    }

    public final void showDescription(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        TextView r1 = (TextView) r0.findViewById(2131368819);
        if (r1 == null) goto L9;
        setViewVisibility(r1, r3);
        return;
    L9:
        return;
    }

    public final void showLinkAction(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364624);
        if (r1 == null) goto L9;
        setViewVisibility(r1, r3);
        return;
    L9:
        return;
    }

    public final void showPrimaryAction(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364625);
        if (r1 == null) goto L9;
        setViewVisibility(r1, r3);
        return;
    L9:
        return;
    }

    public final void showSecondaryAction(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        AppCompatButton r1 = (UDButton) r0.findViewById(2131364628);
        if (r1 == null) goto L9;
        setViewVisibility(r1, r3);
        return;
    L9:
        return;
    }

    public final void showTitle(boolean r3) {
        View r0 = this.rootView;
        if (r0 == null) goto L8;
        TextView r1 = (TextView) r0.findViewById(2131388772);
        if (r1 == null) goto L9;
        setViewVisibility(r1, r3);
        return;
    L9:
        return;
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
        this(r2, r3, r4, 2131954154);
    }

    private final void init(AttributeSet r4, int r5, int r6) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131559280, this, true);
        this.rootView = r0;
        if (r0 == null) goto L5;
        TextView r1 = (TextView) r0.findViewById(2131368819);
    L6:
        if (r1 == null) goto L9;
        r1.setHighlightColor(0);
    L9:
        View r2 = this.rootView;
        if (r2 == null) goto L14;
        AppCompatButton r3 = (UDButton) r2.findViewById(2131364625);
        if (r3 == null) goto L14;
        r3.addOnLayoutChangeListener(new oz7.a(this));
    L14:
        View r7 = this.rootView;
        if (r7 == null) goto L19;
        AppCompatButton r8 = (UDButton) r7.findViewById(2131364628);
        if (r8 == null) goto L19;
        r8.addOnLayoutChangeListener(new oz7.b(this));
    L19:
        TypedArray r9 = getContext().obtainStyledAttributes(r4, new int[]{2130974893, 2130974894, 2130974895, 2130974896, 2130974897, 2130974898, 2130974899, 2130974900, 2130974901, 2130974902, 2130974903, 2130974904}, r5, r6);
        initProperty(r9);
        initStyle(r9);
        r9.recycle();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public UDEmptyState(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
        init(r3, r4, r5);
    }

    private static final void init$lambda$1(UDEmptyState r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        View r10 = r0.rootView;
        if (r10 == null) goto L12;
        UDButton r11 = (UDButton) r10.findViewById(2131364625);
        if (r11 == null) goto L13;
        View r12 = r0.rootView;
        if (r12 == null) goto L14;
        UDButton r13 = (UDButton) r12.findViewById(2131364628);
        if (r13 == null) goto L15;
        oz7.c.a(r13, r11);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private static final void init$lambda$3(UDEmptyState r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        View r10 = r0.rootView;
        if (r10 == null) goto L12;
        UDButton r11 = (UDButton) r10.findViewById(2131364628);
        if (r11 == null) goto L13;
        View r12 = r0.rootView;
        if (r12 == null) goto L14;
        UDButton r13 = (UDButton) r12.findViewById(2131364625);
        if (r13 == null) goto L15;
        oz7.c.a(r13, r11);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
