package com.bytedance.android.live.broadcastgame.opengame;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ LiveBasePluginManager a;

    public l(LiveBasePluginManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ((d10.a) r3).getClass();
        SharedPreferences.Editor r4 = this.a.getContext().getSharedPreferences("com.tt.miniapp.shared_prefs_prefix_new_permission_null", 0).edit();
        r4.clear();
        r4.apply();
        f2.c("null 权限SP已清空", 0);
    }
}
