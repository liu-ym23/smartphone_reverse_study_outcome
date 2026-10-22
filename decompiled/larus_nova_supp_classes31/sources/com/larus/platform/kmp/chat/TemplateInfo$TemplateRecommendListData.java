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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u000223B'\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J.\u0010\u001d\u001a\u00020\u00002\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bJ%\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R.\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateRecommendListData;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "templateInfos", "", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTemplateInfos$annotations", "()V", "getTemplateInfos", "()Ljava/util/List;", "setTemplateInfos", "(Ljava/util/List;)V", "getHasMore$annotations", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateRecommendListData;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TemplateInfo$TemplateRecommendListData implements Parcelable {
    public static final Parcelable.Creator<TemplateInfo$TemplateRecommendListData> CREATOR = null;
    public static final b Companion = null;
    public static final Lazy<d<Object>>[] c = null;
    public final List<TemplateInfo$TemplateInfo> a;
    public final Boolean b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TemplateInfo$TemplateRecommendListData> {
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
            g2 r1 = new g2("com.larus.platform.kmp.chat.TemplateInfo.TemplateRecommendListData", r0, 2);
            r1.j("template_infos", true);
            r1.j("has_more", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d((d) TemplateInfo$TemplateRecommendListData.c[0].getValue()), kuc.a.d(i.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            Lazy<d<Object>>[] r1 = TemplateInfo$TemplateRecommendListData.c;
            List r5 = null;
            if (r12.decodeSequentially() == false) goto L5;
            List r2 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            Boolean r3 = (Boolean) r12.decodeNullableSerializableElement(r0, 1, i.a, null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new TemplateInfo$TemplateRecommendListData(r4, r2, r3);
        L5:
            Boolean r6 = null;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r12.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r5 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r6 = (Boolean) r12.decodeNullableSerializableElement(r0, 1, i.a, r6);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r2 = r5;
            r3 = r6;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            TemplateInfo$TemplateRecommendListData r8 = (TemplateInfo$TemplateRecommendListData) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<d<Object>>[] r1 = TemplateInfo$TemplateRecommendListData.c;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, (n) r1[0].getValue(), r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, i.a, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (Intrinsics.areEqual(r8.b, Boolean.FALSE) == true) goto L17;
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TemplateInfo$TemplateRecommendListData> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TemplateInfo$TemplateRecommendListData> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateRecommendListData createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            boolean r1 = false;
            Boolean r2 = null;
            if (r7.readInt() != 0) goto L5;
            ArrayList r3 = null;
        L13:
            if (r7.readInt() == 0) goto L20;
            if (r7.readInt() == 0) goto L18;
            r1 = true;
        L18:
            r2 = Boolean.valueOf(r1);
        L20:
            return new TemplateInfo$TemplateRecommendListData(r3, r2);
        L5:
            int r0 = r7.readInt();
            r3 = new ArrayList(r0);
            int r4 = 0;
        L6:
            if (r4 == r0) goto L13;
            if (r7.readInt() != 0) goto L10;
            TemplateInfo$TemplateInfo r5 = null;
        L11:
            r3.add(r5);
            r4 = r4 + 1;
            goto L6
        L10:
            r5 = TemplateInfo$TemplateInfo.CREATOR.createFromParcel(r7);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateRecommendListData[] newArray(int r1) {
            return new TemplateInfo$TemplateRecommendListData[r1];
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
        if ((r5 instanceof TemplateInfo$TemplateRecommendListData) == true) goto L8;
        return false;
    L8:
        TemplateInfo$TemplateRecommendListData r6 = (TemplateInfo$TemplateRecommendListData) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<TemplateInfo$TemplateInfo> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateRecommendListData(templateInfos=" + this.a + ", hasMore=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<TemplateInfo$TemplateInfo> r0 = this.a;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L12:
        Boolean r7 = this.b;
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
        c = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new eq9.b()), null};
    }

    public TemplateInfo$TemplateRecommendListData() {
        this(null, Boolean.FALSE);
    }

    public TemplateInfo$TemplateRecommendListData(List<TemplateInfo$TemplateInfo> r1, Boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public TemplateInfo$TemplateRecommendListData(int r3, List r4, Boolean r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = Boolean.FALSE;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
