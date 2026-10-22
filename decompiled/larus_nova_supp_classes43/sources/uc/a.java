package uc;

import android.app.Activity;
import android.util.AndroidRuntimeException;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.d;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.g;
import com.bytedance.android.bst.api.saas.SaasService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c {
    public static final SaasService a = null;
    public static final a b = null;

    public a() {
    }

    @Override // uc.c
    public final void a() {
    }

    @Override // uc.c
    public final void b() {
    }

    @Override // uc.c
    public final void bindView() {
    }

    @Override // uc.c
    public final void c() {
    }

    @Override // uc.c
    public final void f() {
    }

    @Override // uc.c
    public final void h() {
    }

    static {
        b = new a();
        a = new SaasService();
    }

    @Override // uc.c
    public final void e(d r10) {
        SaasService r0 = a;
        r0.getClass();
        r0.b(r10.g);
        g r1 = r10.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
    L5:
        String r11 = r10.b;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("event");
    L8:
        r1.a(r11, new LinkedHashMap());
        ExtKt.a("clickTrack", r10.a + " emit");
    }

    @Override // uc.c
    public final void g(d r11) {
        SaasService r0 = a;
        r0.getClass();
        r0.b(r11.g);
        Activity r1 = ExtKt.getActivity(r11.g);
        if (r1 != null) goto L11;
        g r10 = r11.f;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
    L7:
        String r12 = r11.b;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("event");
    L10:
        r10.a(r12, new LinkedHashMap());
        ExtKt.a("autoShowTrack", r11.a + " emit for activity is null");
        return;
    L11:
        String r13 = r11.d;
        if (r13 != null) goto L14;
    L17:
        boolean r14 = true;
    L18:
        if (r14 == true) goto L49;
        Object r15 = r11.g;
        Object r16 = r11.c;
        if ((r16 instanceof String) == false) goto L22;
        String r17 = (String) r16;
    L25:
        String r18 = r13 + '_' + r17;
        List<SaasService.b> r19 = (List) ((LinkedHashMap) r0.b).get(new com.bytedance.android.bst.api.ext.c(r1));
        if (r19 == null) goto L37;
        Iterator<T> r20 = r19.iterator();
    L29:
        if (r20.hasNext() == false) goto L33;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((SaasService.b) r21).a, r18) == false) goto L29;
    L34:
        if (r21 == null) goto L37;
        ExtKt.a("autoShowTrack", r11.a + " intercept,for exposure repeat");
        return;
    L33:
        r21 = null;
    L37:
        if (r19 != null) goto L40;
        r19 = new ArrayList();
    L40:
        r19.add(new SaasService.b(r18, r11.e));
        r0.b.put(new com.bytedance.android.bst.api.ext.c(r1), r19);
        g r22 = r11.f;
        if (r22 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("reporter");
    L43:
        String r23 = r11.b;
        if (r23 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("event");
    L46:
        r22.a(r23, new LinkedHashMap());
        ExtKt.a("autoShowTrack", r11.a + " emit");
        return;
    L22:
        if (r16 == null) goto L24;
        r15 = r16;
    L24:
        r17 = String.valueOf(System.identityHashCode(r15));
        goto L25
    L49:
        throw new AndroidRuntimeException("rule key is null");
    L14:
        if (r13.length() == 0) goto L17;
        r14 = false;
        goto L18
    }

    @Override // uc.c
    public final void d(RecyclerView r10, int r11) {
        a.a(r10, r11);
    }
}
