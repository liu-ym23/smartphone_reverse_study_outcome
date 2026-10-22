package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.a0;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.z2;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.utils.y;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class FlowSocialSettingsProvider implements i {
    public static final FlowSocialSettingsProvider a = null;

    static {
        a = new FlowSocialSettingsProvider();
    }

    public FlowSocialSettingsProvider() {
    }

    @Override // com.larus.setting.api.i
    public final void a(FragmentActivity r10, FlowSettingsScene r11, final Function1<? super List<zs9.c>, Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "completion");
        OfficeSDKUserApi r2 = null;
        if (r11 != FlowSettingsScene.ADD_MY_WAY) goto L12;
        int r13 = m.a;
        Intrinsics.checkNotNullParameter(r12, "completion");
        Object r14 = xp9.o.a;
        if ((r14 instanceof OfficeSDKUserApi) == false) goto L7;
        r2 = (OfficeSDKUserApi) r14;
    L7:
        if (r2 == null) goto L50;
        ktb.a r15 = r2.getService(ktb.a.class);
        if (r15 == null) goto L51;
        r15.V7(new o(r12));
        return;
    L51:
        return;
    L50:
        return;
    L12:
        if (r11 != FlowSettingsScene.FIND_MY_WAY) goto L19;
        if (r10 == null) goto L48;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r10);
        if (r3 == null) goto L49;
        BuildersKt.launch$default(r3, null, null, new FlowSocialSettingsProvider$fetchSections$1(r12, r10, null), 3, null);
        return;
    L49:
        return;
    L48:
        return;
    L19:
        if (r11 != FlowSettingsScene.NOTIFY) goto L53;
        final ArrayList r16 = new ArrayList();
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == true) goto L23;
    L25:
        boolean r1 = false;
    L26:
        a0.z1.getClass();
        boolean r4 = a0.a.b;
        if (r1 == true) goto L29;
        if (r4 == true) goto L29;
    L34:
        if (r1 == false) goto L46;
        int r5 = m.a;
        Intrinsics.checkNotNullParameter(r16, "result");
        Intrinsics.checkNotNullParameter(r12, "completion");
        Object r0 = xp9.o.a;
        if ((r0 instanceof OfficeSDKUserApi) == false) goto L38;
        OfficeSDKUserApi r6 = (OfficeSDKUserApi) r0;
    L39:
        if (r6 == null) goto L43;
        aza.d r7 = r6.getService(aza.d.class);
        if (r7 == null) goto L43;
        r2 = r7.E4();
    L43:
        if (r2 != null) goto L45;
        y.c(new j(r12, r16));
        return;
    L45:
        r2.a(new q(r16, r10, r12));
        return;
    L38:
        r6 = null;
        goto L39
    L46:
        r12.invoke(r16);
        return;
    L29:
        List<zs9.c> r8 = SettingService.a.a(r10);
        if (r8 != null) goto L33;
        r8 = CollectionsKt.emptyList();
    L33:
        r16.addAll(r8);
        goto L34
    L23:
        if (z2.a.q().n == false) goto L25;
        r1 = true;
        goto L26
    }
}
