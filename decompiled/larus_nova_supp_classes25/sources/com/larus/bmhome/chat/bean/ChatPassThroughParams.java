package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0007J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "flowFunctionScene", "", "enableForsetiPageSizeSlot", "", "enableSmallWindowTopInsetAdaptation", "userContextParam", "Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "<init>", "(Ljava/lang/String;ZZLcom/larus/bmhome/chat/bean/ChatUserContextParam;)V", "getFlowFunctionScene", "()Ljava/lang/String;", "getEnableForsetiPageSizeSlot", "()Z", "getEnableSmallWindowTopInsetAdaptation", "getUserContextParam", "()Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "isNotEmpty", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatPassThroughParams implements Parcelable, Serializable, t1a.c {
    public static final Parcelable.Creator<ChatPassThroughParams> CREATOR = null;
    private final boolean enableForsetiPageSizeSlot;
    private final boolean enableSmallWindowTopInsetAdaptation;
    private final String flowFunctionScene;
    private final ChatUserContextParam userContextParam;

    public static final class a implements Parcelable.Creator<ChatPassThroughParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPassThroughParams createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            String r1 = r7.readString();
            boolean r3 = false;
            if (r7.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            if (r7.readInt() == 0) goto L10;
            r3 = true;
        L10:
            return new ChatPassThroughParams(r1, r2, r3, (ChatUserContextParam) r7.readParcelable(ChatPassThroughParams.class.getClassLoader()));
        L5:
            r2 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatPassThroughParams[] newArray(int r1) {
            return new ChatPassThroughParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatPassThroughParams() {
        this(null, false, false, null, 15, null);
    }

    public static /* synthetic */ ChatPassThroughParams copy$default(ChatPassThroughParams r0, String r1, boolean r2, boolean r3, ChatUserContextParam r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.flowFunctionScene;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.enableForsetiPageSizeSlot;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.enableSmallWindowTopInsetAdaptation;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.userContextParam;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.flowFunctionScene;
    }

    public final boolean component2() {
        return this.enableForsetiPageSizeSlot;
    }

    public final boolean component3() {
        return this.enableSmallWindowTopInsetAdaptation;
    }

    public final ChatUserContextParam component4() {
        return this.userContextParam;
    }

    public final ChatPassThroughParams copy(String r2, boolean r3, boolean r4, ChatUserContextParam r5) {
        return new ChatPassThroughParams(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatPassThroughParams) == true) goto L8;
        return false;
    L8:
        ChatPassThroughParams r6 = (ChatPassThroughParams) r5;
        if (Intrinsics.areEqual(this.flowFunctionScene, r6.flowFunctionScene) == true) goto L12;
        return false;
    L12:
        if (this.enableForsetiPageSizeSlot == r6.enableForsetiPageSizeSlot) goto L15;
        return false;
    L15:
        if (this.enableSmallWindowTopInsetAdaptation == r6.enableSmallWindowTopInsetAdaptation) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userContextParam, r6.userContextParam) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.flowFunctionScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.enableForsetiPageSizeSlot == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.enableSmallWindowTopInsetAdaptation == true) goto L14;
        r4 = 1237;
    L14:
        int r7 = (r6 + r4) * 31;
        ChatUserContextParam r8 = this.userContextParam;
        if (r8 == null) goto L19;
        r1 = r8.hashCode();
    L19:
        return r7 + r1;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatPassThroughParams(flowFunctionScene=" + this.flowFunctionScene + ", enableForsetiPageSizeSlot=" + this.enableForsetiPageSizeSlot + ", enableSmallWindowTopInsetAdaptation=" + this.enableSmallWindowTopInsetAdaptation + ", userContextParam=" + this.userContextParam + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.flowFunctionScene);
        r2.writeInt(this.enableForsetiPageSizeSlot ? 1 : 0);
        r2.writeInt(this.enableSmallWindowTopInsetAdaptation ? 1 : 0);
        r2.writeParcelable(this.userContextParam, r3);
    }

    public final boolean isNotEmpty() {
        String r0 = this.flowFunctionScene;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L21;
        ChatUserContextParam r2 = this.userContextParam;
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L21;
        if (this.enableForsetiPageSizeSlot == true) goto L21;
        if (this.enableSmallWindowTopInsetAdaptation == true) goto L21;
        return false;
    L13:
        if (r2.isNotEmpty() != true) goto L15;
        r3 = true;
    L21:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean getEnableForsetiPageSizeSlot() {
        return this.enableForsetiPageSizeSlot;
    }

    public final boolean getEnableSmallWindowTopInsetAdaptation() {
        return this.enableSmallWindowTopInsetAdaptation;
    }

    public final String getFlowFunctionScene() {
        return this.flowFunctionScene;
    }

    public final ChatUserContextParam getUserContextParam() {
        return this.userContextParam;
    }

    public ChatPassThroughParams(String r1, boolean r2, boolean r3, ChatUserContextParam r4) {
        this.flowFunctionScene = r1;
        this.enableForsetiPageSizeSlot = r2;
        this.enableSmallWindowTopInsetAdaptation = r3;
        this.userContextParam = r4;
    }

    public /* synthetic */ ChatPassThroughParams(String r3, boolean r4, boolean r5, ChatUserContextParam r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        this(r3, r4, r5, r6);
    }
}
