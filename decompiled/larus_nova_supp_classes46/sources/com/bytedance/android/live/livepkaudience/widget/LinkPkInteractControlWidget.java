package com.bytedance.android.live.livepkaudience.widget;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget;
import com.bytedance.android.live.livepkaudience.base.w;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.dialog.RevLinkDialog;
import com.bytedance.android.live.livepkaudience.rtc.GuestRtcLinkerWidget;
import com.bytedance.android.live.livepkaudience.service.PkAudienceInternalServiceContext;
import com.bytedance.android.live.livepkaudience.window.LinkPkInteractAudienceWindowManagerV2;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/widget/LinkPkInteractControlWidget;", "Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/livepkaudience/service/e;", "Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractAnchorWidget$a;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkInteractControlWidget extends BasePkInteractControlWidget implements Observer<KVData>, com.bytedance.android.live.livepkaudience.service.e, BasePkInteractAnchorWidget.a {
    public final String a;
    public LinkPkInteractAudienceAnchorWidget b;
    public LinkPkInteractAudienceGuestWidget c;
    public GuestRtcLinkerWidget d;
    public final CompositeDisposable e;
    public RevLinkDialog f;
    public boolean g;
    public Room h;
    public final int i;
    public int j;
    public LinkPkInteractGuestDataContext k;
    public final v0 l;

    @Override // com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget
    public final String tag() {
        return "LinkPkInteractControlWidget";
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final String Wc() {
        LinkPkInteractGuestDataContext r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L6:
        return r0.kickedUsersUniqueId();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final boolean getSelfHasAudienceBeforePk() {
        LinkPkInteractGuestDataContext r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L6:
        return r0.getSelfHasAudienceBeforePk();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final boolean handleInteractClick() {
        if (v.a(((Integer) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue(), 4) == false) goto L50;
        RevPkState r0 = k.n(ILinkServiceExternal.class).getPkServiceExternal().d();
        if (this.g == false) goto L30;
        if (r0 != null) goto L8;
    L62:
        return false;
    L8:
        if (r0 == RevPkState.DISABLE) goto L62;
        if (us1.b.a() == true) goto L12;
        f2.c(us1.b.b(), 0);
        goto L62
    L12:
        if (v.a(((IInteractService) k.n(IInteractService.class)).getLinkMode(), 32) == false) goto L14;
        DataCenter r1 = ((Widget) this).dataCenter;
        int r2 = RevLinkDialog.u;
        RevLinkDialog r3 = new RevLinkDialog.a(r1, this).a("link_click", -1, null, false);
        this.f = r3;
        FragmentActivity r4 = ((Widget) this).context;
        if (r4 == null) goto L28;
        FragmentManager r5 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "RevLinkDialog", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r3, r6) == false) goto L64;
    L26:
        ((Widget) this).dataCenter.put("data_link_pk_interact_show_red_dot", Boolean.TRUE);
        goto L62
    L64:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L25:
        r3.show(r5, "RevLinkDialog");
        goto L26
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L14:
        if (((IInteractService) k.n(IInteractService.class)).getInteractAudienceService() == null) goto L26;
        if (dl0.k.a() == true) goto L18;
        ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) k.n(IInteractService.class)).getInteractAudienceService()).getClass();
        com.bytedance.android.live.liveinteract.plantform.base.f.a().K7(PbRequest.SwitchType.PK);
        goto L26
    L18:
        f2.c(s1.B(2131915316), 0);
        goto L26
    L30:
        IUserService r7 = k.f(IUserService.class);
        if (r7 == null) goto L46;
        com.bytedance.android.livesdk.user.f r8 = r7.user();
        if (r8 == null) goto L46;
        if (r8.c() != true) goto L46;
        IInteractService r9 = (IInteractService) k.f(IInteractService.class);
        if (r9 == null) goto L39;
        int r10 = r9.getLinkMode();
    L41:
        if (v.a(r10, 2) == false) goto L43;
        f2.c(s1.B(2131915438), 0);
        goto L62
    L43:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r11 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r11 == null) goto L62;
        r11.v0(0, "bottom", -1, "");
        goto L62
    L39:
        r10 = 0;
    L46:
        LinkPkInteractAudienceGuestWidget r12 = this.c;
        if (r12 == null) goto L62;
        r12.Yq(false);
        goto L62
    L50:
        if (v.a(((IInteractService) k.n(IInteractService.class)).getLinkMode(), 2) == false) goto L62;
        if (this.g == true) goto L62;
        IUserService r13 = k.f(IUserService.class);
        if (r13 == null) goto L62;
        com.bytedance.android.livesdk.user.f r14 = r13.user();
        if (r14 == null) goto L62;
        if (r14.c() == true) goto L62;
        LinkPkInteractAudienceGuestWidget r15 = this.c;
        if (r15 == null) goto L62;
        r15.Yq(true);
        goto L62
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void hideInteractDialog() {
        if (this.g == false) goto L14;
        LinkPkInteractAudienceAnchorWidget r0 = this.b;
        if (r0 == null) goto L14;
        RevLinkDialog r1 = r0.p;
        if (r1 == null) goto L14;
        r1.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L14;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        RevLinkDialog r3 = this.f;
        if (r3 == null) goto L27;
        r3.dismiss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L28;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final com.bytedance.android.live.livepkaudience.service.g ml() {
        LinkPkInteractGuestDataContext r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L6:
        return r0.getPkInteractAudienceParams();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void tryLoadPkAudienceWidget() {
        if (this.g == false) goto L5;
        this.j = 2131382346;
    L6:
        int r0 = this.j;
        enableSubWidgetManager();
        if (this.g == false) goto L17;
        if (this.b != null) goto L23;
        v0 r1 = this.l;
        if (r1 == null) goto L24;
        LinkPkInteractGuestDataContext r4 = this.k;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L15:
        LinkPkInteractAudienceAnchorWidget r3 = new LinkPkInteractAudienceAnchorWidget(r1, r4, this);
        this.b = r3;
        ((Widget) this).subWidgetManager.load(r0, r3);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        if (this.c != null) goto L26;
        LinkPkInteractGuestDataContext r5 = this.k;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L21:
        LinkPkInteractAudienceGuestWidget r2 = new LinkPkInteractAudienceGuestWidget(r5, this);
        this.c = r2;
        ((Widget) this).subWidgetManager.load(r0, r2);
        return;
    L26:
        return;
    L5:
        this.j = this.i;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void tryUnLoadPkAudienceWidget() {
        int r0 = x8.a.a;
        x8.a.b(this.a, "tryUnLoadPkAudienceWidget", false);
        if (this.g == false) goto L7;
        LinkPkInteractAudienceAnchorWidget r1 = this.b;
        if (r1 == null) goto L10;
        ((Widget) this).subWidgetManager.unload(r1);
    L10:
        this.b = null;
        this.c = null;
        return;
    L7:
        LinkPkInteractAudienceGuestWidget r2 = this.c;
        if (r2 == null) goto L10;
        ((Widget) this).subWidgetManager.unload(r2);
        goto L10
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        RoomContext.a r0 = RoomContext.Companion;
        Room r1 = null;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.i r6 = r5.isAnchor();
        if (r6 == null) goto L9;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L9;
        boolean r8 = r7.booleanValue();
    L10:
        this.g = r8;
        RoomContext r2 = RoomContext.a.c(r0, null, 0, 3);
        if (r2 == null) goto L15;
        m r3 = r2.getRoom();
        if (r3 == null) goto L15;
        r1 = (Room) r3.getValue();
    L15:
        this.h = r1;
        ((Widget) this).dataCenter.observe("cmd_interact_audience_invite", this).observe("cmd_video_talk_invite", this);
        enableSubWidgetManager();
        if (this.g == true) goto L18;
        GuestRtcLinkerWidget r4 = new GuestRtcLinkerWidget();
        this.d = r4;
        ((Widget) this).subWidgetManager.load(r4);
    L18:
        Pair r9 = com.bytedance.live.datacontext.d.a(new LinkPkInteractControlWidget$onCreate$dataPair$1(this));
        this.k = (LinkPkInteractGuestDataContext) r9.getFirst();
        com.bytedance.live.datacontext.b.a((DataContext) r9.getFirst(), "linkpk_interact_guest_data_service");
        this.e.add((Disposable) r9.getSecond());
        Pair r10 = com.bytedance.live.datacontext.d.a(LinkPkInteractControlWidget$onCreate$pair$1.INSTANCE);
        PkAudienceInternalServiceContext r11 = (PkAudienceInternalServiceContext) r10.getFirst();
        r11.getService().d(this);
        com.bytedance.live.datacontext.b.a(r11, PkAudienceInternalServiceContext.TAG);
        this.e.add((Disposable) r10.getSecond());
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L22;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), com.bytedance.android.live.pkaudience.api.c.class, this);
        return;
    L22:
        return;
    L9:
        r8 = false;
        goto L10
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L5;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), com.bytedance.android.live.pkaudience.api.c.class);
    L5:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.removeObserver(this);
    L8:
        LinkPkInteractGuestDataContext r1 = this.k;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkPkInteractDataContext");
    L11:
        r1.resetLinkData();
        this.e.clear();
    }

    public final void onChanged(Object r14) {
        KVData r15 = (KVData) r14;
        if (isViewValid() == false) goto L40;
        if (r15 != null) goto L6;
        return;
    L6:
        if (r15.getData() == null) goto L49;
        String r0 = r15.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-793150208)) goto L17;
        if (r1 == 1361477747) goto L14;
        return;
    L14:
        if (r0.equals("cmd_video_talk_invite") == false) goto L42;
    L18:
        User r16 = (User) r15.getData();
        if (r16 == null) goto L51;
        long r2 = 0;
        if (this.g == false) goto L30;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r5 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r5 == null) goto L44;
        int r3 = x8.a.a;
        x8.a.b(this.a, "pk anchor invite audience", false);
        Room r4 = this.h;
        if (r4 == null) goto L28;
        r2 = r4.id;
    L28:
        r5.invite(r2, "0", r16.getCastSecUid(), 1, 0);
        return;
    L44:
        return;
    L30:
        if (k.n(IUserService.class).user().c() == false) goto L46;
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.a.C0119a.a() == null) goto L47;
        int r6 = x8.a.a;
        x8.a.b(this.a, "pk anchor invite audience", false);
        com.bytedance.android.live.livepkaudience.service.a r7 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r7 == null) goto L48;
        Room r8 = this.h;
        if (r8 == null) goto L38;
        r2 = r8.id;
    L38:
        r7.t2(r2, "0", r16.getCastSecUid());
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L51:
        return;
    L42:
        return;
    L17:
        if (r0.equals("cmd_interact_audience_invite") == true) goto L18;
        return;
    L49:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.ILinkControlWidget, com.bytedance.android.live.pkaudience.api.c
    public final void onSei(String r8) {
        LinkPkInteractAudienceGuestWidget r0 = this.c;
        if (r0 == null) goto L40;
        if (r8 == null) goto L41;
        Intrinsics.checkNotNullParameter(r8, "sei");
        LinkPkInteractAudienceWindowManagerV2 r1 = r0.t;
        if (r1 == null) goto L42;
        Intrinsics.checkNotNullParameter(r8, "sei");
        if (r1.s == true) goto L10;
        return;
    L10:
        if (r1.p == false) goto L44;
        w r2 = r1.o;
        if (r2 != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r8) == false) goto L16;
        return;
    L16:
        if (r8.contains("app_data") == false) goto L51;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L37
        JSONObject r9 = LiveSeiUtil.c(r8);     // Catch: JSONException -> L37
        if (r9.has("info") == false) goto L26;
        if (r9.has("source") == false) goto L26;
        if (TextUtils.equals(r9.optString("source"), "zego") == false) goto L26;
        r9 = (JSONObject) r9.get("info");     // Catch: JSONException -> L37
    L26:
        if (r9.has("app_data") == false) goto L47;
        JSONObject r3 = new JSONObject(JSONObjectProtectorUtils.getString(r9, "app_data").replaceAll("\\\\", ""));     // Catch: JSONException -> L37
        long r4 = r3.optLong("timestamp");     // Catch: JSONException -> L37
        if (r4 > r2.a) goto L31;
        return;
    L31:
        if (r3.has("ver") == false) goto L49;
        int r10 = r3.optInt("ver");     // Catch: JSONException -> L37
        if (r2.b.c(r10) == false) goto L50;
        r2.a = r4;     // Catch: JSONException -> L37
        SeiAppData r11 = w.a(r3);     // Catch: JSONException -> L37
        r2.b.onSeiUpdated(r11);     // Catch: JSONException -> L37
        return;
    L50:
        return;
    L49:
        return;
    L47:
        return;
    L52:
        return;
    L51:
        return;
    L44:
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget
    public final void p3(IRoom r3) {
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        Room r4 = jm2.a.e((vh7.c) r3);
        if (r4 == null) goto L10;
        GuestRtcLinkerWidget r1 = this.d;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        r1.b = r4;
        com.bytedance.android.live.livepkaudience.rtc.a r0 = r1.a;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.w = r4;
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.e
    public final void unLoadOtherWidget(int r3) {
        if (r3 != 2) goto L8;
        LinkPkInteractAudienceGuestWidget r4 = this.c;
        if (r4 == null) goto L13;
        r4.F3("live_end");
        return;
    L13:
        return;
    L8:
        if (r3 != 32) goto L15;
        LinkPkInteractAudienceGuestWidget r5 = this.c;
        if (r5 == null) goto L16;
        r5.F3("live_end");
        return;
    L16:
        return;
    }

    public LinkPkInteractControlWidget(v0 r1, int r2) {
        this.l = r1;
        this.a = "LinkPkInteractControlWidget";
        this.e = new CompositeDisposable();
        this.i = r2;
    }

    public final boolean qa(Runnable r7, boolean r8) {
        LinkPkInteractAudienceGuestWidget r9 = this.c;
        Integer r1 = null;
        if (r9 == null) goto L23;
        Intrinsics.checkNotNullParameter(r7, "runnable");
        Integer r3 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r3 != null) goto L8;
    L17:
        Integer r10 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r10 == null) goto L23;
        if (1 != r10.intValue()) goto L23;
        r9.f = true;
        goto L23
    L8:
        if (2 != r3.intValue()) goto L17;
        DataCenter r4 = ((Widget) r9).dataCenter;
        if (r4 == null) goto L12;
        Boolean r5 = (Boolean) r4.get("cmd_mic_room_jump", Boolean.FALSE);
    L14:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L16;
        r9.f = true;
        goto L23
    L16:
        x0.b r6 = new x0.b(r9.getContext(), 4);
        r6.l(2131919394);
        r6.i(0, 2131920806, new d(r9, r7));
        r6.i(1, 2131915442, e.a);
        r6.n();
        boolean r11 = true;
    L24:
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L28;
        r1 = (Integer) r12.get("data_link_state", 0);
    L28:
        if (this.g == true) goto L46;
        if (r11 == true) goto L46;
        Integer r13 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r13 == null) goto L46;
        if (r13.intValue() != 1) goto L46;
        if (this.h == null) goto L46;
        if (r1 != null) goto L40;
    L41:
        LinkApi r14 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Room r0 = this.h;
        if (r0 == null) goto L44;
        long r2 = r0.id;
    L45:
        ((SingleSubscribeProxy) r14.leave(r2, "live_end").as(autoDisposeWithTransformer())).subscribe(i.a, new j(this));
        goto L46
    L44:
        r2 = 0;
        goto L45
    L40:
        if (r1.intValue() != 0) goto L41;
    L46:
        return r11;
    L12:
        r5 = null;
    L23:
        r11 = false;
        goto L24
    }
}
