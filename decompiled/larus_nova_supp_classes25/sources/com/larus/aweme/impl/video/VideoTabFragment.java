package com.larus.aweme.impl.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.larus.aweme.api.video.service.AwemeVideoFeedDelegate;
import com.larus.aweme.impl.databinding.LarusPageVideoTabBinding;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.FirstFeedSceneEnum;
import com.larus.bmhome.utils.f2;
import com.larus.home.impl.sdk.i;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.AccountService;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.larus.utils.v;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pr9.d;
import pr9.e;
import pr9.h;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J \u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u000b2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0017H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/aweme/impl/video/VideoTabFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/aweme/api/video/IVideoTabFragment;", "<init>", "()V", "binding", "Lcom/larus/aweme/impl/databinding/LarusPageVideoTabBinding;", "operateFeedFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "isRefreshing", "", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "", "bundle", "onViewCreated", "view", "autoLogEnterPage", "onDestroy", "getCurrentPageName", "", "tabIndex", "", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "onManualPause", "onResume", "onPause", "handleStatusBarMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VideoTabFragment extends BaseHomeTabFragment implements s19.a, ka8.a {
    public LarusPageVideoTabBinding j;
    public h k;
    public boolean l;
    public FragmentExtKt.addOnBackPressed.callback.1 m;

    public static final class a {
    }

    public static final class b extends e {
        public final /* synthetic */ VideoTabFragment a;

        public static final class a implements d {
            public final /* synthetic */ VideoTabFragment a;

            public final void g() {
            }

            public final void onRefreshFinish() {
                this.a.l = false;
                FLogger.a.d("VideoTabFragment", "[onRefreshFinish]");
            }

            public final void onRefreshStartManually() {
                this.a.l = true;
                FLogger.a.d("VideoTabFragment", "[onRefreshStartManually]");
            }

            public final void onReleaseAndRefresh() {
                this.a.l = true;
                FLogger.a.d("VideoTabFragment", "[onReleaseAndRefresh]");
            }

            public final void onReleaseAndScrollBack() {
                FLogger.a.d("VideoTabFragment", "[onReleaseAndScrollBack]");
            }

            public a(VideoTabFragment r1) {
                this.a = r1;
            }
        }

        public final d a() {
            return new a(this.a);
        }

        public b(VideoTabFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public VideoTabFragment() {
        super(true);
    }

    public final boolean S90() {
        return false;
    }

    public final void a2(Bundle r1) {
    }

    public final String k() {
        return "video_tab";
    }

    public final void t1() {
    }

    @Override // ka8.a
    public final void MZ() {
        h r0 = this.k;
        if (r0 == null) goto L6;
        r0.V5();
        return;
    }

    public final int sb() {
        return BaseHomeTabFragment.MainTab.VIDEO.getIndex();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.m;
        if (r0 == null) goto L6;
        r0.remove();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if ((getResources().getConfiguration().uiMode & 48) != 16) goto L7;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        u.e(r0, true, false);
    L7:
        FragmentExtKt.addOnBackPressed.callback.1 r1 = this.m;
        if (r1 == null) goto L11;
        r1.remove();
        return;
    }

    @Override // com.larus.bmhome.BaseHomeTabFragment
    public final void onResume() {
        super.onResume();
        if (this.e == false) goto L14;
        VideoFeedProviderDelegate r0 = VideoFeedProviderDelegate.b;
        qr9.b r3 = r0.getTopPlayerController();
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L14;
        qr9.b r1 = r0.getTopPlayerController();
        if (r1 == null) goto L14;
        r1.playPlayer();
        goto L14
    L7:
        if (r3.a() != true) goto L9;
        r4 = true;
    L14:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L17;
        u.e(r2, false, true);
    L17:
        this.m = v.a(this, new ma8.b(this));
    }

    public final void y2(String r6) {
        Bundle r0 = getArguments();
        String r2 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getString("is_from_push");
    L7:
        if (Intrinsics.areEqual(r1, "true") == true) goto L9;
        String r3 = "click_navigate_video";
    L10:
        Bundle r4 = getArguments();
        if (r4 == null) goto L14;
        r2 = r4.getString("is_from_push");
    L14:
        if (Intrinsics.areEqual(r2, "true") == false) goto L17;
        r6 = "landing";
    L17:
        a1.d("video_tab", r3, r6, "bottom_tab", 48);
        return;
    L9:
        r3 = "outer_push";
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void KC(boolean r2, Function0<Unit> r3) {
        if (this.l == true) goto L8;
        FLogger.a.d("VideoTabFragment", "[manualRefresh]");
        h r4 = this.k;
        if (r4 == null) goto L9;
        r4.N7();
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L5;
        r7.f0();
        i r8 = i.a;
    L7:
        if (r8 == null) goto L11;
        boolean r1 = true;
        if (r8.c() != true) goto L11;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        Bundle r9 = getArguments();
        if (r9 == null) goto L17;
        String r10 = r9.getString("is_from_push");
    L19:
        if (Intrinsics.areEqual(r10, "true") == true) goto L21;
        EnterVideoMethod r11 = EnterVideoMethod.BOTTOM_TAB;
    L22:
        Bundle r2 = getArguments();
        if (r2 == null) goto L25;
        r2.remove("is_from_push");
    L25:
        or9.d r3 = new or9.d();
        r3.g = false;
        Intrinsics.checkNotNullParameter(r11, "enterVideoMethod");
        r3.a = r11;
        r3.t = false;
        r3.z = false;
        Long r12 = StringsKt.toLongOrNull(AccountService.a.getUserId());
        if (r12 == null) goto L28;
        long r4 = r12.longValue();
    L29:
        r3.q = r4;
        r3.w = 0;
        String r13 = AwemeVideoFeedDelegate.b.getSceneId();
        if (r13 != null) goto L32;
        r13 = "";
    L32:
        Intrinsics.checkNotNullParameter(r13, "sceneID");
        r3.p = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L38;
        String r15 = r14.getString("item_id");
        if (r15 == null) goto L38;
        List r16 = CollectionsKt.listOf(r15);
        Intrinsics.checkNotNullParameter(r16, "itemIDList");
        r3.b = r16;
    L38:
        h r17 = VideoFeedProviderDelegate.b.i(r3.a());
        this.k = r17;
        r17.xQ(new b(this));
        Fragment r18 = r17.f();
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L42;
        r0.replace(2131373275, r18);
    L42:
        r0.commit();
        return;
    L28:
        r4 = -1;
        goto L29
    L21:
        r11 = EnterVideoMethod.OUTER_PUSH;
        goto L22
    L17:
        r10 = null;
    L11:
        r1 = false;
        goto L12
    L5:
        r8 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = getLayoutInflater().inflate(2131563080, r3, false);
        if (r5 == null) goto L15;
        FrameLayout r6 = (FrameLayout) r5;
        this.j = new LarusPageVideoTabBinding(r6, r6);
        if (f2.a != FirstFeedSceneEnum.VIDEO_FEED) goto L7;
        f2.a(r6, "VideoTabFragment");
    L7:
        LarusPageVideoTabBinding r7 = this.j;
        if (r7 == null) goto L12;
        FrameLayout r8 = r7.a;
        if (r8 == null) goto L12;
        r8.setTag(2131377847, this);
        return r8;
    L12:
        return null;
    L15:
        throw new NullPointerException("rootView");
    }
}
