package com.bytedance.android.live.liveinteract.interact.audience.dialog;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkPadCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestSettingDialog;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.r;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/InteractAudienceGuestApplyDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkPadCommonBottomDialog;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceGuestApplyDialog extends LinkPadCommonBottomDialog {
    public final DataCenter B;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public a(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            int r8 = ChatRoomGuestSettingDialog.f;
            ChatRoomGuestSettingDialog.a.a();
            DataCenter r2 = this.a.B;
            if (r2 == null) goto L26;
            ChatRoomGuestSettingDialog r9 = new ChatRoomGuestSettingDialog(this.a.getContext(), r2, false, "", 2);
            if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L28;
            DialogLancet.handleBlockedDialogShow(r9);
        L9:
            CommonStandardBottomDialog r10 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r10);
            if (r0 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r10);
            r10.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r10);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r10);
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
            r0.post(DialogLancet.createDismissRunnable(r10));
            return;
        L28:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L8:
            DialogLancet.beforeDialogShow(r9);
            r9.show();
            DialogLancet.afterDialogShow(r9);
            goto L9
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;
        public final /* synthetic */ String b;

        public b(InteractAudienceGuestApplyDialog r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            m r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r9 == null) goto L5;
            IRoom r10 = (IRoom) r9.getValue();
        L6:
            if (r10 != null) goto L8;
        L15:
            com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
            com.bytedance.android.live.liveinteract.plantform.camera.b r0 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
            if (r0 == null) goto L34;
            com.bytedance.android.live.liveinteract.plantform.camera.b.C0048b.a(r0, !r0.d(this.b), false, false, false, "InteractAudienceGuestApplyDialog onCreate", 28);
            CommonStandardBottomDialog r11 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r11);
            if (r1 != null) goto L20;
        L22:
            DialogLancet.beforeDialogDismiss(r11);
            r11.dismiss();     // Catch: Throwable -> L25 Exception -> L27
        L31:
            DialogLancet.afterDialogDismiss(r11);
            return;
        L25:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r11);
            throw th;
        L27:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L25
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L25
            if (r2 == null) goto L31;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L25
            goto L31
        L20:
            if (Looper.myLooper() == r1.getLooper()) goto L22;
            r1.post(DialogLancet.createDismissRunnable(r11));
            return;
        L34:
            return;
        L8:
            if (TextUtils.equals(r10.getAnchorAbValue("live_pc_helper_new_layout"), "1") == false) goto L15;
            if (r10.getStreamType() != LiveMode.THIRD_PARTY) goto L15;
            if (IStreamUrlExtraKt.getWidthFlex(r10.getStreamUrlExtraSafely()) <= IStreamUrlExtraKt.getHeightFlex(r10.getStreamUrlExtraSafely())) goto L15;
            f2.b(2131921238, 0);
            return;
        L5:
            r10 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public c(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L6;
            f2.b(2131921450, 0);
            return;
        L6:
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r6 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r6 == null) goto L9;
            int r0 = bh0.a.a;
            r6.c2(2, 102, "audience_apply_dialog_click", null);
        L9:
            CommonStandardBottomDialog r7 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r2 == null) goto L23;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r1.getLooper()) goto L14;
            r1.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public d(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L6;
            f2.b(2131921450, 0);
            return;
        L6:
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r6 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r6 == null) goto L9;
            int r0 = bh0.a.a;
            r6.c2(2, 102, "audience_apply_dialog_click", null);
        L9:
            CommonStandardBottomDialog r7 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r2 == null) goto L23;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r1.getLooper()) goto L14;
            r1.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public e(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r8 == null) goto L5;
            IRoom r9 = (IRoom) r8.getValue();
        L7:
            if (r9 == null) goto L17;
            if (TextUtils.equals(r9.getAnchorAbValue("live_pc_helper_new_layout"), "1") == false) goto L17;
            if (r9.getStreamType() != LiveMode.THIRD_PARTY) goto L17;
            if (IStreamUrlExtraKt.getWidthFlex(r9.getStreamUrlExtraSafely()) <= IStreamUrlExtraKt.getHeightFlex(r9.getStreamUrlExtraSafely())) goto L17;
            f2.b(2131921238, 0);
            return;
        L17:
            if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L20;
            f2.b(2131921450, 0);
            return;
        L20:
            com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.e r10 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
            if (r10 == null) goto L23;
            int r1 = bh0.a.a;
            r10.c2(1, 102, "audience_apply_dialog_click", null);
        L23:
            CommonStandardBottomDialog r11 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r11);
            if (r0 != null) goto L26;
        L28:
            DialogLancet.beforeDialogDismiss(r11);
            r11.dismiss();     // Catch: Throwable -> L31 Exception -> L33
        L37:
            DialogLancet.afterDialogDismiss(r11);
            return;
        L31:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r11);
            throw th;
        L33:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L31
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L31
            if (r2 == null) goto L37;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
            goto L37
        L26:
            if (Looper.myLooper() == r0.getLooper()) goto L28;
            r0.post(DialogLancet.createDismissRunnable(r11));
            return;
        L5:
            r9 = null;
            goto L7
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r5, int r6) {
                r5.dismiss();
                com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
                com.bytedance.android.live.liveinteract.plantform.base.e r7 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
                if (r7 == null) goto L5;
                r7.F3("");
            L5:
                com.bytedance.android.live.liveinteract.utils.d r8 = jf0.c.a;
                String r9 = tc0.c.h().G;
                Intrinsics.checkNotNullParameter(r9, "requestPage");
                HashMap r10 = new HashMap();
                r10.put("function_type", "audience");
                r10.put("request_page", r9);
                if (hd0.c.f().g != 1) goto L8;
                String r11 = "video";
            L9:
                r10.put("guest_connection_type", r11);
                TalkRoomLogUtils.O0(r10);
                j0.l().sendLog("livesdk_guest_connection_break_click", r10, new Object[]{IRoom.class, x.class});
                return;
            L8:
                r11 = "audio";
                goto L9
            }
        }

        public f(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            b r7 = b.a;
            a r0 = a.a;
            DataCenter r1 = this.a.B;
            String r2 = null;
            if (r1 == null) goto L7;
            IRoom r3 = (IRoom) r1.get("data_room");
            if (r3 == null) goto L7;
            IBaseUser r4 = r3.getBaseOwner();
        L8:
            Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r5 != null) goto L12;
        L14:
            Object[] r8 = new Object[1];
            if (r4 == null) goto L17;
            r2 = r4.getNickName();
        L17:
            r8[0] = r2;
            String r9 = s1.C(2131917528, r8);
        L18:
            com.bytedance.android.livesdk.widget.j0.a r10 = new com.bytedance.android.livesdk.widget.j0.a(this.a.getContext());
            r10.a = r9;
            r10.b(s1.B(2131916227), r7);
            r10.a(s1.B(2131915442), r0);
            r10.c();
            CommonStandardBottomDialog r11 = this.a;
            Handler r12 = DialogLancet.resolveDialogHandler(r11);
            if (r12 != null) goto L21;
        L23:
            DialogLancet.beforeDialogDismiss(r11);
            r11.dismiss();     // Catch: Throwable -> L26 Exception -> L28
        L32:
            DialogLancet.afterDialogDismiss(r11);
            return;
        L28:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
            Throwable r13 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
            if (r13 == null) goto L32;
            com.bytedance.crash.d.d(r13, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r11);
            throw th;
        L21:
            if (Looper.myLooper() == r12.getLooper()) goto L23;
            r12.post(DialogLancet.createDismissRunnable(r11));
            return;
        L12:
            if (r5.intValue() != 1) goto L14;
            r9 = s1.B(2131917525);
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public g(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonStandardBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ InteractAudienceGuestApplyDialog a;

        public h(InteractAudienceGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.c.P0;
            List r0 = (List) r13.getValue();
            boolean r1 = ListProtector.get((List) r13.getValue(), 0) instanceof r;
            if ((!r0.isEmpty()) == false) goto L49;
            if (r1 == true) goto L6;
            return;
        L6:
            if (((r) ListProtector.get(r0, 0)).c == null) goto L54;
            String r2 = ((r) ListProtector.get(r0, 0)).c;
            if (r2 != null) goto L10;
            r2 = "";
        L10:
            DataCenter r3 = this.a.B;
            if (r3 == null) goto L55;
            IRoom r4 = (IRoom) r3.get("data_room");
            if (r4 != null) goto L16;
            return;
        L16:
            if (r2.length() <= 0) goto L18;
            boolean r5 = true;
        L20:
            if (r5 == false) goto L22;
            u6 r6 = new u6(r2);
            u6 r7 = r6.d("url");
            r7.b("room_id", String.valueOf(r4.getRoomId()));
            r7.b("anchor_id", String.valueOf(r4.getAnchorId()));
            r7.b("live_type", "video_live");
            r7.b("function_type", "audience");
            r7.b("user_type", "guest");
            r7.b("request_page", "audience");
            k.n(IBaseLiveActionHandler.class).handle(this.a.getContext(), r6.c());
        L22:
            int r8 = dk0.b.a;
            HashMap r9 = new HashMap();
            r9.put("live_type", "video_live");
            r9.put("function_type", "audience");
            j0.l().sendLog("livesdk_audience_head_decorate_icon_click", r9, new Object[]{IRoom.class});
            this.a.getClass();
            List r10 = (List) r13.getValue();
            if ((!r10.isEmpty()) == false) goto L32;
            Boolean r11 = ((r) ListProtector.get(r10, 0)).d;
            if (r11 == null) goto L27;
            boolean r14 = r11.booleanValue();
        L28:
            int r15 = r10.size();
            if (r14 == false) goto L32;
            if (r15 <= 1) goto L32;
            ListProtector.remove(r10, 0);
            com.bytedance.android.livesdk.sharedpref.f.d(r13, r10);
            goto L32
        L27:
            r14 = false;
        L32:
            CommonStandardBottomDialog r16 = this.a;
            Handler r17 = DialogLancet.resolveDialogHandler(r16);
            if (r17 != null) goto L35;
        L37:
            DialogLancet.beforeDialogDismiss(r16);
            r16.dismiss();     // Catch: Throwable -> L40 Exception -> L42
        L46:
            DialogLancet.afterDialogDismiss(r16);
            return;
        L42:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L40
            Throwable r18 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L40
            if (r18 == null) goto L46;
            com.bytedance.crash.d.d(r18, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r16);
            throw th;
        L35:
            if (Looper.myLooper() == r17.getLooper()) goto L37;
            r17.post(DialogLancet.createDismissRunnable(r16));
            return;
        L18:
            r5 = false;
            goto L20
        L55:
            return;
        L54:
            return;
        }
    }

    public final int getLayoutId() {
        return 2131565525;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r14) {
        super.onCreate(r14);
        String r15 = tc0.c.h().f;
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        boolean r9 = false;
        if (r0 != null) goto L6;
    L19:
        ((LinearLayout) findViewById(2131363176)).setVisibility(8);
        ((LinearLayout) findViewById(2131369130)).setVisibility(0);
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.util.d.a.a() == 0) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == false) goto L25;
        ((TextView) findViewById(2131391412)).setVisibility(0);
        ((TextView) findViewById(2131391412)).setOnClickListener(new a(this));
    L26:
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 != null) goto L30;
    L72:
        ((LinearLayout) findViewById(2131365096)).setVisibility(8);
    L73:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r3 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r3 != null) goto L76;
    L78:
        ((TextView) findViewById(2131365090)).setText(s1.B(2131917801));
    L79:
        ((LinearLayout) findViewById(2131365096)).setOnClickListener(new b(this, r15));
        Integer r16 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r16 != null) goto L83;
    L85:
        String r17 = s1.B(2131919271);
    L86:
        ((TextView) findViewById(2131369129)).setText(r17);
        ((LinearLayout) findViewById(2131363176)).setOnClickListener(new c(this));
        ((LinearLayout) findViewById(2131381497)).setOnClickListener(new d(this));
        ((LinearLayout) findViewById(2131381534)).setOnClickListener(new e(this));
        ((TextView) findViewById(2131369129)).setOnClickListener(new f(this));
        ((TextView) findViewById(2131365114)).setOnClickListener(new g(this));
        findViewById(2131383604).setOnClickListener(new h(this));
        List r18 = (List) com.bytedance.android.livesdk.sharedpref.c.P0.getValue();
        if ((!r18.isEmpty()) == true) goto L89;
    L94:
        Window r19 = getWindow();
        if (r19 == null) goto L98;
        r19.addFlags(2);
        r19.setDimAmount(0.6f);
        return;
    L98:
        return;
    L89:
        if ((ListProtector.get(r18, 0) instanceof r) == false) goto L94;
        Boolean r110 = ((r) ListProtector.get(r18, 0)).b;
        if (r110 == null) goto L93;
        r9 = r110.booleanValue();
    L93:
        findViewById(2131383604).setClickable(!r9);
        goto L94
    L83:
        if (r16.intValue() != 1) goto L85;
        r17 = s1.B(2131917526);
        goto L86
    L76:
        if (r3.d(r15) != true) goto L78;
        ((TextView) findViewById(2131365090)).setText(s1.B(2131917596));
        goto L79
    L30:
        if (2 != r2.intValue()) goto L72;
        ReadOnlyProperty r4 = vm2.d.N1;
        KProperty[] r5 = vm2.d.a;
        String r10 = null;
        if (((Boolean) r4.getValue(null, r5[141(0x8d, float:1.98E-43)])).booleanValue() == false) goto L60;
        Integer r6 = (Integer) com.bytedance.android.livesdk.sharedpref.c.N0.getValue();
        if (r6 != null) goto L37;
    L38:
        if (r6 != null) goto L41;
    L42:
        if (r6 == null) goto L60;
        if (r6.intValue() != 4) goto L60;
    L46:
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.P0;
        if ((!((Collection) r7.getValue()).isEmpty()) == false) goto L60;
        if ((ListProtector.get((List) r7.getValue(), 0) instanceof r) == false) goto L60;
        TextView r11 = (TextView) findViewById(2131377888);
        String r8 = ((r) ListProtector.get((List) r7.getValue(), 0)).a;
        if (r8 != null) goto L54;
        r8 = "";
    L54:
        r11.setText(r8);
        if (Intrinsics.areEqual(((TextView) findViewById(2131377888)).getText(), "") == false) goto L57;
        ((TextView) findViewById(2131377888)).setVisibility(8);
    L58:
        int r12 = s1.f(13.0f);
        ViewGroup.LayoutParams r13 = ((TextView) findViewById(2131377888)).getLayoutParams();
        r13.width = r12 * ((TextView) findViewById(2131377888)).getText().length();
        ((TextView) findViewById(2131377888)).setLayoutParams(r13);
        int r20 = dk0.b.a;
        HashMap r21 = new HashMap();
        r21.put("function_type", "audience");
        r21.put("live_type", "video_live");
        j0.l().sendLog("livesdk_audience_head_decorate_icon_show", r21, new Object[]{IRoom.class});
        findViewById(2131383604).setVisibility(0);
        goto L60
    L57:
        ((TextView) findViewById(2131377888)).setVisibility(0);
        goto L58
    L41:
        if (r6.intValue() == 2) goto L46;
    L37:
        if (r6.intValue() == 1) goto L46;
    L60:
        if (((Boolean) vm2.d.f3.getValue(null, r5[211(0xd3, float:2.96E-43)])).booleanValue() == false) goto L71;
        IInteractService r22 = (IInteractService) k.f(IInteractService.class);
        if (r22 == null) goto L70;
        IMiddlewareUserService r23 = k.f(IMiddlewareUserService.class);
        if (r23 == null) goto L69;
        com.bytedance.android.livesdk.user.e r24 = r23.user();
        if (r24 == null) goto L69;
        r10 = r24.n();
    L69:
        if (r22.isAnonymousUser(r10) == true) goto L71;
    L70:
        ((LinearLayout) findViewById(2131365096)).setVisibility(0);
    L71:
        ((LinearLayout) findViewById(2131365096)).setVisibility(8);
        goto L73
    L25:
        ((TextView) findViewById(2131391412)).setVisibility(8);
        goto L26
    L22:
        r1 = false;
        goto L23
    L6:
        if (r0.intValue() != 0) goto L19;
        int r25 = com.bytedance.android.live.liveinteract.utils.r.a;
        if (r25 != 1) goto L10;
    L13:
        boolean r26 = true;
    L15:
        if (r26 == false) goto L17;
        ((LinearLayout) findViewById(2131363176)).setVisibility(0);
        ((LinearLayout) findViewById(2131363191)).setVisibility(8);
    L18:
        ((LinearLayout) findViewById(2131369130)).setVisibility(8);
        ((LinearLayout) findViewById(2131365096)).setVisibility(8);
        ((TextView) findViewById(2131391412)).setVisibility(8);
        goto L79
    L17:
        ((LinearLayout) findViewById(2131363176)).setVisibility(8);
        ((LinearLayout) findViewById(2131363191)).setVisibility(0);
        goto L18
    L10:
        if (r25 == 3) goto L13;
        r26 = false;
        goto L15
    }

    public InteractAudienceGuestApplyDialog(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.B = r3;
    }
}
