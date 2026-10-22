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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "使用 OInsetSheet")
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0003@ABB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u001a\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u000e\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&0\nj\b\u0012\u0004\u0012\u00020&`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "()V", "mActionContainer", "Landroid/widget/LinearLayout;", "getMActionContainer", "()Landroid/widget/LinearLayout;", "setMActionContainer", "(Landroid/widget/LinearLayout;)V", "mActions", "Ljava/util/ArrayList;", "Lcom/obric/oui/sheet/OActionSheet$Action;", "Lkotlin/collections/ArrayList;", "mCancelBtnClickListener", "Landroid/view/View$OnClickListener;", "getMCancelBtnClickListener", "()Landroid/view/View$OnClickListener;", "setMCancelBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "mSubTitle", "", "getMSubTitle", "()Ljava/lang/CharSequence;", "setMSubTitle", "(Ljava/lang/CharSequence;)V", "mSubTitleText", "Landroid/widget/TextView;", "getMSubTitleText", "()Landroid/widget/TextView;", "setMSubTitleText", "(Landroid/widget/TextView;)V", "mTitle", "getMTitle", "setMTitle", "mTitleText", "getMTitleText", "setMTitleText", "onDismissListeners", "Landroid/content/DialogInterface$OnDismissListener;", "addOnDismissListener", "", "listener", "getSpecColor", "", MemoryInfoSectionEditActivity.KIND_SCENE, "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "removeOnDismissListener", "", "Action", "Companion", "OActionSheetBuilder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00128\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RL\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet$Action;", "", "title", "", "subTitle", "highlight", "", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "Landroidx/fragment/app/DialogFragment;", "dialog", "", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/jvm/functions/Function2;)V", "getHighlight", "()Z", "setHighlight", "(Z)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "setOnClick", "(Lkotlin/jvm/functions/Function2;)V", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "getTitle", "setTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f14460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f14461b;
        private boolean c;
        private Function2<? super View, ? super DialogFragment, Unit> d;

        public final CharSequence a() {
            return this.f14460a;
        }

        public final CharSequence b() {
            return this.f14461b;
        }

        public final boolean c() {
            return this.c;
        }

        public final Function2<View, DialogFragment, Unit> d() {
            return this.d;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet$Companion;", "", "()V", "DIVIDER_LINE", "", "DIVIDER_VIEW", "EXTENSION_SUBTITLE", "EXTENSION_TITLE", "ITEM_SUBTITLE", "ITEM_TITLE", "TAG", "build", "Lcom/obric/oui/sheet/OActionSheet;", "block", "Lkotlin/Function1;", "Lcom/obric/oui/sheet/OActionSheet$OActionSheetBuilder;", "", "Lkotlin/ExtensionFunctionType;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/sheet/OActionSheet$onViewCreated$1", "Landroid/view/View$AccessibilityDelegate;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "host");
            Intrinsics.checkNotNullParameter(r3, "info");
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName((CharSequence) ZeusTransformUtils.preCheckCast("android.widget.ImageButton", CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/sheet/OActionSheet$onViewCreated$3$2", "Landroid/view/View$AccessibilityDelegate;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14462a;

        d(a r1) {
            this.f14462a = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r4, AccessibilityNodeInfo r5) {
            Intrinsics.checkNotNullParameter(r4, "host");
            Intrinsics.checkNotNullParameter(r5, "info");
            super.onInitializeAccessibilityNodeInfo(r4, r5);
            r5.setClassName((CharSequence) ZeusTransformUtils.preCheckCast("android.widget.ImageButton", CharSequence.class, "com.obric.memorydata.plugin"));
            if (this.f14462a.c() == false) goto L6;
            r4.setSelected(true);
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

    public static final /* synthetic */ void access$setMActions$p(OActionSheet r0, ArrayList r1) {
        r0.mActions = r1;
    }

    private final int getSpecColor(String r5) {
        switch(r5.hashCode()) {
            case -1951390164: goto L39;
            case -1672427580: goto L32;
            case -1210163878: goto L25;
            case -1209866229: goto L18;
            case 1704015448: goto L12;
            case 1915336728: goto L6;
            default: goto L46;
        };
    L46:
        int r6 = 0;
    L48:
        return ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6);
    L6:
        if (r5.equals(EXTENSION_SUBTITLE) == false) goto L46;
        if (getAutoSwitchDayNight() == true) goto L36;
    L37:
        r6 = ZeusTransformUtils.mapRes(R.color.TextReverse3, TypedValues.Custom.S_COLOR, "TextReverse3");
    L36:
        r6 = ZeusTransformUtils.mapRes(R.color.TextTertiary, TypedValues.Custom.S_COLOR, "TextTertiary");
        goto L48
    L12:
        if (r5.equals(EXTENSION_TITLE) == false) goto L46;
        if (getAutoSwitchDayNight() == false) goto L37;
    L18:
        if (r5.equals(DIVIDER_VIEW) == false) goto L46;
        if (getAutoSwitchDayNight() == false) goto L23;
        int r7 = R.color.BGPlaceholderDefault;
        String r0 = "BGPlaceholderDefault";
    L45:
        r6 = ZeusTransformUtils.mapRes(r7, TypedValues.Custom.S_COLOR, r0);
        goto L48
    L23:
        r7 = R.color.BGInputReverse;
        r0 = "BGInputReverse";
        goto L45
    L25:
        if (r5.equals(DIVIDER_LINE) == false) goto L46;
        if (getAutoSwitchDayNight() == false) goto L30;
        r7 = R.color.LinePrimary;
        r0 = "LinePrimary";
        goto L45
    L30:
        r7 = R.color.LineReverse2;
        r0 = "LineReverse2";
        goto L45
    L32:
        if (r5.equals(ITEM_SUBTITLE) == false) goto L46;
        if (getAutoSwitchDayNight() == false) goto L37;
    L39:
        if (r5.equals(ITEM_TITLE) == false) goto L46;
        if (getAutoSwitchDayNight() == false) goto L44;
        r7 = R.color.TextPrimary;
        r0 = "TextPrimary";
        goto L45
    L44:
        r7 = R.color.TextReverse;
        r0 = "TextReverse";
        goto L45
    }

    public static /* synthetic */ void lambda$8_Dz1BGVTp9wfUk_M9d2zaF1fY8(OActionSheet r0, View r1) {
        m1358onViewCreated$lambda2(r0, r1);
    }

    public static /* synthetic */ void lambda$EDKQ_gtAcfcX6ERAMQYIh3tZx_E(a r0, OActionSheet r1, View r2) {
        m1359onViewCreated$lambda4$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    private static final void m1358onViewCreated$lambda2(OActionSheet r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        View.OnClickListener r0 = r1.mCancelBtnClickListener;
        if (r0 == null) goto L6;
        r0.onClick(r2);
    L6:
        r1.dismissAllowingStateLoss();
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-3, reason: not valid java name */
    private static final void m1359onViewCreated$lambda4$lambda3(a r1, OActionSheet r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "$action");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Function2<View, DialogFragment, Unit> r4 = r1.d();
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r4.invoke(r3, r2);
    L6:
        r2.dismissAllowingStateLoss();
    }

    public final void addOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onDismissListeners.add(r4);
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
    public Dialog onCreateDialog(Bundle r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext()");
        OBasePanelDialog r7 = new OBasePanelDialog(r0, 0, 2, null);
        r7.setExpandable(false);
        r7.setRemoveMinHeight(true);
        r7.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        return (Dialog) ZeusTransformUtils.preCheckCast(r7, Dialog.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return ZeusTransformUtils.inflate(r2, ZeusTransformUtils.mapRes(R.layout.o_view_action_sheet, "layout", "o_view_action_sheet"), r3, false, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dialog");
        super.onDismiss(r5);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.onDismissListeners, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(r3.next(), DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin")).onDismiss(r5);
        goto L4
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (ZeusTransformUtils.instanceOf(getDialog(), OBasePanelDialog.class) == false) goto L6;
        Dialog r2 = getDialog();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
        ((OBasePanelDialog) ZeusTransformUtils.preCheckCast(r2, OBasePanelDialog.class, "com.obric.memorydata.plugin")).hideHeader();
        return;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r18, Bundle r19) {
        final OActionSheet r0 = this;
        Intrinsics.checkNotNullParameter(r18, "view");
        super.onViewCreated(r18, r19);
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.action_sheet_layout, OaidModel.KEY_ID, "action_sheet_layout")), LinearLayout.class, "com.obric.memorydata.plugin");
        if (getAutoSwitchDayNight() == false) goto L5;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r7 = R.drawable.o_action_sheet_daynight_bg;
        String r8 = "o_action_sheet_daynight_bg";
    L6:
        Drawable r5 = ContextCompat.getDrawable(r4, ZeusTransformUtils.mapRes(r7, "drawable", r8));
        if (r2 == null) goto L10;
        r2.setBackground(r5);
    L10:
        r18.findViewById(ZeusTransformUtils.mapRes(R.id.divider_view, OaidModel.KEY_ID, DIVIDER_VIEW)).setBackgroundColor(r0.getSpecColor(DIVIDER_VIEW));
        LinearLayout r3 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.title_container, OaidModel.KEY_ID, "title_container")), LinearLayout.class, "com.obric.memorydata.plugin");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.action_title, OaidModel.KEY_ID, "action_title")), TextView.class, "com.obric.memorydata.plugin");
        r0.mTitleText = r6;
        if (r6 == null) goto L14;
        r6.setTextColor(r0.getSpecColor(EXTENSION_TITLE));
    L14:
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.action_sub_title, OaidModel.KEY_ID, "action_sub_title")), TextView.class, "com.obric.memorydata.plugin");
        r0.mSubTitleText = r9;
        if (r9 == null) goto L18;
        r9.setTextColor(r0.getSpecColor(EXTENSION_SUBTITLE));
    L18:
        View r10 = r3.findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, OaidModel.KEY_ID, "top_divider"));
        r10.setBackgroundColor(r0.getSpecColor(DIVIDER_LINE));
        r10.setVisibility(4);
        CharSequence r11 = r0.mTitle;
        boolean r13 = false;
        if (r11 == null) goto L32;
        TextView r15 = r0.mTitleText;
        if (r15 == null) goto L24;
        r15.setText(r11);
    L24:
        TextView r12 = r0.mTitleText;
        if (r12 == null) goto L28;
        r12.setVisibility(0);
    L28:
        TextView r14 = r0.mSubTitleText;
        if (r14 == null) goto L40;
        r14.setMaxLines(1);
    L40:
        CharSequence r16 = r0.mSubTitle;
        if (r16 == null) goto L50;
        TextView r17 = r0.mSubTitleText;
        if (r17 == null) goto L46;
        r17.setText(r16);
    L46:
        TextView r20 = r0.mSubTitleText;
        if (r20 == null) goto L55;
        r20.setVisibility(0);
    L55:
        if (r0.mTitle == null) goto L57;
    L59:
        TextView r21 = (TextView) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.cancel_action, OaidModel.KEY_ID, "cancel_action")), TextView.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L63;
        r21.setTextColor(r0.getSpecColor(ITEM_TITLE));
    L63:
        r21.setAccessibilityDelegate((View.AccessibilityDelegate) ZeusTransformUtils.preCheckCast(new c(), View.AccessibilityDelegate.class, "com.obric.memorydata.plugin"));
        r21.setOnClickListener(new $$Lambda$OActionSheet$8_Dz1BGVTp9wfUk_M9d2zaF1fY8(r0));
        r0.mActionContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.action_container, OaidModel.KEY_ID, "action_container")), LinearLayout.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.mActions, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L65:
        if (r1.hasNext() == false) goto L98;
        final a r22 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");
        View r110 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_action_sheet, "layout", "o_item_action_sheet"), (ViewGroup) ZeusTransformUtils.preCheckCast(getMActionContainer(), ViewGroup.class, "com.obric.memorydata.plugin"), r13, "com.obric.memorydata.plugin");
        r110.setOnClickListener(new $$Lambda$OActionSheet$EDKQ_gtAcfcX6ERAMQYIh3tZx_E(r22, r0));
        TextView r111 = (TextView) ZeusTransformUtils.preCheckCast(r110.findViewById(ZeusTransformUtils.mapRes(R.id.action_title, OaidModel.KEY_ID, "action_title")), TextView.class, "com.obric.memorydata.plugin");
        TextView r112 = (TextView) ZeusTransformUtils.preCheckCast(r110.findViewById(ZeusTransformUtils.mapRes(R.id.action_sub_title, OaidModel.KEY_ID, "action_sub_title")), TextView.class, "com.obric.memorydata.plugin");
        View r113 = r110.findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, OaidModel.KEY_ID, "top_divider"));
        if (r111 == null) goto L70;
        r111.setTextColor(r0.getSpecColor(ITEM_TITLE));
    L70:
        if (r112 == null) goto L73;
        r112.setTextColor(r0.getSpecColor(ITEM_SUBTITLE));
    L73:
        if (r113 == null) goto L77;
        r113.setBackgroundColor(r0.getSpecColor(DIVIDER_LINE));
    L77:
        if (r0.mActions.indexOf(r22) == 0) goto L79;
    L81:
        int r114 = 0;
        r113.setVisibility(0);
    L83:
        if (r22.a() == null) goto L85;
        r111.setText(r22.a());
        r111.setVisibility(r114);
        r110.setContentDescription(r22.a());
        r112.setMaxLines(1);
    L87:
        if (r22.b() == null) goto L89;
        r112.setText(r22.b());
        r112.setVisibility(0);
        r110.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r110.getContentDescription() + ", " + r22.b(), CharSequence.class, "com.obric.memorydata.plugin"));
    L91:
        if (r22.c() == false) goto L93;
        r111.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Negative, TypedValues.Custom.S_COLOR, "Negative")));
    L93:
        r110.setAccessibilityDelegate((View.AccessibilityDelegate) ZeusTransformUtils.preCheckCast(new d(r22), View.AccessibilityDelegate.class, "com.obric.memorydata.plugin"));
        LinearLayout r23 = getMActionContainer();
        if (r23 == null) goto L97;
        r23.addView(r110);
    L97:
        r13 = false;
        r0 = this;
        goto L65
    L89:
        r112.setVisibility(8);
        goto L91
    L85:
        r111.setVisibility(8);
        r112.setMaxLines(2);
        goto L87
    L79:
        if (r3.getVisibility() != 8) goto L81;
        r113.setVisibility(4);
        r114 = 0;
        goto L83
    L98:
        return;
    L57:
        if (r0.mSubTitle != null) goto L59;
        r3.setVisibility(8);
        goto L59
    L50:
        TextView r24 = r0.mSubTitleText;
        if (r24 == null) goto L55;
        r24.setVisibility(8);
        goto L55
    L32:
        TextView r25 = r0.mTitleText;
        if (r25 == null) goto L36;
        r25.setVisibility(8);
    L36:
        TextView r26 = r0.mSubTitleText;
        if (r26 == null) goto L40;
        r26.setMaxLines(2);
        goto L40
    L5:
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r7 = R.drawable.o_action_sheet_const_bg;
        r8 = "o_action_sheet_const_bg";
        goto L6
    }

    public final boolean removeOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        return this.onDismissListeners.remove(r4);
    }

    public final void setMActionContainer(LinearLayout r1) {
        this.mActionContainer = r1;
    }

    public final void setMCancelBtnClickListener(View.OnClickListener r3) {
        this.mCancelBtnClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    public final void setMSubTitle(CharSequence r3) {
        this.mSubTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public final void setMSubTitleText(TextView r1) {
        this.mSubTitleText = r1;
    }

    public final void setMTitle(CharSequence r3) {
        this.mTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public final void setMTitleText(TextView r1) {
        this.mTitleText = r1;
    }
}
