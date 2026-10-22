package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.message.model.k7;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u00017R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010#\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\b\u001a\u0004\b!\u0010\u0006R\u001a\u0010&\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b$\u0010\u0006R\u001a\u0010)\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\b\u001a\u0004\b'\u0010\u0006R\u001a\u0010,\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\b\u001a\u0004\b*\u0010\fR\u001a\u0010/\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\b\u001a\u0004\b-\u0010\fR \u00105\u001a\b\u0012\u0004\u0012\u000201008&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\b\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/o;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getMiniAppId", "()Ljava/lang/String;", "getMiniAppId$annotations", "()V", "miniAppId", "", "getRoundId", "()J", "getRoundId$annotations", "roundId", "", "getMessageType", "()I", "getMessageType$annotations", "messageType", "Lcom/bytedance/android/livesdk/message/model/k7;", "getEntrance", "()Lcom/bytedance/android/livesdk/message/model/k7;", "getEntrance$annotations", "entrance", "", "getShouldShowAuth", "()Z", "getShouldShowAuth$annotations", "shouldShowAuth", "getCreatorId", "getCreatorId$annotations", "creatorId", "getNoticeTitle", "getNoticeTitle$annotations", "noticeTitle", "getNoticeSubtitle", "getNoticeSubtitle$annotations", "noticeSubtitle", "getExtra", "getExtra$annotations", "extra", "getStartTime", "getStartTime$annotations", "startTime", "getExpectFinishTime", "getExpectFinishTime$annotations", "expectFinishTime", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/k;", "getPlayers", "()Ljava/util/List;", "getPlayers$annotations", "players", "Companion", "a", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o extends vh7.c<o>, yh6.c {
    public static final a Companion = null;
    public static final int ROUND_MESSAGE_DEFAULT = 0;
    public static final int ROUND_MESSAGE_FINISH = 2;
    public static final int ROUND_MESSAGE_INVITE_DENY = 4;
    public static final int ROUND_MESSAGE_INVITE_RECV = 3;
    public static final int ROUND_MESSAGE_START = 1;

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

    /* synthetic */ m0 getCommonData();

    @FieldName(name = "creator_id")
    String getCreatorId();

    @FieldName(name = "entrance")
    k7 getEntrance();

    @FieldName(name = "expect_finish_time")
    long getExpectFinishTime();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "message_type")
    int getMessageType();

    @FieldName(name = "mini_app_id")
    String getMiniAppId();

    @FieldName(name = "notice_subtitle")
    String getNoticeSubtitle();

    @FieldName(name = "notice_title")
    String getNoticeTitle();

    @FieldName(name = "players")
    List<k> getPlayers();

    @FieldName(name = "round_id")
    long getRoundId();

    @FieldName(name = "should_show_auth")
    boolean getShouldShowAuth();

    @FieldName(name = "start_time")
    long getStartTime();

    /* synthetic */ void setCommonData(m0 r1);
}
