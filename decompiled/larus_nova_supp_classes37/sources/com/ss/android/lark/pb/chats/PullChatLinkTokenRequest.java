package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ChatShareTargetScene;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullChatLinkTokenRequest extends Message<PullChatLinkTokenRequest, Builder> {
    public static final ProtoAdapter<PullChatLinkTokenRequest> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_EXPIRED_DAY = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mapp_name;
    public final String mchat_id;
    public final Integer mexpired_day;
    public final Boolean mis_unlimited;
    public final ChatShareTargetScene mtarget_scene;

    public static final class Builder extends Message.Builder<PullChatLinkTokenRequest, Builder> {
        public String mapp_name;
        public String mchat_id;
        public Integer mexpired_day;
        public Boolean mis_unlimited;
        public ChatShareTargetScene mtarget_scene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullChatLinkTokenRequest m893build() {
            String r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new PullChatLinkTokenRequest(this.mchat_id, this.mexpired_day, this.mapp_name, this.mis_unlimited, this.mtarget_scene, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m893build();
        }

        public Builder app_name(String r1) {
            this.mapp_name = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder expired_day(Integer r1) {
            this.mexpired_day = r1;
            return this;
        }

        public Builder is_unlimited(Boolean r1) {
            this.mis_unlimited = r1;
            return this;
        }

        public Builder target_scene(ChatShareTargetScene r1) {
            this.mtarget_scene = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChatLinkTokenRequest extends ProtoAdapter<PullChatLinkTokenRequest> {
        public ProtoAdapter_PullChatLinkTokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatLinkTokenRequest.class);
        }

        public PullChatLinkTokenRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            r0.mexpired_day = 7;
            r0.mapp_name = "";
            r0.mis_unlimited = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mexpired_day = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mapp_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mis_unlimited = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mtarget_scene = (ChatShareTargetScene) ChatShareTargetScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m893build();
        }

        public int encodedSize(PullChatLinkTokenRequest r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mchat_id);
            Integer r2 = r7.mexpired_day;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mapp_name;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r7.mis_unlimited;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            ChatShareTargetScene r13 = r7.mtarget_scene;
            if (r13 == null) goto L18;
            r3 = ChatShareTargetScene.ADAPTER.encodedSizeWithTag(5, r13);
        L18:
            return (r12 + r3) + r7.unknownFields().size();
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m894decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullChatLinkTokenRequest) r1);
        }

        public void encode(ProtoWriter r5, PullChatLinkTokenRequest r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mchat_id);
            Integer r1 = r6.mexpired_day;
            if (r1 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mapp_name;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            Boolean r3 = r6.mis_unlimited;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
        L11:
            ChatShareTargetScene r4 = r6.mtarget_scene;
            if (r4 == null) goto L14;
            ChatShareTargetScene.ADAPTER.encodeWithTag(r5, 5, r4);
        L14:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullChatLinkTokenRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatLinkTokenRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_EXPIRED_DAY = 7;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m892newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mexpired_day = this.mexpired_day;
        r0.mapp_name = this.mapp_name;
        r0.mis_unlimited = this.mis_unlimited;
        r0.mtarget_scene = this.mtarget_scene;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullChatLinkTokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m892newBuilder();
    }

    public PullChatLinkTokenRequest(String r8, Integer r9, String r10, Boolean r11, ChatShareTargetScene r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public PullChatLinkTokenRequest(String r2, Integer r3, String r4, Boolean r5, ChatShareTargetScene r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mchat_id = r2;
        this.mexpired_day = r3;
        this.mapp_name = r4;
        this.mis_unlimited = r5;
        this.mtarget_scene = r6;
    }
}
