package com.ss.android.lark.pb.videochat_my_ai;

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
public final class EmptyStateInfo extends Message<EmptyStateInfo, Builder> {
    public static final ProtoAdapter<EmptyStateInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<EmptyStateMaterial> mempty_state_materials;

    public static final class Builder extends Message.Builder<EmptyStateInfo, Builder> {
        public List<EmptyStateMaterial> mempty_state_materials;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EmptyStateInfo m3272build() {
            return new EmptyStateInfo(this.mempty_state_materials, super.buildUnknownFields());
        }

        public Builder() {
            this.mempty_state_materials = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3272build();
        }

        public Builder empty_state_materials(List<EmptyStateMaterial> r1) {
            Internal.checkElementsNotNull(r1);
            this.mempty_state_materials = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EmptyStateInfo extends ProtoAdapter<EmptyStateInfo> {
        public ProtoAdapter_EmptyStateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EmptyStateInfo.class);
        }

        public EmptyStateInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mempty_state_materials.add((EmptyStateMaterial) EmptyStateMaterial.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3272build();
        }

        public int encodedSize(EmptyStateInfo r4) {
            return EmptyStateMaterial.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mempty_state_materials) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3273decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EmptyStateInfo) r1);
        }

        public void encode(ProtoWriter r4, EmptyStateInfo r5) throws IOException {
            EmptyStateMaterial.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mempty_state_materials);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EmptyStateInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmptyStateInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3271newBuilder() {
        Builder r0 = new Builder();
        r0.mempty_state_materials = Internal.copyOf("mempty_state_materials", this.mempty_state_materials);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EmptyStateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3271newBuilder();
    }

    public EmptyStateInfo(List<EmptyStateMaterial> r2) {
        this(r2, ByteString.EMPTY);
    }

    public EmptyStateInfo(List<EmptyStateMaterial> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mempty_state_materials = Internal.immutableCopyOf("mempty_state_materials", r2);
    }
}
