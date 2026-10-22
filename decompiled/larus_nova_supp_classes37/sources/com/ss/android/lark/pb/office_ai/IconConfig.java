package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IconConfig extends Message<IconConfig, Builder> {
    public static final ProtoAdapter<IconConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final IconInfo mdisplay_icon;
    public final IconInfo mlink_icon;

    public static final class Builder extends Message.Builder<IconConfig, Builder> {
        public IconInfo mdisplay_icon;
        public IconInfo mlink_icon;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public IconConfig m1958build() {
            return new IconConfig(this.mdisplay_icon, this.mlink_icon, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1958build();
        }

        public Builder display_icon(IconInfo r1) {
            this.mdisplay_icon = r1;
            return this;
        }

        public Builder link_icon(IconInfo r1) {
            this.mlink_icon = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_IconConfig extends ProtoAdapter<IconConfig> {
        public ProtoAdapter_IconConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, IconConfig.class);
        }

        public IconConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mdisplay_icon = (IconInfo) IconInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mlink_icon = (IconInfo) IconInfo.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1958build();
        }

        public int encodedSize(IconConfig r5) {
            IconInfo r0 = r5.mdisplay_icon;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = IconInfo.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            IconInfo r3 = r5.mlink_icon;
            if (r3 == null) goto L10;
            r1 = IconInfo.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1959decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((IconConfig) r1);
        }

        public void encode(ProtoWriter r4, IconConfig r5) throws IOException {
            IconInfo r0 = r5.mdisplay_icon;
            if (r0 == null) goto L5;
            IconInfo.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            IconInfo r1 = r5.mlink_icon;
            if (r1 == null) goto L8;
            IconInfo.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (IconConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IconConfig();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1957newBuilder() {
        Builder r0 = new Builder();
        r0.mdisplay_icon = this.mdisplay_icon;
        r0.mlink_icon = this.mlink_icon;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return IconConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1957newBuilder();
    }

    public IconConfig(IconInfo r2, IconInfo r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public IconConfig(IconInfo r2, IconInfo r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mdisplay_icon = r2;
        this.mlink_icon = r3;
    }
}
