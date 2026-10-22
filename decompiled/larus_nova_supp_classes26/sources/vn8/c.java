package vn8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardBtnAction;
import kotlin.jvm.internal.Intrinsics;
import un8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public vn8.a a;
    public b b;
    public final a c;

    public static final class a implements m {
        public final /* synthetic */ c a;

        @Override // un8.m
        public final boolean c() {
            c r0 = this.a;
            vn8.a r1 = r0.a;
            if (r1 != null) goto L5;
            return false;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.b(r1);
            return true;
        L9:
            return false;
        }

        public final void d() {
            b r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public a(c r1) {
            this.a = r1;
        }

        @Override // un8.m
        public final void b(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            c r0 = this.a;
            vn8.a r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.c(r3, r1);
            return;
        }

        @Override // un8.m
        public final void a(Context r3, TaskCardBtnAction r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "action");
            c r0 = this.a;
            vn8.a r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            b r2 = r0.b;
            if (r2 == null) goto L9;
            r2.d(r3, r1, r4);
            return;
        }
    }

    public c() {
        this.c = new a(this);
    }
}
