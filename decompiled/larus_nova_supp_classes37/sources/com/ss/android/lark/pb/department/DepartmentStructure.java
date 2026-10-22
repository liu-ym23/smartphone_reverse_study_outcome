package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chatter;
import com.ss.android.lark.pb.entities.Department;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DepartmentStructure extends Message<DepartmentStructure, Builder> {
    public static final ProtoAdapter<DepartmentStructure> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Boolean DEFAULT_HAS_MORE_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_USER_EXCEED_LIMIT = null;
    private static final long serialVersionUID = 0;
    public final List<String> madministrator;
    public final ChatInfo mchat_info;
    public final Department mdepartment;
    public final Boolean mhas_more;
    public final Boolean mhas_more_department;
    public final Boolean mis_user_exceed_limit;
    public final Chatter mleader;
    public final List<Department> msub_departments;
    public final List<String> msuper_administrator;
    public final List<Chatter> musers;

    public static final class Builder extends Message.Builder<DepartmentStructure, Builder> {
        public List<String> madministrator;
        public ChatInfo mchat_info;
        public Department mdepartment;
        public Boolean mhas_more;
        public Boolean mhas_more_department;
        public Boolean mis_user_exceed_limit;
        public Chatter mleader;
        public List<Department> msub_departments;
        public List<String> msuper_administrator;
        public List<Chatter> musers;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DepartmentStructure m965build() {
            return new DepartmentStructure(this.mleader, this.mdepartment, this.musers, this.mhas_more, this.msub_departments, this.mchat_info, this.madministrator, this.msuper_administrator, this.mhas_more_department, this.mis_user_exceed_limit, super.buildUnknownFields());
        }

        public Builder() {
            this.musers = Internal.newMutableList();
            this.msub_departments = Internal.newMutableList();
            this.madministrator = Internal.newMutableList();
            this.msuper_administrator = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m965build();
        }

        public Builder administrator(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.madministrator = r1;
            return this;
        }

        public Builder chat_info(ChatInfo r1) {
            this.mchat_info = r1;
            return this;
        }

        public Builder department(Department r1) {
            this.mdepartment = r1;
            return this;
        }

        public Builder has_more(Boolean r1) {
            this.mhas_more = r1;
            return this;
        }

        public Builder has_more_department(Boolean r1) {
            this.mhas_more_department = r1;
            return this;
        }

        public Builder is_user_exceed_limit(Boolean r1) {
            this.mis_user_exceed_limit = r1;
            return this;
        }

        public Builder leader(Chatter r1) {
            this.mleader = r1;
            return this;
        }

        public Builder sub_departments(List<Department> r1) {
            Internal.checkElementsNotNull(r1);
            this.msub_departments = r1;
            return this;
        }

        public Builder super_administrator(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.msuper_administrator = r1;
            return this;
        }

        public Builder users(List<Chatter> r1) {
            Internal.checkElementsNotNull(r1);
            this.musers = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DepartmentStructure extends ProtoAdapter<DepartmentStructure> {
        public ProtoAdapter_DepartmentStructure() {
            super(FieldEncoding.LENGTH_DELIMITED, DepartmentStructure.class);
        }

        public DepartmentStructure decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mhas_more = r1;
            r0.mhas_more_department = r1;
            r0.mis_user_exceed_limit = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
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
        L7:
            r0.mis_user_exceed_limit = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mhas_more_department = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            r0.msuper_administrator.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.madministrator.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.mchat_info = (ChatInfo) ChatInfo.ADAPTER.decode(r7);
            goto L3
        L12:
            r0.msub_departments.add((Department) Department.ADAPTER.decode(r7));
            goto L3
        L13:
            r0.mhas_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L14:
            r0.musers.add((Chatter) Chatter.ADAPTER.decode(r7));
            goto L3
        L15:
            r0.mdepartment = (Department) Department.ADAPTER.decode(r7);
            goto L3
        L16:
            r0.mleader = (Chatter) Chatter.ADAPTER.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r2);
            return r0.m965build();
        }

        public int encodedSize(DepartmentStructure r7) {
            Chatter r0 = r7.mleader;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Chatter.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Department r3 = r7.mdepartment;
            if (r3 == null) goto L9;
            int r4 = Department.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = (r2 + r4) + Chatter.ADAPTER.asRepeated().encodedSizeWithTag(3, r7.musers);
            Boolean r6 = r7.mhas_more;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r6);
        L14:
            int r9 = (r5 + r8) + Department.ADAPTER.asRepeated().encodedSizeWithTag(5, r7.msub_departments);
            ChatInfo r10 = r7.mchat_info;
            if (r10 == null) goto L17;
            int r11 = ChatInfo.ADAPTER.encodedSizeWithTag(6, r10);
        L18:
            int r12 = r9 + r11;
            ProtoAdapter r13 = ProtoAdapter.STRING;
            int r14 = (r12 + r13.asRepeated().encodedSizeWithTag(7, r7.madministrator)) + r13.asRepeated().encodedSizeWithTag(8, r7.msuper_administrator);
            Boolean r15 = r7.mhas_more_department;
            if (r15 == null) goto L21;
            int r16 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r15);
        L22:
            int r17 = r14 + r16;
            Boolean r18 = r7.mis_user_exceed_limit;
            if (r18 == null) goto L26;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r18);
        L26:
            return (r17 + r1) + r7.unknownFields().size();
        L21:
            r16 = 0;
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
        public /* bridge */ /* synthetic */ Object m966decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DepartmentStructure) r1);
        }

        public void encode(ProtoWriter r5, DepartmentStructure r6) throws IOException {
            Chatter r0 = r6.mleader;
            if (r0 == null) goto L5;
            Chatter.ADAPTER.encodeWithTag(r5, 1, r0);
        L5:
            Department r1 = r6.mdepartment;
            if (r1 == null) goto L8;
            Department.ADAPTER.encodeWithTag(r5, 2, r1);
        L8:
            Chatter.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.musers);
            Boolean r2 = r6.mhas_more;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r2);
        L11:
            Department.ADAPTER.asRepeated().encodeWithTag(r5, 5, r6.msub_departments);
            ChatInfo r3 = r6.mchat_info;
            if (r3 == null) goto L14;
            ChatInfo.ADAPTER.encodeWithTag(r5, 6, r3);
        L14:
            ProtoAdapter r4 = ProtoAdapter.STRING;
            r4.asRepeated().encodeWithTag(r5, 7, r6.madministrator);
            r4.asRepeated().encodeWithTag(r5, 8, r6.msuper_administrator);
            Boolean r7 = r6.mhas_more_department;
            if (r7 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r7);
        L17:
            Boolean r8 = r6.mis_user_exceed_limit;
            if (r8 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r5, 10, r8);
        L20:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DepartmentStructure) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DepartmentStructure();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_HAS_MORE = r0;
        DEFAULT_HAS_MORE_DEPARTMENT = r0;
        DEFAULT_IS_USER_EXCEED_LIMIT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m964newBuilder() {
        Builder r0 = new Builder();
        r0.mleader = this.mleader;
        r0.mdepartment = this.mdepartment;
        r0.musers = Internal.copyOf("musers", this.musers);
        r0.mhas_more = this.mhas_more;
        r0.msub_departments = Internal.copyOf("msub_departments", this.msub_departments);
        r0.mchat_info = this.mchat_info;
        r0.madministrator = Internal.copyOf("madministrator", this.madministrator);
        r0.msuper_administrator = Internal.copyOf("msuper_administrator", this.msuper_administrator);
        r0.mhas_more_department = this.mhas_more_department;
        r0.mis_user_exceed_limit = this.mis_user_exceed_limit;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DepartmentStructure.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m964newBuilder();
    }

    public DepartmentStructure(Chatter r13, Department r14, List<Chatter> r15, Boolean r16, List<Department> r17, ChatInfo r18, List<String> r19, List<String> r20, Boolean r21, Boolean r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public DepartmentStructure(Chatter r2, Department r3, List<Chatter> r4, Boolean r5, List<Department> r6, ChatInfo r7, List<String> r8, List<String> r9, Boolean r10, Boolean r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mleader = r2;
        this.mdepartment = r3;
        this.musers = Internal.immutableCopyOf("musers", r4);
        this.mhas_more = r5;
        this.msub_departments = Internal.immutableCopyOf("msub_departments", r6);
        this.mchat_info = r7;
        this.madministrator = Internal.immutableCopyOf("madministrator", r8);
        this.msuper_administrator = Internal.immutableCopyOf("msuper_administrator", r9);
        this.mhas_more_department = r10;
        this.mis_user_exceed_limit = r11;
    }
}
