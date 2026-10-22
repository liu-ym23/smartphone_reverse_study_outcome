package sr9;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageLoadingDrawPartType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x implements ISketchLoadingController {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
    }

    public final void a(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "text");
    }

    public final void b(boolean r1, ImageLoadingDrawPartType r2, int r3) {
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    public final void hide() {
    }

    public final void setProgress(int r1) {
    }

    public final Boolean isVisible() {
        return Boolean.FALSE;
    }
}
