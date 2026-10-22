package og8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import bd8.b;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.utils.q;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.network.http.d;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v19.c;
import v19.i5;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends b {
    public TextView l;

    public a() {
        super(false, -1);
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return true;
    }

    @Override // bd8.b
    public final void A() {
        i r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.l != null) goto L18;
        TextView r1 = new TextView(getContext());
        r1.setVisibility(8);
        r1.setGravity(8388613);
        r1.setTextSize(14.0f);
        Context r2 = r1.getContext();
        TextView r3 = this.l;
        ViewGroup r4 = null;
        if (r3 == null) goto L10;
        Context r5 = r3.getContext();
    L11:
        r1.setTextColor(ContextCompat.getColor(r2, c.b(2130972082, r5, 2131103146)));
        ViewParent r6 = r0.getParent();
        if ((r6 instanceof ViewGroup) == false) goto L14;
        r4 = (ViewGroup) r6;
    L14:
        if (r4 == null) goto L16;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-1, -2);
        r7.setMargins(i5.m(), i5.e0(), i5.m(), 0);
        r7.topToBottom = r0.getId();
        Unit r8 = Unit.INSTANCE;
        r4.addView(r1, r7);
    L16:
        this.l = r1;
        return;
    L10:
        r5 = null;
        goto L11
    }

    @Override // bd8.b
    public final void C() {
        TextView r0 = this.l;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    @Override // bd8.b
    public final void w(Message r13, int r14, ec8.b r15) {
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r13, "message");
        if (d.e == false) goto L99;
        q0 r16 = this.e;
        String r17 = null;
        if (r16 == null) goto L15;
        List r18 = r16.getCurrentList();
        if (r18 == null) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator r19 = r18.iterator();
    L10:
        if (r19.hasNext() == false) goto L14;
        Object r1 = r19.next();
        if (com.larus.bmhome.chat.bean.d.G0((Message) r1) == false) goto L10;
        r0.add(r1);
        goto L10
    L14:
        List r110 = CollectionsKt.asReversed(r0);
    L16:
        int r2 = -1;
        if (r110 == null) goto L25;
        Iterator r3 = r110.iterator();
        int r4 = 0;
    L20:
        if (r3.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((Message) r3.next()).getMessageId(), r13.getMessageId()) == true) goto L26;
        r4 = r4 + 1;
    L26:
        String r5 = "";
        if (r4 < 0) goto L31;
        Context r111 = getContext();
        if (r111 == null) goto L75;
        r17 = r111.getString(2131900886, new Object[]{Integer.valueOf(r4 + 1)});
    L75:
        TextView r112 = this.l;
        if (r112 == null) goto L81;
        if (r17 == null) goto L80;
        r5 = r17;
    L80:
        r112.setText(r5);
    L81:
        TextView r113 = this.l;
        if (r113 == null) goto L100;
        e1.x(r113);
        return;
    L100:
        return;
    L31:
        if (r110 == null) goto L43;
        ListIterator r6 = r110.listIterator(r110.size());
    L34:
        if (r6.hasPrevious() == false) goto L41;
        Object r7 = r6.previous();
        if (((Message) r7).getLocalIndex() >= r13.getLocalIndex()) goto L38;
        boolean r8 = true;
    L39:
        if (r8 == false) goto L34;
    L42:
        Message r9 = (Message) r7;
    L44:
        if (r110 == null) goto L56;
        Iterator r114 = r110.iterator();
        int r10 = 0;
    L47:
        if (r114.hasNext() == false) goto L56;
        String r11 = ((Message) r114.next()).getMessageId();
        if (r9 == null) goto L51;
        String r12 = r9.getMessageId();
    L53:
        if (Intrinsics.areEqual(r11, r12) == true) goto L54;
        r10 = r10 + 1;
        goto L47
    L54:
        r2 = r10;
        goto L56
    L51:
        r12 = null;
    L56:
        int r115 = q.a;
        Regex r116 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        TextContent r117 = r.b(r13);
        if (r117 == null) goto L59;
        String r118 = r117.text;
    L60:
        if (r118 != null) goto L62;
        r118 = "";
    L62:
        int r119 = q.b(r118);
        if (r2 < 0) goto L72;
        StringBuilder r20 = new StringBuilder();
        Context r21 = getContext();
        if (r21 == null) goto L67;
        String r22 = r21.getString(2131900886, new Object[]{Integer.valueOf(r2 + 1)});
    L68:
        r20.append(r22);
        r20.append(" | ");
        Context r23 = getContext();
        if (r23 == null) goto L71;
        r17 = r23.getString(2131900887, new Object[]{Integer.valueOf(r119)});
    L71:
        r20.append(r17);
        r17 = r20.toString();
        goto L75
    L67:
        r22 = null;
        goto L68
    L72:
        Context r24 = getContext();
        if (r24 == null) goto L75;
        r17 = r24.getString(2131900887, new Object[]{Integer.valueOf(r119)});
        goto L75
    L59:
        r118 = null;
        goto L60
    L38:
        r8 = false;
        goto L39
    L41:
        r7 = null;
        goto L42
    L43:
        r9 = null;
    L25:
        r4 = -1;
    L15:
        r110 = null;
        goto L16
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        return CollectionsKt.emptyList();
    }
}
