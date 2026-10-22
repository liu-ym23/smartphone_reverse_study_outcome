package com.larus.platform.kmp.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import juc.d;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00060\u0001j\u0002`\u0002:\u0002>?B;\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!JB\u0010)\u001a\u00020\u00002\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u0007J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0007J%\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R.\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR(\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010$\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006@"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateRecommendRelatedData;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "templateInfos", "", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "offset", "", "size", "hasMore", "", "<init>", "(Ljava/util/List;IILjava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;IILjava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTemplateInfos$annotations", "()V", "getTemplateInfos", "()Ljava/util/List;", "setTemplateInfos", "(Ljava/util/List;)V", "getOffset$annotations", "getOffset", "()I", "setOffset", "(I)V", "getSize$annotations", "getSize", "setSize", "getHasMore$annotations", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;IILjava/lang/Boolean;)Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateRecommendRelatedData;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TemplateInfo$TemplateRecommendRelatedData implements Parcelable {
    public static final Parcelable.Creator<TemplateInfo$TemplateRecommendRelatedData> CREATOR = null;
    public static final b Companion = null;
    public static final Lazy<d<Object>>[] e = null;
    public final List<TemplateInfo$TemplateInfo> a;
    public final int b;
    public final int c;
    public final Boolean d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TemplateInfo$TemplateRecommendRelatedData> {
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
            g2 r1 = new g2("com.larus.platform.kmp.chat.TemplateInfo.TemplateRecommendRelatedData", r0, 4);
            r1.j("template_infos", true);
            r1.j("offset", true);
            r1.j("size", true);
            r1.j("has_more", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            w0 r0 = w0.a;
            return new d[]{kuc.a.d((d) TemplateInfo$TemplateRecommendRelatedData.e[0].getValue()), r0, r0, kuc.a.d(i.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            Lazy<d<Object>>[] r2 = TemplateInfo$TemplateRecommendRelatedData.e;
            if (r0.decodeSequentially() == false) goto L5;
            List r3 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            int r4 = r0.decodeIntElement(r1, 1);
            List r15 = r3;
            int r16 = r4;
            int r17 = r0.decodeIntElement(r1, 2);
            Boolean r18 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, i.a, null);
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new TemplateInfo$TemplateRecommendRelatedData(r14, r15, r16, r17, r18);
        L5:
            List r10 = null;
            Boolean r11 = null;
            int r5 = 0;
            int r8 = 0;
            int r9 = 0;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L20;
            int r13 = r0.decodeElementIndex(r1);
            if (r13 != (-1)) goto L9;
            r12 = false;
            goto L6
        L9:
            if (r13 != 0) goto L10;
            r10 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r10);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r5 = r0.decodeIntElement(r1, 1);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r8 = r0.decodeIntElement(r1, 2);
            r9 = r9 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, i.a, r11);
            r9 = r9 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r13);
        L20:
            r16 = r5;
            r17 = r8;
            r14 = r9;
            r15 = r10;
            r18 = r11;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            TemplateInfo$TemplateRecommendRelatedData r9 = (TemplateInfo$TemplateRecommendRelatedData) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<d<Object>>[] r1 = TemplateInfo$TemplateRecommendRelatedData.e;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, (n) r1[0].getValue(), r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeIntElement(r0, 1, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeIntElement(r0, 2, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r10.encodeNullableSerializableElement(r0, 3, i.a, r9.d);
        L37:
            r10.endStructure(r0);
            return;
        L33:
            if (Intrinsics.areEqual(r9.d, Boolean.FALSE) == true) goto L35;
        L24:
            if (r9.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TemplateInfo$TemplateRecommendRelatedData> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TemplateInfo$TemplateRecommendRelatedData> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateRecommendRelatedData createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            boolean r1 = false;
            Boolean r2 = null;
            if (r7.readInt() != 0) goto L5;
            ArrayList r3 = null;
        L12:
            int r0 = r7.readInt();
            int r4 = r7.readInt();
            if (r7.readInt() == 0) goto L20;
            if (r7.readInt() == 0) goto L18;
            r1 = true;
        L18:
            r2 = Boolean.valueOf(r1);
        L20:
            return new TemplateInfo$TemplateRecommendRelatedData(r3, r0, r4, r2);
        L5:
            int r5 = r7.readInt();
            r3 = new ArrayList(r5);
            int r6 = 0;
        L6:
            if (r6 == r5) goto L12;
            if (r7.readInt() != 0) goto L10;
            TemplateInfo$TemplateInfo r8 = null;
        L11:
            r3.add(r8);
            r6 = r6 + 1;
            goto L6
        L10:
            r8 = TemplateInfo$TemplateInfo.CREATOR.createFromParcel(r7);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateRecommendRelatedData[] newArray(int r1) {
            return new TemplateInfo$TemplateRecommendRelatedData[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TemplateInfo$TemplateRecommendRelatedData) == true) goto L8;
        return false;
    L8:
        TemplateInfo$TemplateRecommendRelatedData r6 = (TemplateInfo$TemplateRecommendRelatedData) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<TemplateInfo$TemplateInfo> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        Boolean r4 = this.d;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateRecommendRelatedData(templateInfos=" + this.a + ", offset=" + this.b + ", size=" + this.c + ", hasMore=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<TemplateInfo$TemplateInfo> r0 = this.a;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L12:
        r5.writeInt(this.b);
        r5.writeInt(this.c);
        Boolean r7 = this.d;
        if (r7 != null) goto L15;
        r5.writeInt(0);
        return;
    L15:
        r5.writeInt(1);
        r5.writeInt(r7.booleanValue() ? 1 : 0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<TemplateInfo$TemplateInfo> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        TemplateInfo$TemplateInfo r3 = r1.next();
        if (r3 == null) goto L10;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L7
    L10:
        r5.writeInt(0);
        goto L7
    }

    static {
        Companion = new b();
        CREATOR = new c();
        e = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new eq9.c()), null, null, null};
    }

    public TemplateInfo$TemplateRecommendRelatedData() {
        this(null, 0, 0, Boolean.FALSE);
    }

    public TemplateInfo$TemplateRecommendRelatedData(List<TemplateInfo$TemplateInfo> r1, int r2, int r3, Boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public TemplateInfo$TemplateRecommendRelatedData(int r4, List r5, int r6, int r7, Boolean r8) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = Boolean.FALSE;
        return;
    L19:
        this.d = r8;
        return;
    L15:
        this.c = r7;
        goto L17
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
