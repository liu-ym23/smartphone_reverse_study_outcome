package kg8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import po8.c;
import v19.i5;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends bd8.b {
    public final Lazy l;
    public c m;

    public static final class a {
    }

    static {
    }

    @Override // bd8.b
    public final void C() {
        c r0 = this.m;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    public b(int r2) {
        super(true, r2);
        this.l = LazyKt.lazy(new kg8.a(this));
    }

    @Override // bd8.b
    public final void w(Message r5, int r6, ec8.b r7) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r5, "message");
        q0 r8 = this.e;
        boolean r9 = true;
        String r0 = null;
        if (r8 == null) goto L18;
        List<wq8.a> r10 = r8.D7();
        if (r10 == null) goto L18;
        Iterator<T> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r1 = r11.next();
        if ((!d.O0(((wq8.a) r1).getMessage())) == false) goto L8;
    L13:
        wq8.a r2 = (wq8.a) r1;
        if (r2 == null) goto L18;
        Message r12 = r2.getMessage();
        if (r12 == null) goto L18;
        String r13 = r12.getMessageId();
    L20:
        if (Intrinsics.areEqual(r13, r5.getMessageId()) == true) goto L25;
        FLogger.a.i("CreateDocBtnComponent", "Not the latest message , return");
        c r14 = this.m;
        if (r14 == null) goto L79;
        e1.o(r14);
        return;
    L79:
        return;
    L25:
        if (d.Q0(r5) == true) goto L31;
        if (d.I0(r5) == true) goto L31;
        if (r5.getMessageStatusLocal() == 20) goto L31;
    L32:
        boolean r15 = true;
    L34:
        if (r15 == false) goto L72;
        String r16 = r5.getMessageId();
        if (r16 != null) goto L38;
    L41:
        boolean r17 = true;
    L42:
        if (r17 == true) goto L72;
        Map r18 = r5.getExt();
        if (r18 == null) goto L47;
        String r19 = (String) r18.get("show_canvas_confirm");
    L48:
        if (r19 != null) goto L50;
    L69:
        FLogger.a.i("CreateDocBtnComponent", "The show_canvas_confirm is " + r19 + " , return");
        c r20 = this.m;
        if (r20 == null) goto L83;
        e1.o(r20);
        return;
    L83:
        return;
    L50:
        if (Intrinsics.areEqual(r19, "0") == true) goto L69;
        c r21 = this.m;
        if (r21 == null) goto L66;
        y r3 = (y) this.l.getValue();
        if (r3 == null) goto L61;
        e r4 = r3.h();
        if (r4 == null) goto L61;
        if (n.v(r4) != true) goto L61;
    L62:
        y r22 = (y) this.l.getValue();
        if (r22 == null) goto L65;
        r0 = r22.getBotId();
    L65:
        r21.a(r5, r9, r0);
    L61:
        r9 = false;
    L66:
        c r23 = this.m;
        if (r23 == null) goto L81;
        e1.x(r23);
        return;
    L81:
        return;
    L47:
        r19 = null;
        goto L48
    L38:
        if (r16.length() == 0) goto L41;
        r17 = false;
    L72:
        c r24 = this.m;
        if (r24 == null) goto L85;
        e1.o(r24);
        return;
    L85:
        return;
    L31:
        if (r5.getMessageStatusLocal() == 23) goto L32;
        r15 = false;
        goto L34
    L12:
        r1 = null;
    L18:
        r13 = null;
        goto L20
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        View r8 = new c(r3);
        this.m = r8;
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) r9).bottomMargin = i5.h();
        if (r5 == null) goto L6;
        r5.addView(r8, r2, r9);
    L6:
        return CollectionsKt.listOf(r8);
    }
}
