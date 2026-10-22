package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00103\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010)J\u0086\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u0005J\u0013\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "Landroid/os/Parcelable;", "name", "", "popWindowType", "", ChatDraftItem.TYPE_TEXT, "Lcom/larus/bmhome/chat/bean/PopWindowText;", "mediaList", "", "Lcom/larus/bmhome/chat/bean/PopWindowMedia;", "buttonList", "Lcom/larus/bmhome/chat/bean/PopWindowButton;", "backgroundColor", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "frequencyConf", "Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "priority", "", "showMute", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowText;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getPopWindowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "()Lcom/larus/bmhome/chat/bean/PopWindowText;", "getMediaList", "()Ljava/util/List;", "getButtonList", "getBackgroundColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "getFrequencyConf", "()Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "getPriority", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowMute", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowText;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/PopWindowCandidateConf;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowCandidateConf implements Parcelable {
    public static final Parcelable.Creator<PopWindowCandidateConf> CREATOR = null;

    @SerializedName("background_color")
    private final PopWindowColor backgroundColor;

    @SerializedName("button_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<PopWindowButton> buttonList;

    @SerializedName("frequency_conf")
    private final PopWindowFrequencyConf frequencyConf;

    @SerializedName("media_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<PopWindowMedia> mediaList;

    @SerializedName("name")
    private final String name;

    @SerializedName("pop_window_type")
    private final Integer popWindowType;

    @SerializedName("priority")
    private final Long priority;

    @SerializedName("show_trumpet")
    private final Boolean showMute;

    @SerializedName(ChatDraftItem.TYPE_TEXT)
    private final PopWindowText text;

    public static final class a implements Parcelable.Creator<PopWindowCandidateConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowCandidateConf createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r2 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r12.readInt() != 0) goto L9;
            PopWindowText r0 = null;
        L10:
            PopWindowText r4 = r0;
            boolean r5 = false;
            if (r12.readInt() != 0) goto L13;
            ArrayList r6 = null;
        L17:
            if (r12.readInt() != 0) goto L19;
            ArrayList r7 = null;
        L23:
            if (r12.readInt() != 0) goto L25;
            PopWindowColor r1 = null;
        L26:
            PopWindowColor r8 = r1;
            if (r12.readInt() != 0) goto L29;
            PopWindowFrequencyConf r9 = null;
        L30:
            PopWindowFrequencyConf r10 = r9;
            if (r12.readInt() != 0) goto L33;
            Long r11 = null;
        L35:
            if (r12.readInt() != 0) goto L38;
            Boolean r13 = null;
        L42:
            return new PopWindowCandidateConf(r2, r3, r4, r6, r7, r8, r10, r11, r13);
        L38:
            if (r12.readInt() == 0) goto L40;
            r5 = true;
        L40:
            r13 = Boolean.valueOf(r5);
            goto L42
        L33:
            r11 = Long.valueOf(r12.readLong());
            goto L35
        L29:
            r9 = PopWindowFrequencyConf.CREATOR.createFromParcel(r12);
            goto L30
        L25:
            r1 = PopWindowColor.CREATOR.createFromParcel(r12);
            goto L26
        L19:
            int r14 = r12.readInt();
            r7 = new ArrayList(r14);
            int r15 = 0;
        L20:
            if (r15 == r14) goto L23;
            r7.add(PopWindowButton.CREATOR.createFromParcel(r12));
            r15 = r15 + 1;
            goto L20
        L13:
            int r16 = r12.readInt();
            r6 = new ArrayList(r16);
            int r17 = 0;
        L14:
            if (r17 == r16) goto L17;
            r6.add(PopWindowMedia.CREATOR.createFromParcel(r12));
            r17 = r17 + 1;
            goto L14
        L9:
            r0 = PopWindowText.CREATOR.createFromParcel(r12);
            goto L10
        L5:
            r3 = Integer.valueOf(r12.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowCandidateConf[] newArray(int r1) {
            return new PopWindowCandidateConf[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowCandidateConf() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopWindowCandidateConf copy$default(PopWindowCandidateConf r10, String r11, Integer r12, PopWindowText r13, List r14, List r15, PopWindowColor r16, PopWindowFrequencyConf r17, Long r18, Boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.name;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Integer r3 = r10.popWindowType;
    L11:
        if ((r20 & 4) == 0) goto L13;
        PopWindowText r4 = r10.text;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = r10.mediaList;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = r10.buttonList;
    L23:
        if ((r20 & 32) == 0) goto L25;
        PopWindowColor r7 = r10.backgroundColor;
    L27:
        if ((r20 & 64) == 0) goto L29;
        PopWindowFrequencyConf r8 = r10.frequencyConf;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r9 = r10.priority;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Boolean r1 = r10.showMute;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.popWindowType;
    }

    public final PopWindowText component3() {
        return this.text;
    }

    public final List<PopWindowMedia> component4() {
        return this.mediaList;
    }

    public final List<PopWindowButton> component5() {
        return this.buttonList;
    }

    public final PopWindowColor component6() {
        return this.backgroundColor;
    }

    public final PopWindowFrequencyConf component7() {
        return this.frequencyConf;
    }

    public final Long component8() {
        return this.priority;
    }

    public final Boolean component9() {
        return this.showMute;
    }

    public final PopWindowCandidateConf copy(String r12, Integer r13, PopWindowText r14, List<PopWindowMedia> r15, List<PopWindowButton> r16, PopWindowColor r17, PopWindowFrequencyConf r18, Long r19, Boolean r20) {
        return new PopWindowCandidateConf(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowCandidateConf) == true) goto L8;
        return false;
    L8:
        PopWindowCandidateConf r6 = (PopWindowCandidateConf) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.popWindowType, r6.popWindowType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mediaList, r6.mediaList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.frequencyConf, r6.frequencyConf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.priority, r6.priority) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showMute, r6.showMute) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.popWindowType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        PopWindowText r7 = this.text;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<PopWindowMedia> r10 = this.mediaList;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<PopWindowButton> r13 = this.buttonList;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        PopWindowColor r16 = this.backgroundColor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        PopWindowFrequencyConf r19 = this.frequencyConf;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.priority;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.showMute;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
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

    public String toString() {
        return "PopWindowCandidateConf(name=" + this.name + ", popWindowType=" + this.popWindowType + ", text=" + this.text + ", mediaList=" + this.mediaList + ", buttonList=" + this.buttonList + ", backgroundColor=" + this.backgroundColor + ", frequencyConf=" + this.frequencyConf + ", priority=" + this.priority + ", showMute=" + this.showMute + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.name);
        Integer r0 = this.popWindowType;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        PopWindowText r1 = this.text;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        List<PopWindowMedia> r2 = this.mediaList;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L17:
        List<PopWindowButton> r3 = this.buttonList;
        if (r3 != null) goto L20;
        r6.writeInt(0);
    L24:
        PopWindowColor r4 = this.backgroundColor;
        if (r4 != null) goto L27;
        r6.writeInt(0);
    L28:
        PopWindowFrequencyConf r5 = this.frequencyConf;
        if (r5 != null) goto L31;
        r6.writeInt(0);
    L32:
        Long r8 = this.priority;
        if (r8 != null) goto L35;
        r6.writeInt(0);
    L36:
        Boolean r9 = this.showMute;
        if (r9 != null) goto L39;
        r6.writeInt(0);
        return;
    L39:
        r6.writeInt(1);
        r6.writeInt(r9.booleanValue() ? 1 : 0);
        return;
    L35:
        r6.writeInt(1);
        r6.writeLong(r8.longValue());
        goto L36
    L31:
        r6.writeInt(1);
        r5.writeToParcel(r6, r7);
        goto L32
    L27:
        r6.writeInt(1);
        r4.writeToParcel(r6, r7);
        goto L28
    L20:
        r6.writeInt(1);
        r6.writeInt(r3.size());
        Iterator<PopWindowButton> r10 = r3.iterator();
    L22:
        if (r10.hasNext() == false) goto L24;
        r10.next().writeToParcel(r6, r7);
        goto L22
    L13:
        r6.writeInt(1);
        r6.writeInt(r2.size());
        Iterator<PopWindowMedia> r11 = r2.iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        r11.next().writeToParcel(r6, r7);
        goto L15
    L9:
        r6.writeInt(1);
        r1.writeToParcel(r6, r7);
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.intValue());
        goto L6
    }

    public final PopWindowColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<PopWindowButton> getButtonList() {
        return this.buttonList;
    }

    public final PopWindowFrequencyConf getFrequencyConf() {
        return this.frequencyConf;
    }

    public final List<PopWindowMedia> getMediaList() {
        return this.mediaList;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPopWindowType() {
        return this.popWindowType;
    }

    public final Long getPriority() {
        return this.priority;
    }

    public final Boolean getShowMute() {
        return this.showMute;
    }

    public final PopWindowText getText() {
        return this.text;
    }

    public PopWindowCandidateConf(String r1, Integer r2, PopWindowText r3, List<PopWindowMedia> r4, List<PopWindowButton> r5, PopWindowColor r6, PopWindowFrequencyConf r7, Long r8, Boolean r9) {
        this.name = r1;
        this.popWindowType = r2;
        this.text = r3;
        this.mediaList = r4;
        this.buttonList = r5;
        this.backgroundColor = r6;
        this.frequencyConf = r7;
        this.priority = r8;
        this.showMute = r9;
    }

    public /* synthetic */ PopWindowCandidateConf(String r11, Integer r12, PopWindowText r13, List r14, List r15, PopWindowColor r16, PopWindowFrequencyConf r17, Long r18, Boolean r19, int r20, DefaultConstructorMarker r21) {
        Boolean r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        PopWindowText r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        PopWindowColor r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        PopWindowFrequencyConf r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Long r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
