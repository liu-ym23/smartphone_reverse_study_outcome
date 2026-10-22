package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutMessageLinkRequest extends Message<PutMessageLinkRequest, Builder> {
    public static final ProtoAdapter<PutMessageLinkRequest> ADAPTER = null;
    public static final Long DEFAULT_FROM_ID = null;
    private static final long serialVersionUID = 0;
    public final List<Long> mcopied_id;
    public final LinkFrom mfrom;
    public final Long mfrom_id;

    public static final class Builder extends Message.Builder<PutMessageLinkRequest, Builder> {
        public List<Long> mcopied_id;
        public LinkFrom mfrom;
        public Long mfrom_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutMessageLinkRequest m1823build() {
            Long r0 = this.mfrom_id;
            if (r0 == null) goto L9;
            if (this.mfrom == null) goto L9;
            return new PutMessageLinkRequest(this.mfrom_id, this.mfrom, this.mcopied_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mfrom_id", this.mfrom, "mfrom"});
        }

        public Builder() {
            this.mcopied_id = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1823build();
        }

        public Builder copied_id(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcopied_id = r1;
            return this;
        }

        public Builder from(LinkFrom r1) {
            this.mfrom = r1;
            return this;
        }

        public Builder from_id(Long r1) {
            this.mfrom_id = r1;
            return this;
        }
    }

    public static final enum LinkFrom extends Enum<LinkFrom> implements WireEnum {
        private static final /* synthetic */ LinkFrom[] $VALUES = null;
        public static final ProtoAdapter<LinkFrom> ADAPTER = null;
        public static final LinkFrom CHAT = null;
        public static final LinkFrom MESSAGE_THREAD = null;
        public static final LinkFrom THREAD = null;
        private final int value;

        static {
            LinkFrom r0 = new LinkFrom("CHAT", 0, 1);
            CHAT = r0;
            LinkFrom r1 = new LinkFrom("THREAD", 1, 2);
            THREAD = r1;
            LinkFrom r4 = new LinkFrom("MESSAGE_THREAD", 2, 3);
            MESSAGE_THREAD = r4;
            $VALUES = new LinkFrom[]{r0, r1, r4};
            ADAPTER = ProtoAdapter.newEnumAdapter(LinkFrom.class);
        }

        public static LinkFrom[] values() {
            return (LinkFrom[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static LinkFrom fromValue(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return MESSAGE_THREAD;
        L13:
            return THREAD;
        L15:
            return CHAT;
        }

        public static LinkFrom valueOf(String r1) {
            return (LinkFrom) a.a(LinkFrom.class, r1);
        }

        private LinkFrom(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_PutMessageLinkRequest extends ProtoAdapter<PutMessageLinkRequest> {
        public ProtoAdapter_PutMessageLinkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutMessageLinkRequest.class);
        }

        public PutMessageLinkRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mfrom_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mfrom_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mfrom = (LinkFrom) LinkFrom.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mcopied_id.add((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1823build();
        }

        public int encodedSize(PutMessageLinkRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return ((r0.encodedSizeWithTag(1, r6.mfrom_id) + LinkFrom.ADAPTER.encodedSizeWithTag(2, r6.mfrom)) + r0.asRepeated().encodedSizeWithTag(3, r6.mcopied_id)) + r6.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1824decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutMessageLinkRequest) r1);
        }

        public void encode(ProtoWriter r5, PutMessageLinkRequest r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.mfrom_id);
            LinkFrom.ADAPTER.encodeWithTag(r5, 2, r6.mfrom);
            r0.asRepeated().encodeWithTag(r5, 3, r6.mcopied_id);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutMessageLinkRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutMessageLinkRequest();
        DEFAULT_FROM_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1822newBuilder() {
        Builder r0 = new Builder();
        r0.mfrom_id = this.mfrom_id;
        r0.mfrom = this.mfrom;
        r0.mcopied_id = Internal.copyOf("mcopied_id", this.mcopied_id);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutMessageLinkRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1822newBuilder();
    }

    public PutMessageLinkRequest(Long r2, LinkFrom r3, List<Long> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PutMessageLinkRequest(Long r2, LinkFrom r3, List<Long> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mfrom_id = r2;
        this.mfrom = r3;
        this.mcopied_id = Internal.immutableCopyOf("mcopied_id", r4);
    }
}
