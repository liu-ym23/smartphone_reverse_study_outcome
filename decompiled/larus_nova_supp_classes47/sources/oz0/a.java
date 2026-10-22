package oz0;

import android.content.Context;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vh7.e;
import vlc.l;
import zh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements zh6.a, o {
    public final c a;

    /* JADX INFO: renamed from: oz0.a$a, reason: collision with other inner class name */
    public static final class C0287a implements zh6.b {
        public final Map<String, l> a;
        public final com.bytedance.android.livesdk.revenue.message.b b;

        /* JADX INFO: renamed from: oz0.a$a$a, reason: collision with other inner class name */
        public static final class C0288a implements l {
            public final /* synthetic */ zh6.b.a a;
            public final /* synthetic */ Class b;

            public C0288a(zh6.b.a r1, Class r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onMessage(d r3) {
                zh6.b.a r0 = this.a;
                if (r3 == null) goto L11;
                yh6.c r4 = m.a((vh7.c) r3, this.b);
                if (r4 == null) goto L9;
                r0.a(r4);
                return;
            L9:
                throw new NullPointerException("null cannot be cast to non-null type T");
            L11:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
            }
        }

        /* JADX INFO: renamed from: oz0.a$a$b */
        public static final class b implements l {
            public final /* synthetic */ zh6.b.a a;

            public b(zh6.b.a r1) {
                this.a = r1;
            }

            public final void onMessage(d r2) {
                zh6.b.a r0 = this.a;
                if (r2 == null) goto L7;
                r0.a((yh6.c) r2);
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
        }

        public final void release() {
            this.b.release();
        }

        public final void startMessage() {
            this.b.startMessage();
        }

        public C0287a(com.bytedance.android.livesdk.revenue.message.b r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            this.b = r2;
            this.a = new LinkedHashMap();
        }

        public final <T extends yh6.c> void a(yh6.b<T> r3, zh6.b.a<T> r4) {
            Intrinsics.checkNotNullParameter(r3, "desc");
            Intrinsics.checkNotNullParameter(r4, "listener");
            Map<String, l> r5 = this.a;
            LinkedHashMap r6 = (LinkedHashMap) r5;
            l r7 = (l) r6.get(r3.getName());
            if (r7 == null) goto L6;
            this.b.removeMessageListener(r3.getName(), r7);
            l r8 = this.a.remove(r3.getName());
            return;
        }

        public final <T extends yh6.c> void b(yh6.b<T> r3, zh6.b.a<T> r4) {
            Intrinsics.checkNotNullParameter(r3, "desc");
            Intrinsics.checkNotNullParameter(r4, "listener");
            Class r0 = r3.getType().getType();
            if (e.class.isAssignableFrom(r0) == false) goto L5;
            l r1 = new C0288a(r4, r0);
        L6:
            this.a.put(r3.getName(), r1);
            this.b.addMessageListener(r3.getName(), r1);
            return;
        L5:
            r1 = new b(r4);
            goto L6
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.a = r2;
    }

    public final C0287a f(String r3, Context r4, Map r5) {
        Intrinsics.checkNotNullParameter("linkmic_channel", "scene");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "extraParams");
        return new C0287a(this.a.f(r3, r4, r5));
    }
}
