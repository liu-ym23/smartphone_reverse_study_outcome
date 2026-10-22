package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", "Landroid/os/Parcelable;", "code", "", DTraitConstant.ERROR, "", "realTimeContext", "Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/realtime/RealTimeContext;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getRealTimeContext", "()Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealTimeContextResult implements Parcelable {
    public static final Parcelable.Creator<RealTimeContextResult> CREATOR = null;
    public static final a Companion = null;
    private final int code;
    private final String errorMsg;
    private final RealTimeContext realTimeContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult$Companion;", "", "<init>", "()V", "dummy", "Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final RealTimeContextResult a() {
            return new RealTimeContextResult(0, null, RealTimeContext.Companion.a());
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<RealTimeContextResult> {
        public b() {
        }

        public final RealTimeContextResult a(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            int r0 = r5.readInt();
            String r1 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            RealTimeContext r6 = null;
        L7:
            return new RealTimeContextResult(r0, r1, (RealTimeContext) ZeusTransformUtils.preCheckCast(r6, RealTimeContext.class, "com.obric.memorydata.plugin"));
        L5:
            r6 = RealTimeContext.CREATOR.createFromParcel(r5);
            goto L7
        }

        public final RealTimeContextResult[] a(int r1) {
            return new RealTimeContextResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RealTimeContextResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RealTimeContextResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public RealTimeContextResult(int r1, String r2, RealTimeContext r3) {
        this.code = r1;
        this.errorMsg = r2;
        this.realTimeContext = r3;
    }

    public static /* synthetic */ RealTimeContextResult copy$default(RealTimeContextResult r0, int r1, String r2, RealTimeContext r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.errorMsg;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.realTimeContext;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final RealTimeContext component3() {
        return this.realTimeContext;
    }

    public final RealTimeContextResult copy(int r1, String r2, RealTimeContext r3) {
        return new RealTimeContextResult(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RealTimeContextResult.class) == true) goto L8;
        return false;
    L8:
        RealTimeContextResult r6 = (RealTimeContextResult) ZeusTransformUtils.preCheckCast(r5, RealTimeContextResult.class, "com.obric.memorydata.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.realTimeContext, r6.realTimeContext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final RealTimeContext getRealTimeContext() {
        return this.realTimeContext;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.errorMsg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        RealTimeContext r5 = this.realTimeContext;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RealTimeContextResult(code=" + this.code + ", errorMsg=" + this.errorMsg + ", realTimeContext=" + this.realTimeContext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeInt(this.code);
        r2.writeString(this.errorMsg);
        RealTimeContext r1 = this.realTimeContext;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r1.writeToParcel(r2, r3);
    }
}
