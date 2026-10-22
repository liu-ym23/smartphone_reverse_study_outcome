package com.obric.assistant.authenticationsession;

import com.obric.assistant.n4;
import com.obric.assistant.o4;
import com.obric.assistant.reporter.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SessionAuthenticationServiceImpl$b implements n4 {
    public final AtomicBoolean a;
    public final /* synthetic */ SessionAuthenticationServiceImpl b;
    public final /* synthetic */ Ref.ObjectRef<Job> c;
    public final /* synthetic */ n4 d;
    public final /* synthetic */ Ref.BooleanRef e;
    public final /* synthetic */ o4 f;

    @Override // com.obric.assistant.n4
    public final void onAuthenticationCancelled() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.b.d.setValue(Boolean.FALSE);
        Job r0 = (Job) this.c.element;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        a(false);
        this.d.onAuthenticationCancelled();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationFailed() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.b.d.setValue(Boolean.FALSE);
        Job r0 = (Job) this.c.element;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        a(false);
        this.d.onAuthenticationFailed();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationNotAvailable() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.b.d.setValue(Boolean.FALSE);
        Job r0 = (Job) this.c.element;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.d.onAuthenticationNotAvailable();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationPass() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.b.d.setValue(Boolean.FALSE);
        Job r0 = (Job) this.c.element;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        a(true);
        this.d.onAuthenticationPass();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationTimeout() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.b.d.setValue(Boolean.FALSE);
        Job r0 = (Job) this.c.element;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        a(false);
        this.d.onAuthenticationTimeout();
    }

    public final void a(boolean r2) {
        if (this.e.element == false) goto L6;
        int r0 = c.a;
        c.a(this.f.c, r2);
        return;
    }

    public SessionAuthenticationServiceImpl$b(SessionAuthenticationServiceImpl r1, Ref.ObjectRef<Job> r2, n4 r3, Ref.BooleanRef r4, o4 r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new AtomicBoolean(false);
    }
}
