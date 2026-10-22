package com.larus.platform.kmp.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J)\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010!\u001a\u00020\u000bJ\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000bJ%\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u00066"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "url", "", "width", "", "height", "<init>", "(Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getWidth$annotations", "getWidth", "()J", "setWidth", "(J)V", "getHeight$annotations", "getHeight", "setHeight", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TemplateInfo$TemplateImage implements Parcelable {
    public static final Parcelable.Creator<TemplateInfo$TemplateImage> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final long b;
    public final long c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TemplateInfo$TemplateImage> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            g1 r1 = g1.a;
            return new d[]{kuc.a.d(v2.a), r1, r1};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.kmp.chat.TemplateInfo.TemplateImage", r0, 3);
            r1.j("url", true);
            r1.j("width", true);
            r1.j("height", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            String r6 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, null);
            String r14 = r2;
            long r15 = r0.decodeLongElement(r1, 1);
            long r17 = r0.decodeLongElement(r1, 2);
            int r13 = 7;
        L19:
            r0.endStructure(r1);
            return new TemplateInfo$TemplateImage(r13, r14, r15, r17);
        L5:
            long r7 = 0;
            long r9 = 0;
            int r3 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L18;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r6 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r6);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r7 = r0.decodeLongElement(r1, 1);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L14;
            r9 = r0.decodeLongElement(r1, 2);
            r3 = r3 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r12);
        L18:
            r13 = r3;
            r14 = r6;
            r15 = r7;
            r17 = r9;
            goto L19
        }

        public final void serialize(muc.f r10, Object r11) {
            TemplateInfo$TemplateImage r12 = (TemplateInfo$TemplateImage) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            b r1 = TemplateInfo$TemplateImage.Companion;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeNullableSerializableElement(r0, 0, v2.a, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeLongElement(r0, 1, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r13.encodeLongElement(r0, 2, r12.c);
        L28:
            r13.endStructure(r0);
            return;
        L24:
            if (r12.c == 0) goto L26;
        L15:
            if (r12.b != 0) goto L16;
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

        public final d<TemplateInfo$TemplateImage> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TemplateInfo$TemplateImage> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateImage createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new TemplateInfo$TemplateImage(r8.readString(), r8.readLong(), r8.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateImage[] newArray(int r1) {
            return new TemplateInfo$TemplateImage[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TemplateInfo$TemplateImage) == true) goto L8;
        return false;
    L8:
        TemplateInfo$TemplateImage r9 = (TemplateInfo$TemplateImage) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.b;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.c;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateImage(url=" + this.a + ", width=" + this.b + ", height=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeLong(this.b);
        r3.writeLong(this.c);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public TemplateInfo$TemplateImage() {
        this("", 0, 0);
    }

    public TemplateInfo$TemplateImage(String r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public TemplateInfo$TemplateImage(int r3, String r4, long r5, long r7) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = "";
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = 0;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = 0;
        return;
    L14:
        this.c = r7;
        return;
    L10:
        this.b = r5;
        goto L12
    }
}
