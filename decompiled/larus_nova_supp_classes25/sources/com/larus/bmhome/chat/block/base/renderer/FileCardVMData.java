package com.larus.bmhome.chat.block.base.renderer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BÃ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010,J\t\u0010=\u001a\u00020\fHÆ\u0003JÊ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010?J\u0006\u0010@\u001a\u00020\u0004J\u0013\u0010A\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0004HÖ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#¨\u0006K"}, d2 = {"Lcom/larus/bmhome/chat/block/base/renderer/FileCardVMData;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardVMData;", "Landroid/os/Parcelable;", "iconRes", "", "darkIcon", "", "lightIcon", "fileName", "url", "type", "showType", "", "rootBackgroundRes", "messageId", "messageExt", "", "conversationId", "botId", "showPlayAudioButton", "fileSizeBytes", "", "showFileActions", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Z)V", "getIconRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDarkIcon", "()Ljava/lang/String;", "getLightIcon", "getFileName", "getUrl", "getType", "getShowType", "()Z", "getRootBackgroundRes", "getMessageId", "getMessageExt", "()Ljava/util/Map;", "getConversationId", "getBotId", "getShowPlayAudioButton", "getFileSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowFileActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Z)Lcom/larus/bmhome/chat/block/base/renderer/FileCardVMData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FileCardVMData implements Parcelable {
    public static final Parcelable.Creator<FileCardVMData> CREATOR = null;

    @SerializedName("botId")
    private final String botId;

    @SerializedName("conversationId")
    private final String conversationId;

    @SerializedName("darkIcon")
    private final String darkIcon;

    @SerializedName("fileName")
    private final String fileName;

    @SerializedName("fileSizeBytes")
    private final Long fileSizeBytes;

    @SerializedName("iconRes")
    private final Integer iconRes;

    @SerializedName("lightIcon")
    private final String lightIcon;

    @SerializedName("messageExt")
    private final Map<String, String> messageExt;

    @SerializedName("messageId")
    private final String messageId;

    @SerializedName("rootBackgroundRes")
    private final Integer rootBackgroundRes;

    @SerializedName("showFileActions")
    private final boolean showFileActions;

    @SerializedName("showPlayAudioButton")
    private final boolean showPlayAudioButton;

    @SerializedName("showType")
    private final boolean showType;

    @SerializedName("type")
    private final String type;

    @SerializedName("url")
    private final String url;

    public static final class a implements Parcelable.Creator<FileCardVMData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FileCardVMData createFromParcel(Parcel r21) {
            Intrinsics.checkNotNullParameter(r21, "parcel");
            if (r21.readInt() != 0) goto L5;
            Integer r4 = null;
        L6:
            String r5 = r21.readString();
            String r6 = r21.readString();
            String r7 = r21.readString();
            String r8 = r21.readString();
            String r9 = r21.readString();
            if (r21.readInt() == 0) goto L9;
            boolean r0 = true;
        L11:
            if (r21.readInt() != 0) goto L13;
            Integer r11 = null;
        L14:
            String r12 = r21.readString();
            if (r21.readInt() != 0) goto L17;
            LinkedHashMap r13 = null;
        L21:
            String r14 = r21.readString();
            String r15 = r21.readString();
            if (r21.readInt() == 0) goto L24;
            boolean r2 = true;
        L26:
            if (r21.readInt() != 0) goto L28;
            Long r18 = null;
        L30:
            if (r21.readInt() == 0) goto L32;
            boolean r1 = true;
        L34:
            return new FileCardVMData(r4, r5, r6, r7, r8, r9, r0, r11, r12, r13, r14, r15, r2, r18, r1);
        L32:
            r1 = false;
            goto L34
        L28:
            r18 = Long.valueOf(r21.readLong());
            goto L30
        L24:
            r2 = false;
            goto L26
        L17:
            int r16 = r21.readInt();
            LinkedHashMap r17 = new LinkedHashMap(r16);
            int r19 = 0;
        L18:
            if (r19 == r16) goto L20;
            r17.put(r21.readString(), r21.readString());
            r19 = r19 + 1;
            goto L18
        L20:
            r13 = r17;
            goto L21
        L13:
            r11 = Integer.valueOf(r21.readInt());
            goto L14
        L9:
            r0 = false;
            goto L11
        L5:
            r4 = Integer.valueOf(r21.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FileCardVMData[] newArray(int r1) {
            return new FileCardVMData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public FileCardVMData() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, false, 32767);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FileCardVMData) == true) goto L8;
        return false;
    L8:
        FileCardVMData r6 = (FileCardVMData) r5;
        if (Intrinsics.areEqual(this.iconRes, r6.iconRes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.darkIcon, r6.darkIcon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lightIcon, r6.lightIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L27;
        return false;
    L27:
        if (this.showType == r6.showType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.rootBackgroundRes, r6.rootBackgroundRes) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.messageExt, r6.messageExt) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L45;
        return false;
    L45:
        if (this.showPlayAudioButton == r6.showPlayAudioButton) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.fileSizeBytes, r6.fileSizeBytes) == true) goto L51;
        return false;
    L51:
        if (this.showFileActions == r6.showFileActions) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.iconRes;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.darkIcon;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.lightIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.fileName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.url;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.type;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        int r19 = 1231;
        if (this.showType == false) goto L29;
        int r20 = 1231;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.rootBackgroundRes;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.messageId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, String> r28 = this.messageExt;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.conversationId;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.botId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        if (this.showPlayAudioButton == false) goto L53;
        int r37 = 1231;
    L54:
        int r38 = (r36 + r37) * 31;
        Long r39 = this.fileSizeBytes;
        if (r39 == null) goto L58;
        r1 = r39.hashCode();
    L58:
        int r40 = (r38 + r1) * 31;
        if (this.showFileActions == true) goto L63;
        r19 = 1237;
    L63:
        return r40 + r19;
    L53:
        r37 = 1237;
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = 1237;
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public final String toString() {
        return "FileCardVMData(iconRes=" + this.iconRes + ", darkIcon=" + this.darkIcon + ", lightIcon=" + this.lightIcon + ", fileName=" + this.fileName + ", url=" + this.url + ", type=" + this.type + ", showType=" + this.showType + ", rootBackgroundRes=" + this.rootBackgroundRes + ", messageId=" + this.messageId + ", messageExt=" + this.messageExt + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", showPlayAudioButton=" + this.showPlayAudioButton + ", fileSizeBytes=" + this.fileSizeBytes + ", showFileActions=" + this.showFileActions + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Integer r7 = this.iconRes;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        r5.writeString(this.darkIcon);
        r5.writeString(this.lightIcon);
        r5.writeString(this.fileName);
        r5.writeString(this.url);
        r5.writeString(this.type);
        r5.writeInt(this.showType ? 1 : 0);
        Integer r8 = this.rootBackgroundRes;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.messageId);
        Map<String, String> r9 = this.messageExt;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L17:
        r5.writeString(this.conversationId);
        r5.writeString(this.botId);
        r5.writeInt(this.showPlayAudioButton ? 1 : 0);
        Long r10 = this.fileSizeBytes;
        if (r10 != null) goto L20;
        r5.writeInt(0);
    L21:
        r5.writeInt(this.showFileActions ? 1 : 0);
        return;
    L20:
        r5.writeInt(1);
        r5.writeLong(r10.longValue());
        goto L21
    L13:
        r5.writeInt(1);
        r5.writeInt(r9.size());
        Iterator<Map.Entry<String, String>> r11 = r9.entrySet().iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry<String, String> r2 = r11.next();
        r5.writeString(r2.getKey());
        r5.writeString(r2.getValue());
        goto L15
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
        goto L6
    }

    public final String b() {
        return this.botId;
    }

    public final String c() {
        return this.conversationId;
    }

    public final String d() {
        return this.darkIcon;
    }

    public final String e() {
        return this.fileName;
    }

    public final Long g() {
        return this.fileSizeBytes;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer h() {
        return this.iconRes;
    }

    public final String i() {
        return this.lightIcon;
    }

    public final Map<String, String> j() {
        return this.messageExt;
    }

    public final String k() {
        return this.messageId;
    }

    public final Integer o() {
        return this.rootBackgroundRes;
    }

    public final boolean q() {
        return this.showFileActions;
    }

    public final boolean r() {
        return this.showPlayAudioButton;
    }

    public final boolean s() {
        return this.showType;
    }

    public final String t() {
        return this.url;
    }

    public static FileCardVMData a(FileCardVMData r17, Integer r18, String r19, Map r20, String r21, String r22) {
        return new FileCardVMData(r17.iconRes, r17.darkIcon, r17.lightIcon, r17.fileName, r17.url, r17.type, r17.showType, r18, r19, r20, r21, r22, r17.showPlayAudioButton, r17.fileSizeBytes, r17.showFileActions);
    }

    public /* synthetic */ FileCardVMData(Integer r20, String r21, String r22, String r23, String r24, String r25, Integer r26, String r27, Map r28, String r29, String r30, boolean r31, Long r32, boolean r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        Integer r4 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r34 & 128) == 0) goto L29;
        Integer r11 = null;
    L31:
        if ((r34 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r34 & 512) == 0) goto L37;
        Map r13 = null;
    L39:
        if ((r34 & 1024) == 0) goto L41;
        String r14 = null;
    L43:
        if ((r34 & 2048) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r34 & 4096) == 0) goto L49;
        boolean r16 = false;
    L51:
        if ((r34 & 8192) == 0) goto L53;
        Long r17 = null;
    L55:
        if ((r34 & 16384) == 0) goto L57;
        boolean r18 = false;
    L58:
        this(r4, r5, r6, r7, r8, r9, false, r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L57:
        r18 = r33;
        goto L58
    L53:
        r17 = r32;
        goto L55
    L49:
        r16 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L43
    L37:
        r13 = r28;
        goto L39
    L33:
        r12 = r27;
        goto L35
    L29:
        r11 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r5 = r21;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }

    public FileCardVMData(Integer r1, String r2, String r3, String r4, String r5, String r6, boolean r7, Integer r8, String r9, Map<String, String> r10, String r11, String r12, boolean r13, Long r14, boolean r15) {
        this.iconRes = r1;
        this.darkIcon = r2;
        this.lightIcon = r3;
        this.fileName = r4;
        this.url = r5;
        this.type = r6;
        this.showType = r7;
        this.rootBackgroundRes = r8;
        this.messageId = r9;
        this.messageExt = r10;
        this.conversationId = r11;
        this.botId = r12;
        this.showPlayAudioButton = r13;
        this.fileSizeBytes = r14;
        this.showFileActions = r15;
    }
}
