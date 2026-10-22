package bb;

import ai.j0;
import android.content.Context;
import android.os.Handler;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.EventSubType;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f899b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f900c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f901a;

    static {
        f899b = new e(0);
        f900c = new e(1);
    }

    public /* synthetic */ e(int r5) {
        this.f901a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Long r5 = null;
        int r10 = 1;
        switch(this.f901a) {
            case 0: goto L36;
            default: goto L4;
        };
    L4:
        df.c r11 = df.c.f16652i;
        r11.a();
        Context r12 = df.c.f.getContext();
        if (r12 == null) goto L116;
        File r13 = new File(r12.getFilesDir().getAbsolutePath() + "/keva/repo/gecko_channel_meta");
        if (r13.exists() == true) goto L9;
    L11:
        ArrayList r14 = new ArrayList(df.c.d.keySet());
        boolean r15 = r14.isEmpty();
        we.a r16 = com.bytedance.geckox.utils.d.f4794a;
        if (r15 == true) goto L31;
        LinkedHashMap r17 = com.bytedance.geckox.f.f4747a;
        r11.a();
        String r18 = df.c.f.getAppVersion();
        String r19 = r16.e(r12.getApplicationContext(), "build_in_app_version", null);
        if (Intrinsics.areEqual(r19, r18) == true) goto L31;
        StringBuilder r20 = com.lynx.tasm.base.a.e("build-in reinstall app,disable offline channels,app version:", r18, ",cache app version:", r19, ",accessKeys:");
        r20.append(r14);
        GeckoLogger.a(r20.toString());
        com.bytedance.geckox.f.f4748b.set(true);
        Iterator r21 = r14.iterator();
    L18:
        if (r21.hasNext() == false) goto L30;
        String r22 = (String) r21.next();
        File[] r23 = new File(r12.getFilesDir(), j0.q(new StringBuilder("gecko_build_in"), File.separator, r22)).listFiles();
        if (r23 == null) goto L18;
        int r24 = r23.length;
        int r110 = 0;
    L22:
        if (r110 >= r24) goto L18;
        File r111 = r23[r110];
        if (r111.isDirectory() == false) goto L29;
        String r112 = r111.getName();
        LinkedHashMap r113 = com.bytedance.geckox.f.f4747a;
        if (com.bytedance.geckox.f.g(r12, "gecko_build_in" + File.separator + r22, r112) == true) goto L29;
        com.bytedance.geckox.f.f(r12, r22, r112, true);
    L29:
        r110 = r110 + 1;
        goto L22
    L30:
        r16.g(r12.getApplicationContext(), "build_in_app_version", r18);
    L31:
        com.lynx.tasm.behavior.utils.d.i();
        String r25 = r16.e(r12, "gecko_daily_task", "2021-09-15");
        String r26 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (Intrinsics.areEqual(r26, r25) == true) goto L117;
        r16.g(r12, "gecko_daily_task", r26);
        GeckoLogger.a("do daily task, date: " + r26);
        ((Executor) com.bytedance.geckox.utils.c.f.getValue()).execute(f899b);
        return;
    L117:
        return;
    L9:
        if (r13.isDirectory() == false) goto L11;
        com.bytedance.geckox.utils.d.j(r13);
        goto L11
    L116:
        return;
    L36:
        Ref.LongRef r27 = new Ref.LongRef();
        long r28 = 0;
        r27.element = 0;
        ArrayList r29 = new ArrayList();
        Iterator r30 = df.c.d.entrySet().iterator();
        int r31 = 0;
    L38:
        if (r30.hasNext() == false) goto L91;
        Map.Entry r32 = (Map.Entry) r30.next();
        String r114 = (String) r32.getKey();
        File[] r33 = new File((String) r32.getValue(), r114).listFiles(d.f897c);
        if (r33 != null) goto L42;
    L43:
        Iterator r115 = r30;
    L90:
        r30 = r115;
        r5 = null;
        r10 = 1;
        r28 = 0;
        goto L38
    L42:
        if (r33.length == 0) goto L43;
        int r116 = r33.length;
        long r117 = r28;
        int r118 = 0;
    L45:
        String r34 = "";
        if (r118 >= r116) goto L75;
        File r35 = r33[r118];
        dn.a.L(r35.getAbsolutePath(), r5);
        File[] r36 = r35.listFiles(d.f896b);
        if (r36 == null) goto L56;
        int r37 = r36.length;
        int r38 = 0;
    L50:
        if (r38 >= r37) goto L55;
        int r119 = r37;
        Iterator r120 = r30;
        int r121 = r116;
        File r39 = new File(r36[r38], "res.zip");
        if (r39.exists() == false) goto L54;
        r39.delete();
    L54:
        r38 = r38 + 1;
        r37 = r119;
        r30 = r120;
        r116 = r121;
        goto L50
    L55:
        Iterator r122 = r30;
        int r123 = r116;
        int r40 = 1;
    L57:
        if (r36 == null) goto L59;
        int r41 = r36.length;
    L60:
        if (r41 <= r40) goto L74;
        int r42 = r36.length;
        int r124 = 0;
    L62:
        if (r124 >= r42) goto L64;
        File r125 = r36[r124];
        StringBuilder r43 = j0.u(r34);
        r43.append(r125.getName());
        r43.append(',');
        r34 = r43.toString();
        r124 = r124 + 1;
        goto L62
    L64:
        EventSubType r44 = EventSubType.f6610q;
        String r45 = r35.getName();
        String r46 = String.valueOf(r41);
        JSONObject r47 = new JSONObject();
        r47.put("sub_type", r44.f6615a);
        if (r114 == null) goto L67;
        r47.put("access_key", r114);
    L67:
        if (r45 == null) goto L69;
        r47.put("channels", r45);
    L69:
        if (r34 == null) goto L71;
        r47.put("err_msg", r34);
    L71:
        if (r46 == null) goto L73;
        r47.put("extra", r46);
    L73:
        j.g("geckosdk_event_message", r47);
    L74:
        r117 = r117 + com.bytedance.geckox.utils.d.l(r35);
        r118 = r118 + 1;
        r10 = 1;
        r30 = r122;
        r116 = r123;
        r5 = null;
        goto L45
    L59:
        r41 = 0;
        goto L60
    L56:
        r40 = r10;
        r122 = r30;
        r123 = r116;
        goto L57
    L75:
        r115 = r30;
        r27.element += r117;
        r31 = r31 + r33.length;
        JSONObject r48 = new JSONObject();
        r48.put("access_key", r114);
        r48.put("access_key_resource_usage", r117);
        r48.put("channel_count", r33.length);
        ConcurrentHashMap r49 = (ConcurrentHashMap) df.e.f16655b.get(r114);
        if (r49 == null) goto L78;
        String r50 = (String) r49.get("business_version");
    L79:
        if (r50 != null) goto L82;
        r50 = df.c.e.getAppVersion();
    L82:
        if (r50 != null) goto L85;
        r50 = "";
    L85:
        r48.put("business_version", r50);
        ConcurrentHashMap r51 = va.b.f22564a;
        if (r114.length() != 0) goto L88;
        Pair r52 = new Pair(0, "");
    L89:
        r48.put("blocklist_count", ((Number) r52.getFirst()).intValue());
        r48.put("block_channels", r52.getSecond());
        r29.add(r48);
        goto L90
    L88:
        com.bytedance.geckox.c r53 = com.bytedance.geckox.b.f4736a;
        r52 = new Pair(0, "");
        goto L89
    L78:
        r50 = null;
        goto L79
    L91:
        Iterator r54 = r29.iterator();
    L93:
        if (r54.hasNext() == false) goto L95;
        JSONObject r55 = (JSONObject) r54.next();
        r55.put("gecko_total_resource_usage", r27.element);
        r55.put("total_channel_count", r31);
        j.g("geckosdk_access_key_resource_info", r55);
        goto L93
    L95:
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(new a6.a(r27, 1));
    }
}
