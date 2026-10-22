package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongAvatarMicSeatView;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class q extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public LinkMicQuickInteractView A;
    public RequestSongAvatarMicSeatView B;
    public Context C;
    public final CompositeDisposable z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r3 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a) r2;
            HamletAvatarContext r0 = HamletAvatarContext.Companion.getContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r1 = r0.isStreamRending();
            if (r1 == null) goto L9;
            Boolean r4 = (Boolean) r1.getValue();
            if (r4 == null) goto L9;
            boolean r5 = r4.booleanValue();
        L10:
            if (r5 == true) goto L13;
            q r6 = this.a;
            int r7 = r3.d;
            r6.R();
            return;
        L13:
            return;
        L9:
            r5 = false;
            goto L10
        }
    }

    public abstract void R();

    public final RequestSongAvatarMicSeatView Q() {
        RequestSongAvatarMicSeatView r0 = this.B;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c, jg0.f
    public void onDetach() {
        super.onDetach();
        RequestSongAvatarMicSeatView r0 = this.B;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L5:
        r0.e(0);
        r0.d();
        LinkMicQuickInteractView r1 = this.A;
        if (r1 == null) goto L11;
        r1.l(0, null);
        ViewGroup r2 = r1.getExtraContainer();
        RequestSongAvatarMicSeatView r3 = this.B;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("requestSongAvatarMicSeatView");
    L10:
        r2.removeView(r3);
    L11:
        this.C = null;
        this.z.dispose();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public boolean z() {
        if (q().getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.C;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.a(r5);
        DataCenter r3 = null;
        this.B = new RequestSongAvatarMicSeatView(r5, null, 6, 0);
        MultiLinkMicSeatGiftIconElement r0 = this.m;
        if (r0 == null) goto L5;
        LinkMicQuickInteractView r1 = r0.c;
    L6:
        this.A = r1;
        this.C = r5;
        if (LinkFeedTypeConstant.Companion.isFeedType(n()) == true) goto L21;
        LinkUserDataMergeContext.a r6 = LinkUserDataMergeContext.Companion;
        xg0.a r2 = this.c;
        if (r2 == null) goto L11;
        r3 = r2.getDataCenter();
    L11:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = LinkUserDataMergeContext.a.b(r6, r3);
        if (r7 == null) goto L22;
        BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> r8 = r7.p1();
        if (r8 == null) goto L23;
        Observable r9 = r8.compose(RxUtil.rxSchedulerHelper());
        if (r9 == null) goto L24;
        Disposable r10 = r9.subscribe(new a(this));
        if (r10 == null) goto L25;
        RxUtilKt.c(r10, this.z);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void A(MultiLinkGuestViewBinder.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        super.A(r3, r4);
        LinkMicQuickInteractView r5 = this.A;
        if (r5 == null) goto L25;
        MultiLinkGuestViewBinder.a r6 = this.e;
        if (r6 == null) goto L12;
        ch0.e r7 = r6.k;
        if (r7 == null) goto L12;
        ILinkPlayerInfoBridge r8 = r7.a;
        if (r8 == null) goto L12;
        String r9 = r8.getFanTicketDisplayStr();
        if (r9 == null) goto L12;
    L13:
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L23;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L23;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L23;
        IBaseUser r10 = r2.getUser();
        if (r10 == null) goto L23;
        String r11 = r10.getIdString();
        if (r11 == null) goto L23;
    L24:
        r5.b(r9, r11);
    L23:
        r11 = "";
    L12:
        r9 = "0";
    L25:
        InteractiveSongContext r12 = InteractiveSongContext.Companion.getContext();
        if (r12 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.m130isOpenInteractiveSong();
        if (r13 == null) goto L37;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L37;
        if (this.C == null) goto L37;
        LinkMicQuickInteractView r14 = this.A;
        if (r14 == null) goto L37;
        r14.post(new p(this));
    L37:
        HamletAvatarContext.a r15 = HamletAvatarContext.Companion;
        HamletAvatarContext r16 = r15.getContext();
        if (r16 == null) goto L44;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.isAvatarRending();
        if (r17 == null) goto L44;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L44;
        r18.booleanValue();
    L44:
        DataCenter r19 = null;
        if (LinkFeedTypeConstant.Companion.isFeedType(n()) == true) goto L65;
        HamletAvatarContext r20 = r15.getContext();
        if (r20 == null) goto L53;
        com.bytedance.live.datacontext.m<Boolean> r21 = r20.isStreamRending();
        if (r21 == null) goto L53;
        Boolean r22 = (Boolean) r21.getValue();
        if (r22 == null) goto L53;
        boolean r23 = r22.booleanValue();
    L54:
        LinkUserDataMergeContext.a r24 = LinkUserDataMergeContext.Companion;
        xg0.a r25 = this.c;
        if (r25 == null) goto L57;
        r19 = r25.getDataCenter();
    L57:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r26 = LinkUserDataMergeContext.a.b(r24, r19);
        if (r26 == null) goto L62;
        BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> r27 = r26.p1();
        if (r27 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r28 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a) r27.getValue();
    L62:
        if (r23 == false) goto L64;
        R();
        return;
    L64:
        R();
        return;
    L53:
        r23 = false;
        goto L54
    L65:
        xg0.a r29 = this.c;
        if (r29 == null) goto L68;
        r19 = r29.getLastSubUILayout();
    L68:
        if (r19 == null) goto L71;
        r19.intValue();
    L71:
        R();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public q(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
        this.z = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void B(MultiLinkGuestViewBinder.a r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        Intrinsics.checkNotNullParameter(r6, "payload");
        super.B(r4, r5, r6);
        Iterator<String> r7 = r6.keySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L45;
        String r8 = r7.next();
        if (r8 == null) goto L4;
        int r0 = r8.hashCode();
        Object r2 = null;
        if (r0 != (-1770063218)) goto L11;
        if (r8.equals("payload_key_hamlet_avatar_rending_update") == false) goto L4;
        Object r9 = r4.k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_RENDING");
        if ((r9 instanceof Boolean) == false) goto L33;
        r2 = r9;
    L33:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L4;
        r3.booleanValue();
        HamletAvatarContext r10 = HamletAvatarContext.Companion.getContext();
        if (r10 == null) goto L42;
        com.bytedance.live.datacontext.m<Boolean> r11 = r10.isStreamRending();
        if (r11 == null) goto L42;
        Boolean r12 = (Boolean) r11.getValue();
        if (r12 == null) goto L42;
        boolean r13 = r12.booleanValue();
    L43:
        if (r13 == false) goto L4;
        R();
    L42:
        r13 = false;
        goto L43
    L11:
        if (r0 != 618131157) goto L4;
        if (r8.equals("payload_key_request_song_open_update") == false) goto L4;
        Object r14 = r4.k.d.get("EXT_KEY_UPDATE_REQUEST_SONG_OPEN");
        if ((r14 instanceof Boolean) == false) goto L19;
        r2 = r14;
    L19:
        Boolean r15 = (Boolean) r2;
        if (r15 == null) goto L4;
        r15.booleanValue();
        if (this.C == null) goto L4;
        LinkMicQuickInteractView r16 = this.A;
        if (r16 == null) goto L4;
        r16.post(new p(this));
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
