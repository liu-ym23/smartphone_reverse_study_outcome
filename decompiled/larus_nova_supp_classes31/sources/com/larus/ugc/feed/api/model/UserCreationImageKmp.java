package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.creation.TplTagType;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010*\u001a\u00020\u000fJ\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u000fHÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000fJ%\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001e¨\u0006?"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationImageKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "imageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "displayContent", "", "prompt", "ratio", "Lcom/larus/ugc/feed/api/model/OptionItemKmp;", "styles", "model", "<init>", "(Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageInfo$annotations", "()V", "getImageInfo", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/ugc/feed/api/model/OptionItemKmp;", "getStyles$annotations", "getStyles", "getModel$annotations", "getModel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationImageKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationImageKmp> CREATOR = null;
    public static final b Companion = null;
    private final String displayContent;
    private final ImageInfoKmp imageInfo;
    private final OptionItemKmp model;
    private final String prompt;
    private final OptionItemKmp ratio;
    private final OptionItemKmp styles;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationImageKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            OptionItemKmp.a r2 = OptionItemKmp.a.a;
            return new d[]{kuc.a.d(ImageInfoKmp.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationImageKmp", r0, 6);
            r1.j("image_info", true);
            r1.j("display_content", true);
            r1.j("prompt", true);
            r1.j("ratio", true);
            r1.j(TplTagType.STYLE, true);
            r1.j("model", true);
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
            OptionItemKmp r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ImageInfoKmp r2 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 0, ImageInfoKmp.a.a, null);
            v2 r7 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r7, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, r7, null);
            OptionItemKmp.a r8 = OptionItemKmp.a.a;
            OptionItemKmp r10 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            ImageInfoKmp r11 = r2;
            String r12 = r4;
            OptionItemKmp r14 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 4, r8, null);
            OptionItemKmp r15 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 5, r8, null);
            String r13 = r6;
            OptionItemKmp r16 = r10;
            int r17 = 63;
        L21:
            r0.endStructure(r1);
            return new UserCreationImageKmp(r17, r11, r13, r12, r16, r14, r15, null);
        L5:
            r11 = null;
            OptionItemKmp r18 = null;
            r12 = null;
            String r110 = null;
            r14 = null;
            int r5 = 0;
            boolean r111 = true;
        L6:
            if (r111 == false) goto L20;
            int r20 = r0.decodeElementIndex(r1);
            switch(r20) {
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
            throw new UnknownFieldException(r20);
        L19:
            r3 = 2;
            r111 = false;
            goto L6
        L11:
            r9 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 5, OptionItemKmp.a.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 4, OptionItemKmp.a.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r18 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 3, OptionItemKmp.a.a, r18);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r110 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r110);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r11 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 0, ImageInfoKmp.a.a, r11);
            goto L18
        L20:
            r15 = r9;
            r17 = r5;
            String r112 = r110;
            r16 = r18;
            r13 = r112;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationImageKmp r4 = (UserCreationImageKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationImageKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationImageKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationImageKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationImageKmp createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            OptionItemKmp r2 = null;
            if (r9.readInt() != 0) goto L5;
            ImageInfoKmp r1 = null;
        L6:
            ImageInfoKmp r3 = r1;
            String r4 = r9.readString();
            String r5 = r9.readString();
            if (r9.readInt() != 0) goto L9;
            OptionItemKmp r6 = null;
        L10:
            OptionItemKmp r7 = r6;
            if (r9.readInt() != 0) goto L13;
            OptionItemKmp r8 = null;
        L14:
            OptionItemKmp r10 = r8;
            if (r9.readInt() == 0) goto L19;
            r2 = OptionItemKmp.CREATOR.createFromParcel(r9);
        L19:
            return new UserCreationImageKmp(r3, r4, r5, r7, r10, r2);
        L13:
            r8 = OptionItemKmp.CREATOR.createFromParcel(r9);
            goto L14
        L9:
            r6 = OptionItemKmp.CREATOR.createFromParcel(r9);
            goto L10
        L5:
            r1 = ImageInfoKmp.CREATOR.createFromParcel(r9);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationImageKmp[] newArray(int r1) {
            return new UserCreationImageKmp[r1];
        }
    }

    public UserCreationImageKmp() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UserCreationImageKmp copy$default(UserCreationImageKmp r4, ImageInfoKmp r5, String r6, String r7, OptionItemKmp r8, OptionItemKmp r9, OptionItemKmp r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.imageInfo;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.displayContent;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.prompt;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.ratio;
    L14:
        OptionItemKmp r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.styles;
    L17:
        OptionItemKmp r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.model;
    L20:
        ImageInfoKmp r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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

    @SerialName(TplTagType.STYLE)
    public static /* synthetic */ void getStyles$annotations() {
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
        return this.styles;
    }

    public final OptionItemKmp component6() {
        return this.model;
    }

    public final UserCreationImageKmp copy(ImageInfoKmp r9, String r10, String r11, OptionItemKmp r12, OptionItemKmp r13, OptionItemKmp r14) {
        return new UserCreationImageKmp(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationImageKmp) == true) goto L8;
        return false;
    L8:
        UserCreationImageKmp r6 = (UserCreationImageKmp) r5;
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
        if (Intrinsics.areEqual(this.styles, r6.styles) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L26;
        return false;
    L26:
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
        OptionItemKmp r13 = this.styles;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        OptionItemKmp r16 = this.model;
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
        return "UserCreationImageKmp(imageInfo=" + this.imageInfo + ", displayContent=" + this.displayContent + ", prompt=" + this.prompt + ", ratio=" + this.ratio + ", styles=" + this.styles + ", model=" + this.model + ')';
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
        OptionItemKmp r2 = this.styles;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        OptionItemKmp r3 = this.model;
        if (r3 != null) goto L17;
        r4.writeInt(0);
        return;
    L17:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
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

    public final OptionItemKmp getStyles() {
        return this.styles;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationImageKmp r5, muc.d r6, f r7) {
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
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, OptionItemKmp.a.a, r5.styles);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        r0 = true;
    L53:
        if (r0 == false) goto L56;
        r6.encodeNullableSerializableElement(r7, 5, OptionItemKmp.a.a, r5.model);
        return;
    L56:
        return;
    L51:
        if (r5.model == null) goto L53;
    L42:
        if (r5.styles != null) goto L40;
        r8 = false;
        goto L45
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

    public UserCreationImageKmp(ImageInfoKmp r1, String r2, String r3, OptionItemKmp r4, OptionItemKmp r5, OptionItemKmp r6) {
        this.imageInfo = r1;
        this.displayContent = r2;
        this.prompt = r3;
        this.ratio = r4;
        this.styles = r5;
        this.model = r6;
    }

    public UserCreationImageKmp(int r2, ImageInfoKmp r3, String r4, String r5, OptionItemKmp r6, OptionItemKmp r7, OptionItemKmp r8, q2 r9) {
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
        this.styles = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.model = null;
        return;
    L27:
        this.model = r8;
        return;
    L23:
        this.styles = r7;
        goto L25
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

    public /* synthetic */ UserCreationImageKmp(ImageInfoKmp r6, String r7, String r8, OptionItemKmp r9, OptionItemKmp r10, OptionItemKmp r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        ImageInfoKmp r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        OptionItemKmp r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        OptionItemKmp r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        OptionItemKmp r15 = null;
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
