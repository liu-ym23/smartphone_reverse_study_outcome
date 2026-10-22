package com.obric.aikernel.runtime.subproc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.config.RequestParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class SubProcHost extends Binder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AIInferRuntime f5378c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Bundle f5381c;

        public b() {
            this(false, false, null, 7, null);
        }

        public b(boolean r10, boolean r11, Bundle r12) {
            this.f5379a = r10;
            this.f5380b = r11;
            this.f5381c = r12;
        }

        public /* synthetic */ b(boolean r10, boolean r11, Bundle r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = false;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = false;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = null;
        L11:
            this(r10, r11, r12);
        }

        public final boolean a() {
            return this.f5380b;
        }

        public final Bundle b() {
            return this.f5381c;
        }

        public final boolean c() {
            return this.f5379a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f5379a == r11.f5379a) goto L12;
            return false;
        L12:
            if (this.f5380b == r11.f5380b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f5381c, r11.f5381c) == true) goto L17;
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
            boolean r10 = this.f5379a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f5380b;
            if (r14 == true) goto L9;
            r11 = r14;
        L9:
            int r15 = (r13 + r11) * 31;
            Bundle r16 = this.f5381c;
            if (r16 != null) goto L12;
            int r17 = 0;
        L14:
            return r15 + r17;
        L12:
            r17 = r16.hashCode();
            goto L14
        }

        public String toString() {
            return "PreparePackageResult(success=" + this.f5379a + ", setHost=" + this.f5380b + ", subProcessVersionMap=" + this.f5381c + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f5382a;

        public c(String r10, IBinder r11) {
            Intrinsics.checkNotNullParameter(r10, "proc");
            Intrinsics.checkNotNullParameter(r11, "remote");
            this.f5382a = r11;
        }

        public final b a(RequestParams r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            NativeLibVersionPolicy.INSTANCE.fillNativeLibs(r10.getBackend());
            Parcel r11 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r11, "obtain()");
            Parcel r12 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r12, "obtain()");
            b r13 = null;
            r11.writeInterfaceToken("SubProcHost");     // Catch: Throwable -> L8
            r11.writeParcelable(r10.getBackend(), 0);     // Catch: Throwable -> L8
            if (this.f5382a.transact(1, r11, r12, 0) == false) goto L7;
            r12.readException();     // Catch: Throwable -> L8
            r13 = new b(r12.readBoolean(), r12.readBoolean(), (Bundle) r12.readParcelable(c.class.getClassLoader()));     // Catch: Throwable -> L8
        L7:
            r11.recycle();
            r12.recycle();
            return r13;
        L8:
            th = move-exception;
            com.obric.aikernel.runtime.utils.d.f5417a.e("SubProcHost", "preparePackage failed, " + th);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            r11.recycle();
            r12.recycle();
            throw th;
        }

        public final void b(MainHost r10) {
            Intrinsics.checkNotNullParameter(r10, "host");
            Parcel r11 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r11, "obtain()");
            r11.writeInterfaceToken("SubProcHost");     // Catch: Throwable -> L5
            r11.writeStrongBinder(r10);     // Catch: Throwable -> L5
            this.f5382a.transact(2, r11, null, 0);     // Catch: Throwable -> L5
        L4:
            r11.recycle();
            return;
        L5:
            th = move-exception;
            com.obric.aikernel.runtime.utils.d.f5417a.e("SubProcHost", "setHost failed, " + th);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r11.recycle();
            throw th;
        }
    }

    public static final class d extends AIPackage {
        d(String r10, String r11, PackageResourceManager.PresmConfig r12) {
            Intrinsics.checkNotNullExpressionValue(r11, "version");
            super(r10, r11, r12);
        }

        @Override // com.obric.aikernel.res.metadata.data.AIPackage, com.obric.aikernel.res.metadata.data.b
        public boolean H() {
            return true;
        }

        @Override // com.obric.aikernel.res.metadata.data.b
        public boolean Z() {
            return true;
        }

        @Override // com.obric.aikernel.res.metadata.data.AIPackage, com.obric.aikernel.res.metadata.data.b
        public boolean a0() {
            return true;
        }
    }

    static {
        new a(null);
    }

    public SubProcHost(AIInferRuntime r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        super("SubProcHost");
        this.f5378c = r10;
    }

    public final AIInferRuntime a() {
        return this.f5378c;
    }

    public final void b(RequestParams r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        Map<String, String> r10 = NativeLibVersionPolicy.INSTANCE.getNativeLibs(r15.getBackend());
        if (r10 == null) goto L12;
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<String, String> r12 = r11.next();
        NativeLibVersionPolicy r13 = NativeLibVersionPolicy.INSTANCE;
        if (r13.getVersion(r12.getKey()) != null) goto L6;
        r13.recordMaxAvail(r12.getKey(), this.f5378c.R().h());
        r13.recordVersion(r12.getKey(), r12.getValue());
        if (r15.getBackend().getBoolean("@prepare_by_update") == true) goto L6;
        r13.initOrGetVersion(r12.getKey());
    L12:
        String r14 = r15.getBackend().getString("@vm_package_name");
        if (r14 == null) goto L40;
        String r16 = r15.getBackend().getString("@vm_lora_name");
        ArrayList r17 = new ArrayList();
        String r18 = r15.getBackend().getString("@pre_init_pkg_ver");
        if (r18 == null) goto L17;
        r17.add("package@" + r15.getBackend().getString("@pre_init_pkg_name") + '@' + r18);
    L17:
        ArrayList<String> r19 = r15.getBackend().getStringArrayList("@vm_package_sub_res");
        if (r19 == null) goto L25;
        String r20 = r15.getBackend().getString("@vm_package_ver");
        if (r20 == null) goto L22;
        d r110 = new d(r14, r20, this.f5378c.R().h());
        r110.q0(com.obric.aikernel.res.metadata.data.b.f5079l.c(r19, this.f5378c.R().h()));
        List<? extends AIPackage> r21 = CollectionsKt.mutableListOf(new AIPackage[]{r110});
        Unit r22 = Unit.INSTANCE;
    L23:
        if (r22 == null) goto L26;
    L29:
        String r23 = r15.getBackend().getString("@vm_lora_ver");
        if (r23 == null) goto L32;
        r17.add("lora@" + r16 + '@' + r23);
    L32:
        AIInferRuntime r24 = this.f5378c;
        if (r21 != null) goto L35;
        r21 = CollectionsKt.emptyList();
    L35:
        r24.x0(r17, r21);
        if (r15.getBackend().getBoolean("needPreload") == false) goto L48;
        h.d(this.f5378c.a0(), null, null, new SubProcHost$preparePackage$6(this, r14, r15, null), 3, null);
        return;
    L48:
        return;
    L26:
        String r25 = r15.getBackend().getString("@vm_package_ver");
        if (r25 == null) goto L29;
        r17.add("package@" + r14 + '@' + r25);
        goto L29
    L22:
        r21 = null;
        r22 = null;
        goto L23
    L25:
        r21 = null;
        goto L26
    L40:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // android.os.Binder
    protected boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L42;
        r11.enforceInterface("SubProcHost");
        IBinder r14 = r11.readStrongBinder();
        Intrinsics.checkNotNullExpressionValue(r14, "data.readStrongBinder()");
        MainHost.Proxy r15 = new MainHost.Proxy(r14);
        this.f5378c.R().f().g(r15);
        AIInferRuntime.d.c r16 = this.f5378c.R().k();
        if (r16 == null) goto L45;
        r16.c(r15);
        return true;
    L45:
        return true;
    L42:
        return super.onTransact(r10, r11, r12, r13);
    L10:
        r11.enforceInterface("SubProcHost");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L16
        Parcelable r18 = r11.readParcelable(RequestParams.class.getClassLoader());     // Catch: Throwable -> L16
        if (r18 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r18, "requireNotNull(data.read…:class.java.classLoader))");     // Catch: Throwable -> L16
        b(new RequestParams((Bundle) r18, null, 2, null));     // Catch: Throwable -> L16
        Object r19 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.m39isSuccessimpl(r19) == false) goto L25;
        Unit r20 = (Unit) r19;
        if (r12 == null) goto L23;
        r12.writeNoException();
    L23:
        if (r12 == null) goto L25;
        r12.writeBoolean(true);
    L25:
        Throwable r21 = Result.m35exceptionOrNullimpl(r19);
        if (r21 == null) goto L32;
        if (r12 == null) goto L29;
        r12.writeException(new RuntimeException(r21));
    L29:
        if (r12 == null) goto L32;
        r12.writeBoolean(true);
    L32:
        if (r12 != null) goto L34;
    L38:
        if (r12 == null) goto L44;
        Bundle r22 = new Bundle();
        NativeLibVersionPolicy.INSTANCE.fillNativeLibs(r22);
        r12.writeParcelable(r22, 0);
        return true;
    L44:
        return true;
    L34:
        if (this.f5378c.R().f().b() != null) goto L36;
        boolean r23 = true;
    L37:
        r12.writeBoolean(r23);
        goto L38
    L36:
        r23 = false;
        goto L37
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
