package fx8;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;
    public static final List<String> e = null;
    public static final List<String> f = null;
    public static final List<String> g = null;

    static {
        List<String> r0 = CollectionsKt.listOf("CAPTURE_MODE_PHOTO");
        a = r0;
        List<String> r1 = CollectionsKt.listOf("CAPTURE_MODE_SCAN");
        b = r1;
        List<String> r2 = CollectionsKt.listOf(new String[]{"CAPTURE_MODE_HEALTH_PHOTO", "CAPTURE_MODE_HEALTH_SECOND_PHOTO"});
        c = r2;
        d = CollectionsKt.listOf("CAPTURE_MODE_EDU_GENERAL_PHOTO");
        List<String> r3 = CollectionsKt.listOf(new String[]{"CAPTURE_MODE_EDU_GENERAL_PHOTO", "CAPTURE_MODE_EDU_ARTICLE_PHOTO", "CAPTURE_MODE_EDU_CALCULATION_PHOTO", "CAPTURE_MODE_EDU_HOMEWORK_PHOTO"});
        e = r3;
        f = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(r0, r1), r3), r2);
        g = CollectionsKt.listOf(new String[]{"common_input", "outer_input", "common_bottom_menu", "send_photo_preview"});
    }
}
