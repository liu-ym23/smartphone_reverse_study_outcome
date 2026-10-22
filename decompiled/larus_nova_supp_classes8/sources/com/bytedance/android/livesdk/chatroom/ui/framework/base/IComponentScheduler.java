package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface IComponentScheduler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentScheduler$LoadBatch;", "", "BASE", "PRELOAD", "FIRST_SCREEN", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "POTHER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadBatch extends Enum<LoadBatch> {
        public static final LoadBatch BASE = null;
        public static final LoadBatch FIRST_SCREEN = null;
        public static final LoadBatch P0 = null;
        public static final LoadBatch P1 = null;
        public static final LoadBatch P2 = null;
        public static final LoadBatch POTHER = null;
        public static final LoadBatch PRELOAD = null;
        public static final /* synthetic */ LoadBatch[] a = null;

        static {
            LoadBatch r1 = new LoadBatch("BASE", 0);
            BASE = r1;
            LoadBatch r2 = new LoadBatch("PRELOAD", 1);
            PRELOAD = r2;
            LoadBatch r3 = new LoadBatch("FIRST_SCREEN", 2);
            FIRST_SCREEN = r3;
            LoadBatch r4 = new LoadBatch(DiagnoseResult.DIAGNOSE_LEVEL_P0, 3);
            P0 = r4;
            LoadBatch r5 = new LoadBatch(DiagnoseResult.DIAGNOSE_LEVEL_P1, 4);
            P1 = r5;
            LoadBatch r6 = new LoadBatch(DiagnoseResult.DIAGNOSE_LEVEL_P2, 5);
            P2 = r6;
            LoadBatch r7 = new LoadBatch("POTHER", 6);
            POTHER = r7;
            a = new LoadBatch[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static LoadBatch valueOf(String r1) {
            return (LoadBatch) r27.a.a(LoadBatch.class, r1);
        }

        public static LoadBatch[] values() {
            return (LoadBatch[]) a.clone();
        }

        public LoadBatch(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentScheduler$LoadMode;", "", "DIRECT", "PREVIEW", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadMode extends Enum<LoadMode> {
        public static final LoadMode DIRECT = null;
        public static final LoadMode PREVIEW = null;
        public static final /* synthetic */ LoadMode[] a = null;

        static {
            LoadMode r1 = new LoadMode("DIRECT", 0);
            DIRECT = r1;
            LoadMode r2 = new LoadMode("PREVIEW", 1);
            PREVIEW = r2;
            a = new LoadMode[]{r1, r2};
        }

        public static LoadMode valueOf(String r1) {
            return (LoadMode) r27.a.a(LoadMode.class, r1);
        }

        public static LoadMode[] values() {
            return (LoadMode[]) a.clone();
        }

        public LoadMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentScheduler$SchedulerType;", "", "LOAD_TASK_SCHEDULER", "COMPONENT_X_SCHEDULER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SchedulerType extends Enum<SchedulerType> {
        public static final SchedulerType COMPONENT_X_SCHEDULER = null;
        public static final SchedulerType LOAD_TASK_SCHEDULER = null;
        public static final /* synthetic */ SchedulerType[] a = null;

        static {
            SchedulerType r1 = new SchedulerType("LOAD_TASK_SCHEDULER", 0);
            LOAD_TASK_SCHEDULER = r1;
            SchedulerType r2 = new SchedulerType("COMPONENT_X_SCHEDULER", 1);
            COMPONENT_X_SCHEDULER = r2;
            a = new SchedulerType[]{r1, r2};
        }

        public static SchedulerType valueOf(String r1) {
            return (SchedulerType) r27.a.a(SchedulerType.class, r1);
        }

        public static SchedulerType[] values() {
            return (SchedulerType[]) a.clone();
        }

        public SchedulerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void b(LoadBatch r1);

        void d(LoadBatch r1, LayerDescriptorList r2);

        void e(LoadBatch r1);
    }

    void a();

    com.bytedance.android.livesdk.widgetdescriptor.priority.c b();

    void c();

    void d();

    void e();

    void f(InteractionComponentManager r1);

    void g();

    void h(boolean r1);

    void i();

    void j();

    void k();

    void l();

    void release();
}
