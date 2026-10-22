package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/AddPriceSteps;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/c;", "", "component1", "component2", "component3", "leftClosedInterval", "rightClosedInterval", "step", "copy", "", "toString", "", "hashCode", "", PbRequest.SwitchType.OTHER, "", "equals", "J", "getLeftClosedInterval", "()J", "getRightClosedInterval", "getStep", "<init>", "(JJJ)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AddPriceSteps extends FlexModelBase<com.bytedance.android.livesdk.multilink.base.model.c> implements com.bytedance.android.livesdk.multilink.base.model.c, vh7.h {

    @SerializedName("left_closed_interval")
    protected long leftClosedInterval;

    @SerializedName("right_closed_interval")
    protected long rightClosedInterval;

    @SerializedName("step")
    protected long step;

    public AddPriceSteps(long r2, long r4, long r6) {
        super(com.bytedance.android.livesdk.multilink.base.model.c.class);
        this.leftClosedInterval = r2;
        this.rightClosedInterval = r4;
        this.step = r6;
    }

    public static /* synthetic */ AddPriceSteps copy$default(AddPriceSteps r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.leftClosedInterval;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.rightClosedInterval;
    L8:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L12;
        r12 = r7.step;
    L12:
        return r7.copy(r1, r3, r12);
    }

    public final long component1() {
        return this.leftClosedInterval;
    }

    public final long component2() {
        return this.rightClosedInterval;
    }

    public final long component3() {
        return this.step;
    }

    public final AddPriceSteps copy(long r9, long r11, long r13) {
        return new AddPriceSteps(r9, r11, r13);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof AddPriceSteps) == false) goto L12;
        AddPriceSteps r7 = (AddPriceSteps) r6;
        if (this.leftClosedInterval == r7.leftClosedInterval) goto L8;
        return false;
    L8:
        if (this.rightClosedInterval == r7.rightClosedInterval) goto L10;
        return false;
    L10:
        if (this.step == r7.step) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r0 = this.leftClosedInterval;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.rightClosedInterval;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.step;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public String toString() {
        return "AddPriceSteps(leftClosedInterval=" + this.leftClosedInterval + ", rightClosedInterval=" + this.rightClosedInterval + ", step=" + this.step + ")";
    }

    public AddPriceSteps() {
        super(com.bytedance.android.livesdk.multilink.base.model.c.class);
        this.leftClosedInterval = 0;
        this.rightClosedInterval = 0;
        this.step = 0;
    }

    public final long getLeftClosedInterval() {
        return this.leftClosedInterval;
    }

    public final long getRightClosedInterval() {
        return this.rightClosedInterval;
    }

    public final long getStep() {
        return this.step;
    }

    public AddPriceSteps(am3.g r7) {
        super(com.bytedance.android.livesdk.multilink.base.model.c.class);
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L15;
        am3.g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        this.leftClosedInterval = r7.j();
        r0 = r0 | 1;
        goto L3
    L8:
        if (r3 != 2) goto L10;
        this.rightClosedInterval = r7.j();
        r0 = r0 | 2;
        goto L3
    L10:
        if (r3 != 3) goto L11;
        this.step = r7.j();
        r0 = r0 | 4;
        goto L3
    L11:
        am3.h.d(r4, r7);
        goto L3
    L15:
        r7.d(r1);
        setThreadSafe(true);
        if ((r0 & 1) != 0) goto L19;
        this.leftClosedInterval = 0;
    L19:
        if ((r0 & 2) != 0) goto L22;
        this.rightClosedInterval = 0;
    L22:
        if ((r0 & 4) != 0) goto L37;
        this.step = 0;
        return;
    }

    public /* synthetic */ AddPriceSteps(long r7, long r9, long r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        long r2 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        long r4 = 0;
    L11:
        if ((r13 & 4) == 0) goto L13;
        long r12 = 0;
    L14:
        this(r2, r4, r12);
        return;
    L13:
        r12 = r11;
        goto L14
    L9:
        r4 = r9;
        goto L11
    L5:
        r2 = r7;
        goto L7
    }
}
