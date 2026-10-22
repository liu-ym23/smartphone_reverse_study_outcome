package com.ss.android.lark.pb.compliance;

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
public final class CanUserDownloadRiskFileRequest extends Message<CanUserDownloadRiskFileRequest, Builder> {
    public static final ProtoAdapter<CanUserDownloadRiskFileRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FileOperateUsage mop_usage;
    public final SourceTerminal msource_terminal;

    public static final class Builder extends Message.Builder<CanUserDownloadRiskFileRequest, Builder> {
        public FileOperateUsage mop_usage;
        public SourceTerminal msource_terminal;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CanUserDownloadRiskFileRequest m947build() {
            FileOperateUsage r0 = this.mop_usage;
            if (r0 == null) goto L9;
            if (this.msource_terminal == null) goto L9;
            return new CanUserDownloadRiskFileRequest(this.mop_usage, this.msource_terminal, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mop_usage", this.msource_terminal, "msource_terminal"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m947build();
        }

        public Builder op_usage(FileOperateUsage r1) {
            this.mop_usage = r1;
            return this;
        }

        public Builder source_terminal(SourceTerminal r1) {
            this.msource_terminal = r1;
            return this;
        }
    }

    public static final enum FileOperateUsage extends Enum<FileOperateUsage> implements WireEnum {
        private static final /* synthetic */ FileOperateUsage[] $VALUES = null;
        public static final ProtoAdapter<FileOperateUsage> ADAPTER = null;
        public static final FileOperateUsage Download = null;
        public static final FileOperateUsage Preview = null;
        public static final FileOperateUsage TransCode = null;
        public static final FileOperateUsage Unspecified = null;
        private final int value;

        static {
            FileOperateUsage r0 = new FileOperateUsage("Unspecified", 0, 0);
            Unspecified = r0;
            FileOperateUsage r1 = new FileOperateUsage("Download", 1, 1);
            Download = r1;
            FileOperateUsage r3 = new FileOperateUsage("Preview", 2, 2);
            Preview = r3;
            FileOperateUsage r5 = new FileOperateUsage("TransCode", 3, 3);
            TransCode = r5;
            $VALUES = new FileOperateUsage[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileOperateUsage.class);
        }

        public static FileOperateUsage[] values() {
            return (FileOperateUsage[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FileOperateUsage fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return TransCode;
        L14:
            return Preview;
        L16:
            return Download;
        L18:
            return Unspecified;
        }

        public static FileOperateUsage valueOf(String r1) {
            return (FileOperateUsage) a.a(FileOperateUsage.class, r1);
        }

        private FileOperateUsage(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_CanUserDownloadRiskFileRequest extends ProtoAdapter<CanUserDownloadRiskFileRequest> {
        public ProtoAdapter_CanUserDownloadRiskFileRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CanUserDownloadRiskFileRequest.class);
        }

        public CanUserDownloadRiskFileRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mop_usage = (FileOperateUsage) FileOperateUsage.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.msource_terminal = (SourceTerminal) SourceTerminal.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m947build();
        }

        public int encodedSize(CanUserDownloadRiskFileRequest r5) {
            return (FileOperateUsage.ADAPTER.encodedSizeWithTag(1, r5.mop_usage) + SourceTerminal.ADAPTER.encodedSizeWithTag(2, r5.msource_terminal)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m948decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CanUserDownloadRiskFileRequest) r1);
        }

        public void encode(ProtoWriter r4, CanUserDownloadRiskFileRequest r5) throws IOException {
            FileOperateUsage.ADAPTER.encodeWithTag(r4, 1, r5.mop_usage);
            SourceTerminal.ADAPTER.encodeWithTag(r4, 2, r5.msource_terminal);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CanUserDownloadRiskFileRequest) r2);
        }
    }

    public static final enum SourceTerminal extends Enum<SourceTerminal> implements WireEnum {
        private static final /* synthetic */ SourceTerminal[] $VALUES = null;
        public static final ProtoAdapter<SourceTerminal> ADAPTER = null;
        public static final SourceTerminal Browser = null;
        public static final SourceTerminal Mobile = null;
        public static final SourceTerminal PC = null;
        public static final SourceTerminal Unknown = null;
        private final int value;

        static {
            SourceTerminal r0 = new SourceTerminal("Unknown", 0, 0);
            Unknown = r0;
            SourceTerminal r1 = new SourceTerminal("Browser", 1, 1);
            Browser = r1;
            SourceTerminal r3 = new SourceTerminal("PC", 2, 2);
            PC = r3;
            SourceTerminal r5 = new SourceTerminal("Mobile", 3, 3);
            Mobile = r5;
            $VALUES = new SourceTerminal[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceTerminal.class);
        }

        public static SourceTerminal[] values() {
            return (SourceTerminal[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SourceTerminal fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return Mobile;
        L14:
            return PC;
        L16:
            return Browser;
        L18:
            return Unknown;
        }

        public static SourceTerminal valueOf(String r1) {
            return (SourceTerminal) a.a(SourceTerminal.class, r1);
        }

        private SourceTerminal(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CanUserDownloadRiskFileRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m946newBuilder() {
        Builder r0 = new Builder();
        r0.mop_usage = this.mop_usage;
        r0.msource_terminal = this.msource_terminal;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CanUserDownloadRiskFileRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m946newBuilder();
    }

    public CanUserDownloadRiskFileRequest(FileOperateUsage r2, SourceTerminal r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CanUserDownloadRiskFileRequest(FileOperateUsage r2, SourceTerminal r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mop_usage = r2;
        this.msource_terminal = r3;
    }
}
