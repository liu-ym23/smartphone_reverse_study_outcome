package com.obric.matrix.platform.sdk.ones.safecushion.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\t¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper;", "", "()V", "getSafeMode", "", "lastSafeModeFlagInfo", "Lkotlin/Pair;", "", "lastStartSafeModeInfo", "", "lastStartSafeModeProcessInfo", "markOpenSafeModePage", "", "mode", "markStartSafeMode", "markStartSafeModeProcess", "safeModeIsLegal", "updateSafeModeState", "state", "upgradeFinish", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8127a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8127a = new a(null);
    }

    public b() {
    }

    public final void a() {
        c.f8128a.a("startSafeModeFlag", "startSafeModeFlag-" + System.currentTimeMillis());
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        c.f8128a.a("startSafeModeProcess", "startSafeModeProcess-" + r3 + '-' + System.currentTimeMillis());
    }

    public final void a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "mode");
        Intrinsics.checkNotNullParameter(r12, "state");
        List r3 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeFlagHelper", "updateSafeModeState mode:" + r11 + ",state:" + r12, null, 4, null);     // Catch: Exception -> L19
        File r1 = c.f8128a.a("safeModeFlag");     // Catch: Exception -> L19
        if (r1 == null) goto L8;
        String r4 = r1.getName();     // Catch: Exception -> L19
        if (r4 == null) goto L8;
        r3 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L19
    L8:
        boolean r5 = false;
        if (r3 == null) goto L14;
        if (r3.size() != 4) goto L14;
        r5 = true;
    L14:
        if (r5 == true) goto L16;
        new File(c.f8128a.a(), "safeModeFlag-" + r11 + '-' + r12 + '-' + System.currentTimeMillis()).createNewFile();     // Catch: Exception -> L19
        return;
    L16:
        c.f8128a.a(r1, new File(c.f8128a.a(), "safeModeFlag-" + r11 + '-' + r12 + '-' + ((String) ZeusTransformUtils.preCheckCast(r3.get(3), String.class, "com.obric.memorydata.plugin"))));     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeModeFlagHelper", "updateSafeModeState error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final Pair<Boolean, Long> b() {
        File r1 = c.f8128a.a("startSafeModeFlag");
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        Log.d("SafeModeFlagHelper", "lastStartSafeMode: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "startSafeModeFlagFile.name");     // Catch: Exception -> L10
        List r3 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 2) goto L13;
        long r4 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeFlagHelper", "lastStartSafeModeTime: " + r4, null, 4, null);     // Catch: Exception -> L10
        return TuplesKt.to(true, Long.valueOf(r4));
    L13:
        return TuplesKt.to(false, -1L);
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "mode");
        File r3 = c.f8128a.a("safeModeFlag");
        if (r3 != null) goto L5;
    L8:
        c.f8128a.a("safeModeFlag", "safeModeFlag-" + r4 + "-init-" + System.currentTimeMillis());
        return;
    L5:
        if (r3.exists() == false) goto L8;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeFlagHelper", "markOpenSafeModePage: already marked, skip", null, 4, null);
    }

    public final Pair<String, Long> c() {
        File r1 = c.f8128a.a("startSafeModeProcess");
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        Log.d("SafeModeFlagHelper", "lastStartSafeModeProcessInfo: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "startSafeModeProcessFile.name");     // Catch: Exception -> L10
        List r3 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 3) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        long r0 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.get(2), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SafeModeFlagHelper", "lastStartSafeModeProcessInfo mode:" + r4 + ",startTime:" + r0, null, 4, null);     // Catch: Exception -> L10
        return TuplesKt.to(r4, Long.valueOf(r0));
    L13:
        return TuplesKt.to(null, -1L);
    }

    public final boolean c(String r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (Intrinsics.areEqual("repair", r1) == true) goto L9;
        if (Intrinsics.areEqual("upgrade", r1) == true) goto L9;
        return false;
    }

    public final Pair<String, Long> d() {
        File r1 = c.f8128a.a("safeModeFlag");
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        Log.d("SafeModeFlagHelper", "lastStartSafeModeFlagInfo: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "safeModeFlogFile.name");     // Catch: Exception -> L10
        List r3 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 4) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        long r0 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.get(3), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("SafeModeFlagHelper", "lastStartSafeModeFlagInfo mode:" + r4 + ",startTime:" + r0, null, 4, null);     // Catch: Exception -> L10
        return TuplesKt.to(r4, Long.valueOf(r0));
    L13:
        return TuplesKt.to(null, -1L);
    }

    public final String e() {
        return c.f8128a.a("safeModeFlag", 4, 1);
    }

    public final boolean f() {
        File r1 = c.f8128a.a("safeModeFlag");
        if (r1 != null) goto L5;
    L17:
        return false;
    L5:
        if (r1.exists() == false) goto L17;
        String r2 = r1.getName();     // Catch: Exception -> L15
        Intrinsics.checkNotNullExpressionValue(r2, "safeModeFlogFile.name");     // Catch: Exception -> L15
        List r3 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L15
        if (r3.size() != 4) goto L17;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.get(1), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get(2), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("SafeModeFlagHelper", "lastStartSafeModeFlagInfo mode:" + r5 + ",state:" + r4, null, 4, null);     // Catch: Exception -> L15
        if (Intrinsics.areEqual("upgrade", r5) == false) goto L20;
        if (Intrinsics.areEqual("finish", r4) == true) goto L14;
        return false;
    L14:
        return true;
    L20:
        return false;
    L15:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("SafeModeFlagHelper", "lastStartSafeModeFlagInfo error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L17
    }
}
