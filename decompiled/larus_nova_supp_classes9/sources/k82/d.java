package k82;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface d {

    public static final class a {
        public static void a(VSInputSectionType r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "sectionType");
            Intrinsics.checkNotNullParameter(r2, "view");
        }
    }

    void a();

    VSInputSectionType b();

    c c();

    void d();

    void e();

    View g(h82.b r1);

    void h(VSInputSectionType r1, View r2);
}
