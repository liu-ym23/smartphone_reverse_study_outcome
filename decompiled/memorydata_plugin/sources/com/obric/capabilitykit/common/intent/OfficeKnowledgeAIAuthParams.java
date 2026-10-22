package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeKnowledgeAIAuthParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "auth", "", "(Ljava/lang/Boolean;)V", "getAuth", "()Ljava/lang/Boolean;", "setAuth", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/OfficeKnowledgeAIAuthParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeKnowledgeAIAuthParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<OfficeKnowledgeAIAuthParams> CREATOR = null;
    private Boolean auth;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeKnowledgeAIAuthParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeKnowledgeAIAuthParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            int r4 = 1;
            if (r6.readInt() != 0) goto L6;
            Boolean r2 = null;
        L10:
            OfficeKnowledgeAIAuthParams r1 = new OfficeKnowledgeAIAuthParams(r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
        L11:
            if (r4 > r3) goto L13;
            r4 = r4 + 1;
        L13:
            if (r4 > r0) goto L15;
            a.a(r6, r5);
            r4 = r4 + 1;
            goto L13
        L15:
            return r1;
        L6:
            if (r6.readInt() == 0) goto L8;
            boolean r7 = true;
        L9:
            r2 = Boolean.valueOf(r7);
            goto L10
        L8:
            r7 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeKnowledgeAIAuthParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeKnowledgeAIAuthParams[] newArray(int r1) {
            return new OfficeKnowledgeAIAuthParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeKnowledgeAIAuthParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeKnowledgeAIAuthParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public OfficeKnowledgeAIAuthParams(Boolean r1) {
        this.auth = r1;
    }

    public /* synthetic */ OfficeKnowledgeAIAuthParams(Boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static /* synthetic */ OfficeKnowledgeAIAuthParams copy$default(OfficeKnowledgeAIAuthParams r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.auth;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.auth;
    }

    public final OfficeKnowledgeAIAuthParams copy(Boolean r1) {
        return new OfficeKnowledgeAIAuthParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeKnowledgeAIAuthParams.class) == true) goto L8;
        return false;
    L8:
        OfficeKnowledgeAIAuthParams r6 = (OfficeKnowledgeAIAuthParams) ZeusTransformUtils.preCheckCast(r5, OfficeKnowledgeAIAuthParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.auth, r6.auth) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final Boolean getAuth() {
        return this.auth;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        Boolean r0 = this.auth;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, OfficeKnowledgeAIAuthParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        Boolean r5 = this.auth;
        if (r5 != null) goto L10;
        r5 = ((OfficeKnowledgeAIAuthParams) ZeusTransformUtils.preCheckCast(r4, OfficeKnowledgeAIAuthParams.class, "com.obric.memorydata.plugin")).auth;
    L10:
        r3 = ZeusTransformUtils.preCheckCast(new OfficeKnowledgeAIAuthParams(r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setAuth(Boolean r1) {
        this.auth = r1;
    }

    public String toString() {
        return "OfficeKnowledgeAIAuthParams(auth=" + this.auth + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        Boolean r1 = this.auth;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.booleanValue() ? 1 : 0);
    }
}
