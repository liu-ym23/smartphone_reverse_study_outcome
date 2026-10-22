package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ThreadMeta extends Message<ThreadMeta, Builder> {
    public static final ProtoAdapter<ThreadMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final String mid;
    public final Long mupdate_time;

    public static final class Builder extends Message.Builder<ThreadMeta, Builder> {
        public String mchat_id;
        public String mid;
        public Long mupdate_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ThreadMeta m2873build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new ThreadMeta(this.mid, this.mchat_id, this.mupdate_time, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2873build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ThreadMeta extends ProtoAdapter<ThreadMeta> {
        public ProtoAdapter_ThreadMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ThreadMeta.class);
        }

        public ThreadMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mchat_id = "";
            r0.mupdate_time = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2873build();
        }

        public int encodedSize(ThreadMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid);
            String r2 = r6.mchat_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Long r7 = r6.mupdate_time;
            if (r7 == null) goto L10;
            r3 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2874decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ThreadMeta) r1);
        }

        public void encode(ProtoWriter r4, ThreadMeta r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            String r1 = r5.mchat_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            Long r2 = r5.mupdate_time;
            if (r2 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ThreadMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThreadMeta();
        DEFAULT_UPDATE_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2872newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mchat_id = this.mchat_id;
        r0.mupdate_time = this.mupdate_time;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ThreadMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2872newBuilder();
    }

    public ThreadMeta(String r2, String r3, Long r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ThreadMeta(String r2, String r3, Long r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.mchat_id = r3;
        this.mupdate_time = r4;
    }
}
