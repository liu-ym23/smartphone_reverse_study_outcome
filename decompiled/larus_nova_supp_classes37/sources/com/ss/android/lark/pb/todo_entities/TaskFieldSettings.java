package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskFieldSettings extends Message<TaskFieldSettings, Builder> {
    public static final ProtoAdapter<TaskFieldSettings> ADAPTER = null;
    public static final Boolean DEFAULT_MULTIPLE = null;
    public static final Boolean DEFAULT_READONLY = null;
    public static final Boolean DEFAULT_SELF_EDIT_ONLY = null;
    private static final long serialVersionUID = 0;
    public final DatetimeFieldSettings mdatetime_field_settings;
    public final MemberFieldSettings mmember_field_settings;
    public final MultiSelectFieldSettings mmulti_select_field_settings;
    public final Boolean mmultiple;
    public final NumberFieldSettings mnumber_field_settings;
    public final Boolean mreadonly;
    public final Boolean mself_edit_only;
    public final SingleSelectFieldSettings msingle_select_field_settings;
    public final TextFieldSettings mtext_field_settings;

    public static final class Builder extends Message.Builder<TaskFieldSettings, Builder> {
        public DatetimeFieldSettings mdatetime_field_settings;
        public MemberFieldSettings mmember_field_settings;
        public MultiSelectFieldSettings mmulti_select_field_settings;
        public Boolean mmultiple;
        public NumberFieldSettings mnumber_field_settings;
        public Boolean mreadonly;
        public Boolean mself_edit_only;
        public SingleSelectFieldSettings msingle_select_field_settings;
        public TextFieldSettings mtext_field_settings;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskFieldSettings m2345build() {
            return new TaskFieldSettings(this.mreadonly, this.mmultiple, this.mself_edit_only, this.mnumber_field_settings, this.mmember_field_settings, this.mdatetime_field_settings, this.msingle_select_field_settings, this.mmulti_select_field_settings, this.mtext_field_settings, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2345build();
        }

        public Builder datetime_field_settings(DatetimeFieldSettings r1) {
            this.mdatetime_field_settings = r1;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder member_field_settings(MemberFieldSettings r1) {
            this.mmember_field_settings = r1;
            this.mnumber_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder multi_select_field_settings(MultiSelectFieldSettings r1) {
            this.mmulti_select_field_settings = r1;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder multiple(Boolean r1) {
            this.mmultiple = r1;
            return this;
        }

        public Builder number_field_settings(NumberFieldSettings r1) {
            this.mnumber_field_settings = r1;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder readonly(Boolean r1) {
            this.mreadonly = r1;
            return this;
        }

        public Builder self_edit_only(Boolean r1) {
            this.mself_edit_only = r1;
            return this;
        }

        public Builder single_select_field_settings(SingleSelectFieldSettings r1) {
            this.msingle_select_field_settings = r1;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder text_field_settings(TextFieldSettings r1) {
            this.mtext_field_settings = r1;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskFieldSettings extends ProtoAdapter<TaskFieldSettings> {
        public ProtoAdapter_TaskFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskFieldSettings.class);
        }

        public TaskFieldSettings decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mreadonly = r1;
            r0.mmultiple = r1;
            r0.mself_edit_only = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L22;
            if (r3 != 1) goto L8;
            r0.mreadonly = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmultiple = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mself_edit_only = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            switch(r3) {
                case 101: goto L18;
                case 102: goto L17;
                case 103: goto L16;
                case 104: goto L15;
                case 105: goto L14;
                case 106: goto L13;
                default: goto L12;
            };
        L13:
            r0.text_field_settings((TextFieldSettings) TextFieldSettings.ADAPTER.decode(r7));
            goto L3
        L14:
            r0.multi_select_field_settings((MultiSelectFieldSettings) MultiSelectFieldSettings.ADAPTER.decode(r7));
            goto L3
        L15:
            r0.single_select_field_settings((SingleSelectFieldSettings) SingleSelectFieldSettings.ADAPTER.decode(r7));
            goto L3
        L16:
            r0.datetime_field_settings((DatetimeFieldSettings) DatetimeFieldSettings.ADAPTER.decode(r7));
            goto L3
        L17:
            r0.member_field_settings((MemberFieldSettings) MemberFieldSettings.ADAPTER.decode(r7));
            goto L3
        L18:
            r0.number_field_settings((NumberFieldSettings) NumberFieldSettings.ADAPTER.decode(r7));
            goto L3
        L12:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L22:
            r7.endMessage(r2);
            return r0.m2345build();
        }

        public int encodedSize(TaskFieldSettings r6) {
            Boolean r0 = r6.mreadonly;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mmultiple;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mself_edit_only;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            NumberFieldSettings r10 = r6.mnumber_field_settings;
            if (r10 == null) goto L17;
            int r11 = NumberFieldSettings.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r10);
        L18:
            int r12 = r9 + r11;
            MemberFieldSettings r13 = r6.mmember_field_settings;
            if (r13 == null) goto L21;
            int r14 = MemberFieldSettings.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r13);
        L22:
            int r15 = r12 + r14;
            DatetimeFieldSettings r16 = r6.mdatetime_field_settings;
            if (r16 == null) goto L25;
            int r17 = DatetimeFieldSettings.ADAPTER.encodedSizeWithTag(103, r16);
        L26:
            int r18 = r15 + r17;
            SingleSelectFieldSettings r19 = r6.msingle_select_field_settings;
            if (r19 == null) goto L29;
            int r20 = SingleSelectFieldSettings.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_ALIAS_AND_MEMO, r19);
        L30:
            int r21 = r18 + r20;
            MultiSelectFieldSettings r22 = r6.mmulti_select_field_settings;
            if (r22 == null) goto L33;
            int r23 = MultiSelectFieldSettings.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_MEMO_DESCRIPTION, r22);
        L34:
            int r24 = r21 + r23;
            TextFieldSettings r25 = r6.mtext_field_settings;
            if (r25 == null) goto L38;
            r1 = TextFieldSettings.ADAPTER.encodedSizeWithTag(106, r25);
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
        public /* bridge */ /* synthetic */ Object m2346decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskFieldSettings) r1);
        }

        public void encode(ProtoWriter r4, TaskFieldSettings r5) throws IOException {
            Boolean r0 = r5.mreadonly;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mmultiple;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mself_edit_only;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            NumberFieldSettings r3 = r5.mnumber_field_settings;
            if (r3 == null) goto L14;
            NumberFieldSettings.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r3);
        L14:
            MemberFieldSettings r6 = r5.mmember_field_settings;
            if (r6 == null) goto L17;
            MemberFieldSettings.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_S_FRIEND_LINK, r6);
        L17:
            DatetimeFieldSettings r7 = r5.mdatetime_field_settings;
            if (r7 == null) goto L20;
            DatetimeFieldSettings.ADAPTER.encodeWithTag(r4, 103, r7);
        L20:
            SingleSelectFieldSettings r8 = r5.msingle_select_field_settings;
            if (r8 == null) goto L23;
            SingleSelectFieldSettings.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_ALIAS_AND_MEMO, r8);
        L23:
            MultiSelectFieldSettings r9 = r5.mmulti_select_field_settings;
            if (r9 == null) goto L26;
            MultiSelectFieldSettings.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_MEMO_DESCRIPTION, r9);
        L26:
            TextFieldSettings r10 = r5.mtext_field_settings;
            if (r10 == null) goto L29;
            TextFieldSettings.ADAPTER.encodeWithTag(r4, 106, r10);
        L29:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskFieldSettings) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskFieldSettings();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_READONLY = r0;
        DEFAULT_MULTIPLE = r0;
        DEFAULT_SELF_EDIT_ONLY = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2344newBuilder() {
        Builder r0 = new Builder();
        r0.mreadonly = this.mreadonly;
        r0.mmultiple = this.mmultiple;
        r0.mself_edit_only = this.mself_edit_only;
        r0.mnumber_field_settings = this.mnumber_field_settings;
        r0.mmember_field_settings = this.mmember_field_settings;
        r0.mdatetime_field_settings = this.mdatetime_field_settings;
        r0.msingle_select_field_settings = this.msingle_select_field_settings;
        r0.mmulti_select_field_settings = this.mmulti_select_field_settings;
        r0.mtext_field_settings = this.mtext_field_settings;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2344newBuilder();
    }

    public TaskFieldSettings(Boolean r12, Boolean r13, Boolean r14, NumberFieldSettings r15, MemberFieldSettings r16, DatetimeFieldSettings r17, SingleSelectFieldSettings r18, MultiSelectFieldSettings r19, TextFieldSettings r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public TaskFieldSettings(Boolean r2, Boolean r3, Boolean r4, NumberFieldSettings r5, MemberFieldSettings r6, DatetimeFieldSettings r7, SingleSelectFieldSettings r8, MultiSelectFieldSettings r9, TextFieldSettings r10, ByteString r11) {
        super(ADAPTER, r11);
        if (Internal.countNonNull(r5, r6, r7, r8, new Object[]{r9, r10}) > 1) goto L7;
        this.mreadonly = r2;
        this.mmultiple = r3;
        this.mself_edit_only = r4;
        this.mnumber_field_settings = r5;
        this.mmember_field_settings = r6;
        this.mdatetime_field_settings = r7;
        this.msingle_select_field_settings = r8;
        this.mmulti_select_field_settings = r9;
        this.mtext_field_settings = r10;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mnumber_field_settings, mmember_field_settings, mdatetime_field_settings, msingle_select_field_settings, mmulti_select_field_settings, mtext_field_settings may be non-null");
    }
}
