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
public final class SingleSelectFieldSettings extends Message<SingleSelectFieldSettings, Builder> {
    public static final ProtoAdapter<SingleSelectFieldSettings> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<SelectFieldOption> moptions;

    public static final class Builder extends Message.Builder<SingleSelectFieldSettings, Builder> {
        public List<SelectFieldOption> moptions;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SingleSelectFieldSettings m2327build() {
            return new SingleSelectFieldSettings(this.moptions, super.buildUnknownFields());
        }

        public Builder() {
            this.moptions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2327build();
        }

        public Builder options(List<SelectFieldOption> r1) {
            Internal.checkElementsNotNull(r1);
            this.moptions = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SingleSelectFieldSettings extends ProtoAdapter<SingleSelectFieldSettings> {
        public ProtoAdapter_SingleSelectFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, SingleSelectFieldSettings.class);
        }

        public SingleSelectFieldSettings decode(ProtoReader r7) throws IOException {
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
            return r0.m2327build();
        }

        public int encodedSize(SingleSelectFieldSettings r4) {
            return SelectFieldOption.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.moptions) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2328decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SingleSelectFieldSettings) r1);
        }

        public void encode(ProtoWriter r4, SingleSelectFieldSettings r5) throws IOException {
            SelectFieldOption.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.moptions);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SingleSelectFieldSettings) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SingleSelectFieldSettings();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2326newBuilder() {
        Builder r0 = new Builder();
        r0.moptions = Internal.copyOf("moptions", this.moptions);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SingleSelectFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2326newBuilder();
    }

    public SingleSelectFieldSettings(List<SelectFieldOption> r2) {
        this(r2, ByteString.EMPTY);
    }

    public SingleSelectFieldSettings(List<SelectFieldOption> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.moptions = Internal.immutableCopyOf("moptions", r2);
    }
}
