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
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00060\u0001j\u0002`\u0002:\u0002@AB[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0006J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0004HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006J%\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015¨\u0006B"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "logId", "", "pageIndex", "", "position", "tabId", "tabName", "tabType", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLogId$annotations", "()V", "getLogId", "()Ljava/lang/String;", "getPageIndex$annotations", "getPageIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosition$annotations", "getPosition", "getTabId$annotations", "getTabId", "getTabName$annotations", "getTabName", "getTabType$annotations", "getTabType", "getBotId$annotations", "getBotId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/ugc/feed/api/model/UserCreationTrackParamsKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationTrackParamsKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationTrackParamsKmp> CREATOR = null;
    public static final b Companion = null;
    private final String botId;
    private final String logId;
    private final Integer pageIndex;
    private final Integer position;
    private final String tabId;
    private final String tabName;
    private final String tabType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationTrackParamsKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationTrackParamsKmp", r0, 7);
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

        public final Object deserialize(e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
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
            int r18 = 127;
        L23:
            r0.endStructure(r1);
            return new UserCreationTrackParamsKmp(r18, r10, r13, r12, r17, r14, r15, r16, null);
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
            r18 = r21;
            r16 = r110;
            r12 = r111;
            r17 = r113;
            r15 = r112;
            r14 = r20;
            goto L23
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationTrackParamsKmp r4 = (UserCreationTrackParamsKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationTrackParamsKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationTrackParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationTrackParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationTrackParamsKmp createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r4 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Integer r5 = null;
        L11:
            return new UserCreationTrackParamsKmp(r2, r4, r5, r10.readString(), r10.readString(), r10.readString(), r10.readString());
        L9:
            r5 = Integer.valueOf(r10.readInt());
            goto L11
        L5:
            r4 = Integer.valueOf(r10.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationTrackParamsKmp[] newArray(int r1) {
            return new UserCreationTrackParamsKmp[r1];
        }
    }

    public UserCreationTrackParamsKmp() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ UserCreationTrackParamsKmp copy$default(UserCreationTrackParamsKmp r5, String r6, Integer r7, Integer r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.logId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.pageIndex;
    L8:
        Integer r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.position;
    L11:
        Integer r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.tabId;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.tabName;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.tabType;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.botId;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("log_id")
    public static /* synthetic */ void getLogId$annotations() {
    }

    @SerialName("page_index")
    public static /* synthetic */ void getPageIndex$annotations() {
    }

    @SerialName("position")
    public static /* synthetic */ void getPosition$annotations() {
    }

    @SerialName("tab_id")
    public static /* synthetic */ void getTabId$annotations() {
    }

    @SerialName("tab_name")
    public static /* synthetic */ void getTabName$annotations() {
    }

    @SerialName("tab_type")
    public static /* synthetic */ void getTabType$annotations() {
    }

    public final String component1() {
        return this.logId;
    }

    public final Integer component2() {
        return this.pageIndex;
    }

    public final Integer component3() {
        return this.position;
    }

    public final String component4() {
        return this.tabId;
    }

    public final String component5() {
        return this.tabName;
    }

    public final String component6() {
        return this.tabType;
    }

    public final String component7() {
        return this.botId;
    }

    public final UserCreationTrackParamsKmp copy(String r10, Integer r11, Integer r12, String r13, String r14, String r15, String r16) {
        return new UserCreationTrackParamsKmp(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationTrackParamsKmp) == true) goto L8;
        return false;
    L8:
        UserCreationTrackParamsKmp r6 = (UserCreationTrackParamsKmp) r5;
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageIndex, r6.pageIndex) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabId, r6.tabId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabName, r6.tabName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tabType, r6.tabType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.logId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.pageIndex;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.position;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.tabId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.tabName;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.tabType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.botId;
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

    public String toString() {
        return "UserCreationTrackParamsKmp(logId=" + this.logId + ", pageIndex=" + this.pageIndex + ", position=" + this.position + ", tabId=" + this.tabId + ", tabName=" + this.tabName + ", tabType=" + this.tabType + ", botId=" + this.botId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.logId);
        Integer r5 = this.pageIndex;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.position;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.tabId);
        r3.writeString(this.tabName);
        r3.writeString(this.tabType);
        r3.writeString(this.botId);
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

    public final String getBotId() {
        return this.botId;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final Integer getPageIndex() {
        return this.pageIndex;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabType() {
        return this.tabType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationTrackParamsKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.logId);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, w0.a, r5.pageIndex);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, w0.a, r5.position);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, v2.a, r5.tabId);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.tabName);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        boolean r9 = true;
    L54:
        if (r9 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 5, v2.a, r5.tabType);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L60;
    L58:
        r0 = true;
    L62:
        if (r0 == false) goto L65;
        r6.encodeNullableSerializableElement(r7, 6, v2.a, r5.botId);
        return;
    L65:
        return;
    L60:
        if (r5.botId == null) goto L62;
    L51:
        if (r5.tabType != null) goto L49;
        r9 = false;
        goto L54
    L42:
        if (r5.tabName != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.tabId != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.position != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.pageIndex != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r5.logId, "") == false) goto L4;
        r1 = false;
        goto L9
    }

    public UserCreationTrackParamsKmp(String r1, Integer r2, Integer r3, String r4, String r5, String r6, String r7) {
        this.logId = r1;
        this.pageIndex = r2;
        this.position = r3;
        this.tabId = r4;
        this.tabName = r5;
        this.tabType = r6;
        this.botId = r7;
    }

    public UserCreationTrackParamsKmp(int r2, String r3, Integer r4, Integer r5, String r6, String r7, String r8, String r9, q2 r10) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = "";
    L7:
        this.logId = r3;
        if ((r2 & 2) != 0) goto L10;
        this.pageIndex = null;
    L12:
        if ((r2 & 4) != 0) goto L14;
        this.position = null;
    L16:
        if ((r2 & 8) != 0) goto L18;
        this.tabId = null;
    L20:
        if ((r2 & 16) != 0) goto L22;
        this.tabName = null;
    L24:
        if ((r2 & 32) != 0) goto L26;
        this.tabType = null;
    L28:
        if ((r2 & 64) != 0) goto L30;
        this.botId = null;
        return;
    L30:
        this.botId = r9;
        return;
    L26:
        this.tabType = r8;
        goto L28
    L22:
        this.tabName = r7;
        goto L24
    L18:
        this.tabId = r6;
        goto L20
    L14:
        this.position = r5;
        goto L16
    L10:
        this.pageIndex = r4;
        goto L12
    }

    public /* synthetic */ UserCreationTrackParamsKmp(String r6, Integer r7, Integer r8, String r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r6 = "";
    L5:
        String r0 = null;
        if ((r13 & 2) == 0) goto L8;
        Integer r15 = null;
    L10:
        if ((r13 & 4) == 0) goto L12;
        Integer r1 = null;
    L14:
        if ((r13 & 8) == 0) goto L16;
        String r2 = null;
    L18:
        if ((r13 & 16) == 0) goto L20;
        String r3 = null;
    L22:
        if ((r13 & 32) == 0) goto L24;
        String r4 = null;
    L26:
        if ((r13 & 64) != 0) goto L29;
        r0 = r12;
    L29:
        this(r6, r15, r1, r2, r3, r4, r0);
        return;
    L24:
        r4 = r11;
        goto L26
    L20:
        r3 = r10;
        goto L22
    L16:
        r2 = r9;
        goto L18
    L12:
        r1 = r8;
        goto L14
    L8:
        r15 = r7;
        goto L10
    }
}
