package x82;

import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface d {
    public static final a z2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaMultiAnchorLinkContext.class);
            if ((r0 instanceof MediaMultiAnchorLinkContext) == true) goto L5;
            r0 = null;
        L5:
            MediaMultiAnchorLinkContext r1 = (MediaMultiAnchorLinkContext) r0;
            if (r1 == null) goto L11;
            j<d> r2 = r1.getEnlargeService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (d) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        z2 = a.a;
    }

    void A5(String r1, boolean r2);

    void P4(String r1, boolean r2);

    Map<String, WindowsPosition> gc(List<String> r1);

    boolean t4(String r1);

    boolean x5(String r1);

    String zd();
}
