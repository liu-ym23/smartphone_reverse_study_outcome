package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ntb.a0;
import ntb.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010,\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J(\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u001a2\u0006\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0BH\u0002J\u0010\u0010C\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\fH\u0002J\u001c\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020F2\b\u0010H\u001a\u0004\u0018\u00010FH\u0002J\u0010\u0010I\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0007H\u0002J \u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\"2\u0006\u0010?\u001a\u00020@2\u0006\u0010M\u001a\u00020\u000bH\u0002J\"\u0010N\u001a\u00020\f2\u0006\u0010L\u001a\u00020\"2\u0006\u0010O\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010Q\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\fH\u0003J\u0012\u0010S\u001a\u00020\u000b2\b\b\u0002\u0010T\u001a\u00020\u000bH\u0002J\b\u0010U\u001a\u00020\fH\u0016J\u0010\u0010\b\u001a\u00020\f2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020FH\u0002J\u0010\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020FH\u0002J\u001a\u0010\\\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u0005H\u0002J\u001a\u0010`\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010a\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "mdMarginDefault", BuildConfig.FLAVOR, "panelOptions", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelOptions;", "onDismiss", "Lkotlin/Function2;", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelPickerResult;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "linkClickResolver", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelLinkClickResolver;", "errorCode", "selectItem", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/SelectPanelItem;", "selectItems", BuildConfig.FLAVOR, "callbackItemId", "selectStyle", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/ItemSelectInfo;", "titleBarLayout", "Landroid/widget/RelativeLayout;", "panelContent", "Landroid/widget/LinearLayout;", "panelTitle", "Landroid/widget/TextView;", "panelDesc", "leftActionLayout", "rightActionLayout", "panelTitleContainer", "dragBar", "Landroid/view/View;", "panelScrollView", "Landroid/widget/ScrollView;", "titleBarDivider", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheet", "initialY", "isDragging", BuildConfig.FLAVOR, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getTheme", "setWindowParam", "options", "setupTitle", "setupActions", "setupActionItem", "layout", "item", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelItem;", "onClick", "Lkotlin/Function0;", "setupMarkdown", "updateTitleContainerPadding", "resolveMarkdownLink", BuildConfig.FLAVOR, "link", "baseUrl", "setupContent", "isContentInvalid", "setupPanelItem", "itemView", "pickerType", "updateItemSelectState", "selected", "panelItem", "setupDragBar", "setupTitleBarDrag", "getStyleColor", "style", "onDestroyView", "dialog", "Landroid/content/DialogInterface;", "getUDResource", "icon", "getUDColor", "colorName", "dp2px", "context", "Landroid/content/Context;", "dpValue", "px2dp", "pxValue", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelBottomDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int y = 0;
    public final float d;
    public PanelOptions e;
    public Function2<? super PanelPickerResult, ? super Integer, Unit> f;
    public int g;
    public g h;
    public final Set<g> i;
    public PanelPickerResult j;
    public ItemSelectInfo k;
    public RelativeLayout l;
    public LinearLayout m;
    public TextView n;
    public TextView o;
    public LinearLayout p;
    public LinearLayout q;
    public LinearLayout r;
    public View s;
    public ScrollView t;
    public View u;
    public View v;
    public float w;
    public boolean x;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PanelBottomDialog a;
        public final /* synthetic */ DisplayMetrics b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ View e;

        public b(PanelBottomDialog r1, DisplayMetrics r2, int r3, int r4, View r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            PanelBottomDialog r0 = this.a;
            RelativeLayout r1 = r0.l;
            LinearLayout r2 = r0.r;
            if (r2 == null) goto L14;
            LinearLayout r4 = r0.p;
            if (r4 == null) goto L8;
            int r5 = r4.getMeasuredWidth();
        L9:
            LinearLayout r3 = r0.q;
            if (r3 == null) goto L12;
            int r6 = r3.getMeasuredWidth();
        L13:
            int r7 = Math.max(r5, r6);
            r2.setPadding(r7, r2.getPaddingTop(), r7, r2.getPaddingBottom());
            goto L14
        L12:
            r6 = 0;
            goto L13
        L8:
            r5 = 0;
        L14:
            ScrollView r8 = this.a.t;
            boolean r9 = true;
            Integer r10 = null;
            if (r8 == null) goto L25;
            Integer r11 = Integer.valueOf(r8.getMeasuredWidth());
            if (r11.intValue() <= 0) goto L19;
            boolean r12 = true;
        L20:
            if (r12 == true) goto L23;
            r11 = null;
        L23:
            if (r11 == null) goto L25;
            int r13 = r11.intValue();
        L37:
            if (r1 == null) goto L39;
            r1.measure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        L39:
            LinearLayout r14 = this.a.m;
            if (r14 == null) goto L42;
            r14.measure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        L42:
            LinearLayout r15 = this.a.m;
            if (r15 == null) goto L45;
            int r16 = r15.getMeasuredHeight();
        L46:
            if (r1 == null) goto L48;
            int r17 = r1.getMeasuredHeight();
        L49:
            View r18 = this.a.s;
            if (r18 == null) goto L52;
            int r19 = r18.getMeasuredHeight();
        L53:
            int r20 = (r16 + r17) + r19;
            PanelBottomDialog r21 = this.a;
            int r22 = r20 + r21.U90(r21.getContext(), 16.0f);
            int r23 = this.c;
            if (r22 >= r23) goto L56;
        L55:
            r22 = r23;
        L59:
            Log.i("LK_API_TAG_PanelBottomDialog", "finalHeight:" + r22);
            ViewGroup.LayoutParams r24 = this.e.getLayoutParams();
            r24.height = r22;
            this.e.setLayoutParams(r24);
            BottomSheetBehavior r25 = BottomSheetBehavior.from(this.e);
            r25.setPeekHeight(r22);
            r25.setDraggable(false);
            return;
        L56:
            r23 = this.d;
            if (r22 <= r23) goto L59;
        L52:
            r19 = 0;
            goto L53
        L48:
            r17 = 0;
            goto L49
        L45:
            r16 = 0;
            goto L46
        L19:
            r12 = false;
        L25:
            View r26 = this.a.getView();
            if (r26 == null) goto L33;
            Integer r27 = Integer.valueOf(r26.getMeasuredWidth());
            if (r27.intValue() > 0) goto L31;
            r9 = false;
        L31:
            if (r9 == false) goto L33;
            r10 = r27;
        L33:
            if (r10 == null) goto L35;
            r13 = r10.intValue();
            goto L37
        L35:
            r13 = this.b.widthPixels;
            goto L37
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public c(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954467;
    }

    public PanelBottomDialog() {
        this.d = 12.0f;
        this.i = new LinkedHashSet();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.f = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        Log.i("LK_API_TAG_PanelBottomDialog", "onDestroyView");
    }

    public static void S90(PanelBottomDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);
        Log.i("LK_API_TAG_PanelBottomDialog", "onDismiss, " + this.j);
        Function2<? super PanelPickerResult, ? super Integer, Unit> r4 = this.f;
        if (r4 == null) goto L6;
        r4.invoke(this.j, Integer.valueOf(this.g));
        return;
    }

    public final int V90(int r3) {
        if (r3 != ColorStyle.Normal.getValue()) goto L6;
        return ContextCompat.getColor(requireContext(), 2131108729);
    L6:
        if (r3 != ColorStyle.Desc.getValue()) goto L9;
        return ContextCompat.getColor(requireContext(), 2131108724);
    L9:
        if (r3 != ColorStyle.Select.getValue()) goto L12;
        return ContextCompat.getColor(requireContext(), 2131108626);
    L12:
        if (r3 != ColorStyle.Warning.getValue()) goto L15;
        return ContextCompat.getColor(requireContext(), 2131108780);
    L15:
        if (r3 != ColorStyle.Disable.getValue()) goto L18;
        return ContextCompat.getColor(requireContext(), 2131108721);
    L18:
        if (r3 != ColorStyle.TRANSLATE.getValue()) goto L21;
        return ContextCompat.getColor(requireContext(), 2131106784);
    L21:
        return ContextCompat.getColor(requireContext(), 2131108729);
    }

    public final int W90(String r9) {
        String r10 = "ud_" + StringsKt.replace$default(r9, '-', '_', false, 4, null);
        Context r0 = getContext();
        if (r0 == null) goto L12;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L12;
        Context r2 = getContext();
        if (r2 == null) goto L10;
        String r3 = r2.getPackageName();
        if (r3 == null) goto L10;
    L11:
        int r11 = r1.getIdentifier(r10, "color", r3);
    L13:
        if (r11 == 0) goto L16;
        return ContextCompat.getColor(requireContext(), r11);
    L16:
        return ContextCompat.getColor(requireContext(), 2131108729);
    L10:
        r3 = BuildConfig.FLAVOR;
    L12:
        r11 = 0;
        goto L13
    }

    public final int X90(String r9) {
        String r10 = "ud_" + StringsKt.replace$default(r9, '-', '_', false, 4, null);
        Context r0 = getContext();
        if (r0 == null) goto L12;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L12;
        Context r2 = getContext();
        if (r2 == null) goto L10;
        String r3 = r2.getPackageName();
        if (r3 == null) goto L10;
    L14:
        return r1.getIdentifier(r10, "drawable", r3);
    L10:
        r3 = BuildConfig.FLAVOR;
    L12:
        return 0;
    }

    public final void Y90(PanelOptions r9) {
        Resources r0 = getResources();
        DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        int r5 = (int) (r4.heightPixels * r9.getMinHeightPercent());
        int r6 = (int) (r4.heightPixels * r9.getMaxHeightPercent());
        Dialog r10 = getDialog();
        if (r10 == null) goto L5;
        View r11 = r10.findViewById(2131368870);
    L6:
        View r7 = r11;
        this.v = r7;
        if (r7 != null) goto L9;
        return;
    L9:
        r7.setBackground(ContextCompat.getDrawable(requireContext(), 2131233302));
        View r12 = getView();
        if (r12 == null) goto L13;
        r12.post(new b(this, r4, r5, r6, r7));
        return;
    L13:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        Log.i("LK_API_TAG_PanelBottomDialog", "onConfigurationChanged");
        PanelOptions r3 = this.e;
        if (r3 == null) goto L6;
        Y90(r3);
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        T90(r2);     // Catch: Throwable -> L5
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

    public final int U90(Context r2, float r3) {
        if (r2 == null) goto L8;
        Resources r4 = r2.getResources();
        if (r4 == null) goto L8;
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        if (r5 == null) goto L8;
        float r6 = r5.density;
    L10:
        return (int) ((r3 * r6) + 0.5f);
    L8:
        r6 = 0.0f;
        goto L10
    }

    public final void onViewCreated(View r33, Bundle r34) {
        Intrinsics.checkNotNullParameter(r33, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r33, r34);
        this.l = (RelativeLayout) r33.findViewById(2131388817);
        this.m = (LinearLayout) r33.findViewById(2131381867);
        this.n = (TextView) r33.findViewById(2131381895);
        this.o = (TextView) r33.findViewById(2131381868);
        this.p = (LinearLayout) r33.findViewById(2131377714);
        this.q = (LinearLayout) r33.findViewById(2131384533);
        this.r = (LinearLayout) r33.findViewById(2131381896);
        this.s = r33.findViewById(2131370203);
        this.t = (ScrollView) r33.findViewById(2131381894);
        this.u = r33.findViewById(2131388814);
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setBackgroundDrawableResource(R.color.transparent);
    L7:
        Dialog r2 = getDialog();
        if (r2 == null) goto L12;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L12;
        r3.setDimAmount(0.6f);
    L12:
        final PanelOptions r7 = this.e;
        if (r7 == null) goto L364;
        ScrollView r4 = this.t;
        if (r4 == null) goto L17;
        r4.setVerticalScrollBarEnabled(r7.getShowScrollBar());
    L17:
        TextView r5 = this.n;
        String r6 = BuildConfig.FLAVOR;
        if (r5 == null) goto L34;
        String r8 = r7.getTitle();
        if (r8 != null) goto L23;
        r8 = BuildConfig.FLAVOR;
    L23:
        r5.setText(r8);
        r5.setTextColor(V90(ColorStyle.Normal.getValue()));
        r5.setMaxLines(r7.getTitleMaxLines());
        String r9 = r7.getTitle();
        if (r9 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == false) goto L32;
        int r11 = 8;
    L33:
        r5.setVisibility(r11);
        goto L34
    L32:
        r11 = 0;
        goto L33
    L26:
        if (r9.length() == 0) goto L29;
        r10 = false;
    L34:
        TextView r12 = this.o;
        if (r12 == null) goto L51;
        String r13 = r7.getDesc();
        if (r13 != null) goto L40;
        r13 = BuildConfig.FLAVOR;
    L40:
        r12.setText(r13);
        r12.setTextColor(V90(ColorStyle.Desc.getValue()));
        String r14 = r7.getDesc();
        if (r14 != null) goto L43;
    L46:
        boolean r15 = true;
    L47:
        if (r15 == false) goto L49;
        int r16 = 8;
    L50:
        r12.setVisibility(r16);
        goto L51
    L49:
        r16 = 0;
        goto L50
    L43:
        if (r14.length() == 0) goto L46;
        r15 = false;
    L51:
        View r17 = this.u;
        if (r17 != null) goto L54;
    L58:
        PanelItem r18 = r7.getLeftAction();
        if (r18 == null) goto L65;
        Boolean r19 = r18.getActionCallback();
        if (r19 == null) goto L63;
        final boolean r20 = r19.booleanValue();
    L64:
        Z90(this.p, r18, new PanelBottomDialog$setupActions$1$1(r20, r7, this));
    L68:
        PanelItem r21 = r7.getRightAction();
        if (r21 == null) goto L75;
        Boolean r22 = r21.getActionCallback();
        if (r22 == null) goto L73;
        final boolean r23 = r22.booleanValue();
    L74:
        Z90(this.q, r21, new PanelBottomDialog$setupActions$3$1(r23, r7, this));
    L78:
        View r24 = this.s;
        if (r24 == null) goto L86;
        if (r7.getShowDragBar() == false) goto L83;
        int r25 = 0;
    L84:
        r24.setVisibility(r25);
        goto L86
    L83:
        r25 = 8;
    L86:
        if (r7.getShowDragBar() == false) goto L90;
        RelativeLayout r26 = this.l;
        if (r26 == null) goto L90;
        r26.setOnTouchListener(new d(this));
    L90:
        LinearLayout r27 = this.m;
        if (r27 == null) goto L93;
        r27.removeAllViews();
    L93:
        List<PanelItem> r28 = r7.getData();
        if (r28 != null) goto L96;
    L99:
        boolean r29 = true;
    L101:
        if (r29 == false) goto L114;
        MarkdownInfo r30 = r7.getMarkdownInfo();
        if (r30 == null) goto L105;
        String r31 = r30.getContent();
    L106:
        if (r31 != null) goto L108;
    L111:
        boolean r32 = true;
    L112:
        if (r32 == false) goto L114;
        boolean r35 = true;
    L116:
        if (r35 == false) goto L118;
        this.g = -1;
        S90(this);
    L356:
        Y90(r7);
        return;
    L118:
        final MarkdownInfo r36 = r7.getMarkdownInfo();
        if (r36 == null) goto L121;
        String r37 = r36.getContent();
    L123:
        if (r36 == null) goto L236;
        if (r37 != null) goto L126;
    L129:
        boolean r38 = true;
    L130:
        if (r38 == true) goto L236;
        Margin r39 = r36.getContentMargin();
        Context r40 = getContext();
        if (r39 == null) goto L137;
        Float r41 = r39.getLeft();
        if (r41 == null) goto L137;
        float r42 = r41.floatValue();
    L138:
        int r43 = U90(r40, r42);
        Context r44 = getContext();
        if (r39 == null) goto L143;
        Float r45 = r39.getTop();
        if (r45 == null) goto L143;
        float r46 = r45.floatValue();
    L144:
        int r47 = U90(r44, r46);
        Context r48 = getContext();
        if (r39 == null) goto L149;
        Float r110 = r39.getRight();
        if (r110 == null) goto L149;
        float r111 = r110.floatValue();
    L150:
        int r49 = U90(r48, r111);
        Context r112 = getContext();
        if (r39 == null) goto L155;
        Float r50 = r39.getBottom();
        if (r50 == null) goto L155;
        float r51 = r50.floatValue();
    L156:
        int r52 = U90(r112, r51);
        DependencyContainer r113 = DependencyContainer.a;
        com.ss.android.lark.officesdk.di.core.b r114 = DependencyContainer.a(q.class, null);
        if ((r114 instanceof q) == true) goto L159;
        r114 = null;
    L159:
        final q r115 = (q) r114;
        if (r115 != null) goto L162;
        Log.w("LK_API_TAG_PanelBottomDialog", "setupMarkdown skipped, markdown dependency is not registered");
        goto L236
    L162:
        int r116 = f.a;
        Function1<String, String> r117 = new PanelBottomDialog$setupMarkdown$markdownConfig$1(this, r36);
        Function1<String, Unit> r118 = new PanelBottomDialog$setupMarkdown$markdownConfig$2(this);
        Function0<Unit> r53 = new PanelBottomDialog$setupMarkdown$markdownConfig$3(this, r7);
        Intrinsics.checkNotNullParameter(r36, "markdownInfo");
        Intrinsics.checkNotNullParameter(r117, "resolveMarkdownLink");
        Intrinsics.checkNotNullParameter(r118, "openUrl");
        Float r54 = r36.getLineHeight();
        if (r54 == null) goto L165;
        float r55 = r54.floatValue();
    L166:
        Float r119 = r36.getLineSpacing();
        if (r119 == null) goto L169;
        float r210 = r119.floatValue();
    L170:
        float r211 = RangesKt.coerceAtLeast(r55 - 2, 1.0f);
        Float r56 = r36.getTextSize();
        if (r56 == null) goto L173;
        float r57 = r56.floatValue();
    L174:
        float r120 = zz7.b.d().getMultiplier() * r57;
        if (Intrinsics.areEqual(r36.getNoBlockSpace(), Boolean.FALSE) == false) goto L177;
        float r212 = 17.0f;
    L178:
        String r58 = r36.getContent();
        if (r58 == null) goto L182;
        r6 = r58;
    L182:
        String r121 = new Regex("(?<=[A-Za-z0-9])\\\\?-(?=[A-Za-z0-9])").replace(r6, "-\u200b");
        String r59 = r36.getTextColor();
        if (r59 == null) goto L188;
        String r60 = f.a(r59);
        if (r60 == null) goto L188;
        String r122 = r60;
    L189:
        String r61 = r36.getLinkColor();
        if (r61 == null) goto L192;
        String r213 = f.a(r61);
    L193:
        String r62 = r36.getListItemColor();
        if (r62 == null) goto L199;
        String r63 = f.a(r62);
        if (r63 == null) goto L199;
        String r214 = r63;
    L200:
        MarkdownListMarginInfo r64 = r36.getListMarginInfo();
        if (r64 == null) goto L205;
        Float r65 = r64.getDotDiameter();
        if (r65 == null) goto L205;
        float r215 = r65.floatValue();
    L206:
        MarkdownListMarginInfo r66 = r36.getListMarginInfo();
        if (r66 == null) goto L211;
        Float r67 = r66.getBulletDotOffset();
        if (r67 == null) goto L211;
        float r216 = r67.floatValue();
    L212:
        MarkdownListMarginInfo r68 = r36.getListMarginInfo();
        if (r68 == null) goto L217;
        Float r69 = r68.getTextStartMargin();
        if (r69 == null) goto L217;
        float r70 = r69.floatValue();
    L223:
        float r217 = r70;
    L225:
        final a0 r71 = new a0(r121, r122, r120, r211, r210, r213, r214, r215, r212, r216, r217, r117, null, r118, r53);
        requireContext();
        final View r72 = r115.n();
        r72.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r73 = this.m;
        if (r73 == null) goto L228;
        r73.addView(r72);
    L228:
        LinearLayout r74 = this.m;
        if (r74 == null) goto L231;
        r74.setPadding(r43, r47, r49, r52);
    L231:
        Function1<Integer, Unit> r123 = new PanelBottomDialog$setupMarkdown$applyMarkdown$1(this, r115, r72, r71, r7);
        if (r72.getWidth() <= 0) goto L234;
        r123.invoke(Integer.valueOf(r72.getWidth()));
    L235:
        Log.i("LK_API_TAG_PanelBottomDialog", "setupMarkdown success");
        boolean r75 = true;
    L237:
        if (r75 == true) goto L247;
        List<PanelItem> r76 = r7.getData();
        if (r76 != null) goto L241;
    L244:
        boolean r77 = true;
    L245:
        if (r77 == false) goto L247;
        this.g = -1;
        S90(this);
        goto L356
    L241:
        if (r76.isEmpty() == true) goto L244;
        r77 = false;
    L247:
        Log.i("LK_API_TAG_PanelBottomDialog", "setupContent start");
        ItemSelectInfo r78 = r7.getItemSelectInfo();
        if (r78 == null) goto L250;
        this.k = r78;
    L250:
        List<PanelItem> r79 = r7.getData();
        if (r79 == null) goto L356;
        Iterator<T> r80 = r79.iterator();
    L254:
        if (r80.hasNext() == false) goto L356;
        PanelItem r81 = (PanelItem) r80.next();
        if (r81.getId() == null) goto L355;
        View r82 = LayoutInflater.from(getContext()).inflate(2131559838, this.m, false);
        Intrinsics.checkNotNull(r82);
        int r83 = r7.getPickerType();
        TextView r84 = (TextView) r82.findViewById(2131375795);
        ImageView r85 = (ImageView) r82.findViewById(2131375790);
        ImageView r86 = (ImageView) r82.findViewById(2131375794);
        ImageView r87 = (ImageView) r82.findViewById(2131375834);
        TextView r124 = (TextView) r82.findViewById(2131375727);
        if (r84 == null) goto L270;
        Text r125 = r81.getLeftText();
        if (r125 == null) goto L269;
        r84.setText(r125.getValue());
        Integer r126 = r125.getStyle();
        if (r126 == null) goto L264;
        int r127 = r126.intValue();
    L265:
        r84.setTextColor(V90(r127));
        r84.setTypeface(r84.getTypeface(), r125.getBold() ? 1 : 0);
        Integer r128 = r125.getMaxLines();
        if (r128 == null) goto L268;
        r84.setMaxLines(r128.intValue());
    L268:
        r84.setVisibility(0);
        goto L270
    L264:
        r127 = ColorStyle.Normal.getValue();
        goto L265
    L269:
        r84.setVisibility(8);
    L270:
        if (r85 == null) goto L286;
        Icon r88 = r81.getLeftIcon();
        if (r88 == null) goto L285;
        String r89 = r88.getUdKey();
        if (r89 == null) goto L285;
        int r90 = X90(r89);
        if (r90 == 0) goto L284;
        r85.setVisibility(0);
        r85.setImageResource(r90);
        Icon r91 = r81.getLeftIcon();
        if (r91 == null) goto L282;
        Integer r92 = r91.getIconStyle();
        if (r92 == null) goto L282;
        int r93 = r92.intValue();
    L283:
        r85.setColorFilter(V90(r93));
    L282:
        r93 = ColorStyle.Normal.getValue();
        goto L283
    L284:
        r85.setVisibility(8);
    L285:
        r85.setVisibility(8);
    L286:
        if (r86 == null) goto L302;
        Icon r94 = r81.getLeftIconTag();
        if (r94 == null) goto L301;
        String r95 = r94.getUdKey();
        if (r95 == null) goto L301;
        int r96 = X90(r95);
        if (r96 == 0) goto L300;
        r86.setVisibility(0);
        r86.setImageResource(r96);
        Icon r97 = r81.getLeftIcon();
        if (r97 == null) goto L298;
        Integer r98 = r97.getIconStyle();
        if (r98 == null) goto L298;
        int r99 = r98.intValue();
    L299:
        r86.setColorFilter(V90(r99));
    L298:
        r99 = ColorStyle.Normal.getValue();
        goto L299
    L300:
        r86.setVisibility(8);
    L301:
        r86.setVisibility(8);
    L302:
        if (r87 == null) goto L318;
        Icon r100 = r81.getRightIcon();
        if (r100 == null) goto L317;
        String r101 = r100.getUdKey();
        if (r101 == null) goto L317;
        int r102 = X90(r101);
        if (r102 == 0) goto L316;
        r87.setVisibility(0);
        r87.setImageResource(r102);
        Icon r103 = r81.getLeftIcon();
        if (r103 == null) goto L314;
        Integer r104 = r103.getIconStyle();
        if (r104 == null) goto L314;
        int r105 = r104.intValue();
    L315:
        r87.setColorFilter(V90(r105));
    L314:
        r105 = ColorStyle.Normal.getValue();
        goto L315
    L316:
        r87.setVisibility(8);
    L317:
        r87.setVisibility(8);
    L318:
        if (r124 == null) goto L328;
        Text r106 = r81.getDesc();
        if (r106 == null) goto L326;
        r124.setText(r106.getValue());
        Integer r107 = r106.getStyle();
        if (r107 == null) goto L324;
        int r108 = r107.intValue();
    L325:
        r124.setTextColor(V90(r108));
        r124.setVisibility(0);
        goto L328
    L324:
        r108 = ColorStyle.Desc.getValue();
        goto L325
    L326:
        r124.setVisibility(8);
    L328:
        ItemSelectInfo r109 = this.k;
        g r129 = new g(r81.getId(), r82, r81);
        if (r83 != 0) goto L331;
        if (r109 == null) goto L347;
        if (TextUtils.equals(r109.getSelectId(), r81.getId()) == false) goto L347;
        this.h = r129;
        aa0(r82, true, r81);
    L347:
        r82.setOnClickListener(new com.ss.android.lark.chameleonv2.lkapi.widget.panel.b(this, r81, r129));
    L348:
        LinearLayout r130 = this.m;
        if (r130 == null) goto L351;
        r130.addView(r82);
        Unit r131 = Unit.INSTANCE;
    L352:
        if (r131 != null) goto L254;
    L351:
        r131 = null;
        goto L352
    L331:
        if (r83 != 1) goto L348;
        if (r109 == null) goto L340;
        List<String> r132 = r109.getSelectIds();
        if (r132 == null) goto L337;
        boolean r133 = CollectionsKt.contains(r132, r81.getId());
    L338:
        if (r133 == false) goto L340;
        this.i.add(r129);
        aa0(r82, true, r81);
        goto L340
    L337:
        r133 = false;
    L340:
        r82.setOnClickListener(new com.ss.android.lark.chameleonv2.lkapi.widget.panel.c(this, r129));
    L355:
        this.g = -1;
        S90(this);
        goto L254
    L234:
        r72.post(new com.ss.android.lark.chameleonv2.lkapi.widget.panel.a(r123, r72));
    L217:
        MarkdownListMarginInfo r134 = r36.getListMarginInfo();
        if (r134 == null) goto L220;
        Float r135 = r134.getListMargin();
    L221:
        if (r135 == null) goto L224;
        r70 = r135.floatValue();
        goto L223
    L224:
        r217 = 14.0f;
        goto L225
    L220:
        r135 = null;
    L211:
        r216 = -3.0f;
    L205:
        r215 = 5.0f;
    L199:
        r214 = "N900-80";
        goto L200
    L192:
        r213 = null;
    L188:
        r122 = "N900-80";
        goto L189
    L177:
        r212 = 0.0f;
        goto L178
    L173:
        r57 = 14.0f;
        goto L174
    L169:
        r210 = 4.0f;
        goto L170
    L165:
        r55 = 25.0f;
    L155:
        r51 = this.d;
    L149:
        r111 = this.d;
    L143:
        r46 = this.d;
    L137:
        r42 = this.d;
        goto L138
    L126:
        if (r37.length() == 0) goto L129;
        r38 = false;
    L236:
        r75 = false;
        goto L237
    L121:
        r37 = null;
        goto L123
    L108:
        if (r31.length() == 0) goto L111;
        r32 = false;
        goto L112
    L105:
        r31 = null;
    L114:
        r35 = false;
        goto L116
    L96:
        if (r28.isEmpty() == true) goto L99;
        r29 = false;
        goto L101
    L73:
        r23 = true;
        goto L74
    L75:
        LinearLayout r136 = this.q;
        if (r136 == null) goto L78;
        r136.setVisibility(8);
        goto L78
    L63:
        r20 = false;
        goto L64
    L65:
        LinearLayout r137 = this.p;
        if (r137 == null) goto L68;
        r137.setVisibility(8);
        goto L68
    L54:
        if (r7.getShowTitleDivider() == false) goto L56;
        int r138 = 0;
    L57:
        r17.setVisibility(r138);
        goto L58
    L56:
        r138 = 8;
        goto L57
    }

    public final void Z90(LinearLayout r5, PanelItem r6, Function0<Unit> r7) {
        if (r5 == null) goto L45;
        r5.setVisibility(0);
        r5.setOnClickListener(new c(r7));
        TextView r8 = (TextView) r5.findViewById(2131377715);
        if (r8 != null) goto L6;
        r8 = (TextView) r5.findViewById(2131384534);
    L6:
        ImageView r1 = (ImageView) r5.findViewById(2131377713);
        if (r1 != null) goto L10;
        r1 = (ImageView) r5.findViewById(2131384532);
    L10:
        if (r8 == null) goto L23;
        Text r2 = r6.getLeftText();
        if (r2 == null) goto L22;
        r8.setText(r2.getValue());
        r8.setVisibility(0);
        String r3 = r2.getUdColor();
        if (r3 == null) goto L16;
        r8.setTextColor(W90(r3));
    L21:
        r8.setTypeface(r8.getTypeface(), r2.getBold() ? 1 : 0);
        goto L23
    L16:
        Integer r4 = r2.getStyle();
        if (r4 == null) goto L19;
        int r9 = r4.intValue();
    L20:
        r8.setTextColor(V90(r9));
        goto L21
    L19:
        r9 = ColorStyle.Normal.getValue();
        goto L20
    L22:
        r8.setVisibility(8);
    L23:
        if (r1 == null) goto L46;
        Icon r10 = r6.getLeftIcon();
        if (r10 == null) goto L43;
        String r11 = r10.getUdKey();
        if (r11 == null) goto L43;
        int r12 = X90(r11);
        if (r12 == 0) goto L42;
        r1.setVisibility(0);
        r1.setImageResource(r12);
        Icon r13 = r6.getLeftIcon();
        if (r13 == null) goto L35;
        String r14 = r13.getUdColor();
        if (r14 == null) goto L35;
        r1.setColorFilter(W90(r14));
        return;
    L35:
        Icon r15 = r6.getLeftIcon();
        if (r15 == null) goto L40;
        Integer r16 = r15.getIconStyle();
        if (r16 == null) goto L40;
        int r17 = r16.intValue();
    L41:
        r1.setColorFilter(V90(r17));
        return;
    L40:
        r17 = ColorStyle.Normal.getValue();
        goto L41
    L42:
        r1.setVisibility(8);
        return;
    L43:
        r1.setVisibility(8);
        return;
    L46:
        return;
    }

    public final void aa0(View r5, boolean r6, PanelItem r7) {
        TextView r0 = (TextView) r5.findViewById(2131375795);
        if (this.k != null) goto L16;
        int r8 = ColorStyle.Normal.getValue();
        if (r6 == false) goto L7;
        r8 = ColorStyle.Select.getValue();
    L13:
        if (r0 == null) goto L132;
        r0.setTextColor(V90(r8));
        return;
    L132:
        return;
    L7:
        if (r7 == null) goto L13;
        Text r9 = r7.getLeftText();
        if (r9 == null) goto L13;
        Integer r10 = r9.getStyle();
        if (r10 == null) goto L13;
        r8 = r10.intValue();
        goto L13
    L16:
        TextView r1 = (TextView) r5.findViewById(2131375727);
        ImageView r2 = (ImageView) r5.findViewById(2131375790);
        ImageView r11 = (ImageView) r5.findViewById(2131375834);
        if (r6 == false) goto L63;
        ItemSelectInfo r12 = this.k;
        if (r12 == null) goto L25;
        Integer r13 = r12.getTextStyle();
        if (r13 == null) goto L25;
        int r14 = r13.intValue();
        if (r0 == null) goto L25;
        r0.setTextColor(V90(r14));
    L25:
        ItemSelectInfo r15 = this.k;
        if (r15 == null) goto L33;
        Integer r16 = r15.getDescStyle();
        if (r16 == null) goto L33;
        int r17 = r16.intValue();
        if (r1 == null) goto L33;
        r1.setTextColor(V90(r17));
    L33:
        if (r2 == null) goto L48;
        ItemSelectInfo r18 = this.k;
        if (r18 == null) goto L48;
        Icon r19 = r18.getLeftIcon();
        if (r19 == null) goto L48;
        String r3 = r19.getUdKey();
        if (r3 == null) goto L44;
        int r4 = X90(r3);
        if (r4 == 0) goto L43;
        r2.setVisibility(0);
        r2.setImageResource(r4);
    L45:
        Integer r20 = r19.getIconStyle();
        if (r20 == null) goto L48;
        r2.setColorFilter(V90(r20.intValue()));
        goto L48
    L43:
        r2.setVisibility(8);
        goto L45
    L44:
        r2.setVisibility(8);
    L48:
        if (r11 == null) goto L133;
        ItemSelectInfo r21 = this.k;
        if (r21 == null) goto L134;
        Icon r22 = r21.getRightIcon();
        if (r22 == null) goto L135;
        String r23 = r22.getUdKey();
        if (r23 == null) goto L59;
        int r24 = X90(r23);
        if (r24 == 0) goto L58;
        r11.setVisibility(0);
        r11.setImageResource(r24);
    L60:
        Integer r25 = r22.getIconStyle();
        if (r25 == null) goto L136;
        r11.setColorFilter(V90(r25.intValue()));
        return;
    L136:
        return;
    L58:
        r11.setVisibility(8);
        goto L60
    L59:
        r11.setVisibility(8);
        goto L60
    L135:
        return;
    L134:
        return;
    L133:
        return;
    L63:
        ItemSelectInfo r26 = this.k;
        if (r26 == null) goto L78;
        Integer r27 = r26.getTextStyle();
        if (r27 == null) goto L78;
        r27.intValue();
        if (r7 == null) goto L74;
        Text r28 = r7.getLeftText();
        if (r28 == null) goto L74;
        Integer r29 = r28.getStyle();
        if (r29 == null) goto L74;
        int r30 = r29.intValue();
    L75:
        int r31 = V90(r30);
        if (r0 == null) goto L78;
        r0.setTextColor(r31);
    L74:
        r30 = ColorStyle.Normal.getValue();
    L78:
        ItemSelectInfo r32 = this.k;
        if (r32 == null) goto L93;
        Integer r33 = r32.getDescStyle();
        if (r33 == null) goto L93;
        r33.intValue();
        if (r7 == null) goto L89;
        Text r34 = r7.getDesc();
        if (r34 == null) goto L89;
        Integer r35 = r34.getStyle();
        if (r35 == null) goto L89;
        int r36 = r35.intValue();
    L90:
        int r37 = V90(r36);
        if (r1 == null) goto L93;
        r1.setTextColor(r37);
    L89:
        r36 = ColorStyle.Desc.getValue();
    L93:
        if (r2 == null) goto L112;
        ItemSelectInfo r38 = this.k;
        if (r38 == null) goto L112;
        Icon r39 = r38.getLeftIcon();
        if (r39 == null) goto L112;
        if (r39.getUdKey() == null) goto L101;
        r2.setVisibility(8);
    L101:
        Integer r40 = r39.getIconStyle();
        if (r40 == null) goto L112;
        r40.intValue();
        if (r7 == null) goto L110;
        Icon r41 = r7.getLeftIcon();
        if (r41 == null) goto L110;
        Integer r42 = r41.getIconStyle();
        if (r42 == null) goto L110;
        int r43 = r42.intValue();
    L111:
        r2.setColorFilter(r43);
    L110:
        r43 = ColorStyle.Normal.getValue();
    L112:
        if (r11 == null) goto L138;
        ItemSelectInfo r44 = this.k;
        if (r44 == null) goto L139;
        Icon r45 = r44.getRightIcon();
        if (r45 != null) goto L118;
        return;
    L118:
        if (r45.getUdKey() == null) goto L120;
        r11.setVisibility(8);
    L120:
        Integer r46 = r45.getIconStyle();
        if (r46 == null) goto L141;
        r46.intValue();
        if (r7 == null) goto L129;
        Icon r47 = r7.getRightIcon();
        if (r47 == null) goto L129;
        Integer r48 = r47.getIconStyle();
        if (r48 == null) goto L129;
        int r49 = r48.intValue();
    L130:
        r11.setColorFilter(r49);
        return;
    L129:
        r49 = ColorStyle.Normal.getValue();
        goto L130
    L141:
        return;
    L139:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559837, r3, false);
    }
}
