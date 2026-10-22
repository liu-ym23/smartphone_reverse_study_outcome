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
public final class CalendarMeta extends Message<CalendarMeta, Builder> {
    public static final ProtoAdapter<CalendarMeta> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final Icon micon;
    public final String mid;
    public final String muri;

    public static final class Builder extends Message.Builder<CalendarMeta, Builder> {
        public String mdescription;
        public Icon micon;
        public String mid;
        public String muri;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CalendarMeta m2567build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new CalendarMeta(this.mid, this.muri, this.mdescription, this.micon, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2567build();
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
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

    public static final class ProtoAdapter_CalendarMeta extends ProtoAdapter<CalendarMeta> {
        public ProtoAdapter_CalendarMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarMeta.class);
        }

        public CalendarMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.muri = "";
            r0.mdescription = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.muri = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.micon = (Icon) Icon.ADAPTER.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2567build();
        }

        public int encodedSize(CalendarMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid);
            String r2 = r6.muri;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.mdescription;
            if (r7 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r7);
        L10:
            int r9 = r5 + r8;
            Icon r10 = r6.micon;
            if (r10 == null) goto L14;
            r3 = Icon.ADAPTER.encodedSizeWithTag(4, r10);
        L14:
            return (r9 + r3) + r6.unknownFields().size();
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2568decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CalendarMeta) r1);
        }

        public void encode(ProtoWriter r4, CalendarMeta r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            String r1 = r5.muri;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            String r2 = r5.mdescription;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            Icon r3 = r5.micon;
            if (r3 == null) goto L11;
            Icon.ADAPTER.encodeWithTag(r4, 4, r3);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CalendarMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2566newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.muri = this.muri;
        r0.mdescription = this.mdescription;
        r0.micon = this.micon;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CalendarMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2566newBuilder();
    }

    public CalendarMeta(String r7, String r8, String r9, Icon r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public CalendarMeta(String r2, String r3, String r4, Icon r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mid = r2;
        this.muri = r3;
        this.mdescription = r4;
        this.micon = r5;
    }
}
