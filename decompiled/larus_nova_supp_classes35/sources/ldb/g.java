package ldb;

import android.text.TextUtils;
import com.larksuite.framework.utils.j0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class g implements jdb.g {

    @Inject
    public String a;
    public final jdb.d b;

    @Inject
    public g(jdb.d r3) {
        Log.i("UserFeatureGatingService", "UserFeatureGatingService start");
        this.b = r3;
        Log.i("UserFeatureGatingService", "UserFeatureGatingService finish");
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        Log.w("UserFeatureGatingService", "wtf, invalid uid within user-state-framework.");
        return;
    L5:
        Log.i("UserFeatureGatingService", "uid info:" + j0.a(this.a));
    }

    @Override // jdb.g
    public final boolean isCurrentEnable(String r3) {
        Log.i("UserFeatureGatingService", "from UserFeatureGatingService.");
        return this.b.x(this.a, r3);
    }

    @Override // jdb.g
    public final boolean isEnable(String r3) {
        Log.i("UserFeatureGatingService", "from UserFeatureGatingService.");
        return this.b.B0(this.a, r3);
    }

    @Override // jdb.g
    public final void addFeatureGatingUpdateListener(String r3, jdb.c r4, String r5) {
        this.b.T(this.a, "base.setting.realtime_fg_setting_fix", r4, "_normal_fg");
    }
}
