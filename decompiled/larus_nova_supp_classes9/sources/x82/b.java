package x82;

import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.ui.m;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAnchorWindowManager;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    public static final a u2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @JvmStatic
        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaMultiAnchorLinkContext.class);
            if ((r0 instanceof MediaMultiAnchorLinkContext) == true) goto L5;
            r0 = null;
        L5:
            MediaMultiAnchorLinkContext r1 = (MediaMultiAnchorLinkContext) r0;
            if (r1 == null) goto L11;
            j<b> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        u2 = a.a;
    }

    void D6();

    void Z8(String r1, LinkerKickOutContent.KickOutSource r2);

    void f();

    m getMuteManager();

    void ik(String r1, String r2, int r3);

    void setFollowState(String r1, boolean r2, String r3);

    MediaMultiLinkAnchorWindowManager yn();
}
