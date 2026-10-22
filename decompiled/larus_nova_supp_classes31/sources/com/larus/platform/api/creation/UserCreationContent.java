package com.larus.platform.api.creation;

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
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00060\u0001j\u0002`\u0002:\u0002JKBO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BW\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003JQ\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0006\u00106\u001a\u00020\u0012J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0012HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001J\u0016\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0012J%\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010+R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010.¨\u0006L"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationContent;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "imageContent", "Lcom/larus/platform/api/creation/UserCreationImage;", "musicContent", "Lcom/larus/platform/api/creation/UserCreationMusic;", "userAvatarContent", "Lcom/larus/platform/api/creation/UserCreationUserAvatar;", "aiBeautifyUserContent", "Lcom/larus/platform/api/creation/AiBeautifyUserContent;", "videoUserContent", "Lcom/larus/platform/api/creation/VideoUserContent;", "videoContentFromChat", "Lcom/larus/platform/api/creation/VideoContentFromChat;", "<init>", "(Lcom/larus/platform/api/creation/UserCreationImage;Lcom/larus/platform/api/creation/UserCreationMusic;Lcom/larus/platform/api/creation/UserCreationUserAvatar;Lcom/larus/platform/api/creation/AiBeautifyUserContent;Lcom/larus/platform/api/creation/VideoUserContent;Lcom/larus/platform/api/creation/VideoContentFromChat;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/creation/UserCreationImage;Lcom/larus/platform/api/creation/UserCreationMusic;Lcom/larus/platform/api/creation/UserCreationUserAvatar;Lcom/larus/platform/api/creation/AiBeautifyUserContent;Lcom/larus/platform/api/creation/VideoUserContent;Lcom/larus/platform/api/creation/VideoContentFromChat;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageContent$annotations", "()V", "getImageContent", "()Lcom/larus/platform/api/creation/UserCreationImage;", "getMusicContent$annotations", "getMusicContent", "()Lcom/larus/platform/api/creation/UserCreationMusic;", "setMusicContent", "(Lcom/larus/platform/api/creation/UserCreationMusic;)V", "getUserAvatarContent$annotations", "getUserAvatarContent", "()Lcom/larus/platform/api/creation/UserCreationUserAvatar;", "setUserAvatarContent", "(Lcom/larus/platform/api/creation/UserCreationUserAvatar;)V", "getAiBeautifyUserContent$annotations", "getAiBeautifyUserContent", "()Lcom/larus/platform/api/creation/AiBeautifyUserContent;", "setAiBeautifyUserContent", "(Lcom/larus/platform/api/creation/AiBeautifyUserContent;)V", "getVideoUserContent$annotations", "getVideoUserContent", "()Lcom/larus/platform/api/creation/VideoUserContent;", "getVideoContentFromChat$annotations", "getVideoContentFromChat", "()Lcom/larus/platform/api/creation/VideoContentFromChat;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationContent implements Parcelable {
    public static final Parcelable.Creator<UserCreationContent> CREATOR = null;
    public static final b Companion = null;
    public final UserCreationImage a;
    public UserCreationMusic b;
    public final UserCreationUserAvatar c;
    public final AiBeautifyUserContent d;
    public final VideoUserContent e;
    public final VideoContentFromChat f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationContent> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(UserCreationImage.a.a), kuc.a.d(UserCreationMusic.a.a), kuc.a.d(UserCreationUserAvatar.a.a), kuc.a.d(AiBeautifyUserContent.a.a), kuc.a.d(VideoUserContent.a.a), kuc.a.d(VideoContentFromChat.a.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.UserCreationContent", r0, 6);
            r1.j("image_content", true);
            r1.j("music_content", true);
            r1.j("user_avatar_content", true);
            r1.j("ai_beautify_user_content", true);
            r1.j("video_user_content", true);
            r1.j("video_content", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            int r3 = 2;
            VideoContentFromChat r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            UserCreationImage r2 = (UserCreationImage) r0.decodeNullableSerializableElement(r1, 0, UserCreationImage.a.a, null);
            UserCreationMusic r6 = (UserCreationMusic) r0.decodeNullableSerializableElement(r1, 1, UserCreationMusic.a.a, null);
            UserCreationUserAvatar r4 = (UserCreationUserAvatar) r0.decodeNullableSerializableElement(r1, 2, UserCreationUserAvatar.a.a, null);
            AiBeautifyUserContent r7 = (AiBeautifyUserContent) r0.decodeNullableSerializableElement(r1, 3, AiBeautifyUserContent.a.a, null);
            UserCreationImage r10 = r2;
            UserCreationUserAvatar r12 = r4;
            VideoUserContent r14 = (VideoUserContent) r0.decodeNullableSerializableElement(r1, 4, VideoUserContent.a.a, null);
            VideoContentFromChat r15 = (VideoContentFromChat) r0.decodeNullableSerializableElement(r1, 5, VideoContentFromChat.a.a, null);
            UserCreationMusic r11 = r6;
            AiBeautifyUserContent r13 = r7;
            int r16 = 63;
        L21:
            r0.endStructure(r1);
            return new UserCreationContent(r16, r10, r11, r12, r13, r14, r15);
        L5:
            r10 = null;
            AiBeautifyUserContent r17 = null;
            r12 = null;
            UserCreationMusic r19 = null;
            r14 = null;
            int r5 = 0;
            boolean r110 = true;
        L6:
            if (r110 == false) goto L20;
            int r8 = r0.decodeElementIndex(r1);
            switch(r8) {
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
            throw new UnknownFieldException(r8);
        L19:
            r3 = 2;
            r110 = false;
            goto L6
        L11:
            r9 = (VideoContentFromChat) r0.decodeNullableSerializableElement(r1, 5, VideoContentFromChat.a.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (VideoUserContent) r0.decodeNullableSerializableElement(r1, 4, VideoUserContent.a.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r17 = (AiBeautifyUserContent) r0.decodeNullableSerializableElement(r1, 3, AiBeautifyUserContent.a.a, r17);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (UserCreationUserAvatar) r0.decodeNullableSerializableElement(r1, r3, UserCreationUserAvatar.a.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r19 = (UserCreationMusic) r0.decodeNullableSerializableElement(r1, 1, UserCreationMusic.a.a, r19);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r10 = (UserCreationImage) r0.decodeNullableSerializableElement(r1, 0, UserCreationImage.a.a, r10);
            goto L18
        L20:
            r15 = r9;
            r16 = r5;
            UserCreationMusic r111 = r19;
            r13 = r17;
            r11 = r111;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            UserCreationContent r9 = (UserCreationContent) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = UserCreationContent.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, UserCreationImage.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, UserCreationMusic.a.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, UserCreationUserAvatar.a.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, AiBeautifyUserContent.a.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, VideoUserContent.a.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r10.encodeNullableSerializableElement(r0, 5, VideoContentFromChat.a.a, r9.f);
        L55:
            r10.endStructure(r0);
            return;
        L51:
            if (r9.f == null) goto L53;
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationContent> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationContent> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationContent createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            VideoContentFromChat r2 = null;
            if (r9.readInt() != 0) goto L5;
            UserCreationImage r1 = null;
        L6:
            UserCreationImage r3 = r1;
            if (r9.readInt() != 0) goto L9;
            UserCreationMusic r4 = null;
        L10:
            UserCreationMusic r5 = r4;
            if (r9.readInt() != 0) goto L13;
            UserCreationUserAvatar r6 = null;
        L14:
            UserCreationUserAvatar r7 = r6;
            if (r9.readInt() != 0) goto L17;
            AiBeautifyUserContent r8 = null;
        L18:
            AiBeautifyUserContent r10 = r8;
            if (r9.readInt() != 0) goto L21;
            VideoUserContent r11 = null;
        L22:
            VideoUserContent r12 = r11;
            if (r9.readInt() == 0) goto L27;
            r2 = VideoContentFromChat.CREATOR.createFromParcel(r9);
        L27:
            return new UserCreationContent(r3, r5, r7, r10, r12, r2);
        L21:
            r11 = VideoUserContent.CREATOR.createFromParcel(r9);
            goto L22
        L17:
            r8 = AiBeautifyUserContent.CREATOR.createFromParcel(r9);
            goto L18
        L13:
            r6 = UserCreationUserAvatar.CREATOR.createFromParcel(r9);
            goto L14
        L9:
            r4 = UserCreationMusic.CREATOR.createFromParcel(r9);
            goto L10
        L5:
            r1 = UserCreationImage.CREATOR.createFromParcel(r9);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationContent[] newArray(int r1) {
            return new UserCreationContent[r1];
        }
    }

    public UserCreationContent() {
        this(null, 63);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationContent) == true) goto L8;
        return false;
    L8:
        UserCreationContent r6 = (UserCreationContent) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        UserCreationImage r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        UserCreationMusic r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        UserCreationUserAvatar r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AiBeautifyUserContent r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        VideoUserContent r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        VideoContentFromChat r16 = this.f;
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

    public final String toString() {
        return "UserCreationContent(imageContent=" + this.a + ", musicContent=" + this.b + ", userAvatarContent=" + this.c + ", aiBeautifyUserContent=" + this.d + ", videoUserContent=" + this.e + ", videoContentFromChat=" + this.f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        UserCreationImage r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        UserCreationMusic r1 = this.b;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        UserCreationUserAvatar r2 = this.c;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        AiBeautifyUserContent r3 = this.d;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        VideoUserContent r6 = this.e;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        VideoContentFromChat r7 = this.f;
        if (r7 != null) goto L25;
        r4.writeInt(0);
        return;
    L25:
        r4.writeInt(1);
        r7.writeToParcel(r4, r5);
        return;
    L21:
        r4.writeInt(1);
        r6.writeToParcel(r4, r5);
        goto L22
    L17:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        goto L18
    L13:
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
        goto L14
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L10
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ UserCreationContent(UserCreationUserAvatar r8, int r9) {
        if ((r9 & 4) == 0) goto L5;
        r8 = null;
    L5:
        this(null, null, r8, null, null, null);
    }

    public UserCreationContent(UserCreationImage r1, UserCreationMusic r2, UserCreationUserAvatar r3, AiBeautifyUserContent r4, VideoUserContent r5, VideoContentFromChat r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public static UserCreationContent a(UserCreationContent r7, UserCreationImage r8, UserCreationUserAvatar r9, AiBeautifyUserContent r10, VideoUserContent r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        UserCreationImage r1 = r8;
        if ((r12 & 2) == 0) goto L8;
        UserCreationMusic r2 = r7.b;
    L10:
        if ((r12 & 4) == 0) goto L12;
        r9 = r7.c;
    L12:
        UserCreationUserAvatar r3 = r9;
        if ((r12 & 8) == 0) goto L15;
        r10 = r7.d;
    L15:
        AiBeautifyUserContent r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r11 = r7.e;
    L18:
        VideoUserContent r5 = r11;
        if ((r12 & 32) == 0) goto L21;
        VideoContentFromChat r6 = r7.f;
    L23:
        return new UserCreationContent(r1, r2, r3, r4, r5, r6);
    L21:
        r6 = null;
        goto L23
    L8:
        r2 = null;
        goto L10
    }

    public UserCreationContent(int r3, UserCreationImage r4, UserCreationMusic r5, UserCreationUserAvatar r6, AiBeautifyUserContent r7, VideoUserContent r8, VideoContentFromChat r9) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = null;
        return;
    L27:
        this.f = r9;
        return;
    L23:
        this.e = r8;
        goto L25
    L19:
        this.d = r7;
        goto L21
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
