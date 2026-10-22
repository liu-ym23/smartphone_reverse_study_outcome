package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardData;", "Landroid/os/Parcelable;", "actionCards", "", "Lcom/larus/bmhome/auth/OnboardingActionCardItemData;", "<init>", "(Ljava/util/List;)V", "getActionCards", "()Ljava/util/List;", "setActionCards", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CardScene", "CardType", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class OnboardingActionCardData implements Parcelable {
    public static final Parcelable.Creator<OnboardingActionCardData> CREATOR = null;

    @SerializedName("skill_cards")
    private List<OnboardingActionCardItemData> actionCards;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FirstMet", "ActionCard", "NewTopics", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum CardScene extends Enum<CardScene> {
        public static final CardScene ActionCard = null;
        public static final CardScene FirstMet = null;
        public static final CardScene NewTopics = null;
        public static final /* synthetic */ CardScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<CardScene> getEntries() {
            return b;
        }

        static {
            CardScene r0 = new CardScene("FirstMet", 0, 1);
            FirstMet = r0;
            CardScene r1 = new CardScene("ActionCard", 1, 2);
            ActionCard = r1;
            CardScene r4 = new CardScene("NewTopics", 2, 3);
            NewTopics = r4;
            CardScene[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static CardScene[] values() {
            return (CardScene[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CardScene valueOf(String r1) {
            return (CardScene) r27.a.a(CardScene.class, r1);
        }

        public CardScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardData$CardType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AISearch", "Text2Img", "Music", "TextCreate", "ReadFile", "ImageRecognize", "ScanQuestion", "Universal", "toTea", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum CardType extends Enum<CardType> {
        public static final CardType AISearch = null;
        public static final a Companion = null;
        public static final CardType ImageRecognize = null;
        public static final CardType Music = null;
        public static final CardType ReadFile = null;
        public static final CardType ScanQuestion = null;
        public static final CardType Text2Img = null;
        public static final CardType TextCreate = null;
        public static final CardType Universal = null;
        public static final /* synthetic */ CardType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CardType> getEntries() {
            return b;
        }

        static {
            CardType r0 = new CardType("AISearch", 0, 1);
            AISearch = r0;
            CardType r1 = new CardType("Text2Img", 1, 2);
            Text2Img = r1;
            CardType r4 = new CardType("Music", 2, 3);
            Music = r4;
            CardType r6 = new CardType("TextCreate", 3, 4);
            TextCreate = r6;
            CardType r8 = new CardType("ReadFile", 4, 5);
            ReadFile = r8;
            CardType r10 = new CardType("ImageRecognize", 5, 6);
            ImageRecognize = r10;
            CardType r12 = new CardType("ScanQuestion", 6, 7);
            ScanQuestion = r12;
            CardType r14 = new CardType("Universal", 7, 8);
            Universal = r14;
            CardType[] r11 = {r0, r1, r4, r6, r8, r10, r12, r14};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static CardType[] values() {
            return (CardType[]) a.clone();
        }

        public final String toTea() {
            switch(this.value) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L5;
                default: goto L4;
            };
        L4:
            return "";
        L5:
            return "universal";
        L6:
            return "edu_ocr";
        L7:
            return "ocr";
        L8:
            return "pdf_read";
        L9:
            return "text_creation";
        L10:
            return "music_creation";
        L11:
            return "image_creation";
        L12:
            return "ai_search";
        }

        public final int getValue() {
            return this.value;
        }

        public static CardType valueOf(String r1) {
            return (CardType) r27.a.a(CardType.class, r1);
        }

        public CardType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a implements Parcelable.Creator<OnboardingActionCardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OnboardingActionCardData createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            ArrayList r1 = null;
            if (r6.readInt() == 0) goto L14;
            int r0 = r6.readInt();
            ArrayList r2 = new ArrayList(r0);
            int r3 = 0;
        L6:
            if (r3 == r0) goto L12;
            if (r6.readInt() != 0) goto L10;
            Object r4 = null;
        L11:
            r2.add(r4);
            r3 = r3 + 1;
            goto L6
        L10:
            r4 = OnboardingActionCardItemData.CREATOR.createFromParcel(r6);
            goto L11
        L12:
            r1 = r2;
        L14:
            return new OnboardingActionCardData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final OnboardingActionCardData[] newArray(int r1) {
            return new OnboardingActionCardData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public OnboardingActionCardData() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof OnboardingActionCardData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.actionCards, ((OnboardingActionCardData) r4).actionCards) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<OnboardingActionCardItemData> r0 = this.actionCards;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "OnboardingActionCardData(actionCards=" + this.actionCards + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<OnboardingActionCardItemData> r0 = this.actionCards;
        if (r0 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<OnboardingActionCardItemData> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L19;
        OnboardingActionCardItemData r3 = r1.next();
        if (r3 == null) goto L10;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L7
    L10:
        r5.writeInt(0);
        goto L7
    }

    public final List<OnboardingActionCardItemData> a() {
        return this.actionCards;
    }

    public OnboardingActionCardData(List<OnboardingActionCardItemData> r1) {
        this.actionCards = r1;
    }
}
