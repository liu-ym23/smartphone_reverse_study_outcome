package com.bytedance.android.live.livepkaudience.emoji;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/LinkPKGameInteractPanel;", "Lcom/bytedance/android/live/livepkaudience/emoji/BaseInteractEmojiPanel;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPKGameInteractPanel extends BaseInteractEmojiPanel {
    public static final /* synthetic */ int z = 0;
    public com.bytedance.android.live.livepkaudience.base.i v;
    public boolean w;
    public boolean x;
    public final CompositeDisposable y;

    public static final class a {
        @JvmStatic
        public static LinkPKGameInteractPanel a(Context r2, DataCenter r3, LinkPlayerInfo r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "userInfo");
            Intrinsics.checkNotNullParameter("seat", "requestPage");
            LinkPKGameInteractPanel r0 = new LinkPKGameInteractPanel(r2, r3, r4);
            Intrinsics.checkNotNullParameter("seat", "<set-?>");
            r0.k = "seat";
            return r0;
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
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkPKGameInteractPanel a;

        public c(LinkPKGameInteractPanel r1) {
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
    public final String S0() {
        return "我方控制者:";
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final List<com.bytedance.android.live.livepkaudience.emoji.panel.g> P0() {
        ArrayList r0 = new ArrayList();
        boolean r2 = false;
        if (this.j == false) goto L18;
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.i(this));
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.j(this, "资料卡"));
        User r1 = this.l;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.live.livepkaudience.emoji.panel.g r3 = new com.bytedance.android.live.livepkaudience.emoji.panel.e(this);
    L10:
        r0.add(r3);
        if (this.s.silenceStatus == 0) goto L13;
        r2 = true;
    L13:
        if (r2 == false) goto L15;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r4 = new com.bytedance.android.live.livepkaudience.emoji.panel.n(this);
    L16:
        r0.add(r4);
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.d(this));
    L24:
        return r0;
    L15:
        r4 = new com.bytedance.android.live.livepkaudience.emoji.panel.k(this);
        goto L16
    L7:
        if (r1.isFollowing() != true) goto L9;
        r3 = new com.bytedance.android.live.livepkaudience.emoji.panel.m(this);
        goto L10
    L18:
        if (this.s.silenceStatus == 0) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        com.bytedance.android.live.livepkaudience.emoji.panel.g r5 = new com.bytedance.android.live.livepkaudience.emoji.panel.n(this);
    L23:
        r0.add(r5);
        r0.add(new com.bytedance.android.live.livepkaudience.emoji.panel.d(this));
        goto L24
    L22:
        r5 = new com.bytedance.android.live.livepkaudience.emoji.panel.k(this);
        goto L23
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
        String r8 = r7.getIdString();
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

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final String R0() {
        IBaseUser r0 = this.s.getUser();
        if (r0 == null) goto L6;
        String r1 = r0.getNickName();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final boolean X0() {
        User r0 = this.l;
        if (r0 == null) goto L5;
        String r1 = r0.getIdString();
    L7:
        if (Intrinsics.areEqual(r1, jc1.k.n(IUserService.class).user().b().getIdString()) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void disconnect() {
        if (this.j == true) goto L22;
        if (X0() == false) goto L22;
        String r0 = this.k;
        int r1 = r0.hashCode();
        if (r1 != (-1383228885)) goto L9;
        r0.equals("bottom");
    L13:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r2 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r2 == null) goto L16;
        com.bytedance.android.live.livepkaudience.service.d.b.b(r2);
    L16:
        int r3 = al0.c.b;
        String r4 = tc0.c.h().G;
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        al0.c.c(r4);
        return;
    L9:
        if (r1 != 3526149) goto L13;
        r0.equals("seat");
    L22:
        if (Q0() == true) goto L25;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L25:
        String r5 = s1.B(2131919267);
        String r6 = s1.B(2131915442);
        Object[] r7 = new Object[1];
        IBaseUser r8 = this.s.getUser();
        if (r8 == null) goto L28;
        String r9 = r8.getNickName();
    L29:
        r7[0] = LinkPlayerInfo.getUserNameWithCut(r9);
        String r10 = s1.C(2131919814, r7);
        if (this.j == false) goto L33;
        c r11 = new c(this);
        j0.a r12 = new j0.a(getContext());
        r12.a = r10;
        r12.b(r6, b.a);
        r12.a(r5, r11);
        r12.c();
        return;
    L33:
        return;
    L28:
        r9 = null;
        goto L29
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void e() {
        String r2 = "0";
        if (this.j == true) goto L23;
        if (X0() == false) goto L23;
        String r0 = this.k;
        com.bytedance.android.live.livepkaudience.base.i r3 = this.v;
        Long r4 = null;
        if (r3 == null) goto L9;
        Integer r5 = Integer.valueOf(com.bytedance.android.live.livepkaudience.emoji.c.a(r3));
    L10:
        el0.j.h(r0, r5, dl0.n.d());
        Room r1 = this.i;
        if (r1 == null) goto L13;
        r4 = Long.valueOf(r1.getRoomId());
    L13:
        long r6 = r4.longValue();
        String r7 = dl0.n.d();
        if (r7 == null) goto L18;
        r2 = r7;
    L18:
        if (this.w == true) goto L44;
        this.w = true;
        this.y.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r6, r2, r2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a0(this, r2), new b0(this, r2)));
        return;
    L44:
        return;
    L9:
        r5 = null;
    L23:
        if (Q0() == true) goto L27;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L27:
        if (this.j == false) goto L42;
        IBaseUser r8 = this.s.getUser();
        if (r8 == null) goto L35;
        String r9 = r8.getIdString();
        if (r9 == null) goto L35;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r10 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r10 == null) goto L35;
        r10.u3(r9);
    L35:
        int r11 = al0.b.a;
        IBaseUser r12 = this.s.getUser();
        if (r12 == null) goto L41;
        String r13 = r12.getIdString();
        if (r13 == null) goto L41;
        r2 = r13;
    L41:
        al0.b.f(r2, true);
    L42:
        V0(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void k() {
        if (this.j == true) goto L16;
        if (X0() == false) goto L16;
        el0.j.g(this.k, dl0.n.d());
        Room r0 = this.i;
        if (r0 == null) goto L9;
        Long r1 = Long.valueOf(r0.getRoomId());
    L10:
        long r2 = r1.longValue();
        String r3 = dl0.n.d();
        if (this.x == true) goto L36;
        this.x = true;
        Disposable r4 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r2, r3, r3.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(this, r3), new d0(this, r3));
        this.y.add(r4);
        return;
    L36:
        return;
    L9:
        r1 = null;
    L16:
        if (Q0() == true) goto L20;
        f2.b(2131922751, 0);
        V0(this);
        return;
    L20:
        if (this.j == false) goto L34;
        IBaseUser r5 = this.s.getUser();
        if (r5 == null) goto L28;
        String r6 = r5.getIdString();
        if (r6 == null) goto L28;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r7 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r7 == null) goto L28;
        r7.b5(r6);
    L28:
        int r8 = al0.b.a;
        IBaseUser r9 = this.s.getUser();
        if (r9 == null) goto L32;
        String r10 = r9.getIdString();
        if (r10 == null) goto L32;
    L33:
        al0.b.f(r10, false);
    L32:
        r10 = "0";
    L34:
        V0(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel, com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void y5() {
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r0 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r0 == null) goto L6;
        r0.handleInteractClick();
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.y.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void V0(LinkPKGameInteractPanel r3) {
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

    @Override // com.bytedance.android.live.livepkaudience.emoji.BaseInteractEmojiPanel
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (this.j == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r2 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r2 == null) goto L10;
        com.bytedance.android.live.livepkaudience.base.i r3 = r2.getLinkUserCenter();
    L11:
        this.v = r3;
        return;
    L10:
        r3 = null;
        goto L11
    L7:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r4 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r4 == null) goto L10;
        r3 = r4.getLinkUserCenter();
        goto L11
    }

    public static final void W0(LinkPKGameInteractPanel r0, Throwable r1) {
        r0.getClass();
        if ((r1 instanceof ApiServerException) == false) goto L8;
        ApiServerException r2 = (ApiServerException) r1;
        if (TextUtils.isEmpty(r2.getPrompt()) == true) goto L9;
        f2.c(r2.getPrompt(), 0);
        return;
    L9:
        return;
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

    public LinkPKGameInteractPanel(Context r2, DataCenter r3, LinkPlayerInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        super(r2, r3, r4, false);
        this.y = new CompositeDisposable();
    }
}
