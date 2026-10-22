package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.TagData;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DepartmentMeta extends Message<DepartmentMeta, Builder> {
    public static final ProtoAdapter<DepartmentMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mid;
    public final TagData mrelation_tag;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<DepartmentMeta, Builder> {
        public String mid;
        public TagData mrelation_tag;
        public String mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DepartmentMeta m2585build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new DepartmentMeta(this.mid, this.mtenant_id, this.mrelation_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2585build();
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder relation_tag(TagData r1) {
            this.mrelation_tag = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DepartmentMeta extends ProtoAdapter<DepartmentMeta> {
        public ProtoAdapter_DepartmentMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, DepartmentMeta.class);
        }

        public DepartmentMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtenant_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mrelation_tag = (TagData) TagData.ADAPTER.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2585build();
        }

        public int encodedSize(DepartmentMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid);
            String r2 = r6.mtenant_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            TagData r7 = r6.mrelation_tag;
            if (r7 == null) goto L10;
            r3 = TagData.ADAPTER.encodedSizeWithTag(3, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2586decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DepartmentMeta) r1);
        }

        public void encode(ProtoWriter r4, DepartmentMeta r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            String r1 = r5.mtenant_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            TagData r2 = r5.mrelation_tag;
            if (r2 == null) goto L8;
            TagData.ADAPTER.encodeWithTag(r4, 3, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DepartmentMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DepartmentMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2584newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtenant_id = this.mtenant_id;
        r0.mrelation_tag = this.mrelation_tag;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DepartmentMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2584newBuilder();
    }

    public DepartmentMeta(String r2, String r3, TagData r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DepartmentMeta(String r2, String r3, TagData r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.mtenant_id = r3;
        this.mrelation_tag = r4;
    }
}
