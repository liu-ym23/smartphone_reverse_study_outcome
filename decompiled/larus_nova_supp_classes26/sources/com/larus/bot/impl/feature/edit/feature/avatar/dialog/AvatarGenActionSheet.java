package com.larus.bot.impl.feature.edit.feature.avatar.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusDialogGenAvatarActionBinding;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001\u001b\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010+\u001a\u00020,H\u0016J&\u0010-\u001a\u0004\u0018\u00010\u000b2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u000103H\u0016Jê\u0001\u00106\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010*\u001a\u00020\u00122\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2%\u00109\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00142\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u000eH\u0002J\b\u0010=\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0012H\u0002J\u0016\u0010@\u001a\u00020\u000e2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarGenActionSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogGenAvatarActionBinding;", "avatarPromptInput", "Lcom/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarPromptInputDialog;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "uploadPicClickListener", "Lkotlin/Function0;", "", "avatarPrompt", "", "showTopDesc", "", "avatarChooserListener", "Lkotlin/Function1;", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Lkotlin/ParameterName;", "name", "selectedAvatar", "clickAiGenListener", "behaviorCallback", "com/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarGenActionSheet$behaviorCallback$1", "Lcom/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarGenActionSheet$behaviorCallback$1;", "bgImageInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "avatarInfo", "botName", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "creationId", "createWay", "enterMethod", "hasOriginAvatar", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUp", "showDesc", "picClickListener", "chooseListener", "clickAiListener", "(ZLcom/larus/bot/impl/bean/BotAvatarIconData;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "initView", "genBgImageByImage", "showAvatarPromptInput", "isGenBgImage", "checkRecordPermission", "doNext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarGenActionSheet extends BottomSheetDialogFragment implements by7.e {
    public static final /* synthetic */ int y = 0;
    public LarusDialogGenAvatarActionBinding d;
    public AvatarPromptInputDialog e;
    public BottomSheetBehavior<View> f;
    public Function0<Unit> g;
    public String h;
    public boolean i;
    public Function1<? super BotAvatarIconData, Unit> j;
    public Function0<Unit> k;
    public final b l;
    public BgImageInfo m;
    public BotAvatarIconData n;
    public String o;
    public String p;
    public String q;
    public String r;
    public boolean s;
    public BotModel t;
    public String u;
    public String v;
    public String w;
    public boolean x;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ AvatarGenActionSheet a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(AvatarGenActionSheet r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.f;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public AvatarGenActionSheet() {
        this.l = new b(this);
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public static void S90(AvatarGenActionSheet r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void V90(boolean r4) {
        AvatarPromptInputDialog r0 = this.e;
        if (r0 != null) goto L18;
    L10:
        AvatarPromptInputDialog r1 = new AvatarPromptInputDialog(this.h, new f(this));
        AvatarPromptInputDialog.S90(r1, r4, this.u, this.v);
        FragmentManager r5 = getParentFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "AvatarPromptInputDialog", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r1, r2) == false) goto L20;
    L15:
        this.e = r1;
        return;
    L20:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L14:
        r1.show(r5, "AvatarPromptInputDialog");
        goto L15
    L18:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L10;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L5;
        r6.setOnShowListener(new com.larus.bot.impl.feature.edit.feature.avatar.dialog.a(this));
    L5:
        LarusDialogGenAvatarActionBinding r7 = this.d;
        if (r7 == null) goto L19;
        e1.d(r7.b, new com.larus.bot.impl.feature.edit.feature.avatar.dialog.b(this));
        e1.d(r7.f, new c(this));
        e1.d(r7.c, new d(this));
        Dialog r8 = getDialog();
        if (r8 == null) goto L10;
        r8.setOnCancelListener(new e(this));
    L10:
        TextView r9 = r7.d;
        int r1 = 8;
        if (this.i == false) goto L13;
        int r0 = 0;
    L14:
        r9.setVisibility(r0);
        View r10 = r7.e;
        if (this.i == false) goto L17;
        r1 = 0;
    L17:
        r10.setVisibility(r1);
        return;
    L13:
        r0 = 8;
        goto L14
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562079, r9, false);
        int r12 = 2131363598;
        if (ViewBindings.findChildViewById(r11, 2131363598) == null) goto L23;
        r12 = 2131363599;
        if (ViewBindings.findChildViewById(r11, 2131363599) == null) goto L23;
        r12 = 2131363601;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131363601);
        if (r2 == null) goto L23;
        r12 = 2131365123;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131365123);
        if (r3 == null) goto L23;
        r12 = 2131365135;
        if (ViewBindings.findChildViewById(r11, 2131365135) == null) goto L23;
        r12 = 2131368819;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131368819);
        if (r4 == null) goto L23;
        r12 = 2131368825;
        View r5 = ViewBindings.findChildViewById(r11, 2131368825);
        if (r5 == null) goto L23;
        r12 = 2131391915;
        if (ViewBindings.findChildViewById(r11, 2131391915) == null) goto L23;
        r12 = 2131391933;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131391933);
        if (r6 == null) goto L23;
        LinearLayout r13 = (LinearLayout) r11;
        this.d = new LarusDialogGenAvatarActionBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public static /* synthetic */ void U90(AvatarGenActionSheet r20, boolean r21, BotAvatarIconData r22, BgImageInfo r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, boolean r31, Function0 r32, Function1 r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r34 & 4) == 0) goto L9;
        BgImageInfo r6 = null;
    L11:
        if ((r34 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r34 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r34 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r34 & 64) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r34 & 512) == 0) goto L29;
        String r13 = null;
    L31:
        if ((r34 & 1024) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r34 & 2048) == 0) goto L37;
        String r15 = null;
    L39:
        if ((r34 & 4096) == 0) goto L41;
        boolean r16 = false;
    L42:
        r20.T90(r4, r22, r6, r7, r8, r9, r10, null, null, r13, r14, r15, r16, r32, r33, null);
        return;
    L41:
        r16 = r31;
        goto L42
    L37:
        r15 = r30;
        goto L39
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r7 = r24;
        goto L15
    L9:
        r6 = r23;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    public final void T90(boolean r4, BotAvatarIconData r5, BgImageInfo r6, String r7, String r8, String r9, String r10, Boolean r11, BotModel r12, String r13, String r14, String r15, boolean r16, Function0<Unit> r17, Function1<? super BotAvatarIconData, Unit> r18, Function0<Unit> r19) {
        this.i = r4;
        if (r5 == null) goto L5;
        String r2 = r5.getPrompt();
    L6:
        this.h = r2;
        this.m = r6;
        this.n = r5;
        this.o = r7;
        this.p = r8;
        this.q = r9;
        this.r = r10;
        if (r11 == null) goto L9;
        boolean r1 = r11.booleanValue();
    L10:
        this.s = r1;
        this.t = r12;
        this.u = r13;
        this.v = r14;
        this.g = r17;
        this.j = r18;
        this.k = r19;
        this.w = r15;
        this.x = r16;
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
