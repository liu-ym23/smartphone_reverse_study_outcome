package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MarqueeFilter extends Message<MarqueeFilter, Builder> {
    public static final ProtoAdapter<MarqueeFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MessageFilter.FromUserFilter mmessage_from_user_filter;
    public final MessageFilter.TimeFilter mmessage_time_filter;

    public static final class Builder extends Message.Builder<MarqueeFilter, Builder> {
        public MessageFilter.FromUserFilter mmessage_from_user_filter;
        public MessageFilter.TimeFilter mmessage_time_filter;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MarqueeFilter m2681build() {
            return new MarqueeFilter(this.mmessage_time_filter, this.mmessage_from_user_filter, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2681build();
        }

        public Builder message_from_user_filter(MessageFilter.FromUserFilter r1) {
            this.mmessage_from_user_filter = r1;
            this.mmessage_time_filter = null;
            return this;
        }

        public Builder message_time_filter(MessageFilter.TimeFilter r1) {
            this.mmessage_time_filter = r1;
            this.mmessage_from_user_filter = null;
            return this;
        }
    }

    public static final class ProtoAdapter_MarqueeFilter extends ProtoAdapter<MarqueeFilter> {
        public ProtoAdapter_MarqueeFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, MarqueeFilter.class);
        }

        public MarqueeFilter decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.message_time_filter((MessageFilter.TimeFilter) MessageFilter.TimeFilter.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.message_from_user_filter((MessageFilter.FromUserFilter) MessageFilter.FromUserFilter.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2681build();
        }

        public int encodedSize(MarqueeFilter r5) {
            MessageFilter.TimeFilter r0 = r5.mmessage_time_filter;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = MessageFilter.TimeFilter.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            MessageFilter.FromUserFilter r3 = r5.mmessage_from_user_filter;
            if (r3 == null) goto L10;
            r1 = MessageFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2682decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MarqueeFilter) r1);
        }

        public void encode(ProtoWriter r4, MarqueeFilter r5) throws IOException {
            MessageFilter.TimeFilter r0 = r5.mmessage_time_filter;
            if (r0 == null) goto L5;
            MessageFilter.TimeFilter.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            MessageFilter.FromUserFilter r1 = r5.mmessage_from_user_filter;
            if (r1 == null) goto L8;
            MessageFilter.FromUserFilter.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MarqueeFilter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MarqueeFilter();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2680newBuilder() {
        Builder r0 = new Builder();
        r0.mmessage_time_filter = this.mmessage_time_filter;
        r0.mmessage_from_user_filter = this.mmessage_from_user_filter;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MarqueeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2680newBuilder();
    }

    public MarqueeFilter(MessageFilter.TimeFilter r2, MessageFilter.FromUserFilter r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public MarqueeFilter(MessageFilter.TimeFilter r2, MessageFilter.FromUserFilter r3, ByteString r4) {
        super(ADAPTER, r4);
        if (Internal.countNonNull(r2, r3) > 1) goto L7;
        this.mmessage_time_filter = r2;
        this.mmessage_from_user_filter = r3;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mmessage_time_filter, mmessage_from_user_filter may be non-null");
    }
}
