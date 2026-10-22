package com.obric.aikernel.runtime.subproc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/SubProcHost;", "Landroid/os/Binder;", "ctx", "Lcom/obric/aikernel/runtime/AIInferRuntime;", "(Lcom/obric/aikernel/runtime/AIInferRuntime;)V", "getCtx", "()Lcom/obric/aikernel/runtime/AIInferRuntime;", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "preparePackage", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "Companion", "PreparePackageResult", "Proxy", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AIInferRuntime f6207b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/SubProcHost$Companion;", "", "()V", "LORA_NAME", "", "LORA_VERSION", "PACKAGE_NAME", "PACKAGE_SUB_RES_LIST", "PACKAGE_VERSION", "PREPARE_BY_UPDATE", "PRE_INIT_PKG_NAME", "PRE_INIT_PKG_VERSION", "TAG", "_preparePackage", "", "_setHost", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.subproc.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/SubProcHost$PreparePackageResult;", "", "success", "", "setHost", "subProcessVersionMap", "Landroid/os/Bundle;", "(ZZLandroid/os/Bundle;)V", "getSetHost", "()Z", "getSubProcessVersionMap", "()Landroid/os/Bundle;", "getSuccess", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0279b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6209b;
        private final Bundle c;

        public C0279b() {
            this(false, false, null, 7, null);
        }

        public C0279b(boolean r1, boolean r2, Bundle r3) {
            this.f6208a = r1;
            this.f6209b = r2;
            this.c = r3;
        }

        public /* synthetic */ C0279b(boolean r2, boolean r3, Bundle r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final boolean a() {
            return this.f6208a;
        }

        public final boolean b() {
            return this.f6209b;
        }

        public final Bundle c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0279b.class) == true) goto L8;
            return false;
        L8:
            C0279b r6 = (C0279b) ZeusTransformUtils.preCheckCast(r5, C0279b.class, "com.obric.memorydata.plugin");
            if (this.f6208a == r6.f6208a) goto L12;
            return false;
        L12:
            if (this.f6209b == r6.f6209b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r0 = this.f6208a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f6209b;
            if (r4 == true) goto L9;
            r1 = r4;
        L9:
            int r5 = (r3 + r1) * 31;
            Bundle r6 = this.c;
            if (r6 != null) goto L12;
            int r7 = 0;
        L14:
            return r5 + r7;
        L12:
            r7 = r6.hashCode();
            goto L14
        }

        public String toString() {
            return "PreparePackageResult(success=" + this.f6208a + ", setHost=" + this.f6209b + ", subProcessVersionMap=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/runtime/subproc/SubProcHost$Proxy;", "", "proc", "", "remote", "Landroid/os/IBinder;", "(Ljava/lang/String;Landroid/os/IBinder;)V", "getProc", "()Ljava/lang/String;", "getRemote", "()Landroid/os/IBinder;", "preparePackage", "Lcom/obric/aikernel/runtime/subproc/SubProcHost$PreparePackageResult;", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "setHost", "", "host", "Lcom/obric/aikernel/runtime/subproc/MainHost;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IBinder f6211b;

        public c(String r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "proc");
            Intrinsics.checkNotNullParameter(r5, "remote");
            this.f6210a = r3;
            this.f6211b = r5;
        }

        public final C0279b a(RequestParams r9) {
            Intrinsics.checkNotNullParameter(r9, TrackerImpl.PARAMS);
            NativeLibVersionPolicy.INSTANCE.fillNativeLibs(r9.getBackend());
            Parcel r2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r2, "obtain()");
            Parcel r4 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r4, "obtain()");
            C0279b r3 = null;
            r2.writeInterfaceToken("SubProcHost");     // Catch: Throwable -> L7
            r2.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r9.getBackend(), Parcelable.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L7
            if (this.f6211b.transact(1, r2, r4, 0) == false) goto L9;
            r4.readException();     // Catch: Throwable -> L7
            r3 = new C0279b(r4.readBoolean(), r4.readBoolean(), (Bundle) ZeusTransformUtils.preCheckCast(r4.readParcelable(getClass().getClassLoader()), Bundle.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        L9:
            r2.recycle();
            r4.recycle();
            return r3;
        L7:
            th = move-exception;
            com.obric.aikernel.runtime.utils.d.f6216a.g("SubProcHost", "preparePackage failed, " + th);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            r2.recycle();
            r4.recycle();
            throw th;
        }

        public final void a(com.obric.aikernel.runtime.subproc.a r5) {
            Intrinsics.checkNotNullParameter(r5, "host");
            Parcel r1 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r1, "obtain()");
            r1.writeInterfaceToken("SubProcHost");     // Catch: Throwable -> L5
            r1.writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(r5, IBinder.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            this.f6211b.transact(2, r1, null, 0);     // Catch: Throwable -> L5
        L4:
            r1.recycle();
            return;
        L5:
            th = move-exception;
            com.obric.aikernel.runtime.utils.d.f6216a.g("SubProcHost", "setHost failed, " + th);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r1.recycle();
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aikernel/runtime/subproc/SubProcHost$preparePackage$3$1$mockPkg$1", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "isAvailable", "", "resourceIsAvailable", "resourceIsReady", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends com.obric.aikernel.res.metadata.data.b {
        d(String r2, String r3, PackageResourceManager.PresmConfig r4) {
            Intrinsics.checkNotNullExpressionValue(r3, "version");
            super(r2, r3, r4);
        }

        @Override // com.obric.aikernel.res.metadata.data.b, com.obric.aikernel.res.metadata.data.d
        public boolean d() {
            return true;
        }

        @Override // com.obric.aikernel.res.metadata.data.d
        public boolean e() {
            return true;
        }

        @Override // com.obric.aikernel.res.metadata.data.b, com.obric.aikernel.res.metadata.data.d
        public boolean f() {
            return true;
        }
    }

    static {
        f6206a = new a(null);
    }

    public b(AIInferRuntime r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super("SubProcHost");
        this.f6207b = r2;
    }

    public final AIInferRuntime a() {
        return this.f6207b;
    }

    public final void a(RequestParams r18) {
        Intrinsics.checkNotNullParameter(r18, TrackerImpl.PARAMS);
        Map<String, String> r2 = NativeLibVersionPolicy.INSTANCE.getNativeLibs(r18.getBackend());
        if (r2 == null) goto L12;
        Iterator<Map.Entry<String, String>> r3 = r2.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (NativeLibVersionPolicy.INSTANCE.getVersion((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) != null) goto L6;
        NativeLibVersionPolicy.INSTANCE.recordMaxAvail((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), this.f6207b.a().g());
        NativeLibVersionPolicy.INSTANCE.recordVersion((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));
        if (r18.getBackend().getBoolean("@prepare_by_update") == true) goto L6;
        NativeLibVersionPolicy.INSTANCE.initOrGetVersion((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"));
    L12:
        String r5 = r18.getBackend().getString("@vm_package_name");
        if (r5 == null) goto L40;
        String r6 = r18.getBackend().getString("@vm_lora_name");
        List<String> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r8 = r18.getBackend().getString("@pre_init_pkg_ver");
        if (r8 == null) goto L17;
        r7.add("package@" + r18.getBackend().getString("@pre_init_pkg_name") + '@' + r8);
    L17:
        ArrayList<String> r9 = r18.getBackend().getStringArrayList("@vm_package_sub_res");
        if (r9 == null) goto L25;
        String r11 = r18.getBackend().getString("@vm_package_ver");
        if (r11 == null) goto L22;
        d r13 = new d(r5, r11, this.f6207b.a().g());
        r13.a(com.obric.aikernel.res.metadata.data.d.f.a((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), this.f6207b.a().g()));
        List<? extends com.obric.aikernel.res.metadata.data.b> r10 = CollectionsKt.mutableListOf(new com.obric.aikernel.res.metadata.data.b[]{(com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r13, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin")});
        Unit r12 = Unit.INSTANCE;
    L23:
        if (r12 == null) goto L26;
    L29:
        String r14 = r18.getBackend().getString("@vm_lora_ver");
        if (r14 == null) goto L32;
        r7.add("lora@" + r6 + '@' + r14);
    L32:
        AIInferRuntime r15 = this.f6207b;
        if (r10 != null) goto L35;
        r10 = CollectionsKt.emptyList();
    L35:
        r15.a(r7, r10);
        if (r18.getBackend().getBoolean(Params.NEED_PRELOAD) == false) goto L48;
        i.a(this.f6207b.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new SubProcHost$preparePackage$6(this, r5, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L48:
        return;
    L26:
        b r16 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        String r17 = r18.getBackend().getString("@vm_package_ver");
        if (r17 == null) goto L29;
        Boolean.valueOf(r7.add("package@" + r5 + '@' + r17));
        goto L29
    L22:
        r10 = null;
        r12 = null;
        goto L23
    L25:
        r10 = null;
        goto L26
    L40:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // android.os.Binder
    public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (r5 == 1) goto L10;
        if (r5 != 2) goto L42;
        r6.enforceInterface("SubProcHost");
        IBinder r9 = r6.readStrongBinder();
        Intrinsics.checkNotNullExpressionValue(r9, "data.readStrongBinder()");
        com.obric.aikernel.runtime.subproc.a.c r10 = new com.obric.aikernel.runtime.subproc.a.c(r9);
        this.f6207b.a().m().a(r10);
        AIInferRuntime.d.C0273d r4 = this.f6207b.a().h();
        if (r4 == null) goto L45;
        r4.a(r10);
        return true;
    L45:
        return true;
    L42:
        return super.onTransact(r5, r6, r7, r8);
    L10:
        r6.enforceInterface("SubProcHost");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L16
        b r12 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Parcelable r13 = r6.readParcelable(RequestParams.class.getClassLoader());     // Catch: Throwable -> L16
        if (r13 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r13, "requireNotNull(data.read…:class.java.classLoader))");     // Catch: Throwable -> L16
        r12.a(new RequestParams((Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.memorydata.plugin"), null, 2, null));     // Catch: Throwable -> L16
        Object r14 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.m1428isSuccessimpl(r14) == false) goto L25;
        Unit r15 = (Unit) ZeusTransformUtils.preCheckCast(r14, Unit.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L23;
        r7.writeNoException();
    L23:
        if (r7 == null) goto L25;
        r7.writeBoolean(true);
    L25:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r14);
        if (r16 == null) goto L32;
        if (r7 == null) goto L29;
        r7.writeException((Exception) ZeusTransformUtils.preCheckCast(new RuntimeException(r16), Exception.class, "com.obric.memorydata.plugin"));
    L29:
        if (r7 == null) goto L32;
        r7.writeBoolean(true);
    L32:
        if (r7 != null) goto L34;
    L38:
        if (r7 == null) goto L44;
        Bundle r17 = new Bundle();
        NativeLibVersionPolicy.INSTANCE.fillNativeLibs(r17);
        r7.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r17, Parcelable.class, "com.obric.memorydata.plugin"), 0);
        return true;
    L44:
        return true;
    L34:
        if (this.f6207b.a().m().e() != null) goto L36;
        boolean r18 = true;
    L37:
        r7.writeBoolean(r18);
        goto L38
    L36:
        r18 = false;
        goto L37
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
