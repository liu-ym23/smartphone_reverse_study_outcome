package com.bytedance.android.live.profit.format.voicechat.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.format.voicechat.model.CloseReason;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatPrivilegeSource;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.android.live.profit.format.voicechat.trace.VoiceChatTraceStep;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import nu0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\u0004H\u0014R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00060&j\u0002`'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010,R\u001b\u00101\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R#\u0010<\u001a\n 8*\u0004\u0018\u000107078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020>0A8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020F0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010@R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020F0A8\u0006¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010ER\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020J0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010@R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020J0A8\u0006¢\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010ER\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020N0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010@R\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020N0A8\u0006¢\u0006\f\n\u0004\bP\u0010C\u001a\u0004\bQ\u0010ER\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00150=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010@R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00150A8\u0006¢\u0006\f\n\u0004\bS\u0010C\u001a\u0004\bS\u0010ER\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020T0=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010@R\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020T0A8\u0006¢\u0006\f\n\u0004\bV\u0010C\u001a\u0004\bW\u0010E¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/viewmodel/VoiceChatViewModel;", "Landroidx/lifecycle/ViewModel;", "", "effectId", "", "preloadGiftAssets", "Lcom/bytedance/android/live/core/resources/e;", "assetModel", "preDownloadAssets", "", "authorId", "init", "Landroid/content/Context;", "context", "", "sendGiftLogParams", "Lio/reactivex/Single;", "Lcom/bytedance/android/livesdk/gift/model/p2;", "Lcom/bytedance/revenue/platform/api/core/rx/Single;", "sendGift", "startChat", "", "isClosePage", "Lcom/bytedance/android/live/profit/format/voicechat/model/CloseReason;", "closeReason", "details", "closeChat", "changeMuteState", "interruptAI", "onCleared", "Lcom/bytedance/android/live/profit/format/voicechat/viewmodel/d;", "repository", "Lcom/bytedance/android/live/profit/format/voicechat/viewmodel/d;", "Lhu0/a;", "rtcManager", "Lhu0/a;", "getRtcManager", "()Lhu0/a;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "Ljava/lang/String;", "userId$delegate", "Lkotlin/Lazy;", "getUserId", "()Ljava/lang/String;", "userId", "Lca0/d;", "sendGiftService$delegate", "getSendGiftService", "()Lca0/d;", "sendGiftService", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager;", "kotlin.jvm.PlatformType", "assetsManager$delegate", "getAssetsManager", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager;", "assetsManager", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/profit/format/voicechat/model/a;", "_bootConfig", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "bootConfig", "Landroidx/lifecycle/LiveData;", "getBootConfig", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/profit/format/voicechat/model/c;", "_startButton", "startButton", "getStartButton", "Lcom/bytedance/android/live/profit/format/voicechat/model/f;", "_state", "state", "getState", "Lcom/bytedance/android/live/profit/format/voicechat/model/VoiceChatState;", "_chatState", "chatState", "getChatState", "_isMute", "isMute", "Lju0/f;", "_topics", "topics", "getTopics", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatViewModel extends ViewModel {
    private final MutableLiveData<com.bytedance.android.live.profit.format.voicechat.model.a> _bootConfig;
    private final MutableLiveData<VoiceChatState> _chatState;
    private final MutableLiveData<Boolean> _isMute;
    private final MutableLiveData<com.bytedance.android.live.profit.format.voicechat.model.c> _startButton;
    private final MutableLiveData<com.bytedance.android.live.profit.format.voicechat.model.f> _state;
    private final MutableLiveData<ju0.f> _topics;
    private final Lazy assetsManager$delegate;
    private String authorId;
    private final LiveData<com.bytedance.android.live.profit.format.voicechat.model.a> bootConfig;
    private final CompositeDisposable cd;
    private final LiveData<VoiceChatState> chatState;
    private final LiveData<Boolean> isMute;
    private final com.bytedance.android.live.profit.format.voicechat.viewmodel.d repository;
    private final hu0.a rtcManager;
    private final Lazy sendGiftService$delegate;
    private final LiveData<com.bytedance.android.live.profit.format.voicechat.model.c> startButton;
    private final LiveData<com.bytedance.android.live.profit.format.voicechat.model.f> state;
    private final LiveData<ju0.f> topics;
    private final Lazy userId$delegate;

    public static final class a implements Action {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.invoke();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VoiceChatViewModel a;

        public b(VoiceChatViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            VoiceChatViewModel.access$get_startButton$p(this.a).setValue(((com.bytedance.android.live.profit.format.voicechat.model.b) r2).getStartButton());
            nu0.j.a(this.a, "close chat success");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VoiceChatViewModel a;

        public c(VoiceChatViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            VoiceChatViewModel r0 = this.a;
            nu0.j.c(r0, "close chat failed", (Throwable) r4, 4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ VoiceChatViewModel a;

        public d(VoiceChatViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.profit.format.voicechat.model.a r5 = (com.bytedance.android.live.profit.format.voicechat.model.a) r4;
            nu0.j.a(this.a, "init boot config success!");
            VoiceChatViewModel.access$get_bootConfig$p(this.a).setValue(r5);
            VoiceChatViewModel.access$get_startButton$p(this.a).setValue(r5.getStartButton());
            VoiceChatViewModel.access$preloadGiftAssets(this.a, r5.getEffectId());
            String r0 = mu0.c.a;
            Pair[] r1 = {TuplesKt.to("privilege_source", String.valueOf(r5.getStartButton().getPrivilegeSource()))};
            Intrinsics.checkNotNullParameter(r1, "params");
            MapsKt.putAll(mu0.c.b, r1);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VoiceChatViewModel a;

        public e(VoiceChatViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            VoiceChatViewModel r0 = this.a;
            nu0.j.c(r0, "init boot config failed!", (Throwable) r4, 4);
        }
    }

    public static final class f extends o {
        public f() {
        }

        public final void onFailed(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "t");
            nu0.j.c(this, "download asset failed: " + r3, null, 6);
        }

        public final void c(long r1, String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            nu0.j.a(this, "download success");
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ VoiceChatViewModel a;
        public final /* synthetic */ h b;

        public g(VoiceChatViewModel r1, h r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            VoiceChatViewModel.access$getAssetsManager$p(this.a).l0(this.b);
        }
    }

    public static final class h implements IAssetsManager.b {
        public final /* synthetic */ VoiceChatViewModel a;
        public final /* synthetic */ long b;

        public final void a() {
            nu0.j.c(this, "on sync assets list failed", null, 6);
        }

        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r7) {
            Intrinsics.checkNotNullParameter(r7, "assetsModels");
            Iterator<T> r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L13;
            Object r0 = r8.next();
            com.bytedance.android.live.core.resources.e r1 = (com.bytedance.android.live.core.resources.e) r0;
            if (r1 != null) goto L8;
        L10:
            boolean r2 = false;
        L11:
            if (r2 == false) goto L4;
        L14:
            com.bytedance.android.live.core.resources.e r3 = (com.bytedance.android.live.core.resources.e) r0;
            if (r3 == null) goto L17;
            VoiceChatViewModel.access$preDownloadAssets(this.a, r3);
            return;
        L17:
            a();
            return;
        L8:
            if (r1.getId() != this.b) goto L10;
            r2 = true;
            goto L11
        L13:
            r0 = null;
            goto L14
        }

        public h(VoiceChatViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ VoiceChatViewModel a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ long c;

        public i(VoiceChatViewModel r1, Context r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r22) {
            com.bytedance.android.live.profit.format.voicechat.model.d r5 = (com.bytedance.android.live.profit.format.voicechat.model.d) r22;
            Intrinsics.checkNotNullParameter(r5, "$this$valid");
            if (r5.getRtcRoomId().length() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L8;
        L22:
            boolean r2 = false;
        L23:
            if (r2 == true) goto L25;
            this.a.closeChat(false, CloseReason.OTHER, "paramInvalid");
            return;
        L25:
            nu0.j.d(this.a, "start chat success!", null);
            String r3 = mu0.c.a;
            Pair[] r4 = {TuplesKt.to("room_id", r5.getRtcRoomId()), TuplesKt.to("session_id", String.valueOf(r5.getSessionId()))};
            Intrinsics.checkNotNullParameter(r4, "params");
            MapsKt.putAll(mu0.c.b, r4);
            com.bytedance.android.live.profit.format.voicechat.model.e r12 = new com.bytedance.android.live.profit.format.voicechat.model.e(this.b, VoiceChatViewModel.access$getUserId$p(this.a), VoiceChatViewModel.access$getAuthorId$p(this.a), r5, this.c);
            VoiceChatViewModel.access$get_state$p(this.a).setValue(new com.bytedance.android.live.profit.format.voicechat.model.f.b(r12));
            hu0.a r6 = this.a.getRtcManager();
            com.bytedance.android.live.profit.format.voicechat.viewmodel.f r7 = new com.bytedance.android.live.profit.format.voicechat.viewmodel.f(this);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r12, "sessionInfo");
            Intrinsics.checkNotNullParameter(r7, "callback");
            r6.d = r12;
            r6.g = r7;
            nu0.j.d(r6, "startRoom, roomID: " + r12.d.getRtcRoomId(), null);
            r6.a.h(r6.b);
            r6.a.d(r12.getContext(), r12.d.getRtcAppId(), r12.d.getRtcToken(), r12.d.getRtcRoomId(), r12.b, r12.c, r12.d.getRtcBusinessId());
            Disposable r8 = r6.h;
            if (r8 == null) goto L28;
            r8.dispose();
        L28:
            r6.h = RxUtilKt.h(Observable.timer(((Number) l.d.getValue(null, l.a[2])).longValue(), TimeUnit.SECONDS)).subscribe(new hu0.b(r6, r7));
            mu0.c.c(VoiceChatTraceStep.JOIN_ROOM, null, null, 0, 14);
            return;
        L8:
            if (r5.getRtcToken().length() <= 0) goto L10;
            boolean r9 = true;
        L11:
            if (r9 == false) goto L22;
            if (r5.getRtcAppId().length() <= 0) goto L15;
            boolean r10 = true;
        L16:
            if (r10 == false) goto L22;
            if (r5.getSessionId() == 0) goto L22;
            if (r5.getCountDown() == 0) goto L22;
            r2 = true;
            goto L23
        L15:
            r10 = false;
            goto L16
        L10:
            r9 = false;
            goto L11
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ VoiceChatViewModel a;

        public j(VoiceChatViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            nu0.j.c(this.a, "start chat failed!", r5, 4);
            String r1 = null;
            if ((r5 instanceof ApiServerException) == true) goto L5;
            r5 = null;
        L5:
            ApiServerException r6 = (ApiServerException) r5;
            if (r6 == null) goto L14;
            String r7 = r6.getPrompt();
            if (r7 == null) goto L14;
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r7) == false) goto L12;
            r1 = r7;
        L12:
            if (r1 == null) goto L14;
            ToastUtil.b(r1, 0);
        L14:
            this.a.closeChat(false, CloseReason.OTHER, "startError");
        }
    }

    private final IAssetsManager getAssetsManager() {
        return (IAssetsManager) this.assetsManager$delegate.getValue();
    }

    private final ca0.d getSendGiftService() {
        return (ca0.d) this.sendGiftService$delegate.getValue();
    }

    private final String getUserId() {
        return (String) this.userId$delegate.getValue();
    }

    public final void changeMuteState() {
        MutableLiveData<Boolean> r0 = this._isMute;
        Boolean r1 = (Boolean) r0.getValue();
        Boolean r2 = Boolean.TRUE;
        r0.setValue(Boolean.valueOf(!Intrinsics.areEqual(r1, r2)));
        hu0.a r3 = this.rtcManager;
        boolean r4 = Intrinsics.areEqual((Boolean) this.isMute.getValue(), r2);
        r3.i = r4;
        if (r4 == false) goto L5;
        r3.a.g();
        return;
    L5:
        r3.a.f();
    }

    public final void interruptAI() {
        this.rtcManager.a.c(UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("type", "interrupt")}).toString());
    }

    public VoiceChatViewModel() {
        this.repository = new com.bytedance.android.live.profit.format.voicechat.viewmodel.d();
        this.rtcManager = new hu0.a();
        this.cd = new CompositeDisposable();
        this.authorId = "";
        this.userId$delegate = LazyKt.lazy(VoiceChatViewModel$userId$2.INSTANCE);
        this.sendGiftService$delegate = LazyKt.lazy(VoiceChatViewModel$sendGiftService$2.INSTANCE);
        this.assetsManager$delegate = LazyKt.lazy(VoiceChatViewModel$assetsManager$2.INSTANCE);
        MutableLiveData<com.bytedance.android.live.profit.format.voicechat.model.a> r0 = new MutableLiveData();
        this._bootConfig = r0;
        Intrinsics.checkNotNullParameter(r0, "$this$readOnly");
        this.bootConfig = r0;
        MutableLiveData<com.bytedance.android.live.profit.format.voicechat.model.c> r1 = new MutableLiveData();
        this._startButton = r1;
        Intrinsics.checkNotNullParameter(r1, "$this$readOnly");
        this.startButton = r1;
        MutableLiveData<com.bytedance.android.live.profit.format.voicechat.model.f> r2 = new MutableLiveData();
        this._state = r2;
        Intrinsics.checkNotNullParameter(r2, "$this$readOnly");
        this.state = r2;
        MutableLiveData<VoiceChatState> r3 = new MutableLiveData();
        this._chatState = r3;
        Intrinsics.checkNotNullParameter(r3, "$this$readOnly");
        this.chatState = r3;
        Boolean r4 = Boolean.FALSE;
        if (r4 != null) goto L5;
        MutableLiveData<Boolean> r5 = new MutableLiveData();
    L6:
        this._isMute = r5;
        Intrinsics.checkNotNullParameter(r5, "$this$readOnly");
        this.isMute = r5;
        MutableLiveData<ju0.f> r6 = new MutableLiveData();
        this._topics = r6;
        Intrinsics.checkNotNullParameter(r6, "$this$readOnly");
        this.topics = r6;
        return;
    L5:
        r5 = new MutableLiveData(r4);
        goto L6
    }

    public void onCleared() {
        super.onCleared();
        this.rtcManager.a();
        this.cd.dispose();
    }

    public final LiveData<com.bytedance.android.live.profit.format.voicechat.model.a> getBootConfig() {
        return this.bootConfig;
    }

    public final CompositeDisposable getCd() {
        return this.cd;
    }

    public final LiveData<VoiceChatState> getChatState() {
        return this.chatState;
    }

    public final hu0.a getRtcManager() {
        return this.rtcManager;
    }

    public final LiveData<com.bytedance.android.live.profit.format.voicechat.model.c> getStartButton() {
        return this.startButton;
    }

    public final LiveData<com.bytedance.android.live.profit.format.voicechat.model.f> getState() {
        return this.state;
    }

    public final LiveData<ju0.f> getTopics() {
        return this.topics;
    }

    public final LiveData<Boolean> isMute() {
        return this.isMute;
    }

    public static final /* synthetic */ IAssetsManager access$getAssetsManager$p(VoiceChatViewModel r0) {
        return r0.getAssetsManager();
    }

    public static final /* synthetic */ String access$getAuthorId$p(VoiceChatViewModel r0) {
        return r0.authorId;
    }

    public static final /* synthetic */ String access$getUserId$p(VoiceChatViewModel r0) {
        return r0.getUserId();
    }

    public static final /* synthetic */ MutableLiveData access$get_bootConfig$p(VoiceChatViewModel r0) {
        return r0._bootConfig;
    }

    public static final /* synthetic */ MutableLiveData access$get_chatState$p(VoiceChatViewModel r0) {
        return r0._chatState;
    }

    public static final /* synthetic */ MutableLiveData access$get_startButton$p(VoiceChatViewModel r0) {
        return r0._startButton;
    }

    public static final /* synthetic */ MutableLiveData access$get_state$p(VoiceChatViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ MutableLiveData access$get_topics$p(VoiceChatViewModel r0) {
        return r0._topics;
    }

    private final void preDownloadAssets(com.bytedance.android.live.core.resources.e r4) {
        if (getAssetsManager().H0(r4.getId()) == null) goto L6;
        nu0.j.a(this, "asset is ready!");
        return;
    L6:
        getAssetsManager().Ne(r4, new f(), 2);
    }

    private final void preloadGiftAssets(long r8) {
        com.bytedance.android.live.core.resources.e r0 = getAssetsManager().G1(r8);
        if (r0 == null) goto L6;
        preDownloadAssets(r0);
        return;
    L6:
        nu0.j.a(this, "asset model is need request");
        getAssetsManager().d4(2, false, r8, "FormatGift");
        h r1 = new h(this, r8);
        getAssetsManager().T(r1);
        com.bytedance.revenue.platform.api.core.rx.f.a(Disposables.fromAction(new g(this, r1)), this.cd);
    }

    public final void init(String r12) {
        Intrinsics.checkNotNullParameter(r12, "authorId");
        this.authorId = r12;
        com.bytedance.android.live.profit.format.voicechat.viewmodel.d r1 = this.repository;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "authorId");
        tz0.b r0 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        Intrinsics.checkNotNullParameter("author_id", "$this$setTo");
        if (r12 == null) goto L5;
        r3.put("author_id", r12);
    L5:
        x.a(r2, r1.a);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        Single r13 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/profit/ai/voice_chat/boot_config/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.format.voicechat.model.a.class)), Extra.class, r2.d, r2.a, r2.b, r2.c).map(com.bytedance.android.live.profit.format.voicechat.viewmodel.b.a).singleOrError();
        int r4 = mu0.b.a;
        VoiceChatTraceStep r5 = VoiceChatTraceStep.BOOT_CONFIG;
        Intrinsics.checkNotNullParameter(r5, "step");
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.i(r13.compose(new mu0.a(r5))).subscribe(new d(this), new e(this)), this.cd);
    }

    public final void startChat(Context r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        com.bytedance.android.live.profit.format.voicechat.model.c r2 = (com.bytedance.android.live.profit.format.voicechat.model.c) this.startButton.getValue();
        if (r2 == null) goto L5;
        long r3 = r2.getPrivilegeSource();
    L6:
        long r4 = System.currentTimeMillis();
        com.bytedance.android.live.profit.format.voicechat.viewmodel.d r6 = this.repository;
        String r7 = this.authorId;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "authorId");
        tz0.b r8 = tz0.b.a;
        uz0.c r9 = new uz0.c();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map<String, String> r10 = r9.b;
        Intrinsics.checkNotNullParameter(r10, "queriesMap");
        Intrinsics.checkNotNullParameter("author_id", "$this$setTo");
        if (r7 == null) goto L9;
        r10.put("author_id", r7);
    L9:
        String r5 = Long.valueOf(r3).toString();
        Intrinsics.checkNotNullParameter("privilege_source", "$this$setTo");
        if (r5 == null) goto L12;
        r10.put("privilege_source", r5);
    L12:
        x.a(r9, r6.a);
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Single r12 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/profit/ai/voice_chat/start/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.format.voicechat.model.d.class)), Extra.class, r9.d, r9.a, r9.b, r9.c).map(com.bytedance.android.live.profit.format.voicechat.viewmodel.c.a).singleOrError();
        int r13 = mu0.b.a;
        VoiceChatTraceStep r14 = VoiceChatTraceStep.CHAT_START_REQ;
        Intrinsics.checkNotNullParameter(r14, "step");
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.i(r12.compose(new mu0.a(r14))).subscribe(new i(this, r19, r4), new j(this)), this.cd);
        return;
    L5:
        r3 = VoiceChatPrivilegeSource.GIFT.getType();
        goto L6
    }

    public static final /* synthetic */ void access$preDownloadAssets(VoiceChatViewModel r0, com.bytedance.android.live.core.resources.e r1) {
        r0.preDownloadAssets(r1);
    }

    public static final /* synthetic */ void access$preloadGiftAssets(VoiceChatViewModel r0, long r1) {
        r0.preloadGiftAssets(r1);
    }

    public static final /* synthetic */ void access$setAuthorId$p(VoiceChatViewModel r0, String r1) {
        r0.authorId = r1;
    }

    public final Single<p2> sendGift(Context r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "sendGiftLogParams");
        com.bytedance.android.live.profit.format.voicechat.model.a r0 = (com.bytedance.android.live.profit.format.voicechat.model.a) this._bootConfig.getValue();
        if (r0 == null) goto L5;
        Single r14 = ca0.d.a.a(getSendGiftService(), r12, r0.getGiftId(), this.authorId, (int) r0.getGiftDiamond(), "avatar_format_call", "not_show", r13, 160).singleOrError();
        int r15 = mu0.b.a;
        VoiceChatTraceStep r16 = VoiceChatTraceStep.SEND_GIFT;
        Intrinsics.checkNotNullParameter(r16, "step");
        return r14.compose(new mu0.a(r16));
    L5:
        return Single.error(new IllegalStateException("boot config is null!"));
    }

    public final void closeChat(final boolean r24, final CloseReason r25, final String r26) {
        Intrinsics.checkNotNullParameter(r25, "closeReason");
        Intrinsics.checkNotNullParameter(r26, "details");
        Object r1 = null;
        nu0.j.d(this, "close chat, currentState: " + ((com.bytedance.android.live.profit.format.voicechat.model.f) this._state.getValue()) + ", isClosePage: " + r24 + ", closeReason: " + r25 + ", detail: " + r26, null);
        Object r0 = this.state.getValue();
        if ((r0 instanceof com.bytedance.android.live.profit.format.voicechat.model.f.b) == false) goto L6;
        r1 = r0;
    L6:
        com.bytedance.android.live.profit.format.voicechat.model.f.b r12 = (com.bytedance.android.live.profit.format.voicechat.model.f.b) r1;
        if (r25 == CloseReason.COUNT_DOWN) goto L15;
        long r2 = System.currentTimeMillis();
        if (r12 == null) goto L13;
        com.bytedance.android.live.profit.format.voicechat.model.e r3 = r12.a;
        if (r3 == null) goto L13;
        long r4 = r3.f;
    L14:
        long r5 = r2 - r4;
    L23:
        final long r6 = r5;
        int r7 = com.bytedance.android.live.profit.format.voicechat.viewmodel.e.a[r25.ordinal()];
        if (r7 != 1) goto L26;
        String r8 = "userClose";
    L30:
        final String r9 = r8;
    L31:
        Function0<Unit> r13 = new VoiceChatViewModel$closeChat$onClose$1(this, r9, r6, r25, r26, r24);
        if (r12 != null) goto L35;
        r13.invoke();
        return;
    L35:
        com.bytedance.android.live.profit.format.voicechat.viewmodel.d r10 = this.repository;
        long r14 = r12.a.d.getSessionId();
        int r15 = r25.getType();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r26, "details");
        tz0.b r16 = tz0.b.a;
        uz0.c r17 = new uz0.c();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "$this$beforeConfigureRequest");
        Map<String, String> r18 = r17.b;
        Intrinsics.checkNotNullParameter(r18, "queriesMap");
        String r19 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("session_id", "$this$setTo");
        if (r19 == null) goto L38;
        r18.put("session_id", r19);
    L38:
        Intrinsics.checkNotNullParameter("req_from", "$this$setTo");
        r18.put("req_from", "app");
        String r20 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("reason", "$this$setTo");
        if (r20 == null) goto L41;
        r18.put("reason", r20);
    L41:
        Intrinsics.checkNotNullParameter("details", "$this$setTo");
        if (r26 == null) goto L44;
        r18.put("details", r26);
    L44:
        x.a(r17, r10.a);
        Intrinsics.checkNotNullParameter(r17, "$this$afterConfigureRequest");
        Single r22 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/profit/ai/voice_chat/close/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.format.voicechat.model.b.class)), Extra.class, r17.d, r17.a, r17.b, r17.c).map(com.bytedance.android.live.profit.format.voicechat.viewmodel.a.a).singleOrError();
        int r23 = mu0.b.a;
        VoiceChatTraceStep r27 = VoiceChatTraceStep.CHAT_CLOSE_REQ;
        Intrinsics.checkNotNullParameter(r27, "step");
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.i(r22.compose(new mu0.a(r27))).doFinally(new a(r13)).subscribe(new b(this), new c(this)), this.cd);
        return;
    L26:
        if (r7 == 2) goto L28;
        r9 = r26;
        goto L31
    L28:
        r8 = "timeUp";
    L13:
        r4 = System.currentTimeMillis();
        goto L14
    L15:
        if (r12 == null) goto L21;
        com.bytedance.android.live.profit.format.voicechat.model.e r28 = r12.a;
        if (r28 == null) goto L21;
        com.bytedance.android.live.profit.format.voicechat.model.d r29 = r28.d;
        if (r29 == null) goto L21;
        long r30 = r29.getCountDown();
    L22:
        r5 = r30 * ((long) WebcastRedirectException.UNKNOWN);
    L21:
        r30 = 0;
        goto L22
    }

    public static /* synthetic */ void closeChat$default(VoiceChatViewModel r0, boolean r1, CloseReason r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = CloseReason.UNKNOWN;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = "";
    L8:
        r0.closeChat(r1, r2, r3);
    }
}
