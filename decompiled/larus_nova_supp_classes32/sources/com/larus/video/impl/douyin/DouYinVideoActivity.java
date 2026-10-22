package com.larus.video.impl.douyin;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.audio.ttsV2.TtsClientDelegate;
import com.larus.bmhome.chat.api.MultimodalTraceDelegate;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.api.r2;
import com.larus.platform.api.z3;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.platform.uimodel.VideoParam;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003,/2\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u000bJ\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0015J\b\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J\b\u0010<\u001a\u000205H\u0002J\b\u0010=\u001a\u000205H\u0002J\b\u0010>\u001a\u000205H\u0002J\b\u0010?\u001a\u000205H\u0002J\u0010\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020BH\u0002J<\u0010C\u001a\u0002052\u0006\u0010A\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0F2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH\u0002J\u0010\u0010I\u001a\u0002052\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u000205H\u0002J\b\u0010M\u001a\u000205H\u0003J\b\u0010N\u001a\u000205H\u0014J\b\u0010O\u001a\u000205H\u0002J\b\u0010P\u001a\u000205H\u0014J\b\u0010Q\u001a\u000205H\u0016J\b\u0010R\u001a\u000205H\u0002J\u0010\u0010S\u001a\u0002052\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u000205H\u0002J\b\u0010W\u001a\u000205H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006Y"}, d2 = {"Lcom/larus/video/impl/douyin/DouYinVideoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "douyinVideoModel", "Lcom/larus/video/impl/douyin/DouYinActivityVideoModel;", "isExitTransitionRunning", NameKeys.UnloadStrategy_No_Strategy, "mEnterTime", NameKeys.UnloadStrategy_No_Strategy, "mLatestAid", NameKeys.UnloadStrategy_No_Strategy, "iOperateFeedFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "isFirstFramePlayed", "firstFrameLoadFinishTimeStamp", "Ljava/lang/Long;", "firstFrameLoadDuration", "staticBlackColor", NameKeys.UnloadStrategy_No_Strategy, "getStaticBlackColor", "()I", "staticBlackColor$delegate", "Lkotlin/Lazy;", "douYinVideoDataManager", "Lcom/larus/video/impl/douyin/DouYinVideoDataManager;", "getDouYinVideoDataManager", "()Lcom/larus/video/impl/douyin/DouYinVideoDataManager;", "douYinVideoDataManager$delegate", "getPoiTrackParams", "Lorg/json/JSONObject;", "getPoiTrackParams$impl_mainlandRelease", "getCurrentMessageId", "douYinVideoUIOperator", "Lcom/larus/video/impl/douyin/DouYinVideoUIOperator;", "getDouYinVideoUIOperator", "()Lcom/larus/video/impl/douyin/DouYinVideoUIOperator;", "douYinVideoUIOperator$delegate", "douYinVideoActivityTracker", "Lcom/larus/video/impl/douyin/DouYinVideoActivityTracker;", "getDouYinVideoActivityTracker", "()Lcom/larus/video/impl/douyin/DouYinVideoActivityTracker;", "douYinVideoActivityTracker$delegate", "sendEventCallback", "com/larus/video/impl/douyin/DouYinVideoActivity$sendEventCallback$1", "Lcom/larus/video/impl/douyin/DouYinVideoActivity$sendEventCallback$1;", "getMoreListener", "com/larus/video/impl/douyin/DouYinVideoActivity$getMoreListener$1", "Lcom/larus/video/impl/douyin/DouYinVideoActivity$getMoreListener$1;", "customIFeedPageListener", "com/larus/video/impl/douyin/DouYinVideoActivity$customIFeedPageListener$1", "Lcom/larus/video/impl/douyin/DouYinVideoActivity$customIFeedPageListener$1;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "validateEssentialData", "setUpVideoModel", "trackActivityCreationTime", "setupPerformanceMonitoring", "mutePage", "setupWindowConfig", "registerGlobalListeners", "reportLeave", "tryLoadMoreItemIdList", "callback", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomILoadMoreCallback;", "handleLoadMoreResult", "haveMore", "loadMoreItemIdList", NameKeys.UnloadStrategy_No_Strategy, "ext", NameKeys.UnloadStrategy_No_Strategy, "beforeEnterInitCacheData", "enterDouYinSdkParam", "Lcom/larus/video/impl/douyin/EnterDouYinSdkParam;", "addVideoFeedFragment", "dispatchTouchEventToSeekBar", "onPause", "saveUnConsumedPlayList", "onResume", "onAttachedToWindow", "applySystemBarColor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refreshLayoutForConfigurationChanged", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouYinVideoActivity extends AppCompatActivity {
    public static final /* synthetic */ int p = 0;
    public DouYinActivityVideoModel a;
    public boolean b;
    public long c;
    public String d;
    public pr9.h e;
    public boolean f;
    public Long g;
    public Long h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final e m;
    public final d n;
    public final c o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VideoParam.RecommendType.values().length];
            r0[VideoParam.RecommendType.Search.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[VideoParam.RecommendType.AwemeFeed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements pr9.b {
        public final /* synthetic */ DouYinVideoActivity a;

        public final pr9.d a() {
            return null;
        }

        public final void onLoadSuccess() {
            FLogger.a.i("DouYinVideoActivity", "onLoadSuccess");
            DouYinVideoActivity r0 = this.a;
            int r1 = DouYinVideoActivity.p;
            n r2 = r0.z1();
            r2.getClass();
            MultimodalTraceDelegate r3 = MultimodalTraceDelegate.b;
            String r4 = (String) r2.b.getValue();
            DouYinVideoDataManager r5 = r2.a;
            String r6 = r5.E;
            String r7 = r5.y;
            r3.c(r4, r6, r2.a(), r7);
        }

        public c(DouYinVideoActivity r1) {
            this.a = r1;
        }

        public final void b(CustomFeedPlayerEvent r9) {
            Intrinsics.checkNotNullParameter(r9, "event");
            boolean r1 = true;
            if ((r9 instanceof CustomFeedPlayerEvent.FirstFrame) == false) goto L7;
            DouYinVideoActivity r0 = this.a;
            r0.f = true;
            if (r0.g != null) goto L7;
            r0.g = Long.valueOf(System.currentTimeMillis());
        L7:
            FLogger.a.i("DouYinVideoActivity", "onPlayerEvent: " + Reflection.getOrCreateKotlinClass(r9.getClass()).getSimpleName() + ", aid = " + r9.getAwemeId() + ", type = " + r9.getAwemeType() + ", ext = " + r9.getExtra());
            Intrinsics.checkNotNullParameter(r9, "<this>");
            Map r3 = r9.getExtra();
            Object r5 = null;
            if (r3 == null) goto L10;
            Object r4 = r3.get("reason");
        L12:
            if ((r9 instanceof CustomFeedPlayerEvent.PausePlay) == true) goto L14;
        L16:
            boolean r6 = false;
        L17:
            if (r6 == false) goto L21;
            DouYinVideoActivity r7 = this.a;
            if (r7.b == true) goto L21;
            r7.z1().b("paused");
            return;
        L21:
            Intrinsics.checkNotNullParameter(r9, "<this>");
            Map r2 = r9.getExtra();
            if (r2 == null) goto L25;
            r5 = r2.get("reason");
        L25:
            if ((r9 instanceof CustomFeedPlayerEvent.ResumePlay) == true) goto L27;
        L29:
            r1 = false;
        L30:
            if (r1 == false) goto L34;
            DouYinVideoActivity r10 = this.a;
            int r8 = DouYinVideoActivity.p;
            r10.z1().b("play");
            return;
        L34:
            return;
        L27:
            if (Intrinsics.areEqual(r5, 1) == false) goto L29;
        L14:
            if (Intrinsics.areEqual(r4, 1) == false) goto L16;
            r6 = true;
            goto L17
        L10:
            r4 = null;
            goto L12
        }

        public final void onLoadError(String r9) {
            Intrinsics.checkNotNullParameter(r9, "msg");
            FLogger.a.i("DouYinVideoActivity", "onLoadError, code = 21002, msg = ".concat(r9));
            DouYinVideoActivity r1 = this.a;
            int r2 = DouYinVideoActivity.p;
            n r3 = r1.z1();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r9, "msg");
            MultimodalTraceDelegate r4 = MultimodalTraceDelegate.b;
            String r5 = (String) r3.b.getValue();
            DouYinVideoDataManager r0 = r3.a;
            String r6 = r0.E;
            String r7 = r0.y;
            String r8 = r3.a();
            JSONObject r10 = new JSONObject();
            r10.put("err_code", 21002);
            r10.put("err_msg", r9);
            r4.a(r5, r6, r10.toString(), r8, r7);
        }

        public final void c(boolean r6, String r7) {
            Intrinsics.checkNotNullParameter(r7, "aid");
            FLogger.a.i("DouYinVideoActivity", "notifyFeedChange, isPlayNext = " + r6 + ", aid = " + r7);
            DouYinVideoActivity r8 = this.a;
            int r1 = DouYinVideoActivity.p;
            v r9 = (v) r8.k.getValue();
            r9.getClass();
            Intrinsics.checkNotNullParameter(r7, "aid");
            DouYinVideoDataManager r0 = r9.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r7, "itemId");
            ArrayList<MediaEntity> r2 = r0.L;
            if (r2 == null) goto L8;
            MediaEntity r3 = (MediaEntity) CollectionsKt.getOrNull(r2, 0);
            if (r3 == null) goto L8;
            String r4 = r3.getItem_id();
            if (r4 == null) goto L8;
        L10:
            if (Intrinsics.areEqual(r4, r7) == true) goto L12;
        L14:
            ((TextView) r9.c.getValue()).setVisibility(8);
            ((View) r9.d.getValue()).setVisibility(8);
        L15:
            this.a.A1().B.add(r7);
            String r10 = l2a.b.a;
            Intrinsics.checkNotNullParameter(r7, "itemId");
            l2a.b.a = r7;
            DouYinVideoActivity r11 = this.a;
            r11.d = r7;
            VideoParam.RecommendType r12 = r11.A1().M;
            Map r5 = com.larus.bmhome.video.e.a;
            com.larus.bmhome.video.e.a(r12.name(), CollectionsKt.listOf(r7));
            this.a.B1();
            return;
        L12:
            if (r9.b.O == false) goto L14;
            ((TextView) r9.c.getValue()).setText(r9.a.getResources().getString(2131909748));
            ((TextView) r9.c.getValue()).setVisibility(0);
            ((View) r9.d.getValue()).setVisibility(0);
        L8:
            r4 = NameKeys.UnloadStrategy_No_Strategy;
            goto L10
        }
    }

    public static final class d implements pr9.g {
        public final /* synthetic */ DouYinVideoActivity a;

        public d(DouYinVideoActivity r1) {
            this.a = r1;
        }

        public final void a(com.larus.api.bussiness.j r9) {
            Intrinsics.checkNotNullParameter(r9, "callback");
            DouYinVideoActivity r0 = this.a;
            int r1 = DouYinVideoActivity.p;
            r0.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new DouYinVideoActivity$tryLoadMoreItemIdList$1(r0, r9, null), 3, null);
        }
    }

    public static final class e implements pr9.i {
        public final /* synthetic */ DouYinVideoActivity a;

        public e(DouYinVideoActivity r1) {
            this.a = r1;
        }

        public final void a(String r5, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r5, "event");
            Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
            DouYinVideoActivity r2 = this.a;
            int r3 = DouYinVideoActivity.p;
            DouYinVideoDataManager r4 = r2.A1();
            r4.getClass();
            Intrinsics.checkNotNullParameter(r5, "event");
            Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
            if (Intrinsics.areEqual(r5, "play_time") == false) goto L17;
            int r7 = JSONObjectProtectorUtils.getInt(r6, "duration");     // Catch: Exception -> L13
            String r8 = JSONObjectProtectorUtils.getString(r6, "group_id");     // Catch: Exception -> L13
            Integer r0 = r4.v.get(r8);     // Catch: Exception -> L13
            int r1 = 0;
            if (r0 == null) goto L7;
            int r9 = r0.intValue();     // Catch: Exception -> L13
        L8:
            r4.v.put(r8, Integer.valueOf(r9 + r7));     // Catch: Exception -> L13
            RecommendVideoApi r10 = RecommendVideoApi.a;     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r8);     // Catch: Exception -> L13
            Intrinsics.checkNotNullParameter(r8, "videoId");     // Catch: Exception -> L13
            ConcurrentHashMap r11 = RecommendVideoApi.j;     // Catch: Exception -> L13
            Integer r12 = (Integer) r11.get(r8);     // Catch: Exception -> L13
            if (r12 == null) goto L11;
            r1 = r12.intValue();     // Catch: Exception -> L13
        L11:
            r11.put(r8, Integer.valueOf(r1 + r7));     // Catch: Exception -> L13
            return;
        L7:
            r9 = 0;
        L13:
            FLogger.a.d("DouYinVideoDataParser", "read play duration and group id error");
            return;
        }
    }

    static {
    }

    public final DouYinVideoDataManager A1() {
        return (DouYinVideoDataManager) this.j.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DouYinVideoActivity.class.getName()));
    L5:
        String r1 = A1().U;
        if (r1 == null) goto L10;
        new m2a.f();
        Intrinsics.checkNotNullParameter(r1, "token");
        cy6.a r2 = cy6.c.a(r1);
        if (r2 == null) goto L10;
        r2.release();
    L10:
        PrefetchRecommendVideoParam r3 = A1().P;
        if (r3 != null) goto L13;
    L15:
        IBTMService r4 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r4 == null) goto L18;
        r4.q(this);
    L18:
        super.onDestroy();
        if (A1().M == VideoParam.RecommendType.Non) goto L21;
        Map r5 = com.larus.bmhome.video.e.a;
        com.larus.bmhome.video.e.d(A1().M.name());
    L21:
        this.e = null;
        com.larus.platform.service.k r6 = com.larus.platform.service.k.a;
        IAppletJsbEventService.TriggeredEvent r7 = IAppletJsbEventService.TriggeredEvent.LEAVE_AWENME_VIDEO;
        com.larus.platform.service.k.a.a(r7, null);
        l2a.b.a = NameKeys.UnloadStrategy_No_Strategy;
        com.larus.platform.service.g.a.g("VIDEO_ACTIVITY");
        FLogger.a.j("VIDEO_ACTIVITY", "DouYinVideoActivity onDestroy");
        VideoFeedProviderDelegate.b.c(this.m);
        return;
    L13:
        if (r3.getEnterFromRelatedVideoFlow() == true) goto L15;
        com.larus.video.impl.sdk.f.a.g(PrefetchRecommendVideoParam.copy$default(r3, null, null, null, null, null, CachedVideosPreloadFrom.REFRESH_VIDEO, null, new i(this), null, null, false, null, null, false, null, 32607, null));
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        if (this.h != null) goto L9;
        Long r1 = this.g;
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.longValue() - this.c);
    L8:
        this.h = r2;
        goto L9
    L7:
        r2 = null;
    L9:
        n r3 = z1();
        Intent r4 = getIntent();
        String r5 = this.d;
        long r6 = this.c;
        boolean r7 = this.f;
        Long r8 = this.h;
        Map<String, String> r9 = r3.a.F;
        if (r5 != null) goto L12;
        String r11 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        String r10 = (String) ((LinkedHashMap) r9).get(r11);
        if (r10 != null) goto L16;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        DouYinVideoDataManager r12 = r3.a;
        if (r5 != null) goto L19;
        String r13 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "itemId");
        String r14 = (String) ((LinkedHashMap) r12.G).get(r13);
        String r15 = r3.a.I;
        if (r15 != null) goto L23;
    L26:
        boolean r16 = true;
    L27:
        if (r16 == false) goto L29;
        String r17 = r3.a.H;
    L30:
        com.larus.platform.service.o r18 = com.larus.platform.service.o.a;
        JSONObject r19 = new JSONObject();
        if (r5 != null) goto L33;
        String r110 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        r19.put("video_id", r110);
        r19.put("duration", System.currentTimeMillis() - r6);
        r19.put("cnt", r3.a.B.size());
        r19.put("req_id", r10);
        String r20 = "1";
        if (r14 == null) goto L41;
        r19.put("channel_id", r14);
        if (Intrinsics.areEqual(r14, "416") == false) goto L39;
        Object r21 = "1";
    L40:
        r19.put("is_inner_video", r21);
        goto L41
    L39:
        r21 = "0";
    L41:
        String r22 = r3.a.A;
        if (r22 != null) goto L44;
        r22 = NameKeys.UnloadStrategy_No_Strategy;
    L44:
        r19.put("conversation_id", r22);
        String r23 = r3.a.D;
        if (r23 != null) goto L47;
        r23 = NameKeys.UnloadStrategy_No_Strategy;
    L47:
        r19.put("bot_id", r23);
        String r24 = r3.a.E;
        if (r24 != null) goto L50;
        r24 = NameKeys.UnloadStrategy_No_Strategy;
    L50:
        r19.put("message_id", r24);
        if (r4 == null) goto L55;
        Bundle r25 = r4.getExtras();
        if (r25 == null) goto L55;
        String r26 = r25.getString("slidemode");
    L56:
        r19.put("slidemode", r26);
        if (r4 == null) goto L61;
        Bundle r27 = r4.getExtras();
        if (r27 == null) goto L61;
        String r28 = r27.getString("host_enter_from");
    L62:
        r19.put("host_enter_from", r28);
        if (r4 == null) goto L67;
        Bundle r29 = r4.getExtras();
        if (r29 == null) goto L67;
        String r30 = r29.getString("card_position");
    L68:
        r19.put("card_position", r30);
        if (r4 == null) goto L73;
        Bundle r31 = r4.getExtras();
        if (r31 == null) goto L73;
        String r32 = r31.getString("card_sub_position");
    L74:
        r19.put("card_sub_position", r32);
        if (r5 != null) goto L77;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L77:
        r19.put("group_id", r5);
        r19.put("reply_id", r3.a.z);
        r19.put("search_id", r17);
        r19.put("agent_id", r3.a.K);
        if (r7 == true) goto L81;
        r20 = "0";
    L81:
        r19.put("is_first_frame_played", r20);
        if (r8 == null) goto L84;
        r19.put("first_frame_load_duration", r8.longValue());
    L84:
        Unit r33 = Unit.INSTANCE;
        r18.reportEvent("leave_video_layer", r19);
        A1().B.clear();
        B1();
        VideoFeedProviderDelegate.b.g(this.n);
        return;
    L73:
        r32 = null;
    L67:
        r30 = null;
    L61:
        r28 = null;
    L55:
        r26 = null;
        goto L56
    L33:
        r110 = r5;
        goto L34
    L29:
        r17 = r3.a.I;
        goto L30
    L23:
        if (StringsKt.isBlank(r15) == true) goto L26;
        r16 = false;
        goto L27
    L19:
        r13 = r5;
        goto L20
    L12:
        r11 = r5;
        goto L13
    }

    public final n z1() {
        return (n) this.l.getValue();
    }

    public DouYinVideoActivity() {
        this.i = LazyKt.lazy(new com.larus.video.impl.douyin.d(this));
        this.j = LazyKt.lazy(new com.larus.video.impl.douyin.e());
        this.k = LazyKt.lazy(new f(this));
        this.l = LazyKt.lazy(new g(this));
        this.m = new e(this);
        this.n = new d(this);
        this.o = new c(this);
    }

    public final void B1() {
        PrefetchRecommendVideoParam r0 = A1().P;
        if (r0 == null) goto L46;
        Map r1 = com.larus.bmhome.video.e.a;
        String r2 = A1().M.name();
        Intrinsics.checkNotNullParameter(r2, "scene");
        List r3 = (CopyOnWriteArrayList) ((LinkedHashMap) com.larus.bmhome.video.e.b).get(r2);
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        ArrayList r4 = new ArrayList(r3);
        List r5 = (CopyOnWriteArraySet) ((LinkedHashMap) com.larus.bmhome.video.e.c).get(r2);
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        Set r6 = CollectionsKt.toSet(new ArrayList(r5));
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Object r9 = r8.next();
        if (r6.contains((String) r9) == true) goto L14;
        r7.add(r9);
        goto L14
    L18:
        String r10 = r0.getMessageId();
        if (r10 != null) goto L21;
        String r11 = NameKeys.UnloadStrategy_No_Strategy;
    L22:
        HashMap r12 = new HashMap();
        HashMap r13 = new HashMap();
        Iterator r14 = r7.iterator();
    L24:
        if (r14.hasNext() == false) goto L32;
        String r15 = (String) r14.next();
        DouYinVideoDataManager r16 = A1();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "itemId");
        String r17 = (String) ((LinkedHashMap) r16.F).get(r15);
        if (r17 != null) goto L28;
        r17 = NameKeys.UnloadStrategy_No_Strategy;
    L28:
        r12.put(r15, r17);
        DouYinVideoDataManager r18 = A1();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r15, "itemId");
        String r19 = (String) ((LinkedHashMap) r18.G).get(r15);
        if (r19 != null) goto L31;
        r19 = "416";
    L31:
        r13.put(r15, r19);
        goto L24
    L32:
        com.larus.platform.api.k r20 = new com.larus.platform.api.k(r12, r11, AppHost.a.getAppClock().currentTimeMillis(), new ArrayList(r7), CachedVideosPreloadFrom.UN_CONSUMED, r0.getImprIndex(), r13);
        IFlowSdkDepend r21 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r21 == null) goto L47;
        r2 r22 = r21.A0();
        if (r22 == null) goto L48;
        r22.o(r20, r0.getEnterFromRelatedVideoFlow());
        return;
    L48:
        return;
    L47:
        return;
    L21:
        r11 = r10;
        goto L22
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DouYinVideoActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Activity*/.onAttachedToWindow();
        getWindow().setStatusBarColor(((Number) this.i.getValue()).intValue());
        getWindow().setNavigationBarColor(((Number) this.i.getValue()).intValue());
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        this.c = System.currentTimeMillis();
        VideoFeedProviderDelegate.b.e(this.n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r7) {
        Intrinsics.checkNotNullParameter(r7, "newConfig");
        super.onConfigurationChanged(r7);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r7 == null) goto L8;
        Integer r3 = Integer.valueOf(r7.orientation);     // Catch: Throwable -> L17
    L9:
        if (r3 != null) goto L12;
    L14:
        if (r2 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:DouYinVideoActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r3.intValue() == r2) goto L19;
    L8:
        r3 = null;
    L19:
        FLogger.a.i("DouYinVideoActivity", "onConfigurationChanged, orientation = " + r7.orientation + ", screenLayout = " + r7.screenLayout + ", smallestScreenWidthDp = " + r7.smallestScreenWidthDp);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        getWindow().setStatusBarColor(((Number) this.i.getValue()).intValue());
        getWindow().setNavigationBarColor(((Number) this.i.getValue()).intValue());
        View r8 = y1(getWindow()).findViewById(2131384840);
        if (r8 == null) goto L22;
        e1.x(r8);
        r8.requestApplyInsets();
        r8.requestLayout();
    L22:
        View r9 = findViewById(2131373275);
        if (r9 == null) goto L25;
        r9.requestLayout();
    L25:
        pr9.h r10 = this.e;
        if (r10 == null) goto L35;
        Fragment r11 = r10.f();
        if (r11 == null) goto L36;
        View r12 = r11.getView();
        if (r12 == null) goto L37;
        r12.requestLayout();
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.larus.video.impl.douyin.j] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.video.impl.douyin.p] */
    public final void onCreate(Bundle r19) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r19);
        IBTMService r0 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r0 == null) goto L14;
        r0.i(this, getIntent());
    L14:
        String r1 = getIntent().getStringExtra("source_btm_token");
        IBTMService r2 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r2 == null) goto L17;
        r2.registerBtmPageOnCreate(this, "a35794.b109331", r1);
    L17:
        this.c = System.currentTimeMillis();
        com.larus.platform.service.g.a.e("VIDEO_ACTIVITY");
        FLogger.a.j("VIDEO_ACTIVITY", "DouYinVideoActivity onCreate");
        com.larus.platform.service.k r3 = com.larus.platform.service.k.a;
        com.larus.platform.service.k.a.a(IAppletJsbEventService.TriggeredEvent.ENTER_AWENME_VIDEO, null);
        TtsClientDelegate.b.cancel("DouYinVideoActivity onCreate", false);
        Lazy r4 = q3.a;
        z3 r5 = q3.a();
        if (r5 == null) goto L20;
        r5.n(null);
    L20:
        DouYinVideoDataManager r6 = A1();
        Intent r7 = getIntent();
        r6.getClass();
        Intrinsics.checkNotNullParameter(this, "context");
        String r11 = NameKeys.UnloadStrategy_No_Strategy;
        if (r7 == null) goto L342;
        Bundle r8 = r7.getExtras();
        if (r8 == null) goto L25;
        String r9 = r8.getString("media_error_msg");
    L26:
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == true) goto L39;
        t19.s r12 = t19.s.a;
        Bundle r13 = r7.getExtras();
        if (r13 == null) goto L37;
        String r14 = r13.getString("media_error_msg");
        if (r14 == null) goto L37;
    L38:
        r12.getClass();
        t19.s.c(this, r14);
    L358:
        boolean r15 = false;
    L360:
        if (r15 == true) goto L362;
        finish();
        boolean r16 = false;
    L363:
        if (r16 == false) goto L616;
        setContentView(2131561784);
        DouYinVideoDataManager r17 = A1();
        ArrayList<MediaEntity> r18 = r17.L;
        if (r18 == null) goto L370;
        MediaEntity r20 = (MediaEntity) CollectionsKt.getOrNull(r18, r17.f);
        if (r20 == null) goto L370;
        String r21 = r20.getItem_id();
    L371:
        if (r21 != null) goto L373;
        r21 = NameKeys.UnloadStrategy_No_Strategy;
    L373:
        r17.t = r21;
        ArrayList r22 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList<MediaEntity> r111 = r17.L;
        if (r111 == null) goto L401;
        Iterator<T> r112 = r111.iterator();
    L377:
        if (r112.hasNext() == false) goto L401;
        MediaEntity r113 = (MediaEntity) r112.next();
        if (r113 == null) goto L381;
        String r114 = r113.getItem_id();
    L382:
        if (r113 == null) goto L384;
        String r115 = r113.getInteractive_rec_info();
    L385:
        if (r114 != null) goto L387;
    L390:
        boolean r116 = true;
    L391:
        if (r116 == true) goto L377;
        r22.add(r114);
        if (r115 != null) goto L395;
    L398:
        boolean r117 = true;
    L399:
        if (r117 == true) goto L377;
        r110.add(TuplesKt.to(r114, r115));
        goto L377
    L395:
        if (r115.length() == 0) goto L398;
        r117 = false;
        goto L399
    L387:
        if (r114.length() == 0) goto L390;
        r116 = false;
        goto L391
    L384:
        r115 = null;
        goto L385
    L381:
        r114 = null;
    L401:
        Map r118 = com.larus.bmhome.video.e.a;
        com.larus.bmhome.video.e.a(r17.M.name(), r22);
        VideoParam.RecommendType r119 = r17.M;
        if (r119 == VideoParam.RecommendType.Search) goto L406;
        if (r119 == VideoParam.RecommendType.AwemeFeed) goto L406;
    L424:
        w r23 = new w(r21, r22, r110);
        VideoParam.RecommendType r24 = A1().M;
        if (r24 == VideoParam.RecommendType.Non) goto L463;
        DouYinVideoDataManager r25 = A1();
        int r26 = b.a[r24.ordinal()];
        if (r26 == 1) goto L431;
        if (r26 == 2) goto L431;
    L462:
        com.larus.bmhome.video.e.c(r24.name(), r23.b);
    L431:
        FirstFramePreloadVideoData r27 = r25.Q;
        if (r27 == null) goto L436;
        ArrayList r28 = r27.getPreLoadFirstRequestItemIdList();
        if (r28 == null) goto L436;
        List r29 = CollectionsKt.filterNotNull(r28);
    L437:
        if (r29 != null) goto L439;
        r29 = CollectionsKt.emptyList();
    L439:
        String r120 = r24.name();
        List<String> r121 = r23.b;
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r30 = r121.iterator();
    L441:
        if (r30.hasNext() == false) goto L461;
        String r123 = (String) r30.next();
        if (r29.contains(r123) == false) goto L450;
        FirstFramePreloadVideoData r31 = r25.Q;
        if (r31 == null) goto L449;
        Map r32 = r31.getPreLoadFirstRequestItemIdToRequestIdMap();
        if (r32 == null) goto L449;
        String r33 = (String) r32.get(r123);
    L452:
        if (r29.contains(r123) == false) goto L459;
        FirstFramePreloadVideoData r34 = r25.Q;
        if (r34 == null) goto L458;
        Map r35 = r34.getPreLoadFirstRequestItemIdToChannelIdMap();
        if (r35 == null) goto L458;
        String r36 = (String) r35.get(r123);
    L460:
        r122.add(new com.larus.bmhome.video.g(r123, r33, r36));
    L458:
        r36 = null;
        goto L460
    L459:
        r36 = r25.J;
    L449:
        r33 = null;
        goto L452
    L450:
        r33 = r25.H;
        goto L452
    L461:
        com.larus.bmhome.video.e.b(r120, r122);
    L436:
        r29 = null;
    L463:
        DouYinVideoDataManager r37 = A1();
        Intent r38 = getIntent();
        r37.getClass();
        Intrinsics.checkNotNullParameter(r23, "enterDouYinSdkParam");
        or9.d r39 = new or9.d();
        List<String> r40 = r23.b;
        Intrinsics.checkNotNullParameter(r40, "itemIDList");
        r39.b = r40;
        JSONObject r41 = new JSONObject();
        r41.put("req_id", r37.H);
        String r42 = r37.A;
        if (r42 != null) goto L466;
        r42 = NameKeys.UnloadStrategy_No_Strategy;
    L466:
        r41.put("conversation_id", r42);
        String r43 = r37.D;
        if (r43 != null) goto L469;
        r43 = NameKeys.UnloadStrategy_No_Strategy;
    L469:
        r41.put("bot_id", r43);
        String r44 = r37.E;
        if (r44 != null) goto L472;
        r44 = NameKeys.UnloadStrategy_No_Strategy;
    L472:
        r41.put("message_id", r44);
        Intrinsics.checkNotNullParameter(r41, "jsonObject");
        r39.c = r41;
        r39.d = true;
        List<Pair<String, String>> r45 = r23.c;
        Intrinsics.checkNotNullParameter(r45, "interactiveRecInfoList");
        r39.e = r45;
        r39.k = r37.i;
        EnterVideoMethod r46 = or9.a.a(r37.y);     // Catch: Exception -> L475
    L476:
        Intrinsics.checkNotNullParameter(r46, "enterVideoMethod");
        r39.a = r46;
        r39.j = r37.h;
        String r47 = r23.a;
        Intrinsics.checkNotNullParameter(r47, "enterItemID");
        r39.r = r47;
        r39.t = false;
        r39.w = 0;
        String r48 = r37.j;
        Intrinsics.checkNotNullParameter(r48, "sceneID");
        r39.p = r48;
        r39.y = r37.k;
        Long r49 = StringsKt.toLongOrNull(AccountService.a.getUserId());
        if (r49 == null) goto L479;
        long r50 = r49.longValue();
    L480:
        r39.q = r50;
        r39.l = r37.m;
        r39.m = r37.l;
        r39.g = false;
        JSONObject r51 = new JSONObject();
        String r52 = r37.E;
        if (r52 != null) goto L483;
        r52 = NameKeys.UnloadStrategy_No_Strategy;
    L483:
        r51.put("host_message_id", r52);
        r51.put("host_conversation_id", r37.A);
        String r53 = r37.n;
        if (r53 != null) goto L486;
        r53 = NameKeys.UnloadStrategy_No_Strategy;
    L486:
        r51.put("host_last_message_id", r53);
        r51.put("host_enter_from_group_id", r37.p);
        String r54 = r37.K;
        if (r54 != null) goto L489;
        r54 = NameKeys.UnloadStrategy_No_Strategy;
    L489:
        r51.put("host_agent_id", r54);
        r51.put("host_impr_index", r37.q);
        if (o0.d(r37.o) == false) goto L492;
        r51.put("host_enter_from", r37.o);
    L492:
        r51.put("host_rank", r37.s);
        String r55 = r37.D;
        if (r55 != null) goto L495;
        r55 = NameKeys.UnloadStrategy_No_Strategy;
    L495:
        r51.put("host_bot_id", r55);
        String r56 = r37.b;
        if (r56 != null) goto L498;
        r56 = NameKeys.UnloadStrategy_No_Strategy;
    L498:
        r51.put("host_section_id", r56);
        String r57 = r37.H;
        if (r57 != null) goto L501;
        r57 = NameKeys.UnloadStrategy_No_Strategy;
    L501:
        r51.put("host_req_id", r57);
        String r58 = r37.z;
        if (r58 != null) goto L504;
        r58 = NameKeys.UnloadStrategy_No_Strategy;
    L504:
        r51.put("host_reply_id", r58);
        String r59 = r37.c;
        if (r59 == null) goto L508;
        r11 = r59;
    L508:
        r51.put("host_chat_type", r11);
        r51.put("host_recommend_type", r37.M.name());
        if (r38 == null) goto L513;
        Bundle r60 = r38.getExtras();
        if (r60 == null) goto L513;
        String r61 = r60.getString("slidemode");
    L514:
        r51.put("host_slidemode", r61);
        if (r38 == null) goto L519;
        Bundle r62 = r38.getExtras();
        if (r62 == null) goto L519;
        String r63 = r62.getString("card_position");
    L520:
        r51.put("host_card_position", r63);
        if (r38 == null) goto L525;
        Bundle r64 = r38.getExtras();
        if (r64 == null) goto L525;
        String r65 = r64.getString("card_sub_position");
    L526:
        r51.put("host_card_sub_position", r65);
        if (r38 == null) goto L531;
        Bundle r66 = r38.getExtras();
        if (r66 == null) goto L531;
        String r67 = r66.getString("rich_media_type");
    L532:
        r51.put("host_rich_media_type", r67);
        if (r38 == null) goto L537;
        Bundle r68 = r38.getExtras();
        if (r68 == null) goto L537;
        String r69 = r68.getString("module_source");
    L538:
        r51.put("host_module_source", r69);
        if (r38 == null) goto L543;
        Bundle r70 = r38.getExtras();
        if (r70 == null) goto L543;
        String r71 = r70.getString("module_position");
    L544:
        r51.put("host_module_position", r71);
        r51.put("host_incoming_video_ids", r23.b.toString());
        if (r38 == null) goto L551;
        Bundle r72 = r38.getExtras();
        if (r72 == null) goto L551;
        String r73 = r72.getString("host_key_search_id");
        if (r73 == null) goto L551;
        r51.put("host_key_search_id", r73);
    L551:
        JSONObject r74 = r37.T;
        if (r74 == null) goto L562;
        Iterator<String> r75 = r74.keys();
        if (r75 == null) goto L562;
    L556:
        if (r75.hasNext() == false) goto L562;
        String r76 = r75.next();
        JSONObject r77 = r37.T;
        if (r77 == null) goto L560;
        Object r78 = r77.opt(r76);
    L561:
        r51.putOpt(r76, r78);
        goto L556
    L560:
        r78 = null;
    L562:
        Intrinsics.checkNotNullParameter(r51, "trackParams");
        r39.o = r51;
        r39.u = c7.b(50);
        r39.s = false;
        r39.A = r37.g;
        VideoFeedConfigure r79 = r39.a();
        VideoFeedProviderDelegate r80 = VideoFeedProviderDelegate.b;
        pr9.h r81 = r80.i(r79);
        this.e = r81;
        Fragment r82 = r81.f();
        r82.setArguments(getIntent().getExtras());
        FragmentTransaction r83 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r83, r82, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L566;
        r83 = r83.replace(2131373275, r82);
    L566:
        r83.commitAllowingStateLoss();
        y1(getWindow()).setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        int r84 = com.larus.utils.d.a;
        com.larus.utils.d.a(this, new l2a.c(), new l2a.d(), new j(this), null, 16);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DouYinVideoActivity$setupWindowConfig$2(this, null), 3, null);
        pr9.h r85 = this.e;
        if (r85 == null) goto L569;
        r85.xQ(this.o);
    L569:
        r80.e(this.n);
        r80.h(this.m);
        final v r86 = (v) this.k.getValue();
        pr9.h r87 = this.e;
        r86.getClass();
        final DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1 r88 = new DouYinVideoUIOperator$addPressBack$onBackPressedCallback$1(r87, r86);
        r86.a.getOnBackPressedDispatcher().addCallback(r86.a, r88);
        ImageView r89 = (ImageView) r86.e.getValue();
        if (r89 == null) goto L572;
        e1.d(r89, new q(r88));
    L572:
        z2 r90 = z2.a;
        final int r91 = r90.networkAutoSwitch().b;
        if (r90.networkAutoSwitch().a == false) goto L577;
        if (r91 <= 0) goto L577;
        final Keva r92 = Keva.getRepo("network_auto_switch");
        final Ref.LongRef r93 = new Ref.LongRef();
        com.larus.network.ttnet.c.a.getClass();
        com.larus.network.ttnet.c.d.observe(r86.a, new v.a(new p(r93, r92, r91, r86)));
    L577:
        DouYinActivityVideoModel r94 = new DouYinActivityVideoModel();
        this.a = r94;
        r94.updateLoadMoreParamsFromVideoSource(A1().C);
        View r95 = findViewById(2131377668);
        if (r95 == null) goto L580;
        r95.setOnTouchListener(new h(this));
    L580:
        n r96 = z1();
        r96.getClass();
        MultimodalTraceDelegate.b.b((String) r96.b.getValue(), r96.a.A);
        return;
    L543:
        r71 = null;
    L537:
        r69 = null;
    L531:
        r67 = null;
    L525:
        r65 = null;
    L519:
        r63 = null;
    L513:
        r61 = null;
        goto L514
    L479:
        r50 = -1;
    L475:
        r46 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
    L406:
        if (r17.d != 0) goto L424;
        if (r17.N == true) goto L410;
        r22.clear();
        r22.add(r21);
    L410:
        FirstFramePreloadVideoData r124 = r17.Q;
        if (r124 == null) goto L424;
        ArrayList r125 = r124.getPreLoadFirstRequestItemIdList();
        if (r125 == null) goto L424;
        List r126 = CollectionsKt.filterNotNull(r125);
        if (r126 == null) goto L424;
        List r127 = r126;
        if ((!r127.isEmpty()) == false) goto L424;
        r22.addAll(r127);
        Intrinsics.checkNotNullParameter(r126, "videoIdList");
        com.larus.bmhome.video.e.d.addAll(r127);
        r17.u = true;
        FirstFramePreloadVideoData r97 = r17.Q;
        if (r97 == null) goto L421;
        boolean r98 = Intrinsics.areEqual(r97.getInnerLoadMoreRequestFromSecondRun(), Boolean.TRUE);
    L422:
        if (r98 == false) goto L424;
        r17.W = 2;
        goto L424
    L421:
        r98 = false;
    L370:
        r21 = null;
        goto L371
    L616:
        return;
    L362:
        r16 = true;
    L37:
        r14 = NameKeys.UnloadStrategy_No_Strategy;
        goto L38
    L39:
        Bundle r99 = r7.getExtras();
        if (r99 == null) goto L42;
        Serializable r100 = r99.getSerializable("_media_arg_key");
    L43:
        if (r100 != null) goto L45;
        boolean r101 = true;
    L46:
        if (r101 == false) goto L342;
        Bundle r102 = r7.getExtras();
        if (r102 == null) goto L50;
        Serializable r103 = r102.getSerializable("_media_arg_key");
    L51:
        if (r103 != null) goto L53;
        boolean r104 = true;
    L54:
        if (r104 == false) goto L342;
        Bundle r105 = r7.getExtras();
        if (r105 == null) goto L58;
        Serializable r106 = r105.getSerializable("_media_arg_key");
    L59:
        r6.L = (ArrayList) r106;
        Bundle r107 = r7.getExtras();
        if (r107 == null) goto L62;
        Serializable r108 = r107.getSerializable("key_reply_item_ids");
    L64:
        if ((r108 instanceof ArrayList) == false) goto L66;
        ArrayList<String> r109 = (ArrayList) r108;
    L67:
        r6.R = r109;
        Bundle r128 = r7.getExtras();
        if (r128 == null) goto L70;
        Serializable r129 = r128.getSerializable("extra_item_id_list");
    L71:
        r6.a = (ArrayList) r129;
        Bundle r130 = r7.getExtras();
        if (r130 == null) goto L74;
        Serializable r131 = r130.getSerializable("_media_container_key");
    L76:
        if ((r131 instanceof MediaEntityContainer) == false) goto L78;
        MediaEntityContainer r132 = (MediaEntityContainer) r131;
    L79:
        r6.C = r132;
        Bundle r133 = r7.getExtras();
        if (r133 == null) goto L82;
        String r134 = r133.getString("key_bot_id");
    L83:
        r6.D = r134;
        Bundle r135 = r7.getExtras();
        if (r135 == null) goto L86;
        String r136 = r135.getString("section_id");
    L87:
        r6.b = r136;
        Bundle r137 = r7.getExtras();
        if (r137 == null) goto L90;
        String r138 = r137.getString("req_id");
    L91:
        r6.H = r138;
        Bundle r139 = r7.getExtras();
        if (r139 == null) goto L94;
        String r140 = r139.getString("host_key_search_id");
    L95:
        r6.I = r140;
        Bundle r141 = r7.getExtras();
        if (r141 == null) goto L98;
        String r142 = r141.getString("key_channel_id");
    L99:
        r6.J = r142;
        Bundle r143 = r7.getExtras();
        if (r143 == null) goto L102;
        String r144 = r143.getString("key_chat_type");
    L103:
        r6.c = r144;
        Bundle r145 = r7.getExtras();
        if (r145 == null) goto L106;
        String r146 = r145.getString("key_message_id");
    L107:
        r6.E = r146;
        Bundle r147 = r7.getExtras();
        if (r147 == null) goto L110;
        String r148 = r147.getString("key_last_message_id");
    L111:
        r6.n = r148;
        Bundle r149 = r7.getExtras();
        if (r149 == null) goto L114;
        String r150 = r149.getString("host_enter_from");
    L115:
        r6.o = r150;
        Bundle r151 = r7.getExtras();
        if (r151 == null) goto L118;
        String r152 = r151.getString("enter_from_group_id");
    L119:
        r6.p = r152;
        Bundle r153 = r7.getExtras();
        if (r153 == null) goto L122;
        String r154 = r153.getString("agent_id");
    L123:
        r6.K = r154;
        Bundle r155 = r7.getExtras();
        if (r155 == null) goto L126;
        Integer r156 = Integer.valueOf(r155.getInt("impr_index"));
    L127:
        r6.q = r156;
        Bundle r157 = r7.getExtras();
        if (r157 == null) goto L130;
        Integer r158 = Integer.valueOf(r157.getInt("key_stream_index"));
    L131:
        r6.r = r158;
        Bundle r159 = r7.getExtras();
        if (r159 == null) goto L134;
        Integer r160 = Integer.valueOf(r159.getInt("rank"));
    L135:
        r6.s = r160;
        Bundle r161 = r7.getExtras();
        if (r161 == null) goto L138;
        String r162 = r161.getString("key_conversation_id");
    L139:
        r6.A = r162;
        Bundle r163 = r7.getExtras();
        if (r163 == null) goto L142;
        int r164 = r163.getInt("key_video_index");
    L143:
        r6.f = r164;
        Bundle r165 = r7.getExtras();
        if (r165 == null) goto L146;
        long r166 = r165.getLong("key_start_play_position", 0);
    L147:
        r6.g = RangesKt.coerceAtLeast(r166, 0);
        Bundle r167 = r7.getExtras();
        if (r167 == null) goto L150;
        boolean r168 = r167.getBoolean("key_need_custom_load_more");
    L151:
        r6.h = r168;
        Bundle r169 = r7.getExtras();
        if (r169 == null) goto L154;
        boolean r170 = r169.getBoolean("key_need_custom_refresh");
    L155:
        r6.i = r170;
        Bundle r171 = r7.getExtras();
        if (r171 == null) goto L158;
        boolean r172 = r171.getBoolean("key_need_load_more", true);
    L159:
        r6.x = r172;
        Bundle r173 = r7.getExtras();
        if (r173 == null) goto L163;
        String r174 = r173.getString("key_enter_method");
        if (r174 == null) goto L163;
    L164:
        r6.y = r174;
        Bundle r175 = r7.getExtras();
        if (r175 == null) goto L168;
        String r176 = r175.getString("key_dou_yin_scene_id");
        if (r176 == null) goto L168;
    L169:
        r6.j = r176;
        Bundle r177 = r7.getExtras();
        if (r177 == null) goto L173;
        String r178 = r177.getString("key_dou_yin_video_image_cover");
        if (r178 == null) goto L173;
    L174:
        r6.k = r178;
        Bundle r179 = r7.getExtras();
        if (r179 == null) goto L177;
        int r180 = r179.getInt("key_dou_yin_video_image_cover_width");
    L178:
        r6.m = r180;
        Bundle r181 = r7.getExtras();
        if (r181 == null) goto L181;
        int r182 = r181.getInt("key_dou_yin_video_image_cover_height");
    L182:
        r6.l = r182;
        Bundle r183 = r7.getExtras();
        if (r183 == null) goto L185;
        String r184 = r183.getString("key_reply_id");
    L186:
        r6.z = r184;
        Bundle r185 = r7.getExtras();
        if (r185 == null) goto L189;
        Serializable r186 = r185.getSerializable("key_video_recommend_type");
    L191:
        if ((r186 instanceof VideoParam.RecommendType) == false) goto L193;
        VideoParam.RecommendType r187 = (VideoParam.RecommendType) r186;
    L194:
        if (r187 != null) goto L196;
        r187 = VideoParam.RecommendType.Non;
    L196:
        r6.M = r187;
        Bundle r188 = r7.getExtras();
        if (r188 == null) goto L199;
        boolean r189 = r188.getBoolean("key_keep_all_outer_aid_when_recommend");
    L200:
        r6.N = r189;
        Bundle r190 = r7.getExtras();
        if (r190 == null) goto L203;
        int r191 = r190.getInt("key_ugc_video_scene");
    L204:
        r6.d = r191;
        Bundle r192 = r7.getExtras();
        if (r192 == null) goto L207;
        ArrayList<String> r193 = r192.getStringArrayList("key_query");
    L208:
        r6.e = r193;
        Bundle r194 = r7.getExtras();
        if (r194 == null) goto L211;
        boolean r195 = r194.getBoolean("key_force_preload_recommend");
    L212:
        r6.S = r195;
        Bundle r196 = r7.getExtras();
        if (r196 == null) goto L224;
        String r197 = r196.getString("key_host_track_params");
        if (r197 == null) goto L224;
        Result.Companion r198 = Result.Companion;     // Catch: Throwable -> L218
        Object r199 = Result.constructor-impl(new JSONObject(r197));     // Catch: Throwable -> L218
    L221:
        if (Result.isFailure-impl(r199) == false) goto L223;
        r199 = null;
    L223:
        JSONObject r200 = (JSONObject) r199;
    L225:
        r6.T = r200;
        Bundle r201 = r7.getExtras();
        if (r201 == null) goto L228;
        Serializable r202 = r201.getSerializable("key_first_frame_preload_cache");
    L230:
        if ((r202 instanceof FirstFramePreloadVideoData) == false) goto L232;
        FirstFramePreloadVideoData r203 = (FirstFramePreloadVideoData) r202;
    L233:
        r6.Q = r203;
        Bundle r204 = r7.getExtras();
        if (r204 == null) goto L236;
        Serializable r205 = r204.getSerializable("key_preload_request_param");
    L238:
        if ((r205 instanceof PrefetchRecommendVideoParam) == false) goto L240;
        PrefetchRecommendVideoParam r206 = (PrefetchRecommendVideoParam) r205;
    L241:
        r6.P = r206;
        ArrayList<MediaEntity> r207 = r6.L;
        if (r207 == null) goto L273;
        Iterator<T> r208 = r207.iterator();
    L245:
        if (r208.hasNext() == false) goto L273;
        MediaEntity r1100 = (MediaEntity) r208.next();
        Map<String, String> r1101 = r6.F;
        if (r1100 == null) goto L249;
        String r1102 = r1100.getItem_id();
    L250:
        if (r1102 != null) goto L252;
        r1102 = NameKeys.UnloadStrategy_No_Strategy;
    L252:
        String r1103 = r6.H;
        if (r1103 != null) goto L255;
        r1103 = NameKeys.UnloadStrategy_No_Strategy;
    L255:
        r1101.put(r1102, r1103);
        FirstFramePreloadVideoData r1104 = r6.Q;
        if (r1104 == null) goto L245;
        Map r1105 = r1104.getPreLoadFirstRequestItemIdToChannelIdMap();
        if (r1105 == null) goto L245;
        if (r1100 == null) goto L261;
        String r1106 = r1100.getItem_id();
    L262:
        if (r1106 != null) goto L264;
        r1106 = NameKeys.UnloadStrategy_No_Strategy;
    L264:
        String r1107 = (String) r1105.get(r1106);
        if (r1107 == null) goto L245;
        Map<String, String> r1108 = r6.G;
        if (r1100 == null) goto L269;
        String r1109 = r1100.getItem_id();
    L270:
        if (r1109 != null) goto L272;
        r1109 = NameKeys.UnloadStrategy_No_Strategy;
    L272:
        r1108.put(r1109, r1107);
        goto L245
    L269:
        r1109 = null;
        goto L270
    L261:
        r1106 = null;
        goto L262
    L249:
        r1102 = null;
    L273:
        FirstFramePreloadVideoData r209 = r6.Q;
        if (r209 == null) goto L298;
        ArrayList r210 = r209.getPreLoadFirstRequestItemIdList();
        if (r210 == null) goto L298;
        List r211 = CollectionsKt.filterNotNull(r210);
        if (r211 == null) goto L298;
        Iterator r212 = r211.iterator();
    L281:
        if (r212.hasNext() == false) goto L298;
        String r1110 = (String) r212.next();
        Map<String, String> r1111 = r6.F;
        FirstFramePreloadVideoData r1112 = r6.Q;
        if (r1112 == null) goto L287;
        Map r1113 = r1112.getPreLoadFirstRequestItemIdToRequestIdMap();
        if (r1113 == null) goto L287;
        String r1114 = (String) r1113.get(r1110);
    L288:
        if (r1114 != null) goto L290;
        r1114 = NameKeys.UnloadStrategy_No_Strategy;
    L290:
        r1111.put(r1110, r1114);
        Map<String, String> r1115 = r6.G;
        FirstFramePreloadVideoData r1116 = r6.Q;
        if (r1116 == null) goto L296;
        Map r1117 = r1116.getPreLoadFirstRequestItemIdToChannelIdMap();
        if (r1117 == null) goto L296;
        String r1118 = (String) r1117.get(r1110);
        if (r1118 == null) goto L296;
    L297:
        r1115.put(r1110, r1118);
    L296:
        r1118 = "414";
    L287:
        r1114 = null;
    L298:
        ArrayList<MediaEntity> r213 = r6.L;
        if (r213 != null) goto L301;
    L304:
        boolean r214 = true;
    L305:
        if (r214 == true) goto L313;
        ArrayList<MediaEntity> r215 = r6.L;
        if (r215 != null) goto L309;
    L311:
        boolean r216 = false;
    L312:
        if (r216 == true) goto L313;
    L314:
        Bundle r217 = r7.getExtras();
        if (r217 == null) goto L317;
        String r218 = r217.getString("key_poi_feed_provider_token");
    L318:
        r6.U = r218;
        Bundle r219 = r7.getExtras();
        if (r219 == null) goto L321;
        r219.getString("key_poi_enter_aweme_id");
    L321:
        Bundle r220 = r7.getExtras();
        if (r220 == null) goto L324;
        r220.getString("key_poi_id");
    L324:
        Bundle r221 = r7.getExtras();
        if (r221 == null) goto L339;
        String r222 = r221.getString("key_poi_track_params_json");
        if (r222 == null) goto L339;
        Result.Companion r223 = Result.Companion;     // Catch: Throwable -> L330
        Object r224 = Result.constructor-impl(new JSONObject(r222));     // Catch: Throwable -> L330
    L332:
        Throwable r225 = Result.exceptionOrNull-impl(r224);
        if (r225 == null) goto L336;
        FLogger.a.e("DouYinVideoDataParser", "parse POI track params failed: " + r225.getMessage());
    L336:
        if (Result.isFailure-impl(r224) == false) goto L338;
        r224 = null;
    L338:
        JSONObject r226 = (JSONObject) r224;
    L340:
        r6.V = r226;
    L330:
        th = move-exception;
        Result.Companion r227 = Result.Companion;
        r224 = Result.constructor-impl(ResultKt.createFailure(th));
    L339:
        r226 = null;
        goto L340
    L317:
        r218 = null;
        goto L318
    L309:
        if (r215.size() != 1) goto L311;
        r216 = true;
    L313:
        r6.O = false;
        goto L314
    L301:
        if (r213.isEmpty() == true) goto L304;
        r214 = false;
        goto L305
    L240:
        r206 = null;
        goto L241
    L236:
        r205 = null;
        goto L238
    L232:
        r203 = null;
        goto L233
    L228:
        r202 = null;
    L218:
        th = move-exception;
        Result.Companion r1119 = Result.Companion;
        r199 = Result.constructor-impl(ResultKt.createFailure(th));
    L224:
        r200 = null;
        goto L225
    L211:
        r195 = false;
        goto L212
    L207:
        r193 = null;
        goto L208
    L203:
        r191 = 0;
        goto L204
    L199:
        r189 = false;
        goto L200
    L193:
        r187 = null;
        goto L194
    L189:
        r186 = null;
        goto L191
    L185:
        r184 = null;
        goto L186
    L181:
        r182 = 10;
        goto L182
    L177:
        r180 = 10;
    L173:
        r178 = NameKeys.UnloadStrategy_No_Strategy;
    L168:
        r176 = "false";
    L163:
        r174 = NameKeys.UnloadStrategy_No_Strategy;
        goto L164
    L158:
        r172 = true;
        goto L159
    L154:
        r170 = false;
        goto L155
    L150:
        r168 = false;
        goto L151
    L146:
        r166 = 0;
        goto L147
    L142:
        r164 = 0;
        goto L143
    L138:
        r162 = null;
        goto L139
    L134:
        r160 = null;
        goto L135
    L130:
        r158 = null;
        goto L131
    L126:
        r156 = null;
        goto L127
    L122:
        r154 = null;
        goto L123
    L118:
        r152 = null;
        goto L119
    L114:
        r150 = null;
        goto L115
    L110:
        r148 = null;
        goto L111
    L106:
        r146 = null;
        goto L107
    L102:
        r144 = null;
        goto L103
    L98:
        r142 = null;
        goto L99
    L94:
        r140 = null;
        goto L95
    L90:
        r138 = null;
        goto L91
    L86:
        r136 = null;
        goto L87
    L82:
        r134 = null;
        goto L83
    L78:
        r132 = null;
        goto L79
    L74:
        r131 = null;
        goto L76
    L70:
        r129 = null;
        goto L71
    L66:
        r109 = null;
        goto L67
    L62:
        r108 = null;
        goto L64
    L58:
        r106 = null;
        goto L59
    L53:
        r104 = r103 instanceof ArrayList;
        goto L54
    L50:
        r103 = null;
        goto L51
    L45:
        r101 = r100 instanceof ArrayList;
        goto L46
    L42:
        r100 = null;
        goto L43
    L28:
        if (r9.length() == 0) goto L31;
        r10 = false;
        goto L32
    L25:
        r9 = null;
    L342:
        if (r6.M == VideoParam.RecommendType.Non) goto L345;
        r6.h = true;
    L345:
        if (r6.x == true) goto L347;
        r6.h = true;
    L347:
        ArrayList<MediaEntity> r228 = r6.L;
        if (r228 != null) goto L350;
    L353:
        boolean r229 = true;
    L354:
        if (r229 == true) goto L358;
        if (r6.C == null) goto L358;
        r15 = true;
        goto L360
    L350:
        if (r228.isEmpty() == true) goto L353;
        r229 = false;
        goto L354
    }
}
