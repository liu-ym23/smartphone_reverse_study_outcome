package com.ss.android.lark.pb.url_preview;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PreviewHangPoint extends Message<PreviewHangPoint, Builder> {
    public static final ProtoAdapter<PreviewHangPoint> ADAPTER = null;
    public static final Boolean DEFAULT_CLOSE_CARD_PREVIEW = null;
    public static final Boolean DEFAULT_IS_LAZY_LOAD = null;
    public static final Boolean DEFAULT_NEED_LOCAL_PREVIEW = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Boolean mclose_card_preview;
    public final Boolean mis_lazy_load;
    public final Boolean mneed_local_preview;
    public final String mpreview_id;
    public final String murl;

    public static final class Builder extends Message.Builder<PreviewHangPoint, Builder> {
        public Boolean mclose_card_preview;
        public Boolean mis_lazy_load;
        public Boolean mneed_local_preview;
        public String mpreview_id;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PreviewHangPoint m2486build() {
            return new PreviewHangPoint(this.mpreview_id, this.mneed_local_preview, this.mclose_card_preview, this.murl, this.mis_lazy_load, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2486build();
        }

        public Builder close_card_preview(Boolean r1) {
            this.mclose_card_preview = r1;
            return this;
        }

        public Builder is_lazy_load(Boolean r1) {
            this.mis_lazy_load = r1;
            return this;
        }

        public Builder need_local_preview(Boolean r1) {
            this.mneed_local_preview = r1;
            return this;
        }

        public Builder preview_id(String r1) {
            this.mpreview_id = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PreviewHangPoint extends ProtoAdapter<PreviewHangPoint> {
        public ProtoAdapter_PreviewHangPoint() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewHangPoint.class);
        }

        public PreviewHangPoint decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mpreview_id = "";
            Boolean r2 = Boolean.FALSE;
            r0.mneed_local_preview = r2;
            r0.mclose_card_preview = r2;
            r0.murl = "";
            r0.mis_lazy_load = r2;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mpreview_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mneed_local_preview = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mclose_card_preview = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.murl = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mis_lazy_load = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2486build();
        }

        public int encodedSize(PreviewHangPoint r6) {
            String r0 = r6.mpreview_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mneed_local_preview;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mclose_card_preview;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.murl;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mis_lazy_load;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
        L17:
            r11 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m2487decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PreviewHangPoint) r1);
        }

        public void encode(ProtoWriter r4, PreviewHangPoint r5) throws IOException {
            String r0 = r5.mpreview_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mneed_local_preview;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mclose_card_preview;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.murl;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.mis_lazy_load;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PreviewHangPoint) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewHangPoint();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_NEED_LOCAL_PREVIEW = r0;
        DEFAULT_CLOSE_CARD_PREVIEW = r0;
        DEFAULT_IS_LAZY_LOAD = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2485newBuilder() {
        Builder r0 = new Builder();
        r0.mpreview_id = this.mpreview_id;
        r0.mneed_local_preview = this.mneed_local_preview;
        r0.mclose_card_preview = this.mclose_card_preview;
        r0.murl = this.murl;
        r0.mis_lazy_load = this.mis_lazy_load;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PreviewHangPoint.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2485newBuilder();
    }

    public PreviewHangPoint(String r8, Boolean r9, Boolean r10, String r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public PreviewHangPoint(String r2, Boolean r3, Boolean r4, String r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mpreview_id = r2;
        this.mneed_local_preview = r3;
        this.mclose_card_preview = r4;
        this.murl = r5;
        this.mis_lazy_load = r6;
    }
}
