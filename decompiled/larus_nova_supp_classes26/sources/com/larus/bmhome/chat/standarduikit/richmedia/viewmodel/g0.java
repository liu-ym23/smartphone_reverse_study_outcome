package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kc8.m0;
import kc8.n0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 implements f0 {
    public final kc8.b a;

    public final kc8.q a() {
        kc8.b r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    public final kc8.y f() {
        kc8.b r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final String j() {
        kc8.b r0 = this.a;
        if (r0 == null) goto L11;
        n0 r1 = r0.d;
        if (r1 == null) goto L11;
        m0 r2 = r1.a;
        if (r2 == null) goto L11;
        Function0 r3 = r2.b;
        if (r3 == null) goto L11;
        return (String) r3.invoke();
    L11:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final String b() {
        kc8.y r0 = f();
        if (r0 == null) goto L9;
        Function0 r1 = r0.m;
        if (r1 == null) goto L9;
        ChatParam r2 = (ChatParam) r1.invoke();
        if (r2 == null) goto L9;
        return r2.c;
    L9:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final CoroutineScope c() {
        kc8.q r0 = a();
        if (r0 == null) goto L6;
        CoroutineScope r1 = r0.f;
        if (r1 == null) goto L6;
        return r1;
    L6:
        kc8.y r2 = f();
        if (r2 == null) goto L11;
        Fragment r3 = r2.a;
        if (r3 == null) goto L11;
        return LifecycleOwnerKt.getLifecycleScope(r3);
    L11:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final boolean d() {
        kc8.q r0 = a();
        if (r0 == null) goto L8;
        Function0 r1 = r0.e;
        if (r1 == null) goto L8;
        Boolean r2 = (Boolean) r1.invoke();
    L16:
        return r2.booleanValue();
    L8:
        kc8.y r3 = f();
        if (r3 == null) goto L11;
        r2 = r3.g;
    L12:
        if (r2 != null) goto L16;
        return false;
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final q0 e() {
        kc8.q r0 = a();
        if (r0 == null) goto L6;
        q0 r1 = r0.l;
        if (r1 == null) goto L6;
        return r1;
    L6:
        kc8.y r2 = f();
        if (r2 == null) goto L9;
        q0 r3 = r2.x;
    L10:
        if (r3 != null) goto L17;
        q0.a r4 = r();
        if (r4 == null) goto L15;
        return r4.e();
    L15:
        return null;
    L17:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final kc8.q g() {
        return a();
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final Integer getBotConversationType() {
        kc8.q r0 = a();
        if (r0 == null) goto L11;
        kc8.a0 r1 = r0.d;
        if (r1 == null) goto L11;
        wc9.e r2 = r1.h();
        if (r2 == null) goto L11;
        Integer r3 = r2.v;
        if (r3 == null) goto L11;
        return r3;
    L11:
        kc8.y r4 = f();
        if (r4 == null) goto L18;
        Function0 r5 = r4.e;
        if (r5 == null) goto L18;
        wc9.e r6 = (wc9.e) r5.invoke();
        if (r6 == null) goto L18;
        Integer r7 = r6.v;
    L19:
        if (r7 != null) goto L29;
        q0.a r8 = r();
        if (r8 == null) goto L28;
        com.larus.bmhome.chat.component.cvs.y r9 = r8.u0();
        if (r9 == null) goto L28;
        wc9.e r10 = r9.h();
        if (r10 == null) goto L28;
        return r10.v;
    L28:
        return null;
    L29:
        return r7;
    L18:
        r7 = null;
        goto L19
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final String getBotId() {
        kc8.q r0 = a();
        if (r0 == null) goto L8;
        kc8.a0 r1 = r0.d;
        if (r1 == null) goto L8;
        String r2 = r1.getBotId();
        if (r2 == null) goto L8;
        return r2;
    L8:
        kc8.y r3 = f();
        if (r3 == null) goto L15;
        Function0 r4 = r3.m;
        if (r4 == null) goto L15;
        ChatParam r5 = (ChatParam) r4.invoke();
        if (r5 == null) goto L15;
        return r5.b;
    L15:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final String getChatType() {
        kc8.y r0 = f();
        if (r0 == null) goto L9;
        Function0 r1 = r0.m;
        if (r1 == null) goto L9;
        ChatParam r2 = (ChatParam) r1.invoke();
        if (r2 == null) goto L9;
        return r2.e;
    L9:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final String getConversationId() {
        kc8.y r0 = f();
        if (r0 == null) goto L7;
        Function0 r1 = r0.f;
        if (r1 == null) goto L7;
        return (String) r1.invoke();
    L7:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final String getCurrentPage() {
        kc8.y r0 = f();
        if (r0 == null) goto L9;
        Function0 r1 = r0.m;
        if (r1 == null) goto L9;
        ChatParam r2 = (ChatParam) r1.invoke();
        if (r2 == null) goto L9;
        return r2.d;
    L9:
        return null;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final Fragment getHostFragment() {
        kc8.q r0 = a();
        if (r0 == null) goto L6;
        Fragment r1 = r0.a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        kc8.y r2 = f();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final boolean l() {
        kc8.y r0 = f();
        ry8.d r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.Adapter r2 = r0.w;
    L7:
        if ((r2 instanceof ry8.d) == false) goto L9;
        r1 = (ry8.d) r2;
    L9:
        if (r1 == null) goto L11;
        r1.l();
        return true;
    L11:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final boolean n() {
        kc8.q r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r0.b, Boolean.TRUE);
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final void o() {
        kc8.y r0 = f();
        if (r0 == null) goto L8;
        kc8.z r1 = r0.A;
        if (r1 == null) goto L9;
        kc8.z.a.a(r1, null, null, 7);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final boolean p() {
        kc8.q r0 = a();
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.c, Boolean.FALSE);
    L7:
        return !r1;
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final q0.a r() {
        kc8.y r0 = f();
        if (r0 == null) goto L6;
        q0.a r1 = r0.u;
        if (r1 == null) goto L6;
        return r1;
    L6:
        kc8.q r2 = a();
        if (r2 == null) goto L11;
        q0 r3 = r2.l;
        if (r3 == null) goto L11;
        return r3.getProvider();
    L11:
        kc8.y r4 = f();
        if (r4 == null) goto L16;
        q0 r5 = r4.x;
        if (r5 == null) goto L16;
        return r5.getProvider();
    L16:
        return null;
    }

    public g0(kc8.b r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final boolean h(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        kc8.b r0 = this.a;
        if (r0 == null) goto L14;
        n0 r1 = r0.d;
        if (r1 == null) goto L15;
        m0 r2 = r1.a;
        if (r2 == null) goto L16;
        Function1 r4 = r2.a;
        if (r4 != null) goto L11;
        return false;
    L11:
        if (((Boolean) r4.invoke(r3)).booleanValue() != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final boolean m(int r2) {
        kc8.q r0 = a();
        if (r0 == null) goto L9;
        Function1 r1 = r0.m;
        if (r1 == null) goto L11;
        r1.invoke(Integer.valueOf(r2));
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.f0
    public final Object q(Continuation<? super Unit> r2) {
        kc8.q r0 = a();
        if (r0 == null) goto L14;
        rd8.b r1 = r0.g;
        if (r1 == null) goto L14;
        kh8.a r3 = r1.q3();
        if (r3 == null) goto L14;
        Object r4 = r3.f(r2);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r4;
    L12:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    }
}
