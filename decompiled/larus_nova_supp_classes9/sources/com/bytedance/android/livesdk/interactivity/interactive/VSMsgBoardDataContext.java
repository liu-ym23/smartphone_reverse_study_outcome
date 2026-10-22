package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardCommentListSyncDataModel;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.u9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisodeKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSToolbarConfigData;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b`\u0010aJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u0012\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0016J\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010#R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010#R!\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010#R$\u0010/\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010I\u001a\u0004\b\f\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bM\u00100\u001a\u0004\bN\u00102\"\u0004\bO\u00104R*\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010P8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bW\u0010I\u001a\u0004\bX\u0010J\"\u0004\bY\u0010LR\"\u0010Z\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bZ\u0010I\u001a\u0004\b[\u0010J\"\u0004\b\\\u0010LR\"\u0010]\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b]\u0010I\u001a\u0004\b^\u0010J\"\u0004\b_\u0010L¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/VSMsgBoardDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/chatroom/msgboard/a;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "reqCommentLikeData", "initInputPanelConfig", "Lylc/e;", "wrdsManager", "initMsgBoardCommentDataSync", BuildConfig.FLAVOR, "isReplay", "init", "updateReplayStatus", "Lio/reactivex/Observable;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getMessageBoardSelfComment", "getInteractDressInfo", "Lcom/bytedance/android/livesdk/chatroom/msgboard/b;", "dressResponse", BuildConfig.FLAVOR, "updatePaidStatus", "Lcom/bytedance/live/datacontext/n;", BuildConfig.FLAVOR, "draft$delegate", "Lcom/bytedance/live/datacontext/p;", "getDraft", "()Lcom/bytedance/live/datacontext/n;", "draft", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/chatroom/ui/u9;", "inputPanelConfig$delegate", "getInputPanelConfig", "()Lcom/bytedance/live/datacontext/j;", "inputPanelConfig", "commentLikeRelation$delegate", "getCommentLikeRelation", "commentLikeRelation", "extra$delegate", "getExtra", "extra", "Lcom/bytedance/android/livesdk/chatroom/msgboard/VSMsgBoardCommentListSyncDataModel;", "commentListDataSyncModel$delegate", "getCommentListDataSyncModel", "commentListDataSyncModel", "vsMsgBoardDressInfo", "Ljava/lang/String;", "getVsMsgBoardDressInfo", "()Ljava/lang/String;", "setVsMsgBoardDressInfo", "(Ljava/lang/String;)V", "vsMsgSelfCommentData", "Ljava/util/List;", "getVsMsgSelfCommentData", "()Ljava/util/List;", "setVsMsgSelfCommentData", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "getEpisode", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "setEpisode", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;)V", "Z", "()Z", "setReplay", "(Z)V", "payScheme", "getPayScheme", "setPayScheme", BuildConfig.FLAVOR, "paidEntityIds", "Ljava/util/Set;", "getPaidEntityIds", "()Ljava/util/Set;", "setPaidEntityIds", "(Ljava/util/Set;)V", "requestDressInfoFailed", "getRequestDressInfoFailed", "setRequestDressInfoFailed", "requestDressAlready", "getRequestDressAlready", "setRequestDressAlready", "paidStatusChanged", "getPaidStatusChanged", "setPaidStatusChanged", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardDataContext extends DataContext implements com.bytedance.android.livesdk.chatroom.msgboard.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p commentLikeRelation$delegate;
    private final com.bytedance.live.datacontext.p commentListDataSyncModel$delegate;
    private final com.bytedance.live.datacontext.p draft$delegate;
    private Episode episode;
    private final com.bytedance.live.datacontext.p extra$delegate;
    private final com.bytedance.live.datacontext.p inputPanelConfig$delegate;
    private boolean isReplay;
    private Set<String> paidEntityIds;
    private boolean paidStatusChanged;
    private String payScheme;
    private boolean requestDressAlready;
    private boolean requestDressInfoFailed;
    private IRoom room;
    private String vsMsgBoardDressInfo;
    private List<String> vsMsgSelfCommentData;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ VSMsgBoardDataContext a;

        public a(VSMsgBoardDataContext r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            Response r5 = (Response) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            VSMsgBoardDataContext r0 = this.a;
            com.bytedance.android.livesdk.chatroom.msgboard.b r1 = (com.bytedance.android.livesdk.chatroom.msgboard.b) ((BaseResponse) r5).data;
            if (r1 == null) goto L6;
            String r2 = r1.d();
            if (r2 == null) goto L6;
        L7:
            r0.setPayScheme(r2);
            this.a.setVsMsgBoardDressInfo(GsonProtectorUtils.toJson(GsonHelper.get(), ((BaseResponse) r5).data));
            this.a.setPaidEntityIds(new LinkedHashSet());
            this.a.updatePaidStatus((com.bytedance.android.livesdk.chatroom.msgboard.b) ((BaseResponse) r5).data);
            this.a.setRequestDressInfoFailed(false);
            this.a.setRequestDressAlready(true);
            this.a.setPaidStatusChanged(false);
            return this.a.getVsMsgBoardDressInfo();
        L6:
            r2 = BuildConfig.FLAVOR;
            goto L7
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ VSMsgBoardDataContext a;

        public b(VSMsgBoardDataContext r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            VSMsgBoardDataContext r0 = this.a;
            d1 r4 = (d1) ((BaseResponse) r3).data;
            if (r4 == null) goto L5;
            List<String> r5 = r4.a();
        L6:
            r0.setVsMsgSelfCommentData(r5);
            return this.a.getVsMsgSelfCommentData();
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VSMsgBoardDataContext a;

        public c(VSMsgBoardDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Response r3 = (Response) r2;
            com.bytedance.live.datacontext.n<String> r0 = this.a.getCommentLikeRelation();
            if (r3 == null) goto L7;
            VSMessageBoardCommentLikeResponseData r4 = (VSMessageBoardCommentLikeResponseData) ((BaseResponse) r3).data;
            if (r4 == null) goto L7;
            Map<Long, Boolean> r5 = r4.getThumbUpList();
        L8:
            r0.setValue(JsonUtil.toJSONString(r5));
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            int r0 = h1.a;
            String r4 = "req for thumb up error = " + ((Throwable) r3).getMessage();
            Intrinsics.checkNotNullParameter(r4, "msg");
            ALogger.i("VSMsgBoard", r4);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VSMsgBoardDataContext.class, "draft", "getDraft()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(VSMsgBoardDataContext.class, "inputPanelConfig", "getInputPanelConfig()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(VSMsgBoardDataContext.class, "commentLikeRelation", "getCommentLikeRelation()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(VSMsgBoardDataContext.class, "extra", "getExtra()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(VSMsgBoardDataContext.class, "commentListDataSyncModel", "getCommentListDataSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
    }

    public com.bytedance.live.datacontext.n<String> getCommentLikeRelation() {
        return (com.bytedance.live.datacontext.n) this.commentLikeRelation$delegate.a(this, $$delegatedProperties[2]);
    }

    public com.bytedance.live.datacontext.j<VSMsgBoardCommentListSyncDataModel> getCommentListDataSyncModel() {
        return (com.bytedance.live.datacontext.j) this.commentListDataSyncModel$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.n<CharSequence> getDraft() {
        return (com.bytedance.live.datacontext.n) this.draft$delegate.a(this, $$delegatedProperties[0]);
    }

    public com.bytedance.live.datacontext.j<String> getExtra() {
        return (com.bytedance.live.datacontext.j) this.extra$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.j<u9> getInputPanelConfig() {
        return (com.bytedance.live.datacontext.j) this.inputPanelConfig$delegate.a(this, $$delegatedProperties[1]);
    }

    public VSMsgBoardDataContext() {
        this.draft$delegate = com.bytedance.live.datacontext.q.c(this);
        this.inputPanelConfig$delegate = ConstantKt.c(this);
        this.commentLikeRelation$delegate = com.bytedance.live.datacontext.q.c(this);
        this.extra$delegate = ConstantKt.c(this);
        this.commentListDataSyncModel$delegate = ConstantKt.c(this);
        this.payScheme = BuildConfig.FLAVOR;
        this.paidEntityIds = new LinkedHashSet();
    }

    public Observable<String> getInteractDressInfo() {
        updateReplayStatus();
        ArrayList r0 = new ArrayList();
        JSONObject r1 = new JSONObject();
        r1.put("paid_live_type", 5);
        IRoom r2 = getRoom();
        Long r4 = null;
        if (r2 == null) goto L11;
        IEpisodeExtraInfo r3 = r2.getEpisodeExtra();
        if (r3 == null) goto L11;
        Map r5 = r3.getPrivilegeInfo();
        if (r5 == null) goto L11;
        PrivilegeInfo r6 = (PrivilegeInfo) r5.get(String.valueOf(5));
        if (r6 == null) goto L11;
        Long r7 = Long.valueOf(r6.entityid);
    L21:
        long r8 = 0;
        if (r7 == null) goto L24;
        long r9 = r7.longValue();
    L25:
        r1.put("entity_id", r9);
        r0.add(r1.toString());
        IVSMessageBoardApi r10 = (IVSMessageBoardApi) com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().getService(IVSMessageBoardApi.class);
        if (isReplay() == false) goto L32;
        Episode r11 = getEpisode();
        if (r11 == null) goto L38;
        EpisodeBasicInfo r13 = r11.episodeBasicInfo;
        if (r13 == null) goto L38;
        long r14 = r13.getOriginEpisodeId();
    L37:
        long r15 = r14;
    L39:
        fq1.s r16 = fq1.t.a();
        if (r16 == null) goto L44;
        String r17 = r16.getCurrentUserId();
        if (r17 == null) goto L44;
        r4 = Long.valueOf(CastLongProtector.parseLong(r17));
    L44:
        long r18 = r4.longValue();
        if (isReplay() == false) goto L49;
        Episode r19 = getEpisode();
        if (r19 == null) goto L53;
        r8 = r19.roomId;
    L53:
        return r10.getInteractDressInfo(r15, r18, r8, GsonProtectorUtils.toJson(GsonHelper.get(), r0)).map(new a(this));
    L49:
        IRoom r20 = getRoom();
        if (r20 == null) goto L53;
        r8 = r20.getRoomId();
    L38:
        r15 = 0;
        goto L39
    L32:
        IRoom r21 = getRoom();
        if (r21 == null) goto L38;
        IEpisodeExtraInfo r23 = r21.getEpisodeExtra();
        if (r23 == null) goto L38;
        r14 = r23.getId();
        goto L37
    L24:
        r9 = 0;
    L11:
        Episode r24 = getEpisode();
        if (r24 == null) goto L20;
        IMainEpisode r25 = r24.castToOrNull(IMainEpisode.class);
        if (r25 == null) goto L20;
        Map r26 = r25.getPrivilegeInfo();
        if (r26 == null) goto L20;
        PrivilegeInfo r27 = (PrivilegeInfo) r26.get(5);
        if (r27 == null) goto L20;
        r7 = Long.valueOf(r27.entityid);
    L20:
        r7 = null;
        goto L21
    }

    public Observable<List<String>> getMessageBoardSelfComment() {
        updateReplayStatus();
        if (fq1.t.a().isLogin() == true) goto L6;
        return null;
    L6:
        IVSMessageBoardApi r1 = (IVSMessageBoardApi) com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().getService(IVSMessageBoardApi.class);
        long r2 = 0;
        if (isReplay() == false) goto L11;
        Episode r0 = getEpisode();
        if (r0 == null) goto L14;
        long r4 = r0.roomId;
    L16:
        if (isReplay() == false) goto L22;
        Episode r3 = getEpisode();
        if (r3 == null) goto L27;
        EpisodeBasicInfo r5 = r3.episodeBasicInfo;
        if (r5 == null) goto L27;
        r2 = r5.getOriginEpisodeId();
    L27:
        long r6 = r2;
        if (isReplay() == false) goto L36;
        Episode r7 = getEpisode();
        if (r7 == null) goto L40;
        IMainEpisode r8 = r7.castToOrNull(IMainEpisode.class);
        if (r8 == null) goto L40;
        String r9 = IMainEpisodeKt.getOwnerUserIdStr(r8);
        if (r9 == null) goto L40;
    L42:
        return r1.getSelfComment(r4, r6, r9).map(new b(this));
    L40:
        r9 = "0";
        goto L42
    L36:
        IRoom r10 = getRoom();
        if (r10 == null) goto L40;
        r9 = r10.getAnchorId();
        if (r9 != null) goto L42;
    L22:
        IRoom r11 = getRoom();
        if (r11 == null) goto L27;
        IEpisodeExtraInfo r13 = r11.getEpisodeExtra();
        if (r13 == null) goto L27;
        r2 = r13.getId();
    L14:
        r4 = 0;
        goto L16
    L11:
        IRoom r14 = getRoom();
        if (r14 == null) goto L14;
        r4 = r14.getRoomId();
        goto L16
    }

    public final void updateReplayStatus() {
        nm1.e r0 = pm1.f.c();
        com.bytedance.live.datacontext.j r1 = null;
        if (r0 == null) goto L7;
        ReplayDataContext r2 = r0.h(null);
        if (r2 == null) goto L7;
        r1 = r2.getVsMsgBoardDataContext();
    L7:
        if (r1 == null) goto L9;
        boolean r3 = true;
    L10:
        setReplay(r3);
        return;
    L9:
        r3 = false;
        goto L10
    }

    public Episode getEpisode() {
        return this.episode;
    }

    public Set<String> getPaidEntityIds() {
        return this.paidEntityIds;
    }

    public boolean getPaidStatusChanged() {
        return this.paidStatusChanged;
    }

    public String getPayScheme() {
        return this.payScheme;
    }

    public boolean getRequestDressAlready() {
        return this.requestDressAlready;
    }

    public boolean getRequestDressInfoFailed() {
        return this.requestDressInfoFailed;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public String getVsMsgBoardDressInfo() {
        return this.vsMsgBoardDressInfo;
    }

    public List<String> getVsMsgSelfCommentData() {
        return this.vsMsgSelfCommentData;
    }

    public boolean isReplay() {
        return this.isReplay;
    }

    private final void initInputPanelConfig(DataCenter r8) {
        com.bytedance.live.datacontext.j<u9> r0 = getInputPanelConfig();
        int r1 = k1.a;
        u9 r2 = null;
        if (r8 == null) goto L54;
        nm1.e r3 = pm1.f.c();
        if (r3 == null) goto L10;
        ReplayDataContext r4 = r3.h(r8);
        if (r4 == null) goto L10;
        com.bytedance.live.datacontext.j r5 = r4.getVsMsgBoardDataContext();
    L12:
        if (r5 != null) goto L30;
        ILiveToolbarData r9 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r8).getToolbarData();
        if (r9 == null) goto L47;
        List r10 = r9.getToolbarDataList();
        if (r10 == null) goto L47;
        Iterator r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L26;
        Object r6 = r11.next();
        if (((IToolbarComponentData) r6).getId() != 27) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L19;
    L27:
        IToolbarComponentData r13 = (IToolbarComponentData) r6;
        if (r13 == null) goto L47;
        String r14 = r13.getExtraData();
    L56:
        com.bytedance.android.livesdk.interactivity.interactive.a r15 = (com.bytedance.android.livesdk.interactivity.interactive.a) GsonHelper.get().fromJson(r14, com.bytedance.android.livesdk.interactivity.interactive.a.class);     // Catch: Exception -> L50
    L51:
        if (r15 == null) goto L54;
        r2 = r15.a();
    L50:
        int r16 = h1.a;
        String r17 = "parse extra config error extra = " + r14;
        Intrinsics.checkNotNullParameter(r17, "msg");
        ALogger.i("VSMsgBoard", r17);
        r15 = null;
        goto L51
    L23:
        r7 = false;
        goto L24
    L26:
        r6 = null;
    L47:
        r14 = null;
        goto L56
    L30:
        List r18 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r8).getPannelToolbarList();
        if (r18 == null) goto L47;
        Iterator r19 = r18.iterator();
    L34:
        if (r19.hasNext() == false) goto L41;
        Object r20 = r19.next();
        if (((IVSToolbarConfigData) r20).getToolbarType() != 12) goto L38;
        boolean r21 = true;
    L39:
        if (r21 == false) goto L34;
    L42:
        IVSToolbarConfigData r23 = (IVSToolbarConfigData) r20;
        if (r23 == null) goto L47;
        IMainVSToolbarConfigData r24 = r23.castToOrNull(IMainVSToolbarConfigData.class);
        if (r24 == null) goto L47;
        r14 = r24.getExtra();
        goto L56
    L38:
        r21 = false;
        goto L39
    L41:
        r20 = null;
    L10:
        r5 = null;
    L54:
        r0.d(r2);
    }

    private final void initMsgBoardCommentDataSync(ylc.e r2) {
        if (r2 == null) goto L5;
        VSMsgBoardCommentListSyncDataModel r3 = dc2.b.a(r2, VSMsgBoardDataContext$initMsgBoardCommentDataSync$commentListSyncDataModel$1.INSTANCE);
        getCommentListDataSyncModel().d(r3);
        return;
    }

    private final void reqCommentLikeData(DataCenter r9) {
        if (fq1.t.a().isLogin() == true) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        return;
    L7:
        updateReplayStatus();
        IRoom r0 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r9);
        Episode r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r9);
        JSONObject r2 = new JSONObject();
        r2.put("scene", "get_thumbup_status");
        JSONObject r3 = new JSONObject();
        fq1.s r4 = fq1.t.a();
        String r5 = null;
        if (r4 == null) goto L10;
        String r6 = r4.getCurrentUserId();
    L11:
        r3.put("uid", r6);
        if (isReplay() == false) goto L14;
        long r7 = r1.roomId;
    L15:
        r3.put("room_id", r7);
        if (isReplay() == false) goto L18;
        String r8 = EpisodeExtKt.getOwnerIdString(r1);
    L24:
        r3.put("anchor_uid", r8);
        Unit r10 = Unit.INSTANCE;
        r2.put("params", r3);
        IVSMessageBoardApi r11 = (IVSMessageBoardApi) com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().getService(IVSMessageBoardApi.class);
        long r13 = 0;
        if (isReplay() == false) goto L30;
        if (r1 == null) goto L33;
        EpisodeBasicInfo r14 = r1.episodeBasicInfo;
        if (r14 == null) goto L33;
        r13 = r14.getOriginEpisodeId();
    L33:
        ((ObservableSubscribeProxy) r11.getCommentLikeList(r13, r2.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r9.lifecycleOwner))).subscribe(new c(this), d.a);
        return;
    L30:
        IEpisodeExtraInfo r15 = r0.getEpisodeExtra();
        if (r15 == null) goto L33;
        r13 = r15.getId();
        goto L33
    L18:
        IBaseUser r16 = r0.getOwner();
        if (r16 == null) goto L21;
        r5 = r16.getIdString();
    L21:
        if (r5 != null) goto L23;
        r8 = BuildConfig.FLAVOR;
        goto L24
    L23:
        r8 = r5;
        goto L24
    L14:
        r7 = r0.getRoomId();
        goto L15
    L10:
        r6 = null;
        goto L11
    }

    public void setEpisode(Episode r1) {
        this.episode = r1;
    }

    public void setPaidEntityIds(Set<String> r1) {
        this.paidEntityIds = r1;
    }

    public void setPaidStatusChanged(boolean r1) {
        this.paidStatusChanged = r1;
    }

    public void setPayScheme(String r1) {
        this.payScheme = r1;
    }

    public void setReplay(boolean r1) {
        this.isReplay = r1;
    }

    public void setRequestDressAlready(boolean r1) {
        this.requestDressAlready = r1;
    }

    public void setRequestDressInfoFailed(boolean r1) {
        this.requestDressInfoFailed = r1;
    }

    public void setRoom(IRoom r1) {
        this.room = r1;
    }

    public void setVsMsgBoardDressInfo(String r1) {
        this.vsMsgBoardDressInfo = r1;
    }

    public void setVsMsgSelfCommentData(List<String> r1) {
        this.vsMsgSelfCommentData = r1;
    }

    public Set<String> updatePaidStatus(com.bytedance.android.livesdk.chatroom.msgboard.b r7) {
        if (r7 == null) goto L19;
        List r1 = r7.c();
        if (r1 == null) goto L19;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        VSMsgBoardDress r3 = (VSMsgBoardDress) r2.next();
        if (r3.getHasPaid() == 1) goto L15;
        if (r3.getHasPaid() == 0) goto L15;
        if (r3.isFree() == false) goto L8;
    L15:
        Set<String> r4 = getPaidEntityIds();
        if (r4 != null) goto L18;
        r4 = new LinkedHashSet();
    L18:
        r4.add(String.valueOf(r3.getEntityId()));
    L19:
        if (r7 == null) goto L36;
        List r8 = r7.a();
        if (r8 == null) goto L36;
        Iterator r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L36;
        VSMsgBoardDress r5 = (VSMsgBoardDress) r9.next();
        if (r5.getHasPaid() == 1) goto L31;
        if (r5.getHasPaid() == 0) goto L31;
        if (r5.isFree() == false) goto L24;
    L31:
        Set<String> r6 = getPaidEntityIds();
        if (r6 != null) goto L34;
        r6 = new LinkedHashSet();
    L34:
        r6.add(String.valueOf(r5.getEntityId()));
    L36:
        return getPaidEntityIds();
    }

    public final void init(boolean r5, DataCenter r6, ylc.e r7) {
        updateReplayStatus();
        String r8 = null;
        if (r6 == null) goto L5;
        IRoom r0 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r6);
    L6:
        setRoom(r0);
        if (r6 == null) goto L9;
        Episode r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r6);
    L10:
        setEpisode(r1);
        reqCommentLikeData(r6);
        initMsgBoardCommentDataSync(r7);
        initInputPanelConfig(r6);
        nm1.e r9 = pm1.f.c();
        if (r9 == null) goto L15;
        ReplayDataContext r10 = r9.h(r6);
        if (r10 == null) goto L15;
        com.bytedance.live.datacontext.j r11 = r10.getVsMsgBoardDataContext();
    L17:
        if (r11 != null) goto L38;
        if (r6 == null) goto L58;
        IRoom r13 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r6);
        if (r13 == null) goto L58;
        ILiveToolbarData r14 = r13.getToolbarData();
        if (r14 == null) goto L58;
        List r15 = r14.getToolbarDataList();
        if (r15 == null) goto L58;
        Iterator r16 = r15.iterator();
    L27:
        if (r16.hasNext() == false) goto L34;
        Object r17 = r16.next();
        if (((IToolbarComponentData) r17).getId() != 27) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == false) goto L27;
    L35:
        IToolbarComponentData r18 = (IToolbarComponentData) r17;
        if (r18 == null) goto L58;
        r8 = r18.getExtraData();
        goto L58
    L31:
        r2 = false;
        goto L32
    L34:
        r17 = null;
    L58:
        getExtra().d(r8);
        return;
    L38:
        if (r6 == null) goto L58;
        Episode r19 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r6);
        if (r19 == null) goto L58;
        List r20 = r19.getPannelToolbarList();
        if (r20 == null) goto L58;
        Iterator r21 = r20.iterator();
    L45:
        if (r21.hasNext() == false) goto L52;
        Object r23 = r21.next();
        if (((IVSToolbarConfigData) r23).getToolbarType() != 12) goto L49;
        boolean r3 = true;
    L50:
        if (r3 == false) goto L45;
    L53:
        IVSToolbarConfigData r24 = (IVSToolbarConfigData) r23;
        if (r24 == null) goto L58;
        IMainVSToolbarConfigData r25 = r24.castToOrNull(IMainVSToolbarConfigData.class);
        if (r25 == null) goto L58;
        r8 = r25.getExtra();
        goto L58
    L49:
        r3 = false;
        goto L50
    L52:
        r23 = null;
    L15:
        r11 = null;
        goto L17
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }
}
