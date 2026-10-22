package com.larus.bmhome.video.fragment;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.utils.c4;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.home.impl.sdk.SdkWatermarkServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020#H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020#H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/video/fragment/VideoDetailPagerFragment;", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment;", "Landroidx/viewbinding/ViewBinding;", "<init>", "()V", "pagerAdapter", "Lcom/larus/bmhome/video/fragment/VideoDetailPagerFragment$VideoDetailPagerAdapter;", "initList", "", "Lcom/larus/platform/model/video/VideoPlayData;", "getInitList", "()Ljava/util/List;", "setInitList", "(Ljava/util/List;)V", "initPosition", "", "getInitPosition", "()I", "setInitPosition", "(I)V", "videoDetailScene", "Lcom/larus/bmhome/video/bean/VideoDetailScene;", "getVideoDetailScene", "()Lcom/larus/bmhome/video/bean/VideoDetailScene;", "setVideoDetailScene", "(Lcom/larus/bmhome/video/bean/VideoDetailScene;)V", "eventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "getEventParams", "()Lcom/larus/bmhome/utils/VideoDetailEventParams;", "hasReportedClose", "", "getPagerAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "initView", "", "savedInstanceState", "Landroid/os/Bundle;", "getFeedDirection", "needCommonSlide", "onStart", "onStop", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment$ContainerEvent;", "getCurrentFragment", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "getEventParamFromScene", "scene", "clickBackCallback", "initViewBinding", "Companion", "VideoDetailPagerAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoDetailPagerFragment extends CommonSlideDialogFragment<ViewBinding> {
    public VideoDetailPagerAdapter i;
    public List<nr9.g> j;
    public os8.b k;
    public boolean l;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/video/fragment/VideoDetailPagerFragment$VideoDetailPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "scene", "Lcom/larus/bmhome/video/bean/VideoDetailScene;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/larus/bmhome/video/bean/VideoDetailScene;)V", "realList", "", "Lcom/larus/platform/model/video/VideoPlayData;", "getRealList", "()Ljava/util/List;", "setRealList", "(Ljava/util/List;)V", "getItemCount", "", "initData", "", "list", "createFragment", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VideoDetailPagerAdapter extends FragmentStateAdapter {
        public final os8.b a;
        public List<nr9.g> b;

        public static final class a {
        }

        static {
        }

        public final int getItemCount() {
            return this.b.size();
        }

        public final Fragment createFragment(int r3) {
            nr9.g r4 = (nr9.g) ListProtector.get(this.b, r3);
            os8.b r0 = this.a;
            if ((r0 instanceof os8.b.a) == false) goto L11;
            AiGenVideoDetailFragment r1 = new AiGenVideoDetailFragment(r4, ((os8.b.a) this.a).b);
            if (((os8.b.a) this.a).c.length() <= 0) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == false) goto L19;
            a0.a r6 = new a0.a();
            r6.b(((os8.b.a) this.a).c);
            r6.a(((os8.b.a) this.a).d);
            a0 r7 = r6.a;
            Intrinsics.checkNotNullParameter(r7, "config");
            r1.u = r7;
            return r1;
        L19:
            return r1;
        L7:
            r5 = false;
            goto L8
        L11:
            if (Intrinsics.areEqual(r0, os8.b.C0128b.a) == false) goto L14;
            return new Fragment();
        L14:
            if ((r0 instanceof os8.b.c) == false) goto L18;
            UserVideoDetailFragment r2 = new UserVideoDetailFragment(r4, ((os8.b.c) this.a).b);
            r2.y = ((os8.b.c) this.a).c;
            return r2;
        L18:
            throw new NoWhenBranchMatchedException();
        }

        public VideoDetailPagerAdapter(Fragment r2, os8.b r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "scene");
            super(r2);
            this.a = r3;
            this.b = new ArrayList();
        }
    }

    public static final class a {
    }

    static {
    }

    public final int aa0() {
        return 0;
    }

    public final ViewBinding ea0() {
        return null;
    }

    public final void T90() {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        List<nr9.g> r0 = this.j;
        if (r0 == null) goto L10;
        nr9.g r1 = (nr9.g) CollectionsKt.getOrNull(r0, 0);
        if (r1 == null) goto L10;
        String r2 = r1.a;
    L11:
        a4.i(r2, ma0().b, ma0().a, ma0().c, ma0().g, null, 224);
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final FragmentStateAdapter ca0() {
        if (this.i != null) goto L6;
        this.i = new VideoDetailPagerAdapter(this, this.k);
    L6:
        return this.i;
    }

    public final c4 ma0() {
        os8.b r1 = this.k;
        if ((r1 instanceof os8.b.a) == false) goto L6;
        return ((os8.b.a) r1).b;
    L6:
        if (Intrinsics.areEqual(r1, os8.b.C0128b.a) == false) goto L9;
        return new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    L9:
        if ((r1 instanceof os8.b.c) == false) goto L13;
        return ((os8.b.c) r1).b;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public VideoDetailPagerFragment() {
        this.k = os8.b.C0128b.a;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L9;
        r1.m0();
        SdkWatermarkServiceImpl.a.d(r0);
        return;
    L9:
        return;
    }

    public final void onStop() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L7;
        r1.m0();
        SdkWatermarkServiceImpl.a.e(r0);
    L7:
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public final void Y90(CommonSlideDialogFragment.b r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof CommonSlideDialogFragment.b.e) == false) goto L25;
        g19.a r0 = null;
        LarusFragmentCommonSlideBinding r1 = ((CommonSlideDialogFragment) this).d;     // Catch: Exception -> L18
        if (r1 == null) goto L8;
        ViewPager2 r2 = r1.c;     // Catch: Exception -> L18
    L9:
        if (r2 == null) goto L20;
        int r3 = r2.getCurrentItem();     // Catch: Exception -> L18
        VideoDetailPagerAdapter r4 = this.i;     // Catch: Exception -> L18
        if (r4 == null) goto L13;
        long r5 = r4.getItemId(r3);     // Catch: Exception -> L18
    L14:
        Fragment r7 = getChildFragmentManager().findFragmentByTag("f" + r5);     // Catch: Exception -> L18
        if ((r7 instanceof g19.a) == false) goto L20;
        r0 = (g19.a) r7;     // Catch: Exception -> L18
        goto L20
    L13:
        r5 = 0;
    L20:
        if (r0 == null) goto L26;
        r0.d70();
        return;
    L26:
        return;
    L8:
        r2 = null;
    L18:
        e = move-exception;
        FLogger.a.e("TemplateImagePagerFragment", "getCurrentFragment error e=" + e.getMessage());
        goto L20
    }

    public final void da0(Bundle r4) {
        super.da0(r4);
        LarusFragmentCommonSlideBinding r5 = ((CommonSlideDialogFragment) this).d;
        if (r5 == null) goto L5;
        ViewPager2 r6 = r5.c;
    L6:
        boolean r0 = false;
        if (r6 == null) goto L9;
        r6.setUserInputEnabled(false);
    L9:
        W90();
        VideoDetailPagerAdapter r7 = this.i;
        if (r7 == null) goto L20;
        List<nr9.g> r1 = this.j;
        if (r1 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L21;
        ArrayList r2 = new ArrayList();
        r2.addAll(r1);
        r7.b = r2;
        return;
    L21:
        return;
    L14:
        if (r1.isEmpty() == false) goto L16;
    L20:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
