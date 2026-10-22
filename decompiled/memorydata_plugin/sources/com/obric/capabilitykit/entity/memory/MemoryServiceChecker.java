package com.obric.capabilitykit.entity.memory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.util.Log;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryServiceChecker;", "", "()V", "ACTION_GLOBAL_SEARCH_SERVICE", "", "ACTION_SEARCH_SERVICE", "ENTITY_PROVIDER_AUTHORITY", "TAG", "checkEntityProviderAvailable", "Lcom/obric/capabilitykit/entity/memory/MemoryServiceStatus;", "context", "Landroid/content/Context;", "checkGlobalSearchServiceAvailable", "checkSearchServiceAvailable", "checkServiceAvailableInternal", "action", "serviceName", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryServiceChecker {
    public static final String ACTION_GLOBAL_SEARCH_SERVICE = "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE";
    public static final String ACTION_SEARCH_SERVICE = "com.obric.memorydata.action.SEARCH_SERVICE";
    public static final String ENTITY_PROVIDER_AUTHORITY = "com.obric.memorydata.personalcontext.EntityProvider";
    public static final MemoryServiceChecker INSTANCE = null;
    public static final String TAG = "MemoryServiceChecker";

    static {
        INSTANCE = new MemoryServiceChecker();
    }

    private MemoryServiceChecker() {
    }

    private final MemoryServiceStatus checkServiceAvailableInternal(Context r8, String r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        PackageManager r1 = r11.getPackageManager();
        Intent r3 = new Intent(r9);
        boolean r4 = false;
    L11:
        e = e;
        StringBuilder r5 = new StringBuilder();
        String r6 = "No permission to query ";
    L13:
        Log.w(TAG, r5.append(r6).append(r10).append(" services").toString(), e);
        List<ResolveInfo> r2 = CollectionsKt.emptyList();
    L15:
        if (r2.isEmpty() == false) goto L19;
        Log.w(TAG, "No " + r10 + " services found for action: " + r9);
        return MemoryServiceStatus.UNAVAILABLE;
    L19:
        if (r2.isEmpty() == true) goto L37;
        Iterator<T> r7 = r2.iterator();
    L23:
        if (r7.hasNext() == false) goto L37;
        ServiceInfo r12 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r7.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo;
        if (r12 == null) goto L34;
        Intrinsics.checkNotNullExpressionValue(r12, "serviceInfo");
        if (PackageUtils.INSTANCE.checkSignature(r12.packageName) == true) goto L29;
        Log.w(TAG, r10 + " service pkg not trusted: " + r12.packageName);
        goto L34
    L29:
        boolean r13 = a.f7485a.a(r11, new ComponentName(r12.packageName, r12.name));
        if (r13 == false) goto L32;
        StringBuilder r14 = new StringBuilder();
        StringBuilder r15 = r14.append(r10);
        String r16 = " service is available: ";
    L33:
        Log.d(TAG, r15.append(r16).append(r12.packageName).append('/').append(r12.name).toString());
    L35:
        if (r13 == false) goto L23;
        r4 = true;
        goto L37
    L32:
        r14 = new StringBuilder();
        r15 = r14.append(r10);
        r16 = " service is disabled: ";
    L34:
        r13 = false;
    L37:
        if (r4 == false) goto L40;
        return MemoryServiceStatus.AVAILABLE;
    L40:
        return MemoryServiceStatus.UNAVAILABLE;
    L9:
        e = e;
        r5 = new StringBuilder();
        r6 = "Failed to query ";
        goto L13
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r2 = r1.queryIntentServices(r3, 131072);     // Catch: RuntimeException -> L9 SecurityException -> L11
    L7:
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            if (Build.…)\n            }\n        }");     // Catch: RuntimeException -> L9 SecurityException -> L11
    L6:
        r2 = r1.queryIntentServices(r3, 0);     // Catch: RuntimeException -> L9 SecurityException -> L11
        goto L7
    }

    public final MemoryServiceStatus checkEntityProviderAvailable(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        PackageManager r0 = r7.getPackageManager();
        ProviderInfo r1 = null;
    L13:
        e = e;
        String r2 = "No permission to resolve provider";
    L15:
        Log.w(TAG, r2, e);
    L16:
        if (r1 != null) goto L20;
        Log.w(TAG, "No provider found for authority: com.obric.memorydata.personalcontext.EntityProvider");
        return MemoryServiceStatus.UNAVAILABLE;
    L20:
        if (a.f7485a.a(r7, new ComponentName(r1.packageName, r1.name)) == false) goto L22;
        Log.i(TAG, "Provider is available: " + r1.packageName + '/' + r1.name);
        return MemoryServiceStatus.AVAILABLE;
    L22:
        Log.w(TAG, "Provider is disabled: " + r1.packageName + '/' + r1.name);
        return MemoryServiceStatus.UNAVAILABLE;
    L11:
        e = e;
        r2 = "Failed to resolve provider";
        goto L15
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        ProviderInfo r3 = r0.resolveContentProvider(ENTITY_PROVIDER_AUTHORITY, 0);     // Catch: RuntimeException -> L11 SecurityException -> L13
    L8:
        r1 = r3;
        goto L16
    L7:
        r3 = r0.resolveContentProvider(ENTITY_PROVIDER_AUTHORITY, 131072);     // Catch: RuntimeException -> L11 SecurityException -> L13
        goto L8
    }

    public final MemoryServiceStatus checkGlobalSearchServiceAvailable(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return checkServiceAvailableInternal(r4, ACTION_GLOBAL_SEARCH_SERVICE, "GlobalSearch");
    }

    public final MemoryServiceStatus checkSearchServiceAvailable(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return checkServiceAvailableInternal(r4, ACTION_SEARCH_SERVICE, "Search");
    }
}
