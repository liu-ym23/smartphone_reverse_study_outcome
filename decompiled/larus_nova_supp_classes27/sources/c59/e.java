package c59;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements d {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // c59.d
    public final boolean a(Context r13, CoroutineScope r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "lifecycleScope");
        int r15 = com.larus.dora.impl.util.h0.a;
        b r16 = this.a;
        if (r16 != null) goto L5;
        g49.d.b("ExternalRoute", "open action failed, action is null");
        return false;
    L5:
        String r1 = r16.e();
        if (r16.getType() != DslActionType.EXTERNAL_JUMP_BY_EXPLICIT_INTENT) goto L66;
        g49.d.d("ExternalRoute", "open by explicit intent, action: " + r16);
        Map<String, Object> r3 = r16.a();     // Catch: Exception -> L63
        String r5 = null;
        if (r3 == null) goto L12;
        Object r4 = r3.get("package_name");     // Catch: Exception -> L63
    L14:
        if ((r4 instanceof String) == false) goto L16;
        String r6 = (String) r4;     // Catch: Exception -> L63
    L17:
        Map<String, Object> r7 = r16.a();     // Catch: Exception -> L63
        if (r7 == null) goto L21;
        Object r8 = r7.get("class_name");     // Catch: Exception -> L63
    L23:
        if ((r8 instanceof String) == false) goto L25;
        r5 = (String) r8;     // Catch: Exception -> L63
    L25:
        g49.d.d("ExternalRoute", "open component, packageName: " + r6 + ", className: " + r5);     // Catch: Exception -> L63
        if (r6 != null) goto L28;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == true) goto L87;
        if (r5 != null) goto L35;
    L38:
        boolean r10 = true;
    L39:
        if (r10 == true) goto L88;
        Intent r11 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L63
        r11.addFlags(335544320);     // Catch: Exception -> L63
        r11.setComponent(new ComponentName(r6, r5));     // Catch: Exception -> L63
        r11.setPackage(r6);     // Catch: Exception -> L63
        Iterator<Map.Entry<String, Object>> r17 = r16.a().entrySet().iterator();     // Catch: Exception -> L63
    L43:
        if (r17.hasNext() == false) goto L61;
        Map.Entry<String, Object> r12 = r17.next();     // Catch: Exception -> L63
        String r18 = r12.getKey();     // Catch: Exception -> L63
        Object r20 = r12.getValue();     // Catch: Exception -> L63
        if (Intrinsics.areEqual(r18, "package_name") == true) goto L43;
        if (Intrinsics.areEqual(r18, "class_name") == true) goto L43;
        g49.d.d("ExternalRoute", "put extra, key: " + r18 + ", value: " + r20);     // Catch: Exception -> L63
        if ((r20 instanceof String) == true) goto L60;
        if ((r20 instanceof Integer) == true) goto L60;
        if ((r20 instanceof Long) == true) goto L60;
        if ((r20 instanceof Boolean) == true) goto L60;
        if ((r20 instanceof Float) == true) goto L60;
        if ((r20 instanceof Double) == false) goto L43;
    L60:
        r11.putExtra(r18, (Serializable) r20);     // Catch: Exception -> L63
        goto L43
    L61:
        AppHost.a.getApplication().startActivity(r11);     // Catch: Exception -> L63
        g49.d.d("ExternalRoute", "open component success, packageName: " + r6 + ", className: " + r5);     // Catch: Exception -> L63
        return true;
    L88:
        return false;
    L35:
        if (r5.length() == 0) goto L38;
        r10 = false;
        goto L39
    L87:
        return false;
    L28:
        if (r6.length() == 0) goto L31;
        r9 = false;
        goto L32
    L21:
        r8 = null;
        goto L23
    L16:
        r6 = null;
        goto L17
    L12:
        r4 = null;
    L63:
        e = move-exception;
        g49.d.b("ExternalRoute", "open component failed, e: " + e.getMessage());
        return false;
    L66:
        if (r16.getType() != DslActionType.EXTERNAL_JUMP) goto L68;
        g49.d.d("ExternalRoute", "open schema, schema: " + r1);
        return com.larus.dora.impl.util.h0.b(r1);
    L68:
        g49.d.b("ExternalRoute", "open action failed, unknown action type, action: " + r16);
        return false;
    }
}
