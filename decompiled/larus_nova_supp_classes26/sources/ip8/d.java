package ip8;

import com.larus.bmhome.video.Content;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new c());
    }

    public static final boolean a(Content r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !CollectionsKt.contains((List) a.getValue(), r1.getItemType());
    }
}
