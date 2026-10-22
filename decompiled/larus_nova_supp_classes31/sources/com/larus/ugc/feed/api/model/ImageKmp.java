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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J5\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0006\u0010&\u001a\u00020\fJ\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\fHÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\fJ%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006;"}, d2 = {"Lcom/larus/ugc/feed/api/model/ImageKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "url", "", "urlV2", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUrlV2$annotations", "getUrlV2", "setUrlV2", "getWidth$annotations", "getWidth", "()J", "setWidth", "(J)V", "getHeight$annotations", "getHeight", "setHeight", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ImageKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ImageKmp> CREATOR = null;
    public static final b Companion = null;
    private long height;
    private String url;
    private String urlV2;
    private long width;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ImageKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            g1 r2 = g1.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), r2, r2};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.ImageKmp", r0, 4);
            r1.j("url", true);
            r1.j("url_v2", true);
            r1.j("width", true);
            r1.j("height", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            String r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            long r8 = r0.decodeLongElement(r1, 2);
            String r17 = r3;
            String r16 = r4;
            long r20 = r0.decodeLongElement(r1, 3);
            long r18 = r8;
            int r15 = 15;
        L21:
            r0.endStructure(r1);
            return new ImageKmp(r15, r16, r17, r18, r20, null);
        L5:
            long r9 = 0;
            String r12 = null;
            long r10 = 0;
            int r5 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L20;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r7 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r7);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r12 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r12);
            r5 = r5 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r10 = r0.decodeLongElement(r1, 2);
            r5 = r5 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L15;
            r9 = r0.decodeLongElement(r1, 3);
            r5 = r5 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r14);
        L20:
            r15 = r5;
            r16 = r7;
            r20 = r9;
            r18 = r10;
            r17 = r12;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            ImageKmp r4 = (ImageKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            ImageKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ImageKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ImageKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageKmp createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            return new ImageKmp(r9.readString(), r9.readString(), r9.readLong(), r9.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final ImageKmp[] newArray(int r1) {
            return new ImageKmp[r1];
        }
    }

    public ImageKmp() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ ImageKmp copy$default(ImageKmp r4, String r5, String r6, long r7, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.url;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.urlV2;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.width;
    L11:
        long r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.height;
    L14:
        String r8 = r5;
        return r4.copy(r8, r13, r0, r9);
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("url_v2")
    public static /* synthetic */ void getUrlV2$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.urlV2;
    }

    public final long component3() {
        return this.width;
    }

    public final long component4() {
        return this.height;
    }

    public final ImageKmp copy(String r9, String r10, long r11, long r13) {
        return new ImageKmp(r9, r10, r11, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ImageKmp) == true) goto L8;
        return false;
    L8:
        ImageKmp r9 = (ImageKmp) r8;
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlV2, r9.urlV2) == true) goto L15;
        return false;
    L15:
        if (this.width == r9.width) goto L18;
        return false;
    L18:
        if (this.height == r9.height) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.urlV2;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        long r6 = this.width;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.height;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageKmp(url=" + this.url + ", urlV2=" + this.urlV2 + ", width=" + this.width + ", height=" + this.height + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.url);
        r3.writeString(this.urlV2);
        r3.writeLong(this.width);
        r3.writeLong(this.height);
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlV2() {
        return this.urlV2;
    }

    public final long getWidth() {
        return this.width;
    }

    public final void setHeight(long r1) {
        this.height = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setUrlV2(String r1) {
        this.urlV2 = r1;
    }

    public final void setWidth(long r1) {
        this.width = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(ImageKmp r8, muc.d r9, f r10) {
        boolean r0 = false;
        if (r9.shouldEncodeElementDefault(r10, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r9.encodeNullableSerializableElement(r10, 0, v2.a, r8.url);
    L12:
        if (r9.shouldEncodeElementDefault(r10, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r9.encodeNullableSerializableElement(r10, 1, v2.a, r8.urlV2);
    L21:
        if (r9.shouldEncodeElementDefault(r10, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r9.encodeLongElement(r10, 2, r8.width);
    L30:
        if (r9.shouldEncodeElementDefault(r10, 3) == false) goto L33;
    L31:
        r0 = true;
    L35:
        if (r0 == false) goto L38;
        r9.encodeLongElement(r10, 3, r8.height);
        return;
    L38:
        return;
    L33:
        if (r8.height == 0) goto L35;
    L24:
        if (r8.width != 0) goto L22;
        r3 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r8.urlV2, "") == false) goto L13;
        r2 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r8.url, "") == false) goto L4;
        r1 = false;
        goto L9
    }

    public ImageKmp(String r1, String r2, long r3, long r5) {
        this.url = r1;
        this.urlV2 = r2;
        this.width = r3;
        this.height = r5;
    }

    public ImageKmp(int r3, String r4, String r5, long r6, long r8, q2 r10) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.url = "";
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.urlV2 = "";
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.width = 0;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.height = 0;
        return;
    L19:
        this.height = r8;
        return;
    L15:
        this.width = r6;
        goto L17
    L11:
        this.urlV2 = r5;
        goto L13
    L7:
        this.url = r4;
        goto L9
    }

    public /* synthetic */ ImageKmp(String r6, String r7, long r8, long r10, int r12, DefaultConstructorMarker r13) {
        String r0 = "";
        if ((r12 & 1) == 0) goto L5;
        String r14 = "";
    L7:
        if ((r12 & 2) != 0) goto L11;
        r0 = r7;
    L11:
        if ((r12 & 4) == 0) goto L13;
        long r3 = 0;
    L15:
        if ((r12 & 8) == 0) goto L17;
        long r11 = 0;
    L18:
        this(r14, r0, r3, r11);
        return;
    L17:
        r11 = r10;
        goto L18
    L13:
        r3 = r8;
        goto L15
    L5:
        r14 = r6;
        goto L7
    }
}
