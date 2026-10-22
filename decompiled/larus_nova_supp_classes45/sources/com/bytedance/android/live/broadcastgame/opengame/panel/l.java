package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ ShowTipsHelper a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.ObjectRef c;

    public l(ShowTipsHelper r1, String r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (((SharedPreferences) this.a.b.getValue()).contains(this.b) == false) goto L5;
        this.c.element = "user_pay";
        MainThreadPostUtils.c(this.a.d, 3000);
        return;
    L5:
        ((SharedPreferences) this.a.b.getValue()).edit().putBoolean(this.b, true).apply();
    }
}
