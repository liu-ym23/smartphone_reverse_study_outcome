package nk0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;
import lb6.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends b implements rb6.a {
    public final bc6.a b;

    /* JADX INFO: renamed from: nk0.a$a, reason: collision with other inner class name */
    public static final class C0243a implements bc6.b {
        public final /* synthetic */ rb6.a.a a;

        public C0243a(rb6.a.a r1) {
            this.a = r1;
        }

        public final void W(long r2, OperateType r4) {
            Intrinsics.checkNotNullParameter(r4, "operationType");
            rb6.a.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.W(r2, r4);
            return;
        }

        public final void c1(long r2, OperateType r4, BaseCheckException r5) {
            Intrinsics.checkNotNullParameter(r4, "operationType");
            Intrinsics.checkNotNullParameter(r5, "exception");
            rb6.a.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.c1(r2, r4, r5);
            return;
        }
    }

    public a(fc6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hostService");
        this.b = r2.n();
    }

    public final void x(Context r3, OperateType r4, int r5, rb6.a.a r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "operateType");
        this.b.E(r3, r4, r5, new C0243a(r6));
    }
}
