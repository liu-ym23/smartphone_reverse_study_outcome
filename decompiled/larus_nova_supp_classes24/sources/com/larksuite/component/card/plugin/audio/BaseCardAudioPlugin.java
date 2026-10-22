package com.larksuite.component.card.plugin.audio;

import com.larksuite.component.card.component.audio.service.b;
import com.larksuite.component.card.plugin.OPPlugin;
import com.larksuite.component.card.service.c;
import com.larksuite.component.card.service.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0004¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/BaseCardAudioPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "getAudioService", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService;", "Lcom/larksuite/framework/apiplugin/LKEvent;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class BaseCardAudioPlugin extends OPPlugin {
    public BaseCardAudioPlugin() {
    }

    public final b getAudioService(LKEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r4 = r3.h;
        c r1 = null;
        if ((r4 instanceof ILynxBridgeContext) == false) goto L5;
        ILynxBridgeContext r5 = (ILynxBridgeContext) r4;
    L6:
        if (r5 == null) goto L12;
        ILynxContainerContext r6 = r5.getContainerContext();
        if (r6 == null) goto L12;
        Map r7 = r6.getBizExtra();
        if (r7 == null) goto L12;
        Object r8 = r7.get("card_service");
    L14:
        if ((r8 instanceof d) == true) goto L16;
        r8 = null;
    L16:
        d r9 = (d) r8;
        if (r9 == null) goto L21;
        r1 = r9.getService(b.class);
    L21:
        return (b) r1;
    L12:
        r8 = null;
        goto L14
    L5:
        r5 = null;
        goto L6
    }
}
