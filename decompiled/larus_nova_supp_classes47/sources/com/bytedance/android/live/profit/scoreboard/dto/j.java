package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.livesdk.message.model.k7;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.im.GameToolRoundMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\bB\u0010CJ-\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u0004\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014R\u001b\u0010/\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014R\u001b\u00102\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u0010\u0014R\u001b\u00105\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R\u001b\u00108\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0012\u001a\u0004\b7\u0010\u0019R\u001b\u0010;\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u0019R!\u0010A\u001a\b\u0012\u0004\u0012\u00020=0<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/j;", "Llm2/a;", "Lvh7/c$a;", "Lcom/bytedance/android/live/profit/scoreboard/dto/o;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "miniAppId$delegate", "Ljava/lang/Object;", "getMiniAppId", "()Ljava/lang/String;", "miniAppId", "", "roundId$delegate", "getRoundId", "()J", "roundId", "", "messageType$delegate", "getMessageType", "()I", "messageType", "Lcom/bytedance/android/livesdk/message/model/k7;", "entrance$delegate", "getEntrance", "()Lcom/bytedance/android/livesdk/message/model/k7;", "entrance", "", "shouldShowAuth$delegate", "getShouldShowAuth", "()Z", "shouldShowAuth", "creatorId$delegate", "getCreatorId", "creatorId", "noticeTitle$delegate", "getNoticeTitle", "noticeTitle", "noticeSubtitle$delegate", "getNoticeSubtitle", "noticeSubtitle", "extra$delegate", "getExtra", "extra", "startTime$delegate", "getStartTime", "startTime", "expectFinishTime$delegate", "getExpectFinishTime", "expectFinishTime", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/k;", "players$delegate", "getPlayers", "()Ljava/util/List;", "players", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j extends lm2.a implements vh7.c.a<o>, o, vh7.h {

    @SerializedName("creator_id")
    protected String _$$creatorId;

    @SerializedName("entrance")
    protected k7 _$$entrance;

    @SerializedName("expect_finish_time")
    protected long _$$expectFinishTime;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("message_type")
    protected int _$$messageType;

    @SerializedName("mini_app_id")
    protected String _$$miniAppId;

    @SerializedName("notice_subtitle")
    protected String _$$noticeSubtitle;

    @SerializedName("notice_title")
    protected String _$$noticeTitle;

    @SerializedName("players")
    protected List<k> _$$players;

    @SerializedName("round_id")
    protected long _$$roundId;

    @SerializedName("should_show_auth")
    protected boolean _$$shouldShowAuth;

    @SerializedName("start_time")
    protected long _$$startTime;
    private final transient FlexModelDelegate<o> delegate;

    public j() {
        this.delegate = new FlexModelDelegate(o.class, this);
        this._$$miniAppId = "";
        this._$$creatorId = "";
        this._$$noticeTitle = "";
        this._$$noticeSubtitle = "";
        this._$$extra = "";
        this._$$players = new ArrayList();
        ((o0) this).type = MessageType.GAME_TOOL_ROUND_MESSAGE;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final String getCreatorId() {
        return this._$$creatorId;
    }

    public FlexModelDelegate<o> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final k7 getEntrance() {
        return this._$$entrance;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final long getExpectFinishTime() {
        return this._$$expectFinishTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final int getMessageType() {
        return this._$$messageType;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final String getMiniAppId() {
        return this._$$miniAppId;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final String getNoticeSubtitle() {
        return this._$$noticeSubtitle;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final String getNoticeTitle() {
        return this._$$noticeTitle;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final List<k> getPlayers() {
        return this._$$players;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final long getRoundId() {
        return this._$$roundId;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final boolean getShouldShowAuth() {
        return this._$$shouldShowAuth;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public final long getStartTime() {
        return this._$$startTime;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdk.message.model.k7, java.lang.Object] */
    public j(am3.g r5) {
        this._$$players = new ArrayList();
        this.delegate = new FlexModelDelegate(o.class, this);
        getDelegate().setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = getDelegate().decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            default: goto L7;
        };
    L8:
        this._$$players.add((k) vh7.f.a(r5, k.class));
        goto L3
    L9:
        this._$$expectFinishTime = r5.j();
        goto L3
    L10:
        this._$$startTime = r5.j();
        goto L3
    L11:
        this._$$extra = am3.h.c(r5);
        goto L3
    L12:
        this._$$noticeSubtitle = am3.h.c(r5);
        goto L3
    L13:
        this._$$noticeTitle = am3.h.c(r5);
        goto L3
    L14:
        this._$$creatorId = am3.h.c(r5);
        goto L3
    L15:
        this._$$shouldShowAuth = am3.h.a(r5);
        goto L3
    L16:
        this._$$entrance = vh7.f.a(r5, k7.class);
        goto L3
    L17:
        this._$$messageType = r5.i();
        goto L3
    L18:
        this._$$roundId = r5.j();
        goto L3
    L19:
        this._$$miniAppId = am3.h.c(r5);
        goto L3
    L20:
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L21:
        r5.d(r0);
        getDelegate().setThreadSafe(true);
        if (this._$$miniAppId != null) goto L25;
        this._$$miniAppId = "";
    L25:
        if (this._$$creatorId != null) goto L28;
        this._$$creatorId = "";
    L28:
        if (this._$$noticeTitle != null) goto L31;
        this._$$noticeTitle = "";
    L31:
        if (this._$$noticeSubtitle != null) goto L34;
        this._$$noticeSubtitle = "";
    L34:
        if (this._$$extra != null) goto L37;
        this._$$extra = "";
    L37:
        if (this._$$players.isEmpty() == false) goto L39;
        this._$$players = new ArrayList();
    L39:
        ((o0) this).type = MessageType.GAME_TOOL_ROUND_MESSAGE;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public <R extends vh7.e<o>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castTo(r2);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.o
    public <R extends vh7.e<o>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castToOrNull(r2);
    }
}
