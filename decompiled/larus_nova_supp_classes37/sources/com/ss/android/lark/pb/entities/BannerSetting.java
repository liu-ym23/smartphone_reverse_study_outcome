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
public final class BannerSetting extends com.squareup.wire.Message<BannerSetting, Builder> {
    public static final ProtoAdapter<BannerSetting> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Integer DEFAULT_CHAT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_CHAT_THREAD_POSITION = null;
    public static final Boolean DEFAULT_CLEAN_HISTORY_MESSAGE = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final Integer mchat_message_position;
    public final Integer mchat_thread_position;
    public final Boolean mclean_history_message;
    public final Map<String, String> mi18n_names;

    public static final class Builder extends com.squareup.wire.Message.Builder<BannerSetting, Builder> {
        public Long mchat_id;
        public Integer mchat_message_position;
        public Integer mchat_thread_position;
        public Boolean mclean_history_message;
        public Map<String, String> mi18n_names;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerSetting m1016build() {
            Long r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new BannerSetting(this.mchat_id, this.mchat_message_position, this.mchat_thread_position, this.mi18n_names, this.mclean_history_message, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
            this.mi18n_names = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1016build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder chat_message_position(Integer r1) {
            this.mchat_message_position = r1;
            return this;
        }

        public Builder chat_thread_position(Integer r1) {
            this.mchat_thread_position = r1;
            return this;
        }

        public Builder clean_history_message(Boolean r1) {
            this.mclean_history_message = r1;
            return this;
        }

        public Builder i18n_names(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_names = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerSetting extends ProtoAdapter<BannerSetting> {
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_BannerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerSetting.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public BannerSetting decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.mchat_message_position = 0;
            r0.mchat_thread_position = 0;
            r0.mclean_history_message = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat_message_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mchat_thread_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mi18n_names.putAll((Map) this.mi18n_names.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mclean_history_message = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1016build();
        }

        public int encodedSize(BannerSetting r6) {
            int r0 = ProtoAdapter.INT64.encodedSizeWithTag(1, r6.mchat_id);
            Integer r1 = r6.mchat_message_position;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Integer r5 = r6.mchat_thread_position;
            if (r5 == null) goto L9;
            int r7 = ProtoAdapter.INT32.encodedSizeWithTag(3, r5);
        L10:
            int r8 = (r4 + r7) + this.mi18n_names.encodedSizeWithTag(4, r6.mi18n_names);
            Boolean r9 = r6.mclean_history_message;
            if (r9 == null) goto L14;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r9);
        L14:
            return (r8 + r2) + r6.unknownFields().size();
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1017decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerSetting) r1);
        }

        public void encode(ProtoWriter r4, BannerSetting r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.mchat_id);
            Integer r0 = r5.mchat_message_position;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r0);
        L5:
            Integer r1 = r5.mchat_thread_position;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r1);
        L8:
            this.mi18n_names.encodeWithTag(r4, 4, r5.mi18n_names);
            Boolean r2 = r5.mclean_history_message;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerSetting) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerSetting();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_CHAT_MESSAGE_POSITION = 0;
        DEFAULT_CHAT_THREAD_POSITION = 0;
        DEFAULT_CLEAN_HISTORY_MESSAGE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1015newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mchat_message_position = this.mchat_message_position;
        r0.mchat_thread_position = this.mchat_thread_position;
        r0.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r0.mclean_history_message = this.mclean_history_message;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1015newBuilder();
    }

    public BannerSetting(Long r8, Integer r9, Integer r10, Map<String, String> r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public BannerSetting(Long r2, Integer r3, Integer r4, Map<String, String> r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mchat_id = r2;
        this.mchat_message_position = r3;
        this.mchat_thread_position = r4;
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r5);
        this.mclean_history_message = r6;
    }
}
