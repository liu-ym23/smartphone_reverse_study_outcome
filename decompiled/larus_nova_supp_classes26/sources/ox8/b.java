package ox8;

import com.larus.camera.impl.edulibs.cameraapi.idl.RpcErrorCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final e a(a r17) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        String r2 = r17.l();
        RpcErrorCode r3 = r17.j();
        Integer r4 = r17.d();
        Integer r8 = r17.g();
        String r9 = r17.e();
        String r10 = r17.f();
        Long r11 = r17.b();
        i r12 = r17.k();
        String r14 = r17.c();
        List<Integer> r0 = r17.a();
        if (r0 == null) goto L5;
        List r1 = CollectionsKt.filterNotNull(r0);
    L6:
        List r7 = r1;
        List<h> r5 = r17.h();
        if (r5 == null) goto L16;
        List r6 = CollectionsKt.filterNotNull(r5);
        if (r6 == null) goto L16;
        h r13 = (h) CollectionsKt.firstOrNull(r6);
        if (r13 == null) goto L16;
        List<g> r15 = r13.a();
        if (r15 == null) goto L16;
        Object r16 = CollectionsKt.filterNotNull(r15);
        if (r16 == null) goto L16;
    L17:
        List r18 = CollectionsKt.listOf(r16);
        List<f> r19 = r17.i();
        if (r19 == null) goto L27;
        List r20 = CollectionsKt.filterNotNull(r19);
        if (r20 == null) goto L27;
        f r21 = (f) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L27;
        List<String> r22 = r21.a();
        if (r22 == null) goto L27;
        Object r23 = CollectionsKt.filterNotNull(r22);
        if (r23 == null) goto L27;
    L29:
        return new e(r2, r3, r4, r18, CollectionsKt.listOf(r23), r7, r8, r9, r10, r11, r12, null, r14, null, 10240);
    L27:
        r23 = new ArrayList();
    L16:
        r16 = new ArrayList();
        goto L17
    L5:
        r1 = null;
        goto L6
    }
}
