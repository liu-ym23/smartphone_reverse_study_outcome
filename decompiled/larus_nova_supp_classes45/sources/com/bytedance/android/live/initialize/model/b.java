package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.api.IWTOLogger;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final ConcurrentHashMap<Integer, IWTOTask> a;
    public final CopyOnWriteArrayList<IWTOTask> b;
    public final ConcurrentHashMap<com.bytedance.android.live.initialize.a, CopyOnWriteArrayList<IWTOTask>> c;
    public final Map<com.bytedance.android.live.initialize.a, a> d;
    public final List<IWTOTask> e;

    public static final class a {
        public final Map<Integer, IWTOTask> a;
        public final Map<Integer, Set<Integer>> b;
        public final Map<Integer, Set<Integer>> c;
        public final CopyOnWriteArrayList<IWTOTask> d;
        public final boolean e;

        public a(CopyOnWriteArrayList r6) {
            Intrinsics.checkNotNullParameter(r6, "tasks");
            this.d = r6;
            this.e = true;
            LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
            Iterator r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Object r1 = r7.next();
            r3.put(Integer.valueOf(((IWTOTask) r1).taskID()), r1);
            goto L4
        L6:
            this.a = r3;
            CopyOnWriteArrayList<IWTOTask> r8 = this.d;
            LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
            Iterator<T> r9 = r8.iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            Pair r2 = TuplesKt.to(Integer.valueOf(((IWTOTask) r9.next()).taskID()), new LinkedHashSet());
            r4.put(r2.getFirst(), r2.getSecond());
            goto L8
        L10:
            this.b = r4;
            CopyOnWriteArrayList<IWTOTask> r11 = this.d;
            LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
            Iterator<T> r12 = r11.iterator();
        L12:
            if (r12.hasNext() == false) goto L14;
            Pair r0 = TuplesKt.to(Integer.valueOf(((IWTOTask) r12.next()).taskID()), new LinkedHashSet());
            r5.put(r0.getFirst(), r0.getSecond());
            goto L12
        L14:
            this.c = r5;
            Iterator<T> r13 = this.d.iterator();
        L16:
            if (r13.hasNext() == false) goto L28;
            IWTOTask r14 = (IWTOTask) r13.next();
            if ((r14 instanceof IWTOSingleTask) == false) goto L16;
            Map<Integer, Set<Integer>> r15 = this.b;
            LinkedHashMap r16 = (LinkedHashMap) r15;
            Set r17 = (Set) r16.get(Integer.valueOf(r14.taskID()));
            if (r17 == null) goto L22;
            r17.addAll(((IWTOSingleTask) r14).taskDependencies());
        L22:
            Iterator<T> r18 = ((IWTOSingleTask) r14).taskDependencies().iterator();
        L24:
            if (r18.hasNext() == false) goto L16;
            int r19 = ((Number) r18.next()).intValue();
            Map<Integer, Set<Integer>> r21 = this.c;
            LinkedHashMap r22 = (LinkedHashMap) r21;
            Set r23 = (Set) r22.get(Integer.valueOf(r19));
            if (r23 == null) goto L24;
            r23.add(Integer.valueOf(r14.taskID()));
            goto L24
        }

        public final boolean a(IWTOTask r8, Set<Integer> r9, List<Integer> r11, List<Integer> r12) {
            r9.add(Integer.valueOf(r8.taskID()));
            ArrayList r1 = (ArrayList) r11;
            r1.add(Integer.valueOf(r8.taskID()));
            ArrayList r2 = (ArrayList) r12;
            r2.add(Integer.valueOf(r8.taskID()));
            Set r0 = (Set) ((LinkedHashMap) this.b).get(Integer.valueOf(r8.taskID()));
            if (r0 == null) goto L6;
            Iterator r3 = r0.iterator();
            if (r3 == null) goto L6;
        L8:
            if (r3.hasNext() == false) goto L22;
            int r4 = ((Number) r3.next()).intValue();
            if (r9.contains(Integer.valueOf(r4)) == false) goto L11;
            if (r1.contains(Integer.valueOf(r4)) == false) goto L8;
            r2.add(Integer.valueOf(r4));
            return true;
        L11:
            IWTOTask r5 = (IWTOTask) ((LinkedHashMap) this.a).get(Integer.valueOf(r4));
            if (r5 == null) goto L17;
            if (a(r5, r9, r11, r12) == false) goto L8;
            return true;
        L17:
            throw new RuntimeException(r8.taskID() + " 依赖的任务(" + r4 + ")不存在");
        L22:
            r1.remove(Integer.valueOf(r8.taskID()));
            if (r2.size() <= 0) goto L25;
            boolean r13 = true;
        L26:
            if (r13 == true) goto L29;
            r12 = null;
        L29:
            if (r12 == null) goto L31;
            ((Number) ListProtector.remove(r12, r12.size() - 1)).intValue();
        L31:
            return false;
        L25:
            r13 = false;
        L6:
            r3 = new ArrayList().listIterator();
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends IWTOTask> r5) {
        Intrinsics.checkNotNullParameter(r5, "mInitTaskList");
        this.e = r5;
        this.a = new ConcurrentHashMap();
        this.b = new CopyOnWriteArrayList();
        this.c = new ConcurrentHashMap();
        this.d = new LinkedHashMap();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        IWTOTask r0 = (IWTOTask) r6.next();
        if (this.c.get(r0.taskExecutePeriod()) != null) goto L8;
        this.c.put(r0.taskExecutePeriod(), new CopyOnWriteArrayList());
    L8:
        CopyOnWriteArrayList<IWTOTask> r1 = this.c.get(r0.taskExecutePeriod());
        if (r1 == null) goto L11;
        r1.add(r0);
    L11:
        this.a.put(Integer.valueOf(r0.taskID()), r0);
        goto L4
    L12:
        Iterator<Map.Entry<com.bytedance.android.live.initialize.a, CopyOnWriteArrayList<IWTOTask>>> r7 = this.c.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        Map.Entry<com.bytedance.android.live.initialize.a, CopyOnWriteArrayList<IWTOTask>> r2 = r7.next();
        this.d.put(r2.getKey(), new a(r2.getValue()));
        goto L14
    }

    public final List<IWTOTask> a(com.bytedance.android.live.initialize.a r12) {
        Intrinsics.checkNotNullParameter(r12, "period");
        ArrayList r0 = new ArrayList();
        CopyOnWriteArrayList<IWTOTask> r13 = this.c.get(r12);
        if (r13 == null) goto L66;
        ArrayList r1 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L5:
        boolean r2 = false;
        if (r14.hasNext() == false) goto L12;
        Object r3 = r14.next();
        if (c.a((IWTOTask) r3).a != WTOTaskStatus.IDLE) goto L10;
        r2 = true;
    L10:
        if (r2 == false) goto L5;
        r1.add(r3);
        goto L5
    L12:
        Iterator r15 = r1.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        IWTOTask r4 = (IWTOTask) r15.next();
        IWTOLogger r5 = ya0.a.a;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("taskBusiness", r4.taskBusinessInfo());
        Unit r7 = Unit.INSTANCE;
        ya0.a.a("getExecutableTask Filter First Time", r6.toString());
        goto L14
    L16:
        ArrayList r16 = new ArrayList();
        Iterator r8 = r1.iterator();
    L18:
        if (r8.hasNext() == false) goto L43;
        Object r9 = r8.next();
        IWTOTask r11 = (IWTOTask) r9;
        if ((r11 instanceof IWTORepeatableTask) == false) goto L22;
    L40:
        boolean r17 = true;
    L41:
        if (r17 == false) goto L18;
        r16.add(r9);
        goto L18
    L22:
        if ((r11 instanceof IWTOSingleTask) == false) goto L39;
        IWTOSingleTask r18 = (IWTOSingleTask) r11;
        List<Integer> r19 = r18.taskDependencies();
        ArrayList r21 = new ArrayList();
        Iterator<T> r22 = r19.iterator();
    L25:
        if (r22.hasNext() == false) goto L37;
        Object r23 = r22.next();
        int r24 = ((Number) r23).intValue();
        IWTOTask r25 = this.a.get(Integer.valueOf(r24));
        if (r25 == null) goto L29;
        WTOTaskStatus r26 = c.a(r25).a;
    L31:
        if (r26 != WTOTaskStatus.FINISHED) goto L33;
        boolean r27 = true;
    L34:
        if (r27 == false) goto L25;
        r21.add(r23);
        goto L25
    L33:
        r27 = false;
        goto L34
    L29:
        r26 = null;
        goto L31
    L37:
        if (r21.size() == r18.taskDependencies().size()) goto L40;
    L39:
        r17 = false;
        goto L41
    L43:
        Iterator r28 = r16.iterator();
    L45:
        if (r28.hasNext() == false) goto L48;
        IWTOTask r29 = (IWTOTask) r28.next();
        IWTOLogger r31 = ya0.a.a;
        LinkedHashMap r32 = new LinkedHashMap();
        r32.put("taskBusiness", r29.taskBusinessInfo());
        Unit r33 = Unit.INSTANCE;
        ya0.a.a("getExecutableTask Filter Second Time", r32.toString());
        goto L45
    L48:
        return r16;
    L66:
        return r0;
    }
}
