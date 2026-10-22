package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/VSLiveShowMessageRepoManager;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/BaseMessageRepoManager;", "Ltlc/d;", "message", BuildConfig.FLAVOR, "filterFirstRoomMessage", BuildConfig.FLAVOR, "onCleared", "Lcom/bytedance/android/live/base/model/message/t;", "msg", "onInsertLocalMessage", "canReceiveMessage", BuildConfig.FLAVOR, "msgMethod", "onDynamicAddMessageType", "Lvlc/l;", "actualMessageListener", "Lvlc/l;", "Lvlc/d;", "normalRepo", "Lvlc/d;", BuildConfig.FLAVOR, "normalMessageTypes", "Ljava/util/List;", "messageManager", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lq92/a;", "config", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lq92/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLiveShowMessageRepoManager extends BaseMessageRepoManager {
    private final l actualMessageListener;
    private final DataCenter dataCenter;
    private final d messageManager;
    private final List<String> normalMessageTypes;
    private final d normalRepo;

    public static final class a implements l {
        public final /* synthetic */ VSLiveShowMessageRepoManager a;

        public a(VSLiveShowMessageRepoManager r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            this.a.notifyMessage(r2);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onCleared() {
        super.onCleared();
        d r0 = this.normalRepo;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this.actualMessageListener);
    L5:
        d r1 = this.messageManager;
        if (r1 == null) goto L9;
        r1.F(this);
        return;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    private final boolean filterFirstRoomMessage(tlc.d r6) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L5;
        o r1 = IRoomContextService.a.a(r0, this.dataCenter, 0, 2);
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r6.isFromFirstRequest() == false) goto L24;
        m r2 = r1.c2();
        if (r2 == null) goto L24;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L24;
        m r3 = r1.l2();
        if (r3 == null) goto L24;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L24;
        if ((r6 instanceof t) == false) goto L24;
        if (Intrinsics.areEqual(((t) r6).getMessageMethod(), "WebcastRoomMessage") == false) goto L24;
        return true;
    L24:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public boolean canReceiveMessage(tlc.d r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (filterFirstRoomMessage(r4) == false) goto L6;
        return false;
    L6:
        if ((r4 instanceof t) == false) goto L13;
        t r5 = (t) r4;
        if (this.normalMessageTypes.contains(r5.getMessageMethod()) == false) goto L10;
    L11:
        return true;
    L10:
        if (getDynamicMessageTypes().contains(r5.getMessageMethod()) == true) goto L11;
        return false;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onDynamicAddMessageType(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgMethod");
        d r0 = this.normalRepo;
        if (r0 == null) goto L6;
        r0.addMessageListener(r3, this.actualMessageListener);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onInsertLocalMessage(t r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        tlc.d r3 = (tlc.d) r2;
        if (canReceiveMessage(r3) == false) goto L6;
        notifyMessage(r3);
        return;
    }

    public VSLiveShowMessageRepoManager(DataCenter r5, final q92.a r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "config");
        this.dataCenter = r5;
        a r0 = new a(this);
        this.actualMessageListener = r0;
        d r2 = (d) r5.get("data_message_manager");
        this.normalRepo = r2;
        d r7 = (d) r5.get("data_message_manager");
        this.messageManager = r7;
        ArrayList r1 = new ArrayList();
        r1.add("WebcastChatMessage");
        r1.add("WebcastScreenChatMessage");
        r1.add("WebcastAudioChatMessage");
        r1.add("WebcastAudioChatMessage");
        r1.add("WebcastRoomMessage");
        r1.add("WebcastMediaRoomNoticeMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r1, "WebcastAnchorBoostMessage", new VSLiveShowMessageRepoManager$$special$$inlined$apply$lambda$1(r6));
        r1.add("WebcastCommonTextMessage");
        r1.add("--default--");
        r1.add("WebcastImDeleteMessage");
        r1.add("WebcastLikeMessage");
        r1.add("WebcastSocialMessage");
        r1.add("WebcastMemberMessage");
        Unit r8 = Unit.INSTANCE;
        this.normalMessageTypes = r1;
        if (r2 == null) goto L5;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.b(r2, r1, r0);
    L5:
        if (r7 == null) goto L8;
        r7.n(this);
        return;
    }
}
