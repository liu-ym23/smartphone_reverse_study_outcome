package hk8;

import android.view.View;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public boolean a;
    public hk8.a b;
    public b c;
    public String d;
    public final Lazy e;

    public static final class a implements gk8.b {
        public final /* synthetic */ e a;

        @Override // gk8.b
        public final void a() {
            hk8.a r0 = this.a.b;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == false) goto L10;
            return;
        L10:
            if (r0 == null) goto L16;
            Function0<Boolean> r2 = r0.m;
            if (r2 == null) goto L16;
            if (((Boolean) r2.invoke()).booleanValue() != true) goto L16;
            r1 = true;
        L16:
            if (r1 == false) goto L18;
            return;
        L18:
            e r4 = this.a;
            r4.a = !r4.a;
            b r5 = r4.c;
            if (r5 == null) goto L22;
            r5.a();
            return;
        L22:
            return;
        L5:
            if (r0.n != true) goto L7;
            r3 = true;
            goto L8
        }

        public a(e r1) {
            this.a = r1;
        }

        @Override // gk8.b
        public final void b(String r2, String r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            Intrinsics.checkNotNullParameter(r3, ShareType.URL);
            Intrinsics.checkNotNullParameter(r4, "view");
            b r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.b(r2, r3, r4);
            return;
        }
    }

    public e() {
        this.e = LazyKt.lazy(new d(this));
    }
}
