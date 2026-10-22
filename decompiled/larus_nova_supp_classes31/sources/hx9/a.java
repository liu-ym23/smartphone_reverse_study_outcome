package hx9;

import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements l {
    public final k a;

    /* JADX INFO: renamed from: hx9.a$a, reason: collision with other inner class name */
    public static final class C0059a implements Function0<Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Unit> a;

        public C0059a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke() {
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<Unit> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        L6:
            return Unit.INSTANCE;
        }
    }

    @Override // hx9.l
    public final wc9.e O8() {
        y r0 = this.a.d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    @Override // hx9.l
    public final long b() {
        de8.c r0 = this.a.c();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.n;
    }

    @Override // hx9.l
    public final List<Message> c() {
        return this.a.e();
    }

    @Override // hx9.l
    public final boolean d() {
        return AccountService.a.a();
    }

    @Override // hx9.l
    public final String e() {
        k r0 = this.a;
        de8.c r1 = r0.c();
        String r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.f();
        if (r3 == null) goto L11;
        if (o0.d(r3) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L11;
        return r3;
    L11:
        y r4 = r0.d();
        if (r4 == null) goto L18;
        String r5 = r4.getBotId();
        if (r5 == null) goto L18;
        if (o0.d(r5) == false) goto L18;
        r2 = r5;
    L18:
        if (r2 != null) goto L21;
        return "";
    L21:
        return r2;
    }

    @Override // hx9.l
    public final boolean f() {
        o r0 = (o) this.a.f.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.w() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final List<Message> g() {
        return this.a.a();
    }

    @Override // hx9.l
    public final String getConversationId() {
        k r0 = this.a;
        de8.c r1 = r0.c();
        String r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.h();
        if (r3 == null) goto L11;
        if (o0.d(r3) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L11;
        return r3;
    L11:
        y r4 = r0.d();
        if (r4 == null) goto L14;
        r2 = r4.Y1();
    L14:
        if (r2 != null) goto L17;
        return "";
    L17:
        return r2;
    }

    @Override // hx9.l
    public final de8.c h() {
        return this.a.c();
    }

    @Override // hx9.l
    public final boolean j() {
        hy9.e r0 = (hy9.e) this.a.j.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b30() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final boolean k() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.a.g.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.m0() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final boolean l() {
        f1 r0 = this.a.a.getAbility(f1.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.sL() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final void x4() {
        u7 r0 = (u7) this.a.h.getValue();
        if (r0 == null) goto L6;
        r0.C90();
        return;
    }

    public a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        this.a = r2;
    }

    @Override // hx9.l
    public final Object i(Continuation<? super Unit> r4) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        u7 r1 = (u7) this.a.h.getValue();
        if (r1 == null) goto L13;
        r1.PI(new C0059a(r0));
        Object r2 = r0.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L8:
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r2;
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("Required value was null.".toString());
    }
}
