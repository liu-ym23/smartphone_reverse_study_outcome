package com.ss.ugc.live.sdk.platform.bytelink.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TenantPublishers extends AndroidMessage<TenantPublishers, Builder> {
    public static final ProtoAdapter<TenantPublishers> ADAPTER = null;
    public static final Parcelable.Creator<TenantPublishers> CREATOR = null;
    public static final String DEFAULT_FROM_PAGE = "";
    public static final String DEFAULT_TO_PAGE = "";
    public static final String DEFAULT_TRIGGER_REASON = "";
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String from_page;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.PublisherInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<PublisherInfo> publisher_info_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String to_page;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String trigger_reason;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<TenantPublishers, Builder> {
        public String from_page;
        public List<PublisherInfo> publisher_info_list;
        public String to_page;
        public String trigger_reason;
        public Long update_time_ms;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TenantPublishers m1726build() {
            return new TenantPublishers(this.publisher_info_list, this.trigger_reason, this.from_page, this.to_page, this.update_time_ms, super.buildUnknownFields());
        }

        public Builder() {
            this.trigger_reason = "";
            this.from_page = "";
            this.to_page = "";
            this.update_time_ms = 0L;
            this.publisher_info_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1726build();
        }

        public Builder from_page(String r1) {
            this.from_page = r1;
            return this;
        }

        public Builder publisher_info_list(List<PublisherInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.publisher_info_list = r1;
            return this;
        }

        public Builder to_page(String r1) {
            this.to_page = r1;
            return this;
        }

        public Builder trigger_reason(String r1) {
            this.trigger_reason = r1;
            return this;
        }

        public Builder update_time_ms(Long r1) {
            this.update_time_ms = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TenantPublishers extends ProtoAdapter<TenantPublishers> {
        public ProtoAdapter_TenantPublishers() {
            super(FieldEncoding.LENGTH_DELIMITED, TenantPublishers.class);
        }

        public TenantPublishers decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.publisher_info_list.add((PublisherInfo) PublisherInfo.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.trigger_reason((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.from_page((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.to_page((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.update_time_ms((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1726build();
        }

        public int encodedSize(TenantPublishers r5) {
            int r0 = PublisherInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.publisher_info_list);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            return ((((r0 + r1.encodedSizeWithTag(2, r5.trigger_reason)) + r1.encodedSizeWithTag(3, r5.from_page)) + r1.encodedSizeWithTag(4, r5.to_page)) + ProtoAdapter.INT64.encodedSizeWithTag(5, r5.update_time_ms)) + r5.unknownFields().size();
        }

        public TenantPublishers redact(TenantPublishers r3) {
            Builder r4 = r3.m1725newBuilder();
            Internal.redactElements(r4.publisher_info_list, PublisherInfo.ADAPTER);
            r4.clearUnknownFields();
            return r4.m1726build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1727decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TenantPublishers) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((TenantPublishers) r1);
        }

        public void encode(ProtoWriter r4, TenantPublishers r5) throws IOException {
            PublisherInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.publisher_info_list);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.trigger_reason);
            r0.encodeWithTag(r4, 3, r5.from_page);
            r0.encodeWithTag(r4, 4, r5.to_page);
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r5.update_time_ms);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TenantPublishers) r2);
        }
    }

    static {
        ProtoAdapter_TenantPublishers r0 = new ProtoAdapter_TenantPublishers();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_UPDATE_TIME_MS = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = ((unknownFields().hashCode() * 37) + this.publisher_info_list.hashCode()) * 37;
        String r2 = this.trigger_reason;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.from_page;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.to_page;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.update_time_ms;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        ((Message) this).hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1725newBuilder() {
        Builder r0 = new Builder();
        r0.publisher_info_list = Internal.copyOf("publisher_info_list", this.publisher_info_list);
        r0.trigger_reason = this.trigger_reason;
        r0.from_page = this.from_page;
        r0.to_page = this.to_page;
        r0.update_time_ms = this.update_time_ms;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<PublisherInfo> r1 = this.publisher_info_list;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", publisher_info_list=");
        r0.append(this.publisher_info_list);
    L8:
        if (this.trigger_reason == null) goto L11;
        r0.append(", trigger_reason=");
        r0.append(this.trigger_reason);
    L11:
        if (this.from_page == null) goto L14;
        r0.append(", from_page=");
        r0.append(this.from_page);
    L14:
        if (this.to_page == null) goto L17;
        r0.append(", to_page=");
        r0.append(this.to_page);
    L17:
        if (this.update_time_ms == null) goto L19;
        r0.append(", update_time_ms=");
        r0.append(this.update_time_ms);
    L19:
        StringBuilder r2 = r0.replace(0, 2, "TenantPublishers{");
        r2.append('}');
        return r2.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1725newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TenantPublishers) == true) goto L8;
        return false;
    L8:
        TenantPublishers r6 = (TenantPublishers) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (this.publisher_info_list.equals(r6.publisher_info_list) == false) goto L21;
        if (Internal.equals(this.trigger_reason, r6.trigger_reason) == false) goto L21;
        if (Internal.equals(this.from_page, r6.from_page) == false) goto L21;
        if (Internal.equals(this.to_page, r6.to_page) == false) goto L21;
        if (Internal.equals(this.update_time_ms, r6.update_time_ms) == false) goto L21;
        return true;
    }

    public TenantPublishers(List<PublisherInfo> r8, String r9, String r10, String r11, Long r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public TenantPublishers(List<PublisherInfo> r2, String r3, String r4, String r5, Long r6, ByteString r7) {
        super(ADAPTER, r7);
        this.publisher_info_list = Internal.immutableCopyOf("publisher_info_list", r2);
        this.trigger_reason = r3;
        this.from_page = r4;
        this.to_page = r5;
        this.update_time_ms = r6;
    }
}
