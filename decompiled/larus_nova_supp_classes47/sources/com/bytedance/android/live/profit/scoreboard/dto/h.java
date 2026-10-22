package com.bytedance.android.live.profit.scoreboard.dto;

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
@ProtoMessage("webcast.im.GameToolCounterMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\b*\u0010+J-\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010 \u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010#\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0019R!\u0010)\u001a\b\u0012\u0004\u0012\u00020%0$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/h;", "Llm2/a;", "Lvh7/c$a;", "Lcom/bytedance/android/live/profit/scoreboard/dto/n;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "miniAppId$delegate", "Ljava/lang/Object;", "getMiniAppId", "()Ljava/lang/String;", "miniAppId", "", "roundId$delegate", "getRoundId", "()J", "roundId", "updateTime$delegate", "getUpdateTime", "updateTime", "startTime$delegate", "getStartTime", "startTime", "expectFinishTime$delegate", "getExpectFinishTime", "expectFinishTime", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/i;", "players$delegate", "getPlayers", "()Ljava/util/List;", "players", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h extends lm2.a implements vh7.c.a<n>, n, vh7.h {

    @SerializedName("expect_finish_time")
    protected long _$$expectFinishTime;

    @SerializedName("mini_app_id")
    protected String _$$miniAppId;

    @SerializedName("players")
    protected List<i> _$$players;

    @SerializedName("round_id")
    protected long _$$roundId;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("update_time")
    protected long _$$updateTime;
    private final transient FlexModelDelegate<n> delegate;

    public h() {
        this.delegate = new FlexModelDelegate(n.class, this);
        this._$$miniAppId = "";
        this._$$players = new ArrayList();
        ((o0) this).type = MessageType.GAME_TOOL_COUNTER_MESSAGE;
    }

    public FlexModelDelegate<n> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public final long getExpectFinishTime() {
        return this._$$expectFinishTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public final String getMiniAppId() {
        return this._$$miniAppId;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public final List<i> getPlayers() {
        return this._$$players;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public final long getRoundId() {
        return this._$$roundId;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public final long getUpdateTime() {
        return this._$$updateTime;
    }

    public h(am3.g r5) {
        this._$$players = new ArrayList();
        this.delegate = new FlexModelDelegate(n.class, this);
        getDelegate().setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = getDelegate().decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L7;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$players.add((i) vh7.f.a(r5, i.class));
        goto L3
    L9:
        this._$$expectFinishTime = r5.j();
        goto L3
    L10:
        this._$$startTime = r5.j();
        goto L3
    L11:
        this._$$updateTime = r5.j();
        goto L3
    L12:
        this._$$roundId = r5.j();
        goto L3
    L13:
        this._$$miniAppId = am3.h.c(r5);
        goto L3
    L14:
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        getDelegate().setThreadSafe(true);
        if (this._$$miniAppId != null) goto L19;
        this._$$miniAppId = "";
    L19:
        if (this._$$players.isEmpty() == false) goto L21;
        this._$$players = new ArrayList();
    L21:
        ((o0) this).type = MessageType.GAME_TOOL_COUNTER_MESSAGE;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public <R extends vh7.e<n>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castTo(r2);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.n
    public <R extends vh7.e<n>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) getDelegate().castToOrNull(r2);
    }
}
