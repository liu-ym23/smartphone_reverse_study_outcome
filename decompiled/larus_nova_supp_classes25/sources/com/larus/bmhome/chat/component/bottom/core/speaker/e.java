package com.larus.bmhome.chat.component.bottom.core.speaker;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final /* synthetic */ int k = 0;
    public final b a;
    public final CoroutineScope b;
    public final long c;
    public final String d;
    public final MutableSharedFlow<c> e;
    public volatile boolean f;
    public volatile int g;
    public Job h;
    public boolean i;
    public final f j;

    public static final class a {
    }

    public interface b {
        void A9();

        void B9(f r1);

        void C9(f r1);

        void D9(Function1<? super String, Boolean> r1);
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

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.speaker.e$c$c, reason: collision with other inner class name */
        public static final class C0047c extends c {
            public static final C0047c a = null;

            static {
                a = new C0047c();
            }

            public C0047c() {
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

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.speaker.e$c$e, reason: collision with other inner class name */
        public static final class C0048e extends c {
            public static final C0048e a = null;

            static {
                a = new C0048e();
            }

            public C0048e() {
            }
        }

        public static final class f extends c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "StreamResult(text=" + this.a + ')';
            }

            public f(String r2) {
                Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
                this.a = r2;
            }
        }

        public static final class g extends c {
            public final String a;
            public final int b;
            public final String c;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof g) == true) goto L8;
                return false;
            L8:
                g r6 = (g) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
                String r1 = this.c;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "Success(text=" + this.a + ", streamResultLength=" + this.b + ", asrLogId=" + this.c + ')';
            }

            public g(String r2, int r3, String r4) {
                Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public static final class h extends c {
            public static final h a = null;

            static {
                a = new h();
            }

            public h() {
            }
        }

        public c() {
        }
    }

    static {
    }

    public final void a() {
        if (this.f == false) goto L6;
        FLogger.a.w("ChatSpeakerPressLifecycle", "[" + this.d + "][begin] skipped, lifecycle already running");
        return;
    L6:
        FLogger.a.i("ChatSpeakerPressLifecycle", "[" + this.d + "][begin]");
        this.f = true;
        this.g = -1;
        this.a.B9(this.j);
        this.a.D9(new com.larus.bmhome.chat.component.bottom.core.speaker.c());
        c(c.C0047c.a);
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        FLogger.a.i("ChatSpeakerPressLifecycle", "[" + this.d + "][cancel]");
        this.a.A9();
    }

    public final void f() {
        if (this.f == true) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        r0.i("ChatSpeakerPressLifecycle", "[" + this.d + "][onPressUp]");
        c(c.d.a);
        if (this.i == true) goto L8;
        r0.i("ChatSpeakerPressLifecycle", "[" + this.d + "][onPressUp] asr not started, cancel");
        c(c.a.a);
        d("asr_not_started");
        return;
    L8:
        Job r1 = this.h;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        this.h = null;
        this.h = BuildersKt.launch$default(this.b, null, null, new ChatSpeakerPressLifecycle$startTimer$1(this, null), 3, null);
    }

    public final void c(c r4) {
        if (this.e.tryEmit(r4) == true) goto L6;
        FLogger.a.w("ChatSpeakerPressLifecycle", "[" + this.d + "][tryEmit] dropped " + r4);
        return;
    }

    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (this.f == true) goto L5;
        return;
    L5:
        FLogger.a.i("ChatSpeakerPressLifecycle", "[" + this.d + "][end] lifecycle reason=" + r4);
        this.f = false;
        this.g = -1;
        this.i = false;
        Job r5 = this.h;
        if (r5 == null) goto L8;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L8:
        this.h = null;
        this.a.C9(this.j);
        this.a.D9(new d());
    }

    public final void e(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.e, new ChatSpeakerPressLifecycle$observe$1(r3)), new ChatSpeakerPressLifecycle$observe$2(this, null)), this.b);
    }

    public e(b r2, LifecycleCoroutineScope r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "tag");
        this.a = r2;
        this.b = r3;
        this.c = 300000;
        this.d = r4;
        this.e = SharedFlowKt.MutableSharedFlow$default(0, 16, null, 4, null);
        this.g = -1;
        this.j = new f(this);
    }
}
