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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J&\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\nJ\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nJ%\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0005\u0010\u0013¨\u0006-"}, d2 = {"Lcom/larus/ugc/feed/api/model/VideoContentFromChatKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "taskId", "", "isExtendVideo", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTaskId$annotations", "()V", "getTaskId", "()Ljava/lang/String;", "isExtendVideo$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/ugc/feed/api/model/VideoContentFromChatKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class VideoContentFromChatKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<VideoContentFromChatKmp> CREATOR = null;
    public static final b Companion = null;
    private final Boolean isExtendVideo;
    private final String taskId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoContentFromChatKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(v2.a), kuc.a.d(i.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.VideoContentFromChatKmp", r0, 2);
            r1.j("task_id", true);
            r1.j("is_extend_video", true);
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
            String r1 = (String) r12.decodeNullableSerializableElement(r0, 0, v2.a, null);
            Boolean r2 = (Boolean) r12.decodeNullableSerializableElement(r0, 1, i.a, null);
            int r3 = 3;
        L17:
            r12.endStructure(r0);
            return new VideoContentFromChatKmp(r3, r1, r2, null);
        L5:
            r1 = null;
            Boolean r5 = null;
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
            r1 = (String) r12.decodeNullableSerializableElement(r0, 0, v2.a, r1);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r5 = (Boolean) r12.decodeNullableSerializableElement(r0, 1, i.a, r5);
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
            VideoContentFromChatKmp r4 = (VideoContentFromChatKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            VideoContentFromChatKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<VideoContentFromChatKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<VideoContentFromChatKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoContentFromChatKmp createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            String r1 = r4.readString();
            if (r4.readInt() != 0) goto L6;
            Boolean r5 = null;
        L11:
            return new VideoContentFromChatKmp(r1, r5);
        L6:
            if (r4.readInt() == 0) goto L8;
            boolean r6 = true;
        L9:
            r5 = Boolean.valueOf(r6);
            goto L11
        L8:
            r6 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final VideoContentFromChatKmp[] newArray(int r1) {
            return new VideoContentFromChatKmp[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoContentFromChatKmp() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VideoContentFromChatKmp copy$default(VideoContentFromChatKmp r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.taskId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isExtendVideo;
    L9:
        return r0.copy(r1, r2);
    }

    @SerialName("task_id")
    public static /* synthetic */ void getTaskId$annotations() {
    }

    @SerialName("is_extend_video")
    public static /* synthetic */ void isExtendVideo$annotations() {
    }

    public final String component1() {
        return this.taskId;
    }

    public final Boolean component2() {
        return this.isExtendVideo;
    }

    public final VideoContentFromChatKmp copy(String r2, Boolean r3) {
        return new VideoContentFromChatKmp(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoContentFromChatKmp) == true) goto L8;
        return false;
    L8:
        VideoContentFromChatKmp r6 = (VideoContentFromChatKmp) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isExtendVideo, r6.isExtendVideo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isExtendVideo;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "VideoContentFromChatKmp(taskId=" + this.taskId + ", isExtendVideo=" + this.isExtendVideo + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.taskId);
        Boolean r4 = this.isExtendVideo;
        if (r4 != null) goto L6;
        ?? r5 = 0;
    L5:
        r2.writeInt(r5);
        return;
    L6:
        r2.writeInt(1);
        r5 = r4.booleanValue();
        goto L5
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Boolean isExtendVideo() {
        return this.isExtendVideo;
    }

    public VideoContentFromChatKmp(String r1, Boolean r2) {
        this.taskId = r1;
        this.isExtendVideo = r2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(VideoContentFromChatKmp r4, muc.d r5, f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, v2.a, r4.taskId);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        r0 = true;
    L17:
        if (r0 == false) goto L20;
        r5.encodeNullableSerializableElement(r6, 1, i.a, r4.isExtendVideo);
        return;
    L20:
        return;
    L15:
        if (r4.isExtendVideo == null) goto L17;
    L6:
        if (r4.taskId != null) goto L4;
        r1 = false;
        goto L9
    }

    public VideoContentFromChatKmp(int r2, String r3, Boolean r4, q2 r5) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.taskId = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.isExtendVideo = null;
        return;
    L11:
        this.isExtendVideo = r4;
        return;
    L7:
        this.taskId = r3;
        goto L9
    }

    public /* synthetic */ VideoContentFromChatKmp(String r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
