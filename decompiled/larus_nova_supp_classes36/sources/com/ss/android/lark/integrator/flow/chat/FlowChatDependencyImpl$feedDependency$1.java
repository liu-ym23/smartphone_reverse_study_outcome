package com.ss.android.lark.integrator.flow.chat;

import aqb.j;
import aza.d;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.bytedance.lark.pb.feed.v1.UpdateFeedCardUnreadRequest;
import com.bytedance.lark.pb.feed.v1.UpdateFeedCardUnreadResponse;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import dagger.hilt.EntryPoints;
import egb.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import qeb.b;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatDependencyImpl$feedDependency$1 implements c {
    public final List<j> a;
    public com.ss.android.lark.integrator.flow.chat.a b;

    public static final class a implements SdkSender.IParser<UpdateFeedCardUnreadResponse> {
        public a() {
        }

        public final Object parse(byte[] r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            return (UpdateFeedCardUnreadResponse) UpdateFeedCardUnreadResponse.ADAPTER.decode(r2);
        }
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void g() {
    }

    public final int getBadge() {
        return ((Number) BuildersKt.runBlocking$default(null, new FlowChatDependencyImpl$feedDependency$1$getBadge$1(null), 1, null)).intValue();
    }

    public FlowChatDependencyImpl$feedDependency$1() {
        this.a = new ArrayList();
    }

    public final void a(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.a).contains(r3) == true) goto L8;
        ((ArrayList) this.a).add(r3);
    L8:
        if (this.b != null) goto L25;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L11:
        if (this.b != null) goto L19;
        com.ss.android.lark.integrator.flow.chat.a r4 = new com.ss.android.lark.integrator.flow.chat.a(this);     // Catch: Throwable -> L22
        this.b = r4;     // Catch: Throwable -> L22
        d r0 = ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(d.class);     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L19;
        r0.J5(r4);     // Catch: Exception -> L17 Throwable -> L22
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L17 Throwable -> L22
    L17:
        e = move-exception;
        Log.e("FlowChatDependencyImpl", e);     // Catch: Throwable -> L22
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L19:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    }

    public final void c(com.ss.android.lark.chat.chatwindow.chat.v2.push.c.b r3) {
        TypeIntrinsics.asMutableCollection(this.a).remove(r3);
        if (((ArrayList) this.a).isEmpty() == false) goto L17;
        com.ss.android.lark.integrator.flow.chat.a r4 = this.b;
        if (r4 != null) goto L15;
        return;
    L15:
        d r0 = ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(d.class);     // Catch: Exception -> L11
        if (r0 == null) goto L13;
        r0.J5(r4);     // Catch: Exception -> L11
    L13:
        this.b = null;
        return;
    L11:
        e = move-exception;
        Log.e("FlowChatDependencyImpl", e);
        goto L13
    }

    public final /* bridge */ /* synthetic */ void f(Long r1, Long r2) {
        r1.longValue();
        r2.longValue();
    }

    public final void b(String r3, FeedCard.EntityType r4, boolean r5, UpdateUnreadStatusScene r6) {
        Intrinsics.checkNotNullParameter(r6, "updateUnreadStatusScene");
        Log.i("FlowChatDependencyImpl", "update feed card read status,feedid: " + r3 + ",type:" + r4 + ",targetUnreadStatus:" + r5);
        if (r3 == null) goto L16;
        if (r4 == null) goto L17;
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r6, "actionScene");
        if (r5 == true) goto L10;
    L14:
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_FEED_CARD_UNREAD, new UpdateFeedCardUnreadRequest.Builder().id(r3).entity_type(r4).mark_as_unread(Boolean.valueOf(r5)), new FlowChatDependencyImpl$feedDependency$1$updateFeedCardUnreadStatus$1(), new a());
        return;
    L10:
        if (r6 != UpdateUnreadStatusScene.FEED_ITEM) goto L12;
        s5c.a r7 = z5c.b.c;
    L13:
        s5c.a r1 = r.T2;
        s5c.a r2 = p3.c;
        r1.getClass();
        JSONObject r8 = s5c.d.b.b(r1, r2).plus(r7).toJson();
        qeb.c.a(r8, false);
        Statistics.sendEvent("feed_press_click", r8);
        goto L14
    L12:
        r7 = z5c.b.d;
        goto L13
    L17:
        return;
    }
}
