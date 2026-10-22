package nl8;

import android.view.View;
import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public boolean a;
    public nl8.a b;
    public final ButtonStatus c;
    public b d;
    public String e;
    public final Lazy f;

    public static final class a implements fj8.b {
        public final /* synthetic */ e a;

        @Override // fj8.b
        public final void onRejectClick() {
        }

        @Override // fj8.b
        public final void a() {
            nl8.a r0 = this.a.b;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == true) goto L10;
            return;
        L10:
            if (r0 != null) goto L12;
        L14:
            boolean r4 = false;
        L15:
            if (r4 == false) goto L17;
            return;
        L17:
            if (r0 == null) goto L23;
            Function0<Boolean> r2 = r0.g;
            if (r2 == null) goto L23;
            if (((Boolean) r2.invoke()).booleanValue() != true) goto L23;
            r1 = true;
        L23:
            if (r1 == false) goto L25;
            return;
        L25:
            e r5 = this.a;
            r5.a = !r5.a;
            b r6 = r5.d;
            if (r6 == null) goto L29;
            r6.a();
            return;
        L29:
            return;
        L12:
            if (r0.h != true) goto L14;
            r4 = true;
            goto L15
        L5:
            if (r0.d != true) goto L7;
            r3 = true;
            goto L8
        }

        public a(e r1) {
            this.a = r1;
        }

        @Override // fj8.b
        public final void b(String r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.URL);
            Intrinsics.checkNotNullParameter(r3, "view");
            b r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.b(r2, r3);
            return;
        }
    }

    public e() {
        this.c = ButtonStatus.HIDE;
        this.f = LazyKt.lazy(new d(this));
    }
}
