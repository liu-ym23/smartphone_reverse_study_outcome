package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BannerElement extends Message<BannerElement, Builder> {
    public static final ProtoAdapter<BannerElement> ADAPTER = null;
    public static final String DEFAULT_TRACKING_KEY = "";
    private static final long serialVersionUID = 0;
    public final BannerAction maction;
    public final BannerText mbanner_text;
    public final String mtracking_key;

    public static final class Builder extends Message.Builder<BannerElement, Builder> {
        public BannerAction maction;
        public BannerText mbanner_text;
        public String mtracking_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerElement m2543build() {
            return new BannerElement(this.mbanner_text, this.maction, this.mtracking_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2543build();
        }

        public Builder action(BannerAction r1) {
            this.maction = r1;
            return this;
        }

        public Builder banner_text(BannerText r1) {
            this.mbanner_text = r1;
            return this;
        }

        public Builder tracking_key(String r1) {
            this.mtracking_key = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerElement extends ProtoAdapter<BannerElement> {
        public ProtoAdapter_BannerElement() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerElement.class);
        }

        public BannerElement decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtracking_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mbanner_text = (BannerText) BannerText.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.maction = (BannerAction) BannerAction.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mtracking_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2543build();
        }

        public int encodedSize(BannerElement r6) {
            BannerText r0 = r6.mbanner_text;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = BannerText.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            BannerAction r3 = r6.maction;
            if (r3 == null) goto L9;
            int r4 = BannerAction.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mtracking_key;
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
        public /* bridge */ /* synthetic */ Object m2544decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerElement) r1);
        }

        public void encode(ProtoWriter r4, BannerElement r5) throws IOException {
            BannerText r0 = r5.mbanner_text;
            if (r0 == null) goto L5;
            BannerText.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            BannerAction r1 = r5.maction;
            if (r1 == null) goto L8;
            BannerAction.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtracking_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerElement) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerElement();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2542newBuilder() {
        Builder r0 = new Builder();
        r0.mbanner_text = this.mbanner_text;
        r0.maction = this.maction;
        r0.mtracking_key = this.mtracking_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2542newBuilder();
    }

    public BannerElement(BannerText r2, BannerAction r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public BannerElement(BannerText r2, BannerAction r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mbanner_text = r2;
        this.maction = r3;
        this.mtracking_key = r4;
    }
}
