package com.ss.android.lark.chat.entity.redpacket;

import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00014Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J{\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00065"}, d2 = {"Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, IPortraitService.NAME, BuildConfig.FLAVOR, "coverType", "Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;", "mainCover", "Lcom/ss/android/lark/image/entity/PassThroughImage;", "messageCover", "headCover", "companyLogo", "selectCover", "displayName", "Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;", "companyName", "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getCoverType", "()Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;", "getMainCover", "()Lcom/ss/android/lark/image/entity/PassThroughImage;", "getMessageCover", "getHeadCover", "getCompanyLogo", "getSelectCover", "getDisplayName", "()Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;", "getCompanyName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "CoverType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedPacketCover implements Serializable {
    private final PassThroughImage companyLogo;
    private final String companyName;
    private final CoverType coverType;
    private final RedPacketDisplayName displayName;
    private final PassThroughImage headCover;
    private final long id;
    private final PassThroughImage mainCover;
    private final PassThroughImage messageCover;
    private final String name;
    private final PassThroughImage selectCover;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TEMPLATE", "CUSTOMIZE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CoverType extends Enum<CoverType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CoverType[] $VALUES = null;
        public static final CoverType CUSTOMIZE = null;
        public static final CoverType TEMPLATE = null;
        public static final CoverType UNKNOWN = null;

        private static final /* synthetic */ CoverType[] $values() {
            return new CoverType[]{UNKNOWN, TEMPLATE, CUSTOMIZE};
        }

        public static EnumEntries<CoverType> getEntries() {
            return $ENTRIES;
        }

        static {
            UNKNOWN = new CoverType("UNKNOWN", 0);
            TEMPLATE = new CoverType("TEMPLATE", 1);
            CUSTOMIZE = new CoverType("CUSTOMIZE", 2);
            CoverType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static CoverType[] values() {
            return (CoverType[]) $VALUES.clone();
        }

        public static CoverType valueOf(String r1) {
            return (CoverType) a.a(CoverType.class, r1);
        }

        private CoverType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ RedPacketCover copy$default(RedPacketCover r12, long r13, String r15, CoverType r16, PassThroughImage r17, PassThroughImage r18, PassThroughImage r19, PassThroughImage r20, PassThroughImage r21, RedPacketDisplayName r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        long r2 = r12.id;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r4 = r12.name;
    L11:
        if ((r24 & 4) == 0) goto L13;
        CoverType r5 = r12.coverType;
    L15:
        if ((r24 & 8) == 0) goto L17;
        PassThroughImage r6 = r12.mainCover;
    L19:
        if ((r24 & 16) == 0) goto L21;
        PassThroughImage r7 = r12.messageCover;
    L23:
        if ((r24 & 32) == 0) goto L25;
        PassThroughImage r8 = r12.headCover;
    L27:
        if ((r24 & 64) == 0) goto L29;
        PassThroughImage r9 = r12.companyLogo;
    L31:
        if ((r24 & 128) == 0) goto L33;
        PassThroughImage r10 = r12.selectCover;
    L35:
        if ((r24 & 256) == 0) goto L37;
        RedPacketDisplayName r11 = r12.displayName;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r1 = r12.companyName;
    L43:
        return r12.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L41:
        r1 = r23;
        goto L43
    L37:
        r11 = r22;
        goto L39
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r4 = r15;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.companyName;
    }

    public final String component2() {
        return this.name;
    }

    public final CoverType component3() {
        return this.coverType;
    }

    public final PassThroughImage component4() {
        return this.mainCover;
    }

    public final PassThroughImage component5() {
        return this.messageCover;
    }

    public final PassThroughImage component6() {
        return this.headCover;
    }

    public final PassThroughImage component7() {
        return this.companyLogo;
    }

    public final PassThroughImage component8() {
        return this.selectCover;
    }

    public final RedPacketDisplayName component9() {
        return this.displayName;
    }

    public final RedPacketCover copy(long r14, String r16, CoverType r17, PassThroughImage r18, PassThroughImage r19, PassThroughImage r20, PassThroughImage r21, PassThroughImage r22, RedPacketDisplayName r23, String r24) {
        Intrinsics.checkNotNullParameter(r16, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r17, "coverType");
        return new RedPacketCover(r14, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RedPacketCover) == true) goto L8;
        return false;
    L8:
        RedPacketCover r9 = (RedPacketCover) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (this.coverType == r9.coverType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mainCover, r9.mainCover) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageCover, r9.messageCover) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headCover, r9.headCover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.companyLogo, r9.companyLogo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectCover, r9.selectCover) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.displayName, r9.displayName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.companyName, r9.companyName) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.name.hashCode()) * 31) + this.coverType.hashCode()) * 31;
        PassThroughImage r2 = this.mainCover;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        PassThroughImage r6 = this.messageCover;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        PassThroughImage r9 = this.headCover;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        PassThroughImage r12 = this.companyLogo;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        PassThroughImage r15 = this.selectCover;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        RedPacketDisplayName r18 = this.displayName;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.companyName;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        return r20 + r3;
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "RedPacketCover(id=" + this.id + ", name=" + this.name + ", coverType=" + this.coverType + ", mainCover=" + this.mainCover + ", messageCover=" + this.messageCover + ", headCover=" + this.headCover + ", companyLogo=" + this.companyLogo + ", selectCover=" + this.selectCover + ", displayName=" + this.displayName + ", companyName=" + this.companyName + ')';
    }

    public final PassThroughImage getCompanyLogo() {
        return this.companyLogo;
    }

    public final String getCompanyName() {
        return this.companyName;
    }

    public final CoverType getCoverType() {
        return this.coverType;
    }

    public final RedPacketDisplayName getDisplayName() {
        return this.displayName;
    }

    public final PassThroughImage getHeadCover() {
        return this.headCover;
    }

    public final long getId() {
        return this.id;
    }

    public final PassThroughImage getMainCover() {
        return this.mainCover;
    }

    public final PassThroughImage getMessageCover() {
        return this.messageCover;
    }

    public final String getName() {
        return this.name;
    }

    public final PassThroughImage getSelectCover() {
        return this.selectCover;
    }

    public RedPacketCover(long r2, String r4, CoverType r5, PassThroughImage r6, PassThroughImage r7, PassThroughImage r8, PassThroughImage r9, PassThroughImage r10, RedPacketDisplayName r11, String r12) {
        Intrinsics.checkNotNullParameter(r4, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r5, "coverType");
        this.id = r2;
        this.name = r4;
        this.coverType = r5;
        this.mainCover = r6;
        this.messageCover = r7;
        this.headCover = r8;
        this.companyLogo = r9;
        this.selectCover = r10;
        this.displayName = r11;
        this.companyName = r12;
    }
}
