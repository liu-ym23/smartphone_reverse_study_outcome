package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MeetingAISubtitle extends Message<MeetingAISubtitle, Builder> {
    public static final ProtoAdapter<MeetingAISubtitle> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_LANG = "";
    public static final Long DEFAULT_SENTENCE_ID = null;
    public static final Long DEFAULT_START_MS = null;
    public static final Long DEFAULT_STOP_MS = null;
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final String mlang;
    public final Long msentence_id;
    public final MeetingAISSDInfo mssd_info;
    public final Long mstart_ms;
    public final Long mstop_ms;
    public final ByteviewUser muser;

    public static final class Builder extends Message.Builder<MeetingAISubtitle, Builder> {
        public String mcontent;
        public String mlang;
        public Long msentence_id;
        public MeetingAISSDInfo mssd_info;
        public Long mstart_ms;
        public Long mstop_ms;
        public ByteviewUser muser;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingAISubtitle m3296build() {
            return new MeetingAISubtitle(this.msentence_id, this.mcontent, this.mlang, this.mstart_ms, this.mstop_ms, this.muser, this.mssd_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3296build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder lang(String r1) {
            this.mlang = r1;
            return this;
        }

        public Builder sentence_id(Long r1) {
            this.msentence_id = r1;
            return this;
        }

        public Builder ssd_info(MeetingAISSDInfo r1) {
            this.mssd_info = r1;
            return this;
        }

        public Builder start_ms(Long r1) {
            this.mstart_ms = r1;
            return this;
        }

        public Builder stop_ms(Long r1) {
            this.mstop_ms = r1;
            return this;
        }

        public Builder user(ByteviewUser r1) {
            this.muser = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAISubtitle extends ProtoAdapter<MeetingAISubtitle> {
        public ProtoAdapter_MeetingAISubtitle() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAISubtitle.class);
        }

        public MeetingAISubtitle decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msentence_id = 0L;
            r0.mcontent = "";
            r0.mlang = "";
            r0.mstart_ms = 0L;
            r0.mstop_ms = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.mssd_info = (MeetingAISSDInfo) MeetingAISSDInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            r0.muser = (ByteviewUser) ByteviewUser.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.mstop_ms = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            r0.mstart_ms = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            r0.mlang = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.msentence_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m3296build();
        }

        public int encodedSize(MeetingAISubtitle r6) {
            Long r0 = r6.msentence_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mcontent;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mlang;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mstart_ms;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r6.mstop_ms;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ByteviewUser r16 = r6.muser;
            if (r16 == null) goto L25;
            int r17 = ByteviewUser.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            MeetingAISSDInfo r19 = r6.mssd_info;
            if (r19 == null) goto L30;
            r1 = MeetingAISSDInfo.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            return (r18 + r1) + r6.unknownFields().size();
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Object m3297decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingAISubtitle) r1);
        }

        public void encode(ProtoWriter r4, MeetingAISubtitle r5) throws IOException {
            Long r0 = r5.msentence_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mcontent;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mlang;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mstart_ms;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            Long r6 = r5.mstop_ms;
            if (r6 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r4, 5, r6);
        L17:
            ByteviewUser r7 = r5.muser;
            if (r7 == null) goto L20;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            MeetingAISSDInfo r8 = r5.mssd_info;
            if (r8 == null) goto L23;
            MeetingAISSDInfo.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingAISubtitle) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAISubtitle();
        DEFAULT_SENTENCE_ID = 0L;
        DEFAULT_START_MS = 0L;
        DEFAULT_STOP_MS = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3295newBuilder() {
        Builder r0 = new Builder();
        r0.msentence_id = this.msentence_id;
        r0.mcontent = this.mcontent;
        r0.mlang = this.mlang;
        r0.mstart_ms = this.mstart_ms;
        r0.mstop_ms = this.mstop_ms;
        r0.muser = this.muser;
        r0.mssd_info = this.mssd_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingAISubtitle.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3295newBuilder();
    }

    public MeetingAISubtitle(Long r10, String r11, String r12, Long r13, Long r14, ByteviewUser r15, MeetingAISSDInfo r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public MeetingAISubtitle(Long r2, String r3, String r4, Long r5, Long r6, ByteviewUser r7, MeetingAISSDInfo r8, ByteString r9) {
        super(ADAPTER, r9);
        this.msentence_id = r2;
        this.mcontent = r3;
        this.mlang = r4;
        this.mstart_ms = r5;
        this.mstop_ms = r6;
        this.muser = r7;
        this.mssd_info = r8;
    }
}
