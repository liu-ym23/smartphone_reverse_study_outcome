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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00060\u0001j\u0002`\u0002:\u0002PQB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0081\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010=\u001a\u00020\u0012J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0012HÖ\u0001J\t\u0010C\u001a\u00020\u0004HÖ\u0001J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0012J%\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0017\u001a\u0004\b1\u0010\u0019¨\u0006R"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationMusicKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "videoModel", "", "title", "lyric", "cover", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "shareInfo", "coverMainColor", "captionsResult", "vid", "genre", "makeReplicaParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoModel$annotations", "()V", "getVideoModel", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getLyric$annotations", "getLyric", "getCover$annotations", "getCover", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "setCover", "(Lcom/larus/ugc/feed/api/model/ImageInfoKmp;)V", "getShareInfo$annotations", "getShareInfo", "getCoverMainColor$annotations", "getCoverMainColor", "setCoverMainColor", "getCaptionsResult$annotations", "getCaptionsResult", "getVid$annotations", "getVid", "getGenre$annotations", "getGenre", "getMakeReplicaParams$annotations", "getMakeReplicaParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationMusicKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationMusicKmp> CREATOR = null;
    public static final b Companion = null;
    private final String captionsResult;
    private ImageInfoKmp cover;
    private String coverMainColor;
    private final String genre;
    private final String lyric;
    private final String makeReplicaParams;
    private final String shareInfo;
    private String title;
    private final String vid;
    private final String videoModel;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationMusicKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationMusicKmp", r0, 10);
            r1.j("video_model", true);
            r1.j("title", true);
            r1.j("lyric", true);
            r1.j("cover", true);
            r1.j("share_info", true);
            r1.j("cover_main_color", true);
            r1.j("captions_result", true);
            r1.j("vid", true);
            r1.j("genre", true);
            r1.j("make_replica_param", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(ImageInfoKmp.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            int r3 = 8;
            int r6 = 6;
            int r7 = 7;
            String r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            ImageInfoKmp r4 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 3, ImageInfoKmp.a.a, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            String r16 = r15;
            String r18 = r5;
            String r19 = r8;
            String r110 = r14;
            String r20 = r11;
            int r21 = 1023;
            ImageInfoKmp r111 = r4;
            String r112 = r9;
            String r22 = r12;
            String r113 = r10;
        L27:
            r0.endStructure(r1);
            return new UserCreationMusicKmp(r21, r20, r22, r112, r111, r113, r18, r19, r110, r16, r17, null);
        L5:
            String r23 = null;
            String r25 = null;
            String r114 = null;
            String r115 = null;
            String r116 = null;
            ImageInfoKmp r117 = null;
            String r118 = null;
            String r119 = null;
            String r26 = null;
            int r27 = 0;
            boolean r28 = true;
        L6:
            if (r28 == false) goto L26;
            int r29 = r0.decodeElementIndex(r1);
            switch(r29) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r29);
        L25:
            r3 = 8;
            r6 = 6;
            r7 = 7;
            r28 = false;
            goto L6
        L11:
            r23 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r23);
            r27 = r27 | 512;
        L20:
            String r30 = r119;
        L22:
            String r31 = r26;
        L24:
            r119 = r30;
            r26 = r31;
            r3 = 8;
            r6 = 6;
            r7 = 7;
            goto L6
        L12:
            r25 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r25);
            r27 = r27 | 256;
            goto L20
        L13:
            r114 = (String) r0.decodeNullableSerializableElement(r1, r7, v2.a, r114);
            r27 = r27 | 128;
            goto L20
        L14:
            r116 = (String) r0.decodeNullableSerializableElement(r1, r6, v2.a, r116);
            r27 = r27 | 64;
            goto L20
        L16:
            r115 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r115);
            r27 = r27 | 32;
            goto L20
        L17:
            r118 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r118);
            r27 = r27 | 16;
            goto L20
        L18:
            r117 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 3, ImageInfoKmp.a.a, r117);
            r27 = r27 | 8;
            goto L20
        L19:
            r119 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r119);
            r27 = r27 | 4;
            goto L20
        L21:
            r30 = r119;
            r26 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r26);
            r27 = r27 | 2;
            goto L22
        L23:
            r30 = r119;
            r31 = r26;
            r27 = r27 | 1;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r13);
            goto L24
        L26:
            r21 = r27;
            r17 = r23;
            r16 = r25;
            r20 = r13;
            r22 = r26;
            r18 = r115;
            r111 = r117;
            r19 = r116;
            r113 = r118;
            r110 = r114;
            r112 = r119;
            goto L27
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationMusicKmp r4 = (UserCreationMusicKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationMusicKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationMusicKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationMusicKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationMusicKmp createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            String r2 = r13.readString();
            String r3 = r13.readString();
            String r4 = r13.readString();
            if (r13.readInt() != 0) goto L5;
            ImageInfoKmp r1 = null;
        L7:
            return new UserCreationMusicKmp(r2, r3, r4, r1, r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString());
        L5:
            r1 = ImageInfoKmp.CREATOR.createFromParcel(r13);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationMusicKmp[] newArray(int r1) {
            return new UserCreationMusicKmp[r1];
        }
    }

    public UserCreationMusicKmp() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ UserCreationMusicKmp copy$default(UserCreationMusicKmp r11, String r12, String r13, String r14, ImageInfoKmp r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.videoModel;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.title;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.lyric;
    L15:
        if ((r22 & 8) == 0) goto L17;
        ImageInfoKmp r5 = r11.cover;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.shareInfo;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.coverMainColor;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.captionsResult;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.vid;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.genre;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.makeReplicaParams;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    @SerialName("captions_result")
    public static /* synthetic */ void getCaptionsResult$annotations() {
    }

    @SerialName("cover")
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("cover_main_color")
    public static /* synthetic */ void getCoverMainColor$annotations() {
    }

    @SerialName("genre")
    public static /* synthetic */ void getGenre$annotations() {
    }

    @SerialName("lyric")
    public static /* synthetic */ void getLyric$annotations() {
    }

    @SerialName("make_replica_param")
    public static /* synthetic */ void getMakeReplicaParams$annotations() {
    }

    @SerialName("share_info")
    public static /* synthetic */ void getShareInfo$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    @SerialName("video_model")
    public static /* synthetic */ void getVideoModel$annotations() {
    }

    public final String component1() {
        return this.videoModel;
    }

    public final String component10() {
        return this.makeReplicaParams;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.lyric;
    }

    public final ImageInfoKmp component4() {
        return this.cover;
    }

    public final String component5() {
        return this.shareInfo;
    }

    public final String component6() {
        return this.coverMainColor;
    }

    public final String component7() {
        return this.captionsResult;
    }

    public final String component8() {
        return this.vid;
    }

    public final String component9() {
        return this.genre;
    }

    public final UserCreationMusicKmp copy(String r13, String r14, String r15, ImageInfoKmp r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        return new UserCreationMusicKmp(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationMusicKmp) == true) goto L8;
        return false;
    L8:
        UserCreationMusicKmp r6 = (UserCreationMusicKmp) r5;
        if (Intrinsics.areEqual(this.videoModel, r6.videoModel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lyric, r6.lyric) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cover, r6.cover) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.shareInfo, r6.shareInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.coverMainColor, r6.coverMainColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.captionsResult, r6.captionsResult) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.genre, r6.genre) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.makeReplicaParams, r6.makeReplicaParams) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.videoModel;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.lyric;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageInfoKmp r10 = this.cover;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.shareInfo;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.coverMainColor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.captionsResult;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.vid;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.genre;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.makeReplicaParams;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "UserCreationMusicKmp(videoModel=" + this.videoModel + ", title=" + this.title + ", lyric=" + this.lyric + ", cover=" + this.cover + ", shareInfo=" + this.shareInfo + ", coverMainColor=" + this.coverMainColor + ", captionsResult=" + this.captionsResult + ", vid=" + this.vid + ", genre=" + this.genre + ", makeReplicaParams=" + this.makeReplicaParams + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.videoModel);
        r3.writeString(this.title);
        r3.writeString(this.lyric);
        ImageInfoKmp r0 = this.cover;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.shareInfo);
        r3.writeString(this.coverMainColor);
        r3.writeString(this.captionsResult);
        r3.writeString(this.vid);
        r3.writeString(this.genre);
        r3.writeString(this.makeReplicaParams);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
        goto L6
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
    }

    public final String getCaptionsResult() {
        return this.captionsResult;
    }

    public final ImageInfoKmp getCover() {
        return this.cover;
    }

    public final String getCoverMainColor() {
        return this.coverMainColor;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final String getLyric() {
        return this.lyric;
    }

    public final String getMakeReplicaParams() {
        return this.makeReplicaParams;
    }

    public final String getShareInfo() {
        return this.shareInfo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public final void setCover(ImageInfoKmp r1) {
        this.cover = r1;
    }

    public final void setCoverMainColor(String r1) {
        this.coverMainColor = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationMusicKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.videoModel);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.title);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.lyric);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, ImageInfoKmp.a.a, r5.cover);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.shareInfo);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        boolean r9 = true;
    L54:
        if (r9 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 5, v2.a, r5.coverMainColor);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L60;
    L58:
        boolean r10 = true;
    L63:
        if (r10 == false) goto L66;
        r6.encodeNullableSerializableElement(r7, 6, v2.a, r5.captionsResult);
    L66:
        if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L69;
    L67:
        boolean r11 = true;
    L72:
        if (r11 == false) goto L75;
        r6.encodeNullableSerializableElement(r7, 7, v2.a, r5.vid);
    L75:
        if (r6.shouldEncodeElementDefault(r7, 8) == false) goto L78;
    L76:
        boolean r12 = true;
    L81:
        if (r12 == false) goto L84;
        r6.encodeNullableSerializableElement(r7, 8, v2.a, r5.genre);
    L84:
        if (r6.shouldEncodeElementDefault(r7, 9) == false) goto L87;
    L85:
        r0 = true;
    L89:
        if (r0 == false) goto L92;
        r6.encodeNullableSerializableElement(r7, 9, v2.a, r5.makeReplicaParams);
        return;
    L92:
        return;
    L87:
        if (r5.makeReplicaParams == null) goto L89;
    L78:
        if (r5.genre != null) goto L76;
        r12 = false;
        goto L81
    L69:
        if (r5.vid != null) goto L67;
        r11 = false;
        goto L72
    L60:
        if (r5.captionsResult != null) goto L58;
        r10 = false;
        goto L63
    L51:
        if (r5.coverMainColor != null) goto L49;
        r9 = false;
        goto L54
    L42:
        if (r5.shareInfo != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.cover != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.lyric != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.title != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.videoModel != null) goto L4;
        r1 = false;
        goto L9
    }

    public UserCreationMusicKmp(String r1, String r2, String r3, ImageInfoKmp r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        this.videoModel = r1;
        this.title = r2;
        this.lyric = r3;
        this.cover = r4;
        this.shareInfo = r5;
        this.coverMainColor = r6;
        this.captionsResult = r7;
        this.vid = r8;
        this.genre = r9;
        this.makeReplicaParams = r10;
    }

    public UserCreationMusicKmp(int r2, String r3, String r4, String r5, ImageInfoKmp r6, String r7, String r8, String r9, String r10, String r11, String r12, q2 r13) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.videoModel = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.title = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.lyric = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.cover = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.shareInfo = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.coverMainColor = null;
    L29:
        if ((r2 & 64) != 0) goto L31;
        this.captionsResult = null;
    L33:
        if ((r2 & 128) != 0) goto L35;
        this.vid = null;
    L37:
        if ((r2 & 256) != 0) goto L39;
        this.genre = null;
    L41:
        if ((r2 & 512) != 0) goto L43;
        this.makeReplicaParams = null;
        return;
    L43:
        this.makeReplicaParams = r12;
        return;
    L39:
        this.genre = r11;
        goto L41
    L35:
        this.vid = r10;
        goto L37
    L31:
        this.captionsResult = r9;
        goto L33
    L27:
        this.coverMainColor = r8;
        goto L29
    L23:
        this.shareInfo = r7;
        goto L25
    L19:
        this.cover = r6;
        goto L21
    L15:
        this.lyric = r5;
        goto L17
    L11:
        this.title = r4;
        goto L13
    L7:
        this.videoModel = r3;
        goto L9
    }

    public /* synthetic */ UserCreationMusicKmp(String r12, String r13, String r14, ImageInfoKmp r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        ImageInfoKmp r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
