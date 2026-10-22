package com.ss.android.lark.pb.section;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SectionFooter extends Message<SectionFooter, Builder> {
    public static final ProtoAdapter<SectionFooter> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final Action maction;
    public final String mavatar_key;
    public final String mtext;

    public static final class Builder extends Message.Builder<SectionFooter, Builder> {
        public Action maction;
        public String mavatar_key;
        public String mtext;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SectionFooter m2147build() {
            return new SectionFooter(this.mavatar_key, this.mtext, this.maction, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2147build();
        }

        public Builder action(Action r1) {
            this.maction = r1;
            return this;
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder text(String r1) {
            this.mtext = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SectionFooter extends ProtoAdapter<SectionFooter> {
        public ProtoAdapter_SectionFooter() {
            super(FieldEncoding.LENGTH_DELIMITED, SectionFooter.class);
        }

        public SectionFooter decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mavatar_key = "";
            r0.mtext = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.maction = (Action) Action.ADAPTER.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2147build();
        }

        public int encodedSize(SectionFooter r6) {
            String r0 = r6.mavatar_key;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtext;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Action r7 = r6.maction;
            if (r7 == null) goto L14;
            r1 = Action.ADAPTER.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m2148decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SectionFooter) r1);
        }

        public void encode(ProtoWriter r4, SectionFooter r5) throws IOException {
            String r0 = r5.mavatar_key;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtext;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Action r2 = r5.maction;
            if (r2 == null) goto L11;
            Action.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SectionFooter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SectionFooter();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2146newBuilder() {
        Builder r0 = new Builder();
        r0.mavatar_key = this.mavatar_key;
        r0.mtext = this.mtext;
        r0.maction = this.maction;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SectionFooter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2146newBuilder();
    }

    public SectionFooter(String r2, String r3, Action r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SectionFooter(String r2, String r3, Action r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mavatar_key = r2;
        this.mtext = r3;
        this.maction = r4;
    }
}
