package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010#\u001a\u00020$H\u0016J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020$HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "keyword", "", "field", "value", "isSemantic", "", "score", "Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "fieldArrayUniqueKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/obric/capabilitykit/entity/search/SearchScoreParam;Ljava/lang/String;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldArrayUniqueKey", "setFieldArrayUniqueKey", "()Z", "getKeyword", "getScore", "()Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "setScore", "(Lcom/obric/capabilitykit/entity/search/SearchScoreParam;)V", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchEntityParam implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private String field;
    private String fieldArrayUniqueKey;
    private final boolean isSemantic;
    private final String keyword;
    private SearchScoreParam score;
    private final String value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchEntityParam> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchEntityParam createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InAppSearchEntityParam(r2);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchEntityParam[] newArray(int r1) {
            return new InAppSearchEntityParam[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchEntityParam(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        this(EntityExtKt.e(r11), EntityExtKt.e(r11), r11.readString(), EntityExtKt.d(r11), (SearchScoreParam) r11.readParcelable(SearchScoreParam.class.getClassLoader()), null, 32, null);
        int r0 = r11.dataPosition();
        String r1 = r11.readString();
        int r3 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r11.setDataPosition(r0);
    L12:
        int r2 = CastIntegerProtector.parseInt(VERSION);
        if (r3 > r2) goto L16;
        r2 = r3;
    L16:
        ClassLoader r5 = InAppSearchEntityParam.class.getClassLoader();
        int r6 = 1;
    L17:
        if (r6 > r2) goto L21;
        if (r6 != 1) goto L20;
        this.fieldArrayUniqueKey = (String) r11.readValue(r5);
    L20:
        r6 = r6 + 1;
    L21:
        if (r6 > r3) goto L23;
        ParcelUtils.INSTANCE.skipValueSafely(r11, r5);
        r6 = r6 + 1;
        goto L21
    L23:
        return;
    L11:
        r3 = CastIntegerProtector.parseInt(r1);
        goto L12
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public InAppSearchEntityParam(String r2, String r3, String r4, boolean r5, SearchScoreParam r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        Intrinsics.checkNotNullParameter(r3, "field");
        this.keyword = r2;
        this.field = r3;
        this.value = r4;
        this.isSemantic = r5;
        this.score = r6;
        this.fieldArrayUniqueKey = r7;
    }

    public /* synthetic */ InAppSearchEntityParam(String r10, String r11, String r12, boolean r13, SearchScoreParam r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r16 & 16) == 0) goto L13;
        SearchScoreParam r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        String r8 = null;
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public static /* synthetic */ InAppSearchEntityParam copy$default(InAppSearchEntityParam r4, String r5, String r6, String r7, boolean r8, SearchScoreParam r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.keyword;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.field;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.value;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isSemantic;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.score;
    L17:
        SearchScoreParam r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.fieldArrayUniqueKey;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.keyword;
    }

    public final String component2() {
        return this.field;
    }

    public final String component3() {
        return this.value;
    }

    public final boolean component4() {
        return this.isSemantic;
    }

    public final SearchScoreParam component5() {
        return this.score;
    }

    public final String component6() {
        return this.fieldArrayUniqueKey;
    }

    public final InAppSearchEntityParam copy(String r9, String r10, String r11, boolean r12, SearchScoreParam r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "keyword");
        Intrinsics.checkNotNullParameter(r10, "field");
        return new InAppSearchEntityParam(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InAppSearchEntityParam) == true) goto L8;
        return false;
    L8:
        InAppSearchEntityParam r6 = (InAppSearchEntityParam) r5;
        if (Intrinsics.areEqual(this.keyword, r6.keyword) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.field, r6.field) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L18;
        return false;
    L18:
        if (this.isSemantic == r6.isSemantic) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.score, r6.score) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fieldArrayUniqueKey, r6.fieldArrayUniqueKey) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getField() {
        return this.field;
    }

    public final String getFieldArrayUniqueKey() {
        return this.fieldArrayUniqueKey;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final SearchScoreParam getScore() {
        return this.score;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int r0 = ((this.keyword.hashCode() * 31) + this.field.hashCode()) * 31;
        String r1 = this.value;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.isSemantic;
        ?? r6 = r5;
        if (r5 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r4 + r6) * 31;
        SearchScoreParam r8 = this.score;
        if (r8 != null) goto L12;
        int r9 = 0;
    L13:
        int r10 = (r7 + r9) * 31;
        String r11 = this.fieldArrayUniqueKey;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L12:
        r9 = r8.hashCode();
        goto L13
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final void setField(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.field = r2;
    }

    public final void setFieldArrayUniqueKey(String r1) {
        this.fieldArrayUniqueKey = r1;
    }

    public final void setScore(SearchScoreParam r1) {
        this.score = r1;
    }

    public String toString() {
        return "InAppSearchEntityParam(keyword=" + this.keyword + ", field=" + this.field + ", value=" + this.value + ", isSemantic=" + this.isSemantic + ", score=" + this.score + ", fieldArrayUniqueKey=" + this.fieldArrayUniqueKey + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.keyword);
        r3.writeString(this.field);
        r3.writeString(this.value);
        boolean r0 = this.isSemantic;
        Gson r1 = EntityExtKt.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.writeInt(r0 ? 1 : 0);
        r3.writeParcelable(this.score, r4);
        r3.writeString(VERSION);
        r3.writeValue(this.fieldArrayUniqueKey);
    }
}
