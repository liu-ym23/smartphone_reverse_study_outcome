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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\nJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\nJ%\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006/"}, d2 = {"Lcom/larus/ugc/feed/api/model/AuthorInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "name", "", "uid", "avatarUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getUid$annotations", "getUid", "getAvatarUrl$annotations", "getAvatarUrl", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class AuthorInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<AuthorInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final String avatarUrl;
    private final String name;
    private final String uid;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AuthorInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.AuthorInfoKmp", r0, 3);
            r1.j("name", true);
            r1.j("uid", true);
            r1.j("avatar_url", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r17) {
            Intrinsics.checkNotNullParameter(r17, "decoder");
            g2 r1 = b;
            muc.c r0 = r17.beginStructure(r1);
            String r6 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r12 = r4;
            String r13 = r5;
            int r11 = 7;
        L19:
            r0.endStructure(r1);
            return new AuthorInfoKmp(r11, r12, r13, r14, null);
        L5:
            String r7 = null;
            String r8 = null;
            int r3 = 0;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L18;
            int r10 = r0.decodeElementIndex(r1);
            if (r10 != (-1)) goto L9;
            r9 = false;
            goto L6
        L9:
            if (r10 != 0) goto L10;
            r6 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r6);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L11;
            r7 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r7);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r10 != 2) goto L14;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r8);
            r3 = r3 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r10);
        L18:
            r11 = r3;
            r12 = r6;
            r13 = r7;
            r14 = r8;
            goto L19
        }

        public final void serialize(muc.f r2, Object r3) {
            AuthorInfoKmp r4 = (AuthorInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            AuthorInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AuthorInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<AuthorInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final AuthorInfoKmp createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new AuthorInfoKmp(r4.readString(), r4.readString(), r4.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AuthorInfoKmp[] newArray(int r1) {
            return new AuthorInfoKmp[r1];
        }
    }

    public AuthorInfoKmp() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AuthorInfoKmp copy$default(AuthorInfoKmp r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.uid;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.avatarUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @SerialName("avatar_url")
    public static /* synthetic */ void getAvatarUrl$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("uid")
    public static /* synthetic */ void getUid$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.avatarUrl;
    }

    public final AuthorInfoKmp copy(String r2, String r3, String r4) {
        return new AuthorInfoKmp(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AuthorInfoKmp) == true) goto L8;
        return false;
    L8:
        AuthorInfoKmp r6 = (AuthorInfoKmp) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uid, r6.uid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarUrl, r6.avatarUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.uid;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.avatarUrl;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AuthorInfoKmp(name=" + this.name + ", uid=" + this.uid + ", avatarUrl=" + this.avatarUrl + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.name);
        r1.writeString(this.uid);
        r1.writeString(this.avatarUrl);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUid() {
        return this.uid;
    }

    public AuthorInfoKmp(String r1, String r2, String r3) {
        this.name = r1;
        this.uid = r2;
        this.avatarUrl = r3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(AuthorInfoKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.name);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.uid);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        r0 = true;
    L26:
        if (r0 == false) goto L29;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.avatarUrl);
        return;
    L29:
        return;
    L24:
        if (Intrinsics.areEqual(r5.avatarUrl, "") == true) goto L26;
    L15:
        if (Intrinsics.areEqual(r5.uid, "") == false) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.name != null) goto L4;
        r1 = false;
        goto L9
    }

    public AuthorInfoKmp(int r2, String r3, String r4, String r5, q2 r6) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.name = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.uid = "";
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.avatarUrl = "";
        return;
    L15:
        this.avatarUrl = r5;
        return;
    L11:
        this.uid = r4;
        goto L13
    L7:
        this.name = r3;
        goto L9
    }

    public /* synthetic */ AuthorInfoKmp(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
