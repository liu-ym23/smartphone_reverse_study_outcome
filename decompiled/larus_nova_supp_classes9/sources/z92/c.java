package z92;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.t3;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import u42.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends x {
    public static final /* synthetic */ int c = 0;
    public final DataCenter b;

    public static final class a {
    }

    public static final class b implements i.a {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i.a
        public final z92.a a(t r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            if ((r3 instanceof t3) == false) goto L13;
            StringBuilder r0 = new StringBuilder("receive hover message. scene=");
            t3 r4 = (t3) r3;
            r0.append(r4.getScene());
            f.a(r0.toString());
            if (Intrinsics.areEqual(r4.getScene(), "consumption_manager_hover") == false) goto L8;
            boolean r1 = false;
            if (a0.d(this.a.b, false) == false) goto L8;
        L9:
            if (r1 == false) goto L13;
            z92.a r2 = new z92.a(r4);
            if (u42.d.b == false) goto L15;
            r2.d = new z92.b(r2);
            return r2;
        L15:
            return r2;
        L8:
            r1 = true;
        L13:
            return null;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        f.a("HoverMessagePublicScreenPlugin unload");
    }

    public c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(l r3) {
        Intrinsics.checkNotNullParameter(r3, "publicScreenContext");
        f.a("HoverMessagePublicScreenPlugin load");
        d r4 = d.b;
        n(d.a, r4);
        b r5 = new b(this);
        Intrinsics.checkNotNullParameter("WebcastPublicAreaHoverMessage", "messageMethod");
        Intrinsics.checkNotNullParameter(r5, "factory");
        n r0 = this.a;
        if (r0 == null) goto L6;
        r0.addMessageFactory("WebcastPublicAreaHoverMessage", r5);
        return;
    }
}
