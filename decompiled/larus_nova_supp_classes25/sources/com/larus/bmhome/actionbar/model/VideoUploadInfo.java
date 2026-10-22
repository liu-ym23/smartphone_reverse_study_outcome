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
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ2\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\fHÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00066"}, d2 = {"Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "vid", "", "cover", "Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;", "duration", "", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "()V", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "getCover$annotations", "getCover", "()Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;", "setCover", "(Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;)V", "getDuration$annotations", "getDuration", "()Ljava/lang/Double;", "setDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;Ljava/lang/Double;)Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$instruction_core_api_release", "$serializer", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@Serializable
public final class VideoUploadInfo implements java.io.Serializable {
    public static final b Companion = null;
    private f2 cover;
    private Double duration;
    private String vid;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<VideoUploadInfo> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d(f2.a.a), kuc.a.d(nuc.b0.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.VideoUploadInfo", r0, 3);
            r1.j("vid", true);
            r1.j("cover", true);
            r1.j("duration", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r17) {
            Intrinsics.checkNotNullParameter(r17, "decoder");
            g2 r1 = b;
            muc.c r0 = r17.beginStructure(r1);
            String r6 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, null);
            f2 r4 = (f2) r0.decodeNullableSerializableElement(r1, 1, f2.a.a, null);
            String r12 = r2;
            Double r14 = (Double) r0.decodeNullableSerializableElement(r1, 2, nuc.b0.a, null);
            f2 r13 = r4;
            int r11 = 7;
        L19:
            r0.endStructure(r1);
            return new VideoUploadInfo(r11, r12, r13, r14, null);
        L5:
            f2 r7 = null;
            Double r8 = null;
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
            r7 = (f2) r0.decodeNullableSerializableElement(r1, 1, f2.a.a, r7);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r8 = (Double) r0.decodeNullableSerializableElement(r1, 2, nuc.b0.a, r8);
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
            VideoUploadInfo r4 = (VideoUploadInfo) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            VideoUploadInfo.write$Self$instruction_core_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<VideoUploadInfo> serializer() {
            return a.a;
        }
    }

    public VideoUploadInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoUploadInfo copy$default(VideoUploadInfo r0, String r1, f2 r2, Double r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.vid;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.cover;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.duration;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    public final String component1() {
        return this.vid;
    }

    public final f2 component2() {
        return this.cover;
    }

    public final Double component3() {
        return this.duration;
    }

    public final VideoUploadInfo copy(String r2, f2 r3, Double r4) {
        return new VideoUploadInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoUploadInfo) == true) goto L8;
        return false;
    L8:
        VideoUploadInfo r6 = (VideoUploadInfo) r5;
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cover, r6.cover) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.vid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        f2 r4 = this.cover;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.duration;
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
        return "VideoUploadInfo(vid=" + this.vid + ", cover=" + this.cover + ", duration=" + this.duration + ')';
    }

    static {
        Companion = new b();
    }

    public final f2 getCover() {
        return this.cover;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final String getVid() {
        return this.vid;
    }

    public final void setCover(f2 r1) {
        this.cover = r1;
    }

    public final void setDuration(Double r1) {
        this.duration = r1;
    }

    public final void setVid(String r1) {
        this.vid = r1;
    }

    public VideoUploadInfo(String r1, f2 r2, Double r3) {
        this.vid = r1;
        this.cover = r2;
        this.duration = r3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$instruction_core_api_release(VideoUploadInfo r4, muc.d r5, luc.f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, v2.a, r4.vid);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r5.encodeNullableSerializableElement(r6, 1, f2.a.a, r4.cover);
    L21:
        if (r5.shouldEncodeElementDefault(r6, 2) == false) goto L24;
    L22:
        r0 = true;
    L26:
        if (r0 == false) goto L29;
        r5.encodeNullableSerializableElement(r6, 2, nuc.b0.a, r4.duration);
        return;
    L29:
        return;
    L24:
        if (r4.duration == null) goto L26;
    L15:
        if (r4.cover != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r4.vid != null) goto L4;
        r1 = false;
        goto L9
    }

    public VideoUploadInfo(int r2, String r3, f2 r4, Double r5, q2 r6) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.vid = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.cover = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.duration = null;
        return;
    L15:
        this.duration = r5;
        return;
    L11:
        this.cover = r4;
        goto L13
    L7:
        this.vid = r3;
        goto L9
    }

    public /* synthetic */ VideoUploadInfo(String r2, f2 r3, Double r4, int r5, DefaultConstructorMarker r6) {
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
