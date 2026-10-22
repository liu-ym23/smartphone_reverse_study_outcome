package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatterCustomStatus extends com.squareup.wire.Message<ChatterCustomStatus, Builder> {
    public static final ProtoAdapter<ChatterCustomStatus> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final Boolean DEFAULT_IS_NOT_DISTURB_MODE = null;
    public static final Long DEFAULT_STATUS_ID = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final EffectiveInterval meffective_interval;
    public final String mfs_unit;
    public final Map<String, String> mi18n_title;
    public final String micon_key;
    public final Boolean mis_not_disturb_mode;
    public final Long mstatus_id;
    public final TagInfo mtag_info;
    public final TimeFormat mtime_format;
    public final String mtitle;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatterCustomStatus, Builder> {
        public EffectiveInterval meffective_interval;
        public String mfs_unit;
        public Map<String, String> mi18n_title;
        public String micon_key;
        public Boolean mis_not_disturb_mode;
        public Long mstatus_id;
        public TagInfo mtag_info;
        public TimeFormat mtime_format;
        public String mtitle;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatterCustomStatus m1178build() {
            return new ChatterCustomStatus(this.mtitle, this.mi18n_title, this.micon_key, this.mfs_unit, this.meffective_interval, this.mis_not_disturb_mode, this.mtag_info, this.mtime_format, this.mstatus_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_title = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1178build();
        }

        public Builder effective_interval(EffectiveInterval r1) {
            this.meffective_interval = r1;
            return this;
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder i18n_title(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_title = r1;
            return this;
        }

        public Builder icon_key(String r1) {
            this.micon_key = r1;
            return this;
        }

        public Builder is_not_disturb_mode(Boolean r1) {
            this.mis_not_disturb_mode = r1;
            return this;
        }

        public Builder status_id(Long r1) {
            this.mstatus_id = r1;
            return this;
        }

        public Builder tag_info(TagInfo r1) {
            this.mtag_info = r1;
            return this;
        }

        public Builder time_format(TimeFormat r1) {
            this.mtime_format = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatterCustomStatus extends ProtoAdapter<ChatterCustomStatus> {
        private final ProtoAdapter<Map<String, String>> mi18n_title;

        public ProtoAdapter_ChatterCustomStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatterCustomStatus.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_title = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ChatterCustomStatus decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtitle = "";
            r0.micon_key = "";
            r0.mfs_unit = "";
            r0.mis_not_disturb_mode = Boolean.FALSE;
            r0.mstatus_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r0.mstatus_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            r0.mtime_format = (TimeFormat) TimeFormat.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.mtag_info = (TagInfo) TagInfo.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.mis_not_disturb_mode = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            r0.meffective_interval = (EffectiveInterval) EffectiveInterval.ADAPTER.decode(r7);
            goto L3
        L12:
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.micon_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mi18n_title.putAll((Map) this.mi18n_title.decode(r7));
            goto L3
        L15:
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.m1178build();
        }

        public int encodedSize(ChatterCustomStatus r6) {
            String r0 = r6.mtitle;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + this.mi18n_title.encodedSizeWithTag(2, r6.mi18n_title);
            String r4 = r6.micon_key;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.STRING.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.mfs_unit;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
        L14:
            int r10 = r7 + r9;
            EffectiveInterval r11 = r6.meffective_interval;
            if (r11 == null) goto L17;
            int r12 = EffectiveInterval.ADAPTER.encodedSizeWithTag(5, r11);
        L18:
            int r13 = r10 + r12;
            Boolean r14 = r6.mis_not_disturb_mode;
            if (r14 == null) goto L21;
            int r15 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r14);
        L22:
            int r16 = r13 + r15;
            TagInfo r17 = r6.mtag_info;
            if (r17 == null) goto L25;
            int r18 = TagInfo.ADAPTER.encodedSizeWithTag(7, r17);
        L26:
            int r19 = r16 + r18;
            TimeFormat r20 = r6.mtime_format;
            if (r20 == null) goto L29;
            int r21 = TimeFormat.ADAPTER.encodedSizeWithTag(8, r20);
        L30:
            int r22 = r19 + r21;
            Long r23 = r6.mstatus_id;
            if (r23 == null) goto L34;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(9, r23);
        L34:
            return (r22 + r1) + r6.unknownFields().size();
        L29:
            r21 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1179decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatterCustomStatus) r1);
        }

        public void encode(ProtoWriter r4, ChatterCustomStatus r5) throws IOException {
            String r0 = r5.mtitle;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            this.mi18n_title.encodeWithTag(r4, 2, r5.mi18n_title);
            String r1 = r5.micon_key;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
        L8:
            String r2 = r5.mfs_unit;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            EffectiveInterval r3 = r5.meffective_interval;
            if (r3 == null) goto L14;
            EffectiveInterval.ADAPTER.encodeWithTag(r4, 5, r3);
        L14:
            Boolean r6 = r5.mis_not_disturb_mode;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r6);
        L17:
            TagInfo r7 = r5.mtag_info;
            if (r7 == null) goto L20;
            TagInfo.ADAPTER.encodeWithTag(r4, 7, r7);
        L20:
            TimeFormat r8 = r5.mtime_format;
            if (r8 == null) goto L23;
            TimeFormat.ADAPTER.encodeWithTag(r4, 8, r8);
        L23:
            Long r9 = r5.mstatus_id;
            if (r9 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r4, 9, r9);
        L26:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatterCustomStatus) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatterCustomStatus();
        DEFAULT_IS_NOT_DISTURB_MODE = Boolean.FALSE;
        DEFAULT_STATUS_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1177newBuilder() {
        Builder r0 = new Builder();
        r0.mtitle = this.mtitle;
        r0.mi18n_title = Internal.copyOf("mi18n_title", this.mi18n_title);
        r0.micon_key = this.micon_key;
        r0.mfs_unit = this.mfs_unit;
        r0.meffective_interval = this.meffective_interval;
        r0.mis_not_disturb_mode = this.mis_not_disturb_mode;
        r0.mtag_info = this.mtag_info;
        r0.mtime_format = this.mtime_format;
        r0.mstatus_id = this.mstatus_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatterCustomStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1177newBuilder();
    }

    public ChatterCustomStatus(String r12, Map<String, String> r13, String r14, String r15, EffectiveInterval r16, Boolean r17, TagInfo r18, TimeFormat r19, Long r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public ChatterCustomStatus(String r2, Map<String, String> r3, String r4, String r5, EffectiveInterval r6, Boolean r7, TagInfo r8, TimeFormat r9, Long r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mtitle = r2;
        this.mi18n_title = Internal.immutableCopyOf("mi18n_title", r3);
        this.micon_key = r4;
        this.mfs_unit = r5;
        this.meffective_interval = r6;
        this.mis_not_disturb_mode = r7;
        this.mtag_info = r8;
        this.mtime_format = r9;
        this.mstatus_id = r10;
    }
}
