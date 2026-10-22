package yia;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xia.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static MemoryServiceStatus a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        PackageManager r0 = r4.getPackageManager();
    L10:
        ProviderInfo r1 = null;
    L11:
        if (r1 != null) goto L15;
        return MemoryServiceStatus.UNAVAILABLE;
    L15:
        if (b.a(r4, new ComponentName(r1.packageName, r1.name)) == false) goto L18;
        return MemoryServiceStatus.AVAILABLE;
    L18:
        return MemoryServiceStatus.UNAVAILABLE;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        r1 = r0.resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", 0);     // Catch: Throwable -> L10 Throwable -> L10
    L19:
        goto L11
    L7:
        r1 = r0.resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", 131072);     // Catch: Throwable -> L10 Throwable -> L10
        goto L19
    }

    public static MemoryServiceStatus b(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return c(r1, "com.obric.memorydata.action.SEARCH_SERVICE");
    }

    public static MemoryServiceStatus c(Context r4, String r5) {
        PackageManager r0 = r4.getPackageManager();
        Intent r1 = new Intent(r5);
        boolean r6 = false;
    L8:
        List<ResolveInfo> r2 = CollectionsKt.emptyList();
    L10:
        if (r2.isEmpty() == false) goto L14;
        return MemoryServiceStatus.UNAVAILABLE;
    L14:
        if (r2.isEmpty() == true) goto L28;
        Iterator<T> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L28;
        ServiceInfo r7 = ((ResolveInfo) r3.next()).serviceInfo;
        if (r7 != null) goto L22;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L18;
        r6 = true;
        goto L28
    L22:
        if (PackageUtils.INSTANCE.checkSignature(r7.packageName) == false) goto L25;
        r8 = b.a(r4, new ComponentName(r7.packageName, r7.name));
    L28:
        if (r6 == false) goto L31;
        return MemoryServiceStatus.AVAILABLE;
    L31:
        return MemoryServiceStatus.UNAVAILABLE;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r2 = r0.queryIntentServices(r1, 131072);     // Catch: Throwable -> L8
    L32:
        goto L10
    L6:
        r2 = r0.queryIntentServices(r1, 0);     // Catch: Throwable -> L8
        goto L32
    }
}
