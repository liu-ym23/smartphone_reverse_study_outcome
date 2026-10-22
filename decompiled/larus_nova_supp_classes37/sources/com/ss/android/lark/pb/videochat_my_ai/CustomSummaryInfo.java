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
public final class CustomSummaryInfo extends Message<CustomSummaryInfo, Builder> {
    public static final ProtoAdapter<CustomSummaryInfo> ADAPTER = null;
    public static final String DEFAULT_ANALYZE_LINK_URL = "";
    public static final Boolean DEFAULT_IS_OPEN = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String manalyze_link_url;
    public final List<CustomSummaryAutoDetectSpeaker> mauto_detect_speaker;
    public final Boolean mis_open;
    public final CustomSummaryMinutesMeetingInfo mminutes_meeting_info;
    public final List<CustomSummaryItem> msummary_items;
    public final Integer mversion;

    public static final class Builder extends Message.Builder<CustomSummaryInfo, Builder> {
        public String manalyze_link_url;
        public List<CustomSummaryAutoDetectSpeaker> mauto_detect_speaker;
        public Boolean mis_open;
        public CustomSummaryMinutesMeetingInfo mminutes_meeting_info;
        public List<CustomSummaryItem> msummary_items;
        public Integer mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomSummaryInfo m3248build() {
            return new CustomSummaryInfo(this.mis_open, this.msummary_items, this.mversion, this.manalyze_link_url, this.mminutes_meeting_info, this.mauto_detect_speaker, super.buildUnknownFields());
        }

        public Builder() {
            this.msummary_items = Internal.newMutableList();
            this.mauto_detect_speaker = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3248build();
        }

        public Builder analyze_link_url(String r1) {
            this.manalyze_link_url = r1;
            return this;
        }

        public Builder auto_detect_speaker(List<CustomSummaryAutoDetectSpeaker> r1) {
            Internal.checkElementsNotNull(r1);
            this.mauto_detect_speaker = r1;
            return this;
        }

        public Builder is_open(Boolean r1) {
            this.mis_open = r1;
            return this;
        }

        public Builder minutes_meeting_info(CustomSummaryMinutesMeetingInfo r1) {
            this.mminutes_meeting_info = r1;
            return this;
        }

        public Builder summary_items(List<CustomSummaryItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.msummary_items = r1;
            return this;
        }

        public Builder version(Integer r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomSummaryInfo extends ProtoAdapter<CustomSummaryInfo> {
        public ProtoAdapter_CustomSummaryInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomSummaryInfo.class);
        }

        public CustomSummaryInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mis_open = Boolean.FALSE;
            r0.mversion = 0;
            r0.manalyze_link_url = "";
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
            r0.mauto_detect_speaker.add((CustomSummaryAutoDetectSpeaker) CustomSummaryAutoDetectSpeaker.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.mminutes_meeting_info = (CustomSummaryMinutesMeetingInfo) CustomSummaryMinutesMeetingInfo.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.manalyze_link_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mversion = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L11:
            r0.msummary_items.add((CustomSummaryItem) CustomSummaryItem.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.mis_open = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m3248build();
        }

        public int encodedSize(CustomSummaryInfo r6) {
            Boolean r0 = r6.mis_open;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + CustomSummaryItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.msummary_items);
            Integer r4 = r6.mversion;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.INT32.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.manalyze_link_url;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
        L14:
            int r10 = r7 + r9;
            CustomSummaryMinutesMeetingInfo r11 = r6.mminutes_meeting_info;
            if (r11 == null) goto L18;
            r1 = CustomSummaryMinutesMeetingInfo.ADAPTER.encodedSizeWithTag(5, r11);
        L18:
            return ((r10 + r1) + CustomSummaryAutoDetectSpeaker.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.mauto_detect_speaker)) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m3249decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomSummaryInfo) r1);
        }

        public void encode(ProtoWriter r4, CustomSummaryInfo r5) throws IOException {
            Boolean r0 = r5.mis_open;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            CustomSummaryItem.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.msummary_items);
            Integer r1 = r5.mversion;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r1);
        L8:
            String r2 = r5.manalyze_link_url;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            CustomSummaryMinutesMeetingInfo r3 = r5.mminutes_meeting_info;
            if (r3 == null) goto L14;
            CustomSummaryMinutesMeetingInfo.ADAPTER.encodeWithTag(r4, 5, r3);
        L14:
            CustomSummaryAutoDetectSpeaker.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.mauto_detect_speaker);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomSummaryInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomSummaryInfo();
        DEFAULT_IS_OPEN = Boolean.FALSE;
        DEFAULT_VERSION = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3247newBuilder() {
        Builder r0 = new Builder();
        r0.mis_open = this.mis_open;
        r0.msummary_items = Internal.copyOf("msummary_items", this.msummary_items);
        r0.mversion = this.mversion;
        r0.manalyze_link_url = this.manalyze_link_url;
        r0.mminutes_meeting_info = this.mminutes_meeting_info;
        r0.mauto_detect_speaker = Internal.copyOf("mauto_detect_speaker", this.mauto_detect_speaker);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomSummaryInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3247newBuilder();
    }

    public CustomSummaryInfo(Boolean r9, List<CustomSummaryItem> r10, Integer r11, String r12, CustomSummaryMinutesMeetingInfo r13, List<CustomSummaryAutoDetectSpeaker> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public CustomSummaryInfo(Boolean r2, List<CustomSummaryItem> r3, Integer r4, String r5, CustomSummaryMinutesMeetingInfo r6, List<CustomSummaryAutoDetectSpeaker> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mis_open = r2;
        this.msummary_items = Internal.immutableCopyOf("msummary_items", r3);
        this.mversion = r4;
        this.manalyze_link_url = r5;
        this.mminutes_meeting_info = r6;
        this.mauto_detect_speaker = Internal.immutableCopyOf("mauto_detect_speaker", r7);
    }
}
