package com.byted.mgl.merge.service.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpCameraPosition {
    public final float bearing;
    public final BdpLatLng latLng;
    public final float tilt;
    public final float zoom;

    public static final class Builder {
        private float bearing;
        private BdpLatLng latLng;
        private float tilt;
        private float zoom;

        public static Builder builder() {
            return new Builder();
        }

        public BdpCameraPosition build() {
            return new BdpCameraPosition(this.latLng, this.zoom, this.tilt, this.bearing);
        }

        public Builder() {
        }

        public Builder bearing(float r1) {
            this.bearing = r1;
            return this;
        }

        public Builder latLng(BdpLatLng r1) {
            this.latLng = r1;
            return this;
        }

        public Builder tilt(float r1) {
            this.tilt = r1;
            return this;
        }

        public Builder zoom(float r1) {
            this.zoom = r1;
            return this;
        }
    }

    public BdpCameraPosition(BdpLatLng r1, float r10, float r11, float r12) {
        this.latLng = r1;
        this.zoom = r10;
        this.tilt = r11;
        this.bearing = r12;
    }
}
