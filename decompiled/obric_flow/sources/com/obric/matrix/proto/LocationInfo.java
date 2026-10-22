package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
import cn.nubia.neopush.commons.Constant;
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

/* JADX INFO: loaded from: classes3.dex */
public final class LocationInfo extends Message<LocationInfo, Builder> {
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

    @SerializedName(Constant.LATITUDE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("locality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String locality;

    @SerializedName(Constant.LONGITUDE)
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
        public String country;
        public String countryCode;
        public String district;
        public Double latitude;
        public String locality;
        public Double longitude;
        public String street;
        public String subAdministrativeArea;
        public String subLocality;
        public String town;

        public Builder() {
            Double r5 = Double.valueOf(0.0d);
            this.longitude = r5;
            this.latitude = r5;
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
        }

        public Builder addressLine(String r5) {
            this.addressLine = r5;
            return this;
        }

        public Builder administrativeArea(String r5) {
            this.administrativeArea = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder city(String r5) {
            this.city = r5;
            return this;
        }

        public Builder country(String r5) {
            this.country = r5;
            return this;
        }

        public Builder countryCode(String r5) {
            this.countryCode = r5;
            return this;
        }

        public Builder district(String r5) {
            this.district = r5;
            return this;
        }

        public Builder latitude(Double r5) {
            this.latitude = r5;
            return this;
        }

        public Builder locality(String r5) {
            this.locality = r5;
            return this;
        }

        public Builder longitude(Double r5) {
            this.longitude = r5;
            return this;
        }

        public Builder street(String r5) {
            this.street = r5;
            return this;
        }

        public Builder subAdministrativeArea(String r5) {
            this.subAdministrativeArea = r5;
            return this;
        }

        public Builder subLocality(String r5) {
            this.subLocality = r5;
            return this;
        }

        public Builder town(String r5) {
            this.town = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public LocationInfo build() {
            return new LocationInfo(this.longitude, this.latitude, this.country, this.countryCode, this.administrativeArea, this.city, this.district, this.town, this.street, this.subAdministrativeArea, this.locality, this.subLocality, this.addressLine, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_LocationInfo extends ProtoAdapter<LocationInfo> {
        public ProtoAdapter_LocationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, LocationInfo r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LocationInfo r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo redact(LocationInfo r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LocationInfo decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L20;
            switch(r12) {
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
            r5.addressLine(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            r5.subLocality(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            r5.locality(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            r5.subAdministrativeArea(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            r5.street(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r5.town(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r5.district(ProtoAdapter.STRING.decode(r10));
            goto L3
        L14:
            r5.city(ProtoAdapter.STRING.decode(r10));
            goto L3
        L15:
            r5.administrativeArea(ProtoAdapter.STRING.decode(r10));
            goto L3
        L16:
            r5.countryCode(ProtoAdapter.STRING.decode(r10));
            goto L3
        L17:
            r5.country(ProtoAdapter.STRING.decode(r10));
            goto L3
        L18:
            r5.latitude(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L19:
            r5.longitude(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L20:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, LocationInfo r10) throws IOException {
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            r11.encodeWithTag(r5, 1, r10.longitude);
            r11.encodeWithTag(r5, 2, r10.latitude);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r5, 3, r10.country);
            r12.encodeWithTag(r5, 4, r10.countryCode);
            r12.encodeWithTag(r5, 5, r10.administrativeArea);
            r12.encodeWithTag(r5, 6, r10.city);
            r12.encodeWithTag(r5, 7, r10.district);
            r12.encodeWithTag(r5, 8, r10.town);
            r12.encodeWithTag(r5, 9, r10.street);
            r12.encodeWithTag(r5, 10, r10.subAdministrativeArea);
            r12.encodeWithTag(r5, 11, r10.locality);
            r12.encodeWithTag(r5, 12, r10.subLocality);
            r12.encodeWithTag(r5, 13, r10.addressLine);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LocationInfo r5) {
            ProtoAdapter<Double> r10 = ProtoAdapter.DOUBLE;
            int r11 = r10.encodedSizeWithTag(1, r5.longitude);
            int r12 = r10.encodedSizeWithTag(2, r5.latitude) + r11;
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            int r14 = r13.encodedSizeWithTag(3, r5.country) + r12;
            int r15 = r13.encodedSizeWithTag(4, r5.countryCode) + r14;
            int r16 = r13.encodedSizeWithTag(5, r5.administrativeArea) + r15;
            int r17 = r13.encodedSizeWithTag(6, r5.city) + r16;
            int r18 = r13.encodedSizeWithTag(7, r5.district) + r17;
            int r19 = r13.encodedSizeWithTag(8, r5.town) + r18;
            int r20 = r13.encodedSizeWithTag(9, r5.street) + r19;
            int r21 = r13.encodedSizeWithTag(10, r5.subAdministrativeArea) + r20;
            int r22 = r13.encodedSizeWithTag(11, r5.locality) + r21;
            int r23 = r13.encodedSizeWithTag(12, r5.subLocality) + r22;
            int r24 = r13.encodedSizeWithTag(13, r5.addressLine) + r23;
            return r5.unknownFields().size() + r24;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public LocationInfo redact2(LocationInfo r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LocationInfo();
        Double r5 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r5;
        DEFAULT_LATITUDE = r5;
    }

    public LocationInfo(Double r16, Double r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r10 = (LocationInfo) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L38;
        if (Internal.equals(this.longitude, r10.longitude) == false) goto L38;
        if (Internal.equals(this.latitude, r10.latitude) == false) goto L38;
        if (Internal.equals(this.country, r10.country) == false) goto L38;
        if (Internal.equals(this.countryCode, r10.countryCode) == false) goto L38;
        if (Internal.equals(this.administrativeArea, r10.administrativeArea) == false) goto L38;
        if (Internal.equals(this.city, r10.city) == false) goto L38;
        if (Internal.equals(this.district, r10.district) == false) goto L38;
        if (Internal.equals(this.town, r10.town) == false) goto L38;
        if (Internal.equals(this.street, r10.street) == false) goto L38;
        if (Internal.equals(this.subAdministrativeArea, r10.subAdministrativeArea) == false) goto L38;
        if (Internal.equals(this.locality, r10.locality) == false) goto L38;
        if (Internal.equals(this.subLocality, r10.subLocality) == false) goto L38;
        if (Internal.equals(this.addressLine, r10.addressLine) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L57;
        int r10 = unknownFields().hashCode() * 37;
        Double r11 = this.longitude;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.latitude;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.country;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        String r21 = this.countryCode;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.administrativeArea;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        String r27 = this.city;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        String r30 = this.district;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        String r33 = this.town;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        String r36 = this.street;
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        int r38 = (r35 + r37) * 37;
        String r39 = this.subAdministrativeArea;
        if (r39 == null) goto L43;
        int r40 = r39.hashCode();
    L44:
        int r41 = (r38 + r40) * 37;
        String r42 = this.locality;
        if (r42 == null) goto L47;
        int r43 = r42.hashCode();
    L48:
        int r44 = (r41 + r43) * 37;
        String r45 = this.subLocality;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 37;
        String r48 = this.addressLine;
        if (r48 == null) goto L55;
        r12 = r48.hashCode();
    L55:
        int r49 = r47 + r12;
        this.hashCode = r49;
        return r49;
    L51:
        r46 = 0;
        goto L52
    L47:
        r43 = 0;
        goto L48
    L43:
        r40 = 0;
        goto L44
    L39:
        r37 = 0;
        goto L40
    L35:
        r34 = 0;
        goto L36
    L31:
        r31 = 0;
        goto L32
    L27:
        r28 = 0;
        goto L28
    L23:
        r25 = 0;
        goto L24
    L19:
        r22 = 0;
        goto L20
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L57:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r5.append(", longitude=");
        r5.append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r5.append(", latitude=");
        r5.append(this.latitude);
    L9:
        if (this.country == null) goto L12;
        r5.append(", country=");
        r5.append(this.country);
    L12:
        if (this.countryCode == null) goto L15;
        r5.append(", countryCode=");
        r5.append(this.countryCode);
    L15:
        if (this.administrativeArea == null) goto L18;
        r5.append(", administrativeArea=");
        r5.append(this.administrativeArea);
    L18:
        if (this.city == null) goto L21;
        r5.append(", city=");
        r5.append(this.city);
    L21:
        if (this.district == null) goto L24;
        r5.append(", district=");
        r5.append(this.district);
    L24:
        if (this.town == null) goto L27;
        r5.append(", town=");
        r5.append(this.town);
    L27:
        if (this.street == null) goto L30;
        r5.append(", street=");
        r5.append(this.street);
    L30:
        if (this.subAdministrativeArea == null) goto L33;
        r5.append(", subAdministrativeArea=");
        r5.append(this.subAdministrativeArea);
    L33:
        if (this.locality == null) goto L36;
        r5.append(", locality=");
        r5.append(this.locality);
    L36:
        if (this.subLocality == null) goto L39;
        r5.append(", subLocality=");
        r5.append(this.subLocality);
    L39:
        if (this.addressLine == null) goto L42;
        r5.append(", addressLine=");
        r5.append(this.addressLine);
    L42:
        return a.s(r5, 0, 2, "LocationInfo{", '}');
    }

    public LocationInfo(Double r5, Double r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.longitude = r5;
        this.latitude = r10;
        this.country = r11;
        this.countryCode = r12;
        this.administrativeArea = r13;
        this.city = r14;
        this.district = r15;
        this.town = r16;
        this.street = r17;
        this.subAdministrativeArea = r18;
        this.locality = r19;
        this.subLocality = r110;
        this.addressLine = r111;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.longitude = this.longitude;
        r5.latitude = this.latitude;
        r5.country = this.country;
        r5.countryCode = this.countryCode;
        r5.administrativeArea = this.administrativeArea;
        r5.city = this.city;
        r5.district = this.district;
        r5.town = this.town;
        r5.street = this.street;
        r5.subAdministrativeArea = this.subAdministrativeArea;
        r5.locality = this.locality;
        r5.subLocality = this.subLocality;
        r5.addressLine = this.addressLine;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
