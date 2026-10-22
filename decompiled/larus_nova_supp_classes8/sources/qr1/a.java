package qr1;

import com.bytedance.android.live.GsonHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Observer<String> {
    public final /* synthetic */ i a;

    public a(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        String r5 = String.valueOf(((Map) GsonHelper.getDefault().fromJson(r4, Map.class)).get("error_code"));     // Catch: Throwable -> L5
        this.a.a("player_status", r5);     // Catch: Throwable -> L5
        i r6 = this.a;     // Catch: Throwable -> L5
        r6.f.c = true;     // Catch: Throwable -> L5
        r6.h(3, "enter failed cause of player error");     // Catch: Throwable -> L5
        return;
    }
}
