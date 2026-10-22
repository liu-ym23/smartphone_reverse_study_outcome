package com.ss.android.lark.pb.videochat;

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
public final class MeetingAIQuickActions extends Message<MeetingAIQuickActions, Builder> {
    public static final ProtoAdapter<MeetingAIQuickActions> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MyAIQuickActionConfig> mmy_ai_quick_action_configs;

    public static final class Builder extends Message.Builder<MeetingAIQuickActions, Builder> {
        public List<MyAIQuickActionConfig> mmy_ai_quick_action_configs;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingAIQuickActions m3158build() {
            return new MeetingAIQuickActions(this.mmy_ai_quick_action_configs, super.buildUnknownFields());
        }

        public Builder() {
            this.mmy_ai_quick_action_configs = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3158build();
        }

        public Builder my_ai_quick_action_configs(List<MyAIQuickActionConfig> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmy_ai_quick_action_configs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAIQuickActions extends ProtoAdapter<MeetingAIQuickActions> {
        public ProtoAdapter_MeetingAIQuickActions() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAIQuickActions.class);
        }

        public MeetingAIQuickActions decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmy_ai_quick_action_configs.add((MyAIQuickActionConfig) MyAIQuickActionConfig.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3158build();
        }

        public int encodedSize(MeetingAIQuickActions r4) {
            return MyAIQuickActionConfig.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mmy_ai_quick_action_configs) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3159decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingAIQuickActions) r1);
        }

        public void encode(ProtoWriter r4, MeetingAIQuickActions r5) throws IOException {
            MyAIQuickActionConfig.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mmy_ai_quick_action_configs);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingAIQuickActions) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAIQuickActions();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3157newBuilder() {
        Builder r0 = new Builder();
        r0.mmy_ai_quick_action_configs = Internal.copyOf("mmy_ai_quick_action_configs", this.mmy_ai_quick_action_configs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingAIQuickActions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3157newBuilder();
    }

    public MeetingAIQuickActions(List<MyAIQuickActionConfig> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MeetingAIQuickActions(List<MyAIQuickActionConfig> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmy_ai_quick_action_configs = Internal.immutableCopyOf("mmy_ai_quick_action_configs", r2);
    }
}
