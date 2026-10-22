package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001dR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkmicEnlargeGuestMessage;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "getMsg_type", "()I", "getMsg_type$annotations", "()V", "msg_type", "", "getPlay_modes", "()Ljava/util/List;", "getPlay_modes$annotations", "play_modes", "Lcom/bytedance/android/live/base/model/message/f6;", "getTurn_on_content", "()Lcom/bytedance/android/live/base/model/message/f6;", "getTurn_on_content$annotations", "turn_on_content", "Lcom/bytedance/android/live/base/model/message/e6;", "getTurn_off_content", "()Lcom/bytedance/android/live/base/model/message/e6;", "getTurn_off_content$annotations", "turn_off_content", "Lcom/bytedance/android/live/base/model/message/d6;", "getChange_user_content", "()Lcom/bytedance/android/live/base/model/message/d6;", "getChange_user_content$annotations", "change_user_content", "LinkmicEnlargeGuestMessageType", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicEnlargeGuestMessage extends vh7.c<ILinkmicEnlargeGuestMessage>, t {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkmicEnlargeGuestMessage$LinkmicEnlargeGuestMessageType;", "", "EnlargeGuestMessageType_Unkown", "EnlargeGuestMessageType_TurnOn", "EnlargeGuestMessageType_TurnOff", "EnlargeGuestMessageType_ChangeUser", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicEnlargeGuestMessageType extends Enum<LinkmicEnlargeGuestMessageType> {
        public static final LinkmicEnlargeGuestMessageType EnlargeGuestMessageType_ChangeUser = null;
        public static final LinkmicEnlargeGuestMessageType EnlargeGuestMessageType_TurnOff = null;
        public static final LinkmicEnlargeGuestMessageType EnlargeGuestMessageType_TurnOn = null;
        public static final LinkmicEnlargeGuestMessageType EnlargeGuestMessageType_Unkown = null;
        public static final /* synthetic */ LinkmicEnlargeGuestMessageType[] a = null;

        static {
            LinkmicEnlargeGuestMessageType r1 = new LinkmicEnlargeGuestMessageType("EnlargeGuestMessageType_Unkown", 0);
            EnlargeGuestMessageType_Unkown = r1;
            LinkmicEnlargeGuestMessageType r2 = new LinkmicEnlargeGuestMessageType("EnlargeGuestMessageType_TurnOn", 1);
            EnlargeGuestMessageType_TurnOn = r2;
            LinkmicEnlargeGuestMessageType r3 = new LinkmicEnlargeGuestMessageType("EnlargeGuestMessageType_TurnOff", 2);
            EnlargeGuestMessageType_TurnOff = r3;
            LinkmicEnlargeGuestMessageType r4 = new LinkmicEnlargeGuestMessageType("EnlargeGuestMessageType_ChangeUser", 3);
            EnlargeGuestMessageType_ChangeUser = r4;
            a = new LinkmicEnlargeGuestMessageType[]{r1, r2, r3, r4};
        }

        public static LinkmicEnlargeGuestMessageType valueOf(String r1) {
            return (LinkmicEnlargeGuestMessageType) r27.a.a(LinkmicEnlargeGuestMessageType.class, r1);
        }

        public static LinkmicEnlargeGuestMessageType[] values() {
            return (LinkmicEnlargeGuestMessageType[]) a.clone();
        }

        public LinkmicEnlargeGuestMessageType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    @FieldName(name = "change_user_content")
    d6 getChange_user_content();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "msg_type")
    int getMsg_type();

    @FieldName(name = "play_modes")
    List<Integer> getPlay_modes();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    @FieldName(name = "turn_off_content")
    e6 getTurn_off_content();

    @FieldName(name = "turn_on_content")
    f6 getTurn_on_content();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setBaseMessage(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setHttpSendTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setLocalInsertMsg(boolean r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setReceiveTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
