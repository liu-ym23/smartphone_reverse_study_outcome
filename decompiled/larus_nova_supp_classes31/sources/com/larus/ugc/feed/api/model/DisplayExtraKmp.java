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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00060\u0001j\u0002`\u0002:\u000212B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u000bJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bJ%\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012¨\u00063"}, d2 = {"Lcom/larus/ugc/feed/api/model/DisplayExtraKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "textColor", "", "darkTextColor", "iconUrl", "darkIconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTextColor$annotations", "()V", "getTextColor", "()Ljava/lang/String;", "getDarkTextColor$annotations", "getDarkTextColor", "getIconUrl$annotations", "getIconUrl", "getDarkIconUrl$annotations", "getDarkIconUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class DisplayExtraKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<DisplayExtraKmp> CREATOR = null;
    public static final b Companion = null;
    private final String darkIconUrl;
    private final String darkTextColor;
    private final String iconUrl;
    private final String textColor;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<DisplayExtraKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.DisplayExtraKmp", r0, 4);
            r1.j("text_color", true);
            r1.j("dark_text_color", true);
            r1.j("icon_url", true);
            r1.j("dark_icon_url", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            String r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r16 = r3;
            String r14 = r4;
            String r15 = r5;
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new DisplayExtraKmp(r13, r14, r15, r16, r17, null);
        L5:
            String r8 = null;
            String r9 = null;
            String r10 = null;
            int r6 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r7 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r7);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r8);
            r6 = r6 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r9);
            r6 = r6 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r10);
            r6 = r6 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r13 = r6;
            r14 = r7;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            DisplayExtraKmp r4 = (DisplayExtraKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            DisplayExtraKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<DisplayExtraKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<DisplayExtraKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final DisplayExtraKmp createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new DisplayExtraKmp(r5.readString(), r5.readString(), r5.readString(), r5.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DisplayExtraKmp[] newArray(int r1) {
            return new DisplayExtraKmp[r1];
        }
    }

    public DisplayExtraKmp() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DisplayExtraKmp copy$default(DisplayExtraKmp r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.textColor;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.darkTextColor;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.iconUrl;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.darkIconUrl;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    @SerialName("dark_icon_url")
    public static /* synthetic */ void getDarkIconUrl$annotations() {
    }

    @SerialName("dark_text_color")
    public static /* synthetic */ void getDarkTextColor$annotations() {
    }

    @SerialName("icon_url")
    public static /* synthetic */ void getIconUrl$annotations() {
    }

    @SerialName("text_color")
    public static /* synthetic */ void getTextColor$annotations() {
    }

    public final String component1() {
        return this.textColor;
    }

    public final String component2() {
        return this.darkTextColor;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.darkIconUrl;
    }

    public final DisplayExtraKmp copy(String r2, String r3, String r4, String r5) {
        return new DisplayExtraKmp(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DisplayExtraKmp) == true) goto L8;
        return false;
    L8:
        DisplayExtraKmp r6 = (DisplayExtraKmp) r5;
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.darkTextColor, r6.darkTextColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkIconUrl, r6.darkIconUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.textColor;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.darkTextColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.iconUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.darkIconUrl;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "DisplayExtraKmp(textColor=" + this.textColor + ", darkTextColor=" + this.darkTextColor + ", iconUrl=" + this.iconUrl + ", darkIconUrl=" + this.darkIconUrl + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.textColor);
        r1.writeString(this.darkTextColor);
        r1.writeString(this.iconUrl);
        r1.writeString(this.darkIconUrl);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getDarkIconUrl() {
        return this.darkIconUrl;
    }

    public final String getDarkTextColor() {
        return this.darkTextColor;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(DisplayExtraKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.textColor);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.darkTextColor);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.iconUrl);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        r0 = true;
    L35:
        if (r0 == false) goto L38;
        r6.encodeNullableSerializableElement(r7, 3, v2.a, r5.darkIconUrl);
        return;
    L38:
        return;
    L33:
        if (r5.darkIconUrl == null) goto L35;
    L24:
        if (r5.iconUrl != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.darkTextColor != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.textColor != null) goto L4;
        r1 = false;
        goto L9
    }

    public DisplayExtraKmp(String r1, String r2, String r3, String r4) {
        this.textColor = r1;
        this.darkTextColor = r2;
        this.iconUrl = r3;
        this.darkIconUrl = r4;
    }

    public DisplayExtraKmp(int r2, String r3, String r4, String r5, String r6, q2 r7) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.textColor = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.darkTextColor = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.iconUrl = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.darkIconUrl = null;
        return;
    L19:
        this.darkIconUrl = r6;
        return;
    L15:
        this.iconUrl = r5;
        goto L17
    L11:
        this.darkTextColor = r4;
        goto L13
    L7:
        this.textColor = r3;
        goto L9
    }

    public /* synthetic */ DisplayExtraKmp(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
