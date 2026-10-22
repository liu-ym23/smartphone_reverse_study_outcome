package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullOnboardInfoRequest extends Message<PullOnboardInfoRequest, Builder> {
    public static final ProtoAdapter<PullOnboardInfoRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_NEED_SAMPLE_ANSWER = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final Integer mcount;
    public final Boolean mneed_sample_answer;
    public final OnboardType monboard_type;
    public final Integer mversion;

    public static final class Builder extends Message.Builder<PullOnboardInfoRequest, Builder> {
        public Long mchat_id;
        public Integer mcount;
        public Boolean mneed_sample_answer;
        public OnboardType monboard_type;
        public Integer mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullOnboardInfoRequest m1988build() {
            Long r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new PullOnboardInfoRequest(this.mchat_id, this.monboard_type, this.mversion, this.mneed_sample_answer, this.mcount, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1988build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder count(Integer r1) {
            this.mcount = r1;
            return this;
        }

        public Builder need_sample_answer(Boolean r1) {
            this.mneed_sample_answer = r1;
            return this;
        }

        public Builder onboard_type(OnboardType r1) {
            this.monboard_type = r1;
            return this;
        }

        public Builder version(Integer r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final enum OnboardType extends Enum<OnboardType> implements WireEnum {
        private static final /* synthetic */ OnboardType[] $VALUES = null;
        public static final ProtoAdapter<OnboardType> ADAPTER = null;
        public static final OnboardType ENTERPRISE_SEARCH = null;
        public static final OnboardType SCENE = null;
        private final int value;

        static {
            OnboardType r0 = new OnboardType("SCENE", 0, 0);
            SCENE = r0;
            OnboardType r1 = new OnboardType("ENTERPRISE_SEARCH", 1, 1);
            ENTERPRISE_SEARCH = r1;
            $VALUES = new OnboardType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(OnboardType.class);
        }

        public static OnboardType[] values() {
            return (OnboardType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static OnboardType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return ENTERPRISE_SEARCH;
        L10:
            return SCENE;
        }

        public static OnboardType valueOf(String r1) {
            return (OnboardType) a.a(OnboardType.class, r1);
        }

        private OnboardType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_PullOnboardInfoRequest extends ProtoAdapter<PullOnboardInfoRequest> {
        public ProtoAdapter_PullOnboardInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullOnboardInfoRequest.class);
        }

        public PullOnboardInfoRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.mversion = 0;
            r0.mneed_sample_answer = Boolean.FALSE;
            r0.mcount = 0;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.monboard_type = (OnboardType) OnboardType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mversion = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mneed_sample_answer = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mcount = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1988build();
        }

        public int encodedSize(PullOnboardInfoRequest r6) {
            int r0 = ProtoAdapter.INT64.encodedSizeWithTag(1, r6.mchat_id);
            OnboardType r1 = r6.monboard_type;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = OnboardType.ADAPTER.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Integer r5 = r6.mversion;
            if (r5 == null) goto L9;
            int r7 = ProtoAdapter.INT32.encodedSizeWithTag(3, r5);
        L10:
            int r8 = r4 + r7;
            Boolean r9 = r6.mneed_sample_answer;
            if (r9 == null) goto L13;
            int r10 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r9);
        L14:
            int r11 = r8 + r10;
            Integer r12 = r6.mcount;
            if (r12 == null) goto L18;
            r2 = ProtoAdapter.INT32.encodedSizeWithTag(5, r12);
        L18:
            return (r11 + r2) + r6.unknownFields().size();
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1989decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullOnboardInfoRequest) r1);
        }

        public void encode(ProtoWriter r4, PullOnboardInfoRequest r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.mchat_id);
            OnboardType r0 = r5.monboard_type;
            if (r0 == null) goto L5;
            OnboardType.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            Integer r1 = r5.mversion;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r1);
        L8:
            Boolean r2 = r5.mneed_sample_answer;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
        L11:
            Integer r3 = r5.mcount;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullOnboardInfoRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullOnboardInfoRequest();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_VERSION = 0;
        DEFAULT_NEED_SAMPLE_ANSWER = Boolean.FALSE;
        DEFAULT_COUNT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1987newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.monboard_type = this.monboard_type;
        r0.mversion = this.mversion;
        r0.mneed_sample_answer = this.mneed_sample_answer;
        r0.mcount = this.mcount;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullOnboardInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1987newBuilder();
    }

    public PullOnboardInfoRequest(Long r8, OnboardType r9, Integer r10, Boolean r11, Integer r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public PullOnboardInfoRequest(Long r2, OnboardType r3, Integer r4, Boolean r5, Integer r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mchat_id = r2;
        this.monboard_type = r3;
        this.mversion = r4;
        this.mneed_sample_answer = r5;
        this.mcount = r6;
    }
}
