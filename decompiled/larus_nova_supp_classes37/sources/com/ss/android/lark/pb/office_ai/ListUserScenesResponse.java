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
public final class ListUserScenesResponse extends Message<ListUserScenesResponse, Builder> {
    public static final ProtoAdapter<ListUserScenesResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_PAGE_OFFSET = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_more;
    public final Long mpage_offset;
    public final List<MyAIScene> mscene;

    public static final class Builder extends Message.Builder<ListUserScenesResponse, Builder> {
        public Boolean mhas_more;
        public Long mpage_offset;
        public List<MyAIScene> mscene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ListUserScenesResponse m1967build() {
            return new ListUserScenesResponse(this.mscene, this.mhas_more, this.mpage_offset, super.buildUnknownFields());
        }

        public Builder() {
            this.mscene = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1967build();
        }

        public Builder has_more(Boolean r1) {
            this.mhas_more = r1;
            return this;
        }

        public Builder page_offset(Long r1) {
            this.mpage_offset = r1;
            return this;
        }

        public Builder scene(List<MyAIScene> r1) {
            Internal.checkElementsNotNull(r1);
            this.mscene = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ListUserScenesResponse extends ProtoAdapter<ListUserScenesResponse> {
        public ProtoAdapter_ListUserScenesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ListUserScenesResponse.class);
        }

        public ListUserScenesResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhas_more = Boolean.FALSE;
            r0.mpage_offset = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mscene.add((MyAIScene) MyAIScene.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mhas_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mpage_offset = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1967build();
        }

        public int encodedSize(ListUserScenesResponse r6) {
            int r0 = MyAIScene.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mscene);
            Boolean r1 = r6.mhas_more;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Long r5 = r6.mpage_offset;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.INT64.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1968decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ListUserScenesResponse) r1);
        }

        public void encode(ProtoWriter r4, ListUserScenesResponse r5) throws IOException {
            MyAIScene.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mscene);
            Boolean r0 = r5.mhas_more;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
        L5:
            Long r1 = r5.mpage_offset;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ListUserScenesResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ListUserScenesResponse();
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_PAGE_OFFSET = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1966newBuilder() {
        Builder r0 = new Builder();
        r0.mscene = Internal.copyOf("mscene", this.mscene);
        r0.mhas_more = this.mhas_more;
        r0.mpage_offset = this.mpage_offset;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ListUserScenesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1966newBuilder();
    }

    public ListUserScenesResponse(List<MyAIScene> r2, Boolean r3, Long r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ListUserScenesResponse(List<MyAIScene> r2, Boolean r3, Long r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mscene = Internal.immutableCopyOf("mscene", r2);
        this.mhas_more = r3;
        this.mpage_offset = r4;
    }
}
