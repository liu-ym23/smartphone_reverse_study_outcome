package com.ss.android.lark.chat.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001*B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JL\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "sourceId", BuildConfig.FLAVOR, "sourceTextMD5", "sourceType", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;", "privateDescriptionId", BuildConfig.FLAVOR, "entryList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;Ljava/lang/Long;Ljava/util/List;)V", "getSourceId", "()Ljava/lang/String;", "getSourceTextMD5", "getSourceType", "()Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;", "getPrivateDescriptionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEntryList", "()Ljava/util/List;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;Ljava/lang/Long;Ljava/util/List;)Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "toString", "UrlPreViewSourceType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreViewEntries implements Serializable, b<UrlPreViewEntries> {
    private final List<UrlPreViewEntry> entryList;
    private final Long privateDescriptionId;
    private final String sourceId;
    private final String sourceTextMD5;
    private final UrlPreViewSourceType sourceType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries$UrlPreViewSourceType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "CHAT_ANNOUNCEMENT", "PERSONAL_SIG", "PRIVATE_DESCRIPTION", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UrlPreViewSourceType extends Enum<UrlPreViewSourceType> {
        public static final UrlPreViewSourceType CHAT_ANNOUNCEMENT = null;
        public static final a Companion = null;
        public static final UrlPreViewSourceType PERSONAL_SIG = null;
        public static final UrlPreViewSourceType PRIVATE_DESCRIPTION = null;
        public static final /* synthetic */ UrlPreViewSourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<UrlPreViewSourceType> getEntries() {
            return b;
        }

        static {
            UrlPreViewSourceType r0 = new UrlPreViewSourceType("CHAT_ANNOUNCEMENT", 0, 1);
            CHAT_ANNOUNCEMENT = r0;
            UrlPreViewSourceType r1 = new UrlPreViewSourceType("PERSONAL_SIG", 1, 10);
            PERSONAL_SIG = r1;
            UrlPreViewSourceType r4 = new UrlPreViewSourceType("PRIVATE_DESCRIPTION", 2, 11);
            PRIVATE_DESCRIPTION = r4;
            UrlPreViewSourceType[] r5 = {r0, r1, r4};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static UrlPreViewSourceType[] values() {
            return (UrlPreViewSourceType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UrlPreViewSourceType valueOf(String r1) {
            return (UrlPreViewSourceType) r27.a.a(UrlPreViewSourceType.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public UrlPreViewSourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreViewEntries copy$default(UrlPreViewEntries r3, String r4, String r5, UrlPreViewSourceType r6, Long r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.sourceId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.sourceTextMD5;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.sourceType;
    L11:
        UrlPreViewSourceType r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.privateDescriptionId;
    L14:
        Long r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.entryList;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.sourceId;
    }

    public final String component2() {
        return this.sourceTextMD5;
    }

    public final UrlPreViewSourceType component3() {
        return this.sourceType;
    }

    public final Long component4() {
        return this.privateDescriptionId;
    }

    public final List<UrlPreViewEntry> component5() {
        return this.entryList;
    }

    public final UrlPreViewEntries copy(String r8, String r9, UrlPreViewSourceType r10, Long r11, List<UrlPreViewEntry> r12) {
        Intrinsics.checkNotNullParameter(r9, "sourceTextMD5");
        Intrinsics.checkNotNullParameter(r12, "entryList");
        return new UrlPreViewEntries(r8, r9, r10, r11, r12);
    }

    public String toString() {
        return "UrlPreViewEntries(sourceId=" + this.sourceId + ", sourceTextMD5=" + this.sourceTextMD5 + ", sourceType=" + this.sourceType + ", privateDescriptionId=" + this.privateDescriptionId + ", entryList=" + this.entryList + ')';
    }

    public int hashCode() {
        String r0 = this.sourceId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.sourceTextMD5.hashCode()) * 31;
        UrlPreViewSourceType r4 = this.sourceType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.privateDescriptionId;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + this.entryList.hashCode();
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final List<UrlPreViewEntry> getEntryList() {
        return this.entryList;
    }

    public final Long getPrivateDescriptionId() {
        return this.privateDescriptionId;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getSourceTextMD5() {
        return this.sourceTextMD5;
    }

    public final UrlPreViewSourceType getSourceType() {
        return this.sourceType;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlPreViewEntries) == true) goto L8;
        return false;
    L8:
        UrlPreViewEntries r6 = (UrlPreViewEntries) r5;
        if (Intrinsics.areEqual(this.sourceId, r6.sourceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceTextMD5, r6.sourceTextMD5) == true) goto L15;
        return false;
    L15:
        if (this.sourceType == r6.sourceType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.privateDescriptionId, r6.privateDescriptionId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entryList, r6.entryList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public boolean isContentSame(UrlPreViewEntries r6) {
        String r0 = this.sourceId;
        Long r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.sourceId;
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L34;
        String r3 = this.sourceTextMD5;
        if (r6 == null) goto L11;
        String r4 = r6.sourceTextMD5;
    L13:
        if (Intrinsics.areEqual(r3, r4) == false) goto L34;
        UrlPreViewSourceType r5 = this.sourceType;
        if (r5 == null) goto L22;
        if (r6 == null) goto L18;
        UrlPreViewSourceType r7 = r6.sourceType;
    L20:
        if (r5.equals(r7) == true) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L34;
        Long r9 = this.privateDescriptionId;
        if (r6 == null) goto L28;
        r1 = r6.privateDescriptionId;
    L28:
        if (Intrinsics.areEqual(r9, r1) == false) goto L34;
        if (a.b(this.entryList, r6.entryList) == true) goto L33;
        return false;
    L33:
        return true;
    L18:
        r7 = null;
    L22:
        r8 = false;
        goto L23
    L11:
        r4 = null;
    L34:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public boolean isItemSame(UrlPreViewEntries r6) {
        String r0 = this.sourceId;
        Long r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.sourceId;
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L27;
        String r3 = this.sourceTextMD5;
        if (r6 == null) goto L11;
        String r4 = r6.sourceTextMD5;
    L13:
        if (Intrinsics.areEqual(r3, r4) == false) goto L27;
        UrlPreViewSourceType r5 = this.sourceType;
        if (r5 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == false) goto L27;
        Long r8 = this.privateDescriptionId;
        if (r6 == null) goto L25;
        r1 = r6.privateDescriptionId;
    L25:
        if (Intrinsics.areEqual(r8, r1) == false) goto L27;
        return true;
    L17:
        if (r5.equals(r6.sourceType) != true) goto L19;
        r7 = true;
        goto L20
    L11:
        r4 = null;
    L27:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UrlPreViewEntries) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UrlPreViewEntries) r1);
    }

    public UrlPreViewEntries(String r2, String r3, UrlPreViewSourceType r4, Long r5, List<UrlPreViewEntry> r6) {
        Intrinsics.checkNotNullParameter(r3, "sourceTextMD5");
        Intrinsics.checkNotNullParameter(r6, "entryList");
        this.sourceId = r2;
        this.sourceTextMD5 = r3;
        this.sourceType = r4;
        this.privateDescriptionId = r5;
        this.entryList = r6;
    }
}
