package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkmicAnnounceMessage;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "Lcom/bytedance/android/live/base/model/message/ILinkmicAnnounceMessage$b;", "getShowingAnnounce", "()Lcom/bytedance/android/live/base/model/message/ILinkmicAnnounceMessage$b;", "setShowingAnnounce", "(Lcom/bytedance/android/live/base/model/message/ILinkmicAnnounceMessage$b;)V", "getShowingAnnounce$annotations", "()V", "showingAnnounce", "", "getAnnounceMessageType", "()I", "setAnnounceMessageType", "(I)V", "getAnnounceMessageType$annotations", "announceMessageType", "b", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicAnnounceMessage extends vh7.c<ILinkmicAnnounceMessage>, c3 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR6\u0010&\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010#j\n\u0012\u0004\u0012\u00020$\u0018\u0001`%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR6\u0010/\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010#j\n\u0012\u0004\u0012\u00020$\u0018\u0001`%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+¨\u00064"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkmicAnnounceMessage$b;", "", "", "title", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "", "state", "I", "getState", "()I", "setState", "(I)V", "showState", "getShowState", "setShowState", "", "announceId", "J", "getAnnounceId", "()J", "setAnnounceId", "(J)V", "updatedTime", "getUpdatedTime", "setUpdatedTime", "announceSnapShotId", "getAnnounceSnapShotId", "setAnnounceSnapShotId", "", "Lpy/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "imageList", "Ljava/util/List;", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "auditReason", "getAuditReason", "setAuditReason", "imageListThumb", "getImageListThumb", "setImageListThumb", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b implements vh7.h {

        @SerializedName("announce_id")
        protected long announceId;

        @SerializedName("announce_snapshot_id")
        protected String announceSnapShotId;

        @SerializedName("audit_reason")
        protected String auditReason;

        @SerializedName("content")
        protected String content;

        @SerializedName("image_list")
        protected List<? extends py.k> imageList;

        @SerializedName("image_list_thumb")
        protected List<? extends py.k> imageListThumb;

        @SerializedName("show_state")
        protected int showState;

        @SerializedName("state")
        protected int state;

        @SerializedName("title")
        protected String title;

        @SerializedName("updated_time")
        protected long updatedTime;

        public b() {
        }

        public final String a() {
            return this.title;
        }

        public b(am3.g r5) {
            this.imageList = new ArrayList();
            this.imageListThumb = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L18;
            switch(r2) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            List<? extends py.k> r3 = this.imageListThumb;
        L10:
            r3.add(vh7.f.a(r5, py.k.class));
            goto L3
        L8:
            this.auditReason = am3.h.c(r5);
            goto L3
        L9:
            r3 = this.imageList;
            goto L10
        L11:
            this.announceSnapShotId = am3.h.c(r5);
            goto L3
        L12:
            this.updatedTime = r5.j();
            goto L3
        L13:
            this.announceId = r5.j();
            goto L3
        L14:
            this.showState = r5.i();
            goto L3
        L15:
            this.state = r5.i();
            goto L3
        L16:
            this.content = am3.h.c(r5);
            goto L3
        L17:
            this.title = am3.h.c(r5);
            goto L3
        L6:
            am3.h.e(r5);
            goto L3
        L18:
            r5.d(r0);
        }
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "message_type")
    int getAnnounceMessageType();

    @Override // com.bytedance.android.live.base.model.message.c3
    /* synthetic */ m0 getCommon();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getConsumeTime();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getDecodeEndTime();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getEnqueueDispatchTime();

    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "showing_announce")
    b getShowingAnnounce();

    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "message_type#setter")
    void setAnnounceMessageType(int r1);

    /* synthetic */ void setCommon(m0 r1);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setGeneralMessageType(int r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    @FieldName(name = "showing_announce#setter")
    void setShowingAnnounce(b r1);

    @Override // com.bytedance.android.live.base.model.message.d3
    /* synthetic */ void setTimestamp(long r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
