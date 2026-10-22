package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.banner.BannerItemViewHolder;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public m() {
    }

    public static void a(String r2, Integer r3, String r4, String r5, String r6, BannerItemViewHolder r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 == null) goto L5;
        r0.put("banner_id", r2);
    L5:
        if (r3 == null) goto L7;
        r0.put("show_position", r3.intValue());
    L7:
        r0.put("show_way", r4);
        if (r5 == null) goto L10;
        r0.put("uri", r5);
    L10:
        if (r6 == null) goto L12;
        r0.put("video_id", r6);
    L12:
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("banner_show");
        if (r7 == null) goto L15;
        r9.b = r7;
    L15:
        r9.a.merge(r8);
        r9.b();
    }
}
