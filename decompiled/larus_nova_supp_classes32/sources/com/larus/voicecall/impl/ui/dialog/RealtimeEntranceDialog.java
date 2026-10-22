package com.larus.voicecall.impl.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import b3a.c;
import b4a.e;
import b4a.f;
import b4a.h;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusDialogRealtimeEntranceBinding;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J&\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010,\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010-\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u00062"}, d2 = {"Lcom/larus/voicecall/impl/ui/dialog/RealtimeEntranceDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "curBean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "binding", "Lcom/larus/voicecall/impl/databinding/LarusDialogRealtimeEntranceBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "isCancel", NameKeys.UnloadStrategy_No_Strategy, "behaviorCallback", "com/larus/voicecall/impl/ui/dialog/RealtimeEntranceDialog$behaviorCallback$1", "Lcom/larus/voicecall/impl/ui/dialog/RealtimeEntranceDialog$behaviorCallback$1;", "injectFData", "bean", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", NameKeys.UnloadStrategy_No_Strategy, "view", "setupEntranceItem", "setupVideoCallEntrance", "setupVoiceCallEntrance", "setupShareScreenEntrance", "setupCallSceneEntrance", "setupEntranceListener", "mobMenuInteraction", "btnType", NameKeys.UnloadStrategy_No_Strategy, "interactionType", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "showNow", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "show", NameKeys.UnloadStrategy_No_Strategy, "transaction", "Landroidx/fragment/app/FragmentTransaction;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeEntranceDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public c d;
    public LarusDialogRealtimeEntranceBinding e;
    public BottomSheetBehavior<View> f;
    public final b g;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ RealtimeEntranceDialog a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(RealtimeEntranceDialog r1) {
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

    public RealtimeEntranceDialog() {
        this.g = new b(this);
    }

    public static void S90(RealtimeEntranceDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L5
        T90("cancel", "click_button");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L5
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

    public final void T90(String r6, String r7) {
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        c r2 = this.d;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.i;
    L6:
        r1.put("call_enter_method", r4);
        c r5 = this.d;
        if (r5 == null) goto L11;
        BotModel r8 = r5.e;
        if (r8 == null) goto L11;
        String r9 = r8.getBotId();
    L12:
        r1.put("bot_id", r9);
        c r10 = this.d;
        if (r10 == null) goto L15;
        String r11 = r10.b;
    L16:
        r1.put("conversation_id", r11);
        c r12 = this.d;
        if (r12 == null) goto L19;
        r3 = r12.g;
    L19:
        r1.put("chat_type", r3);
        r1.put("button_type", r6);
        r1.put("interaction_type", r7);
        Unit r13 = Unit.INSTANCE;
        r0.reportEvent("call_menu_interaction", r1);
        return;
    L15:
        r11 = null;
    L11:
        r9 = null;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        r11.setOnShowListener(new b4a.a(this));
    L5:
        LarusDialogRealtimeEntranceBinding r12 = this.e;
        int r13 = 8;
        if (r12 == null) goto L22;
        List r2 = h.a().b();
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        LinearLayout r4 = r12.e;
        if (r3 == false) goto L16;
        int r5 = 0;
    L17:
        r4.setVisibility(r5);
        View r14 = r12.f;
        if (r3 == false) goto L20;
        int r6 = 0;
    L21:
        r14.setVisibility(r6);
        goto L22
    L20:
        r6 = 8;
        goto L21
    L16:
        r5 = 8;
        goto L17
    L10:
        if (r2.contains(Integer.valueOf(CallEntranceType.VIDEO.getType())) != true) goto L12;
        r3 = true;
    L22:
        LarusDialogRealtimeEntranceBinding r15 = this.e;
        if (r15 == null) goto L39;
        List r7 = h.a().b();
        if (r7 != null) goto L27;
    L29:
        boolean r8 = false;
    L30:
        LinearLayout r16 = r15.g;
        if (r8 == false) goto L33;
        int r17 = 0;
    L34:
        r16.setVisibility(r17);
        View r18 = r15.h;
        if (r8 == false) goto L37;
        int r19 = 0;
    L38:
        r18.setVisibility(r19);
        goto L39
    L37:
        r19 = 8;
        goto L38
    L33:
        r17 = 8;
        goto L34
    L27:
        if (r7.contains(Integer.valueOf(CallEntranceType.CALL.getType())) != true) goto L29;
        r8 = true;
    L39:
        LarusDialogRealtimeEntranceBinding r20 = this.e;
        if (r20 == null) goto L61;
        List r21 = h.a().b();
        if (r21 != null) goto L44;
    L46:
        boolean r22 = false;
    L47:
        if (r22 == false) goto L51;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.B() == false) goto L51;
        boolean r23 = true;
    L52:
        View r24 = r20.d;
        if (r23 == false) goto L55;
        int r25 = 0;
    L56:
        r24.setVisibility(r25);
        LinearLayout r26 = r20.c;
        if (r23 == false) goto L59;
        int r27 = 0;
    L60:
        r26.setVisibility(r27);
        goto L61
    L59:
        r27 = 8;
        goto L60
    L55:
        r25 = 8;
    L51:
        r23 = false;
        goto L52
    L44:
        if (r21.contains(Integer.valueOf(CallEntranceType.SHARE_SCREEN.getType())) != true) goto L46;
        r22 = true;
    L61:
        LarusDialogRealtimeEntranceBinding r28 = this.e;
        if (r28 == null) goto L108;
        List r29 = h.a().b();
        if (r29 != null) goto L66;
    L68:
        boolean r30 = false;
    L69:
        LinearLayout r31 = r28.b;
        if (r30 == false) goto L72;
        r13 = 0;
    L72:
        r31.setVisibility(r13);
        boolean r110 = Intrinsics.areEqual(h.a().a(), Boolean.TRUE);
        if (r30 == false) goto L108;
        if (r110 == false) goto L108;
        c r111 = this.d;
        if (r111 == null) goto L82;
        BotModel r112 = r111.e;
        if (r112 == null) goto L82;
        SceneModelList r113 = r112.getSceneModelList();
        if (r113 == null) goto L82;
        List r114 = r113.getList();
    L83:
        if (r114 == null) goto L108;
        if (r114.isEmpty() == true) goto L108;
        List r32 = h.a().c();
        if (r32 != null) goto L90;
        r32 = CollectionsKt.emptyList();
    L90:
        Iterator r33 = r32.iterator();
    L92:
        if (r33.hasNext() == false) goto L108;
        int r34 = ((Number) r33.next()).intValue();
        Iterator r35 = r114.iterator();
    L95:
        if (r35.hasNext() == false) goto L102;
        Object r36 = r35.next();
        if (((SceneModel) r36).getId() != r34) goto L99;
        boolean r37 = true;
    L100:
        if (r37 == false) goto L95;
    L103:
        SceneModel r38 = (SceneModel) r36;
        if (r38 == null) goto L92;
        FLogger.a.i("RealtimeEntranceDialog", "[setupCallSceneEntrance]: find SceneModel:" + r38);
        r28.i.setText(r38.getName());
        c r39 = this.d;
        if (r39 == null) goto L108;
        r39.N = r38;
        goto L108
    L99:
        r37 = false;
        goto L100
    L102:
        r36 = null;
    L82:
        r114 = null;
        goto L83
    L66:
        if (r29.contains(Integer.valueOf(CallEntranceType.CALL_SCENE.getType())) != true) goto L68;
        r30 = true;
    L108:
        LarusDialogRealtimeEntranceBinding r40 = this.e;
        if (r40 == null) goto L113;
        LinearLayout r41 = r40.e;
        if (r41 == null) goto L113;
        e1.d(r41, new b4a.b(this));
    L113:
        LarusDialogRealtimeEntranceBinding r42 = this.e;
        if (r42 == null) goto L118;
        LinearLayout r43 = r42.g;
        if (r43 == null) goto L118;
        e1.d(r43, new b4a.c(this));
    L118:
        LarusDialogRealtimeEntranceBinding r44 = this.e;
        if (r44 == null) goto L123;
        LinearLayout r45 = r44.c;
        if (r45 == null) goto L123;
        e1.d(r45, new b4a.d(this));
    L123:
        LarusDialogRealtimeEntranceBinding r46 = this.e;
        if (r46 == null) goto L128;
        LinearLayout r47 = r46.b;
        if (r47 == null) goto L128;
        e1.d(r47, new e(this));
    L128:
        LarusDialogRealtimeEntranceBinding r48 = this.e;
        if (r48 == null) goto L142;
        TextView r49 = r48.j;
        if (r49 == null) goto L143;
        e1.d(r49, new f(this));
        return;
    L143:
        return;
    }

    public final int show(FragmentTransaction r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "transaction");
        T90(NameKeys.UnloadStrategy_No_Strategy, "popup");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, this, r0) == false) goto L9;
        return -1;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L7:
        return super/*androidx.fragment.app.DialogFragment*/.show(r3, r4);
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        T90(NameKeys.UnloadStrategy_No_Strategy, "popup");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super/*androidx.fragment.app.DialogFragment*/.showNow(r3, r4);
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == false) goto L10;
    L7:
        T90(NameKeys.UnloadStrategy_No_Strategy, "popup");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super/*androidx.fragment.app.DialogFragment*/.show(r2, r3);
        goto L7
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r15 = r12.inflate(2131562100, r13, false);
        int r16 = 2131372693;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131372693);
        if (r2 == null) goto L23;
        r16 = 2131372838;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131372838);
        if (r3 == null) goto L23;
        r16 = 2131372839;
        View r4 = ViewBindings.findChildViewById(r15, 2131372839);
        if (r4 == null) goto L23;
        r16 = 2131372880;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131372880);
        if (r5 == null) goto L23;
        r16 = 2131372881;
        View r6 = ViewBindings.findChildViewById(r15, 2131372881);
        if (r6 == null) goto L23;
        r16 = 2131372888;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131372888);
        if (r7 == null) goto L23;
        r16 = 2131372889;
        View r8 = ViewBindings.findChildViewById(r15, 2131372889);
        if (r8 == null) goto L23;
        r16 = 2131390262;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131390262);
        if (r9 == null) goto L23;
        r16 = 2131390273;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r15, 2131390273);
        if (r10 == null) goto L23;
        LinearLayout r17 = (LinearLayout) r15;
        this.e = new LarusDialogRealtimeEntranceBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return r17;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
