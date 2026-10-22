package com.ss.android.lark.pb.feed;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AppFeedCardButtonCallbackRequest extends Message<AppFeedCardButtonCallbackRequest, Builder> {
    public static final ProtoAdapter<AppFeedCardButtonCallbackRequest> ADAPTER = null;
    public static final String DEFAULT_BUTTON_ID = "";
    private static final long serialVersionUID = 0;
    public final String mbutton_id;

    public static final class Builder extends Message.Builder<AppFeedCardButtonCallbackRequest, Builder> {
        public String mbutton_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AppFeedCardButtonCallbackRequest m1691build() {
            String r0 = this.mbutton_id;
            if (r0 == null) goto L7;
            return new AppFeedCardButtonCallbackRequest(this.mbutton_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mbutton_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1691build();
        }

        public Builder button_id(String r1) {
            this.mbutton_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AppFeedCardButtonCallbackRequest extends ProtoAdapter<AppFeedCardButtonCallbackRequest> {
        public ProtoAdapter_AppFeedCardButtonCallbackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedCardButtonCallbackRequest.class);
        }

        public AppFeedCardButtonCallbackRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mbutton_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mbutton_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1691build();
        }

        public int encodedSize(AppFeedCardButtonCallbackRequest r4) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.mbutton_id) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1692decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AppFeedCardButtonCallbackRequest) r1);
        }

        public void encode(ProtoWriter r4, AppFeedCardButtonCallbackRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mbutton_id);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AppFeedCardButtonCallbackRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedCardButtonCallbackRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1690newBuilder() {
        Builder r0 = new Builder();
        r0.mbutton_id = this.mbutton_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AppFeedCardButtonCallbackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1690newBuilder();
    }

    public AppFeedCardButtonCallbackRequest(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public AppFeedCardButtonCallbackRequest(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mbutton_id = r2;
    }
}
