package com.bytedance.android.live.liveinteract.linksecurity;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.multilink.base.model.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\f\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linksecurity/CheckAudienceLinkersResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/g;", "", "component1", "", "component2", "sleepSecond", "action", "copy", "", "toString", "hashCode", "", PbRequest.SwitchType.OTHER, "", "equals", "J", "getSleepSecond", "()J", "I", "getAction", "()I", "<init>", "(JI)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CheckAudienceLinkersResponse extends FlexModelBase<g> implements g, h {

    @SerializedName("action")
    protected int action;

    @SerializedName("sleep_second")
    protected long sleepSecond;

    public CheckAudienceLinkersResponse(long r2, int r4) {
        super(g.class);
        this.sleepSecond = r2;
        this.action = r4;
    }

    public static /* synthetic */ CheckAudienceLinkersResponse copy$default(CheckAudienceLinkersResponse r0, long r1, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.sleepSecond;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.action;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.sleepSecond;
    }

    public final int component2() {
        return this.action;
    }

    public final CheckAudienceLinkersResponse copy(long r2, int r4) {
        return new CheckAudienceLinkersResponse(r2, r4);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof CheckAudienceLinkersResponse) == false) goto L10;
        CheckAudienceLinkersResponse r7 = (CheckAudienceLinkersResponse) r6;
        if (this.sleepSecond == r7.sleepSecond) goto L8;
        return false;
    L8:
        if (this.action == r7.action) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r0 = this.sleepSecond;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.action;
    }

    public String toString() {
        return "CheckAudienceLinkersResponse(sleepSecond=" + this.sleepSecond + ", action=" + this.action + ")";
    }

    public CheckAudienceLinkersResponse() {
        super(g.class);
        this.sleepSecond = 0;
        this.action = 0;
    }

    public final int getAction() {
        return this.action;
    }

    public final long getSleepSecond() {
        return this.sleepSecond;
    }

    public CheckAudienceLinkersResponse(am3.g r9) {
        super(g.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L11;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this.sleepSecond = r9.j();
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L8;
        this.action = r9.i();
        r3 = r3 | 2;
        goto L3
    L8:
        am3.h.d(r5, r9);
        goto L3
    L11:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L15;
        this.sleepSecond = 0;
    L15:
        if ((r3 & 2) != 0) goto L27;
        this.action = 0;
        return;
    }

    public /* synthetic */ CheckAudienceLinkersResponse(long r1, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r3);
    }
}
