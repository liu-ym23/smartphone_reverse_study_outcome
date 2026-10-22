package com.larus.avlink.plugins;

import android.app.Application;
import com.google.gson.Gson;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.avlink.liveai.model.LiveAiEventScene;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.VisionModeIntention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x1 extends BaseDoraLiteLiveAiPlugin {
    public final Lazy m;

    @Override // com.larus.avlink.plugins.BaseDoraLiteLiveAiPlugin
    public final void o3() {
        SoundPlayManager r0 = (SoundPlayManager) this.m.getValue();
        Application r1 = AppHost.a.getApplication();
        String r2 = ((n4) getContext()).params().o.d;
        if (r2 != null) goto L7;
        String r3 = a98.a.c;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        boolean r5 = false;
        if (StringsKt.contains$default(r3, "female", false, 2, null) == false) goto L12;
    L14:
        r5 = true;
    L15:
        com.larus.avlink.n1.d("DoraLiteLiveAiPlugin", "styleName is " + r2 + ", botStyleId is " + a98.a.c + ", isFemaleTimbre is " + r5);
        if (r5 == false) goto L18;
        String r4 = this.f;
    L19:
        SoundPlayManager.e(r0, r1, r4, true, null);
        return;
    L18:
        r4 = this.g;
        goto L19
    L12:
        if (StringsKt.contains$default(r3, "male", false, 2, null) == false) goto L14;
    L7:
        r3 = r2;
        goto L8
    }

    public x1(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.m = LazyKt.lazy(new w1());
    }

    @Override // com.larus.avlink.plugins.BaseDoraLiteLiveAiPlugin
    public final void l3(pf9.q r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        List r10 = r9.a;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L45;
        pf9.p r1 = (pf9.p) r11.next();
        Long r2 = r1.a;
        if (r2 == null) goto L44;
        int r3 = (int) r2.longValue();
        JSONObject r4 = new JSONObject();
        Map r5 = r1.b;
        if (r5 == null) goto L13;
        Iterator r6 = r5.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r7 = (Map.Entry) r6.next();
        r4.putOpt((String) r7.getKey(), r7.getValue());
    L13:
        FLogger.a.i("DoraLiteLiveAiPlugin", "handleCommandResponse: cmd:" + r3 + ", params: " + r4 + '.');
        Gson r8 = ha8.a.a;
        ChatParam r12 = (ChatParam) ha8.a.a(r4.toString(), ChatParam.class);
        if (r3 != 24) goto L44;
        Integer r13 = null;
        Gson r14 = new Gson();     // Catch: Exception -> L22
        if (r12 == null) goto L19;
        String r15 = r12.getVisionModeIntention();     // Catch: Exception -> L22
    L20:
        VisionModeIntention r16 = (VisionModeIntention) r14.fromJson(r15, VisionModeIntention.class);     // Catch: Exception -> L22
    L24:
        if (r16 == null) goto L26;
        Integer r17 = r16.getDoraSpecialMode();
    L27:
        if (r16 == null) goto L29;
        r13 = r16.getVisionEventType();
    L29:
        FLogger.a.i("DoraLiteLiveAiPlugin", "handleChatResponseResult: DORA_VISION_MODE_INTENTION. mode:" + r17 + ", status:" + r13);
        if (r17 == null) goto L44;
        if (r17.intValue() != 2) goto L44;
        if (r13 != null) goto L37;
    L39:
        if (r13 == null) goto L44;
        if (r13.intValue() != 2) goto L44;
        m3(5, LiveAiEventScene.MANUAL);
        goto L44
    L37:
        if (r13.intValue() != 1) goto L39;
        m3(2, LiveAiEventScene.MANUAL);
        goto L44
    L26:
        r17 = null;
        goto L27
    L19:
        r15 = null;
    L22:
        e = move-exception;
        FLogger.a.e("DoraLiteLiveAiPlugin", "handleChatResponseResult: intentionItems.", e);
        r16 = null;
    L44:
        r0.add(r1);
        goto L4
    }

    @Override // com.larus.avlink.plugins.BaseDoraLiteLiveAiPlugin
    public final void r1(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (r6 != null) goto L7;
        com.larus.call_plugins_doubao_common.i r7 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.i.class), null);
        if (r7 == null) goto L11;
        r7.r1(r5, AppletPayloadProviderDelegate.a.b(((n4) getContext()).params().o.c, ((n4) getContext()).params().o.h, null));
        return;
    L11:
        return;
    L7:
        com.larus.call_plugins_doubao_common.i r0 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.i.class), null);
        if (r0 == null) goto L13;
        r0.r1(r5, r6);
        return;
    }
}
