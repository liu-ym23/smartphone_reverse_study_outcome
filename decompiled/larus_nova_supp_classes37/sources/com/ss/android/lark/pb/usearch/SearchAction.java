package com.ss.android.lark.pb.usearch;

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
public final class SearchAction extends Message<SearchAction, Builder> {
    public static final ProtoAdapter<SearchAction> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final Boolean DEFAULT_CAPSULE_RECOMMEND_ENABLE = null;
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String mapp_id;
    public final Boolean mcapsule_recommend_enable;
    public final List<SearchActionFilter> mfilters;
    public final String mquery;
    public final com.ss.android.lark.pb.searches.SearchTabName mtab;

    public static final class Builder extends Message.Builder<SearchAction, Builder> {
        public String mapp_id;
        public Boolean mcapsule_recommend_enable;
        public List<SearchActionFilter> mfilters;
        public String mquery;
        public com.ss.android.lark.pb.searches.SearchTabName mtab;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchAction m2804build() {
            return new SearchAction(this.mquery, this.mtab, this.mfilters, this.mapp_id, this.mcapsule_recommend_enable, super.buildUnknownFields());
        }

        public Builder() {
            this.mfilters = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2804build();
        }

        public Builder app_id(String r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder capsule_recommend_enable(Boolean r1) {
            this.mcapsule_recommend_enable = r1;
            return this;
        }

        public Builder filters(List<SearchActionFilter> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfilters = r1;
            return this;
        }

        public Builder query(String r1) {
            this.mquery = r1;
            return this;
        }

        public Builder tab(com.ss.android.lark.pb.searches.SearchTabName r1) {
            this.mtab = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchAction extends ProtoAdapter<SearchAction> {
        public ProtoAdapter_SearchAction() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchAction.class);
        }

        public SearchAction decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mquery = "";
            r0.mapp_id = "";
            r0.mcapsule_recommend_enable = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mquery = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtab = (com.ss.android.lark.pb.searches.SearchTabName) com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfilters.add((SearchActionFilter) SearchActionFilter.ADAPTER.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mapp_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mcapsule_recommend_enable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m2804build();
        }

        public int encodedSize(SearchAction r6) {
            String r0 = r6.mquery;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            com.ss.android.lark.pb.searches.SearchTabName r3 = r6.mtab;
            if (r3 == null) goto L9;
            int r4 = com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = (r2 + r4) + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.mfilters);
            String r7 = r6.mapp_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(4, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mcapsule_recommend_enable;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r10);
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
        public /* bridge */ /* synthetic */ Object m2805decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchAction) r1);
        }

        public void encode(ProtoWriter r4, SearchAction r5) throws IOException {
            String r0 = r5.mquery;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            com.ss.android.lark.pb.searches.SearchTabName r1 = r5.mtab;
            if (r1 == null) goto L8;
            com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mfilters);
            String r2 = r5.mapp_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            Boolean r3 = r5.mcapsule_recommend_enable;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchAction) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchAction();
        DEFAULT_CAPSULE_RECOMMEND_ENABLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2803newBuilder() {
        Builder r0 = new Builder();
        r0.mquery = this.mquery;
        r0.mtab = this.mtab;
        r0.mfilters = Internal.copyOf("mfilters", this.mfilters);
        r0.mapp_id = this.mapp_id;
        r0.mcapsule_recommend_enable = this.mcapsule_recommend_enable;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2803newBuilder();
    }

    public SearchAction(String r8, com.ss.android.lark.pb.searches.SearchTabName r9, List<SearchActionFilter> r10, String r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public SearchAction(String r2, com.ss.android.lark.pb.searches.SearchTabName r3, List<SearchActionFilter> r4, String r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mquery = r2;
        this.mtab = r3;
        this.mfilters = Internal.immutableCopyOf("mfilters", r4);
        this.mapp_id = r5;
        this.mcapsule_recommend_enable = r6;
    }
}
