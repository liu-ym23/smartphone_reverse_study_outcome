package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageTranslationAbility extends com.squareup.wire.Message<ImageTranslationAbility, Builder> {
    public static final ProtoAdapter<ImageTranslationAbility> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_TRANSLATE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcan_translate;
    public final List<String> msrc_language;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageTranslationAbility, Builder> {
        public Boolean mcan_translate;
        public List<String> msrc_language;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageTranslationAbility m1292build() {
            Boolean r0 = this.mcan_translate;
            if (r0 == null) goto L7;
            return new ImageTranslationAbility(this.mcan_translate, this.msrc_language, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mcan_translate"});
        }

        public Builder() {
            this.msrc_language = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1292build();
        }

        public Builder can_translate(Boolean r1) {
            this.mcan_translate = r1;
            return this;
        }

        public Builder src_language(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.msrc_language = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageTranslationAbility extends ProtoAdapter<ImageTranslationAbility> {
        public ProtoAdapter_ImageTranslationAbility() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageTranslationAbility.class);
        }

        public ImageTranslationAbility decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcan_translate = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mcan_translate = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.msrc_language.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1292build();
        }

        public int encodedSize(ImageTranslationAbility r5) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.mcan_translate) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r5.msrc_language)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1293decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageTranslationAbility) r1);
        }

        public void encode(ProtoWriter r4, ImageTranslationAbility r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.mcan_translate);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 2, r5.msrc_language);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageTranslationAbility) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageTranslationAbility();
        DEFAULT_CAN_TRANSLATE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1291newBuilder() {
        Builder r0 = new Builder();
        r0.mcan_translate = this.mcan_translate;
        r0.msrc_language = Internal.copyOf("msrc_language", this.msrc_language);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageTranslationAbility.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1291newBuilder();
    }

    public ImageTranslationAbility(Boolean r2, List<String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ImageTranslationAbility(Boolean r2, List<String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcan_translate = r2;
        this.msrc_language = Internal.immutableCopyOf("msrc_language", r3);
    }
}
