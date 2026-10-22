package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.redpacket.RedPacketCover;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000278B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "Ljava/io/Serializable;", "<init>", "()V", "redPacketId", BuildConfig.FLAVOR, "getRedPacketId", "()Ljava/lang/String;", "setRedPacketId", "(Ljava/lang/String;)V", "subject", "getSubject", "setSubject", "isClicked", BuildConfig.FLAVOR, "()Z", "setClicked", "(Z)V", "isExpired", "setExpired", "isGrabbed", "setGrabbed", "isGrabbedFinish", "setGrabbedFinish", "canGrab", "getCanGrab", "setCanGrab", "previewUsers", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chatter/ChatterInfo;", "getPreviewUsers", "()Ljava/util/List;", "setPreviewUsers", "(Ljava/util/List;)V", "totalNum", BuildConfig.FLAVOR, "getTotalNum", "()I", "setTotalNum", "(I)V", IPortraitService.TYPE, "Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent$Type;", "getType", "()Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent$Type;", "setType", "(Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent$Type;)V", "cover", "Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover;", "getCover", "()Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover;", "setCover", "(Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover;)V", "isContentSame", "diffable", "Companion", "Type", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "RedPacketContent")
public final class RedPacketContent extends Content {
    public static final a Companion = null;
    private static final long serialVersionUID = -6431995976536648010L;
    private boolean canGrab;
    private RedPacketCover cover;
    private boolean isClicked;
    private boolean isExpired;
    private boolean isGrabbed;
    private boolean isGrabbedFinish;
    private List<? extends ChatterInfo> previewUsers;
    private String redPacketId;
    private String subject;
    private int totalNum;
    private Type type;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent$Type;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "P2P", "GROUP_FIX", "GROUP_RANDOM", "COMMERCIAL", "DESIGNATED", "B2C_FIX", "B2C_RANDOM", "isB2C", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type B2C_FIX = null;
        public static final Type B2C_RANDOM = null;
        public static final Type COMMERCIAL = null;
        public static final Companion Companion = null;
        public static final Type DESIGNATED = null;
        public static final Type GROUP_FIX = null;
        public static final Type GROUP_RANDOM = null;
        public static final Type P2P = null;
        public static final Type UNKNOWN = null;
        private final int number;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent$Type$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "valueOf", "Lcom/ss/android/lark/chat/entity/message/content/RedPacketContent$Type;", "value", BuildConfig.FLAVOR, "forNumber", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final Type forNumber(int r1) {
                switch(r1) {
                    case 1: goto L11;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    default: goto L12;
                };
            L12:
                return Type.UNKNOWN;
            L13:
                return Type.B2C_RANDOM;
            L14:
                return Type.B2C_FIX;
            L15:
                return Type.DESIGNATED;
            L16:
                return Type.COMMERCIAL;
            L17:
                return Type.GROUP_RANDOM;
            L18:
                return Type.GROUP_FIX;
            L11:
                return Type.P2P;
            }

            public final Type valueOf(int r1) {
                return forNumber(r1);
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{UNKNOWN, P2P, GROUP_FIX, GROUP_RANDOM, COMMERCIAL, DESIGNATED, B2C_FIX, B2C_RANDOM};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            UNKNOWN = new Type("UNKNOWN", 0, 0);
            P2P = new Type("P2P", 1, 1);
            GROUP_FIX = new Type("GROUP_FIX", 2, 2);
            GROUP_RANDOM = new Type("GROUP_RANDOM", 3, 3);
            COMMERCIAL = new Type("COMMERCIAL", 4, 4);
            DESIGNATED = new Type("DESIGNATED", 5, 5);
            B2C_FIX = new Type("B2C_FIX", 6, 6);
            B2C_RANDOM = new Type("B2C_RANDOM", 7, 7);
            Type[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
            Companion = new Companion(null);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final boolean isB2C() {
            if (this != B2C_FIX) goto L5;
        L8:
            return true;
        L5:
            if (this == B2C_RANDOM) goto L8;
            return false;
        }

        public final int getNumber() {
            return this.number;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.number = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RedPacketContent() {
        this.previewUsers = CollectionsKt.emptyList();
        this.type = Type.UNKNOWN;
    }

    public final boolean getCanGrab() {
        return this.canGrab;
    }

    public final RedPacketCover getCover() {
        return this.cover;
    }

    public final List<ChatterInfo> getPreviewUsers() {
        return this.previewUsers;
    }

    public final String getRedPacketId() {
        return this.redPacketId;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final int getTotalNum() {
        return this.totalNum;
    }

    public final Type getType() {
        return this.type;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public final boolean isGrabbed() {
        return this.isGrabbed;
    }

    public final boolean isGrabbedFinish() {
        return this.isGrabbedFinish;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r5) {
        if (r5 != null) goto L5;
    L36:
        return false;
    L5:
        if ((r5 instanceof RedPacketContent) == false) goto L36;
        if (this != r5) goto L10;
        return true;
    L10:
        RedPacketContent r6 = (RedPacketContent) r5;
        if (this.isClicked == r6.isClicked) goto L14;
        return false;
    L14:
        if (this.isGrabbed == r6.isGrabbed) goto L17;
        return false;
    L17:
        if (this.isGrabbedFinish == r6.isGrabbedFinish) goto L20;
        return false;
    L20:
        if (this.isExpired == r6.isExpired) goto L23;
        return false;
    L23:
        if (Objects.equals(this.redPacketId, r6.redPacketId) == true) goto L26;
        return false;
    L26:
        if (Objects.equals(Boolean.valueOf(this.canGrab), Boolean.valueOf(r6.canGrab)) == true) goto L29;
        return false;
    L29:
        if (Objects.equals(Integer.valueOf(this.totalNum), Integer.valueOf(r6.totalNum)) == true) goto L32;
        return false;
    L32:
        if (Objects.equals(this.previewUsers, r6.previewUsers) == true) goto L35;
        return false;
    L35:
        return !Objects.equals(this.subject, r6.subject);
    }

    public final void setCanGrab(boolean r1) {
        this.canGrab = r1;
    }

    public final void setClicked(boolean r1) {
        this.isClicked = r1;
    }

    public final void setCover(RedPacketCover r1) {
        this.cover = r1;
    }

    public final void setExpired(boolean r1) {
        this.isExpired = r1;
    }

    public final void setGrabbed(boolean r1) {
        this.isGrabbed = r1;
    }

    public final void setGrabbedFinish(boolean r1) {
        this.isGrabbedFinish = r1;
    }

    public final void setPreviewUsers(List<? extends ChatterInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.previewUsers = r2;
    }

    public final void setRedPacketId(String r1) {
        this.redPacketId = r1;
    }

    public final void setSubject(String r1) {
        this.subject = r1;
    }

    public final void setTotalNum(int r1) {
        this.totalNum = r1;
    }

    public final void setType(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }
}
