package sa;

import ae.d;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import ce.e;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.config.RequestParams;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12056a = null;

    /* JADX INFO: renamed from: sa.a$a, reason: collision with other inner class name */
    @e(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", l = {31}, m = "grantUri")
    public static final class C0155a extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AssetFileDescriptor f12058b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f12059m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f12060n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ a f12061o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f12062p;

        public C0155a(a r8, d<? super C0155a> r10) {
            this.f12061o = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f12060n = r8;
            this.f12062p |= Integer.MIN_VALUE;
            a r10 = this.f12061o;
            a r11 = a.f12056a;
            return r10.a(null, null, 0, this);
        }
    }

    @e(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", l = {25}, m = "onStartCompat")
    public static final class b extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f12063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f12064b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12065m;

        public b(a r8, d<? super b> r10) {
            this.f12064b = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f12063a = r8;
            this.f12065m |= Integer.MIN_VALUE;
            a r10 = a.f12056a;
            return this.f12064b.b(null, this);
        }
    }

    @e(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", l = {16}, m = "startCompat")
    public static final class c extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RequestParams f12066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12067b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ a f12068m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f12069n;

        public c(a r8, d<? super c> r10) {
            this.f12068m = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f12067b = r8;
            this.f12069n |= Integer.MIN_VALUE;
            return this.f12068m.c(null, this);
        }
    }

    static {
        f12056a = new a();
    }

    public a() {
    }

    public final Object a(String r10, AssetFileDescriptor r11, long r12, d<? super j> r13) {
        if ((r13 instanceof C0155a) == false) goto L7;
        C0155a r8 = (C0155a) r13;
        int r14 = r8.f12062p;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f12062p = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r8.f12060n;
        be.a r16 = be.a.f3165a;
        int r17 = r8.f12062p;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r12 = r8.f12059m;
        r11 = r8.f12058b;
        r10 = r8.f12057a;
        defpackage.c.m0(r15);
    L17:
        AIKBinder r18 = (AIKBinder) r15;
        if (r18 != null) goto L26;
        AIKLog.INSTANCE.w("ParamsCompat", "grantUri get null binder!");
    L25:
        return j.f13877a;
    L26:
        Bundle r19 = new Bundle();     // Catch: Throwable -> L21
        wa.a.a(r19, "", IdlKeys.Method_GrantUri, IdlKeys.Call_Type_CallGlobalBiz, null, "ParamsCompat", "grantUri", 200);     // Catch: Throwable -> L21
        r19.putString(IdlKeys.Args_GrantUri, r10);     // Catch: Throwable -> L21
        r19.putParcelable(IdlKeys.Args_GrantFd, r11);     // Catch: Throwable -> L21
        r19.putLong(IdlKeys.Args_Timeout, r12);     // Catch: Throwable -> L21
        r18.s1(r19);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        defpackage.c.D(th);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r15);
        r8.getClass();
        r8.f12057a = r10;
        r8.f12058b = r11;
        r8.f12059m = r12;
        r8.f12062p = 1;
        r15 = AIKernelApi.d(AIKernelManager.INSTANCE.getInstance$sdk_release(), r8);
        if (r15 != r16) goto L17;
        return r16;
    L7:
        r8 = new C0155a(this, r13);
        goto L8
    }

    public final Object b(RequestParams r8, d<? super j> r10) {
        if ((r10 instanceof b) == false) goto L7;
        b r11 = (b) r10;
        int r12 = r11.f12065m;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f12065m = r12 - Integer.MIN_VALUE;
    L8:
        b r13 = r11;
        Object r14 = r13.f12063a;
        be.a r15 = be.a.f3165a;
        int r16 = r13.f12065m;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        defpackage.c.m0(r14);
    L22:
        return j.f13877a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r14);
        String r17 = r8.getBackend().getString("filePath");
        if (r17 == null) goto L22;
        AssetFileDescriptor r18 = (AssetFileDescriptor) r8.getBackend().getParcelable("fdAsset");
        if (r18 == null) goto L22;
        a r19 = f12056a;
        r13.f12065m = 1;
        if (r19.a(r17, r18, 3600000, r13) != r15) goto L22;
        return r15;
    L7:
        r11 = new b(this, r10);
        goto L8
    }

    public final Object c(RequestParams r8, d<? super Bundle> r10) {
        if ((r10 instanceof c) == false) goto L7;
        c r11 = (c) r10;
        int r12 = r11.f12069n;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f12069n = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f12067b;
        Object r14 = be.a.f3165a;
        int r15 = r11.f12069n;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r8 = r11.f12066a;
        defpackage.c.m0(r13);
    L20:
        return r8.start();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r13);
        if (AIKernelManager.INSTANCE.getInstance$sdk_release().f5241c == false) goto L20;
        r11.f12066a = r8;
        r11.f12069n = 1;
        if (b(r8, r11) != r14) goto L20;
        return r14;
    L7:
        r11 = new c(this, r10);
        goto L8
    }
}
