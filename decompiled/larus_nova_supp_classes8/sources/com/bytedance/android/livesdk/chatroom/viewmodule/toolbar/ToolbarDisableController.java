package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarDisableController {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final Context b;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            String r3 = this.b;
            if (r3 == null) goto L8;
            int r4 = r3.hashCode();
        L10:
            return r2 + r4;
        L8:
            r4 = 0;
            goto L10
        }

        public final String toString() {
            return "ToolbarStatus(isDisable=" + this.a + ", prompt=" + this.b + ")";
        }

        public b(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "prompt");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public ToolbarDisableController(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        this.a = LazyKt.lazy(ToolbarDisableController$cacheStatus$2.INSTANCE);
    }

    public final void b(x3 r4) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        Iterator r0 = ((Map) this.a.getValue()).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (((b) r1.getValue()).a == true) goto L7;
        r4.h((ExtendedToolbarButton) r1.getKey());
        goto L4
    L7:
        r4.l((ExtendedToolbarButton) r1.getKey(), ((b) r1.getValue()).b);
        goto L4
    L9:
        ((Map) this.a.getValue()).clear();
    }

    public final void a(x3 r7, List r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "manager");
        Intrinsics.checkNotNullParameter(r8, "buttons");
        Intrinsics.checkNotNullParameter(r9, "condition");
        if (((Map) this.a.getValue()).isEmpty() == false) goto L8;
        Iterator r0 = r8.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ExtendedToolbarButton r1 = (ExtendedToolbarButton) r0.next();
        ((Map) this.a.getValue()).put(r1, new b(r7.x(r1), r7.u(r1)));
    L8:
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        ExtendedToolbarButton r2 = (ExtendedToolbarButton) r10.next();
        if (((Boolean) r9.invoke(r2)).booleanValue() == false) goto L10;
        r7.l(r2, this.b.getString(2131915411));
        goto L10
    }
}
