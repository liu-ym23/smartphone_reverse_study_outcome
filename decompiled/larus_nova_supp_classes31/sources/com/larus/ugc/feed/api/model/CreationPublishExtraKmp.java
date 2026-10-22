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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u0002/0B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bJ%\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u00061"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "isNewPublish", "", "publicRefImage", "caption", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "isNewPublish$annotations", "()V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPublicRefImage$annotations", "getPublicRefImage", "getCaption$annotations", "getCaption", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/ugc/feed/api/model/CreationPublishExtraKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationPublishExtraKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationPublishExtraKmp> CREATOR = null;
    public static final b Companion = null;
    private final String caption;
    private final Boolean isNewPublish;
    private final Boolean publicRefImage;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationPublishExtraKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            i r1 = i.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(v2.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationPublishExtraKmp", r0, 3);
            r1.j("is_new_publish", true);
            r1.j("public_ref_image", true);
            r1.j("caption", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r17) {
            Intrinsics.checkNotNullParameter(r17, "decoder");
            g2 r1 = b;
            muc.c r0 = r17.beginStructure(r1);
            Boolean r6 = null;
            if (r0.decodeSequentially() == false) goto L5;
            i r2 = i.a;
            Boolean r4 = (Boolean) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Boolean r13 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, null);
            Boolean r12 = r4;
            int r11 = 7;
        L19:
            r0.endStructure(r1);
            return new CreationPublishExtraKmp(r11, r12, r13, r14, null);
        L5:
            Boolean r7 = null;
            String r8 = null;
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
            r6 = (Boolean) r0.decodeNullableSerializableElement(r1, 0, i.a, r6);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L11;
            r7 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, r7);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r8);
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
            CreationPublishExtraKmp r4 = (CreationPublishExtraKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationPublishExtraKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationPublishExtraKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationPublishExtraKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationPublishExtraKmp createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            boolean r2 = false;
            Boolean r4 = null;
            if (r7.readInt() != 0) goto L6;
            Boolean r1 = null;
        L11:
            if (r7.readInt() == 0) goto L18;
            if (r7.readInt() == 0) goto L16;
            r2 = true;
        L16:
            r4 = Boolean.valueOf(r2);
        L18:
            return new CreationPublishExtraKmp(r1, r4, r7.readString());
        L6:
            if (r7.readInt() == 0) goto L8;
            boolean r3 = true;
        L9:
            r1 = Boolean.valueOf(r3);
            goto L11
        L8:
            r3 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final CreationPublishExtraKmp[] newArray(int r1) {
            return new CreationPublishExtraKmp[r1];
        }
    }

    public CreationPublishExtraKmp() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CreationPublishExtraKmp copy$default(CreationPublishExtraKmp r0, Boolean r1, Boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isNewPublish;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.publicRefImage;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.caption;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @SerialName("caption")
    public static /* synthetic */ void getCaption$annotations() {
    }

    @SerialName("public_ref_image")
    public static /* synthetic */ void getPublicRefImage$annotations() {
    }

    @SerialName("is_new_publish")
    public static /* synthetic */ void isNewPublish$annotations() {
    }

    public final Boolean component1() {
        return this.isNewPublish;
    }

    public final Boolean component2() {
        return this.publicRefImage;
    }

    public final String component3() {
        return this.caption;
    }

    public final CreationPublishExtraKmp copy(Boolean r2, Boolean r3, String r4) {
        return new CreationPublishExtraKmp(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationPublishExtraKmp) == true) goto L8;
        return false;
    L8:
        CreationPublishExtraKmp r6 = (CreationPublishExtraKmp) r5;
        if (Intrinsics.areEqual(this.isNewPublish, r6.isNewPublish) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.publicRefImage, r6.publicRefImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.caption, r6.caption) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.isNewPublish;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.publicRefImage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.caption;
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
        return "CreationPublishExtraKmp(isNewPublish=" + this.isNewPublish + ", publicRefImage=" + this.publicRefImage + ", caption=" + this.caption + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        Boolean r5 = this.isNewPublish;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r6 = this.publicRefImage;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.caption);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getCaption() {
        return this.caption;
    }

    public final Boolean getPublicRefImage() {
        return this.publicRefImage;
    }

    public final Boolean isNewPublish() {
        return this.isNewPublish;
    }

    public CreationPublishExtraKmp(Boolean r1, Boolean r2, String r3) {
        this.isNewPublish = r1;
        this.publicRefImage = r2;
        this.caption = r3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationPublishExtraKmp r4, muc.d r5, f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, i.a, r4.isNewPublish);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r5.encodeNullableSerializableElement(r6, 1, i.a, r4.publicRefImage);
    L21:
        if (r5.shouldEncodeElementDefault(r6, 2) == false) goto L24;
    L22:
        r0 = true;
    L26:
        if (r0 == false) goto L29;
        r5.encodeNullableSerializableElement(r6, 2, v2.a, r4.caption);
        return;
    L29:
        return;
    L24:
        if (r4.caption == null) goto L26;
    L15:
        if (r4.publicRefImage != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r4.isNewPublish != null) goto L4;
        r1 = false;
        goto L9
    }

    public CreationPublishExtraKmp(int r2, Boolean r3, Boolean r4, String r5, q2 r6) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.isNewPublish = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.publicRefImage = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.caption = null;
        return;
    L15:
        this.caption = r5;
        return;
    L11:
        this.publicRefImage = r4;
        goto L13
    L7:
        this.isNewPublish = r3;
        goto L9
    }

    public /* synthetic */ CreationPublishExtraKmp(Boolean r2, Boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
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
