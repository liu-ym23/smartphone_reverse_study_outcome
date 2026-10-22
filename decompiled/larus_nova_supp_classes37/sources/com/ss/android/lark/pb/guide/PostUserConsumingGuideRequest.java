package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PostUserConsumingGuideRequest extends Message<PostUserConsumingGuideRequest, Builder> {
    public static final ProtoAdapter<PostUserConsumingGuideRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mcontext;
    public final Map<String, Integer> mkey_step;
    public final List<String> mkeys;
    public final List<String> mkeys_done;

    public static final class Builder extends Message.Builder<PostUserConsumingGuideRequest, Builder> {
        public Map<String, String> mcontext;
        public Map<String, Integer> mkey_step;
        public List<String> mkeys;
        public List<String> mkeys_done;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PostUserConsumingGuideRequest m1727build() {
            return new PostUserConsumingGuideRequest(this.mkeys, this.mkey_step, this.mcontext, this.mkeys_done, super.buildUnknownFields());
        }

        public Builder() {
            this.mkeys = Internal.newMutableList();
            this.mkey_step = Internal.newMutableMap();
            this.mcontext = Internal.newMutableMap();
            this.mkeys_done = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1727build();
        }

        public Builder context(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcontext = r1;
            return this;
        }

        public Builder key_step(Map<String, Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.mkey_step = r1;
            return this;
        }

        public Builder keys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mkeys = r1;
            return this;
        }

        public Builder keys_done(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mkeys_done = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PostUserConsumingGuideRequest extends ProtoAdapter<PostUserConsumingGuideRequest> {
        private final ProtoAdapter<Map<String, String>> mcontext;
        private final ProtoAdapter<Map<String, Integer>> mkey_step;

        public ProtoAdapter_PostUserConsumingGuideRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PostUserConsumingGuideRequest.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mkey_step = ProtoAdapter.newMapAdapter(r0, ProtoAdapter.INT32);
            this.mcontext = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public PostUserConsumingGuideRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mkeys.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mkey_step.putAll((Map) this.mkey_step.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcontext.putAll((Map) this.mcontext.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mkeys_done.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1727build();
        }

        public int encodedSize(PostUserConsumingGuideRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (((r0.asRepeated().encodedSizeWithTag(1, r6.mkeys) + this.mkey_step.encodedSizeWithTag(2, r6.mkey_step)) + this.mcontext.encodedSizeWithTag(3, r6.mcontext)) + r0.asRepeated().encodedSizeWithTag(4, r6.mkeys_done)) + r6.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1728decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PostUserConsumingGuideRequest) r1);
        }

        public void encode(ProtoWriter r5, PostUserConsumingGuideRequest r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.asRepeated().encodeWithTag(r5, 1, r6.mkeys);
            this.mkey_step.encodeWithTag(r5, 2, r6.mkey_step);
            this.mcontext.encodeWithTag(r5, 3, r6.mcontext);
            r0.asRepeated().encodeWithTag(r5, 4, r6.mkeys_done);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PostUserConsumingGuideRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PostUserConsumingGuideRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1726newBuilder() {
        Builder r0 = new Builder();
        r0.mkeys = Internal.copyOf("mkeys", this.mkeys);
        r0.mkey_step = Internal.copyOf("mkey_step", this.mkey_step);
        r0.mcontext = Internal.copyOf("mcontext", this.mcontext);
        r0.mkeys_done = Internal.copyOf("mkeys_done", this.mkeys_done);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PostUserConsumingGuideRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1726newBuilder();
    }

    public PostUserConsumingGuideRequest(List<String> r7, Map<String, Integer> r8, Map<String, String> r9, List<String> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PostUserConsumingGuideRequest(List<String> r2, Map<String, Integer> r3, Map<String, String> r4, List<String> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mkeys = Internal.immutableCopyOf("mkeys", r2);
        this.mkey_step = Internal.immutableCopyOf("mkey_step", r3);
        this.mcontext = Internal.immutableCopyOf("mcontext", r4);
        this.mkeys_done = Internal.immutableCopyOf("mkeys_done", r5);
    }
}
