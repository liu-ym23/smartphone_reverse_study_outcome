package com.ss.android.lark.pb.graph;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullClosestChattersRequest extends Message<PullClosestChattersRequest, Builder> {
    public static final ProtoAdapter<PullClosestChattersRequest> ADAPTER = null;
    public static final Integer DEFAULT_BEGIN = null;
    public static final Integer DEFAULT_END = null;
    public static final Boolean DEFAULT_IS_FETCH_FEATURE = null;
    public static final Boolean DEFAULT_IS_NEED_AGENT = null;
    public static final Boolean DEFAULT_IS_NEED_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_NEED_EMAIL_ADDRESS = null;
    public static final Boolean DEFAULT_IS_NEED_EXTENDED_FIELDS = null;
    public static final Boolean DEFAULT_IS_NEED_RELATIONSHIP = null;
    public static final String DEFAULT_LOCALE_IDENTIFIER = "zh_CN";
    private static final long serialVersionUID = 0;
    public final Integer mbegin;
    public final Integer mend;
    public final FilterParam mfilter_param;
    public final Boolean mis_fetch_feature;
    public final Boolean mis_need_agent;
    public final Boolean mis_need_department;
    public final Boolean mis_need_email_address;
    public final Boolean mis_need_extended_fields;
    public final Boolean mis_need_relationship;
    public final String mlocale_identifier;
    public final PullStrategy mpull_type;
    public final Scene mscene;
    public final List<UpdateId> mupdate_ids;

    public static final class Builder extends Message.Builder<PullClosestChattersRequest, Builder> {
        public Integer mbegin;
        public Integer mend;
        public FilterParam mfilter_param;
        public Boolean mis_fetch_feature;
        public Boolean mis_need_agent;
        public Boolean mis_need_department;
        public Boolean mis_need_email_address;
        public Boolean mis_need_extended_fields;
        public Boolean mis_need_relationship;
        public String mlocale_identifier;
        public PullStrategy mpull_type;
        public Scene mscene;
        public List<UpdateId> mupdate_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullClosestChattersRequest m1703build() {
            return new PullClosestChattersRequest(this.mlocale_identifier, this.mbegin, this.mend, this.mfilter_param, this.mscene, this.mis_fetch_feature, this.mis_need_email_address, this.mis_need_extended_fields, this.mpull_type, this.mupdate_ids, this.mis_need_relationship, this.mis_need_department, this.mis_need_agent, super.buildUnknownFields());
        }

        public Builder() {
            this.mupdate_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1703build();
        }

        public Builder begin(Integer r1) {
            this.mbegin = r1;
            return this;
        }

        public Builder end(Integer r1) {
            this.mend = r1;
            return this;
        }

        public Builder filter_param(FilterParam r1) {
            this.mfilter_param = r1;
            return this;
        }

        public Builder is_fetch_feature(Boolean r1) {
            this.mis_fetch_feature = r1;
            return this;
        }

        public Builder is_need_agent(Boolean r1) {
            this.mis_need_agent = r1;
            return this;
        }

        public Builder is_need_department(Boolean r1) {
            this.mis_need_department = r1;
            return this;
        }

        public Builder is_need_email_address(Boolean r1) {
            this.mis_need_email_address = r1;
            return this;
        }

        public Builder is_need_extended_fields(Boolean r1) {
            this.mis_need_extended_fields = r1;
            return this;
        }

        public Builder is_need_relationship(Boolean r1) {
            this.mis_need_relationship = r1;
            return this;
        }

        public Builder locale_identifier(String r1) {
            this.mlocale_identifier = r1;
            return this;
        }

        public Builder pull_type(PullStrategy r1) {
            this.mpull_type = r1;
            return this;
        }

        public Builder scene(Scene r1) {
            this.mscene = r1;
            return this;
        }

        public Builder update_ids(List<UpdateId> r1) {
            Internal.checkElementsNotNull(r1);
            this.mupdate_ids = r1;
            return this;
        }
    }

    public static final class FilterParam extends Message<FilterParam, Builder> {
        public static final ProtoAdapter<FilterParam> ADAPTER = null;
        public static final String DEFAULT_AGENDA_ID = "";
        public static final Long DEFAULT_AGENDA_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final String magenda_id;
        public final Long magenda_start_time;
        public final List<String> mchat_ids;

        public static final class Builder extends Message.Builder<FilterParam, Builder> {
            public String magenda_id;
            public Long magenda_start_time;
            public List<String> mchat_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FilterParam m1705build() {
                return new FilterParam(this.mchat_ids, this.magenda_id, this.magenda_start_time, super.buildUnknownFields());
            }

            public Builder() {
                this.mchat_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1705build();
            }

            public Builder agenda_id(String r1) {
                this.magenda_id = r1;
                return this;
            }

            public Builder agenda_start_time(Long r1) {
                this.magenda_start_time = r1;
                return this;
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_FilterParam extends ProtoAdapter<FilterParam> {
            public ProtoAdapter_FilterParam() {
                super(FieldEncoding.LENGTH_DELIMITED, FilterParam.class);
            }

            public FilterParam decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.magenda_id = "";
                r0.magenda_start_time = 0L;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.magenda_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.magenda_start_time = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1705build();
            }

            public int encodedSize(FilterParam r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.asRepeated().encodedSizeWithTag(1, r6.mchat_ids);
                String r2 = r6.magenda_id;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = r0.encodedSizeWithTag(2, r2);
            L6:
                int r5 = r1 + r4;
                Long r7 = r6.magenda_start_time;
                if (r7 == null) goto L10;
                r3 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L10:
                return (r5 + r3) + r6.unknownFields().size();
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1706decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FilterParam) r1);
            }

            public void encode(ProtoWriter r5, FilterParam r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 1, r6.mchat_ids);
                String r1 = r6.magenda_id;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r5, 2, r1);
            L5:
                Long r2 = r6.magenda_start_time;
                if (r2 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
            L8:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FilterParam) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FilterParam();
            DEFAULT_AGENDA_START_TIME = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1704newBuilder() {
            Builder r0 = new Builder();
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.magenda_id = this.magenda_id;
            r0.magenda_start_time = this.magenda_start_time;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FilterParam.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1704newBuilder();
        }

        public FilterParam(List<String> r2, String r3, Long r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public FilterParam(List<String> r2, String r3, Long r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r2);
            this.magenda_id = r3;
            this.magenda_start_time = r4;
        }
    }

    public static final class ProtoAdapter_PullClosestChattersRequest extends ProtoAdapter<PullClosestChattersRequest> {
        public ProtoAdapter_PullClosestChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullClosestChattersRequest.class);
        }

        public PullClosestChattersRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mlocale_identifier = PullClosestChattersRequest.DEFAULT_LOCALE_IDENTIFIER;
            r0.mbegin = 0;
            r0.mend = 4;
            Boolean r1 = Boolean.FALSE;
            r0.mis_fetch_feature = r1;
            r0.mis_need_email_address = r1;
            r0.mis_need_extended_fields = r1;
            r0.mis_need_relationship = r1;
            r0.mis_need_department = r1;
            r0.mis_need_agent = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L26;
            switch(r3) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L30;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L28;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            r0.mpull_type = (PullStrategy) PullStrategy.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r0.mscene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mis_need_agent = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.mis_need_department = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            r0.mis_need_relationship = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.mupdate_ids.add((UpdateId) UpdateId.ADAPTER.decode(r9));
            goto L3
        L15:
            r0.mis_need_extended_fields = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L16:
            r0.mis_need_email_address = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L17:
            r0.mis_fetch_feature = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L22:
            r0.mfilter_param = (FilterParam) FilterParam.ADAPTER.decode(r9);
            goto L3
        L23:
            r0.mend = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L24:
            r0.mbegin = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L25:
            r0.mlocale_identifier = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L26:
            r9.endMessage(r2);
            return r0.m1703build();
        }

        public int encodedSize(PullClosestChattersRequest r6) {
            String r0 = r6.mlocale_identifier;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mbegin;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mend;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            FilterParam r10 = r6.mfilter_param;
            if (r10 == null) goto L17;
            int r11 = FilterParam.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Scene r13 = r6.mscene;
            if (r13 == null) goto L21;
            int r14 = Scene.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r6.mis_fetch_feature;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mis_need_email_address;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Boolean r22 = r6.mis_need_extended_fields;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            PullStrategy r25 = r6.mpull_type;
            if (r25 == null) goto L37;
            int r26 = PullStrategy.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = (r24 + r26) + UpdateId.ADAPTER.asRepeated().encodedSizeWithTag(10, r6.mupdate_ids);
            Boolean r28 = r6.mis_need_relationship;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r28);
        L42:
            int r30 = r27 + r29;
            Boolean r31 = r6.mis_need_department;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r31);
        L46:
            int r33 = r30 + r32;
            Boolean r34 = r6.mis_need_agent;
            if (r34 == null) goto L50;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r34);
        L50:
            return (r33 + r1) + r6.unknownFields().size();
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ Object m1707decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullClosestChattersRequest) r1);
        }

        public void encode(ProtoWriter r4, PullClosestChattersRequest r5) throws IOException {
            String r0 = r5.mlocale_identifier;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mbegin;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mend;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            FilterParam r3 = r5.mfilter_param;
            if (r3 == null) goto L14;
            FilterParam.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            Scene r6 = r5.mscene;
            if (r6 == null) goto L17;
            Scene.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            Boolean r7 = r5.mis_fetch_feature;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mis_need_email_address;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            Boolean r9 = r5.mis_need_extended_fields;
            if (r9 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r9);
        L26:
            PullStrategy r10 = r5.mpull_type;
            if (r10 == null) goto L29;
            PullStrategy.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            UpdateId.ADAPTER.asRepeated().encodeWithTag(r4, 10, r5.mupdate_ids);
            Boolean r11 = r5.mis_need_relationship;
            if (r11 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r4, 11, r11);
        L32:
            Boolean r12 = r5.mis_need_department;
            if (r12 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r4, 12, r12);
        L35:
            Boolean r13 = r5.mis_need_agent;
            if (r13 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r4, 13, r13);
        L38:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullClosestChattersRequest) r2);
        }
    }

    public static final enum PullStrategy extends Enum<PullStrategy> implements WireEnum {
        private static final /* synthetic */ PullStrategy[] $VALUES = null;
        public static final ProtoAdapter<PullStrategy> ADAPTER = null;
        public static final PullStrategy PullStrategy_FULL = null;
        public static final PullStrategy PullStrategy_UNKNOWN = null;
        public static final PullStrategy PullStrategy_UPDATE = null;
        private final int value;

        static {
            PullStrategy r0 = new PullStrategy("PullStrategy_UNKNOWN", 0, 0);
            PullStrategy_UNKNOWN = r0;
            PullStrategy r1 = new PullStrategy("PullStrategy_FULL", 1, 1);
            PullStrategy_FULL = r1;
            PullStrategy r3 = new PullStrategy("PullStrategy_UPDATE", 2, 2);
            PullStrategy_UPDATE = r3;
            $VALUES = new PullStrategy[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(PullStrategy.class);
        }

        public static PullStrategy[] values() {
            return (PullStrategy[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static PullStrategy fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return PullStrategy_UPDATE;
        L12:
            return PullStrategy_FULL;
        L14:
            return PullStrategy_UNKNOWN;
        }

        public static PullStrategy valueOf(String r1) {
            return (PullStrategy) a.a(PullStrategy.class, r1);
        }

        private PullStrategy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene SEARCH = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r0 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Scene r1 = new Scene("SEARCH", 1, 1);
            SEARCH = r1;
            $VALUES = new Scene[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return SEARCH;
        L10:
            return UNKNOWN;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class UpdateId extends Message<UpdateId, Builder> {
        public static final ProtoAdapter<UpdateId> ADAPTER = null;
        public static final Long DEFAULT_TENANT_ID = null;
        public static final Long DEFAULT_USER_ID = null;
        private static final long serialVersionUID = 0;
        public final Long mtenant_id;
        public final Long muser_id;

        public static final class Builder extends Message.Builder<UpdateId, Builder> {
            public Long mtenant_id;
            public Long muser_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UpdateId m1709build() {
                Long r0 = this.muser_id;
                if (r0 == null) goto L7;
                return new UpdateId(this.muser_id, this.mtenant_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "muser_id"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1709build();
            }

            public Builder tenant_id(Long r1) {
                this.mtenant_id = r1;
                return this;
            }

            public Builder user_id(Long r1) {
                this.muser_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_UpdateId extends ProtoAdapter<UpdateId> {
            public ProtoAdapter_UpdateId() {
                super(FieldEncoding.LENGTH_DELIMITED, UpdateId.class);
            }

            public UpdateId decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_id = 0L;
                r0.mtenant_id = -1L;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.muser_id = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mtenant_id = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1709build();
            }

            public int encodedSize(UpdateId r5) {
                ProtoAdapter r0 = ProtoAdapter.INT64;
                int r1 = r0.encodedSizeWithTag(1, r5.muser_id);
                Long r2 = r5.mtenant_id;
                if (r2 == null) goto L5;
                int r3 = r0.encodedSizeWithTag(2, r2);
            L7:
                return (r1 + r3) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1710decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UpdateId) r1);
            }

            public void encode(ProtoWriter r4, UpdateId r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.INT64;
                r0.encodeWithTag(r4, 1, r5.muser_id);
                Long r1 = r5.mtenant_id;
                if (r1 == null) goto L5;
                r0.encodeWithTag(r4, 2, r1);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UpdateId) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UpdateId();
            DEFAULT_USER_ID = 0L;
            DEFAULT_TENANT_ID = -1L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1708newBuilder() {
            Builder r0 = new Builder();
            r0.muser_id = this.muser_id;
            r0.mtenant_id = this.mtenant_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UpdateId.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1708newBuilder();
        }

        public UpdateId(Long r2, Long r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public UpdateId(Long r2, Long r3, ByteString r4) {
            super(ADAPTER, r4);
            this.muser_id = r2;
            this.mtenant_id = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullClosestChattersRequest();
        DEFAULT_BEGIN = 0;
        DEFAULT_END = 4;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_FETCH_FEATURE = r0;
        DEFAULT_IS_NEED_EMAIL_ADDRESS = r0;
        DEFAULT_IS_NEED_EXTENDED_FIELDS = r0;
        DEFAULT_IS_NEED_RELATIONSHIP = r0;
        DEFAULT_IS_NEED_DEPARTMENT = r0;
        DEFAULT_IS_NEED_AGENT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1702newBuilder() {
        Builder r0 = new Builder();
        r0.mlocale_identifier = this.mlocale_identifier;
        r0.mbegin = this.mbegin;
        r0.mend = this.mend;
        r0.mfilter_param = this.mfilter_param;
        r0.mscene = this.mscene;
        r0.mis_fetch_feature = this.mis_fetch_feature;
        r0.mis_need_email_address = this.mis_need_email_address;
        r0.mis_need_extended_fields = this.mis_need_extended_fields;
        r0.mpull_type = this.mpull_type;
        r0.mupdate_ids = Internal.copyOf("mupdate_ids", this.mupdate_ids);
        r0.mis_need_relationship = this.mis_need_relationship;
        r0.mis_need_department = this.mis_need_department;
        r0.mis_need_agent = this.mis_need_agent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullClosestChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1702newBuilder();
    }

    public PullClosestChattersRequest(String r16, Integer r17, Integer r18, FilterParam r19, Scene r20, Boolean r21, Boolean r22, Boolean r23, PullStrategy r24, List<UpdateId> r25, Boolean r26, Boolean r27, Boolean r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public PullClosestChattersRequest(String r2, Integer r3, Integer r4, FilterParam r5, Scene r6, Boolean r7, Boolean r8, Boolean r9, PullStrategy r10, List<UpdateId> r11, Boolean r12, Boolean r13, Boolean r14, ByteString r15) {
        super(ADAPTER, r15);
        this.mlocale_identifier = r2;
        this.mbegin = r3;
        this.mend = r4;
        this.mfilter_param = r5;
        this.mscene = r6;
        this.mis_fetch_feature = r7;
        this.mis_need_email_address = r8;
        this.mis_need_extended_fields = r9;
        this.mpull_type = r10;
        this.mupdate_ids = Internal.immutableCopyOf("mupdate_ids", r11);
        this.mis_need_relationship = r12;
        this.mis_need_department = r13;
        this.mis_need_agent = r14;
    }
}
