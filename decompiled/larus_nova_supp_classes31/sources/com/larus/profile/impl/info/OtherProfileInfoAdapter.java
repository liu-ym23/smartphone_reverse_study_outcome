package com.larus.profile.impl.info;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.profile.api.bean.LandingTab;
import com.larus.profile.impl.ProfileBotListFragment;
import com.larus.profile.impl.creation.ProfileCreationListFragmentV2;
import com.larus.profile.impl.e2;
import com.larus.settings.value.e10;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0019H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0012j\b\u0012\u0004\u0012\u00020\u0003`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/profile/impl/info/OtherProfileInfoAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "enterFrom", "", "tracePageName", "mobPageName", "userId", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "tabSelector", "Lcom/larus/profile/impl/ProfileDefaultTabSelector;", "shouldPropagateAICreationAppletSource", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/RecommendFrom;Lcom/larus/profile/impl/ProfileDefaultTabSelector;Z)V", "fragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isPublic", "isSelfProfile", "addCreationFragment", "", "getItemCount", "", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OtherProfileInfoAdapter extends FragmentStateAdapter {
    public final boolean a;
    public final ArrayList<Fragment> b;

    public final int getItemCount() {
        return this.b.size();
    }

    public final Fragment createFragment(int r2) {
        return (Fragment) ListProtector.get(this.b, r2);
    }

    public final void y2(Fragment r6, String r7, com.larus.profile.impl.w r8) {
        Fragment r0 = new ProfileCreationListFragmentV2();
        Bundle r1 = new Bundle();
        r1.putString("user_id", r7);
        r1.putInt("creation_mode", 4);
        int r9 = a.c;
        boolean r10 = this.a;
        Intrinsics.checkNotNullParameter(r1, "target");
        if (r10 == false) goto L6;
        r1.putBoolean("from_ai_creation_applet", true);
    L6:
        if ((r6 instanceof by7.e) == false) goto L8;
        r1.putString("previous_page", TrackParams.optString$default(by7.h.a((by7.e) r6), "previous_page", null, 2, null));
    L8:
        r0.setArguments(r1);
        this.b.add(r0);
        r8.a(new e2(r0.yq(4), LandingTab.PROFILE_CREATION_LIST, null));
    }

    public OtherProfileInfoAdapter(Fragment r17, String r18, String r19, RecommendFrom r20, com.larus.profile.impl.w r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "fragment");
        Intrinsics.checkNotNullParameter(r18, "enterFrom");
        Intrinsics.checkNotNullParameter("self_created_bot_list", "tracePageName");
        Intrinsics.checkNotNullParameter("bot_list_others", "mobPageName");
        Intrinsics.checkNotNullParameter(r19, "userId");
        Intrinsics.checkNotNullParameter(r21, "tabSelector");
        super(r17);
        this.a = r22;
        ArrayList<Fragment> r6 = new ArrayList();
        this.b = r6;
        z2 r9 = z2.a;
        if (r9.I2() == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        boolean r13 = Intrinsics.areEqual(r19, ILoginService.a.getAccountInfo().c);
        if (com.larus.bmhome.utils.u.g() == false) goto L16;
        if (AccountService.a.isLogin().booleanValue() == false) goto L16;
        e10 r14 = e10.a;
        if (e10.u0().a() == false) goto L16;
        y2(r17, r19, r21);
    L16:
        if (r9.x3().shouldHideProfileBotTab(r13) == true) goto L25;
        e10 r11 = e10.a;
        if (e10.B0() == false) goto L20;
        if (r13 == false) goto L25;
    L20:
        ProfileBotListFragment r12 = new ProfileBotListFragment();
        Bundle r15 = new Bundle();
        r15.putString("bot_mob_page_name", "bot_list_others");
        r15.putString("bot_enter_from", r18);
        r15.putString("bot_trace_page", "self_created_bot_list");
        r15.putBoolean("bot_is_self", false);
        r15.putParcelable("setting_bot_recommend_from", r20);
        int r2 = a.c;
        Intrinsics.checkNotNullParameter(r15, "target");
        if (r22 == false) goto L23;
        r15.putBoolean("from_ai_creation_applet", true);
    L23:
        r12.setArguments(r15);
        r6.add(r12);
        r21.a(new e2(ProfileBotListFragment.class.getName(), LandingTab.PROFILE_BOT_LIST, null));
    L25:
        if (com.larus.bmhome.utils.u.g() == true) goto L27;
    L31:
        if (r10 == false) goto L34;
        ProfileInfoBaseFragment r1 = IAIChatAudioService.a.l();
        Bundle r3 = new Bundle();
        r3.putString("key_language_code", "");
        r3.putString("public_voice_user_id", r19);
        r3.putString("key_public_voice_scene", "other_profile");
        r1.setArguments(r3);
        r6.add(r1);
        r21.a(new e2(r1.getClass().getName(), LandingTab.PUBLIC_VOICE_LIST, null));
        return;
    L34:
        return;
    L27:
        if (AccountService.a.isLogin().booleanValue() == false) goto L31;
        e10 r4 = e10.a;
        if (e10.u0().a() == true) goto L31;
        y2(r17, r19, r21);
        goto L31
    L5:
        if (r9.D2() == false) goto L7;
        r10 = true;
        goto L8
    }
}
