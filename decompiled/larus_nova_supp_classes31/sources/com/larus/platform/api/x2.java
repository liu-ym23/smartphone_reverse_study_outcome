package com.larus.platform.api;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import hq9.a3;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface x2 {

    public static final class a {
        public static /* synthetic */ void a(LocateScene r2) {
            com.larus.platform.service.l1.a.a(r2, null);
        }
    }

    void a(LocateScene r1, a3 r2);

    void b(hq9.y2 r1);

    boolean c();

    Dialog d(FragmentActivity r1);

    GeoLocationInfo e(long r1);

    void f(LocateScene r1, com.bytedance.applet.utils.g r2, JSONObject r3);

    void g();
}
