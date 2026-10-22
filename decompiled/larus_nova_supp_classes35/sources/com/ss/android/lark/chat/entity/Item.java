package com.ss.android.lark.chat.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jd\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001c¨\u0006."}, d2 = {"Lcom/ss/android/lark/chat/entity/Item;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, "entityId", BuildConfig.FLAVOR, "entityType", "Lcom/ss/android/lark/chat/entity/Item$Type;", "parentId", "orderWeight", "nameWeight", Keys.API_RETURN_KEY_VERSION, "isHidden", BuildConfig.FLAVOR, "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/Item$Type;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;JZ)V", "getId", "()J", "getEntityId", "()Ljava/lang/String;", "getEntityType", "()Lcom/ss/android/lark/chat/entity/Item$Type;", "getParentId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOrderWeight", "getNameWeight", "getVersion", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/Item$Type;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;JZ)Lcom/ss/android/lark/chat/entity/Item;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Type", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Item implements Serializable {
    private final String entityId;
    private final Type entityType;
    private final long id;
    private final boolean isHidden;
    private final String nameWeight;
    private final Long orderWeight;
    private final Long parentId;
    private final long version;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/Item$Type;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "TEAM", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type CHAT = null;
        public static final a Companion = null;
        public static final Type TEAM = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("CHAT", 1, 1);
            CHAT = r1;
            Type r3 = new Type("TEAM", 2, 2);
            TEAM = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r2) {
            Companion.getClass();
            Type r0 = CHAT;
            if (r2 == r0.getValue()) goto L10;
            Type r1 = TEAM;
            if (r2 != r1.getValue()) goto L9;
            return r1;
        L9:
            return UNKNOWN;
        L10:
            return r0;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ Item copy$default(Item r11, long r12, String r14, Type r15, Long r16, Long r17, String r18, long r19, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r2 = r11.id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r4 = r11.entityId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Type r5 = r11.entityType;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Long r6 = r11.parentId;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Long r7 = r11.orderWeight;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r8 = r11.nameWeight;
    L27:
        if ((r22 & 64) == 0) goto L29;
        long r9 = r11.version;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r1 = r11.isHidden;
    L35:
        return r11.copy(r2, r4, r5, r6, r7, r8, r9, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.entityId;
    }

    public final Type component3() {
        return this.entityType;
    }

    public final Long component4() {
        return this.parentId;
    }

    public final Long component5() {
        return this.orderWeight;
    }

    public final String component6() {
        return this.nameWeight;
    }

    public final long component7() {
        return this.version;
    }

    public final boolean component8() {
        return this.isHidden;
    }

    public final Item copy(long r13, String r15, Type r16, Long r17, Long r18, String r19, long r20, boolean r22) {
        Intrinsics.checkNotNullParameter(r15, "entityId");
        Intrinsics.checkNotNullParameter(r16, "entityType");
        return new Item(r13, r15, r16, r17, r18, r19, r20, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Item) == true) goto L8;
        return false;
    L8:
        Item r9 = (Item) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r9.entityId) == true) goto L15;
        return false;
    L15:
        if (this.entityType == r9.entityType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentId, r9.parentId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.orderWeight, r9.orderWeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.nameWeight, r9.nameWeight) == true) goto L27;
        return false;
    L27:
        if (this.version == r9.version) goto L30;
        return false;
    L30:
        if (this.isHidden == r9.isHidden) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        long r0 = this.id;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.entityId.hashCode()) * 31) + this.entityType.hashCode()) * 31;
        Long r2 = this.parentId;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        Long r6 = this.orderWeight;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.nameWeight;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        int r10 = (r8 + r3) * 31;
        long r11 = this.version;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        if (this.isHidden == false) goto L17;
        int r13 = 1231;
    L19:
        return r12 + r13;
    L17:
        r13 = 1237;
        goto L19
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "Item(id=" + this.id + ", entityId=" + this.entityId + ", entityType=" + this.entityType + ", parentId=" + this.parentId + ", orderWeight=" + this.orderWeight + ", nameWeight=" + this.nameWeight + ", version=" + this.version + ", isHidden=" + this.isHidden + ')';
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final Type getEntityType() {
        return this.entityType;
    }

    public final long getId() {
        return this.id;
    }

    public final String getNameWeight() {
        return this.nameWeight;
    }

    public final Long getOrderWeight() {
        return this.orderWeight;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final long getVersion() {
        return this.version;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public Item(long r2, String r4, Type r5, Long r6, Long r7, String r8, long r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        Intrinsics.checkNotNullParameter(r5, "entityType");
        this.id = r2;
        this.entityId = r4;
        this.entityType = r5;
        this.parentId = r6;
        this.orderWeight = r7;
        this.nameWeight = r8;
        this.version = r9;
        this.isHidden = r11;
    }
}
