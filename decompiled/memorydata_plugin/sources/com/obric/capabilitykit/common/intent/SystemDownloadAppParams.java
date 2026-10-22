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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017JJ\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\u0012\u0010-\u001a\u00020\u00012\b\u0010.\u001a\u0004\u0018\u00010+H\u0016J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R(\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", "isSystemApp", "", "proceed", "operateType", "", "updateRange", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setSystemApp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOperateType$annotations", "()V", "getOperateType", "()Ljava/lang/Integer;", "setOperateType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getProceed$annotations", "getProceed", "setProceed", "getUpdateRange$annotations", "getUpdateRange", "setUpdateRange", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemDownloadAppParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemDownloadAppParams> CREATOR = null;
    private String appName;
    private Boolean isSystemApp;
    Integer operateType;
    Boolean proceed;
    Integer updateRange;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemDownloadAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r3 = r12.readString();
            if (r12.readInt() != 0) goto L7;
            Boolean r2 = null;
        L11:
            SystemDownloadAppParams r1 = new SystemDownloadAppParams(r3, r2, null, null, null, 28, null);
            int r4 = Math.min(r0, 3);
            ClassLoader r11 = getClass().getClassLoader();
            int r5 = 1;
        L12:
            if (r5 > r4) goto L28;
            if (r5 != 1) goto L19;
            Object r6 = a.b(r12, r11);
            if (r6 == null) goto L27;
            r1.proceed = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin");
        L27:
            r5 = r5 + 1;
            goto L12
        L19:
            if (r5 != 2) goto L23;
            Object r7 = a.b(r12, r11);
            if (r7 == null) goto L27;
            r1.operateType = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin");
            goto L27
        L23:
            if (r5 != 3) goto L27;
            Object r8 = a.b(r12, r11);
            if (r8 == null) goto L27;
            r1.updateRange = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
        L28:
            if (r5 > r0) goto L30;
            a.a(r12, r11);
            r5 = r5 + 1;
            goto L28
        L30:
            return r1;
        L7:
            if (r12.readInt() == 0) goto L9;
            boolean r9 = true;
        L10:
            r2 = Boolean.valueOf(r9);
            goto L11
        L9:
            r9 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams[] newArray(int r1) {
            return new SystemDownloadAppParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public SystemDownloadAppParams() {
        this(null, null, null, null, null, 31, null);
    }

    public SystemDownloadAppParams(String r1, Boolean r2, Boolean r3, Integer r4, Integer r5) {
        this.appName = r1;
        this.isSystemApp = r2;
        this.proceed = r3;
        this.operateType = r4;
        this.updateRange = r5;
    }

    public /* synthetic */ SystemDownloadAppParams(String r2, Boolean r3, Boolean r4, Integer r5, Integer r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ SystemDownloadAppParams copy$default(SystemDownloadAppParams r3, String r4, Boolean r5, Boolean r6, Integer r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.appName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.isSystemApp;
    L8:
        Boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.proceed;
    L11:
        Boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.operateType;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.updateRange;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public static /* synthetic */ void getOperateType$annotations() {
    }

    public static /* synthetic */ void getProceed$annotations() {
    }

    public static /* synthetic */ void getUpdateRange$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final Boolean component2() {
        return this.isSystemApp;
    }

    public final Boolean component3() {
        return this.proceed;
    }

    public final Integer component4() {
        return this.operateType;
    }

    public final Integer component5() {
        return this.updateRange;
    }

    public final SystemDownloadAppParams copy(String r7, Boolean r8, Boolean r9, Integer r10, Integer r11) {
        return new SystemDownloadAppParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemDownloadAppParams.class) == true) goto L8;
        return false;
    L8:
        SystemDownloadAppParams r6 = (SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r5, SystemDownloadAppParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSystemApp, r6.isSystemApp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.proceed, r6.proceed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.operateType, r6.operateType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateRange, r6.updateRange) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Integer getOperateType() {
        return this.operateType;
    }

    public final Boolean getProceed() {
        return this.proceed;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final Integer getUpdateRange() {
        return this.updateRange;
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isSystemApp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.proceed;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.operateType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.updateRange;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public final Boolean isSystemApp() {
        return this.isSystemApp;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, SystemDownloadAppParams.class) == false) goto L5;
        String r1 = this.appName;
        if (r1 != null) goto L9;
        r1 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.memorydata.plugin")).appName;
    L9:
        String r4 = r1;
        Boolean r2 = this.isSystemApp;
        if (r2 != null) goto L12;
        r2 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.memorydata.plugin")).isSystemApp;
    L12:
        Boolean r5 = r2;
        Boolean r3 = this.proceed;
        if (r3 != null) goto L15;
        r3 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.memorydata.plugin")).proceed;
    L15:
        Boolean r6 = r3;
        Integer r7 = this.operateType;
        if (r7 != null) goto L18;
        r7 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.memorydata.plugin")).operateType;
    L18:
        Integer r8 = r7;
        Integer r9 = this.updateRange;
        if (r9 != null) goto L21;
        r9 = ((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r10, SystemDownloadAppParams.class, "com.obric.memorydata.plugin")).updateRange;
    L21:
        SystemDownloadAppParams this = new SystemDownloadAppParams(r4, r5, r6, r8, r9);
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setOperateType(Integer r1) {
        this.operateType = r1;
    }

    public final void setProceed(Boolean r1) {
        this.proceed = r1;
    }

    public final void setSystemApp(Boolean r1) {
        this.isSystemApp = r1;
    }

    public final void setUpdateRange(Integer r1) {
        this.updateRange = r1;
    }

    public String toString() {
        return "SystemDownloadAppParams(appName=" + this.appName + ", isSystemApp=" + this.isSystemApp + ", proceed=" + this.proceed + ", operateType=" + this.operateType + ", updateRange=" + this.updateRange + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(3);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.appName);
        Boolean r4 = this.isSystemApp;
        if (r4 != null) goto L6;
        ?? r5 = 0;
    L5:
        r2.writeInt(r5);
        r2.writeValue(this.proceed);
        r2.writeValue(this.operateType);
        r2.writeValue(this.updateRange);
        return;
    L6:
        r2.writeInt(1);
        r5 = r4.booleanValue();
        goto L5
    }
}
