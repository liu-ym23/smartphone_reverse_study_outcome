package com.larus.avlink.plugins;

import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraAppletPlugin extends CommonAppletPlugin<n4> {
    public final String j;
    public final Map<String, String> k;

    public final void k3() {
        super.k3();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L5;
        return;
    L5:
        List r1 = CollectionsKt.toList(r0.G0());
        com.larus.avlink.n1.d(this.j, "onStart: vad: " + r1);
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Map r3 = (Map) r2.next();
        CoroutineScope r5 = ((n4) getContext()).r();
        if (r5 == null) goto L7;
        BuildersKt.launch$default(r5, Dispatchers.getIO(), null, new DoraAppletPlugin$onSessionStarted$1(this, r3, null), 2, null);
        goto L7
    L11:
        r0.G0().clear();
        CoroutineScope r4 = ((n4) getContext()).r();
        if (r4 == null) goto L20;
        BuildersKt.launch$default(r4, Dispatchers.getIO(), null, new DoraAppletPlugin$onSessionStarted$2(this, null), 2, null);
        return;
    }

    public final String T2() {
        return this.j;
    }

    public DoraAppletPlugin(n4 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.j = "DoraAppletPlugin";
        this.k = AppletPayloadProviderDelegate.a.b(r4.params().o.c, r4.params().o.h, null);
    }

    public final void j3(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "obj");
        y1 r0 = (y1) getContext().c(Reflection.getOrCreateKotlinClass(y1.class), null);
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.P() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        String r2 = String.valueOf(DoraVisionBizScene.LIVE_AI.getValue());
    L11:
        r4.put("vision_biz_scene", r2);
        return;
    L10:
        DoraVisionBizScene.a r3 = DoraVisionBizScene.Companion;
        int r5 = ((n4) getContext()).q();
        r3.getClass();
        r2 = String.valueOf(DoraVisionBizScene.a.a(r5).getValue());
    L7:
        r1 = false;
        goto L8
    }
}
