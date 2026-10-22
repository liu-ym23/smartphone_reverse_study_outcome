package ka0;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    void a(HybridCard r1, String r2);

    void b(HybridCard r1, View r2, int r3);

    void loadUrl(String r1);

    void release();

    <T> void sendJsEvent(String r1, T r2);
}
