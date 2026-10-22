package com.bytedance.android.live.livepkaudience.context;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.service.f;
import com.bytedance.android.live.livepkaudience.service.c;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerReplyContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import ey.d;
import ey.g;
import ey.l;
import fy.e;
import fy.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001D\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0006\u0010\u001c\u001a\u00020\nR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R!\u00102\u001a\b\u0012\u0004\u0012\u00020$0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R!\u00105\u001a\b\u0012\u0004\u0012\u00020$0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R!\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R!\u0010;\u001a\b\u0012\u0004\u0012\u00020$0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010,\u001a\u0004\b:\u0010.R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u0004\u0018\u00010?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0017\u0010H\u001a\u00020G8\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/context/LinkPkInteractGuestDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/livepkaudience/service/c;", "", "isLinkWithAudience", "", "getSelfAnchorLinkMicId", "getGuestAnchorLinkMicId", "getAudienceSelfLinkMicId", "linkId", "", "setSelfAnchorLinkMicId", "src", "setGuestAnchorLinkMicId", "gameExtra", "setGameData", "Landroidx/lifecycle/MutableLiveData;", "getGuestLynxListData", "setAudienceSelfLinkMicId", "hasAudienceJoinSelfAnchorLink", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/live/pkaudience/api/d;", "getPkAudienceLogData", "kickedUsersUniqueId", "getSelfHasAudienceBeforePk", "Lcom/bytedance/android/live/livepkaudience/service/g;", "getPkInteractAudienceParams", "resetLinkData", "resetLogData", "audienceLinkMicId", "Ljava/lang/String;", "linkMicId", "guestLinkMicId", "mySelfHasAudience", "Z", "", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "linkerContentMap", "Ljava/util/Map;", "inviterWithAudience", "inviteeWithAudience", "Lcom/bytedance/live/datacontext/m;", "hasAudienceJoin4Pk$delegate", "Lcom/bytedance/live/datacontext/p;", "getHasAudienceJoin4Pk", "()Lcom/bytedance/live/datacontext/m;", "hasAudienceJoin4Pk", "hasAudienceOnlineTime4Pk$delegate", "getHasAudienceOnlineTime4Pk", "hasAudienceOnlineTime4Pk", "hasAudienceOnlineTime$delegate", "getHasAudienceOnlineTime", "hasAudienceOnlineTime", "hasAudienceJoin4Penalty$delegate", "getHasAudienceJoin4Penalty", "hasAudienceJoin4Penalty", "hasAudienceOnlineTime4Penalty$delegate", "getHasAudienceOnlineTime4Penalty", "hasAudienceOnlineTime4Penalty", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Ley/g;", "connectService", "Ley/g;", "linkGuestLynxData", "Landroidx/lifecycle/MutableLiveData;", "com/bytedance/android/live/livepkaudience/context/LinkPkInteractGuestDataContext$b", "linkListener", "Lcom/bytedance/android/live/livepkaudience/context/LinkPkInteractGuestDataContext$b;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkInteractGuestDataContext extends DataContext implements c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private String audienceLinkMicId;
    private CompositeDisposable cd;
    private final g connectService;
    private final DataCenter dataCenter;
    private String gameExtra;
    private String guestLinkMicId;
    private final p hasAudienceJoin4Penalty$delegate;
    private final p hasAudienceJoin4Pk$delegate;
    private final p hasAudienceOnlineTime$delegate;
    private final p hasAudienceOnlineTime4Penalty$delegate;
    private final p hasAudienceOnlineTime4Pk$delegate;
    private boolean inviteeWithAudience;
    private boolean inviterWithAudience;
    private String kickedUsersUniqueId;
    private MutableLiveData<String> linkGuestLynxData;
    private final b linkListener;
    private String linkMicId;
    private Map<Long, ? extends RoomLinkerContent> linkerContentMap;
    private boolean mySelfHasAudience;

    public static final class a implements Action {
        public final /* synthetic */ LinkPkInteractGuestDataContext a;

        public a(LinkPkInteractGuestDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            g r0 = LinkPkInteractGuestDataContext.access$getConnectService$p(this.a);
            if (r0 == null) goto L6;
            r0.a(1, LinkPkInteractGuestDataContext.access$getLinkListener$p(this.a));
            r0.a(7, LinkPkInteractGuestDataContext.access$getLinkListener$p(this.a));
            return;
        }
    }

    public static final class b extends d {
        public final /* synthetic */ LinkPkInteractGuestDataContext a;

        public b(LinkPkInteractGuestDataContext r1) {
            this.a = r1;
        }

        public final void P5(if r3) {
            Intrinsics.checkNotNullParameter(r3, "linkerMessage");
            Intrinsics.checkNotNullParameter(r3, "linkerMessage");
            LinkPkInteractGuestDataContext r0 = this.a;
            LinkPkInteractGuestDataContext.access$setMySelfHasAudience$p(r0, LinkPkInteractGuestDataContext.access$isLinkWithAudience(r0));
            LinkPkInteractGuestDataContext r1 = this.a;
            LinkerInviteContent r4 = r3.mInvite;
            if (r4 == null) goto L5;
            boolean r5 = r4.getInviterWithAudience();
        L6:
            LinkPkInteractGuestDataContext.access$setInviterWithAudience$p(r1, r5);
            return;
        L5:
            r5 = false;
            goto L6
        }

        public final void qe(if r4) {
            Intrinsics.checkNotNullParameter(r4, "linkerMessage");
            Intrinsics.checkNotNullParameter(r4, "linkerMessage");
            LinkerReplyContent r0 = r4.mReply;
            Map r1 = null;
            if (r0 == null) goto L5;
            Integer r2 = Integer.valueOf(r0.replyStatus);
        L6:
            if (r2 != null) goto L9;
            return;
        L9:
            if (r2.intValue() != 1) goto L20;
            LinkPkInteractGuestDataContext r3 = this.a;
            LinkerReplyContent r5 = r4.mReply;
            if (r5 == null) goto L14;
            String r6 = r5.kickedUsersniqueId;
            if (r6 == null) goto L14;
        L15:
            LinkPkInteractGuestDataContext.access$setKickedUsersUniqueId$p(r3, r6);
            LinkPkInteractGuestDataContext r7 = this.a;
            LinkerReplyContent r8 = r4.mReply;
            if (r8 == null) goto L18;
            r1 = r8.linkerContentMap;
        L18:
            LinkPkInteractGuestDataContext.access$setLinkerContentMap$p(r7, r1);
            return;
        L14:
            r6 = "";
            goto L15
        L20:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final void Ah(j r2, LinkReplyResult r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r3, "replyResult");
            super.Ah(r2, r3, r4);
            if (r2.d != 1) goto L10;
            LinkPkInteractGuestDataContext r5 = this.a;
            String r6 = r3.getKickedUsersniqueId();
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            LinkPkInteractGuestDataContext.access$setKickedUsersUniqueId$p(r5, r6);
            LinkPkInteractGuestDataContext.access$setLinkerContentMap$p(this.a, r3.getMLinkerContentMap());
            return;
        }

        public final void zm(e r2, long r3, LinkInviteResult r5, l r6) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r5, "inviteResult");
            super.zm(r2, r3, r5, r6);
            LinkPkInteractGuestDataContext r4 = this.a;
            LinkPkInteractGuestDataContext.access$setMySelfHasAudience$p(r4, LinkPkInteractGuestDataContext.access$isLinkWithAudience(r4));
            LinkPkInteractGuestDataContext.access$setInviteeWithAudience$p(this.a, r5.getInviteeWithAudience());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceJoin4Pk", "getHasAudienceJoin4Pk()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceOnlineTime4Pk", "getHasAudienceOnlineTime4Pk()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceOnlineTime", "getHasAudienceOnlineTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceJoin4Penalty", "getHasAudienceJoin4Penalty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LinkPkInteractGuestDataContext.class, "hasAudienceOnlineTime4Penalty", "getHasAudienceOnlineTime4Penalty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> getHasAudienceJoin4Penalty() {
        return (m) this.hasAudienceJoin4Penalty$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getHasAudienceJoin4Pk() {
        return (m) this.hasAudienceJoin4Pk$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Long> getHasAudienceOnlineTime() {
        return (m) this.hasAudienceOnlineTime$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Long> getHasAudienceOnlineTime4Penalty() {
        return (m) this.hasAudienceOnlineTime4Penalty$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Long> getHasAudienceOnlineTime4Pk() {
        return (m) this.hasAudienceOnlineTime4Pk$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void resetLinkData() {
        this.linkerContentMap = null;
        this.kickedUsersUniqueId = "";
        this.inviterWithAudience = false;
        this.inviteeWithAudience = false;
    }

    private final boolean isLinkWithAudience() {
        if (((f) ((IInteractService) k.n(IInteractService.class)).getInteractAudienceService()).P() == false) goto L5;
    L8:
        return true;
    L5:
        if (((IInteractService) k.n(IInteractService.class)).getVideoTalkService().t() > 0) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public com.bytedance.android.live.pkaudience.api.d getPkAudienceLogData() {
        return new com.bytedance.android.live.pkaudience.api.d(((Boolean) getHasAudienceJoin4Pk().getValue()).booleanValue(), ((Number) getHasAudienceOnlineTime4Pk().getValue()).longValue(), ((Number) getHasAudienceOnlineTime().getValue()).longValue(), ((Boolean) getHasAudienceJoin4Penalty().getValue()).booleanValue(), ((Number) getHasAudienceOnlineTime4Penalty().getValue()).longValue());
    }

    public com.bytedance.android.live.livepkaudience.service.g getPkInteractAudienceParams() {
        return new com.bytedance.android.live.livepkaudience.service.g(this.linkerContentMap, this.inviterWithAudience, this.inviteeWithAudience);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public Boolean hasAudienceJoinSelfAnchorLink() {
        return (Boolean) this.dataCenter.get("cmd_what_audience_join_self_link", Boolean.FALSE);
    }

    public final void resetLogData() {
        m<Boolean> r0 = getHasAudienceJoin4Pk();
        Boolean r1 = Boolean.FALSE;
        r0.setValue(r1);
        getHasAudienceOnlineTime4Pk().setValue(0L);
        getHasAudienceJoin4Penalty().setValue(r1);
        getHasAudienceOnlineTime4Penalty().setValue(0L);
        getHasAudienceOnlineTime().setValue(0L);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public String getAudienceSelfLinkMicId() {
        return this.audienceLinkMicId;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public String getGuestAnchorLinkMicId() {
        return this.guestLinkMicId;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public MutableLiveData<String> getGuestLynxListData() {
        return this.linkGuestLynxData;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public String getSelfAnchorLinkMicId() {
        return this.linkMicId;
    }

    public final boolean getSelfHasAudienceBeforePk() {
        return this.mySelfHasAudience;
    }

    public final String kickedUsersUniqueId() {
        return this.kickedUsersUniqueId;
    }

    public LinkPkInteractGuestDataContext(DataCenter r6) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.dataCenter = r6;
        this.audienceLinkMicId = "";
        this.linkMicId = "";
        this.guestLinkMicId = "";
        this.kickedUsersUniqueId = "";
        this.gameExtra = "";
        Boolean r1 = Boolean.FALSE;
        this.hasAudienceJoin4Pk$delegate = q.d(this, r1);
        this.hasAudienceOnlineTime4Pk$delegate = q.d(this, 0L);
        this.hasAudienceOnlineTime$delegate = q.d(this, 0L);
        this.hasAudienceJoin4Penalty$delegate = q.d(this, r1);
        this.hasAudienceOnlineTime4Penalty$delegate = q.d(this, 0L);
        this.cd = new CompositeDisposable();
        g.a.getClass();
        nc0.b r2 = g.a.a();
        this.connectService = r2;
        this.linkGuestLynxData = new MutableLiveData();
        b r3 = new b(this);
        this.linkListener = r3;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), this.cd);
        if (r2 == null) goto L6;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r2.d.linkOutManager(), "real");
        r2.b(1, r3);
        r2.b(7, r3);
        return;
    }

    public static final /* synthetic */ g access$getConnectService$p(LinkPkInteractGuestDataContext r0) {
        return r0.connectService;
    }

    public static final /* synthetic */ boolean access$getInviteeWithAudience$p(LinkPkInteractGuestDataContext r0) {
        return r0.inviteeWithAudience;
    }

    public static final /* synthetic */ boolean access$getInviterWithAudience$p(LinkPkInteractGuestDataContext r0) {
        return r0.inviterWithAudience;
    }

    public static final /* synthetic */ String access$getKickedUsersUniqueId$p(LinkPkInteractGuestDataContext r0) {
        return r0.kickedUsersUniqueId;
    }

    public static final /* synthetic */ b access$getLinkListener$p(LinkPkInteractGuestDataContext r0) {
        return r0.linkListener;
    }

    public static final /* synthetic */ Map access$getLinkerContentMap$p(LinkPkInteractGuestDataContext r0) {
        return r0.linkerContentMap;
    }

    public static final /* synthetic */ boolean access$getMySelfHasAudience$p(LinkPkInteractGuestDataContext r0) {
        return r0.mySelfHasAudience;
    }

    public static final /* synthetic */ boolean access$isLinkWithAudience(LinkPkInteractGuestDataContext r0) {
        return r0.isLinkWithAudience();
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setAudienceSelfLinkMicId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.audienceLinkMicId = r1;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setGameData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "gameExtra");
        this.gameExtra = r2;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setSelfAnchorLinkMicId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkId");
        this.linkMicId = r2;
    }

    public static final /* synthetic */ void access$setInviteeWithAudience$p(LinkPkInteractGuestDataContext r0, boolean r1) {
        r0.inviteeWithAudience = r1;
    }

    public static final /* synthetic */ void access$setInviterWithAudience$p(LinkPkInteractGuestDataContext r0, boolean r1) {
        r0.inviterWithAudience = r1;
    }

    public static final /* synthetic */ void access$setKickedUsersUniqueId$p(LinkPkInteractGuestDataContext r0, String r1) {
        r0.kickedUsersUniqueId = r1;
    }

    public static final /* synthetic */ void access$setLinkerContentMap$p(LinkPkInteractGuestDataContext r0, Map r1) {
        r0.linkerContentMap = r1;
    }

    public static final /* synthetic */ void access$setMySelfHasAudience$p(LinkPkInteractGuestDataContext r0, boolean r1) {
        r0.mySelfHasAudience = r1;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.c
    public void setGuestAnchorLinkMicId(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "linkId");
        Intrinsics.checkNotNullParameter(r4, "src");
        ALogger.i("LinkPkInteract", "LinkPkInteractGuestDataContext setGuestAnchorLinkMicId linkId = " + r3 + ", src = " + r4);
        this.guestLinkMicId = r3;
    }
}
