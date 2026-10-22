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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00060\u0001j\u0002`\u0002:\u0002;<BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\b\u0010!\u001a\u0004\u0018\u00010\u0004J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u000eJ\u0013\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u000eHÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000eJ%\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 ¨\u0006="}, d2 = {"Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "id", "", "starlingKey", "name", "supportTextReplace", "", "displayExtra", "Lcom/larus/ugc/feed/api/model/DisplayExtraKmp;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/ugc/feed/api/model/DisplayExtraKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/ugc/feed/api/model/DisplayExtraKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getStarlingKey$annotations", "getStarlingKey", "getName$annotations", "getName", "getSupportTextReplace$annotations", "getSupportTextReplace", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayExtra$annotations", "getDisplayExtra", "()Lcom/larus/ugc/feed/api/model/DisplayExtraKmp;", "getTrackerTabType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/ugc/feed/api/model/DisplayExtraKmp;)Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TabItemInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<TabItemInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final DisplayExtraKmp displayExtra;
    private final String id;
    private final String name;
    private final String starlingKey;
    private final Boolean supportTextReplace;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TabItemInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(i.a), kuc.a.d(DisplayExtraKmp.a.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.TabItemInfoKmp", r0, 5);
            r1.j("id", true);
            r1.j("starling_key", true);
            r1.j("name", true);
            r1.j("support_text_replace", true);
            r1.j("display_extra", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r18 = r3;
            Boolean r19 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, i.a, null);
            DisplayExtraKmp r20 = (DisplayExtraKmp) r0.decodeNullableSerializableElement(r1, 4, DisplayExtraKmp.a.a, null);
            String r16 = r5;
            String r17 = r6;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new TabItemInfoKmp(r15, r16, r17, r18, r19, r20, null);
        L5:
            String r9 = null;
            String r10 = null;
            Boolean r11 = null;
            DisplayExtraKmp r12 = null;
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
            r8 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r8);
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
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, i.a, r11);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r12 = (DisplayExtraKmp) r0.decodeNullableSerializableElement(r1, 4, DisplayExtraKmp.a.a, r12);
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
            TabItemInfoKmp r4 = (TabItemInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            TabItemInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TabItemInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TabItemInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TabItemInfoKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r2 = r8.readString();
            String r3 = r8.readString();
            String r4 = r8.readString();
            DisplayExtraKmp r5 = null;
            if (r8.readInt() != 0) goto L6;
            Boolean r6 = null;
        L11:
            if (r8.readInt() == 0) goto L15;
            r5 = DisplayExtraKmp.CREATOR.createFromParcel(r8);
        L15:
            return new TabItemInfoKmp(r2, r3, r4, r6, r5);
        L6:
            if (r8.readInt() == 0) goto L8;
            boolean r1 = true;
        L9:
            r6 = Boolean.valueOf(r1);
            goto L11
        L8:
            r1 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final TabItemInfoKmp[] newArray(int r1) {
            return new TabItemInfoKmp[r1];
        }
    }

    public TabItemInfoKmp() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TabItemInfoKmp copy$default(TabItemInfoKmp r3, String r4, String r5, String r6, Boolean r7, DisplayExtraKmp r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.id;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.starlingKey;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.name;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.supportTextReplace;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.displayExtra;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @SerialName("display_extra")
    public static /* synthetic */ void getDisplayExtra$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("starling_key")
    public static /* synthetic */ void getStarlingKey$annotations() {
    }

    @SerialName("support_text_replace")
    public static /* synthetic */ void getSupportTextReplace$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.starlingKey;
    }

    public final String component3() {
        return this.name;
    }

    public final Boolean component4() {
        return this.supportTextReplace;
    }

    public final DisplayExtraKmp component5() {
        return this.displayExtra;
    }

    public final TabItemInfoKmp copy(String r8, String r9, String r10, Boolean r11, DisplayExtraKmp r12) {
        return new TabItemInfoKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TabItemInfoKmp) == true) goto L8;
        return false;
    L8:
        TabItemInfoKmp r6 = (TabItemInfoKmp) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.starlingKey, r6.starlingKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportTextReplace, r6.supportTextReplace) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.displayExtra, r6.displayExtra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getTrackerTabType() {
        return null;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.starlingKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.supportTextReplace;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        DisplayExtraKmp r13 = this.displayExtra;
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
        return "TabItemInfoKmp(id=" + this.id + ", starlingKey=" + this.starlingKey + ", name=" + this.name + ", supportTextReplace=" + this.supportTextReplace + ", displayExtra=" + this.displayExtra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.id);
        r4.writeString(this.starlingKey);
        r4.writeString(this.name);
        Boolean r0 = this.supportTextReplace;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        DisplayExtraKmp r1 = this.displayExtra;
        if (r1 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final DisplayExtraKmp getDisplayExtra() {
        return this.displayExtra;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStarlingKey() {
        return this.starlingKey;
    }

    public final Boolean getSupportTextReplace() {
        return this.supportTextReplace;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(TabItemInfoKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.id);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.starlingKey);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.name);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, i.a, r5.supportTextReplace);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        r0 = true;
    L44:
        if (r0 == false) goto L47;
        r6.encodeNullableSerializableElement(r7, 4, DisplayExtraKmp.a.a, r5.displayExtra);
        return;
    L47:
        return;
    L42:
        if (r5.displayExtra == null) goto L44;
    L33:
        if (r5.supportTextReplace != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.name != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.starlingKey != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.id != null) goto L4;
        r1 = false;
        goto L9
    }

    public TabItemInfoKmp(String r1, String r2, String r3, Boolean r4, DisplayExtraKmp r5) {
        this.id = r1;
        this.starlingKey = r2;
        this.name = r3;
        this.supportTextReplace = r4;
        this.displayExtra = r5;
    }

    public TabItemInfoKmp(int r2, String r3, String r4, String r5, Boolean r6, DisplayExtraKmp r7, q2 r8) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.id = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.starlingKey = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.name = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.supportTextReplace = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.displayExtra = null;
        return;
    L23:
        this.displayExtra = r7;
        return;
    L19:
        this.supportTextReplace = r6;
        goto L21
    L15:
        this.name = r5;
        goto L17
    L11:
        this.starlingKey = r4;
        goto L13
    L7:
        this.id = r3;
        goto L9
    }

    public /* synthetic */ TabItemInfoKmp(String r5, String r6, String r7, Boolean r8, DisplayExtraKmp r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        DisplayExtraKmp r13 = null;
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
