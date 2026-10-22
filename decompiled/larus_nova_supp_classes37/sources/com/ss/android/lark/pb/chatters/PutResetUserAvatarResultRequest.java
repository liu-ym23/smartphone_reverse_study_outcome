package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutResetUserAvatarResultRequest extends Message<PutResetUserAvatarResultRequest, Builder> {
    public static final ProtoAdapter<PutResetUserAvatarResultRequest> ADAPTER = null;
    public static final String DEFAULT_RESET_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final String mreset_token;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<PutResetUserAvatarResultRequest, Builder> {
        public String mreset_token;
        public Status mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutResetUserAvatarResultRequest m938build() {
            String r0 = this.mreset_token;
            if (r0 == null) goto L9;
            if (this.mstatus == null) goto L9;
            return new PutResetUserAvatarResultRequest(this.mreset_token, this.mstatus, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mreset_token", this.mstatus, "mstatus"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m938build();
        }

        public Builder reset_token(String r1) {
            this.mreset_token = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutResetUserAvatarResultRequest extends ProtoAdapter<PutResetUserAvatarResultRequest> {
        public ProtoAdapter_PutResetUserAvatarResultRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutResetUserAvatarResultRequest.class);
        }

        public PutResetUserAvatarResultRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mreset_token = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mreset_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m938build();
        }

        public int encodedSize(PutResetUserAvatarResultRequest r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mreset_token) + Status.ADAPTER.encodedSizeWithTag(2, r5.mstatus)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m939decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutResetUserAvatarResultRequest) r1);
        }

        public void encode(ProtoWriter r4, PutResetUserAvatarResultRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mreset_token);
            Status.ADAPTER.encodeWithTag(r4, 2, r5.mstatus);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutResetUserAvatarResultRequest) r2);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ABORT = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status RESET = null;
        private final int value;

        static {
            Status r0 = new Status("RESET", 0, 1);
            RESET = r0;
            Status r1 = new Status("ABORT", 1, 2);
            ABORT = r1;
            $VALUES = new Status[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return ABORT;
        L11:
            return RESET;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutResetUserAvatarResultRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m937newBuilder() {
        Builder r0 = new Builder();
        r0.mreset_token = this.mreset_token;
        r0.mstatus = this.mstatus;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutResetUserAvatarResultRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m937newBuilder();
    }

    public PutResetUserAvatarResultRequest(String r2, Status r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PutResetUserAvatarResultRequest(String r2, Status r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mreset_token = r2;
        this.mstatus = r3;
    }
}
