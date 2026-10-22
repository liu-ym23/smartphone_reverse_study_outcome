package com.bytedance.android.livesdk.chatroom.vs_base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayStatusBarUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayAdaptiveDialogFragment;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "<init>", "()V", "a", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ReplayAdaptiveDialogFragment extends AdaptiveDialogFragment implements com.bytedance.android.live.matchroom.b {
    public boolean e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ReplayAdaptiveDialogFragment a;

        public b(ReplayAdaptiveDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public abstract String S90();

    public final void dismiss() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r0 = ReplayRoomFragmentScopeUtil.a;
        ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).o(S90());
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L12;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.c(375);
    }

    public ReplayAdaptiveDialogFragment() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r0 = ReplayRoomFragmentScopeUtil.a;
        this.e = ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).i();
    }

    public final boolean isVertical() {
        return this.e;
    }

    public void onActivityCreated(Bundle r11) {
        super.onActivityCreated(r11);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r12 = ReplayRoomFragmentScopeUtil.a;
        ReplayAdaptiveDialogUIState r13 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        Dialog r0 = getDialog();
        View r1 = null;
        if (r0 == null) goto L5;
        Window r2 = r0.getWindow();
    L6:
        View r3 = getView();
        FragmentActivity r4 = getActivity();
        if (r2 != null) goto L9;
        r13.getClass();
    L81:
        View r14 = getView();
        if (r14 == null) goto L86;
        View r15 = r14.findViewById(2131369150);
        if (r15 == null) goto L86;
        r15.setOnClickListener(new b(this));
    L86:
        View r16 = getView();
        if (r16 == null) goto L89;
        r1 = r16.findViewById(2131368956);
    L89:
        Dialog r17 = getDialog();
        if (r17 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r5 = ReplayRoomFragmentScopeUtil.a;
        ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).s(r17, r1);
    L92:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r18 = ReplayRoomFragmentScopeUtil.a;
        ReplayAdaptiveDialogUIState r19 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        Dialog r6 = getDialog();
        if (r6 == null) goto L95;
        r6.getWindow();
    L95:
        r19.getClass();
        return;
    L9:
        d0 r7 = r13.a;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L12:
        boolean r8 = ReplayStatusBarUIState.q(r4, ((ReplayStatusBarUIState) r7.c(ReplayStatusBarUIState.class)).d());
        boolean r9 = r4 instanceof Context;
        int r10 = 0;
        if (r9 == false) goto L34;
        int r20 = t.a;
        if (r9 == true) goto L17;
        FragmentActivity r21 = null;
    L18:
        boolean r22 = true;
        if (r21 != null) goto L97;
    L29:
        boolean r23 = true;
    L30:
        if (r23 == false) goto L34;
        if (r13.i() == false) goto L34;
    L36:
        if (r8 == true) goto L40;
        if (r22 == true) goto L40;
        r2.addFlags(1024);
    L42:
        if (r13.i() == false) goto L44;
        r2.setGravity(80);
    L45:
        r2.setSoftInputMode(48);
        if (r8 == true) goto L64;
        if (r22 == true) goto L64;
        r2.setLayout(-1, -1);
        if (r3 == null) goto L52;
        ViewGroup.LayoutParams r110 = r3.getLayoutParams();
    L54:
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L56;
        r110 = null;
    L56:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L81;
        int r24 = t.a;
        Rect r25 = new Rect();
        if ((r4 instanceof Activity) == false) goto L61;
        t.b(r4.getWindow()).getWindowVisibleDisplayFrame(r25);
    L61:
        r111.height = r25.height();
        if (r3 == null) goto L81;
        r3.setLayoutParams(r111);
        goto L81
    L52:
        r110 = null;
    L64:
        if (r8 == false) goto L66;
        int r26 = s1.A();
    L67:
        if (r22 == false) goto L69;
        r10 = s1.o();
    L69:
        r2.setLayout(-1, -2);
        WindowManager.LayoutParams r112 = r2.getAttributes();
        int r27 = t.a;
        r112.width = s1.q(s1.getContext()).widthPixels;
        r112.height = (s1.q(s1.getContext()).heightPixels - r10) - r26;
        r2.setAttributes(r112);
        if (r3 == null) goto L72;
        ViewGroup.LayoutParams r113 = r3.getLayoutParams();
    L74:
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == true) goto L76;
        r113 = null;
    L76:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        if (r114 == null) goto L81;
        r114.height = (s1.q(s1.getContext()).heightPixels - r10) - r26;
        if (r3 == null) goto L81;
        r3.setLayoutParams(r114);
        goto L81
    L72:
        r113 = null;
        goto L74
    L66:
        r26 = 0;
        goto L67
    L44:
        r2.setGravity(8388613);
    L40:
        r2.clearFlags(1024);
        goto L42
    L97:
    L27:
        e = move-exception;
        ALogger.e("ReplayResUtils", "isNavBarShow: get nav bar status fail, " + e.getMessage());
        goto L29
    L22:
        if (Settings.Secure.getInt(r21.getContentResolver(), t.c(), 0) != 0) goto L26;
        if (Settings.Global.getInt(r21.getContentResolver(), t.c(), 0) == 0) goto L29;
    L26:
        r23 = false;
        goto L30
    L17:
        r21 = r4;
    L34:
        r22 = false;
        goto L36
    L5:
        r2 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r3 = ReplayRoomFragmentScopeUtil.a;
        setStyle(1, ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).t(getActivity()));
    }

    public final void setVertical(boolean r1) {
        this.e = r1;
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r0 = ReplayRoomFragmentScopeUtil.a;
        ReplayAdaptiveDialogUIState r1 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        String r2 = S90();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r1.h() == true) goto L5;
    L7:
        super/*com.bytedance.android.livesdk.LiveDialogFragment*/.onViewCreated(r4, r5);
        return;
    L5:
        if (r1.d() == false) goto L7;
        boolean r3 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y(r2, this, -1);
        goto L7
    }
}
