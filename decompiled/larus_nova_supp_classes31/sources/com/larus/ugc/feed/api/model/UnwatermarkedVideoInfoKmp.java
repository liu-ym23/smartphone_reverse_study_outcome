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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\nJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nJ%\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, d2 = {"Lcom/larus/ugc/feed/api/model/UnwatermarkedVideoInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "videoInfo", "Lcom/larus/ugc/feed/api/model/VideoInfoKmp;", "coverImageUrl", "", "<init>", "(Lcom/larus/ugc/feed/api/model/VideoInfoKmp;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/VideoInfoKmp;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoInfo$annotations", "()V", "getVideoInfo", "()Lcom/larus/ugc/feed/api/model/VideoInfoKmp;", "getCoverImageUrl$annotations", "getCoverImageUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UnwatermarkedVideoInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UnwatermarkedVideoInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final String coverImageUrl;
    private final VideoInfoKmp videoInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UnwatermarkedVideoInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(VideoInfoKmp.a.a), kuc.a.d(v2.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UnwatermarkedVideoInfoKmp", r0, 2);
            r1.j("video_info", true);
            r1.j("cover_image_url", true);
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
            VideoInfoKmp r1 = (VideoInfoKmp) r12.decodeNullableSerializableElement(r0, 0, VideoInfoKmp.a.a, null);
            String r2 = (String) r12.decodeNullableSerializableElement(r0, 1, v2.a, null);
            int r3 = 3;
        L17:
            r12.endStructure(r0);
            return new UnwatermarkedVideoInfoKmp(r3, r1, r2, null);
        L5:
            r1 = null;
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
            r1 = (VideoInfoKmp) r12.decodeNullableSerializableElement(r0, 0, VideoInfoKmp.a.a, r1);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r5 = (String) r12.decodeNullableSerializableElement(r0, 1, v2.a, r5);
            r6 = r6 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r2 = r5;
            r3 = r6;
            goto L17
        }

        public final void serialize(muc.f r2, Object r3) {
            UnwatermarkedVideoInfoKmp r4 = (UnwatermarkedVideoInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UnwatermarkedVideoInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UnwatermarkedVideoInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UnwatermarkedVideoInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UnwatermarkedVideoInfoKmp createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            if (r3.readInt() != 0) goto L5;
            VideoInfoKmp r1 = null;
        L7:
            return new UnwatermarkedVideoInfoKmp(r1, r3.readString());
        L5:
            r1 = VideoInfoKmp.CREATOR.createFromParcel(r3);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UnwatermarkedVideoInfoKmp[] newArray(int r1) {
            return new UnwatermarkedVideoInfoKmp[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnwatermarkedVideoInfoKmp() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UnwatermarkedVideoInfoKmp copy$default(UnwatermarkedVideoInfoKmp r0, VideoInfoKmp r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.videoInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.coverImageUrl;
    L9:
        return r0.copy(r1, r2);
    }

    @SerialName("cover_image_url")
    public static /* synthetic */ void getCoverImageUrl$annotations() {
    }

    @SerialName("video_info")
    public static /* synthetic */ void getVideoInfo$annotations() {
    }

    public final VideoInfoKmp component1() {
        return this.videoInfo;
    }

    public final String component2() {
        return this.coverImageUrl;
    }

    public final UnwatermarkedVideoInfoKmp copy(VideoInfoKmp r2, String r3) {
        return new UnwatermarkedVideoInfoKmp(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UnwatermarkedVideoInfoKmp) == true) goto L8;
        return false;
    L8:
        UnwatermarkedVideoInfoKmp r6 = (UnwatermarkedVideoInfoKmp) r5;
        if (Intrinsics.areEqual(this.videoInfo, r6.videoInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coverImageUrl, r6.coverImageUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        VideoInfoKmp r0 = this.videoInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.coverImageUrl;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UnwatermarkedVideoInfoKmp(videoInfo=" + this.videoInfo + ", coverImageUrl=" + this.coverImageUrl + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        VideoInfoKmp r0 = this.videoInfo;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.coverImageUrl);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public final VideoInfoKmp getVideoInfo() {
        return this.videoInfo;
    }

    public UnwatermarkedVideoInfoKmp(VideoInfoKmp r1, String r2) {
        this.videoInfo = r1;
        this.coverImageUrl = r2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UnwatermarkedVideoInfoKmp r4, muc.d r5, f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, VideoInfoKmp.a.a, r4.videoInfo);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        r0 = true;
    L17:
        if (r0 == false) goto L20;
        r5.encodeNullableSerializableElement(r6, 1, v2.a, r4.coverImageUrl);
        return;
    L20:
        return;
    L15:
        if (r4.coverImageUrl == null) goto L17;
    L6:
        if (r4.videoInfo != null) goto L4;
        r1 = false;
        goto L9
    }

    public UnwatermarkedVideoInfoKmp(int r2, VideoInfoKmp r3, String r4, q2 r5) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.videoInfo = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.coverImageUrl = null;
        return;
    L11:
        this.coverImageUrl = r4;
        return;
    L7:
        this.videoInfo = r3;
        goto L9
    }

    public /* synthetic */ UnwatermarkedVideoInfoKmp(VideoInfoKmp r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
