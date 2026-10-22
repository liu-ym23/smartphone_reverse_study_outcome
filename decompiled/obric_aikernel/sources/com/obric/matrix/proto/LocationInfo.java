package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    @c("addressLine")
    public final String addressLine;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @c("administrativeArea")
    public final String administrativeArea;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @c("city")
    public final String city;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @c("country")
    public final String country;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @c("countryCode")
    public final String countryCode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @c("district")
    public final String district;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    @c("latitude")
    public final Double latitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @c("locality")
    public final String locality;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    @c("longitude")
    public final Double longitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @c("street")
    public final String street;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @c("subAdministrativeArea")
    public final String subAdministrativeArea;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @c("subLocality")
    public final String subLocality;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @c("town")
    public final String town;

    public static final class a extends Message.Builder<LocationInfo, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f5965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f5966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f5968d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5969e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f5970f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f5971g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f5972h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f5973i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f5974j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f5975k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f5976l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f5977m;

        public a() {
            Double r10 = Double.valueOf(0.0d);
            this.f5965a = r10;
            this.f5966b = r10;
            this.f5967c = "";
            this.f5968d = "";
            this.f5969e = "";
            this.f5970f = "";
            this.f5971g = "";
            this.f5972h = "";
            this.f5973i = "";
            this.f5974j = "";
            this.f5975k = "";
            this.f5976l = "";
            this.f5977m = "";
        }

        public a a(String r10) {
            this.f5977m = r10;
            return this;
        }

        public a b(String r10) {
            this.f5969e = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public LocationInfo c() {
            return new LocationInfo(this.f5965a, this.f5966b, this.f5967c, this.f5968d, this.f5969e, this.f5970f, this.f5971g, this.f5972h, this.f5973i, this.f5974j, this.f5975k, this.f5976l, this.f5977m, super.buildUnknownFields());
        }

        public a d(String r10) {
            this.f5970f = r10;
            return this;
        }

        public a e(String r10) {
            this.f5967c = r10;
            return this;
        }

        public a f(String r10) {
            this.f5968d = r10;
            return this;
        }

        public a g(String r10) {
            this.f5971g = r10;
            return this;
        }

        public a h(Double r10) {
            this.f5966b = r10;
            return this;
        }

        public a i(String r10) {
            this.f5975k = r10;
            return this;
        }

        public a j(Double r10) {
            this.f5965a = r10;
            return this;
        }

        public a k(String r10) {
            this.f5973i = r10;
            return this;
        }

        public a l(String r10) {
            this.f5974j = r10;
            return this;
        }

        public a m(String r10) {
            this.f5976l = r10;
            return this;
        }

        public a n(String r10) {
            this.f5972h = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<LocationInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        public LocationInfo a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L20;
            switch(r13) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            r11.m(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            r11.i(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            r11.l(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            r11.k(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r11.n(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r11.g(ProtoAdapter.STRING.decode(r10));
            goto L3
        L14:
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L15:
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L16:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L17:
            r11.e(ProtoAdapter.STRING.decode(r10));
            goto L3
        L18:
            r11.h(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L19:
            r11.j(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L20:
            r10.endMessage(r12);
            return r11.c();
        }

        public void b(ProtoWriter r10, LocationInfo r11) {
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.encodeWithTag(r10, 1, r11.longitude);
            r12.encodeWithTag(r10, 2, r11.latitude);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            r13.encodeWithTag(r10, 3, r11.country);
            r13.encodeWithTag(r10, 4, r11.countryCode);
            r13.encodeWithTag(r10, 5, r11.administrativeArea);
            r13.encodeWithTag(r10, 6, r11.city);
            r13.encodeWithTag(r10, 7, r11.district);
            r13.encodeWithTag(r10, 8, r11.town);
            r13.encodeWithTag(r10, 9, r11.street);
            r13.encodeWithTag(r10, 10, r11.subAdministrativeArea);
            r13.encodeWithTag(r10, 11, r11.locality);
            r13.encodeWithTag(r10, 12, r11.subLocality);
            r13.encodeWithTag(r10, 13, r11.addressLine);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(LocationInfo r10) {
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            int r12 = r11.encodedSizeWithTag(1, r10.longitude) + r11.encodedSizeWithTag(2, r10.latitude);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            return (((((((((((r12 + r13.encodedSizeWithTag(3, r10.country)) + r13.encodedSizeWithTag(4, r10.countryCode)) + r13.encodedSizeWithTag(5, r10.administrativeArea)) + r13.encodedSizeWithTag(6, r10.city)) + r13.encodedSizeWithTag(7, r10.district)) + r13.encodedSizeWithTag(8, r10.town)) + r13.encodedSizeWithTag(9, r10.street)) + r13.encodedSizeWithTag(10, r10.subAdministrativeArea)) + r13.encodedSizeWithTag(11, r10.locality)) + r13.encodedSizeWithTag(12, r10.subLocality)) + r13.encodedSizeWithTag(13, r10.addressLine)) + r10.unknownFields().size();
        }

        public LocationInfo d(LocationInfo r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, LocationInfo r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LocationInfo r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo redact(LocationInfo r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        Double r10 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r10;
        DEFAULT_LATITUDE = r10;
    }

    public LocationInfo(Double r16, Double r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public LocationInfo(Double r10, Double r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.longitude = r10;
        this.latitude = r11;
        this.country = r12;
        this.countryCode = r13;
        this.administrativeArea = r14;
        this.city = r15;
        this.district = r16;
        this.town = r17;
        this.street = r18;
        this.subAdministrativeArea = r19;
        this.locality = r110;
        this.subLocality = r111;
        this.addressLine = r112;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r11 = (LocationInfo) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L38;
        if (Internal.equals(this.longitude, r11.longitude) == false) goto L38;
        if (Internal.equals(this.latitude, r11.latitude) == false) goto L38;
        if (Internal.equals(this.country, r11.country) == false) goto L38;
        if (Internal.equals(this.countryCode, r11.countryCode) == false) goto L38;
        if (Internal.equals(this.administrativeArea, r11.administrativeArea) == false) goto L38;
        if (Internal.equals(this.city, r11.city) == false) goto L38;
        if (Internal.equals(this.district, r11.district) == false) goto L38;
        if (Internal.equals(this.town, r11.town) == false) goto L38;
        if (Internal.equals(this.street, r11.street) == false) goto L38;
        if (Internal.equals(this.subAdministrativeArea, r11.subAdministrativeArea) == false) goto L38;
        if (Internal.equals(this.locality, r11.locality) == false) goto L38;
        if (Internal.equals(this.subLocality, r11.subLocality) == false) goto L38;
        if (Internal.equals(this.addressLine, r11.addressLine) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L57;
        int r11 = unknownFields().hashCode() * 37;
        Double r12 = this.longitude;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Double r16 = this.latitude;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.country;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        String r22 = this.countryCode;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        String r25 = this.administrativeArea;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        String r28 = this.city;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        String r31 = this.district;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (r30 + r32) * 37;
        String r34 = this.town;
        if (r34 == null) goto L35;
        int r35 = r34.hashCode();
    L36:
        int r36 = (r33 + r35) * 37;
        String r37 = this.street;
        if (r37 == null) goto L39;
        int r38 = r37.hashCode();
    L40:
        int r39 = (r36 + r38) * 37;
        String r40 = this.subAdministrativeArea;
        if (r40 == null) goto L43;
        int r41 = r40.hashCode();
    L44:
        int r42 = (r39 + r41) * 37;
        String r43 = this.locality;
        if (r43 == null) goto L47;
        int r44 = r43.hashCode();
    L48:
        int r45 = (r42 + r44) * 37;
        String r46 = this.subLocality;
        if (r46 == null) goto L51;
        int r47 = r46.hashCode();
    L52:
        int r48 = (r45 + r47) * 37;
        String r49 = this.addressLine;
        if (r49 == null) goto L55;
        r13 = r49.hashCode();
    L55:
        int r50 = r48 + r13;
        this.hashCode = r50;
        return r50;
    L51:
        r47 = 0;
        goto L52
    L47:
        r44 = 0;
        goto L48
    L43:
        r41 = 0;
        goto L44
    L39:
        r38 = 0;
        goto L40
    L35:
        r35 = 0;
        goto L36
    L31:
        r32 = 0;
        goto L32
    L27:
        r29 = 0;
        goto L28
    L23:
        r26 = 0;
        goto L24
    L19:
        r23 = 0;
        goto L20
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L57:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f5965a = this.longitude;
        r10.f5966b = this.latitude;
        r10.f5967c = this.country;
        r10.f5968d = this.countryCode;
        r10.f5969e = this.administrativeArea;
        r10.f5970f = this.city;
        r10.f5971g = this.district;
        r10.f5972h = this.town;
        r10.f5973i = this.street;
        r10.f5974j = this.subAdministrativeArea;
        r10.f5975k = this.locality;
        r10.f5976l = this.subLocality;
        r10.f5977m = this.addressLine;
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r10.append(", longitude=");
        r10.append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r10.append(", latitude=");
        r10.append(this.latitude);
    L9:
        if (this.country == null) goto L12;
        r10.append(", country=");
        r10.append(this.country);
    L12:
        if (this.countryCode == null) goto L15;
        r10.append(", countryCode=");
        r10.append(this.countryCode);
    L15:
        if (this.administrativeArea == null) goto L18;
        r10.append(", administrativeArea=");
        r10.append(this.administrativeArea);
    L18:
        if (this.city == null) goto L21;
        r10.append(", city=");
        r10.append(this.city);
    L21:
        if (this.district == null) goto L24;
        r10.append(", district=");
        r10.append(this.district);
    L24:
        if (this.town == null) goto L27;
        r10.append(", town=");
        r10.append(this.town);
    L27:
        if (this.street == null) goto L30;
        r10.append(", street=");
        r10.append(this.street);
    L30:
        if (this.subAdministrativeArea == null) goto L33;
        r10.append(", subAdministrativeArea=");
        r10.append(this.subAdministrativeArea);
    L33:
        if (this.locality == null) goto L36;
        r10.append(", locality=");
        r10.append(this.locality);
    L36:
        if (this.subLocality == null) goto L39;
        r10.append(", subLocality=");
        r10.append(this.subLocality);
    L39:
        if (this.addressLine == null) goto L41;
        r10.append(", addressLine=");
        r10.append(this.addressLine);
    L41:
        StringBuilder r11 = r10.replace(0, 2, "LocationInfo{");
        r11.append('}');
        return r11.toString();
    }
}
