package com.obric.aikernel.runtime.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\r\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0016J%\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aH\u0000¢\u0006\u0002\b\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/aikernel/runtime/utils/NetworkUtil;", "", "()V", "TAG", "", "directNetworkState", "Lcom/obric/aikernel/runtime/utils/NetworkUtil$DirectNetworkState;", "context", "Landroid/content/Context;", "fallbackNetworkState", "Lcom/obric/aikernel/runtime/utils/NetworkUtil$FallbackNetworkState;", "fallbackNetworkStateForTest", "fallbackNetworkStateForTest$pyvm_utils_release", "isNetNotMetered", "", "isNetSystemUsable", "isWifiAvail", "resolveUnmeteredNetwork", "direct", "fallback", "resolveUnmeteredNetwork$pyvm_utils_release", "resolveValidatedNetwork", "resolveValidatedNetwork$pyvm_utils_release", "safeFallbackNetworkState", AILabCheckPermissionTask.KEY_SOURCE, "provider", "Lkotlin/Function0;", "safeFallbackNetworkState$pyvm_utils_release", "DirectNetworkState", "FallbackNetworkState", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6225a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/obric/aikernel/runtime/utils/NetworkUtil$DirectNetworkState;", "", "activeNetwork", "", "hasCapabilities", "", "validated", "internet", "unmetered", LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI, "(Ljava/lang/String;ZZZZZ)V", "getActiveNetwork", "()Ljava/lang/String;", "getHasCapabilities", "()Z", "getInternet", "getUnmetered", "getValidated", "getWifi", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6227b;
        private final boolean c;
        private final boolean d;
        private final boolean e;
        private final boolean f;

        public a(String r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "activeNetwork");
            this.f6226a = r2;
            this.f6227b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final String a() {
            return this.f6226a;
        }

        public final boolean b() {
            return this.f6227b;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6226a, r6.f6226a) == true) goto L12;
            return false;
        L12:
            if (this.f6227b == r6.f6227b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final boolean f() {
            return this.f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r0 = this.f6226a.hashCode() * 31;
            boolean r1 = this.f6227b;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.c;
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (r4 + r6) * 31;
            boolean r8 = this.d;
            ?? r9 = r8;
            if (r8 == false) goto L11;
            r9 = 1;
        L11:
            int r10 = (r7 + r9) * 31;
            boolean r11 = this.e;
            ?? r12 = r11;
            if (r11 == false) goto L14;
            r12 = 1;
        L14:
            int r13 = (r10 + r12) * 31;
            boolean r14 = this.f;
            if (r14 == true) goto L19;
            r2 = r14;
        L19:
            return r13 + r2;
        }

        public String toString() {
            return "DirectNetworkState(activeNetwork=" + this.f6226a + ", hasCapabilities=" + this.f6227b + ", validated=" + this.c + ", internet=" + this.d + ", unmetered=" + this.e + ", wifi=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/aikernel/runtime/utils/NetworkUtil$FallbackNetworkState;", "", "validated", "", "unmetered", "(ZZ)V", "getUnmetered", "()Z", "getValidated", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6229b;

        public b(boolean r1, boolean r2) {
            this.f6228a = r1;
            this.f6229b = r2;
        }

        public final boolean a() {
            return this.f6228a;
        }

        public final boolean b() {
            return this.f6229b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f6228a == r6.f6228a) goto L12;
            return false;
        L12:
            if (this.f6229b == r6.f6229b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r0 = this.f6228a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f6229b;
            if (r4 == true) goto L10;
            r1 = r4;
        L10:
            return r3 + r1;
        }

        public String toString() {
            return "FallbackNetworkState(validated=" + this.f6228a + ", unmetered=" + this.f6229b + ')';
        }
    }

    static {
        f6225a = new h();
    }

    private h() {
    }

    public static /* synthetic */ b a(h r1, String r2, Function0 r3, int r4, Object r5) {
        Function0<b> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = "NetworkStateStore";
    L6:
        return r1.a(r2, r6);
    }

    private final b b() {
        return a(this, null, (Function0) ZeusTransformUtils.preCheckCast(NetworkUtil$fallbackNetworkState$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"), 1, null);
    }

    private final a d(Context r11) {
        Object r10 = ((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        NetworkCapabilities r1 = null;
        if (ZeusTransformUtils.instanceOf(r10, ConnectivityManager.class) == false) goto L5;
        ConnectivityManager r12 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r10, ConnectivityManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 == null) goto L8;
        Network r13 = r12.getActiveNetwork();
    L9:
        if (r13 == null) goto L12;
        r1 = r12.getNetworkCapabilities(r13);
    L12:
        if (com.obric.aikernel.runtime.utils.a.f6212a.c() == false) goto L14;
    L13:
        boolean r6 = true;
    L20:
        if (r13 == null) goto L23;
        String r14 = r13.toString();
        if (r14 == null) goto L23;
    L24:
        String r4 = r14;
        if (r1 == null) goto L27;
        boolean r5 = true;
    L28:
        if (r1 != null) goto L30;
    L32:
        boolean r7 = false;
    L33:
        if (r1 != null) goto L35;
    L37:
        boolean r8 = false;
    L38:
        if (r1 != null) goto L40;
    L42:
        boolean r9 = false;
    L44:
        return new a(r4, r5, r6, r7, r8, r9);
    L40:
        if (r1.hasTransport(1) != true) goto L42;
        r9 = true;
        goto L44
    L35:
        if (r1.hasCapability(11) != true) goto L37;
        r8 = true;
        goto L38
    L30:
        if (r1.hasCapability(12) != true) goto L32;
        r7 = true;
        goto L33
    L27:
        r5 = false;
    L23:
        r14 = "null";
        goto L24
    L14:
        if (r1 != null) goto L16;
    L18:
        r6 = false;
        goto L20
    L16:
        if (r1.hasCapability(16) != true) goto L18;
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final b a() {
        g.a r2 = (g.a) ZeusTransformUtils.preCheckCast(g.f6221a.a().c(), g.a.class, "com.obric.memorydata.plugin");
        return new b(r2.a(), r2.b());
    }

    public final b a(String r6, Function0<b> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r8, "provider");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        h r5 = (h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl((b) ZeusTransformUtils.preCheckCast(r8.invoke(), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L14;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        d.f6216a.f("NetworkUtil", "fallbackNetworkState unavailable source=" + r6 + " error=" + r10.getClass().getName() + ": " + r10.getMessage() + " using validated=false unmetered=false");     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L14:
        if (Result.m1424exceptionOrNullimpl(r9) == null) goto L18;
        r9 = new b(false, false);
    L18:
        return (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        a r3 = d(r5);
        if (r3.b() == true) goto L5;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L14;
        d.f6216a.d("NetworkUtil", "isWifiAvail result=false activeNetwork=" + r3.a() + " hasCapabilities=" + r3.b() + " validated=" + r3.c() + " internet=" + r3.d() + " unmetered=" + r3.e() + " wifi=" + r3.f());
    L14:
        return r6;
    L5:
        if (r3.f() == false) goto L11;
        if (r3.d() == false) goto L11;
        if (r3.c() == false) goto L11;
        r6 = true;
        goto L12
    }

    public final boolean a(a r1, b r2) {
        Intrinsics.checkNotNullParameter(r1, "direct");
        Intrinsics.checkNotNullParameter(r2, "fallback");
        if (r1.b() == false) goto L6;
        return r1.c();
    L6:
        return r2.a();
    }

    public final boolean b(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        a r10 = d(r9);
        b r0 = b();
        boolean r7 = a(r10, r0);
        if (r10.b() == true) goto L6;
        d.f6216a.f("NetworkUtil", "isNetSystemUsable result=" + r7 + " activeNetwork=" + r10.a() + " capabilities=null fallbackValidated=" + r0.a() + " fallbackUnmetered=" + r0.b());
        return r7;
    L6:
        d.f6216a.d("NetworkUtil", "isNetSystemUsable result=" + r7 + " activeNetwork=" + r10.a() + " validated=" + r10.c() + " internet=" + r10.d() + " unmetered=" + r10.e() + " wifi=" + r10.f() + " fallbackValidated=" + r0.a() + " fallbackUnmetered=" + r0.b());
        return r7;
    }

    public final boolean b(a r1, b r2) {
        Intrinsics.checkNotNullParameter(r1, "direct");
        Intrinsics.checkNotNullParameter(r2, "fallback");
        if (r1.b() == false) goto L6;
        return r1.e();
    L6:
        return r2.b();
    }

    public final boolean c(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        a r10 = d(r9);
        b r0 = b();
        boolean r7 = b(r10, r0);
        if (r10.b() == true) goto L6;
        d.f6216a.f("NetworkUtil", "isNetNotMetered result=" + r7 + " activeNetwork=" + r10.a() + " capabilities=null fallbackValidated=" + r0.a() + " fallbackUnmetered=" + r0.b());
        return r7;
    L6:
        d.f6216a.d("NetworkUtil", "isNetNotMetered result=" + r7 + " activeNetwork=" + r10.a() + " validated=" + r10.c() + " internet=" + r10.d() + " unmetered=" + r10.e() + " wifi=" + r10.f() + " fallbackValidated=" + r0.a() + " fallbackUnmetered=" + r0.b());
        return r7;
    }
}
