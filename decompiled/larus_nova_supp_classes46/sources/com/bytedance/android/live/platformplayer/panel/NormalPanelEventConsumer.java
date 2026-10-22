package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdkapi.model.StreamAutoAdapterConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class NormalPanelEventConsumer implements c {
    public Pair<? extends LivePanelType, String> a;
    public final Lazy b;

    @Override // com.bytedance.android.live.platformplayer.panel.c
    public final void clear() {
        this.a = null;
    }

    public NormalPanelEventConsumer() {
        this.b = LazyKt.lazy(NormalPanelEventConsumer$config$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.platformplayer.panel.c
    public final boolean a(LivePanelType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "panelType");
        if (r4 == false) goto L5;
        return false;
    L5:
        Pair<? extends LivePanelType, String> r5 = this.a;
        String r1 = null;
        if (r5 == null) goto L8;
        LivePanelType r6 = (LivePanelType) r5.getFirst();
    L9:
        if (r3 != r6) goto L18;
        Pair<? extends LivePanelType, String> r7 = this.a;
        if (r7 == null) goto L14;
        r1 = (String) r7.getSecond();
    L14:
        if (Intrinsics.areEqual(r1, "close") == true) goto L18;
        return true;
    L18:
        return false;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.platformplayer.panel.c
    public final boolean b(ds0.b r7, nk r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "panelEvent");
        StreamAutoAdapterService r0 = StreamAutoAdapterService.o;
        StringBuilder r1 = new StringBuilder("receive ");
        r1.append(r7.getType());
        r1.append(" panel ");
        if (Intrinsics.areEqual(r7.b, "open") == false) goto L5;
        String r2 = "open";
    L6:
        r1.append(r2);
        r1.append(" event");
        r0.e(r1.toString());
        if (r9 == false) goto L10;
        return false;
    L10:
        if (((StreamAutoAdapterConfig) this.b.getValue()).getBlackPanelList().contains(r7.getType().getIdentifier()) == false) goto L12;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L25;
        r0.e("auto adapter failed. panel " + r7.getType() + " in black list!");
        return false;
    L25:
        Pair<? extends LivePanelType, String> r11 = this.a;
        Object r5 = null;
        if (r11 == null) goto L28;
        String r12 = (String) r11.getSecond();
    L30:
        if (Intrinsics.areEqual(r12, "open") == false) goto L49;
        Pair<? extends LivePanelType, String> r13 = this.a;
        if (r13 == null) goto L34;
        LivePanelType r14 = (LivePanelType) r13.getFirst();
    L36:
        if (r14 == r7.getType()) goto L43;
        StringBuilder r15 = new StringBuilder("auto adapter failed. ");
        Pair<? extends LivePanelType, String> r16 = this.a;
        if (r16 == null) goto L40;
        r5 = (LivePanelType) r16.getFirst();
    L40:
        r15.append(r5);
        r15.append(" has open, not handle ");
        r15.append(r7.getType());
        r15.append('_');
        r15.append(r7.b);
        r0.e(r15.toString());
        return false;
    L43:
        if (Intrinsics.areEqual(r7.b, "open") == false) goto L61;
        StringBuilder r17 = new StringBuilder("auto adapter failed. not handle ");
        Pair<? extends LivePanelType, String> r18 = this.a;
        if (r18 == null) goto L47;
        r5 = (LivePanelType) r18.getFirst();
    L47:
        r17.append(r5);
        r17.append(" second open.");
        r0.e(r17.toString());
        return false;
    L61:
        if (r8 != null) goto L64;
        StreamAutoAdapterService.g(r7);
        return false;
    L64:
        this.a = new Pair(r7.getType(), r7.b);
        return true;
    L34:
        r14 = null;
        goto L36
    L49:
        com.bytedance.android.livesdk.f.d().getClass();
        int r19 = com.bytedance.android.livesdk.f.h;
        if (r19 <= 1) goto L53;
        r0.e("cur has " + r19 + " dialog show, filter " + r7.getType() + " panel stream adapter");
        return false;
    L53:
        Pair<? extends LivePanelType, String> r20 = this.a;
        if (r20 == null) goto L57;
        r5 = (String) r20.getSecond();
    L57:
        if (Intrinsics.areEqual(r5, "close") == false) goto L61;
        if (Intrinsics.areEqual(r7.b, "close") == false) goto L61;
        return false;
    L28:
        r12 = null;
        goto L30
    L12:
        if (r7.getType() == LivePanelType.UN_KNOW) goto L21;
        if (r7.getType() == LivePanelType.GAME_DETAIL) goto L21;
        if (r7.getType() == LivePanelType.PREDICTOR) goto L21;
        if (r7.getType() == LivePanelType.LOTTERY) goto L21;
        r10 = false;
        goto L22
    L5:
        r2 = "close";
        goto L6
    }
}
