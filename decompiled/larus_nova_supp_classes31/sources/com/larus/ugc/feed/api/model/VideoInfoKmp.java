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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003JV\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u000eJ\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u000eHÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000eJ%\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015¨\u0006?"}, d2 = {"Lcom/larus/ugc/feed/api/model/VideoInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "vid", "", "downloadUrl", "downloadFilehash", "duration", "", "videoType", "videoModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "()V", "getVid", "()Ljava/lang/String;", "getDownloadUrl$annotations", "getDownloadUrl", "getDownloadFilehash$annotations", "getDownloadFilehash", "getDuration$annotations", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoType$annotations", "getVideoType", "getVideoModel$annotations", "getVideoModel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/ugc/feed/api/model/VideoInfoKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class VideoInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<VideoInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final String downloadFilehash;
    private final String downloadUrl;
    private final Double duration;
    private final String vid;
    private final String videoModel;
    private final String videoType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(b0.a), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.VideoInfoKmp", r0, 6);
            r1.j("vid", true);
            r1.j("download_url", true);
            r1.j("download_filehash", true);
            r1.j("duration", true);
            r1.j("video_type", true);
            r1.j("video_model", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            int r3 = 2;
            String r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Double r8 = (Double) r0.decodeNullableSerializableElement(r1, 3, b0.a, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r12 = r4;
            String r14 = r5;
            String r11 = r6;
            String r10 = r7;
            Double r13 = r8;
            int r16 = 63;
        L21:
            r0.endStructure(r1);
            return new VideoInfoKmp(r16, r10, r11, r12, r13, r14, r15, null);
        L5:
            r10 = null;
            Double r17 = null;
            r12 = null;
            String r18 = null;
            r14 = null;
            int r20 = 0;
            boolean r110 = true;
        L6:
            if (r110 == false) goto L20;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L19:
            r3 = 2;
            r110 = false;
            goto L6
        L11:
            r9 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r9);
            r20 = r20 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r14);
            r20 = r20 | 16;
            goto L18
        L13:
            r17 = (Double) r0.decodeNullableSerializableElement(r1, 3, b0.a, r17);
            r20 = r20 | 8;
            goto L18
        L14:
            r12 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r12);
            r20 = r20 | 4;
            goto L18
        L15:
            r18 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r18);
            r20 = r20 | 2;
            goto L18
        L17:
            r20 = r20 | 1;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r10);
            goto L18
        L20:
            r15 = r9;
            r16 = r20;
            String r111 = r18;
            r13 = r17;
            r11 = r111;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            VideoInfoKmp r4 = (VideoInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            VideoInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<VideoInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<VideoInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoInfoKmp createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r2 = r9.readString();
            String r3 = r9.readString();
            String r4 = r9.readString();
            if (r9.readInt() != 0) goto L5;
            Double r1 = null;
        L7:
            return new VideoInfoKmp(r2, r3, r4, r1, r9.readString(), r9.readString());
        L5:
            r1 = Double.valueOf(r9.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final VideoInfoKmp[] newArray(int r1) {
            return new VideoInfoKmp[r1];
        }
    }

    public VideoInfoKmp() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ VideoInfoKmp copy$default(VideoInfoKmp r4, String r5, String r6, String r7, Double r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.vid;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.downloadUrl;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.downloadFilehash;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.duration;
    L14:
        Double r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.videoType;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.videoModel;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    @SerialName("download_filehash")
    public static /* synthetic */ void getDownloadFilehash$annotations() {
    }

    @SerialName("download_url")
    public static /* synthetic */ void getDownloadUrl$annotations() {
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    @SerialName("video_model")
    public static /* synthetic */ void getVideoModel$annotations() {
    }

    @SerialName("video_type")
    public static /* synthetic */ void getVideoType$annotations() {
    }

    public final String component1() {
        return this.vid;
    }

    public final String component2() {
        return this.downloadUrl;
    }

    public final String component3() {
        return this.downloadFilehash;
    }

    public final Double component4() {
        return this.duration;
    }

    public final String component5() {
        return this.videoType;
    }

    public final String component6() {
        return this.videoModel;
    }

    public final VideoInfoKmp copy(String r9, String r10, String r11, Double r12, String r13, String r14) {
        return new VideoInfoKmp(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoInfoKmp) == true) goto L8;
        return false;
    L8:
        VideoInfoKmp r6 = (VideoInfoKmp) r5;
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadUrl, r6.downloadUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.downloadFilehash, r6.downloadFilehash) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoType, r6.videoType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoModel, r6.videoModel) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.vid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.downloadUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.downloadFilehash;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.duration;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.videoType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.videoModel;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "VideoInfoKmp(vid=" + this.vid + ", downloadUrl=" + this.downloadUrl + ", downloadFilehash=" + this.downloadFilehash + ", duration=" + this.duration + ", videoType=" + this.videoType + ", videoModel=" + this.videoModel + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.vid);
        r3.writeString(this.downloadUrl);
        r3.writeString(this.downloadFilehash);
        Double r5 = this.duration;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.videoType);
        r3.writeString(this.videoModel);
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

    public final String getDownloadFilehash() {
        return this.downloadFilehash;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(VideoInfoKmp r5, muc.d r6, f r7) {
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
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.downloadUrl);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.downloadFilehash);
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
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.videoType);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        r0 = true;
    L53:
        if (r0 == false) goto L56;
        r6.encodeNullableSerializableElement(r7, 5, v2.a, r5.videoModel);
        return;
    L56:
        return;
    L51:
        if (r5.videoModel == null) goto L53;
    L42:
        if (r5.videoType != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.duration != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.downloadFilehash != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.downloadUrl != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.vid != null) goto L4;
        r1 = false;
        goto L9
    }

    public VideoInfoKmp(String r1, String r2, String r3, Double r4, String r5, String r6) {
        this.vid = r1;
        this.downloadUrl = r2;
        this.downloadFilehash = r3;
        this.duration = r4;
        this.videoType = r5;
        this.videoModel = r6;
    }

    public VideoInfoKmp(int r2, String r3, String r4, String r5, Double r6, String r7, String r8, q2 r9) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.vid = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.downloadUrl = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.downloadFilehash = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.duration = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.videoType = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.videoModel = null;
        return;
    L27:
        this.videoModel = r8;
        return;
    L23:
        this.videoType = r7;
        goto L25
    L19:
        this.duration = r6;
        goto L21
    L15:
        this.downloadFilehash = r5;
        goto L17
    L11:
        this.downloadUrl = r4;
        goto L13
    L7:
        this.vid = r3;
        goto L9
    }

    public /* synthetic */ VideoInfoKmp(String r6, String r7, String r8, Double r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Double r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
