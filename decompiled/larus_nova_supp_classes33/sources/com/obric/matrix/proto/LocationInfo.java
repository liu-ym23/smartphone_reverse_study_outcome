package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LocationInfo extends Message<LocationInfo, Builder> {
    public static final ProtoAdapter<LocationInfo> ADAPTER = null;
    public static final String DEFAULT_ADDRESSLINE = "";
    public static final String DEFAULT_ADMINISTRATIVEAREA = "";
    public static final String DEFAULT_CITY = "";
    public static final String DEFAULT_CITYCODE = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_COUNTRYCODE = "";
    public static final String DEFAULT_DISTRICT = "";
    public static final String DEFAULT_DISTRICTCODE = "";
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

    @SerializedName("cityCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String cityCode;

    @SerializedName("country")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String country;

    @SerializedName("countryCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String countryCode;

    @SerializedName("district")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String district;

    @SerializedName("districtCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final String districtCode;

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

    public static final class Builder extends Message.Builder<LocationInfo, Builder> {
        public String addressLine;
        public String administrativeArea;
        public String city;
        public String cityCode;
        public String country;
        public String countryCode;
        public String district;
        public String districtCode;
        public Double latitude;
        public String locality;
        public Double longitude;
        public String street;
        public String subAdministrativeArea;
        public String subLocality;
        public String town;

        public LocationInfo build() {
            return new LocationInfo(this.longitude, this.latitude, this.country, this.countryCode, this.administrativeArea, this.city, this.district, this.town, this.street, this.subAdministrativeArea, this.locality, this.subLocality, this.addressLine, this.cityCode, this.districtCode, super.buildUnknownFields());
        }

        public Builder() {
            Double r0 = Double.valueOf(0.0d);
            this.longitude = r0;
            this.latitude = r0;
            this.country = "";
            this.countryCode = "";
            this.administrativeArea = "";
            this.city = "";
            this.district = "";
            this.town = "";
            this.street = "";
            this.subAdministrativeArea = "";
            this.locality = "";
            this.subLocality = "";
            this.addressLine = "";
            this.cityCode = "";
            this.districtCode = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m111build() {
            return build();
        }

        public Builder addressLine(String r1) {
            this.addressLine = r1;
            return this;
        }

        public Builder administrativeArea(String r1) {
            this.administrativeArea = r1;
            return this;
        }

        public Builder city(String r1) {
            this.city = r1;
            return this;
        }

        public Builder cityCode(String r1) {
            this.cityCode = r1;
            return this;
        }

        public Builder country(String r1) {
            this.country = r1;
            return this;
        }

        public Builder countryCode(String r1) {
            this.countryCode = r1;
            return this;
        }

        public Builder district(String r1) {
            this.district = r1;
            return this;
        }

        public Builder districtCode(String r1) {
            this.districtCode = r1;
            return this;
        }

        public Builder latitude(Double r1) {
            this.latitude = r1;
            return this;
        }

        public Builder locality(String r1) {
            this.locality = r1;
            return this;
        }

        public Builder longitude(Double r1) {
            this.longitude = r1;
            return this;
        }

        public Builder street(String r1) {
            this.street = r1;
            return this;
        }

        public Builder subAdministrativeArea(String r1) {
            this.subAdministrativeArea = r1;
            return this;
        }

        public Builder subLocality(String r1) {
            this.subLocality = r1;
            return this;
        }

        public Builder town(String r1) {
            this.town = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_LocationInfo extends ProtoAdapter<LocationInfo> {
        public ProtoAdapter_LocationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        public LocationInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L22;
            switch(r3) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L7:
            r0.districtCode((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            r0.cityCode((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.addressLine((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.subLocality((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.locality((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.subAdministrativeArea((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.street((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.town((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            r0.district((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L16:
            r0.city((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L17:
            r0.administrativeArea((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L18:
            r0.countryCode((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L19:
            r0.country((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L20:
            r0.latitude((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L21:
            r0.longitude((Double) ProtoAdapter.DOUBLE.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L22:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(LocationInfo r5) {
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            int r1 = r0.encodedSizeWithTag(1, r5.longitude) + r0.encodedSizeWithTag(2, r5.latitude);
            ProtoAdapter r2 = ProtoAdapter.STRING;
            return (((((((((((((r1 + r2.encodedSizeWithTag(3, r5.country)) + r2.encodedSizeWithTag(4, r5.countryCode)) + r2.encodedSizeWithTag(5, r5.administrativeArea)) + r2.encodedSizeWithTag(6, r5.city)) + r2.encodedSizeWithTag(7, r5.district)) + r2.encodedSizeWithTag(8, r5.town)) + r2.encodedSizeWithTag(9, r5.street)) + r2.encodedSizeWithTag(10, r5.subAdministrativeArea)) + r2.encodedSizeWithTag(11, r5.locality)) + r2.encodedSizeWithTag(12, r5.subLocality)) + r2.encodedSizeWithTag(13, r5.addressLine)) + r2.encodedSizeWithTag(14, r5.cityCode)) + r2.encodedSizeWithTag(15, r5.districtCode)) + r5.unknownFields().size();
        }

        public LocationInfo redact(LocationInfo r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m112decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((LocationInfo) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((LocationInfo) r1);
        }

        public void encode(ProtoWriter r4, LocationInfo r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.DOUBLE;
            r0.encodeWithTag(r4, 1, r5.longitude);
            r0.encodeWithTag(r4, 2, r5.latitude);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.encodeWithTag(r4, 3, r5.country);
            r1.encodeWithTag(r4, 4, r5.countryCode);
            r1.encodeWithTag(r4, 5, r5.administrativeArea);
            r1.encodeWithTag(r4, 6, r5.city);
            r1.encodeWithTag(r4, 7, r5.district);
            r1.encodeWithTag(r4, 8, r5.town);
            r1.encodeWithTag(r4, 9, r5.street);
            r1.encodeWithTag(r4, 10, r5.subAdministrativeArea);
            r1.encodeWithTag(r4, 11, r5.locality);
            r1.encodeWithTag(r4, 12, r5.subLocality);
            r1.encodeWithTag(r4, 13, r5.addressLine);
            r1.encodeWithTag(r4, 14, r5.cityCode);
            r1.encodeWithTag(r4, 15, r5.districtCode);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (LocationInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LocationInfo();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L65;
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
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        String r42 = this.cityCode;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        String r45 = this.districtCode;
        if (r45 == null) goto L63;
        r3 = r45.hashCode();
    L63:
        int r46 = r44 + r3;
        ((Message) this).hashCode = r46;
        return r46;
    L59:
        r43 = 0;
        goto L60
    L55:
        r40 = 0;
        goto L56
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
    L65:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.longitude = this.longitude;
        r0.latitude = this.latitude;
        r0.country = this.country;
        r0.countryCode = this.countryCode;
        r0.administrativeArea = this.administrativeArea;
        r0.city = this.city;
        r0.district = this.district;
        r0.town = this.town;
        r0.street = this.street;
        r0.subAdministrativeArea = this.subAdministrativeArea;
        r0.locality = this.locality;
        r0.subLocality = this.subLocality;
        r0.addressLine = this.addressLine;
        r0.cityCode = this.cityCode;
        r0.districtCode = this.districtCode;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r0.append(", longitude=");
        r0.append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r0.append(", latitude=");
        r0.append(this.latitude);
    L9:
        if (this.country == null) goto L12;
        r0.append(", country=");
        r0.append(this.country);
    L12:
        if (this.countryCode == null) goto L15;
        r0.append(", countryCode=");
        r0.append(this.countryCode);
    L15:
        if (this.administrativeArea == null) goto L18;
        r0.append(", administrativeArea=");
        r0.append(this.administrativeArea);
    L18:
        if (this.city == null) goto L21;
        r0.append(", city=");
        r0.append(this.city);
    L21:
        if (this.district == null) goto L24;
        r0.append(", district=");
        r0.append(this.district);
    L24:
        if (this.town == null) goto L27;
        r0.append(", town=");
        r0.append(this.town);
    L27:
        if (this.street == null) goto L30;
        r0.append(", street=");
        r0.append(this.street);
    L30:
        if (this.subAdministrativeArea == null) goto L33;
        r0.append(", subAdministrativeArea=");
        r0.append(this.subAdministrativeArea);
    L33:
        if (this.locality == null) goto L36;
        r0.append(", locality=");
        r0.append(this.locality);
    L36:
        if (this.subLocality == null) goto L39;
        r0.append(", subLocality=");
        r0.append(this.subLocality);
    L39:
        if (this.addressLine == null) goto L42;
        r0.append(", addressLine=");
        r0.append(this.addressLine);
    L42:
        if (this.cityCode == null) goto L45;
        r0.append(", cityCode=");
        r0.append(this.cityCode);
    L45:
        if (this.districtCode == null) goto L47;
        r0.append(", districtCode=");
        r0.append(this.districtCode);
    L47:
        StringBuilder r1 = r0.replace(0, 2, "LocationInfo{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m110newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r6 = (LocationInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L41:
        return false;
    L11:
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L41;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L41;
        if (Internal.equals(this.country, r6.country) == false) goto L41;
        if (Internal.equals(this.countryCode, r6.countryCode) == false) goto L41;
        if (Internal.equals(this.administrativeArea, r6.administrativeArea) == false) goto L41;
        if (Internal.equals(this.city, r6.city) == false) goto L41;
        if (Internal.equals(this.district, r6.district) == false) goto L41;
        if (Internal.equals(this.town, r6.town) == false) goto L41;
        if (Internal.equals(this.street, r6.street) == false) goto L41;
        if (Internal.equals(this.subAdministrativeArea, r6.subAdministrativeArea) == false) goto L41;
        if (Internal.equals(this.locality, r6.locality) == false) goto L41;
        if (Internal.equals(this.subLocality, r6.subLocality) == false) goto L41;
        if (Internal.equals(this.addressLine, r6.addressLine) == false) goto L41;
        if (Internal.equals(this.cityCode, r6.cityCode) == false) goto L41;
        if (Internal.equals(this.districtCode, r6.districtCode) == false) goto L41;
        return true;
    }

    public LocationInfo(Double r16, Double r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public LocationInfo(Double r18, Double r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, ByteString r31) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, "", "", r31);
    }

    public LocationInfo(Double r17, Double r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
    }

    public LocationInfo(Double r18, Double r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, ByteString.EMPTY);
    }

    public LocationInfo(Double r18, Double r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, ByteString r32) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, "", r32);
    }

    public LocationInfo(Double r4, Double r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, ByteString r19) {
        super(ADAPTER, r19);
        this.longitude = r4;
        this.latitude = r5;
        this.country = r6;
        this.countryCode = r7;
        this.administrativeArea = r8;
        this.city = r9;
        this.district = r10;
        this.town = r11;
        this.street = r12;
        this.subAdministrativeArea = r13;
        this.locality = r14;
        this.subLocality = r15;
        this.addressLine = r16;
        this.cityCode = r17;
        this.districtCode = r18;
    }
}
