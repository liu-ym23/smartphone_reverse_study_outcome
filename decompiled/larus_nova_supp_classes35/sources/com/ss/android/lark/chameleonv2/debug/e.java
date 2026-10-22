package com.ss.android.lark.chameleonv2.debug;

import android.preference.Preference;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ ChameleonDebugActivity a;

    public e(ChameleonDebugActivity r1) {
        this.a = r1;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference r21, Object r22) {
        Intrinsics.checkNotNullParameter(r22, "newValue");
        String r0 = r22.toString();
        CmlDebugSettingUtil.b("chameleon_open_url", r0);
        ChameleonDebugActivity r2 = this.a;
        r2.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r0, "url");
        ChameleonConfig.Builder r1 = new ChameleonConfig.Builder().loadUrl(r0);
        OpenConfig r15 = new OpenConfig(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
        r15.setTitlebarConfig(new TitlebarConfig(false, null, 2, null));
        ChameleonConfig r3 = r1.openConfig(r15).build();
        Chameleon r4 = Chameleon.a;
        Chameleon.b(r2, r3, null);
        return true;
    }
}
