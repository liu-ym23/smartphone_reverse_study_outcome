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
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJB[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jb\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u0006J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0006HÖ\u0001J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0006J%\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001d\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001d\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R&\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017¨\u0006K"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationTrackParams;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "logId", "", "pageIndex", "", "position", "tabId", "tabName", "tabType", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLogId$annotations", "()V", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "getPageIndex$annotations", "getPageIndex", "()Ljava/lang/Integer;", "setPageIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPosition$annotations", "getPosition", "setPosition", "getTabId$annotations", "getTabId", "setTabId", "getTabName$annotations", "getTabName", "setTabName", "getTabType$annotations", "getTabType", "setTabType", "getBotId$annotations", "getBotId", "setBotId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/api/creation/UserCreationTrackParams;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationTrackParams implements Parcelable {
    public static final Parcelable.Creator<UserCreationTrackParams> CREATOR = null;
    public static final b Companion = null;
    public String a;
    public Integer b;
    public Integer c;
    public String d;
    public String e;
    public String f;
    public String g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationTrackParams> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            w0 r2 = w0.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.UserCreationTrackParams", r0, 7);
            r1.j("log_id", true);
            r1.j("page_index", true);
            r1.j("position", true);
            r1.j("tab_id", true);
            r1.j("tab_name", true);
            r1.j("tab_type", true);
            r1.j("bot_id", true);
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
            String r10 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            w0 r11 = w0.a;
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r11, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 2, r11, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            Integer r12 = r4;
            String r14 = r5;
            r10 = r6;
            Integer r13 = r7;
            String r15 = r8;
            String r17 = r9;
            int r19 = 127;
        L23:
            r0.endStructure(r1);
            return new UserCreationTrackParams(r19, r10, r13, r12, r17, r14, r15, r16);
        L5:
            String r20 = null;
            r13 = null;
            String r110 = null;
            Integer r111 = null;
            String r112 = null;
            String r113 = null;
            int r21 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L22;
            int r22 = r0.decodeElementIndex(r1);
            switch(r22) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r22);
        L21:
            r3 = 2;
            r114 = false;
            goto L6
        L11:
            r110 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r110);
            r21 = r21 | 64;
        L20:
            r3 = 2;
            goto L6
        L12:
            r112 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r112);
            r21 = r21 | 32;
            goto L20
        L13:
            r20 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r20);
            r21 = r21 | 16;
            goto L20
        L14:
            r113 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r113);
            r21 = r21 | 8;
            goto L20
        L15:
            r111 = (Integer) r0.decodeNullableSerializableElement(r1, r3, w0.a, r111);
            r21 = r21 | 4;
            goto L20
        L17:
            r13 = (Integer) r0.decodeNullableSerializableElement(r1, 1, w0.a, r13);
            r21 = r21 | 2;
            goto L20
        L19:
            r21 = r21 | 1;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r10);
            goto L20
        L22:
            r19 = r21;
            r16 = r110;
            r12 = r111;
            r17 = r113;
            r15 = r112;
            r14 = r20;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            UserCreationTrackParams r9 = (UserCreationTrackParams) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = UserCreationTrackParams.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, w0.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, w0.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L64:
            r10.endStructure(r0);
            return;
        L60:
            if (r9.g == null) goto L62;
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
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
            if (Intrinsics.areEqual(r9.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationTrackParams> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationTrackParams> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationTrackParams createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r4 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Integer r5 = null;
        L11:
            return new UserCreationTrackParams(r2, r4, r5, r10.readString(), r10.readString(), r10.readString(), r10.readString());
        L9:
            r5 = Integer.valueOf(r10.readInt());
            goto L11
        L5:
            r4 = Integer.valueOf(r10.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationTrackParams[] newArray(int r1) {
            return new UserCreationTrackParams[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserCreationTrackParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationTrackParams) == true) goto L8;
        return false;
    L8:
        UserCreationTrackParams r6 = (UserCreationTrackParams) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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

    public final String toString() {
        return "UserCreationTrackParams(logId=" + this.a + ", pageIndex=" + this.b + ", position=" + this.c + ", tabId=" + this.d + ", tabName=" + this.e + ", tabType=" + this.f + ", botId=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        Integer r5 = this.b;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.c;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ UserCreationTrackParams(String r9, Integer r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r9 = "";
    L5:
        String r1 = r9;
        if ((r11 & 4) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, null, r10, null, null, null, null);
    }

    public UserCreationTrackParams(String r1, Integer r2, Integer r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public UserCreationTrackParams(int r3, String r4, Integer r5, Integer r6, String r7, String r8, String r9, String r10) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = "";
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = null;
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = null;
    L20:
        if ((r3 & 16) != 0) goto L22;
        this.e = null;
    L24:
        if ((r3 & 32) != 0) goto L26;
        this.f = null;
    L28:
        if ((r3 & 64) != 0) goto L30;
        this.g = null;
        return;
    L30:
        this.g = r10;
        return;
    L26:
        this.f = r9;
        goto L28
    L22:
        this.e = r8;
        goto L24
    L18:
        this.d = r7;
        goto L20
    L14:
        this.c = r6;
        goto L16
    L10:
        this.b = r5;
        goto L12
    }
}
