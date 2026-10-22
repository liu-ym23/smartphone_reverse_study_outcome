package com.bytedance.ies.bullet.kit.resourceloader;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.room.writer.DaoWriter;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.k;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements wc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f5446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f5447b;

    public c() {
        new HashMap();
    }

    public final h a() {
        h r5 = this.f5446a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_SERVICE);
        return null;
    }

    public final File b(String r5, String r10, boolean r11) {
        String r12 = (String) df.c.d.get(r10);
        if (r12 != null) goto L5;
    L7:
        r12 = r5;
    L8:
        if (r11 == true) goto L12;
        return new File(r12);
    L12:
        if (this.f5447b != null) goto L20;
        Application r13 = g.f5452b;
        Intrinsics.checkNotNull(r13);
        this.f5447b = r13.getFilesDir();
    L20:
        File r14 = new File(this.f5447b, r12);     // Catch: Exception -> L18
        if (r14.exists() == true) goto L17;
        r14.mkdirs();     // Catch: Exception -> L18
    L17:
        return r14;
    L19:
        return new File(r5);
    L5:
        if (r12.length() <= 0) goto L7;
        r11 = false;
        goto L8
    }

    public final wc.g c(Uri r27, wc.g r28) {
        Intrinsics.checkNotNullParameter(r27, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r28, "config");
        if (this.f5446a != null) goto L5;
    L162:
        dc.b.b("RL实例未初始化，mergeConfig未执行");
        return new wc.g("");
    L5:
        if (a().f == null) goto L162;
        com.bytedance.ies.bullet.base.utils.logger.b r5 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r10 = r28.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("resourceSession", r10, r5.f5260a);
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r27.toString()), TuplesKt.to("cdnUri", r28.f22839h), TuplesKt.to("config", r28.toString())});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("start mergeConfig", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "start mergeConfig", r12, r5);
        wc.g r13 = new wc.g(r28.f22836a);
        r13.a(r28);
        GlobalConfigSettings r14 = df.c.f16652i.d();
        if (r14 == null) goto L159;
        String r15 = r27.getQueryParameter("res_url");
        if (r15 != null) goto L12;
        r15 = "";
    L12:
        String r16 = r27.getQueryParameter("surl");
        if (r16 != null) goto L16;
        r16 = "";
    L16:
        if (r15.length() > 0) goto L26;
        if (k.o(r28.f22839h) == false) goto L22;
        r15 = r28.f22839h;
        goto L26
    L22:
        if (r16.length() <= 0) goto L24;
        r15 = r16;
        goto L26
    L24:
        r15 = r27.toString();
    L26:
        if (r15.length() == 0) goto L159;
        String r17 = Uri.parse(r15).getPath();
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        List r18 = StringsKt.K(r17, new String[]{"/"}, 0, 6);
        if (r18.isEmpty() == false) goto L34;
    L37:
        String r19 = "";
    L38:
        GlobalConfigSettings.ResourceMeta r110 = r14.getResourceMeta();
        if (r110 == null) goto L41;
        GlobalConfigSettings.CurrentLevelConfig r111 = r110.getConfig();
    L42:
        if (r111 == null) goto L159;
        LinkedHashMap r20 = a().d().f22833l;
        Map<String, String> r112 = r111.getPrefix2AccessKey();
        if (r112 == null) goto L47;
        String r113 = r112.get(r19);
    L48:
        if (r113 != null) goto L50;
    L51:
        r113 = (String) r20.get(r19);
    L52:
        if (r113 != null) goto L54;
    L160:
        dc.b.a("GeckoXDepender mergeConfig:ak is Null or Empty,prefix = " + r19);
        return r13;
    L54:
        if (r113.length() == 0) goto L160;
        GlobalConfigSettings.CurrentLevelConfig r21 = r14.getResourceMeta().getConfig();
        GlobalConfigSettings.AccessKeyMetaInfo r114 = r14.getResourceMeta().getAccessKeys().get(r113);
        if (r114 == null) goto L59;
        GlobalConfigSettings.CurrentLevelConfig r115 = r114.getConfig();
    L60:
        Intrinsics.checkNotNullParameter("", LynxMonitorService.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter("", "bundlePath");
        if (k.o(r15) == true) goto L63;
    L95:
        com.bytedance.ies.bullet.base.utils.logger.b r116 = r5;
        String r117 = "";
    L88:
        String r22 = r117;
        String r23 = r22;
    L96:
        if (r114 == null) goto L102;
        Map<String, GlobalConfigSettings.ChannelMetaInfo> r24 = r114.getChannels();
        if (r24 == null) goto L102;
        GlobalConfigSettings.ChannelMetaInfo r25 = r24.get(r23);
        if (r25 == null) goto L102;
        GlobalConfigSettings.CurrentLevelConfig r26 = r25.getConfig();
    L104:
        if (r23.length() != 0) goto L106;
        r23 = r28.f;
    L106:
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r13.f = r23;
        if (r22.length() != 0) goto L109;
        r22 = r28.g;
    L109:
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r13.g = r22;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r13.f22836a = r113;
        if (r26 == null) goto L113;
        List<GlobalConfigSettings.PipelineStep> r29 = r26.getPipeline();
        if (r29 == null) goto L113;
    L118:
        if (r29 != null) goto L120;
    L145:
        String r30 = r117;
        if (r26 == null) goto L149;
        GlobalConfigSettings.CDNFallBackConfig r31 = r26.getCdnFallback();
        if (r31 == null) goto L149;
    L154:
        if (r31 != null) goto L156;
    L158:
        int r32 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r33 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r27.toString()), TuplesKt.to("ppl", r30), TuplesKt.to("sourceUrl", r15), TuplesKt.to("prefix", r19), TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r13.f), TuplesKt.to("bundle", r13.g), TuplesKt.to("result", r13.toString())});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("show mergeConfig result", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "show mergeConfig result", r33, r116);
        r13.f22845n = true;
        goto L159
    L156:
        if (r31.getDomains() == null) goto L158;
        List<String> r34 = r31.getDomains();
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r13.f22842k = r34;
        r31.getMaxAttempts();
        r13.f22843l = r31.getShuffle();
    L149:
        if (r115 == null) goto L151;
        r31 = r115.getCdnFallback();
    L152:
        if (r31 != null) goto L154;
        r31 = r21.getCdnFallback();
        goto L154
    L151:
        r31 = null;
        goto L152
    L120:
        if (r29.isEmpty() == true) goto L145;
        wc.a r35 = new wc.a(true);
        wc.a r118 = r28.f22837b;
        r35.f22823c = r118.f22823c;
        r35.d = r118.d;
        r35.e = r118.e;
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r13.f22837b = r35;
        List r36 = r35.f22822b;
        r36.clear();
        Iterator<GlobalConfigSettings.PipelineStep> r37 = r29.iterator();
    L123:
        if (r37.hasNext() == false) goto L143;
        GlobalConfigSettings.PipelineStep r119 = r37.next();
        if (r119 == null) goto L123;
        StringBuilder r120 = sk.a.a(r117);
        Iterator<GlobalConfigSettings.PipelineStep> r210 = r37;
        r120.append(r119.getType());
        r120.append(',');
        r117 = r120.toString();
        int r38 = r119.getType();
        if (r38 != 1) goto L130;
        r36.add(LoaderType.f5993a);
        r13.d = Integer.valueOf(r119.getUpdate());
    L141:
        r37 = r210;
        goto L123
    L130:
        if (r38 != 2) goto L132;
        r36.add(LoaderType.f5995c);
        if (r119.getNoCache() != 1) goto L138;
        boolean r39 = true;
    L139:
        r13.f22844m = r39;
        goto L141
    L138:
        r39 = false;
        goto L139
    L132:
        if (r38 != 3) goto L141;
        r36.add(LoaderType.f5994b);
        goto L141
    L143:
        if (Intrinsics.areEqual(r28.f22840i, "sub_resource") == false) goto L145;
        r36.remove(LoaderType.f5995c);
    L113:
        if (r115 == null) goto L115;
        r29 = r115.getPipeline();
    L116:
        if (r29 != null) goto L118;
        r29 = r21.getPipeline();
        goto L118
    L115:
        r29 = null;
    L102:
        r26 = null;
        goto L104
    L63:
        if (k.o(r19) == false) goto L95;
        StringBuilder r40 = new StringBuilder();     // Catch: Exception -> L92
        r40.append(r19);     // Catch: Exception -> L92
        r117 = "";
        r40.append("/(([^/]+)/([^?]*))");     // Catch: Exception -> L89
        Matcher r41 = Pattern.compile(r40.toString()).matcher(r15);     // Catch: Exception -> L89
        if (r41.find() == false) goto L91;
        r116 = r5;
        if (r41.groupCount() != 3) goto L88;
        String r121 = r41.group(2);     // Catch: Exception -> L86
        r22 = r41.group(3);     // Catch: Exception -> L86
        if (k.o(r121) == false) goto L88;
        if (k.o(r22) == false) goto L88;
        if (r121 != null) goto L78;
        r23 = r117;
    L79:
        Intrinsics.checkNotNullParameter(r23, "<set-?>");     // Catch: Exception -> L86
        if (r22 != null) goto L168;
        r22 = r117;
    L168:
        Intrinsics.checkNotNullParameter(r22, "<set-?>");     // Catch: Exception -> L84
    L84:
        e = e;
    L94:
        Log.w("GeckoXDepender", "ChannelBundleModel parse error: " + e.getMessage());
        r23 = r23;
        r22 = r117;
        goto L96
    L78:
        r23 = r121;
    L86:
        e = e;
    L87:
        r23 = r117;
        goto L94
    L91:
        r116 = r5;
    L89:
        e = e;
        r116 = r5;
    L92:
        e = e;
        r116 = r5;
        r117 = "";
        goto L87
    L59:
        r115 = null;
        goto L60
    L50:
        if (r113.length() != 0) goto L52;
    L47:
        r113 = null;
        goto L48
    L41:
        r111 = null;
        goto L42
    L34:
        if (r18.size() < 6) goto L37;
        r19 = "/" + ((String) r18.get(1)) + '/' + ((String) r18.get(2)) + '/' + ((String) r18.get(3)) + '/' + ((String) r18.get(4)) + '/' + ((String) r18.get(5));
    L159:
        return r13;
    }

    public final void d(wc.g r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        if (this.f5446a != null) goto L5;
    L32:
        dc.b.b("RL实例未初始化，deleteChannel未执行");
        return;
    L5:
        if (a().f == null) goto L32;
        GeckoConfig r5 = a().d().a(r10.f22836a);
        dc.b.a("GeckoXDepender deleteChannel:config= " + r10);
        File r11 = b(r5.getOfflineDir(), r10.f22836a, r5.isRelativePath());
        String r12 = r10.f22836a;
        String r13 = r10.f;
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r13) == false) goto L11;
        return;
    L11:
        if (r11.exists() == true) goto L13;
        return;
    L13:
        if (r11.isDirectory() == false) goto L41;
        String r14 = com.bytedance.geckox.utils.d.b(r13);
        File r15 = new File(r11, File.separator + r12);     // Catch: Throwable -> L29
        if (r15.exists() == false) goto L39;
        File r16 = new File(r15.getAbsolutePath(), r14);     // Catch: Throwable -> L29
        if (r16.exists() == false) goto L40;
        GeckoLogger.a("deleteChannel: " + r12 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r14);     // Catch: Throwable -> L29
        com.bytedance.iesgurd.meta.e.g(r12, r14);     // Catch: Throwable -> L29
        CleanStrategy r17 = CleanStrategy.f6698a;     // Catch: Throwable -> L29
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L29
        r18.put("clean_strategy", r17.ordinal());     // Catch: Throwable -> L29
        r18.put("clean_type", -1);     // Catch: Throwable -> L29
        r18.put("stats_type", 200);     // Catch: Throwable -> L29
        if (r12 == null) goto L25;
        r18.put("access_key", r12);     // Catch: Throwable -> L29
    L25:
        if (r14 == null) goto L27;
        r18.put(LynxMonitorService.KEY_CHANNEL, r14);     // Catch: Throwable -> L29
    L27:
        com.lynx.tasm.utils.j.g("geckosdk_clean_stats", r18);     // Catch: Throwable -> L29
        com.bytedance.geckox.utils.d.j(r16);     // Catch: Throwable -> L29
        return;
    L40:
        return;
    L39:
        return;
    L29:
        th = move-exception;
        GeckoLogger.a("deleteChannel:error:", th);
        return;
    }
}
