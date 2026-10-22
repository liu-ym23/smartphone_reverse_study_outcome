package com.obric.aikernel.res.installer;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aikernel/res/installer/DeviceStorageScanner;", "Lcom/obric/aikernel/res/installer/IInstaller;", "storagePath", "", "(Ljava/lang/String;)V", "installAIPackages", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "installAll", "installLibs", "installModels", LocationMonitorConst.TAG, "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6046b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/installer/DeviceStorageScanner$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6045a = new a(null);
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "storagePath");
        this.f6046b = r2;
        new File(r2).mkdirs();
    }

    private final void c(final PrmContext r21) {
        File r0 = new File(this.f6046b + "/package");
        String[] r1 = r0.list();
        if (r1 == null) goto L24;
        int r2 = r1.length;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L34;
        final String r15 = r1[r4];
        File r14 = new File(r0, r15);
        String[] r13 = r14.list();
        if (r13 == null) goto L23;
        Intrinsics.checkNotNullExpressionValue(r13, "list()");
        int r12 = r13.length;
        int r11 = 0;
    L9:
        if (r11 >= r12) goto L23;
        final String r8 = r13[r11];
        final File r5 = new File(r14, r8);
        File r6 = new File(r5, "configuration.json");
        if (r6.exists() == false) goto L22;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileReader(r6), Closeable.class, "com.obric.memorydata.plugin");
        JsonObject r3 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson((Reader) ZeusTransformUtils.preCheckCast((FileReader) ZeusTransformUtils.preCheckCast(r7, FileReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r7, null);
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r8, "version");
        PrmContext.install$default(r21, "package", r15, r8, r3, false, false, (Function1) ZeusTransformUtils.preCheckCast(new DeviceStorageScanner$installAIPackages$1$1$1(r15, r8, r21, r5), Function1.class, "com.obric.memorydata.plugin"), 48, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L22:
        r11 = r11 + 1;
        r12 = r12;
        r13 = r13;
        r14 = r14;
    L23:
        r4 = r4 + 1;
        goto L5
    L34:
        return;
    }

    private final void d(final PrmContext r21) {
        File r0 = new File(this.f6046b + "/model");
        String[] r1 = r0.list();
        if (r1 == null) goto L12;
        int r2 = r1.length;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L16;
        final String r15 = r1[r4];
        File r14 = new File(r0, r15);
        String[] r13 = r14.list();
        if (r13 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r13, "list()");
        int r12 = r13.length;
        int r11 = 0;
    L9:
        if (r11 >= r12) goto L11;
        final String r8 = r13[r11];
        final File r5 = new File(r14, r8);
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r8, "version");
        PrmContext.install$default(r21, "model", r15, r8, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new DeviceStorageScanner$installModels$1$1$1(r15, r8, r21, r5), Function1.class, "com.obric.memorydata.plugin"), 56, null);
        r11 = r11 + 1;
        r13 = r13;
        r12 = r12;
        r14 = r14;
    L11:
        r4 = r4 + 1;
        goto L5
    L16:
        return;
    }

    private final void e(final PrmContext r21) {
        File r0 = new File(this.f6046b + "/lib");
        String[] r1 = r0.list();
        if (r1 == null) goto L12;
        int r2 = r1.length;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L16;
        final String r15 = r1[r4];
        File r14 = new File(r0, r15);
        String[] r13 = r14.list();
        if (r13 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r13, "list()");
        int r12 = r13.length;
        int r11 = 0;
    L9:
        if (r11 >= r12) goto L11;
        final String r8 = r13[r11];
        final File r5 = new File(r14, r8);
        Intrinsics.checkNotNullExpressionValue(r15, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r8, "version");
        PrmContext.install$default(r21, "lib", r15, r8, null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new DeviceStorageScanner$installLibs$1$1$1(r15, r8, r21, r5), Function1.class, "com.obric.memorydata.plugin"), 56, null);
        r11 = r11 + 1;
        r13 = r13;
        r12 = r12;
        r14 = r14;
    L11:
        r4 = r4 + 1;
        goto L5
    L16:
        return;
    }

    @Override // com.obric.aikernel.res.installer.d
    public String a() {
        return "PResM-DeviceStorageScanner";
    }

    @Override // com.obric.aikernel.res.installer.d
    public void a(PrmContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        e(r2);
        d(r2);
        c(r2);
    }

    @Override // com.obric.aikernel.res.installer.d
    public boolean a(PrmContext r1, String r2, String r3, String r4) {
        return d.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.obric.aikernel.res.installer.d
    public List<Object> b(PrmContext r1) {
        return d.a.b(this, r1);
    }
}
