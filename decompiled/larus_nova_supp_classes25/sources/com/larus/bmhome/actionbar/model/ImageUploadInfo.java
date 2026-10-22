package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J&\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006,"}, d2 = {"Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "width", "", "height", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidth$annotations", "()V", "getWidth", "()Ljava/lang/Long;", "setWidth", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHeight$annotations", "getHeight", "setHeight", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$instruction_core_api_release", "$serializer", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@Serializable
public final class ImageUploadInfo implements java.io.Serializable {
    public static final b Companion = null;
    private Long height;
    private Long width;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<ImageUploadInfo> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.g1 r1 = nuc.g1.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ImageUploadInfo", r0, 2);
            r1.j("width", true);
            r1.j("height", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            if (r12.decodeSequentially() == false) goto L5;
            nuc.g1 r1 = nuc.g1.a;
            Long r2 = (Long) r12.decodeNullableSerializableElement(r0, 0, r1, null);
            Long r3 = (Long) r12.decodeNullableSerializableElement(r0, 1, r1, null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new ImageUploadInfo(r4, r2, r3, null);
        L5:
            r3 = null;
            Long r5 = null;
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
            r5 = (Long) r12.decodeNullableSerializableElement(r0, 0, nuc.g1.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r3 = (Long) r12.decodeNullableSerializableElement(r0, 1, nuc.g1.a, r3);
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
            ImageUploadInfo r4 = (ImageUploadInfo) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            ImageUploadInfo.write$Self$instruction_core_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<ImageUploadInfo> serializer() {
            return a.a;
        }
    }

    public ImageUploadInfo() {
        Long r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ImageUploadInfo copy$default(ImageUploadInfo r0, Long r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        return r0.copy(r1, r2);
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final Long component1() {
        return this.width;
    }

    public final Long component2() {
        return this.height;
    }

    public final ImageUploadInfo copy(Long r2, Long r3) {
        return new ImageUploadInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageUploadInfo) == true) goto L8;
        return false;
    L8:
        ImageUploadInfo r6 = (ImageUploadInfo) r5;
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r0 = this.width;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.height;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageUploadInfo(width=" + this.width + ", height=" + this.height + ')';
    }

    static {
        Companion = new b();
    }

    public final Long getHeight() {
        return this.height;
    }

    public final Long getWidth() {
        return this.width;
    }

    public final void setHeight(Long r1) {
        this.height = r1;
    }

    public final void setWidth(Long r1) {
        this.width = r1;
    }

    public ImageUploadInfo(Long r1, Long r2) {
        this.width = r1;
        this.height = r2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$instruction_core_api_release(ImageUploadInfo r7, muc.d r8, luc.f r9) {
        boolean r0 = false;
        if (r8.shouldEncodeElementDefault(r9, 0) == false) goto L5;
    L4:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        r8.encodeNullableSerializableElement(r9, 0, nuc.g1.a, r7.width);
    L15:
        if (r8.shouldEncodeElementDefault(r9, 1) == false) goto L17;
    L16:
        r0 = true;
    L23:
        if (r0 == false) goto L26;
        r8.encodeNullableSerializableElement(r9, 1, nuc.g1.a, r7.height);
        return;
    L26:
        return;
    L17:
        Long r2 = r7.height;
        if (r2 == null) goto L16;
        if (r2.longValue() == 0) goto L23;
    L5:
        Long r3 = r7.width;
        if (r3 == null) goto L4;
        if (r3.longValue() != 0) goto L4;
        r1 = false;
        goto L12
    }

    public ImageUploadInfo(int r3, Long r4, Long r5, q2 r6) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = 0L;
    L7:
        this.width = r4;
        if ((r3 & 2) != 0) goto L10;
        this.height = 0L;
        return;
    L10:
        this.height = r5;
    }

    public /* synthetic */ ImageUploadInfo(Long r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = 0L;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = 0L;
    L8:
        this(r3, r4);
    }
}
