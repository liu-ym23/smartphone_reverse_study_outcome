package com.ss.android.lark.forwardv3.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1;
import com.ss.android.lark.forwardv3.confirmdialog.ForwardConfirmDialogAdapter;
import com.ss.android.lark.forwardv3.confirmdialog.ForwardConfirmDialogItemDecoration;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public n() {
    }

    public static boolean f(Context r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (ForsetiConfig.a(r1) != true) goto L6;
        return true;
    }

    public static boolean d(SearchBaseInfo r1, ImageView r2) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "avatar");
        ExternalTargetAvatarProviderStore r0 = ExternalTargetAvatarProviderStore.INSTANCE;
        if (r0.requiresProvider(r1) == true) goto L6;
        return false;
    L6:
        Drawable r3 = r0.createDrawableOrNull();
        ImageLoader.clear(r2);
        r2.setImageDrawable(r3);
        return true;
    }

    public static void c(Context r11, SearchBaseInfo r12, LKUIRoundedImageView r13, LKUIRoundedImageView r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "avatar");
        Intrinsics.checkNotNullParameter(r14, "icon");
        int r1 = 8;
        if (d(r12, r13) == true) goto L5;
        boolean r0 = false;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if ((r12 instanceof SearchChatInfo) == false) goto L15;
        SearchChatInfo r15 = (SearchChatInfo) r12;
        if (r15.isShield() == false) goto L13;
        r1 = 0;
    L13:
        r14.setVisibility(r1);
        r13.setVisibility(0);
        r14.setImageResource(2131237487);
        b(r11, r13, r15.getAvatarKey(), r15.getId(), y9c.d.b(r11, 40.0f), y9c.d.b(r11, 40.0f));
        return;
    L15:
        if ((r12 instanceof SearchShieldP2PChatInfo) == false) goto L18;
        r14.setVisibility(0);
        r13.setVisibility(0);
        r14.setImageResource(2131237487);
        SearchShieldP2PChatInfo r16 = (SearchShieldP2PChatInfo) r12;
        b(r11, r13, r16.getAvatarKey(), r16.getChatterId(), y9c.d.b(r11, 40.0f), y9c.d.b(r11, 40.0f));
        return;
    L18:
        if ((r12 instanceof SearchChatterInfo) == false) goto L21;
        r14.setVisibility(8);
        r13.setVisibility(0);
        r14.setBorderWidthDP(1.5f);
        r14.setBorderColor(y9c.d.c(r11, 2131106521));
        SearchChatterInfo r17 = (SearchChatterInfo) r12;
        b(r11, r13, r17.getAvatarKey(), r17.getId(), y9c.d.b(r11, 40.0f), y9c.d.b(r11, 40.0f));
        return;
    L21:
        if ((r12 instanceof SearchReplyInThreadInfo) == false) goto L24;
        r14.setVisibility(0);
        r13.setVisibility(0);
        r14.setBorderColor(0);
        r14.setBorderWidthDP(0.0f);
        r13.setImageResource(2131237551);
        SearchReplyInThreadInfo r18 = (SearchReplyInThreadInfo) r12;
        b(r11, r14, r18.getAvatarKey(), r18.getEntityId(), y9c.d.b(r11, 15.0f), y9c.d.b(r11, 15.0f));
        return;
    L24:
        if ((r12 instanceof SearchThreadInfo) == false) goto L27;
        r14.setVisibility(0);
        r13.setVisibility(0);
        r14.setBorderWidthDP(1.5f);
        r14.setBorderColor(y9c.d.c(r11, 2131106521));
        r14.setImageResource(2131235361);
        SearchThreadInfo r19 = (SearchThreadInfo) r12;
        b(r11, r13, r19.getAvatarKey(), r19.getChannel().getId(), y9c.d.b(r11, 40.0f), y9c.d.b(r11, 40.0f));
        return;
    L27:
        if ((r12 instanceof SearchAiKnowledgeInfo) == false) goto L35;
        r14.setVisibility(8);
        r13.setVisibility(0);
        r13.setImageResource(2131255192);
        r13.setLayoutParams(new FrameLayout.LayoutParams(y9c.d.b(r11, 40.0f), y9c.d.b(r11, 40.0f)));
        return;
    L35:
        return;
    L5:
        r14.setVisibility(8);
        r13.setVisibility(0);
        r0 = true;
        goto L6
    }

    public static void b(Context r1, ImageView r2, String r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, "entityId");
        LoadParams r0 = new LoadParams();
        r0.a = r5;
        r0.b = r6;
        ImageModule.a(r1, r2, r3, r4, r0);
    }

    public static void a(Context r4, int r5, boolean r6, TextView r7, boolean r8, TextView r9, boolean r10, TextView r11) {
        if (r6 == false) goto L8;
        if (r8 == false) goto L8;
        if (r10 == false) goto L8;
        ViewGroup.LayoutParams r12 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r12;
        r13.topMargin = r5;
        r13.bottomMargin = r5;
        r9.setLayoutParams(r13);
        r9.setMaxLines(2);
        r9.setTextColor(y9c.d.c(r4, 2131106620));
        return;
    L8:
        if (r6 == false) goto L12;
        if (r8 == false) goto L12;
        if (r10 == true) goto L12;
        ViewGroup.LayoutParams r14 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        r15.topMargin = r5;
        r9.setLayoutParams(r15);
        r9.setMaxLines(3);
        r9.setTextColor(y9c.d.c(r4, 2131106620));
        return;
    L12:
        if (r6 == false) goto L16;
        if (r8 == true) goto L16;
        if (r10 == false) goto L16;
        ViewGroup.LayoutParams r16 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
        r17.topMargin = r5;
        r11.setLayoutParams(r17);
        r11.setMaxLines(2);
        r11.setTextColor(y9c.d.c(r4, 2131106620));
        return;
    L16:
        if (r6 == false) goto L20;
        if (r8 == true) goto L20;
        if (r10 == true) goto L20;
        r7.setMaxLines(2);
        return;
    L20:
        if (r6 == true) goto L24;
        if (r8 == false) goto L24;
        if (r10 == false) goto L24;
        ViewGroup.LayoutParams r18 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r19 = (LinearLayout.LayoutParams) r18;
        r19.topMargin = r5;
        r11.setLayoutParams(r19);
        r9.setMaxLines(3);
        return;
    L24:
        if (r6 == true) goto L28;
        if (r8 == false) goto L28;
        if (r10 == true) goto L28;
        r9.setMaxLines(4);
        return;
    L28:
        if (r6 == true) goto L39;
        if (r8 == true) goto L40;
        if (r10 == false) goto L41;
        r11.setMaxLines(2);
        return;
    L41:
        return;
    L40:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.view.View, android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    /* JADX WARN: Type inference failed for: r7v7, types: [android.widget.EditText, com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText] */
    public static UDDialog e(final FragmentActivity r17, String r18, String r19, String r20, final boolean r21, boolean r22, List r23, final ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 r24, boolean r25, com.ss.android.lark.forwardv3.plugins.f r26) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r18, "titleBarText");
        Intrinsics.checkNotNullParameter(r19, "confirmButtonText");
        String r9 = r20;
        Intrinsics.checkNotNullParameter(r9, "cancelButtonText");
        Intrinsics.checkNotNullParameter(r23, "items");
        Intrinsics.checkNotNullParameter(r24, "onDialogListener");
        Intrinsics.checkNotNullParameter(r26, "forwardPluginManager");
        View r6 = LayoutInflater.from(r17).inflate(2131560029, null, false);
        r6.setBackgroundColor(y9c.d.c(r17, 2131100557));
        AppCompatImageView r10 = r6.findViewById(2131365501);
        RelativeLayout r13 = (RelativeLayout) r6.findViewById(2131386675);
        LKUIRoundedImageView r14 = r6.findViewById(2131386550);
        LKUIRoundedImageView r15 = r6.findViewById(2131384551);
        TextView r12 = (TextView) r6.findViewById(2131386676);
        CommonRecyclerView r11 = r6.findViewById(2131380437);
        ?? r7 = (KeyboardFunctionEditText) r6.findViewById(2131381010);
        if (r21 == false) goto L5;
        int r8 = 0;
    L6:
        r7.setVisibility(r8);
        r7.setOnTouchListener(new j(r7));
        com.ss.android.lark.forwardv3.plugins.i r5 = r26.b("forward_at_plugin");
        if (r5 == 0) goto L11;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        com.ss.android.lark.forwardv3.plugins.i r16 = r5.b(r17, null, r7);
        if (r16 == null) goto L11;
        r16.e(ForwardDataUtils.d(r23));
    L11:
        y1b.a r27 = (y1b.a) PluginServiceLoader.loadFirstOrNull(y1b.a.class);
        int r28 = r23.size();
        if (r28 == 0) goto L26;
        if (r28 == 1) goto L15;
        r11.setVisibility(0);
        r13.setVisibility(8);
        ForwardConfirmDialogAdapter r29 = new ForwardConfirmDialogAdapter(r17);
        r29.b = new l(r22, r27, r17);
        r29.addAll(r23);
        r11.setLayoutManager(new GridLayoutManager(r17, 5));
        r11.addItemDecoration(new ForwardConfirmDialogItemDecoration(r17));
        r11.setAdapter(r29);
    L25:
        View r30 = r6;
    L28:
        if (r30 != null) goto L30;
        return null;
    L30:
        ConstraintLayout r3 = (ConstraintLayout) r30.findViewById(2131363981);
        ConstraintLayout r31 = (ConstraintLayout) r30.findViewById(2131368369);
        final ?? r32 = (KeyboardFunctionEditText) r30.findViewById(2131381010);
        if (r25 == false) goto L35;
        boolean r110 = b.a("im.forward.url_preview", false);
        Log.i("FGUtils", "FG key: im.forward.url_preview: " + r110);
        if (r110 == false) goto L35;
        boolean r111 = true;
    L36:
        if (r25 == false) goto L40;
        if (r111 == false) goto L40;
        ForwardDialogContentLifecycleOwner r112 = new ForwardDialogContentLifecycleOwner();
    L41:
        final Function0<Unit> r2 = new ForwardViewUtils$buildDialog$confirmForward$1(r21, r17, r32, r24);
        h r113 = new h(r2);
        Function0<Boolean> r114 = new ForwardViewUtils$buildDialog$1(r2);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.keyboard.pass_attrs_revert") == true) goto L45;
        r32.setOnEditorActionListener(new m(r114));
    L45:
        if (r21 == true) goto L47;
    L49:
        g r4 = new g(r21, r17, r32, r24);
        if (aoc.b.a() == false) goto L54;
        Boolean r1 = ExternalKeyboardUtils.a;
        if (ExternalKeyboardUtils.b(false) == false) goto L54;
        r32.post(new f(r32));
    L54:
        i r33 = new i(r112, r24);
        UDDialogBuilder r34 = new UDDialogBuilder(r17);
        if (StringsKt.isBlank(r18) == false) goto L57;
        String r115 = y9c.d.i(r17, 2131891587);
    L58:
        UDDialogBuilder r35 = r34.title(r115).titleGravity(8388611).contentLayout(r30).onDismissListener(r33);
        if (StringsKt.isBlank(r19) == false) goto L61;
        String r36 = y9c.d.i(r17, 2131892196);
    L62:
        UDDialogBuilder r37 = r35.addActionButton(2131391777, r36, r113);
        if (StringsKt.isBlank(r20) == false) goto L65;
        r9 = y9c.d.i(r17, 2131891541);
    L65:
        Dialog r0 = r37.addActionButton(2131391778, r9, r4).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).cancelable(false).build();
        if (r25 == false) goto L74;
        r3.setVisibility(8);
        r31.setVisibility(0);
        if (r112 != null) goto L70;
    L73:
        r24.d(r31);
    L75:
        ForwardModuleV3.a().attachGlobalWatermark(r0);
        return r0;
    L70:
        if (r112.a.getCurrentState() != Lifecycle.State.CREATED) goto L72;
        r112.a.setCurrentState(Lifecycle.State.RESUMED);
    L72:
        ViewTreeLifecycleOwner.set(r31, r112);
        goto L73
    L74:
        r3.setVisibility(0);
        r31.setVisibility(8);
        r24.c(r3);
        goto L75
    L61:
        r36 = r19;
        goto L62
    L57:
        r115 = r18;
        goto L58
    L47:
        if (ForwardModuleV3.a().isEnterSendEnabled() == false) goto L49;
        int r116 = com.ss.android.lark.keyboard.utils.d.a;
        com.ss.android.lark.keyboard.utils.d.a(r32, new ForwardViewUtils$buildDialog$2(r2));
    L40:
        r112 = null;
    L35:
        r111 = false;
        goto L36
    L15:
        SearchBaseInfo r38 = (SearchBaseInfo) ListProtector.get(r23, 0);
        r11.setVisibility(8);
        r13.setVisibility(0);
        r12.setText(r38.getTitle());
        c(r17, r38, r14, r15);
        if (r22 == true) goto L18;
    L20:
        boolean r39 = false;
    L21:
        if (r39 == false) goto L23;
        int r40 = 0;
    L24:
        r10.setVisibility(r40);
        r13.setOnClickListener(new k(r39, r27, r17, r38));
        goto L25
    L23:
        r40 = 8;
        goto L24
    L18:
        if (ExternalTargetAvatarProviderStore.INSTANCE.requiresProvider(r38) == true) goto L20;
        r39 = true;
        goto L21
    L26:
        Log.e("NewForward_ForwardViewUtils", "forward confirm dialog's items size is empty");
        r30 = null;
        goto L28
    L5:
        r8 = 8;
        goto L6
    }
}
