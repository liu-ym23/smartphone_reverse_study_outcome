package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Icon;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LarkMinutesMeta extends Message<LarkMinutesMeta, Builder> {
    public static final ProtoAdapter<LarkMinutesMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;
    public final Icon micon;
    public final String mid;
    public final String muri;

    public static final class Builder extends Message.Builder<LarkMinutesMeta, Builder> {
        public Icon micon;
        public String mid;
        public String muri;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public LarkMinutesMeta m2675build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new LarkMinutesMeta(this.mid, this.muri, this.micon, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2675build();
        }

        public Builder icon(Icon r1) {
            this.micon = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder uri(String r1) {
            this.muri = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkMinutesMeta extends ProtoAdapter<LarkMinutesMeta> {
        public ProtoAdapter_LarkMinutesMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkMinutesMeta.class);
        }

        public LarkMinutesMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.muri = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.muri = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 4) goto L11;
            r0.micon = (Icon) Icon.ADAPTER.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2675build();
        }

        public int encodedSize(LarkMinutesMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid);
            String r2 = r6.muri;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Icon r7 = r6.micon;
            if (r7 == null) goto L10;
            r3 = Icon.ADAPTER.encodedSizeWithTag(4, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2676decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((LarkMinutesMeta) r1);
        }

        public void encode(ProtoWriter r4, LarkMinutesMeta r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            String r1 = r5.muri;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            Icon r2 = r5.micon;
            if (r2 == null) goto L8;
            Icon.ADAPTER.encodeWithTag(r4, 4, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (LarkMinutesMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkMinutesMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2674newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.muri = this.muri;
        r0.micon = this.micon;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return LarkMinutesMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2674newBuilder();
    }

    public LarkMinutesMeta(String r2, String r3, Icon r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public LarkMinutesMeta(String r2, String r3, Icon r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mid = r2;
        this.muri = r3;
        this.micon = r4;
    }
}
