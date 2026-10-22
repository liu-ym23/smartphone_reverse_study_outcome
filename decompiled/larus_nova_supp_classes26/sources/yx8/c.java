package yx8;

import com.larus.camera.impl.ui.component.result.general.ResultControlComponent;
import com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent;
import com.larus.camera.impl.ui.component.result.general.ResultTitleComponent;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputtableControlComponent;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static volatile a a;
    public static volatile boolean b;

    public c() {
    }

    static {
        a = a.d.b;
    }

    public static boolean b() {
        return !Intrinsics.areEqual(a, a.d.b);
    }

    public static List a(b r4) {
        Intrinsics.checkNotNullParameter(r4, "mode");
        if (b == false) goto L6;
        r4 = b.C0145b.a;
    L6:
        if (Intrinsics.areEqual(r4, b.a.a) == false) goto L12;
        if (b() == false) goto L21;
        return CollectionsKt.listOf(new com.larus.camera.impl.ui.arch.b[]{new ResultTitleComponent(), new ResultInputtableControlComponent()});
    L21:
        return CollectionsKt.listOf(new com.larus.camera.impl.ui.arch.b[]{new ResultTitleComponent(), new ResultControlComponent()});
    L12:
        if ((r4 instanceof b.c) == false) goto L15;
        return CollectionsKt.listOf(new com.larus.camera.impl.ui.arch.b[]{new ResultTitleComponent(), new ResultTabControlComponent(((b.c) r4).a)});
    L15:
        if (Intrinsics.areEqual(r4, b.C0145b.a) == false) goto L19;
        return CollectionsKt.listOf(new com.larus.camera.impl.ui.arch.b[]{new ResultTitleComponent(), new ResultControlComponent()});
    L19:
        throw new NoWhenBranchMatchedException();
    }
}
