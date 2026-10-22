package sr9;

import android.content.Context;
import com.larus.bmhome.utils.c4;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 implements com.larus.bmhome.video.save_share.a {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    public final void b(Context r1, nr9.g r2, c4 r3, String r4, CoroutineScope r5, boolean r6, boolean r7, JSONObject r8, Map<String, String> r9, String r10, boolean r11, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r3, "videoDetailEventParams");
        Intrinsics.checkNotNullParameter(r4, "clickMethod");
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r12, "dismissLoadingCallback");
        r12.invoke(501, "", 0L, Boolean.FALSE);
    }
}
