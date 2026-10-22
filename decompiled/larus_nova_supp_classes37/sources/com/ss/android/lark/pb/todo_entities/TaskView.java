package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskView extends Message<TaskView, Builder> {
    public static final ProtoAdapter<TaskView> ADAPTER = null;
    public static final Boolean DEFAULT_ADMIN_SETTING = null;
    public static final Long DEFAULT_ADMIN_SETTING_UPDATE_USER_ID = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final String DEFAULT_CONTAINER_KEY = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_SHOW_SUB_TASKS = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean madmin_setting;
    public final Long madmin_setting_update_user_id;
    public final String mcontainer_guid;
    public final String mcontainer_key;
    public final Long mdelete_milli_time;
    public final TaskViewFieldConfig mfield_config;
    public final GanttViewSetting mgantt_view_setting;
    public final String mguid;
    public final Boolean mshow_sub_tasks;
    public final Type mtype;
    public final Long mversion;
    public final TaskViewFields mview_fields;
    public final TaskViewFilters mview_filters;
    public final TaskViewGroups mview_groups;
    public final TaskViewSorts mview_sorts;

    public static final class Builder extends Message.Builder<TaskView, Builder> {
        public Boolean madmin_setting;
        public Long madmin_setting_update_user_id;
        public String mcontainer_guid;
        public String mcontainer_key;
        public Long mdelete_milli_time;
        public TaskViewFieldConfig mfield_config;
        public GanttViewSetting mgantt_view_setting;
        public String mguid;
        public Boolean mshow_sub_tasks;
        public Type mtype;
        public Long mversion;
        public TaskViewFields mview_fields;
        public TaskViewFilters mview_filters;
        public TaskViewGroups mview_groups;
        public TaskViewSorts mview_sorts;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskView m2363build() {
            return new TaskView(this.mguid, this.mtype, this.mview_fields, this.mview_groups, this.mview_sorts, this.mview_filters, this.mshow_sub_tasks, this.mcontainer_guid, this.mfield_config, this.mcontainer_key, this.madmin_setting, this.madmin_setting_update_user_id, this.mversion, this.mdelete_milli_time, this.mgantt_view_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2363build();
        }

        public Builder admin_setting(Boolean r1) {
            this.madmin_setting = r1;
            return this;
        }

        public Builder admin_setting_update_user_id(Long r1) {
            this.madmin_setting_update_user_id = r1;
            return this;
        }

        public Builder container_guid(String r1) {
            this.mcontainer_guid = r1;
            return this;
        }

        public Builder container_key(String r1) {
            this.mcontainer_key = r1;
            return this;
        }

        public Builder delete_milli_time(Long r1) {
            this.mdelete_milli_time = r1;
            return this;
        }

        public Builder field_config(TaskViewFieldConfig r1) {
            this.mfield_config = r1;
            return this;
        }

        public Builder gantt_view_setting(GanttViewSetting r1) {
            this.mgantt_view_setting = r1;
            return this;
        }

        public Builder guid(String r1) {
            this.mguid = r1;
            return this;
        }

        public Builder show_sub_tasks(Boolean r1) {
            this.mshow_sub_tasks = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }

        public Builder view_fields(TaskViewFields r1) {
            this.mview_fields = r1;
            return this;
        }

        public Builder view_filters(TaskViewFilters r1) {
            this.mview_filters = r1;
            return this;
        }

        public Builder view_groups(TaskViewGroups r1) {
            this.mview_groups = r1;
            return this;
        }

        public Builder view_sorts(TaskViewSorts r1) {
            this.mview_sorts = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskView extends ProtoAdapter<TaskView> {
        public ProtoAdapter_TaskView() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskView.class);
        }

        public TaskView decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mguid = "";
            Boolean r2 = Boolean.FALSE;
            r0.mshow_sub_tasks = r2;
            r0.mcontainer_guid = "";
            r0.mcontainer_key = "";
            r0.madmin_setting = r2;
            r0.madmin_setting_update_user_id = 0L;
            r0.mversion = 0L;
            r0.mdelete_milli_time = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L31;
            if (r3 != 100) goto L8;
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 101) goto L10;
            r0.mdelete_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 201) goto L11;
            r0.gantt_view_setting((GanttViewSetting) GanttViewSetting.ADAPTER.decode(r9));
            goto L3
        L11:
            switch(r3) {
                case 1: goto L27;
                case 2: goto L33;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                default: goto L12;
            };
        L33:
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r0.madmin_setting_update_user_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L14:
            r0.madmin_setting = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            r0.mcontainer_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mfield_config = (TaskViewFieldConfig) TaskViewFieldConfig.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mcontainer_guid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mshow_sub_tasks = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L19:
            r0.mview_filters = (TaskViewFilters) TaskViewFilters.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.mview_sorts = (TaskViewSorts) TaskViewSorts.ADAPTER.decode(r9);
            goto L3
        L21:
            r0.mview_groups = (TaskViewGroups) TaskViewGroups.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.mview_fields = (TaskViewFields) TaskViewFields.ADAPTER.decode(r9);
            goto L3
        L27:
            r0.mguid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L31:
            r9.endMessage(r1);
            return r0.m2363build();
        }

        public int encodedSize(TaskView r6) {
            String r0 = r6.mguid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Type r3 = r6.mtype;
            if (r3 == null) goto L9;
            int r4 = Type.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            TaskViewFields r7 = r6.mview_fields;
            if (r7 == null) goto L13;
            int r8 = TaskViewFields.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TaskViewGroups r10 = r6.mview_groups;
            if (r10 == null) goto L17;
            int r11 = TaskViewGroups.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            TaskViewSorts r13 = r6.mview_sorts;
            if (r13 == null) goto L21;
            int r14 = TaskViewSorts.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            TaskViewFilters r16 = r6.mview_filters;
            if (r16 == null) goto L25;
            int r17 = TaskViewFilters.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mshow_sub_tasks;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mcontainer_guid;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            TaskViewFieldConfig r25 = r6.mfield_config;
            if (r25 == null) goto L37;
            int r26 = TaskViewFieldConfig.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mcontainer_key;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            Boolean r31 = r6.madmin_setting;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r31);
        L46:
            int r33 = r30 + r32;
            Long r34 = r6.madmin_setting_update_user_id;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.INT64.encodedSizeWithTag(12, r34);
        L50:
            int r36 = r33 + r35;
            Long r37 = r6.mversion;
            if (r37 == null) goto L53;
            int r38 = ProtoAdapter.INT64.encodedSizeWithTag(100, r37);
        L54:
            int r39 = r36 + r38;
            Long r40 = r6.mdelete_milli_time;
            if (r40 == null) goto L57;
            int r41 = ProtoAdapter.INT64.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r40);
        L58:
            int r42 = r39 + r41;
            GanttViewSetting r43 = r6.mgantt_view_setting;
            if (r43 == null) goto L62;
            r1 = GanttViewSetting.ADAPTER.encodedSizeWithTag(201, r43);
        L62:
            return (r42 + r1) + r6.unknownFields().size();
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ Object m2364decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskView) r1);
        }

        public void encode(ProtoWriter r4, TaskView r5) throws IOException {
            String r0 = r5.mguid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Type r1 = r5.mtype;
            if (r1 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            TaskViewFields r2 = r5.mview_fields;
            if (r2 == null) goto L11;
            TaskViewFields.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TaskViewGroups r3 = r5.mview_groups;
            if (r3 == null) goto L14;
            TaskViewGroups.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            TaskViewSorts r6 = r5.mview_sorts;
            if (r6 == null) goto L17;
            TaskViewSorts.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            TaskViewFilters r7 = r5.mview_filters;
            if (r7 == null) goto L20;
            TaskViewFilters.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mshow_sub_tasks;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mcontainer_guid;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            TaskViewFieldConfig r10 = r5.mfield_config;
            if (r10 == null) goto L29;
            TaskViewFieldConfig.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            String r11 = r5.mcontainer_key;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r11);
        L32:
            Boolean r12 = r5.madmin_setting;
            if (r12 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r4, 11, r12);
        L35:
            Long r13 = r5.madmin_setting_update_user_id;
            if (r13 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r4, 12, r13);
        L38:
            Long r14 = r5.mversion;
            if (r14 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r4, 100, r14);
        L41:
            Long r15 = r5.mdelete_milli_time;
            if (r15 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r15);
        L44:
            GanttViewSetting r16 = r5.mgantt_view_setting;
            if (r16 == null) goto L47;
            GanttViewSetting.ADAPTER.encodeWithTag(r4, 201, r16);
        L47:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskView) r2);
        }
    }

    public static final class TaskViewField extends Message<TaskViewField, Builder> {
        public static final ProtoAdapter<TaskViewField> ADAPTER = null;
        public static final String DEFAULT_FIELD_KEY = "";
        public static final Boolean DEFAULT_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final String mfield_key;
        public final Boolean mvisible;

        public static final class Builder extends Message.Builder<TaskViewField, Builder> {
            public String mfield_key;
            public Boolean mvisible;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewField m2366build() {
                return new TaskViewField(this.mfield_key, this.mvisible, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2366build();
            }

            public Builder field_key(String r1) {
                this.mfield_key = r1;
                return this;
            }

            public Builder visible(Boolean r1) {
                this.mvisible = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewField extends ProtoAdapter<TaskViewField> {
            public ProtoAdapter_TaskViewField() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewField.class);
            }

            public TaskViewField decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mfield_key = "";
                r0.mvisible = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mfield_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mvisible = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2366build();
            }

            public int encodedSize(TaskViewField r5) {
                String r0 = r5.mfield_key;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mvisible;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2367decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewField) r1);
            }

            public void encode(ProtoWriter r4, TaskViewField r5) throws IOException {
                String r0 = r5.mfield_key;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mvisible;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewField) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewField();
            DEFAULT_VISIBLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2365newBuilder() {
            Builder r0 = new Builder();
            r0.mfield_key = this.mfield_key;
            r0.mvisible = this.mvisible;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewField.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2365newBuilder();
        }

        public TaskViewField(String r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public TaskViewField(String r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mfield_key = r2;
            this.mvisible = r3;
        }
    }

    public static final class TaskViewFieldConfig extends Message<TaskViewFieldConfig, Builder> {
        public static final ProtoAdapter<TaskViewFieldConfig> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> menable_filter_field_keys;
        public final List<String> menable_group_field_keys;
        public final List<String> menable_sort_field_keys;
        public final List<String> menable_system_field_keys;

        public static final class Builder extends Message.Builder<TaskViewFieldConfig, Builder> {
            public List<String> menable_filter_field_keys;
            public List<String> menable_group_field_keys;
            public List<String> menable_sort_field_keys;
            public List<String> menable_system_field_keys;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewFieldConfig m2369build() {
                return new TaskViewFieldConfig(this.menable_system_field_keys, this.menable_filter_field_keys, this.menable_group_field_keys, this.menable_sort_field_keys, super.buildUnknownFields());
            }

            public Builder() {
                this.menable_system_field_keys = Internal.newMutableList();
                this.menable_filter_field_keys = Internal.newMutableList();
                this.menable_group_field_keys = Internal.newMutableList();
                this.menable_sort_field_keys = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2369build();
            }

            public Builder enable_filter_field_keys(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.menable_filter_field_keys = r1;
                return this;
            }

            public Builder enable_group_field_keys(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.menable_group_field_keys = r1;
                return this;
            }

            public Builder enable_sort_field_keys(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.menable_sort_field_keys = r1;
                return this;
            }

            public Builder enable_system_field_keys(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.menable_system_field_keys = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewFieldConfig extends ProtoAdapter<TaskViewFieldConfig> {
            public ProtoAdapter_TaskViewFieldConfig() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewFieldConfig.class);
            }

            public TaskViewFieldConfig decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.menable_system_field_keys.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.menable_filter_field_keys.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.menable_group_field_keys.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.menable_sort_field_keys.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m2369build();
            }

            public int encodedSize(TaskViewFieldConfig r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                return (((r0.asRepeated().encodedSizeWithTag(1, r6.menable_system_field_keys) + r0.asRepeated().encodedSizeWithTag(2, r6.menable_filter_field_keys)) + r0.asRepeated().encodedSizeWithTag(3, r6.menable_group_field_keys)) + r0.asRepeated().encodedSizeWithTag(4, r6.menable_sort_field_keys)) + r6.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2370decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewFieldConfig) r1);
            }

            public void encode(ProtoWriter r5, TaskViewFieldConfig r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 1, r6.menable_system_field_keys);
                r0.asRepeated().encodeWithTag(r5, 2, r6.menable_filter_field_keys);
                r0.asRepeated().encodeWithTag(r5, 3, r6.menable_group_field_keys);
                r0.asRepeated().encodeWithTag(r5, 4, r6.menable_sort_field_keys);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewFieldConfig) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewFieldConfig();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2368newBuilder() {
            Builder r0 = new Builder();
            r0.menable_system_field_keys = Internal.copyOf("menable_system_field_keys", this.menable_system_field_keys);
            r0.menable_filter_field_keys = Internal.copyOf("menable_filter_field_keys", this.menable_filter_field_keys);
            r0.menable_group_field_keys = Internal.copyOf("menable_group_field_keys", this.menable_group_field_keys);
            r0.menable_sort_field_keys = Internal.copyOf("menable_sort_field_keys", this.menable_sort_field_keys);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewFieldConfig.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2368newBuilder();
        }

        public TaskViewFieldConfig(List<String> r7, List<String> r8, List<String> r9, List<String> r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public TaskViewFieldConfig(List<String> r2, List<String> r3, List<String> r4, List<String> r5, ByteString r6) {
            super(ADAPTER, r6);
            this.menable_system_field_keys = Internal.immutableCopyOf("menable_system_field_keys", r2);
            this.menable_filter_field_keys = Internal.immutableCopyOf("menable_filter_field_keys", r3);
            this.menable_group_field_keys = Internal.immutableCopyOf("menable_group_field_keys", r4);
            this.menable_sort_field_keys = Internal.immutableCopyOf("menable_sort_field_keys", r5);
        }
    }

    public static final class TaskViewFields extends Message<TaskViewFields, Builder> {
        public static final ProtoAdapter<TaskViewFields> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TaskViewField> mfields;

        public static final class Builder extends Message.Builder<TaskViewFields, Builder> {
            public List<TaskViewField> mfields;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewFields m2372build() {
                return new TaskViewFields(this.mfields, super.buildUnknownFields());
            }

            public Builder() {
                this.mfields = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2372build();
            }

            public Builder fields(List<TaskViewField> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfields = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewFields extends ProtoAdapter<TaskViewFields> {
            public ProtoAdapter_TaskViewFields() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewFields.class);
            }

            public TaskViewFields decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfields.add((TaskViewField) TaskViewField.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2372build();
            }

            public int encodedSize(TaskViewFields r4) {
                return TaskViewField.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mfields) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2373decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewFields) r1);
            }

            public void encode(ProtoWriter r4, TaskViewFields r5) throws IOException {
                TaskViewField.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mfields);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewFields) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewFields();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2371newBuilder() {
            Builder r0 = new Builder();
            r0.mfields = Internal.copyOf("mfields", this.mfields);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewFields.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2371newBuilder();
        }

        public TaskViewFields(List<TaskViewField> r2) {
            this(r2, ByteString.EMPTY);
        }

        public TaskViewFields(List<TaskViewField> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfields = Internal.immutableCopyOf("mfields", r2);
        }
    }

    public static final class TaskViewFilters extends Message<TaskViewFilters, Builder> {
        public static final ProtoAdapter<TaskViewFilters> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<FilterCondition> mconditions;
        public final FilterConjunction mconjunction;

        public static final class Builder extends Message.Builder<TaskViewFilters, Builder> {
            public List<FilterCondition> mconditions;
            public FilterConjunction mconjunction;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewFilters m2375build() {
                return new TaskViewFilters(this.mconjunction, this.mconditions, super.buildUnknownFields());
            }

            public Builder() {
                this.mconditions = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2375build();
            }

            public Builder conditions(List<FilterCondition> r1) {
                Internal.checkElementsNotNull(r1);
                this.mconditions = r1;
                return this;
            }

            public Builder conjunction(FilterConjunction r1) {
                this.mconjunction = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewFilters extends ProtoAdapter<TaskViewFilters> {
            public ProtoAdapter_TaskViewFilters() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewFilters.class);
            }

            public TaskViewFilters decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mconjunction = (FilterConjunction) FilterConjunction.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mconditions.add((FilterCondition) FilterCondition.ADAPTER.decode(r9));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m2375build();
            }

            public int encodedSize(TaskViewFilters r5) {
                FilterConjunction r0 = r5.mconjunction;
                if (r0 == null) goto L5;
                int r1 = FilterConjunction.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return (r1 + FilterCondition.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mconditions)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2376decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewFilters) r1);
            }

            public void encode(ProtoWriter r4, TaskViewFilters r5) throws IOException {
                FilterConjunction r0 = r5.mconjunction;
                if (r0 == null) goto L5;
                FilterConjunction.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                FilterCondition.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mconditions);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewFilters) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewFilters();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2374newBuilder() {
            Builder r0 = new Builder();
            r0.mconjunction = this.mconjunction;
            r0.mconditions = Internal.copyOf("mconditions", this.mconditions);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewFilters.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2374newBuilder();
        }

        public TaskViewFilters(FilterConjunction r2, List<FilterCondition> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public TaskViewFilters(FilterConjunction r2, List<FilterCondition> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mconjunction = r2;
            this.mconditions = Internal.immutableCopyOf("mconditions", r3);
        }
    }

    public static final class TaskViewGroup extends Message<TaskViewGroup, Builder> {
        public static final ProtoAdapter<TaskViewGroup> ADAPTER = null;
        public static final String DEFAULT_FIELD_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mfield_key;

        public static final class Builder extends Message.Builder<TaskViewGroup, Builder> {
            public String mfield_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewGroup m2378build() {
                return new TaskViewGroup(this.mfield_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2378build();
            }

            public Builder field_key(String r1) {
                this.mfield_key = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewGroup extends ProtoAdapter<TaskViewGroup> {
            public ProtoAdapter_TaskViewGroup() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewGroup.class);
            }

            public TaskViewGroup decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mfield_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfield_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2378build();
            }

            public int encodedSize(TaskViewGroup r4) {
                String r0 = r4.mfield_key;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2379decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewGroup) r1);
            }

            public void encode(ProtoWriter r4, TaskViewGroup r5) throws IOException {
                String r0 = r5.mfield_key;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewGroup) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewGroup();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2377newBuilder() {
            Builder r0 = new Builder();
            r0.mfield_key = this.mfield_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewGroup.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2377newBuilder();
        }

        public TaskViewGroup(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public TaskViewGroup(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfield_key = r2;
        }
    }

    public static final class TaskViewGroups extends Message<TaskViewGroups, Builder> {
        public static final ProtoAdapter<TaskViewGroups> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TaskViewGroup> mgroups;

        public static final class Builder extends Message.Builder<TaskViewGroups, Builder> {
            public List<TaskViewGroup> mgroups;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewGroups m2381build() {
                return new TaskViewGroups(this.mgroups, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroups = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2381build();
            }

            public Builder groups(List<TaskViewGroup> r1) {
                Internal.checkElementsNotNull(r1);
                this.mgroups = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewGroups extends ProtoAdapter<TaskViewGroups> {
            public ProtoAdapter_TaskViewGroups() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewGroups.class);
            }

            public TaskViewGroups decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mgroups.add((TaskViewGroup) TaskViewGroup.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2381build();
            }

            public int encodedSize(TaskViewGroups r4) {
                return TaskViewGroup.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mgroups) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2382decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewGroups) r1);
            }

            public void encode(ProtoWriter r4, TaskViewGroups r5) throws IOException {
                TaskViewGroup.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mgroups);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewGroups) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewGroups();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2380newBuilder() {
            Builder r0 = new Builder();
            r0.mgroups = Internal.copyOf("mgroups", this.mgroups);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewGroups.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2380newBuilder();
        }

        public TaskViewGroups(List<TaskViewGroup> r2) {
            this(r2, ByteString.EMPTY);
        }

        public TaskViewGroups(List<TaskViewGroup> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mgroups = Internal.immutableCopyOf("mgroups", r2);
        }
    }

    public static final class TaskViewSort extends Message<TaskViewSort, Builder> {
        public static final ProtoAdapter<TaskViewSort> ADAPTER = null;
        public static final String DEFAULT_FIELD_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mfield_key;
        public final OrderType morder;

        public static final class Builder extends Message.Builder<TaskViewSort, Builder> {
            public String mfield_key;
            public OrderType morder;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewSort m2384build() {
                return new TaskViewSort(this.mfield_key, this.morder, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2384build();
            }

            public Builder field_key(String r1) {
                this.mfield_key = r1;
                return this;
            }

            public Builder order(OrderType r1) {
                this.morder = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewSort extends ProtoAdapter<TaskViewSort> {
            public ProtoAdapter_TaskViewSort() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewSort.class);
            }

            public TaskViewSort decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mfield_key = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mfield_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.morder = (OrderType) OrderType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
                return r0.m2384build();
            }

            public int encodedSize(TaskViewSort r5) {
                String r0 = r5.mfield_key;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                OrderType r3 = r5.morder;
                if (r3 == null) goto L10;
                r1 = OrderType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2385decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewSort) r1);
            }

            public void encode(ProtoWriter r4, TaskViewSort r5) throws IOException {
                String r0 = r5.mfield_key;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                OrderType r1 = r5.morder;
                if (r1 == null) goto L8;
                OrderType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewSort) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewSort();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2383newBuilder() {
            Builder r0 = new Builder();
            r0.mfield_key = this.mfield_key;
            r0.morder = this.morder;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewSort.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2383newBuilder();
        }

        public TaskViewSort(String r2, OrderType r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public TaskViewSort(String r2, OrderType r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mfield_key = r2;
            this.morder = r3;
        }
    }

    public static final class TaskViewSorts extends Message<TaskViewSorts, Builder> {
        public static final ProtoAdapter<TaskViewSorts> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TaskViewSort> msorts;

        public static final class Builder extends Message.Builder<TaskViewSorts, Builder> {
            public List<TaskViewSort> msorts;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TaskViewSorts m2387build() {
                return new TaskViewSorts(this.msorts, super.buildUnknownFields());
            }

            public Builder() {
                this.msorts = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2387build();
            }

            public Builder sorts(List<TaskViewSort> r1) {
                Internal.checkElementsNotNull(r1);
                this.msorts = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TaskViewSorts extends ProtoAdapter<TaskViewSorts> {
            public ProtoAdapter_TaskViewSorts() {
                super(FieldEncoding.LENGTH_DELIMITED, TaskViewSorts.class);
            }

            public TaskViewSorts decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.msorts.add((TaskViewSort) TaskViewSort.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2387build();
            }

            public int encodedSize(TaskViewSorts r4) {
                return TaskViewSort.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.msorts) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2388decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TaskViewSorts) r1);
            }

            public void encode(ProtoWriter r4, TaskViewSorts r5) throws IOException {
                TaskViewSort.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.msorts);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TaskViewSorts) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TaskViewSorts();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2386newBuilder() {
            Builder r0 = new Builder();
            r0.msorts = Internal.copyOf("msorts", this.msorts);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TaskViewSorts.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2386newBuilder();
        }

        public TaskViewSorts(List<TaskViewSort> r2) {
            this(r2, ByteString.EMPTY);
        }

        public TaskViewSorts(List<TaskViewSort> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.msorts = Internal.immutableCopyOf("msorts", r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CALENDAR = null;
        public static final Type GANTT = null;
        public static final Type KANBAN = null;
        public static final Type TABLE = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("TABLE", 1, 1);
            TABLE = r1;
            Type r3 = new Type("KANBAN", 2, 2);
            KANBAN = r3;
            Type r5 = new Type("GANTT", 3, 3);
            GANTT = r5;
            Type r7 = new Type("CALENDAR", 4, 4);
            CALENDAR = r7;
            $VALUES = new Type[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return CALENDAR;
        L16:
            return GANTT;
        L18:
            return KANBAN;
        L20:
            return TABLE;
        L22:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskView();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_SHOW_SUB_TASKS = r0;
        DEFAULT_ADMIN_SETTING = r0;
        DEFAULT_ADMIN_SETTING_UPDATE_USER_ID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2362newBuilder() {
        Builder r0 = new Builder();
        r0.mguid = this.mguid;
        r0.mtype = this.mtype;
        r0.mview_fields = this.mview_fields;
        r0.mview_groups = this.mview_groups;
        r0.mview_sorts = this.mview_sorts;
        r0.mview_filters = this.mview_filters;
        r0.mshow_sub_tasks = this.mshow_sub_tasks;
        r0.mcontainer_guid = this.mcontainer_guid;
        r0.mfield_config = this.mfield_config;
        r0.mcontainer_key = this.mcontainer_key;
        r0.madmin_setting = this.madmin_setting;
        r0.madmin_setting_update_user_id = this.madmin_setting_update_user_id;
        r0.mversion = this.mversion;
        r0.mdelete_milli_time = this.mdelete_milli_time;
        r0.mgantt_view_setting = this.mgantt_view_setting;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskView.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2362newBuilder();
    }

    public TaskView(String r18, Type r19, TaskViewFields r20, TaskViewGroups r21, TaskViewSorts r22, TaskViewFilters r23, Boolean r24, String r25, TaskViewFieldConfig r26, String r27, Boolean r28, Long r29, Long r30, Long r31, GanttViewSetting r32) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, ByteString.EMPTY);
    }

    public TaskView(String r4, Type r5, TaskViewFields r6, TaskViewGroups r7, TaskViewSorts r8, TaskViewFilters r9, Boolean r10, String r11, TaskViewFieldConfig r12, String r13, Boolean r14, Long r15, Long r16, Long r17, GanttViewSetting r18, ByteString r19) {
        super(ADAPTER, r19);
        this.mguid = r4;
        this.mtype = r5;
        this.mview_fields = r6;
        this.mview_groups = r7;
        this.mview_sorts = r8;
        this.mview_filters = r9;
        this.mshow_sub_tasks = r10;
        this.mcontainer_guid = r11;
        this.mfield_config = r12;
        this.mcontainer_key = r13;
        this.madmin_setting = r14;
        this.madmin_setting_update_user_id = r15;
        this.mversion = r16;
        this.mdelete_milli_time = r17;
        this.mgantt_view_setting = r18;
    }
}
