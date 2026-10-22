package com.larus.platform.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00060\u0001j\u0002`\u0002:\u000212B3\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J:\u0010\u001c\u001a\u00020\u00002\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0007J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007J%\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R&\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0015¨\u00063"}, d2 = {"Lcom/larus/platform/api/BatchUpdateUserCreationRequest;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "creationIdList", "", "", "status", "", "privateStatus", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationIdList$annotations", "()V", "getCreationIdList", "()Ljava/util/List;", "getStatus$annotations", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrivateStatus$annotations", "getPrivateStatus", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/api/BatchUpdateUserCreationRequest;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class BatchUpdateUserCreationRequest implements Parcelable {
    public static final Parcelable.Creator<BatchUpdateUserCreationRequest> CREATOR = null;
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final List<String> a;
    public final Integer b;
    public final Integer c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<BatchUpdateUserCreationRequest> {
        public static final a a = null;
        public static final nuc.g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            nuc.g2 r1 = new nuc.g2("com.larus.platform.api.BatchUpdateUserCreationRequest", r0, 3);
            r1.j("creation_id_list", true);
            r1.j("status", true);
            r1.j("private_status", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            nuc.w0 r0 = nuc.w0.a;
            return new juc.d[]{kuc.a.d((juc.d) BatchUpdateUserCreationRequest.d[0].getValue()), kuc.a.d(r0), kuc.a.d(r0)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            nuc.g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = BatchUpdateUserCreationRequest.d;
            List r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            List r2 = (List) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            nuc.w0 r3 = nuc.w0.a;
            Integer r4 = (Integer) r14.decodeNullableSerializableElement(r0, 1, r3, null);
            Integer r5 = (Integer) r14.decodeNullableSerializableElement(r0, 2, r3, null);
            int r7 = 7;
        L19:
            r14.endStructure(r0);
            return new BatchUpdateUserCreationRequest(r7, r2, r4, r5);
        L5:
            Integer r8 = null;
            Integer r9 = null;
            int r10 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L18;
            int r12 = r14.decodeElementIndex(r0);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r6 = (List) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r6);
            r10 = r10 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (Integer) r14.decodeNullableSerializableElement(r0, 1, nuc.w0.a, r8);
            r10 = r10 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L14;
            r9 = (Integer) r14.decodeNullableSerializableElement(r0, 2, nuc.w0.a, r9);
            r10 = r10 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r12);
        L18:
            r7 = r10;
            r2 = r6;
            r4 = r8;
            r5 = r9;
            goto L19
        }

        public final void serialize(muc.f r6, Object r7) {
            BatchUpdateUserCreationRequest r8 = (BatchUpdateUserCreationRequest) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            nuc.g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = BatchUpdateUserCreationRequest.d;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r9.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r9.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r8.c);
        L28:
            r9.endStructure(r0);
            return;
        L24:
            if (r8.c == null) goto L26;
        L15:
            if (r8.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<BatchUpdateUserCreationRequest> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<BatchUpdateUserCreationRequest> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final BatchUpdateUserCreationRequest createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            ArrayList<String> r1 = r6.createStringArrayList();
            Integer r3 = null;
            if (r6.readInt() != 0) goto L5;
            Integer r2 = null;
        L7:
            if (r6.readInt() == 0) goto L11;
            r3 = Integer.valueOf(r6.readInt());
        L11:
            return new BatchUpdateUserCreationRequest(r1, r2, r3);
        L5:
            r2 = Integer.valueOf(r6.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BatchUpdateUserCreationRequest[] newArray(int r1) {
            return new BatchUpdateUserCreationRequest[r1];
        }
    }

    public BatchUpdateUserCreationRequest() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BatchUpdateUserCreationRequest) == true) goto L8;
        return false;
    L8:
        BatchUpdateUserCreationRequest r6 = (BatchUpdateUserCreationRequest) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.a;
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

    public final String toString() {
        return "BatchUpdateUserCreationRequest(creationIdList=" + this.a + ", status=" + this.b + ", privateStatus=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeStringList(this.a);
        Integer r5 = this.b;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.c;
        if (r6 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
        d = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new h()), null, null};
    }

    public BatchUpdateUserCreationRequest(List<String> r1, Integer r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public BatchUpdateUserCreationRequest(int r3, List r4, Integer r5, Integer r6) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = null;
        return;
    L15:
        this.c = r6;
        return;
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
