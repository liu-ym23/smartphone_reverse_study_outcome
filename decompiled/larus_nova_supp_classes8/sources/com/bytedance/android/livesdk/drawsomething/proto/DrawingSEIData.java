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
public final class DrawingSEIData extends Message<DrawingSEIData, Builder> {
    public static final ProtoAdapter<DrawingSEIData> ADAPTER = null;
    public static final Integer DEFAULT_CANVASHEIGHT = null;
    public static final Integer DEFAULT_CANVASWIDTH = null;
    public static final Integer DEFAULT_DURATION = null;
    public static final Integer DEFAULT_STATE = null;
    public static final Integer DEFAULT_TIME = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer canvasHeight;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer canvasWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer duration;

    @WireField(adapter = "webcast.sei.DrawingExtra#ADAPTER", tag = 4)
    public final DrawingExtra extra;

    @WireField(adapter = "webcast.sei.DrawingLine#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<DrawingLine> lines;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer state;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer time;

    public static final class Builder extends Message.Builder<DrawingSEIData, Builder> {
        public Integer canvasHeight;
        public Integer canvasWidth;
        public Integer duration;
        public DrawingExtra extra;
        public List<DrawingLine> lines;
        public Integer state;
        public Integer time;

        public DrawingSEIData build() {
            return new DrawingSEIData(this.state, this.time, this.lines, this.extra, this.duration, this.canvasWidth, this.canvasHeight, super.buildUnknownFields());
        }

        public Builder() {
            this.lines = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m1180build() {
            return build();
        }

        public Builder canvasHeight(Integer r1) {
            this.canvasHeight = r1;
            return this;
        }

        public Builder canvasWidth(Integer r1) {
            this.canvasWidth = r1;
            return this;
        }

        public Builder duration(Integer r1) {
            this.duration = r1;
            return this;
        }

        public Builder extra(DrawingExtra r1) {
            this.extra = r1;
            return this;
        }

        public Builder lines(List<DrawingLine> r1) {
            Internal.checkElementsNotNull(r1);
            this.lines = r1;
            return this;
        }

        public Builder state(Integer r1) {
            this.state = r1;
            return this;
        }

        public Builder time(Integer r1) {
            this.time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingSEIData extends ProtoAdapter<DrawingSEIData> {
        public ProtoAdapter_DrawingSEIData() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingSEIData.class);
        }

        public DrawingSEIData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.canvasHeight((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            r0.canvasWidth((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L9:
            r0.duration((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.extra((DrawingExtra) DrawingExtra.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.lines.add((DrawingLine) DrawingLine.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.time((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L13:
            r0.state((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(DrawingSEIData r6) {
            Integer r0 = r6.state;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.time;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = (r2 + r4) + DrawingLine.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.lines);
            DrawingExtra r7 = r6.extra;
            if (r7 == null) goto L13;
            int r8 = DrawingExtra.ADAPTER.encodedSizeWithTag(4, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.duration;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(5, r10);
        L18:
            int r12 = r9 + r11;
            Integer r13 = r6.canvasWidth;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(6, r13);
        L22:
            int r15 = r12 + r14;
            Integer r16 = r6.canvasHeight;
            if (r16 == null) goto L26;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(7, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public DrawingSEIData redact(DrawingSEIData r3) {
            Builder r4 = r3.newBuilder();
            Internal.redactElements(r4.lines, DrawingLine.ADAPTER);
            DrawingExtra r0 = r4.extra;
            if (r0 == null) goto L5;
            r4.extra = (DrawingExtra) DrawingExtra.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1181decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DrawingSEIData) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((DrawingSEIData) r1);
        }

        public void encode(ProtoWriter r4, DrawingSEIData r5) throws IOException {
            Integer r0 = r5.state;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            DrawingLine.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.lines);
            DrawingExtra r2 = r5.extra;
            if (r2 == null) goto L11;
            DrawingExtra.ADAPTER.encodeWithTag(r4, 4, r2);
        L11:
            Integer r3 = r5.duration;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r3);
        L14:
            Integer r6 = r5.canvasWidth;
            if (r6 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r4, 6, r6);
        L17:
            Integer r7 = r5.canvasHeight;
            if (r7 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r4, 7, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DrawingSEIData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingSEIData();
        DEFAULT_STATE = 0;
        DEFAULT_TIME = 0;
        DEFAULT_DURATION = 0;
        DEFAULT_CANVASWIDTH = 0;
        DEFAULT_CANVASHEIGHT = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L29;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.state;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.time;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((r5 + r7) * 37) + this.lines.hashCode()) * 37;
        DrawingExtra r9 = this.extra;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.duration;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.canvasWidth;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Integer r18 = this.canvasHeight;
        if (r18 == null) goto L27;
        r3 = r18.hashCode();
    L27:
        int r19 = r17 + r3;
        ((Message) this).hashCode = r19;
        return r19;
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
    L29:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.state = this.state;
        r0.time = this.time;
        r0.lines = Internal.copyOf("lines", this.lines);
        r0.extra = this.extra;
        r0.duration = this.duration;
        r0.canvasWidth = this.canvasWidth;
        r0.canvasHeight = this.canvasHeight;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.state == null) goto L6;
        r0.append(", state=");
        r0.append(this.state);
    L6:
        if (this.time == null) goto L9;
        r0.append(", time=");
        r0.append(this.time);
    L9:
        if (this.lines.isEmpty() == true) goto L12;
        r0.append(", lines=");
        r0.append(this.lines);
    L12:
        if (this.extra == null) goto L15;
        r0.append(", extra=");
        r0.append(this.extra);
    L15:
        if (this.duration == null) goto L18;
        r0.append(", duration=");
        r0.append(this.duration);
    L18:
        if (this.canvasWidth == null) goto L21;
        r0.append(", canvasWidth=");
        r0.append(this.canvasWidth);
    L21:
        if (this.canvasHeight == null) goto L23;
        r0.append(", canvasHeight=");
        r0.append(this.canvasHeight);
    L23:
        StringBuilder r1 = r0.replace(0, 2, "DrawingSEIData{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m1179newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DrawingSEIData) == true) goto L8;
        return false;
    L8:
        DrawingSEIData r6 = (DrawingSEIData) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (Internal.equals(this.state, r6.state) == false) goto L25;
        if (Internal.equals(this.time, r6.time) == false) goto L25;
        if (this.lines.equals(r6.lines) == false) goto L25;
        if (Internal.equals(this.extra, r6.extra) == false) goto L25;
        if (Internal.equals(this.duration, r6.duration) == false) goto L25;
        if (Internal.equals(this.canvasWidth, r6.canvasWidth) == false) goto L25;
        if (Internal.equals(this.canvasHeight, r6.canvasHeight) == false) goto L25;
        return true;
    }

    public DrawingSEIData(Integer r10, Integer r11, List<DrawingLine> r12, DrawingExtra r13, Integer r14, Integer r15, Integer r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public DrawingSEIData(Integer r2, Integer r3, List<DrawingLine> r4, DrawingExtra r5, Integer r6, Integer r7, Integer r8, ByteString r9) {
        super(ADAPTER, r9);
        this.state = r2;
        this.time = r3;
        this.lines = Internal.immutableCopyOf("lines", r4);
        this.extra = r5;
        this.duration = r6;
        this.canvasWidth = r7;
        this.canvasHeight = r8;
    }
}
