package com.larus.push.impl.reminder;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.OpenPushReminderScene;
import com.larus.platform.api.s4;
import com.larus.platform.api.t4;
import com.larus.push.impl.PushEventManager;
import com.larus.push.impl.databinding.LarusOpenPushReminderBubbleLeftStyleBinding;
import com.larus.push.impl.databinding.LarusOpenPushReminderBubbleRightStyleBinding;
import com.larus.push.impl.databinding.LarusOpenPushReminderDialogBinding;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.j5;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u001b\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0016\u0010\u001d\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0003J\u001a\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/push/impl/reminder/OpenPushReminderDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/push/impl/databinding/LarusOpenPushReminderDialogBinding;", "sceneInfo", "Lcom/larus/push/impl/reminder/OpenPushReminderSceneInfo;", "bizData", "Lcom/larus/platform/api/OpenPushReminderData;", "sceneId", "", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "init", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "orDefaultFromResource", "defaultValue", "orDefaultAvatarFromResource", "initViews", "inflateBubbleLeftStyle", "uiData", "Lcom/larus/push/impl/reminder/BubbleUIData;", "useSubAvatar", "", "inflateBubbleRightStyle", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setupLandscape", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OpenPushReminderDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusOpenPushReminderDialogBinding d;
    public OpenPushReminderSceneInfo e;
    public s4 f;
    public String g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OpenPushReminderScene.values().length];
            r0[OpenPushReminderScene.LikeMsgForMainBot.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[OpenPushReminderScene.CopyMsgFromMainBot.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[OpenPushReminderScene.CreateVideo.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[OpenPushReminderScene.LikeBot.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[OpenPushReminderScene.ChatWithBot.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[OpenPushReminderScene.CreateBot.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void W90() {
        BottomSheetDialog r0 = getDialog();
        View r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.findViewById(2131368870);
    L8:
        if (r2 == null) goto L18;
        BottomSheetBehavior r3 = BottomSheetBehavior.from(r2);
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.getState() != 4) goto L15;
        r3.setState(3);
    L15:
        if (r3.getSkipCollapsed() == true) goto L20;
        r3.setSkipCollapsed(true);
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public OpenPushReminderDialog() {
    }

    public static void S90(OpenPushReminderDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static String U90(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return r1;
    L10:
        return "res://" + AppHost.a.getApplication().getPackageName() + "/2131240119";
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (r2.orientation != 2) goto L6;
        W90();
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        if (r3 == null) goto L6;
        this.g = r3.getString("scene_id");
    L6:
        if (this.e != null) goto L8;
    L9:
        FLogger.a.e("OpenPushReminderDialog", "OpenPushReminderDialog onCreate failed, sceneInfo or bizData is null, sceneId = " + this.g);
        String r4 = this.g;
        if (r4 == null) goto L12;
        OpenPushReminder r0 = OpenPushReminder.a;
        OpenPushReminder.c(r4);
    L12:
        S90(this);
        return;
    L8:
        if (this.f == null) goto L9;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        String r3 = this.g;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        OpenPushReminder r0 = OpenPushReminder.a;     // Catch: Throwable -> L7
        OpenPushReminder.c(r3);     // Catch: Throwable -> L7
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

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r3);
        String r0 = this.g;
        if (r0 == null) goto L6;
        r3.putString("scene_id", r0);
        FLogger.a.i("OpenPushReminderDialog", "saved sceneId = ".concat(r0));
        return;
    }

    public static String V90(String r1, int r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        int r3 = j0.a;
        return j0.d(r2);
    L11:
        return r1;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        if (getResources().getConfiguration().orientation != 2) goto L5;
        W90();
    L5:
        PushEventManager r9 = PushEventManager.a;
        s4 r10 = this.f;
        r9.getClass();
        if (r10 == null) goto L28;
        IApplog.Companion r11 = IApplog.a;     // Catch: Exception -> L23
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L23
        r1.put("current_page", "chat");     // Catch: Exception -> L23
        r1.put("scene", r10.a.getMobString());     // Catch: Exception -> L23
        t4 r3 = r10.b;     // Catch: Exception -> L23
        BotModel r4 = null;
        if (r3 == null) goto L11;
        e r5 = r3.a;     // Catch: Exception -> L23
    L12:
        if (r3 == null) goto L14;
        r4 = r3.b;     // Catch: Exception -> L23
    L14:
        r1.put("chat_type", PushEventManager.a(r5, r4));     // Catch: Exception -> L23
        t4 r12 = r10.b;     // Catch: Exception -> L23
        if (r12 == null) goto L20;
        BotModel r13 = r12.b;     // Catch: Exception -> L23
        if (r13 == null) goto L20;
        String r14 = r13.getBotId();     // Catch: Exception -> L23
        if (r14 == null) goto L20;
    L21:
        r1.put("bot_id", r14);     // Catch: Exception -> L23
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L23
        r11.reportEvent("push_authorize_guide_show", r1);     // Catch: Exception -> L23
        return;
    L20:
        r14 = "";
        goto L21
    L11:
        r5 = null;
    L23:
        e = move-exception;
        FLogger.a.i("PushEventManager", e.toString());
        return;
    }

    public static ConstraintLayout T90(LayoutInflater r13, com.larus.push.impl.reminder.a r14, boolean r15) {
        boolean r2 = false;
        ConstraintLayout r16 = r13.inflate(2131562988, null, false);
        int r0 = 2131376527;
        CircleSimpleDraweeView r5 = ViewBindings.findChildViewById(r16, 2131376527);
        if (r5 == null) goto L29;
        r0 = 2131376528;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r16, 2131376528);
        if (r1 == null) goto L29;
        r0 = 2131391223;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131391223);
        if (r10 == null) goto L29;
        r0 = 2131391224;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r16, 2131391224);
        if (r11 == null) goto L29;
        r0 = 2131391225;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r16, 2131391225);
        if (r12 == null) goto L29;
        ConstraintLayout r17 = r16;
        ImageLoaderKt.u(new LarusOpenPushReminderBubbleLeftStyleBinding(r17, r5, r1, r10, r11, r12).b, r14.a, "push_reminder_dialog");
        if (r15 == false) goto L15;
        int r18 = 0;
    L16:
        r1.setVisibility(r18);
        AppHost.Companion r19 = AppHost.a;
        String r3 = j5.a(r19.getApplication(), 2131894310, 2131901970);
        String r4 = r14.b;
        if (r4 != null) goto L19;
    L20:
        r2 = true;
    L21:
        if (r2 == true) goto L23;
    L25:
        r12.setText(V90(r14.b, 2131908040));
    L26:
        r10.setText(r14.c);
        int r110 = j0.a;
        r11.setText(j0.d(2131908186));
        return r17;
    L23:
        if (r19.isOversea() == false) goto L25;
        r12.setText(r3);
        goto L26
    L19:
        if (r4.length() != 0) goto L21;
    L15:
        r18 = 8;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r0)));
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r19, "inflater");
        boolean r4 = false;
        ConstraintLayout r2 = r19.inflate(2131562990, null, false);
        int r5 = 2131376531;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r2, 2131376531);
        if (r6 == null) goto L223;
        r5 = 2131386040;
        if (ViewBindings.findChildViewById(r2, 2131386040) == null) goto L223;
        r5 = 2131386041;
        if (ViewBindings.findChildViewById(r2, 2131386041) == null) goto L223;
        r5 = 2131386042;
        if (ViewBindings.findChildViewById(r2, 2131386042) == null) goto L223;
        r5 = 2131391219;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131391219);
        if (r14 == null) goto L223;
        r5 = 2131391220;
        View r11 = ViewBindings.findChildViewById(r2, 2131391220);
        if (r11 == null) goto L223;
        r5 = 2131391221;
        View r12 = ViewBindings.findChildViewById(r2, 2131391221);
        if (r12 == null) goto L223;
        r5 = 2131391229;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r2, 2131391229);
        if (r13 == null) goto L223;
        r5 = 2131391230;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r2, 2131391230);
        if (r10 == null) goto L223;
        r5 = 2131391231;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r2, 2131391231);
        if (r9 == null) goto L223;
        this.d = new LarusOpenPushReminderDialogBinding(r2, r6, r14, r11, r12, r13, r10, r9);
        r6.setOnClickListener(new com.larus.push.impl.reminder.b(this));
        OpenPushReminderSceneInfo r7 = this.e;
        if (r7 == null) goto L25;
        String r8 = r7.getTitle();
    L26:
        r9.setText(V90(r8, 2131908181));
        OpenPushReminderSceneInfo r3 = this.e;
        if (r3 == null) goto L29;
        String r15 = r3.getSubTitle();
    L30:
        r10.setText(V90(r15, 2131908187));
        int r16 = j0.a;
        r13.setText(j0.d(2131908180));
        r13.setOnClickListener(new c(this));
        s4 r17 = this.f;
        if (r17 == null) goto L33;
        OpenPushReminderScene r18 = r17.a;
    L34:
        if (r18 != null) goto L36;
        int r22 = -1;
    L38:
        switch(r22) {
            case 1: goto L119;
            case 2: goto L119;
            case 3: goto L92;
            case 4: goto L67;
            case 5: goto L67;
            case 6: goto L42;
            default: goto L39;
        };
    L39:
        s4 r23 = this.f;
        if (r23 != null) goto L146;
    L155:
        String r24 = null;
    L156:
        String r25 = U90(r24);
        s4 r26 = this.f;
        if (r26 == null) goto L163;
        t4 r27 = r26.b;
        if (r27 == null) goto L163;
        e r28 = r27.a;
        if (r28 == null) goto L163;
        String r29 = r28.c;
    L164:
        OpenPushReminderSceneInfo r30 = this.e;
        if (r30 == null) goto L169;
        BubbleInfo r31 = r30.getBubbleInfo();
        if (r31 == null) goto L169;
        String r32 = r31.getText();
    L170:
        com.larus.push.impl.reminder.a r33 = new com.larus.push.impl.reminder.a(r25, r29, V90(r32, 2131908184));
    L171:
        OpenPushReminderSceneInfo r34 = this.e;
        if (r34 == null) goto L176;
        BubbleInfo r35 = r34.getBubbleInfo();
        if (r35 == null) goto L176;
        Integer r36 = r35.getStyle();
    L177:
        int r37 = BubbleStyle.SIMPLE_LEFT.getValue();
        if (r36 != null) goto L181;
    L183:
        int r38 = BubbleStyle.SIMPLE_RIGHT.getValue();
        if (r36 != null) goto L187;
    L211:
        int r39 = BubbleStyle.SIMPLE_LEFT_WITH_SUB_AVATAR.getValue();
        if (r36 != null) goto L215;
    L217:
        ConstraintLayout r1 = T90(r19, r33, false);
    L218:
        r14.addView(r1);
        LarusOpenPushReminderDialogBinding r40 = this.d;
        if (r40 != null) goto L221;
        return null;
    L221:
        return r40.a;
    L215:
        if (r36.intValue() != r39) goto L217;
        r1 = T90(r19, r33, true);
        goto L218
    L187:
        if (r36.intValue() != r38) goto L211;
        ConstraintLayout r41 = r19.inflate(2131562989, null, false);
        int r42 = 2131376529;
        CircleSimpleDraweeView r110 = ViewBindings.findChildViewById(r41, 2131376529);
        if (r110 == null) goto L210;
        r42 = 2131376530;
        if (ViewBindings.findChildViewById(r41, 2131376530) == null) goto L210;
        r42 = 2131391226;
        TextView r43 = (TextView) ViewBindings.findChildViewById(r41, 2131391226);
        if (r43 == null) goto L210;
        r42 = 2131391227;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r41, 2131391227);
        if (r111 == null) goto L210;
        r42 = 2131391228;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r41, 2131391228);
        if (r112 == null) goto L210;
        r1 = r41;
        ImageLoaderKt.u(new LarusOpenPushReminderBubbleRightStyleBinding(r1, r110, r43, r111, r112).b, r33.a, "push_reminder_dialog");
        AppHost.Companion r44 = AppHost.a;
        String r45 = j5.a(r44.getApplication(), 2131894310, 2131901970);
        String r46 = r33.b;
        if (r46 != null) goto L201;
    L202:
        r4 = true;
    L203:
        if (r4 == true) goto L205;
    L207:
        r112.setText(V90(r33.b, 2131908040));
    L208:
        r43.setText(r33.c);
        r111.setText("· " + j0.d(2131908186));
        goto L218
    L205:
        if (r44.isOversea() == false) goto L207;
        r112.setText(r45);
        goto L208
    L201:
        if (r46.length() != 0) goto L203;
    L210:
        throw new NullPointerException("Missing required view with ID: ".concat(r41.getResources().getResourceName(r42)));
    L181:
        if (r36.intValue() != r37) goto L183;
        r1 = T90(r19, r33, false);
    L176:
        r36 = null;
    L169:
        r32 = null;
    L163:
        r29 = null;
        goto L164
    L146:
        t4 r47 = r23.b;
        if (r47 == null) goto L155;
        e r48 = r47.a;
        if (r48 == null) goto L155;
        IconImage r49 = r48.b;
        if (r49 == null) goto L155;
        ImageObj r50 = r49.imageThumb;
        if (r50 == null) goto L155;
        r24 = r50.url;
        goto L156
    L42:
        s4 r51 = this.f;
        if (r51 == null) goto L51;
        t4 r52 = r51.b;
        if (r52 == null) goto L51;
        BotModel r53 = r52.b;
        if (r53 == null) goto L51;
        BotIconImage r54 = r53.getIconImage();
        if (r54 == null) goto L51;
        String r55 = r54.getTinyUrl();
    L52:
        String r56 = U90(r55);
        s4 r57 = this.f;
        if (r57 == null) goto L59;
        t4 r58 = r57.b;
        if (r58 == null) goto L59;
        BotModel r59 = r58.b;
        if (r59 == null) goto L59;
        String r60 = r59.getName();
    L60:
        OpenPushReminderSceneInfo r61 = this.e;
        if (r61 == null) goto L65;
        BubbleInfo r62 = r61.getBubbleInfo();
        if (r62 == null) goto L65;
        String r63 = r62.getText();
    L66:
        r33 = new com.larus.push.impl.reminder.a(r56, r60, V90(r63, 2131908182));
    L65:
        r63 = null;
    L59:
        r60 = null;
    L51:
        r55 = null;
        goto L52
    L67:
        s4 r64 = this.f;
        if (r64 == null) goto L76;
        t4 r65 = r64.b;
        if (r65 == null) goto L76;
        BotModel r66 = r65.b;
        if (r66 == null) goto L76;
        BotIconImage r67 = r66.getIconImage();
        if (r67 == null) goto L76;
        String r68 = r67.getTinyUrl();
    L77:
        String r69 = U90(r68);
        s4 r70 = this.f;
        if (r70 == null) goto L84;
        t4 r71 = r70.b;
        if (r71 == null) goto L84;
        BotModel r72 = r71.b;
        if (r72 == null) goto L84;
        String r73 = r72.getName();
    L85:
        OpenPushReminderSceneInfo r74 = this.e;
        if (r74 == null) goto L90;
        BubbleInfo r75 = r74.getBubbleInfo();
        if (r75 == null) goto L90;
        String r76 = r75.getText();
    L91:
        r33 = new com.larus.push.impl.reminder.a(r69, r73, V90(r76, 2131908184));
    L90:
        r76 = null;
    L84:
        r73 = null;
    L76:
        r68 = null;
        goto L77
    L92:
        s4 r77 = this.f;
        if (r77 == null) goto L103;
        t4 r78 = r77.b;
        if (r78 == null) goto L103;
        e r79 = r78.a;
        if (r79 == null) goto L103;
        IconImage r80 = r79.b;
        if (r80 == null) goto L103;
        ImageObj r81 = r80.imageThumb;
        if (r81 == null) goto L103;
        String r82 = r81.url;
    L104:
        String r83 = U90(r82);
        s4 r84 = this.f;
        if (r84 == null) goto L111;
        t4 r85 = r84.b;
        if (r85 == null) goto L111;
        e r86 = r85.a;
        if (r86 == null) goto L111;
        String r87 = r86.c;
    L112:
        OpenPushReminderSceneInfo r88 = this.e;
        if (r88 == null) goto L117;
        BubbleInfo r89 = r88.getBubbleInfo();
        if (r89 == null) goto L117;
        String r90 = r89.getText();
    L118:
        r33 = new com.larus.push.impl.reminder.a(r83, r87, V90(r90, 2131908185));
    L117:
        r90 = null;
    L111:
        r87 = null;
    L103:
        r82 = null;
        goto L104
    L119:
        s4 r91 = this.f;
        if (r91 == null) goto L130;
        t4 r92 = r91.b;
        if (r92 == null) goto L130;
        e r93 = r92.a;
        if (r93 == null) goto L130;
        IconImage r94 = r93.b;
        if (r94 == null) goto L130;
        ImageObj r95 = r94.imageThumb;
        if (r95 == null) goto L130;
        String r96 = r95.url;
    L131:
        String r97 = U90(r96);
        s4 r98 = this.f;
        if (r98 == null) goto L138;
        t4 r99 = r98.b;
        if (r99 == null) goto L138;
        e r100 = r99.a;
        if (r100 == null) goto L138;
        String r101 = r100.c;
    L139:
        OpenPushReminderSceneInfo r102 = this.e;
        if (r102 == null) goto L144;
        BubbleInfo r103 = r102.getBubbleInfo();
        if (r103 == null) goto L144;
        String r104 = r103.getText();
    L145:
        r33 = new com.larus.push.impl.reminder.a(r97, r101, V90(r104, 2131908184));
    L144:
        r104 = null;
    L138:
        r101 = null;
    L130:
        r96 = null;
        goto L131
    L36:
        r22 = b.a[r18.ordinal()];
        goto L38
    L33:
        r18 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r8 = null;
    L223:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r5)));
    }
}
