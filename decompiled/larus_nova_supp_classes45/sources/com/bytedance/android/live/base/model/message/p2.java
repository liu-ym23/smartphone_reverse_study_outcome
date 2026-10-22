package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016J\b\u0010\u0004\u001a\u00020\u0003H&R\u0014\u0010\b\u001a\u00020\u00058gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/base/model/message/p2;", "Lvh7/c;", "Ltlc/d;", "", "getMessageId", "", "getMsgType", "()I", "msgType", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "teamFightInfo", "Lcom/bytedance/android/live/base/model/message/o2;", "getFinishContent", "()Lcom/bytedance/android/live/base/model/message/o2;", "finishContent", "Lcom/bytedance/android/live/base/model/message/n2;", "getCreateContent", "()Lcom/bytedance/android/live/base/model/message/n2;", "createContent", "Companion", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p2 extends vh7.c<p2>, tlc.d {
    public static final a Companion = null;
    public static final int TEAM_FIGHT_MESSAGE_CREATE = 1;
    public static final int TEAM_FIGHT_MESSAGE_FINISH = 5;
    public static final int TEAM_FIGHT_MESSAGE_NONE = 0;
    public static final int TEAM_FIGHT_MESSAGE_PUNISH = 4;
    public static final int TEAM_FIGHT_MESSAGE_SHOWING = 6;
    public static final int TEAM_FIGHT_MESSAGE_START = 2;
    public static final int TEAM_FIGHT_MESSAGE_UPDATE = 3;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "create_content")
    n2 getCreateContent();

    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "finish_content")
    o2 getFinishContent();

    /* synthetic */ int getGeneralMessageType();

    /* synthetic */ int getIntType();

    /* synthetic */ int getMessageFrom();

    long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "msg_type")
    int getMsgType();

    /* synthetic */ int getPriority();

    /* synthetic */ long getRoomId();

    @FieldName(name = "teamfight_info")
    com.bytedance.android.live.liveinteract.multiscene.a getTeamFightInfo();

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
