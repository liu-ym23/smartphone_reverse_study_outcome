package xl8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import cb8.x1;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.e2;
import jc8.d;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends jc8.b<xl8.a> {
    public wl8.a d;
    public kc8.b e;
    public final Lazy f;

    public static final class a implements yl8.c {
        public final y a;

        @Override // yl8.c
        public final boolean a() {
            y r0 = this.a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(r0.h, Boolean.TRUE);
        }

        @Override // yl8.c
        public final q0 e() {
            y r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.x;
        }

        @Override // yl8.c
        public final e h() {
            y r0 = this.a;
            if (r0 == null) goto L7;
            Function0 r1 = r0.e;
            if (r1 == null) goto L7;
            return (e) r1.invoke();
        L7:
            return null;
        }

        public a(y r1) {
            this.a = r1;
        }
    }

    public final String c() {
        return "LyricsToSongBlockHolder";
    }

    public c() {
        this.f = LazyKt.lazy(new b(this));
    }

    public final d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((xl8.a) r2, "blockModel");
        return new d(0, 0, 0, 0);
    }

    public final void g(jc8.a r13) {
        xl8.a r14 = (xl8.a) r13;
        Intrinsics.checkNotNullParameter(r14, "blockModel");
        this.e = jc8.c.a(this, kc8.b.class);
        wl8.a r0 = this.d;
        if (r0 == null) goto L5;
        j(r0);
    L5:
        cd8.a r1 = jc8.c.a(this, cd8.a.class);
        if (r1 == null) goto L8;
        int r2 = r1.a;
    L9:
        yl8.b r3 = new yl8.b(r2, x1.b(((jc8.b) this).a, r14, xl8.a.class), r14.i);
        wl8.a r15 = this.d;
        if (r15 == null) goto L36;
        yl8.c r4 = (yl8.c) this.f.getValue();
        Intrinsics.checkNotNullParameter(r3, "vmData");
        LinearLayout.LayoutParams r5 = null;
        if (r4 == null) goto L14;
        q0 r7 = r4.e();
    L15:
        Message r6 = r3.c.a;
        if (r4 == null) goto L18;
        e r8 = r4.h();
    L19:
        if (r4 == null) goto L21;
        boolean r9 = r4.a();
    L23:
        if (e2.a.isPad() == false) goto L31;
        int r10 = r15.a.getResources().getDimensionPixelSize(v19.c.b(2130971486, r15.a, 2131167341));
        ViewGroup.LayoutParams r11 = r15.c.getLayoutParams();
        if ((r11 instanceof LinearLayout.LayoutParams) == false) goto L28;
        r5 = (LinearLayout.LayoutParams) r11;
    L28:
        if (r5 != null) goto L30;
        r5 = new LinearLayout.LayoutParams(Math.min(r3.a, r10), -2);
    L30:
        r5.width = Math.min(r3.a, r10);
        r5.height = -2;
        r15.c.setLayoutParams(r5);
    L31:
        if (r7 == null) goto L33;
    L34:
        r15.b.a(r6, r7, r8, r9, r3.c.b, r15.d);
        return;
    L33:
        if (r15.e == true) goto L34;
        return;
    L21:
        r9 = false;
        goto L23
    L18:
        r8 = null;
        goto L19
    L14:
        r7 = null;
        goto L15
    L36:
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        this.e = jc8.c.a(this, kc8.b.class);
        wl8.a r0 = new wl8.a(r2.getContext());
        this.d = r0;
        j(r0);
        return r0.c;
    }

    public final void j(wl8.a r5) {
        kc8.b r0 = this.e;
        Fragment r1 = null;
        if (r0 == null) goto L7;
        y r2 = r0.a;
        if (r2 == null) goto L7;
        RecyclerView.Adapter r3 = r2.w;
    L9:
        if ((r3 instanceof ry8.d) == false) goto L11;
        ry8.d r4 = (ry8.d) r3;
    L12:
        if (r0 == null) goto L16;
        y r6 = r0.a;
        if (r6 == null) goto L16;
        r1 = r6.a;
    L16:
        if (r4 == null) goto L18;
        r4.l();
        boolean r7 = true;
    L19:
        r5.d = r1;
        r5.e = r7;
        return;
    L18:
        r7 = false;
        goto L19
    L11:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }
}
