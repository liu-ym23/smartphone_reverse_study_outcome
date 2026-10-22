package com.ss.ugc.effectplatform.task;

import bytekn.foundation.utils.Transmitter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.util.r;
import e0.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class BaseTask implements c {
    public String a;
    public boolean b;
    public long c;
    public boolean d;
    public final String e;
    public final hlc.a f;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Function0 r1) {
            this.a = r1;
        }
    }

    public abstract void a();

    public abstract void b();

    public void c() {
    }

    public void cancel() {
        this.b = true;
        e(new cancel.1(this));
    }

    public void d() {
    }

    public int getLevel() {
        return 0;
    }

    public void pause() {
        this.b = true;
        e(new pause.1(this));
    }

    public final void run() {
        this.d = true;
        String r0 = this.e;
        IEffectPlatformBaseListener r1 = null;
        if (r0 == null) goto L12;
        hlc.a r2 = this.f;
        if (r2 == null) goto L7;
        IEffectPlatformBaseListener r3 = r2.a(r0);
    L9:
        if ((r3 instanceof hlc.c) == false) goto L12;
        ((hlc.c) r3).onStart();
        goto L12
    L7:
        r3 = null;
    L12:
        if (this.b == false) goto L14;
        return;
    L14:
        a();
        String r4 = this.e;
        if (r4 == null) goto L22;
        hlc.a r5 = this.f;
        if (r5 == null) goto L20;
        r1 = r5.a(r4);
    L20:
        if ((r1 instanceof hlc.c) == false) goto L22;
        ((hlc.c) r1).onFinally();
    L22:
        this.d = false;
    }

    public final String getId() {
        String r0 = this.e;
        if (r0 != null) goto L7;
        return "0";
    L7:
        return r0;
    }

    public final String getTag() {
        int r0 = r.a;
        if (r.b(this.a) == false) goto L6;
        return String.valueOf(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName());
    L6:
        return this.a;
    }

    public long getModifyTime() {
        return this.c;
    }

    public final void e(Function0<Unit> r2) {
        Transmitter.a(new a(r2));
    }

    public void setModifyTime(long r1) {
        this.c = r1;
    }

    public BaseTask(String r1, hlc.a r2) {
        this.e = r1;
        this.f = r2;
        this.a = "";
    }
}
