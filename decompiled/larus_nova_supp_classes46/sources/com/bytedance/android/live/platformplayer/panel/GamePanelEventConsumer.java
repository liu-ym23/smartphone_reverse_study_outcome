package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdkapi.model.GameOpenPanelContentAdapterConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GamePanelEventConsumer implements c {
    public Pair<? extends LivePanelType, String> a;
    public final Lazy b;

    @Override // com.bytedance.android.live.platformplayer.panel.c
    public final boolean a(LivePanelType r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "panelType");
        return false;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.c
    public final void clear() {
        this.a = null;
    }

    public GamePanelEventConsumer() {
        this.b = LazyKt.lazy(GamePanelEventConsumer$config$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.platformplayer.panel.c
    public final boolean b(ds0.b r11, nk r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "panelEvent");
        if (((GameOpenPanelContentAdapterConfig) this.b.getValue()).getSwitch() == true) goto L5;
        return false;
    L5:
        StreamAutoAdapterService r14 = StreamAutoAdapterService.o;
        StringBuilder r1 = new StringBuilder("GamePanelEventConsumer receive ");
        r1.append(r11.getType());
        r1.append(" panel ");
        if (Intrinsics.areEqual(r11.b, "open") == false) goto L8;
        String r2 = "open";
    L9:
        r1.append(r2);
        r1.append(" event");
        r14.e(r1.toString());
        if (r13 == true) goto L12;
    L19:
        Object r3 = null;
        if (r13 == true) goto L76;
        List r15 = ((GameOpenPanelContentAdapterConfig) this.b.getValue()).getPanelList();
        if (r15 != null) goto L24;
    L26:
        r14.e("panelEvent：" + r11.getType().getIdentifier() + " not in config panelList");
        boolean r16 = true;
    L27:
        if (r16 == false) goto L29;
        r14.e("panelEvent：" + r11.getType().getIdentifier() + " type filter");
    L72:
        boolean r17 = true;
    L74:
        if (r17 == false) goto L76;
        return false;
    L29:
        LivePanelType r18 = r11.getType();
        LivePanelType r19 = LivePanelType.UN_KNOW;
        if (r18 == r19) goto L32;
    L63:
        boolean r110 = false;
    L64:
        if (r110 == false) goto L67;
        StreamAutoAdapterService.o.e("panelEvent：" + r11.getType().getIdentifier() + " path filter");
        goto L72
    L67:
        if (r11.c < (((double) s1.w()) * 0.8d)) goto L69;
        boolean r111 = true;
    L70:
        if (r111 == false) goto L73;
        StreamAutoAdapterService.o.e("panelEvent：" + r11.getType().getIdentifier() + " height filter");
        goto L72
    L73:
        r17 = false;
        goto L74
    L69:
        r111 = false;
        goto L70
    L32:
        if (r11.getType() == r19) goto L34;
    L60:
        boolean r112 = false;
    L61:
        if (r112 == false) goto L63;
        r110 = true;
        goto L64
    L34:
        if (r11.i.length() != 0) goto L36;
        boolean r113 = true;
    L37:
        if (r113 == true) goto L60;
        List r114 = ((GameOpenPanelContentAdapterConfig) this.b.getValue()).getBlockUrlPanelList();
        if (r114 != null) goto L41;
    L44:
        boolean r115 = true;
    L45:
        if (r115 == true) goto L60;
        List r116 = ((GameOpenPanelContentAdapterConfig) this.b.getValue()).getBlockUrlPanelList();
        if (r116 == null) goto L60;
        Iterator r117 = r116.iterator();
    L51:
        if (r117.hasNext() == false) goto L60;
        String r118 = (String) r117.next();
        if (r118.length() <= 0) goto L55;
        boolean r6 = true;
    L56:
        if (r6 == false) goto L51;
        if (StringsKt.contains$default(r11.i, r118, false, 2, null) == false) goto L51;
        r112 = true;
        goto L61
    L55:
        r6 = false;
        goto L56
    L41:
        if (r114.isEmpty() == true) goto L44;
        r115 = false;
        goto L45
    L36:
        r113 = false;
        goto L37
    L24:
        if (r15.contains(r11.getType().getIdentifier()) == false) goto L26;
        r14.e("panelEvent：" + r11.getType().getIdentifier() + " in config panelList");
        r16 = false;
    L76:
        Pair<? extends LivePanelType, String> r119 = this.a;
        if (r119 == null) goto L79;
        String r120 = (String) r119.getSecond();
    L81:
        if (Intrinsics.areEqual(r120, "open") == false) goto L100;
        Pair<? extends LivePanelType, String> r121 = this.a;
        if (r121 == null) goto L85;
        LivePanelType r122 = (LivePanelType) r121.getFirst();
    L87:
        if (r122 == r11.getType()) goto L94;
        StreamAutoAdapterService r123 = StreamAutoAdapterService.o;
        StringBuilder r124 = new StringBuilder("auto adapter failed. ");
        Pair<? extends LivePanelType, String> r4 = this.a;
        if (r4 == null) goto L91;
        r3 = (LivePanelType) r4.getFirst();
    L91:
        r124.append(r3);
        r124.append(" has open, not handle ");
        r124.append(r11.getType());
        r124.append('_');
        r124.append(r11.b);
        r123.e(r124.toString());
        return false;
    L94:
        if (Intrinsics.areEqual(r11.b, "open") == false) goto L112;
        StreamAutoAdapterService r125 = StreamAutoAdapterService.o;
        StringBuilder r126 = new StringBuilder("auto adapter failed. not handle ");
        Pair<? extends LivePanelType, String> r127 = this.a;
        if (r127 == null) goto L98;
        r3 = (LivePanelType) r127.getFirst();
    L98:
        r126.append(r3);
        r126.append(" second open.");
        r125.e(r126.toString());
        return false;
    L112:
        this.a = new Pair(r11.getType(), r11.b);
        return true;
    L85:
        r122 = null;
        goto L87
    L100:
        com.bytedance.android.livesdk.f.d().getClass();
        int r128 = com.bytedance.android.livesdk.f.h;
        if (r128 <= 1) goto L104;
        StreamAutoAdapterService.o.e("cur has " + r128 + " dialog show, filter " + r11.getType() + " panel stream adapter");
        return false;
    L104:
        Pair<? extends LivePanelType, String> r129 = this.a;
        if (r129 == null) goto L108;
        r3 = (String) r129.getSecond();
    L108:
        if (Intrinsics.areEqual(r3, "close") == false) goto L112;
        if (Intrinsics.areEqual(r11.b, "close") == false) goto L112;
        return false;
    L79:
        r120 = null;
        goto L81
    L12:
        if (((GameOpenPanelContentAdapterConfig) this.b.getValue()).getLandscapeAdapt() == true) goto L14;
    L18:
        return false;
    L14:
        if (r11.getType() == LivePanelType.INPUT) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L16:
        r5 = false;
        goto L17
    L8:
        r2 = "close";
        goto L9
    }
}
