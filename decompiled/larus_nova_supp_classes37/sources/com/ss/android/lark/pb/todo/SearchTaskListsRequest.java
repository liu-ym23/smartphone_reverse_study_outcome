package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchTaskListsRequest extends Message<SearchTaskListsRequest, Builder> {
    public static final ProtoAdapter<SearchTaskListsRequest> ADAPTER = null;
    public static final String DEFAULT_AGENT_ID = "";
    public static final Long DEFAULT_COUNT = null;
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String magent_id;
    public final Long mcount;
    public final String mquery;
    public final Scene mscene;

    public static final class Builder extends Message.Builder<SearchTaskListsRequest, Builder> {
        public String magent_id;
        public Long mcount;
        public String mquery;
        public Scene mscene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchTaskListsRequest m2231build() {
            return new SearchTaskListsRequest(this.mscene, this.mquery, this.mcount, this.magent_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2231build();
        }

        public Builder agent_id(String r1) {
            this.magent_id = r1;
            return this;
        }

        public Builder count(Long r1) {
            this.mcount = r1;
            return this;
        }

        public Builder query(String r1) {
            this.mquery = r1;
            return this;
        }

        public Builder scene(Scene r1) {
            this.mscene = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTaskListsRequest extends ProtoAdapter<SearchTaskListsRequest> {
        public ProtoAdapter_SearchTaskListsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTaskListsRequest.class);
        }

        public SearchTaskListsRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mquery = "";
            r0.mcount = 0L;
            r0.magent_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mscene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mquery = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcount = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.magent_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2231build();
        }

        public int encodedSize(SearchTaskListsRequest r6) {
            Scene r0 = r6.mscene;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Scene.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mquery;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.mcount;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.magent_id;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m2232decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchTaskListsRequest) r1);
        }

        public void encode(ProtoWriter r4, SearchTaskListsRequest r5) throws IOException {
            Scene r0 = r5.mscene;
            if (r0 == null) goto L5;
            Scene.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mquery;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.mcount;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.magent_id;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchTaskListsRequest) r2);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene EDITABLE = null;
        public static final Scene READABLE = null;
        private final int value;

        static {
            Scene r0 = new Scene("READABLE", 0, 1);
            READABLE = r0;
            Scene r1 = new Scene("EDITABLE", 1, 2);
            EDITABLE = r1;
            $VALUES = new Scene[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return EDITABLE;
        L11:
            return READABLE;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchTaskListsRequest();
        DEFAULT_COUNT = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2230newBuilder() {
        Builder r0 = new Builder();
        r0.mscene = this.mscene;
        r0.mquery = this.mquery;
        r0.mcount = this.mcount;
        r0.magent_id = this.magent_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchTaskListsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2230newBuilder();
    }

    public SearchTaskListsRequest(Scene r7, String r8, Long r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SearchTaskListsRequest(Scene r2, String r3, Long r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mscene = r2;
        this.mquery = r3;
        this.mcount = r4;
        this.magent_id = r5;
    }
}
