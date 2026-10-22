package com.larus.api.bussiness;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.media.v;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.SdkVideoFeedDelegate;
import com.larus.platform.service.o;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.l;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020 H\u0002J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0/H\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020-H\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0006H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0019H\u0016J\b\u00109\u001a\u00020\u0019H\u0016J\u0010\u0010:\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0019H\u0002J\b\u0010<\u001a\u00020\u0019H\u0002J\b\u0010=\u001a\u00020\u0019H\u0002J\b\u0010>\u001a\u00020\u0019H\u0016J+\u0010?\u001a\u00020\u00192!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u00190AH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/larus/api/bussiness/VideoChatFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "<init>", "()V", "haveShowRemindDialog", "", "mEnterTime", "", "currentViewVideoAid", "", "mLatestAid", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "autoLogEnterPage", "getCurrentPageName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "mRecordBrowserVideo", "", "isPlayFirstVideo", "haveShowAuthorizationDialog", "videoFeedConfigure", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "iPreloadVideoProvider", "processDialog", "isPlayNext", "aid", "reportSwipeVideo", "status", "reportLeave", "manualRefresh", "manualPause", "addConversationFragment", "customFeedPageConfig", "customIFeedPageListener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomIFeedPageListener;", "getPlaybackStateChangeExtra", "", "outerLister", "setFeedPageListener", "listener", "deliverHiddenChanged", "hidden", "fragment", "Landroidx/fragment/app/Fragment;", "onBackPressed", "onResume", "onPause", "onHiddenChanged", "showDouYinAuthorizationDialog", "doDouyinLogin", "doDouyinAuthorization", "onDestroy", "needShowAuthorizationDialog", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "needShowDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VideoChatFragment extends TraceFragment implements pr9.h {
    public static final /* synthetic */ int q = 0;
    public boolean e;
    public long f;
    public String g;
    public String h;
    public final com.larus.media.model.a i;
    public final Set<String> j;
    public boolean k;
    public boolean l;
    public VideoFeedConfigure m;
    public pr9.h n;
    public b o;
    public pr9.b p;

    public static final class a {
    }

    public static final class b implements pr9.b {
        public final /* synthetic */ VideoChatFragment a;

        public final pr9.d a() {
            pr9.b r0 = this.a.p;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a();
        }

        public final void onLoadSuccess() {
            pr9.b r0 = this.a.p;
            if (r0 == null) goto L6;
            r0.onLoadSuccess();
            return;
        }

        public b(VideoChatFragment r1) {
            this.a = r1;
        }

        public final void b(CustomFeedPlayerEvent r7) {
            Intrinsics.checkNotNullParameter(r7, "event");
            boolean r0 = r7 instanceof CustomFeedPlayerEvent.PausePlay;
            if (r0 == false) goto L5;
        L12:
            Lazy r1 = MediaResourceManager.a;
            MediaResourceManager.a(this.a.i);
        L14:
            if ((r7 instanceof CustomFeedPlayerEvent.StartPlay) == true) goto L16;
            if (r0 == false) goto L21;
            GlobalAudioObserver.a.c(GlobalAudioSceneEnum.VIDEO, GlobalAudioStateEnum.PAUSED, VideoChatFragment.U90(this.a));
        L26:
            pr9.b r2 = this.a.p;
            if (r2 == null) goto L30;
            r2.b(r7);
            return;
        L30:
            return;
        L21:
            if ((r7 instanceof CustomFeedPlayerEvent.ResumePlay) == false) goto L24;
            GlobalAudioObserver.a.c(GlobalAudioSceneEnum.VIDEO, GlobalAudioStateEnum.PLAYING, VideoChatFragment.U90(this.a));
            AudioServiceDelegate.a.O().e(SoundsSource.VIDEO);
            goto L26
        L24:
            if ((r7 instanceof CustomFeedPlayerEvent.StopPlay) == false) goto L26;
            GlobalAudioObserver.a.c(GlobalAudioSceneEnum.VIDEO, GlobalAudioStateEnum.STOPPED, VideoChatFragment.U90(this.a));
            goto L26
        L16:
            if (o0.d(r7.getAwemeId()) == false) goto L26;
            GlobalAudioObserver r3 = GlobalAudioObserver.a;
            r3.e(GlobalAudioSceneEnum.VIDEO, r7.getAwemeId(), null);
            r3.c(GlobalAudioSceneEnum.VIDEO, GlobalAudioStateEnum.PLAYING, VideoChatFragment.U90(this.a));
            goto L26
        L5:
            if ((r7 instanceof CustomFeedPlayerEvent.StopPlay) == true) goto L12;
            if ((r7 instanceof CustomFeedPlayerEvent.ResumePlay) == false) goto L10;
        L11:
            Lazy r4 = MediaResourceManager.a;
            final VideoChatFragment r5 = this.a;
            MediaResourceManager.m(r5.i, new d(), new e(r5), 0, 8);
            goto L14
        L10:
            if ((r7 instanceof CustomFeedPlayerEvent.StartPlay) == false) goto L14;
            goto L11
        }

        public final void onLoadError(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            pr9.b r0 = this.a.p;
            if (r0 == null) goto L6;
            r0.onLoadError(r2);
            return;
        }

        public final void c(boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "aid");
            VideoChatFragment r0 = this.a;
            r0.h = r6;
            pr9.b r1 = r0.p;
            if (r1 == null) goto L5;
            r1.c(r5, r6);
        L5:
            VideoChatFragment r2 = this.a;
            r2.j.add(r6);
            r2.g = r6;
            if (r5 == true) goto L8;
        L10:
            if (r5 == false) goto L17;
            if (r2.k == true) goto L17;
            if (r2.l == true) goto L17;
            LifecycleOwnerKt.getLifecycleScope(r2).launchWhenResumed(new VideoChatFragment$processDialog$1(r2, null));
        L17:
            if (r2.k == true) goto L24;
            if (r5 == false) goto L20;
            String r7 = "up";
        L21:
            o r3 = o.a;
            JSONObject r4 = new JSONObject();
            r4.put("video_id", r6);
            r4.put("status", r7);
            Unit r8 = Unit.INSTANCE;
            r3.reportEvent("swipe_video", r4);
            return;
        L20:
            r7 = "down";
            goto L21
        L24:
            return;
        L8:
            if (r2.k == false) goto L10;
            r2.k = false;
        }
    }

    public static final class c implements v {
        public final /* synthetic */ VideoChatFragment a;

        public c(VideoChatFragment r1) {
            this.a = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r0 = com.larus.media.o0.a;
            return com.larus.media.o0.a("VIDEO", r2.getScene());
        }

        public final void e(lk9.g r1) {
            v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            qr9.b r0 = VideoFeedProviderDelegate.b.getTopPlayerController();
            if (r0 == null) goto L5;
            r0.playPlayer();
        L5:
            v.a.f(r2, r3);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            v.a.g(r1, r2);
        }

        public final void i(lk9.g r2, lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            v.a.e(r2, r3);
            FLogger.a.i("VideoChatFragment", "Manual pause current video");
            final VideoChatFragment r4 = this.a;
            t0.e(new g(r4));
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r4 = com.larus.media.o0.a;
            return com.larus.media.o0.b("VIDEO", r2.getScene());
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final Fragment f() {
        return this;
    }

    public final String k() {
        return "";
    }

    public final void onDestroy() {
        this.p = null;
        this.o = null;
        pr9.h r0 = this.n;
        if (r0 == null) goto L5;
        r0.xQ(new pr9.e());
    L5:
        AudioServiceDelegate.a.O().d(SoundsSource.VIDEO);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void N7() {
        pr9.h r0 = this.n;
        if (r0 == null) goto L6;
        r0.N7();
        return;
    }

    public final void V5() {
        pr9.h r0 = this.n;
        if (r0 == null) goto L6;
        r0.V5();
        return;
    }

    public final boolean onBackPressed() {
        pr9.h r0 = this.n;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onBackPressed();
    }

    public VideoChatFragment() {
        int r11 = MediaLevel.PLAY_HIGH.getValue();
        this.i = new com.larus.media.model.a(null, "VIDEO", true, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, r11, false, new c(this), 1449);
        this.j = new LinkedHashSet();
        this.k = true;
        this.o = new b(this);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        VideoFeedConfigure r0 = this.m;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.c != true) goto L7;
    L8:
        if (r1 == true) goto L36;
        Bundle r2 = getArguments();
        if (r2 == null) goto L16;
        String r3 = r2.getString("key_leave_trace_info");
        if (r3 == null) goto L16;
        JSONObject r4 = new JSONObject(r3);     // Catch: JSONException -> L32
    L17:
        if (r4 != null) goto L19;
        r4 = new JSONObject();
    L19:
        VideoFeedConfigure r5 = this.m;
        if (r5 == null) goto L27;
        JSONObject r6 = r5.g;
        if (r6 == null) goto L27;
        Iterator<String> r7 = r6.keys();
    L25:
        if (r7.hasNext() == false) goto L27;
        String r8 = r7.next();
        r4.put(r8, r6.get(r8));
    L27:
        o r9 = o.a;
        String r10 = this.h;
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        r4.put("video_id", r10);
        r4.put("duration", System.currentTimeMillis() - this.f);
        r4.put("cnt", this.j.size());
        Unit r11 = Unit.INSTANCE;
        r9.reportEvent("leave_video_layer", r4);
        this.j.clear();
        return;
    L16:
        r4 = null;
        goto L17
    L36:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onResume() {
        super.onResume();
        this.f = System.currentTimeMillis();
        String r0 = this.g;
        if (r0 == null) goto L6;
        this.j.add(r0);
        return;
    }

    public static final Map U90(VideoChatFragment r4) {
        r4.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        VideoFeedConfigure r5 = r4.m;
        if (r5 == null) goto L17;
        JSONObject r6 = r5.d;
        if (r6 == null) goto L17;
        String r2 = "";
        String r1 = r6.optString("host_conversation_id", "");
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0.put("conversation_id", r1);
        String r3 = r6.optString("host_message_id", "");
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r0.put("message_id", r3);
        String r7 = r6.optString("host_bot_id", "");
        if (r7 == null) goto L16;
        r2 = r7;
    L16:
        String r8 = (String) r0.put("bot_id", r2);
    L17:
        r0.put("current_page", GlobalAudioSceneEnum.VIDEO);
        return r0;
    }

    public final void onHiddenChanged(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(r2);
        pr9.h r0 = this.n;
        if (r0 == null) goto L8;
        Fragment r1 = r0.f();
        if (r1 == null) goto L9;
        r1.onHiddenChanged(r2);
        return;
    L9:
        return;
    }

    public final void xQ(pr9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.p = r2;
        Looper r0 = Looper.myLooper();
        Intrinsics.checkNotNull(r0);
        new Handler(r0).post(new com.larus.api.bussiness.b(this));
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        VideoFeedConfigure r6 = (VideoFeedConfigure) l.b(this, "VideoFeedConfigure");
        if (r6 != null) goto L5;
        return;
    L5:
        this.m = r6;
        pr9.h r7 = SdkVideoFeedDelegate.b.c(getChildFragmentManager(), r6);
        this.n = r7;
        if (r7 == null) goto L16;
        Fragment r8 = r7.f();
        if (r8 == null) goto L17;
        FragmentTransaction r9 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L14;
        r9.add(2131373275, r8);
    L14:
        r9.commit();
        return;
    L17:
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return getLayoutInflater().inflate(2131562394, null);
    }
}
