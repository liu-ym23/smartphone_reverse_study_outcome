package com.larus.bmhome.music.protocol;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final Gson a = null;

    /* JADX INFO: renamed from: com.larus.bmhome.music.protocol.a$a, reason: collision with other inner class name */
    public static final class C0023a<T> implements Comparator {
        public C0023a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((String) r1, (String) r2);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((String) r1, (String) r2);
        }
    }

    static {
        a = new Gson();
    }

    public static final boolean a(MusicCreationContent r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getVideoModel();
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        com.larus.bmhome.music.player.f r2 = com.larus.bmhome.music.player.f.a;
        if (com.larus.bmhome.music.player.f.b == false) goto L23;
        if (r3 == null) goto L13;
        r0 = r3.getChunkUrl();
    L13:
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return false;
    L23:
        return false;
    L15:
        if (r3 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == true) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r3.getMusicGenFailed() != true) goto L19;
        r4 = true;
        goto L20
    L5:
        r1 = null;
        goto L7
    }

    public static final MusicCreationContentList b(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        Intrinsics.checkNotNullParameter(r9, "json");
        ad9.d.a r0 = new ad9.d.a(r8, true, null, 4);
        HashMap r1 = new HashMap();
        int r2 = 0;
        JSONObject r4 = new JSONObject(r9);     // Catch: Exception -> L25
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L25
        Iterator<String> r5 = r4.keys();     // Catch: Exception -> L25
    L5:
        if (r5.hasNext() == false) goto L8;
        r10.add(r5.next());     // Catch: Exception -> L25
        goto L5
    L8:
        if (r10.size() <= 1) goto L10;
        CollectionsKt.sortWith(r10, new b());     // Catch: Exception -> L25
    L10:
        Iterator r11 = r10.iterator();     // Catch: Exception -> L25
    L11:
        if (r11.hasNext() == false) goto L27;
        String r3 = (String) r11.next();     // Catch: Exception -> L25
        if (TextUtils.equals(r3, "task_nums") == true) goto L15;
        MusicCreationContent r6 = (MusicCreationContent) a.fromJson(r4.optString(r3), MusicCreationContent.class);     // Catch: Exception -> L25
        if (StringsKt.toIntOrNull(r3) == null) goto L22;
        if (r6 == null) goto L22;
        if (a(r6) == false) goto L22;
        r0.a(r6, r3);     // Catch: Exception -> L25
        com.larus.bmhome.music.player.b.a.getClass();     // Catch: Exception -> L25
        com.larus.bmhome.music.player.b.a.c(r8, r3, r6);     // Catch: Exception -> L25
    L22:
        if (r6 == null) goto L11;
        r1.put(r3, r6);     // Catch: Exception -> L25
        goto L11
    L15:
        r2 = r4.optInt(r3);     // Catch: Exception -> L25
    L27:
        return new MusicCreationContentList(r2, MapsKt.toSortedMap(r1, new C0023a()));
    L25:
        FLogger.a.i("MusicCreationContent", "MusicCreationContent parse failed");
        goto L27
    }
}
