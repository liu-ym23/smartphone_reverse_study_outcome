package com.obric.aikernel;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.request.RequestParser;
import com.obric.aikernel.request.track.VMStartupInfo;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.service.res.PythonRuntimeService;
import com.obric.aikernel.service.session.ApiRequestSession;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class InferEntry implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f4385d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PythonRuntimeService f4386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InferEntry$requestHandleImpl$1 f4387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RequestParser f4388c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(boolean r10) {
            InferEntry.h(r10);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IBinder f4390b;

        public b(String r10, IBinder r11) {
            Intrinsics.checkNotNullParameter(r10, "processName");
            Intrinsics.checkNotNullParameter(r11, "binder");
            this.f4389a = r10;
            this.f4390b = r11;
        }

        public final IBinder a() {
            return this.f4390b;
        }

        public final String b() {
            return this.f4389a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.f4389a, r11.f4389a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4390b, r11.f4390b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f4389a.hashCode() * 31) + this.f4390b.hashCode();
        }

        public String toString() {
            return "PreparedPackageTarget(processName=" + this.f4389a + ", binder=" + this.f4390b + ')';
        }
    }

    static {
        f4385d = new a(null);
    }

    public InferEntry(IBinder r10) {
        Intrinsics.checkNotNullParameter(r10, "binder");
        VMStartupInfo r11 = VMStartupInfo.f4878a;
        r11.n();
        this.f4386a = com.obric.aikernel.service.c.f5440a.a().d();
        r11.m();
        InferEntry$requestHandleImpl$1 r12 = new InferEntry$requestHandleImpl$1(this);
        this.f4387b = r12;
        this.f4388c = new RequestParser(new RequestTracker(r12));
    }

    public static final /* synthetic */ PythonRuntimeService f(InferEntry r10) {
        return r10.f4386a;
    }

    public static final /* synthetic */ Object g(InferEntry r10, RequestParams r11, com.obric.aikernel.b r12, Continuation r13) {
        return r10.k(r11, r12, r13);
    }

    public static final /* synthetic */ void h(boolean r10) {
    }

    private final void i(Bundle r10, String r11, ArrayList<String> r12, Function2<? super Bundle, ? super String, Unit> r13) {
        boolean r14 = false;
        if (r12 != null) goto L5;
    L7:
        if (r14 == true) goto L10;
        r13.invoke(r10, r11);
        return;
    L10:
        return;
    L5:
        if (r12.contains(r11) == true) goto L7;
        r14 = true;
        goto L7
    }

    private final Object k(RequestParams r10, com.obric.aikernel.b r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof InferEntry$inferRequestImpl$1) == false) goto L7;
        InferEntry$inferRequestImpl$1 r13 = (InferEntry$inferRequestImpl$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        com.obric.aikernel.legacy.a r18 = (com.obric.aikernel.legacy.a) r13.L$2;
        Bundle r19 = (Bundle) r13.L$1;
        r11 = (com.obric.aikernel.b) r13.L$0;
        ResultKt.throwOnFailure(r15);
        Bundle r20 = r19;
    L27:
        Bundle r21 = e8.a.w(r20, r18.a((PackageResource) r15), 0, null, 6, null);
    L28:
        e8.a.r(r11, r21);
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (com.obric.aikernel.b) r13.L$2;
        r10 = (RequestParams) r13.L$1;
        InferEntry this = (InferEntry) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        if (((Boolean) r15).booleanValue() == true) goto L31;
        if (Intrinsics.areEqual(e8.a.h(r10.getBackend()), IdlKeys.Method_GetScriptStatus) == false) goto L29;
        String r22 = e8.a.e(r10.getBackend());
        Bundle r23 = new Bundle();
        com.obric.aikernel.legacy.a r24 = com.obric.aikernel.legacy.a.f4495a;
        InferEntry$requestHandleImpl$1 r25 = this.f4387b;
        r13.L$0 = r11;
        r13.L$1 = r23;
        r13.L$2 = r24;
        r13.label = 2;
        r15 = r25.e(r22, r10, r13);
        if (r15 != r16) goto L26;
        return r16;
    L26:
        r20 = r23;
        r18 = r24;
        goto L27
    L29:
        r21 = e8.a.A(new Bundle(), 106, null, 2, null);
        goto L28
    L16:
        ResultKt.throwOnFailure(r15);
        RequestParser r26 = this.f4388c;
        r13.L$0 = this;
        r13.L$1 = r10;
        r13.L$2 = r11;
        r13.label = 1;
        r15 = r26.a(r10, r11, r13);
        if (r15 != r16) goto L20;
        return r16;
    L7:
        r13 = new InferEntry$inferRequestImpl$1(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.e
    public boolean a(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "requestParams");
        return com.obric.aikernel.service.c.f5440a.a().a(r10);
    }

    @Override // com.obric.aikernel.e
    public void b(FileDescriptor r10, PrintWriter r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        Intrinsics.checkNotNullParameter(r11, "fout");
        com.obric.aikernel.service.c.f5440a.a().b(r10, r11, r12);
    }

    @Override // com.obric.aikernel.e
    public Object c(RequestParams r10, com.obric.aikernel.b r11, Continuation<? super Unit> r12) {
        Object r13 = k(r10, r11, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.e
    public Object d(RequestParams r10, com.obric.aikernel.b r11, Continuation<? super com.obric.aikernel.b> r12) {
        ApiRequestSession.a r13 = new ApiRequestSession.a(r11, r10, null, 4, null);
        com.obric.aikernel.service.c.f5440a.a().c().i(ApiRequestSession.Companion.d(ApiRequestSession.f5534j, r10, r12.getContext(), r13, null, 4, null));
        return r13;
    }

    @Override // com.obric.aikernel.e
    public Bundle e(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        String r11 = e8.a.h(r10);
        if (r11 == null) goto L27;
        int r12 = r11.hashCode();
        if (r12 == (-381168340)) goto L21;
        if (r12 == 1405340390) goto L16;
        if (r12 != 1930625485) goto L27;
        if (r11.equals(IdlKeys.Method_QuerySubProc) == false) goto L27;
        ArrayList<String> r13 = r10.getStringArrayList("@query_args");
        Bundle r14 = new Bundle();
        i(r14, "@sub_proc_host", r13, new InferEntry$inferRequest$3$1(this));
        i(r14, NativeLibVersionPolicy.KEY_NATIVE_LIB, r13, InferEntry$inferRequest$3$2.INSTANCE);
        i(r14, "@vlm_local_ver", r13, InferEntry$inferRequest$3$3.INSTANCE);
        return r14;
    L16:
        if (r11.equals(IdlKeys.Method_SubProcRestart) == false) goto L27;
        com.obric.aikernel.service.c.f5440a.a().c().m();
    L29:
        return com.obric.aikernel.request.b.f4839c.e();
    L21:
        if (r11.equals(IdlKeys.Method_PushDebugPackage) == false) goto L27;
        String r15 = r10.getString(IdlKeys.Args_HostModels);
        if (r15 == null) goto L29;
        h.d(m0.a(z0.b()), null, null, new InferEntry$inferRequest$2$1(this, r15, null), 3, null);
    L27:
        return e.a.b(this, r10);
    }

    public final List<y6.b> j() {
        return com.obric.aikernel.service.c.f5440a.a().d().A();
    }
}
