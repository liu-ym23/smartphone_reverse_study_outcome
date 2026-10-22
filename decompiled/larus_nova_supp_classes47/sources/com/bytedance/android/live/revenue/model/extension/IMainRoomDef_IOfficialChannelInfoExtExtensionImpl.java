package com.bytedance.android.live.revenue.model.extension;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import iy0.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010Q\u001a\u00020\u0002¢\u0006\u0004\bR\u0010SJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u00020\u00138\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010#R\u001e\u0010'\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010#R\u001e\u0010-\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R<\u00104\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010.j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u0001`/8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00107\u001a\u00020\u00178\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001c\u0010:\u001a\u00020\u00178\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR\u001c\u0010=\u001a\u00020\u00138\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u001fR0\u0010D\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010>j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`?8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR0\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010>j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`?8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001e\u0010J\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bH\u0010*\"\u0004\bI\u0010,R\u001c\u0010M\u001a\u00020\u00178\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bK\u0010\u0019\"\u0004\bL\u0010\u001bR\u001c\u0010P\u001a\u00020\u00178\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bN\u0010\u0019\"\u0004\bO\u0010\u001b¨\u0006T"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/IMainRoomDef_IOfficialChannelInfoExtExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;", "Liy0/a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getCurrentShowId", "()I", "currentShowId", "", "getBackupRoomIdStr", "()Ljava/lang/String;", "backupRoomIdStr", "", "getEnableHost", "()Z", "enableHost", "", "getBackupRoomId", "()J", "setBackupRoomId", "(J)V", "backupRoomId", "getCanAcceptGift", "setCanAcceptGift", "(Z)V", "canAcceptGift", "getChannelIntroduction", "setChannelIntroduction", "(Ljava/lang/String;)V", "channelIntroduction", "getChannelName", "setChannelName", "channelName", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getChannelUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setChannelUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "channelUser", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getDelayEnterTime", "()Ljava/util/Map;", "setDelayEnterTime", "(Ljava/util/Map;)V", "delayEnterTime", "getEndTimeStamp", "setEndTimeStamp", "endTimeStamp", "getForbiddenBeforeEnd", "setForbiddenBeforeEnd", "forbiddenBeforeEnd", "getHasHostPermission", "setHasHostPermission", "hasHostPermission", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getHostAwemeUids", "()Ljava/util/List;", "setHostAwemeUids", "(Ljava/util/List;)V", "hostAwemeUids", "getHostOpenIds", "setHostOpenIds", "hostOpenIds", "getLivingUser", "setLivingUser", "livingUser", "getMaxEnterTime", "setMaxEnterTime", "maxEnterTime", "getMaxNextTime", "setMaxNextTime", "maxNextTime", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainRoomDef_IOfficialChannelInfoExtExtensionImpl extends ModelExtensionBase<IOfficialChannelInfo, a> implements a, IOfficialChannelInfo {
    private final /* synthetic */ IOfficialChannelInfo $$delegate_0;

    @Override // iy0.a
    public <R extends e<IOfficialChannelInfo>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // iy0.a
    public <R extends e<IOfficialChannelInfo>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    public long getBackupRoomId() {
        return this.$$delegate_0.getBackupRoomId();
    }

    public boolean getCanAcceptGift() {
        return this.$$delegate_0.getCanAcceptGift();
    }

    public String getChannelIntroduction() {
        return this.$$delegate_0.getChannelIntroduction();
    }

    public String getChannelName() {
        return this.$$delegate_0.getChannelName();
    }

    public IBaseUser getChannelUser() {
        return this.$$delegate_0.getChannelUser();
    }

    public Map<Long, Long> getDelayEnterTime() {
        return this.$$delegate_0.getDelayEnterTime();
    }

    public long getEndTimeStamp() {
        return this.$$delegate_0.getEndTimeStamp();
    }

    public long getForbiddenBeforeEnd() {
        return this.$$delegate_0.getForbiddenBeforeEnd();
    }

    public boolean getHasHostPermission() {
        return this.$$delegate_0.getHasHostPermission();
    }

    public List<Long> getHostAwemeUids() {
        return this.$$delegate_0.getHostAwemeUids();
    }

    public List<String> getHostOpenIds() {
        return this.$$delegate_0.getHostOpenIds();
    }

    public IBaseUser getLivingUser() {
        return this.$$delegate_0.getLivingUser();
    }

    public long getMaxEnterTime() {
        return this.$$delegate_0.getMaxEnterTime();
    }

    public long getMaxNextTime() {
        return this.$$delegate_0.getMaxNextTime();
    }

    public void setBackupRoomId(long r2) {
        this.$$delegate_0.setBackupRoomId(r2);
    }

    public void setCanAcceptGift(boolean r2) {
        this.$$delegate_0.setCanAcceptGift(r2);
    }

    public void setChannelIntroduction(String r2) {
        this.$$delegate_0.setChannelIntroduction(r2);
    }

    public void setChannelName(String r2) {
        this.$$delegate_0.setChannelName(r2);
    }

    public void setChannelUser(IBaseUser r2) {
        this.$$delegate_0.setChannelUser(r2);
    }

    public void setDelayEnterTime(Map<Long, Long> r2) {
        this.$$delegate_0.setDelayEnterTime(r2);
    }

    public void setEndTimeStamp(long r2) {
        this.$$delegate_0.setEndTimeStamp(r2);
    }

    public void setForbiddenBeforeEnd(long r2) {
        this.$$delegate_0.setForbiddenBeforeEnd(r2);
    }

    public void setHasHostPermission(boolean r2) {
        this.$$delegate_0.setHasHostPermission(r2);
    }

    public void setHostAwemeUids(List<Long> r2) {
        this.$$delegate_0.setHostAwemeUids(r2);
    }

    public void setHostOpenIds(List<String> r2) {
        this.$$delegate_0.setHostOpenIds(r2);
    }

    public void setLivingUser(IBaseUser r2) {
        this.$$delegate_0.setLivingUser(r2);
    }

    public void setMaxEnterTime(long r2) {
        this.$$delegate_0.setMaxEnterTime(r2);
    }

    public void setMaxNextTime(long r2) {
        this.$$delegate_0.setMaxNextTime(r2);
    }

    @Override // iy0.a
    public String getBackupRoomIdStr() {
        return (String) get(15, a.class, "");
    }

    @Override // iy0.a
    public int getCurrentShowId() {
        return ((Number) get(6, a.class, 0)).intValue();
    }

    @Override // iy0.a
    public boolean getEnableHost() {
        return ((Boolean) get(16, a.class, Boolean.FALSE)).booleanValue();
    }

    public IMainRoomDef_IOfficialChannelInfoExtExtensionImpl(IOfficialChannelInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
