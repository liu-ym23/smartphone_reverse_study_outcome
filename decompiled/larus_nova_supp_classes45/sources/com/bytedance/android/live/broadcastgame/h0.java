package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.live.broadcastgame.api.model.SupportLiveMode;
import com.bytedance.android.live.broadcastgame.api.model.l;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0<T extends com.bytedance.android.live.broadcastgame.api.model.l> implements e10.b {
    public DataCenter a;

    public h0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e10.a
    public final List<T> filter(List<? extends T> r21) {
        Intrinsics.checkNotNullParameter(r21, "dataList");
        DataCenter r4 = this.a;
        if (r4 == null) goto L62;
        z.k.getClass();
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Integer r5 = (Integer) r4.get("data_link_state", 0);
        int r7 = 4;
        boolean r6 = gd0.v.a(r5.intValue(), 4);
        boolean r8 = gd0.v.a(r5.intValue(), 64);
        int r11 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().g();
        boolean r12 = gd0.v.a(r5.intValue(), 2);
        boolean r13 = jc1.k.n(IInteractService.class).getInteractAudienceService().P();
        if (gd0.v.a(r5.intValue(), 32) == false) goto L7;
    L10:
        boolean r14 = true;
    L11:
        int r17 = r5.intValue();
        int r9 = r5.intValue();
        if (gd0.v.a(r9, 4) == false) goto L15;
        r7 = 1;
    L31:
        int r15 = r7;
    L34:
        if (com.bytedance.android.live.core.utils.z.k(r4) == false) goto L38;
        int r16 = SupportLiveMode.VIDEO.getValue();
    L50:
        final z r3 = new z(r4, r17, r6, r8, r11, r12, r13, r14, r15, r16);
        List<? extends T> r1 = r21;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L52:
        if (r2.hasNext() == false) goto L58;
        com.bytedance.android.live.broadcastgame.api.model.l r19 = (com.bytedance.android.live.broadcastgame.api.model.l) r2.next();
        if (r19 == null) goto L57;
        r18.add(r19);
        goto L52
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.model.IInteractEntranceCommonValue");
    L58:
        Intrinsics.checkNotNullParameter(r18, "dataList");
        Intrinsics.checkNotNullParameter(r3, "filterContext");
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r18), new LiveOpenFeatureSceneFilters$filter$1(this, r3)), new LiveOpenFeatureSceneFilters$filter$2(this, r3)));
    L38:
        if (com.bytedance.android.live.core.utils.z.j(r4) == false) goto L41;
        r16 = SupportLiveMode.OBS.getValue();
        goto L50
    L41:
        if (com.bytedance.android.live.core.utils.z.g(r4) == false) goto L44;
        r16 = SupportLiveMode.AUDIO.getValue();
        goto L50
    L44:
        if (com.bytedance.android.live.core.utils.z.i(r4) == false) goto L47;
        r16 = SupportLiveMode.SCREEN_RECORD.getValue();
        goto L50
    L47:
        if (com.bytedance.android.live.core.utils.z.h(r4) == false) goto L49;
        r16 = SupportLiveMode.MEDIA.getValue();
        goto L50
    L49:
        r16 = SupportLiveMode.UNKNOWN.getValue();
        goto L50
    L15:
        if (gd0.v.a(r9, 2) == false) goto L20;
        if (jc1.k.n(IInteractService.class).getInteractAudienceService().P() == true) goto L31;
    L20:
        if (gd0.v.a(r9, 16) == false) goto L23;
        r7 = 3;
        goto L31
    L23:
        if (gd0.v.a(r9, 32) == false) goto L26;
        r7 = jc1.k.n(IInteractService.class).getCurrentScene();
        goto L31
    L26:
        if (gd0.v.a(r9, 64) == false) goto L29;
        r7 = 7;
        goto L31
    L29:
        if (gd0.v.a(r9, 8) == false) goto L32;
        r7 = jc1.k.n(IInteractService.class).getCurrentScene();
        goto L31
    L32:
        r15 = 0;
        goto L34
    L7:
        if (gd0.v.a(r5.intValue(), 8) == true) goto L10;
        r14 = false;
        goto L11
    L62:
        return r21;
    }
}
