package com.bytedance.geckox;

import android.text.TextUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f4750a;

    public g(j r5) {
        this.f4750a = r5;
    }

    public static g a(j r5) {
        List r10 = r5.f4754a;
        if (r10 == null) goto L18;
        if (r10.isEmpty() == true) goto L18;
        Iterator r11 = r10.iterator();     // Catch: IllegalArgumentException -> L11
    L8:
        if (r11.hasNext() == false) goto L13;
        l.a((String) r11.next(), r5.f4755b.getAbsolutePath());     // Catch: IllegalArgumentException -> L11
    L13:
        g r12 = new g(r5);
        ConcurrentHashMap r13 = h.f4751a;
        String r14 = (String) r10.get(0);
        ConcurrentHashMap r15 = h.f4751a;
        if (r15.get(r14) != null) goto L16;
        r15.put(r14, r12);
    L16:
        return r12;
    L11:
        e = move-exception;
        GeckoLogger.a("gecko client register root dir failed:" + e.getMessage());
    L18:
        throw new IllegalArgumentException("access key empty");
    }

    public final void b(Map r14, OptionCheckUpdateParams r15) {
        boolean r5 = df.c.f16650c.get();
        j r13 = this.f4750a;
        List r10 = r13.f4754a;
        if (r5 == true) goto L23;
        if (r15 != null) goto L7;
    L9:
        GeckoLogger.b("do not call checkUpdateMulti before GeckoGlobalManager.init");
        if (r15 == null) goto L12;
        String r16 = r15.getTag();
    L13:
        EventSubType r17 = EventSubType.f6600c;
        String r11 = r10.toString();
        String r18 = r14.toString();
        JSONObject r12 = new JSONObject();
        r12.put("sub_type", r17.f6615a);
        if (r11 == null) goto L16;
        r12.put("access_key", r11);
    L16:
        if (r18 == null) goto L18;
        r12.put("channels", r18);
    L18:
        if (r16 == null) goto L20;
        r12.put("extra", r16);
    L20:
        r12.put("duration", 1);
        com.lynx.tasm.utils.j.g("geckosdk_event_message", r12);
        return;
    L12:
        r16 = "";
        goto L13
    L7:
        if (r15.getListener() == null) goto L9;
        r15.getListener().c(new IllegalStateException("do not call checkUpdateMulti before GeckoGlobalManager.init"));
        goto L9
    L23:
        if (l.b() == true) goto L29;
        if (r15 != null) goto L26;
        return;
    L26:
        if (r15.getListener() == null) goto L184;
        r15.getListener().c(new IllegalStateException("gecko is disabled"));
        return;
    L184:
        return;
    L29:
        boolean r19 = false;
        if (r14 != null) goto L32;
    L47:
        if (r15 != null) goto L50;
        r15 = new OptionCheckUpdateParams();
    L50:
        if (r15.isLazyUpdate() == false) goto L86;
        if (r10.size() <= 1) goto L56;
        pa.a r20 = r15.getListener();
        if (r20 == null) goto L77;
        r20.c(new IllegalArgumentException("lazy update not support multi ak"));
    L77:
        boolean r21 = true;
    L100:
        if (r21 == false) goto L103;
        return;
    L103:
        if (r15.isRequestWhenHasLocalVersion() == true) goto L143;
        if (r14 == null) goto L143;
        if (r14.isEmpty() == true) goto L143;
        if (TextUtils.isEmpty(null) == false) goto L112;
    L114:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r14.entrySet().iterator();
    L116:
        if (r23.hasNext() == false) goto L136;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getKey();
        Iterator r26 = ((List) r24.getValue()).iterator();
    L119:
        if (r26.hasNext() == false) goto L116;
        CheckRequestBodyModel.TargetChannel r27 = (CheckRequestBodyModel.TargetChannel) r26.next();
        File r28 = r13.f4755b;
        String r29 = r27.channelName;
        if (TextUtils.isEmpty(r25) == false) goto L123;
    L131:
        Long r30 = null;
    L132:
        if (r30 == null) goto L143;
        r22.add(new sa.a(r27.channelName, r30.longValue()));
        goto L119
    L123:
        if (TextUtils.isEmpty(r29) == true) goto L131;
        ChannelMeta r110 = com.bytedance.iesgurd.meta.e.a(r25, r29);
        if (r110 == null) goto L131;
        String r111 = "rootDir: ";
        if (r28 == null) goto L130;
        r111 = "rootDir: " + r28.getAbsolutePath();
    L130:
        r30 = com.bytedance.iesgurd.meta.e.c(r25, r29, r110, r111);
        goto L132
    L136:
        if (r15.getListener() == null) goto L144;
        Iterator r31 = r22.iterator();
    L139:
        if (r31.hasNext() == false) goto L144;
        sa.a r32 = (sa.a) r31.next();
        CopyOnWriteArraySet r33 = pa.b.f21323a;
        pa.a r34 = r15.getListener();
        if (r34 == null) goto L139;
        r34.e(r32, r32.f21883b);
    L144:
        if (r19 == false) goto L188;
        m.a(r13, r14, r15);     // Catch: Throwable -> L151 Exception -> L153
    L148:
        if (r15.getListener() == null) goto L185;
        r15.getListener().a();
        return;
    L185:
        return;
    L153:
        e = move-exception;
        GeckoLogger.a("Gecko update failed:", e);     // Catch: Throwable -> L151
        if (r15.getListener() == null) goto L186;
        r15.getListener().a();
        return;
    L186:
        return;
    L151:
        th = move-exception;
        if (r15.getListener() == null) goto L162;
        r15.getListener().a();
    L162:
        throw th;
    L188:
        return;
    L112:
        if ("default".equals(null) == true) goto L114;
    L143:
        r19 = true;
        goto L144
    L56:
        if (r14 == null) goto L58;
        int r35 = r14.size();
    L59:
        if (r35 <= 1) goto L63;
        pa.a r36 = r15.getListener();
        if (r36 == null) goto L77;
        r36.c(new IllegalArgumentException("lazy update not support channels with multi ak"));
        goto L77
    L63:
        String r37 = (String) r10.get(0);
        if (r14 == null) goto L66;
        List r38 = (List) r14.get(r37);
    L67:
        if (r38 != null) goto L69;
    L72:
        boolean r39 = true;
    L73:
        if (r39 == false) goto L78;
        pa.a r40 = r15.getListener();
        if (r40 == null) goto L77;
        r40.c(new IllegalArgumentException("lazy update argument error: channel empty and group empty"));
        goto L77
    L78:
        if (r38 == null) goto L83;
        ArrayList r41 = new ArrayList(CollectionsKt.h(r38));
        Iterator r42 = r38.iterator();
    L81:
        if (r42.hasNext() == false) goto L84;
        r41.add(((CheckRequestBodyModel.TargetChannel) r42.next()).channelName);
    L84:
        r21 = com.bytedance.apm.util.a.g(com.bytedance.apm.util.a.a(r15, r37, r41));
        goto L100
    L83:
        r41 = null;
        goto L84
    L69:
        if (r38.isEmpty() == true) goto L72;
        r39 = false;
        goto L73
    L66:
        r38 = null;
        goto L67
    L58:
        r35 = 0;
        goto L59
    L86:
        if (r10.size() > 1) goto L99;
        String r43 = (String) r10.get(0);
        if (r14 == null) goto L99;
        if (r14.size() != 1) goto L99;
        List r44 = (List) r14.get(r43);
        if (r44 == null) goto L99;
        if (r44.size() != 1) goto L99;
        r21 = com.bytedance.apm.util.a.g(com.bytedance.apm.util.a.a(r15, r43, CollectionsKt.listOf(((CheckRequestBodyModel.TargetChannel) r44.get(0)).channelName)));
    L99:
        r21 = false;
        goto L100
    L32:
        if (r14.isEmpty() == true) goto L47;
        Iterator r45 = r14.entrySet().iterator();
    L36:
        if (r45.hasNext() == false) goto L47;
        Map.Entry r46 = (Map.Entry) r45.next();
        Iterator r47 = r10.iterator();
        boolean r48 = false;
    L39:
        if (r47.hasNext() == false) goto L43;
        if (TextUtils.equals((String) r47.next(), (CharSequence) r46.getKey()) == false) goto L39;
        r48 = true;
        goto L39
    L43:
        if (r48 == true) goto L36;
        throw new IllegalArgumentException("target keys are not in deployments keys");
    }
}
