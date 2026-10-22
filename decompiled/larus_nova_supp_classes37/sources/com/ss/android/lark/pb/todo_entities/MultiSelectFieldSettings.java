package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MultiSelectFieldSettings extends Message<MultiSelectFieldSettings, Builder> {
    public static final ProtoAdapter<MultiSelectFieldSettings> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<SelectFieldOption> moptions;

    public static final class Builder extends Message.Builder<MultiSelectFieldSettings, Builder> {
        public List<SelectFieldOption> moptions;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MultiSelectFieldSettings m2309build() {
            return new MultiSelectFieldSettings(this.moptions, super.buildUnknownFields());
        }

        public Builder() {
            this.moptions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2309build();
        }

        public Builder options(List<SelectFieldOption> r1) {
            Internal.checkElementsNotNull(r1);
            this.moptions = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MultiSelectFieldSettings extends ProtoAdapter<MultiSelectFieldSettings> {
        public ProtoAdapter_MultiSelectFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, MultiSelectFieldSettings.class);
        }

        public MultiSelectFieldSettings decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.moptions.add((SelectFieldOption) SelectFieldOption.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2309build();
        }

        public int encodedSize(MultiSelectFieldSettings r4) {
            return SelectFieldOption.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.moptions) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2310decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MultiSelectFieldSettings) r1);
        }

        public void encode(ProtoWriter r4, MultiSelectFieldSettings r5) throws IOException {
            SelectFieldOption.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.moptions);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MultiSelectFieldSettings) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MultiSelectFieldSettings();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2308newBuilder() {
        Builder r0 = new Builder();
        r0.moptions = Internal.copyOf("moptions", this.moptions);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MultiSelectFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2308newBuilder();
    }

    public MultiSelectFieldSettings(List<SelectFieldOption> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MultiSelectFieldSettings(List<SelectFieldOption> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.moptions = Internal.immutableCopyOf("moptions", r2);
    }
}
