package com.bytedance.android.livesdk.drawsomething.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DrawingExtra extends Message<DrawingExtra, Builder> {
    public static final ProtoAdapter<DrawingExtra> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_HINT = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String answer;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String hint;

    public static final class Builder extends Message.Builder<DrawingExtra, Builder> {
        public String answer;
        public String hint;

        public DrawingExtra build() {
            return new DrawingExtra(this.hint, this.answer, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m1171build() {
            return build();
        }

        public Builder answer(String r1) {
            this.answer = r1;
            return this;
        }

        public Builder hint(String r1) {
            this.hint = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingExtra extends ProtoAdapter<DrawingExtra> {
        public ProtoAdapter_DrawingExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingExtra.class);
        }

        public DrawingExtra decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.hint((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.answer((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(DrawingExtra r5) {
            String r0 = r5.hint;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.answer;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        public DrawingExtra redact(DrawingExtra r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1172decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DrawingExtra) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((DrawingExtra) r1);
        }

        public void encode(ProtoWriter r4, DrawingExtra r5) throws IOException {
            String r0 = r5.hint;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.answer;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DrawingExtra) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingExtra();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.hint;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.answer;
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
        r0.hint = this.hint;
        r0.answer = this.answer;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.hint == null) goto L6;
        r0.append(", hint=");
        r0.append(this.hint);
    L6:
        if (this.answer == null) goto L8;
        r0.append(", answer=");
        r0.append(this.answer);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "DrawingExtra{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m1170newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DrawingExtra) == true) goto L8;
        return false;
    L8:
        DrawingExtra r6 = (DrawingExtra) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.hint, r6.hint) == false) goto L15;
        if (Internal.equals(this.answer, r6.answer) == false) goto L15;
        return true;
    }

    public DrawingExtra(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public DrawingExtra(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.hint = r2;
        this.answer = r3;
    }
}
