package com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ShowEntranceTask {
    public long a;
    public String b;
    public EntranceSource c;
    public final StateMachine<d, a, c> d;
    public final EntranceType e;
    public final b f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/entrancemonitor/ShowEntranceTask$Stage;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Begin", "Running", "Success", "Fail", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Stage extends Enum<Stage> {
        public static final Stage Begin = null;
        public static final Stage Fail = null;
        public static final Stage Running = null;
        public static final Stage Success = null;
        public static final /* synthetic */ Stage[] a = null;
        private final String value;

        static {
            Stage r1 = new Stage("Begin", 0, "begin");
            Begin = r1;
            Stage r2 = new Stage("Running", 1, "running");
            Running = r2;
            Stage r3 = new Stage("Success", 2, "success");
            Success = r3;
            Stage r4 = new Stage("Fail", 3, "fail");
            Fail = r4;
            a = new Stage[]{r1, r2, r3, r4};
        }

        public static Stage valueOf(String r1) {
            return (Stage) r27.a.a(Stage.class, r1);
        }

        public static Stage[] values() {
            return (Stage[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Stage(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask$a$a, reason: collision with other inner class name */
        public static final class C0154a extends a {
            public static final C0154a a = null;

            static {
                a = new C0154a();
            }

            public C0154a() {
            }
        }

        public static final class b extends a {
            public final String a;
            public final JSONObject b;

            public b(String r2, JSONObject r3) {
                Intrinsics.checkNotNullParameter(r2, "stageDesc");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends a {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public a() {
        }
    }

    public interface b {
        void a(String r1, EntranceType r2, EntranceSource r3, long r4, String r6, JSONObject r7);

        void b(String r1, EntranceType r2, EntranceSource r3, long r4);

        void c(String r1, EntranceType r2, EntranceSource r3);

        void d(String r1, EntranceType r2, EntranceSource r3, long r4, String r6);
    }

    public static abstract class c {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask$c$c, reason: collision with other inner class name */
        public static final class C0155c extends c {
            public static final C0155c a = null;

            static {
                a = new C0155c();
            }

            public C0155c() {
            }
        }

        public static final class d extends c {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends c {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends d {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.entrancemonitor.ShowEntranceTask$d$d, reason: collision with other inner class name */
        public static final class C0156d extends d {
            public static final C0156d a = null;

            static {
                a = new C0156d();
            }

            public C0156d() {
            }
        }

        public static final class e extends d {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public d() {
        }
    }

    public ShowEntranceTask(EntranceType r2, EntranceMonitorContextService.b r3) {
        Intrinsics.checkNotNullParameter(r2, "entranceType");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.e = r2;
        this.f = r3;
        StateMachine.a r4 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<d, a, c>, Unit> r5 = new ShowEntranceTask$stateMachine$1(this);
        r4.getClass();
        this.d = StateMachine.a.a(r5);
    }

    public final void a(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "stageDesc");
        StateMachine<d, a, c> r0 = this.d;
        a.b r1 = new a.b(r3, r4);
        StateMachine.a r5 = StateMachine.c;
        r0.d(r1, null);
    }
}
