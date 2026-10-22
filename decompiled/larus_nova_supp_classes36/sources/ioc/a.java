package ioc;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.cta.newstyle.adapter.VersionInfoAdapter;
import java.util.Iterator;
import java.util.List;
import joc.d;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends OnSingleClickListener {
    public final /* synthetic */ joc.a a;
    public final /* synthetic */ VersionInfoAdapter b;
    public final /* synthetic */ VersionInfoAdapter.VersionViewHolder c;

    public final void onSingleClick(View r9) {
        if (this.a.a.f() == false) goto L36;
        VersionInfoAdapter r10 = this.b;
        int r0 = this.c.getBindingAdapterPosition();
        List r1 = CollectionsKt.toMutableList(r10.c.getCurrentList());
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L11;
        if (((joc.a) r2.next()).b == true) goto L12;
        r4 = r4 + 1;
    L12:
        if (r4 == r0) goto L26;
        Iterator r3 = r1.iterator();
        int r5 = 0;
    L16:
        if (r3.hasNext() == false) goto L25;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        joc.a r8 = (joc.a) r6;
        if (r5 != r0) goto L23;
        boolean r11 = true;
    L24:
        r8.b = r11;
        r5 = r7;
        goto L16
    L23:
        r11 = false;
        goto L24
    L25:
        r10.c.submitList(r1, new b(r4, r10, r0));
    L26:
        d r12 = this.b.b;
        int r13 = this.c.getBindingAdapterPosition();
        String r14 = this.a.a.d();
        if (r14 != null) goto L29;
        r14 = "";
    L29:
        r12.a(r13, r14);
        return;
    L11:
        r4 = -1;
        goto L12
    }

    public a(joc.a r1, VersionInfoAdapter r2, VersionInfoAdapter.VersionViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(500);
    }
}
