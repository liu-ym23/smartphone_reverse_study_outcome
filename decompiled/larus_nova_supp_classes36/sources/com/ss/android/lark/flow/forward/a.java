package com.ss.android.lark.flow.forward;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.bytedance.lark.pb.feed.v1.RecentVisitTarget;
import com.bytedance.lark.pb.feed.v1.SetRecentVisitTargetsRequest;
import com.bytedance.lark.pb.im.v1.SendShareThreadResponse;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ ForwardTools.RecentVisitTargetType b;

    public /* synthetic */ a(String r1, ForwardTools.RecentVisitTargetType r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        ForwardTools.RecentVisitTargetType r1 = this.b;
        if (TextUtils.isEmpty(r0) == true) goto L14;
        SetRecentVisitTargetsRequest.Builder r4 = new SetRecentVisitTargetsRequest.Builder();
        Log.i("Android_Recent_Visit", "set recent visit feedId is " + r0 + " targetType is " + ForwardTools.RecentVisitTargetType.access$000(r1));     // Catch: Exception -> L8
        r4.targets.add(new RecentVisitTarget.Builder().target_id(r0).feed_entity_type(FeedCard.EntityType.fromValue(ForwardTools.RecentVisitTargetType.access$000(r1))).build());     // Catch: Exception -> L8
    L10:
        ForwardTools.AnonymousClass1 r2 = new ForwardTools.AnonymousClass1();
        Command r3 = Command.SET_RECENT_VISIT_TARGETS;
        final ProtoAdapter r5 = SendShareThreadResponse.ADAPTER;
        Objects.requireNonNull(r5);
        SdkSender.asynSendRequestNonWrap(r3, r4, r2, new b(r5));
        return;
    L8:
        e = move-exception;
        Log.e("Android_Recent_Visit", "set recent visit feedId is invalid", e, true);
        goto L10
    }
}
