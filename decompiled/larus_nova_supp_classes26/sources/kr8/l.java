package kr8;

import android.util.LruCache;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ixigua.lib.track.TrackParams;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface l {

    public static final class a {
        public static void a(l r4, by7.e r5, JSONObject r6) {
            LruCache<String, Boolean> r0 = q.a;
            Intrinsics.checkNotNullParameter(r4, "mobData");
            JSONObject r1 = new JSONObject(GsonProtectorUtils.toJson(q.e, r4));
            if (r6 == null) goto L9;
            Iterator<String> r2 = r6.keys();
            if (r2 == null) goto L9;
        L7:
            if (r2.hasNext() == false) goto L9;
            String r3 = r2.next();
            r1.put(r3, r6.opt(r3));
        L9:
            TrackParams r7 = new TrackParams().merge(r1);
            String r8 = r4.a();
            if (r8 != null) goto L12;
            r8 = "";
        L12:
            by7.a r9 = new by7.a(r8);
            if (r5 == null) goto L15;
            r9.b = r5;
        L15:
            r9.a.merge(r7);
            r9.b();
        }

        public static /* synthetic */ void b(l r1, JSONObject r2, int r3) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            r1.b(null, r2);
        }
    }

    String a();

    void b(by7.e r1, JSONObject r2);
}
