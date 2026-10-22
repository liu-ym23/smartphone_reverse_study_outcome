package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chat;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatInfo extends Message<ChatInfo, Builder> {
    public static final ProtoAdapter<ChatInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_MEMBER = null;
    private static final long serialVersionUID = 0;
    public final Chat mchat;
    public final Boolean mis_member;
    public final UserPermission muser_perm;

    public static final class Builder extends Message.Builder<ChatInfo, Builder> {
        public Chat mchat;
        public Boolean mis_member;
        public UserPermission muser_perm;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatInfo m962build() {
            UserPermission r0 = this.muser_perm;
            if (r0 == null) goto L7;
            return new ChatInfo(this.muser_perm, this.mchat, this.mis_member, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "muser_perm"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m962build();
        }

        public Builder chat(Chat r1) {
            this.mchat = r1;
            return this;
        }

        public Builder is_member(Boolean r1) {
            this.mis_member = r1;
            return this;
        }

        public Builder user_perm(UserPermission r1) {
            this.muser_perm = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatInfo extends ProtoAdapter<ChatInfo> {
        public ProtoAdapter_ChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatInfo.class);
        }

        public ChatInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_member = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.muser_perm = (UserPermission) UserPermission.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat = (Chat) Chat.ADAPTER.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mis_member = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m962build();
        }

        public int encodedSize(ChatInfo r6) {
            int r0 = UserPermission.ADAPTER.encodedSizeWithTag(1, r6.muser_perm);
            Chat r1 = r6.mchat;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = Chat.ADAPTER.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Boolean r5 = r6.mis_member;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m963decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatInfo) r1);
        }

        public void encode(ProtoWriter r4, ChatInfo r5) throws IOException {
            UserPermission.ADAPTER.encodeWithTag(r4, 1, r5.muser_perm);
            Chat r0 = r5.mchat;
            if (r0 == null) goto L5;
            Chat.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            Boolean r1 = r5.mis_member;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatInfo) r2);
        }
    }

    public static final enum UserPermission extends Enum<UserPermission> implements WireEnum {
        private static final /* synthetic */ UserPermission[] $VALUES = null;
        public static final ProtoAdapter<UserPermission> ADAPTER = null;
        public static final UserPermission INVISIBLE = null;
        public static final UserPermission UNKNOWN = null;
        public static final UserPermission VISIBLE_AND_CREATE = null;
        public static final UserPermission VISIBLE_NOT_CREATE = null;
        private final int value;

        static {
            UserPermission r0 = new UserPermission("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            UserPermission r1 = new UserPermission("VISIBLE_AND_CREATE", 1, 1);
            VISIBLE_AND_CREATE = r1;
            UserPermission r3 = new UserPermission("VISIBLE_NOT_CREATE", 2, 2);
            VISIBLE_NOT_CREATE = r3;
            UserPermission r5 = new UserPermission("INVISIBLE", 3, 3);
            INVISIBLE = r5;
            $VALUES = new UserPermission[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(UserPermission.class);
        }

        public static UserPermission[] values() {
            return (UserPermission[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UserPermission fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return INVISIBLE;
        L14:
            return VISIBLE_NOT_CREATE;
        L16:
            return VISIBLE_AND_CREATE;
        L18:
            return UNKNOWN;
        }

        public static UserPermission valueOf(String r1) {
            return (UserPermission) a.a(UserPermission.class, r1);
        }

        private UserPermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatInfo();
        DEFAULT_IS_MEMBER = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m961newBuilder() {
        Builder r0 = new Builder();
        r0.muser_perm = this.muser_perm;
        r0.mchat = this.mchat;
        r0.mis_member = this.mis_member;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m961newBuilder();
    }

    public ChatInfo(UserPermission r2, Chat r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ChatInfo(UserPermission r2, Chat r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.muser_perm = r2;
        this.mchat = r3;
        this.mis_member = r4;
    }
}
