package cu0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.fansclub.panel.FansClubPanelTypes;
import com.bytedance.android.live.profit.fansclub.panel.d;
import com.bytedance.android.live.profit.fansclub.panel.e;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements e<b> {
    public final Context a;

    /* JADX INFO: renamed from: cu0.a$a, reason: collision with other inner class name */
    public static final class C0228a implements p {
        public final Context a;
        public final Uri b;

        @Override // com.bytedance.android.live.profit.fansclub.p
        public final void show() {
            a(null);
        }

        public final void a(Function1<? super Uri, ? extends Uri> r4) {
            if (UriProtector.getQueryParameterNames(this.b).contains("height") == true) goto L5;
            Uri r0 = this.b.buildUpon().appendQueryParameter("height", String.valueOf(500)).build();
        L6:
            if (r4 == null) goto L11;
            Uri r5 = (Uri) r4.invoke(r0);
            if (r5 == null) goto L11;
            r0 = r5;
        L11:
            ((vy0.b) f.a(c.class)).U0(this.a, r0, null);
            return;
        L5:
            r0 = this.b;
            goto L6
        }

        public C0228a(Context r2, Uri r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends d {
        public x0 a;
        public x0 b;

        public b() {
            this.a = new x0(Uri.EMPTY);
            this.b = new x0(Uri.EMPTY);
        }
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final d a(FansClubEntranceParams r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceParams");
        return new b();
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final boolean b(int r2, FansClubEntranceParams r3) {
        Intrinsics.checkNotNullParameter(r3, "entranceParams");
        if (r2 != FansClubPanelTypes.Lynx.ordinal()) goto L5;
    L8:
        return true;
    L5:
        if (r2 == FansClubPanelTypes.Web.ordinal()) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.profit.fansclub.panel.e
    public final p c(int r3, FansClubEntranceParams r4, d r5) {
        b r6 = (b) r5;
        Intrinsics.checkNotNullParameter(r4, "entranceParams");
        Intrinsics.checkNotNullParameter(r6, "panelParams");
        if (r3 != FansClubPanelTypes.Lynx.ordinal()) goto L6;
        return new C0228a(this.a, r6.a.c());
    L6:
        if (r3 == FansClubPanelTypes.Web.ordinal()) goto L11;
        return null;
    L11:
        return new C0228a(this.a, x6.a.b(r6.b.toString()).buildUpon().appendQueryParameter("type", "popup").appendQueryParameter("gravity", "bottom").build());
    }
}
