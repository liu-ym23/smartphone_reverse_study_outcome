package bia;

import android.view.View;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.obric.assistant.window.materials.services.IWindowMaterialService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new f());
    }

    public static boolean a(View r1, boolean r2, MaterialSceneType r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "materialSceneType");
        if (r2 == false) goto L6;
        ((IWindowMaterialService) a.getValue()).a(r1, r3);
        return true;
    L6:
        return false;
    }
}
