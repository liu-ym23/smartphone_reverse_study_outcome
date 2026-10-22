package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OnboardText extends Message<OnboardText, Builder> {
    public static final ProtoAdapter<OnboardText> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final String mtitle;

    public static final class Builder extends Message.Builder<OnboardText, Builder> {
        public String mdescription;
        public String mtitle;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public OnboardText m1973build() {
            return new OnboardText(this.mtitle, this.mdescription, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1973build();
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_OnboardText extends ProtoAdapter<OnboardText> {
        public ProtoAdapter_OnboardText() {
            super(FieldEncoding.LENGTH_DELIMITED, OnboardText.class);
        }

        public OnboardText decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtitle = "";
            r0.mdescription = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1973build();
        }

        public int encodedSize(OnboardText r5) {
            String r0 = r5.mtitle;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mdescription;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1974decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((OnboardText) r1);
        }

        public void encode(ProtoWriter r4, OnboardText r5) throws IOException {
            String r0 = r5.mtitle;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mdescription;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (OnboardText) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnboardText();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1972newBuilder() {
        Builder r0 = new Builder();
        r0.mtitle = this.mtitle;
        r0.mdescription = this.mdescription;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return OnboardText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1972newBuilder();
    }

    public OnboardText(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public OnboardText(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtitle = r2;
        this.mdescription = r3;
    }
}
