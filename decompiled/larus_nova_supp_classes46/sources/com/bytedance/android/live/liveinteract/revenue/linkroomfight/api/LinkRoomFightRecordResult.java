package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.multilink.base.model.f;
import com.bytedance.android.livesdk.multilink.base.model.v;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ResultType;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightRecordResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/v;", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightRecordResult$BattleRecord;", "recordList", "Ljava/util/List;", "getRecordList", "()Ljava/util/List;", "setRecordList", "(Ljava/util/List;)V", "<init>", "()V", "BattleRecord", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightRecordResult extends FlexModelBase<v> implements v, h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("records")
    protected List<BattleRecord> recordList;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightRecordResult$BattleRecord;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/f;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "rivalUser", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getRivalUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setRivalUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "finishTime", "J", "getFinishTime", "()J", "setFinishTime", "(J)V", "", "_battleResult", "I", "get_battleResult", "()I", "set_battleResult", "(I)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ResultType;", "getBattleResultType", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ResultType;", "battleResultType", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class BattleRecord extends FlexModelBase<f> implements f, h {

        @SerializedName("battle_result")
        protected int _battleResult;

        @SerializedName("finish_time")
        protected long finishTime;

        @SerializedName("rival_user")
        protected IBaseUser rivalUser;

        public BattleRecord() {
            super(f.class);
        }

        public final ResultType getBattleResultType() {
            return ResultType.Companion.fromInt(get_battleResult());
        }

        public long getFinishTime() {
            return this.finishTime;
        }

        public IBaseUser getRivalUser() {
            return this.rivalUser;
        }

        public int get_battleResult() {
            return this._battleResult;
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
        public BattleRecord(g r6) {
            super(f.class);
            setThreadSafe(false);
            long r0 = r6.c();
        L3:
            int r2 = r6.f();
            if (r2 == (-1)) goto L15;
            g.a r3 = decodeExtensionFields(r2, r6);
            if (r2 != 1) goto L8;
            this.rivalUser = vh7.f.a(r6, IBaseUser.class);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.finishTime = r6.j();
            goto L3
        L10:
            if (r2 != 3) goto L11;
            this._battleResult = r6.i();
            goto L3
        L11:
            am3.h.d(r3, r6);
            goto L3
        L15:
            r6.d(r0);
            setThreadSafe(true);
        }

        public void setFinishTime(long r1) {
            this.finishTime = r1;
        }

        public void setRivalUser(IBaseUser r1) {
            this.rivalUser = r1;
        }

        public void set_battleResult(int r1) {
            this._battleResult = r1;
        }
    }

    public LinkRoomFightRecordResult() {
        super(v.class);
        this.recordList = new ArrayList();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public List<BattleRecord> getRecordList() {
        return this.recordList;
    }

    public LinkRoomFightRecordResult(g r6) {
        super(v.class);
        this.recordList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.recordList.add(new BattleRecord(r6));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.hasMore = am3.h.a(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this.recordList.isEmpty() == false) goto L25;
        this.recordList = new ArrayList();
        return;
    }

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setRecordList(List<BattleRecord> r1) {
        this.recordList = r1;
    }
}
