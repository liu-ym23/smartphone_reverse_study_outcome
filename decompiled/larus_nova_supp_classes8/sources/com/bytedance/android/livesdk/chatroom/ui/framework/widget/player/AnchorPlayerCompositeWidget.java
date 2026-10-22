package com.bytedance.android.livesdk.chatroom.ui.framework.widget.player;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.h;
import com.bytedance.android.livesdk.config.n80;
import com.bytedance.android.livesdk.config.qt0;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.streamcontrol.StreamControlInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uf2.b1;
import zg1.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/player/AnchorPlayerCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/player/PlayerCompositeWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPlayerCompositeWidget extends PlayerCompositeWidget {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.observeForever("cmd_widget_loaded", this);
        return;
    }

    public AnchorPlayerCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void Bq(k3 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Logger.d("PlayerCompositeWidget", "horizontal=" + r3.a + " videoBottom=" + r3.b);
        super.Bq(r3);
        h.a(((Widget) this).dataCenter, "updateVideoDirection");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void onChanged(KVData r4) {
        super.onChanged(r4);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L27;
        if (r4 == null) goto L9;
        String r1 = r4.getKey();
    L10:
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.hashCode() == (-1836833765)) goto L16;
        return;
    L16:
        if (r1.equals("cmd_widget_loaded") == true) goto L18;
        return;
    L18:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r4) == true) goto L20;
        return;
    L20:
        if (qt0.a.getValue().a() == false) goto L26;
        ((SingleSubscribeProxy) Single.timer(3, TimeUnit.SECONDS).observeOn(Schedulers.single()).as(AutoDispose.bind(this))).subscribe(new a(this));
        return;
    L26:
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final boolean yq(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual("push", r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void zq(String r6, StreamControlInfo.ControlParams r7) {
        Intrinsics.checkNotNullParameter(r6, "controlMessage");
        Intrinsics.checkNotNullParameter(r7, "controlParams");
        ALogger.d("PlayerCompositeWidget", "handleStreamControlMessage type: " + r7.type + ", mIsAnchor: true");
        String r0 = r7.type;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("push", r0) == false) goto L48;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        if (r1 == null) goto L10;
        com.bytedance.android.live.pushstream.d r2 = r1.getLiveStream();
    L11:
        ALogger.d("PlayerCompositeWidget", "handleStreamControlMessage onLiveSdkParamsIssue mLiveStream: " + r2);
        if (r2 != null) goto L14;
    L45:
        ((Widget) this).dataCenter.put("data_interact_anchor_param_change", r6);
        ILinkServiceExternal r8 = k.f(ILinkServiceExternal.class);
        if (r8 == null) goto L51;
        r8.updateInteractAnchorParam(r6);
        return;
    L51:
        return;
    L14:
        if (n80.a.getValue().booleanValue() == true) goto L16;
        r2.m1(r6);
        goto L45
    L16:
        if (Intrinsics.areEqual("push_changeUrl", r7.command) == false) goto L31;
        JsonObject r9 = GsonProtectorUtils.parse(new JsonParser(), r7.params).getAsJsonObject();
        if (r9.has("sdk_params") == false) goto L45;
        JsonObject r10 = GsonProtectorUtils.parse(new JsonParser(), r9.get("sdk_params").getAsString()).getAsJsonObject();
        if (r10.has("changeUrl") == false) goto L45;
        JsonObject r11 = r10.get("changeUrl").getAsJsonObject();
        if (r11.has("url") == false) goto L45;
        String r12 = r11.get("url").getAsString();
        LiveRequestSourceRole r3 = LiveRequestSourceRole.Business;
        r2.C0(new uv0.a(r3, "AnchorPlayerCompositeWidget.handleStreamControlMessage.stop", null));
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L29;
        Room r5 = z.o(r4);
        if (r5 == null) goto L29;
        if (r5.isVirtualLive == true) goto L45;
    L29:
        r2.B0(r12, new uv0.a(r3, "AnchorPlayerCompositeWidget.handleStreamControlMessage.start", null));
        goto L45
    L31:
        if (Intrinsics.areEqual("push_changeClarity", r7.command) == false) goto L43;
        JsonObject r13 = GsonProtectorUtils.parse(new JsonParser(), r7.params).getAsJsonObject();
        if (r13.has("sdk_params") == false) goto L45;
        JsonObject r14 = GsonProtectorUtils.parse(new JsonParser(), r13.get("sdk_params").getAsString()).getAsJsonObject();
        if (r14.has("changeClarity") == false) goto L45;
        JsonObject r15 = r14.get("changeClarity").getAsJsonObject();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r16 = ILiveWrappedLivePusher.a.b();
        if (r16 == null) goto L42;
        b1 r17 = r16.newTEBundle();
        if (r17 == null) goto L50;
        Cq(r17, r15, "defaultBitrate");
        Cq(r17, r15, "maxBitrate");
        Cq(r17, r15, "minBitrate");
        Cq(r17, r15, "height");
        Cq(r17, r15, "width");
        Cq(r17, r15, "fps");
        r2.getLiveCore().S();
        goto L45
    L50:
        return;
    L42:
        return;
    L43:
        r2.m1(r6);
        goto L45
    L10:
        r2 = null;
        goto L11
    L48:
        ALogger.e("PlayerCompositeWidget", "handleStreamControlMessage type is error: " + r7.type);
    }

    public final void Cq(b1 r2, JsonObject r3, String r4) {
        if (r3.has(r4) == false) goto L6;
        r3.get(r4).getAsInt();
        r2.b();
        return;
    }
}
