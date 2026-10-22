package com.byted.mgl.merge.service.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpVisibleRegion {
    public BdpLatLng leftBottom;
    public final BdpLatLng leftTop;
    public final BdpLatLng rightBottom;
    public final BdpLatLng rightTop;

    public static final class Builder {
        private BdpLatLng leftBottom;
        private BdpLatLng leftTop;
        private BdpLatLng rightBottom;
        private BdpLatLng rightTop;

        public static Builder builder() {
            return new Builder();
        }

        public BdpVisibleRegion build() {
            return new BdpVisibleRegion(this.leftTop, this.rightTop, this.rightBottom, this.leftBottom);
        }

        public Builder() {
        }

        public Builder leftBottom(BdpLatLng r1) {
            if (r1 == null) goto L6;
            this.leftBottom = r1;
            return this;
        L6:
            throw null;
        }

        public Builder leftTop(BdpLatLng r1) {
            if (r1 == null) goto L6;
            this.leftTop = r1;
            return this;
        L6:
            throw null;
        }

        public Builder rightBottom(BdpLatLng r1) {
            if (r1 == null) goto L6;
            this.rightBottom = r1;
            return this;
        L6:
            throw null;
        }

        public Builder rightTop(BdpLatLng r1) {
            if (r1 == null) goto L6;
            this.rightTop = r1;
            return this;
        L6:
            throw null;
        }
    }

    public BdpVisibleRegion(BdpLatLng r1, BdpLatLng r10, BdpLatLng r11, BdpLatLng r12) {
        this.leftTop = r1;
        this.rightTop = r10;
        this.rightBottom = r11;
        this.leftBottom = r12;
    }
}
