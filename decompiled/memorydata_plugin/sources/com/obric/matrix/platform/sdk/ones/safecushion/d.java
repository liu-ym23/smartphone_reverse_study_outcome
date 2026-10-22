package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.matrix.platform.sdk.ones.safecushion.ui.CushionActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0012\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u000e\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0004J$\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u0010+\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020\u001cJ\b\u0010-\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0002J\u0006\u0010\u0015\u001a\u00020\u001cJ\"\u00101\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010)J\u0006\u00102\u001a\u00020\u001cJ\b\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0006H\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0006H\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020\u0006H\u0002J?\u0010;\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042%\b\u0002\u0010.\u001a\u001f\u0012\u0013\u0012\u001100¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u0006\u0018\u00010=H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006A"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/SafeCushionCrashCounter;", "", "()V", "TAG", "", "alreadyStartedSafeMode", "", "currentCrashCount", "", "flagHelper", "Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper;", "haveDealtWithCrash", "increaseCrashCountSuccess", "isMainProcess", "()Z", "isMainProcess$delegate", "Lkotlin/Lazy;", "isSafeProcess", "isSafeProcess$delegate", "lastCrashCount", "lastSupposeCrashCount", "normalStart", "safeModeCrashThreshold", "getSafeModeCrashThreshold", "()I", "canClearCrash", "fileNamePrefix", "checkCrash", "", "clearCrashInfo", "deleteTempCrashFile", "clearSupposeCrashCount", "deleteCrashFile", "deleteSupposeCrashFiles", "exitProcess", "getCrashCountFromFile", "crashFileNamePrefix", "handleCrash", "crashType", "crashMsg", "thread", "Ljava/lang/Thread;", "increaseCrashCount", "increaseSupposeCrashCount", "initSafeMode", "isHeadlessMode", "needInterrupt", "file", "Ljava/io/File;", "onCrash", "onNpthInitFinish", "performCheckCrash", "performExitProcess", "needExit", "performOpenAppStore", "isLaunchCheckCrash", "startActivityIfNeed", "startHeadlessRepair", "startSafeMode", "updateCrashCount", "crashFileName", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "crashFile", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f8134b;
    private static int c;
    private static int d;
    private static boolean e;
    private static volatile boolean f;
    private static boolean g;
    private static volatile boolean h;
    private static final com.obric.matrix.platform.sdk.ones.safecushion.a.b i = null;
    private static final Lazy j = null;
    private static final Lazy k = null;

    static {
        d r0 = new d();
        f8133a = r0;
        f8134b = -1;
        c = -1;
        d = -1;
        i = new com.obric.matrix.platform.sdk.ones.safecushion.a.b();
        j = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(SafeCushionCrashCounter$isMainProcess$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(SafeCushionCrashCounter$isSafeProcess$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        if (r0.b() == false) goto L5;
        f8134b = r0.a("supposeCrash");
        int r1 = r0.a("crashInfo");
        d = r1;
        c = r1;
        r0.d();
    L5:
        r0.a();
    }

    private d() {
    }

    private final void a(boolean r11) {
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "startActivityIfNeed isLaunchCheckCrash:" + r11, null, 4, null);
        com.obric.matrix.platform.sdk.ones.safecushion.a.b r0 = i;
        Pair<Boolean, Long> r4 = r0.b();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L23;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "lastStartSafeModeInfo success", null, 4, null);
        if ((System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r4.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue()) > 2000) goto L8;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "lastStartSafeModeInfo success,but time is near,return", null, 4, null);
        return;
    L8:
        Pair<String, Long> r5 = r0.c();
        Pair<String, Long> r6 = r0.d();
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "lastStartSafeModeProcess success,lastStartSafeModeProcess:" + ((String) ZeusTransformUtils.preCheckCast(r5.getFirst(), String.class, "com.obric.memorydata.plugin")) + ",lastSafeModeFlag:" + ((String) ZeusTransformUtils.preCheckCast(r6.getFirst(), String.class, "com.obric.memorydata.plugin")), null, 4, null);
        if (r5.getFirst() != null) goto L11;
        String r1 = "lastStartSafeModeProcess fail";
    L22:
        Log.i("zhoupeng.725999", r1);
        b(r11);
        return;
    L11:
        if (r6.getFirst() != null) goto L17;
        long r2 = System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r5.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r2 > 3000) goto L15;
        Log.i("zhoupeng.725999", "wait for start Activity,duration:" + r2);
        return;
    L15:
        r1 = "start Activity failed,duration:" + r2;
        goto L22
    L17:
        if (r0.f() == false) goto L19;
        r1 = "upgradeFinish,openAppStore";
        goto L22
    L19:
        if (r11 == true) goto L26;
        Log.i("zhoupeng.725999", "!isLaunchCheckCrash,startSafeMode");
        i();
        return;
    L26:
        return;
    L23:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "not startSafeModeInfo,startSafeMode now", null, 4, null);
        g = true;
        i();
        c(r11);
    }

    public static final /* synthetic */ boolean a(d r0, File r1) {
        return r0.a(r1);
    }

    static /* synthetic */ boolean a(d r1, String r2, String r3, Function1 r4, int r5, Object r6) {
        Function1<? super File, Boolean> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(SafeCushionCrashCounter$updateCrashCount$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r2, r3, r7);
    }

    private final boolean a(File r8) {
        String r7 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "file.name");
        List r9 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r9.size() <= 2) goto L8;
        long r10 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r9.get(2), String.class, "com.obric.memorydata.plugin"));
        if ((System.currentTimeMillis() - r10) >= 1000) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    private final boolean a(String r12, String r13, Function1<? super File, Boolean> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        File r2 = com.obric.matrix.platform.sdk.ones.safecushion.a.c.f8128a.a();     // Catch: Exception -> L38
        File r3 = new File(r2, r13);     // Catch: Exception -> L38
        File[] r4 = r2.listFiles();     // Catch: Exception -> L38
        StringBuilder r16 = new StringBuilder().append("updateCrashCount crashFileName:").append(r13).append(",containFile:");     // Catch: Exception -> L38
        if (r4 != null) goto L6;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        boolean r6 = true;
    L16:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", r16.append(r6).toString(), null, 4, null);     // Catch: Exception -> L38
        if (r4 == null) goto L36;
        int r17 = r4.length;     // Catch: Exception -> L38
        int r7 = 0;
    L19:
        if (r7 >= r17) goto L36;
        File r8 = r4[r7];     // Catch: Exception -> L38
        String r9 = r8.getName();     // Catch: Exception -> L38
        Intrinsics.checkNotNullExpressionValue(r9, "it.name");     // Catch: Exception -> L38
        if (StringsKt.startsWith$default(r9, r12, false, 2, null) == true) goto L23;
        r7 = r7 + 1;     // Catch: Exception -> L38
        goto L19
    L23:
        if (r15 == null) goto L27;
        Intrinsics.checkNotNullExpressionValue(r8, "it");     // Catch: Exception -> L38
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.invoke(r8), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == false) goto L32;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "updateCrashCount: interrupt", null, 4, null);     // Catch: Exception -> L38
        return false;
    L32:
        if (r8.renameTo(r3) == true) goto L34;
        com.obric.matrix.platform.sdk.ones.safecushion.a.c r11 = com.obric.matrix.platform.sdk.ones.safecushion.a.c.f8128a;     // Catch: Exception -> L38
        Intrinsics.checkNotNullExpressionValue(r8, "it");     // Catch: Exception -> L38
        r11.a(r8);     // Catch: Exception -> L38
        r3.createNewFile();     // Catch: Exception -> L38
    L34:
        return true;
    L27:
        r18 = false;
    L36:
        r3.createNewFile();     // Catch: Exception -> L38
        return true;
    L15:
        r6 = false;
        goto L16
    L6:
        if (r4.length != 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L12;
        r5 = false;
        goto L13
    L8:
        r10 = false;
    L38:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private final void b(String r10) {
        if (b() == false) goto L8;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "increaseCrashCount currentCrashCount:" + d, null, 4, null);
        if (a(this, "crashInfo", "crashInfo-" + (d + 1) + '-' + System.currentTimeMillis() + '-' + r10, null, 4, null) == false) goto L9;
        e = true;
        d++;
        return;
    L9:
        return;
    }

    private final void b(String r3, String r4, Thread r5) {
        boolean r6 = !com.obric.matrix.platform.sdk.ones.safecushion.a.a.f8125a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.f8131a.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "performStartSafeMode currentCrashCount:" + d + ",isForeground:" + r6, null, 4, null);
        if (d < f()) goto L5;
    L6:
        if (r6 == true) goto L8;
        return;
    L8:
        if (g() == false) goto L10;
        i();
        return;
    L10:
        a(false);
        return;
    L5:
        if (f8134b > f()) goto L6;
    }

    private final void b(boolean r5) {
        if (g == true) goto L6;
        h = true;
        a.f8123a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.f8131a.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        c(r5);
        return;
    }

    private final boolean b() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(j.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final void c(boolean r1) {
        if (r1 == false) goto L5;
        h();
        return;
    }

    private final boolean c() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(k.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final void d() {
        if (b() == false) goto L6;
        e();
        return;
    }

    private final void e() {
        if (b() == true) goto L5;
        return;
    L5:
        if (c >= f()) goto L9;
        if (f8134b >= 4) goto L9;
        return;
    L9:
        if (g() == false) goto L11;
        i();
        return;
    L11:
        a(true);
    }

    private final int f() {
        int r0 = c.f8131a.a().a().b();
        if (r0 > 0) goto L7;
        return 3;
    L7:
        return r0;
    }

    private final boolean g() {
        if (c.f8131a.a().a().c() != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void h() {
        System.exit(1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeModeCounter", "exitProcess: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean i() {
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "startSafeMode", null, 4, null);
        h = true;
        i.a();
        if (g() == true) goto L5;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.f8131a.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        Intent r3 = new Intent(r5, CushionActivity.class);     // Catch: Exception -> L8
        r3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Exception -> L8
        ZeusTransformUtils.startActivity(r5, r3, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeModeCounter", "openSafeMode: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L5:
        return j();
    }

    private final boolean j() {
        List<com.obric.matrix.platform.sdk.ones.safecushion.repair.a> r1 = c.f8131a.a().a().a(d);     // Catch: Exception -> L16
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "startHeadlessRepair repairCount:" + r1.size() + ",crashCount:" + d, null, 4, null);     // Catch: Exception -> L16
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L16
    L5:
        if (r2.hasNext() == false) goto L11;
        ((com.obric.matrix.platform.sdk.ones.safecushion.repair.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.matrix.platform.sdk.ones.safecushion.repair.a.class, "com.obric.memorydata.plugin")).run();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeModeCounter", "startHeadlessRepair: repair error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16
        goto L5
    L11:
        com.obric.matrix.platform.sdk.ones.safecushion.a.b r3 = i;     // Catch: Exception -> L16
        String r4 = r3.e();     // Catch: Exception -> L16
        if (r4 != null) goto L14;
        r4 = "repair";
    L14:
        r3.a(r4, "finish");     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeModeCounter", "startHeadlessRepair: error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    public final int a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "crashFileNamePrefix");
        File r0 = com.obric.matrix.platform.sdk.ones.safecushion.a.c.f8128a.a(r8);
        if (r0 == null) goto L14;
        String r1 = r0.getName();     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r1, "it.name");     // Catch: Exception -> L8
        List r2 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L8
        if (r2.size() <= 1) goto L15;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.get(1), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", r8 + " getCrashCount: " + r7, null, 4, null);     // Catch: Exception -> L8
        return Integer.parseInt(r7);
    L15:
        return 0;
    L8:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L14:
        return 0;
    }

    public final void a() {
        if (c() == false) goto L13;
        com.obric.matrix.platform.sdk.ones.safecushion.a.b r2 = i;
        String r0 = r2.e();
        if (r2.c(r0) == true) goto L7;
        return;
    L7:
        if (r0 != null) goto L10;
        r2.a("repair");
        return;
    L10:
        if (Intrinsics.areEqual(r0, "repair") == false) goto L16;
        r2.a("upgrade");
        return;
    L16:
        return;
    }

    public final synchronized void a(String r5, String r6, Thread r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "crashType");     // Catch: Throwable -> L27
        String r3 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "onCrash:" + r5 + ",thread:" + r7 + ",crashMsg:" + r6, null, 4, null);     // Catch: Throwable -> L27
        if (b() == true) goto L9;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "onCrash isn't main process", null, 4, null);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L9:
        if (h == false) goto L14;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "onCrash haveDealtWithCrash", null, 4, null);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L14:
        if (f == false) goto L19;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeCounter", "onCrash already normalStart", null, 4, null);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L19:
        if (e == true) goto L21;
        b(r5);     // Catch: Throwable -> L27
    L21:
        com.obric.matrix.platform.sdk.ones.safecushion.a.c r0 = com.obric.matrix.platform.sdk.ones.safecushion.a.c.f8128a;     // Catch: Throwable -> L27
        if (r7 == null) goto L24;
        r3 = r7.toString();     // Catch: Throwable -> L27
    L24:
        r0.a(r5, r6, r3, d);     // Catch: Throwable -> L27
        b(r5, r6, r7);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    }
}
