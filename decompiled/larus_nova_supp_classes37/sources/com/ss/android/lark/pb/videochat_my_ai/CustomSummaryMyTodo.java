package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomSummaryMyTodo extends Message<CustomSummaryMyTodo, Builder> {
    public static final ProtoAdapter<CustomSummaryMyTodo> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final List<ByteviewUser> mexecutors;

    public static final class Builder extends Message.Builder<CustomSummaryMyTodo, Builder> {
        public String mcontent;
        public List<ByteviewUser> mexecutors;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryMyTodo m3260build() {
            return new CustomSummaryMyTodo(this.mcontent, this.mexecutors, super.buildUnknownFields());
        }

        public Builder() {
            this.mexecutors = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3260build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder executors(List<ByteviewUser> r1) {
            Internal.checkElementsNotNull(r1);
            this.mexecutors = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryMyTodo extends ProtoAdapter<CustomSummaryMyTodo> {
        public ProtoAdapter_CustomSummaryMyTodo() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryMyTodo.class);
        }

        public CustomSummaryMyTodo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mexecutors.add((ByteviewUser) ByteviewUser.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3260build();
        }

        public int encodedSize(CustomSummaryMyTodo r5) {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + ByteviewUser.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mexecutors)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3261decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryMyTodo) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryMyTodo r5) throws IOException {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ByteviewUser.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mexecutors);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryMyTodo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryMyTodo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3259newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.mexecutors = Internal.copyOf("mexecutors", this.mexecutors);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryMyTodo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3259newBuilder();
    }

    public CustomSummaryMyTodo(String r2, List<ByteviewUser> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CustomSummaryMyTodo(String r2, List<ByteviewUser> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcontent = r2;
        this.mexecutors = Internal.immutableCopyOf("mexecutors", r3);
    }
}
