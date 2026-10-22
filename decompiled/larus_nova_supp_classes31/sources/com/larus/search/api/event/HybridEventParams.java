package com.larus.search.api.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u0004\u0018\u00010#J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÂ\u0003Jp\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020/J\u0013\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020/HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0016\u00105\u001a\u00020!2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/search/api/event/HybridEventParams;", "Landroid/os/Parcelable;", "enterMethod", "", "localPage", "chatType", "duration", "", "isRichMediaPictureLink", "", "mobMap", "", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;)V", "getEnterMethod", "()Ljava/lang/String;", "getLocalPage", "getChatType", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setRichMediaPictureLink", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMobMap", "()Ljava/util/Map;", "setMobMap", "(Ljava/util/Map;)V", "addExtraParams", "", "jsonObject", "Lorg/json/JSONObject;", "getExtraParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/String;)Lcom/larus/search/api/event/HybridEventParams;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class HybridEventParams implements Parcelable {
    public static final Parcelable.Creator<HybridEventParams> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public Long d;
    public Boolean e;
    public Map<String, String> f;
    public String g;

    public static final class a implements Parcelable.Creator<HybridEventParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HybridEventParams createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r2 = r11.readString();
            String r3 = r11.readString();
            String r4 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Long r5 = null;
        L6:
            int r6 = 0;
            if (r11.readInt() != 0) goto L10;
            Boolean r0 = null;
        L15:
            if (r11.readInt() != 0) goto L17;
            LinkedHashMap r7 = null;
        L21:
            return new HybridEventParams(r2, r3, r4, r5, r0, r7, r11.readString());
        L17:
            int r1 = r11.readInt();
            r7 = new LinkedHashMap(r1);
        L18:
            if (r6 == r1) goto L21;
            r7.put(r11.readString(), r11.readString());
            r6 = r6 + 1;
            goto L18
        L10:
            if (r11.readInt() == 0) goto L12;
            boolean r8 = true;
        L13:
            r0 = Boolean.valueOf(r8);
            goto L15
        L12:
            r8 = false;
            goto L13
        L5:
            r5 = Long.valueOf(r11.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final HybridEventParams[] newArray(int r1) {
            return new HybridEventParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public HybridEventParams() {
        this(null, null, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HybridEventParams) == true) goto L8;
        return false;
    L8:
        HybridEventParams r6 = (HybridEventParams) r5;
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
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.f;
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
        return "HybridEventParams(enterMethod=" + this.a + ", localPage=" + this.b + ", chatType=" + this.c + ", duration=" + this.d + ", isRichMediaPictureLink=" + this.e + ", mobMap=" + this.f + ", extra=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.a);
        r5.writeString(this.b);
        r5.writeString(this.c);
        Long r7 = this.d;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Boolean r8 = this.e;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Map<String, String> r9 = this.f;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L17:
        r5.writeString(this.g);
        return;
    L13:
        r5.writeInt(1);
        r5.writeInt(r9.size());
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Map.Entry<String, String> r0 = r10.next();
        r5.writeString(r0.getKey());
        r5.writeString(r0.getValue());
        goto L15
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        if (this.g != null) goto L18;
        this.g = r5.toString();
        return;
    L18:
        String r1 = this.g;     // Catch: JSONException -> L11
        if (r1 != null) goto L9;
        r1 = "{}";
    L9:
        JSONObject r0 = new JSONObject(r1);     // Catch: JSONException -> L11
    L12:
        Iterator<String> r2 = r5.keys();
    L14:
        if (r2.hasNext() == false) goto L16;
        String r3 = r2.next();
        r0.put(r3, r5.get(r3));
        goto L14
    L16:
        this.g = r0.toString();
        return;
    L11:
        r0 = new JSONObject();
        goto L12
    }

    public /* synthetic */ HybridEventParams(String r11, String r12, String r13, Map r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        Long r6 = 0L;
    L19:
        if ((r15 & 16) == 0) goto L21;
        Boolean r7 = Boolean.FALSE;
    L23:
        if ((r15 & 32) == 0) goto L25;
        Map r8 = null;
    L26:
        this(r3, r4, r5, r6, r7, r8, null);
        return;
    L25:
        r8 = r14;
        goto L26
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public HybridEventParams(String r1, String r2, String r3, Long r4, Boolean r5, Map<String, String> r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
