package com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import ec2.g1;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final boolean a = false;

    static {
        if (v.a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a = r0;
        return;
    L5:
        if (((Boolean) g1.a.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "addReason");
        if (a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_MESSAGE_HEAT", r1);
    }

    public static void e(f r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_MESSAGE_DROP", "消息超时丢弃，超时时间为" + ((System.currentTimeMillis() - r5.p().longValue()) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) + 's');
    }

    @JvmStatic
    public static final void c(PSMessageHeatState r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "heatState");
        if (a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_MESSAGE_HEAT", "现在的热度状态为" + r3 + ", heat state is " + r2.name());
    }

    public static void f(List r5, PSMessageAction r6) {
        Iterator r7 = r5.iterator();
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L17;
        f r3 = (f) r7.next();
        if (r3.A != r6) goto L4;
        int r4 = b.a[r3.z.ordinal()];
        if (r4 != 1) goto L10;
        r0 = r0 + 1;
        goto L4
    L10:
        if (r4 != 2) goto L12;
        r1 = r1 + 1;
        goto L4
    L12:
        if (r4 != 3) goto L4;
        r2 = r2 + 1;
        goto L4
    L17:
        ALogger.e("PS_BUFFER_POLL", r6.name() + "消息优先级的数量：高优：" + r0 + "，中优：" + r1 + "，低优：" + r2);
    }

    public static void d(f r2, PSMessagePriority r3, PSMessageAction r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r4, "queueAction");
        if (a == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("入队一条消息，行为类型:");
        r0.append(r2.A.name());
        r0.append("，优先级:");
        r0.append(r2.z.name());
        r0.append("。队列行为类型为");
        r0.append(r4.name());
        r0.append(", 队列优先级为");
        if (r3 == null) goto L8;
        String r5 = r3.name();
    L9:
        r0.append(r5);
        ALogger.e("PS_BUFFER_PUSH", r0.toString());
        return;
    L8:
        r5 = null;
        goto L9
    }

    public static void a(int r2, int r3, int r4, int r5, int r6) {
        if (a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_CHAT_COUNT", "最近" + r2 + "秒评论累计数量为" + r4 + "，最近" + r3 + "秒内收到的评论数量为" + r5 + "，超过15s的评论数量为" + r6);
    }
}
