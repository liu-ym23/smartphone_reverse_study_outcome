package na8;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends o {
    public static final Set<Integer> f = null;

    public static final class a {
    }

    static {
        f = SetsKt.setOf(new Integer[]{0, 3, 4, 5});
    }

    public k() {
        super("biz.forms.audioStartRecord", "biz.forms.onFrameRecorded");
    }

    @Override // na8.o
    public final boolean f(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        return f.contains(Integer.valueOf(r4.optInt("state", -1)));
    }
}
