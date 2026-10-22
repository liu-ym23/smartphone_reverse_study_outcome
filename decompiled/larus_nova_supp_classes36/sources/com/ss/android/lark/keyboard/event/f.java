package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> {
    public final Map<Class<? extends T>, Set<Class<? extends T>>> a;
    public final Map<Class<? extends T>, Set<Class<? extends T>>> b;

    public static final class a {
    }

    static {
    }

    public f() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final Set<Class<? extends T>> a(Class<? extends T> r9) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Log.d("keyboard", "handleNotifyType: method called");
        if (this.b.containsKey(r9) == false) goto L16;
        Log.d("keyboard", "handleNotifyType: findSelect type, method return");
        StringBuilder r1 = new StringBuilder("select type is : ");
        Set r3 = ((LinkedHashMap) this.a).keySet();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r5.add(((Class) r4.next()).getName());
        goto L6
    L8:
        r1.append(r5);
        r1.append("; notify type is: ");
        Set r2 = ((LinkedHashMap) this.b).keySet();
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r7 = r2.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.add(((Class) r7.next()).getName());
        goto L10
    L12:
        r1.append(r6);
        Log.d("keyboard", r1.toString());
        Set<Class<? extends T>> r10 = (Set) ((LinkedHashMap) this.b).get(r9);
        if (r10 == null) goto L15;
        return r10;
    L15:
        return SetsKt.emptySet();
    L16:
        Set r8 = ((LinkedHashMap) this.a).keySet();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r8.iterator();
    L18:
        if (r12.hasNext() == false) goto L22;
        T r13 = r12.next();
        if (((Class) r13).isAssignableFrom(r9) == false) goto L18;
        r11.add(r13);
        goto L18
    L22:
        Set<Class<? extends T>> r14 = CollectionsKt.toMutableSet(r11);
        this.b.put(r9, r14);
        Iterator<T> r15 = r14.iterator();
    L24:
        if (r15.hasNext() == false) goto L28;
        Class r16 = (Class) r15.next();
        Set r17 = (Set) ((LinkedHashMap) this.a).get(r16);
        if (r17 == null) goto L24;
        r17.add(r9);
        goto L24
    L28:
        StringBuilder r18 = new StringBuilder("select type is : ");
        Set r19 = ((LinkedHashMap) this.a).keySet();
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<T> r21 = r19.iterator();
    L30:
        if (r21.hasNext() == false) goto L32;
        r20.add(((Class) r21.next()).getName());
        goto L30
    L32:
        r18.append(r20);
        r18.append("; notify type is: ");
        Set r22 = ((LinkedHashMap) this.b).keySet();
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L34:
        if (r24.hasNext() == false) goto L36;
        r23.add(((Class) r24.next()).getName());
        goto L34
    L36:
        r18.append(r23);
        Log.d("keyboard", r18.toString());
        return r14;
    }

    public final void b(Class r9) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Log.d("keyboard", "handleSelectType: method called");
        if (this.a.containsKey(r9) == false) goto L16;
        Log.d("keyboard", "handleSelectType: findSelect type, method return");
        StringBuilder r1 = new StringBuilder("select type is : ");
        Set r3 = ((LinkedHashMap) this.a).keySet();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r5.add(((Class) r4.next()).getName());
        goto L6
    L8:
        r1.append(r5);
        r1.append("; notify type is: ");
        Set r2 = ((LinkedHashMap) this.b).keySet();
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r7 = r2.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.add(((Class) r7.next()).getName());
        goto L10
    L12:
        r1.append(r6);
        Log.d("keyboard", r1.toString());
        if (((Set) ((LinkedHashMap) this.a).get(r9)) != null) goto L52;
        SetsKt.emptySet();
        return;
    L52:
        return;
    L16:
        Set r8 = ((LinkedHashMap) this.b).keySet();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L18:
        if (r11.hasNext() == false) goto L22;
        T r12 = r11.next();
        if (r9.isAssignableFrom((Class) r12) == false) goto L18;
        r10.add(r12);
        goto L18
    L22:
        Set<Class<? extends T>> r13 = CollectionsKt.toMutableSet(r10);
        this.a.put(r9, r13);
        Iterator<T> r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L28;
        Class r15 = (Class) r14.next();
        Set r16 = (Set) ((LinkedHashMap) this.b).get(r15);
        if (r16 == null) goto L24;
        r16.add(r9);
        goto L24
    L28:
        StringBuilder r17 = new StringBuilder("select type is : ");
        Set r18 = ((LinkedHashMap) this.a).keySet();
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L30:
        if (r20.hasNext() == false) goto L32;
        r19.add(((Class) r20.next()).getName());
        goto L30
    L32:
        r17.append(r19);
        r17.append("; notify type is: ");
        Set r21 = ((LinkedHashMap) this.b).keySet();
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r23 = r21.iterator();
    L34:
        if (r23.hasNext() == false) goto L36;
        r22.add(((Class) r23.next()).getName());
        goto L34
    L36:
        r17.append(r22);
        Log.d("keyboard", r17.toString());
    }
}
