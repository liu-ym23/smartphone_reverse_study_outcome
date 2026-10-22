package hf;

import ai.p;
import android.text.TextUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.h;
import com.lynx.tasm.ui.image.v;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import l9.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PrepareMeta f17315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17316c;
    public final /* synthetic */ n d;

    public e(PrepareMeta r5, int r10, n r11, int r12) {
        this.f17315b = r5;
        this.f17316c = r10;
        this.d = r11;
        this.f17314a = r12;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        int r10 = ((e) r5).f17314a;
        int r11 = this.f17314a;
        if (r11 >= r10) goto L6;
        return -1;
    L6:
        if (r11 <= r10) goto L9;
        return 1;
    L9:
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = false;
        int r10 = 9;
        GeckoLogger.a("[" + this.f17315b + "]UpdateQueue execute: " + this.f17316c);
        p r11 = df.c.f16651h;
        if (r11 == null) goto L21;
        AtomicBoolean r12 = (AtomicBoolean) r11.f287b;
        if (r12.get() == false) goto L21;
        Object r13 = r11.f288c;
        monitor-enter(r13);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (r12.get() == true) goto L280;
    L17:
        monitor-exit(r13);     // Catch: Throwable -> L12
        goto L21
    L280:
        GeckoLogger.a("channel update wait:" + new SimpleDateFormat("MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));     // Catch: Throwable -> L12 InterruptedException -> L14
        r11.f288c.wait();     // Catch: Throwable -> L12 InterruptedException -> L14
    L15:
        GeckoLogger.a("UpdateQueue execute update task manager return");
        return;
    L21:
        AtomicInteger r14 = f.f17317a;
        f.f17318b = this.f17315b.getAccessKey() + '_' + this.f17315b.getChannel();
        PrepareMeta r15 = this.f17315b;
        n r16 = this.d;
        g r17 = new g(r16);
        r17.e = System.currentTimeMillis();
        r17.d = r16.f4760c;
        String r18 = r15.getAccessKey();
        String r19 = r15.getChannel();
        String r20 = (String) df.c.d.get(r18);
        if (r20 != null) goto L24;
    L276:
        r17.b(r15, "update failed, no dir for " + r18);
    L277:
        f.f17318b = "";
        return;
    L24:
        if (r20.length() == 0) goto L276;
        PrepareMeta r21 = com.bytedance.iesgurd.meta.f.a(r18, r19);
        Long r22 = null;
        if (r21 == null) goto L29;
        if (r21 == r15) goto L41;
        r21.setTimeAddQueue(r15.getTimeAddQueue());
        r21.setPreTriggerChannel(r15.getPreTriggerChannel());
    L41:
        r17.f17319a = r21;
        r21.setUpdatePriority(r16.f4763j.ordinal());
        PrepareMeta r110 = r17.f17319a;
        if (r110 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L44:
        r110.setTimeUpdateStart(System.currentTimeMillis());
        PrepareMeta r111 = r17.f17319a;
        if (r111 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L47:
        long r112 = 0;
        if (r111.getTimeAddQueue() != 0) goto L53;
        PrepareMeta r113 = r17.f17319a;
        if (r113 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L52:
        r113.setTimeAddQueue(System.currentTimeMillis());
    L53:
        r17.f17320b = new h();
        PrepareMeta r114 = r17.f17319a;
        if (r114 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L56:
        h r23 = r17.f17320b;
        if (r23 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L59:
        r114.setStatisticModel(r23);
        r17.f17321c = new File(new File(r20, r18), r19);
        PrepareMeta r115 = r17.f17319a;
        if (r115 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L62:
        File r24 = r17.f17321c;
        if (r24 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L65:
        PrepareMeta r25 = r17.f17319a;
        if (r25 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L68:
        r115.setDestDir(new File(r24, String.valueOf(r25.getVersion())));
        String r116 = r15.getAccessKey();
        String r26 = r15.getChannel();
        PrepareMeta r27 = r17.f17319a;
        if (r27 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L71:
        long r28 = r27.getVersion();
        ChannelMeta r29 = com.bytedance.iesgurd.meta.e.a(r116, r26);
        PrepareMeta r117 = r17.f17319a;
        if (r117 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L75:
        if (r117.getDestDir().exists() == false) goto L110;
        PrepareMeta r118 = r17.f17319a;
        if (r118 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L80:
        if (r118.getDestDir().isDirectory() == false) goto L106;
        PrepareMeta r30 = r17.f17319a;
        if (r30 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L84:
        r30.setLocalVersion(r28);
        GeckoLogger.a("current channel is the newest: " + r26);
        if (r29 != null) goto L87;
        r29 = new ChannelMeta();
    L87:
        Long r31 = r29.getId();
        if (r31 != null) goto L90;
    L91:
        r29.setId(Long.valueOf(r28));
        r29.setUpdateTime(Long.valueOf(System.currentTimeMillis()));
        com.bytedance.iesgurd.meta.e.f(r116, r26, r29);
        com.bytedance.iesgurd.meta.e.d(r116, r26, r29);
        EventSubType r32 = EventSubType.f6603j;
        StringBuilder r33 = new StringBuilder();
        r33.append(r31);
        r33.append('-');
        r33.append(r28);
        String r34 = r33.toString();
        JSONObject r35 = new JSONObject();
        r35.put("sub_type", r32.f6615a);
        if (r116 == null) goto L94;
        r35.put("access_key", r116);
    L94:
        if (r26 == null) goto L96;
        r35.put("channels", r26);
    L96:
        if (r34 == null) goto L98;
        r35.put("err_msg", r34);
    L98:
        j.g("geckosdk_event_message", r35);
    L99:
        File r119 = r17.f17321c;
        if (r119 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L102:
        dn.a.L(r119.getAbsolutePath(), Long.valueOf(r28));
        PrepareMeta r120 = r17.f17319a;
        if (r120 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L105:
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new v(r10, r17, r5, r120));
        goto L277
    L90:
        if (r31.longValue() == r28) goto L99;
    L106:
        PrepareMeta r36 = r17.f17319a;
        if (r36 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L109:
        r36.getDestDir().delete();
    L110:
        PrepareMeta r37 = r17.f17319a;
        if (r37 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L114:
        if (r37.getIgnoreBlockList() == true) goto L123;
        ConcurrentHashMap r38 = va.b.f22564a;
        if (r116.length() == 0) goto L123;
        if (r26 == null) goto L123;
        if (r26.length() == 0) goto L123;
        com.bytedance.geckox.c r39 = com.bytedance.geckox.b.f4736a;
    L123:
        PrepareMeta r40 = r17.f17319a;
        if (r40 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L127:
        if (o.h(r40) == true) goto L132;
        PrepareMeta r41 = r17.f17319a;
        if (r41 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L131:
        r17.b(r41, com.lynx.tasm.utils.b.j("block by storage, ", r116, ", ", r26));
        goto L277
    L132:
        File r42 = r17.f17321c;
        if (r42 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L136:
        if (r42.isFile() == false) goto L141;
        File r43 = r17.f17321c;
        if (r43 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L140:
        com.bytedance.geckox.utils.d.j(r43);
    L141:
        File r44 = r17.f17321c;
        if (r44 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L145:
        if (r44.mkdirs() == true) goto L155;
        File r45 = r17.f17321c;
        if (r45 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L150:
        if (r45.isDirectory() == true) goto L155;
        PrepareMeta r46 = r17.f17319a;
        if (r46 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L154:
        r17.b(r46, com.lynx.tasm.utils.b.j("create channel dir failed, ", r116, ", ", r26));
    L155:
        PrepareMeta r121 = r17.f17319a;
        if (r121 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L158:
        File r47 = r17.f17321c;
        if (r47 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L161:
        StringBuilder r48 = new StringBuilder();
        PrepareMeta r49 = r17.f17319a;
        if (r49 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L164:
        r48.append(r49.getVersion());
        r48.append("--updating");
        r121.setUpdatingDir(new File(r47, r48.toString()));
        PrepareMeta r122 = r17.f17319a;
        if (r122 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L168:
        if (com.bytedance.geckox.utils.d.j(r122.getUpdatingDir()) == true) goto L173;
        PrepareMeta r123 = r17.f17319a;
        if (r123 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L172:
        r17.b(r123, com.lynx.tasm.utils.b.j("delete updating dir failed, ", r18, ", ", r19));
        goto L277
    L173:
        PrepareMeta r124 = r17.f17319a;
        if (r124 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L176:
        r124.getUpdatingDir().mkdirs();
        StringBuilder r125 = new StringBuilder("[");
        PrepareMeta r50 = r17.f17319a;
        if (r50 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L179:
        r125.append(r50);
        r125.append("]start update: ");
        PrepareMeta r51 = r17.f17319a;
        if (r51 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L182:
        r125.append(r51.getReqType());
        GeckoLogger.a(r125.toString());
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new com.lynx.tasm.ui.image.h(r17, 20));
        PrepareMeta r126 = r17.f17319a;
        if (r126 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L185:
        long r52 = r126.getLocalVersion();
        if (r52 == 0) goto L247;
        PrepareMeta r127 = r17.f17319a;
        if (r127 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L192:
        if (r127.getPatch() != null) goto L197;
        PrepareMeta r128 = r17.f17319a;
        if (r128 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L196:
        r128.setNotUsePatchReason(1);
        goto L247
    L197:
        PrepareMeta r129 = r17.f17319a;
        if (r129 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L200:
        PrepareMetaPackage r130 = r129.getPatch();
        if (r130 != null) goto L204;
        Intrinsics.throwNpe();
    L204:
        if (r130.getUrlList().isEmpty() == false) goto L209;
        PrepareMeta r131 = r17.f17319a;
        if (r131 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L208:
        r131.setNotUsePatchReason(4);
        goto L247
    L209:
        PrepareMeta r132 = r17.f17319a;
        if (r132 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L212:
        String r133 = r132.getAccessKey();
        PrepareMeta r53 = r17.f17319a;
        if (r53 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L215:
        ChannelMeta r134 = com.bytedance.iesgurd.meta.e.a(r133, r53.getChannel());
        if (r134 == null) goto L221;
        Long r135 = r134.getId();
        if (r135 == null) goto L221;
        r112 = r135.longValue();
    L221:
        if (r112 == r52) goto L235;
        StringBuilder r136 = dn.a.K(r52, "local version change, delete patch: old: ", ", new: ");
        r136.append(r112);
        GeckoLogger.a(r136.toString());
        PrepareMeta r137 = r17.f17319a;
        if (r137 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L225:
        r137.setPatch(null);
        PrepareMeta r138 = r17.f17319a;
        if (r138 != null) goto L228;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L228:
        r138.setLocalVersion(r112);
        PrepareMeta r139 = r17.f17319a;
        if (r139 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L231:
        r139.setLocalVersionOld(r52);
        PrepareMeta r140 = r17.f17319a;
        if (r140 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L234:
        r140.setNotUsePatchReason(2);
        goto L247
    L235:
        File r54 = r17.f17321c;
        if (r54 != null) goto L239;
        Intrinsics.throwUninitializedPropertyAccessException("channelFile");
    L239:
        if (new File(r54, r52 + "/res").isDirectory() == true) goto L247;
        PrepareMeta r141 = r17.f17319a;
        if (r141 != null) goto L243;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L243:
        r141.setPatch(null);
        PrepareMeta r142 = r17.f17319a;
        if (r142 != null) goto L246;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L246:
        r142.setNotUsePatchReason(3);
    L247:
        PrepareMeta r143 = r17.f17319a;
        if (r143 != null) goto L251;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L251:
        if (r143.getPatch() == null) goto L275;
        PrepareMeta r144 = r17.f17319a;
        if (r144 != null) goto L255;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L255:
        PrepareMetaPackage r145 = r144.getPatch();
        if (r145 != null) goto L259;
        Intrinsics.throwNpe();
    L259:
        if (r145.getUrlList().isEmpty() == true) goto L275;
        PrepareMeta r146 = r17.f17319a;
        if (r146 != null) goto L265;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L265:
        if (r146.isSingleFile() == true) goto L271;
        PrepareMeta r147 = r17.f17319a;
        if (r147 != null) goto L270;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L270:
        if (r147.getUseZstd() == false) goto L275;
    L271:
        PrepareMeta r148 = r17.f17319a;
        if (r148 != null) goto L274;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L274:
        r148.setUpdateWithPatch(true);
    L275:
        r17.a();
        goto L277
    L29:
        if (TextUtils.isEmpty(r18) == false) goto L31;
    L36:
        if (r22 == null) goto L38;
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new v(r10, r17, r5, r15));
        goto L277
    L38:
        r17.b(r15, com.lynx.tasm.utils.b.j("no update meta, ", r18, ", ", r19));
        goto L277
    L31:
        if (TextUtils.isEmpty(r19) == true) goto L36;
        ChannelMeta r149 = com.bytedance.iesgurd.meta.e.a(r18, r19);
        if (r149 == null) goto L36;
        r22 = com.bytedance.iesgurd.meta.e.c(r18, r19, r149, "rootDir: ");
        goto L36
    }
}
