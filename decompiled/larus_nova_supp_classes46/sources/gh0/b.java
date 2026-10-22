package gh0;

import com.bytedance.android.live.core.log.ALogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vm2.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final boolean a = false;
    public static final List<String> b = null;

    static {
        a = l.a();
        b = CollectionsKt.mutableListOf(new String[]{"WindowListHelper"});
    }

    public static void a(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "subTag");
        Intrinsics.checkNotNullParameter(r4, "content");
        if (a == true) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        ALogger.e("LinkDebugLog", "subTag: " + r3 + " | content: " + r4);
        return;
    L8:
        ALogger.i("LinkDebugLog", "subTag: " + r3 + " | content: " + r4);
    }
}
