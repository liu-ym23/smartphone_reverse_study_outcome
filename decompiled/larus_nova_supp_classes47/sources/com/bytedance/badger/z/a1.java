package com.bytedance.badger.z;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a1 extends u0 {
    public final com.bytedance.badger.utils.g a;

    public a1() {
        this.a = new com.bytedance.badger.utils.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v4 */
    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r12, BadgerModuleBase.BadgerRequestData r13) {
        boolean r14 = com.bytedance.badger.t.d.f(com.bytedance.badger.t.a.a(993434546, null, null, 6));
        ?? r15 = r14;
        if (com.bytedance.badger.t.d.f(com.bytedance.badger.t.a.a(1026274741, null, null, 6)) == false) goto L5;
        r15 = (r14 ? 1 : 0) | 2;
    L5:
        int r16 = r15;
        if (com.bytedance.badger.t.d.f(com.bytedance.badger.t.a.a(207928141, null, null, 6)) == false) goto L8;
        r16 = (r15 == true ? 1 : 0) | 4;
    L8:
        com.bytedance.badger.utils.g r0 = this.a;
        r0.getClass();
        boolean r1 = false;
        PackageManager r2 = r12.getPackageManager();     // Catch: Exception -> L17
        Lazy r3 = r0.a;     // Catch: Exception -> L17
        KProperty r4 = com.bytedance.badger.utils.g.b[0];     // Catch: Exception -> L17
        String[] r5 = (String[]) r3.getValue();     // Catch: Exception -> L17
        int r6 = r5.length;     // Catch: Exception -> L17
        int r7 = 0;
        boolean r8 = false;
    L11:
        if (r7 >= r6) goto L19;
        String r9 = r5[r7];     // Catch: Exception -> L16
        BadgerCore.Companion.getClass();     // Catch: Exception -> L16
        Intent r10 = new Intent(com.bytedance.badger.j.b(300291045195973874L));     // Catch: Exception -> L16
        r10.setPackage(r9);     // Catch: Exception -> L16
        if (r2.queryIntentServices(r10, 0).isEmpty() == true) goto L15;
        r8 = true;
    L15:
        r7 = r7 + 1;
    L16:
        r1 = r8;
    L19:
        if (r8 == false) goto L21;
        r16 = (r16 == true ? 1 : 0) | '\b';
    L21:
        this.a.getClass();
        ArrayList r17 = new ArrayList();
        Object r18 = r12.getSystemService("accessibility");     // Catch: Exception -> L36
        if (r18 == null) goto L33;
        List<AccessibilityServiceInfo> r19 = ((AccessibilityManager) r18).getEnabledAccessibilityServiceList(-1);     // Catch: Exception -> L36
        String r110 = r12.getApplicationInfo().packageName;     // Catch: Exception -> L36
        Iterator<AccessibilityServiceInfo> r111 = r19.iterator();     // Catch: Exception -> L36
    L26:
        if (r111.hasNext() == false) goto L34;
        AccessibilityServiceInfo r20 = r111.next();     // Catch: Exception -> L36
        HashMap r22 = new HashMap();     // Catch: Exception -> L36
        r22.put("serviceName", r20.getResolveInfo().serviceInfo.name);     // Catch: Exception -> L36
        r22.put("packageName", r20.getResolveInfo().serviceInfo.packageName);     // Catch: Exception -> L36
        r17.add(r22);     // Catch: Exception -> L36
        goto L26
    L33:
        throw new TypeCastException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");     // Catch: Exception -> L36
    L34:
        JSONObject r112 = new JSONObject();
        r112.putOpt(DataType.TRUE, Integer.valueOf(r16));
        r112.putOpt("2", r17);
        return new BadgerResult.Success(new DataJson(r112));
    L18:
        r8 = r1;
        goto L19
    }
}
