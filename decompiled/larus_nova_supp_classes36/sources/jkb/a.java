package jkb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jkb.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a<C extends jkb.b> {
    public final List<d<C>> a;

    /* JADX INFO: renamed from: jkb.a$a, reason: collision with other inner class name */
    public static final class C0284a {
    }

    public static final class b implements c {
        public d<C> a;
        public final /* synthetic */ Iterator<d<C>> b;
        public final /* synthetic */ C c;
        public final /* synthetic */ a<C> d;

        @Override // jkb.c
        public final void a() {
            if (this.b.hasNext() == false) goto L6;
            this.a = this.b.next();
            int r0 = com.ss.android.lark.im.sdk.a.a;
            com.ss.android.lark.im.sdk.a.b("ImSdkPipeline", "Pipeline step " + this.a.getName() + " start to process");
            this.a.a(this.c, this);
            return;
        }

        @Override // jkb.c
        public final void b(e r4) {
            Intrinsics.checkNotNullParameter(r4, "reason");
            int r0 = com.ss.android.lark.im.sdk.a.a;
            com.ss.android.lark.im.sdk.a.a("ImSdkPipeline", "Pipeline step " + this.a.getName() + " terminated for reason: " + r4);
            this.d.b(this.a, this.c, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(d<C> r1, Iterator<? extends d<C>> r2, C r3, a<C> r4) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.a = r1;
        }
    }

    static {
    }

    public abstract void b(d<C> r1, C r2, e r3);

    public a() {
        this.a = new ArrayList();
    }

    public final void a(d<C> r2) {
        Intrinsics.checkNotNullParameter(r2, "pipelineStep");
        ((ArrayList) this.a).add(r2);
    }

    public final void c(C r6) {
        Intrinsics.checkNotNullParameter(r6, "pipelineContext");
        com.ss.android.lark.im.sdk.a.b("ImSdkPipeline", "Pipeline start to process");
        Iterator r1 = ((ArrayList) this.a).iterator();
        if (r1.hasNext() == true) goto L6;
        Intrinsics.checkNotNullParameter("ImSdkPipeline", "tag");
        Intrinsics.checkNotNullParameter("Pipeline has no step, return", INotificationHitPoint.NoticeType.MESSAGE);
        Log.w("ImSdkPipeline", "Pipeline has no step, return");
        return;
    L6:
        d r2 = (d) r1.next();
        b r3 = new b(r2, r1, r6, this);
        com.ss.android.lark.im.sdk.a.b("ImSdkPipeline", "Pipeline step " + r2.getName() + " start to process");
        r2.a(r6, r3);
    }
}
