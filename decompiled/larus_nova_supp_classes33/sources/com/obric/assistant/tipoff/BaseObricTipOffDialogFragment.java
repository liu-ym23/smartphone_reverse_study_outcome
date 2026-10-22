package com.obric.assistant.tipoff;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.common_ui.widget.MaxHeightScrollView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0004J\b\u0010\u0015\u001a\u00020\tH\u0004J(\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0004J4\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0018H\u0002J \u0001\u0010$\u001a\u00020\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00101\u001a\u00020\u001dH\u0084@¢\u0006\u0002\u00102R\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00064"}, d2 = {"Lcom/obric/assistant/tipoff/BaseObricTipOffDialogFragment;", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "showNow", "configDialogWindow", "setTransparentWindowBackground", "applyNavigationBarInsets", "containerLayout", "Landroid/view/View;", "scrollContentView", "Lcom/larus/common_ui/widget/MaxHeightScrollView;", "scrollBoundaryDivider", "updateScrollContentMaxHeight", "", "keyboardOffset", "state", "Lcom/obric/assistant/tipoff/BaseObricTipOffDialogFragment$ScrollContentHeightState;", "calculateFixedContainerHeight", "calculateViewOccupiedHeight", "view", "reportFeedbackToObric", "tagList", "", "content", "messageIdList", "filePathList", "omniTaskId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "isConsentChecked", "score", "needUploadImage", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ScrollContentHeightState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseObricTipOffDialogFragment extends BaseTipOffDialog {
    public static final /* synthetic */ int d = 0;

    public static final class a {
        public boolean a;
        public Integer b;
        public Integer c;

        public a() {
        }
    }

    public abstract String getLogTag();

    public final void Y90() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        WindowCompat.setDecorFitsSystemWindows(r1, false);
        r1.setSoftInputMode(48);
        r1.setStatusBarColor(0);
        r1.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r1.setStatusBarContrastEnforced(false);
        r1.setNavigationBarContrastEnforced(false);
        return;
    L12:
        return;
    L11:
        return;
    }

    public BaseObricTipOffDialogFragment() {
    }

    public static final boolean U90(WindowInsetsAnimationCompat r1) {
        if ((r1.getTypeMask() & WindowInsetsCompat.Type.ime()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int X90(View r5) {
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        Integer r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        int r3 = 0;
        if (r1 == null) goto L9;
        int r4 = r1.height;
    L10:
        Integer r6 = Integer.valueOf(r4);
        if (r6.intValue() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        r2 = r6;
    L16:
        if (r2 == null) goto L18;
        int r8 = r2.intValue();
    L19:
        int r9 = Math.max(r5.getMeasuredHeight(), r8);
        if (r1 == null) goto L22;
        int r10 = r1.topMargin;
    L23:
        int r11 = r9 + r10;
        if (r1 == null) goto L27;
        r3 = r1.bottomMargin;
    L27:
        return r11 + r3;
    L22:
        r10 = 0;
        goto L23
    L18:
        r8 = 0;
        goto L19
    L13:
        r7 = false;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        setStyle(2, 2131953744);
    }

    public static final boolean V90(Set<WindowInsetsAnimationCompat> r1, Set<WindowInsetsAnimationCompat> r2) {
        if ((!r1.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!r2.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final int show(FragmentTransaction r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "transaction");
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r6, r1);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, r1) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        return super/*androidx.fragment.app.DialogFragment*/.show(r5, r6);
    L17:
        return -1;
    L9:
        e = move-exception;
        FLogger.a.e(getLogTag(), "show error: " + e.getMessage(), e);
        return -1;
    }

    public final void showNow(FragmentManager r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r5, r0);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        super/*androidx.fragment.app.DialogFragment*/.showNow(r4, r5);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.a.e(getLogTag(), "showNow error: " + e.getMessage(), e);
    }

    public final void show(FragmentManager r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r5, r0);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        super/*androidx.fragment.app.DialogFragment*/.show(r4, r5);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.a.e(getLogTag(), "show error: " + e.getMessage(), e);
    }

    public static boolean Z90(View r8, MaxHeightScrollView r9, View r10, int r11, a r12) {
        if (r9 != null) goto L6;
        return true;
    L6:
        if (ViewCompat.isAttachedToWindow(r8) == true) goto L8;
    L85:
        return true;
    L8:
        if (ViewCompat.isAttachedToWindow(r9) == false) goto L85;
        if (ViewCompat.isLaidOut(r8) == true) goto L13;
    L84:
        return false;
    L13:
        if (ViewCompat.isLaidOut(r9) == false) goto L84;
        Object r1 = r8.getParent();
        ViewGroup r4 = null;
        if ((r1 instanceof View) == false) goto L18;
        View r2 = (View) r1;
    L19:
        if (r2 == null) goto L21;
        int r3 = r2.getHeight();
    L22:
        Integer r5 = Integer.valueOf(r3);
        if (r5.intValue() <= 0) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == true) goto L29;
        r5 = null;
    L29:
        if (r5 == null) goto L31;
        int r7 = r5.intValue();
    L32:
        if (r7 > 0) goto L34;
        return false;
    L34:
        ViewGroup.LayoutParams r13 = r8.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
    L38:
        if (r14 == null) goto L40;
        int r15 = r14.topMargin;
    L41:
        int r16 = (r7 - r15) - r11;
        if ((r8 instanceof ViewGroup) == false) goto L44;
        r4 = (ViewGroup) r8;
    L44:
        int r17 = 8;
        if (r4 != null) goto L47;
        int r18 = 0;
    L57:
        int r19 = r16 - r18;
        View r110 = r9.getChildAt(0);
        if (r110 == null) goto L60;
        int r111 = r110.getMeasuredHeight();
    L61:
        if (r111 <= r19) goto L63;
        boolean r112 = true;
    L64:
        if (r112 == false) goto L66;
        r17 = 0;
    L66:
        if (r10 == null) goto L73;
        Integer r20 = r12.c;
        if (r20 != null) goto L71;
    L72:
        r10.setVisibility(r17);
        r12.c = Integer.valueOf(r17);
        goto L73
    L71:
        if (r20.intValue() != r17) goto L72;
    L73:
        if (r112 == false) goto L76;
        if (r10 == null) goto L76;
        int r21 = X90(r10);
    L77:
        int r22 = Math.max(0, r19 - r21);
        Integer r113 = r12.b;
        if (r113 != null) goto L81;
    L82:
        r9.setMaxHeight(r22);
        r12.b = Integer.valueOf(r22);
    L83:
        return true;
    L81:
        if (r113.intValue() == r22) goto L83;
    L76:
        r21 = 0;
        goto L77
    L63:
        r112 = false;
        goto L64
    L60:
        r111 = 0;
        goto L61
    L47:
        r18 = r4.getPaddingTop() + r4.getPaddingBottom();
        int r23 = r4.getChildCount();
        int r24 = 0;
    L48:
        if (r24 >= r23) goto L57;
        View r25 = r4.getChildAt(r24);
        if (r25 == r9) goto L56;
        if (r25 == r10) goto L56;
        if (r25.getVisibility() == 8) goto L56;
        Intrinsics.checkNotNull(r25);
        r18 = r18 + X90(r25);
    L56:
        r24 = r24 + 1;
        goto L48
    L40:
        r15 = 0;
        goto L41
    L37:
        r14 = null;
        goto L38
    L31:
        r7 = r8.getRootView().getHeight();
        goto L32
    L25:
        r6 = false;
        goto L26
    L21:
        r3 = 0;
        goto L22
    L18:
        r2 = null;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r11v15 */
    public static final void W90(BaseObricTipOffDialogFragment r7, MaxHeightScrollView r8, View r9, a r10, int r11, View r12, WindowInsetsCompat r13) {
        int r0 = r13.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r14 = r11 + r0;
        if (r12.getPaddingBottom() == r14) goto L5;
        r12.setPadding(r12.getPaddingLeft(), r12.getPaddingTop(), r12.getPaddingRight(), r14);
    L5:
        int r6 = Math.max(0, r13.getInsets(WindowInsetsCompat.Type.ime()).bottom - r0);
        float r15 = -r6;
        if (Math.abs(r12.getTranslationY() - r15) > 0.5f) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        r12.setTranslationY(r15);
    L11:
        r7.getClass();
        if (Z90(r12, r8, r9, r6, r10) == false) goto L14;
        return;
    L14:
        if (r10.a == false) goto L16;
        return;
    L16:
        if (ViewCompat.isAttachedToWindow(r12) == false) goto L39;
        r10.a = true;
        if (ViewCompat.isLaidOut(r12) == false) goto L25;
        if (r8 == null) goto L25;
        if (ViewCompat.isLaidOut(r8) == true) goto L25;
        ?? r16 = r8;
    L27:
        if (r16.isLaidOut() == true) goto L29;
    L33:
        r16.addOnLayoutChangeListener(new d(r10, r12, r7, r8, r9, r6));
        return;
    L29:
        if (r16.isLayoutRequested() == true) goto L33;
        r10.a = false;
        if (ViewCompat.isAttachedToWindow(r12) == false) goto L37;
        Z90(r12, r8, r9, r6, r10);
        return;
    L37:
        return;
    L25:
        r16 = r12;
        goto L27
    L39:
        return;
    L8:
        r1 = false;
        goto L9
    }

    public static final void T90(View r10, Ref.ObjectRef r11, BaseObricTipOffDialogFragment r12, MaxHeightScrollView r13, View r14, a r15, int r16, String r17) {
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(r10);
        if (r1 != null) goto L5;
        WindowInsetsCompat r9 = (WindowInsetsCompat) r11.element;
    L6:
        if (r1 == null) goto L9;
        String r2 = "root";
    L12:
        r11.element = null;
        FLogger.a.i(r12.getLogTag(), "Apply final IME insets, reason=" + r17 + ", source=" + r2);
        if (r9 == null) goto L16;
        W90(r12, r13, r14, r15, r16, r10, r9);
        return;
    L16:
        return;
    L9:
        if (r11.element == null) goto L11;
        r2 = "pending";
        goto L12
    L11:
        r2 = "none";
        goto L12
    L5:
        r9 = r1;
        goto L6
    }
}
