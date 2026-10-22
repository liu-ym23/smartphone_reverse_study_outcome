package com.obric.aikernel.phx.sdk;

import ae.d;
import androidx.annotation.Keep;
import ce.c;
import ce.e;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class AIKernelManager implements IAIKernelManager {
    public static final AIKernelManager INSTANCE = null;
    private static final AIKernelApi instance = null;

    @e(c = "com.obric.aikernel.phx.sdk.AIKernelManager", f = "AIKernelManager.kt", l = {30}, m = "getPackage-0E7RQCE")
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelManager f5232b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f5233m;

        public a(AIKernelManager r8, d<? super a> r10) {
            this.f5232b = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5231a = r8;
            this.f5233m |= Integer.MIN_VALUE;
            Object r10 = this.f5232b.mo9getPackage0E7RQCE(null, null, this);
            if (r10 != be.a.f3165a) goto L6;
            return r10;
        L6:
            return new xd.e(r10);
        }
    }

    @e(c = "com.obric.aikernel.phx.sdk.AIKernelManager", f = "AIKernelManager.kt", l = {32}, m = "updatePackage-0E7RQCE")
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AIKernelManager f5235b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f5236m;

        public b(AIKernelManager r8, d<? super b> r10) {
            this.f5235b = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5234a = r8;
            this.f5236m |= Integer.MIN_VALUE;
            Object r10 = this.f5235b.mo10updatePackage0E7RQCE(null, null, this);
            if (r10 != be.a.f3165a) goto L6;
            return r10;
        L6:
            return new xd.e(r10);
        }
    }

    static {
        INSTANCE = new AIKernelManager();
        instance = new AIKernelApi();
    }

    private AIKernelManager() {
    }

    public static /* synthetic */ void init$default(AIKernelManager r8, AIKernelConfig r10, ILog r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        r8.init(r10, r11);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r8, d<? super j> r10) {
        Object r11 = instance.clearAIKernelData(r8, r10);
        if (r11 != be.a.f3165a) goto L6;
        return r11;
    L6:
        return j.f13877a;
    }

    public final AIKernelApi getInstance$sdk_release() {
        return instance;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE, reason: not valid java name */
    public Object mo9getPackage0E7RQCE(String r8, RequestParams r10, d<? super xd.e<PackageResource>> r11) {
        if ((r11 instanceof a) == false) goto L7;
        a r12 = (a) r11;
        int r13 = r12.f5233m;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f5233m = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f5231a;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f5233m;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        defpackage.c.m0(r14);
        return ((xd.e) r14).f13869a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r14);
        AIKernelApi r17 = instance;
        r12.f5233m = 1;
        Object r18 = r17.mo9getPackage0E7RQCE(r8, r10, r12);
        if (r18 != r15) goto L18;
        return r15;
    L18:
        return r18;
    L7:
        r12 = new a(this, r11);
        goto L8
    }

    public final void init(AIKernelConfig r8) {
        i.f(r8, "config");
        instance.f(r8, null);
    }

    public final IAIKernelManager invoke() {
        return this;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r8, boolean r10, RequestParams r11, d<? super IBaseModel> r12) {
        return instance.loadPackage(r8, r10, r11, r12);
    }

    public final void registerLog(ILog r8) {
        i.f(r8, "inst");
        AIKLog.INSTANCE.registerLog(r8);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE, reason: not valid java name */
    public Object mo10updatePackage0E7RQCE(PackageResource r8, RequestParams r10, d<? super xd.e<PackageResource>> r11) {
        if ((r11 instanceof b) == false) goto L7;
        b r12 = (b) r11;
        int r13 = r12.f5236m;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f5236m = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f5234a;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f5236m;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        defpackage.c.m0(r14);
        return ((xd.e) r14).f13869a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r14);
        AIKernelApi r17 = instance;
        r12.f5236m = 1;
        Object r18 = r17.mo10updatePackage0E7RQCE(r8, r10, r12);
        if (r18 != r15) goto L18;
        return r15;
    L18:
        return r18;
    L7:
        r12 = new b(this, r11);
        goto L8
    }

    public final void init(AIKernelConfig r8, ILog r10) {
        i.f(r8, "config");
        instance.f(r8, r10);
    }
}
