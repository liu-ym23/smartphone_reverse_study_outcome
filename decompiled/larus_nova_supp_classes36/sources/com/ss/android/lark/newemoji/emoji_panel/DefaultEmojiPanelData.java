package com.ss.android.lark.newemoji.emoji_panel;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.newemoji.larkemoji.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.sequences.SequencesKt;
import qsb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DefaultEmojiPanelData {
    public final List<a> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_panel/DefaultEmojiPanelData$Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEFAULT", "CUSTOM", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Type extends Enum<Type> {
        public static final Type CUSTOM = null;
        public static final a Companion = null;
        public static final Type DEFAULT = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("DEFAULT", 1, 1);
            DEFAULT = r1;
            Type r3 = new Type("CUSTOM", 2, 2);
            CUSTOM = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public Type a;
        public String b;
        public String c;
        public final List<Pair<String, String>> d;

        /* JADX INFO: renamed from: com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData$a$a, reason: collision with other inner class name */
        public static final class RunnableC0197a implements Runnable {
            public static final RunnableC0197a a = null;

            static {
                a = new RunnableC0197a();
            }

            public RunnableC0197a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.b();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final List<String> a() {
            List<Pair<String, String>> r0 = this.d;
            ArrayList r1 = new ArrayList();
            Iterator r2 = ((ArrayList) r0).iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if ((!b.a().i7((String) ((Pair) r3).getFirst())) == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r5 = r1.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            r4.add((String) ((Pair) r5.next()).getFirst());
            goto L10
        L12:
            return r4;
        }

        public final List<com.ss.android.lark.newemoji.larkemoji.a> b() {
            List<Pair<String, String>> r0 = this.d;
            ArrayList r1 = new ArrayList();
            Iterator r2 = ((ArrayList) r0).iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Pair r3 = (Pair) r2.next();
            ReentrantLock r4 = c.a;
            com.ss.android.lark.newemoji.larkemoji.b r5 = c.d((String) r3.getFirst());
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L8:
            return r1;
        }

        public final String toString() {
            return "EmojiGroupData(type=" + this.a + ", iconKey='" + this.b + "', title='" + this.c + "', size=" + ((ArrayList) this.d).size() + ')';
        }

        public a() {
            this.a = Type.UNKNOWN;
            this.b = "";
            this.c = "";
            this.d = new ArrayList();
        }

        public final Type getType() {
            return this.a;
        }

        public final void c(List<Pair<String, String>> r4) {
            if (r4.isEmpty() == false) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            ((ArrayList) this.d).clear();
            ((ArrayList) this.d).addAll(r4);
            Iterator r5 = ((ArrayList) this.d).iterator();
        L10:
            if (r5.hasNext() == false) goto L15;
            Pair r1 = (Pair) r5.next();
            ReentrantLock r2 = c.a;
            String r3 = (String) r1.getFirst();
            String r6 = (String) r1.getSecond();
            if (r6 != null) goto L14;
            r6 = (String) r1.getFirst();
        L14:
            c.f(r3, r6);
            goto L10
        L15:
            ThreadUtils.runOnUIThread(RunnableC0197a.a);
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public final List<String> a() {
        List<a> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (((a) r3).getType() != Type.CUSTOM) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L12:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.map(CollectionsKt.asSequence(r1), DefaultEmojiPanelData$getCustomEmojiKeys$2.INSTANCE), DefaultEmojiPanelData$getCustomEmojiKeys$3.INSTANCE));
    }

    public final List<String> b() {
        List<a> r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        List<a> r2 = this.a;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L14:
        if (r4.hasNext() == false) goto L22;
        Object r5 = r4.next();
        if (((a) r5).getType() != Type.DEFAULT) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L14;
        r3.add(r5);
        goto L14
    L18:
        r6 = false;
        goto L19
    L22:
        return ((a) ListProtector.get(r3, 0)).a();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean c() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((a) r1).getType() != Type.CUSTOM) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
    L12:
        if (r1 != null) goto L21;
        return false;
    L21:
        return true;
    L8:
        r4 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final boolean d() {
        List<a> r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        return false;
    }

    public final String toString() {
        return this.a.toString();
    }

    public DefaultEmojiPanelData() {
        this.a = new ArrayList();
    }
}
