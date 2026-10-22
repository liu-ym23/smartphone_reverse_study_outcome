package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationInfo extends Message<LocationInfo, a> {
    public static final ProtoAdapter<LocationInfo> ADAPTER = null;
    public static final String DEFAULT_ADDRESSLINE = "";
    public static final String DEFAULT_ADMINISTRATIVEAREA = "";
    public static final String DEFAULT_CITY = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_COUNTRYCODE = "";
    public static final String DEFAULT_DISTRICT = "";
    public static final Double DEFAULT_LATITUDE = null;
    public static final String DEFAULT_LOCALITY = "";
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_STREET = "";
    public static final String DEFAULT_SUBADMINISTRATIVEAREA = "";
    public static final String DEFAULT_SUBLOCALITY = "";
    public static final String DEFAULT_TOWN = "";
    private static final long serialVersionUID = 0;

    @SerializedName("addressLine")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String addressLine;

    @SerializedName("administrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String administrativeArea;

    @SerializedName("city")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String city;

    @SerializedName("country")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String country;

    @SerializedName("countryCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String countryCode;

    @SerializedName("district")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String district;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("locality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String locality;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    @SerializedName("street")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String street;

    @SerializedName("subAdministrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String subAdministrativeArea;

    @SerializedName("subLocality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String subLocality;

    @SerializedName("town")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String town;

    public static final class a extends Message.Builder<LocationInfo, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f8176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f8177b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;

        public a() {
            Double r0 = Double.valueOf(0.0d);
            this.f8176a = r0;
            this.f8177b = r0;
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
            this.j = "";
            this.k = "";
            this.l = "";
            this.m = "";
        }

        public a a(Double r1) {
            this.f8176a = r1;
            return this;
        }

        public a a(String r1) {
            this.c = r1;
            return this;
        }

        public LocationInfo a() {
            return new LocationInfo(this.f8176a, this.f8177b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, super.buildUnknownFields());
        }

        public a b(Double r1) {
            this.f8177b = r1;
            return this;
        }

        public a b(String r1) {
            this.d = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.e = r1;
            return this;
        }

        public a d(String r1) {
            this.f = r1;
            return this;
        }

        public a e(String r1) {
            this.g = r1;
            return this;
        }

        public a f(String r1) {
            this.h = r1;
            return this;
        }

        public a g(String r1) {
            this.i = r1;
            return this;
        }

        public a h(String r1) {
            this.j = r1;
            return this;
        }

        public a i(String r1) {
            this.k = r1;
            return this;
        }

        public a j(String r1) {
            this.l = r1;
            return this;
        }

        public a k(String r1) {
            this.m = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<LocationInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        public int a(LocationInfo r4) {
            return ((((((((((((ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r4.longitude) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.latitude)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.country)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r4.countryCode)) + ProtoAdapter.STRING.encodedSizeWithTag(5, r4.administrativeArea)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r4.city)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r4.district)) + ProtoAdapter.STRING.encodedSizeWithTag(8, r4.town)) + ProtoAdapter.STRING.encodedSizeWithTag(9, r4.street)) + ProtoAdapter.STRING.encodedSizeWithTag(10, r4.subAdministrativeArea)) + ProtoAdapter.STRING.encodedSizeWithTag(11, r4.locality)) + ProtoAdapter.STRING.encodedSizeWithTag(12, r4.subLocality)) + ProtoAdapter.STRING.encodedSizeWithTag(13, r4.addressLine)) + r4.unknownFields().size();
        }

        public LocationInfo a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L21;
            switch(r2) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r5.k((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r5.j((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r5.i((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r5.h((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r5.g((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r5.f((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r5.e((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r5.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r5.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L17:
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L18:
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L19:
            r5.b((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L20:
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L21:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, LocationInfo r4) {
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 1, r4.longitude);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.latitude);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.country);
            ProtoAdapter.STRING.encodeWithTag(r3, 4, r4.countryCode);
            ProtoAdapter.STRING.encodeWithTag(r3, 5, r4.administrativeArea);
            ProtoAdapter.STRING.encodeWithTag(r3, 6, r4.city);
            ProtoAdapter.STRING.encodeWithTag(r3, 7, r4.district);
            ProtoAdapter.STRING.encodeWithTag(r3, 8, r4.town);
            ProtoAdapter.STRING.encodeWithTag(r3, 9, r4.street);
            ProtoAdapter.STRING.encodeWithTag(r3, 10, r4.subAdministrativeArea);
            ProtoAdapter.STRING.encodeWithTag(r3, 11, r4.locality);
            ProtoAdapter.STRING.encodeWithTag(r3, 12, r4.subLocality);
            ProtoAdapter.STRING.encodeWithTag(r3, 13, r4.addressLine);
            r3.writeBytes(r4.unknownFields());
        }

        public LocationInfo b(LocationInfo r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ LocationInfo decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, LocationInfo r4) {
            a(r3, (LocationInfo) ZeusTransformUtils.preCheckCast(r4, LocationInfo.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(LocationInfo r3) {
            return a((LocationInfo) ZeusTransformUtils.preCheckCast(r3, LocationInfo.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ LocationInfo redact(LocationInfo r3) {
            return b((LocationInfo) ZeusTransformUtils.preCheckCast(r3, LocationInfo.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public LocationInfo(Double r16, Double r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public LocationInfo(Double r2, Double r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, ByteString r15) {
        super(ADAPTER, r15);
        this.longitude = r2;
        this.latitude = r3;
        this.country = r4;
        this.countryCode = r5;
        this.administrativeArea = r6;
        this.city = r7;
        this.district = r8;
        this.town = r9;
        this.street = r10;
        this.subAdministrativeArea = r11;
        this.locality = r12;
        this.subLocality = r13;
        this.addressLine = r14;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LocationInfo.class) == true) goto L8;
        return false;
    L8:
        LocationInfo r6 = (LocationInfo) ZeusTransformUtils.preCheckCast(r5, LocationInfo.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L38;
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L38;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L38;
        if (Internal.equals(this.country, r6.country) == false) goto L38;
        if (Internal.equals(this.countryCode, r6.countryCode) == false) goto L38;
        if (Internal.equals(this.administrativeArea, r6.administrativeArea) == false) goto L38;
        if (Internal.equals(this.city, r6.city) == false) goto L38;
        if (Internal.equals(this.district, r6.district) == false) goto L38;
        if (Internal.equals(this.town, r6.town) == false) goto L38;
        if (Internal.equals(this.street, r6.street) == false) goto L38;
        if (Internal.equals(this.subAdministrativeArea, r6.subAdministrativeArea) == false) goto L38;
        if (Internal.equals(this.locality, r6.locality) == false) goto L38;
        if (Internal.equals(this.subLocality, r6.subLocality) == false) goto L38;
        if (Internal.equals(this.addressLine, r6.addressLine) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L57;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.longitude;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.latitude;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.country;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.countryCode;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.administrativeArea;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.city;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.district;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.town;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.street;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.subAdministrativeArea;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.locality;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        String r36 = this.subLocality;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        String r39 = this.addressLine;
        if (r39 == null) goto L55;
        r3 = r39.hashCode();
    L55:
        int r40 = r38 + r3;
        this.hashCode = r40;
        return r40;
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L57:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8176a = this.longitude;
        r0.f8177b = this.latitude;
        r0.c = this.country;
        r0.d = this.countryCode;
        r0.e = this.administrativeArea;
        r0.f = this.city;
        r0.g = this.district;
        r0.h = this.town;
        r0.i = this.street;
        r0.j = this.subAdministrativeArea;
        r0.k = this.locality;
        r0.l = this.subLocality;
        r0.m = this.addressLine;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r0.append(", longitude=").append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r0.append(", latitude=").append(this.latitude);
    L9:
        if (this.country == null) goto L12;
        r0.append(", country=").append(this.country);
    L12:
        if (this.countryCode == null) goto L15;
        r0.append(", countryCode=").append(this.countryCode);
    L15:
        if (this.administrativeArea == null) goto L18;
        r0.append(", administrativeArea=").append(this.administrativeArea);
    L18:
        if (this.city == null) goto L21;
        r0.append(", city=").append(this.city);
    L21:
        if (this.district == null) goto L24;
        r0.append(", district=").append(this.district);
    L24:
        if (this.town == null) goto L27;
        r0.append(", town=").append(this.town);
    L27:
        if (this.street == null) goto L30;
        r0.append(", street=").append(this.street);
    L30:
        if (this.subAdministrativeArea == null) goto L33;
        r0.append(", subAdministrativeArea=").append(this.subAdministrativeArea);
    L33:
        if (this.locality == null) goto L36;
        r0.append(", locality=").append(this.locality);
    L36:
        if (this.subLocality == null) goto L39;
        r0.append(", subLocality=").append(this.subLocality);
    L39:
        if (this.addressLine == null) goto L42;
        r0.append(", addressLine=").append(this.addressLine);
    L42:
        return r0.replace(0, 2, "LocationInfo{").append('}').toString();
    }
}
