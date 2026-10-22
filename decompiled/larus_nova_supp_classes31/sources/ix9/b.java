package ix9;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.suggest.impl.wcb.request.WcbRequestPipeline;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.utils.logger.FLogger;
import hx9.k;
import ic8.k0;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements d {
    public final k a;
    public final lx9.c b;
    public final WcbRequestPipeline c;
    public final boolean d;
    public boolean e;
    public final Set<lx9.d> f;
    public final a g;

    public static final class a implements f09.a.b {
        public final /* synthetic */ b a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            q r0 = this.a.c.h;
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    @Override // ix9.d
    public final boolean c() {
        return false;
    }

    @Override // ix9.d
    public final void onCreate() {
        this.e = true;
        AppHost.a.a().j(this.g);
    }

    @Override // ix9.d
    public final void onDestroy() {
        WcbRequestPipeline r0 = this.c;
        r0.d();
        CoroutineScopeKt.cancel$default(r0.d, null, 1, null);
        this.e = false;
        AppHost.a.a().c(this.g);
    }

    @Override // ix9.d
    public final void a(lx9.a r8) {
        Intrinsics.checkNotNullParameter(r8, "change");
        if (this.e == true) goto L6;
        return;
    L6:
        if ((r8 instanceof lx9.a.C0066a) == false) goto L13;
        WcbRequestPipeline r0 = this.c;
        z r2 = ((lx9.a.C0066a) r8).a;
        WcbRequestTrigger r3 = WcbRequestTrigger.INITIAL;
        if (this.d == false) goto L10;
        String r9 = "new_conversation_cvs_changed";
    L11:
        r0.a(e(this, r2, r3, r9, null, 56));
        return;
    L10:
        r9 = "new_conversation_enter";
        goto L11
    L13:
        if ((r8 instanceof lx9.a.b) == false) goto L20;
        WcbRequestPipeline r1 = this.c;
        z r4 = ((lx9.a.b) r8).b;
        WcbRequestTrigger r5 = WcbRequestTrigger.MODE_SWITCH;
        Message r10 = this.a.b();
        if (r10 == null) goto L17;
        int r6 = p.b;
        p r11 = p.a.a(r10);
    L18:
        r1.a(e(this, r4, r5, "task_mode_changed", r11, 40));
        return;
    L17:
        r11 = null;
        goto L18
    L20:
        if ((r8 instanceof lx9.a.c) == false) goto L22;
        return;
    L22:
        if ((r8 instanceof lx9.a.d) == false) goto L25;
        FLogger.a.w("WcbLog", "unsupported new wcb pipeline policy key=" + ((lx9.a.d) r8).a);
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    }

    @Override // ix9.d
    public final Set<Message> h9(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        return SetsKt.emptySet();
    }

    @Override // ix9.d
    public final void u8(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
    }

    @Override // ix9.d
    public final void b(Message r9, k0 r10) {
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "params");
        z r2 = this.b.b.get();
        if (r2 != null) goto L5;
        return;
    L5:
        WcbRequestPipeline r0 = this.c;
        WcbRequestTrigger r3 = WcbRequestTrigger.REGENERATE;
        int r1 = p.b;
        r0.a(d(r2, r3, "regenerate", r10, p.a.a(r9), 2));
    }

    public b(k r2, lx9.c r3, WcbRequestPipeline r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        Intrinsics.checkNotNullParameter(r3, "policySelection");
        Intrinsics.checkNotNullParameter(r4, "pipeline");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = new LinkedHashSet();
        this.g = new a(this);
    }

    public static /* synthetic */ com.larus.suggest.impl.wcb.request.c e(b r15, z r16, WcbRequestTrigger r17, String r18, p r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        k0 r12 = new k0(null, null, null, null, 15);
    L7:
        if ((r20 & 16) == 0) goto L9;
        p r13 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        int r14 = r16.getScene();
    L15:
        return r15.d(r16, r17, r18, r12, r13, r14);
    L13:
        r14 = 0;
        goto L15
    L9:
        r13 = r19;
        goto L11
    L5:
        r12 = null;
        goto L7
    }

    public final com.larus.suggest.impl.wcb.request.c d(z r10, WcbRequestTrigger r11, String r12, k0 r13, p r14, int r15) {
        if (r11 != WcbRequestTrigger.REGENERATE) goto L5;
    L7:
        boolean r7 = false;
    L9:
        return new com.larus.suggest.impl.wcb.request.c(r10, r11, r13, r12, r14, r15, r7);
    L5:
        if (this.f.add(r10.getKey()) == false) goto L7;
        r7 = true;
        goto L9
    }
}
