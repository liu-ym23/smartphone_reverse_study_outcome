package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class EnterRoomShelfInfoStateMachine {
    public final StateMachine<c, a, b> a;
    public d b;
    public final OpenPlatformContext c;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine$a$a, reason: collision with other inner class name */
        public static final class C0168a extends a {
            public static final C0168a a = null;

            static {
                a = new C0168a();
            }

            public C0168a() {
            }
        }

        public static final class b extends a {
            public final tq0.a a;

            public b(tq0.a r2) {
                Intrinsics.checkNotNullParameter(r2, "response");
                this.a = r2;
            }
        }

        public static final class c extends a {
            public final e a;

            public c(e r2) {
                Intrinsics.checkNotNullParameter(r2, "toolbarData");
                this.a = r2;
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

        public a() {
        }

        public final String toString() {
            if (Intrinsics.areEqual(this, d.a) == false) goto L6;
            return "Start";
        L6:
            if ((this instanceof b) == false) goto L9;
            return "BackendSuccess";
        L9:
            if (Intrinsics.areEqual(this, C0168a.a) == false) goto L12;
            return "BackendFail";
        L12:
            if ((this instanceof c) == false) goto L16;
            return "ReceiveToolbarData";
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine$b$b, reason: collision with other inner class name */
        public static final class C0169b extends b {
            public static final C0169b a = null;

            static {
                a = new C0169b();
            }

            public C0169b() {
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public b() {
        }
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
            public final e a;

            public b() {
                this(null);
            }

            public b(e r1) {
                this.a = r1;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.EnterRoomShelfInfoStateMachine$c$c, reason: collision with other inner class name */
        public static final class C0170c extends c {
            public final tq0.a a;

            public C0170c(tq0.a r2) {
                Intrinsics.checkNotNullParameter(r2, "response");
                this.a = r2;
            }
        }

        public static final class d extends c {
            public final e a;
            public final tq0.a b;

            public d(e r2, tq0.a r3) {
                Intrinsics.checkNotNullParameter(r2, "toolbarData");
                this.a = r2;
                this.b = r3;
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

        public final String toString() {
            if (Intrinsics.areEqual(this, e.a) == false) goto L6;
            return "Init";
        L6:
            if ((this instanceof b) == false) goto L9;
            return "BackendProcessing";
        L9:
            if ((this instanceof C0170c) == false) goto L12;
            return "BackendSuccessful";
        L12:
            if (Intrinsics.areEqual(this, a.a) == false) goto L15;
            return "BackendFailed";
        L15:
            if ((this instanceof d) == false) goto L19;
            return "Finished";
        L19:
            throw new NoWhenBranchMatchedException();
        }
    }

    public interface d {
        void a();

        void b(tq0.a r1);

        void c(e r1, tq0.a r2, boolean r3);

        void d(e r1, boolean r2);
    }

    public static final class e {
        public final ToolbarMatchInterface a;
        public final Function0<Unit> b;
        public final Function1<String, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public e(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "loadFail");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public EnterRoomShelfInfoStateMachine(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        this.c = r2;
        StateMachine.a r3 = StateMachine.c;
        EnterRoomShelfInfoStateMachine$stateMachine$1 r0 = new EnterRoomShelfInfoStateMachine$stateMachine$1(this);
        r3.getClass();
        this.a = StateMachine.a.a(r0);
    }
}
