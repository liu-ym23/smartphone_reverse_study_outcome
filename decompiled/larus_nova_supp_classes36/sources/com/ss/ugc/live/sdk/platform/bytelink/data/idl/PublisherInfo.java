package com.ss.ugc.live.sdk.platform.bytelink.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PublisherInfo extends AndroidMessage<PublisherInfo, Builder> {
    public static final ProtoAdapter<PublisherInfo> ADAPTER = null;
    public static final Parcelable.Creator<PublisherInfo> CREATOR = null;
    public static final Long DEFAULT_CLIENT_VISIBLE_ROOM_ID = null;
    public static final Integer DEFAULT_DISTRIBUTION_SCENE = null;
    public static final Long DEFAULT_FEED_TIME_MS = null;
    public static final String DEFAULT_PUBLISHER_ID = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long client_visible_room_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer distribution_scene;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 100)
    public final Map<String, String> extra_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long feed_time_ms;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String publisher_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long user_id;

    public static final class Builder extends Message.Builder<PublisherInfo, Builder> {
        public Long client_visible_room_id;
        public Integer distribution_scene;
        public Map<String, String> extra_info;
        public Long feed_time_ms;
        public String publisher_id;
        public Long user_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PublisherInfo m1723build() {
            return new PublisherInfo(this.publisher_id, this.user_id, this.distribution_scene, this.feed_time_ms, this.client_visible_room_id, this.extra_info, super.buildUnknownFields());
        }

        public Builder() {
            this.publisher_id = "";
            this.user_id = 0L;
            this.distribution_scene = 0;
            this.feed_time_ms = 0L;
            this.client_visible_room_id = 0L;
            this.extra_info = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1723build();
        }

        public Builder client_visible_room_id(Long r1) {
            this.client_visible_room_id = r1;
            return this;
        }

        public Builder distribution_scene(Integer r1) {
            this.distribution_scene = r1;
            return this;
        }

        public Builder extra_info(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extra_info = r1;
            return this;
        }

        public Builder feed_time_ms(Long r1) {
            this.feed_time_ms = r1;
            return this;
        }

        public Builder publisher_id(String r1) {
            this.publisher_id = r1;
            return this;
        }

        public Builder user_id(Long r1) {
            this.user_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PublisherInfo extends ProtoAdapter<PublisherInfo> {
        private final ProtoAdapter<Map<String, String>> extra_info;

        public ProtoAdapter_PublisherInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PublisherInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.extra_info = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public PublisherInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.publisher_id((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.user_id((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.distribution_scene((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.feed_time_ms((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L16;
            r0.client_visible_room_id((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L16:
            if (r3 != 100) goto L17;
            r0.extra_info.putAll((Map) this.extra_info.decode(r7));
            goto L3
        L17:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L24:
            r7.endMessage(r1);
            return r0.m1723build();
        }

        public int encodedSize(PublisherInfo r6) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r6.publisher_id);
            ProtoAdapter r1 = ProtoAdapter.INT64;
            return (((((r0 + r1.encodedSizeWithTag(2, r6.user_id)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r6.distribution_scene)) + r1.encodedSizeWithTag(4, r6.feed_time_ms)) + r1.encodedSizeWithTag(5, r6.client_visible_room_id)) + this.extra_info.encodedSizeWithTag(100, r6.extra_info)) + r6.unknownFields().size();
        }

        public PublisherInfo redact(PublisherInfo r1) {
            Builder r2 = r1.m1722newBuilder();
            r2.clearUnknownFields();
            return r2.m1723build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1724decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PublisherInfo) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((PublisherInfo) r1);
        }

        public void encode(ProtoWriter r5, PublisherInfo r6) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r6.publisher_id);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 2, r6.user_id);
            ProtoAdapter.INT32.encodeWithTag(r5, 3, r6.distribution_scene);
            r0.encodeWithTag(r5, 4, r6.feed_time_ms);
            r0.encodeWithTag(r5, 5, r6.client_visible_room_id);
            this.extra_info.encodeWithTag(r5, 100, r6.extra_info);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PublisherInfo) r2);
        }
    }

    static {
        ProtoAdapter_PublisherInfo r0 = new ProtoAdapter_PublisherInfo();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_USER_ID = 0L;
        DEFAULT_DISTRIBUTION_SCENE = 0;
        DEFAULT_FEED_TIME_MS = 0L;
        DEFAULT_CLIENT_VISIBLE_ROOM_ID = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.publisher_id;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.user_id;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.distribution_scene;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.feed_time_ms;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.client_visible_room_id;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = ((r14 + r3) * 37) + this.extra_info.hashCode();
        ((Message) this).hashCode = r16;
        return r16;
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L25:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1722newBuilder() {
        Builder r0 = new Builder();
        r0.publisher_id = this.publisher_id;
        r0.user_id = this.user_id;
        r0.distribution_scene = this.distribution_scene;
        r0.feed_time_ms = this.feed_time_ms;
        r0.client_visible_room_id = this.client_visible_room_id;
        r0.extra_info = Internal.copyOf("extra_info", this.extra_info);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.publisher_id == null) goto L6;
        r0.append(", publisher_id=");
        r0.append(this.publisher_id);
    L6:
        if (this.user_id == null) goto L9;
        r0.append(", user_id=");
        r0.append(this.user_id);
    L9:
        if (this.distribution_scene == null) goto L12;
        r0.append(", distribution_scene=");
        r0.append(this.distribution_scene);
    L12:
        if (this.feed_time_ms == null) goto L15;
        r0.append(", feed_time_ms=");
        r0.append(this.feed_time_ms);
    L15:
        if (this.client_visible_room_id == null) goto L17;
        r0.append(", client_visible_room_id=");
        r0.append(this.client_visible_room_id);
    L17:
        Map<String, String> r1 = this.extra_info;
        if (r1 != null) goto L20;
    L22:
        StringBuilder r2 = r0.replace(0, 2, "PublisherInfo{");
        r2.append('}');
        return r2.toString();
    L20:
        if (r1.isEmpty() == true) goto L22;
        r0.append(", extra_info=");
        r0.append(this.extra_info);
        goto L22
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1722newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PublisherInfo) == true) goto L8;
        return false;
    L8:
        PublisherInfo r6 = (PublisherInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (Internal.equals(this.publisher_id, r6.publisher_id) == false) goto L23;
        if (Internal.equals(this.user_id, r6.user_id) == false) goto L23;
        if (Internal.equals(this.distribution_scene, r6.distribution_scene) == false) goto L23;
        if (Internal.equals(this.feed_time_ms, r6.feed_time_ms) == false) goto L23;
        if (Internal.equals(this.client_visible_room_id, r6.client_visible_room_id) == false) goto L23;
        if (this.extra_info.equals(r6.extra_info) == false) goto L23;
        return true;
    }

    public PublisherInfo(String r9, Long r10, Integer r11, Long r12, Long r13, Map<String, String> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public PublisherInfo(String r2, Long r3, Integer r4, Long r5, Long r6, Map<String, String> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.publisher_id = r2;
        this.user_id = r3;
        this.distribution_scene = r4;
        this.feed_time_ms = r5;
        this.client_visible_room_id = r6;
        this.extra_info = Internal.immutableCopyOf("extra_info", r7);
    }
}
