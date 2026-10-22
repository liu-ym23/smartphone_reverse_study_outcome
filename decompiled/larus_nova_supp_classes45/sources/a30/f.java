package a30;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.livesdk.revenue.service.effect.g {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ SetEffectComposerResultModel d;

    public final void onResult(int r4) {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.getLoadedEffectResourceMap();
        if (r1 == null) goto L9;
        Map r2 = (Map) r1.getValue();
        if (r2 == null) goto L9;
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) r2.get(this.b);
    L10:
        if (r3 != null) goto L18;
        r3 = new CopyOnWriteArrayList();
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.i r6 = r5.getLoadedEffectResourceMap();
        if (r6 == null) goto L18;
        Map r7 = (Map) r6.getValue();
        if (r7 == null) goto L18;
        CopyOnWriteArrayList r8 = (CopyOnWriteArrayList) r7.put(this.b, r3);
    L18:
        CollectionsKt.addAll(r3, this.c);
        SetEffectComposerResultModel.b r9 = this.d.getData();
        if (r9 == null) goto L21;
        r9.setResult(Integer.valueOf(r4));
    L21:
        jy0.b.d("SetEffectComposerMethod", "appendComposer success, result = " + r4);
        this.a.finishWithResult(this.d);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public f(e r1, String r2, String[] r3, SetEffectComposerResultModel r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
