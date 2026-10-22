package wt0;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.api.ProfitApi;
import com.bytedance.android.live.profit.util.ProfitNitaViewInfo;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import dr2.h;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zt0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class d implements yt0.a, o {
    public d() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    @Override // yt0.b
    public List<zo2.a> getProfitNitaViewList() {
        ArrayList r0 = new ArrayList();
        r0.add(ProfitNitaViewInfo.TTLIVE_VIEW_USER_INFO_MVI_FOLLOW);
        return r0;
    }

    @Override // yt0.b
    public f getPrivilegeSlardarMonitor() {
        return com.bytedance.android.live.profit.privilege.e.a;
    }

    public g<?, ?> provideJsbImpl(String r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "jsbName");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (Intrinsics.areEqual(r2, "hasCart") == false) goto L7;
        return new pp2.c(r3);
    L7:
        if (Intrinsics.areEqual(r2, "openCart") == true) goto L9;
        return null;
    L9:
        return new pp2.e(r3);
    }

    @Override // yt0.b
    public void showVipEmojiTemplatePanel(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "authorId");
        KmpEnv r6 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L10;
        h r7 = vh6.c.b(h.class);
        boolean r8 = r7.checkPluginLoaded("m.l.plugin.veffect_engine");
        boolean r0 = r7.checkPluginLoaded("m.l.plugin.tools_plugin");
        boolean r9 = r7.checkPluginLoaded("com.ss.android.live.broadcast");
        if (r8 == false) goto L8;
        if (r0 == false) goto L8;
        if (r9 == true) goto L10;
    L8:
        int r10 = ToastUtil.a;
        ToastUtil.b(s1.B(2131923684), 0);
        return;
    L10:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).we();
        Activity r12 = vh6.c.b(wh6.a.class).getCurrentActivity();
        LiveDialogFragment r1 = null;
        if ((r12 instanceof FragmentActivity) == true) goto L13;
        r12 = null;
    L13:
        FragmentActivity r13 = (FragmentActivity) r12;
        if (r13 == null) goto L21;
        m r14 = m.e;
        cy0.e.a.getClass();
        sc1.a r15 = (sc1.a) r14.d(cy0.e.a.a, sc1.a.class);
        if (r15 == null) goto L18;
        r1 = r15.q0();
    L18:
        if (r1 == null) goto L22;
        FragmentManager r16 = r13.getSupportFragmentManager();
        sc1.a.r2.getClass();
        INVOKEVIRTUAL_com_bytedance_android_live_profit_ProfitServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r1, r16, "VipEmojiTemplatePanel");
        return;
    L22:
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_profit_ProfitServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(LiveDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        LiveDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // yt0.b
    public Single<com.bytedance.android.live.network.response.e<com.bytedance.android.live.profit.vip.model.b>> uploadVipCustomEmoji(int r3, String r4, MultipartTypedOutput r5) {
        Intrinsics.checkNotNullParameter(r4, "authorId");
        Intrinsics.checkNotNullParameter(r5, "typedOutput");
        return RxUtilKt.i(((ProfitApi) vh6.c.b(com.bytedance.android.livesdk.revenue.service.network.a.class).getService(ProfitApi.class)).uploadSubscribeCustomEmoji(r3, r4, r5).singleOrError());
    }
}
