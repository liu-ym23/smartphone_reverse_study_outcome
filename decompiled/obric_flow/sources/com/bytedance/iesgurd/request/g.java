package com.bytedance.iesgurd.request;

import android.os.Handler;
import android.util.Pair;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.geckox.net.RequestExecutor;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.exception.ExceptionWithCode;
import com.bytedance.iesgurd.h;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.model.CleanTask;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.model.ResponseBodyUpdate;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.keva.Keva;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.common.reflect.w;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f6679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.oui.toast.b f6680c;
    public pa.a d;
    public ReqType e;
    public List f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ResponseBodyUpdate f6681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RequestBodyUpdate f6682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n f6683j;

    public g(RequestBodyUpdate r5, n r10) {
        this.f6682i = r5;
        this.f6683j = r10;
        this.f6679b = new w(12, false);
        com.obric.oui.toast.b r11 = new com.obric.oui.toast.b();
        ReqType r12 = ReqType.NORMAL;
        r11.e = r12;
        r11.f14885i = "";
        r11.f14886j = "";
        r11.f14887k = "";
        this.f6680c = r11;
        this.e = r12;
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static final void c(g r20) {
        r20.d = r20.f6683j.f4760c;
        r20.e = r20.f6682i.getReqType();
        GeckoLogger.a("start check update request " + r20.e);
        r20.f6682i.getReqInfo().setTag(r20.f6683j.f);
        String r5 = r20.f6682i.getSortedDeployments();
        w r10 = r20.f6679b;
        r10.f9376b = new h0(r20.e);
        r10.d = new b(r20.f6678a, r20.f6683j.f4759b, r5, r20);
        ReqType r11 = r20.e;
        ReqType r12 = ReqType.NORMAL;
        if (r11 != r12) goto L5;
        r20.f6679b.f9377c = new c(r20.f6683j.f4758a, r5);
    L5:
        com.obric.oui.toast.b r13 = r20.f6680c;
        r13.d = r20.f6678a;
        ReqType r14 = r20.e;
        r13.e = r14;
        r13.f14888l = r20.f6683j;
        if (r14 != r12) goto L360;
        Iterator<String> r15 = r20.f6682i.getDeployments().keySet().iterator();
        if (r15.hasNext() == false) goto L360;
        String r16 = r15.next();
        com.obric.oui.toast.b r17 = r20.f6680c;
        r17.getClass();
        r17.f14885i = r16;
        DeploymentsData r18 = r20.f6682i.getDeployments().get(r16);
        if (r18 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        DeploymentsData r19 = r18;
        List<String> r21 = r19.getChannels();
        if (r21 != null) goto L16;
    L19:
        List<String> r22 = r19.getGroups();
        if (r22 != null) goto L22;
    L25:
        Map<String, String> r23 = r20.f6682i.getCustom().get(r16);
        if (r23 != null) goto L28;
        Intrinsics.throwNpe();
    L28:
        StringCompanionObject r24 = StringCompanionObject.INSTANCE;
        com.obric.oui.toast.b r25 = r20.f6680c;
        GeckoLogger.a(String.format("check update, ak: %s, channels:%s, groupName:%s, business_version:%s", Arrays.copyOf(new Object[]{r16, (String) r25.f14886j, (String) r25.f14887k, r23.get("business_version")}, 4)));
        goto L360
    L22:
        if (r22.isEmpty() == true) goto L25;
        com.obric.oui.toast.b r26 = r20.f6680c;
        String r27 = String.valueOf(r19.getGroups());
        r26.getClass();
        r26.f14887k = r27;
        goto L25
    L16:
        if (r21.isEmpty() == true) goto L19;
        com.obric.oui.toast.b r28 = r20.f6680c;
        String r29 = String.valueOf(r19.getChannels());
        r28.getClass();
        r28.f14886j = r29;
    L360:
        r20.f6679b.d();     // Catch: ExceptionWithCode -> L353
        long r30 = 0;
        r20.a();     // Catch: Throwable -> L323
        ResponseBodyUpdate r31 = r20.f6681h;
        if (r31 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("responseBody");
    L36:
        int r32 = r31.getStatus();
        Long r33 = null;
        if (r32 == 0) goto L40;
        r20.f6680c.f14883c = r32;
        String r34 = com.lynx.jsbridge.a.d(r32, "check update failed, status error: ");
    L39:
        g r35 = r20;
    L175:
        if (r34 == null) goto L178;
        r35.d(new Exception(r34));
        return;
    L178:
        Iterator r36 = r35.f.iterator();
    L180:
        if (r36.hasNext() == false) goto L203;
        PrepareMeta r37 = (PrepareMeta) r36.next();
        String r38 = r37.getAccessKey();
        String r39 = r37.getChannel();
        if (r37.getFullPackage() == null) goto L180;
        r37.setLogId((String) r35.f6680c.g);
        r37.setApiVersion((String) r35.f6680c.f14884h);
        r37.setRetry(r35.f6680c.d);
        Long r40 = r35.f6682i.getLocalVersion(r38, r39);
        if (r40 == null) goto L186;
        r37.setLocalVersion(r40.longValue());
    L186:
        r37.initByRequest(r35.e);
        ConcurrentHashMap r41 = com.bytedance.iesgurd.meta.f.f6652a;
        if (r41.get(r38) != null) goto L199;
        monitor-enter(r41);
        if (r41.get(r38) != null) goto L194;
        r41.put(r38, new ConcurrentHashMap());     // Catch: Throwable -> L192
    L194:
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L192
        monitor-exit(r41);
    L192:
        th = move-exception;
        throw th;
    L199:
        Object r43 = r41.get(r38);
        if (r43 != null) goto L202;
        Intrinsics.throwNpe();
    L202:
        ((Map) r43).put(r39, r37);
        goto L180
    L203:
        int r44 = d.f6672a[r35.e.ordinal()];
        if (r44 != 1) goto L206;
    L277:
        HashMap r45 = new HashMap();
        Iterator r46 = r35.f.iterator();
    L279:
        if (r46.hasNext() == false) goto L287;
        PrepareMeta r47 = (PrepareMeta) r46.next();
        long r48 = r47.getDownloadDelay();
        if (r48 > 0) goto L283;
        r48 = 3;
    L283:
        List r49 = (List) r45.get(Long.valueOf(r48));
        if (r49 != null) goto L286;
        r49 = new ArrayList();
        r45.put(Long.valueOf(r48), r49);
    L286:
        r49.add(r47);
        goto L279
    L287:
        Iterator r50 = r45.entrySet().iterator();
    L289:
        if (r50.hasNext() == false) goto L292;
        Map.Entry r51 = (Map.Entry) r50.next();
        long r52 = ((Number) r51.getKey()).longValue();
        ((Handler) com.bytedance.geckox.utils.c.f4792b.getValue()).postDelayed(new e(r52, r51, r35), r52 * 1000);
    L292:
        if (r35.e != ReqType.NORMAL) goto L307;
        if (r35.d == null) goto L307;
        Map<String, List<Pair<String, Long>>> r53 = r35.f6682i.getRequestMap();
        HashMap r54 = new HashMap();
        Iterator r55 = r35.g.iterator();
    L297:
        if (r55.hasNext() == false) goto L302;
        PrepareMeta r56 = (PrepareMeta) r55.next();
        String r57 = r56.getAccessKey();
        List r58 = (List) r54.get(r57);
        if (r58 != null) goto L301;
        r58 = new ArrayList();
    L301:
        r58.add(r56.getPack());
        r54.put(r57, r58);
        goto L297
    L302:
        pa.a r59 = r35.d;
        if (r59 != null) goto L305;
        Intrinsics.throwNpe();
    L305:
        r59.d(r53, r54);
    L307:
        if (r35.g.isEmpty() == false) goto L309;
        Function1 r60 = r35.f6683j.f4764k;
        return;
    L309:
        if (r35.f6683j.f4764k == null) goto L320;
        Iterator r61 = r35.g.iterator();
    L312:
        if (r61.hasNext() == false) goto L320;
        PrepareMeta r62 = (PrepareMeta) r61.next();
        n r63 = r35.f6683j;
        String r64 = r62.getChannel();
        r63.getClass();
        if (r63.f4764k == null) goto L312;
        LinkedHashMap r65 = r63.e;
        if (r65 != null) goto L319;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L319:
        r65.put(r64, Boolean.FALSE);
    L320:
        AtomicInteger r66 = hf.f.f17317a;
        hf.f.a(r35.g, r35.f6683j);
        return;
    L206:
        if (r44 == 2) goto L277;
        if (r44 != 3) goto L210;
        Iterator r67 = r35.f.iterator();
    L275:
        if (r67.hasNext() == false) goto L292;
        r35.b((PrepareMeta) r67.next());
        goto L275
    L210:
        if (r44 == 4) goto L264;
        Iterator<Map.Entry<String, DeploymentsData>> r68 = r35.f6682i.getDeployments().entrySet().iterator();
    L213:
        if (r68.hasNext() == false) goto L292;
        Map.Entry<String, DeploymentsData> r69 = r68.next();
        DeploymentsData r70 = r69.getValue();
        List<String> r71 = r70.getChannels();
        if (r71 == null) goto L249;
        Iterator<T> r72 = r71.iterator();
    L218:
        if (r72.hasNext() == false) goto L249;
        String r73 = (String) r72.next();
        String r74 = r69.getKey();
        PrepareMeta r75 = com.bytedance.iesgurd.meta.f.a(r74, r73);
        if (r75 == null) goto L223;
        r35.b(r75);
    L223:
        if (r35.e != ReqType.NORMAL) goto L218;
        Function1 r76 = r35.f6683j.f4764k;
        if (r35.d != null) goto L229;
        if (r76 == null) goto L218;
    L229:
        if (r75 == null) goto L230;
        BlockType r77 = r75.getBlockType();
        if (r77 == null) goto L218;
        CopyOnWriteArraySet r78 = pa.b.f21323a;
        pa.a r79 = r35.d;
        sa.a r80 = r75.getPack();
        Exception r110 = new Exception("update blocked: " + r77);
        if (r79 == null) goto L248;
        r79.f(r80, r110);
        String r81 = r80.f21882a;
    L248:
        r35.f6683j.b(r73, "update blocked: " + r77);
        goto L218
    L230:
        ChannelMeta r82 = com.bytedance.iesgurd.meta.e.a(r74, r73);
        if (r82 == null) goto L233;
        Long r83 = r82.getId();
    L234:
        if (r83 == null) goto L235;
        CopyOnWriteArraySet r84 = pa.b.f21323a;
        pa.b.a(r35.d, r74, r73, r83.longValue());
        n r85 = r35.f6683j;
        long r86 = r83.longValue();
        r85.getClass();
        if (r85.f4764k == null) goto L218;
        r85.a(r73, new com.bytedance.iesgurd.g(null, r86, true));
        goto L218
    L235:
        CopyOnWriteArraySet r87 = pa.b.f21323a;
        pa.a r88 = r35.d;
        sa.a r89 = new sa.a(r73, 0);
        Exception r90 = new Exception("no local version and no remote version");
        if (r88 == null) goto L238;
        r88.f(r89, r90);
    L238:
        r35.f6683j.b(r73, "no local version and no remote version");
        goto L218
    L233:
        r83 = null;
    L249:
        List<String> r91 = r70.getGroups();
        if (r91 == null) goto L213;
        Iterator<T> r92 = r91.iterator();
    L253:
        if (r92.hasNext() == false) goto L213;
        String r93 = (String) r92.next();
        ConcurrentHashMap r94 = com.bytedance.iesgurd.meta.f.f6652a;
        Map r95 = (Map) com.bytedance.iesgurd.meta.f.f6652a.get(r69.getKey());
        if (r95 == null) goto L253;
        Iterator r96 = r95.entrySet().iterator();
    L258:
        if (r96.hasNext() == false) goto L253;
        PrepareMeta r97 = (PrepareMeta) ((Map.Entry) r96.next()).getValue();
        List<String> r98 = r97.getGroups();
        if (r98 == null) goto L258;
        if (r98.contains(r93) != true) goto L258;
        r35.b(r97);
        goto L258
    L264:
        Iterator<T> r99 = r35.f6682i.getCustom().keySet().iterator();
    L266:
        if (r99.hasNext() == false) goto L292;
        Map r100 = (Map) com.bytedance.iesgurd.meta.f.f6652a.get((String) r99.next());
        if (r100 == null) goto L266;
        Iterator r101 = r100.entrySet().iterator();
    L271:
        if (r101.hasNext() == false) goto L266;
        r35.b((PrepareMeta) ((Map.Entry) r101.next()).getValue());
        goto L271
    L40:
        ResponseBodyUpdate r102 = r20.f6681h;
        if (r102 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("responseBody");
    L44:
        if (r102.getData() != null) goto L46;
        r34 = "check update failed, data is null";
        goto L39
    L46:
        ResponseBodyUpdate r103 = r20.f6681h;
        if (r103 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("responseBody");
    L49:
        ResponseBodyUpdate.ResponseBodyData r104 = r103.getData();
        if (r104 != null) goto L53;
        Intrinsics.throwNpe();
    L53:
        if (r104.getResources() != null) goto L55;
        r34 = "check update failed, resources is null";
        goto L39
    L55:
        r20.f6680c.a();
        r20.f6680c.getClass();
        Map<String, Map<String, CleanTask>> r105 = r104.getCleanTasks();
        if (r105 != null) goto L58;
    L164:
        List r106 = CollectionsKt.toMutableList(r104.getResources());
        int r107 = r106.size() - 1;
    L165:
        if (r107 < 0) goto L174;
        PrepareMeta r108 = (PrepareMeta) r106.get(r107);
        String r109 = r108.checkValid();
        if (r109 == null) goto L173;
        String r111 = "server data error: ".concat(r109);
        GeckoLogger.b(r111);
        r108.getAccessKey();
        sa.a r112 = new sa.a(r108.getChannel(), 0);
        CopyOnWriteArraySet r113 = pa.b.f21323a;
        pa.a r114 = r20.d;
        Exception r115 = new Exception(r111);
        if (r114 == null) goto L171;
        r114.f(r112, r115);
    L171:
        r20.f6683j.b(r108.getChannel(), r111);
        r106.remove(r107);
    L173:
        r107 = r107 - 1;
        goto L165
    L174:
        r35 = r20;
        r35.f = CollectionsKt.toList(r106);
        r34 = null;
        goto L175
    L58:
        if (r105.isEmpty() == true) goto L164;
        Iterator<Map.Entry<String, Map<String, CleanTask>>> r116 = r105.entrySet().iterator();
    L62:
        if (r116.hasNext() == false) goto L163;
        Map.Entry<String, Map<String, CleanTask>> r117 = r116.next();
        String r118 = r117.getKey();
        Iterator<Map.Entry<String, CleanTask>> r119 = r117.getValue().entrySet().iterator();
    L65:
        if (r119.hasNext() == false) goto L62;
        Map.Entry<String, CleanTask> r120 = r119.next();
        String r121 = r120.getKey();
        CleanTask r122 = r120.getValue();
        List<Long> r123 = r122.getCleanPackages();
        if (r123 == null) goto L117;
        Iterator<T> r124 = r123.iterator();
    L70:
        if (r124.hasNext() == false) goto L117;
        long r125 = ((Number) r124.next()).longValue();
        CleanStrategy r126 = CleanStrategy.f6699b;
        String r127 = (String) df.c.d.get(r118);
        if (r127 == null) goto L70;
        Long r128 = Long.valueOf(r125);
        if (r125 != r30) goto L82;
        ChannelMeta r129 = com.bytedance.iesgurd.meta.e.a(r118, r121);
        if (r129 == null) goto L78;
        r128 = r129.getId();
    L79:
        File r130 = new File(r127 + '/' + r118 + '/' + r121);
        com.bytedance.iesgurd.meta.f.b(r33, r118, r121);
        com.bytedance.iesgurd.meta.e.g(r118, r121);
        ConcurrentHashMap r131 = (ConcurrentHashMap) va.b.f22564a.get(r118);
        if (r131 == null) goto L99;
        r131.remove(r121);
        va.b.f22566c.put(r118, Boolean.TRUE);
    L99:
        if (r130.exists() == true) goto L103;
    L100:
        r30 = 0;
        r33 = null;
        goto L70
    L103:
        if (com.lynx.tasm.behavior.utils.d.f(r130) == false) goto L107;
        if (r128 == null) goto L106;
        dn.a.M(r118, r121);
    L106:
        int r132 = 200;
    L108:
        JSONObject r133 = new JSONObject();
        r133.put("clean_strategy", r126.ordinal());
        r133.put("stats_type", r132);
        if (r118 == null) goto L111;
        r133.put("access_key", r118);
    L111:
        if (r121 == null) goto L113;
        r133.put(LynxMonitorService.KEY_CHANNEL, r121);
    L113:
        if (r125 == r30) goto L115;
        r133.put("id", r125);
    L115:
        j.g("geckosdk_clean_stats", r133);
        goto L100
    L107:
        r132 = 201;
        goto L108
    L78:
        r128 = r33;
        goto L79
    L82:
        r130 = new File(r127 + '/' + r118 + '/' + r121 + '/' + r125);
        ConcurrentHashMap r134 = com.bytedance.iesgurd.meta.f.f6652a;
        com.bytedance.iesgurd.meta.f.b(Long.valueOf(r125), r118, r121);
        ConcurrentHashMap r135 = com.bytedance.iesgurd.meta.e.f6651c;
        ConcurrentHashMap r136 = (ConcurrentHashMap) r135.get(r118);
        if (r136 == null) goto L99;
        ChannelMeta r137 = (ChannelMeta) r136.get(r121);
        if (r137 == null) goto L99;
        Long r138 = r137.getId();
        if (r138 == null) goto L99;
        if (r138.longValue() != r125) goto L99;
        ConcurrentHashMap r139 = (ConcurrentHashMap) r135.get(r118);
        if (r139 == null) goto L94;
        ChannelMeta r140 = (ChannelMeta) r139.remove(r121);
    L94:
        Keva r141 = com.bytedance.iesgurd.meta.e.f6649a;
        if (r141 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L97:
        r141.erase(r118 + '@' + r121);
    L117:
        List<Long> r142 = r122.getClosePackages();
        if (r142 == null) goto L123;
        Iterator<T> r143 = r142.iterator();
    L121:
        if (r143.hasNext() == false) goto L123;
        long r144 = ((Number) r143.next()).longValue();
        ConcurrentHashMap r145 = com.bytedance.iesgurd.meta.f.f6652a;
        com.bytedance.iesgurd.meta.f.b(Long.valueOf(r144), r118, r121);
    L123:
        String r146 = (String) df.c.d.get(r118);
        if (r146 != null) goto L126;
    L133:
        ChannelMeta r147 = com.bytedance.iesgurd.meta.e.a(r118, r121);
        if (r147 == null) goto L161;
        List<Long> r148 = r122.getForbiddenPackages();
        if (r148 == null) goto L148;
        Iterator<T> r149 = r148.iterator();
    L139:
        if (r149.hasNext() == false) goto L148;
        long r150 = ((Number) r149.next()).longValue();
        Long r151 = r147.getId();
        if (r151 == null) goto L139;
        if (r151.longValue() != r150) goto L139;
        if (r147.getForbidden() == true) goto L139;
        GeckoLogger.a("forbidden channel: " + r118 + '-' + r121 + '-' + r150);
        r147.setForbidden(true);
        com.bytedance.iesgurd.meta.e.d(r118, r121, r147);
        dn.a.M(r118, r121);
    L148:
        List<Long> r152 = r122.getUnforbiddenPackages();
        if (r152 == null) goto L161;
        Iterator<T> r153 = r152.iterator();
    L152:
        if (r153.hasNext() == false) goto L161;
        long r154 = ((Number) r153.next()).longValue();
        Long r155 = r147.getId();
        if (r155 == null) goto L152;
        if (r155.longValue() != r154) goto L152;
        if (r147.getForbidden() == false) goto L152;
        GeckoLogger.a("unforbidden channel: " + r118 + '-' + r121 + '-' + r154);
        r147.setForbidden(false);
        com.bytedance.iesgurd.meta.e.d(r118, r121, r147);
    L161:
        r30 = 0;
        r33 = null;
        goto L65
    L126:
        if (r146.length() == 0) goto L133;
        File r156 = new File(r146 + '/' + r118 + '/' + r121);
        File[] r157 = r156.listFiles(cf.a.f1184a);
        if (r157 != null) goto L131;
    L132:
        com.bytedance.geckox.utils.d.j(r156);
        goto L133
    L131:
        if (r157.length != 0) goto L133;
    L163:
        com.lynx.tasm.behavior.utils.d.i();
    L323:
        th = move-exception;
        w r158 = r20.f6679b;
        c r159 = (c) r158.f9377c;
        if (r159 == null) goto L327;
        c.f6669c.remove(r159.f6671b);
    L327:
        h0 r160 = (h0) r158.f9376b;
        if (r160 == null) goto L336;
        monitor-enter(r160);
        h0.f1509c++;     // Catch: Throwable -> L333
        h0.d = System.currentTimeMillis();     // Catch: Throwable -> L333
    L333:
        th = move-exception;
        throw th;
    L336:
        b r161 = (b) r158.d;
        if (r161 != null) goto L339;
    L352:
        r20.d(th);
        return;
    L339:
        if (r161.f6666a.get() == true) goto L350;
        if (r161.f6668c == false) goto L350;
        if ((System.currentTimeMillis() - b.f.get()) > 1800000) goto L350;
        a r162 = new a(r161, 0);
        long r163 = System.currentTimeMillis();
        r162.f892b = Long.valueOf(r163);
        long r164 = 60000;
        w r165 = (w) bb.c.f895a.f22857a;
        if (r164 >= 0) goto L347;
        r165.getClass();
    L348:
        b.e.put(r161.d, Long.valueOf(r163));
        GeckoLogger.a(r161.d + "gecko update request retry hit");
        goto L352
    L347:
        r165.e(r162, r164, 0);
    L350:
        if (r161.f6666a.get() == false) goto L352;
        b.f.set(System.currentTimeMillis());
    L353:
        e = move-exception;
        com.obric.oui.toast.b r166 = r20.f6680c;
        r166.f14883c = e.f6623a;
        r166.f14882b = 1;
        r20.d(e);
    }

    public final void a() {
        com.obric.oui.toast.b r5 = this.f6680c;
        r5.f14884h = "update_v7_custom";
        ReqType r10 = this.e;
        if (r10 != ReqType.POLLING) goto L6;
        r5.f14884h = "update_v7_polling";
        String r11 = "/gkx/api/resource/v7/polling";
    L12:
        StringBuilder r12 = new StringBuilder("https://");
        df.c.f16652i.a();
        r12.append(df.c.f.getHost());
        r12.append(r11);
        final String r13 = r12.toString();
        ReqType r14 = ReqType.NONE;
        CopyOnWriteArrayList r15 = GeckoLogger.f4756a;
        GeckoLogger.a(ReportNode.CHECK_UPDATE_REQUEST, "check update start, tag: " + this.f6683j.f + ", retry: " + this.f6678a + ", reqType: " + this.e + ", " + r13);
        new RequestExecutor(this.f6682i, r13, new UpdateRequest$doRequest$1(this, r13)).b();
        return;
    L6:
        if (r10 != ReqType.QUEUE) goto L8;
    L11:
        r5.f14884h = "update_v7_coldstart";
        r11 = "/gkx/api/resource/v7/coldstart";
        goto L12
    L8:
        if (r10 == ReqType.REGISTER_LATE) goto L11;
        r11 = "/gkx/api/resource/v7/custom";
        goto L12
    }

    public final void b(PrepareMeta r5) {
        r5.setReqType(this.e);
        PrepareMeta.updateBlockType$default(r5, false, 1, null);
        if (r5.getBlockType() != null) goto L6;
        this.g.add(r5);
        return;
    }

    public final void d(Throwable r5) {
        String r10 = r5.getMessage();
        String r11 = "";
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        GeckoLogger.b(r10);
        String r12 = r5.getMessage();
        com.obric.oui.toast.b r13 = this.f6680c;
        r13.f = r12;
        r13.a();
        if (this.e != ReqType.NORMAL) goto L22;
        pa.a r14 = this.d;
        if (r14 == null) goto L11;
        r14.c(r5);
    L11:
        String r15 = r5.getMessage();
        if (r15 == null) goto L14;
        r11 = r15;
    L14:
        n r16 = this.f6683j;
        Function1 r17 = r16.f4764k;
        if (r17 == null) goto L23;
        GeckoLogger.a(r16.f + '-' + r16.g + " update failed: " + r11);
        h r18 = r16.d;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L20:
        r18.getClass();
        r17.invoke(r18);
        return;
    L23:
        return;
    }

    public final void e() {
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new f(this, 1));
    }

    public g(RequestBodyUpdate r11) {
        this(r11, new n("gecko_backup", null, null, false, null, null, false, 1022));
    }
}
