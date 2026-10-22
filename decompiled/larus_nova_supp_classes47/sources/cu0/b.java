package cu0;

import android.content.Context;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.fansclub.panel.FansClubPanelTypes;
import com.bytedance.android.live.profit.fansclub.panel.d;
import com.bytedance.android.live.profit.fansclub.panel.e;
import com.bytedance.android.live.revenue.core.util.f;
import kotlin.jvm.internal.Intrinsics;
import vy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements e<C0229b> {
    public final Context a;

    public static final class a implements p {
        public final Context a;
        public final String b;

        @Override // com.bytedance.android.live.profit.fansclub.p
        public final void show() {
            ((c) f.a(c.class)).j1(this.a, this.b);
        }

        public a(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "schema");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: cu0.b$b, reason: collision with other inner class name */
    public static final class C0229b extends d {
        public String a;

        public C0229b() {
            this.a = "";
        }
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final d a(FansClubEntranceParams r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceParams");
        return new C0229b();
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final boolean b(int r2, FansClubEntranceParams r3) {
        Intrinsics.checkNotNullParameter(r3, "entranceParams");
        if (r2 != FansClubPanelTypes.Redirect.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final p c(int r1, FansClubEntranceParams r2, d r3) {
        C0229b r4 = (C0229b) r3;
        Intrinsics.checkNotNullParameter(r2, "entranceParams");
        Intrinsics.checkNotNullParameter(r4, "panelParams");
        return new a(this.a, r4.a);
    }
}
