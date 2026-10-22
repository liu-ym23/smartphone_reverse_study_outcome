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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010&\u001a\u00020\rJ\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\rHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rJ%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R&\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001f¨\u0006;"}, d2 = {"Lcom/larus/ugc/feed/api/model/AiBeautifyUserContentKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "imageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "multiSelectorList", "", "displayContent", "prompt", "redirectSchema", "<init>", "(Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageInfo$annotations", "()V", "getImageInfo", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "getMultiSelectorList$annotations", "getMultiSelectorList", "()Ljava/lang/String;", "getDisplayContent$annotations", "getDisplayContent", "getPrompt$annotations", "getPrompt", "getRedirectSchema$annotations", "getRedirectSchema", "setRedirectSchema", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class AiBeautifyUserContentKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<AiBeautifyUserContentKmp> CREATOR = null;
    public static final b Companion = null;
    private final String displayContent;
    private final ImageInfoKmp imageInfo;
    private final String multiSelectorList;
    private final String prompt;
    private String redirectSchema;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AiBeautifyUserContentKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(ImageInfoKmp.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.AiBeautifyUserContentKmp", r0, 5);
            r1.j("image_info", true);
            r1.j("multi_selector_list", true);
            r1.j("display_content", true);
            r1.j("prompt", true);
            r1.j("redirect_schema", true);
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
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 3, r5, null);
            ImageInfoKmp r16 = r2;
            String r18 = r3;
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 4, r5, null);
            String r17 = r6;
            String r19 = r7;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new AiBeautifyUserContentKmp(r15, r16, r17, r18, r19, r20, null);
        L5:
            String r9 = null;
            String r10 = null;
            String r11 = null;
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
            r8 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 0, ImageInfoKmp.a.a, r8);
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
            r11 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r11);
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
            AiBeautifyUserContentKmp r4 = (AiBeautifyUserContentKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            AiBeautifyUserContentKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AiBeautifyUserContentKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<AiBeautifyUserContentKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final AiBeautifyUserContentKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            if (r8.readInt() != 0) goto L5;
            ImageInfoKmp r1 = null;
        L7:
            return new AiBeautifyUserContentKmp(r1, r8.readString(), r8.readString(), r8.readString(), r8.readString());
        L5:
            r1 = ImageInfoKmp.CREATOR.createFromParcel(r8);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AiBeautifyUserContentKmp[] newArray(int r1) {
            return new AiBeautifyUserContentKmp[r1];
        }
    }

    public AiBeautifyUserContentKmp() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AiBeautifyUserContentKmp copy$default(AiBeautifyUserContentKmp r3, ImageInfoKmp r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.imageInfo;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.multiSelectorList;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.displayContent;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.prompt;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.redirectSchema;
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

    @SerialName("multi_selector_list")
    public static /* synthetic */ void getMultiSelectorList$annotations() {
    }

    @SerialName("prompt")
    public static /* synthetic */ void getPrompt$annotations() {
    }

    @SerialName("redirect_schema")
    public static /* synthetic */ void getRedirectSchema$annotations() {
    }

    public final ImageInfoKmp component1() {
        return this.imageInfo;
    }

    public final String component2() {
        return this.multiSelectorList;
    }

    public final String component3() {
        return this.displayContent;
    }

    public final String component4() {
        return this.prompt;
    }

    public final String component5() {
        return this.redirectSchema;
    }

    public final AiBeautifyUserContentKmp copy(ImageInfoKmp r8, String r9, String r10, String r11, String r12) {
        return new AiBeautifyUserContentKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AiBeautifyUserContentKmp) == true) goto L8;
        return false;
    L8:
        AiBeautifyUserContentKmp r6 = (AiBeautifyUserContentKmp) r5;
        if (Intrinsics.areEqual(this.imageInfo, r6.imageInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.multiSelectorList, r6.multiSelectorList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayContent, r6.displayContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.redirectSchema, r6.redirectSchema) == true) goto L23;
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
        String r4 = this.multiSelectorList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.displayContent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.prompt;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.redirectSchema;
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
        return "AiBeautifyUserContentKmp(imageInfo=" + this.imageInfo + ", multiSelectorList=" + this.multiSelectorList + ", displayContent=" + this.displayContent + ", prompt=" + this.prompt + ", redirectSchema=" + this.redirectSchema + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        ImageInfoKmp r0 = this.imageInfo;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.multiSelectorList);
        r3.writeString(this.displayContent);
        r3.writeString(this.prompt);
        r3.writeString(this.redirectSchema);
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

    public final String getDisplayContent() {
        return this.displayContent;
    }

    public final ImageInfoKmp getImageInfo() {
        return this.imageInfo;
    }

    public final String getMultiSelectorList() {
        return this.multiSelectorList;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getRedirectSchema() {
        return this.redirectSchema;
    }

    public final void setRedirectSchema(String r1) {
        this.redirectSchema = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(AiBeautifyUserContentKmp r5, muc.d r6, f r7) {
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
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.multiSelectorList);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.displayContent);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, v2.a, r5.prompt);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        r0 = true;
    L44:
        if (r0 == false) goto L47;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.redirectSchema);
        return;
    L47:
        return;
    L42:
        if (r5.redirectSchema == null) goto L44;
    L33:
        if (r5.prompt != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.displayContent != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.multiSelectorList != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.imageInfo != null) goto L4;
        r1 = false;
        goto L9
    }

    public AiBeautifyUserContentKmp(ImageInfoKmp r1, String r2, String r3, String r4, String r5) {
        this.imageInfo = r1;
        this.multiSelectorList = r2;
        this.displayContent = r3;
        this.prompt = r4;
        this.redirectSchema = r5;
    }

    public AiBeautifyUserContentKmp(int r2, ImageInfoKmp r3, String r4, String r5, String r6, String r7, q2 r8) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.imageInfo = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.multiSelectorList = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.displayContent = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.prompt = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.redirectSchema = null;
        return;
    L23:
        this.redirectSchema = r7;
        return;
    L19:
        this.prompt = r6;
        goto L21
    L15:
        this.displayContent = r5;
        goto L17
    L11:
        this.multiSelectorList = r4;
        goto L13
    L7:
        this.imageInfo = r3;
        goto L9
    }

    public /* synthetic */ AiBeautifyUserContentKmp(ImageInfoKmp r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
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
        String r3 = null;
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
