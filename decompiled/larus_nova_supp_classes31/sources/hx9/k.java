package hx9;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import gx9.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final t1a.b a;
    public final Function0<List<Message>> b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public final List<Message> a() {
        u7 r0 = (u7) this.h.getValue();
        if (r0 == null) goto L7;
        MessageAdapter r1 = r0.MF();
        if (r1 == null) goto L7;
        List<Message> r2 = r1.getCurrentList();
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r2 = null;
        goto L8
    }

    public final de8.c c() {
        return (de8.c) this.c.getValue();
    }

    public final y d() {
        return (y) this.d.getValue();
    }

    public final List<Message> e() {
        List<Message> r0 = (List) this.b.invoke();
        if (r0 != null) goto L11;
        u7 r1 = (u7) this.h.getValue();
        if (r1 == null) goto L7;
        List<Message> r2 = r1.zj();
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r2 = null;
        goto L8
    L11:
        return r0;
    }

    public final Message b() {
        List<Message> r0 = e();
        Object r2 = null;
        if (com.larus.bmhome.chat.bean.d.U0() == true) goto L10;
        Message r1 = (Message) CollectionsKt.firstOrNull(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        if (p.a(r1) == true) goto L9;
        return null;
    L9:
        return r1;
    L10:
        List<Message> r3 = a();
        List<Message> r4 = r0;
        if (r4.isEmpty() == true) goto L14;
        r3 = r4;
    L14:
        Iterator<T> r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L50;
        Object r6 = r5.next();
        Message r7 = (Message) r6;
        boolean r8 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r7) == false) goto L23;
        if (com.larus.bmhome.chat.bean.d.w(r7) == true) goto L23;
    L42:
        boolean r9 = false;
    L43:
        if (r9 == false) goto L47;
        if (p.a(r7) == false) goto L47;
        r8 = true;
    L47:
        if (r8 == false) goto L16;
        r2 = r6;
    L23:
        if (com.larus.bmhome.chat.bean.d.T(r7) == true) goto L42;
        if (com.larus.bmhome.chat.bean.d.p0(r7) == true) goto L42;
        if (com.larus.bmhome.chat.bean.d.C0(r7) == true) goto L30;
    L32:
        MessageStatus r10 = r7.getMessageStatus();
        if (r10 != null) goto L35;
    L37:
        boolean r11 = false;
    L38:
        if (r11 == false) goto L40;
    L41:
        r9 = true;
        goto L43
    L40:
        if (b0.f(r7) == false) goto L42;
    L35:
        if (r10.isVisible() != true) goto L37;
        r11 = true;
        goto L38
    L30:
        if (r7.getRegenVisible() == true) goto L32;
    L50:
        return (Message) r2;
    }

    public k(t1a.b r2, com.larus.suggest.impl.g r3) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "pendingMessageList");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new b(this));
        this.d = LazyKt.lazy(new c(this));
        this.e = LazyKt.lazy(new d(this));
        this.f = LazyKt.lazy(new e(this));
        this.g = LazyKt.lazy(new f(this));
        this.h = LazyKt.lazy(new g(this));
        this.i = LazyKt.lazy(new h(this));
        this.j = LazyKt.lazy(new i(this));
        this.k = LazyKt.lazy(new j());
    }
}
