package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullUserAgreementRequest extends Message<PullUserAgreementRequest, Builder> {
    public static final ProtoAdapter<PullUserAgreementRequest> ADAPTER = null;
    public static final String DEFAULT_TARGET_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String mtarget_user_id;
    public final UserAgreementType muser_agreement_type;

    public static final class Builder extends Message.Builder<PullUserAgreementRequest, Builder> {
        public String mtarget_user_id;
        public UserAgreementType muser_agreement_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUserAgreementRequest m920build() {
            return new PullUserAgreementRequest(this.mtarget_user_id, this.muser_agreement_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m920build();
        }

        public Builder target_user_id(String r1) {
            this.mtarget_user_id = r1;
            return this;
        }

        public Builder user_agreement_type(UserAgreementType r1) {
            this.muser_agreement_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserAgreementRequest extends ProtoAdapter<PullUserAgreementRequest> {
        public ProtoAdapter_PullUserAgreementRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserAgreementRequest.class);
        }

        public PullUserAgreementRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtarget_user_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtarget_user_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.muser_agreement_type = (UserAgreementType) UserAgreementType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m920build();
        }

        public int encodedSize(PullUserAgreementRequest r5) {
            String r0 = r5.mtarget_user_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            UserAgreementType r3 = r5.muser_agreement_type;
            if (r3 == null) goto L10;
            r1 = UserAgreementType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m921decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUserAgreementRequest) r1);
        }

        public void encode(ProtoWriter r4, PullUserAgreementRequest r5) throws IOException {
            String r0 = r5.mtarget_user_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            UserAgreementType r1 = r5.muser_agreement_type;
            if (r1 == null) goto L8;
            UserAgreementType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUserAgreementRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserAgreementRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m919newBuilder() {
        Builder r0 = new Builder();
        r0.mtarget_user_id = this.mtarget_user_id;
        r0.muser_agreement_type = this.muser_agreement_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUserAgreementRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m919newBuilder();
    }

    public PullUserAgreementRequest(String r2, UserAgreementType r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PullUserAgreementRequest(String r2, UserAgreementType r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtarget_user_id = r2;
        this.muser_agreement_type = r3;
    }
}
