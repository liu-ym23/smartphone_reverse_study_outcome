package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements k {
    public final com.ss.android.lark.keyboard.b a;
    public final ConcurrentHashMap<Object, p> b;
    public final Function1<Object, p> c;

    public interface a {
        void dispose();
    }

    @Override // com.ss.android.lark.keyboard.event.k
    public final Function1<h, Unit> b() {
        return IKeyboardEventCenter$emptyAction$1.INSTANCE;
    }

    public o(BasicKeyboard r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboard");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        this.c = new KeyboardEventCenter$handleFactory$1(this);
    }

    @Override // com.ss.android.lark.keyboard.event.k
    public final l of(Object r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        ConcurrentHashMap<Object, p> r0 = this.b;
        p r1 = r0.get(r3);
        if (r1 != null) goto L9;
        r1 = (p) this.c.invoke(r3);
        p r4 = r0.putIfAbsent(r3, r1);
        if (r4 == null) goto L9;
        r1 = r4;
    L9:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.lark.keyboard.event.k
    public final o a(j r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "buildAction");
        EventContextImpl.Factory r1 = EventContextImpl.c;
        com.ss.android.lark.keyboard.b r2 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "keyboard");
        EventContextImpl r3 = r1.a();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "keyboard");
        r3.a = r2;
        r3.b.clear();
        r11.invoke(r3);
        Iterator<T> r12 = this.b.values().iterator();
    L3:
        Object r4 = null;
        if (r12.hasNext() == false) goto L45;
        p r5 = (p) r12.next();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r3, "context");
        Iterator r6 = ((ArrayList) r5.g).iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r7 = r6.next();
        if (((Boolean) ((Function2) r7).invoke(r3, r10)).booleanValue() == false) goto L7;
        r4 = r7;
    L11:
        if (r4 != null) goto L12;
        if ((r10 instanceof q) == true) goto L15;
        if ((r10 instanceof t) == false) goto L44;
        t r8 = (t) r10;
        Set r9 = CollectionsKt.intersect(r5.f.a((Class<? extends m>) r8.a.getClass()), r5.f.a((Class<? extends m>) r8.b.getClass()));
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r14 = r9.iterator();
    L32:
        if (r14.hasNext() == false) goto L35;
        r13.add(r5.d.get((Class) r14.next()));
        goto L32
    L35:
        if (r13.isEmpty() == true) goto L3;
        Iterator r15 = r13.iterator();
    L39:
        if (r15.hasNext() == false) goto L3;
        Function3 r16 = (Function3) r15.next();
        if (r16 == null) goto L39;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.keyboard.event.Transform<S of com.ss.android.lark.keyboard.event.KeyboardEventHandle.handleTransformNoCheck>");
        Log.d("keyboard", "handleTransform: form " + r8.a.getTag() + " tp " + r8.b.getTag());
        r16.invoke(r3, r8.a, r8.b);
        goto L39
    L44:
        throw new NoWhenBranchMatchedException();
    L15:
        q r17 = (q) r10;
        Set<Class<? extends q>> r18 = r5.e.a((Class<? extends q>) r17.getClass());
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L17:
        if (r20.hasNext() == false) goto L20;
        r19.add(r5.c.get((Class) r20.next()));
        goto L17
    L20:
        if (r19.isEmpty() == true) goto L3;
        Iterator r21 = r19.iterator();
    L24:
        if (r21.hasNext() == false) goto L3;
        Function2 r22 = (Function2) r21.next();
        if (r22 == null) goto L24;
        Log.d("keyboard", "handleNotify: notify is " + r17.getTag());
        r22.invoke(r3, r17);
        goto L24
    L12:
        Log.d("keyboard", "onSend: event is intercepted");
        goto L3
    L45:
        r3.b.clear();
        r3.a = null;
        EventContextImpl.Factory r110 = EventContextImpl.c;
        if (r110.b.size() >= 3) goto L49;
        r110.b.add((T) r3);
    L49:
        if ((r10 instanceof s.b) == false) goto L51;
        ((s.b) r10).recycle();
    L51:
        return this;
    }
}
