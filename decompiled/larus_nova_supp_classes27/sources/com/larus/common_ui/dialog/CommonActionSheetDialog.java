package com.larus.common_ui.dialog;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\u00020\u0001:\u0003HIJB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0006H\u0016J$\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0016J\u001c\u0010%\u001a\u00020\u0007*\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u001c\u0010+\u001a\u00020\u0007*\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u001c\u0010,\u001a\u00020\u0007*\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J \u0010-\u001a\u00020.2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010/\u001a\u00020\rH\u0002J(\u00100\u001a\u00020.2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0010H\u0002JD\u00103\u001a\u00020.2\u0006\u0010'\u001a\u00020(2\u0006\u00104\u001a\u00020\r2\b\b\u0001\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010)\u001a\u00020*2\b\b\u0003\u0010:\u001a\u00020\u0006H\u0002J\u0018\u0010;\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0017H\u0002J'\u0010>\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010\u00062\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010C\u001a\u00020D2\b\b\u0001\u0010E\u001a\u00020\u0006H\u0002J\u001a\u0010F\u001a\u00020G2\u0006\u0010)\u001a\u00020*2\b\b\u0001\u0010:\u001a\u00020\u0006H\u0002R*\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/common_ui/dialog/CommonActionSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onFinish", "Lkotlin/Function1;", "", "", "getOnFinish", "()Lkotlin/jvm/functions/Function1;", "setOnFinish", "(Lkotlin/jvm/functions/Function1;)V", "sheetTitle", "", "items", "", "Lcom/larus/common_ui/dialog/CommonActionSheetDialog$Item;", "cancelTitle", "cancelAction", "Lkotlin/Function0;", "hasCompleted", "", "bottomSafeAreaView", "Landroid/view/View;", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "addActionGroup", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "colors", "Lcom/larus/common_ui/dialog/CommonActionSheetDialog$StyleColors;", "addGap", "addCancelRow", "createTitleView", "Landroid/widget/TextView;", "title", "createItemRow", "index", "item", "createRowView", "text", "textColor", "textSizeDp", "", "typeface", "Landroid/graphics/Typeface;", "normalBackgroundColor", "createDivider", "setupBottomInsets", "root", "complete", "selectedIndex", "action", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "resolveColors", "topRoundedDrawable", "Landroid/graphics/drawable/GradientDrawable;", "color", "rowSelector", "Landroid/graphics/drawable/StateListDrawable;", "Item", "StyleColors", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonActionSheetDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int j = 0;
    public String d;
    public List<b> e;
    public String f;
    public Function0<Unit> g;
    public boolean h;
    public View i;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Integer b;
        public final Function0<Unit> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Integer r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Function0<Unit> r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Item(title=" + this.a + ", textColor=" + this.b + ", action=" + this.c + ')';
        }

        public b(String r2, Integer r3, com.bytedance.applet.impl.p0 r4) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "StyleColors(groupBackgroundColor=" + this.a + ", itemBackgroundColor=" + this.b + ", pressedBackgroundColor=" + this.c + ", itemTextColor=" + this.d + ", titleTextColor=" + this.e + ", separatorColor=" + this.f + ')';
        }

        public c(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public CommonActionSheetDialog() {
        this.e = CollectionsKt.emptyList();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Context r0 = getContext();
        if (r0 == null) goto L23;
        c r1 = U90(r0);
        BottomSheetDialog r2 = getDialog();
        if ((r2 instanceof BottomSheetDialog) == false) goto L8;
        BottomSheetDialog r3 = r2;
    L9:
        if (r3 == null) goto L14;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L14;
        r4.setNavigationBarColor(r1.b);
    L14:
        if (r3 == null) goto L16;
        r3.setCanceledOnTouchOutside(true);
    L16:
        if (r3 == null) goto L21;
        View r5 = r3.findViewById(2131368870);
        if (r5 == null) goto L22;
        r5.setBackgroundColor(0);
        BottomSheetBehavior r6 = BottomSheetBehavior.from(r5);
        r6.setState(3);
        r6.setSkipCollapsed(true);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public static c U90(Context r8) {
        return new c(v19.c.a(2130970531, r8, 2131102535), v19.c.a(2130970532, r8, 2131102539), v19.c.a(2130972118, r8, 2131103188), v19.c.a(2130972079, r8, 2131103136), v19.c.a(2130972081, r8, 2131103143), v19.c.a(2130972087, r8, 2131103162));
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        S90(null, this.g);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        S90(null, this.g);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void S90(Integer r1, Function0<Unit> r2) {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        if (r2 == null) goto L9;
        r2.invoke();
        return;
    }

    public final View onCreateView(LayoutInflater r20, ViewGroup r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r20, "inflater");
        Context r1 = requireContext();
        c r9 = U90(r1);
        LinearLayout r10 = new LinearLayout(r1);
        r10.setOrientation(1);
        r10.setBackgroundColor(0);
        LinearLayout r13 = new LinearLayout(r1);
        r13.setOrientation(1);
        int r2 = r9.b;
        GradientDrawable r3 = new GradientDrawable();
        r3.setColor(r2);
        float r4 = c7.b(24);
        r3.setCornerRadii(new float[]{r4, r4, r4, r4, 0.0f, 0.0f, 0.0f, 0.0f});
        r13.setBackground(r3);
        r13.setClipToOutline(true);
        r10.addView(r13, new LinearLayout.LayoutParams(-1, -2));
        String r5 = this.d;
        if (r5 == null) goto L5;
        String r6 = StringsKt.trim(r5).toString();
    L6:
        String r7 = r6;
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L17;
        TextView r11 = T90(r1, r7, r9.e, 12.0f, Typeface.DEFAULT_BOLD, r9, 0);
        r11.setClickable(false);
        r11.setFocusable(false);
        r11.setBackground(new ColorDrawable(0));
        r13.addView(r11);
        if ((!this.e.isEmpty()) == false) goto L17;
        View r12 = new View(r1);
        r12.setBackgroundColor(r9.f);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        r13.addView(r12);
    L17:
        Iterator<T> r16 = this.e.iterator();
        int r14 = 0;
    L19:
        if (r16.hasNext() == false) goto L31;
        Object r15 = r16.next();
        int r17 = r14 + 1;
        if (r14 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        final b r18 = (b) r15;
        String r23 = r18.a;
        Integer r24 = r18.b;
        if (r24 == null) goto L26;
        int r25 = r24.intValue();
    L27:
        final int r110 = r14;
        TextView r26 = T90(r1, r23, r25, 16.0f, Typeface.DEFAULT_BOLD, r9, 0);
        r26.setOnClickListener(new w(this, r110, r18));
        r13.addView(r26);
        if (r110 == CollectionsKt.getLastIndex(this.e)) goto L30;
        View r27 = new View(r1);
        r27.setBackgroundColor(r9.f);
        r27.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        r13.addView(r27);
    L30:
        r14 = r17;
        goto L19
    L26:
        r25 = r9.d;
        goto L27
    L31:
        View r28 = new View(r1);
        r28.setBackgroundColor(r9.a);
        r10.addView(r28, new LinearLayout.LayoutParams(-1, c7.b(8)));
        String r30 = this.f;
        if (r30 != null) goto L34;
        r30 = r1.getString(2131900590);
    L34:
        TextView r31 = T90(r1, r30, r9.d, 16.0f, Typeface.DEFAULT_BOLD, r9, r9.b);
        r31.setOnClickListener(new x(this));
        r10.addView(r31);
        View r32 = new View(r1);
        r32.setBackgroundColor(r9.b);
        this.i = r32;
        r10.addView(r32, new LinearLayout.LayoutParams(-1, 0));
        ViewCompat.setOnApplyWindowInsetsListener(r10, new v(this));
        ViewCompat.requestApplyInsets(r10);
        return r10;
    L9:
        if (r7.length() == 0) goto L12;
        r8 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public static TextView T90(Context r3, String r4, int r5, float r6, Typeface r7, c r8, int r9) {
        TextView r0 = new TextView(r3);
        r0.setGravity(17);
        r0.setIncludeFontPadding(false);
        r0.setMaxLines(2);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setPadding(c7.b(16), 0, c7.b(16), 0);
        r0.setText(r4);
        r0.setTextColor(r5);
        r0.setTextSize(1, r6);
        r0.setTypeface(r7);
        StateListDrawable r10 = new StateListDrawable();
        r10.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(r8.c));
        r10.addState(new int[0], new ColorDrawable(r9));
        r0.setBackground(r10);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, c7.b(56)));
        return r0;
    }
}
