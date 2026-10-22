package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AICapabilityPermData extends Message<AICapabilityPermData, Builder> {
    public static final ProtoAdapter<AICapabilityPermData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MeetingAICapabilityAction maction;
    public final MeetingAICapability mcapability;
    public final ByteviewUser moperate_user;
    public final ByteviewUser mrequester;

    public static final class Builder extends Message.Builder<AICapabilityPermData, Builder> {
        public MeetingAICapabilityAction maction;
        public MeetingAICapability mcapability;
        public ByteviewUser moperate_user;
        public ByteviewUser mrequester;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AICapabilityPermData m3095build() {
            return new AICapabilityPermData(this.maction, this.mcapability, this.mrequester, this.moperate_user, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3095build();
        }

        public Builder action(MeetingAICapabilityAction r1) {
            this.maction = r1;
            return this;
        }

        public Builder capability(MeetingAICapability r1) {
            this.mcapability = r1;
            return this;
        }

        public Builder operate_user(ByteviewUser r1) {
            this.moperate_user = r1;
            return this;
        }

        public Builder requester(ByteviewUser r1) {
            this.mrequester = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AICapabilityPermData extends ProtoAdapter<AICapabilityPermData> {
        public ProtoAdapter_AICapabilityPermData() {
            super(FieldEncoding.LENGTH_DELIMITED, AICapabilityPermData.class);
        }

        public AICapabilityPermData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.maction = (MeetingAICapabilityAction) MeetingAICapabilityAction.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcapability = (MeetingAICapability) MeetingAICapability.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mrequester = (ByteviewUser) ByteviewUser.ADAPTER.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.moperate_user = (ByteviewUser) ByteviewUser.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m3095build();
        }

        public int encodedSize(AICapabilityPermData r6) {
            MeetingAICapabilityAction r0 = r6.maction;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = MeetingAICapabilityAction.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            MeetingAICapability r3 = r6.mcapability;
            if (r3 == null) goto L9;
            int r4 = MeetingAICapability.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ByteviewUser r7 = r6.mrequester;
            if (r7 == null) goto L13;
            int r8 = ByteviewUser.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ByteviewUser r10 = r6.moperate_user;
            if (r10 == null) goto L18;
            r1 = ByteviewUser.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m3096decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AICapabilityPermData) r1);
        }

        public void encode(ProtoWriter r4, AICapabilityPermData r5) throws IOException {
            MeetingAICapabilityAction r0 = r5.maction;
            if (r0 == null) goto L5;
            MeetingAICapabilityAction.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            MeetingAICapability r1 = r5.mcapability;
            if (r1 == null) goto L8;
            MeetingAICapability.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            ByteviewUser r2 = r5.mrequester;
            if (r2 == null) goto L11;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            ByteviewUser r3 = r5.moperate_user;
            if (r3 == null) goto L14;
            ByteviewUser.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AICapabilityPermData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AICapabilityPermData();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3094newBuilder() {
        Builder r0 = new Builder();
        r0.maction = this.maction;
        r0.mcapability = this.mcapability;
        r0.mrequester = this.mrequester;
        r0.moperate_user = this.moperate_user;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AICapabilityPermData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3094newBuilder();
    }

    public AICapabilityPermData(MeetingAICapabilityAction r7, MeetingAICapability r8, ByteviewUser r9, ByteviewUser r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public AICapabilityPermData(MeetingAICapabilityAction r2, MeetingAICapability r3, ByteviewUser r4, ByteviewUser r5, ByteString r6) {
        super(ADAPTER, r6);
        this.maction = r2;
        this.mcapability = r3;
        this.mrequester = r4;
        this.moperate_user = r5;
    }
}
