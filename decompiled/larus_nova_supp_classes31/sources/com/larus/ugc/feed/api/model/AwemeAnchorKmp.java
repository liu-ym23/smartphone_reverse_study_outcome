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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002)*B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\tJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ%\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006+"}, d2 = {"Lcom/larus/ugc/feed/api/model/AwemeAnchorKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "anchorId", "", "anchorName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAnchorId$annotations", "()V", "getAnchorId", "()Ljava/lang/String;", "getAnchorName$annotations", "getAnchorName", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class AwemeAnchorKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<AwemeAnchorKmp> CREATOR = null;
    public static final b Companion = null;
    private final String anchorId;
    private final String anchorName;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AwemeAnchorKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.AwemeAnchorKmp", r0, 2);
            r1.j("anchor_id", true);
            r1.j("anchor_name", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            if (r12.decodeSequentially() == false) goto L5;
            v2 r1 = v2.a;
            String r2 = (String) r12.decodeNullableSerializableElement(r0, 0, r1, null);
            String r3 = (String) r12.decodeNullableSerializableElement(r0, 1, r1, null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new AwemeAnchorKmp(r4, r2, r3, null);
        L5:
            r3 = null;
            String r5 = null;
            int r6 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r12.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r5 = (String) r12.decodeNullableSerializableElement(r0, 0, v2.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r3 = (String) r12.decodeNullableSerializableElement(r0, 1, v2.a, r3);
            r6 = r6 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r2 = r5;
            r4 = r6;
            goto L17
        }

        public final void serialize(muc.f r2, Object r3) {
            AwemeAnchorKmp r4 = (AwemeAnchorKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            AwemeAnchorKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AwemeAnchorKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<AwemeAnchorKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final AwemeAnchorKmp createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new AwemeAnchorKmp(r3.readString(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AwemeAnchorKmp[] newArray(int r1) {
            return new AwemeAnchorKmp[r1];
        }
    }

    public AwemeAnchorKmp() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ AwemeAnchorKmp copy$default(AwemeAnchorKmp r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.anchorId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.anchorName;
    L9:
        return r0.copy(r1, r2);
    }

    @SerialName("anchor_id")
    public static /* synthetic */ void getAnchorId$annotations() {
    }

    @SerialName("anchor_name")
    public static /* synthetic */ void getAnchorName$annotations() {
    }

    public final String component1() {
        return this.anchorId;
    }

    public final String component2() {
        return this.anchorName;
    }

    public final AwemeAnchorKmp copy(String r2, String r3) {
        return new AwemeAnchorKmp(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AwemeAnchorKmp) == true) goto L8;
        return false;
    L8:
        AwemeAnchorKmp r6 = (AwemeAnchorKmp) r5;
        if (Intrinsics.areEqual(this.anchorId, r6.anchorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorName, r6.anchorName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.anchorId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.anchorName;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AwemeAnchorKmp(anchorId=" + this.anchorId + ", anchorName=" + this.anchorName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.anchorId);
        r1.writeString(this.anchorName);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAnchorName() {
        return this.anchorName;
    }

    public AwemeAnchorKmp(String r1, String r2) {
        this.anchorId = r1;
        this.anchorName = r2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(AwemeAnchorKmp r4, muc.d r5, f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, v2.a, r4.anchorId);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        r0 = true;
    L17:
        if (r0 == false) goto L20;
        r5.encodeNullableSerializableElement(r6, 1, v2.a, r4.anchorName);
        return;
    L20:
        return;
    L15:
        if (r4.anchorName == null) goto L17;
    L6:
        if (r4.anchorId != null) goto L4;
        r1 = false;
        goto L9
    }

    public AwemeAnchorKmp(int r2, String r3, String r4, q2 r5) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.anchorId = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.anchorName = null;
        return;
    L11:
        this.anchorName = r4;
        return;
    L7:
        this.anchorId = r3;
        goto L9
    }

    public /* synthetic */ AwemeAnchorKmp(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
