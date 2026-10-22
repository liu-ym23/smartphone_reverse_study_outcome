package com.obric.memorydata.utils;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0016H\u0007J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0015\u0010\u0018¨\u0006!"}, d2 = {"Lcom/obric/memorydata/utils/RomVersionHelper;", "", "<init>", "()V", "TAG", "", "ROM_VERSION_VOLUME_KEY_SHORTCUT", "", "OTA_KEYS", "", "romFullOtaString", "getRomFullOtaString$annotations", "getRomFullOtaString", "()Ljava/lang/String;", "romVersionName", "getRomVersionName$annotations", "getRomVersionName", "romVersion", "getRomVersion$annotations", "getRomVersion", "()J", "isVolumeKeyShortcutSupported", "", "isVolumeKeyShortcutSupported$annotations", "()Z", "hasContextAwarenessEntry", "readFullOtaString", "extractVersionName", "full", "parseRomVersion", ActivityLifecycle.NAME, "safeGetSystemProperty", "key", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ar f13177a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f13178b = null;
    private static final String c = null;
    private static final String d = null;
    private static final long e = 0;
    private static final boolean f = false;

    static {
        ar r0 = new ar();
        f13177a = r0;
        f13178b = CollectionsKt.listOf(new String[]{"ro.os.ota.version", "ro.system_ext.ota.version", "persist.sys.monitor.ota", "ro.build.version.incremental", "ro.build.display.id"});
        String r1 = r0.d();
        c = r1;
        String r2 = r0.a(r1);
        d = r2;
        long r3 = r0.b(r2);
        e = r3;
        if (r3 < 2003000000) goto L5;
        boolean r4 = true;
    L6:
        f = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }

    private ar() {
    }

    public static final String a() {
        return d;
    }

    private final String a(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (r8 == false) goto L12;
        return "";
    L12:
        String r5 = null;
        MatchResult r9 = Regex.find$default(new Regex("^(\\d+(?:\\.\\d+){1,3})"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r9 == null) goto L17;
        List<String> r10 = r9.getGroupValues();
        if (r10 == null) goto L17;
        r5 = (String) ZeusTransformUtils.preCheckCast(r10.get(1), String.class, "com.obric.memorydata.plugin");
    L17:
        if (r5 != null) goto L20;
        return "";
    L20:
        return r5;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r8 = false;
        goto L10
    }

    private final long b(String r14) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r13 != null) goto L5;
    L8:
        boolean r15 = true;
    L10:
        if (r15 == false) goto L28;
        Log.w("RomVersionHelper", "parseRomVersion: empty version name, return 0");
        return 0;
    L28:
        List r16 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L25
        long r5 = 0;
    L15:
        if (r1 >= 4) goto L33;
        String r17 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r16, r1), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        if (r17 == null) goto L22;
        Long r18 = StringsKt.toLongOrNull(r17);     // Catch: Exception -> L25
        if (r18 == null) goto L22;
        long r7 = RangesKt.coerceIn(r18.longValue(), 0, 999);     // Catch: Exception -> L25
    L23:
        r5 = (r5 * 1000) + r7;
        r1 = r1 + 1;
    L22:
        r7 = 0;
        goto L23
    L33:
        return r5;
    L25:
        e = move-exception;
        Log.e("RomVersionHelper", "parseRomVersion error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return 0;
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r15 = false;
        goto L10
    }

    public static final boolean b() {
        return f;
    }

    private final String c(String r8) {
        Object r1 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r8});     // Catch: Exception -> L7
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    L7:
        e = move-exception;
        Log.w("RomVersionHelper", "safeGetSystemProperty(" + r8 + ") failed: " + e.getMessage());
        return null;
    }

    @JvmStatic
    public static final boolean c() {
        if (l.f13248a.a() == false) goto L17;
        return false;
    L17:
        IPlatformService r2 = am.f13169a.a();     // Catch: Exception -> L14
        if (r2 == null) goto L8;
        IRomInfo r3 = r2.romInfo();     // Catch: Exception -> L14
    L9:
        if (r3 != null) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RomVersionHelper", "[CA_ENTRY_GATE_ROM_INFO_UNAVAILABLE] romInfo unavailable", null, 4, null);     // Catch: Exception -> L14
        return false;
    L12:
        String r4 = r3.getShortOSVersion();     // Catch: Exception -> L14
        int r5 = r3.getOSReleaseDate();     // Catch: Exception -> L14
        boolean r6 = l.f13248a.a(r4, r5);     // Catch: Exception -> L14
        RunLog.INSTANCE.debug("RomVersionHelper", "hasContextAwarenessEntry: version=" + r4 + ", releaseDate=" + r5 + ", result=" + r6);     // Catch: Exception -> L14
        return r6;
    L8:
        r3 = null;
    L14:
        e = move-exception;
        RunLog.INSTANCE.warn("RomVersionHelper", "[CA_ENTRY_GATE_READ_FAILED] failed to read ROM info", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final String d() {
        Iterator<String> r0 = f13178b.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = c(r1);
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L4;
        Log.d("RomVersionHelper", "readFullOtaString hit key=" + r1 + " value=" + r3);
        return r3;
    L8:
        if (StringsKt.isBlank(r4) == true) goto L11;
        r5 = false;
        goto L12
    L15:
        Log.w("RomVersionHelper", "readFullOtaString: no OTA prop found");
        return "";
    }
}
