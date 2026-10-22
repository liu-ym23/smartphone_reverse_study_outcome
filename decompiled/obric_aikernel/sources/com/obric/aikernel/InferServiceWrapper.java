package com.obric.aikernel;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.UserHandle;
import com.obric.aikernel.auto_test.api.AutoTestHandlerApi;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.isolate.api.IIsolateApi;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.CloudRequestInjector;
import com.obric.aikernel.multiusr.MultiUsrAdapter;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.request.track.ProcessRequestIntervalReporter;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.tob.api.IToBStrategyManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class InferServiceWrapper extends com.obric.aikernel.a.AbstractBinderC0095a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Set<String> f4395l = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4396c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f4397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final UserHandle f4398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l0 f4399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CloudRequestInjector f4400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ConcurrentHashMap<String, WeakReference<AssetFileDescriptor>> f4401k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class b extends AbstractCoroutineContextElement implements h0 {
        public b(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            AIKLog.INSTANCE.e("InferServiceWrapper", r10 + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        new a(null);
        f4395l = SetsKt.setOf(new String[]{"com.obric.memorydata", IAIKernelManager.PACKAGE_NAME_ASSIST});
    }

    public InferServiceWrapper(Context r10, Function1<? super InferServiceWrapper, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "initBlock");
        this.f4396c = r10;
        this.f4398h = Process.myUserHandle();
        this.f4399i = m0.a(new k0("InferServiceWrapper").plus(z0.b()).plus(q2.b(null, 1, null)).plus(new b(h0.f10523d)));
        this.f4400j = new CloudRequestInjector(r10);
        this.f4401k = new ConcurrentHashMap();
        r11.invoke(this);
    }

    public static final /* synthetic */ CloudRequestInjector f2(InferServiceWrapper r10) {
        return r10.f4400j;
    }

    public static final /* synthetic */ ConcurrentHashMap k2(InferServiceWrapper r10) {
        return r10.f4401k;
    }

    private final void l2(RequestParams r10) {
        String r11 = r10.getBackend().getString("filePath");
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10.getBackend().getParcelable("fdObject") != null) goto L14;
        WeakReference<AssetFileDescriptor> r12 = this.f4401k.get(r11);
        if (r12 == null) goto L11;
        AssetFileDescriptor r13 = r12.get();
        if (r13 == null) goto L11;
        r10.getBackend().putParcelable("fdObject", r13.getParcelFileDescriptor());
    L11:
        h.d(this.f4399i, null, null, new InferServiceWrapper$argsCompat$1$2(this, null), 3, null);
        return;
    }

    private final void p2(Bundle r10) {
        if (com.obric.aikernel.api.b.f4431a.a().j() == true) goto L5;
        return;
    L5:
        if (r10.getInt(RequestParams.Args_llmUsageMode) == 1) goto L7;
        return;
    L7:
        if (f4395l.contains(e8.a.j(r10)) == false) goto L12;
        r10.putBoolean("is_lowmem_mode", true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aikernel.a
    public void A1(Bundle r15, com.obric.aikernel.b r16) {
        if (r15 == null) goto L6;
        r15.setClassLoader(PackageResource.class.getClassLoader());
    L6:
        AIKLog r10 = AIKLog.INSTANCE;
        r10.d("InferServiceWrapper", "callModel " + q2() + ' ' + r15 + ' ' + r16);
        if (r15 == null) goto L31;
        if (r16 == null) goto L31;
        IIsolateApi r11 = k7.b.a();
        int r12 = 0;
        if (r11 != null) goto L13;
    L15:
        Object[] r13 = false;
    L16:
        if (r13 == false) goto L19;
        String r14 = "callModel interceptByDebugMode " + e8.a.e(r15);
        r10.e("InferServiceWrapper", r14);
        e8.a.c(r16, 404, r14);
        return;
    L19:
        int r17 = Binder.getCallingPid();
        int r18 = Binder.getCallingUid();
        UserHandle r19 = UserHandle.getUserHandleForUid(r18);
        r10.d("InferServiceWrapper", "callModel " + e8.a.d(r15) + ' ' + this.f4398h + " from " + r17 + ',' + r18 + ',' + r19);
        if (Intrinsics.areEqual(r19, this.f4398h) == true) goto L22;
        MultiUsrAdapter r20 = MultiUsrAdapter.f4720a;
        Intrinsics.checkNotNullExpressionValue(r19, "callerUserHandle");
        r20.d(r15, r19);
        r10.d("InferServiceWrapper", "proceed args from " + r18 + ", proc " + r17);
    L22:
        p2(r15);
        ApiPerfDetails.a r21 = ApiPerfDetails.Companion;
        r21.f(r15);
        r21.i(r15, ApiPerfDetails.onReceiveBinderRequestElapse, true);
        ApiPerfDetails.a.j(r21, r15, ApiPerfDetails.onReceiveBinderRequest, false, 2, null);
        RequestParams.Companion.a(r15, r17, r18);
        int r22 = 2;
        RequestParams r23 = new RequestParams(r15, null, r22, 0 == true ? 1 : 0);
        l2(r23);
        ProcessRequestIntervalReporter.f4861a.w(new RequestParams(new Bundle(r23.getBackend()), 0 == true ? 1 : 0, r22, 0 == true ? 1 : 0));
        IToBStrategyManager r24 = h8.a.a();
        if (r24 == null) goto L25;
        r12 = r24.injectRequest(r23);
    L25:
        if (r12 == 0) goto L29;
        if (r12 != 1) goto L29;
        e8.a.c(r16, 101, "invalid permission, request rejected");
        return;
    L29:
        h.d(this.f4399i, null, null, new InferServiceWrapper$callModel$1(r23, this, r16, r15, null), 3, null);
        return;
    L13:
        if (r11.interceptByDebugMode(r15) != true) goto L15;
        r13 = true;
    L31:
        r10.e("InferServiceWrapper", "callModel with empty param: " + r15 + ' ' + r16);
    }

    @Override // com.obric.aikernel.a
    public void F1(Bundle r10, com.obric.aikernel.b r11) {
        if (e7.a.a() != null) goto L7;
        if (r11 == null) goto L11;
        e8.a.r(r11, e8.a.B(new Bundle(), 106, "not found AutoTestHandler", false, 4, null));
        return;
    L11:
        return;
    L7:
        AutoTestHandlerApi r12 = e7.a.a();
        if (r12 == null) goto L12;
        r12.handleAutoRequest(r10, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aikernel.a
    public Bundle Z0(Bundle r12) {
        Function1 r10 = null;
        Object[] r11 = 0;
        if (r12 != null) goto L6;
        AIKLog.INSTANCE.e("InferServiceWrapper", "callModelSync with empty param");
        return null;
    L6:
        r12.setClassLoader(PackageResource.class.getClassLoader());
        IToBStrategyManager r13 = h8.a.a();
        if (r13 == null) goto L9;
        int r14 = r13.injectRequest(new RequestParams(r12, r10, 2, r11 == true ? 1 : 0));
    L10:
        if (r14 != 0) goto L12;
        AssetFileDescriptor r15 = (AssetFileDescriptor) r12.getParcelable(IdlKeys.Args_GrantFd);
        if (r15 == null) goto L22;
        String r16 = r12.getString(IdlKeys.Args_GrantUri);
        if (r16 == null) goto L22;
        ConcurrentHashMap<String, WeakReference<AssetFileDescriptor>> r17 = this.f4401k;
        Intrinsics.checkNotNullExpressionValue(r16, "uri");
        r17.put(r16, new WeakReference(r15));
        h.d(this.f4399i, null, null, new InferServiceWrapper$callModelSync$1$1$1(r15, r16, r12, null), 3, null);
    L22:
        return q2().e(r12);
    L12:
        if (r14 != 1) goto L15;
        return e8.a.B(new Bundle(), 101, "invalid permission.", false, 4, null);
    L15:
        return e8.a.D(new Bundle(), 0, "request handled");
    L9:
        r14 = 0;
        goto L10
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor r12, PrintWriter r13, String[] r14) {
        Intrinsics.checkNotNullParameter(r12, "fd");
        Intrinsics.checkNotNullParameter(r13, "fout");
        String r10 = null;
        if (r14 == null) goto L5;
        String r11 = (String) ArraysKt.firstOrNull(r14);
    L7:
        if (Intrinsics.areEqual(r11, "flush-stat") == false) goto L9;
        InferEntry.f4385d.a(true);
    L9:
        StringBuilder r15 = new StringBuilder();
        if (r14 == null) goto L12;
        r10 = ArraysKt.joinToString$default(r14, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null);
    L12:
        r15.append(r10);
        r15.append("\ndid=");
        r15.append(AppContext.INSTANCE.getServerDeviceId());
        r13.println(r15.toString());
        q2().b(r12, r13, r14);
        r13.flush();
        return;
    L5:
        r11 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aikernel.a.AbstractBinderC0095a, android.os.Binder
    public boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r10 != 1001) goto L5;
        Parcelable r14 = r11.readParcelable(PackageResource.class.getClassLoader());
        Function1 r15 = null;
        Object[] r16 = 0;
        if ((r14 instanceof Bundle) == false) goto L13;
        Bundle r17 = (Bundle) r14;
    L14:
        if (r17 != null) goto L17;
        return false;
    L17:
        RequestParams.Companion.a(r17, Binder.getCallingPid(), Binder.getCallingUid());
        return q2().a(new RequestParams(r17, r15, 2, r16 == true ? 1 : 0));
    L13:
        r17 = null;
        goto L14
    L5:
        if (r10 != 10000) goto L9;
        Context r18 = this.f4396c;
        Intent r19 = new Intent(this.f4396c, Class.forName("com.obric.aikernel.debug.MainActivity"));
        r19.addFlags(268435456);
        r18.startActivity(r19);
    L9:
        return super.onTransact(r10, r11, r12, r13);
    }

    public final e q2() {
        e r10 = this.f4397g;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void r2(e r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f4397g = r10;
    }
}
