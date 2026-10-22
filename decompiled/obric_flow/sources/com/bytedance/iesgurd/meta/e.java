package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.keva.Keva;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f6649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Keva f6650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f6651c = null;

    static {
        f6651c = new ConcurrentHashMap();
        GeckoLogger.a("ChannelMetaManager init");
        GeckoLogger.a("ChannelMetaManager readCache");
        boolean r5 = true;
        Keva r10 = Keva.getRepo("gecko_channel_meta_new", 1);
        f6649a = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L5:
        Iterator<Map.Entry<String, ?>> r11 = r10.getAll().entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L78;
        Map.Entry<String, ?> r12 = r11.next();
        if (r12.getKey().length() < 34) goto L10;
        String r13 = r12.getKey();
        if (r13 == null) goto L77;
        int r14 = 0;
        String r15 = r13.substring(0, 32);
        String r16 = r12.getKey();
        if (r16 == null) goto L75;
        String r17 = r16.substring(33);
        String r18 = (String) r12.getValue();
        if (r18 == null) goto L20;
        ChannelMeta.Companion.getClass();
        List r19 = StringsKt.K(r18, new String[]{","}, 0, 6);
        if (r19.isEmpty() == false) goto L29;
    L30:
        boolean r110 = r5;
    L64:
        ChannelMeta r111 = null;
    L65:
        if (r111 != null) goto L73;
        GeckoLogger.b("ChannelMetaManager buffer error: ".concat(r18));
        EventSubType r20 = EventSubType.f6602i;
        JSONObject r21 = new JSONObject();
        r21.put("sub_type", r20.f6615a);
        if (r15 == null) goto L69;
        r21.put("access_key", r15);
    L69:
        if (r17 == null) goto L71;
        r21.put("channels", r17);
    L71:
        r21.put("err_msg", r18);
        j.g("geckosdk_event_message", r21);
    L72:
        r5 = r110;
        goto L7
    L73:
        f(r15, r17, r111);
        goto L72
    L29:
        if ((r19.size() % 2) != 0) goto L30;
        ChannelMeta r112 = new ChannelMeta();     // Catch: Throwable -> L60
        int r113 = r19.size() / 2;     // Catch: Throwable -> L60
    L32:
        if (r14 >= r113) goto L62;
        int r114 = r14 * 2;     // Catch: Throwable -> L60
        String r115 = (String) r19.get(r114 + 1);     // Catch: Throwable -> L60
    L51:
        th = th;
        r110 = true;
    L63:
        GeckoLogger.a("ChannelMeta fromString error", th);
        goto L64
    L35:
        if (Intrinsics.areEqual(r115, "null") == false) goto L38;
        List r116 = r19;
    L37:
        r110 = true;
    L59:
        r14 = r14 + 1;
        r5 = r110;
        r19 = r116;
        goto L32
    L38:
        String r22 = (String) r19.get(r114);     // Catch: Throwable -> L51
        int r117 = r22.hashCode();     // Catch: Throwable -> L51
        r116 = r19;
        if (r117 != (-295931082)) goto L41;
        r110 = true;
        if (r22.equals("updateTime") == false) goto L59;
        r112.setUpdateTime(Long.valueOf(Long.parseLong(r115)));     // Catch: Throwable -> L49
        goto L59
    L41:
        if (r117 != 3355) goto L43;
        r110 = true;
        if (r22.equals("id") == false) goto L59;
        r112.setId(Long.valueOf(Long.parseLong(r115)));     // Catch: Throwable -> L49
        goto L59
    L43:
        if (r117 != 1503566841) goto L37;
        if (r22.equals("forbidden") == false) goto L37;
        r110 = true;
        r112.setForbidden(true);     // Catch: Throwable -> L49
    L49:
        th = th;
        goto L63
    L62:
        r110 = r5;
        r111 = r112;
    L60:
        th = th;
        r110 = r5;
        goto L63
    L20:
        GeckoLogger.b("ChannelMetaManager value error: " + r12.getValue());
        EventSubType r23 = EventSubType.f6601h;
        String r24 = String.valueOf(r12.getValue());
        JSONObject r25 = new JSONObject();
        r25.put("sub_type", r23.f6615a);
        if (r15 == null) goto L23;
        r25.put("access_key", r15);
    L23:
        if (r17 == null) goto L25;
        r25.put("channels", r17);
    L25:
        r25.put("err_msg", r24);
        j.g("geckosdk_event_message", r25);
        goto L7
    L75:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L77:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L10:
        GeckoLogger.b("ChannelMetaManager key length error: " + r12.getKey());
        EventSubType r26 = EventSubType.g;
        String r27 = r12.getKey();
        JSONObject r28 = new JSONObject();
        r28.put("sub_type", r26.f6615a);
        if (r27 == null) goto L13;
        r28.put("err_msg", r27);
    L13:
        j.g("geckosdk_event_message", r28);
        goto L7
    L78:
        GeckoLogger.a("ChannelMetaManager readCache finish");
        ((Executor) com.bytedance.geckox.utils.c.f.getValue()).execute(b.f6646a);
    }

    public static ChannelMeta a(String r5, String r10) {
        ConcurrentHashMap r11 = (ConcurrentHashMap) f6651c.get(r5);
        if (r11 != null) goto L5;
        return null;
    L5:
        return (ChannelMeta) r11.get(r10);
    }

    public static Long b(File r10) {
        File[] r11 = r10.listFiles(c.f6647a);
        Long r5 = null;
        if (r11 != null) goto L5;
    L16:
        return r5;
    L5:
        if (r11.length == 0) goto L16;
        int r12 = r11.length;
        long r13 = 0;
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L16;
        File r15 = r11[r14];
        String r16 = r15.getName();
        long r17 = new File(r15, "res").lastModified();
        Long r18 = Long.valueOf(r16);     // Catch: Exception -> L17
        if (r5 != null) goto L13;
    L14:
        r5 = r18;
        r13 = r17;
        goto L15
    L13:
        if (r17 > r13) goto L14;
    L15:
        r14 = r14 + 1;
        goto L8
    }

    public static Long c(String r10, String r11, ChannelMeta r12, String r13) {
        if (r12.getId() != null) goto L5;
        return null;
    L5:
        String r5 = (String) df.c.d.get(r10);
        if (r5 == null) goto L39;
        File r14 = new File(new File(r5, r10), r11);
        if (r14.exists() == true) goto L20;
        EventSubType r15 = EventSubType.f6605l;
        String r16 = String.valueOf(r12.getId());
        JSONObject r17 = new JSONObject();
        r17.put("sub_type", r15.f6615a);
        if (r10 == null) goto L12;
        r17.put("access_key", r10);
    L12:
        if (r11 == null) goto L14;
        r17.put("channels", r11);
    L14:
        r17.put("err_msg", r16);
        if (r13 == null) goto L17;
        r17.put("extra", r13);
    L17:
        j.g("geckosdk_event_message", r17);
        g(r10, r11);
        return null;
    L20:
        if (new File(r14, String.valueOf(r12.getId())).exists() == true) goto L37;
        Long r18 = b(r14);
        EventSubType r19 = EventSubType.f6606m;
        StringBuilder r20 = new StringBuilder();
        r20.append(r12.getId());
        r20.append('-');
        r20.append(r18);
        String r21 = r20.toString();
        JSONObject r22 = new JSONObject();
        r22.put("sub_type", r19.f6615a);
        if (r10 == null) goto L24;
        r22.put("access_key", r10);
    L24:
        if (r11 == null) goto L26;
        r22.put("channels", r11);
    L26:
        if (r21 == null) goto L28;
        r22.put("err_msg", r21);
    L28:
        if (r13 == null) goto L30;
        r22.put("extra", r13);
    L30:
        j.g("geckosdk_event_message", r22);
        if (r18 == null) goto L34;
        r12.setId(r18);
        d(r10, r11, r12);
        return r18;
    L34:
        g(r10, r11);
        return r18;
    L37:
        return r12.getId();
    L39:
        return r12.getId();
    }

    public static void d(String r5, String r10, ChannelMeta r11) {
        Keva r12 = f6649a;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L5:
        r12.storeString(androidx.constraintlayout.motion.widget.a.m(r5, '@', r10), r11.toString());
    }

    public static void e(String r11, String r12) {
        Keva r5 = f6650b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repoMigrate");
    L5:
        int r10 = 0;
        if (r5.getBoolean(r11, false) == false) goto L8;
        return;
    L8:
        long r13 = System.currentTimeMillis();
        GeckoLogger.a("ChannelMetaManager migrate: " + r11 + " start");
        File r14 = new File(r12, r11);
        String[] r15 = r14.list(d.f6648a);
        if (r15 == null) goto L22;
        int r16 = r15.length;
    L11:
        if (r10 >= r16) goto L22;
        String r17 = r15[r10];
        File r18 = new File(r14, r17);
        if (r18.isDirectory() == false) goto L21;
        Long r19 = b(r18);
        if (r19 == null) goto L21;
        ChannelMeta r110 = a(r11, r17);
        if (r110 != null) goto L20;
        r110 = new ChannelMeta();
    L20:
        r110.setId(r19);
        r110.setUpdateTime(Long.valueOf(r18.lastModified()));
        f(r11, r17, r110);
        d(r11, r17, r110);
    L21:
        r10 = r10 + 1;
    L22:
        long r20 = System.currentTimeMillis() - r13;
        StringBuilder r21 = new StringBuilder("ChannelMetaManager migrate: ");
        r21.append(r11);
        r21.append(" finish, duration: ");
        r21.append(r20);
        r21.append(", size:");
        if (r15 == null) goto L25;
        Integer r111 = Integer.valueOf(r15.length);
    L26:
        r21.append(r111);
        GeckoLogger.a(r21.toString());
        Keva r112 = f6650b;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("repoMigrate");
    L29:
        r112.storeBoolean(r11, true);
        return;
    L25:
        r111 = null;
        goto L26
    }

    public static void f(String r5, String r10, ChannelMeta r11) {
        ConcurrentHashMap r12 = f6651c;
        if (r12.get(r5) != null) goto L15;
        monitor-enter(r12);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (r12.get(r5) != null) goto L10;
        r12.put(r5, new ConcurrentHashMap());     // Catch: Throwable -> L8
    L10:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r12);
    L15:
        Object r14 = r12.get(r5);
        if (r14 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        ((Map) r14).put(r10, r11);
    }

    public static void g(String r5, String r10) {
        GeckoLogger.a("ChannelMetaManager removeChannel " + r5 + '@' + r10);
        ConcurrentHashMap r11 = (ConcurrentHashMap) f6651c.get(r5);
        if (r11 == null) goto L5;
        ChannelMeta r12 = (ChannelMeta) r11.remove(r10);
    L5:
        Keva r13 = f6649a;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L8:
        r13.erase(r5 + '@' + r10);
    }
}
