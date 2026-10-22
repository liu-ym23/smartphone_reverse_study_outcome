package com.ss.android.lark.pb.office_ai;

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
public final class SearchToolResponse extends Message<SearchToolResponse, Builder> {
    public static final ProtoAdapter<SearchToolResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_more;
    public final List<ToolInfo> mtool_list;

    public static final class Builder extends Message.Builder<SearchToolResponse, Builder> {
        public Boolean mhas_more;
        public List<ToolInfo> mtool_list;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchToolResponse m2021build() {
            return new SearchToolResponse(this.mtool_list, this.mhas_more, super.buildUnknownFields());
        }

        public Builder() {
            this.mtool_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2021build();
        }

        public Builder has_more(Boolean r1) {
            this.mhas_more = r1;
            return this;
        }

        public Builder tool_list(List<ToolInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtool_list = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchToolResponse extends ProtoAdapter<SearchToolResponse> {
        public ProtoAdapter_SearchToolResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchToolResponse.class);
        }

        public SearchToolResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhas_more = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtool_list.add((ToolInfo) ToolInfo.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mhas_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2021build();
        }

        public int encodedSize(SearchToolResponse r5) {
            int r0 = ToolInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mtool_list);
            Boolean r1 = r5.mhas_more;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2022decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchToolResponse) r1);
        }

        public void encode(ProtoWriter r4, SearchToolResponse r5) throws IOException {
            ToolInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mtool_list);
            Boolean r0 = r5.mhas_more;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchToolResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchToolResponse();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2020newBuilder() {
        Builder r0 = new Builder();
        r0.mtool_list = Internal.copyOf("mtool_list", this.mtool_list);
        r0.mhas_more = this.mhas_more;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchToolResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2020newBuilder();
    }

    public SearchToolResponse(List<ToolInfo> r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SearchToolResponse(List<ToolInfo> r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtool_list = Internal.immutableCopyOf("mtool_list", r2);
        this.mhas_more = r3;
    }
}
