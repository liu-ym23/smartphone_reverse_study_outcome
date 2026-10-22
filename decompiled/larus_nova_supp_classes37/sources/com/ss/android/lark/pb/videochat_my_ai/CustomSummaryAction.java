package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummaryAction extends Message<CustomSummaryAction, Builder> {
    public static final ProtoAdapter<CustomSummaryAction> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CustomType mcustom_type;
    public final List<CustomSubType> mneed_tabs;

    public static final class Builder extends Message.Builder<CustomSummaryAction, Builder> {
        public CustomType mcustom_type;
        public List<CustomSubType> mneed_tabs;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryAction m3239build() {
            return new CustomSummaryAction(this.mcustom_type, this.mneed_tabs, super.buildUnknownFields());
        }

        public Builder() {
            this.mneed_tabs = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3239build();
        }

        public Builder custom_type(CustomType r1) {
            this.mcustom_type = r1;
            return this;
        }

        public Builder need_tabs(List<CustomSubType> r1) {
            Internal.checkElementsNotNull(r1);
            this.mneed_tabs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryAction extends ProtoAdapter<CustomSummaryAction> {
        public ProtoAdapter_CustomSummaryAction() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryAction.class);
        }

        public CustomSummaryAction decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mcustom_type = (CustomType) CustomType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mneed_tabs.add((CustomSubType) CustomSubType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
            return r0.m3239build();
        }

        public int encodedSize(CustomSummaryAction r5) {
            CustomType r0 = r5.mcustom_type;
            if (r0 == null) goto L5;
            int r1 = CustomType.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + CustomSubType.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mneed_tabs)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3240decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryAction) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryAction r5) throws IOException {
            CustomType r0 = r5.mcustom_type;
            if (r0 == null) goto L5;
            CustomType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            CustomSubType.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mneed_tabs);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryAction) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryAction();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3238newBuilder() {
        Builder r0 = new Builder();
        r0.mcustom_type = this.mcustom_type;
        r0.mneed_tabs = Internal.copyOf("mneed_tabs", this.mneed_tabs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3238newBuilder();
    }

    public CustomSummaryAction(CustomType r2, List<CustomSubType> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CustomSummaryAction(CustomType r2, List<CustomSubType> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcustom_type = r2;
        this.mneed_tabs = Internal.immutableCopyOf("mneed_tabs", r3);
    }
}
