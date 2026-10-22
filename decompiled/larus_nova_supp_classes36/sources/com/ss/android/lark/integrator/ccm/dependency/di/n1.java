package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.profile.HalfProfileLauncher;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.profile_api.IProfileApi;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import javax.inject.Inject;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class n1 implements com.bytedance.ee.bear.lark.dependency.c0 {
    public final void onDestroy() {
    }

    @Inject
    public n1() {
    }

    public final Pair<Fragment, r1c.a> j4(UserSession r3, String r4, String r5) {
        Bundle r0 = new Bundle();
        r0.putString("param_key_user_id", r4);
        ContactSource r6 = new ContactSource();
        r6.setSourceType(4);
        r6.setSourceName(r5);
        r0.putSerializable("param_key_source", r6);
        PassportcConvention.h(r0, r3);
        return ((IProfileApi) ApiUtils.getApi(IProfileApi.class)).buildProfileFragment(r0);
    }

    public final void eb(final Context r3, final String r4, final String r5, final boolean r6) {
        RxScheduledExecutor.execInIO(new l1(r4), new m1(r3, r4, r5, r6));
    }

    public final void D1(Fragment r1, UserSession r2, String r3, String r4, String r5, String r6, com.bytedance.ee.bear.lark.dependency.c0.a r7) {
        HalfProfileLauncher.b(r1, r2, r3, r4, r5, r6, r7);
    }

    public final void Wb(FragmentActivity r1, FragmentManager r2, UserSession r3, String r4, String r5, String r6, String r7, com.bytedance.ee.bear.lark.dependency.c0.a r8) {
        HalfProfileLauncher.a(r1, r2, r3, r4, r5, r6, r7, r8);
    }
}
