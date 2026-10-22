package com.bytedance.android.live.livepkaudience;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.o;
import com.bytedance.android.live.livepkaudience.base.p;
import com.bytedance.android.live.livepkaudience.base.x;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.live.livepkaudience.base.z;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.service.d;
import com.bytedance.android.live.livepkaudience.service.e;
import com.bytedance.android.live.livepkaudience.service.f;
import com.bytedance.android.live.livepkaudience.widget.LinkPkInteractControlWidget;
import com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import hh1.v0;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m00.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000Õ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001s\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\u0016\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u001c\u0010'\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\b\u0001\u0010%\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J2\u0010/\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020)H\u0016J\"\u00102\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u00020\rH\u0016J(\u00107\u001a\u00020\u000b2\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020$H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\u0010\u0010<\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\rH\u0016J\n\u0010>\u001a\u0004\u0018\u00010=H\u0016J\b\u0010?\u001a\u00020\u0002H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0016J\n\u0010B\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010F\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020GH\u0016J\b\u0010J\u001a\u00020\u000bH\u0016J\n\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010M\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010N\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010O\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010Q\u001a\u00020\u00022\b\u0010P\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010S\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010RH\u0016J\b\u0010T\u001a\u00020\u0002H\u0016J\u0010\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020$H\u0016J\b\u0010W\u001a\u00020\rH\u0016J\b\u0010X\u001a\u00020\rH\u0016J<\u0010a\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u00022\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010]\u001a\u00020)2\u0014\u0010`\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0016J\b\u0010b\u001a\u00020\u000bH\u0016J\u0010\u0010c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004H\u0016J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010d\u001a\u00020\u0002H\u0016J5\u0010m\u001a\u00060kj\u0002`l2'\u0010j\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(i\u0012\u0004\u0012\u00020\u000b0fH\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\b\u0010o\u001a\u00020\u000bH\u0016R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020p0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006x"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/PkAudienceLinkServiceImp;", "Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "", "isAnchor", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkPlayerInfo;", "getOnlineUserListInInteractAudience", "Lcom/bytedance/android/live/livepkaudience/base/i;", "getPkLinkUserInfoCenter", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "user", "", "permit", "", "interactId", "isMuteRemoteAudio", "isSwitching", "markSwitchToMulti", "tryLoadPkAudienceWidget", "tryUnLoadPkAudienceWidget", "Lcom/bytedance/android/live/pkaudience/api/d;", "getPkAudienceLogData", "isInSelfAnchorLink", "getPkGuestLynxData", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "newObserver", "registerPkGuestLynxDataObserver", "unRegisterPkGuestLynxDataObserver", "resetLinkData", "Lcom/bytedance/android/live/pkaudience/api/b;", "listener", "addPkGuestListener", "onFirstRemoteVideoSend", "isLinkAudience", "Lhh1/v0;", "liveVideoClientFactory", "", "containerId", "Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "createRevPkAudienceControlWidget", "isRealHasAudienceBeforePk", "", "roomId", "uid", "secUid", "layout", "msgBoardItemId", "invite", "revSecUid", "reqFrom", "kickOut", "linkType", "applySource", "fromSource", "applyType", "apply", "cancelApply", "reason", "disconnect", "hideInteractDialog", "finishInteract", "Lei6/a;", "getGuestRtcClient", "isRtcEngineOn", "Lgd0/x;", "createRevRtcData", "getLiveVideoClientFactory", "revRtcData", "", "videoClientFactory", "setRevGuestManagerData", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "content", "setLinkerContentMap", "showInviteAndPermitDialog", "Lm00/g;", "getGuestLinkViewNew", "isNotSelfGuestByIId", "isSelfGuestByIId", "isSelfGuestByUid", "userId", "isNotSelfGuestByUid", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "isUserInInteractAudience", "handleInteractClick", "mode", "unLoadOtherWidget", "getGuestAnchorLinkMicId", "getSelfAnchorLinkMicId", "isSilence", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "switchAudioByClient", "kickOutAllGuest", "getAllOwnGuestUidList", "isLeft", "getSelfOnlineUserList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlineList", "onChange", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "registerOnlineListChange", "onPKInteractBizStart", "onPKInteractBizEnd", "Lcom/bytedance/android/live/livepkaudience/base/z;", "infoCenterCallbacks", "Ljava/util/List;", "com/bytedance/android/live/livepkaudience/PkAudienceLinkServiceImp$b", "infoCenterCallback", "Lcom/bytedance/android/live/livepkaudience/PkAudienceLinkServiceImp$b;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PkAudienceLinkServiceImp implements IPkAudienceLinkOutService {
    private final b infoCenterCallback;
    private final List<z> infoCenterCallbacks;

    public static final class a extends x {
        public final /* synthetic */ com.bytedance.android.live.pkaudience.api.b a;

        public a(com.bytedance.android.live.pkaudience.api.b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
        public final void onPermitSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            Intrinsics.checkNotNullParameter(r2, "uid");
            com.bytedance.android.live.pkaudience.api.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onPermitSuccess(r2);
            return;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
        public final void l(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            Intrinsics.checkNotNullParameter(r2, "uid");
            com.bytedance.android.live.pkaudience.api.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.l(r2, r3);
            return;
        }
    }

    public static final class b extends y {
        public final /* synthetic */ PkAudienceLinkServiceImp a;

        public b(PkAudienceLinkServiceImp r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r3) {
            Iterator r0 = PkAudienceLinkServiceImp.access$getInfoCenterCallbacks$p(this.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((z) r0.next()).onOnlineListChanged(r3);
            goto L4
        }
    }

    public static final class c extends y {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r2) {
            Function1 r0 = this.a;
            if (r2 != null) goto L5;
            r2 = CollectionsKt.emptyList();
        L5:
            r0.invoke(r2);
        }
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void cancelApply() {
        d.x0.getClass();
        d r0 = d.a.a();
        if (r0 == null) goto L6;
        r0.cancelApply();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public gd0.x createRevRtcData() {
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r0 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.createRtcData();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public List<String> getAllOwnGuestUidList() {
        ArrayList r0 = new ArrayList();
        i r1 = getPkLinkUserInfoCenter();
        if (r1 == null) goto L18;
        CopyOnWriteArrayList<LinkPlayerInfo> r2 = r1.c;
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        IBaseUser r4 = ((LinkPlayerInfo) r3.next()).getUser();
        if (r4 == null) goto L8;
        String r5 = r4.getIdString();
        if (r5 == null) goto L8;
        if (q0.a(r5) == false) goto L8;
        if (isSelfGuestByUid(r5) == false) goto L8;
        r0.add(r5);
    L18:
        return r0;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getGuestAnchorLinkMicId() {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L6;
        String r1 = r0.getGuestAnchorLinkMicId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public g getGuestLinkViewNew() {
        d.x0.getClass();
        d r0 = d.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGuestLinkViewNew();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public ei6.a getGuestRtcClient() {
        f.z0.getClass();
        f r0 = f.a.a();
        if (r0 == null) goto L7;
        com.bytedance.android.live.livepkaudience.rtc.a r1 = r0.P2();
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public v0 getLiveVideoClientFactory() {
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r0 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveVideoClientFactory();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public com.bytedance.android.live.pkaudience.api.d getPkAudienceLogData() {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkAudienceLogData();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getPkGuestLynxData() {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L8;
        MutableLiveData<String> r1 = r0.getGuestLynxListData();
        if (r1 == null) goto L8;
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public i getPkLinkUserInfoCenter() {
        if (v.a(k.n(ILinkServiceExternal.class).getControlService().getCurrentMode(), 4) == false) goto L17;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.b.a.a() == null) goto L10;
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.getLinkUserCenter();
    L10:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.a.C0119a.a() == null) goto L18;
        com.bytedance.android.live.livepkaudience.service.a r1 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r1 != null) goto L15;
        return null;
    L15:
        return r1.getLinkUserCenter();
    L18:
        return null;
    L17:
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getSelfAnchorLinkMicId() {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L6;
        String r1 = r0.getSelfAnchorLinkMicId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean handleInteractClick() {
        e.y0.getClass();
        e r0 = e.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.handleInteractClick();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void hideInteractDialog() {
        e.y0.getClass();
        e r0 = e.a.a();
        if (r0 == null) goto L6;
        r0.hideInteractDialog();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isInSelfAnchorLink() {
        IUserService r0 = k.f(IUserService.class);
        Boolean r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.f r2 = r0.user();
        if (r2 == null) goto L7;
        String r3 = r2.n();
    L8:
        if (r3 != null) goto L10;
    L26:
        return false;
    L10:
        if (q0.a(r3) != true) goto L26;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L26;
        com.bytedance.live.datacontext.i r5 = r4.isAnchor();
        if (r5 == null) goto L26;
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L26;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r6 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r6 == null) goto L22;
        r1 = r6.hasAudienceJoinSelfAnchorLink();
    L22:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L26;
        if (isSelfGuestByUid(r3) == false) goto L26;
        return true;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isLinkAudience() {
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.b.a.a() == null) goto L11;
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L7;
        int r1 = r0.H();
    L8:
        if (r1 <= 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = 0;
        goto L8
    L11:
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isRealHasAudienceBeforePk() {
        e.y0.getClass();
        e r0 = e.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getSelfHasAudienceBeforePk();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isRtcEngineOn() {
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r0 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRtcEngineOn();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onFirstRemoteVideoSend() {
        d.x0.getClass();
        d r0 = d.a.a();
        if (r0 == null) goto L6;
        r0.onFirstRemoteVideoSend();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onPKInteractBizEnd() {
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L6;
        i r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L6;
    L10:
        if (r1 == null) goto L13;
        r1.J(this.infoCenterCallback);
        return;
    L13:
        return;
    L6:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r2 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r2 == null) goto L9;
        r1 = r2.getLinkUserCenter();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onPKInteractBizStart() {
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L6;
        i r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L6;
    L10:
        if (r1 == null) goto L13;
        r1.c(this.infoCenterCallback);
        return;
    L13:
        return;
    L6:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r2 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r2 == null) goto L9;
        r1 = r2.getLinkUserCenter();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void resetLinkData() {
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L6;
        r0.resetLinkData();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void showInviteAndPermitDialog() {
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L6;
        r0.bf(false);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void tryLoadPkAudienceWidget() {
        e.y0.getClass();
        e r0 = e.a.a();
        if (r0 == null) goto L6;
        r0.tryLoadPkAudienceWidget();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void tryUnLoadPkAudienceWidget() {
        e.y0.getClass();
        e r0 = e.a.a();
        if (r0 == null) goto L6;
        r0.tryUnLoadPkAudienceWidget();
        return;
    }

    public PkAudienceLinkServiceImp() {
        this.infoCenterCallbacks = new ArrayList();
        this.infoCenterCallback = new b(this);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void kickOutAllGuest() {
        i r0 = getPkLinkUserInfoCenter();
        if (r0 == null) goto L25;
        CopyOnWriteArrayList<LinkPlayerInfo> r1 = r0.c;
        if (r1 == null) goto L41;
        Iterator<LinkPlayerInfo> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L42;
        LinkPlayerInfo r3 = r2.next();
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L12;
        String r5 = r4.getIdString();
    L13:
        if (r5 == null) goto L8;
        if (q0.a(r5) != true) goto L8;
        if (isSelfGuestByUid(r5) == false) goto L8;
        IBaseUser r6 = r3.getUser();
        if (r6 == null) goto L8;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
        if (r7 == null) goto L8;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r8 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r8 == null) goto L8;
        com.bytedance.android.live.livepkaudience.service.b.C0120b.a(r8, r5, r7);
        goto L8
    L12:
        r5 = null;
        goto L13
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public /* bridge */ /* synthetic */ Object getGuestLinkViewNew() {
        return getGuestLinkViewNew();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public /* bridge */ /* synthetic */ Object getLiveVideoClientFactory() {
        return getLiveVideoClientFactory();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public /* bridge */ /* synthetic */ com.bytedance.android.live.pkaudience.api.a getPkLinkUserInfoCenter() {
        return getPkLinkUserInfoCenter();
    }

    public static final /* synthetic */ List access$getInfoCenterCallbacks$p(PkAudienceLinkServiceImp r0) {
        return r0.infoCenterCallbacks;
    }

    private final List<LinkPlayerInfo> getOnlineUserListInInteractAudience(boolean r3) {
        if (r3 == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r4 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r4 == null) goto L10;
        i r5 = r4.getLinkUserCenter();
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        if (Lists.isEmpty(r5.c) == false) goto L15;
        return null;
    L15:
        return r5.c;
    L10:
        r5 = null;
        goto L11
    L7:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r6 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r6 == null) goto L10;
        r5 = r6.getLinkUserCenter();
        goto L11
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void addPkGuestListener(com.bytedance.android.live.pkaudience.api.b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        boolean r4 = k.n(IUserService.class).user().c();
        a r5 = new a((com.bytedance.android.live.pkaudience.api.b) WeakReferenceWrapper.wrap(r6));
        if (r3 == false) goto L17;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r7 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r7 == null) goto L24;
        p r8 = r7.X4();
        if (r8 == null) goto L25;
        r8.a(r5);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        if (r4 == false) goto L27;
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r9 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r9 == null) goto L28;
        o r10 = r9.A0();
        if (r10 == null) goto L29;
        r10.a(r5);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void disconnect(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        d.x0.getClass();
        d r0 = d.a.a();
        if (r0 == null) goto L6;
        r0.disconnect(r2);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void finishInteract(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reqFrom");
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L6;
        r0.finishInteract(r2);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public List<ILinkPlayerInfoBridge> getSelfOnlineUserList(boolean r8) {
        ArrayList r0 = new ArrayList();
        i r1 = getPkLinkUserInfoCenter();
        if (r8 == false) goto L6;
        if (r1 == null) goto L8;
        CopyOnWriteArrayList<LinkPlayerInfo> r2 = r1.c;
    L9:
        if (r2 == null) goto L44;
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L44;
        LinkPlayerInfo r4 = (LinkPlayerInfo) r3.next();
        if (r8 != true) goto L32;
        o0.a r5 = o0.a;
        IBaseUser r6 = r4.getUser();
        if (r6 == null) goto L18;
        String r7 = r6.getIdString();
    L19:
        com.bytedance.android.livesdk.chatroom.o r9 = o3.f();
        if (r9 == null) goto L26;
        m r10 = r9.getRoom();
        if (r10 == null) goto L26;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L26;
        String r12 = r11.getOwnerUserIdString();
    L27:
        r5.getClass();
        if (o0.a.a(r7, r12) == true) goto L32;
        if (isSelfGuestByIId(r4.getInteractId()) == false) goto L32;
        r0.add(r4);
    L26:
        r12 = null;
        goto L27
    L18:
        r7 = null;
    L32:
        if (r8 == true) goto L12;
        o0.a r13 = o0.a;
        if (getPkLinkUserInfoCenter() == null) goto L36;
        String r14 = i.j();
    L37:
        IBaseUser r15 = r4.getUser();
        if (r15 == null) goto L40;
        String r16 = r15.getIdString();
    L41:
        r13.getClass();
        if (o0.a.a(r14, r16) == true) goto L12;
        r0.add(r4);
        goto L12
    L40:
        r16 = null;
        goto L41
    L36:
        r14 = null;
    L44:
        return r0;
    L8:
        r2 = null;
        goto L9
    L6:
        if (r1 == null) goto L8;
        r2 = r1.d;
        goto L9
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isMuteRemoteAudio(String r3) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        f.z0.getClass();
        f r1 = f.a.a();
        if (r1 == null) goto L7;
        com.bytedance.android.live.livepkaudience.rtc.a r2 = r1.P2();
        if (r2 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "interactId");
        return r2.t.contains(r3);
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isNotSelfGuestByIId(String r2) {
        i r0 = getPkLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.v(r2);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isNotSelfGuestByUid(String r2) {
        i r0 = getPkLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.w(r2);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isSelfGuestByIId(String r2) {
        i r0 = getPkLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.z(r2);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isSelfGuestByUid(String r2) {
        i r0 = getPkLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.A(r2);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void markSwitchToMulti(boolean r2) {
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 == null) goto L6;
        r0.markSwitchToMulti(r2);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void permit(ILinkPlayerInfoBridge r6) {
        Intrinsics.checkNotNullParameter(r6, "user");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        boolean r4 = k.n(IUserService.class).user().c();
        if (r3 == false) goto L17;
        User r7 = r6.getUser();
        if (r7 == null) goto L22;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r5 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r5 == null) goto L23;
        r5.Fl(r7);
        return;
    L23:
        return;
    L22:
        return;
    L17:
        if (r4 == false) goto L25;
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r8 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r8 == null) goto L26;
        r8.wi((LinkPlayerInfo) r6);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public Disposable registerOnlineListChange(Function1<? super List<? extends ILinkPlayerInfoBridge>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onChange");
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r0 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r1 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r1 == null) goto L9;
        r1.getLinkUserCenter();
    L9:
        final c r3 = new c(r2);
        this.infoCenterCallbacks.add(r3);
        int r4 = h.a;
        return h.a(new AnonymousClass1(this, r3));
    L5:
        if (r0.getLinkUserCenter() != null) goto L9;
        goto L6
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void registerPkGuestLynxDataObserver(Observer<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L8;
        MutableLiveData<String> r1 = r0.getGuestLynxListData();
        if (r1 == null) goto L9;
        r1.observeForever(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void setLinkerContentMap(ILinkerBattleConnectContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r0 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r0 == null) goto L6;
        r0.I7((LinkerBattleConnectContent) r2);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void unLoadOtherWidget(int r2) {
        e.y0.getClass();
        e r0 = e.a.a();
        if (r0 == null) goto L6;
        r0.unLoadOtherWidget(r2);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void unRegisterPkGuestLynxDataObserver(Observer<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r0 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r0 == null) goto L8;
        MutableLiveData<String> r1 = r0.getGuestLynxListData();
        if (r1 == null) goto L9;
        r1.removeObserver(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public BasePkInteractControlWidget createRevPkAudienceControlWidget(v0 r2, int r3) {
        return new LinkPkInteractControlWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isUserInInteractAudience(boolean r7, IBaseUser r8) {
        List<LinkPlayerInfo> r9 = getOnlineUserListInInteractAudience(r7);
        if (r8 != null) goto L5;
    L24:
        return false;
    L5:
        if (Lists.isEmpty(r9) == true) goto L24;
        if (r9 == null) goto L24;
        Iterator<LinkPlayerInfo> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L24;
        LinkPlayerInfo r1 = r10.next();
        if (r1 == null) goto L14;
        IBaseUser r2 = r1.getUser();
    L15:
        if (r2 == null) goto L10;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
        if (r4 == null) goto L10;
        if (d5.c(r4) != d5.c(r8.getIdString())) goto L10;
        return true;
    L14:
        r2 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void setRevGuestManagerData(gd0.x r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "revRtcData");
        if ((r3 instanceof v0) == true) goto L5;
        r3 = null;
    L5:
        v0 r4 = (v0) r3;
        com.bytedance.android.live.livepkaudience.rtc.c.t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r0 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r0 == null) goto L9;
        r0.rd(r2, r4);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void kickOut(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        Intrinsics.checkNotNullParameter(r8, "reqFrom");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        boolean r4 = k.n(IUserService.class).user().c();
        if (r3 == false) goto L15;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r5 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r5 == null) goto L20;
        r5.kickOut(r6, r7, r8);
        return;
    L20:
        return;
    L15:
        if (r4 == false) goto L22;
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r9 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r9 == null) goto L23;
        r9.kickOut(r6, r7, r8);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void apply(int r2, int r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "fromSource");
        d.x0.getClass();
        d r0 = d.a.a();
        if (r0 == null) goto L6;
        r0.c2(r2, r3, r4, com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r5));
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void switchAudioByClient(boolean r8, List<com.bytedance.android.livesdk.link.model.bridge.k> r9, long r10, Map<Long, ? extends g2> r12) {
        Intrinsics.checkNotNullParameter(r9, "data");
        d.x0.getClass();
        d r1 = d.a.a();
        if (r1 == null) goto L14;
        List<AnchorLinkUser> r3 = jm2.a.a(r9);
        if (r12 == null) goto L10;
        LinkedHashMap r11 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));
        Iterator<T> r13 = r12.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r0 = (Map.Entry) r13.next();
        r11.put(r0.getKey(), jm2.a.d((vh7.c) r0.getValue()));
    L11:
        r1.switchAudioByClient(r8, r3, r10, r11);
        return;
    L10:
        r11 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void invite(long r10, String r12, String r13, int r14, long r15) {
        Intrinsics.checkNotNullParameter(r12, "uid");
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r1 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r1 == null) goto L9;
        if (r13 != null) goto L6;
        String r5 = "";
    L7:
        r1.invite(r10, r12, r5, r14, r15);
        return;
    L6:
        r5 = r13;
        goto L7
    }
}
