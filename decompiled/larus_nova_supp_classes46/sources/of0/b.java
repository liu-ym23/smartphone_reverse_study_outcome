package of0;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(InteractiveSongWidget r6, String r7, String r8, String r9) {
            r6.w9(r7, r8, r9, false, null);
        }
    }

    String Bm();

    void I0(String r1, long r2, boolean r4, Map<String, String> r5);

    void e7(HSImageView r1);

    void onSei(String r1);

    void w9(String r1, String r2, String r3, boolean r4, Function0<Unit> r5);

    void y5(String r1);
}
