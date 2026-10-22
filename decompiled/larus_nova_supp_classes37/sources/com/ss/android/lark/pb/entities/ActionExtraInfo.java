package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ActionExtraInfo extends com.squareup.wire.Message<ActionExtraInfo, Builder> {
    public static final ProtoAdapter<ActionExtraInfo> ADAPTER = null;
    public static final Long DEFAULT_ADMIN_ID = null;
    public static final String DEFAULT_PARAMS = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Long madmin_id;
    public final String mparams;
    public final String murl;

    public static final class Builder extends com.squareup.wire.Message.Builder<ActionExtraInfo, Builder> {
        public Long madmin_id;
        public String mparams;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ActionExtraInfo m1001build() {
            return new ActionExtraInfo(this.madmin_id, this.murl, this.mparams, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1001build();
        }

        public Builder admin_id(Long r1) {
            this.madmin_id = r1;
            return this;
        }

        public Builder params(String r1) {
            this.mparams = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ActionExtraInfo extends ProtoAdapter<ActionExtraInfo> {
        public ProtoAdapter_ActionExtraInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ActionExtraInfo.class);
        }

        public ActionExtraInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.madmin_id = 0L;
            r0.murl = "";
            r0.mparams = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.madmin_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.murl = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mparams = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1001build();
        }

        public int encodedSize(ActionExtraInfo r6) {
            Long r0 = r6.madmin_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.murl;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mparams;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1002decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ActionExtraInfo) r1);
        }

        public void encode(ProtoWriter r4, ActionExtraInfo r5) throws IOException {
            Long r0 = r5.madmin_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.murl;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mparams;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ActionExtraInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ActionExtraInfo();
        DEFAULT_ADMIN_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1000newBuilder() {
        Builder r0 = new Builder();
        r0.madmin_id = this.madmin_id;
        r0.murl = this.murl;
        r0.mparams = this.mparams;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ActionExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1000newBuilder();
    }

    public ActionExtraInfo(Long r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ActionExtraInfo(Long r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.madmin_id = r2;
        this.murl = r3;
        this.mparams = r4;
    }
}
