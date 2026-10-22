package com.ss.android.lark.passport.signinsdk_api.interfaces;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IDeviceService {

    public static class Country implements Serializable {
        private long geocodeNameId;
        private String isoCode;

        public long getGeocodeNameId() {
            return this.geocodeNameId;
        }

        public String getIsoCode() {
            return this.isoCode;
        }

        public void setGeocodeNameId(long r1) {
            this.geocodeNameId = r1;
        }

        public void setIsoCode(String r1) {
            this.isoCode = r1;
        }

        public Country(long r1, String r3) {
            this.geocodeNameId = r1;
            this.isoCode = r3;
        }
    }
}
