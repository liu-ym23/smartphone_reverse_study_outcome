package com.ss.android.lark.location.dto;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR.\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010!j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010(\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010!j\n\u0012\u0004\u0012\u00020)\u0018\u0001`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/ss/android/lark/location/dto/AddressComponent;", "", "Ljava/io/Serializable;", "<init>", "()V", "country", "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "province", "getProvince", "setProvince", "city", "getCity", "setCity", "district", "getDistrict", "setDistrict", "township", "getTownship", "setTownship", "neighborhood", "getNeighborhood", "setNeighborhood", LocationConstants$NameType.BUILDING, "getBuilding", "setBuilding", "address", "getAddress", "setAddress", "aoiItems", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/location/dto/AoiItemInfo;", "Lkotlin/collections/ArrayList;", "getAoiItems", "()Ljava/util/ArrayList;", "setAoiItems", "(Ljava/util/ArrayList;)V", "poiItems", "Lcom/ss/android/lark/location/dto/PoiItemInfo;", "getPoiItems", "setPoiItems", "larkStreetNumber", "Lcom/ss/android/lark/location/dto/StreetNumberInfo;", "getLarkStreetNumber", "()Lcom/ss/android/lark/location/dto/StreetNumberInfo;", "setLarkStreetNumber", "(Lcom/ss/android/lark/location/dto/StreetNumberInfo;)V", "Builder", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AddressComponent implements Cloneable, Serializable {
    private String address;
    private ArrayList<AoiItemInfo> aoiItems;
    private String building;
    private String city;
    private String country;
    private String district;
    private StreetNumberInfo larkStreetNumber;
    private String neighborhood;
    private ArrayList<PoiItemInfo> poiItems;
    private String province;
    private String township;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public final AddressComponent a() {
            AddressComponent r0 = new AddressComponent();
            r0.setCountry(this.a);
            r0.setProvince(this.b);
            r0.setCity(this.c);
            r0.setDistrict(this.d);
            r0.setTownship(this.e);
            r0.setNeighborhood(this.f);
            r0.setBuilding(this.g);
            r0.setAddress(this.h);
            r0.setAoiItems(null);
            r0.setPoiItems(null);
            r0.setLarkStreetNumber(null);
            return r0;
        }

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
        }
    }

    public AddressComponent() {
        this.country = "";
        this.province = "";
        this.city = "";
        this.district = "";
        this.township = "";
        this.neighborhood = "";
        this.building = "";
        this.address = "";
    }

    public Object clone() {
        return super.clone();
    }

    public final String getAddress() {
        return this.address;
    }

    public final ArrayList<AoiItemInfo> getAoiItems() {
        return this.aoiItems;
    }

    public final String getBuilding() {
        return this.building;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final StreetNumberInfo getLarkStreetNumber() {
        return this.larkStreetNumber;
    }

    public final String getNeighborhood() {
        return this.neighborhood;
    }

    public final ArrayList<PoiItemInfo> getPoiItems() {
        return this.poiItems;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getTownship() {
        return this.township;
    }

    public final void setAddress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.address = r2;
    }

    public final void setAoiItems(ArrayList<AoiItemInfo> r1) {
        this.aoiItems = r1;
    }

    public final void setBuilding(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.building = r2;
    }

    public final void setCity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.city = r2;
    }

    public final void setCountry(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.country = r2;
    }

    public final void setDistrict(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.district = r2;
    }

    public final void setLarkStreetNumber(StreetNumberInfo r1) {
        this.larkStreetNumber = r1;
    }

    public final void setNeighborhood(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.neighborhood = r2;
    }

    public final void setPoiItems(ArrayList<PoiItemInfo> r1) {
        this.poiItems = r1;
    }

    public final void setProvince(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.province = r2;
    }

    public final void setTownship(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.township = r2;
    }
}
