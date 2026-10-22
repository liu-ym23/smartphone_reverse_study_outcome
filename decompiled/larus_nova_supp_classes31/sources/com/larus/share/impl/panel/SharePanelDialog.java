package com.larus.share.impl.panel;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.share.ShareScene;
import com.larus.common_ui.widget.MaxWidthRecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.share.impl.databinding.LarusShareLayoutPanelDialogBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020%H\u0016JV\u0010&\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u0012\u0010'\u001a\u00020(2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u000e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020/J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u001bH\u0002J\u0093\u0001\u00108\u001a\u00020\u001b2\n\b\u0002\u00109\u001a\u0004\u0018\u00010%2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010/2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010E\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020\u001bH\u0002J\b\u0010I\u001a\u00020/H\u0002J\b\u0010J\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/share/impl/panel/SharePanelDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/share/impl/databinding/LarusShareLayoutPanelDialogBinding;", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "panelRows", "Lcom/larus/platform/model/share/SharePanelConfig;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "itemClick", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "landscape", "", "landscapeFixedPanelWidth", "monitorShare", "row1Adapter", "Lcom/larus/share/impl/panel/SharePanelAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getTheme", "", "init", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "doShow", "updateTitle", "title", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "setupLandscape", "initView", "updateSubTitle", "iconRes", "text", "", "actionText", "actionClickListener", "Lkotlin/Function0;", "backgroundRes", "containerHorizontalPadding", "subTitleTextSize", "", "subTitleBold", "actionAutoDismiss", "subTitleMarginTop", "contentVerticalPadding", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "observePublishInsertEvent", "getCreationTaskId", "isSupportWxMiniAppShare", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SharePanelDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int p = 0;
    public LarusShareLayoutPanelDialogBinding d;
    public FragmentActivity e;
    public ShareScene f;
    public jr9.c g;
    public com.larus.bmhome.share.panel.b h;
    public com.larus.bmhome.share.panel.h i;
    public com.larus.bmhome.share.panel.d j;
    public by7.e k;
    public boolean l;
    public boolean m;
    public boolean n;
    public SharePanelAdapter o;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public final String U90() {
        com.larus.bmhome.share.panel.h r0 = this.i;
        if (r0 == null) goto L5;
        String r1 = r0.E;
    L7:
        if (o0.d(r1) == false) goto L15;
        com.larus.bmhome.share.panel.h r2 = this.i;
        if (r2 == null) goto L24;
        String r3 = r2.E;
        if (r3 != null) goto L14;
        return "";
    L14:
        return r3;
    L24:
        return "";
    L15:
        com.larus.bmhome.share.panel.h r4 = this.i;
        if (r4 == null) goto L26;
        JSONObject r5 = r4.i;
        if (r5 == null) goto L27;
        String r6 = r5.optString("creation_task_id", "");
        if (r6 != null) goto L23;
        return "";
    L23:
        return r6;
    L27:
        return "";
    L26:
        return "";
    L5:
        r1 = null;
        goto L7
    }

    public SharePanelDialog() {
        this.f = ShareScene.UNKNOWN;
    }

    public static void T90(SharePanelDialog r1) {
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

    public final void onCreate(Bundle r2) {
        Context r0 = getContext();
        if (r0 == null) goto L7;
        Resources.Theme r1 = r0.getTheme();
        if (r1 == null) goto L7;
        v19.f.a(r1);
    L7:
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.gravity = 80;
        r1.width = -1;
        r1.height = i5.B();
        r0.setAttributes(r1);
    L5:
        return r5;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        com.larus.bmhome.share.panel.d r3 = this.j;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.onDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [int] */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r41v0 */
    /* JADX WARN: Type inference failed for: r41v1, types: [int] */
    /* JADX WARN: Type inference failed for: r41v2 */
    public final void onViewCreated(View r54, Bundle r55) {
        Intrinsics.checkNotNullParameter(r54, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r54, r55);
        if (this.l == false) goto L42;
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L7;
        BottomSheetDialog r1 = r0;
    L8:
        if (r1 == null) goto L10;
        final View r2 = r1.findViewById(2131368870);
    L11:
        Dialog r3 = getDialog();
        if (r3 == null) goto L15;
        r3.setOnShowListener(new h(r2));
    L15:
        if (this.m == false) goto L42;
        LarusShareLayoutPanelDialogBinding r4 = this.d;
        if (r4 == null) goto L35;
        LinearLayout r5 = r4.a;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L34;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        r7.height = -2;
        r7.width = -2;
        r5.setLayoutParams(r7);
        MaxWidthRecyclerView r8 = r4.c;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if ((r9 instanceof LinearLayout.LayoutParams) == false) goto L23;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r9;
    L24:
        if (r10 == null) goto L26;
        r10.topMargin = i5.q();
    L26:
        if (r10 == null) goto L28;
        r10.bottomMargin = i5.T();
    L28:
        if (r10 == null) goto L30;
        r10.height = -2;
    L30:
        if (r10 == null) goto L32;
        r10.width = -2;
    L32:
        r8.setLayoutParams(r10);
        r8.setMaxHeight((int) UIUtils.dip2Px(this.e, 568.0f));
        goto L35
    L23:
        r10 = null;
        goto L24
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L35:
        if (r2 == null) goto L42;
        ViewGroup.LayoutParams r11 = r2.getLayoutParams();
        if (r11 == null) goto L40;
        CoordinatorLayout.LayoutParams r12 = (CoordinatorLayout.LayoutParams) r11;
        ((ViewGroup.MarginLayoutParams) r12).height = -2;
        ((ViewGroup.MarginLayoutParams) r12).width = -2;
        r12.gravity = 17;
        r2.setLayoutParams(r12);
        goto L42
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L10:
        r2 = null;
        goto L11
    L7:
        r1 = null;
    L42:
        if (this.g != null) goto L44;
    L455:
        T90(this);
        if (this.n == false) goto L465;
        com.larus.share.impl.e r13 = com.larus.share.impl.a.a;
        ShareScene r14 = this.f;
        com.larus.bmhome.share.panel.b r15 = this.h;
        StringBuilder r16 = new StringBuilder("config is null: ");
        if (this.g != null) goto L460;
        boolean r17 = true;
    L461:
        r16.append(r17);
        com.larus.share.impl.a.l(r14, r15, r16.toString(), this.k);
        return;
    L460:
        r17 = false;
        goto L461
    L465:
        return;
    L44:
        if (this.e == null) goto L455;
        if (this.n == false) goto L49;
        com.larus.share.impl.e r18 = com.larus.share.impl.a.a;
        com.larus.share.impl.a.n(this.f, this.h, this.k, "custom");
    L49:
        LarusShareLayoutPanelDialogBinding r19 = this.d;
        if (r19 == null) goto L463;
        Dialog r20 = getDialog();
        if (r20 == null) goto L54;
        View r21 = r20.findViewById(2131368870);
    L55:
        if (r21 == null) goto L57;
        r21.setBackgroundResource(R.color.transparent);
        Unit r22 = Unit.INSTANCE;
    L57:
        e1.d(r19.d, new j(this));
        SharePanelItemDecoration r110 = new SharePanelItemDecoration(this.e, this.l);
        g r111 = new SharePanelDialog$initView$1$callback$1(this);
        jr9.c r23 = this.g;
        if (r23 == null) goto L62;
        List<jr9.a> r24 = r23.a();
        if (r24 == null) goto L62;
        List r25 = CollectionsKt.filterNotNull(r24);
    L63:
        if (r25 != null) goto L65;
        r25 = CollectionsKt.emptyList();
    L65:
        List r26 = CollectionsKt.toMutableList(r25);
        com.larus.bmhome.share.panel.h r27 = this.i;
        if (r27 == null) goto L68;
        com.larus.bmhome.share.panel.k r28 = r27.p0;
    L70:
        if (r28 != null) goto L72;
    L82:
        FLogger.a.i("SharePanelDialog", "publishInsert: 未插入, publishInsert=" + r28);
    L83:
        com.larus.share.impl.util.e r112 = com.larus.share.impl.util.e.a;
        List r113 = com.larus.share.impl.util.e.b(com.larus.share.impl.util.e.b(com.larus.share.impl.util.e.d(r112, r26, false, null, false, 7), null), null);
        String r114 = U90();
        com.larus.bmhome.share.panel.h r29 = this.i;
        if (r29 == null) goto L89;
        String r30 = r29.n;
        if (r30 == null) goto L89;
        String r115 = r30;
    L90:
        if (r29 == null) goto L92;
        ?? r210 = Intrinsics.areEqual(r29.R, Boolean.TRUE);
    L93:
        com.larus.bmhome.share.panel.h r31 = this.i;
        if (r31 == null) goto L99;
        String r32 = r31.h;
        if (r32 == null) goto L99;
        String r211 = r32;
    L100:
        if (r31 != null) goto L102;
    L104:
        int r212 = 0;
    L105:
        if (r31 == null) goto L107;
        String r213 = r31.S;
    L109:
        if (r31 == null) goto L114;
        Message r33 = r31.O;
        if (r33 == null) goto L114;
        String r34 = r33.getReplyId();
        if (r34 == null) goto L114;
    L119:
        String r214 = r34;
    L121:
        com.larus.bmhome.share.panel.h r35 = this.i;
        if (r35 == null) goto L126;
        JSONObject r36 = r35.i;
        if (r36 == null) goto L126;
        String r215 = r36.optString("doc_id");
    L127:
        com.larus.bmhome.share.panel.h r37 = this.i;
        if (r37 == null) goto L132;
        JSONObject r38 = r37.i;
        if (r38 == null) goto L132;
        String r216 = r38.optString("rich_media_type");
    L133:
        com.larus.bmhome.share.panel.h r39 = this.i;
        if (r39 == null) goto L138;
        JSONObject r40 = r39.i;
        if (r40 == null) goto L138;
        String r41 = r40.optString("request_id");
    L140:
        if (o0.d(r41) == false) goto L146;
        com.larus.bmhome.share.panel.h r42 = this.i;
        if (r42 == null) goto L152;
        JSONObject r43 = r42.i;
        if (r43 == null) goto L152;
        String r44 = r43.optString("request_id");
    L151:
        String r217 = r44;
    L153:
        com.larus.bmhome.share.panel.h r45 = this.i;
        if (r45 == null) goto L158;
        JSONObject r46 = r45.i;
        if (r46 == null) goto L158;
        String r310 = r46.optString("_mixed_richmedia_download_trace");
    L159:
        com.larus.bmhome.share.panel.h r47 = this.i;
        if (r47 == null) goto L162;
        JSONObject r311 = r47.i;
    L163:
        List<jr9.a> r48 = com.larus.share.impl.util.e.a(r113, r114, r115, r210, r211, r212, r213, r214, r217, r215, r216, null, null, r310, r311);
        if ((!((ArrayList) r48).isEmpty()) == false) goto L180;
        RecyclerView.LayoutManager r49 = new LinearLayoutManager(this.e, 0, false);
        FragmentActivity r116 = this.e;
        com.larus.bmhome.share.panel.b r50 = this.h;
        Boolean r117 = null;
        com.larus.bmhome.share.panel.h r118 = this.i;
        if (r118 == null) goto L177;
        wc9.e r119 = r118.a;
        if (r119 == null) goto L177;
        Integer r120 = r119.v;
        if (r120 == null) goto L177;
        int r121 = r120.intValue();
        RecyclerView.LayoutManager r122 = r49;
        if (r121 != 1) goto L174;
    L178:
        boolean r123 = true;
    L179:
        int r124 = 8;
        SharePanelAdapter r51 = new SharePanelAdapter(r116, this, r111, r50, r117, r123, 32);
        r51.setData(r48);
        this.o = r51;
        r19.b.setVisibility(0);
        r19.b.setAdapter(r51);
        r19.b.setLayoutManager(r122);
        r19.b.addItemDecoration(r110);
    L181:
        jr9.c r52 = this.g;
        if (r52 == null) goto L186;
        List<jr9.a> r53 = r52.c();
        if (r53 == null) goto L186;
        List r125 = CollectionsKt.filterNotNull(r53);
    L187:
        ShareScene r56 = this.f;
        if (r56 != ShareScene.CODE_FULL_SCREEN_PAGE) goto L190;
    L192:
        boolean r218 = false;
    L193:
        List r312 = com.larus.share.impl.util.e.b(com.larus.share.impl.util.e.d(r112, r125, false, null, r218, 3), null);
        String r313 = U90();
        com.larus.bmhome.share.panel.h r57 = this.i;
        if (r57 == null) goto L199;
        String r58 = r57.n;
        if (r58 == null) goto L199;
        String r410 = r58;
    L200:
        if (r57 == null) goto L202;
        ?? r411 = Intrinsics.areEqual(r57.R, Boolean.TRUE);
    L203:
        com.larus.bmhome.share.panel.h r59 = this.i;
        if (r59 == null) goto L209;
        String r60 = r59.h;
        if (r60 == null) goto L209;
        String r412 = r60;
    L210:
        if (r59 != null) goto L212;
    L214:
        int r413 = 0;
    L215:
        if (r59 == null) goto L217;
        String r414 = r59.S;
    L218:
        if (r59 == null) goto L225;
        Message r61 = r59.O;
        if (r61 == null) goto L225;
        String r62 = r61.getReplyId();
        if (r62 == null) goto L225;
    L224:
        String r415 = r62;
    L231:
        com.larus.bmhome.share.panel.h r63 = this.i;
        if (r63 == null) goto L236;
        JSONObject r64 = r63.i;
        if (r64 == null) goto L236;
        String r416 = r64.optString("doc_id");
    L237:
        com.larus.bmhome.share.panel.h r65 = this.i;
        if (r65 == null) goto L242;
        JSONObject r66 = r65.i;
        if (r66 == null) goto L242;
        String r417 = r66.optString("rich_media_type");
    L243:
        com.larus.bmhome.share.panel.h r67 = this.i;
        if (r67 == null) goto L246;
        String r418 = r67.n0;
    L247:
        if (r67 == null) goto L249;
        String r510 = r67.o0;
    L250:
        if (r67 == null) goto L254;
        JSONObject r68 = r67.i;
        if (r68 == null) goto L254;
        String r69 = "request_id";
        String r70 = r68.optString(r69);
    L256:
        if (o0.d(r70) == false) goto L262;
        com.larus.bmhome.share.panel.h r71 = this.i;
        if (r71 == null) goto L268;
        JSONObject r72 = r71.i;
        if (r72 == null) goto L268;
        String r73 = r69;
    L267:
        String r419 = r72.optString(r73);
    L269:
        com.larus.bmhome.share.panel.h r74 = this.i;
        if (r74 == null) goto L274;
        JSONObject r75 = r74.i;
        if (r75 == null) goto L274;
        String r511 = r75.optString("_mixed_richmedia_download_trace");
    L275:
        com.larus.bmhome.share.panel.h r76 = this.i;
        if (r76 == null) goto L278;
        JSONObject r512 = r76.i;
    L279:
        List<jr9.a> r77 = com.larus.share.impl.util.e.a(r312, r313, r410, r411, r412, r413, r414, r415, r419, r416, r417, r418, r510, r511, r512);
        if ((!((ArrayList) r77).isEmpty()) == false) goto L295;
        LinearLayoutManager r126 = new LinearLayoutManager(this.e, 0, false);
        FragmentActivity r78 = this.e;
        com.larus.bmhome.share.panel.b r79 = this.h;
        Boolean r80 = null;
        com.larus.bmhome.share.panel.h r81 = this.i;
        if (r81 == null) goto L293;
        wc9.e r82 = r81.a;
        if (r82 == null) goto L293;
        Integer r83 = r82.v;
        if (r83 == null) goto L293;
        int r84 = r83.intValue();
        if (r84 == 1) goto L293;
        if (r84 == 3) goto L293;
        boolean r85 = false;
    L294:
        SharePanelAdapter r127 = new SharePanelAdapter(r78, this, r111, r79, r80, r85, 32);
        r127.setData(r77);
        r19.c.setVisibility(0);
        r19.c.setAdapter(r127);
        r19.c.setLayoutManager(r126);
        r19.c.addItemDecoration(r110);
    L296:
        com.larus.bmhome.share.panel.h r86 = this.i;
        if (r86 == null) goto L301;
        com.larus.bmhome.share.panel.i r87 = r86.k0;
        if (r87 == null) goto L301;
        com.larus.bmhome.share.panel.n r88 = r87.b;
    L302:
        if (r88 == null) goto L304;
        CharSequence r89 = r88.e;
    L305:
        if (r89 != null) goto L307;
    L310:
        boolean r219 = true;
    L311:
        boolean r90 = !r219;
        if (r90 == false) goto L389;
        if (r88 == null) goto L315;
        Integer r91 = r88.a;
    L316:
        if (r89 != null) goto L318;
        r89 = "";
    L318:
        if (r88 == null) goto L320;
        String r92 = r88.b;
    L321:
        if (r88 == null) goto L323;
        final Function0 r93 = r88.c;
    L324:
        if (r88 == null) goto L326;
        Integer r94 = r88.d;
    L327:
        if (r88 == null) goto L329;
        Integer r95 = r88.f;
    L330:
        if (r88 == null) goto L332;
        Float r96 = r88.g;
    L333:
        if (r88 == null) goto L335;
        Boolean r128 = r88.h;
    L336:
        if (r88 == null) goto L338;
        final Boolean r129 = r88.i;
    L339:
        if (r88 == null) goto L341;
        Integer r130 = r88.j;
    L342:
        if (r88 == null) goto L344;
        Integer r97 = r88.k;
    L345:
        LarusShareLayoutPanelDialogBinding r131 = this.d;
        if (r131 == null) goto L389;
        e1.x(r131.f);
        if (r94 == null) goto L350;
        r131.f.setBackgroundResource(r94.intValue());
        e1.o(r131.h);
    L351:
        if (r95 == null) goto L354;
        int r98 = r95.intValue();
        LinearLayout r99 = r131.f;
        r99.setPadding(r98, r99.getPaddingTop(), r98, r131.f.getPaddingTop());
    L354:
        if (r97 == null) goto L356;
        int r100 = r97.intValue();
        LinearLayout r101 = r131.g;
        r101.setPadding(r101.getPaddingLeft(), r100, r131.g.getPaddingRight(), r100);
    L356:
        if (r130 == null) goto L364;
        int r102 = r130.intValue();
        ViewGroup.LayoutParams r103 = r131.f.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L360;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L361:
        if (r104 == null) goto L363;
        r104.topMargin = r102;
    L363:
        r131.f.setLayoutParams(r104);
        goto L364
    L360:
        r104 = null;
    L364:
        if (r91 == null) goto L366;
        e1.x(r131.i);
        r131.i.setImageResource(r91.intValue());
    L367:
        r131.j.setText(r89);
        if (r96 == null) goto L370;
        r131.j.setTextSize(r96.floatValue());
    L370:
        if (r128 == null) goto L377;
        boolean r105 = r128.booleanValue();
        TextView r106 = r131.j;
        if (r105 == false) goto L374;
        Typeface r107 = Typeface.defaultFromStyle(1);
    L375:
        r106.setTypeface(r107);
        goto L377
    L374:
        r107 = Typeface.defaultFromStyle(0);
    L377:
        if (r92 != null) goto L379;
    L382:
        boolean r108 = true;
    L383:
        if (r108 == true) goto L388;
        e1.x(r131.e);
        r131.e.setText(r92);
        if (r96 == null) goto L387;
        r131.e.setTextSize(r96.floatValue());
    L387:
        e1.d(r131.e, new k(r93, r129, this));
    L390:
        com.larus.bmhome.share.panel.h r109 = this.i;
        if (r109 == null) goto L427;
        com.larus.bmhome.share.panel.i r132 = r109.k0;
        if (r132 == null) goto L427;
        String r133 = r132.a;
        if (r133 == null) goto L402;
        Intrinsics.checkNotNullParameter(r133, "title");
        LarusShareLayoutPanelDialogBinding r134 = this.d;
        if (r134 == null) goto L401;
        TextView r135 = r134.l;
        if (r135 == null) goto L401;
        r135.setText(r133);
    L401:
        Unit r136 = Unit.INSTANCE;
    L402:
        LarusShareLayoutPanelDialogBinding r137 = this.d;
        if (r137 == null) goto L427;
        TextView r138 = r137.l;
        if (r138 == null) goto L427;
        Integer r139 = r132.c;
        if (r139 == null) goto L409;
        r138.setMaxEms(r139.intValue());
        Unit r140 = Unit.INSTANCE;
    L409:
        Integer r141 = r132.f;
        if (r141 == null) goto L412;
        r138.setMaxLines(r141.intValue());
        Unit r142 = Unit.INSTANCE;
    L412:
        TextUtils.TruncateAt r143 = r132.g;
        if (r143 == null) goto L415;
        r138.setEllipsize(r143);
        Unit r144 = Unit.INSTANCE;
    L415:
        Float r145 = r132.h;
        if (r145 == null) goto L418;
        r138.setTextSize(r145.floatValue());
        Unit r146 = Unit.INSTANCE;
    L418:
        Integer r147 = r132.e;
        if (r147 == null) goto L427;
        int r148 = r147.intValue();
        ViewGroup.LayoutParams r149 = r138.getLayoutParams();
        if ((r149 instanceof RelativeLayout.LayoutParams) == false) goto L423;
        RelativeLayout.LayoutParams r150 = (RelativeLayout.LayoutParams) r149;
    L424:
        if (r150 == null) goto L426;
        r150.setMarginStart(r148);
        r150.removeRule(13);
        r150.addRule(15);
        r138.setLayoutParams(r150);
    L426:
        Unit r151 = Unit.INSTANCE;
        goto L427
    L423:
        r150 = null;
    L427:
        com.larus.bmhome.share.panel.h r152 = this.i;
        if (r152 == null) goto L432;
        com.larus.bmhome.share.panel.i r153 = r152.k0;
        if (r153 == null) goto L432;
        String r154 = r153.a;
    L433:
        if (r154 != null) goto L435;
    L438:
        boolean r155 = true;
    L439:
        if (r155 == false) goto L441;
        e1.o(r19.k);
    L442:
        Context r156 = getContext();
        if (r156 != null) goto L445;
    L454:
        FLogger.a.i("SharePanelDialog", "observePublishInsertEvent: 开始订阅 PublishInsertEvent");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SharePanelDialog$observePublishInsertEvent$1(this, null), 3, null);
        Unit r157 = Unit.INSTANCE;
        return;
    L445:
        if (this.l == true) goto L453;
        if (r90 == true) goto L453;
        if (r19.k.getVisibility() != 0) goto L450;
        boolean r158 = true;
    L451:
        if (r158 == true) goto L453;
        r19.a.setBackground(AppCompatResources.getDrawable(r156, 2131239669));
        goto L453
    L450:
        r158 = false;
    L453:
        Unit r159 = Unit.INSTANCE;
        goto L454
    L441:
        e1.x(r19.k);
        goto L442
    L435:
        if (r154.length() == 0) goto L438;
        r155 = false;
    L432:
        r154 = null;
        goto L433
    L388:
        e1.o(r131.e);
        goto L390
    L379:
        if (r92.length() == 0) goto L382;
        r108 = false;
        goto L383
    L366:
        e1.o(r131.i);
        goto L367
    L350:
        r131.f.setBackground(null);
        e1.x(r131.h);
        goto L351
    L344:
        r97 = null;
        goto L345
    L341:
        r130 = null;
        goto L342
    L338:
        r129 = null;
        goto L339
    L335:
        r128 = null;
        goto L336
    L332:
        r96 = null;
        goto L333
    L329:
        r95 = null;
        goto L330
    L326:
        r94 = null;
        goto L327
    L323:
        r93 = null;
        goto L324
    L320:
        r92 = null;
        goto L321
    L315:
        r91 = null;
    L389:
        r90 = r90;
        goto L390
    L307:
        if (r89.length() == 0) goto L310;
        r219 = false;
        goto L311
    L304:
        r89 = null;
    L301:
        r88 = null;
    L293:
        r85 = true;
        goto L294
    L295:
        r19.c.setVisibility(r124);
        goto L296
    L278:
        r512 = null;
    L274:
        r511 = null;
    L268:
        r419 = null;
        goto L269
    L262:
        com.larus.bmhome.share.panel.h r160 = this.i;
        if (r160 == null) goto L268;
        r72 = r160.i;
        if (r72 == null) goto L268;
        r73 = "req_id";
    L254:
        r69 = r4;
        r70 = null;
        goto L256
    L249:
        r510 = null;
        goto L250
    L246:
        r418 = null;
    L242:
        r417 = null;
    L236:
        r416 = null;
    L225:
        com.larus.bmhome.share.panel.h r161 = this.i;
        if (r161 == null) goto L230;
        JSONObject r162 = r161.i;
        if (r162 == null) goto L230;
        r62 = r162.optString("reply_id");
    L230:
        r415 = null;
        goto L231
    L217:
        r414 = null;
        goto L218
    L212:
        if (r59.l != true) goto L214;
        r413 = 1;
    L209:
        r412 = "";
        goto L210
    L202:
        r411 = 0;
    L199:
        r410 = "";
        goto L200
    L190:
        if (r56 == ShareScene.TABLE_FULL_SCREEN_PAGE) goto L192;
        r218 = true;
    L186:
        r125 = null;
        goto L187
    L174:
        if (r121 == 3) goto L178;
        r123 = false;
    L177:
        r122 = r49;
        goto L178
    L180:
        r124 = 8;
        r19.b.setVisibility(8);
        goto L181
    L162:
        r311 = null;
    L158:
        r310 = null;
    L152:
        r217 = null;
        goto L153
    L146:
        com.larus.bmhome.share.panel.h r163 = this.i;
        if (r163 == null) goto L152;
        JSONObject r164 = r163.i;
        if (r164 == null) goto L152;
        r44 = r164.optString("req_id");
    L138:
        r41 = null;
    L132:
        r216 = null;
    L126:
        r215 = null;
    L114:
        com.larus.bmhome.share.panel.h r165 = this.i;
        if (r165 == null) goto L120;
        JSONObject r166 = r165.i;
        if (r166 == null) goto L120;
        r34 = r166.optString("reply_id");
    L120:
        r214 = null;
        goto L121
    L107:
        r213 = null;
        goto L109
    L102:
        if (r31.l != true) goto L104;
        r212 = 1;
    L99:
        r211 = "";
        goto L100
    L92:
        r210 = 0;
    L89:
        r115 = "";
        goto L90
    L72:
        if ((r28 instanceof com.larus.bmhome.share.panel.k.a) == true) goto L82;
        if ((r28 instanceof com.larus.bmhome.share.panel.k.b) == false) goto L77;
        String r167 = "publish";
    L80:
        if (r167 == null) goto L83;
        int r168 = Math.min(1, r26.size());
        ListProtector.add(r26, r168, new jr9.a(r167, null, 14));
        FLogger.a.i("SharePanelDialog", "publishInsert: 在 index=" + r168 + " 插入 channel=" + r167 + ", rawFirstItems.size=" + r26.size());
        goto L83
    L77:
        if ((r28 instanceof com.larus.bmhome.share.panel.k.c) == false) goto L79;
        r167 = "set_private";
        goto L80
    L79:
        r167 = null;
        goto L80
    L68:
        r28 = null;
    L62:
        r25 = null;
        goto L63
    L54:
        r21 = null;
        goto L55
    }

    public final void show(final FragmentManager r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        com.obric.assistant.spi.keyguard.a.b(false, new i(r2, this, r3), 3);
    }

    public static Unit S90(FragmentManager r1, SharePanelDialog r2, String r3) {
        if (r1.isDestroyed() == true) goto L13;
        if (r1.isStateSaved() == true) goto L13;
        r2.getClass();     // Catch: Throwable -> L15
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L15
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, r3, r0);     // Catch: Throwable -> L15
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r2, r0) == false) goto L18;
    L11:
        com.larus.share.impl.e r4 = com.larus.share.impl.a.a;     // Catch: Throwable -> L15
        com.larus.share.impl.a.r(r2.f, r2.i, r2.k);     // Catch: Throwable -> L15
        goto L13
    L18:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14 Throwable -> L15
    L10:
        super/*androidx.fragment.app.DialogFragment*/.show(r1, r3);     // Catch: Throwable -> L15
    L13:
        return Unit.INSTANCE;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        View r0 = r17.inflate(2131563123, r18, false);
        int r1 = 2131384709;
        RecyclerView r5 = ViewBindings.findChildViewById(r0, 2131384709);
        if (r5 == null) goto L27;
        r1 = 2131384710;
        MaxWidthRecyclerView r6 = ViewBindings.findChildViewById(r0, 2131384710);
        if (r6 == null) goto L27;
        r1 = 2131386073;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r0, 2131386073);
        if (r7 == null) goto L27;
        r1 = 2131388749;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131388749);
        if (r8 == null) goto L27;
        r1 = 2131388753;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131388753);
        if (r9 == null) goto L27;
        r1 = 2131388754;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131388754);
        if (r10 == null) goto L27;
        r1 = 2131388755;
        View r11 = ViewBindings.findChildViewById(r0, 2131388755);
        if (r11 == null) goto L27;
        r1 = 2131388760;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131388760);
        if (r12 == null) goto L27;
        r1 = 2131388767;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r0, 2131388767);
        if (r13 == null) goto L27;
        r1 = 2131388843;
        RelativeLayout r14 = (RelativeLayout) ViewBindings.findChildViewById(r0, 2131388843);
        if (r14 == null) goto L27;
        r1 = 2131390498;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131390498);
        if (r15 == null) goto L27;
        LinearLayout r2 = (LinearLayout) r0;
        this.d = new LarusShareLayoutPanelDialogBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return r2;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void V90(FragmentActivity r2, ShareScene r3, jr9.c r4, com.larus.bmhome.share.panel.b r5, com.larus.bmhome.share.panel.h r6, com.larus.bmhome.share.panel.d r7, by7.e r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "shareScene");
        Intrinsics.checkNotNullParameter(r5, "shareContent");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        if (r2.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r11 = true;
    L6:
        this.l = r11;
        this.m = r9;
        this.n = r10;
        return;
    L5:
        r11 = false;
        goto L6
    }
}
