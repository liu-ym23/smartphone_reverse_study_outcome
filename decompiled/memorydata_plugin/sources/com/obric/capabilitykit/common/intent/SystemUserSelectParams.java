package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001cHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserSelectParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "candidate", "", "", "type", "sourceIntent", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCandidate", "()[Ljava/lang/String;", "setCandidate", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getSourceIntent$annotations", "()V", "getSourceIntent", "()Ljava/lang/String;", "setSourceIntent", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "component3", "copy", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserSelectParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserSelectParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemUserSelectParams> CREATOR = null;
    private String[] candidate;
    String sourceIntent;
    private String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserSelectParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserSelectParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            Intrinsics.checkNotNullParameter(r9, "parcel");
            SystemUserSelectParams r1 = new SystemUserSelectParams(r9.createStringArray(), r9.readString(), null, 4, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r9, r8);
            if (r5 == null) goto L8;
            r1.sourceIntent = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserSelectParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserSelectParams[] newArray(int r1) {
            return new SystemUserSelectParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserSelectParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public SystemUserSelectParams() {
        this(null, null, null, 7, null);
    }

    public SystemUserSelectParams(String[] r1, String r2, String r3) {
        this.candidate = r1;
        this.type = r2;
        this.sourceIntent = r3;
    }

    public /* synthetic */ SystemUserSelectParams(String[] r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ SystemUserSelectParams copy$default(SystemUserSelectParams r0, String[] r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.candidate;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.sourceIntent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getSourceIntent$annotations() {
    }

    public final String[] component1() {
        return this.candidate;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.sourceIntent;
    }

    public final SystemUserSelectParams copy(String[] r1, String r2, String r3) {
        return new SystemUserSelectParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemUserSelectParams.class) == true) goto L8;
        return false;
    L8:
        SystemUserSelectParams r6 = (SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.candidate, r6.candidate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceIntent, r6.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String[] getCandidate() {
        return this.candidate;
    }

    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String[] r0 = this.candidate;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sourceIntent;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.candidate != null) goto L5;
    L9:
        return false;
    L5:
        if (this.type == null) goto L9;
        if (this.sourceIntent == null) goto L9;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, SystemUserSelectParams.class) == true) goto L7;
        Object r4 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r4;
    L7:
        String[] r1 = this.candidate;
        if (r1 != null) goto L10;
        r1 = ((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.memorydata.plugin")).candidate;
    L10:
        String r3 = this.type;
        if (r3 != null) goto L13;
        r3 = ((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.memorydata.plugin")).type;
    L13:
        String r6 = this.sourceIntent;
        if (r6 != null) goto L16;
        r6 = ((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.memorydata.plugin")).sourceIntent;
    L16:
        r4 = ZeusTransformUtils.preCheckCast(new SystemUserSelectParams(r1, r3, r6), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setCandidate(String[] r1) {
        this.candidate = r1;
    }

    public final void setSourceIntent(String r1) {
        this.sourceIntent = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public String toString() {
        return "SystemUserSelectParams(candidate=" + Arrays.toString(this.candidate) + ", type=" + this.type + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeStringArray(this.candidate);
        r1.writeString(this.type);
        r1.writeValue(this.sourceIntent);
    }
}
