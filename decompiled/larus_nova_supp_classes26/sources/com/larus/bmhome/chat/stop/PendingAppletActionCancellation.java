package com.larus.bmhome.chat.stop;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PendingAppletActionCancellation {
    public static final PendingAppletActionCancellation a = null;
    public static final List<c> b = null;
    public static final CopyOnWriteArraySet<a> c = null;
    public static volatile boolean d;

    public interface a {
        void a(b r1);
    }

    public static final class b {
        public final String a;
        public final Set<String> b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            String r4 = this.c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "StoppedRound(conversationId=" + this.a + ", messageIds=" + this.b + ", scene=" + this.c + ')';
        }

        public b(String r2, Set<String> r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "messageIds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final String a;
        public final Set<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "StoppedRoundRecord(conversationId=" + this.a + ", messageIds=" + this.b + ')';
        }

        public c(String r2, Set<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "messageIds");
            this.a = r2;
            this.b = r3;
        }
    }

    public PendingAppletActionCancellation() {
    }

    static {
        a = new PendingAppletActionCancellation();
        b = new ArrayList();
        c = new CopyOnWriteArraySet();
    }

    public static boolean b(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (d == true) goto L5;
        return false;
    L5:
        List r0 = CollectionsKt.listOf(new String[]{r4.getMessageId(), r4.getLocalMessageId()});
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        String r3 = e((String) r1.next());
        if (r3 == null) goto L7;
        r2.add(r3);
        goto L7
    L11:
        Set r5 = CollectionsKt.toSet(r2);
        if (r5.isEmpty() == false) goto L15;
        return false;
    L15:
        return d(r5, e(r4.getConversationId()));
    }

    public static String e(String r3) {
        if (r3 == null) goto L15;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L15;
        boolean r1 = false;
        if (r4.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L13:
        if (r1 == false) goto L15;
        return r4;
    L11:
        if (Intrinsics.areEqual(r4, "null") == true) goto L13;
        r1 = true;
        goto L13
    L8:
        r0 = false;
    L15:
        return null;
    }

    public static boolean d(Set r7, String r8) {
        List<c> r0 = b;
        monitor-enter(r0);
        boolean r2 = false;
        if (((ArrayList) r0).isEmpty() == true) goto L35;
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L37
    L8:
        if (r1.hasNext() == false) goto L35;
        c r3 = (c) r1.next();     // Catch: Throwable -> L37
        Set<String> r4 = r3.b;     // Catch: Throwable -> L37
        if ((r4 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r5 = r4.iterator();     // Catch: Throwable -> L37
    L17:
        if (r5.hasNext() == false) goto L21;
        if (r7.contains((String) r5.next()) == false) goto L17;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L32;
        PendingAppletActionCancellation r9 = a;     // Catch: Throwable -> L37
        String r10 = r3.a;     // Catch: Throwable -> L37
        r9.getClass();     // Catch: Throwable -> L37
        if (r10 == null) goto L29;
        if (r8 == null) goto L29;
        boolean r11 = Intrinsics.areEqual(r10, r8);     // Catch: Throwable -> L37
    L30:
        if (r11 == false) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L8;
        r2 = true;
    L29:
        r11 = true;
    L32:
        r12 = false;
    L21:
        r6 = false;
        goto L22
    L13:
        if (r4.isEmpty() == false) goto L15;
    L35:
        monitor-exit(r0);
        return r2;
    L37:
        th = move-exception;
        throw th;
    }

    public final void a(com.larus.bmhome.chat.stop.a r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "target");
        List<Message> r0 = com.larus.bmhome.chat.stop.b.c(r10);
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (b0.f((Message) r3) == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        String r4 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.plus(r1, r10.b)), new f()));
        Set r12 = SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence(CollectionsKt.plus(r1, r10.b)), new g()), new PendingAppletActionCancellation$cancel$messageIds$2(this)));
        if (r12.isEmpty() == false) goto L11;
        return;
    L11:
        List<c> r5 = b;
        monitor-enter(r5);
        Iterator r6 = ((ArrayList) r5).iterator();     // Catch: Throwable -> L67
        int r7 = 0;
    L15:
        if (r6.hasNext() == false) goto L41;
        c r8 = (c) r6.next();     // Catch: Throwable -> L67
        Set<String> r9 = r8.b;     // Catch: Throwable -> L67
        if ((r9 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r13 = r9.iterator();     // Catch: Throwable -> L67
    L23:
        if (r13.hasNext() == false) goto L27;
        if (r12.contains((String) r13.next()) == false) goto L23;
        boolean r14 = true;
    L28:
        if (r14 == false) goto L37;
        PendingAppletActionCancellation r15 = a;     // Catch: Throwable -> L67
        String r16 = r8.a;     // Catch: Throwable -> L67
        r15.getClass();     // Catch: Throwable -> L67
        if (r16 == null) goto L34;
        if (r4 == null) goto L34;
        boolean r17 = Intrinsics.areEqual(r16, r4);     // Catch: Throwable -> L67
    L35:
        if (r17 == false) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == true) goto L42;
        r7 = r7 + 1;     // Catch: Throwable -> L67
    L42:
        if (r7 < 0) goto L48;
        c r19 = (c) ((ArrayList) b).remove(r7);     // Catch: Throwable -> L67
        String r20 = r19.a;     // Catch: Throwable -> L67
        if (r20 == null) goto L47;
        r4 = r20;
    L47:
        c r21 = new c(r4, SetsKt.plus(r19.b, r12));     // Catch: Throwable -> L67
    L49:
        ((ArrayList) b).add(r21);     // Catch: Throwable -> L67
    L50:
        List<c> r110 = b;     // Catch: Throwable -> L67
        if (((ArrayList) r110).size() <= 64) goto L53;
        ((ArrayList) r110).remove(0);     // Catch: Throwable -> L67
        goto L50
    L53:
        d = true;     // Catch: Throwable -> L67
        monitor-exit(r5);
        b r111 = new b(r21.a, r21.b, r11);
        CopyOnWriteArraySet<a> r112 = c;
        if (r112.isEmpty() == true) goto L66;
        Iterator<a> r113 = r112.iterator();
    L60:
        if (r113.hasNext() == false) goto L89;
        r113.next().a(r111);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        FLogger.a.e("PendingAppletStop", "round stop revoker failed, scene=" + r111.c, th);
        goto L60
    L89:
        return;
    L66:
        return;
    L48:
        r21 = new c(r4, r12);     // Catch: Throwable -> L67
    L34:
        r17 = true;
    L37:
        r18 = false;
    L27:
        r14 = false;
        goto L28
    L19:
        if (r9.isEmpty() == false) goto L21;
    L41:
        r7 = -1;
    L67:
        th = move-exception;
        throw th;
    }

    public final boolean c(Message r6, Message r7) {
        Intrinsics.checkNotNullParameter(r6, "reply");
        Intrinsics.checkNotNullParameter(r7, "question");
        if (d == true) goto L5;
        return false;
    L5:
        Set r2 = SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence(CollectionsKt.listOf(new Message[]{r6, r7})), new e()), new PendingAppletActionCancellation$isCancelledRound$normalizedRoundIds$2(this)));
        if (r2.isEmpty() == false) goto L9;
        return false;
    L9:
        return d(r2, (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf(new String[]{r6.getConversationId(), r7.getConversationId()}), new PendingAppletActionCancellation$isCancelledRound$normalizedConversationId$1(this))));
    }
}
