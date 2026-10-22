package com.ss.android.lark.pb.feed;

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
public final class AppFeedCardButtonCallbackResponse extends Message<AppFeedCardButtonCallbackResponse, Builder> {
    public static final ProtoAdapter<AppFeedCardButtonCallbackResponse> ADAPTER = null;
    public static final String DEFAULT_TOAST = "";
    private static final long serialVersionUID = 0;
    public final StatusCode mstatus;
    public final String mtoast;

    public static final class Builder extends Message.Builder<AppFeedCardButtonCallbackResponse, Builder> {
        public StatusCode mstatus;
        public String mtoast;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AppFeedCardButtonCallbackResponse m1694build() {
            StatusCode r0 = this.mstatus;
            if (r0 == null) goto L7;
            return new AppFeedCardButtonCallbackResponse(this.mstatus, this.mtoast, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mstatus"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1694build();
        }

        public Builder status(StatusCode r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder toast(String r1) {
            this.mtoast = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AppFeedCardButtonCallbackResponse extends ProtoAdapter<AppFeedCardButtonCallbackResponse> {
        public ProtoAdapter_AppFeedCardButtonCallbackResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedCardButtonCallbackResponse.class);
        }

        public AppFeedCardButtonCallbackResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtoast = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mstatus = (StatusCode) StatusCode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtoast = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1694build();
        }

        public int encodedSize(AppFeedCardButtonCallbackResponse r5) {
            int r0 = StatusCode.ADAPTER.encodedSizeWithTag(1, r5.mstatus);
            String r1 = r5.mtoast;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1695decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AppFeedCardButtonCallbackResponse) r1);
        }

        public void encode(ProtoWriter r4, AppFeedCardButtonCallbackResponse r5) throws IOException {
            StatusCode.ADAPTER.encodeWithTag(r4, 1, r5.mstatus);
            String r0 = r5.mtoast;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AppFeedCardButtonCallbackResponse) r2);
        }
    }

    public static final enum StatusCode extends Enum<StatusCode> implements WireEnum {
        private static final /* synthetic */ StatusCode[] $VALUES = null;
        public static final ProtoAdapter<StatusCode> ADAPTER = null;
        public static final StatusCode FAIL = null;
        public static final StatusCode SUCCESS = null;
        private final int value;

        static {
            StatusCode r0 = new StatusCode("SUCCESS", 0, 0);
            SUCCESS = r0;
            StatusCode r1 = new StatusCode("FAIL", 1, 1);
            FAIL = r1;
            $VALUES = new StatusCode[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(StatusCode.class);
        }

        public static StatusCode[] values() {
            return (StatusCode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StatusCode fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return FAIL;
        L10:
            return SUCCESS;
        }

        public static StatusCode valueOf(String r1) {
            return (StatusCode) a.a(StatusCode.class, r1);
        }

        private StatusCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedCardButtonCallbackResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1693newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mtoast = this.mtoast;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AppFeedCardButtonCallbackResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1693newBuilder();
    }

    public AppFeedCardButtonCallbackResponse(StatusCode r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public AppFeedCardButtonCallbackResponse(StatusCode r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mstatus = r2;
        this.mtoast = r3;
    }
}
