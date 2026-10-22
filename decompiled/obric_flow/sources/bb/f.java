package bb;

import com.bytedance.geckox.l;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.g;
import com.google.common.reflect.w;
import com.google.gson.Gson;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import l9.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f902c;

    public /* synthetic */ f(int r5) {
        this.f902c = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bb.a
    public final void a() {
        int r5 = 0;
        Object[] r10 = 0;
        switch(this.f902c) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L29;
            default: goto L4;
        };
    L4:
        Iterator r11 = va.b.f22566c.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L28;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        if (((Boolean) r12.getValue()).booleanValue() == false) goto L6;
        ConcurrentHashMap r14 = va.b.f22564a;
        if (r14.get(r13) == null) goto L6;
        va.b.f22566c.put(r13, Boolean.FALSE);
        if (va.b.a(r13) == true) goto L17;
        va.b.b(r13);     // Catch: Throwable -> L15
    L17:
        ObjectOutputStream r15 = new ObjectOutputStream(new FileOutputStream((File) va.b.f22565b.get(r13)));     // Catch: Throwable -> L15
        r15.writeObject(r14.get(r13));     // Catch: Throwable -> L20
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L20
        r16.append((String) df.c.d.get(r13));     // Catch: Throwable -> L20
        String r17 = File.separator;     // Catch: Throwable -> L20
        r16.append(r17);     // Catch: Throwable -> L20
        r16.append(r13);     // Catch: Throwable -> L20
        r16.append(r17);     // Catch: Throwable -> L20
        r16.append("metaData.json");     // Catch: Throwable -> L20
        com.bytedance.geckox.utils.d.j(new File(r16.toString()));     // Catch: Throwable -> L20
    L24:
        com.bytedance.geckox.utils.d.c(r15);
    L20:
        th = th;
    L76:
        GeckoLogger.a("MetaDataManager: writeToMetaData occurs exception: " + th.getMessage());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        com.bytedance.geckox.utils.d.c(r15);
        throw th;
    L15:
        th = th;
        r15 = null;
        goto L76
    L28:
        return;
    L29:
        AtomicBoolean r18 = gf.b.f17090a;
        if (l.b() == true) goto L32;
    L36:
        GeckoLogger.a("loop disable, cancel");
        GeckoLogger.a("loop stop: " + gf.b.f17091b);
        gf.b.f17090a.set(false);
        b r19 = (b) ((w) c.f895a.f22857a).f9377c;
        if (r19 == null) goto L100;
        r19.removeMessages(3);
        return;
    L100:
        return;
    L32:
        if (gf.b.f17091b <= 0) goto L36;
        if (gf.b.f17092c == false) goto L36;
        RequestBodyUpdate r20 = new RequestBodyUpdate(ReqType.POLLING);
        r20.initCustom();
        new g(r20).e();
        return;
    L41:
        GlobalConfigSettings r21 = com.bytedance.iesgurd.settings.d.f6692a;
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new com.bytedance.iesgurd.settings.b(r5, r10 == true ? 1 : 0, ReqType.POLLING));
        return;
    L43:
        JSONObject r22 = new JSONObject();
        GlobalConfigSettings r23 = df.c.f16652i.d();
        if (r23 == null) goto L46;
        r22.put("settings_version", r23.getVersion());
    L46:
        o.f();
        df.b r24 = df.b.f16647h;
        Pair r25 = r24.b();
        int r26 = ((Number) r25.getFirst()).intValue();
        int r27 = ((Number) r25.getSecond()).intValue();
        if (r26 <= 0) goto L49;
        r22.put("low_storage_threshold", r26);
    L49:
        if (r27 <= 0) goto L51;
        r22.put("sensitive_storage_threshold", r27);
    L51:
        int r28 = o.f19583b;
        if (r28 >= 30) goto L54;
        r22.put("storage_status", 1);
    L60:
        List r29 = r24.a();
        LinkedHashMap r30 = new LinkedHashMap();
        Iterator r31 = com.bytedance.iesgurd.meta.e.f6651c.entrySet().iterator();
    L62:
        if (r31.hasNext() == false) goto L74;
        Map.Entry r32 = (Map.Entry) r31.next();
        String r33 = (String) r32.getKey();
        if (r29 == null) goto L68;
        if (r29.contains(r33) == true) goto L62;
    L68:
        LinkedHashMap r34 = new LinkedHashMap();
        r30.put(r33, r34);
        Iterator r35 = ((Map) r32.getValue()).entrySet().iterator();
    L70:
        if (r35.hasNext() == false) goto L62;
        Map.Entry r36 = (Map.Entry) r35.next();
        Long r37 = ((ChannelMeta) r36.getValue()).getId();
        if (r37 == null) goto L70;
        r34.put(r36.getKey(), Long.valueOf(r37.longValue()));
        goto L70
    L74:
        r22.put("available_meta_ids", new Gson().toJson(r30));
        j.g("geckosdk_online_stats", r22);
        return;
    L54:
        if (r26 <= 0) goto L57;
        if (r28 >= r26) goto L57;
        r22.put("storage_status", 2);
    L57:
        if (r27 <= 0) goto L60;
        if (r28 >= r27) goto L60;
        r22.put("storage_status", 3);
        goto L60
    }

    @Override // bb.a
    public final int b() {
        switch(this.f902c) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return 5;
    L6:
        return 3;
    L8:
        return 0;
    L10:
        return 10;
    }
}
