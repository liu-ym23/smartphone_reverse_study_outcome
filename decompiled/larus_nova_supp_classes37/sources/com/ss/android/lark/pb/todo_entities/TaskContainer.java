package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskContainer extends Message<TaskContainer, Builder> {
    public static final ProtoAdapter<TaskContainer> ADAPTER = null;
    public static final Long DEFAULT_ARCHIVED_MILLI_TIME = null;
    public static final Long DEFAULT_ARCHIVED_USER_ID = null;
    public static final String DEFAULT_BASE_TABLE_TOKEN = "";
    public static final String DEFAULT_BASE_TOKEN = "";
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final Long DEFAULT_CURRENT_USER_JOIN_MILLI_TIME = null;
    public static final Long DEFAULT_DASHBOARD_CREATOR_ID = null;
    public static final String DEFAULT_DASHBOARD_ID = "";
    public static final Long DEFAULT_DELETE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_NOT_MINE = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_OWNER_ID = null;
    public static final String DEFAULT_RANK = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final AgentCategory magent_category;
    public final AgentInfo magent_origin;
    public final Long marchived_milli_time;
    public final Long marchived_user_id;
    public final String mbase_table_token;
    public final String mbase_token;
    public final Category mcategory;
    public final Long mcreate_milli_time;
    public final Long mcurrent_user_join_milli_time;
    public final TaskContainerPermission mcurrent_user_permission;
    public final Long mdashboard_creator_id;
    public final String mdashboard_id;
    public final Long mdelete_milli_time;
    public final String mguid;
    public final IconInfo miconInfo;
    public final Boolean mis_not_mine;
    public final String mkey;
    public final MeegoOrigin mmeego_origin;
    public final String mname;
    public final Long mowner_id;
    public final String mrank;
    public final Long muser_id;
    public final Long mversion;

    public static final enum AgentCategory extends Enum<AgentCategory> implements WireEnum {
        private static final /* synthetic */ AgentCategory[] $VALUES = null;
        public static final ProtoAdapter<AgentCategory> ADAPTER = null;
        public static final AgentCategory AGENT_CRON_TASK_LIST = null;
        public static final AgentCategory AGENT_CUSTOM_TASK_LIST = null;
        public static final AgentCategory AGENT_OWNED_TASK_LIST = null;
        public static final AgentCategory AGENT_UNKNOWN = null;
        private final int value;

        static {
            AgentCategory r0 = new AgentCategory("AGENT_UNKNOWN", 0, 0);
            AGENT_UNKNOWN = r0;
            AgentCategory r1 = new AgentCategory("AGENT_OWNED_TASK_LIST", 1, 1);
            AGENT_OWNED_TASK_LIST = r1;
            AgentCategory r3 = new AgentCategory("AGENT_CRON_TASK_LIST", 2, 2);
            AGENT_CRON_TASK_LIST = r3;
            AgentCategory r5 = new AgentCategory("AGENT_CUSTOM_TASK_LIST", 3, 3);
            AGENT_CUSTOM_TASK_LIST = r5;
            $VALUES = new AgentCategory[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(AgentCategory.class);
        }

        public static AgentCategory[] values() {
            return (AgentCategory[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AgentCategory fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return AGENT_CUSTOM_TASK_LIST;
        L14:
            return AGENT_CRON_TASK_LIST;
        L16:
            return AGENT_OWNED_TASK_LIST;
        L18:
            return AGENT_UNKNOWN;
        }

        public static AgentCategory valueOf(String r1) {
            return (AgentCategory) a.a(AgentCategory.class, r1);
        }

        private AgentCategory(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<TaskContainer, Builder> {
        public AgentCategory magent_category;
        public AgentInfo magent_origin;
        public Long marchived_milli_time;
        public Long marchived_user_id;
        public String mbase_table_token;
        public String mbase_token;
        public Category mcategory;
        public Long mcreate_milli_time;
        public Long mcurrent_user_join_milli_time;
        public TaskContainerPermission mcurrent_user_permission;
        public Long mdashboard_creator_id;
        public String mdashboard_id;
        public Long mdelete_milli_time;
        public String mguid;
        public IconInfo miconInfo;
        public Boolean mis_not_mine;
        public String mkey;
        public MeegoOrigin mmeego_origin;
        public String mname;
        public Long mowner_id;
        public String mrank;
        public Long muser_id;
        public Long mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskContainer m2333build() {
            return new TaskContainer(this.mguid, this.mcategory, this.muser_id, this.mkey, this.mname, this.mrank, this.mis_not_mine, this.mcurrent_user_permission, this.mcurrent_user_join_milli_time, this.mowner_id, this.marchived_milli_time, this.marchived_user_id, this.miconInfo, this.mbase_token, this.mbase_table_token, this.mdashboard_id, this.mdashboard_creator_id, this.mversion, this.mdelete_milli_time, this.mcreate_milli_time, this.mmeego_origin, this.magent_category, this.magent_origin, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2333build();
        }

        public Builder agent_category(AgentCategory r1) {
            this.magent_category = r1;
            return this;
        }

        public Builder agent_origin(AgentInfo r1) {
            this.magent_origin = r1;
            return this;
        }

        public Builder archived_milli_time(Long r1) {
            this.marchived_milli_time = r1;
            return this;
        }

        public Builder archived_user_id(Long r1) {
            this.marchived_user_id = r1;
            return this;
        }

        public Builder base_table_token(String r1) {
            this.mbase_table_token = r1;
            return this;
        }

        public Builder base_token(String r1) {
            this.mbase_token = r1;
            return this;
        }

        public Builder category(Category r1) {
            this.mcategory = r1;
            return this;
        }

        public Builder create_milli_time(Long r1) {
            this.mcreate_milli_time = r1;
            return this;
        }

        public Builder current_user_join_milli_time(Long r1) {
            this.mcurrent_user_join_milli_time = r1;
            return this;
        }

        public Builder current_user_permission(TaskContainerPermission r1) {
            this.mcurrent_user_permission = r1;
            return this;
        }

        public Builder dashboard_creator_id(Long r1) {
            this.mdashboard_creator_id = r1;
            return this;
        }

        public Builder dashboard_id(String r1) {
            this.mdashboard_id = r1;
            return this;
        }

        public Builder delete_milli_time(Long r1) {
            this.mdelete_milli_time = r1;
            return this;
        }

        public Builder guid(String r1) {
            this.mguid = r1;
            return this;
        }

        public Builder iconInfo(IconInfo r1) {
            this.miconInfo = r1;
            return this;
        }

        public Builder is_not_mine(Boolean r1) {
            this.mis_not_mine = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder meego_origin(MeegoOrigin r1) {
            this.mmeego_origin = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder owner_id(Long r1) {
            this.mowner_id = r1;
            return this;
        }

        public Builder rank(String r1) {
            this.mrank = r1;
            return this;
        }

        public Builder user_id(Long r1) {
            this.muser_id = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final enum Category extends Enum<Category> implements WireEnum {
        private static final /* synthetic */ Category[] $VALUES = null;
        public static final ProtoAdapter<Category> ADAPTER = null;
        public static final Category FOLLOWED_TASKS = null;
        public static final Category FROM_MEEGO_DEFAULT = null;
        public static final Category MY_RECORDS = null;
        public static final Category OWNED_TASKS = null;
        public static final Category SAVED_SEARCH_TASKS = null;
        public static final Category TASK_LIST = null;
        public static final Category TODAY = null;
        public static final Category UNKNOWN = null;
        private final int value;

        static {
            Category r0 = new Category("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Category r1 = new Category("OWNED_TASKS", 1, 1);
            OWNED_TASKS = r1;
            Category r3 = new Category("FOLLOWED_TASKS", 2, 2);
            FOLLOWED_TASKS = r3;
            Category r5 = new Category("SAVED_SEARCH_TASKS", 3, 3);
            SAVED_SEARCH_TASKS = r5;
            Category r7 = new Category("TASK_LIST", 4, 4);
            TASK_LIST = r7;
            Category r9 = new Category("FROM_MEEGO_DEFAULT", 5, 5);
            FROM_MEEGO_DEFAULT = r9;
            Category r11 = new Category("TODAY", 6, 6);
            TODAY = r11;
            Category r13 = new Category("MY_RECORDS", 7, 7);
            MY_RECORDS = r13;
            $VALUES = new Category[]{r0, r1, r3, r5, r7, r9, r11, r13};
            ADAPTER = ProtoAdapter.newEnumAdapter(Category.class);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Category fromValue(int r0) {
            switch(r0) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MY_RECORDS;
        L8:
            return TODAY;
        L10:
            return FROM_MEEGO_DEFAULT;
        L12:
            return TASK_LIST;
        L14:
            return SAVED_SEARCH_TASKS;
        L16:
            return FOLLOWED_TASKS;
        L18:
            return OWNED_TASKS;
        L20:
            return UNKNOWN;
        }

        public static Category valueOf(String r1) {
            return (Category) a.a(Category.class, r1);
        }

        private Category(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class MeegoOrigin extends Message<MeegoOrigin, Builder> {
        public static final ProtoAdapter<MeegoOrigin> ADAPTER = null;
        public static final Boolean DEFAULT_SYNC_FROM_MEEGO = null;
        public static final String DEFAULT_WORK_FLOW_NODE_KEY = "";
        public static final String DEFAULT_WORK_FLOW_NODE_NAME = "";
        public static final String DEFAULT_WORK_FLOW_NODE_STATUS = "";
        public static final String DEFAULT_WORK_ITEM_ICON_COLOR = "";
        public static final String DEFAULT_WORK_ITEM_ICON_KEY = "";
        public static final Long DEFAULT_WORK_ITEM_ID = null;
        public static final String DEFAULT_WORK_ITEM_NAME = "";
        private static final long serialVersionUID = 0;
        public final Boolean msync_from_meego;
        public final String mwork_flow_node_key;
        public final String mwork_flow_node_name;
        public final String mwork_flow_node_status;
        public final String mwork_item_icon_color;
        public final String mwork_item_icon_key;
        public final Long mwork_item_id;
        public final String mwork_item_name;

        public static final class Builder extends Message.Builder<MeegoOrigin, Builder> {
            public Boolean msync_from_meego;
            public String mwork_flow_node_key;
            public String mwork_flow_node_name;
            public String mwork_flow_node_status;
            public String mwork_item_icon_color;
            public String mwork_item_icon_key;
            public Long mwork_item_id;
            public String mwork_item_name;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MeegoOrigin m2335build() {
                return new MeegoOrigin(this.msync_from_meego, this.mwork_item_id, this.mwork_item_name, this.mwork_item_icon_key, this.mwork_item_icon_color, this.mwork_flow_node_key, this.mwork_flow_node_name, this.mwork_flow_node_status, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2335build();
            }

            public Builder sync_from_meego(Boolean r1) {
                this.msync_from_meego = r1;
                return this;
            }

            public Builder work_flow_node_key(String r1) {
                this.mwork_flow_node_key = r1;
                return this;
            }

            public Builder work_flow_node_name(String r1) {
                this.mwork_flow_node_name = r1;
                return this;
            }

            public Builder work_flow_node_status(String r1) {
                this.mwork_flow_node_status = r1;
                return this;
            }

            public Builder work_item_icon_color(String r1) {
                this.mwork_item_icon_color = r1;
                return this;
            }

            public Builder work_item_icon_key(String r1) {
                this.mwork_item_icon_key = r1;
                return this;
            }

            public Builder work_item_id(Long r1) {
                this.mwork_item_id = r1;
                return this;
            }

            public Builder work_item_name(String r1) {
                this.mwork_item_name = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MeegoOrigin extends ProtoAdapter<MeegoOrigin> {
            public ProtoAdapter_MeegoOrigin() {
                super(FieldEncoding.LENGTH_DELIMITED, MeegoOrigin.class);
            }

            public MeegoOrigin decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.msync_from_meego = Boolean.FALSE;
                r0.mwork_item_id = 0L;
                r0.mwork_item_name = "";
                r0.mwork_item_icon_key = "";
                r0.mwork_item_icon_color = "";
                r0.mwork_flow_node_key = "";
                r0.mwork_flow_node_name = "";
                r0.mwork_flow_node_status = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                switch(r3) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mwork_flow_node_status = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.mwork_flow_node_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                r0.mwork_flow_node_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.mwork_item_icon_color = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.mwork_item_icon_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                r0.mwork_item_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                r0.mwork_item_id = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L14:
                r0.msync_from_meego = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m2335build();
            }

            public int encodedSize(MeegoOrigin r6) {
                Boolean r0 = r6.msync_from_meego;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Long r3 = r6.mwork_item_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mwork_item_name;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mwork_item_icon_key;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.mwork_item_icon_color;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.mwork_flow_node_key;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                String r19 = r6.mwork_flow_node_name;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                String r22 = r6.mwork_flow_node_status;
                if (r22 == null) goto L34;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
            L34:
                return (r21 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m2336decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MeegoOrigin) r1);
            }

            public void encode(ProtoWriter r4, MeegoOrigin r5) throws IOException {
                Boolean r0 = r5.msync_from_meego;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Long r1 = r5.mwork_item_id;
                if (r1 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mwork_item_name;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mwork_item_icon_key;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.mwork_item_icon_color;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.mwork_flow_node_key;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                String r8 = r5.mwork_flow_node_name;
                if (r8 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
            L23:
                String r9 = r5.mwork_flow_node_status;
                if (r9 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
            L26:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MeegoOrigin) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MeegoOrigin();
            DEFAULT_SYNC_FROM_MEEGO = Boolean.FALSE;
            DEFAULT_WORK_ITEM_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2334newBuilder() {
            Builder r0 = new Builder();
            r0.msync_from_meego = this.msync_from_meego;
            r0.mwork_item_id = this.mwork_item_id;
            r0.mwork_item_name = this.mwork_item_name;
            r0.mwork_item_icon_key = this.mwork_item_icon_key;
            r0.mwork_item_icon_color = this.mwork_item_icon_color;
            r0.mwork_flow_node_key = this.mwork_flow_node_key;
            r0.mwork_flow_node_name = this.mwork_flow_node_name;
            r0.mwork_flow_node_status = this.mwork_flow_node_status;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MeegoOrigin.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2334newBuilder();
        }

        public MeegoOrigin(Boolean r11, Long r12, String r13, String r14, String r15, String r16, String r17, String r18) {
            this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
        }

        public MeegoOrigin(Boolean r2, Long r3, String r4, String r5, String r6, String r7, String r8, String r9, ByteString r10) {
            super(ADAPTER, r10);
            this.msync_from_meego = r2;
            this.mwork_item_id = r3;
            this.mwork_item_name = r4;
            this.mwork_item_icon_key = r5;
            this.mwork_item_icon_color = r6;
            this.mwork_flow_node_key = r7;
            this.mwork_flow_node_name = r8;
            this.mwork_flow_node_status = r9;
        }
    }

    public static final class ProtoAdapter_TaskContainer extends ProtoAdapter<TaskContainer> {
        public ProtoAdapter_TaskContainer() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainer.class);
        }

        public TaskContainer decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mguid = "";
            r0.muser_id = 0L;
            r0.mkey = "";
            r0.mname = "";
            r0.mrank = "";
            r0.mis_not_mine = Boolean.FALSE;
            r0.mcurrent_user_join_milli_time = 0L;
            r0.mowner_id = 0L;
            r0.marchived_milli_time = 0L;
            r0.marchived_user_id = 0L;
            r0.mbase_token = "";
            r0.mbase_table_token = "";
            r0.mdashboard_id = "";
            r0.mdashboard_creator_id = 0L;
            r0.mversion = 0L;
            r0.mdelete_milli_time = 0L;
            r0.mcreate_milli_time = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L37;
            switch(r3) {
                case 1: goto L36;
                case 2: goto L39;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L18;
                case 17: goto L17;
                default: goto L6;
            };
        L39:
            r0.mcategory = (Category) Category.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            r0.mdashboard_creator_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L18:
            r0.mdashboard_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.mbase_table_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L20:
            r0.mbase_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.miconInfo = (IconInfo) IconInfo.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.marchived_user_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L23:
            r0.marchived_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L24:
            r0.mowner_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L25:
            r0.mcurrent_user_join_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L26:
            r0.mcurrent_user_permission = (TaskContainerPermission) TaskContainerPermission.ADAPTER.decode(r9);
            goto L3
        L27:
            r0.mis_not_mine = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L28:
            r0.mrank = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L29:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L30:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L31:
            r0.muser_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L36:
            r0.mguid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            switch(r3) {
                case 100: goto L16;
                case 101: goto L15;
                case 102: goto L14;
                case 103: goto L13;
                case 104: goto L41;
                case 105: goto L8;
                default: goto L7;
            };
        L41:
            r0.magent_category = (AgentCategory) AgentCategory.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r0.magent_origin = (AgentInfo) AgentInfo.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mmeego_origin = (MeegoOrigin) MeegoOrigin.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mcreate_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            r0.mdelete_milli_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L16:
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L37:
            r9.endMessage(r1);
            return r0.m2333build();
        }

        public int encodedSize(TaskContainer r6) {
            String r0 = r6.mguid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Category r3 = r6.mcategory;
            if (r3 == null) goto L9;
            int r4 = Category.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.muser_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mkey;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mname;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mrank;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mis_not_mine;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            TaskContainerPermission r22 = r6.mcurrent_user_permission;
            if (r22 == null) goto L33;
            int r23 = TaskContainerPermission.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            Long r25 = r6.mcurrent_user_join_milli_time;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.INT64.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            Long r28 = r6.mowner_id;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.INT64.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            Long r31 = r6.marchived_milli_time;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.INT64.encodedSizeWithTag(11, r31);
        L46:
            int r33 = r30 + r32;
            Long r34 = r6.marchived_user_id;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.INT64.encodedSizeWithTag(12, r34);
        L50:
            int r36 = r33 + r35;
            IconInfo r37 = r6.miconInfo;
            if (r37 == null) goto L53;
            int r38 = IconInfo.ADAPTER.encodedSizeWithTag(13, r37);
        L54:
            int r39 = r36 + r38;
            String r40 = r6.mbase_token;
            if (r40 == null) goto L57;
            int r41 = ProtoAdapter.STRING.encodedSizeWithTag(14, r40);
        L58:
            int r42 = r39 + r41;
            String r43 = r6.mbase_table_token;
            if (r43 == null) goto L61;
            int r44 = ProtoAdapter.STRING.encodedSizeWithTag(15, r43);
        L62:
            int r45 = r42 + r44;
            String r46 = r6.mdashboard_id;
            if (r46 == null) goto L65;
            int r47 = ProtoAdapter.STRING.encodedSizeWithTag(16, r46);
        L66:
            int r48 = r45 + r47;
            Long r49 = r6.mdashboard_creator_id;
            if (r49 == null) goto L69;
            int r50 = ProtoAdapter.INT64.encodedSizeWithTag(17, r49);
        L70:
            int r51 = r48 + r50;
            Long r52 = r6.mversion;
            if (r52 == null) goto L73;
            int r53 = ProtoAdapter.INT64.encodedSizeWithTag(100, r52);
        L74:
            int r54 = r51 + r53;
            Long r55 = r6.mdelete_milli_time;
            if (r55 == null) goto L77;
            int r56 = ProtoAdapter.INT64.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r55);
        L78:
            int r57 = r54 + r56;
            Long r58 = r6.mcreate_milli_time;
            if (r58 == null) goto L81;
            int r59 = ProtoAdapter.INT64.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r58);
        L82:
            int r60 = r57 + r59;
            MeegoOrigin r61 = r6.mmeego_origin;
            if (r61 == null) goto L85;
            int r62 = MeegoOrigin.ADAPTER.encodedSizeWithTag(103, r61);
        L86:
            int r63 = r60 + r62;
            AgentCategory r64 = r6.magent_category;
            if (r64 == null) goto L89;
            int r65 = AgentCategory.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_ALIAS_AND_MEMO, r64);
        L90:
            int r66 = r63 + r65;
            AgentInfo r67 = r6.magent_origin;
            if (r67 == null) goto L94;
            r1 = AgentInfo.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_MEMO_DESCRIPTION, r67);
        L94:
            return (r66 + r1) + r6.unknownFields().size();
        L89:
            r65 = 0;
            goto L90
        L85:
            r62 = 0;
            goto L86
        L81:
            r59 = 0;
            goto L82
        L77:
            r56 = 0;
            goto L78
        L73:
            r53 = 0;
            goto L74
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
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
        public /* bridge */ /* synthetic */ Object m2337decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskContainer) r1);
        }

        public void encode(ProtoWriter r4, TaskContainer r5) throws IOException {
            String r0 = r5.mguid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Category r1 = r5.mcategory;
            if (r1 == null) goto L8;
            Category.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.muser_id;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mkey;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mname;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mrank;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mis_not_mine;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            TaskContainerPermission r9 = r5.mcurrent_user_permission;
            if (r9 == null) goto L26;
            TaskContainerPermission.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            Long r10 = r5.mcurrent_user_join_milli_time;
            if (r10 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r4, 9, r10);
        L29:
            Long r11 = r5.mowner_id;
            if (r11 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r4, 10, r11);
        L32:
            Long r12 = r5.marchived_milli_time;
            if (r12 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r4, 11, r12);
        L35:
            Long r13 = r5.marchived_user_id;
            if (r13 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r4, 12, r13);
        L38:
            IconInfo r14 = r5.miconInfo;
            if (r14 == null) goto L41;
            IconInfo.ADAPTER.encodeWithTag(r4, 13, r14);
        L41:
            String r15 = r5.mbase_token;
            if (r15 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r4, 14, r15);
        L44:
            String r16 = r5.mbase_table_token;
            if (r16 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r4, 15, r16);
        L47:
            String r17 = r5.mdashboard_id;
            if (r17 == null) goto L50;
            ProtoAdapter.STRING.encodeWithTag(r4, 16, r17);
        L50:
            Long r18 = r5.mdashboard_creator_id;
            if (r18 == null) goto L53;
            ProtoAdapter.INT64.encodeWithTag(r4, 17, r18);
        L53:
            Long r19 = r5.mversion;
            if (r19 == null) goto L56;
            ProtoAdapter.INT64.encodeWithTag(r4, 100, r19);
        L56:
            Long r20 = r5.mdelete_milli_time;
            if (r20 == null) goto L59;
            ProtoAdapter.INT64.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r20);
        L59:
            Long r21 = r5.mcreate_milli_time;
            if (r21 == null) goto L62;
            ProtoAdapter.INT64.encodeWithTag(r4, BaseField.FIELD_TYPE_S_FRIEND_LINK, r21);
        L62:
            MeegoOrigin r22 = r5.mmeego_origin;
            if (r22 == null) goto L65;
            MeegoOrigin.ADAPTER.encodeWithTag(r4, 103, r22);
        L65:
            AgentCategory r23 = r5.magent_category;
            if (r23 == null) goto L68;
            AgentCategory.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_ALIAS_AND_MEMO, r23);
        L68:
            AgentInfo r24 = r5.magent_origin;
            if (r24 == null) goto L71;
            AgentInfo.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_MEMO_DESCRIPTION, r24);
        L71:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskContainer) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainer();
        DEFAULT_USER_ID = 0L;
        DEFAULT_IS_NOT_MINE = Boolean.FALSE;
        DEFAULT_CURRENT_USER_JOIN_MILLI_TIME = 0L;
        DEFAULT_OWNER_ID = 0L;
        DEFAULT_ARCHIVED_MILLI_TIME = 0L;
        DEFAULT_ARCHIVED_USER_ID = 0L;
        DEFAULT_DASHBOARD_CREATOR_ID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_DELETE_MILLI_TIME = 0L;
        DEFAULT_CREATE_MILLI_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2332newBuilder() {
        Builder r0 = new Builder();
        r0.mguid = this.mguid;
        r0.mcategory = this.mcategory;
        r0.muser_id = this.muser_id;
        r0.mkey = this.mkey;
        r0.mname = this.mname;
        r0.mrank = this.mrank;
        r0.mis_not_mine = this.mis_not_mine;
        r0.mcurrent_user_permission = this.mcurrent_user_permission;
        r0.mcurrent_user_join_milli_time = this.mcurrent_user_join_milli_time;
        r0.mowner_id = this.mowner_id;
        r0.marchived_milli_time = this.marchived_milli_time;
        r0.marchived_user_id = this.marchived_user_id;
        r0.miconInfo = this.miconInfo;
        r0.mbase_token = this.mbase_token;
        r0.mbase_table_token = this.mbase_table_token;
        r0.mdashboard_id = this.mdashboard_id;
        r0.mdashboard_creator_id = this.mdashboard_creator_id;
        r0.mversion = this.mversion;
        r0.mdelete_milli_time = this.mdelete_milli_time;
        r0.mcreate_milli_time = this.mcreate_milli_time;
        r0.mmeego_origin = this.mmeego_origin;
        r0.magent_category = this.magent_category;
        r0.magent_origin = this.magent_origin;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskContainer.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2332newBuilder();
    }

    public TaskContainer(String r26, Category r27, Long r28, String r29, String r30, String r31, Boolean r32, TaskContainerPermission r33, Long r34, Long r35, Long r36, Long r37, IconInfo r38, String r39, String r40, String r41, Long r42, Long r43, Long r44, Long r45, MeegoOrigin r46, AgentCategory r47, AgentInfo r48) {
        this(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, ByteString.EMPTY);
    }

    public TaskContainer(String r4, Category r5, Long r6, String r7, String r8, String r9, Boolean r10, TaskContainerPermission r11, Long r12, Long r13, Long r14, Long r15, IconInfo r16, String r17, String r18, String r19, Long r20, Long r21, Long r22, Long r23, MeegoOrigin r24, AgentCategory r25, AgentInfo r26, ByteString r27) {
        super(ADAPTER, r27);
        this.mguid = r4;
        this.mcategory = r5;
        this.muser_id = r6;
        this.mkey = r7;
        this.mname = r8;
        this.mrank = r9;
        this.mis_not_mine = r10;
        this.mcurrent_user_permission = r11;
        this.mcurrent_user_join_milli_time = r12;
        this.mowner_id = r13;
        this.marchived_milli_time = r14;
        this.marchived_user_id = r15;
        this.miconInfo = r16;
        this.mbase_token = r17;
        this.mbase_table_token = r18;
        this.mdashboard_id = r19;
        this.mdashboard_creator_id = r20;
        this.mversion = r21;
        this.mdelete_milli_time = r22;
        this.mcreate_milli_time = r23;
        this.mmeego_origin = r24;
        this.magent_category = r25;
        this.magent_origin = r26;
    }
}
