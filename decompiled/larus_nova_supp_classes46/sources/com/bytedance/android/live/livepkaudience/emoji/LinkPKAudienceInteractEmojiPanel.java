package com.bytedance.android.live.livepkaudience.emoji;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.config.n0;
import com.bytedance.android.livesdk.config.w7;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/LinkPKAudienceInteractEmojiPanel;", "Lcom/bytedance/android/live/livepkaudience/emoji/BaseInteractEmojiPanel;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKAudienceInteractEmojiPanel extends BaseInteractEmojiPanel {
    public static final /* synthetic */ int v = 0;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkPKAudienceInteractEmojiPanel a;

        public c(LinkPKAudienceInteractEmojiPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            r3.dismiss();
            IBaseUser r5 = this.a.s.getUser();
            if (r5 == null) goto L16;
            Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
            String r6 = r5.getCastSecUid();
            if (r6 == null) goto L16;
            if (this.a.j == false) goto L12;
            com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
            com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
            if (r0 == null) goto L16;
            com.bytedance.android.live.livepkaudience.service.b.C0120b.a(r0, r5.getIdString(), r6);
            goto L16
        L12:
            if (dl0.n.c() == false) goto L16;
            com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
            com.bytedance.android.live.livepkaudience.service.a r1 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
            if (r1 == null) goto L16;
            r1.kickOut(r5.getIdString(), r6, "");
        L16:
            q46.a r7 = this.a;
            Handler r8 = DialogLancet.resolveDialogHandler(r7);
            if (r8 != null) goto L19;
        L21:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L24 Exception -> L26
        L30:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L24:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L26:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
            Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
            if (r9 == null) goto L30;
            com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
            goto L30
        L19:
            if (Looper.myLooper() == r8.getLooper()) goto L21;
            r8.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final int O0() {
        return 1;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final String R0() {
        return "控制者";
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final List<com.bytedance.android.live.livepkaudience.emoji.panel.g> P0() {
        ArrayList r0 = new ArrayList();
        String r2 = "";
        if (this.j == false) goto L5;
    L14:
        User r1 = this.l;
        if (r1 != null) goto L17;
    L19:
        boolean r4 = false;
        if (this.s.silenceStatus == 0) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == false) goto L25;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r5 = new com.bytedance.android.live.livepkaudience.emoji.panel.n(this);
    L26:
        r0.add(r5);
        boolean r6 = this.j;
        boolean r7 = tc0.c.h().E;
        if (r6 == true) goto L37;
        if (r7 == false) goto L36;
        Integer r8 = (Integer) n0.a.getValue();
        if (r8 == null) goto L36;
        if (r8.intValue() != 2) goto L36;
        r7 = true;
    L36:
        r7 = false;
    L37:
        if (r7 == true) goto L39;
    L55:
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.d(this));
        User r9 = this.l;
        if (r9 != null) goto L58;
    L66:
        return r0;
    L58:
        if (r9.isMysteryMan() == true) goto L66;
        User r10 = this.l;
        if (r10 != null) goto L62;
    L64:
        com.bytedance.android.live.livepkaudience.emoji.panel.g r11 = new com.bytedance.android.live.livepkaudience.emoji.panel.e(this);
    L65:
        r0.add(r11);
        goto L66
    L62:
        if (r10.isFollowing() != true) goto L64;
        r11 = new com.bytedance.android.live.livepkaudience.emoji.panel.m(this);
        goto L65
    L39:
        if (((Boolean) w7.a.getValue()).booleanValue() == false) goto L55;
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r12 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r12 == null) goto L47;
        String r13 = this.s.getInteractId();
        if (r13 != null) goto L46;
        r13 = "";
    L46:
        if (r12.c(r13) == 3) goto L55;
    L47:
        com.bytedance.android.live.livepkaudience.vm.c r14 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r14 == null) goto L54;
        String r15 = this.s.getInteractId();
        if (r15 == null) goto L53;
        r2 = r15;
    L53:
        r4 = r14.d(r2);
    L54:
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.h(this, r4));
        goto L55
    L25:
        r5 = new com.bytedance.android.live.livepkaudience.emoji.panel.k(this);
        goto L26
    L22:
        r3 = false;
        goto L23
    L17:
        if (r1.isMysteryMan() == true) goto L19;
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.j(this, ""));
        goto L19
    L5:
        if (dl0.n.c() == true) goto L14;
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.j(this, ""));
        User r16 = this.l;
        if (r16 != null) goto L10;
    L12:
        com.bytedance.android.live.livepkaudience.emoji.panel.g r17 = new com.bytedance.android.live.livepkaudience.emoji.panel.e(this);
    L13:
        r0.add(r17);
        goto L66
    L10:
        if (r16.isFollowing() != true) goto L12;
        r17 = new com.bytedance.android.live.livepkaudience.emoji.panel.m(this);
        goto L13
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final boolean Q0() {
        if (this.j == false) goto L9;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L14;
        com.bytedance.android.live.livepkaudience.base.i r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L14;
        CopyOnWriteArrayList<LinkPlayerInfo> r2 = r1.c;
    L16:
        if (r2 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        return false;
    L24:
        Iterator<T> r3 = r2.iterator();
    L26:
        if (r3.hasNext() == false) goto L38;
        IBaseUser r5 = ((LinkPlayerInfo) r3.next()).getUser();
        if (r5 == null) goto L30;
        String r6 = r5.getIdString();
    L31:
        User r7 = this.l;
        if (r7 == null) goto L34;
        String r8 = r7.getIdStr();
    L36:
        if (Intrinsics.areEqual(r6, r8) == false) goto L26;
        return true;
    L34:
        r8 = null;
        goto L36
    L30:
        r6 = null;
        goto L31
    L38:
        return false;
    L18:
        if (r2.isEmpty() == true) goto L21;
        r4 = false;
    L14:
        r2 = null;
        goto L16
    L9:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r9 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r9 == null) goto L14;
        com.bytedance.android.live.livepkaudience.base.i r10 = r9.getLinkUserCenter();
        if (r10 == null) goto L14;
        r2 = r10.c;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void disconnect() {
        if (Q0() == true) goto L6;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L6:
        String r0 = s1.B(2131919267);
        String r2 = s1.B(2131915442);
        Object[] r3 = new Object[1];
        IBaseUser r4 = this.s.getUser();
        if (r4 == null) goto L9;
        String r5 = r4.getNickName();
    L10:
        r3[0] = LinkPlayerInfo.getUserNameWithCut(r5);
        String r1 = s1.C(2131919814, r3);
        if (this.j == false) goto L13;
    L16:
        c r6 = new c(this);
        j0.a r7 = new j0.a(getContext());
        r7.a = r1;
        r7.b(r2, b.a);
        r7.a(r0, r6);
        r7.c();
        return;
    L13:
        if (dl0.n.c() == true) goto L16;
        return;
    L9:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void e() {
        if (Q0() == true) goto L6;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L6:
        String r2 = "0";
        if (this.j == false) goto L23;
        IBaseUser r0 = this.s.getUser();
        if (r0 == null) goto L15;
        String r1 = r0.getIdString();
        if (r1 == null) goto L15;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r3 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r3 == null) goto L15;
        r3.u3(r1);
    L15:
        int r4 = al0.b.a;
        IBaseUser r5 = this.s.getUser();
        if (r5 == null) goto L21;
        String r6 = r5.getIdString();
        if (r6 == null) goto L21;
        r2 = r6;
    L21:
        al0.b.f(r2, true);
    L38:
        V0(this);
        return;
    L23:
        if (dl0.n.c() == false) goto L38;
        IBaseUser r7 = this.s.getUser();
        if (r7 == null) goto L31;
        String r8 = r7.getIdString();
        if (r8 == null) goto L31;
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r9 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r9 == null) goto L31;
        r9.u3(r8);
    L31:
        int r10 = al0.b.a;
        IBaseUser r11 = this.s.getUser();
        if (r11 == null) goto L37;
        String r12 = r11.getIdString();
        if (r12 == null) goto L37;
        r2 = r12;
    L37:
        al0.b.f(r2, true);
        goto L38
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void k() {
        if (Q0() == true) goto L6;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L6:
        String r2 = "0";
        if (this.j == false) goto L23;
        IBaseUser r0 = this.s.getUser();
        if (r0 == null) goto L15;
        String r1 = r0.getIdString();
        if (r1 == null) goto L15;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r3 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r3 == null) goto L15;
        r3.b5(r1);
    L15:
        int r4 = al0.b.a;
        IBaseUser r5 = this.s.getUser();
        if (r5 == null) goto L21;
        String r6 = r5.getIdString();
        if (r6 == null) goto L21;
        r2 = r6;
    L21:
        al0.b.f(r2, false);
    L38:
        V0(this);
        return;
    L23:
        if (dl0.n.c() == false) goto L38;
        IBaseUser r7 = this.s.getUser();
        if (r7 == null) goto L31;
        String r8 = r7.getIdString();
        if (r8 == null) goto L31;
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r9 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r9 == null) goto L31;
        r9.b5(r8);
    L31:
        int r10 = al0.b.a;
        IBaseUser r11 = this.s.getUser();
        if (r11 == null) goto L37;
        String r12 = r11.getIdString();
        if (r12 == null) goto L37;
        r2 = r12;
    L37:
        al0.b.f(r2, false);
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void V0(LinkPKAudienceInteractEmojiPanel r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void x5(boolean r8, boolean r9) {
        if (Q0() == true) goto L6;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L6:
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r10 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r10 == null) goto L36;
        IBaseUser r0 = this.s.getUser();
        String r1 = "0";
        if (r0 == null) goto L12;
        String r2 = r0.getIdString();
        if (r2 == null) goto L12;
    L13:
        String r3 = this.s.getInteractId();
        String r4 = "";
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        r10.b(r2, !r10.d(r3));
        HashMap r5 = new HashMap();
        r5.put("live_type", "video_live");
        IBaseUser r6 = this.s.getUser();
        if (r6 == null) goto L20;
        String r7 = r6.getIdString();
        if (r7 == null) goto L20;
    L21:
        r5.put("to_user_id", r7);
        String r11 = this.s.getInteractId();
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        if (r10.d(r11) == false) goto L27;
        String r12 = "on";
    L28:
        r5.put("button_type", r12);
        r5.put("pk_id", String.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder().getPkId()));
        r5.put("is_in_pk", "1");
        if (dl0.n.c() == false) goto L31;
        r1 = "1";
    L31:
        r5.put("is_admin", r1);
        if (dl0.n.c() == false) goto L34;
        r4 = dl0.n.d();
    L34:
        r5.put("admin_id", r4);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_connection_user_camera_open_click", r5, new Object[]{Room.class});
        V0(this);
        return;
    L27:
        r12 = "off";
    L20:
        r7 = "";
    L12:
        r2 = "0";
        goto L13
    }

    public LinkPKAudienceInteractEmojiPanel(Context r2, DataCenter r3, LinkPlayerInfo r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        super(r2, r3, r4, r5);
    }
}
