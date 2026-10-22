package com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m;
import com.bytedance.android.livesdk.interactivity.textmessage.model.d0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import o72.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MessageHeatUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final m c = null;

    public static o72.c a() {
        return (o72.c) b.getValue();
    }

    public static f c() {
        return (f) a.getValue();
    }

    static {
        a = LazyKt.lazy(MessageHeatUtil$scrollMsgProportionCofig$2.INSTANCE);
        b = LazyKt.lazy(MessageHeatUtil$foldMsgProportionConfig$2.INSTANCE);
        c = new m(CollectionsKt.listOf(new Integer[]{0, 0, 0}));
    }

    @JvmStatic
    public static final String b(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if ((r1 instanceof z) == false) goto L6;
        return ((z) r1).H.getType().name();
    L6:
        if ((r1 instanceof d0) == false) goto L10;
        c4 r2 = ((d0) r1).b;
        if (r2 != null) goto L16;
    L13:
        return null;
    L16:
        return r2.getBizScene();
    L10:
        T r3 = r1.b;
        if (r3 == 0) goto L13;
        return r3.getMessageMethod();
    }
}
