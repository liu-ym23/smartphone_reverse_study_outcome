package com.bytedance.android.live.liveinteract.voicechat.match.viewmodel;

import am2.x;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.FastMatchV2ResultItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.api.ChatApi;
import com.bytedance.android.live.liveinteract.voicechat.match.logger.ChatMatchFailReason;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.model.c1;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.i1;
import com.bytedance.android.livesdk.config.x21;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\\\u001a\u00020[¢\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0002J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\bJ&\u0010\u0012\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R(\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00106R(\u00107\u001a\b\u0012\u0004\u0012\u00020\b0,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010.\u001a\u0004\b8\u00100\"\u0004\b9\u00106R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b:\u00100R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0,8\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b;\u00100R(\u0010=\u001a\b\u0012\u0004\u0012\u00020<0,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010.\u001a\u0004\b>\u00100\"\u0004\b?\u00106R(\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010.\u001a\u0004\b@\u00100\"\u0004\bA\u00106R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\bB\u00100\"\u0004\bC\u00106R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010DR\"\u0010E\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010'\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010'\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R\u001a\u0010K\u001a\u00020J8\u0006X\u0086D¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010'R\u0016\u0010P\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010LR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010SR\"\u0010V\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010'\u001a\u0004\bV\u0010)\"\u0004\bW\u0010+R\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0017\u0010\\\u001a\u00020[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_¨\u0006d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/viewmodel/ChatMatchViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "", "dismissMatchDialog", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", PbRequest.SwitchType.ROOM, "", "rematch", "", "matchType", "fastMatch", "Lcom/bytedance/android/livesdk/chatroom/model/b1;", "fastMatchData", "getMatchResultTags", "startWait", "fromApplyReason", "showMatchDialog", "loadShakeSetting", "startMatch", "startAutoDismissCount", "stopAutoDismissCount", "stopMatch", BuildConfig.BUILD_TYPE, "reset", "getUserWaitingRankPosition", "prepareApply", "prepareApplyCancel", "", "requestId", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/FastMatchV2ResultItem;", "matchResultList", "Ljava/util/List;", "hasMatchSuccessOrFail", "Z", "getHasMatchSuccessOrFail", "()Z", "setHasMatchSuccessOrFail", "(Z)V", "Landroidx/lifecycle/MutableLiveData;", "matchData", "Landroidx/lifecycle/MutableLiveData;", "getMatchData", "()Landroidx/lifecycle/MutableLiveData;", "matchingState", "getMatchingState", "matchDialogState", "getMatchDialogState", "setMatchDialogState", "(Landroidx/lifecycle/MutableLiveData;)V", "waitingCount", "getWaitingCount", "setWaitingCount", "getRematch", "getMatchType", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "getDisplayText", "setDisplayText", "isPrepareApplySuccess", "setPrepareApplySuccess", "getPrepareApplyCancel", "setPrepareApplyCancel", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "hasAutoApply", "getHasAutoApply", "setHasAutoApply", "getFromApplyReason", "setFromApplyReason", "", "waitTime", "J", "getWaitTime", "()J", "isFirst", "startMatchTime", "Lio/reactivex/disposables/Disposable;", "waitingDisposable", "Lio/reactivex/disposables/Disposable;", "intervalDisposable", "autoDismissDisposable", "isAnchor", "setAnchor", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatMatchViewModel extends DataContext {
    public static final a Companion = null;
    public static final String ENTER_METHOD_CONNECTION_MATCH_RESULT = "connection_match_result";
    public static final String ENTER_METHOD_MATCH = "match";
    public static final String ENTER_METHOD_SHAKE = "shake";
    public static final long FAST_MATCH_INTERVAL = 2;
    private static final String TAG = null;
    private Disposable autoDismissDisposable;
    private CompositeDisposable compositeDisposable;
    private final DataCenter dataCenter;
    private MutableLiveData<a5> displayText;
    private boolean fromApplyReason;
    private boolean hasAutoApply;
    private boolean hasMatchSuccessOrFail;
    private Disposable intervalDisposable;
    private boolean isAnchor;
    private boolean isFirst;
    private MutableLiveData<Boolean> isPrepareApplySuccess;
    private final MutableLiveData<b1> matchData;
    private MutableLiveData<Boolean> matchDialogState;
    private List<FastMatchV2ResultItem> matchResultList;
    private final MutableLiveData<Integer> matchType;
    private final MutableLiveData<Boolean> matchingState;
    private MutableLiveData<Boolean> prepareApplyCancel;
    private final MutableLiveData<Boolean> rematch;
    private String requestId;
    private IRoom room;
    private long startMatchTime;
    private final long waitTime;
    private MutableLiveData<Integer> waitingCount;
    private Disposable waitingDisposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ IRoom b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;

        public b(ChatMatchViewModel r1, IRoom r2, boolean r3, int r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r19) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r19;
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            int r3 = this.d;
            long r4 = this.e;
            String r6 = r1.logId;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r6, "logId");
            JSONObject r5 = new JSONObject();
            pd0.b r7 = pd0.b.a;
            r5.put("match_type", pd0.b.c(r3));
            r5.put("match_scene", "fast_match");
            TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.FastMatchApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r4), r6, r5);
            String r13 = "anchor";
            if (ChatMatchViewModel.access$isFirst$p(this.a) == false) goto L20;
            gk0.a.C0214a r8 = gk0.a.b;
            IRoom r9 = this.b;
            Integer r10 = Integer.valueOf(this.d);
            Boolean r11 = Boolean.valueOf(this.c);
            r8.getClass();
            String r12 = gk0.a.C0214a.b(r10, r11).getValue();
            Intrinsics.checkNotNullParameter(r12, "matchType");
            HashMap r14 = new HashMap();
            if (r9 != null) goto L7;
        L11:
            TalkRoomLogUtils.B0(r14, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
            r14.put("request_page", ChatMatchWidget.o);
            r14.put("match_type", r12);
            r14.put("match_enter_from", gk0.a.C0214a.a());
            if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L14;
            Object r15 = "anchor";
        L15:
            r14.put("user_type", r15);
            if (r9 == null) goto L18;
            String r16 = r9.getRequestId();
        L19:
            TalkRoomLogUtils.U0(r14, r16);
            int r17 = 0;
            j0.l().sendLog("livesdk_connection_match_apply", r14, new Object[]{r9, x.class});
            ChatMatchViewModel.access$setFirst$p(this.a, false);
        L21:
            b1 r18 = (b1) r1.data;
            if (r18 != null) goto L24;
            return;
        L24:
            if (r18.getStopMatch() == false) goto L27;
            f2.c(r18.getToast(), r17);
            this.a.stopMatch();
            return;
        L27:
            if (r18.getMatchedRoomId() > 0) goto L29;
            return;
        L29:
            if (r18.getMatchedUser() == null) goto L53;
            this.a.stopMatch();
            this.a.getMatchData().setValue(r18);
            ChatMatchViewModel.showMatchDialog$default(this.a, false, 1, null);
            ChatMatchViewModel.access$startWait(this.a, r18);
            ChatMatchViewModel.access$getMatchResultTags(this.a, r18);
            List r20 = r18.getLinkedUser();
            if (r20 == null) goto L33;
            Map<String, String> r21 = hk0.a.a;
            hk0.a.d = r20.size() - 1;
        L33:
            gk0.a.C0214a r22 = gk0.a.b;
            IRoom r23 = this.b;
            Integer r24 = Integer.valueOf(this.d);
            Boolean r25 = Boolean.valueOf(this.c);
            r22.getClass();
            String r26 = gk0.a.C0214a.b(r24, r25).getValue();
            long r27 = System.currentTimeMillis() - ChatMatchViewModel.access$getStartMatchTime$p(this.a);
            Intrinsics.checkNotNullParameter(r26, "matchType");
            HashMap r28 = new HashMap();
            if (r23 != null) goto L36;
        L40:
            TalkRoomLogUtils.B0(r28, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
            r28.put("request_page", ChatMatchWidget.o);
            r28.put("match_type", r26);
            r28.put("duration", String.valueOf(r27));
            r28.put("match_enter_from", gk0.a.C0214a.a());
            if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == true) goto L44;
            r13 = "user";
        L44:
            r28.put("user_type", r13);
            if (r23 == null) goto L47;
            String r29 = r23.getRequestId();
        L48:
            TalkRoomLogUtils.U0(r28, r29);
            int r30 = bh0.a.a;
            TalkRoomLogUtils.M0(r28, com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER, r26, false, 8);
            j0.l().sendLog("livesdk_connection_match_success", r28, new Object[]{r23, x.class});
            return;
        L47:
            r29 = null;
            goto L48
        L36:
            if (r23.isLiveTypeAudio() == false) goto L38;
            Object r110 = "voice_live";
        L39:
            r28.put("live_type", r110);
            goto L40
        L38:
            r110 = "video_live";
            goto L39
        L53:
            return;
        L18:
            r16 = null;
            goto L19
        L14:
            r15 = "user";
            goto L15
        L7:
            if (r9.isLiveTypeAudio() == false) goto L9;
            Object r31 = "voice_live";
        L10:
            r14.put("live_type", r31);
            goto L11
        L9:
            r31 = "video_live";
            goto L10
        L20:
            r17 = 0;
            goto L21
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public c(IRoom r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r1 = this.b;
            long r2 = this.c;
            r0.getClass();
            JSONObject r3 = new JSONObject();
            pd0.b r4 = pd0.b.a;
            r3.put("match_type", pd0.b.c(r1));
            r3.put("match_scene", "fast_match");
            LinkMonitorData r5 = LinkMonitorData.FastMatchApiMonitorData;
            long r7 = TalkRoomBusinessFullLinkMonitor.h(r2);
            TalkRoomBusinessFullLinkMonitor.Y(r5, r7, (Throwable) r6, r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ IRoom b;

        public d(ChatMatchViewModel r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            this.a.getDisplayText().setValue(((com.bytedance.android.livesdk.chatroom.model.interact.x) ((com.bytedance.android.live.network.response.e) r2).data).getDisplayText());
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            String r0 = ChatMatchViewModel.access$getTAG$cp();
            ALogger.w(r0, (Throwable) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r7) {
            h1 r8 = (h1) ((com.bytedance.android.live.network.response.e) r7).data;
            if (r8 == null) goto L40;
            List r9 = r8.getSettings();
            if (r9 == null) goto L48;
            Iterator<T> r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L49;
            ILinkmicAudienceSetting r0 = (ILinkmicAudienceSetting) r10.next();
            Integer r1 = r0.getKey();
            int r2 = ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_FASTMATCH_SHAKE.ordinal();
            boolean r3 = false;
            if (r1 != null) goto L13;
        L25:
            Integer r4 = r0.getKey();
            int r5 = ILinkmicAudienceSetting.LinkmicAudienceSettingKey.LIVE_ROOM_FORBIDDEN_SHAKE.ordinal();
            if (r4 == null) goto L8;
            if (r4.intValue() != r5) goto L8;
            com.bytedance.android.livesdk.sharedpref.e r6 = b6.W;
            i1 r11 = r0.getValue();
            if (r11 == null) goto L35;
            Integer r12 = r11.getLinkmicAudienceSettingValue();
            if (r12 == null) goto L35;
            int r13 = r12.intValue();
        L37:
            if (r13 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.ordinal()) goto L39;
            r3 = true;
        L39:
            Boolean r14 = Boolean.valueOf(r3);
            r6.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r6, r14);
        L35:
            r13 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal();
            goto L37
        L13:
            if (r1.intValue() != r2) goto L25;
            com.bytedance.android.livesdk.sharedpref.e r15 = b6.V;
            i1 r16 = r0.getValue();
            if (r16 == null) goto L19;
            Integer r17 = r16.getLinkmicAudienceSettingValue();
            if (r17 == null) goto L19;
            int r18 = r17.intValue();
        L21:
            if (r18 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal()) goto L23;
            boolean r19 = true;
        L24:
            Boolean r20 = Boolean.valueOf(r19);
            r15.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r15, r20);
            goto L25
        L23:
            r19 = false;
        L19:
            r18 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal();
            goto L21
        L49:
            return;
        L48:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ IRoom b;

        public h(ChatMatchViewModel r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.network.response.e) r2, "response");
            int r3 = us1.g.a;
            us1.g.a(this.a.getDataCenter(), true);
            hd0.c.f().k(1);
            this.a.isPrepareApplySuccess().setValue(Boolean.TRUE);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ IRoom b;

        public i(ChatMatchViewModel r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            ALogger.w(ChatMatchViewModel.access$getTAG$cp(), r6);
            new qh0.h(2, new ChatMatchViewModel$prepareApply$$inlined$let$lambda$2$1(this), ChatMatchViewModel$prepareApply$1$2$2.INSTANCE).c(r6);
            int r7 = us1.g.a;
            us1.g.a(this.a.getDataCenter(), false);
            hd0.c.f().k(0);
            this.a.isPrepareApplySuccess().setValue(Boolean.FALSE);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ IRoom b;

        public j(ChatMatchViewModel r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            int r4 = us1.g.a;
            us1.g.a(this.a.getDataCenter(), false);
            hd0.c.f().k(0);
            this.a.getPrepareApplyCancel().setValue(Boolean.TRUE);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ IRoom b;

        public k(ChatMatchViewModel r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            ALogger.w("ChatMatchDialog", (Throwable) r2);
            int r3 = us1.g.a;
            us1.g.a(this.a.getDataCenter(), false);
            hd0.c.f().k(0);
            this.a.getPrepareApplyCancel().setValue(Boolean.TRUE);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ Ref.IntRef b;

        public l(ChatMatchViewModel r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            Ref.IntRef r4 = this.b;
            int r0 = r4.element - 1;
            r4.element = r0;
            if (r0 != 0) goto L11;
            Disposable r5 = ChatMatchViewModel.access$getAutoDismissDisposable$p(this.a);
            if (r5 == null) goto L9;
            CompositeDisposable r1 = ChatMatchViewModel.access$getCompositeDisposable$p(this.a);
            if (r1 == null) goto L9;
            r1.remove(r5);
        L9:
            ChatMatchViewModel.access$dismissMatchDialog(this.a);
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ ChatMatchViewModel b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public m(IRoom r1, ChatMatchViewModel r2, int r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            long r0 = ((Number) vm2.d.q5.getValue(null, vm2.d.a[326(0x146, float:4.57E-43)])).longValue();
            if (((Long) r5).longValue() < r0) goto L5;
            this.b.stopMatch();
            gk0.a r6 = new gk0.a(this.a);
            gk0.a.C0214a r1 = gk0.a.b;
            Integer r2 = Integer.valueOf(this.c);
            Boolean r3 = Boolean.valueOf(this.d);
            r1.getClass();
            r6.b(gk0.a.C0214a.b(r2, r3).getValue(), ChatMatchFailReason.NO_MATCH.getValue());
            return;
        L5:
            ChatMatchViewModel.access$fastMatch(this.b, this.a, this.d, this.c);
        }
    }

    public static final class n<T> implements Consumer {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class o<T, R> implements Function {
        public final /* synthetic */ Ref.LongRef a;

        public o(Ref.LongRef r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(this.a.element - r0);
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ ChatMatchViewModel a;

        public p(ChatMatchViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.getWaitingCount().setValue(Integer.valueOf((int) r6.longValue()));
            if (r6.longValue() > 0) goto L11;
            Disposable r7 = ChatMatchViewModel.access$getWaitingDisposable$p(this.a);
            if (r7 == null) goto L9;
            CompositeDisposable r0 = ChatMatchViewModel.access$getCompositeDisposable$p(this.a);
            if (r0 == null) goto L9;
            r0.remove(r7);
        L9:
            ALogger.i("ChatMatchViewModel", "auto jump.");
            return;
        }
    }

    public final void startMatch(IRoom r7) {
        startMatch$default(this, r7, false, 0, 6, null);
    }

    public final void startMatch(IRoom r7, boolean r8) {
        startMatch$default(this, r7, r8, 0, 4, null);
    }

    static {
        Companion = new a();
        TAG = "ChatMatchViewModel";
    }

    private final void dismissMatchDialog() {
        this.matchDialogState.setValue(Boolean.FALSE);
    }

    public final void loadShakeSetting() {
        JSONArray r0 = new JSONArray();
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L5;
        IRoom r2 = (IRoom) r1.getValue();
    L6:
        CompositeDisposable r3 = this.compositeDisposable;
        if (r3 == null) goto L14;
        LinkAudienceApi r4 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r5 = r0.toString();
        if (r2 == null) goto L11;
        long r6 = r2.getId();
    L12:
        RxUtilKt.c(r4.getAudienceSettings(r5, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(f.a, g.a), r3);
        return;
    L11:
        r6 = 0;
        goto L12
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void release() {
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        reset();
    }

    public final void reset() {
        this.matchData.setValue(null);
        this.waitingCount.setValue(null);
        this.matchingState.setValue(Boolean.FALSE);
        this.hasMatchSuccessOrFail = false;
        this.requestId = null;
        this.matchResultList.clear();
    }

    public final void startAutoDismissCount() {
        Disposable r0 = this.autoDismissDisposable;
        if (r0 == null) goto L7;
        CompositeDisposable r1 = this.compositeDisposable;
        if (r1 == null) goto L7;
        r1.remove(r0);
    L7:
        Ref.IntRef r2 = new Ref.IntRef();
        int r3 = ((x21) vm2.e.b.getValue(null, vm2.e.a[0])).h2();
        r2.element = r3;
        if (r3 > 0) goto L10;
        return;
    L10:
        Disposable r4 = du2.a.b(1, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r2));
        this.autoDismissDisposable = r4;
        if (r4 == null) goto L16;
        CompositeDisposable r5 = this.compositeDisposable;
        if (r5 == null) goto L17;
        r5.add(r4);
        return;
    L17:
        return;
    }

    public final void stopAutoDismissCount() {
        Disposable r0 = this.autoDismissDisposable;
        if (r0 == null) goto L8;
        CompositeDisposable r1 = this.compositeDisposable;
        if (r1 == null) goto L9;
        r1.remove(r0);
        return;
    L9:
        return;
    }

    public final void stopMatch() {
        this.matchingState.setValue(Boolean.FALSE);
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final MutableLiveData<a5> getDisplayText() {
        return this.displayText;
    }

    public final boolean getFromApplyReason() {
        return this.fromApplyReason;
    }

    public final boolean getHasAutoApply() {
        return this.hasAutoApply;
    }

    public final boolean getHasMatchSuccessOrFail() {
        return this.hasMatchSuccessOrFail;
    }

    public final MutableLiveData<b1> getMatchData() {
        return this.matchData;
    }

    public final MutableLiveData<Boolean> getMatchDialogState() {
        return this.matchDialogState;
    }

    public final MutableLiveData<Integer> getMatchType() {
        return this.matchType;
    }

    public final MutableLiveData<Boolean> getMatchingState() {
        return this.matchingState;
    }

    public final MutableLiveData<Boolean> getPrepareApplyCancel() {
        return this.prepareApplyCancel;
    }

    public final MutableLiveData<Boolean> getRematch() {
        return this.rematch;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final long getWaitTime() {
        return this.waitTime;
    }

    public final MutableLiveData<Integer> getWaitingCount() {
        return this.waitingCount;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final MutableLiveData<Boolean> isPrepareApplySuccess() {
        return this.isPrepareApplySuccess;
    }

    public ChatMatchViewModel(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.dataCenter = r3;
        this.matchResultList = new ArrayList();
        this.matchData = new MutableLiveData();
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        Boolean r0 = Boolean.FALSE;
        r4.setValue(r0);
        Unit r1 = Unit.INSTANCE;
        this.matchingState = r4;
        MutableLiveData<Boolean> r5 = new MutableLiveData();
        r5.setValue(r0);
        this.matchDialogState = r5;
        this.waitingCount = new MutableLiveData();
        MutableLiveData<Boolean> r6 = new MutableLiveData();
        r6.setValue(r0);
        this.rematch = r6;
        MutableLiveData<Integer> r7 = new MutableLiveData();
        r7.setValue(0);
        this.matchType = r7;
        MutableLiveData<a5> r8 = new MutableLiveData();
        r8.setValue(null);
        this.displayText = r8;
        MutableLiveData<Boolean> r9 = new MutableLiveData();
        r9.setValue(r0);
        this.isPrepareApplySuccess = r9;
        MutableLiveData<Boolean> r10 = new MutableLiveData();
        r10.setValue(r0);
        this.prepareApplyCancel = r10;
        this.waitTime = 3;
        this.isFirst = true;
        this.compositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ void access$dismissMatchDialog(ChatMatchViewModel r0) {
        r0.dismissMatchDialog();
    }

    public static final /* synthetic */ Disposable access$getAutoDismissDisposable$p(ChatMatchViewModel r0) {
        return r0.autoDismissDisposable;
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(ChatMatchViewModel r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ long access$getStartMatchTime$p(ChatMatchViewModel r2) {
        return r2.startMatchTime;
    }

    public static final /* synthetic */ Disposable access$getWaitingDisposable$p(ChatMatchViewModel r0) {
        return r0.waitingDisposable;
    }

    public static final /* synthetic */ boolean access$isFirst$p(ChatMatchViewModel r0) {
        return r0.isFirst;
    }

    private final void getMatchResultTags(b1 r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        List r5 = r4.getResultTagList();
        if (r5 == null) goto L8;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        c1 r1 = (c1) r6.next();
        r0.put(r1.getTagName(), r1.getValue());
    L8:
        Map<String, String> r7 = hk0.a.a;
        Intrinsics.checkNotNullParameter(r0, "matchTags");
        hk0.a.b = r0;
    }

    private final void startWait(b1 r6) {
        Ref.LongRef r0 = new Ref.LongRef();
        long r1 = r6.getCountDownSeconds();
        r0.element = r1;
        if (r1 > 0) goto L6;
        r1 = this.waitTime;
    L6:
        r0.element = r1;
        this.waitingCount.setValue(Integer.valueOf((int) r1));
        if (this.isAnchor == false) goto L9;
        return;
    L9:
        Disposable r7 = this.waitingDisposable;
        if (r7 == null) goto L14;
        CompositeDisposable r2 = this.compositeDisposable;
        if (r2 == null) goto L14;
        r2.remove(r7);
    L14:
        Disposable r8 = du2.a.b(0, 1, TimeUnit.SECONDS).take(r0.element + 1).map(new o(r0)).compose(RxUtil.rxSchedulerHelper()).subscribe(new p(this));
        this.waitingDisposable = r8;
        if (r8 == null) goto L20;
        CompositeDisposable r3 = this.compositeDisposable;
        if (r3 == null) goto L21;
        r3.add(r8);
        return;
    L21:
        return;
    }

    public final void getUserWaitingRankPosition(IRoom r9) {
        Intrinsics.checkNotNullParameter(r9, PbRequest.SwitchType.ROOM);
        if (je0.d.f() == 0) goto L5;
        int r6 = je0.d.f();
    L6:
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L10;
        RxUtilKt.c(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getUserWaitingRankPosition(r9.getId(), tc0.c.h().getChannelId(), r6, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r9), e.a), r0);
        return;
    L10:
        return;
    L5:
        r6 = 5;
        goto L6
    }

    public final void prepareApply(IRoom r9) {
        Intrinsics.checkNotNullParameter(r9, PbRequest.SwitchType.ROOM);
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L6;
        RxUtilKt.c(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApply(r9.getId(), 4, 2, ChatMatchWidget.p ? 1 : 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r9), new i(this, r9)), r0);
        return;
    }

    public final void prepareApplyCancel(IRoom r5) {
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L6;
        RxUtilKt.c(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApplyCancel(r5.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this, r5), new k(this, r5)), r0);
        return;
    }

    public final void setAnchor(boolean r1) {
        this.isAnchor = r1;
    }

    public final void setDisplayText(MutableLiveData<a5> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.displayText = r2;
    }

    public final void setFromApplyReason(boolean r1) {
        this.fromApplyReason = r1;
    }

    public final void setHasAutoApply(boolean r1) {
        this.hasAutoApply = r1;
    }

    public final void setHasMatchSuccessOrFail(boolean r1) {
        this.hasMatchSuccessOrFail = r1;
    }

    public final void setMatchDialogState(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.matchDialogState = r2;
    }

    public final void setPrepareApplyCancel(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.prepareApplyCancel = r2;
    }

    public final void setPrepareApplySuccess(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isPrepareApplySuccess = r2;
    }

    public final void setRequestId(String r1) {
        this.requestId = r1;
    }

    public final void setWaitingCount(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.waitingCount = r2;
    }

    public final void showMatchDialog(boolean r2) {
        this.fromApplyReason = r2;
        this.matchDialogState.setValue(Boolean.TRUE);
    }

    public static final /* synthetic */ void access$getMatchResultTags(ChatMatchViewModel r0, b1 r1) {
        r0.getMatchResultTags(r1);
    }

    public static final /* synthetic */ void access$setAutoDismissDisposable$p(ChatMatchViewModel r0, Disposable r1) {
        r0.autoDismissDisposable = r1;
    }

    public static final /* synthetic */ void access$setCompositeDisposable$p(ChatMatchViewModel r0, CompositeDisposable r1) {
        r0.compositeDisposable = r1;
    }

    public static final /* synthetic */ void access$setFirst$p(ChatMatchViewModel r0, boolean r1) {
        r0.isFirst = r1;
    }

    public static final /* synthetic */ void access$setStartMatchTime$p(ChatMatchViewModel r0, long r1) {
        r0.startMatchTime = r1;
    }

    public static final /* synthetic */ void access$setWaitingDisposable$p(ChatMatchViewModel r0, Disposable r1) {
        r0.waitingDisposable = r1;
    }

    public static final /* synthetic */ void access$startWait(ChatMatchViewModel r0, b1 r1) {
        r0.startWait(r1);
    }

    public final void rematch(IRoom r2, int r3) {
        release();
        startMatch(r2, true, r3);
    }

    private final void fastMatch(IRoom r21, boolean r22, int r23) {
        long r8 = System.currentTimeMillis();
        CompositeDisposable r10 = this.compositeDisposable;
        if (r10 == null) goto L6;
        RxUtilKt.c(((ChatApi) com.bytedance.android.live.network.c.b().e(ChatApi.class)).fastMatch(r21.getId(), d5.c(r21.getOwnerUserIdString()), r21.getOwnerUserIdString(), this.isFirst, r22, r23).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r21, r22, r23, r8), new c(r21, r23, r8)), r10);
        return;
    }

    public final void startMatch(IRoom r6, boolean r7, int r8) {
        this.room = r6;
        this.rematch.setValue(Boolean.valueOf(r7));
        this.matchType.setValue(Integer.valueOf(r8));
        if (r6 == null) goto L15;
        this.matchingState.setValue(Boolean.TRUE);
        Disposable r0 = this.intervalDisposable;
        if (r0 == null) goto L9;
        CompositeDisposable r1 = this.compositeDisposable;
        if (r1 == null) goto L9;
        r1.remove(r0);
    L9:
        this.isFirst = true;
        this.startMatchTime = System.currentTimeMillis();
        Disposable r9 = du2.a.b(1, 2, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r6, this, r8, r7), n.a);
        this.intervalDisposable = r9;
        if (r9 == null) goto L16;
        CompositeDisposable r10 = this.compositeDisposable;
        if (r10 == null) goto L17;
        r10.add(r9);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static final /* synthetic */ void access$fastMatch(ChatMatchViewModel r0, IRoom r1, boolean r2, int r3) {
        r0.fastMatch(r1, r2, r3);
    }

    public static /* synthetic */ void showMatchDialog$default(ChatMatchViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.showMatchDialog(r1);
    }

    public static /* synthetic */ void rematch$default(ChatMatchViewModel r0, IRoom r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.rematch(r1, r2);
    }

    public static /* synthetic */ void startMatch$default(ChatMatchViewModel r1, IRoom r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        r1.startMatch(r2, r3, r4);
    }
}
