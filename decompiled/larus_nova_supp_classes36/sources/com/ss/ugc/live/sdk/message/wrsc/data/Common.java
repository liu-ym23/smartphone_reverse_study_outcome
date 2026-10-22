package com.ss.ugc.live.sdk.message.wrsc.data;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class Common extends AndroidMessage<Common, Builder> {
    public static final ProtoAdapter<Common> ADAPTER = null;
    public static final Parcelable.Creator<Common> CREATOR = null;
    public static final Long DEFAULT_CHANNEL_ID = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_METHOD = "";
    public static final Long DEFAULT_MSG_ID = null;
    public static final Long DEFAULT_ROOM_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 21)
    public final Long channel_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long create_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long msg_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long room_id;

    public static final class Builder extends Message.Builder<Common, Builder> {
        public Long channel_id;
        public Long create_time;
        public String method;
        public Long msg_id;
        public Long room_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Common m1664build() {
            return new Common(this.method, this.msg_id, this.room_id, this.create_time, this.channel_id, super.buildUnknownFields());
        }

        public Builder() {
            this.method = "";
            this.msg_id = 0L;
            this.room_id = 0L;
            this.create_time = 0L;
            this.channel_id = 0L;
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1664build();
        }

        public Builder channel_id(Long r1) {
            this.channel_id = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.create_time = r1;
            return this;
        }

        public Builder method(String r1) {
            this.method = r1;
            return this;
        }

        public Builder msg_id(Long r1) {
            this.msg_id = r1;
            return this;
        }

        public Builder room_id(Long r1) {
            this.room_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Common extends ProtoAdapter<Common> {
        public ProtoAdapter_Common() {
            super(FieldEncoding.LENGTH_DELIMITED, Common.class);
        }

        public Common decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.method((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msg_id((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.room_id((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.create_time((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L14:
            if (r3 != 21) goto L15;
            r0.channel_id((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1664build();
        }

        public int encodedSize(Common r5) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.method);
            ProtoAdapter r1 = ProtoAdapter.INT64;
            return ((((r0 + r1.encodedSizeWithTag(2, r5.msg_id)) + r1.encodedSizeWithTag(3, r5.room_id)) + r1.encodedSizeWithTag(4, r5.create_time)) + r1.encodedSizeWithTag(4, r5.channel_id)) + r5.unknownFields().size();
        }

        public Common redact(Common r1) {
            Builder r2 = r1.m1663newBuilder();
            r2.clearUnknownFields();
            return r2.m1664build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1665decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Common) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Common) r1);
        }

        public void encode(ProtoWriter r4, Common r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.method);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r4, 2, r5.msg_id);
            r0.encodeWithTag(r4, 3, r5.room_id);
            r0.encodeWithTag(r4, 4, r5.create_time);
            r0.encodeWithTag(r4, 21, r5.channel_id);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Common) r2);
        }
    }

    static {
        ProtoAdapter_Common r0 = new ProtoAdapter_Common();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_MSG_ID = 0L;
        DEFAULT_ROOM_ID = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_CHANNEL_ID = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.method;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.msg_id;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.room_id;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.create_time;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.channel_id;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        ((Message) this).hashCode = r16;
        return r16;
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
    L25:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1663newBuilder() {
        Builder r0 = new Builder();
        r0.method = this.method;
        r0.msg_id = this.msg_id;
        r0.room_id = this.room_id;
        r0.create_time = this.create_time;
        r0.channel_id = this.channel_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.method == null) goto L6;
        r0.append(", method=");
        r0.append(this.method);
    L6:
        if (this.msg_id == null) goto L9;
        r0.append(", msg_id=");
        r0.append(this.msg_id);
    L9:
        if (this.room_id == null) goto L12;
        r0.append(", room_id=");
        r0.append(this.room_id);
    L12:
        if (this.create_time == null) goto L15;
        r0.append(", create_time=");
        r0.append(this.create_time);
    L15:
        if (this.channel_id == null) goto L17;
        r0.append(", channel_id=");
        r0.append(this.channel_id);
    L17:
        StringBuilder r1 = r0.replace(0, 2, "Common{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1663newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Common) == true) goto L8;
        return false;
    L8:
        Common r6 = (Common) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.method, r6.method) == false) goto L21;
        if (Internal.equals(this.msg_id, r6.msg_id) == false) goto L21;
        if (Internal.equals(this.room_id, r6.room_id) == false) goto L21;
        if (Internal.equals(this.create_time, r6.create_time) == false) goto L21;
        if (Internal.equals(this.channel_id, r6.channel_id) == false) goto L21;
        return true;
    }

    public Common(String r8, Long r9, Long r10, Long r11, Long r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public Common(String r2, Long r3, Long r4, Long r5, Long r6, ByteString r7) {
        super(ADAPTER, r7);
        this.method = r2;
        this.msg_id = r3;
        this.room_id = r4;
        this.create_time = r5;
        this.channel_id = r6;
    }
}
