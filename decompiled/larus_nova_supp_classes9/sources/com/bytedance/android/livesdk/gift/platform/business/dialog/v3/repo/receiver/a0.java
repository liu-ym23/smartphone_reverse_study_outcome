package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.Pair;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(a0.class, "groupLiveCompetitionListSelectedUser", "getGroupLiveCompetitionListSelectedUser()Lkotlin/Pair;", 1))};
        b = SpongePreferenceManager.a().a("live_gift_group_live_competition_list_selected_user", new Pair(BuildConfig.FLAVOR, vh7.f.c(IBaseUser.class)), rl3.a.c);
    }
}
