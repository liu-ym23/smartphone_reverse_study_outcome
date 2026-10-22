package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements o {
    public final Map<String, List<NormalGiftMessage>> a;
    public AssetsService b;
    public final AssetsService c;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        this.b = this.c;
    }

    public final void onStop() {
        ((LinkedHashMap) this.a).clear();
        this.b = null;
    }

    public e(AssetsService r2) {
        Intrinsics.checkNotNullParameter(r2, "assetsService");
        this.c = r2;
        this.a = new LinkedHashMap();
    }

    public final void a(gm2.d r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        String r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i<k> r2 = r0.getMessageDispatcher();
        if (r2 == null) goto L11;
        k r3 = (k) r2.getValue();
        if (r3 == null) goto L11;
        NormalGiftMessage r9 = r3.a(r8);
    L12:
        if (r9 == null) goto L16;
        h2 r4 = r9.w;
        if (r4 == null) goto L16;
        Integer r5 = Integer.valueOf(r4.getType());
    L17:
        boolean r6 = false;
        if (r5 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L46;
        if (r9 == null) goto L45;
        long r10 = r9.w.getPrimaryEffectId();
        AssetsService r11 = this.b;
        if (r11 == null) goto L45;
        com.bytedance.android.live.core.resources.e r13 = r11.G1(r10);
        if (r13 == null) goto L45;
        if (this.a.containsKey(r9.u()) == false) goto L37;
        List r14 = (List) ((LinkedHashMap) this.a).get(r9.u());
        if (r14 == null) goto L44;
        r14.add(r9);
    L44:
        r6 = true;
        goto L45
    L37:
        ArrayList r15 = new ArrayList();
        r15.add(r9);
        this.a.put(r9.u(), r15);
        if (r9.v == false) goto L40;
        AssetDownloadPriority r16 = AssetDownloadPriority.LOCAL;
    L41:
        AssetsService r17 = this.b;
        if (r17 == null) goto L44;
        r13.getId();
        r17.ib(r13, new f(this, r13, r9.u()), 4, r16);
        goto L44
    L40:
        r16 = AssetDownloadPriority.OTHER_SEND;
    L45:
        if (r6 == false) goto L46;
        return;
    L46:
        StringBuilder r18 = new StringBuilder("message do not need to download special effects，message is ");
        if (r9 == null) goto L49;
        r1 = r9.getLogId();
    L49:
        r18.append(r1);
        r18.append(' ');
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GiftTrayMessageService", r18.toString());
        GiftTrayMessageManager r19 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().g(r9);
        return;
    L21:
        if (r5.intValue() != 15) goto L23;
        r7 = true;
    L16:
        r5 = null;
    L11:
        r9 = null;
        goto L12
    }
}
