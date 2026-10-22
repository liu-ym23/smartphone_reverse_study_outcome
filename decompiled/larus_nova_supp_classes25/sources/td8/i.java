package td8;

import com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final Lazy<Set<ChatMessageListUpdateObserver>> c = null;
    public static final AtomicLong d = null;
    public final d a;
    public final Lazy b;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((td8.b) r1).stage().getOrder()), Integer.valueOf(((td8.b) r2).stage().getOrder()));
        }
    }

    static {
        new a();
        c = LazyKt.lazy(new h());
        d = new AtomicLong();
    }

    public i(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [td8.g] */
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(final com.larus.bmhome.social.page.datasource.event.c<xc8.b> r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Iterator r0 = ((List) this.b.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        td8.b r1 = (td8.b) r0.next();
        r1.b();
        r10 = r1.a(r10);
        goto L4
    L7:
        if (((Set) c.getValue()).isEmpty() == true) goto L70;
        Long r2 = Long.valueOf(this.a.b());
        if (r2.longValue() == 0) goto L12;
        boolean r3 = true;
    L13:
        Object r4 = null;
        if (r3 == true) goto L17;
        r2 = null;
    L17:
        if (r2 == null) goto L19;
        String r5 = "chat:" + r2.longValue();
    L59:
        final Lazy r6 = LazyKt.lazy(new f(r10));
        Iterator r7 = ((Set) c.getValue()).iterator();
    L61:
        if (r7.hasNext() == false) goto L70;
        ChatMessageListUpdateObserver r8 = (ChatMessageListUpdateObserver) r7.next();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L65
        r8.b(r5, new g(r6));     // Catch: Throwable -> L65
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L65
    L67:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L61;
        FLogger.a.e("Pipeline", "notify message list observer failed, observer=".concat(r8.getClass().getSimpleName()), r12);
    L65:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L19:
        Long r14 = Long.valueOf(this.a.o());
        if (r14.longValue() <= 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == true) goto L26;
        r14 = null;
    L26:
        if (r14 == null) goto L28;
        r5 = "session:" + r14.longValue();
        goto L59
    L28:
        wc9.e r16 = this.a.g();
        if (r16 == null) goto L38;
        String r17 = r16.a;
        if (r17 == null) goto L38;
        if ((!StringsKt.isBlank(r17)) == true) goto L36;
        r17 = null;
    L36:
        if (r17 == null) goto L38;
        r5 = "conversation:".concat(r17);
    L38:
        Iterator r18 = r10.a.iterator();
    L40:
        if (r18.hasNext() == false) goto L51;
        Object r19 = r18.next();
        String r20 = ((xc8.b) r19).getMessage().getConversationId();
        if (r20 != null) goto L44;
    L47:
        boolean r21 = true;
    L49:
        if ((!r21) == false) goto L40;
        r4 = r19;
        goto L51
    L44:
        if (StringsKt.isBlank(r20) == true) goto L47;
        r21 = false;
    L51:
        xc8.b r22 = (xc8.b) r4;
        if (r22 == null) goto L58;
        Message r23 = r22.getMessage();
        if (r23 == null) goto L58;
        String r24 = r23.getConversationId();
        if (r24 == null) goto L58;
        r5 = "message:".concat(r24);
    L58:
        r5 = "update:" + d.incrementAndGet();
        goto L59
    L22:
        r15 = false;
        goto L23
    L12:
        r3 = false;
    L70:
        return r10;
    }
}
