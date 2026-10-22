package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserConfig extends com.squareup.wire.Message<UserConfig, Builder> {
    public static final ProtoAdapter<UserConfig> ADAPTER = null;
    public static final Boolean DEFAULT_PHONE_CALL_ACCESSIBLE = null;
    public static final Boolean DEFAULT_VIDEO_CALL_ACCESSIBLE = null;
    public static final Boolean DEFAULT_VOICE_CALL_ACCESSIBLE = null;
    private static final long serialVersionUID = 0;
    public final AccessibleInfo maccess_phone_call;
    public final AccessibleInfo maccess_urgent;
    public final AccessibleInfo maccess_video_call;
    public final AccessibleInfo maccess_voice_call;
    public final Boolean mphone_call_accessible;
    public final Boolean mvideo_call_accessible;
    public final Boolean mvoice_call_accessible;

    public static final class Builder extends com.squareup.wire.Message.Builder<UserConfig, Builder> {
        public AccessibleInfo maccess_phone_call;
        public AccessibleInfo maccess_urgent;
        public AccessibleInfo maccess_video_call;
        public AccessibleInfo maccess_voice_call;
        public Boolean mphone_call_accessible;
        public Boolean mvideo_call_accessible;
        public Boolean mvoice_call_accessible;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserConfig m1685build() {
            return new UserConfig(this.mphone_call_accessible, this.mvoice_call_accessible, this.mvideo_call_accessible, this.maccess_phone_call, this.maccess_voice_call, this.maccess_video_call, this.maccess_urgent, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1685build();
        }

        public Builder access_phone_call(AccessibleInfo r1) {
            this.maccess_phone_call = r1;
            return this;
        }

        public Builder access_urgent(AccessibleInfo r1) {
            this.maccess_urgent = r1;
            return this;
        }

        public Builder access_video_call(AccessibleInfo r1) {
            this.maccess_video_call = r1;
            return this;
        }

        public Builder access_voice_call(AccessibleInfo r1) {
            this.maccess_voice_call = r1;
            return this;
        }

        public Builder phone_call_accessible(Boolean r1) {
            this.mphone_call_accessible = r1;
            return this;
        }

        public Builder video_call_accessible(Boolean r1) {
            this.mvideo_call_accessible = r1;
            return this;
        }

        public Builder voice_call_accessible(Boolean r1) {
            this.mvoice_call_accessible = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserConfig extends ProtoAdapter<UserConfig> {
        public ProtoAdapter_UserConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, UserConfig.class);
        }

        public UserConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.TRUE;
            r0.mphone_call_accessible = r1;
            r0.mvoice_call_accessible = r1;
            r0.mvideo_call_accessible = r1;
            long r2 = r7.beginMessage();
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
            r0.maccess_urgent = (AccessibleInfo) AccessibleInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            r0.maccess_video_call = (AccessibleInfo) AccessibleInfo.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.maccess_voice_call = (AccessibleInfo) AccessibleInfo.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.maccess_phone_call = (AccessibleInfo) AccessibleInfo.ADAPTER.decode(r7);
            goto L3
        L11:
            r0.mvideo_call_accessible = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            r0.mvoice_call_accessible = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            r0.mphone_call_accessible = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r2);
            return r0.m1685build();
        }

        public int encodedSize(UserConfig r6) {
            Boolean r0 = r6.mphone_call_accessible;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mvoice_call_accessible;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mvideo_call_accessible;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            AccessibleInfo r10 = r6.maccess_phone_call;
            if (r10 == null) goto L17;
            int r11 = AccessibleInfo.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            AccessibleInfo r13 = r6.maccess_voice_call;
            if (r13 == null) goto L21;
            int r14 = AccessibleInfo.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            AccessibleInfo r16 = r6.maccess_video_call;
            if (r16 == null) goto L25;
            int r17 = AccessibleInfo.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            AccessibleInfo r19 = r6.maccess_urgent;
            if (r19 == null) goto L30;
            r1 = AccessibleInfo.ADAPTER.encodedSizeWithTag(7, r19);
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
        public /* bridge */ /* synthetic */ Object m1686decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserConfig) r1);
        }

        public void encode(ProtoWriter r4, UserConfig r5) throws IOException {
            Boolean r0 = r5.mphone_call_accessible;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mvoice_call_accessible;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mvideo_call_accessible;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            AccessibleInfo r3 = r5.maccess_phone_call;
            if (r3 == null) goto L14;
            AccessibleInfo.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            AccessibleInfo r6 = r5.maccess_voice_call;
            if (r6 == null) goto L17;
            AccessibleInfo.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            AccessibleInfo r7 = r5.maccess_video_call;
            if (r7 == null) goto L20;
            AccessibleInfo.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            AccessibleInfo r8 = r5.maccess_urgent;
            if (r8 == null) goto L23;
            AccessibleInfo.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserConfig();
        Boolean r0 = Boolean.TRUE;
        DEFAULT_PHONE_CALL_ACCESSIBLE = r0;
        DEFAULT_VOICE_CALL_ACCESSIBLE = r0;
        DEFAULT_VIDEO_CALL_ACCESSIBLE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1684newBuilder() {
        Builder r0 = new Builder();
        r0.mphone_call_accessible = this.mphone_call_accessible;
        r0.mvoice_call_accessible = this.mvoice_call_accessible;
        r0.mvideo_call_accessible = this.mvideo_call_accessible;
        r0.maccess_phone_call = this.maccess_phone_call;
        r0.maccess_voice_call = this.maccess_voice_call;
        r0.maccess_video_call = this.maccess_video_call;
        r0.maccess_urgent = this.maccess_urgent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1684newBuilder();
    }

    public UserConfig(Boolean r10, Boolean r11, Boolean r12, AccessibleInfo r13, AccessibleInfo r14, AccessibleInfo r15, AccessibleInfo r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public UserConfig(Boolean r2, Boolean r3, Boolean r4, AccessibleInfo r5, AccessibleInfo r6, AccessibleInfo r7, AccessibleInfo r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mphone_call_accessible = r2;
        this.mvoice_call_accessible = r3;
        this.mvideo_call_accessible = r4;
        this.maccess_phone_call = r5;
        this.maccess_voice_call = r6;
        this.maccess_video_call = r7;
        this.maccess_urgent = r8;
    }
}
