package com.ss.android.lark.pb.security_event;

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
public final class Event extends Message<Event, Builder> {
    public static final ProtoAdapter<Event> ADAPTER = null;
    public static final String DEFAULT_BIZUNIQUEID = "";
    public static final String DEFAULT_TENANTID = "";
    public static final String DEFAULT_TIMESTAMP = "";
    private static final long serialVersionUID = 0;
    public final String mBizUniqueID;
    public final Env mEnv;
    public final Extend mExtend;
    public final ModuleType mModule;
    public final List<ObjectEntity> mObjects;
    public final OperationType mOperation;
    public final OperatorEntity mOperator;
    public final List<RecipientEntity> mRecipients;
    public final String mTenantID;
    public final String mTimeStamp;

    public static final class Builder extends Message.Builder<Event, Builder> {
        public String mBizUniqueID;
        public Env mEnv;
        public Extend mExtend;
        public ModuleType mModule;
        public List<ObjectEntity> mObjects;
        public OperationType mOperation;
        public OperatorEntity mOperator;
        public List<RecipientEntity> mRecipients;
        public String mTenantID;
        public String mTimeStamp;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Event m2168build() {
            ModuleType r0 = this.mModule;
            if (r0 == null) goto L13;
            if (this.mOperation == null) goto L13;
            if (this.mTimeStamp == null) goto L13;
            if (this.mOperator == null) goto L13;
            return new Event(this.mModule, this.mOperation, this.mTimeStamp, this.mTenantID, this.mOperator, this.mRecipients, this.mObjects, this.mEnv, this.mExtend, this.mBizUniqueID, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "mModule", this.mOperation, "mOperation", this.mTimeStamp, "mTimeStamp", this.mOperator, "mOperator"});
        }

        public Builder() {
            this.mRecipients = Internal.newMutableList();
            this.mObjects = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2168build();
        }

        public Builder BizUniqueID(String r1) {
            this.mBizUniqueID = r1;
            return this;
        }

        public Builder Env(Env r1) {
            this.mEnv = r1;
            return this;
        }

        public Builder Extend(Extend r1) {
            this.mExtend = r1;
            return this;
        }

        public Builder Module(ModuleType r1) {
            this.mModule = r1;
            return this;
        }

        public Builder Objects(List<ObjectEntity> r1) {
            Internal.checkElementsNotNull(r1);
            this.mObjects = r1;
            return this;
        }

        public Builder Operation(OperationType r1) {
            this.mOperation = r1;
            return this;
        }

        public Builder Operator(OperatorEntity r1) {
            this.mOperator = r1;
            return this;
        }

        public Builder Recipients(List<RecipientEntity> r1) {
            Internal.checkElementsNotNull(r1);
            this.mRecipients = r1;
            return this;
        }

        public Builder TenantID(String r1) {
            this.mTenantID = r1;
            return this;
        }

        public Builder TimeStamp(String r1) {
            this.mTimeStamp = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Event extends ProtoAdapter<Event> {
        public ProtoAdapter_Event() {
            super(FieldEncoding.LENGTH_DELIMITED, Event.class);
        }

        public Event decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mTimeStamp = "";
            r0.mTenantID = "";
            r0.mBizUniqueID = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L23;
            switch(r3) {
                case 1: goto L25;
                case 2: goto L27;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L25:
            r0.mModule = (ModuleType) ModuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r0.mOperation = (OperationType) OperationType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mBizUniqueID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mExtend = (Extend) Extend.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mEnv = (Env) Env.ADAPTER.decode(r9);
            goto L3
        L10:
            r0.mObjects.add((ObjectEntity) ObjectEntity.ADAPTER.decode(r9));
            goto L3
        L11:
            r0.mRecipients.add((RecipientEntity) RecipientEntity.ADAPTER.decode(r9));
            goto L3
        L12:
            r0.mOperator = (OperatorEntity) OperatorEntity.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mTenantID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mTimeStamp = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L23:
            r9.endMessage(r1);
            return r0.m2168build();
        }

        public int encodedSize(Event r7) {
            int r0 = ModuleType.ADAPTER.encodedSizeWithTag(1, r7.mModule) + OperationType.ADAPTER.encodedSizeWithTag(2, r7.mOperation);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            int r2 = r0 + r1.encodedSizeWithTag(3, r7.mTimeStamp);
            String r3 = r7.mTenantID;
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = r1.encodedSizeWithTag(4, r3);
        L6:
            int r6 = (((r2 + r5) + OperatorEntity.ADAPTER.encodedSizeWithTag(5, r7.mOperator)) + RecipientEntity.ADAPTER.asRepeated().encodedSizeWithTag(6, r7.mRecipients)) + ObjectEntity.ADAPTER.asRepeated().encodedSizeWithTag(7, r7.mObjects);
            Env r8 = r7.mEnv;
            if (r8 == null) goto L9;
            int r9 = Env.ADAPTER.encodedSizeWithTag(8, r8);
        L10:
            int r10 = r6 + r9;
            Extend r11 = r7.mExtend;
            if (r11 == null) goto L13;
            int r12 = Extend.ADAPTER.encodedSizeWithTag(9, r11);
        L14:
            int r13 = r10 + r12;
            String r14 = r7.mBizUniqueID;
            if (r14 == null) goto L18;
            r4 = r1.encodedSizeWithTag(10, r14);
        L18:
            return (r13 + r4) + r7.unknownFields().size();
        L13:
            r12 = 0;
            goto L14
        L9:
            r9 = 0;
            goto L10
        L5:
            r5 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2169decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Event) r1);
        }

        public void encode(ProtoWriter r5, Event r6) throws IOException {
            ModuleType.ADAPTER.encodeWithTag(r5, 1, r6.mModule);
            OperationType.ADAPTER.encodeWithTag(r5, 2, r6.mOperation);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 3, r6.mTimeStamp);
            String r1 = r6.mTenantID;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 4, r1);
        L5:
            OperatorEntity.ADAPTER.encodeWithTag(r5, 5, r6.mOperator);
            RecipientEntity.ADAPTER.asRepeated().encodeWithTag(r5, 6, r6.mRecipients);
            ObjectEntity.ADAPTER.asRepeated().encodeWithTag(r5, 7, r6.mObjects);
            Env r2 = r6.mEnv;
            if (r2 == null) goto L8;
            Env.ADAPTER.encodeWithTag(r5, 8, r2);
        L8:
            Extend r3 = r6.mExtend;
            if (r3 == null) goto L11;
            Extend.ADAPTER.encodeWithTag(r5, 9, r3);
        L11:
            String r4 = r6.mBizUniqueID;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 10, r4);
        L14:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Event) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Event();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2167newBuilder() {
        Builder r0 = new Builder();
        r0.mModule = this.mModule;
        r0.mOperation = this.mOperation;
        r0.mTimeStamp = this.mTimeStamp;
        r0.mTenantID = this.mTenantID;
        r0.mOperator = this.mOperator;
        r0.mRecipients = Internal.copyOf("mRecipients", this.mRecipients);
        r0.mObjects = Internal.copyOf("mObjects", this.mObjects);
        r0.mEnv = this.mEnv;
        r0.mExtend = this.mExtend;
        r0.mBizUniqueID = this.mBizUniqueID;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Event.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2167newBuilder();
    }

    public Event(ModuleType r13, OperationType r14, String r15, String r16, OperatorEntity r17, List<RecipientEntity> r18, List<ObjectEntity> r19, Env r20, Extend r21, String r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public Event(ModuleType r2, OperationType r3, String r4, String r5, OperatorEntity r6, List<RecipientEntity> r7, List<ObjectEntity> r8, Env r9, Extend r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mModule = r2;
        this.mOperation = r3;
        this.mTimeStamp = r4;
        this.mTenantID = r5;
        this.mOperator = r6;
        this.mRecipients = Internal.immutableCopyOf("mRecipients", r7);
        this.mObjects = Internal.immutableCopyOf("mObjects", r8);
        this.mEnv = r9;
        this.mExtend = r10;
        this.mBizUniqueID = r11;
    }
}
