package com.bytedance.android.livesdk.chatroom.vs_base.player;

import am2.a0;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.api.ReplayListApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.h;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.SeasonBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ShowExperienceInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisodeKt;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.bpea.cert.token.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;
import mq1.e0;
import mq1.p;
import mq1.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fH\u0016J\u0016\u0010%\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0$\u0018\u00010#H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020'H\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\u0012\u0010,\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010.\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u0010\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\"\u00107\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00142\b\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020'0>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020'0>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020'0>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010@R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010@R\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/player/ReplayPlayManageService;", "Lmq1/p;", "Lmq1/b;", "", "updateReplaySwitchListeners", "stopCurrentVideo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "newPlayItem", "refreshData", "refreshDataContext", "refreshVideoSession", "episode", "refreshRoomLog", "Landroid/content/Context;", "context", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/ReplayDataContext;", "dataContext", "Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/h;", "videoSession", "onStartRoom", "", "id", "switchPlayVideo", "", "autoPlayNext", "playNext", "nextReplayItem", "callback", "autoEmitWhenRegisted", "registerReplayListListener", "unregisterReplayListListener", "Lio/reactivex/Observable;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeGroup;", "getPlayList", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "getMoreReplayList", "getAllEpisodeList", "Lmq1/e0;", "registerReplaySwitchListener", "unregisterReplaySwitchListener", "skipEpisodeIdCheck", "refreshReplayList", "refreshItem", "playList", "onListDataChanged", "", "error", "onPullDataFailed", "tryLoadingMoreReplay", "ticketId", "parentTicketId", "Lmq1/a;", "onGetNoneData", "tryLoadSeriesList", "isLoadingMore", BuildConfig.BUILD_TYPE, "hasMoreData", "Ltq1/b;", "playListProvider", "Ltq1/b;", "", "mReplaySwitchListeners", "Ljava/util/Set;", "mTempAddSwitchListeners", "mTempRemoveSwitchListeners", "mPlayListListeners", "mRoomId", "J", "mEpisodeId", "mContext", "Landroid/content/Context;", "mDataContext", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/ReplayDataContext;", "mVideoSession", "Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/h;", "", "lastCursor", "I", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPlayManageService implements p, mq1.b {
    private DataCenter dataCenter;
    private int lastCursor;
    private Context mContext;
    private ReplayDataContext mDataContext;
    private long mEpisodeId;
    private Set<mq1.b> mPlayListListeners;
    private Set<e0> mReplaySwitchListeners;
    private long mRoomId;
    private Set<e0> mTempAddSwitchListeners;
    private Set<e0> mTempRemoveSwitchListeners;
    private h mVideoSession;
    private tq1.b playListProvider;

    public static final class a implements mq1.a {
        public final /* synthetic */ ReplayPlayManageService a;
        public final /* synthetic */ Episode b;

        @Override // mq1.a
        public final void a() {
            this.a.tryLoadingMoreReplay(this.b);
        }

        public a(ReplayPlayManageService r1, Episode r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    private final void stopCurrentVideo() {
        DataCenter r0 = this.dataCenter;
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L9;
        r1.r(true);
        return;
    L9:
        return;
    }

    private final void updateReplaySwitchListeners() {
        this.mReplaySwitchListeners.addAll(this.mTempAddSwitchListeners);
        this.mTempAddSwitchListeners.clear();
        this.mReplaySwitchListeners.removeAll(this.mTempRemoveSwitchListeners);
        this.mTempRemoveSwitchListeners.clear();
    }

    @Override // mq1.p
    public List<EpisodeGroup> getAllEpisodeList() {
        ArrayList r0 = new ArrayList();
        tq1.b r1 = this.playListProvider;
        if (r1 == null) goto L18;
        List<EpisodeGroup> r2 = r1.e;
        if (r2 == null) goto L18;
        ArrayList r4 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        Object r5 = r3.next();
        List r6 = ((EpisodeGroup) r5).episodes;
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L8;
        r4.add(r5);
        goto L8
    L12:
        if (r6.isEmpty() == true) goto L14;
        r7 = true;
        goto L15
    L17:
        r0.addAll(r4);
    L18:
        tq1.b r8 = this.playListProvider;
        if (r8 == null) goto L36;
        NextLiveData<List<EpisodeGroup>> r9 = r8.a;
        if (r9 == null) goto L36;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L36;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L26:
        if (r12.hasNext() == false) goto L35;
        Object r13 = r12.next();
        List r14 = ((EpisodeGroup) r13).episodes;
        if (r14 != null) goto L30;
    L32:
        boolean r15 = false;
    L33:
        if (r15 == false) goto L26;
        r11.add(r13);
        goto L26
    L30:
        if (r14.isEmpty() == true) goto L32;
        r15 = true;
        goto L33
    L35:
        r0.addAll(r11);
    L36:
        return r0;
    }

    @Override // mq1.p
    public NextLiveData<List<EpisodeGroup>> getMoreReplayList() {
        tq1.b r0 = this.playListProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // mq1.p
    public Observable<List<EpisodeGroup>> getPlayList() {
        tq1.b r0 = this.playListProvider;
        if (r0 != null) goto L5;
    L15:
        if (r0 == null) goto L19;
        Observable<List<EpisodeGroup>> r1 = r0.c();
        if (r1 == null) goto L19;
        return r1;
    L19:
        return Observable.error(new Throwable("playListProvider is null"));
    L5:
        if (r0.c != true) goto L15;
        if (r0 == null) goto L8;
        Throwable r2 = r0.d;
    L9:
        if (r2 != null) goto L15;
        if (r0 == null) goto L13;
        List<EpisodeGroup> r3 = r0.e;
        if (r3 == null) goto L13;
    L20:
        return Observable.just(r3);
    L13:
        r3 = CollectionsKt.emptyList();
        goto L20
    L8:
        r2 = null;
        goto L9
    }

    @Override // mq1.p
    public boolean hasMoreData() {
        tq1.b r0 = this.playListProvider;
        if (r0 == null) goto L8;
        NextLiveData<Boolean> r1 = r0.h;
        if (r1 == null) goto L8;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L8;
    L10:
        return !r2.booleanValue();
    L8:
        r2 = Boolean.FALSE;
        goto L10
    }

    @Override // mq1.p
    public boolean isLoadingMore() {
        tq1.b r0 = this.playListProvider;
        if (r0 == null) goto L9;
        NextLiveData<Boolean> r1 = r0.g;
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    @Override // mq1.p
    public Episode nextReplayItem() {
        tq1.b r0 = this.playListProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(this.mEpisodeId);
    }

    @Override // mq1.p
    public void refreshReplayList() {
        tq1.b r0 = this.playListProvider;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // mq1.p
    public void release() {
        this.mTempRemoveSwitchListeners.clear();
        this.mTempAddSwitchListeners.clear();
        this.mReplaySwitchListeners.clear();
        this.mPlayListListeners.clear();
        this.mContext = null;
        this.mDataContext = null;
        this.mVideoSession = null;
    }

    public ReplayPlayManageService(DataCenter r1) {
        this.dataCenter = r1;
        this.mReplaySwitchListeners = new LinkedHashSet();
        this.mTempAddSwitchListeners = new LinkedHashSet();
        this.mTempRemoveSwitchListeners = new LinkedHashSet();
        this.mPlayListListeners = new LinkedHashSet();
    }

    private final void refreshData(Episode r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        fq1.a r0 = fq1.b.a();
        Episode r1 = null;
        if (r0 == null) goto L47;
        Intrinsics.checkNotNullParameter(r8, "newPlayItem");
        Episode r2 = r0.a;
        if (r2 == null) goto L47;
        r2.setId(r8.getId());
        r2.idStr = r8.idStr;
        r2.setPlayVideoModel(r8.video);
        r2.setCover(r8.cover());
        r2.title = r8.title();
        r2.share = r8.share;
        r2.period = r8.period;
        r2.episodeStatus = r8.episodeStatus;
        r2.episodeWatchInfo = r8.episodeWatchInfo;
        r2.background = r8.background;
        r2.releaseTime = r8.releaseTime;
        r2.watchPeriodTextV2 = r8.watchPeriodTextV2;
        r2.currentPeriod = r8.currentPeriod;
        r2.startHighLight = r8.startHighLight;
        r2.highLightFirst = r8.highLightFirst;
        r2.mCommentConfig = r8.mCommentConfig;
        r2.episodeMod = r8.episodeMod;
        r2.episodeBasicInfo = r8.episodeBasicInfo;
        r2.style = r8.style;
        if (r.d().isSaas() == true) goto L11;
        r2.castTo(IMainEpisode.class).setReplayPaidInfo(r8.castTo(IMainEpisode.class).getReplayPaidInfo());
        r2.castTo(IMainEpisode.class).setPrivilegeInfo(r8.castTo(IMainEpisode.class).getPrivilegeInfo());
    L11:
        IRoomAuthStatus r3 = r8.getRoomAuthStatus();
        if (r3 == null) goto L16;
        long r4 = r3.getDownloadVideo();
        IRoomAuthStatus r5 = r2.getRoomAuthStatus();
        if (r5 == null) goto L16;
        r5.setDownloadVideo(r4);
    L16:
        IRoomAuthStatus r6 = r2.getRoomAuthStatus();
        long r7 = 2;
        if (r6 == null) goto L23;
        IRoomAuthStatus r9 = r8.getRoomAuthStatus();
        if (r9 == null) goto L21;
        long r10 = r9.getCastScreen();
    L22:
        r6.setCastScreen(r10);
        goto L23
    L21:
        r10 = 2;
    L23:
        IRoomAuthStatus r11 = r2.getRoomAuthStatus();
        if (r11 == null) goto L29;
        IRoomAuthStatus r12 = r8.getRoomAuthStatus();
        if (r12 == null) goto L28;
        r7 = r12.getCastScreenExplicit();
    L28:
        r11.setCastScreenExplicit(r7);
    L29:
        IRoomAuthStatus r13 = r2.getRoomAuthStatus();
        if (r13 == null) goto L40;
        IRoomAuthStatus.IRoomAuthSpecialStyle r14 = r13.getRoomAuthSpecialStyle();
        if (r14 == null) goto L40;
        IRoomAuthStatus r15 = r8.getRoomAuthStatus();
        if (r15 == null) goto L38;
        IRoomAuthStatus.IRoomAuthSpecialStyle r16 = r15.getRoomAuthSpecialStyle();
        if (r16 == null) goto L38;
        IRoomAuthStatusStyle r17 = r16.getCastScreenAuth();
    L39:
        r14.setCastScreenAuth(r17);
    L38:
        r17 = null;
    L40:
        ShowExperienceInfo r18 = r2.showExperienceInfo;
        if (r18 == null) goto L47;
        ShowExperienceInfo r19 = r8.showExperienceInfo;
        if (r19 == null) goto L45;
        int r20 = r19.xiGuaTvCastConfig;
    L46:
        r18.xiGuaTvCastConfig = r20;
        goto L47
    L45:
        r20 = 0;
    L47:
        refreshDataContext(r8);
        refreshVideoSession(r8);
        DataCenter r21 = this.dataCenter;
        if (r21 == null) goto L56;
        ReplayDataContext r22 = this.mDataContext;
        if (r22 == null) goto L54;
        n<Episode> r23 = r22.getEpisode();
        if (r23 == null) goto L54;
        r1 = (Episode) r23.getValue();
    L54:
        r21.put("data_vs_episode_data", r1);
        return;
    }

    private final void refreshDataContext(Episode r15) {
        ReplayDataContext r16 = this.mDataContext;
        vlc.d r0 = null;
        if (r16 == null) goto L11;
        n<Episode> r17 = r16.getEpisode();
        if (r17 == null) goto L11;
        fq1.a r1 = fq1.b.a();
        if (r1 == null) goto L9;
        Episode r2 = r1.a;
    L10:
        r17.setValue(r2);
        goto L11
    L9:
        r2 = null;
    L11:
        fq1.a r18 = fq1.b.a();
        if (r18 == null) goto L16;
        Episode r19 = r18.a;
        if (r19 == null) goto L16;
        refreshRoomLog(r19);
    L16:
        ReplayDataContext r110 = this.mDataContext;
        long r3 = 0;
        if (r110 == null) goto L21;
        m<Long> r111 = r110.getTotalStopTime();
        if (r111 == null) goto L21;
        r111.setValue(0L);
    L21:
        ReplayDataContext r112 = this.mDataContext;
        if (r112 == null) goto L28;
        n<vlc.d> r113 = r112.getSeekMessageManager();
        if (r113 == null) goto L28;
        vlc.d r114 = (vlc.d) r113.getValue();
        if (r114 == null) goto L28;
        r114.release();
    L28:
        ReplayDataContext r115 = this.mDataContext;
        if (r115 == null) goto L61;
        n<vlc.d> r116 = r115.getSeekMessageManager();
        if (r116 == null) goto L61;
        Context r4 = this.mContext;
        if (r4 == null) goto L60;
        xq1.a r5 = xq1.b.b();
        DataCenter r6 = this.dataCenter;
        ReplayDataContext r7 = this.mDataContext;
        if (r7 == null) goto L41;
        n<Episode> r8 = r7.getEpisode();
        if (r8 == null) goto L41;
        Episode r9 = (Episode) r8.getValue();
        if (r9 == null) goto L41;
        long r10 = r9.roomId;
    L42:
        ReplayDataContext r11 = this.mDataContext;
        if (r11 == null) goto L49;
        n<Episode> r12 = r11.getEpisode();
        if (r12 == null) goto L49;
        Episode r13 = (Episode) r12.getValue();
        if (r13 == null) goto L49;
        long r14 = r13.getId();
    L50:
        int r117 = EpisodeMod.EpisodeStageType.REPLAY;
        ReplayDataContext r20 = this.mDataContext;
        if (r20 == null) goto L59;
        n<Episode> r21 = r20.getEpisode();
        if (r21 == null) goto L59;
        Episode r22 = (Episode) r21.getValue();
        if (r22 == null) goto L59;
        String r23 = r22.seasonId;
        if (r23 == null) goto L59;
        r3 = CastLongProtector.parseLong(r23);
    L59:
        r0 = r5.provideSeekMessageManager(r4, r6, false, r10, r14, r117, r3);
    L49:
        r14 = 0;
    L41:
        r10 = 0;
    L60:
        r116.setValue(r0);
    L61:
        ReplayDataContext r118 = this.mDataContext;
        if (r118 == null) goto L67;
        m<Integer> r119 = r118.getSeekType();
        if (r119 == null) goto L68;
        r119.setValue(-1);
        return;
    L68:
        return;
    }

    private final void refreshRoomLog(Episode r3) {
        DataCenter r0 = this.dataCenter;
        if (r0 == null) goto L8;
        o r1 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r0).c(a0.class);
        if (r1 == null) goto L9;
        int r2 = a0.L;
        a0 r4 = a0.a.a(r3);
        r4.h = true;
        Unit r5 = Unit.INSTANCE;
        r1.setData(r4);
        return;
    L9:
        return;
    }

    private final void refreshVideoSession(Episode r5) {
        h r0 = this.mVideoSession;
        if (r0 == null) goto L12;
        r0.q = r5.getPlayVideoModel();
        r0.r = r5.getPlayVideoId();
        r0.k = false;
        r0.w = r5.getId();
        ReplayDataContext r6 = this.mDataContext;
        if (r6 == null) goto L9;
        n<Episode> r7 = r6.getEpisode();
        if (r7 == null) goto L9;
        Episode r8 = (Episode) r7.getValue();
    L10:
        r0.b(r8);
        r0.l = false;
        r0.n = false;
        r0.o = false;
        return;
    L9:
        r8 = null;
        goto L10
    }

    @Override // mq1.b
    public void onListDataChanged(List<? extends EpisodeGroup> r3) {
        Iterator<mq1.b> r0 = this.mPlayListListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onListDataChanged(r3);
        goto L4
    }

    @Override // mq1.b
    public void onPullDataFailed(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        Iterator<mq1.b> r0 = this.mPlayListListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPullDataFailed(r3);
        goto L4
    }

    @Override // mq1.p
    public void playNext(final boolean r9) {
        boolean r2 = true;
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.d == 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L15:
        tq1.b r10 = this.playListProvider;
        IReplayInnerProgressService r1 = null;
        if (r10 == null) goto L28;
        Episode r11 = r10.a(this.mEpisodeId);
        if (r11 == null) goto L28;
        if (r11.getId() != this.mEpisodeId) goto L23;
        r2 = false;
    L23:
        if (r2 == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L28;
        switchPlayVideo(r11, false);
        return;
    L28:
        t r12 = s.e();
        if (r12 == null) goto L31;
        r1 = r12.provideVSProgressService(this.dataCenter);
    L31:
        if (r1 == null) goto L36;
        r1.resume();
        return;
    L36:
        return;
    L8:
        if (r9 == true) goto L10;
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.a();
        fq1.r.a().d("ReplayPlayManageService", "scheduleClose enable, but isNotAutoPlay continue playNext");
        goto L15
    L10:
        fq1.r.a().d("ReplayPlayManageService", "scheduleClose enable, skip playNext");
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f = new AnonymousClass1(this, r9);
        com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.a();
        Iterator r13 = ((ArrayList) com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.a).iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        ((com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.InterfaceC0088a) r13.next()).d();
        goto L12
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // mq1.p
    public void refreshItem(Episode r13) {
        tq1.b r0 = this.playListProvider;
        if (r0 == null) goto L30;
        int r1 = ((ArrayList) r0.e).size();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L38;
        List r4 = ((EpisodeGroup) ListProtector.get(r0.e, r3)).episodes;
        if (r4 == null) goto L22;
        Iterator r5 = r4.iterator();
        int r6 = 0;
    L10:
        if (r5.hasNext() == false) goto L20;
        long r7 = ((Episode) r5.next()).getId();
        if (r13 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == true) goto L21;
        r6 = r6 + 1;
    L21:
        Integer r9 = Integer.valueOf(r6);
    L23:
        if (r9 == null) goto L29;
        if (r9.intValue() <= 0) goto L29;
        if (r9.intValue() >= r0.b().size()) goto L29;
        ListProtector.set(r4, r9.intValue(), r13);
    L29:
        r3 = r3 + 1;
        goto L5
    L14:
        if (r7 != r13.getId()) goto L16;
        r8 = true;
        goto L17
    L20:
        r6 = -1;
        goto L21
    L22:
        r9 = null;
        goto L23
    L38:
        return;
    }

    public void switchPlayVideo(long r8) {
        tq1.b r0 = this.playListProvider;
        Episode r2 = null;
        Object r3 = null;
        if (r0 == null) goto L14;
        Iterator<T> r1 = r0.b().iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r4 = r1.next();
        if (((Episode) r4).getId() != r8) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
        r3 = r4;
        goto L13
    L10:
        r5 = false;
    L13:
        r2 = (Episode) r3;
    L14:
        switchPlayVideo(r2, false);
    }

    @Override // mq1.p
    public void tryLoadingMoreReplay(Episode r20) {
        Intrinsics.checkNotNullParameter(r20, "episode");
        tq1.b r3 = this.playListProvider;
        if (r3 == null) goto L34;
        Intrinsics.checkNotNullParameter(r20, "episode");
        Boolean r1 = (Boolean) r3.g.getValue();
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r4) == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual((Boolean) r3.h.getValue(), r4) == false) goto L10;
        return;
    L10:
        if (r3.i == true) goto L37;
        r3.g.setValue(r4);
        ReplayListApi r5 = (ReplayListApi) r.n().getService(ReplayListApi.class);
        String r2 = r20.seasonId;
        if (r2 == null) goto L15;
        long r6 = CastLongProtector.parseLong(r2);
    L16:
        long r7 = r20.getId();
        long r10 = r3.b;
        if (r20.isMatchEpisode() == false) goto L19;
        long r12 = 1;
    L20:
        long r13 = r12;
        IMainEpisode r8 = r20.castToOrNull(IMainEpisode.class);
        if (r8 == null) goto L23;
        String r15 = IMainEpisodeKt.getOwnerUserIdStr(r8);
    L24:
        IMainEpisode r9 = r20.castToOrNull(IMainEpisode.class);
        if (r9 == null) goto L27;
        String r16 = IMainEpisodeKt.getOwnerUserIdStr(r9);
    L28:
        SeasonBasicInfo r11 = r20.seasonBasicInfo;
        if (r11 == null) goto L31;
        Integer r17 = r11.getSeasonType();
    L32:
        r3.f.add(r5.getMorePlayList(r6, r7, false, r10, 10, r13, r15, r16, r17, Long.valueOf(r20.roomId)).compose(RxUtil.rxSchedulerHelper()).subscribe(new tq1.e(r3), new tq1.f(r3)));
        return;
    L31:
        r17 = null;
        goto L32
    L27:
        r16 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r12 = 2;
        goto L20
    L15:
        r6 = 0;
        goto L16
    L37:
        return;
    }

    @Override // mq1.p
    public void unregisterReplayListListener(mq1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mPlayListListeners.remove(r2);
    }

    @Override // mq1.p
    public void unregisterReplaySwitchListener(e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mTempRemoveSwitchListeners.remove(r2);
    }

    @Override // mq1.p
    public void registerReplayListListener(mq1.b r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r4 == false) goto L17;
        tq1.b r5 = this.playListProvider;
        if (r5 == null) goto L17;
        if (r5.c != true) goto L17;
        List<EpisodeGroup> r0 = null;
        if (r5 == null) goto L11;
        Throwable r1 = r5.d;
    L12:
        if (r1 == null) goto L14;
        r3.onPullDataFailed(r1);
        goto L17
    L14:
        if (r5 == null) goto L16;
        r0 = r5.e;
    L16:
        r3.onListDataChanged(r0);
        goto L17
    L11:
        r1 = null;
    L17:
        this.mPlayListListeners.add(r3);
    }

    @Override // mq1.p
    public void registerReplaySwitchListener(e0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r4 == false) goto L11;
        ReplayDataContext r0 = this.mDataContext;
        if (r0 == null) goto L9;
        n<Episode> r1 = r0.getEpisode();
        if (r1 == null) goto L9;
        Episode r2 = (Episode) r1.getValue();
    L10:
        r3.FY(new tq1.g(r2, 0));
    L9:
        r2 = null;
    L11:
        this.mTempAddSwitchListeners.add(r3);
    }

    @Override // mq1.p
    public void switchPlayVideo(Episode r7, boolean r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = com.bytedance.android.livesdk.chatroom.vs_base.log.e.a;
        DataCenter r1 = this.dataCenter;
        String r2 = String.valueOf(r7.getId());
        Intrinsics.checkNotNullParameter(r2, "episodeId");
        boolean r3 = true;
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r1).e("livesdk_replay_replace_video_stream", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("episode_id", r2)}), new Object[0]);
    L7:
        if (r8 == true) goto L11;
        if (this.mEpisodeId != r7.getId()) goto L11;
        return;
    L11:
        if (r7.getId() <= 0) goto L63;
        int r9 = r7.style;
        ReplayDataContext r4 = this.mDataContext;
        if (r4 == null) goto L22;
        n<Episode> r5 = r4.getEpisode();
        if (r5 == null) goto L22;
        Episode r6 = (Episode) r5.getValue();
        if (r6 == null) goto L22;
        if (r9 != r6.style) goto L22;
    L33:
        int r10 = 0;
    L34:
        this.mEpisodeId = r7.getId();
        if (this.playListProvider == null) goto L37;
        Intrinsics.checkNotNullParameter(r7, "newPlayItem");
    L37:
        updateReplaySwitchListeners();
        Iterator<e0> r11 = this.mReplaySwitchListeners.iterator();
    L39:
        if (r11.hasNext() == false) goto L41;
        r11.next().qj();
        goto L39
    L41:
        DataCenter r12 = this.dataCenter;
        if (r12 == null) goto L44;
        r12.put("cmd_replay_widget_refreshed", Boolean.FALSE);
    L44:
        refreshData(r7);
        d0 r13 = ReplayRoomFragmentScopeUtil.b();
        if (r13 != null) goto L47;
    L51:
        ReplayDataContext r14 = this.mDataContext;
        if (r14 == null) goto L56;
        m<Boolean> r15 = r14.getHasSwitched();
        if (r15 == null) goto L56;
        r15.setValue(Boolean.TRUE);
    L56:
        ALogger.e("ReplayPlayManageService", "switchPlayVideo listener size" + this.mReplaySwitchListeners.size());
        Iterator<e0> r16 = this.mReplaySwitchListeners.iterator();
    L58:
        if (r16.hasNext() == false) goto L60;
        r16.next().FY(new tq1.g(r7, Integer.valueOf(r10)));
        goto L58
    L60:
        return;
    L47:
        if (r7.style != 2) goto L50;
        r3 = false;
    L50:
        r13.d(r3);
    L22:
        if (r7.style != 2) goto L24;
        r10 = 1;
        goto L34
    L24:
        ReplayDataContext r17 = this.mDataContext;
        if (r17 == null) goto L33;
        n<Episode> r18 = r17.getEpisode();
        if (r18 == null) goto L33;
        Episode r19 = (Episode) r18.getValue();
        if (r19 == null) goto L33;
        if (r19.style != 2) goto L33;
        r10 = 2;
        goto L34
    }

    public void tryLoadSeriesList(long r10, long r12, mq1.a r14) {
        tq1.b r0 = this.playListProvider;
        if (r0 == null) goto L9;
        Boolean r1 = (Boolean) r0.g.getValue();
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == true) goto L10;
        r0.g.setValue(r2);
        Disposable r11 = ((ReplayListApi) r.n().getService(ReplayListApi.class)).getSeriesReplayList(r0.j, r10, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new tq1.c(r0, r14), new tq1.d(r0));
        r0.f.add(r11);
        return;
    L10:
        return;
    }

    @Override // mq1.p
    public void onStartRoom(Episode r13, Context r14, ReplayDataContext r15, h r16) {
        Intrinsics.checkNotNullParameter(r13, "episode");
        Intrinsics.checkNotNullParameter(r16, "videoSession");
        this.mRoomId = r13.roomId;
        long r0 = r13.getId();
        this.mEpisodeId = r0;
        if (this.mRoomId <= 0) goto L5;
    L7:
        this.mContext = r14;
        this.playListProvider = new tq1.b(this.mRoomId, this.mEpisodeId, this);
        this.mVideoSession = r16;
        this.mDataContext = r15;
        IMainEpisode r1 = r13.castToOrNull(IMainEpisode.class);
        if (r1 == null) goto L14;
        ReplayPaidInfo r2 = r1.getReplayPaidInfo();
        if (r2 == null) goto L14;
        TicketData r3 = r2.getTicketData();
        if (r3 == null) goto L14;
        long r4 = r3.getParentTicketSessionId();
    L15:
        IMainEpisode r5 = r13.castToOrNull(IMainEpisode.class);
        if (r5 == null) goto L22;
        ReplayPaidInfo r6 = r5.getReplayPaidInfo();
        if (r6 == null) goto L22;
        TicketData r7 = r6.getTicketData();
        if (r7 == null) goto L22;
        long r8 = r7.getTicketId();
    L24:
        if (r4 == 0) goto L26;
        tryLoadSeriesList(r8, r4, new a(this, r13));
        return;
    L26:
        tryLoadingMoreReplay(r13);
        return;
    L22:
        r8 = 0;
    L14:
        r4 = 0;
        goto L15
    L5:
        if (r0 > 0) goto L7;
    }
}
