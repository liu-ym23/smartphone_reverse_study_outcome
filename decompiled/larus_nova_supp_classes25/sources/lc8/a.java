package lc8;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface a {

    /* JADX INFO: renamed from: lc8.a$a, reason: collision with other inner class name */
    public static final class C0081a {
        public static void a(Context r1, FileCardVMData r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "data");
        }
    }

    void a(Context r1, FileCardVMData r2);

    void b(Context r1, FileCardVMData r2);
}
