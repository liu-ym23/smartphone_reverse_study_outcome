package sr9;

import android.content.Context;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.instruction.f2;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements com.larus.bmhome.instruction.j {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final com.larus.bmhome.actionbar.model.r a(Integer r1, String r2, List<com.larus.bmhome.actionbar.model.u> r3, com.larus.bmhome.actionbar.model.r r4, int r5) {
        return r4;
    }

    public final com.larus.bmhome.actionbar.model.r c(String r1, com.larus.bmhome.actionbar.model.r r2, com.larus.bmhome.view.actionbar.edit.c r3, com.larus.bmhome.view.actionbar.edit.b r4, p1 r5, fq8.e r6) {
        Intrinsics.checkNotNullParameter(r1, "userInput");
        Intrinsics.checkNotNullParameter(r2, "instructionConf");
        return r2;
    }

    public final boolean d(Context r1, String r2, boolean r3, com.larus.bmhome.view.actionbar.edit.c r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "input");
        return false;
    }

    public final com.larus.bmhome.actionbar.model.r e(Integer r1, String r2, com.larus.bmhome.view.actionbar.edit.b r3, com.larus.bmhome.actionbar.model.r r4, int r5) {
        return r4;
    }

    public final String f(String r1, com.larus.bmhome.view.actionbar.edit.c r2, com.larus.bmhome.view.actionbar.edit.b r3, p1 r4, fq8.e r5, f2 r6) {
        Intrinsics.checkNotNullParameter(r1, "userInput");
        return r1;
    }

    public final Map<String, String> b(String r1, String r2, String r3, boolean r4, Map<String, String> r5, Long r6) {
        Intrinsics.checkNotNullParameter(r1, "actionBarKey");
        Intrinsics.checkNotNullParameter(r2, "instructionType");
        return MapsKt.emptyMap();
    }
}
