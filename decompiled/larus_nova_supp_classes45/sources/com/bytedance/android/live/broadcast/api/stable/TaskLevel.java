package com.bytedance.android.live.broadcast.api.stable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/stable/TaskLevel;", "", "", "level", "I", "getLevel", "()I", "Companion", "a", "P_UNKNOWN", "P0", "P1", "P2", "P3", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskLevel extends Enum<TaskLevel> {
    public static final a Companion = null;
    public static final TaskLevel P0 = null;
    public static final TaskLevel P1 = null;
    public static final TaskLevel P2 = null;
    public static final TaskLevel P3 = null;
    public static final TaskLevel P_UNKNOWN = null;
    public static final /* synthetic */ TaskLevel[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    private final int level;

    public static final class a {
        public a() {
        }

        public static final List a(a r3, int r4) {
            r3.getClass();
            List r5 = (List) TaskLevel.access$getLevelAll$cp().getValue();
            ArrayList r0 = new ArrayList();
            Iterator r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L11;
            Object r1 = r6.next();
            if (((TaskLevel) r1).getLevel() < r4) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
            r0.add(r1);
            goto L4
        L8:
            r2 = false;
            goto L9
        L11:
            return r0;
        }
    }

    static {
        TaskLevel r1 = new TaskLevel("P_UNKNOWN", 0, -999);
        P_UNKNOWN = r1;
        TaskLevel r2 = new TaskLevel("P0", 1, 0);
        P0 = r2;
        TaskLevel r3 = new TaskLevel("P1", 2, 1);
        P1 = r3;
        TaskLevel r4 = new TaskLevel("P2", 3, 2);
        P2 = r4;
        TaskLevel r5 = new TaskLevel("P3", 4, 3);
        P3 = r5;
        a = new TaskLevel[]{r1, r2, r3, r4, r5};
        Companion = new a();
        b = LazyKt.lazy(TaskLevel$Companion$levelList$2.INSTANCE);
        c = LazyKt.lazy(TaskLevel$Companion$levelAll$2.INSTANCE);
        d = LazyKt.lazy(TaskLevel$Companion$aboveP1$2.INSTANCE);
        e = LazyKt.lazy(TaskLevel$Companion$aboveP2$2.INSTANCE);
        f = LazyKt.lazy(TaskLevel$Companion$aboveP3$2.INSTANCE);
    }

    public static TaskLevel valueOf(String r1) {
        return (TaskLevel) r27.a.a(TaskLevel.class, r1);
    }

    public static TaskLevel[] values() {
        return (TaskLevel[]) a.clone();
    }

    public static final /* synthetic */ Lazy access$getAboveP1$cp() {
        return d;
    }

    public static final /* synthetic */ Lazy access$getAboveP2$cp() {
        return e;
    }

    public static final /* synthetic */ Lazy access$getAboveP3$cp() {
        return f;
    }

    public static final /* synthetic */ Lazy access$getLevelAll$cp() {
        return c;
    }

    public static final /* synthetic */ Lazy access$getLevelList$cp() {
        return b;
    }

    public final int getLevel() {
        return this.level;
    }

    public TaskLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
