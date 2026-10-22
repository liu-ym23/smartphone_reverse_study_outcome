package com.obric.assistant.complex_task;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.task.ITaskCenter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ComplexTaskManager {
    public static final t a = null;
    public static final ConcurrentHashMap<String, Pair<DMTaskInfo, DMTaskState>> b = null;
    public static long c;
    public static final ComplexTaskManager$complexTaskStateListener$1 d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/complex_task/ComplexTaskManager$UpdateSource;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "TASK_STATE_CHANGED", "UPDATE_PENDING", "MANAGER_INIT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UpdateSource extends Enum<UpdateSource> {
        public static final UpdateSource MANAGER_INIT = null;
        public static final UpdateSource TASK_STATE_CHANGED = null;
        public static final UpdateSource UPDATE_PENDING = null;
        public static final /* synthetic */ UpdateSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UpdateSource> getEntries() {
            return b;
        }

        static {
            UpdateSource r0 = new UpdateSource("TASK_STATE_CHANGED", 0);
            TASK_STATE_CHANGED = r0;
            UpdateSource r1 = new UpdateSource("UPDATE_PENDING", 1);
            UPDATE_PENDING = r1;
            UpdateSource r3 = new UpdateSource("MANAGER_INIT", 2);
            MANAGER_INIT = r3;
            UpdateSource[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static UpdateSource[] values() {
            return (UpdateSource[]) a.clone();
        }

        public static UpdateSource valueOf(String r1) {
            return (UpdateSource) r27.a.a(UpdateSource.class, r1);
        }

        public UpdateSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((((r3 + r1) * 31) + this.c) * 31) + this.d;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsyncTaskMobParams(instructionId=" + this.a + ", referenceMessageId=" + this.b + ", totalTaskCount=" + this.c + ", totalTaskCountAfterRemoval=" + this.d + ')';
        }

        public a(String r1, String r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        a = new t();
        b = new ConcurrentHashMap();
        d = new ComplexTaskManager$complexTaskStateListener$1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.ArrayList] */
    public static a a(DMTaskInfo r8) {
        ITaskCenter r0 = (ITaskCenter) ServiceManager.get().getService(ITaskCenter.class);
        String r1 = null;
        boolean r2 = false;
        if (r0 == null) goto L12;
        List r3 = r0.getAll();
        if (r3 == null) goto L12;
        List r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();
        if (StringsKt.startsWith$default(((com.obric.assistant.task.b) r6).a, "ComplexTask", false, 2, null) == false) goto L8;
        r4.add(r6);
    L13:
        if (r4 != 0) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        int r7 = r4.size();
        String r9 = "ComplexTask-" + r8.getTaskId();
        List r10 = r4;
        if ((r10 instanceof Collection) == true) goto L18;
    L20:
        Iterator r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((com.obric.assistant.task.b) r11.next()).a, r9) == false) goto L22;
        int r12 = 1;
    L27:
        int r13 = RangesKt.coerceAtLeast(r7 - r12, 0);
        IMMessage r14 = r8.getMessage();
        if (r14 == null) goto L43;
        Map r15 = r14.getExt();
        if (r15 == null) goto L43;
        String r16 = (String) r15.get("o_reference_msg_id");
        if (r16 == null) goto L43;
        if (r16.length() != 0) goto L36;
        r2 = true;
    L36:
        if (r2 == false) goto L41;
        IMMessage r17 = r8.getMessage();
        if (r17 == null) goto L40;
        r16 = r17.getMessageId();
        goto L41
    L40:
        r16 = null;
    L41:
        if (r16 == null) goto L43;
        r1 = r16;
    L47:
        return new a(com.obric.assistant.utils.l.c(r8), r1, r7, r13);
    L43:
        IMMessage r18 = r8.getMessage();
        if (r18 == null) goto L47;
        r1 = r18.getMessageId();
    L26:
        r12 = 0;
        goto L27
    L18:
        if (r10.isEmpty() == false) goto L20;
    L12:
        r4 = 0;
        goto L13
    }

    public static String c(Integer r7) {
        DMConstData.DMComplexTaskState[] r0 = DMConstData.DMComplexTaskState.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L14;
        DMConstData.DMComplexTaskState r4 = r0[r3];
        int r5 = r4.ordinal();
        if (r7 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L15;
        r3 = r3 + 1;
    L15:
        if (r4 == null) goto L18;
        String r8 = r4.name();
        if (r8 == null) goto L18;
        return r8;
    L18:
        return "Unknown";
    L8:
        if (r5 != r7.intValue()) goto L10;
        r6 = true;
        goto L11
    L14:
        r4 = null;
        goto L15
    }

    public static void e(DMTaskState r4) {
        DMTaskInfo r5 = r4.getTaskInfo();
        laa.c r0 = null;
        if (r5 == null) goto L7;
        Map r6 = r5.getExt();
        if (r6 == null) goto L7;
        String r7 = (String) r6.get("o_last_reply_message_id");
    L8:
        FLogger.a.i("ComplexTaskManager", "scrollToLatestMessage " + r7);
        int r1 = com.obric.assistant.utils.e.a;
        Object r2 = com.obric.assistant.utils.e.a(Activity.class);
        if ((r2 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r3 = (FragmentActivity) r2;
    L12:
        if (r3 == null) goto L20;
        FragmentManager r8 = r3.getSupportFragmentManager();
        if (r8 == null) goto L20;
        Fragment r9 = r8.findFragmentById(2131373275);
        if (r9 == null) goto L20;
        t1a.b r10 = s1a.a.g(r9);
        if (r10 == null) goto L20;
        r0 = (laa.c) r10.getAbility(laa.c.class);
    L20:
        if (r7 != null) goto L22;
    L25:
        boolean r11 = true;
    L26:
        if (r11 == false) goto L29;
        if (r0 == null) goto L32;
        r0.kc();
        return;
    L32:
        return;
    L29:
        if (r0 == null) goto L34;
        r0.vC(r7);
        return;
    L34:
        return;
    L22:
        if (r7.length() == 0) goto L25;
        r11 = false;
        goto L26
    L11:
        r3 = null;
    L7:
        r7 = null;
        goto L8
    }

    public static String b(DMTaskInfo r8, List r9) {
        Integer r0 = null;
        int r1 = 0;
        int r2 = 1;
        if (r9 == null) goto L20;
        ArrayList r3 = new ArrayList();
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L21;
        Object r4 = r10.next();
        DMTaskState r5 = (DMTaskState) r4;
        if (r5.getState() != DMConstData.DMComplexTaskState.Queueing.ordinal()) goto L17;
        DMTaskInfo r6 = r5.getTaskInfo();
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L6;
        r3.add(r4);
        goto L6
    L12:
        if (r6.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L14;
        r7 = true;
    L17:
        r11 = false;
    L21:
        if (r3 == null) goto L23;
        List r12 = CollectionsKt.sortedWith(r3, ComparisonsKt.compareBy(new Function1[]{new c(), new d()}));
    L24:
        if (r12 == null) goto L34;
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((DMTaskState) r13.next()).getTaskId(), r8.getTaskId()) == true) goto L33;
        r1 = r1 + 1;
    L33:
        r0 = Integer.valueOf(r1);
        goto L34
    L32:
        r1 = -1;
    L34:
        StringBuilder r14 = new StringBuilder();
        if (r0 == null) goto L37;
        int r15 = r0.intValue() + 1;
    L38:
        r14.append(r15);
        r14.append('/');
        if (r12 == null) goto L41;
        r2 = r12.size();
    L41:
        r14.append(r2);
        return r14.toString();
    L37:
        r15 = 1;
        goto L38
    L23:
        r12 = null;
        goto L24
    L20:
        r3 = null;
        goto L21
    }

    public static void f(String r10, List r11) {
        if (r11 == null) goto L19;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r11.iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        Object r3 = r1.next();
        DMTaskState r4 = (DMTaskState) r3;
        boolean r7 = false;
        if (r4.getState() != DMConstData.DMComplexTaskState.Queueing.ordinal()) goto L17;
        DMTaskInfo r5 = r4.getTaskInfo();
        if (r5 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L17;
        r7 = true;
        goto L17
    L12:
        if (r5.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L14;
        r6 = true;
    L17:
        if (r7 == false) goto L6;
        r2.add(r3);
    L20:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("updateQueueingTasks, exceptTaskId = ");
        r9.append(r10);
        r9.append(", queueingTasks size is  ");
        if (r2 == null) goto L23;
        Integer r12 = Integer.valueOf(r2.size());
    L24:
        r9.append(r12);
        r9.append(", active task size = ");
        if (r11 == null) goto L27;
        Integer r13 = Integer.valueOf(r11.size());
    L28:
        r9.append(r13);
        r8.i("ComplexTaskManager", r9.toString());
        if (r2 == null) goto L48;
        Iterator r14 = r2.iterator();
    L32:
        if (r14.hasNext() == false) goto L67;
        DMTaskState r15 = (DMTaskState) r14.next();
        FLogger r16 = FLogger.a;
        r16.i("ComplexTaskManager", "looping " + r15.getTaskId());
        if (Intrinsics.areEqual(r15.getTaskId(), r10) == true) goto L32;
        String r17 = "ComplexTask-" + r15.getTaskId();
        DMTaskInfo r18 = r15.getTaskInfo();
        if (r18 == null) goto L32;
        ITaskCenter r19 = (ITaskCenter) ServiceManager.get().getService(ITaskCenter.class);
        if (r19 == null) goto L42;
        com.obric.assistant.task.b r20 = r19.get(r17);
        if (r20 == null) goto L42;
        com.obric.assistant.task.b r21 = com.obric.assistant.task.b.a(r20, b(r18, r2), 0, 65023);
    L43:
        if (r21 == null) goto L44;
        ITaskCenter r22 = (ITaskCenter) ServiceManager.get().getService(ITaskCenter.class);
        if (r22 == null) goto L32;
        r22.a(r21);
        goto L32
    L44:
        r16.i("ComplexTaskManager", "could not find task entry for " + r15.getTaskId());
    L42:
        r21 = null;
        goto L43
    L67:
        return;
    L48:
        r8.w("ComplexTaskManager", "updateQueueingTasks, queueingTasks is null");
        return;
    L27:
        r13 = null;
        goto L28
    L23:
        r12 = null;
        goto L24
    L19:
        r2 = null;
        goto L20
    }

    public static void d(final DMTaskInfo r7, final DMTaskState r8, final DMTaskState r9, final List r10, final UpdateSource r11) {
        SoftReference r0 = y.a;
        Runnable r1 = new com.obric.assistant.complex_task.a(r11, r7, r9, r8, r10);
        Intrinsics.checkNotNullParameter(r1, "action");
        y.c(r1);
    }
}
