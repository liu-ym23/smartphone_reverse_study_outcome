package com.bytedance.android.livesdk.drawsomething.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DrawingLine extends Message<DrawingLine, Builder> {
    public static final ProtoAdapter<DrawingLine> ADAPTER = null;
    public static final Long DEFAULT_COLOR = null;
    public static final Integer DEFAULT_LINEWIDTH = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer lineWidth;

    @WireField(adapter = "webcast.sei.DrawingPoint#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<DrawingPoint> points;

    public static final class Builder extends Message.Builder<DrawingLine, Builder> {
        public Long color;
        public Integer lineWidth;
        public List<DrawingPoint> points;

        public DrawingLine build() {
            return new DrawingLine(this.points, this.color, this.lineWidth, super.buildUnknownFields());
        }

        public Builder() {
            this.points = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m1174build() {
            return build();
        }

        public Builder color(Long r1) {
            this.color = r1;
            return this;
        }

        public Builder lineWidth(Integer r1) {
            this.lineWidth = r1;
            return this;
        }

        public Builder points(List<DrawingPoint> r1) {
            Internal.checkElementsNotNull(r1);
            this.points = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingLine extends ProtoAdapter<DrawingLine> {
        public ProtoAdapter_DrawingLine() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingLine.class);
        }

        public DrawingLine decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.points.add((DrawingPoint) DrawingPoint.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.color((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.lineWidth((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(DrawingLine r6) {
            int r0 = DrawingPoint.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.points);
            Long r1 = r6.color;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.INT64.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Integer r5 = r6.lineWidth;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.INT32.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        public DrawingLine redact(DrawingLine r3) {
            Builder r4 = r3.newBuilder();
            Internal.redactElements(r4.points, DrawingPoint.ADAPTER);
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1175decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DrawingLine) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((DrawingLine) r1);
        }

        public void encode(ProtoWriter r4, DrawingLine r5) throws IOException {
            DrawingPoint.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.points);
            Long r0 = r5.color;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r0);
        L5:
            Integer r1 = r5.lineWidth;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DrawingLine) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingLine();
        DEFAULT_COLOR = 0L;
        DEFAULT_LINEWIDTH = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = ((unknownFields().hashCode() * 37) + this.points.hashCode()) * 37;
        Long r2 = this.color;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.lineWidth;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        ((Message) this).hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.points = Internal.copyOf("points", this.points);
        r0.color = this.color;
        r0.lineWidth = this.lineWidth;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.points.isEmpty() == true) goto L6;
        r0.append(", points=");
        r0.append(this.points);
    L6:
        if (this.color == null) goto L9;
        r0.append(", color=");
        r0.append(this.color);
    L9:
        if (this.lineWidth == null) goto L11;
        r0.append(", lineWidth=");
        r0.append(this.lineWidth);
    L11:
        StringBuilder r1 = r0.replace(0, 2, "DrawingLine{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m1173newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DrawingLine) == true) goto L8;
        return false;
    L8:
        DrawingLine r6 = (DrawingLine) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.points.equals(r6.points) == false) goto L17;
        if (Internal.equals(this.color, r6.color) == false) goto L17;
        if (Internal.equals(this.lineWidth, r6.lineWidth) == false) goto L17;
        return true;
    }

    public DrawingLine(List<DrawingPoint> r2, Long r3, Integer r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DrawingLine(List<DrawingPoint> r2, Long r3, Integer r4, ByteString r5) {
        super(ADAPTER, r5);
        this.points = Internal.immutableCopyOf("points", r2);
        this.color = r3;
        this.lineWidth = r4;
    }
}
