package com.obric.aikernel.res.installer;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.d;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceStorageScanner implements com.obric.aikernel.res.installer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4997a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public DeviceStorageScanner(String r10) {
        Intrinsics.checkNotNullParameter(r10, "storagePath");
        this.f4997a = r10;
        new File(r10).mkdirs();
    }

    private final void d(final PrmContext r22) {
        File r10 = new File(this.f4997a + "/package");
        String[] r11 = r10.list();
        if (r11 == null) goto L24;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L34;
        final String r15 = r11[r13];
        File r14 = new File(r10, r15);
        String[] r16 = r14.list();
        if (r16 == null) goto L23;
        Intrinsics.checkNotNullExpressionValue(r16, "list()");
        int r17 = r16.length;
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L23;
        final String r19 = r16[r18];
        final File r20 = new File(r14, r19);
        File r21 = new File(r20, "configuration.json");
        if (r21.exists() == false) goto L22;
        FileReader r23 = new FileReader(r21);
        k r24 = (k) new d().i(r23, k.class);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r23, null);
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r19, "version");
        PrmContext.install$default(r22, "package", r15, r19, r24, false, false, new DeviceStorageScanner$installAIPackages$1$1$1(r15, r19, r22, r20), 48, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r23, th);
        throw th;
    L22:
        r18 = r18 + 1;
        r17 = r17;
        r14 = r14;
        r16 = r16;
    L23:
        r13 = r13 + 1;
        goto L5
    L34:
        return;
    }

    private final void e(final PrmContext r22) {
        File r10 = new File(this.f4997a + "/lib");
        String[] r11 = r10.list();
        if (r11 == null) goto L12;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L16;
        final String r15 = r11[r13];
        File r14 = new File(r10, r15);
        String[] r16 = r14.list();
        if (r16 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r16, "list()");
        int r17 = r16.length;
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L11;
        final String r19 = r16[r18];
        final File r20 = new File(r14, r19);
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r19, "version");
        PrmContext.install$default(r22, "lib", r15, r19, null, false, false, new DeviceStorageScanner$installLibs$1$1$1(r15, r19, r22, r20), 56, null);
        r18 = r18 + 1;
        r17 = r17;
        r14 = r14;
        r16 = r16;
    L11:
        r13 = r13 + 1;
        goto L5
    L16:
        return;
    }

    private final void f(final PrmContext r22) {
        File r10 = new File(this.f4997a + "/model");
        String[] r11 = r10.list();
        if (r11 == null) goto L12;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L16;
        final String r15 = r11[r13];
        File r14 = new File(r10, r15);
        String[] r16 = r14.list();
        if (r16 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r16, "list()");
        int r17 = r16.length;
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L11;
        final String r19 = r16[r18];
        final File r20 = new File(r14, r19);
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r19, "version");
        PrmContext.install$default(r22, "model", r15, r19, null, false, false, new DeviceStorageScanner$installModels$1$1$1(r15, r19, r22, r20), 56, null);
        r18 = r18 + 1;
        r17 = r17;
        r14 = r14;
        r16 = r16;
    L11:
        r13 = r13 + 1;
        goto L5
    L16:
        return;
    }

    @Override // com.obric.aikernel.res.installer.a
    public void a(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        e(r10);
        f(r10);
        d(r10);
    }

    @Override // com.obric.aikernel.res.installer.a
    public List<com.obric.aikernel.res.installer.a.b> b(PrmContext r10) {
        return com.obric.aikernel.res.installer.a.C0113a.c(this, r10);
    }

    @Override // com.obric.aikernel.res.installer.a
    public boolean c(PrmContext r10, String r11, String r12, String r13) {
        return com.obric.aikernel.res.installer.a.C0113a.a(this, r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.res.installer.a
    public String tag() {
        return "PResM-DeviceStorageScanner";
    }
}
