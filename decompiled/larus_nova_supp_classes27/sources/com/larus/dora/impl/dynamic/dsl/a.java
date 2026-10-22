package com.larus.dora.impl.dynamic.dsl;

import android.content.Context;
import c59.b;
import c59.d;
import c59.p;
import c59.s;
import c59.t;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements d {
    public final DslActorFactory.ToastType a;
    public final String b;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.dsl.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0063a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DslActorFactory.ToastType.values().length];
            r0[DslActorFactory.ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DslActorFactory.ToastType.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DslActorFactory.ToastType.FAILURE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a(b r6) {
        DslActorFactory.ToastType.a r0 = DslActorFactory.ToastType.Companion;
        Map<String, Object> r1 = r6.a();
        Object r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.get("toast_type");
    L7:
        if ((r3 instanceof String) == false) goto L9;
        String r4 = (String) r3;
    L10:
        r0.getClass();
        Iterator r5 = DslActorFactory.ToastType.getEntries().iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r7 = r5.next();
        if (Intrinsics.areEqual(((DslActorFactory.ToastType) r7).getValue(), r4) == false) goto L12;
    L17:
        DslActorFactory.ToastType r8 = (DslActorFactory.ToastType) r7;
        if (r8 != null) goto L20;
        r8 = DslActorFactory.ToastType.FAILURE;
    L20:
        this.a = r8;
        Lazy r9 = s.a;
        Map<String, Object> r10 = r6.a();
        if (r10 == null) goto L23;
        r2 = r10.get("toast_msg");
    L23:
        String r11 = p.b((t) s.c(r2, t.class));
        if (r11 != null) goto L26;
        r11 = "";
    L26:
        this.b = r11;
        return;
    L16:
        r7 = null;
        goto L17
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    @Override // c59.d
    public final boolean a(Context r3, CoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        DslActorFactory.ToastType r5 = this.a;
        int r6 = C0063a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        t19.s r7 = t19.s.a;
        String r1 = this.b;
        r7.getClass();
        t19.s.p(r3, r1);
    L13:
        return true;
    L5:
        if (r6 != 2) goto L7;
        t19.s r8 = t19.s.a;
        String r2 = this.b;
        r8.getClass();
        t19.s.t(r3, r2);
        goto L13
    L7:
        if (r6 != 3) goto L10;
        t19.s r9 = t19.s.a;
        String r10 = this.b;
        r9.getClass();
        t19.s.c(r3, r10);
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
