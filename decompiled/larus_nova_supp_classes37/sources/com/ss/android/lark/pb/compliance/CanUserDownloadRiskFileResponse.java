package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CanUserDownloadRiskFileResponse extends Message<CanUserDownloadRiskFileResponse, Builder> {
    public static final ProtoAdapter<CanUserDownloadRiskFileResponse> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_DOWNLOAD = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcan_download;

    public static final class Builder extends Message.Builder<CanUserDownloadRiskFileResponse, Builder> {
        public Boolean mcan_download;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CanUserDownloadRiskFileResponse m950build() {
            Boolean r0 = this.mcan_download;
            if (r0 == null) goto L7;
            return new CanUserDownloadRiskFileResponse(this.mcan_download, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mcan_download"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m950build();
        }

        public Builder can_download(Boolean r1) {
            this.mcan_download = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CanUserDownloadRiskFileResponse extends ProtoAdapter<CanUserDownloadRiskFileResponse> {
        public ProtoAdapter_CanUserDownloadRiskFileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CanUserDownloadRiskFileResponse.class);
        }

        public CanUserDownloadRiskFileResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcan_download = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mcan_download = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m950build();
        }

        public int encodedSize(CanUserDownloadRiskFileResponse r4) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.mcan_download) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m951decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CanUserDownloadRiskFileResponse) r1);
        }

        public void encode(ProtoWriter r4, CanUserDownloadRiskFileResponse r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.mcan_download);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CanUserDownloadRiskFileResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CanUserDownloadRiskFileResponse();
        DEFAULT_CAN_DOWNLOAD = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m949newBuilder() {
        Builder r0 = new Builder();
        r0.mcan_download = this.mcan_download;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CanUserDownloadRiskFileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m949newBuilder();
    }

    public CanUserDownloadRiskFileResponse(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public CanUserDownloadRiskFileResponse(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mcan_download = r2;
    }
}
