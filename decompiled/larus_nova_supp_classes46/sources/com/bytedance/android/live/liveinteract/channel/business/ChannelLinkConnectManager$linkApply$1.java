package com.bytedance.android.live.liveinteract.channel.business;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class ChannelLinkConnectManager$linkApply$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $channelId;
    final /* synthetic */ long $roomId;
    final /* synthetic */ b this$0;

    public static final class a<T> implements Consumer {
    }

    public ChannelLinkConnectManager$linkApply$1(b r1, long r2, long r4) {
        this.$roomId = r2;
        this.$channelId = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m37invoke() {
        int r0 = nd0.a.a;
        long r1 = this.$roomId;
        long r2 = this.$channelId;
        LinkMonitorData r5 = LinkMonitorData.ChannelApiStartLinkApply;
        Intrinsics.checkNotNullParameter("normal", "reason");
        Intrinsics.checkNotNullParameter(r5, "linkMonitorData");
        JSONObject r7 = new JSONObject();
        r7.put("target_room_id", r1);
        r7.put("target_channel_id", r2);
        r7.put("reason", "normal");
        nd0.c.o(nd0.c.a, r5, r7, 0, null, false, 28);
        System.currentTimeMillis();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m37invoke();
        return Unit.INSTANCE;
    }
}
