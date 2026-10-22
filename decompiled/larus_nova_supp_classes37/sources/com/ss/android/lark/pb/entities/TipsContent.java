package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TipsContent extends com.squareup.wire.Message<TipsContent, Builder> {
    public static final ProtoAdapter<TipsContent> ADAPTER = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<ActionInfo> mactions;
    public final Map<String, String> mi18n_msg;
    public final Map<String, String> mi18n_title;
    public final Long mversion;

    public static final class Builder extends com.squareup.wire.Message.Builder<TipsContent, Builder> {
        public List<ActionInfo> mactions;
        public Map<String, String> mi18n_msg;
        public Map<String, String> mi18n_title;
        public Long mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TipsContent m1565build() {
            return new TipsContent(this.mversion, this.mi18n_title, this.mi18n_msg, this.mactions, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_title = Internal.newMutableMap();
            this.mi18n_msg = Internal.newMutableMap();
            this.mactions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1565build();
        }

        public Builder actions(List<ActionInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mactions = r1;
            return this;
        }

        public Builder i18n_msg(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_msg = r1;
            return this;
        }

        public Builder i18n_title(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_title = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TipsContent extends ProtoAdapter<TipsContent> {
        private final ProtoAdapter<Map<String, String>> mi18n_msg;
        private final ProtoAdapter<Map<String, String>> mi18n_title;

        public ProtoAdapter_TipsContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TipsContent.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_title = ProtoAdapter.newMapAdapter(r0, r0);
            this.mi18n_msg = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public TipsContent decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mversion = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mi18n_title.putAll((Map) this.mi18n_title.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mi18n_msg.putAll((Map) this.mi18n_msg.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mactions.add((ActionInfo) ActionInfo.ADAPTER.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1565build();
        }

        public int encodedSize(TipsContent r5) {
            Long r0 = r5.mversion;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L7:
            return (((r1 + this.mi18n_title.encodedSizeWithTag(2, r5.mi18n_title)) + this.mi18n_msg.encodedSizeWithTag(3, r5.mi18n_msg)) + ActionInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.mactions)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1566decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TipsContent) r1);
        }

        public void encode(ProtoWriter r4, TipsContent r5) throws IOException {
            Long r0 = r5.mversion;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            this.mi18n_title.encodeWithTag(r4, 2, r5.mi18n_title);
            this.mi18n_msg.encodeWithTag(r4, 3, r5.mi18n_msg);
            ActionInfo.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mactions);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TipsContent) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TipsContent();
        DEFAULT_VERSION = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1564newBuilder() {
        Builder r0 = new Builder();
        r0.mversion = this.mversion;
        r0.mi18n_title = Internal.copyOf("mi18n_title", this.mi18n_title);
        r0.mi18n_msg = Internal.copyOf("mi18n_msg", this.mi18n_msg);
        r0.mactions = Internal.copyOf("mactions", this.mactions);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TipsContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1564newBuilder();
    }

    public TipsContent(Long r7, Map<String, String> r8, Map<String, String> r9, List<ActionInfo> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public TipsContent(Long r2, Map<String, String> r3, Map<String, String> r4, List<ActionInfo> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mversion = r2;
        this.mi18n_title = Internal.immutableCopyOf("mi18n_title", r3);
        this.mi18n_msg = Internal.immutableCopyOf("mi18n_msg", r4);
        this.mactions = Internal.immutableCopyOf("mactions", r5);
    }
}
