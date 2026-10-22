package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VSOgcDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VSAbsDynamicLoader;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSOgcDynamicLoader extends VSAbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        VSRoom r0 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f.a).castToOrNull(VSRoom.class);
        if (r0 == null) goto L25;
        IRoomAppearance r1 = r0.getAppearance();
        if (r1 == null) goto L25;
        ju2.c r2 = r1.castToOrNull(ju2.c.class);
        if (r2 == null) goto L25;
        List r3 = r2.getToolbarConfigList();
        if (r3 == null) goto L25;
        IVSToolbarConfigData r4 = (IVSToolbarConfigData) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L23;
        HashSet r5 = new HashSet();
        k r6 = r4.getIcon();
        if (r6 == null) goto L15;
        List r7 = r6.getUrls();
    L16:
        if (r7 == null) goto L21;
        if ((!r7.isEmpty()) == false) goto L21;
        r5.add(r.y().n(ToolbarButton.VS_ACTIVITY_ONE.extended(), r7));
    L21:
        return CollectionsKt.toList(r5);
    L15:
        r7 = null;
        goto L16
    L23:
        return CollectionsKt.emptyList();
    L25:
        return CollectionsKt.emptyList();
    }

    public VSOgcDynamicLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
