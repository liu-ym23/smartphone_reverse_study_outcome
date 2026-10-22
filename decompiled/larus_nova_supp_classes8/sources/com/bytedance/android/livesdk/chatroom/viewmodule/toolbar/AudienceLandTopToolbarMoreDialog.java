package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.nt;
import com.bytedance.android.livesdk.widget.CustomShaderRectView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AudienceLandTopToolbarMoreDialog;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AbsAudienceToolbarButtonMoreDialog;", "Lcom/bytedance/android/live/matchroom/b;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLandTopToolbarMoreDialog extends AbsAudienceToolbarButtonMoreDialog implements com.bytedance.android.live.matchroom.b {
    public final String Q;
    public CustomShaderRectView R;
    public GridLayout S;
    public GridLayout T;
    public boolean U;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final Fragment W() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final x3 b1() {
        c0 r0 = y3.i(this.F);
        if (r0 == null) goto L7;
        return (x3) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void dismiss() {
        if (this.U == true) goto L5;
        MatchRoomLandScapeAnimUtil.E.j("AudienceLandTopToolbarMoreDialog");
    L9:
        this.U = false;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L23;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r0.getLooper()) goto L14;
        r0.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        boolean r2 = MatchRoomLandScapeAnimUtil.a;
        Intrinsics.checkNotNullParameter("AudienceLandTopToolbarMoreDialog", "key");
        if (MatchRoomLandScapeAnimUtil.b.get("AudienceLandTopToolbarMoreDialog") == null) goto L8;
        MatchRoomLandScapeAnimUtil.b.remove("AudienceLandTopToolbarMoreDialog");
    L8:
        ALogger.i("MatchRoomAnimUtil", "---- releaseDialogWithKey: remove [AudienceLandTopToolbarMoreDialog], now size:" + MatchRoomLandScapeAnimUtil.b.size() + " ---- ");
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void g1() {
        if (this.S != null) goto L5;
    L35:
        Iterator<Pair<ViewGroup, Integer>> r0 = this.G.iterator();
    L36:
        int r2 = 8;
        if (r0.hasNext() == false) goto L42;
        Pair<ViewGroup, Integer> r1 = r0.next();
        View r3 = (View) r1.getFirst();
        if (((ViewGroup) r1.getFirst()).getChildCount() <= 0) goto L41;
        r2 = 0;
    L41:
        UIUtils.setViewVisibility(r3, r2);
        goto L36
    L42:
        CustomShaderRectView r4 = this.R;
        if (r4 == null) goto L45;
        r4.post(new g(this));
    L45:
        CustomShaderRectView r5 = this.R;
        GridLayout r6 = this.T;
        if (r6 == null) goto L48;
        r2 = r6.getVisibility();
    L48:
        UIUtils.setViewVisibility(r5, r2);
        return;
    L5:
        if (j1() == true) goto L35;
        GridLayout r7 = this.S;
        ViewGroup.LayoutParams r8 = null;
        if (r7 == null) goto L10;
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
    L12:
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        int r11 = Z0();
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L17;
        r10.rightMargin = UtilityKotlinExtentionsKt.i(20);
    L18:
        GridLayout r12 = this.S;
        if (r12 == null) goto L29;
        r12.setLayoutParams(r9);
    L29:
        GridLayout r13 = this.T;
        if (r13 == null) goto L35;
        GridLayout r14 = this.S;
        if (r14 == null) goto L34;
        r8 = r14.getLayoutParams();
    L34:
        r13.setLayoutParams(r8);
    L17:
        r10.rightMargin = UtilityKotlinExtentionsKt.i(45);
        goto L18
    L21:
        ViewGroup.MarginLayoutParams r15 = new ViewGroup.MarginLayoutParams(r9);
        int r16 = Z0();
        if (r16 == 1) goto L25;
        if (r16 == 2) goto L25;
        r15.rightMargin = UtilityKotlinExtentionsKt.i(20);
    L26:
        GridLayout r17 = this.S;
        if (r17 == null) goto L29;
        r17.setLayoutParams(r15);
    L25:
        r15.rightMargin = UtilityKotlinExtentionsKt.i(45);
        goto L26
    L10:
        r9 = null;
        goto L12
    }

    public final int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.i(375);
    }

    public final boolean j1() {
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L8;
        r4 = (Room) r1.getValue();
    L8:
        if (r4 != null) goto L10;
    L13:
        m50 r2 = m50.a;
        if (r2.getValue().n() == true) goto L16;
    L18:
        return false;
    L16:
        if (r2.getValue().l() == false) goto L18;
        return true;
    L10:
        if (r4.isMergeVSRoom() != true) goto L13;
        return nt.a.getValue().booleanValue();
    }

    public final int getLayoutId() {
        if (j1() == false) goto L6;
        return 2131565668;
    L6:
        return 2131565667;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void h1() {
        View r0 = findViewById(2131367728);
        if (r0 == null) goto L11;
        int r3 = Z0();
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L8;
        int r4 = 2131249572;
    L10:
        r0.setBackgroundResource(r4);
        com.bytedance.android.live.core.utils.a1.k(r0, Math.min(com.bytedance.android.live.core.utils.s1.w(), com.bytedance.android.live.core.utils.s1.y()));
        r0.setOnClickListener(new h(this));
        goto L11
    L8:
        r4 = 2131249577;
        goto L10
    L9:
        r4 = 2131249576;
    L11:
        Window r1 = getWindow();
        if (r1 == null) goto L18;
        r1.setDimAmount(0.0f);
        if (j1() == false) goto L16;
        r1.setLayout(UtilityKotlinExtentionsKt.i(375), -1);
    L17:
        r1.setGravity(8388693);
        goto L18
    L16:
        r1.setLayout(-2, -1);
    L18:
        TextView r2 = (TextView) findViewById(2131380302);
        if (r2 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r2);
    L21:
        this.R = findViewById(2131369197);
        GridLayout r5 = (GridLayout) findViewById(2131388309);
        GridLayout r6 = null;
        if (r5 == null) goto L24;
        this.G.add(TuplesKt.to(r5, 1));
        Unit r7 = Unit.INSTANCE;
    L25:
        this.T = r5;
        GridLayout r8 = (GridLayout) findViewById(2131387155);
        if (r8 == null) goto L28;
        this.G.add(TuplesKt.to(r8, 2));
        r8.setPadding(r8.getPaddingLeft(), com.bytedance.android.live.core.utils.s1.f(26.0f), r8.getPaddingRight(), r8.getPaddingBottom());
        Unit r9 = Unit.INSTANCE;
        r6 = r8;
    L28:
        this.S = r6;
        return;
    L24:
        r5 = null;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        DataCenter r0 = this.F;
        if (r0 == null) goto L14;
        r0.put("data_predictor_more_entrance_shwo", Boolean.TRUE);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public AudienceLandTopToolbarMoreDialog(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, true, false);
        this.Q = "AudienceLandTopToolbarMoreDialog";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M0(View r3) {
        DataCenter r0 = this.F;
        if (r0 != null) goto L5;
    L8:
        DataCenter r1 = this.F;
        if (r1 != null) goto L11;
    L15:
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.M0(r3);
        return;
    L11:
        if (com.bytedance.android.live.core.utils.z.l(r1) == true) goto L15;
        if (m50.a.getValue().k() == false) goto L15;
    L14:
        boolean r2 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.x(this.Q, this, -1);
        goto L15
    L5:
        if (com.bytedance.android.live.core.utils.z.l(r0) != true) goto L8;
        if (nt.a.getValue().booleanValue() == true) goto L14;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog, android.view.View.OnClickListener
    public final void onClick(View r4) {
        ExtendedToolbarButton r0 = null;
        if (r4 == null) goto L5;
        Object r1 = r4.getTag();
    L7:
        if ((r1 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r1 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r1;
        if (r2 == null) goto L12;
        r0 = r2.m;
    L12:
        if (r0 != null) goto L14;
    L18:
        super.onClick(r4);
        return;
    L14:
        if (Intrinsics.areEqual(r0.f(), ToolbarButton.PREDICTOR_GUESS.name()) == false) goto L18;
        if (j1() == false) goto L18;
        this.U = true;
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void X0(ExtendedToolbarButton r4, c0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "behavior");
        b4.c.a.b(r4.f());
        y3.i(this.F).b(ToolbarButton.MORE, new pp1.j(false));
        if ((r5 instanceof com.bytedance.android.livesdk.room.placeholder.behavior.p) == true) goto L21;
        Handler r6 = DialogLancet.resolveDialogHandler(this);
        if (r6 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r7 == null) goto L18;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L7:
        if (Looper.myLooper() == r6.getLooper()) goto L9;
        r6.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final View x(ViewGroup r2, float r3, com.bytedance.android.livesdk.chatroom.e r4) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        View r5 = LayoutInflater.from(getContext()).inflate(2131567736, r2, false);
        com.bytedance.android.live.core.utils.a1.m(r5, UtilityKotlinExtentionsKt.i(10));
        return r5;
    }
}
