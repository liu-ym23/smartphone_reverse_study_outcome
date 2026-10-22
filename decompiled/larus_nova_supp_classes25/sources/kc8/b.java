package kc8;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements jc8.l {
    public static final /* synthetic */ int y = 0;
    public final y a;
    public final o b;
    public final v0 c;
    public final n0 d;
    public final p e;
    public final r f;
    public final k0 g;
    public final t0 h;
    public final x i;
    public final w j;
    public final s k;
    public final q l;
    public final u m;
    public final t n;
    public final u0 o;
    public final k p;
    public final h0 q;
    public final i r;
    public final l0 s;
    public final x0 t;
    public final m u;
    public final w0 v;
    public final v w;
    public final l x;

    public static final class a {
        public v0 a;
        public y b;
        public o c;
        public n0 d;
        public k0 e;
        public t0 f;
        public x g;
        public w h;
        public r i;
        public p j;
        public s k;
        public q l;
        public u m;
        public t n;
        public u0 o;
        public k p;
        public h0 q;
        public i r;
        public l0 s;
        public x0 t;
        public m u;
        public w0 v;
        public v w;
        public l x;

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v2, types: [kc8.a] */
        public final b a() {
            u0 r15 = this.o;
            v0 r4 = this.a;
            y r2 = this.b;
            o r3 = this.c;
            n0 r5 = this.d;
            k0 r8 = this.e;
            t0 r9 = this.f;
            x r10 = this.g;
            w r11 = this.h;
            r r7 = this.i;
            p r6 = this.j;
            s r12 = this.k;
            q r13 = this.l;
            t r14 = this.n;
            u r1 = this.m;
            k r16 = this.p;
            h0 r17 = this.q;
            i r18 = this.r;
            l0 r19 = this.s;
            x0 r110 = this.t;
            m r111 = this.u;
            w0 r20 = this.v;
            if (r20 != null) goto L13;
            ToolBlockInteractType r112 = ToolBlockInteractType.OpenFloatingPage;
            ToolBlockInitStatus r113 = ToolBlockInitStatus.Fold;
            IBlockDetailNavigatorService r114 = (IBlockDetailNavigatorService) ServiceManager.get().getService(IBlockDetailNavigatorService.class);
            if (r114 == 0) goto L11;
            y r115 = this.b;
            if (r115 == null) goto L9;
            Fragment r116 = r115.a;
        L10:
            com.larus.bmhome.block.presentation.a r117 = r114.a(r116, new kc8.a(this));
        L12:
            r20 = new w0(r112, r113, r117);
        L14:
            w r118 = r11;
            return new b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r118, r12, r13, r1, r14, r15, r16, r17, r18, r19, r110, r111, r20, this.w, this.x);
        L9:
            r116 = null;
            goto L10
        L11:
            r11 = r11;
            r117 = null;
            goto L12
        L13:
            r11 = r11;
            goto L14
        }
    }

    /* JADX INFO: renamed from: kc8.b$b, reason: collision with other inner class name */
    public static final class C0078b {
    }

    static {
    }

    public b(y r3, o r4, v0 r5, n0 r6, p r7, r r8, k0 r9, t0 r10, x r11, w r12, s r13, q r14, u r15, t r16, u0 r17, k r18, h0 r19, i r20, l0 r21, x0 r22, m r23, w0 r24, v r25, l r26) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
    }
}
