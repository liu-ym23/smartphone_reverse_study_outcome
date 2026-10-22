package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserGuideInfo extends Message<UserGuideInfo, Builder> {
    public static final ProtoAdapter<UserGuideInfo> ADAPTER = null;
    public static final String DEFAULT_CONTEXT = "";
    public static final Integer DEFAULT_CUR_COUNT = null;
    public static final Integer DEFAULT_CUR_STEP = null;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_MAX_COUNT = null;
    public static final Integer DEFAULT_MAX_STEP = null;
    public static final Long DEFAULT_PRIORITY = null;
    private static final long serialVersionUID = 0;
    public final String mcontext;
    public final Integer mcur_count;
    public final Integer mcur_step;
    public final String mkey;
    public final Integer mmax_count;
    public final Integer mmax_step;
    public final Long mpriority;

    public static final class Builder extends Message.Builder<UserGuideInfo, Builder> {
        public String mcontext;
        public Integer mcur_count;
        public Integer mcur_step;
        public String mkey;
        public Integer mmax_count;
        public Integer mmax_step;
        public Long mpriority;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserGuideInfo m1736build() {
            return new UserGuideInfo(this.mkey, this.mpriority, this.mcur_step, this.mmax_step, this.mcontext, this.mcur_count, this.mmax_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1736build();
        }

        public Builder context(String r1) {
            this.mcontext = r1;
            return this;
        }

        public Builder cur_count(Integer r1) {
            this.mcur_count = r1;
            return this;
        }

        public Builder cur_step(Integer r1) {
            this.mcur_step = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder max_count(Integer r1) {
            this.mmax_count = r1;
            return this;
        }

        public Builder max_step(Integer r1) {
            this.mmax_step = r1;
            return this;
        }

        public Builder priority(Long r1) {
            this.mpriority = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGuideInfo extends ProtoAdapter<UserGuideInfo> {
        public ProtoAdapter_UserGuideInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGuideInfo.class);
        }

        public UserGuideInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mpriority = 0L;
            r0.mcur_step = 0;
            r0.mmax_step = 0;
            r0.mcontext = "";
            r0.mcur_count = 0;
            r0.mmax_count = 0;
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
            r0.mmax_count = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            r0.mcur_count = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L9:
            r0.mcontext = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mmax_step = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L11:
            r0.mcur_step = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            r0.mpriority = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L13:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m1736build();
        }

        public int encodedSize(UserGuideInfo r6) {
            String r0 = r6.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mpriority;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mcur_step;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.mmax_step;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mcontext;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Integer r16 = r6.mcur_count;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT32.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Integer r19 = r6.mmax_count;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(7, r19);
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
        public /* bridge */ /* synthetic */ Object m1737decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserGuideInfo) r1);
        }

        public void encode(ProtoWriter r4, UserGuideInfo r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mpriority;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mcur_step;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            Integer r3 = r5.mmax_step;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mcontext;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            Integer r7 = r5.mcur_count;
            if (r7 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r4, 6, r7);
        L20:
            Integer r8 = r5.mmax_count;
            if (r8 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserGuideInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGuideInfo();
        DEFAULT_PRIORITY = 0L;
        DEFAULT_CUR_STEP = 0;
        DEFAULT_MAX_STEP = 0;
        DEFAULT_CUR_COUNT = 0;
        DEFAULT_MAX_COUNT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1735newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mpriority = this.mpriority;
        r0.mcur_step = this.mcur_step;
        r0.mmax_step = this.mmax_step;
        r0.mcontext = this.mcontext;
        r0.mcur_count = this.mcur_count;
        r0.mmax_count = this.mmax_count;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserGuideInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1735newBuilder();
    }

    public UserGuideInfo(String r10, Long r11, Integer r12, Integer r13, String r14, Integer r15, Integer r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public UserGuideInfo(String r2, Long r3, Integer r4, Integer r5, String r6, Integer r7, Integer r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mkey = r2;
        this.mpriority = r3;
        this.mcur_step = r4;
        this.mmax_step = r5;
        this.mcontext = r6;
        this.mcur_count = r7;
        this.mmax_count = r8;
    }
}
