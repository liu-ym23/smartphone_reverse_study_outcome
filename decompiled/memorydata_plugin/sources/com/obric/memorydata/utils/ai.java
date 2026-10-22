package com.obric.memorydata.utils;

import android.content.Context;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.livecard.api.impl.IslandImpl;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u001aJ\f\u0010\u001b\u001a\u00020\u0005*\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/utils/PackageWhiteList;", "", "<init>", "()V", "MEMORY_DATA_DEBUG_SIGNATURE", "", "MEMORY_DATA_N1_SIGNATURE", "SIGNATURE_TYPE_DEBUG", "", "SIGNATURE_TYPE_RELEASE", "SIGNATURE_TYPE_RELEASE_N1", "TAG", "ANDROID_PACKAGE", "memorySignatureType", "Ljava/lang/Integer;", "systemSignature", "whiteList", "", "packageBlockSet", "", "isValid", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "hexString", "isValid$utils_obricRelease", "getMemorySignatureType", "()Ljava/lang/Integer;", "toHexString", "", "isSystemApp", "getSystemSignature", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ai f13162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13163b = null;
    private static final int c = 0;
    private static final int d = 0;
    private static final int e = 0;
    private static Integer f;
    private static String g;
    private static final Map<String, Map<String, Integer>> h = null;
    private static final Set<String> i = null;

    static {
        f13162a = new ai();
        f13163b = "144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095";
        d = 1;
        e = 2;
        int r8 = c;
        h = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.android.phone", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.bytedance.radioservice", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.assistantaiagent", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.assistantaiagent", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.android.contacts", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2), TuplesKt.to("28bbfe4a7b97e74681dc55c2fbb6ccb8d6c74963733f6af6ae74d8c3a6e879fd", Integer.valueOf(r8)), TuplesKt.to("e4431422e25ae61fa3655e9f908a9b40da2acd67fab99b737027c21fd22b7d40", 1)})), TuplesKt.to("com.android.mms", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2), TuplesKt.to("a40da80a59d170caa950cf15c18c454d47a39b26989d8b640ecd745ba71bf5dc", Integer.valueOf(r8)), TuplesKt.to("d45f076fe23a1a5b7f486e3ff41547a2023dbfe1fe73353b1e48ebdfed72cc6f", 1)})), TuplesKt.to("com.android.gallery3d", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.notes", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.agentskills", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.clock", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.recorder", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.bytedance.obric.airecordassistant", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.browser", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.calendar", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.ss.android.lark", MapsKt.mapOf(TuplesKt.to("c80ad6826d563bc397cbc5a3babf317c0fdc8da9efbeb501a7ca39426d021944", 1))), TuplesKt.to("com.ss.android.lark.debug", MapsKt.mapOf(TuplesKt.to("2646d76aaeabeae33b8ebca8dd2d362ea96dd40b47b089334110f52551b6e209", Integer.valueOf(r8)))), TuplesKt.to("com.obric.proactive", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.lifelog", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.autoaction", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.smartnotification", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.quicksearch", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.filemanager", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to(IslandImpl.LIVE_CARD_HOST, MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.android.settings", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)})), TuplesKt.to("com.obric.appletapp", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", Integer.valueOf(r8)), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1), TuplesKt.to("144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095", 2)}))});
        i = SetsKt.setOf("com.android.shell");
    }

    private ai() {
    }

    private final Integer a() {
        Integer r1 = f;     // Catch: Exception -> L15
        if (r1 == null) goto L6;
        return r1;
    L6:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        r2.getPackageName();     // Catch: Exception -> L15
        byte[] r3 = r2.getPackageManager().getPackageInfo("com.android.settings", 134217728).signingInfo.getApkContentsSigners()[0].toByteArray();     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L15
        String r8 = a(r3);     // Catch: Exception -> L15
        if (Intrinsics.areEqual(r8, "c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8") == false) goto L10;
        int r9 = c;     // Catch: Exception -> L15
    L13:
        f = Integer.valueOf(r9);     // Catch: Exception -> L15
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageWhiteList", "getMemorySignatureType, result=" + r9, false, 4, null);     // Catch: Exception -> L15
        return Integer.valueOf(r9);
    L10:
        if (Intrinsics.areEqual(r8, f13163b) == false) goto L12;
        r9 = e;     // Catch: Exception -> L15
        goto L13
    L12:
        r9 = d;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        RunLog.INSTANCE.error("PackageWhiteList", "getMemorySignatureType error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final String a(byte[] r6) {
        MessageDigest r5 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        r5.update(r6);
        byte[] r7 = r5.digest();
        StringBuilder r8 = new StringBuilder();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = Integer.toHexString(r7[r1] & 255);
        if (r2.length() != 1) goto L7;
        r8.append('0');
    L7:
        r8.append(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        String r9 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        return r9;
    }

    private final String b() {
        String r1 = g;     // Catch: Exception -> L14
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        if (r2 != null) goto L6;
    L9:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
        return r1;
    L12:
        byte[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo("android", 134217728).signingInfo.getApkContentsSigners()[0].toByteArray();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L14
        String r8 = a(r4);     // Catch: Exception -> L14
        g = r8;     // Catch: Exception -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageWhiteList", "getSystemSignature success", false, 4, null);     // Catch: Exception -> L14
        return r8;
    L6:
        if (r2.length() == 0) goto L9;
        r3 = false;
    L14:
        e = move-exception;
        RunLog.INSTANCE.error("PackageWhiteList", "getSystemSignature error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final boolean b(String r10, String r11) {
        String r9 = b();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "PackageWhiteList";
        String r5 = "isSystemApp=false, systemSignature is empty, method return";
    L11:
        IRunLog.a.a(r3, r4, r5, r6, r7, r8);
        return false;
    L14:
        if (AppContext.INSTANCE.isDebug() == true) goto L19;
        if (i.contains(r10) == false) goto L19;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "PackageWhiteList";
        r5 = "isSystemApp=false, call package is adb shell, method return";
    L19:
        return Intrinsics.areEqual(r11, r9);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "hexString");
        if (b(r10, r11) == false) goto L5;
        return true;
    L5:
        Integer r9 = a();
        if (r9 != null) goto L10;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "PackageWhiteList";
        String r5 = "getMemorySignatureType return null";
    L8:
        IRunLog.a.a(r3, r4, r5, r6, r7, r8);
        return false;
    L10:
        Map<String, Map<String, Integer>> r12 = h;
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(r12.get(r10), Map.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L13;
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(r13.get(r11), Integer.class, "com.obric.memorydata.plugin");
    L14:
        if (r14 != null) goto L16;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = "whiteList[" + r10 + "] not contain " + r11;
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "PackageWhiteList";
        goto L8
    L16:
        int r15 = d;
        if (r9.intValue() == r15) goto L19;
        int r16 = e;
        if (r9.intValue() != r16) goto L47;
        if (r14.intValue() != r16) goto L28;
        return true;
    L28:
        if (r14.intValue() != r15) goto L52;
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(r12.get(r10), Map.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L32;
    L43:
        boolean r18 = false;
    L44:
        if (r18 == true) goto L52;
        return true;
    L32:
        if (r17.isEmpty() == true) goto L43;
        Iterator r19 = r17.entrySet().iterator();
    L36:
        if (r19.hasNext() == false) goto L43;
        if (((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Number.class, "com.obric.memorydata.plugin")).intValue() != e) goto L40;
        boolean r110 = true;
    L41:
        if (r110 == false) goto L36;
        r18 = true;
        goto L44
    L40:
        r110 = false;
    L52:
        return false;
    L47:
        if (r14.intValue() != c) goto L49;
        return true;
    L49:
        if (r14.intValue() != r15) goto L51;
        return true;
    L51:
        if (r14.intValue() != r16) goto L52;
        return true;
    L19:
        if (r14.intValue() != r15) goto L52;
        return true;
    L13:
        r14 = null;
        goto L14
    }
}
