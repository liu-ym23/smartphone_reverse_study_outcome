package hm8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.memory.view.MemoryView;
import com.larus.im.bean.message.Message;
import java.util.List;
import jm8.m;
import km8.g;
import km8.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ph8.e;
import ph8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public m d;

    public static final class a {
    }

    static {
    }

    public final MemoryView b() {
        return (MemoryView) this.b.getValue();
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new hm8.a(this));
        this.c = LazyKt.lazy(new b());
    }

    public final void a(km8.a r19, g r20) {
        Intrinsics.checkNotNullParameter(r19, "vmData");
        i r3 = (i) this.c.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r19, "vmData");
        r3.d = r19;
        r3.c = r20;
        i r1 = (i) this.c.getValue();
        km8.a r2 = r1.d;
        Integer r4 = null;
        if (r2 == null) goto L11;
        e r5 = r2.d;
        if (r5 == null) goto L11;
        List r6 = r5.f();
        if (r6 == null) goto L11;
        List r7 = CollectionsKt.filterNotNull(r6);
        if (r7 == null) goto L11;
        f r8 = (f) CollectionsKt.firstOrNull(r7);
    L12:
        km8.a r9 = r1.d;
        if (r9 == null) goto L17;
        Message r10 = r9.c;
        if (r10 == null) goto L17;
        String r11 = r10.getMessageId();
    L18:
        long r12 = ((Number) r1.e.getValue()).longValue();
        km8.a r13 = r1.d;
        if (r13 == null) goto L21;
        Pair<Integer, Integer> r14 = r13.a;
    L22:
        if (r13 == null) goto L26;
        e r15 = r13.d;
        if (r15 == null) goto L26;
        Boolean r16 = r15.d();
    L27:
        km8.a r17 = r1.d;
        if (r17 == null) goto L32;
        e r18 = r17.d;
        if (r18 == null) goto L32;
        String r110 = r18.b();
    L33:
        km8.a r21 = r1.d;
        if (r21 == null) goto L38;
        e r22 = r21.d;
        if (r22 == null) goto L38;
        String r111 = r22.a();
    L39:
        km8.a r23 = r1.d;
        if (r23 == null) goto L44;
        e r24 = r23.d;
        if (r24 == null) goto L44;
        String r112 = r24.g();
    L45:
        km8.a r25 = r1.d;
        if (r25 == null) goto L50;
        e r26 = r25.d;
        if (r26 == null) goto L50;
        Boolean r113 = r26.c();
    L51:
        if (r8 == null) goto L53;
        String r114 = r8.b();
    L54:
        if (r8 == null) goto L56;
        String r115 = r8.a();
    L57:
        km8.a r27 = r1.d;
        if (r27 == null) goto L60;
        r4 = r27.e;
    L60:
        m r28 = new m(r11, r14, r12, r4, r16, r110, r111, r112, r113, r114, r115);
        r1.a = r28;
        this.d = r28;
        b().e(r28, ((i) this.c.getValue()).b);
        return;
    L56:
        r115 = null;
        goto L57
    L53:
        r114 = null;
    L50:
        r113 = null;
    L44:
        r112 = null;
    L38:
        r111 = null;
    L32:
        r110 = null;
    L26:
        r16 = null;
        goto L27
    L21:
        r14 = null;
    L17:
        r11 = null;
    L11:
        r8 = null;
        goto L12
    }
}
