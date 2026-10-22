package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.RichText;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PatchUserMemoRequest extends Message<PatchUserMemoRequest, Builder> {
    public static final ProtoAdapter<PatchUserMemoRequest> ADAPTER = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_MEMO_PICTURE_KEY = "";
    public static final String DEFAULT_MEMO_TEXT = "";
    public static final String DEFAULT_TARGET_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String malias;
    public final String mmemo_picture_key;
    public final List<String> mmemo_picture_key_v2;
    public final String mmemo_text;
    public final RichText mmemo_text_v2;
    public final String mtarget_user_id;

    public static final class Builder extends Message.Builder<PatchUserMemoRequest, Builder> {
        public String malias;
        public String mmemo_picture_key;
        public List<String> mmemo_picture_key_v2;
        public String mmemo_text;
        public RichText mmemo_text_v2;
        public String mtarget_user_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PatchUserMemoRequest m3002build() {
            return new PatchUserMemoRequest(this.mtarget_user_id, this.malias, this.mmemo_text, this.mmemo_picture_key, this.mmemo_text_v2, this.mmemo_picture_key_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.mmemo_picture_key_v2 = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3002build();
        }

        public Builder alias(String r1) {
            this.malias = r1;
            return this;
        }

        public Builder memo_picture_key(String r1) {
            this.mmemo_picture_key = r1;
            return this;
        }

        public Builder memo_picture_key_v2(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmemo_picture_key_v2 = r1;
            return this;
        }

        public Builder memo_text(String r1) {
            this.mmemo_text = r1;
            return this;
        }

        public Builder memo_text_v2(RichText r1) {
            this.mmemo_text_v2 = r1;
            return this;
        }

        public Builder target_user_id(String r1) {
            this.mtarget_user_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PatchUserMemoRequest extends ProtoAdapter<PatchUserMemoRequest> {
        public ProtoAdapter_PatchUserMemoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchUserMemoRequest.class);
        }

        public PatchUserMemoRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtarget_user_id = "";
            r0.malias = "";
            r0.mmemo_text = "";
            r0.mmemo_picture_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.mmemo_picture_key_v2.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            r0.mmemo_text_v2 = (RichText) RichText.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.mmemo_picture_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mmemo_text = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.malias = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mtarget_user_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m3002build();
        }

        public int encodedSize(PatchUserMemoRequest r6) {
            String r0 = r6.mtarget_user_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.malias;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mmemo_text;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mmemo_picture_key;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            RichText r13 = r6.mmemo_text_v2;
            if (r13 == null) goto L22;
            r1 = RichText.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            return ((r12 + r1) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(6, r6.mmemo_picture_key_v2)) + r6.unknownFields().size();
        L17:
            r11 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m3003decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PatchUserMemoRequest) r1);
        }

        public void encode(ProtoWriter r4, PatchUserMemoRequest r5) throws IOException {
            String r0 = r5.mtarget_user_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.malias;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mmemo_text;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mmemo_picture_key;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            RichText r6 = r5.mmemo_text_v2;
            if (r6 == null) goto L17;
            RichText.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 6, r5.mmemo_picture_key_v2);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PatchUserMemoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PatchUserMemoRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3001newBuilder() {
        Builder r0 = new Builder();
        r0.mtarget_user_id = this.mtarget_user_id;
        r0.malias = this.malias;
        r0.mmemo_text = this.mmemo_text;
        r0.mmemo_picture_key = this.mmemo_picture_key;
        r0.mmemo_text_v2 = this.mmemo_text_v2;
        r0.mmemo_picture_key_v2 = Internal.copyOf("mmemo_picture_key_v2", this.mmemo_picture_key_v2);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PatchUserMemoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3001newBuilder();
    }

    public PatchUserMemoRequest(String r9, String r10, String r11, String r12, RichText r13, List<String> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public PatchUserMemoRequest(String r2, String r3, String r4, String r5, RichText r6, List<String> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mtarget_user_id = r2;
        this.malias = r3;
        this.mmemo_text = r4;
        this.mmemo_picture_key = r5;
        this.mmemo_text_v2 = r6;
        this.mmemo_picture_key_v2 = Internal.immutableCopyOf("mmemo_picture_key_v2", r7);
    }
}
