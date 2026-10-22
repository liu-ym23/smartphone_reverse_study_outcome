package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJJ\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\nHÖ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\b\u0010.\u001a\u00020\u0006H\u0016J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010,H\u0016J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nHÖ\u0001R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R(\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001e\u0012\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", ChatMessage.TYPE_QUERY, "", "needScreenshot", "", "chatHistory", "targets", "subIntent", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChatHistory$annotations", "()V", "getChatHistory", "()Ljava/lang/String;", "setChatHistory", "(Ljava/lang/String;)V", "getNeedScreenshot", "()Ljava/lang/Boolean;", "setNeedScreenshot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuery", "setQuery", "getSubIntent$annotations", "getSubIntent", "()Ljava/lang/Integer;", "setSubIntent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTargets$annotations", "getTargets", "setTargets", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "describeContents", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryProduceParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MemoryProduceParams> CREATOR = null;
    String chatHistory;
    private Boolean needScreenshot;
    private String query;
    Integer subIntent;
    String targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MemoryProduceParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemoryProduceParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r3 = r12.readString();
            if (r12.readInt() != 0) goto L7;
            Boolean r2 = null;
        L11:
            MemoryProduceParams r1 = new MemoryProduceParams(r3, r2, null, null, null, 28, null);
            int r4 = Math.min(r0, 3);
            ClassLoader r11 = getClass().getClassLoader();
            int r5 = 1;
        L12:
            if (r5 > r4) goto L28;
            if (r5 != 1) goto L19;
            Object r6 = a.b(r12, r11);
            if (r6 == null) goto L27;
            r1.chatHistory = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        L27:
            r5 = r5 + 1;
            goto L12
        L19:
            if (r5 != 2) goto L23;
            Object r7 = a.b(r12, r11);
            if (r7 == null) goto L27;
            r1.targets = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
            goto L27
        L23:
            if (r5 != 3) goto L27;
            Object r8 = a.b(r12, r11);
            if (r8 == null) goto L27;
            r1.subIntent = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
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
        public /* bridge */ /* synthetic */ MemoryProduceParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemoryProduceParams[] newArray(int r1) {
            return new MemoryProduceParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryProduceParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public MemoryProduceParams() {
        this(null, null, null, null, null, 31, null);
    }

    public MemoryProduceParams(String r1, Boolean r2, String r3, String r4, Integer r5) {
        this.query = r1;
        this.needScreenshot = r2;
        this.chatHistory = r3;
        this.targets = r4;
        this.subIntent = r5;
    }

    public /* synthetic */ MemoryProduceParams(String r2, Boolean r3, String r4, String r5, Integer r6, int r7, DefaultConstructorMarker r8) {
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

    public static /* synthetic */ MemoryProduceParams copy$default(MemoryProduceParams r3, String r4, Boolean r5, String r6, String r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.query;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.needScreenshot;
    L8:
        Boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.chatHistory;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.targets;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.subIntent;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public static /* synthetic */ void getChatHistory$annotations() {
    }

    public static /* synthetic */ void getSubIntent$annotations() {
    }

    public static /* synthetic */ void getTargets$annotations() {
    }

    public final String component1() {
        return this.query;
    }

    public final Boolean component2() {
        return this.needScreenshot;
    }

    public final String component3() {
        return this.chatHistory;
    }

    public final String component4() {
        return this.targets;
    }

    public final Integer component5() {
        return this.subIntent;
    }

    public final MemoryProduceParams copy(String r7, Boolean r8, String r9, String r10, Integer r11) {
        return new MemoryProduceParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemoryProduceParams.class) == true) goto L8;
        return false;
    L8:
        MemoryProduceParams r6 = (MemoryProduceParams) ZeusTransformUtils.preCheckCast(r5, MemoryProduceParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needScreenshot, r6.needScreenshot) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatHistory, r6.chatHistory) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.targets, r6.targets) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subIntent, r6.subIntent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getChatHistory() {
        return this.chatHistory;
    }

    public final Boolean getNeedScreenshot() {
        return this.needScreenshot;
    }

    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final Integer getSubIntent() {
        return this.subIntent;
    }

    public final String getTargets() {
        return this.targets;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.needScreenshot;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.chatHistory;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.targets;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.subIntent;
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
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, MemoryProduceParams.class) == false) goto L5;
        String r1 = this.query;
        if (r1 != null) goto L9;
        r1 = ((MemoryProduceParams) ZeusTransformUtils.preCheckCast(r10, MemoryProduceParams.class, "com.obric.memorydata.plugin")).query;
    L9:
        String r4 = r1;
        Boolean r2 = this.needScreenshot;
        if (r2 != null) goto L12;
        r2 = ((MemoryProduceParams) ZeusTransformUtils.preCheckCast(r10, MemoryProduceParams.class, "com.obric.memorydata.plugin")).needScreenshot;
    L12:
        Boolean r5 = r2;
        String r3 = this.chatHistory;
        if (r3 != null) goto L15;
        r3 = ((MemoryProduceParams) ZeusTransformUtils.preCheckCast(r10, MemoryProduceParams.class, "com.obric.memorydata.plugin")).chatHistory;
    L15:
        String r6 = r3;
        String r7 = this.targets;
        if (r7 != null) goto L18;
        r7 = ((MemoryProduceParams) ZeusTransformUtils.preCheckCast(r10, MemoryProduceParams.class, "com.obric.memorydata.plugin")).targets;
    L18:
        String r8 = r7;
        Integer r9 = this.subIntent;
        if (r9 != null) goto L21;
        r9 = ((MemoryProduceParams) ZeusTransformUtils.preCheckCast(r10, MemoryProduceParams.class, "com.obric.memorydata.plugin")).subIntent;
    L21:
        MemoryProduceParams this = new MemoryProduceParams(r4, r5, r6, r8, r9);
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    }

    public final void setChatHistory(String r1) {
        this.chatHistory = r1;
    }

    public final void setNeedScreenshot(Boolean r1) {
        this.needScreenshot = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final void setSubIntent(Integer r1) {
        this.subIntent = r1;
    }

    public final void setTargets(String r1) {
        this.targets = r1;
    }

    public String toString() {
        return "MemoryProduceParams(query=" + this.query + ", needScreenshot=" + this.needScreenshot + ", chatHistory=" + this.chatHistory + ", targets=" + this.targets + ", subIntent=" + this.subIntent + ')';
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
        r2.writeString(this.query);
        Boolean r4 = this.needScreenshot;
        if (r4 != null) goto L6;
        ?? r5 = 0;
    L5:
        r2.writeInt(r5);
        r2.writeValue(this.chatHistory);
        r2.writeValue(this.targets);
        r2.writeValue(this.subIntent);
        return;
    L6:
        r2.writeInt(1);
        r5 = r4.booleanValue();
        goto L5
    }
}
