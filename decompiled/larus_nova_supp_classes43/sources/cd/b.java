package cd;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmPage;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.d;
import com.bytedance.android.btm.api.e;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final ConcurrentHashMap<Class<?>, BtmPage> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static PageProp a(Object r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        BtmHostDependManager.F.getClass();
        Iterator r1 = BtmHostDependManager.y.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        d r10 = (d) r1.next();
        if (Intrinsics.areEqual(r10.a, r12.getClass()) == true) goto L13;
        if (r12.getClass().getName().equals(r10.b) == false) goto L7;
    L13:
        return new PageProp(r10.c, r10.d, r10.e, r10.f, null, 16, null);
    L14:
        BtmHostDependManager.F.getClass();
        Iterator r11 = BtmHostDependManager.z.iterator();
    L16:
        if (r11.hasNext() == false) goto L21;
        e r13 = (e) r11.next();
        if (Intrinsics.areEqual(r13.a.get(), r12) == false) goto L16;
        return new PageProp(r13.b, r13.c, r13.d, r13.e, null, 16, null);
    L21:
        BtmHostDependManager r14 = BtmHostDependManager.F;
        r14.getClass();
        if (((Boolean) BtmHostDependManager.t.getValue(r14, BtmHostDependManager.a[18])).booleanValue() == true) goto L34;
    L33:
        return null;
    L34:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L31
        ConcurrentHashMap<Class<?>, BtmPage> r16 = a;     // Catch: Throwable -> L31
        BtmPage r17 = r16.get(r12.getClass());     // Catch: Throwable -> L31
        if (r17 != null) goto L26;
        r17 = (BtmPage) r12.getClass().getAnnotation(BtmPage.class);     // Catch: Throwable -> L31
    L26:
        if (r17 == null) goto L29;
        r16.put(r12.getClass(), r17);     // Catch: Throwable -> L31
        return new PageProp(r17.value(), r17.auto(), r17.singleton(), false, null, 24, null);
    L29:
        Result.constructor-impl(null);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }
}
