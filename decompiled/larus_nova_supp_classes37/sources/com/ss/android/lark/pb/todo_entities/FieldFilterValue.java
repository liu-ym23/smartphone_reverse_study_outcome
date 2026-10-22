package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FieldFilterValue extends Message<FieldFilterValue, Builder> {
    public static final ProtoAdapter<FieldFilterValue> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DatetimeFieldFilterValue mdatetime_value;
    public final MemberFieldFilterValue mmember_value;
    public final NumberFieldFilterValue mnumber_value;
    public final OptionFieldFilterValue moption_value;
    public final TaskCompleteStatusFieldFilterValue mtask_complete_status_value;
    public final TaskSectionFieldFilterValue mtask_section_value;
    public final TaskSourceTypeFieldFilterValue mtask_source_type_value;
    public final TaskSourceFieldFilterValue mtask_source_value;
    public final TextFieldFilterValue mtext_value;

    public static final class Builder extends Message.Builder<FieldFilterValue, Builder> {
        public DatetimeFieldFilterValue mdatetime_value;
        public MemberFieldFilterValue mmember_value;
        public NumberFieldFilterValue mnumber_value;
        public OptionFieldFilterValue moption_value;
        public TaskCompleteStatusFieldFilterValue mtask_complete_status_value;
        public TaskSectionFieldFilterValue mtask_section_value;
        public TaskSourceTypeFieldFilterValue mtask_source_type_value;
        public TaskSourceFieldFilterValue mtask_source_value;
        public TextFieldFilterValue mtext_value;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FieldFilterValue m2285build() {
            return new FieldFilterValue(this.mmember_value, this.mdatetime_value, this.mnumber_value, this.moption_value, this.mtext_value, this.mtask_complete_status_value, this.mtask_source_type_value, this.mtask_source_value, this.mtask_section_value, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2285build();
        }

        public Builder datetime_value(DatetimeFieldFilterValue r1) {
            this.mdatetime_value = r1;
            return this;
        }

        public Builder member_value(MemberFieldFilterValue r1) {
            this.mmember_value = r1;
            return this;
        }

        public Builder number_value(NumberFieldFilterValue r1) {
            this.mnumber_value = r1;
            return this;
        }

        public Builder option_value(OptionFieldFilterValue r1) {
            this.moption_value = r1;
            return this;
        }

        public Builder task_complete_status_value(TaskCompleteStatusFieldFilterValue r1) {
            this.mtask_complete_status_value = r1;
            return this;
        }

        public Builder task_section_value(TaskSectionFieldFilterValue r1) {
            this.mtask_section_value = r1;
            return this;
        }

        public Builder task_source_type_value(TaskSourceTypeFieldFilterValue r1) {
            this.mtask_source_type_value = r1;
            return this;
        }

        public Builder task_source_value(TaskSourceFieldFilterValue r1) {
            this.mtask_source_value = r1;
            return this;
        }

        public Builder text_value(TextFieldFilterValue r1) {
            this.mtext_value = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FieldFilterValue extends ProtoAdapter<FieldFilterValue> {
        public ProtoAdapter_FieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, FieldFilterValue.class);
        }

        public FieldFilterValue decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L26;
            if (r3 != 1) goto L8;
            r0.mmember_value = (MemberFieldFilterValue) MemberFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mdatetime_value = (DatetimeFieldFilterValue) DatetimeFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mnumber_value = (NumberFieldFilterValue) NumberFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.moption_value = (OptionFieldFilterValue) OptionFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mtext_value = (TextFieldFilterValue) TextFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L15:
            switch(r3) {
                case 100: goto L20;
                case 101: goto L19;
                case 102: goto L18;
                case 103: goto L17;
                default: goto L16;
            };
        L17:
            r0.mtask_section_value = (TaskSectionFieldFilterValue) TaskSectionFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L18:
            r0.mtask_source_value = (TaskSourceFieldFilterValue) TaskSourceFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L19:
            r0.mtask_source_type_value = (TaskSourceTypeFieldFilterValue) TaskSourceTypeFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L20:
            r0.mtask_complete_status_value = (TaskCompleteStatusFieldFilterValue) TaskCompleteStatusFieldFilterValue.ADAPTER.decode(r7);
            goto L3
        L16:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L26:
            r7.endMessage(r1);
            return r0.m2285build();
        }

        public int encodedSize(FieldFilterValue r6) {
            MemberFieldFilterValue r0 = r6.mmember_value;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = MemberFieldFilterValue.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            DatetimeFieldFilterValue r3 = r6.mdatetime_value;
            if (r3 == null) goto L9;
            int r4 = DatetimeFieldFilterValue.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            NumberFieldFilterValue r7 = r6.mnumber_value;
            if (r7 == null) goto L13;
            int r8 = NumberFieldFilterValue.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            OptionFieldFilterValue r10 = r6.moption_value;
            if (r10 == null) goto L17;
            int r11 = OptionFieldFilterValue.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            TextFieldFilterValue r13 = r6.mtext_value;
            if (r13 == null) goto L21;
            int r14 = TextFieldFilterValue.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            TaskCompleteStatusFieldFilterValue r16 = r6.mtask_complete_status_value;
            if (r16 == null) goto L25;
            int r17 = TaskCompleteStatusFieldFilterValue.ADAPTER.encodedSizeWithTag(100, r16);
        L26:
            int r18 = r15 + r17;
            TaskSourceTypeFieldFilterValue r19 = r6.mtask_source_type_value;
            if (r19 == null) goto L29;
            int r20 = TaskSourceTypeFieldFilterValue.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r19);
        L30:
            int r21 = r18 + r20;
            TaskSourceFieldFilterValue r22 = r6.mtask_source_value;
            if (r22 == null) goto L33;
            int r23 = TaskSourceFieldFilterValue.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r22);
        L34:
            int r24 = r21 + r23;
            TaskSectionFieldFilterValue r25 = r6.mtask_section_value;
            if (r25 == null) goto L38;
            r1 = TaskSectionFieldFilterValue.ADAPTER.encodedSizeWithTag(103, r25);
        L38:
            return (r24 + r1) + r6.unknownFields().size();
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ Object m2286decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, FieldFilterValue r5) throws IOException {
            MemberFieldFilterValue r0 = r5.mmember_value;
            if (r0 == null) goto L5;
            MemberFieldFilterValue.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            DatetimeFieldFilterValue r1 = r5.mdatetime_value;
            if (r1 == null) goto L8;
            DatetimeFieldFilterValue.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            NumberFieldFilterValue r2 = r5.mnumber_value;
            if (r2 == null) goto L11;
            NumberFieldFilterValue.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            OptionFieldFilterValue r3 = r5.moption_value;
            if (r3 == null) goto L14;
            OptionFieldFilterValue.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            TextFieldFilterValue r6 = r5.mtext_value;
            if (r6 == null) goto L17;
            TextFieldFilterValue.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            TaskCompleteStatusFieldFilterValue r7 = r5.mtask_complete_status_value;
            if (r7 == null) goto L20;
            TaskCompleteStatusFieldFilterValue.ADAPTER.encodeWithTag(r4, 100, r7);
        L20:
            TaskSourceTypeFieldFilterValue r8 = r5.mtask_source_type_value;
            if (r8 == null) goto L23;
            TaskSourceTypeFieldFilterValue.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r8);
        L23:
            TaskSourceFieldFilterValue r9 = r5.mtask_source_value;
            if (r9 == null) goto L26;
            TaskSourceFieldFilterValue.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_S_FRIEND_LINK, r9);
        L26:
            TaskSectionFieldFilterValue r10 = r5.mtask_section_value;
            if (r10 == null) goto L29;
            TaskSectionFieldFilterValue.ADAPTER.encodeWithTag(r4, 103, r10);
        L29:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FieldFilterValue) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FieldFilterValue();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2284newBuilder() {
        Builder r0 = new Builder();
        r0.mmember_value = this.mmember_value;
        r0.mdatetime_value = this.mdatetime_value;
        r0.mnumber_value = this.mnumber_value;
        r0.moption_value = this.moption_value;
        r0.mtext_value = this.mtext_value;
        r0.mtask_complete_status_value = this.mtask_complete_status_value;
        r0.mtask_source_type_value = this.mtask_source_type_value;
        r0.mtask_source_value = this.mtask_source_value;
        r0.mtask_section_value = this.mtask_section_value;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2284newBuilder();
    }

    public FieldFilterValue(MemberFieldFilterValue r12, DatetimeFieldFilterValue r13, NumberFieldFilterValue r14, OptionFieldFilterValue r15, TextFieldFilterValue r16, TaskCompleteStatusFieldFilterValue r17, TaskSourceTypeFieldFilterValue r18, TaskSourceFieldFilterValue r19, TaskSectionFieldFilterValue r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public FieldFilterValue(MemberFieldFilterValue r2, DatetimeFieldFilterValue r3, NumberFieldFilterValue r4, OptionFieldFilterValue r5, TextFieldFilterValue r6, TaskCompleteStatusFieldFilterValue r7, TaskSourceTypeFieldFilterValue r8, TaskSourceFieldFilterValue r9, TaskSectionFieldFilterValue r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mmember_value = r2;
        this.mdatetime_value = r3;
        this.mnumber_value = r4;
        this.moption_value = r5;
        this.mtext_value = r6;
        this.mtask_complete_status_value = r7;
        this.mtask_source_type_value = r8;
        this.mtask_source_value = r9;
        this.mtask_section_value = r10;
    }
}
