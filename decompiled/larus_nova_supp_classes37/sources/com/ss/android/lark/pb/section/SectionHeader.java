package com.ss.android.lark.pb.section;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Image;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SectionHeader extends Message<SectionHeader, Builder> {
    public static final ProtoAdapter<SectionHeader> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_URL = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final Image mavatar;
    public final String mavatar_key;
    public final String mavatar_url;
    public final String mtitle;
    public final List<Modifier> mtitle_modifiers;

    public static final class Builder extends Message.Builder<SectionHeader, Builder> {
        public Image mavatar;
        public String mavatar_key;
        public String mavatar_url;
        public String mtitle;
        public List<Modifier> mtitle_modifiers;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SectionHeader m2150build() {
            return new SectionHeader(this.mtitle, this.mavatar_key, this.mavatar_url, this.mavatar, this.mtitle_modifiers, super.buildUnknownFields());
        }

        public Builder() {
            this.mtitle_modifiers = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2150build();
        }

        public Builder avatar(Image r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder avatar_url(String r1) {
            this.mavatar_url = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }

        public Builder title_modifiers(List<Modifier> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtitle_modifiers = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SectionHeader extends ProtoAdapter<SectionHeader> {
        public ProtoAdapter_SectionHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, SectionHeader.class);
        }

        public SectionHeader decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtitle = "";
            r0.mavatar_key = "";
            r0.mavatar_url = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mavatar_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mavatar = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mtitle_modifiers.add((Modifier) Modifier.ADAPTER.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2150build();
        }

        public int encodedSize(SectionHeader r6) {
            String r0 = r6.mtitle;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mavatar_key;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mavatar_url;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Image r10 = r6.mavatar;
            if (r10 == null) goto L18;
            r1 = Image.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            return ((r9 + r1) + Modifier.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mtitle_modifiers)) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2151decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SectionHeader) r1);
        }

        public void encode(ProtoWriter r4, SectionHeader r5) throws IOException {
            String r0 = r5.mtitle;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mavatar_key;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mavatar_url;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Image r3 = r5.mavatar;
            if (r3 == null) goto L14;
            Image.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            Modifier.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mtitle_modifiers);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SectionHeader) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SectionHeader();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2149newBuilder() {
        Builder r0 = new Builder();
        r0.mtitle = this.mtitle;
        r0.mavatar_key = this.mavatar_key;
        r0.mavatar_url = this.mavatar_url;
        r0.mavatar = this.mavatar;
        r0.mtitle_modifiers = Internal.copyOf("mtitle_modifiers", this.mtitle_modifiers);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SectionHeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2149newBuilder();
    }

    public SectionHeader(String r8, String r9, String r10, Image r11, List<Modifier> r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public SectionHeader(String r2, String r3, String r4, Image r5, List<Modifier> r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mtitle = r2;
        this.mavatar_key = r3;
        this.mavatar_url = r4;
        this.mavatar = r5;
        this.mtitle_modifiers = Internal.immutableCopyOf("mtitle_modifiers", r6);
    }
}
