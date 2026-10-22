package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.todo_entities.ContainerMetaData;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchTaskListsResponse extends Message<SearchTaskListsResponse, Builder> {
    public static final ProtoAdapter<SearchTaskListsResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContainerMetaData> mmeta_data;

    public static final class Builder extends Message.Builder<SearchTaskListsResponse, Builder> {
        public List<ContainerMetaData> mmeta_data;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchTaskListsResponse m2234build() {
            return new SearchTaskListsResponse(this.mmeta_data, super.buildUnknownFields());
        }

        public Builder() {
            this.mmeta_data = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2234build();
        }

        public Builder meta_data(List<ContainerMetaData> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmeta_data = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTaskListsResponse extends ProtoAdapter<SearchTaskListsResponse> {
        public ProtoAdapter_SearchTaskListsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTaskListsResponse.class);
        }

        public SearchTaskListsResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmeta_data.add((ContainerMetaData) ContainerMetaData.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2234build();
        }

        public int encodedSize(SearchTaskListsResponse r4) {
            return ContainerMetaData.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mmeta_data) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2235decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchTaskListsResponse) r1);
        }

        public void encode(ProtoWriter r4, SearchTaskListsResponse r5) throws IOException {
            ContainerMetaData.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mmeta_data);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchTaskListsResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchTaskListsResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2233newBuilder() {
        Builder r0 = new Builder();
        r0.mmeta_data = Internal.copyOf("mmeta_data", this.mmeta_data);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchTaskListsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2233newBuilder();
    }

    public SearchTaskListsResponse(List<ContainerMetaData> r2) {
        this(r2, ByteString.EMPTY);
    }

    public SearchTaskListsResponse(List<ContainerMetaData> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmeta_data = Internal.immutableCopyOf("mmeta_data", r2);
    }
}
