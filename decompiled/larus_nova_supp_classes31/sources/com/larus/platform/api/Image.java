package com.larus.platform.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00060\u0001j\u0002`\u0002:\u0002>?B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003JA\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010+\u001a\u00020\rJ\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\rHÖ\u0001J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\rJ%\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006@"}, d2 = {"Lcom/larus/platform/api/Image;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "url", "", "urlV2", "width", "", "height", "uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUrlV2$annotations", "getUrlV2", "setUrlV2", "getWidth$annotations", "getWidth", "()J", "setWidth", "(J)V", "getHeight$annotations", "getHeight", "setHeight", "getUri$annotations", "getUri", "setUri", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class Image implements Parcelable {
    public static final Parcelable.Creator<Image> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<Image> {
        public static final a a = null;
        public static final nuc.g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.v2 r1 = nuc.v2.a;
            g1 r2 = g1.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), r2, r2, kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            nuc.g2 r1 = new nuc.g2("com.larus.platform.api.Image", r0, 5);
            r1.j("url", true);
            r1.j("url_v2", true);
            r1.j("width", true);
            r1.j("height", true);
            r1.j("uri", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.a;
        }

        public final Object deserialize(muc.e r26) {
            Intrinsics.checkNotNullParameter(r26, "decoder");
            nuc.g2 r1 = b;
            muc.c r0 = r26.beginStructure(r1);
            int r3 = 2;
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.v2 r2 = nuc.v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            long r9 = r0.decodeLongElement(r1, 2);
            long r4 = r0.decodeLongElement(r1, 3);
            String r24 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            long r22 = r4;
            String r19 = r5;
            String r18 = r7;
            long r20 = r9;
            int r17 = 31;
        L26:
            r0.endStructure(r1);
            return new Image(r17, r18, r19, r20, r22, r24);
        L5:
            long r10 = 0;
            String r11 = null;
            String r12 = null;
            long r13 = 0;
            int r6 = 0;
            boolean r15 = true;
        L6:
            if (r15 == false) goto L25;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r3 = 2;
            r15 = false;
            goto L6
        L9:
            if (r14 == 0) goto L22;
            if (r14 != 1) goto L12;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 1, nuc.v2.a, r11);
            r6 = r6 | 2;
        L23:
            r3 = 2;
            goto L6
        L12:
            if (r14 == r3) goto L19;
            if (r14 == 3) goto L18;
            if (r14 != 4) goto L17;
            r12 = (String) r0.decodeNullableSerializableElement(r1, 4, nuc.v2.a, r12);
            r6 = r6 | 16;
            goto L23
        L17:
            throw new UnknownFieldException(r14);
        L18:
            r10 = r0.decodeLongElement(r1, 3);
            r6 = r6 | 8;
            goto L23
        L19:
            r13 = r0.decodeLongElement(r1, r3);
            r6 = r6 | 4;
            goto L23
        L22:
            r6 = r6 | 1;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 0, nuc.v2.a, r8);
            goto L23
        L25:
            r17 = r6;
            r18 = r8;
            r22 = r10;
            r19 = r11;
            r24 = r12;
            r20 = r13;
            goto L26
        }

        public final void serialize(muc.f r10, Object r11) {
            Image r12 = (Image) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            nuc.g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            b r1 = Image.Companion;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeNullableSerializableElement(r0, 0, nuc.v2.a, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeNullableSerializableElement(r0, 1, nuc.v2.a, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeLongElement(r0, 2, r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r13.encodeLongElement(r0, 3, r12.d);
        L39:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            r2 = true;
        L44:
            if (r2 == false) goto L46;
            r13.encodeNullableSerializableElement(r0, 4, nuc.v2.a, r12.e);
        L46:
            r13.endStructure(r0);
            return;
        L42:
            if (r12.e == null) goto L44;
        L33:
            if (r12.d != 0) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r12.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r12.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r12.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<Image> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<Image> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final Image createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Image(r10.readString(), r10.readString(), r10.readLong(), r10.readLong(), r10.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Image[] newArray(int r1) {
            return new Image[r1];
        }
    }

    public Image() {
        this(null, null, 0, 0, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Image) == true) goto L8;
        return false;
    L8:
        Image r9 = (Image) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.d;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r11 = this.e;
        if (r11 == null) goto L15;
        r1 = r11.hashCode();
    L15:
        return r10 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Image(url=" + this.a + ", urlV2=" + this.b + ", width=" + this.c + ", height=" + this.d + ", uri=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeLong(this.c);
        r3.writeLong(this.d);
        r3.writeString(this.e);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ Image(String r11, String r12, long r13, long r15, int r17) {
        if ((r17 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r17 & 4) == 0) goto L13;
        long r5 = 0;
    L15:
        if ((r17 & 8) == 0) goto L17;
        long r7 = 0;
    L18:
        this(r3, r4, r5, r7, null);
        return;
    L17:
        r7 = r15;
        goto L18
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public static Image a(Image r11, long r12, long r14, String r16, int r17) {
        String r2 = null;
        if ((r17 & 1) == 0) goto L5;
        String r4 = r11.a;
    L7:
        if ((r17 & 2) == 0) goto L9;
        r2 = r11.b;
    L9:
        String r5 = r2;
        if ((r17 & 4) == 0) goto L12;
        long r6 = r11.c;
    L14:
        if ((r17 & 8) == 0) goto L16;
        long r8 = r11.d;
    L18:
        if ((r17 & 16) == 0) goto L20;
        String r10 = r11.e;
    L22:
        return new Image(r4, r5, r6, r8, r10);
    L20:
        r10 = r16;
        goto L22
    L16:
        r8 = r14;
        goto L18
    L12:
        r6 = r12;
        goto L14
    L5:
        r4 = null;
        goto L7
    }

    public Image(String r1, String r2, long r3, long r5, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
    }

    public Image(int r5, String r6, String r7, long r8, long r10, String r12) {
        if ((r5 & 0) == 0) goto L5;
        b2.b(r5, 0, a.b);
        throw null;
    L5:
        if ((r5 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r5 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r5 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r5 & 8) != 0) goto L19;
        this.d = 0;
    L21:
        if ((r5 & 16) != 0) goto L23;
        this.e = null;
        return;
    L23:
        this.e = r12;
        return;
    L19:
        this.d = r10;
        goto L21
    L15:
        this.c = r8;
        goto L17
    L11:
        this.b = r7;
        goto L13
    L7:
        this.a = r6;
        goto L9
    }
}
