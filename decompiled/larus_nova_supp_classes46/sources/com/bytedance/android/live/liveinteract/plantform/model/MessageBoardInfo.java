package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.MsgBoardItemInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R \u0010\u001f\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/MessageBoardInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "giftId", "", "getGiftId", "()J", "setGiftId", "(J)V", "giftMoney", "", "getGiftMoney", "()I", "setGiftMoney", "(I)V", "id", "getId", "setId", "msgDisappearTime", "getMsgDisappearTime", "setMsgDisappearTime", "processStatus", "getProcessStatus", "setProcessStatus", "sender", "Lcom/bytedance/android/live/base/model/user/User;", "getSender", "()Lcom/bytedance/android/live/base/model/user/User;", "setSender", "(Lcom/bytedance/android/live/base/model/user/User;)V", "MsgBoardItemProcessStatus", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MessageBoardInfo extends FlexModelBase<IMessageBoardInfo> implements IMessageBoardInfo, vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("gift_id")
    protected long giftId;
    private int giftMoney;

    @SerializedName("id")
    protected long id;

    @SerializedName("msg_disappear_time")
    protected long msgDisappearTime;

    @SerializedName("process_status")
    protected int processStatus;

    @SerializedName("sender")
    protected User sender;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/MessageBoardInfo$MsgBoardItemProcessStatus;", "", "", "value", "I", "getValue", "()I", "NOT_PROCESSED", "PROCESSED", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MsgBoardItemProcessStatus extends Enum<MsgBoardItemProcessStatus> {
        public static final MsgBoardItemProcessStatus NOT_PROCESSED = null;
        public static final MsgBoardItemProcessStatus PROCESSED = null;
        public static final /* synthetic */ MsgBoardItemProcessStatus[] a = null;
        private final int value;

        static {
            MsgBoardItemProcessStatus r1 = new MsgBoardItemProcessStatus("NOT_PROCESSED", 0, 0);
            NOT_PROCESSED = r1;
            MsgBoardItemProcessStatus r2 = new MsgBoardItemProcessStatus("PROCESSED", 1, 1);
            PROCESSED = r2;
            a = new MsgBoardItemProcessStatus[]{r1, r2};
        }

        public static MsgBoardItemProcessStatus valueOf(String r1) {
            return (MsgBoardItemProcessStatus) r27.a.a(MsgBoardItemProcessStatus.class, r1);
        }

        public static MsgBoardItemProcessStatus[] values() {
            return (MsgBoardItemProcessStatus[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public MsgBoardItemProcessStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public MessageBoardInfo() {
        super(IMessageBoardInfo.class);
        this.content = "";
        this.processStatus = MsgBoardItemProcessStatus.NOT_PROCESSED.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public /* bridge */ /* synthetic */ IBaseUser getSender() {
        return m256getSender();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public long getGiftId() {
        return this.giftId;
    }

    public final int getGiftMoney() {
        return this.giftMoney;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public long getId() {
        return this.id;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public long getMsgDisappearTime() {
        return this.msgDisappearTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public int getProcessStatus() {
        return this.processStatus;
    }

    /* JADX INFO: renamed from: getSender, reason: collision with other method in class */
    public User m256getSender() {
        return this.sender;
    }

    public MessageBoardInfo(am3.g r7) {
        super(IMessageBoardInfo.class);
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L24;
        am3.g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        this.id = r7.j();
        goto L3
    L8:
        if (r3 != 3) goto L10;
        this.sender = new User(r7);
        goto L3
    L10:
        if (r3 != 4) goto L12;
        this.content = am3.h.c(r7);
        goto L3
    L12:
        if (r3 != 5) goto L14;
        this.processStatus = r7.i();
        r0 = r0 | true;
        goto L3
    L14:
        if (r3 != 6) goto L16;
        this.giftId = r7.j();
        goto L3
    L16:
        if (r3 != 7) goto L17;
        this.msgDisappearTime = r7.j();
        goto L3
    L17:
        am3.h.d(r4, r7);
        goto L3
    L24:
        r7.d(r1);
        setThreadSafe(true);
        if (this.content != null) goto L28;
        this.content = "";
    L28:
        if ((r0 & true) == true) goto L52;
        this.processStatus = MsgBoardItemProcessStatus.NOT_PROCESSED.getValue();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public void setContent(String r1) {
        this.content = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public void setGiftId(long r1) {
        this.giftId = r1;
    }

    public final void setGiftMoney(int r1) {
        this.giftMoney = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo
    public void setId(long r1) {
        this.id = r1;
    }

    public void setMsgDisappearTime(long r1) {
        this.msgDisappearTime = r1;
    }

    public void setProcessStatus(int r1) {
        this.processStatus = r1;
    }

    public void setSender(User r1) {
        this.sender = r1;
    }
}
