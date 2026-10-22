package com.byted.mgl.merge.service.model;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpPolylineOptions {
    public final int color;
    public final boolean dottedLine;
    public final List<BdpLatLng> points;
    public final double width;

    public static final class Builder {
        private int color;
        private boolean dottedLine;
        private List<BdpLatLng> points;
        private double width;

        public static Builder builder() {
            return new Builder();
        }

        public BdpPolylineOptions build() {
            return new BdpPolylineOptions(this.points, this.color, this.width, this.dottedLine);
        }

        public Builder() {
        }

        public Builder color(int r1) {
            this.color = r1;
            return this;
        }

        public Builder dottedLine(boolean r1) {
            this.dottedLine = r1;
            return this;
        }

        public Builder points(List<BdpLatLng> r1) {
            this.points = r1;
            return this;
        }

        public Builder width(double r1) {
            this.width = r1;
            return this;
        }
    }

    public BdpPolylineOptions(List<BdpLatLng> r1, int r10, double r11, boolean r12) {
        this.points = r1;
        this.color = r10;
        this.width = r11;
        this.dottedLine = r12;
    }
}
