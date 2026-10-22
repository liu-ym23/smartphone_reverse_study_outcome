package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AdvGrammarSelectorResult extends Message<AdvGrammarSelectorResult, Builder> {
    public static final ProtoAdapter<AdvGrammarSelectorResult> ADAPTER = null;
    public static final Integer DEFAULT_END_INDEX = null;
    public static final Integer DEFAULT_START_INDEX = null;
    private static final long serialVersionUID = 0;
    public final Integer mend_index;
    public final SearchResult mresult_meta;
    public final AdvGrammarConf.SelectorType mselectorType;
    public final Integer mstart_index;

    public static final class Builder extends Message.Builder<AdvGrammarSelectorResult, Builder> {
        public Integer mend_index;
        public SearchResult mresult_meta;
        public AdvGrammarConf.SelectorType mselectorType;
        public Integer mstart_index;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AdvGrammarSelectorResult m2501build() {
            return new AdvGrammarSelectorResult(this.mstart_index, this.mend_index, this.mresult_meta, this.mselectorType, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2501build();
        }

        public Builder end_index(Integer r1) {
            this.mend_index = r1;
            return this;
        }

        public Builder result_meta(SearchResult r1) {
            this.mresult_meta = r1;
            return this;
        }

        public Builder selectorType(AdvGrammarConf.SelectorType r1) {
            this.mselectorType = r1;
            return this;
        }

        public Builder start_index(Integer r1) {
            this.mstart_index = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AdvGrammarSelectorResult extends ProtoAdapter<AdvGrammarSelectorResult> {
        public ProtoAdapter_AdvGrammarSelectorResult() {
            super(FieldEncoding.LENGTH_DELIMITED, AdvGrammarSelectorResult.class);
        }

        public AdvGrammarSelectorResult decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mstart_index = 0;
            r0.mend_index = 0;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mstart_index = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mend_index = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mresult_meta = (SearchResult) SearchResult.ADAPTER.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mselectorType = (AdvGrammarConf.SelectorType) AdvGrammarConf.SelectorType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2501build();
        }

        public int encodedSize(AdvGrammarSelectorResult r6) {
            Integer r0 = r6.mstart_index;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mend_index;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            SearchResult r7 = r6.mresult_meta;
            if (r7 == null) goto L13;
            int r8 = SearchResult.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            AdvGrammarConf.SelectorType r10 = r6.mselectorType;
            if (r10 == null) goto L18;
            r1 = AdvGrammarConf.SelectorType.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2502decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AdvGrammarSelectorResult) r1);
        }

        public void encode(ProtoWriter r4, AdvGrammarSelectorResult r5) throws IOException {
            Integer r0 = r5.mstart_index;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mend_index;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            SearchResult r2 = r5.mresult_meta;
            if (r2 == null) goto L11;
            SearchResult.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            AdvGrammarConf.SelectorType r3 = r5.mselectorType;
            if (r3 == null) goto L14;
            AdvGrammarConf.SelectorType.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AdvGrammarSelectorResult) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AdvGrammarSelectorResult();
        DEFAULT_START_INDEX = 0;
        DEFAULT_END_INDEX = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2500newBuilder() {
        Builder r0 = new Builder();
        r0.mstart_index = this.mstart_index;
        r0.mend_index = this.mend_index;
        r0.mresult_meta = this.mresult_meta;
        r0.mselectorType = this.mselectorType;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AdvGrammarSelectorResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2500newBuilder();
    }

    public AdvGrammarSelectorResult(Integer r7, Integer r8, SearchResult r9, AdvGrammarConf.SelectorType r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public AdvGrammarSelectorResult(Integer r2, Integer r3, SearchResult r4, AdvGrammarConf.SelectorType r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mstart_index = r2;
        this.mend_index = r3;
        this.mresult_meta = r4;
        this.mselectorType = r5;
    }
}
