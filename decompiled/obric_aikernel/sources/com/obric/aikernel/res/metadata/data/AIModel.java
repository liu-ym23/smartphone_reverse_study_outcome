package com.obric.aikernel.res.metadata.data;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.config.DistConfig;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class AIModel extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f5059o = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f5060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile String f5061n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(k r10) {
            if (r10 == null) goto L16;
            k r11 = new k();
            i r12 = r10.s("hyper_param");
            if (r12 == null) goto L9;
            Intrinsics.checkNotNullExpressionValue(r12, "get(\"hyper_param\")");
            Set<Map.Entry<String, i>> r13 = ((k) new com.google.gson.d().k(r12.h(), k.class)).e().r();
            Intrinsics.checkNotNullExpressionValue(r13, "Gson().fromJson(arg.asSt…).asJsonObject.entrySet()");
            Iterator<T> r14 = r13.iterator();
        L7:
            if (r14.hasNext() == false) goto L9;
            Map.Entry r15 = (Map.Entry) r14.next();
            r11.m((String) r15.getKey(), (i) r15.getValue());
        L9:
            i r16 = r10.s("weight_files");
            if (r16 == null) goto L12;
            Intrinsics.checkNotNullExpressionValue(r16, "get(\"weight_files\")");
            r11.m("_weight_files", r16);
        L12:
            i r17 = r10.s("tokenizer_file");
            if (r17 == null) goto L15;
            Intrinsics.checkNotNullExpressionValue(r17, "get(\"tokenizer_file\")");
            r11.m("_tokenizer_file", r17);
        L15:
            String r18 = r11.toString();
        L17:
            if (r18 != null) goto L21;
            return "";
        L21:
            return r18;
        L16:
            r18 = null;
            goto L17
        }
    }

    static {
        f5059o = new a(null);
    }

    public AIModel(final String r10, final String r11, final PackageResourceManager.PresmConfig r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "config");
        super(r10, r11, r12);
        this.f5060m = LazyKt.lazy(new AIModel$isEncryptedPreset$2(r12, r10, r11));
    }

    private static final void g0(int r10, AIModel r11, Uri r12, String r13, String r14, String r15) {
        if (r10 > 0) goto L5;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "[Model] try checkResource " + r11 + " but leak size " + r10 + '.');
        return;
    L5:
        long r16 = SystemClock.elapsedRealtime();
        long r17 = r10;
        if (r11.h(r12, r17) != true) goto L9;
        com.obric.aikernel.runtime.utils.d.f5417a.c(PackageResourceManager.TAG, "[Model] check size pass (" + r15 + "): " + r11.w() + '@' + r11.D() + ": " + r12.getPath() + ' ' + r10 + ", cost " + (SystemClock.elapsedRealtime() - r16) + "ms");
        return;
    L9:
        d.f5091a.b(r13, r14, r17);
        throw new IllegalStateException(r11.w() + '@' + r11.D() + ": " + r12.getPath() + " size not match");
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String A() {
        return "model";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String B() {
        return "models";
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    protected void T() {
        super.T();
        u();
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean a0() {
        if (i0() == false) goto L11;
        if (I() == true) goto L7;
    L9:
        return false;
    L7:
        if (z().exists() == false) goto L9;
        return true;
    L11:
        return super.a0();
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean b(boolean r21) {
        DistConfig r10 = s();
        Intrinsics.checkNotNull(r10);
        Iterator<T> r11 = new com.obric.aikernel.res.metadata.config.d(r10.g(), r10.f()).d().iterator();
    L3:
        boolean r12 = true;
        if (r11.hasNext() == false) goto L52;
        com.obric.aikernel.res.metadata.config.b r13 = (com.obric.aikernel.res.metadata.config.b) r11.next();
        final Uri r14 = y(r13.o());
        if (K(r14) == false) goto L7;
        if (r13.v(q().getDecryptFeature()) == false) goto L16;
        int r15 = r13.r();
    L17:
        final int r16 = r15;
        if (r13.v(q().getDecryptFeature()) == false) goto L20;
        String r17 = r13.q();
    L21:
        final String r19 = r17;
        if (r14 == null) goto L51;
        final String r18 = r14.getPath();
        if (r18 == null) goto L51;
        Intrinsics.checkNotNullExpressionValue(r18, "pathUri?.path\n          …d resource uri $pathUri\")");
        if (r21 == true) goto L31;
        if (r16 <= 0) goto L31;
        if (d.f(d.f5091a, r18, r19, r16, 0, 8, null) == false) goto L31;
        boolean r20 = true;
    L32:
        if (r21 == true) goto L44;
        if (r20 == true) goto L44;
        if (r19.length() == 0) goto L39;
        r12 = false;
    L39:
        if (r12 == true) goto L40;
        String r110 = r18;
        if (((Boolean) d.f5091a.g(r110, new AIModel$checkResource$2$verifiedByCache$1(r16, r18, r19, this, r14))).booleanValue() == false) goto L3;
        String r22 = "cached md5";
    L49:
        g0(r16, this, r14, r110, r19, r22);
        goto L3
    L40:
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "[Model] try checkResource " + this + " but leak md5.");
    L44:
        r110 = r18;
        if (r20 == false) goto L47;
        String r23 = "cached md5";
    L48:
        r22 = r23;
        goto L49
    L47:
        r23 = "fast mode";
    L31:
        r20 = false;
    L51:
        throw new IllegalStateException(w() + '@' + D() + ": invalid resource uri " + r14);
    L20:
        r17 = r13.p();
        goto L21
    L16:
        r15 = r13.s();
        goto L17
    L7:
        StringBuilder r24 = new StringBuilder();
        r24.append(w());
        r24.append('@');
        r24.append(D());
        r24.append(": ");
        if (r14 == null) goto L10;
        String r25 = r14.getPath();
    L11:
        r24.append(r25);
        r24.append(" not exist");
        throw new IllegalStateException(r24.toString());
    L10:
        r25 = null;
        goto L11
    L52:
        return true;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public boolean d(boolean r10) {
        if (i0() == false) goto L9;
        if (q().getDecryptFeature().isPresetDecrypted(w(), D()) == true) goto L9;
        return true;
    L9:
        return super.d(r10);
    }

    public final void h0() {
        DistConfig r10 = s();
        Intrinsics.checkNotNull(r10);
        Iterator<T> r11 = new com.obric.aikernel.res.metadata.config.d(r10.g(), r10.f()).d().iterator();
    L4:
        if (r11.hasNext() == false) goto L24;
        com.obric.aikernel.res.metadata.config.b r12 = (com.obric.aikernel.res.metadata.config.b) r11.next();
        Uri r13 = y(r12.o());
        if (K(r13) == false) goto L4;
        if (r12.v(q().getDecryptFeature()) == false) goto L10;
        String r14 = r12.q();
    L11:
        boolean r15 = true;
        if (r14.length() != 0) goto L14;
        boolean r16 = true;
    L15:
        if (r16 == true) goto L4;
        if (r13 != null) goto L18;
    L20:
        r15 = false;
    L21:
        if (r15 == true) goto L4;
        if (r13 == null) goto L4;
        j(r13);
        goto L4
    L18:
        if (a(r13, r14) != true) goto L20;
    L14:
        r16 = false;
        goto L15
    L10:
        r14 = r12.p();
        goto L11
    }

    public final boolean i0() {
        return ((Boolean) this.f5060m.getValue()).booleanValue();
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public String u() {
        if (this.f5061n != null) goto L33;
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.f5061n != null) goto L27;
        DistConfig r10 = s();     // Catch: Throwable -> L30
        String r11 = null;
        if (r10 == null) goto L10;
        k r12 = r10.f();     // Catch: Throwable -> L30
    L11:
        if (r12 == null) goto L26;
        i r13 = r12.s("hyper_param");     // Catch: Throwable -> L30
        boolean r14 = true;
        if (r13 != null) goto L15;
    L17:
        r14 = false;
    L19:
        if (Boolean.valueOf(r14).booleanValue() == true) goto L22;
        r12 = null;
    L22:
        if (r12 == null) goto L26;
        i r15 = r12.s("hyper_param");     // Catch: Throwable -> L30
        if (r15 == null) goto L26;
        r11 = r15.h();     // Catch: Throwable -> L30
        goto L26
    L15:
        if (r13.l() != true) goto L17;
    L26:
        this.f5061n = r11;     // Catch: Throwable -> L30
        goto L27
    L10:
        r12 = null;
    L27:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
    L33:
        String r17 = this.f5061n;
        if (r17 != null) goto L39;
        return "{}";
    L39:
        return r17;
    }

    @Override // com.obric.aikernel.res.metadata.data.b
    public Uri v() {
        if (i0() == false) goto L6;
        return Uri.fromFile(new File(q().getDecryptFeature().e(w(), D())));
    L6:
        return super.v();
    }
}
