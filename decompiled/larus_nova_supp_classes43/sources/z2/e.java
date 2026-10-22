package z2;

import android.webkit.PermissionRequest;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ PermissionRequest a;

    public /* synthetic */ e(PermissionRequest r1) {
        this.a = r1;
    }

    public final Object invoke(Object r22) {
        PermissionRequest r10 = this.a;
        List r1 = (List) r22;
        Intrinsics.checkNotNullParameter(r1, "granted");
        if (r1.isEmpty() == false) goto L5;
        l.b(r10);
    L24:
        return Unit.INSTANCE;
    L5:
        String[] r11 = (String[]) r1.toArray(new String[0]);
        ArrayList r12 = new ArrayList();
        Object[] r13 = {r11};
        f06.b r14 = new f06.b();
        g06.a r15 = (g06.a) ApiHookConfig.b.get(102605);
        if (r15 == null) goto L8;
        f06.a[] r16 = r15.i;
    L9:
        f06.a[] r17 = r16;
        int r18 = r17.length;
        int r19 = 0;
    L11:
        if (r19 >= r18) goto L18;
        f06.a r20 = r17[r19];
        int r110 = r19;
        int r111 = r18;
        f06.a[] r21 = r17;
        f06.d r23 = r20.preInvoke(102605, "android/webkit/PermissionRequest", "grant", r10, r13, "void", r14);     // Catch: Exception -> L25
        if (r23.a == true) goto L20;
        r12.add(r20);     // Catch: Exception -> L25
    L20:
        if (r23.a == true) goto L24;
        r10.grant(r11);
    L17:
        r19 = r110 + 1;
        r18 = r111;
        r17 = r21;
        goto L11
    L18:
        r23 = new f06.d(false, null);
        goto L20
    L8:
        r16 = ApiHookConfig.d;
        goto L9
    }
}
