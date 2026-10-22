package uk8;

import android.view.animation.Interpolator;
import com.larus.bmhome.chat.standarduikit.elapsedblock.viewmodel.ElapsedBlockStatus;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import kb8.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import lb8.h;
import nb8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements hb8.a {
    public d a;
    public qk8.d b;
    public final uk8.a c;
    public final b d;
    public final c e;

    public static final class a {
    }

    public static final class b implements tk8.f {
        public final /* synthetic */ f a;

        @Override // tk8.f
        public final void onRefresh() {
            qk8.d r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.e();
            return;
        }

        public b(f r1) {
            this.a = r1;
        }

        @Override // tk8.f
        public final void a(ow8.a r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            qk8.d r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.d(r2);
            return;
        }

        @Override // tk8.f
        public final void b(ow8.a r2, st8.a r3) {
            qk8.d r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.f(r2, r3);
            return;
        }
    }

    public static final class c implements com.larus.bmhome.block.newheader.foldcontainer.b {
        public final /* synthetic */ f a;

        public final void c() {
            qk8.d r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.U1();
            return;
        }

        public final h d() {
            throw new IllegalStateException("ElapsedBlock does not provide DeepThink block content".toString());
        }

        public final n e() {
            throw new IllegalStateException("ElapsedBlock does not provide reference content".toString());
        }

        public final tk8.f f() {
            return this.a.d;
        }

        public final l g() {
            throw new IllegalStateException("ElapsedBlock does not provide legacy DeepThink content".toString());
        }

        public final com.larus.bmhome.chat.standarduikit.vlm.view.b i() {
            throw new IllegalStateException("ElapsedBlock does not provide VLM content".toString());
        }

        public c(f r1) {
            this.a = r1;
        }

        public final void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "clickPosition");
            f r11 = this.a;
            d r0 = r11.a;
            if (r0 == null) goto L47;
            Message r1 = r0.a.j();
            boolean r3 = false;
            if (com.larus.bmhome.chat.bean.d.Q0(r1) == false) goto L8;
        L11:
            boolean r2 = true;
        L12:
            uk8.a r5 = r11.c;
            boolean r4 = !r2;
            if (r5.b == true) goto L15;
            boolean r6 = false;
        L24:
            if (r6 == false) goto L48;
            qk8.d r7 = r11.b;
            if (r7 == null) goto L36;
            String r8 = r0.a.j().getMessageId();
            String r9 = "";
            if (r8 != null) goto L31;
            r8 = "";
        L31:
            String r12 = r11.c.d.getTrackValue();
            String r13 = r1.getConversationId();
            if (r13 == null) goto L35;
            r9 = r13;
        L35:
            r7.c(new sk8.a(r8, r12, r9));
        L36:
            qk8.d r14 = r11.b;
            if (r14 != null) goto L39;
        L42:
            qk8.d r15 = r11.b;
            if (r15 == null) goto L46;
            r15.e();
            return;
        L46:
            return;
        L39:
            if (r11.c.d != ElapsedBlockStatus.Expanded) goto L41;
            r3 = true;
        L41:
            r14.b(r3, r0.a.j());
            goto L42
        L48:
            return;
        L15:
            ElapsedBlockStatus r16 = r5.d;
            int r17 = uk8.a.C0135a.a[r16.ordinal()];
            if (r17 != 1) goto L18;
            ElapsedBlockStatus r18 = ElapsedBlockStatus.Expanded;
        L23:
            r5.d = r18;
            r5.e = new ib8.c(true, r4, r16.toContainerStatus(), r5.d.toContainerStatus());
            r6 = true;
            goto L24
        L18:
            if (r17 != 2) goto L21;
            r18 = ElapsedBlockStatus.Folded;
            goto L23
        L21:
            throw new NoWhenBranchMatchedException();
        L8:
            if (com.larus.bmhome.chat.bean.d.j0(r1) == false) goto L11;
            r2 = false;
            goto L12
        }

        public final void h(st8.a r3, CustomMarkdownTextView r4) {
            Intrinsics.checkNotNullParameter(r3, "anchorView");
            d r0 = this.a.a;
            if (r0 == null) goto L10;
            rk8.a r1 = r0.a;
            if (r1 == null) goto L11;
            Message r2 = r1.j();
            qk8.d r5 = this.a.b;
            if (r5 == null) goto L12;
            r5.h(r2, r3, r4);
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void a(int r2, int r3, Interpolator r4) {
            Intrinsics.checkNotNullParameter(r4, "animationInterpolator");
            qk8.d r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4);
            return;
        }
    }

    static {
    }

    public final void f() {
        this.a = null;
        this.b = null;
        uk8.a r1 = this.c;
        r1.a = null;
        r1.b = false;
        r1.c = false;
        r1.d = ElapsedBlockStatus.Folded;
        r1.e = new ib8.c(true, null, null, 14);
    }

    public f() {
        this.c = new uk8.a();
        this.d = new b(this);
        this.e = new c(this);
    }
}
