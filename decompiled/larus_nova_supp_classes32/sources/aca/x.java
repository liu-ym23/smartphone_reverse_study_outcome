package aca;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.permission.IObricPermissionService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x implements IObricPermissionService.a {
    public final /* synthetic */ Function1<v.c, Unit> a;

    public x(f r1) {
        this.a = r1;
    }

    public final void a(boolean r4, boolean r5, List<String> r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "grantedList");
        Intrinsics.checkNotNullParameter(r7, "deniedList");
        FLogger.a.i("UserSelectBlockHolder", "ObricRequestPermission, onResult, isCanceledOrFailed: " + r4 + ", allGranted: " + r5 + ", grantedList: " + r6.size() + ", deniedList: " + r7.size());
        this.a.invoke(new v.c(r4, r6));
    }
}
