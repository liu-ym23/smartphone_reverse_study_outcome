package com.obric.datatransfer.server;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static Integer a;
    public static volatile Map<String, ? extends Map<String, Integer>> b;

    static {
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.larus.nova", MapsKt.mapOf(TuplesKt.to("ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a", 1))), TuplesKt.to("com.obric.assistantaiagent", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.android.contacts", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.android.mms", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.android.gallery3d", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.notes", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.clock", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.recorder", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.bytedance.obric.airecordassistant", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.browser", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.calendar", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.ss.android.lark", MapsKt.mapOf(TuplesKt.to("c80ad6826d563bc397cbc5a3babf317c0fdc8da9efbeb501a7ca39426d021944", 1))), TuplesKt.to("com.ss.android.lark.debug", MapsKt.mapOf(TuplesKt.to("2646d76aaeabeae33b8ebca8dd2d362ea96dd40b47b089334110f52551b6e209", 0))), TuplesKt.to("com.obric.proactive", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.lifelog", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.autoaction", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.smartnotification", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.quicksearch", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)})), TuplesKt.to("com.obric.filemanager", MapsKt.mapOf(new Pair[]{TuplesKt.to("c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", 0), TuplesKt.to("b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", 1)}))});
    }

    public static List a(PackageManager r2, String r3) {
        int r0 = Build.VERSION.SDK_INT;     // Catch: Exception -> L16
        if (r0 < 33) goto L9;
        PackageInfo r4 = r2.getPackageInfo(r3, PackageManager.PackageInfoFlags.of(134217728));     // Catch: Exception -> L16
        if (r4.signingInfo.hasMultipleSigners() == false) goto L7;
        List r5 = ArraysKt.toList(r4.signingInfo.getApkContentsSigners());     // Catch: Exception -> L16
    L19:
        return r5;
    L7:
        r5 = ArraysKt.toList(r4.signingInfo.getSigningCertificateHistory());     // Catch: Exception -> L16
        goto L19
    L9:
        if (r0 < 28) goto L14;
        PackageInfo r6 = r2.getPackageInfo(r3, 134217728);     // Catch: Exception -> L16
        if (r6.signingInfo.hasMultipleSigners() == false) goto L13;
        r5 = ArraysKt.toList(r6.signingInfo.getApkContentsSigners());     // Catch: Exception -> L16
        goto L19
    L13:
        r5 = ArraysKt.toList(r6.signingInfo.getSigningCertificateHistory());     // Catch: Exception -> L16
        goto L19
    L14:
        r5 = ArraysKt.toList(r2.getPackageInfo(r3, 64).signatures);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        return CollectionsKt.emptyList();
    }
}
