package com.bytedance.android.livesdk.interactivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/PSOperatePanelDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/e;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSOperatePanelDialog extends DialogFragment implements View.OnClickListener, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e {
    public static final /* synthetic */ int n = 0;
    public List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> d;
    public List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> e;
    public List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> f;
    public com.bytedance.android.livesdk.interactivity.api.entity.l g;
    public LinearLayout h;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public LinearLayout l;
    public final c m;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ PSOperatePanelDialog a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LinearLayout r0 = this.a.j;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            PSOperatePanelDialog r2 = this.a;
            Dialog r3 = r2.getDialog();
            Integer r4 = null;
            if (r3 == null) goto L12;
            Window r5 = r3.getWindow();
            if (r5 == null) goto L12;
            WindowManager.LayoutParams r6 = r5.getAttributes();
        L13:
            Dialog r7 = r2.getDialog();
            if (r7 == null) goto L24;
            Window r8 = r7.getWindow();
            if (r8 == null) goto L24;
            View r9 = r8.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L22;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r10 = ThreadMethodProxy.currentThread();
            if (r10 == com.larus.home.impl.utils.c.a) goto L22;
            com.larus.home.impl.utils.c.a(r10, "getDecorView");
        L22:
            if (r9 == null) goto L24;
            r4 = Integer.valueOf(r9.getHeight());
        L24:
            if (r6 == null) goto L35;
            int r11 = (int) (((double) s1.w()) * 0.6d);
            ALogger.d("PSOperatePanel", "PSOperatePanelDialog-height is " + r6.height + " maxHeight = " + r11 + " h = " + r4);
            if (r4 != null) goto L28;
            return;
        L28:
            if (r4.intValue() <= r11) goto L37;
            r6.height = r11;
            Dialog r13 = r2.getDialog();
            if (r13 == null) goto L38;
            Window r14 = r13.getWindow();
            if (r14 == null) goto L39;
            r14.setAttributes(r6);
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L35:
            return;
        L12:
            r6 = null;
            goto L13
        }

        public b(PSOperatePanelDialog r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.android.live.room.api.panel.b {
        public final /* synthetic */ PSOperatePanelDialog a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ Function1 b;

            public a(c r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function1 r0 = this.b;     // Catch: Throwable -> L8
                LinearLayout r1 = this.a.a.l;     // Catch: Throwable -> L8
                if (r1 == null) goto L5;
                int r2 = r1.getHeight();     // Catch: Throwable -> L8
            L6:
                r0.invoke(Integer.valueOf(r2));     // Catch: Throwable -> L8
                return;
            L5:
                r2 = 0;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public final int getUnionId() {
            return hashCode();
        }

        public final PanelName getPanelName() {
            return PanelName.PublicScreenOperatePanel;
        }

        public c(PSOperatePanelDialog r1) {
            this.a = r1;
        }

        public final void a(Function1<? super Integer, Unit> r2, Function1<? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "continueAction");
            Intrinsics.checkNotNullParameter(r3, "stopAction");
            LinearLayout r0 = this.a.l;
            if (r0 == null) goto L5;
            r0.post(new a(this, r2));
            return;
        L5:
            r3.invoke("root view is null");
        }
    }

    static {
    }

    public final void onDestroyView() {
        int r0 = com.bytedance.android.live.room.api.panel.d.a;
        long r3 = 0;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        Room r4 = (Room) r2.getValue();
        if (r4 == null) goto L9;
        r3 = r4.id;
    L9:
        com.bytedance.android.live.room.api.panel.c r5 = com.bytedance.android.live.room.api.panel.d.b(null, r3);
        if (r5 == null) goto L12;
        r5.notifyPanelClose(PanelName.PublicScreenOperatePanel, this.m);
    L12:
        LinearLayout r6 = this.h;
        if (r6 == null) goto L15;
        r6.removeAllViews();
    L15:
        LinearLayout r7 = this.i;
        if (r7 == null) goto L18;
        r7.removeAllViews();
    L18:
        LinearLayout r8 = this.j;
        if (r8 == null) goto L21;
        r8.removeAllViews();
    L21:
        LinearLayout r9 = this.k;
        if (r9 == null) goto L24;
        r9.removeAllViews();
    L24:
        Iterator<T> r10 = this.d.iterator();
    L26:
        if (r10.hasNext() == false) goto L28;
        ((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r10.next()).onDestroyView();
        goto L26
    L28:
        Iterator<T> r11 = this.e.iterator();
    L30:
        if (r11.hasNext() == false) goto L32;
        ((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r11.next()).onDestroyView();
        goto L30
    L32:
        Iterator<T> r13 = this.f.iterator();
    L34:
        if (r13.hasNext() == false) goto L36;
        ((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r13.next()).onDestroyView();
        goto L34
    L36:
        super.onDestroyView();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e
    public final int ot() {
        LinearLayout r0 = this.l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getHeight();
    }

    public PSOperatePanelDialog() {
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.m = new c(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e
    public final void dismissDialog() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(List r17) {
        com.bytedance.android.livesdk.interactivity.api.entity.l r1 = this.g;
        if (r1 != null) goto L5;
        return;
    L5:
        ALogger.e("PSOperatePanel", "PSOperatePanelDialog-preProcessItem");
        Iterator r2 = r17.iterator();
    L7:
        if (r2.hasNext() == false) goto L53;
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a r3 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r2.next();
        View r4 = r3.getView(r1.getContext());
        if (r4 == null) goto L11;
        r4.setOnClickListener(this);
    L11:
        r3.c(r1, this);
        if ((r1.b instanceof i4) == false) goto L14;
        String r5 = "reply";
    L15:
        Map r6 = MapsKt.mapOf(TuplesKt.to("event_user_type", r5));
        int r7 = com.bytedance.android.livesdk.interactivity.utils.r.a;
        long r8 = r3.a().getId();
        RoomContext.a r9 = RoomContext.Companion;
        String r10 = null;
        RoomContext r11 = RoomContext.a.c(r9, null, 0, 3);
        if (r11 == null) goto L22;
        com.bytedance.live.datacontext.i r13 = r11.isAnchor();
        if (r13 == null) goto L22;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L22;
        boolean r14 = true;
    L23:
        Intrinsics.checkNotNullParameter(r6, "extra");
        HashMap r15 = new HashMap();
        r15.put("item_id", String.valueOf(r8));
        String r16 = "1";
        if (r14 == false) goto L26;
        Object r18 = "1";
    L27:
        r15.put("is_anchor", r18);
        r15.putAll(r6);
        if (r8 != PanelItemSymbol.COMMENT_CONTROL_MODE.getId()) goto L52;
        RoomContext r19 = RoomContext.a.c(r9, null, 0, 3);
        if (r19 == null) goto L36;
        com.bytedance.live.datacontext.m r20 = r19.getRoom();
        if (r20 == null) goto L36;
        Room r21 = (Room) r20.getValue();
        if (r21 == null) goto L36;
        String r23 = r21.getIdStr();
    L37:
        r15.put("anchor_id", r23);
        RoomContext r24 = RoomContext.a.c(r9, null, 0, 3);
        if (r24 == null) goto L44;
        com.bytedance.live.datacontext.m r25 = r24.getRoom();
        if (r25 == null) goto L44;
        Room r26 = (Room) r25.getValue();
        if (r26 == null) goto L44;
        r10 = r26.getOwnerUserIdString();
    L44:
        r15.put("room_id", r10);
        long r27 = CommentControlSwitchHelper.b();
        if (r27 != 0) goto L48;
    L50:
        r16 = "0";
    L51:
        r15.put("item_style", r16);
        goto L52
    L48:
        if (r27 != 1) goto L50;
    L36:
        r23 = null;
    L52:
        com.bytedance.android.livesdk.log.u.l().sendLog("live_public_screen_action_sheet_item_show", r15, new Object[]{Room.class});
        goto L7
    L26:
        r18 = "0";
    L22:
        r14 = false;
        goto L23
    L14:
        r5 = "create";
        goto L15
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L7;
        r5.setLayout(-1, -2);
    L7:
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        r7.setGravity(80);
        return;
    L14:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        PSOperatePanelDialog r1 = null;
        if (S90(this.d, r4) == true) goto L5;
        PSOperatePanelDialog r0 = this;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (S90(this.e, r4) == true) goto L10;
        r1 = r0;
    L10:
        if (r1 == null) goto L14;
        S90(this.f, r4);
        return;
    L14:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954616);
        super.onCreate(r3);
    }

    public final void onDismiss(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");     // Catch: Throwable -> L12
        super.onDismiss(r5);     // Catch: Throwable -> L12
        com.bytedance.android.livesdk.sharedpref.e<Long> r6 = CommentControlSwitchHelper.a;     // Catch: Throwable -> L12
        long r2 = 0;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();     // Catch: Throwable -> L12
        if (r8 == null) goto L9;
        Room r9 = (Room) r8.getValue();     // Catch: Throwable -> L12
        if (r9 == null) goto L9;
        r2 = r9.id;     // Catch: Throwable -> L12
    L9:
        CommentControlSwitchHelper.a(r2);     // Catch: Throwable -> L12
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L12:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final boolean S90(List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r4, View r5) {
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a r0 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r6.next();
        if (r5 == null) goto L8;
        Object r1 = r5.getTag();
    L10:
        if (r1 != r0.a()) goto L4;
        r0.onClick(r5);
        return true;
    L8:
        r1 = null;
        goto L10
    L13:
        return false;
    }

    public final View onCreateView(LayoutInflater r20, ViewGroup r21, Bundle r23) {
        Intrinsics.checkNotNullParameter(r20, "inflater");
        ALogger.e("PSOperatePanel", "PSOperatePanelDialog-onCreateView");
        com.bytedance.android.livesdk.interactivity.api.entity.l r3 = this.g;
        Context r4 = null;
        if (r3 == null) goto L5;
        Context r5 = r3.getContext();
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        com.bytedance.android.livesdk.interactivity.api.entity.l r6 = this.g;
        if (r6 != null) goto L11;
        return null;
    L11:
        ALogger.e("PSOperatePanel", "PSOperatePanelDialog-context is not null");
        View r1 = r20.inflate(2131567218, r21, false);
        this.h = (LinearLayout) r1.findViewById(2131389194);
        this.i = (LinearLayout) r1.findViewById(2131380096);
        LinearLayout r2 = (LinearLayout) r1.findViewById(2131364496);
        this.j = r2;
        if (r2 == null) goto L16;
        ViewTreeObserver r7 = r2.getViewTreeObserver();
        if (r7 == null) goto L16;
        r7.addOnGlobalLayoutListener(new b(this));
    L16:
        this.k = (LinearLayout) r1.findViewById(2131379973);
        this.l = (LinearLayout) r1.findViewById(2131384840);
        View r8 = ((IPublicScreenService) jc1.k.n(IPublicScreenService.class)).createMessageViewInPSOperatePanel(r5, r6);
        LinearLayout r9 = this.k;
        if (r9 == null) goto L19;
        r9.addView(r8, new ViewGroup.LayoutParams(-2, -2));
    L19:
        int r10 = 1;
        if (this.d.isEmpty() == false) goto L24;
        LinearLayout r11 = this.h;
        if (r11 == null) goto L41;
        r11.setVisibility(8);
    L41:
        if (this.e.isEmpty() == false) goto L45;
        LinearLayout r13 = this.i;
        if (r13 == null) goto L61;
        r13.setVisibility(8);
    L61:
        long r14 = 0;
        if (this.f.isEmpty() == false) goto L66;
        LinearLayout r15 = this.j;
        if (r15 == null) goto L90;
        r15.setVisibility(8);
    L90:
        T90(this.d);
        T90(this.e);
        T90(this.f);
        int r16 = com.bytedance.android.live.room.api.panel.d.a;
        RoomContext r17 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r17 == null) goto L97;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L97;
        Room r19 = (Room) r18.getValue();
        if (r19 == null) goto L97;
        r14 = r19.id;
    L97:
        com.bytedance.android.live.room.api.panel.c r24 = com.bytedance.android.live.room.api.panel.d.b(null, r14);
        if (r24 == null) goto L100;
        r24.notifyPanelOpen(PanelName.PublicScreenOperatePanel, this.m);
    L100:
        return r1;
    L66:
        int r25 = this.f.size();
        int r26 = this.f.size();
        int r27 = 0;
    L67:
        if (r27 >= r26) goto L90;
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(-1, s1.j(2131168927));
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) ListProtector.get(this.f, r27)).a() != PanelItemSymbol.COMMENT_CONTROL_MODE) goto L76;
        long r110 = CommentControlSwitchHelper.b();
        if (r110 != 0) goto L74;
        r28 = new LinearLayout.LayoutParams(-1, s1.j(2131168536));
        goto L76
    L74:
        if (r110 != 1) goto L76;
        r28 = new LinearLayout.LayoutParams(-1, s1.j(2131168535));
    L76:
        LinearLayout r111 = this.j;
        if (r111 == null) goto L79;
        r111.addView(((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) ListProtector.get(this.f, r27)).getView(r5), r28);
    L79:
        if (r25 <= r10) goto L89;
        if (r27 >= (r25 - 1)) goto L89;
        LinearLayout r29 = this.j;
        if (r29 == null) goto L89;
        LinearLayout r112 = this.j;
        if (r112 == null) goto L87;
        Context r113 = r112.getContext();
    L88:
        TextView r114 = new TextView(r113);
        r114.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.j(2131168928)));
        r114.setBackgroundColor(s1.h(2131107859));
        Unit r30 = Unit.INSTANCE;
        r29.addView(r114);
        goto L89
    L87:
        r113 = null;
    L89:
        r27 = r27 + 1;
        r10 = 1;
        goto L67
    L45:
        int r31 = this.e.size();
        int r115 = this.e.size();
        int r116 = 0;
    L46:
        if (r116 >= r115) goto L61;
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-1, s1.j(2131168927));
        LinearLayout r118 = this.i;
        if (r118 == null) goto L50;
        r118.addView(((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) ListProtector.get(this.e, r116)).getView(r5), r117);
    L50:
        if (r31 <= 1) goto L60;
        if (r116 >= (r31 - 1)) goto L60;
        LinearLayout r33 = this.i;
        if (r33 == null) goto L60;
        LinearLayout r119 = this.i;
        if (r119 == null) goto L58;
        Context r120 = r119.getContext();
    L59:
        TextView r121 = new TextView(r120);
        r121.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.j(2131168928)));
        r121.setBackgroundColor(s1.h(2131107859));
        Unit r34 = Unit.INSTANCE;
        r33.addView(r121);
        goto L60
    L58:
        r120 = r4;
    L60:
        r116 = r116 + 1;
        r4 = null;
        goto L46
    L24:
        int r35 = this.d.size();
        int r36 = this.d.size();
        int r122 = 0;
    L25:
        if (r122 >= r36) goto L41;
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(-1, s1.j(2131169180));
        r123.weight = 1.0f;
        LinearLayout r124 = this.h;
        if (r124 == null) goto L29;
        r124.addView(((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) ListProtector.get(this.d, r122)).getView(r5), r123);
    L29:
        if (r35 <= 1) goto L39;
        if (r122 >= (r35 - 1)) goto L39;
        LinearLayout r125 = this.h;
        if (r125 == null) goto L39;
        LinearLayout r126 = this.h;
        if (r126 == null) goto L37;
        Context r127 = r126.getContext();
    L38:
        TextView r128 = new TextView(r127);
        r128.setLayoutParams(new ViewGroup.LayoutParams(s1.j(2131169181), 1));
        r128.setBackgroundColor(0);
        Unit r129 = Unit.INSTANCE;
        r125.addView(r128);
        goto L39
    L37:
        r127 = null;
    L39:
        r122 = r122 + 1;
        goto L25
    L5:
        r5 = null;
        goto L6
    }
}
