package com.larus.profile.impl.mine;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.collection.profile.api.CollectServiceDelegate;
import com.larus.collection.impl.view.MineCollectFragment;
import com.larus.collection.impl.view.RevisitListTab;
import com.larus.platform.api.IFlowProfileThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.profile.api.bean.LandingTab;
import com.larus.profile.impl.creation.ProfileCreationListFragmentV2;
import com.larus.profile.impl.e2;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!J\u001c\u0010\"\u001a\u00020\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/profile/impl/mine/MyInfoAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifeCycle", "Landroidx/lifecycle/Lifecycle;", "tabSelector", "Lcom/larus/profile/impl/ProfileDefaultTabSelector;", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Lcom/larus/profile/impl/ProfileDefaultTabSelector;)V", "getTabSelector", "()Lcom/larus/profile/impl/ProfileDefaultTabSelector;", "fragments", "Ljava/util/ArrayList;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Lkotlin/collections/ArrayList;", "fragmentsHashCode", "", "addCreationFragment", "", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "removeFragment", "onLeaveMineTab", "getItemId", "containsItem", "", "itemId", "onStateChange", "state", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "onEnterMineTab", "previousPage", "", "currentItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MyInfoAdapter extends FragmentStateAdapter {
    public static final /* synthetic */ int d = 0;
    public final com.larus.profile.impl.w a;
    public final ArrayList<ProfileInfoBaseFragment> b;
    public final ArrayList<Long> c;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final boolean containsItem(long r2) {
        return this.c.contains(Long.valueOf(r2));
    }

    public final Fragment createFragment(int r4) {
        FLogger.a.i("MyInfoAdapter", "createFragment,position:" + r4);
        return (Fragment) ListProtector.get(this.b, r4);
    }

    public final long getItemId(int r3) {
        return ((Number) ListProtector.get(this.c, r3)).longValue();
    }

    public final void y2(com.larus.profile.impl.w r9) {
        FLogger.a.i("MyInfoAdapter", "addCreationFragment,tabSelector:" + r9);
        ProfileCreationListFragmentV2 r0 = new ProfileCreationListFragmentV2();
        Bundle r1 = new Bundle();
        r1.putInt("creation_mode", 1);
        r0.setArguments(r1);
        ProfileCreationListFragmentV2 r2 = new ProfileCreationListFragmentV2();
        Bundle r4 = new Bundle();
        r4.putInt("creation_mode", 2);
        r2.setArguments(r4);
        this.b.add(r0);
        this.b.add(r2);
        this.c.add(Long.valueOf(r0.hashCode()));
        this.c.add(Long.valueOf(r2.hashCode()));
        r9.a(new e2(r0.yq(1), LandingTab.PROFILE_CREATION_LIST_PUBLIC, null));
        r9.a(new e2(r2.yq(2), LandingTab.PROFILE_CREATION_LIST_PRIVATE, null));
    }

    public MyInfoAdapter(FragmentManager r5, Lifecycle r6, com.larus.profile.impl.w r7) {
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r6, "lifeCycle");
        Intrinsics.checkNotNullParameter(r7, "tabSelector");
        super(r5, r6);
        this.a = r7;
        this.b = new ArrayList();
        this.c = new ArrayList();
        IFlowProfileThemeConfigProvider r8 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r8 == null) goto L5;
        r8.a(new t(this), AdaptThemeFeatureKey.PROFILE_PAGE_FRAGMENT);
    L5:
        Iterator r9 = com.larus.collection.impl.view.t.a().iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        RevisitListTab r10 = (RevisitListTab) r9.next();
        FLogger.a.i("MyInfoAdapter", "init,addCollectFragment, scene=" + r10.getScene() + ", landingTab=" + r10.getLandingTab());
        Integer r11 = MineCollectFragment.x;
        Intrinsics.checkNotNullParameter(r10, "tab");
        ProfileInfoBaseFragment r0 = new MineCollectFragment();
        Intrinsics.checkNotNullParameter(r10, "tab");
        r0.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("arg_scene", Integer.valueOf(r10.getScene())), TuplesKt.to("arg_track_tab_name", r10.getTrackTabName()), TuplesKt.to("arg_is_like_tab", Boolean.valueOf(r10.isLikeTab()))}));
        if (r10.isLikeTab() == false) goto L11;
        CollectServiceDelegate.b.d(r0);
    L12:
        this.b.add(r0);
        this.c.add(Long.valueOf(r0.hashCode()));
        this.a.a(new e2("MineCollectFragment#" + r10.getScene(), r10.getLandingTab(), null));
        goto L7
    L11:
        CollectServiceDelegate.b.c(r0);
        goto L12
    }
}
