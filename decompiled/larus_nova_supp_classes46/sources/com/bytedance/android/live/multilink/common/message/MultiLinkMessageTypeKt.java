package com.bytedance.android.live.multilink.common.message;

import com.bytedance.android.live.liveinteract.multianchor.model.g;
import com.bytedance.android.livesdk.message.model.e9;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yh6.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkMessageTypeKt {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public static final b<e9> a(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$LINKER");
        return (b) a.getValue();
    }

    public static final b<com.bytedance.android.live.liveinteract.multianchor.model.b> b(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC");
        return (b) b.getValue();
    }

    public static final b<g> c(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_GUEST_LINK_MESSAGE");
        return (b) c.getValue();
    }

    static {
        a = LazyKt.lazy(MultiLinkMessageTypeKt$LINKER$2.INSTANCE);
        b = LazyKt.lazy(MultiLinkMessageTypeKt$LINK_MIC$2.INSTANCE);
        c = LazyKt.lazy(MultiLinkMessageTypeKt$LINK_MIC_GUEST_LINK_MESSAGE$2.INSTANCE);
        d = LazyKt.lazy(MultiLinkMessageTypeKt$LINK_SETTING_NOTIFY_MESSAGE$2.INSTANCE);
        e = LazyKt.lazy(MultiLinkMessageTypeKt$CONTROL$2.INSTANCE);
        f = LazyKt.lazy(MultiLinkMessageTypeKt$VOICE_LIVE_THEME_MESSAGE$2.INSTANCE);
    }
}
