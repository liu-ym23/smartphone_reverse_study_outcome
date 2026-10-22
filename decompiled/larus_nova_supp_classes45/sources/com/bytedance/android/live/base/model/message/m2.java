package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0014R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/m2;", "Lvh7/c;", "Ltlc/d;", "", "getMsgType", "()I", "getMsgType$annotations", "()V", "msgType", "Lcom/bytedance/android/live/base/model/message/k2;", "getConfigContent", "()Lcom/bytedance/android/live/base/model/message/k2;", "getConfigContent$annotations", "configContent", "Lcom/bytedance/android/live/base/model/message/l2;", "getLikeContent", "()Lcom/bytedance/android/live/base/model/message/l2;", "getLikeContent$annotations", "likeContent", "Companion", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m2 extends vh7.c<m2>, tlc.d {
    public static final a Companion = null;
    public static final int MSG_TYPE_CONFIG = 1;
    public static final int MSG_TYPE_LIKE = 2;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "config_content")
    k2 getConfigContent();

    /* synthetic */ long getDelayDispatchMs();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ int getIntType();

    @FieldName(name = "like_content")
    l2 getLikeContent();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "msg_type")
    int getMsgType();

    /* synthetic */ int getPriority();

    /* synthetic */ long getRoomId();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setReceiveTime(long r1);
}
