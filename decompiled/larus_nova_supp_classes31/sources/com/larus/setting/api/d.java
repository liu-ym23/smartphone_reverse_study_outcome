package com.larus.setting.api;

import androidx.fragment.app.FragmentActivity;
import com.larus.setting.api.data.FlowSettingsScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements i {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // com.larus.setting.api.i
    public final void a(FragmentActivity r2, FlowSettingsScene r3, Function1<? super List<zs9.c>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "completion");
        if (r3 != FlowSettingsScene.NOTIFY) goto L10;
        int r5 = t.a;
        IOrderMessageNotifySettingsProvider r6 = (IOrderMessageNotifySettingsProvider) ServiceManager.get().getService(IOrderMessageNotifySettingsProvider.class);
        if (r6 == null) goto L7;
        List<zs9.c> r7 = r6.a(r2);
    L8:
        if (r7 != null) goto L11;
        r7 = CollectionsKt.emptyList();
    L11:
        ((e) r4).invoke(r7);
        return;
    L7:
        r7 = null;
        goto L8
    L10:
        r7 = CollectionsKt.emptyList();
        goto L11
    }
}
