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
public final class NavigationAppPopup extends Message<NavigationAppPopup, Builder> {
    public static final ProtoAdapter<NavigationAppPopup> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_APP_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mapp_id;
    public final String mapp_key;
    public final List<SearchActionFilter> mdefault_filter;

    public static final class Builder extends Message.Builder<NavigationAppPopup, Builder> {
        public String mapp_id;
        public String mapp_key;
        public List<SearchActionFilter> mdefault_filter;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public NavigationAppPopup m2732build() {
            return new NavigationAppPopup(this.mapp_id, this.mapp_key, this.mdefault_filter, super.buildUnknownFields());
        }

        public Builder() {
            this.mdefault_filter = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2732build();
        }

        public Builder app_id(String r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder app_key(String r1) {
            this.mapp_key = r1;
            return this;
        }

        public Builder default_filter(List<SearchActionFilter> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdefault_filter = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_NavigationAppPopup extends ProtoAdapter<NavigationAppPopup> {
        public ProtoAdapter_NavigationAppPopup() {
            super(FieldEncoding.LENGTH_DELIMITED, NavigationAppPopup.class);
        }

        public NavigationAppPopup decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mapp_id = "";
            r0.mapp_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mapp_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mapp_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mdefault_filter.add((SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2732build();
        }

        public int encodedSize(NavigationAppPopup r5) {
            String r0 = r5.mapp_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mapp_key;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mdefault_filter)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2733decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((NavigationAppPopup) r1);
        }

        public void encode(ProtoWriter r4, NavigationAppPopup r5) throws IOException {
            String r0 = r5.mapp_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mapp_key;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mdefault_filter);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (NavigationAppPopup) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NavigationAppPopup();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2731newBuilder() {
        Builder r0 = new Builder();
        r0.mapp_id = this.mapp_id;
        r0.mapp_key = this.mapp_key;
        r0.mdefault_filter = Internal.copyOf("mdefault_filter", this.mdefault_filter);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return NavigationAppPopup.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2731newBuilder();
    }

    public NavigationAppPopup(String r2, String r3, List<SearchActionFilter> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public NavigationAppPopup(String r2, String r3, List<SearchActionFilter> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mapp_id = r2;
        this.mapp_key = r3;
        this.mdefault_filter = Internal.immutableCopyOf("mdefault_filter", r4);
    }
}
