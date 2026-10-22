package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Department;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullDepartmentStructureResponse extends Message<PullDepartmentStructureResponse, Builder> {
    public static final ProtoAdapter<PullDepartmentStructureResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_DEPARTMENT_COUNT = null;
    public static final Boolean DEFAULT_SHOW_DEPARTMENT_PRIMARY_MEMBER_COUNT = null;
    private static final long serialVersionUID = 0;
    public final List<String> mchatters_in_chat_id;
    public final List<Department> mdepartment_path;
    public final DepartmentStructure mdepartment_structure;
    public final List<ContactDisplayModule> mdisplay_order;
    public final ExtendFields mextend_fields;
    public final Boolean mshow_department_count;
    public final Boolean mshow_department_primary_member_count;

    public static final class Builder extends Message.Builder<PullDepartmentStructureResponse, Builder> {
        public List<String> mchatters_in_chat_id;
        public List<Department> mdepartment_path;
        public DepartmentStructure mdepartment_structure;
        public List<ContactDisplayModule> mdisplay_order;
        public ExtendFields mextend_fields;
        public Boolean mshow_department_count;
        public Boolean mshow_department_primary_member_count;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullDepartmentStructureResponse m980build() {
            return new PullDepartmentStructureResponse(this.mdepartment_structure, this.mchatters_in_chat_id, this.mextend_fields, this.mshow_department_count, this.mdepartment_path, this.mdisplay_order, this.mshow_department_primary_member_count, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatters_in_chat_id = Internal.newMutableList();
            this.mdepartment_path = Internal.newMutableList();
            this.mdisplay_order = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m980build();
        }

        public Builder chatters_in_chat_id(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatters_in_chat_id = r1;
            return this;
        }

        public Builder department_path(List<Department> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdepartment_path = r1;
            return this;
        }

        public Builder department_structure(DepartmentStructure r1) {
            this.mdepartment_structure = r1;
            return this;
        }

        public Builder display_order(List<ContactDisplayModule> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdisplay_order = r1;
            return this;
        }

        public Builder extend_fields(ExtendFields r1) {
            this.mextend_fields = r1;
            return this;
        }

        public Builder show_department_count(Boolean r1) {
            this.mshow_department_count = r1;
            return this;
        }

        public Builder show_department_primary_member_count(Boolean r1) {
            this.mshow_department_primary_member_count = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDepartmentStructureResponse extends ProtoAdapter<PullDepartmentStructureResponse> {
        public ProtoAdapter_PullDepartmentStructureResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDepartmentStructureResponse.class);
        }

        public PullDepartmentStructureResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mshow_department_count = r1;
            r0.mshow_department_primary_member_count = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L19;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.mdisplay_order.add((ContactDisplayModule) ContactDisplayModule.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mshow_department_primary_member_count = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.mdepartment_path.add((Department) Department.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.mshow_department_count = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            r0.mextend_fields = (ExtendFields) ExtendFields.ADAPTER.decode(r9);
            goto L3
        L15:
            r0.mchatters_in_chat_id.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L16:
            r0.mdepartment_structure = (DepartmentStructure) DepartmentStructure.ADAPTER.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r2);
            return r0.m980build();
        }

        public int encodedSize(PullDepartmentStructureResponse r6) {
            DepartmentStructure r0 = r6.mdepartment_structure;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = DepartmentStructure.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r6.mchatters_in_chat_id);
            ExtendFields r4 = r6.mextend_fields;
            if (r4 == null) goto L9;
            int r5 = ExtendFields.ADAPTER.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            Boolean r8 = r6.mshow_department_count;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r8);
        L14:
            int r10 = ((r7 + r9) + Department.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mdepartment_path)) + ContactDisplayModule.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.mdisplay_order);
            Boolean r11 = r6.mshow_department_primary_member_count;
            if (r11 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r11);
        L18:
            return (r10 + r1) + r6.unknownFields().size();
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m981decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullDepartmentStructureResponse) r1);
        }

        public void encode(ProtoWriter r4, PullDepartmentStructureResponse r5) throws IOException {
            DepartmentStructure r0 = r5.mdepartment_structure;
            if (r0 == null) goto L5;
            DepartmentStructure.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 2, r5.mchatters_in_chat_id);
            ExtendFields r1 = r5.mextend_fields;
            if (r1 == null) goto L8;
            ExtendFields.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            Boolean r2 = r5.mshow_department_count;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
        L11:
            Department.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mdepartment_path);
            ContactDisplayModule.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.mdisplay_order);
            Boolean r3 = r5.mshow_department_primary_member_count;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullDepartmentStructureResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDepartmentStructureResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_SHOW_DEPARTMENT_COUNT = r0;
        DEFAULT_SHOW_DEPARTMENT_PRIMARY_MEMBER_COUNT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m979newBuilder() {
        Builder r0 = new Builder();
        r0.mdepartment_structure = this.mdepartment_structure;
        r0.mchatters_in_chat_id = Internal.copyOf("mchatters_in_chat_id", this.mchatters_in_chat_id);
        r0.mextend_fields = this.mextend_fields;
        r0.mshow_department_count = this.mshow_department_count;
        r0.mdepartment_path = Internal.copyOf("mdepartment_path", this.mdepartment_path);
        r0.mdisplay_order = Internal.copyOf("mdisplay_order", this.mdisplay_order);
        r0.mshow_department_primary_member_count = this.mshow_department_primary_member_count;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullDepartmentStructureResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m979newBuilder();
    }

    public PullDepartmentStructureResponse(DepartmentStructure r10, List<String> r11, ExtendFields r12, Boolean r13, List<Department> r14, List<ContactDisplayModule> r15, Boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public PullDepartmentStructureResponse(DepartmentStructure r2, List<String> r3, ExtendFields r4, Boolean r5, List<Department> r6, List<ContactDisplayModule> r7, Boolean r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mdepartment_structure = r2;
        this.mchatters_in_chat_id = Internal.immutableCopyOf("mchatters_in_chat_id", r3);
        this.mextend_fields = r4;
        this.mshow_department_count = r5;
        this.mdepartment_path = Internal.immutableCopyOf("mdepartment_path", r6);
        this.mdisplay_order = Internal.immutableCopyOf("mdisplay_order", r7);
        this.mshow_department_primary_member_count = r8;
    }
}
