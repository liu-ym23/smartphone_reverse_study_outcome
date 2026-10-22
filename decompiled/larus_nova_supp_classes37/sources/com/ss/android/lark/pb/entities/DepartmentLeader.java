package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DepartmentLeader extends com.squareup.wire.Message<DepartmentLeader, Builder> {
    public static final ProtoAdapter<DepartmentLeader> ADAPTER = null;
    public static final Long DEFAULT_LEADERID = null;
    private static final long serialVersionUID = 0;
    public final Chatter mleader;
    public final Long mleaderID;
    public final LeaderType mleaderType;

    public static final class Builder extends com.squareup.wire.Message.Builder<DepartmentLeader, Builder> {
        public Chatter mleader;
        public Long mleaderID;
        public LeaderType mleaderType;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DepartmentLeader m1202build() {
            LeaderType r0 = this.mleaderType;
            if (r0 == null) goto L9;
            if (this.mleaderID == null) goto L9;
            return new DepartmentLeader(this.mleaderType, this.mleaderID, this.mleader, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mleaderType", this.mleaderID, "mleaderID"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1202build();
        }

        public Builder leader(Chatter r1) {
            this.mleader = r1;
            return this;
        }

        public Builder leaderID(Long r1) {
            this.mleaderID = r1;
            return this;
        }

        public Builder leaderType(LeaderType r1) {
            this.mleaderType = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DepartmentLeader extends ProtoAdapter<DepartmentLeader> {
        public ProtoAdapter_DepartmentLeader() {
            super(FieldEncoding.LENGTH_DELIMITED, DepartmentLeader.class);
        }

        public DepartmentLeader decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mleaderID = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mleaderType = (LeaderType) LeaderType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mleaderID = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mleader = (Chatter) Chatter.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1202build();
        }

        public int encodedSize(DepartmentLeader r5) {
            int r0 = LeaderType.ADAPTER.encodedSizeWithTag(1, r5.mleaderType) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.mleaderID);
            Chatter r1 = r5.mleader;
            if (r1 == null) goto L5;
            int r2 = Chatter.ADAPTER.encodedSizeWithTag(3, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1203decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DepartmentLeader) r1);
        }

        public void encode(ProtoWriter r4, DepartmentLeader r5) throws IOException {
            LeaderType.ADAPTER.encodeWithTag(r4, 1, r5.mleaderType);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.mleaderID);
            Chatter r0 = r5.mleader;
            if (r0 == null) goto L5;
            Chatter.ADAPTER.encodeWithTag(r4, 3, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DepartmentLeader) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DepartmentLeader();
        DEFAULT_LEADERID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1201newBuilder() {
        Builder r0 = new Builder();
        r0.mleaderType = this.mleaderType;
        r0.mleaderID = this.mleaderID;
        r0.mleader = this.mleader;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DepartmentLeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1201newBuilder();
    }

    public DepartmentLeader(LeaderType r2, Long r3, Chatter r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DepartmentLeader(LeaderType r2, Long r3, Chatter r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mleaderType = r2;
        this.mleaderID = r3;
        this.mleader = r4;
    }
}
