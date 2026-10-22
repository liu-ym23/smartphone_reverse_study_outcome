package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u0002/0B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bJ%\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0015¨\u00061"}, d2 = {"Lcom/larus/ugc/feed/api/model/TplInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "tplType", "", "tplDetailForNoAvatar", "Lcom/larus/ugc/feed/api/model/TplDetailKmp;", "tplDetailForHasAvatar", "<init>", "(Ljava/lang/String;Lcom/larus/ugc/feed/api/model/TplDetailKmp;Lcom/larus/ugc/feed/api/model/TplDetailKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/ugc/feed/api/model/TplDetailKmp;Lcom/larus/ugc/feed/api/model/TplDetailKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTplType$annotations", "()V", "getTplType", "()Ljava/lang/String;", "getTplDetailForNoAvatar$annotations", "getTplDetailForNoAvatar", "()Lcom/larus/ugc/feed/api/model/TplDetailKmp;", "getTplDetailForHasAvatar$annotations", "getTplDetailForHasAvatar", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TplInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<TplInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final TplDetailKmp tplDetailForHasAvatar;
    private final TplDetailKmp tplDetailForNoAvatar;
    private final String tplType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TplInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            TplDetailKmp.a r1 = TplDetailKmp.a.a;
            return new d[]{kuc.a.d(v2.a), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.TplInfoKmp", r0, 3);
            r1.j("tpl_type", true);
            r1.j("tpl_detail_for_no_avatar", true);
            r1.j("tpl_detail_for_has_avatar", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r17) {
            Intrinsics.checkNotNullParameter(r17, "decoder");
            g2 r1 = b;
            muc.c r0 = r17.beginStructure(r1);
            String r6 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, null);
            TplDetailKmp.a r4 = TplDetailKmp.a.a;
            TplDetailKmp r5 = (TplDetailKmp) r0.decodeNullableSerializableElement(r1, 1, r4, null);
            String r12 = r2;
            TplDetailKmp r14 = (TplDetailKmp) r0.decodeNullableSerializableElement(r1, 2, r4, null);
            TplDetailKmp r13 = r5;
            int r11 = 7;
        L19:
            r0.endStructure(r1);
            return new TplInfoKmp(r11, r12, r13, r14, null);
        L5:
            TplDetailKmp r7 = null;
            TplDetailKmp r8 = null;
            int r3 = 0;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L18;
            int r10 = r0.decodeElementIndex(r1);
            if (r10 != (-1)) goto L9;
            r9 = false;
            goto L6
        L9:
            if (r10 != 0) goto L10;
            r6 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r6);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L11;
            r7 = (TplDetailKmp) r0.decodeNullableSerializableElement(r1, 1, TplDetailKmp.a.a, r7);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r8 = (TplDetailKmp) r0.decodeNullableSerializableElement(r1, 2, TplDetailKmp.a.a, r8);
            r3 = r3 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r10);
        L18:
            r11 = r3;
            r12 = r6;
            r13 = r7;
            r14 = r8;
            goto L19
        }

        public final void serialize(muc.f r2, Object r3) {
            TplInfoKmp r4 = (TplInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            TplInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TplInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TplInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TplInfoKmp createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            String r1 = r6.readString();
            TplDetailKmp r3 = null;
            if (r6.readInt() != 0) goto L5;
            TplDetailKmp r2 = null;
        L6:
            TplDetailKmp r4 = r2;
            if (r6.readInt() == 0) goto L11;
            r3 = TplDetailKmp.CREATOR.createFromParcel(r6);
        L11:
            return new TplInfoKmp(r1, r4, r3);
        L5:
            r2 = TplDetailKmp.CREATOR.createFromParcel(r6);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TplInfoKmp[] newArray(int r1) {
            return new TplInfoKmp[r1];
        }
    }

    public TplInfoKmp() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TplInfoKmp copy$default(TplInfoKmp r0, String r1, TplDetailKmp r2, TplDetailKmp r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.tplType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.tplDetailForNoAvatar;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.tplDetailForHasAvatar;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @SerialName("tpl_detail_for_has_avatar")
    public static /* synthetic */ void getTplDetailForHasAvatar$annotations() {
    }

    @SerialName("tpl_detail_for_no_avatar")
    public static /* synthetic */ void getTplDetailForNoAvatar$annotations() {
    }

    @SerialName("tpl_type")
    public static /* synthetic */ void getTplType$annotations() {
    }

    public final String component1() {
        return this.tplType;
    }

    public final TplDetailKmp component2() {
        return this.tplDetailForNoAvatar;
    }

    public final TplDetailKmp component3() {
        return this.tplDetailForHasAvatar;
    }

    public final TplInfoKmp copy(String r2, TplDetailKmp r3, TplDetailKmp r4) {
        return new TplInfoKmp(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TplInfoKmp) == true) goto L8;
        return false;
    L8:
        TplInfoKmp r6 = (TplInfoKmp) r5;
        if (Intrinsics.areEqual(this.tplType, r6.tplType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tplDetailForNoAvatar, r6.tplDetailForNoAvatar) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tplDetailForHasAvatar, r6.tplDetailForHasAvatar) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.tplType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        TplDetailKmp r4 = this.tplDetailForNoAvatar;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        TplDetailKmp r7 = this.tplDetailForHasAvatar;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TplInfoKmp(tplType=" + this.tplType + ", tplDetailForNoAvatar=" + this.tplDetailForNoAvatar + ", tplDetailForHasAvatar=" + this.tplDetailForHasAvatar + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.tplType);
        TplDetailKmp r0 = this.tplDetailForNoAvatar;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        TplDetailKmp r1 = this.tplDetailForHasAvatar;
        if (r1 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final TplDetailKmp getTplDetailForHasAvatar() {
        return this.tplDetailForHasAvatar;
    }

    public final TplDetailKmp getTplDetailForNoAvatar() {
        return this.tplDetailForNoAvatar;
    }

    public final String getTplType() {
        return this.tplType;
    }

    public TplInfoKmp(String r1, TplDetailKmp r2, TplDetailKmp r3) {
        this.tplType = r1;
        this.tplDetailForNoAvatar = r2;
        this.tplDetailForHasAvatar = r3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(TplInfoKmp r4, muc.d r5, f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, v2.a, r4.tplType);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r5.encodeNullableSerializableElement(r6, 1, TplDetailKmp.a.a, r4.tplDetailForNoAvatar);
    L21:
        if (r5.shouldEncodeElementDefault(r6, 2) == false) goto L24;
    L22:
        r0 = true;
    L26:
        if (r0 == false) goto L29;
        r5.encodeNullableSerializableElement(r6, 2, TplDetailKmp.a.a, r4.tplDetailForHasAvatar);
        return;
    L29:
        return;
    L24:
        if (r4.tplDetailForHasAvatar == null) goto L26;
    L15:
        if (r4.tplDetailForNoAvatar != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r4.tplType != null) goto L4;
        r1 = false;
        goto L9
    }

    public TplInfoKmp(int r2, String r3, TplDetailKmp r4, TplDetailKmp r5, q2 r6) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.tplType = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.tplDetailForNoAvatar = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.tplDetailForHasAvatar = null;
        return;
    L15:
        this.tplDetailForHasAvatar = r5;
        return;
    L11:
        this.tplDetailForNoAvatar = r4;
        goto L13
    L7:
        this.tplType = r3;
        goto L9
    }

    public /* synthetic */ TplInfoKmp(String r2, TplDetailKmp r3, TplDetailKmp r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
