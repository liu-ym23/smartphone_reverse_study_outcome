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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010&\u001a\u00020\u000eJ\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000eJ%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u001d¨\u0006;"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationUserAvatarKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "imageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "displayContent", "", "prompt", "ratio", "Lcom/larus/ugc/feed/api/model/OptionItemKmp;", "model", "<init>", "(Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageInfo$annotations", "()V", "getImageInfo", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/ugc/feed/api/model/OptionItemKmp;", "getModel$annotations", "getModel", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationUserAvatarKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationUserAvatarKmp> CREATOR = null;
    public static final b Companion = null;
    private final String displayContent;
    private final ImageInfoKmp imageInfo;
    private final OptionItemKmp model;
    private final String prompt;
    private final OptionItemKmp ratio;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationUserAvatarKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            OptionItemKmp.a r2 = OptionItemKmp.a.a;
            return new d[]{kuc.a.d(ImageInfoKmp.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationUserAvatarKmp", r0, 5);
            r1.j("image_info", true);
            r1.j("display_content", true);
            r1.j("prompt", true);
            r1.j("ratio", true);
            r1.j("model", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            ImageInfoKmp r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ImageInfoKmp r2 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 0, ImageInfoKmp.a.a, null);
            v2 r5 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r5, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r5, null);
            OptionItemKmp.a r7 = OptionItemKmp.a.a;
            OptionItemKmp r9 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            ImageInfoKmp r16 = r2;
            String r18 = r3;
            OptionItemKmp r20 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 4, r7, null);
            String r17 = r6;
            OptionItemKmp r19 = r9;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new UserCreationUserAvatarKmp(r15, r16, r17, r18, r19, r20, null);
        L5:
            String r10 = null;
            String r11 = null;
            OptionItemKmp r12 = null;
            OptionItemKmp r13 = null;
            int r4 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L22;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r8 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 0, ImageInfoKmp.a.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r110 != 1) goto L11;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r10);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r110 != 2) goto L12;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r11);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r110 != 3) goto L13;
            r12 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 3, OptionItemKmp.a.a, r12);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r110 != 4) goto L16;
            r13 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 4, OptionItemKmp.a.a, r13);
            r4 = r4 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L22:
            r15 = r4;
            r16 = r8;
            r17 = r10;
            r18 = r11;
            r19 = r12;
            r20 = r13;
            goto L23
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationUserAvatarKmp r4 = (UserCreationUserAvatarKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationUserAvatarKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationUserAvatarKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationUserAvatarKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationUserAvatarKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            OptionItemKmp r2 = null;
            if (r8.readInt() != 0) goto L5;
            ImageInfoKmp r1 = null;
        L6:
            ImageInfoKmp r3 = r1;
            String r4 = r8.readString();
            String r5 = r8.readString();
            if (r8.readInt() != 0) goto L9;
            OptionItemKmp r6 = null;
        L10:
            OptionItemKmp r7 = r6;
            if (r8.readInt() == 0) goto L15;
            r2 = OptionItemKmp.CREATOR.createFromParcel(r8);
        L15:
            return new UserCreationUserAvatarKmp(r3, r4, r5, r7, r2);
        L9:
            r6 = OptionItemKmp.CREATOR.createFromParcel(r8);
            goto L10
        L5:
            r1 = ImageInfoKmp.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationUserAvatarKmp[] newArray(int r1) {
            return new UserCreationUserAvatarKmp[r1];
        }
    }

    public UserCreationUserAvatarKmp() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ UserCreationUserAvatarKmp copy$default(UserCreationUserAvatarKmp r3, ImageInfoKmp r4, String r5, String r6, OptionItemKmp r7, OptionItemKmp r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.imageInfo;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.displayContent;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.prompt;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.ratio;
    L14:
        OptionItemKmp r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.model;
    L17:
        ImageInfoKmp r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @SerialName("display_content")
    public static /* synthetic */ void getDisplayContent$annotations() {
    }

    @SerialName("image_info")
    public static /* synthetic */ void getImageInfo$annotations() {
    }

    @SerialName("model")
    public static /* synthetic */ void getModel$annotations() {
    }

    @SerialName("prompt")
    public static /* synthetic */ void getPrompt$annotations() {
    }

    @SerialName("ratio")
    public static /* synthetic */ void getRatio$annotations() {
    }

    public final ImageInfoKmp component1() {
        return this.imageInfo;
    }

    public final String component2() {
        return this.displayContent;
    }

    public final String component3() {
        return this.prompt;
    }

    public final OptionItemKmp component4() {
        return this.ratio;
    }

    public final OptionItemKmp component5() {
        return this.model;
    }

    public final UserCreationUserAvatarKmp copy(ImageInfoKmp r8, String r9, String r10, OptionItemKmp r11, OptionItemKmp r12) {
        return new UserCreationUserAvatarKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationUserAvatarKmp) == true) goto L8;
        return false;
    L8:
        UserCreationUserAvatarKmp r6 = (UserCreationUserAvatarKmp) r5;
        if (Intrinsics.areEqual(this.imageInfo, r6.imageInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayContent, r6.displayContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ratio, r6.ratio) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        ImageInfoKmp r0 = this.imageInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.displayContent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.prompt;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        OptionItemKmp r10 = this.ratio;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        OptionItemKmp r13 = this.model;
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
        return "UserCreationUserAvatarKmp(imageInfo=" + this.imageInfo + ", displayContent=" + this.displayContent + ", prompt=" + this.prompt + ", ratio=" + this.ratio + ", model=" + this.model + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        ImageInfoKmp r0 = this.imageInfo;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeString(this.displayContent);
        r4.writeString(this.prompt);
        OptionItemKmp r1 = this.ratio;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        OptionItemKmp r2 = this.model;
        if (r2 != null) goto L13;
        r4.writeInt(0);
        return;
    L13:
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
        return;
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

    public final String getDisplayContent() {
        return this.displayContent;
    }

    public final ImageInfoKmp getImageInfo() {
        return this.imageInfo;
    }

    public final OptionItemKmp getModel() {
        return this.model;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final OptionItemKmp getRatio() {
        return this.ratio;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationUserAvatarKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, ImageInfoKmp.a.a, r5.imageInfo);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.displayContent);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.prompt);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, OptionItemKmp.a.a, r5.ratio);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        r0 = true;
    L44:
        if (r0 == false) goto L47;
        r6.encodeNullableSerializableElement(r7, 4, OptionItemKmp.a.a, r5.model);
        return;
    L47:
        return;
    L42:
        if (r5.model == null) goto L44;
    L33:
        if (r5.ratio != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.prompt != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.displayContent != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.imageInfo != null) goto L4;
        r1 = false;
        goto L9
    }

    public UserCreationUserAvatarKmp(ImageInfoKmp r1, String r2, String r3, OptionItemKmp r4, OptionItemKmp r5) {
        this.imageInfo = r1;
        this.displayContent = r2;
        this.prompt = r3;
        this.ratio = r4;
        this.model = r5;
    }

    public UserCreationUserAvatarKmp(int r2, ImageInfoKmp r3, String r4, String r5, OptionItemKmp r6, OptionItemKmp r7, q2 r8) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.imageInfo = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.displayContent = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.prompt = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.ratio = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.model = null;
        return;
    L23:
        this.model = r7;
        return;
    L19:
        this.ratio = r6;
        goto L21
    L15:
        this.prompt = r5;
        goto L17
    L11:
        this.displayContent = r4;
        goto L13
    L7:
        this.imageInfo = r3;
        goto L9
    }

    public /* synthetic */ UserCreationUserAvatarKmp(ImageInfoKmp r5, String r6, String r7, OptionItemKmp r8, OptionItemKmp r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        ImageInfoKmp r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        OptionItemKmp r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        OptionItemKmp r13 = null;
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
