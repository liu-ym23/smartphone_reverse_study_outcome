package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.interact.NormalPaidLinkmicAddPriceStrategy;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002BI\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003JK\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\"\u0010\u001dR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b&\u0010\u001d¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/GetInfoBeforeAddPriceResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/i;", "", "component1", "", "component2", "component3", "component4", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/AddPriceSteps;", "component5", "component6", "addPriceValue", "addPriceStrategy", "addPriceMultiple", "rankAfterAddPrice", "addPriceSteps", "maxAddPriceValue", "copy", "", "toString", "hashCode", "", PbRequest.SwitchType.OTHER, "", "equals", "J", "getAddPriceValue", "()J", "I", "getAddPriceStrategy", "()I", "getAddPriceMultiple", "getRankAfterAddPrice", "Ljava/util/List;", "getAddPriceSteps", "()Ljava/util/List;", "getMaxAddPriceValue", "<init>", "(JIJJLjava/util/List;J)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetInfoBeforeAddPriceResponse extends FlexModelBase<com.bytedance.android.livesdk.multilink.base.model.i> implements com.bytedance.android.livesdk.multilink.base.model.i, vh7.h {

    @SerializedName("add_price_multiple")
    protected long addPriceMultiple;

    @SerializedName("add_price_steps")
    protected List<AddPriceSteps> addPriceSteps;

    @SerializedName("add_price_strategy")
    protected int addPriceStrategy;

    @SerializedName("add_price_value")
    protected long addPriceValue;

    @SerializedName("max_add_price_value")
    protected long maxAddPriceValue;

    @SerializedName("rank_after_add_price")
    protected long rankAfterAddPrice;

    public GetInfoBeforeAddPriceResponse(long r2, int r4, long r5, long r7, List<AddPriceSteps> r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "addPriceSteps");
        super(com.bytedance.android.livesdk.multilink.base.model.i.class);
        this.addPriceValue = r2;
        this.addPriceStrategy = r4;
        this.addPriceMultiple = r5;
        this.rankAfterAddPrice = r7;
        this.addPriceSteps = r9;
        this.maxAddPriceValue = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetInfoBeforeAddPriceResponse copy$default(GetInfoBeforeAddPriceResponse r11, long r12, int r14, long r15, long r17, List r19, long r20, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.addPriceValue;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = r11.addPriceStrategy;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r4 = r11.addPriceMultiple;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r6 = r11.rankAfterAddPrice;
    L19:
        if ((r22 & 16) == 0) goto L21;
        List r8 = r11.addPriceSteps;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r9 = r11.maxAddPriceValue;
    L27:
        return r11.copy(r1, r3, r4, r6, r8, r9);
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final long component1() {
        return this.addPriceValue;
    }

    public final int component2() {
        return this.addPriceStrategy;
    }

    public final long component3() {
        return this.addPriceMultiple;
    }

    public final long component4() {
        return this.rankAfterAddPrice;
    }

    public final List<AddPriceSteps> component5() {
        return this.addPriceSteps;
    }

    public final long component6() {
        return this.maxAddPriceValue;
    }

    public final GetInfoBeforeAddPriceResponse copy(long r13, int r15, long r16, long r18, List<AddPriceSteps> r20, long r21) {
        Intrinsics.checkNotNullParameter(r20, "addPriceSteps");
        return new GetInfoBeforeAddPriceResponse(r13, r15, r16, r18, r20, r21);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof GetInfoBeforeAddPriceResponse) == false) goto L18;
        GetInfoBeforeAddPriceResponse r7 = (GetInfoBeforeAddPriceResponse) r6;
        if (this.addPriceValue == r7.addPriceValue) goto L8;
        return false;
    L8:
        if (this.addPriceStrategy == r7.addPriceStrategy) goto L10;
        return false;
    L10:
        if (this.addPriceMultiple == r7.addPriceMultiple) goto L12;
        return false;
    L12:
        if (this.rankAfterAddPrice == r7.rankAfterAddPrice) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.addPriceSteps, r7.addPriceSteps) == true) goto L16;
        return false;
    L16:
        if (this.maxAddPriceValue == r7.maxAddPriceValue) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        long r0 = this.addPriceValue;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.addPriceStrategy) * 31;
        long r3 = this.addPriceMultiple;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.rankAfterAddPrice;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        List<AddPriceSteps> r6 = this.addPriceSteps;
        if (r6 == null) goto L5;
        int r7 = r6.hashCode();
    L6:
        long r8 = this.maxAddPriceValue;
        return ((r5 + r7) * 31) + ((int) (r8 ^ (r8 >>> 32)));
    L5:
        r7 = 0;
        goto L6
    }

    public String toString() {
        return "GetInfoBeforeAddPriceResponse(addPriceValue=" + this.addPriceValue + ", addPriceStrategy=" + this.addPriceStrategy + ", addPriceMultiple=" + this.addPriceMultiple + ", rankAfterAddPrice=" + this.rankAfterAddPrice + ", addPriceSteps=" + this.addPriceSteps + ", maxAddPriceValue=" + this.maxAddPriceValue + ")";
    }

    public GetInfoBeforeAddPriceResponse() {
        super(com.bytedance.android.livesdk.multilink.base.model.i.class);
        this.addPriceValue = 0;
        this.addPriceStrategy = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
        this.addPriceMultiple = 0;
        this.rankAfterAddPrice = 0;
        this.addPriceSteps = CollectionsKt.emptyList();
        this.maxAddPriceValue = 0;
    }

    public final long getAddPriceMultiple() {
        return this.addPriceMultiple;
    }

    public final List<AddPriceSteps> getAddPriceSteps() {
        return this.addPriceSteps;
    }

    public final int getAddPriceStrategy() {
        return this.addPriceStrategy;
    }

    public final long getAddPriceValue() {
        return this.addPriceValue;
    }

    public final long getMaxAddPriceValue() {
        return this.maxAddPriceValue;
    }

    public final long getRankAfterAddPrice() {
        return this.rankAfterAddPrice;
    }

    public GetInfoBeforeAddPriceResponse(am3.g r6) {
        super(com.bytedance.android.livesdk.multilink.base.model.i.class);
        this.addPriceSteps = new ArrayList();
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L14;
        am3.g.a r4 = decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.maxAddPriceValue = r6.j();
        r0 = r0 | 16;
        goto L3
    L9:
        this.addPriceSteps.add(new AddPriceSteps(r6));
        goto L3
    L10:
        this.rankAfterAddPrice = r6.j();
        r0 = r0 | 8;
        goto L3
    L11:
        this.addPriceMultiple = r6.j();
        r0 = r0 | 4;
        goto L3
    L12:
        this.addPriceStrategy = r6.i();
        r0 = r0 | 2;
        goto L3
    L13:
        this.addPriceValue = r6.j();
        r0 = r0 | 1;
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L14:
        r6.d(r1);
        setThreadSafe(true);
        if ((r0 & 1) != 0) goto L18;
        this.addPriceValue = 0;
    L18:
        if ((r0 & 2) != 0) goto L21;
        this.addPriceStrategy = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
    L21:
        if ((r0 & 4) != 0) goto L24;
        this.addPriceMultiple = 0;
    L24:
        if ((r0 & 8) != 0) goto L27;
        this.rankAfterAddPrice = 0;
    L27:
        if (this.addPriceSteps.isEmpty() == false) goto L30;
        this.addPriceSteps = CollectionsKt.emptyList();
    L30:
        if ((r0 & 16) != 0) goto L49;
        this.maxAddPriceValue = 0;
        return;
    }

    public /* synthetic */ GetInfoBeforeAddPriceResponse(long r12, int r14, long r15, long r17, List r19, long r20, int r22, DefaultConstructorMarker r23) {
        long r1 = 0;
        if ((r22 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r0 = NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal();
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r5 = 0;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r7 = 0;
    L19:
        if ((r22 & 16) == 0) goto L21;
        List r9 = CollectionsKt.emptyList();
    L23:
        if ((r22 & 32) != 0) goto L26;
        r1 = r20;
    L26:
        this(r3, r0, r5, r7, r9, r1);
        return;
    L21:
        r9 = r19;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r0 = r14;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }
}
