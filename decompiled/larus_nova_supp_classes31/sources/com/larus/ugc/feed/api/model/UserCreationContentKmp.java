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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00060\u0001j\u0002`\u0002:\u0002JKBO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BW\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003JQ\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0006\u00106\u001a\u00020\u0012J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0012HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001J\u0016\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0012J%\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010+R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010.¨\u0006L"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationContentKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "imageContent", "Lcom/larus/ugc/feed/api/model/UserCreationImageKmp;", "musicContent", "Lcom/larus/ugc/feed/api/model/UserCreationMusicKmp;", "userAvatarContent", "Lcom/larus/ugc/feed/api/model/UserCreationUserAvatarKmp;", "aiBeautifyUserContent", "Lcom/larus/ugc/feed/api/model/AiBeautifyUserContentKmp;", "videoUserContent", "Lcom/larus/ugc/feed/api/model/VideoUserContentKmp;", "videoContentFromChat", "Lcom/larus/ugc/feed/api/model/VideoContentFromChatKmp;", "<init>", "(Lcom/larus/ugc/feed/api/model/UserCreationImageKmp;Lcom/larus/ugc/feed/api/model/UserCreationMusicKmp;Lcom/larus/ugc/feed/api/model/UserCreationUserAvatarKmp;Lcom/larus/ugc/feed/api/model/AiBeautifyUserContentKmp;Lcom/larus/ugc/feed/api/model/VideoUserContentKmp;Lcom/larus/ugc/feed/api/model/VideoContentFromChatKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/UserCreationImageKmp;Lcom/larus/ugc/feed/api/model/UserCreationMusicKmp;Lcom/larus/ugc/feed/api/model/UserCreationUserAvatarKmp;Lcom/larus/ugc/feed/api/model/AiBeautifyUserContentKmp;Lcom/larus/ugc/feed/api/model/VideoUserContentKmp;Lcom/larus/ugc/feed/api/model/VideoContentFromChatKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageContent$annotations", "()V", "getImageContent", "()Lcom/larus/ugc/feed/api/model/UserCreationImageKmp;", "getMusicContent$annotations", "getMusicContent", "()Lcom/larus/ugc/feed/api/model/UserCreationMusicKmp;", "setMusicContent", "(Lcom/larus/ugc/feed/api/model/UserCreationMusicKmp;)V", "getUserAvatarContent$annotations", "getUserAvatarContent", "()Lcom/larus/ugc/feed/api/model/UserCreationUserAvatarKmp;", "setUserAvatarContent", "(Lcom/larus/ugc/feed/api/model/UserCreationUserAvatarKmp;)V", "getAiBeautifyUserContent$annotations", "getAiBeautifyUserContent", "()Lcom/larus/ugc/feed/api/model/AiBeautifyUserContentKmp;", "setAiBeautifyUserContent", "(Lcom/larus/ugc/feed/api/model/AiBeautifyUserContentKmp;)V", "getVideoUserContent$annotations", "getVideoUserContent", "()Lcom/larus/ugc/feed/api/model/VideoUserContentKmp;", "getVideoContentFromChat$annotations", "getVideoContentFromChat", "()Lcom/larus/ugc/feed/api/model/VideoContentFromChatKmp;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationContentKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationContentKmp> CREATOR = null;
    public static final b Companion = null;
    private AiBeautifyUserContentKmp aiBeautifyUserContent;
    private final UserCreationImageKmp imageContent;
    private UserCreationMusicKmp musicContent;
    private UserCreationUserAvatarKmp userAvatarContent;
    private final VideoContentFromChatKmp videoContentFromChat;
    private final VideoUserContentKmp videoUserContent;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationContentKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(UserCreationImageKmp.a.a), kuc.a.d(UserCreationMusicKmp.a.a), kuc.a.d(UserCreationUserAvatarKmp.a.a), kuc.a.d(AiBeautifyUserContentKmp.a.a), kuc.a.d(VideoUserContentKmp.a.a), kuc.a.d(VideoContentFromChatKmp.a.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationContentKmp", r0, 6);
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

        public final Object deserialize(e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            int r3 = 2;
            VideoContentFromChatKmp r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            UserCreationImageKmp r2 = (UserCreationImageKmp) r0.decodeNullableSerializableElement(r1, 0, UserCreationImageKmp.a.a, null);
            UserCreationMusicKmp r6 = (UserCreationMusicKmp) r0.decodeNullableSerializableElement(r1, 1, UserCreationMusicKmp.a.a, null);
            UserCreationUserAvatarKmp r4 = (UserCreationUserAvatarKmp) r0.decodeNullableSerializableElement(r1, 2, UserCreationUserAvatarKmp.a.a, null);
            AiBeautifyUserContentKmp r7 = (AiBeautifyUserContentKmp) r0.decodeNullableSerializableElement(r1, 3, AiBeautifyUserContentKmp.a.a, null);
            UserCreationImageKmp r10 = r2;
            UserCreationUserAvatarKmp r12 = r4;
            VideoUserContentKmp r14 = (VideoUserContentKmp) r0.decodeNullableSerializableElement(r1, 4, VideoUserContentKmp.a.a, null);
            VideoContentFromChatKmp r15 = (VideoContentFromChatKmp) r0.decodeNullableSerializableElement(r1, 5, VideoContentFromChatKmp.a.a, null);
            UserCreationMusicKmp r11 = r6;
            AiBeautifyUserContentKmp r13 = r7;
            int r16 = 63;
        L21:
            r0.endStructure(r1);
            return new UserCreationContentKmp(r16, r10, r11, r12, r13, r14, r15, null);
        L5:
            r10 = null;
            AiBeautifyUserContentKmp r17 = null;
            r12 = null;
            UserCreationMusicKmp r18 = null;
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
            r9 = (VideoContentFromChatKmp) r0.decodeNullableSerializableElement(r1, 5, VideoContentFromChatKmp.a.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (VideoUserContentKmp) r0.decodeNullableSerializableElement(r1, 4, VideoUserContentKmp.a.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r17 = (AiBeautifyUserContentKmp) r0.decodeNullableSerializableElement(r1, 3, AiBeautifyUserContentKmp.a.a, r17);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (UserCreationUserAvatarKmp) r0.decodeNullableSerializableElement(r1, r3, UserCreationUserAvatarKmp.a.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r18 = (UserCreationMusicKmp) r0.decodeNullableSerializableElement(r1, 1, UserCreationMusicKmp.a.a, r18);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r10 = (UserCreationImageKmp) r0.decodeNullableSerializableElement(r1, 0, UserCreationImageKmp.a.a, r10);
            goto L18
        L20:
            r15 = r9;
            r16 = r5;
            UserCreationMusicKmp r111 = r18;
            r13 = r17;
            r11 = r111;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationContentKmp r4 = (UserCreationContentKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationContentKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationContentKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationContentKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationContentKmp createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            VideoContentFromChatKmp r2 = null;
            if (r9.readInt() != 0) goto L5;
            UserCreationImageKmp r1 = null;
        L6:
            UserCreationImageKmp r3 = r1;
            if (r9.readInt() != 0) goto L9;
            UserCreationMusicKmp r4 = null;
        L10:
            UserCreationMusicKmp r5 = r4;
            if (r9.readInt() != 0) goto L13;
            UserCreationUserAvatarKmp r6 = null;
        L14:
            UserCreationUserAvatarKmp r7 = r6;
            if (r9.readInt() != 0) goto L17;
            AiBeautifyUserContentKmp r8 = null;
        L18:
            AiBeautifyUserContentKmp r10 = r8;
            if (r9.readInt() != 0) goto L21;
            VideoUserContentKmp r11 = null;
        L22:
            VideoUserContentKmp r12 = r11;
            if (r9.readInt() == 0) goto L27;
            r2 = VideoContentFromChatKmp.CREATOR.createFromParcel(r9);
        L27:
            return new UserCreationContentKmp(r3, r5, r7, r10, r12, r2);
        L21:
            r11 = VideoUserContentKmp.CREATOR.createFromParcel(r9);
            goto L22
        L17:
            r8 = AiBeautifyUserContentKmp.CREATOR.createFromParcel(r9);
            goto L18
        L13:
            r6 = UserCreationUserAvatarKmp.CREATOR.createFromParcel(r9);
            goto L14
        L9:
            r4 = UserCreationMusicKmp.CREATOR.createFromParcel(r9);
            goto L10
        L5:
            r1 = UserCreationImageKmp.CREATOR.createFromParcel(r9);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationContentKmp[] newArray(int r1) {
            return new UserCreationContentKmp[r1];
        }
    }

    public UserCreationContentKmp() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UserCreationContentKmp copy$default(UserCreationContentKmp r4, UserCreationImageKmp r5, UserCreationMusicKmp r6, UserCreationUserAvatarKmp r7, AiBeautifyUserContentKmp r8, VideoUserContentKmp r9, VideoContentFromChatKmp r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.imageContent;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.musicContent;
    L8:
        UserCreationMusicKmp r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.userAvatarContent;
    L11:
        UserCreationUserAvatarKmp r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.aiBeautifyUserContent;
    L14:
        AiBeautifyUserContentKmp r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.videoUserContent;
    L17:
        VideoUserContentKmp r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.videoContentFromChat;
    L20:
        UserCreationImageKmp r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    @SerialName("ai_beautify_user_content")
    public static /* synthetic */ void getAiBeautifyUserContent$annotations() {
    }

    @SerialName("image_content")
    public static /* synthetic */ void getImageContent$annotations() {
    }

    @SerialName("music_content")
    public static /* synthetic */ void getMusicContent$annotations() {
    }

    @SerialName("user_avatar_content")
    public static /* synthetic */ void getUserAvatarContent$annotations() {
    }

    @SerialName("video_content")
    public static /* synthetic */ void getVideoContentFromChat$annotations() {
    }

    @SerialName("video_user_content")
    public static /* synthetic */ void getVideoUserContent$annotations() {
    }

    public final UserCreationImageKmp component1() {
        return this.imageContent;
    }

    public final UserCreationMusicKmp component2() {
        return this.musicContent;
    }

    public final UserCreationUserAvatarKmp component3() {
        return this.userAvatarContent;
    }

    public final AiBeautifyUserContentKmp component4() {
        return this.aiBeautifyUserContent;
    }

    public final VideoUserContentKmp component5() {
        return this.videoUserContent;
    }

    public final VideoContentFromChatKmp component6() {
        return this.videoContentFromChat;
    }

    public final UserCreationContentKmp copy(UserCreationImageKmp r9, UserCreationMusicKmp r10, UserCreationUserAvatarKmp r11, AiBeautifyUserContentKmp r12, VideoUserContentKmp r13, VideoContentFromChatKmp r14) {
        return new UserCreationContentKmp(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationContentKmp) == true) goto L8;
        return false;
    L8:
        UserCreationContentKmp r6 = (UserCreationContentKmp) r5;
        if (Intrinsics.areEqual(this.imageContent, r6.imageContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.musicContent, r6.musicContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userAvatarContent, r6.userAvatarContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.aiBeautifyUserContent, r6.aiBeautifyUserContent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoUserContent, r6.videoUserContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoContentFromChat, r6.videoContentFromChat) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        UserCreationImageKmp r0 = this.imageContent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        UserCreationMusicKmp r4 = this.musicContent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        UserCreationUserAvatarKmp r7 = this.userAvatarContent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AiBeautifyUserContentKmp r10 = this.aiBeautifyUserContent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        VideoUserContentKmp r13 = this.videoUserContent;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        VideoContentFromChatKmp r16 = this.videoContentFromChat;
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
        return "UserCreationContentKmp(imageContent=" + this.imageContent + ", musicContent=" + this.musicContent + ", userAvatarContent=" + this.userAvatarContent + ", aiBeautifyUserContent=" + this.aiBeautifyUserContent + ", videoUserContent=" + this.videoUserContent + ", videoContentFromChat=" + this.videoContentFromChat + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        UserCreationImageKmp r0 = this.imageContent;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        UserCreationMusicKmp r1 = this.musicContent;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        UserCreationUserAvatarKmp r2 = this.userAvatarContent;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        AiBeautifyUserContentKmp r3 = this.aiBeautifyUserContent;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        VideoUserContentKmp r6 = this.videoUserContent;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        VideoContentFromChatKmp r7 = this.videoContentFromChat;
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
        $stable = 8;
        CREATOR = new c();
    }

    public final AiBeautifyUserContentKmp getAiBeautifyUserContent() {
        return this.aiBeautifyUserContent;
    }

    public final UserCreationImageKmp getImageContent() {
        return this.imageContent;
    }

    public final UserCreationMusicKmp getMusicContent() {
        return this.musicContent;
    }

    public final UserCreationUserAvatarKmp getUserAvatarContent() {
        return this.userAvatarContent;
    }

    public final VideoContentFromChatKmp getVideoContentFromChat() {
        return this.videoContentFromChat;
    }

    public final VideoUserContentKmp getVideoUserContent() {
        return this.videoUserContent;
    }

    public final void setAiBeautifyUserContent(AiBeautifyUserContentKmp r1) {
        this.aiBeautifyUserContent = r1;
    }

    public final void setMusicContent(UserCreationMusicKmp r1) {
        this.musicContent = r1;
    }

    public final void setUserAvatarContent(UserCreationUserAvatarKmp r1) {
        this.userAvatarContent = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationContentKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, UserCreationImageKmp.a.a, r5.imageContent);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, UserCreationMusicKmp.a.a, r5.musicContent);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, UserCreationUserAvatarKmp.a.a, r5.userAvatarContent);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, AiBeautifyUserContentKmp.a.a, r5.aiBeautifyUserContent);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, VideoUserContentKmp.a.a, r5.videoUserContent);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        r0 = true;
    L53:
        if (r0 == false) goto L56;
        r6.encodeNullableSerializableElement(r7, 5, VideoContentFromChatKmp.a.a, r5.videoContentFromChat);
        return;
    L56:
        return;
    L51:
        if (r5.videoContentFromChat == null) goto L53;
    L42:
        if (r5.videoUserContent != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.aiBeautifyUserContent != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.userAvatarContent != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.musicContent != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.imageContent != null) goto L4;
        r1 = false;
        goto L9
    }

    public UserCreationContentKmp(UserCreationImageKmp r1, UserCreationMusicKmp r2, UserCreationUserAvatarKmp r3, AiBeautifyUserContentKmp r4, VideoUserContentKmp r5, VideoContentFromChatKmp r6) {
        this.imageContent = r1;
        this.musicContent = r2;
        this.userAvatarContent = r3;
        this.aiBeautifyUserContent = r4;
        this.videoUserContent = r5;
        this.videoContentFromChat = r6;
    }

    public UserCreationContentKmp(int r2, UserCreationImageKmp r3, UserCreationMusicKmp r4, UserCreationUserAvatarKmp r5, AiBeautifyUserContentKmp r6, VideoUserContentKmp r7, VideoContentFromChatKmp r8, q2 r9) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.imageContent = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.musicContent = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.userAvatarContent = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.aiBeautifyUserContent = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.videoUserContent = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.videoContentFromChat = null;
        return;
    L27:
        this.videoContentFromChat = r8;
        return;
    L23:
        this.videoUserContent = r7;
        goto L25
    L19:
        this.aiBeautifyUserContent = r6;
        goto L21
    L15:
        this.userAvatarContent = r5;
        goto L17
    L11:
        this.musicContent = r4;
        goto L13
    L7:
        this.imageContent = r3;
        goto L9
    }

    public /* synthetic */ UserCreationContentKmp(UserCreationImageKmp r6, UserCreationMusicKmp r7, UserCreationUserAvatarKmp r8, AiBeautifyUserContentKmp r9, VideoUserContentKmp r10, VideoContentFromChatKmp r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        UserCreationImageKmp r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        UserCreationMusicKmp r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        UserCreationUserAvatarKmp r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        AiBeautifyUserContentKmp r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        VideoUserContentKmp r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        VideoContentFromChatKmp r15 = null;
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
