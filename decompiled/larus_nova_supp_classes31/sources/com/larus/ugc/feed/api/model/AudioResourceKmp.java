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
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003JJ\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\rJ\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\rHÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rJ%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014¨\u0006;"}, d2 = {"Lcom/larus/ugc/feed/api/model/AudioResourceKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "vid", "", "videoModel", "audioType", "duration", "", "fileName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "()V", "getVid", "()Ljava/lang/String;", "getVideoModel$annotations", "getVideoModel", "getAudioType$annotations", "getAudioType", "getDuration$annotations", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFileName$annotations", "getFileName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/larus/ugc/feed/api/model/AudioResourceKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class AudioResourceKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<AudioResourceKmp> CREATOR = null;
    public static final b Companion = null;
    private final String audioType;
    private final Double duration;
    private final String fileName;
    private final String vid;
    private final String videoModel;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AudioResourceKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(b0.a), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.AudioResourceKmp", r0, 5);
            r1.j("vid", true);
            r1.j("video_model", true);
            r1.j("audio_type", true);
            r1.j("duration", true);
            r1.j("file_name", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Double r7 = (Double) r0.decodeNullableSerializableElement(r1, 3, b0.a, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r18 = r3;
            String r16 = r5;
            String r17 = r6;
            Double r19 = r7;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new AudioResourceKmp(r15, r16, r17, r18, r19, r20, null);
        L5:
            String r9 = null;
            String r10 = null;
            Double r11 = null;
            String r12 = null;
            int r4 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L22;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L13;
            r11 = (Double) r0.decodeNullableSerializableElement(r1, 3, b0.a, r11);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r12 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r12);
            r4 = r4 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r14);
        L22:
            r15 = r4;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r2, Object r3) {
            AudioResourceKmp r4 = (AudioResourceKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            AudioResourceKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AudioResourceKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<AudioResourceKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final AudioResourceKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r2 = r8.readString();
            String r3 = r8.readString();
            String r4 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            Double r1 = null;
        L7:
            return new AudioResourceKmp(r2, r3, r4, r1, r8.readString());
        L5:
            r1 = Double.valueOf(r8.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AudioResourceKmp[] newArray(int r1) {
            return new AudioResourceKmp[r1];
        }
    }

    public AudioResourceKmp() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AudioResourceKmp copy$default(AudioResourceKmp r3, String r4, String r5, String r6, Double r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.vid;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.videoModel;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.audioType;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.duration;
    L14:
        Double r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.fileName;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @SerialName("audio_type")
    public static /* synthetic */ void getAudioType$annotations() {
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("file_name")
    public static /* synthetic */ void getFileName$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    @SerialName("video_model")
    public static /* synthetic */ void getVideoModel$annotations() {
    }

    public final String component1() {
        return this.vid;
    }

    public final String component2() {
        return this.videoModel;
    }

    public final String component3() {
        return this.audioType;
    }

    public final Double component4() {
        return this.duration;
    }

    public final String component5() {
        return this.fileName;
    }

    public final AudioResourceKmp copy(String r8, String r9, String r10, Double r11, String r12) {
        return new AudioResourceKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioResourceKmp) == true) goto L8;
        return false;
    L8:
        AudioResourceKmp r6 = (AudioResourceKmp) r5;
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoModel, r6.videoModel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioType, r6.audioType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.vid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.videoModel;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.audioType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.duration;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.fileName;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AudioResourceKmp(vid=" + this.vid + ", videoModel=" + this.videoModel + ", audioType=" + this.audioType + ", duration=" + this.duration + ", fileName=" + this.fileName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.vid);
        r3.writeString(this.videoModel);
        r3.writeString(this.audioType);
        Double r5 = this.duration;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.fileName);
        return;
    L5:
        r3.writeInt(1);
        r3.writeDouble(r5.doubleValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getAudioType() {
        return this.audioType;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(AudioResourceKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.vid);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.videoModel);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.audioType);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, b0.a, r5.duration);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        r0 = true;
    L44:
        if (r0 == false) goto L47;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.fileName);
        return;
    L47:
        return;
    L42:
        if (r5.fileName == null) goto L44;
    L33:
        if (r5.duration != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.audioType != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.videoModel != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.vid != null) goto L4;
        r1 = false;
        goto L9
    }

    public AudioResourceKmp(String r1, String r2, String r3, Double r4, String r5) {
        this.vid = r1;
        this.videoModel = r2;
        this.audioType = r3;
        this.duration = r4;
        this.fileName = r5;
    }

    public AudioResourceKmp(int r2, String r3, String r4, String r5, Double r6, String r7, q2 r8) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.vid = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.videoModel = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.audioType = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.duration = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.fileName = null;
        return;
    L23:
        this.fileName = r7;
        return;
    L19:
        this.duration = r6;
        goto L21
    L15:
        this.audioType = r5;
        goto L17
    L11:
        this.videoModel = r4;
        goto L13
    L7:
        this.vid = r3;
        goto L9
    }

    public /* synthetic */ AudioResourceKmp(String r5, String r6, String r7, Double r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Double r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
