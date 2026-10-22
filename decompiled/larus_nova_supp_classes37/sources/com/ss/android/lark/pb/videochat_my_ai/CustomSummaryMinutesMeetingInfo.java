package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummaryMinutesMeetingInfo extends Message<CustomSummaryMinutesMeetingInfo, Builder> {
    public static final ProtoAdapter<CustomSummaryMinutesMeetingInfo> ADAPTER = null;
    public static final String DEFAULT_HARDWARE_TITLE = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mhardware_title;
    public final String mtitle;

    public static final class Builder extends Message.Builder<CustomSummaryMinutesMeetingInfo, Builder> {
        public String mhardware_title;
        public String mtitle;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryMinutesMeetingInfo m3257build() {
            return new CustomSummaryMinutesMeetingInfo(this.mhardware_title, this.mtitle, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3257build();
        }

        public Builder hardware_title(String r1) {
            this.mhardware_title = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryMinutesMeetingInfo extends ProtoAdapter<CustomSummaryMinutesMeetingInfo> {
        public ProtoAdapter_CustomSummaryMinutesMeetingInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryMinutesMeetingInfo.class);
        }

        public CustomSummaryMinutesMeetingInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhardware_title = "";
            r0.mtitle = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mhardware_title = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3257build();
        }

        public int encodedSize(CustomSummaryMinutesMeetingInfo r5) {
            String r0 = r5.mhardware_title;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mtitle;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3258decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryMinutesMeetingInfo) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryMinutesMeetingInfo r5) throws IOException {
            String r0 = r5.mhardware_title;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtitle;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryMinutesMeetingInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryMinutesMeetingInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3256newBuilder() {
        Builder r0 = new Builder();
        r0.mhardware_title = this.mhardware_title;
        r0.mtitle = this.mtitle;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryMinutesMeetingInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3256newBuilder();
    }

    public CustomSummaryMinutesMeetingInfo(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CustomSummaryMinutesMeetingInfo(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mhardware_title = r2;
        this.mtitle = r3;
    }
}
