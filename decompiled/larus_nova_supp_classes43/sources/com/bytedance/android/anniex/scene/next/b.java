package com.bytedance.android.anniex.scene.next;

import android.os.Build;
import com.bytedance.android.anniex.scene.handler.idle.TaskStatus;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.handler.idle.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;
    public static final Map<String, Long> b = null;

    public static final class a implements i {

        /* JADX INFO: renamed from: com.bytedance.android.anniex.scene.next.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0098a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TaskStatus.values().length];
                r0[TaskStatus.FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TaskStatus.TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TaskStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a() {
        }

        @Override // com.bytedance.android.anniex.scene.handler.idle.i
        public final void a(TaskType r10, String r11, String r12, String r13, TaskStatus r14) {
            Intrinsics.checkNotNullParameter(r10, "taskType");
            Intrinsics.checkNotNullParameter(r11, "taskId");
            Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_STATUS);
            int r15 = C0098a.a[r14.ordinal()];
            if (r15 != 1) goto L5;
        L9:
            if (r12 == null) goto L20;
            b r16 = b.a;
            monitor-enter(r16);
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L17
            if (Intrinsics.areEqual(r13, "view_pre_create") == false) goto L15;
            Long r17 = Long.valueOf(r0);     // Catch: Throwable -> L17
            ((ConcurrentHashMap) b.b).put(r12, r17);     // Catch: Throwable -> L17
        L15:
            monitor-exit(r16);
            return;
        L17:
            th = move-exception;
            throw th;
        L20:
            return;
        L5:
            if (r15 == 2) goto L9;
            if (r15 == 3) goto L9;
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = new ConcurrentHashMap();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        com.bytedance.android.anniex.scene.handler.idle.h r0 = com.bytedance.android.anniex.scene.handler.idle.h.a;
        TaskType r1 = TaskType.NEXT_THRESHOLD_PREDICT;
        a r10 = new a();
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r10, "listener");
        com.bytedance.android.anniex.scene.handler.idle.h.h.computeIfAbsent(r1, com.bytedance.android.anniex.scene.handler.idle.g.a).add(r10);
        return;
    }
}
