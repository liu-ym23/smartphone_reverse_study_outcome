package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AIViewExportData extends Message<AIViewExportData, Builder> {
    public static final ProtoAdapter<AIViewExportData> ADAPTER = null;
    public static final String DEFAULT_EXPORT_TASK_ID = "";
    public static final String DEFAULT_EXPORT_URL = "";
    private static final long serialVersionUID = 0;
    public final ExportStatus mexport_status;
    public final String mexport_task_id;
    public final String mexport_url;

    public static final class Builder extends Message.Builder<AIViewExportData, Builder> {
        public ExportStatus mexport_status;
        public String mexport_task_id;
        public String mexport_url;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AIViewExportData m3236build() {
            return new AIViewExportData(this.mexport_task_id, this.mexport_url, this.mexport_status, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3236build();
        }

        public Builder export_status(ExportStatus r1) {
            this.mexport_status = r1;
            return this;
        }

        public Builder export_task_id(String r1) {
            this.mexport_task_id = r1;
            return this;
        }

        public Builder export_url(String r1) {
            this.mexport_url = r1;
            return this;
        }
    }

    public static final enum ExportStatus extends Enum<ExportStatus> implements WireEnum {
        private static final /* synthetic */ ExportStatus[] $VALUES = null;
        public static final ProtoAdapter<ExportStatus> ADAPTER = null;
        public static final ExportStatus FAIL = null;
        public static final ExportStatus SUCCESS = null;
        public static final ExportStatus UNKNOWN = null;
        private final int value;

        static {
            ExportStatus r0 = new ExportStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ExportStatus r1 = new ExportStatus("SUCCESS", 1, 1);
            SUCCESS = r1;
            ExportStatus r3 = new ExportStatus("FAIL", 2, 2);
            FAIL = r3;
            $VALUES = new ExportStatus[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExportStatus.class);
        }

        public static ExportStatus[] values() {
            return (ExportStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ExportStatus fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return FAIL;
        L12:
            return SUCCESS;
        L14:
            return UNKNOWN;
        }

        public static ExportStatus valueOf(String r1) {
            return (ExportStatus) a.a(ExportStatus.class, r1);
        }

        private ExportStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_AIViewExportData extends ProtoAdapter<AIViewExportData> {
        public ProtoAdapter_AIViewExportData() {
            super(FieldEncoding.LENGTH_DELIMITED, AIViewExportData.class);
        }

        public AIViewExportData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mexport_task_id = "";
            r0.mexport_url = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mexport_task_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mexport_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mexport_status = (ExportStatus) ExportStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m3236build();
        }

        public int encodedSize(AIViewExportData r6) {
            String r0 = r6.mexport_task_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mexport_url;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ExportStatus r7 = r6.mexport_status;
            if (r7 == null) goto L14;
            r1 = ExportStatus.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3237decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AIViewExportData) r1);
        }

        public void encode(ProtoWriter r4, AIViewExportData r5) throws IOException {
            String r0 = r5.mexport_task_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mexport_url;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            ExportStatus r2 = r5.mexport_status;
            if (r2 == null) goto L11;
            ExportStatus.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AIViewExportData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIViewExportData();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3235newBuilder() {
        Builder r0 = new Builder();
        r0.mexport_task_id = this.mexport_task_id;
        r0.mexport_url = this.mexport_url;
        r0.mexport_status = this.mexport_status;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AIViewExportData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3235newBuilder();
    }

    public AIViewExportData(String r2, String r3, ExportStatus r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public AIViewExportData(String r2, String r3, ExportStatus r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mexport_task_id = r2;
        this.mexport_url = r3;
        this.mexport_status = r4;
    }
}
