package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NativePrefetchLepus extends NativePrefetch {
    public final Map<String, a> k;
    public Long l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchLepus$SyncCallback;", "", "fail", "", com.bytedance.android.ec.core.event.a.KEY_RESULT, "", "success", "isFromNetEnd", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface SyncCallback {
        void fail(String r1);

        void success(String r1, boolean r10);
    }

    public static final class a {
        public SyncCallback a;
        public o b;
        public q c;
        public JSONObject d;

        public a() {
            this(null, 15);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L14;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            SyncCallback r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            o r12 = this.b;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            q r15 = this.c;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            JSONObject r18 = this.d;
            if (r18 == null) goto L18;
            r1 = r18.hashCode();
        L18:
            return r17 + r1;
        L13:
            r16 = 0;
            goto L14
        L9:
            r13 = 0;
            goto L10
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "SyncApiKeyRequestModel(prefetchSyncCallback=" + this.a + ", prefetchingSync=" + this.b + ", prefetchTimingSync=" + this.c + ", extraInfo=" + this.d + ")";
        }

        public a(o r10, int r11) {
            if ((r11 & 2) == 0) goto L5;
            r10 = null;
        L5:
            this.a = null;
            this.b = r10;
            this.c = null;
            this.d = null;
        }
    }

    public NativePrefetchLepus() {
        this.k = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final void y() {
        super.y();
        this.l = Long.valueOf(System.currentTimeMillis());
    }

    private final q r(String r10) {
        a r11 = (a) ((LinkedHashMap) this.k).get(r10);
        if (r11 == null) goto L6;
        q r12 = r11.c;
        if (r12 == null) goto L6;
    L7:
        r12.g(this.l);
        r12.h(this.l);
        return r12;
    L6:
        r12 = new q(0);
        goto L7
    }

    public final synchronized void I(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L6
        this.k.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void i(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L6
        super.i(r10);     // Catch: Throwable -> L6
        I(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final void t(String r10) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        super.t(r10);
        this.k.put(r10, new a(new o("", AIPackageNetworkResponse.CODE_UNKNOWN, ""), 13));
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void w(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L8
        super.w(r10);     // Catch: Throwable -> L8
        q r0 = r(r10);     // Catch: Throwable -> L8
        r0.f(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L8
        a r11 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        r11.c = r0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void x(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L8
        super.x(r10);     // Catch: Throwable -> L8
        q r0 = r(r10);     // Catch: Throwable -> L8
        r0.i(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L8
        a r11 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        r11.c = r0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void A(String r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L27
        if (r10 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        ConcurrentHashMap<String, NativePrefetch> r0 = NativePrefetchUtil.a;     // Catch: Throwable -> L27
        if (StringsKt.isBlank(r10) == false) goto L10;
        boolean r1 = true;
    L11:
        NativePrefetch r12 = null;
        if (r1 == false) goto L14;
        NativePrefetch r13 = null;
    L16:
        if ((r13 instanceof NativePrefetchLepus) == false) goto L19;
        r12 = r13;
    L19:
        NativePrefetchLepus r14 = (NativePrefetchLepus) r12;     // Catch: Throwable -> L27
        if (r14 == null) goto L24;
        a r15 = (a) ((LinkedHashMap) r14.k).get(r11);     // Catch: Throwable -> L27
        if (r15 == null) goto L24;
        this.k.put(r11, r15);     // Catch: Throwable -> L27
    L24:
        super.A(r10, r11);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L14:
        r13 = NativePrefetchUtil.a.get(r10);     // Catch: Throwable -> L27
        goto L16
    L10:
        r1 = false;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void B(String r10, int r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L18
        super.B(r10, r11);     // Catch: Throwable -> L18
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        a r1 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        a r12 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L14
        if (r12 == null) goto L10;
        JSONObject r13 = r12.d;     // Catch: Throwable -> L14
        if (r13 == null) goto L10;
    L11:
        r13.putOpt("na_prefetch_config_from", Integer.valueOf(r11));     // Catch: Throwable -> L14
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r1.d = r13;     // Catch: Throwable -> L14
    L10:
        r13 = new JSONObject();     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L18
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void C(String r10, JSONObject r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L8
        super.C(r10, r11);     // Catch: Throwable -> L8
        q r0 = r(r10);     // Catch: Throwable -> L8
        r0.a = r11;     // Catch: Throwable -> L8
        a r12 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r12.c = r0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void D(o r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "data");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L24
        a r0 = (a) ((LinkedHashMap) this.k).get(r11);     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        SyncCallback r1 = r0.a;     // Catch: Throwable -> L24
    L7:
        if (r1 != null) goto L11;
        a r12 = (a) ((LinkedHashMap) this.k).get(r11);     // Catch: Throwable -> L24
        if (r12 == null) goto L18;
        r12.b = r10;     // Catch: Throwable -> L24
    L18:
        a r13 = (a) ((LinkedHashMap) this.k).get(r11);     // Catch: Throwable -> L24
        if (r13 == null) goto L21;
        r13.a = null;     // Catch: Throwable -> L24
    L21:
        super.D(r10, r11);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L11:
        int r14 = r10.b;     // Catch: Throwable -> L24
        if (r14 != 1) goto L14;
        r1.success(r10.a, true);     // Catch: Throwable -> L24
        goto L18
    L14:
        if (r14 != 2) goto L18;
        r1.fail("");     // Catch: Throwable -> L24
        goto L18
    L6:
        r1 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch
    public final synchronized void E(String r10, JSONObject r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L26
        if (r11 != null) goto L31;
        monitor-exit(this);
        return;
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        a r1 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L21
        if (r1 == null) goto L19;
        a r12 = (a) ((LinkedHashMap) this.k).get(r10);     // Catch: Throwable -> L21
        if (r12 == null) goto L13;
        JSONObject r13 = r12.d;     // Catch: Throwable -> L21
        if (r13 == null) goto L13;
    L14:
        Iterator<String> r14 = r11.keys();     // Catch: Throwable -> L21
    L16:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();     // Catch: Throwable -> L21
        r13.putOpt(r15, r11.opt(r15));     // Catch: Throwable -> L21
        goto L16
    L18:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r1.d = r13;     // Catch: Throwable -> L21
    L13:
        r13 = new JSONObject();     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        super.E(r10, r11);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L26
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
