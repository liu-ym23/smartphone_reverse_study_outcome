package x82;

import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import f92.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface e {
    public static final a A2 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static e a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaMultiAnchorLinkContext.class);
            if ((r0 instanceof MediaMultiAnchorLinkContext) == true) goto L5;
            r0 = null;
        L5:
            MediaMultiAnchorLinkContext r1 = (MediaMultiAnchorLinkContext) r0;
            if (r1 == null) goto L11;
            j<e> r2 = r1.getLayoutService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (e) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        A2 = a.a;
    }

    void Oe(SeiAppData r1);

    f Q8();

    void ah();

    UILayout getDefaultUILayout();

    UILayout getUILayout();

    void kg(UILayout r1, String r2, boolean r3);

    void of(int r1);
}
