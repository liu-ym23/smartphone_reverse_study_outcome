package com.ss.android.lark.chameleonv2.debug;

import android.preference.Preference;
import com.ss.android.lark.officesdk.utils.di.s;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ ChameleonDebugActivity a;

    public a(ChameleonDebugActivity r1) {
        this.a = r1;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference r2, Object r3) {
        Intrinsics.checkNotNullParameter(r3, "newValue");
        boolean r4 = ((Boolean) r3).booleanValue();
        com.ss.android.lark.storage.a r5 = CmlDebugSettingUtil.a;
        Intrinsics.checkNotNullParameter("chameleon_disable_debug_view", "key");
        ((KVRepo) CmlDebugSettingUtil.b.getValue()).putBoolean("chameleon_disable_debug_view", r4);
        int r6 = s.a;
        ChameleonDebugActivity r7 = this.a;
        if (r4 == false) goto L5;
        String r8 = "已禁用调试信息面板";
    L6:
        s.a.a(r7, r8);
        return true;
    L5:
        r8 = "已启用调试信息面板";
        goto L6
    }
}
