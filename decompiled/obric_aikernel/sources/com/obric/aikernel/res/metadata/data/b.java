package com.obric.aikernel.res.metadata.data;

import android.net.Uri;
import android.system.Os;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.LoraConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import com.obric.aikernel.res.task.StorageCleanerDaemon;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f5079l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f5082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f5087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final File f5088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final File f5089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final File f5090k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final DistConfig a(String r10, String r11, File r12) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "absolutePath");
            File r13 = new File(r12, "configuration.json");
            Object r14 = null;
            if (r13.exists() == true) goto L29;
            return null;
        L29:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L14
            FileReader r16 = new FileReader(r13);     // Catch: Throwable -> L14
            k r17 = (k) new com.google.gson.d().i(r16, k.class);     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L14
            Intrinsics.checkNotNullExpressionValue(r17, "FileReader(configFile).u…s.java)\n                }");     // Catch: Throwable -> L14
            Object r18 = Result.m32constructorimpl(new DistConfig(r10, r11, r17));     // Catch: Throwable -> L14
        L16:
            Throwable r19 = Result.m35exceptionOrNullimpl(r18);
            if (r19 == null) goto L20;
            r13.delete();
            com.obric.aikernel.runtime.utils.d.f5417a.f(PackageResourceManager.TAG, this + " getConfig delete corrupted config file! " + ExceptionsKt.stackTraceToString(r19));
        L20:
            if (Result.m38isFailureimpl(r18) == true) goto L24;
            r14 = r18;
        L24:
            return (DistConfig) r14;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L16
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Iterator, kotlin.collections.IntIterator] */
        public final UpdateTaskConfig b(String r10, String r11, PackageResourceManager.PresmConfig r12) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "config");
            if (Intrinsics.areEqual(r10, "package") == false) goto L26;
            String[] r13 = new File(new AIPackage(r11, "", r12).o()).list();
            if (r13 != null) goto L7;
            return null;
        L7:
            if (r13.length != 0) goto L9;
            boolean r14 = true;
        L10:
            if (r14 == false) goto L12;
            String r15 = null;
        L21:
            if (r15 == null) goto L60;
            DistConfig r16 = new AIPackage(r11, r15, r12).s();
            if (r16 != null) goto L62;
            return null;
        L62:
            return new com.obric.aikernel.res.metadata.config.e(r11, r16.f(), r12);
        L60:
            return null;
        L12:
            r15 = r13[0];
            int r17 = ArraysKt.getLastIndex(r13);
            if (r17 == 0) goto L21;
            AIPackage.a r18 = AIPackage.f5062u;
            Intrinsics.checkNotNullExpressionValue(r15, "it");
            int r19 = r18.b(r15);
            ?? r20 = new IntRange(1, r17).iterator2();
        L17:
            if (r20.hasNext() == false) goto L21;
            String r21 = r13[r20.nextInt()];
            AIPackage.a r22 = AIPackage.f5062u;
            Intrinsics.checkNotNullExpressionValue(r21, "it");
            int r23 = r22.b(r21);
            if (r19 >= r23) goto L17;
            r15 = r21;
            r19 = r23;
            goto L17
        L9:
            r14 = false;
            goto L10
        L26:
            if (Intrinsics.areEqual(r10, "lora") == false) goto L63;
            String[] r24 = new File(new Lora(r11, "", r12).o()).list();
            if (r24 != null) goto L30;
            return null;
        L30:
            if (r24.length != 0) goto L32;
            boolean r25 = true;
        L33:
            if (r25 == false) goto L35;
            String r26 = null;
        L44:
            if (r26 == null) goto L65;
            DistConfig r27 = new Lora(r11, r26, r12).s();
            if (r27 != null) goto L48;
            return null;
        L48:
            return new LoraConfig(r11, r27.f());
        L65:
            return null;
        L35:
            r26 = r24[0];
            int r28 = ArraysKt.getLastIndex(r24);
            if (r28 == 0) goto L44;
            AIPackage.a r29 = AIPackage.f5062u;
            Intrinsics.checkNotNullExpressionValue(r26, "it");
            int r30 = r29.b(r26);
            ?? r31 = new IntRange(1, r28).iterator2();
        L40:
            if (r31.hasNext() == false) goto L44;
            String r32 = r24[r31.nextInt()];
            AIPackage.a r33 = AIPackage.f5062u;
            Intrinsics.checkNotNullExpressionValue(r32, "it");
            int r34 = r33.b(r32);
            if (r30 >= r34) goto L40;
            r26 = r32;
            r30 = r34;
            goto L40
        L32:
            r25 = false;
            goto L33
        L63:
            return null;
        }

        public final List<b> c(List<String> r10, PackageResourceManager.PresmConfig r11) {
            Intrinsics.checkNotNullParameter(r10, "infos");
            Intrinsics.checkNotNullParameter(r11, "config");
            ArrayList r12 = new ArrayList();
            Iterator<T> r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L29;
            List r14 = StringsKt.split$default((String) r13.next(), new String[]{"@"}, false, 0, 6, null);
            String r15 = (String) CollectionsKt.firstOrNull(r14);
            if (r15 != null) goto L8;
        L26:
            b r16 = null;
        L27:
            if (r16 == null) goto L4;
            r12.add(r16);
            goto L4
        L8:
            switch(r15.hashCode()) {
                case -807062458: goto L23;
                case 107141: goto L19;
                case 3327730: goto L15;
                case 104069929: goto L11;
                default: goto L26;
            };
        L11:
            if (r15.equals("model") == false) goto L26;
            r16 = new AIModel((String) r14.get(1), (String) r14.get(2), r11);
            goto L27
        L15:
            if (r15.equals("lora") == false) goto L26;
            r16 = new Lora((String) r14.get(1), (String) r14.get(2), r11);
            goto L27
        L19:
            if (r15.equals("lib") == false) goto L26;
            r16 = new e((String) r14.get(1), (String) r14.get(2), r11);
            goto L27
        L23:
            if (r15.equals("package") == false) goto L26;
            r16 = new AIPackage((String) r14.get(1), (String) r14.get(2), r11);
            goto L27
        L29:
            return r12;
        }

        public final void d(String r10, Map<String, Long> r11) {
            Intrinsics.checkNotNullParameter(r10, "path");
            Intrinsics.checkNotNullParameter(r11, "checkInfo");
            File r12 = new File(r10, "checker_v2.json");
            com.obric.aikernel.res.utils.a r13 = com.obric.aikernel.res.utils.a.f5222a;
            k r14 = new k();
            Iterator<Map.Entry<String, Long>> r15 = r11.entrySet().iterator();
        L4:
            if (r15.hasNext() == false) goto L6;
            Map.Entry<String, Long> r16 = r15.next();
            String r17 = r16.getKey();
            long r18 = r16.getValue().longValue();
            k r19 = new k();
            r19.o("size", Long.valueOf(r18));
            Unit r20 = Unit.INSTANCE;
            r14.m(r17, r19);
            goto L4
        L6:
            Unit r21 = Unit.INSTANCE;
            String r22 = r14.toString();
            Intrinsics.checkNotNullExpressionValue(r22, "JsonObject().apply {\n   …             }.toString()");
            r13.k(r12, r22);
        }
    }

    static {
        f5079l = new a(null);
    }

    public b(String r10, String r11, PackageResourceManager.PresmConfig r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        Intrinsics.checkNotNullParameter(r12, "cfg");
        this.f5080a = r10;
        this.f5081b = r11;
        this.f5082c = r12;
        this.f5083d = NetConst.NOT_ENCRYPT_VERISON_CODE;
        String r13 = B() + '/' + r10 + '/' + r11;
        this.f5084e = r13;
        String r14 = r12.getRootDir() + '/' + r13;
        this.f5085f = r14;
        this.f5086g = r12.getResRootDir() + '/' + r13;
        StringBuilder r15 = new StringBuilder();
        r15.append(r14);
        r15.append("/state");
        File r16 = new File(r15.toString());
        this.f5087h = r16;
        this.f5088i = new File(r16, "enable");
        this.f5089j = new File(r16, "reinstall");
        this.f5090k = new File(r14, "uri_link");
    }

    private final String C() {
        return this.f5085f + "/last_usage";
    }

    public static /* synthetic */ void M(b r10, long r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = System.currentTimeMillis();
    L6:
        r10.L(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loggerUsage");
    }

    private final void Y(DistConfig r10) {
        DistConfig r11 = s();
        if (r11 == null) goto L18;
        k r12 = r11.f();
        if (r12 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r10.h(), r11.h()) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r10.g(), r11.g()) == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r10.i(), r11.i()) == false) goto L22;
        String r13 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "curCfg.toString()");
        String r14 = r10.f().toString();
        Intrinsics.checkNotNullExpressionValue(r14, "updating.json.toString()");
        if ((!StringsKt.isBlank(r14)) == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r13, r14) == true) goto L24;
        com.obric.aikernel.runtime.utils.d r15 = com.obric.aikernel.runtime.utils.d.f5417a;
        r15.l(PackageResourceManager.TAG, "repairConfig " + this + " override not consist config by update");
        r15.c(PackageResourceManager.TAG, "repairConfig " + this + " Current: " + r13);
        r15.c(PackageResourceManager.TAG, "repairConfig " + this + " Updating: " + r14);
        c0(this, r10, false, 2, null);
        return;
    L24:
        return;
    L22:
        return;
    }

    public static /* synthetic */ boolean c(b r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L7;
        r11 = true;
    L7:
        return r10.b(r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkResource");
    }

    public static /* synthetic */ void c0(b r10, DistConfig r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        r10.b0(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveConfig");
    }

    public static /* synthetic */ boolean e(b r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L7;
        r11 = true;
    L7:
        return r10.d(r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkResourceFull");
    }

    private final boolean f(k r10) {
        Uri r11 = v();
        if (r11 == null) goto L5;
        String r12 = r11.getScheme();
    L7:
        if (Intrinsics.areEqual(r12, "file") == false) goto L22;
        File r13 = new File(r11.getPath());
        Set<Map.Entry<String, i>> r14 = r10.r();
        Intrinsics.checkNotNullExpressionValue(r14, "checkerConfig.entrySet()");
        Iterator<T> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L31;
        Map.Entry r16 = (Map.Entry) r15.next();
        Intrinsics.checkNotNullExpressionValue(r16, "(file, info)");
        String r17 = (String) r16.getKey();
        i r18 = (i) r16.getValue();
        File r19 = new File(r13, r17);
        if (r19.exists() == false) goto L21;
        long r20 = Os.stat(r19.getPath()).st_size;
        i r21 = r18.e().s("size");
        if (r21 == null) goto L10;
        Intrinsics.checkNotNullExpressionValue(r21, "get(\"size\")");
        long r22 = r21.g();
        if (r20 == r22) goto L10;
        throw new IllegalStateException(this + ' ' + new File(r13, r17).getPath() + " corrupted: size(" + r20 + '/' + r22 + ')');
    L21:
        throw new IllegalStateException(this + ' ' + r19.getPath() + " not exist!");
    L31:
        return true;
    L22:
        return true;
    L5:
        r12 = null;
        goto L7
    }

    private final boolean i() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(new File(this.f5085f))));     // Catch: Throwable -> L4
    L6:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L10;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "clean " + this + " failed " + r12);
    L10:
        if (Result.m38isFailureimpl(r11) == false) goto L13;
        r11 = null;
    L13:
        return Intrinsics.areEqual(r11, Boolean.TRUE);
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public abstract String A();

    public abstract String B();

    public final String D() {
        return this.f5081b;
    }

    public final String E() {
        if (Intrinsics.areEqual(this.f5081b, "debug") == false) goto L6;
        DistConfig r10 = s();
        Intrinsics.checkNotNull(r10);
        return com.obric.aikernel.res.metadata.config.a.c(r10.f(), "version_debug");
    L6:
        return this.f5081b;
    }

    public final boolean F() {
        return this.f5089j.exists();
    }

    protected void G(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        if (e(this, false, 1, null) == true) goto L9;
        com.obric.aikernel.runtime.utils.d r11 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r12 = new StringBuilder();
        r12.append("install: list absolutePath ");
        r12.append(this.f5085f);
        r12.append(" files: ");
        com.obric.aikernel.res.utils.a r13 = com.obric.aikernel.res.utils.a.f5222a;
        r12.append(r13.g(new File(this.f5085f)));
        r11.c(PackageResourceManager.TAG, r12.toString());
        if (Intrinsics.areEqual(this.f5085f, this.f5086g) == true) goto L8;
        r11.c(PackageResourceManager.TAG, "install: list resAbsolutePath " + this.f5086g + " files: " + r13.g(new File(this.f5086g)));
    L8:
        throw new IllegalStateException(this.f5080a + '@' + this.f5081b + " check resource failed!");
    }

    public boolean H() {
        return Z();
    }

    public final boolean I() {
        return new File(this.f5085f, "configuration.json").exists();
    }

    protected final boolean J(Uri r10, PackageResourceManager.PresmConfig r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "config");
        String r12 = r10.getScheme();
        if (r12 == null) goto L44;
        int r13 = r12.hashCode();
        if (r13 == (-1408207997)) goto L29;
        if (r13 == 3143036) goto L10;
        return false;
    L10:
        if (r12.equals("file") == false) goto L51;
        File r14 = new File(r10.getPath());
        if (r14.exists() == true) goto L15;
        return false;
    L15:
        if (r14.isFile() == true) goto L47;
        File[] r15 = r14.listFiles();
        if (r15 == null) goto L25;
        Intrinsics.checkNotNullExpressionValue(r15, "listFiles()");
        if (r15.length != 0) goto L21;
        boolean r16 = true;
    L23:
        if ((!r16) != true) goto L25;
        boolean r17 = true;
    L26:
        if (r17 == true) goto L47;
        return false;
    L21:
        r16 = false;
    L25:
        r17 = false;
    L47:
        return true;
    L51:
        return false;
    L29:
        if (r12.equals("assets") == false) goto L52;
        String r18 = r10.getPath();
        if (r18 == null) goto L48;
        String[] r19 = r11.getContext().getAssets().list(r18);
        if (r19 == null) goto L40;
        Intrinsics.checkNotNullExpressionValue(r19, "list(it)");
        if (r19.length != 0) goto L38;
        boolean r20 = true;
    L39:
        Boolean r21 = Boolean.valueOf(!r20);
    L41:
        if (r21 != null) goto L43;
        return false;
    L43:
        return r21.booleanValue();
    L38:
        r20 = false;
        goto L39
    L40:
        r21 = null;
        goto L41
    L48:
        return false;
    L52:
        return false;
    L44:
        return false;
    }

    public final boolean K(Uri r10) {
        boolean r11 = false;
        if (r10 == null) goto L8;
        if (J(r10, this.f5082c) == true) goto L8;
        r11 = true;
    L8:
        return !r11;
    }

    public void L(long r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        File r12 = new File(C());     // Catch: Throwable -> L13
        File r13 = r12.getParentFile();     // Catch: Throwable -> L13
        boolean r14 = false;
        if (r13 != null) goto L5;
    L7:
        if (r14 == false) goto L11;
        File r15 = r12.getParentFile();     // Catch: Throwable -> L13
        if (r15 == null) goto L11;
        r15.mkdirs();     // Catch: Throwable -> L13
    L11:
        FilesKt.writeText$default(r12, String.valueOf(r10), null, 2, null);     // Catch: Throwable -> L13
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L5:
        if (r13.exists() == true) goto L7;
        r14 = true;
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }

    public boolean N() {
        return StorageCleanerDaemon.f5102e.c(this.f5082c, C());
    }

    public final void O(File r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_TARGET);
        if (this.f5090k.exists() == true) goto L5;
    L7:
        File r11 = this.f5090k.getParentFile();
        if (r11 == null) goto L10;
        r11.mkdirs();
    L10:
        com.obric.aikernel.res.utils.a r12 = com.obric.aikernel.res.utils.a.f5222a;
        File r13 = this.f5090k;
        String r14 = Uri.fromFile(r10).toString();
        Intrinsics.checkNotNullExpressionValue(r14, "fromFile(target).toString()");
        r12.k(r13, r14);
        return;
    L5:
        if (this.f5090k.isDirectory() == false) goto L7;
        this.f5090k.delete();
        goto L7
    }

    public final void P(String r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_TARGET);
        O(new File(r10));
    }

    public final void Q() {
        if (this.f5089j.exists() == true) goto L6;
        U(CollectionsKt.listOf(this.f5089j));
        return;
    }

    protected final void R(List<? extends File> r10) {
        Intrinsics.checkNotNullParameter(r10, "flags");
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        File r12 = (File) r11.next();
        if (r12.exists() == false) goto L4;
        r12.delete();
        goto L4
    }

    protected void S() {
        l();
    }

    protected void T() {
    }

    protected final boolean U(List<? extends File> r10) {
        Intrinsics.checkNotNullParameter(r10, "flags");
        if (this.f5087h.isFile() == false) goto L6;
        this.f5087h.delete();
    L6:
        if (this.f5087h.exists() == true) goto L8;
        this.f5087h.mkdirs();
    L8:
        boolean r11 = true;
        Iterator<T> r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L16;
        File r13 = (File) r12.next();
        if (r13.exists() == true) goto L10;
        if (r13.createNewFile() == true) goto L10;
        r11 = false;
        goto L10
    L16:
        return r11;
    }

    protected DistConfig V() {
        return null;
    }

    public final boolean W(PrmContext r20, boolean r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r20, "ctx");
        boolean r10 = c.b(r22, F());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L16
        if (r21 == false) goto L7;
        boolean r12 = i();     // Catch: Throwable -> L16
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, PackageResourceManager.TAG, "performInstall: " + this + " clean current result: " + r12, 0, 4, null);     // Catch: Throwable -> L16
    L11:
        if (e0(r22) == false) goto L13;
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, PackageResourceManager.TAG, "performInstall: " + this + " prepareInstall", 0, 4, null);     // Catch: Throwable -> L16
        X();     // Catch: Throwable -> L16
    L14:
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, PackageResourceManager.TAG, "performInstall: " + this + " start install", 0, 4, null);     // Catch: Throwable -> L16
        G(r20);     // Catch: Throwable -> L16
        Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L22;
        S();
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "performInstall " + this.f5080a + '@' + this.f5081b + " failed by " + ExceptionsKt.stackTraceToString(r14));
    L22:
        if (Result.m39isSuccessimpl(r13) == false) goto L28;
        Unit r15 = (Unit) r13;
        T();
        if (r10 == true) goto L26;
        this.f5089j.delete();
    L26:
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, PackageResourceManager.TAG, "performInstall " + this.f5080a + '@' + this.f5081b + " succeed", 0, 4, null);
    L28:
        return Result.m39isSuccessimpl(r13);
    L13:
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, PackageResourceManager.TAG, "performInstall[override:" + r21 + "]: " + this + '@' + this.f5081b + " resource is installed.", 0, 4, null);     // Catch: Throwable -> L16
        goto L14
    L7:
        DistConfig r16 = V();     // Catch: Throwable -> L16
        if (r16 == null) goto L11;
        Y(r16);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    protected void X() {
    }

    public boolean Z() {
        if (a0() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f5088i.exists() == false) goto L7;
        return true;
    }

    public final boolean a(Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "md5");
        String r12 = r10.getScheme();
        if (r12 != null) goto L5;
        return true;
    L5:
        if (r12.hashCode() == 3143036) goto L8;
        return true;
    L8:
        if (r12.equals("file") == true) goto L10;
        return true;
    L10:
        if (tb.c.c(r11, new File(r10.getPath())) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public boolean a0() {
        if (this.f5087h.isDirectory() == false) goto L13;
        Uri r10 = v();
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L13;
        return true;
    L7:
        if (J(r10, this.f5082c) == true) goto L9;
        r11 = true;
    L13:
        return false;
    }

    public boolean b(boolean r10) {
        if (this.f5087h.isFile() == false) goto L5;
        this.f5087h.delete();
        throw new IllegalStateException(this + " state d illegal");
    L5:
        if (s() == null) goto L23;
        Uri r11 = v();
        boolean r12 = false;
        if (r11 != null) goto L9;
    L11:
        if (r12 == true) goto L21;
        if (this.f5082c.getAppConfig().getCheckPackageResource().invoke().booleanValue() == false) goto L19;
        k r13 = r();
        if (r13 == null) goto L18;
        f(r13);
        goto L19
    L18:
        throw new IllegalStateException("get checker_v2.json failed!");
    L19:
        return true;
    L21:
        throw new IllegalStateException(this.f5080a + '@' + this.f5081b + ' ' + v() + " missed!");
    L9:
        if (J(r11, this.f5082c) == true) goto L11;
        r12 = true;
        goto L11
    L23:
        throw new IllegalStateException(this + " missing config file!");
    }

    public final void b0(DistConfig r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        File r12 = new File(this.f5085f, "configuration.json");
        if (r11 == true) goto L5;
    L7:
        File r13 = r12.getParentFile();
        boolean r14 = false;
        if (r13 != null) goto L10;
    L12:
        if (r14 == false) goto L16;
        File r15 = r12.getParentFile();
        if (r15 == null) goto L16;
        r15.mkdirs();
    L16:
        r12.delete();
        com.obric.aikernel.res.utils.a r16 = com.obric.aikernel.res.utils.a.f5222a;
        String r17 = r10.f().toString();
        Intrinsics.checkNotNullExpressionValue(r17, "config.json.toString()");
        r16.k(r12, r17);
        return;
    L10:
        if (r13.exists() == true) goto L12;
        r14 = true;
        goto L12
    L5:
        if (r12.exists() == false) goto L7;
    }

    public boolean d(boolean r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        Object r12 = Result.m32constructorimpl(Boolean.valueOf(b(r10)));     // Catch: Throwable -> L4
    L6:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L9;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "checkResourceFull: " + r13);
    L9:
        Boolean r14 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r12) == false) goto L13;
        r12 = r14;
    L13:
        return ((Boolean) r12).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void d0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5083d = r10;
    }

    public boolean e0(boolean r10) {
        if (a0() == true) goto L5;
    L8:
        return true;
    L5:
        if (g(r10) == true) goto L8;
        return false;
    }

    public boolean f0() {
        com.obric.aikernel.runtime.utils.d.f5417a.i(PackageResourceManager.TAG, "uninstall " + this.f5080a + '@' + this.f5081b);
        File r10 = new File(this.f5085f);
        Uri r11 = v();
        Object r12 = null;
        if (r11 == null) goto L5;
        String r13 = r11.getScheme();
    L7:
        if (Intrinsics.areEqual(r13, "file") == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L23;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L16
        File r15 = new File(r11.getPath());     // Catch: Throwable -> L16
        if (r15.canWrite() == false) goto L14;
        FilesKt.deleteRecursively(r15);     // Catch: Throwable -> L16
    L14:
        Object r16 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L21;
        com.obric.aikernel.runtime.utils.d.f5417a.f(PackageResourceManager.TAG, "uninstall: clean innerRes " + r11.getPath() + " error: " + ExceptionsKt.stackTraceToString(r17));
    L21:
        Result.m31boximpl(r16);
    L16:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L23:
        if (r10.exists() == true) goto L38;
        return true;
    L38:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L26
        Object r20 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r10)));     // Catch: Throwable -> L26
    L28:
        Throwable r21 = Result.m35exceptionOrNullimpl(r20);
        if (r21 == null) goto L32;
        com.obric.aikernel.runtime.utils.d.f5417a.l(PackageResourceManager.TAG, "uninstall delete " + this + " failed " + r21);
    L32:
        if (Result.m38isFailureimpl(r20) == true) goto L42;
        r12 = r20;
    L42:
        return Intrinsics.areEqual(r12, Boolean.TRUE);
    L26:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L28
    L5:
        r13 = null;
        goto L7
    }

    public boolean g(boolean r10) {
        boolean r11 = F();
        boolean r12 = true;
        if (d(r10) == true) goto L5;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L15
        if (F() == true) goto L13;
        U(CollectionsKt.listOf(this.f5089j));     // Catch: Throwable -> L15
    L13:
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        if (c.a(r10, r11, r12) == false) goto L20;
        this.f5089j.delete();
    L20:
        return r12;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (this.f5082c.getAppConfig().getCheckPackageResource().invoke().booleanValue() == true) goto L7;
    L9:
        r12 = false;
        goto L18
    L7:
        if (r() != null) goto L9;
        goto L9
    }

    public final boolean h(Uri r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r12 = r10.getScheme();
        if (r12 != null) goto L5;
        return true;
    L5:
        if (r12.hashCode() == 3143036) goto L8;
        return true;
    L8:
        if (r12.equals("file") == true) goto L10;
        return true;
    L10:
        if (Os.stat(r10.getPath()).st_size == r11) goto L17;
        return false;
    L17:
        return true;
    }

    public final void j(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getScheme(), "file") == false) goto L6;
        new File(r10.getPath()).delete();
        com.obric.aikernel.runtime.utils.d.f5417a.g(PackageResourceManager.TAG, "delete res file: " + this.f5080a + '@' + this.f5081b + ": " + r10.getPath());
        return;
    }

    public final void k() {
        new File(this.f5085f, "configuration.json").delete();
    }

    public boolean l() {
        if (this.f5088i.exists() == true) goto L7;
        return true;
    L7:
        return this.f5088i.delete();
    }

    public boolean m() {
        if (this.f5088i.exists() == false) goto L5;
        return true;
    L5:
        return U(CollectionsKt.listOf(this.f5088i));
    }

    public final boolean n() {
        return g(false);
    }

    public final String o() {
        return this.f5085f;
    }

    public final File p() {
        return this.f5088i;
    }

    public final PackageResourceManager.PresmConfig q() {
        return this.f5082c;
    }

    public k r() {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
        File r12 = new File(this.f5085f, "checker_v2.json");     // Catch: Throwable -> L9
        if (r12.exists() == false) goto L6;
        k r13 = (k) new com.google.gson.d().k(FilesKt.readText$default(r12, null, 1, null), k.class);     // Catch: Throwable -> L9
    L7:
        Object r14 = Result.m32constructorimpl(r13);     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L15;
        com.obric.aikernel.runtime.utils.d.f5417a.f(PackageResourceManager.TAG, this + " checkResource delete corrupted checker file! " + ExceptionsKt.stackTraceToString(r15));
        new File(this.f5085f, "checker_v2.json").delete();
    L15:
        if (Result.m38isFailureimpl(r14) == true) goto L19;
        r10 = r14;
    L19:
        return (k) r10;
    L6:
        r13 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final DistConfig s() {
        File r10 = new File(this.f5085f, "configuration.json");
        Object r11 = null;
        if (r10.exists() == true) goto L25;
        return null;
    L25:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L14
        String r13 = A();     // Catch: Throwable -> L14
        String r14 = this.f5080a;     // Catch: Throwable -> L14
        FileReader r15 = new FileReader(r10);     // Catch: Throwable -> L14
        k r16 = (k) new com.google.gson.d().i(r15, k.class);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r16, "FileReader(configFile).u…class.java)\n            }");     // Catch: Throwable -> L14
        Object r17 = Result.m32constructorimpl(new DistConfig(r13, r14, r16));     // Catch: Throwable -> L14
    L16:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L20;
        r10.delete();
        com.obric.aikernel.runtime.utils.d.f5417a.f(PackageResourceManager.TAG, this + " getConfig delete corrupted config file! " + ExceptionsKt.stackTraceToString(r18));
    L20:
        if (Result.m38isFailureimpl(r17) == true) goto L24;
        r11 = r17;
    L24:
        return (DistConfig) r11;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final String t() {
        return this.f5083d;
    }

    public String toString() {
        return A() + ':' + this.f5080a + '@' + this.f5081b + '@' + this.f5083d;
    }

    public String u() {
        return "";
    }

    public Uri v() {
        if (this.f5090k.exists() == false) goto L6;
        return Uri.parse(FilesKt.readText$default(this.f5090k, null, 1, null));
    L6:
        return Uri.fromFile(new File(this.f5085f, this.f5080a));
    }

    public final String w() {
        return this.f5080a;
    }

    public final String x() {
        return this.f5086g;
    }

    public final Uri y(String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Uri r11 = v();
        if (r11 == null) goto L9;
        Uri.Builder r12 = r11.buildUpon();
        if (r12 == null) goto L9;
        Uri.Builder r13 = r12.appendPath(r10);
        if (r13 == null) goto L9;
        return r13.build();
    L9:
        return null;
    }

    protected final File z() {
        return this.f5087h;
    }
}
