package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ThreadState;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullAIChatModeThreadResponse extends Message<PullAIChatModeThreadResponse, Builder> {
    public static final ProtoAdapter<PullAIChatModeThreadResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SCENE_USABLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mscene_usable;
    public final ThreadState mstatus;

    public static final class Builder extends Message.Builder<PullAIChatModeThreadResponse, Builder> {
        public Boolean mscene_usable;
        public ThreadState mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullAIChatModeThreadResponse m1982build() {
            return new PullAIChatModeThreadResponse(this.mstatus, this.mscene_usable, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1982build();
        }

        public Builder scene_usable(Boolean r1) {
            this.mscene_usable = r1;
            return this;
        }

        public Builder status(ThreadState r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullAIChatModeThreadResponse extends ProtoAdapter<PullAIChatModeThreadResponse> {
        public ProtoAdapter_PullAIChatModeThreadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullAIChatModeThreadResponse.class);
        }

        public PullAIChatModeThreadResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mscene_usable = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mstatus = (ThreadState) ThreadState.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mscene_usable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1982build();
        }

        public int encodedSize(PullAIChatModeThreadResponse r5) {
            ThreadState r0 = r5.mstatus;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ThreadState.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r5.mscene_usable;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1983decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullAIChatModeThreadResponse) r1);
        }

        public void encode(ProtoWriter r4, PullAIChatModeThreadResponse r5) throws IOException {
            ThreadState r0 = r5.mstatus;
            if (r0 == null) goto L5;
            ThreadState.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mscene_usable;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullAIChatModeThreadResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullAIChatModeThreadResponse();
        DEFAULT_SCENE_USABLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1981newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mscene_usable = this.mscene_usable;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullAIChatModeThreadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1981newBuilder();
    }

    public PullAIChatModeThreadResponse(ThreadState r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PullAIChatModeThreadResponse(ThreadState r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mstatus = r2;
        this.mscene_usable = r3;
    }
}
