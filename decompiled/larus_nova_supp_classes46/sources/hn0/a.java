package hn0;

import bn0.c;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements o, bn0.a {
    public c a;
    public final u60.a b;

    /* JADX INFO: renamed from: hn0.a$a, reason: collision with other inner class name */
    public static final class C0219a {
    }

    static {
    }

    public final void onStop() {
        this.a = null;
    }

    public final void onStart() {
        String r2 = null;
        jy0.b.c("MultiLinkScopeProvider", "onStart: ", null, 4);
        c r0 = new c(this.b);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = k.a;
        if (r0.e != r1) goto L5;
        r2 = "roomInstance";
    L5:
        if (r2 != null) goto L9;
        l.a(r0);
        Unit r3 = Unit.INSTANCE;
        this.a = r0;
        return;
    L9:
        throw new UninitializedPropertyAccessException(r2);
    }

    @Override // bn0.a
    public final bn0.b getMultiLinkRoomScope() {
        return this.a;
    }

    public a(u60.a r2) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        this.b = r2;
    }
}
