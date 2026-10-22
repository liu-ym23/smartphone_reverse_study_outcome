package com.ss.android.lark.export.entity.preview;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\"B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "avatarKey", BuildConfig.FLAVOR, "chatterId", IPortraitService.NAME, "chatterType", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;)V", "getAvatarKey", "()Ljava/lang/String;", "getChatterId", "getName", "setName", "(Ljava/lang/String;)V", "getChatterType", "()Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "ChatterType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterPreviewChatterInfo implements Serializable, b<ChatterPreviewChatterInfo> {
    private final String avatarKey;
    private final String chatterId;
    private final ChatterType chatterType;
    private String name;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatterType extends Enum<ChatterType> {
        public static final a Companion = null;
        public static final ChatterType UNKNOWN = null;
        public static final ChatterType USER = null;
        public static final /* synthetic */ ChatterType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChatterType> getEntries() {
            return b;
        }

        static {
            ChatterType r0 = new ChatterType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatterType r1 = new ChatterType("USER", 1, 1);
            USER = r1;
            ChatterType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static ChatterType[] values() {
            return (ChatterType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatterType valueOf(String r1) {
            return (ChatterType) r27.a.a(ChatterType.class, r1);
        }

        public ChatterType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ChatterPreviewChatterInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ChatterPreviewChatterInfo copy$default(ChatterPreviewChatterInfo r0, String r1, String r2, String r3, ChatterType r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.avatarKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.chatterId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.name;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.chatterType;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.chatterId;
    }

    public final String component3() {
        return this.name;
    }

    public final ChatterType component4() {
        return this.chatterType;
    }

    public final ChatterPreviewChatterInfo copy(String r2, String r3, String r4, ChatterType r5) {
        Intrinsics.checkNotNullParameter(r5, "chatterType");
        return new ChatterPreviewChatterInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatterPreviewChatterInfo) == true) goto L8;
        return false;
    L8:
        ChatterPreviewChatterInfo r6 = (ChatterPreviewChatterInfo) r5;
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterId, r6.chatterId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
        return false;
    L18:
        if (this.chatterType == r6.chatterType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.avatarKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.chatterId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.chatterType.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatterPreviewChatterInfo(avatarKey=" + this.avatarKey + ", chatterId=" + this.chatterId + ", name=" + this.name + ", chatterType=" + this.chatterType + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final ChatterType getChatterType() {
        return this.chatterType;
    }

    public final String getName() {
        return this.name;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((ChatterPreviewChatterInfo) r1);
    }

    public boolean isItemSame(ChatterPreviewChatterInfo r2) {
        String r0 = this.chatterId;
        if (r2 == null) goto L5;
        String r3 = r2.chatterId;
    L7:
        return Intrinsics.areEqual(r0, r3);
    L5:
        r3 = null;
        goto L7
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public boolean isContentSame(ChatterPreviewChatterInfo r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((ChatterPreviewChatterInfo) r1);
    }

    public ChatterPreviewChatterInfo(String r2, String r3, String r4, ChatterType r5) {
        Intrinsics.checkNotNullParameter(r5, "chatterType");
        this.avatarKey = r2;
        this.chatterId = r3;
        this.name = r4;
        this.chatterType = r5;
    }

    public /* synthetic */ ChatterPreviewChatterInfo(String r2, String r3, String r4, ChatterType r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = ChatterType.USER;
    L14:
        this(r2, r3, r4, r5);
    }
}
