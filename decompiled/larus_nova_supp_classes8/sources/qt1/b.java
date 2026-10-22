package qt1;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static String a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;

        public a(String r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r7) {
            DouPlusEntry r8 = (DouPlusEntry) r7;
            if (r8 == null) goto L8;
            HashMap r0 = new HashMap();
            r0.put("is_live", "0");
            r0.put("sec_anchor_id", this.a);
            r0.put("scene", "dou_plus");
            Uri.Builder r9 = UriProtector.parse(r8.douPlusEntry).buildUpon();
            r9.appendQueryParameter("dou_plus_source", "douyin").appendQueryParameter("dou_plus_sub_source", "origin_entrance").appendQueryParameter("dou_plus_medium", "long_press_panel").appendQueryParameter("dou_plus_serving_type", "other_group").appendQueryParameter("dou_plus_entrance_type", "1").appendQueryParameter("dou_plus_entrance_level", "2").appendQueryParameter("dou_plus_referer", "long_press_panel").appendQueryParameter("dou_plus_order_type", "live").appendQueryParameter("target_step", "1");
            ILiveDouPlusService r1 = k.f(ILiveDouPlusService.class);
            if (r1 == null) goto L9;
            r1.showDouPlusDialog(this.b, r0, r9.toString(), null);
            return;
        L9:
            return;
        }
    }

    static {
        a = "6";
    }

    public static void a() {
        ILiveDouPlusService r0 = k.n(ILiveDouPlusService.class);
        HashMap r1 = new HashMap();
        r1.put("entrance_type", "long_press_panel");
        r1.put("target_step", "1");
        r1.put("dou_plus_medium", "long_press_panel");
        r1.put("dou_plus_serving_type", "my_group");
        r1.put("dou_plus_entrance_type", "1");
        r1.put("dou_plus_entrance_level", "2");
        r1.put("dou_plus_referer", "long_press_panel");
        r1.put("dou_plus_order_type", "live");
        r1.put("dou_plus_entrance_seq", a);
        r0.logEvent(false, "click_dou_plus", "", r1);
    }

    public static void b(int r6) {
        a = String.valueOf(r6);
        ILiveDouPlusService r0 = k.n(ILiveDouPlusService.class);
        HashMap r1 = new HashMap();
        r1.put("entrance_type", "long_press_panel");
        r1.put("target_step", "1");
        r1.put("dou_plus_medium", "long_press_panel");
        r1.put("dou_plus_serving_type", "my_group");
        r1.put("dou_plus_entrance_type", "1");
        r1.put("dou_plus_entrance_level", "2");
        r1.put("dou_plus_referer", "long_press_panel");
        r1.put("dou_plus_order_type", "live");
        r1.put("dou_plus_entrance_seq", String.valueOf(r6));
        r0.logEvent(false, "show_dou_plus", "", r1);
    }

    public static void c(long r7, String r9, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r9 != null) goto L5;
        return;
    L5:
        k.n(ILiveDouPlusService.class).showDouPlusLiveEntry(r9, r7, "long_press_panel", new a(r9, r10));
    }
}
