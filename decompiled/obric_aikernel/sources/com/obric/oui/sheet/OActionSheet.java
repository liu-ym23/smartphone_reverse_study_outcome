package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "使用 OInsetSheet")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 F2\u00020\u0001:\u0002GHB\u0007¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001404j\b\u0012\u0004\u0012\u00020\u0014`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R&\u00109\u001a\u0012\u0012\u0004\u0012\u00020804j\b\u0012\u0004\u0012\u000208`58\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010%\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)¨\u0006I"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "", "scene", "", "getSpecColor", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "Landroid/content/DialogInterface$OnDismissListener;", "listener", "addOnDismissListener", "", "removeOnDismissListener", "view", "onViewCreated", "onStart", "Landroid/widget/TextView;", "mSubTitleText", "Landroid/widget/TextView;", "getMSubTitleText", "()Landroid/widget/TextView;", "setMSubTitleText", "(Landroid/widget/TextView;)V", "", "mSubTitle", "Ljava/lang/CharSequence;", "getMSubTitle", "()Ljava/lang/CharSequence;", "setMSubTitle", "(Ljava/lang/CharSequence;)V", "mTitleText", "getMTitleText", "setMTitleText", "Landroid/view/View$OnClickListener;", "mCancelBtnClickListener", "Landroid/view/View$OnClickListener;", "getMCancelBtnClickListener", "()Landroid/view/View$OnClickListener;", "setMCancelBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onDismissListeners", "Ljava/util/ArrayList;", "Lcom/obric/oui/sheet/OActionSheet$a;", "mActions", "Landroid/widget/LinearLayout;", "mActionContainer", "Landroid/widget/LinearLayout;", "getMActionContainer", "()Landroid/widget/LinearLayout;", "setMActionContainer", "(Landroid/widget/LinearLayout;)V", "mTitle", "getMTitle", "setMTitle", "<init>", "()V", "Companion", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OActionSheet extends OBasicPanelFragment {
    public static final b Companion = null;
    public static final String DIVIDER_LINE = "divider_line";
    public static final String DIVIDER_VIEW = "divider_view";
    public static final String EXTENSION_SUBTITLE = "extension_subtitle";
    public static final String EXTENSION_TITLE = "extension_title";
    public static final String ITEM_SUBTITLE = "item_subtitle";
    public static final String ITEM_TITLE = "item_title";
    public static final String TAG = "OActionSheet";
    private LinearLayout mActionContainer;
    private ArrayList<a> mActions;
    private View.OnClickListener mCancelBtnClickListener;
    private CharSequence mSubTitle;
    private TextView mSubTitleText;
    private CharSequence mTitle;
    private TextView mTitleText;
    private final ArrayList<DialogInterface.OnDismissListener> onDismissListeners;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f7370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f7371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Function2<? super View, ? super DialogFragment, Unit> f7373d;

        public final boolean a() {
            return this.f7372c;
        }

        public final Function2<View, DialogFragment, Unit> b() {
            return this.f7373d;
        }

        public final CharSequence c() {
            return this.f7371b;
        }

        public final CharSequence d() {
            return this.f7370a;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f7374c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OActionSheet f7375g;

        c(a r10, OActionSheet r11, LinearLayout r12) {
            this.f7374c = r10;
            this.f7375g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Function2<View, DialogFragment, Unit> r11 = this.f7374c.b();
            if (r11 == null) goto L5;
            Intrinsics.checkNotNullExpressionValue(r10, "it");
            Unit r12 = r11.invoke(r10, this.f7375g);
        L5:
            this.f7375g.dismissAllowingStateLoss();
        }
    }

    public static final class d extends View.AccessibilityDelegate {
        d() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            Intrinsics.checkNotNullParameter(r10, "host");
            Intrinsics.checkNotNullParameter(r11, "info");
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.setClassName("android.widget.ImageButton");
        }
    }

    static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OActionSheet f7376c;

        e(OActionSheet r10) {
            this.f7376c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            View.OnClickListener r11 = this.f7376c.getMCancelBtnClickListener();
            if (r11 == null) goto L5;
            r11.onClick(r10);
        L5:
            this.f7376c.dismissAllowingStateLoss();
        }
    }

    public static final class f extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f7377a;

        f(a r10) {
            this.f7377a = r10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            Intrinsics.checkNotNullParameter(r10, "host");
            Intrinsics.checkNotNullParameter(r11, "info");
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.setClassName("android.widget.ImageButton");
            if (this.f7377a.a() == false) goto L6;
            r10.setSelected(true);
            return;
        }
    }

    static {
        Companion = new b(null);
    }

    public OActionSheet() {
        this.mActions = new ArrayList();
        this.onDismissListeners = new ArrayList();
    }

    public static final /* synthetic */ ArrayList access$getMActions$p(OActionSheet r10) {
        return r10.mActions;
    }

    public static final /* synthetic */ void access$setMActions$p(OActionSheet r10, ArrayList r11) {
        r10.mActions = r11;
    }

    private final int getSpecColor(String r10) {
        switch(r10.hashCode()) {
            case -1951390164: goto L34;
            case -1672427580: goto L28;
            case -1210163878: goto L22;
            case -1209866229: goto L16;
            case 1704015448: goto L11;
            case 1915336728: goto L6;
            default: goto L39;
        };
    L39:
        int r11 = 0;
    L41:
        return ContextCompat.getColor(requireContext(), r11);
    L6:
        if (r10.equals(EXTENSION_SUBTITLE) == false) goto L39;
        if (getAutoSwitchDayNight() == true) goto L31;
    L32:
        r11 = u8.c.TextReverse3;
    L31:
        r11 = u8.c.TextTertiary;
        goto L41
    L11:
        if (r10.equals(EXTENSION_TITLE) == false) goto L39;
        if (getAutoSwitchDayNight() == false) goto L32;
    L16:
        if (r10.equals(DIVIDER_VIEW) == false) goto L39;
        if (getAutoSwitchDayNight() == false) goto L20;
        r11 = u8.c.BGPlaceholderDefault;
        goto L41
    L20:
        r11 = u8.c.BGInputReverse;
        goto L41
    L22:
        if (r10.equals(DIVIDER_LINE) == false) goto L39;
        if (getAutoSwitchDayNight() == false) goto L26;
        r11 = u8.c.LinePrimary;
        goto L41
    L26:
        r11 = u8.c.LineReverse2;
        goto L41
    L28:
        if (r10.equals(ITEM_SUBTITLE) == false) goto L39;
        if (getAutoSwitchDayNight() == false) goto L32;
    L34:
        if (r10.equals(ITEM_TITLE) == false) goto L39;
        if (getAutoSwitchDayNight() == false) goto L38;
        r11 = u8.c.TextPrimary;
        goto L41
    L38:
        r11 = u8.c.TextReverse;
        goto L41
    }

    public final void addOnDismissListener(DialogInterface.OnDismissListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.onDismissListeners.add(r10);
    }

    public final LinearLayout getMActionContainer() {
        return this.mActionContainer;
    }

    public final View.OnClickListener getMCancelBtnClickListener() {
        return this.mCancelBtnClickListener;
    }

    public final CharSequence getMSubTitle() {
        return this.mSubTitle;
    }

    public final TextView getMSubTitleText() {
        return this.mSubTitleText;
    }

    public final CharSequence getMTitle() {
        return this.mTitle;
    }

    public final TextView getMTitleText() {
        return this.mTitleText;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r10) {
        Context r11 = requireContext();
        Intrinsics.checkNotNullExpressionValue(r11, "requireContext()");
        OBasePanelDialog r12 = new OBasePanelDialog(r11, 0, 2, null);
        r12.setExpandable(false);
        r12.setRemoveMinHeight(true);
        r12.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        return r12;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        return r10.inflate(h.o_view_action_sheet, r11, false);
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        super.onDismiss(r10);
        Iterator<T> r11 = this.onDismissListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) r11.next()).onDismiss(r10);
        goto L4
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if ((getDialog() instanceof OBasePanelDialog) == false) goto L6;
        Dialog r10 = getDialog();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
        ((OBasePanelDialog) r10).hideHeader();
        return;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super.onViewCreated(r17, r18);
        LinearLayout r10 = (LinearLayout) r17.findViewById(u8.f.action_sheet_layout);
        if (getAutoSwitchDayNight() == false) goto L5;
        Context r11 = requireContext();
        int r12 = u8.e.o_action_sheet_daynight_bg;
    L6:
        Drawable r13 = ContextCompat.getDrawable(r11, r12);
        if (r10 == null) goto L9;
        r10.setBackground(r13);
    L9:
        r17.findViewById(u8.f.divider_view).setBackgroundColor(getSpecColor(DIVIDER_VIEW));
        LinearLayout r14 = (LinearLayout) r17.findViewById(u8.f.title_container);
        TextView r15 = (TextView) r14.findViewById(u8.f.action_title);
        this.mTitleText = r15;
        if (r15 == null) goto L12;
        r15.setTextColor(getSpecColor(EXTENSION_TITLE));
    L12:
        TextView r16 = (TextView) r14.findViewById(u8.f.action_sub_title);
        this.mSubTitleText = r16;
        if (r16 == null) goto L15;
        r16.setTextColor(getSpecColor(EXTENSION_SUBTITLE));
    L15:
        View r19 = r14.findViewById(u8.f.top_divider);
        r19.setBackgroundColor(getSpecColor(DIVIDER_LINE));
        Intrinsics.checkNotNullExpressionValue(r19, "divider");
        int r20 = 4;
        r19.setVisibility(4);
        CharSequence r21 = this.mTitle;
        if (r21 == null) goto L26;
        TextView r110 = this.mTitleText;
        if (r110 == null) goto L20;
        r110.setText(r21);
    L20:
        TextView r22 = this.mTitleText;
        if (r22 == null) goto L23;
        r22.setVisibility(0);
    L23:
        TextView r23 = this.mSubTitleText;
        if (r23 == null) goto L32;
        r23.setMaxLines(1);
    L32:
        CharSequence r24 = this.mSubTitle;
        if (r24 == null) goto L40;
        TextView r111 = this.mSubTitleText;
        if (r111 == null) goto L37;
        r111.setText(r24);
    L37:
        TextView r25 = this.mSubTitleText;
        if (r25 == null) goto L44;
        r25.setVisibility(0);
    L44:
        if (this.mTitle == null) goto L46;
    L48:
        TextView r26 = (TextView) r17.findViewById(u8.f.cancel_action);
        if (r26 == null) goto L51;
        r26.setTextColor(getSpecColor(ITEM_TITLE));
    L51:
        Intrinsics.checkNotNullExpressionValue(r26, "cancelAction");
        r26.setAccessibilityDelegate(new d());
        r26.setOnClickListener(new e(this));
        this.mActionContainer = (LinearLayout) r17.findViewById(u8.f.action_container);
        Iterator<T> r27 = this.mActions.iterator();
    L53:
        if (r27.hasNext() == false) goto L82;
        a r28 = (a) r27.next();
        View r112 = LayoutInflater.from(getContext()).inflate(h.o_item_action_sheet, this.mActionContainer, false);
        r112.setOnClickListener(new c(r28, this, r14));
        TextView r113 = (TextView) r112.findViewById(u8.f.action_title);
        TextView r114 = (TextView) r112.findViewById(u8.f.action_sub_title);
        View r115 = r112.findViewById(u8.f.top_divider);
        if (r113 == null) goto L57;
        r113.setTextColor(getSpecColor(ITEM_TITLE));
    L57:
        if (r114 == null) goto L59;
        r114.setTextColor(getSpecColor(ITEM_SUBTITLE));
    L59:
        if (r115 == null) goto L62;
        r115.setBackgroundColor(getSpecColor(DIVIDER_LINE));
    L62:
        if (this.mActions.indexOf(r28) != 0) goto L66;
        Intrinsics.checkNotNullExpressionValue(r14, "titleContainer");
        if (r14.getVisibility() != 8) goto L66;
        Intrinsics.checkNotNullExpressionValue(r115, "itemDivider");
        r115.setVisibility(r20);
    L68:
        if (r28.d() == null) goto L70;
        Intrinsics.checkNotNullExpressionValue(r113, "titleText");
        r113.setText(r28.d());
        r113.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(r112, "actionView");
        r112.setContentDescription(r28.d());
        Intrinsics.checkNotNullExpressionValue(r114, "subTitleText");
        r114.setMaxLines(1);
    L72:
        if (r28.c() == null) goto L74;
        r114.setText(r28.c());
        r114.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(r112, "actionView");
        r112.setContentDescription(r112.getContentDescription() + ", " + r28.c());
    L76:
        if (r28.a() == false) goto L78;
        r113.setTextColor(ContextCompat.getColor(requireContext(), u8.c.Negative));
    L78:
        Intrinsics.checkNotNullExpressionValue(r112, "actionView");
        r112.setAccessibilityDelegate(new f(r28));
        LinearLayout r29 = this.mActionContainer;
        if (r29 == null) goto L81;
        r29.addView(r112);
    L81:
        r20 = 4;
        goto L53
    L74:
        r114.setVisibility(8);
        goto L76
    L70:
        Intrinsics.checkNotNullExpressionValue(r113, "titleText");
        r113.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(r114, "subTitleText");
        r114.setMaxLines(2);
    L66:
        Intrinsics.checkNotNullExpressionValue(r115, "itemDivider");
        r115.setVisibility(0);
        goto L68
    L82:
        return;
    L46:
        if (this.mSubTitle != null) goto L48;
        Intrinsics.checkNotNullExpressionValue(r14, "titleContainer");
        r14.setVisibility(8);
        goto L48
    L40:
        TextView r30 = this.mSubTitleText;
        if (r30 == null) goto L44;
        r30.setVisibility(8);
        goto L44
    L26:
        TextView r31 = this.mTitleText;
        if (r31 == null) goto L29;
        r31.setVisibility(8);
    L29:
        TextView r32 = this.mSubTitleText;
        if (r32 == null) goto L32;
        r32.setMaxLines(2);
        goto L32
    L5:
        r11 = requireContext();
        r12 = u8.e.o_action_sheet_const_bg;
        goto L6
    }

    public final boolean removeOnDismissListener(DialogInterface.OnDismissListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        return this.onDismissListeners.remove(r10);
    }

    public final void setMActionContainer(LinearLayout r10) {
        this.mActionContainer = r10;
    }

    public final void setMCancelBtnClickListener(View.OnClickListener r10) {
        this.mCancelBtnClickListener = r10;
    }

    public final void setMSubTitle(CharSequence r10) {
        this.mSubTitle = r10;
    }

    public final void setMSubTitleText(TextView r10) {
        this.mSubTitleText = r10;
    }

    public final void setMTitle(CharSequence r10) {
        this.mTitle = r10;
    }

    public final void setMTitleText(TextView r10) {
        this.mTitleText = r10;
    }
}
