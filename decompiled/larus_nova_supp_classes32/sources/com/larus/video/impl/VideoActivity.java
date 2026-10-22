package com.larus.video.impl;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.audio.ttsV2.TtsClientDelegate;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.home.impl.utils.c;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.d;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.larus.video.impl.widget.PagerLayoutManager;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l2a.g;
import l2a.h;
import l2a.i;
import l2a.k;
import l2a.l;
import l2a.m;
import l2a.o;
import l2a.p;
import org.json.JSONObject;
import t19.s;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00102\u001a\u00020\u0011H\u0016J\b\u00103\u001a\u00020\u0011H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0015J\b\u00109\u001a\u000206H\u0014J\b\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u000206H\u0016J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\u000e\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u001eJ\u001e\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u001eJ\b\u0010F\u001a\u000206H\u0014J\b\u0010G\u001a\u000206H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b/\u00100¨\u0006H"}, d2 = {"Lcom/larus/video/impl/VideoActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "mStatusView", "Lcom/larus/common_ui/widget/LoadingWithRetryView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Lcom/larus/video/impl/VideoDetailAdapter;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "mItemListener", "Lcom/larus/video/impl/ITikTokItemListener;", "mBackBtn", "Landroid/widget/ImageView;", "mIsPlaying", NameKeys.UnloadStrategy_No_Strategy, "mItems", "Ljava/util/ArrayList;", "Lcom/larus/platform/uimodel/MediaEntity;", "Lkotlin/collections/ArrayList;", "mMediaContainer", "Lcom/larus/platform/uimodel/MediaEntityContainer;", "mSourceFrom", NameKeys.UnloadStrategy_No_Strategy, "Ljava/lang/Integer;", "mEnterTime", NameKeys.UnloadStrategy_No_Strategy, "mBotId", NameKeys.UnloadStrategy_No_Strategy, "mMessageId", "mConversationId", "mVideoIndex", "mEnterMethod", "mRecordBrowserVideo", NameKeys.UnloadStrategy_No_Strategy, "mUseNewApiGetVideoModel", "mMainHandler", "Landroid/os/Handler;", "getMMainHandler", "()Landroid/os/Handler;", "mMainHandler$delegate", "Lkotlin/Lazy;", "mUseShareAnim", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "getMVideoController", "()Lcom/larus/platform/api/IVideoController;", "mVideoController$delegate", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "getBackgroundResource", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "initData", "initView", "onAttachedToWindow", "tryInitVideoView", "updateViewByNetwork", "showLoading", "initVideo", "reportClickVideoPlayer", "status", "reportSwipeVideo", "lastPosition", "curPosition", "onPause", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int A = 0;
    public LoadingWithRetryView g;
    public RecyclerView h;
    public VideoDetailAdapter i;
    public CommonVideoModel j;
    public o k;
    public boolean l;
    public ArrayList<MediaEntity> m;
    public MediaEntityContainer n;
    public Integer o;
    public long p;
    public String q;
    public String r;
    public String s;
    public int t;
    public String u;
    public final Set<String> v;
    public boolean w;
    public final Lazy x;
    public boolean y;
    public final Lazy z;

    public final int C1() {
        return R.color.transparent;
    }

    public final boolean H1() {
        return !this.y;
    }

    public final boolean K1() {
        return !this.y;
    }

    public final IVideoController O1() {
        return (IVideoController) this.z.getValue();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VideoActivity.class.getName()));
    L5:
        super.onDestroy();
        RecyclerView r0 = this.h;
        if (r0 == null) goto L8;
        r0.setKeepScreenOn(false);
    L8:
        CommonVideoModel r1 = this.j;
        if (r1 == null) goto L13;
        ArrayList r2 = r1.getItems();
        if (r2 == null) goto L13;
        int r3 = r2.size();
    L14:
        if (r3 <= 0) goto L25;
        Set<String> r4 = this.v;
        CommonVideoModel r5 = this.j;
        if (r5 == null) goto L23;
        ArrayList r6 = r5.getItems();
        if (r6 == null) goto L23;
        MediaEntity r7 = (MediaEntity) ListProtector.get(r6, 0);
        if (r7 == null) goto L23;
        String r8 = r7.getItem_id();
        if (r8 == null) goto L23;
    L24:
        r4.add(r8);
    L23:
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L25:
        ((Handler) this.x.getValue()).removeCallbacksAndMessages(null);
        O1().I(false);
        O1().release();
        return;
    L13:
        r3 = 0;
        goto L14
    }

    public VideoActivity() {
        this.v = new LinkedHashSet();
        this.x = LazyKt.lazy(new g(this));
        this.z = LazyKt.lazy(new h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R1() {
        boolean r1 = false;
        if (NetworkUtils.isNetworkAvailable(this) == true) goto L14;
        LoadingWithRetryView r0 = this.g;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        LoadingWithRetryView r2 = this.g;
        if (r2 == null) goto L10;
        r2.b();
    L10:
        LoadingWithRetryView r3 = this.g;
        if (r3 == null) goto L13;
        r3.setOnRetryListener(new l(this));
    L13:
        ((Handler) this.x.getValue()).postDelayed(new k(this), 340);
        return;
    L14:
        LoadingWithRetryView r4 = this.g;
        if (r4 == null) goto L17;
        e1.o(r4);
    L17:
        ArrayList<MediaEntity> r5 = this.m;
        if (r5 != null) goto L20;
    L21:
        r1 = true;
    L22:
        if (r1 == false) goto L29;
        LoadingWithRetryView r6 = this.g;
        if (r6 == null) goto L26;
        r6.c(2131908354);
    L26:
        LoadingWithRetryView r7 = this.g;
        if (r7 == null) goto L51;
        e1.x(r7);
        return;
    L51:
        return;
    L29:
        RecyclerView r8 = this.h;
        if (r8 == null) goto L32;
        PagerLayoutManager r9 = new PagerLayoutManager(this);
        r9.g = true;
        r9.setRecycleChildrenOnDetach(true);
        r9.h = new m(this);
        r8.setLayoutManager(r9);
    L32:
        this.k = new o(this);
        CommonVideoModel r10 = new CommonVideoModel(this.m);
        this.j = r10;
        r10.setSource(this.o);
        CommonVideoModel r11 = this.j;
        if (r11 == null) goto L35;
        r11.setLoadMoreContainer(this.n);
    L35:
        CommonVideoModel r12 = this.j;
        if (r12 == null) goto L38;
        r12.setUseNewApiGetVideoModel(this.w);
    L38:
        VideoDetailAdapter r13 = new VideoDetailAdapter(new WeakReference(this.h), this.j, this.k, this, O1());
        this.i = r13;
        RecyclerView r14 = this.h;
        if (r14 == null) goto L41;
        r14.setAdapter(r13);
    L41:
        VideoDetailAdapter r15 = this.i;
        if (r15 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        r15 = null;
    L44:
        r15.g = new p(this);
        int r16 = this.t;
        if (r16 <= 0) goto L53;
        RecyclerView r17 = this.h;
        if (r17 == null) goto L54;
        r17.scrollToPosition(r16);
        return;
    L54:
        return;
    L53:
        return;
    L20:
        if (r5.isEmpty() == false) goto L22;
        goto L21
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(VideoActivity.class.getName()));
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
        getWindow().setNavigationBarColor(getResources().getColor(2131103292));
        getWindow().setStatusBarColor(getResources().getColor(2131103292));
    }

    public final void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        if (IVideoController.PlayType.PLAY != O1().d()) goto L5;
        boolean r0 = true;
    L6:
        this.l = r0;
        O1().b();
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        String r3 = this.q;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L9;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r2.put("bot_id", r3);
        String r5 = this.r;
        if (r5 != null) goto L12;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        r2.put("message_id", r5);
        String r6 = this.s;
        if (r6 == null) goto L16;
        r4 = r6;
    L16:
        r2.put("conversation_id", r4);
        r2.put("duration", System.currentTimeMillis() - this.p);
        r2.put("cnt", this.v.size());
        r2.put("enter_method", this.u);
        ArrayList<MediaEntity> r7 = this.m;
        if (r7 == null) goto L21;
        MediaEntity r8 = (MediaEntity) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L21;
        String r9 = r8.getItem_id();
    L22:
        r2.put("video_id", r9);
        Unit r10 = Unit.INSTANCE;
        r1.reportEvent("leave_video_layer", r2);
        return;
    L21:
        r9 = null;
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        if (this.l == false) goto L6;
        O1().play();
        this.l = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View N1(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void P1(String r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        String r2 = this.q;
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 != null) goto L5;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r1.put("bot_id", r2);
        String r4 = this.r;
        if (r4 != null) goto L8;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r1.put("message_id", r4);
        String r5 = this.s;
        if (r5 == null) goto L12;
        r3 = r5;
    L12:
        r1.put("conversation_id", r3);
        r1.put("to_status", r6);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("click_video_player", r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [l2a.f] */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r7);
        N1(getWindow()).setBackgroundColor(getResources().getColor(R.color.transparent));
        setRootView(N1(getWindow()));
        int r8 = d.a;
        d.a(this, new l2a.c(), new l2a.d(), null, new l2a.f(this), 8);
        u.f(this, false);
        Lazy r0 = q3.a;
        z3 r1 = q3.a();
        String r2 = null;
        if (r1 == null) goto L13;
        r1.n(null);
    L13:
        Intent r3 = getIntent();
        if (r3 == null) goto L88;
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L18;
        String r5 = r4.getString("media_error_msg");
    L19:
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        String r9 = NameKeys.UnloadStrategy_No_Strategy;
        if (r6 == true) goto L34;
        s r10 = s.a;
        Bundle r11 = r3.getExtras();
        if (r11 == null) goto L33;
        String r12 = r11.getString("media_error_msg");
        if (r12 == null) goto L33;
        r9 = r12;
    L33:
        r10.getClass();
        s.c(this, r9);
    L99:
        boolean r13 = false;
    L101:
        if (r13 == true) goto L103;
        finish();
        return;
    L103:
        setContentView(2131561800);
        this.g = findViewById(2131387318);
        this.h = findViewById(2131384076);
        ImageView r14 = (ImageView) findViewById(2131363770);
        if (r14 == null) goto L106;
        r14.setOnClickListener(new i(this));
    L106:
        R1();
        RecyclerView r15 = this.h;
        if (r15 == null) goto L109;
        r15.setKeepScreenOn(true);
    L109:
        TtsClientDelegate.b.cancel("VideoActivity onCreate", false);
        this.p = System.currentTimeMillis();
        return;
    L34:
        Bundle r16 = r3.getExtras();
        if (r16 == null) goto L37;
        Serializable r17 = r16.getSerializable("_media_arg_key");
    L38:
        if (r17 != null) goto L40;
        boolean r18 = true;
    L41:
        if (r18 == false) goto L88;
        Bundle r19 = r3.getExtras();
        if (r19 == null) goto L45;
        Serializable r20 = r19.getSerializable("_media_arg_key");
    L46:
        this.m = (ArrayList) r20;
        Bundle r21 = r3.getExtras();
        if (r21 == null) goto L49;
        Serializable r22 = r21.getSerializable("_media_container_key");
    L51:
        if ((r22 instanceof MediaEntityContainer) == false) goto L53;
        MediaEntityContainer r23 = (MediaEntityContainer) r22;
    L54:
        this.n = r23;
        Bundle r24 = r3.getExtras();
        if (r24 == null) goto L57;
        Integer r25 = Integer.valueOf(r24.getInt("_media_video_source_key"));
    L58:
        this.o = r25;
        Bundle r26 = r3.getExtras();
        if (r26 == null) goto L61;
        String r27 = r26.getString("key_bot_id");
    L62:
        this.q = r27;
        Bundle r28 = r3.getExtras();
        if (r28 == null) goto L65;
        String r29 = r28.getString("key_message_id");
    L66:
        this.r = r29;
        Bundle r30 = r3.getExtras();
        if (r30 == null) goto L69;
        r2 = r30.getString("key_conversation_id");
    L69:
        this.s = r2;
        Bundle r31 = r3.getExtras();
        if (r31 == null) goto L72;
        int r32 = r31.getInt("key_video_index");
    L73:
        this.t = r32;
        Bundle r33 = r3.getExtras();
        if (r33 == null) goto L79;
        String r34 = r33.getString("key_enter_method");
        if (r34 == null) goto L79;
        r9 = r34;
    L79:
        this.u = r9;
        Bundle r35 = r3.getExtras();
        if (r35 == null) goto L82;
        boolean r36 = r35.getBoolean("key_api_post_video_model");
    L83:
        this.w = r36;
        Intent r37 = getIntent();
        if (r37 == null) goto L86;
        boolean r38 = r37.getBooleanExtra("key_use_share_anim", false);
    L87:
        this.y = r38;
        goto L88
    L86:
        r38 = false;
        goto L87
    L82:
        r36 = false;
        goto L83
    L72:
        r32 = 0;
        goto L73
    L65:
        r29 = null;
        goto L66
    L61:
        r27 = null;
        goto L62
    L57:
        r25 = null;
        goto L58
    L53:
        r23 = null;
        goto L54
    L49:
        r22 = null;
        goto L51
    L45:
        r20 = null;
        goto L46
    L40:
        r18 = r17 instanceof ArrayList;
        goto L41
    L37:
        r17 = null;
        goto L38
    L21:
        if (r5.length() == 0) goto L24;
        r6 = false;
        goto L25
    L18:
        r5 = null;
    L88:
        ArrayList<MediaEntity> r39 = this.m;
        if (r39 != null) goto L91;
    L94:
        boolean r40 = true;
    L95:
        if (r40 == true) goto L99;
        if (this.n == null) goto L99;
        r13 = true;
        goto L101
    L91:
        if (r39.isEmpty() == true) goto L94;
        r40 = false;
        goto L95
    }

    public final void Q1(int r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "status");
        if (r5 != r6) goto L5;
        return;
    L5:
        CommonVideoModel r8 = this.j;
        if (r8 == null) goto L10;
        ArrayList r9 = r8.getItems();
        if (r9 == null) goto L10;
        int r10 = r9.size();
    L11:
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r10 <= r6) goto L23;
        Set<String> r11 = this.v;
        CommonVideoModel r2 = this.j;
        if (r2 == null) goto L21;
        ArrayList r3 = r2.getItems();
        if (r3 == null) goto L21;
        MediaEntity r12 = (MediaEntity) ListProtector.get(r3, r6);
        if (r12 == null) goto L21;
        String r13 = r12.getItem_id();
        if (r13 == null) goto L21;
    L22:
        r11.add(r13);
    L21:
        r13 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        com.larus.platform.service.o r14 = com.larus.platform.service.o.a;
        JSONObject r15 = new JSONObject();
        String r4 = this.q;
        if (r4 != null) goto L26;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        r15.put("bot_id", r4);
        String r16 = this.r;
        if (r16 != null) goto L29;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L29:
        r15.put("message_id", r16);
        String r17 = this.s;
        if (r17 == null) goto L33;
        r1 = r17;
    L33:
        r15.put("conversation_id", r1);
        r15.put("status", r7);
        Unit r18 = Unit.INSTANCE;
        r14.reportEvent("swipe_video", r15);
        return;
    L10:
        r10 = 0;
        goto L11
    }
}
