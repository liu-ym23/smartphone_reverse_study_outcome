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
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ContainerTab extends Message<ContainerTab, Builder> {
    public static final ProtoAdapter<ContainerTab> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final DashboardTabMeta mdashboard_tab_meta;
    public final String mguid;
    public final String mname;
    public final Type mtype;
    public final Long mversion;
    public final ViewTabMeta mview_tab_meta;

    public static final class Builder extends Message.Builder<ContainerTab, Builder> {
        public DashboardTabMeta mdashboard_tab_meta;
        public String mguid;
        public String mname;
        public Type mtype;
        public Long mversion;
        public ViewTabMeta mview_tab_meta;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ContainerTab m2267build() {
            return new ContainerTab(this.mguid, this.mtype, this.mname, this.mversion, this.mview_tab_meta, this.mdashboard_tab_meta, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2267build();
        }

        public Builder dashboard_tab_meta(DashboardTabMeta r1) {
            this.mdashboard_tab_meta = r1;
            this.mview_tab_meta = null;
            return this;
        }

        public Builder guid(String r1) {
            this.mguid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
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

        public Builder view_tab_meta(ViewTabMeta r1) {
            this.mview_tab_meta = r1;
            this.mdashboard_tab_meta = null;
            return this;
        }
    }

    public static final class DashboardTabMeta extends Message<DashboardTabMeta, Builder> {
        public static final ProtoAdapter<DashboardTabMeta> ADAPTER = null;
        public static final Long DEFAULT_CREATOR_ID = null;
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final Long mcreator_id;
        public final DashboardStatus mstatus;
        public final String murl;

        public static final class Builder extends Message.Builder<DashboardTabMeta, Builder> {
            public Long mcreator_id;
            public DashboardStatus mstatus;
            public String murl;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DashboardTabMeta m2269build() {
                return new DashboardTabMeta(this.mstatus, this.murl, this.mcreator_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2269build();
            }

            public Builder creator_id(Long r1) {
                this.mcreator_id = r1;
                return this;
            }

            public Builder status(DashboardStatus r1) {
                this.mstatus = r1;
                return this;
            }

            public Builder url(String r1) {
                this.murl = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DashboardTabMeta extends ProtoAdapter<DashboardTabMeta> {
            public ProtoAdapter_DashboardTabMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, DashboardTabMeta.class);
            }

            public DashboardTabMeta decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.murl = "";
                r0.mcreator_id = 0L;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mstatus = (DashboardStatus) DashboardStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.murl = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mcreator_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m2269build();
            }

            public int encodedSize(DashboardTabMeta r6) {
                DashboardStatus r0 = r6.mstatus;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = DashboardStatus.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.murl;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Long r7 = r6.mcreator_id;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2270decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DashboardTabMeta) r1);
            }

            public void encode(ProtoWriter r4, DashboardTabMeta r5) throws IOException {
                DashboardStatus r0 = r5.mstatus;
                if (r0 == null) goto L5;
                DashboardStatus.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.murl;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Long r2 = r5.mcreator_id;
                if (r2 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DashboardTabMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DashboardTabMeta();
            DEFAULT_CREATOR_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2268newBuilder() {
            Builder r0 = new Builder();
            r0.mstatus = this.mstatus;
            r0.murl = this.murl;
            r0.mcreator_id = this.mcreator_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DashboardTabMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2268newBuilder();
        }

        public DashboardTabMeta(DashboardStatus r2, String r3, Long r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public DashboardTabMeta(DashboardStatus r2, String r3, Long r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mstatus = r2;
            this.murl = r3;
            this.mcreator_id = r4;
        }
    }

    public static final class ProtoAdapter_ContainerTab extends ProtoAdapter<ContainerTab> {
        public ProtoAdapter_ContainerTab() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerTab.class);
        }

        public ContainerTab decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mguid = "";
            r0.mname = "";
            r0.mversion = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L22;
            if (r3 != 1) goto L8;
            r0.mguid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            switch(r3) {
                case 100: goto L15;
                case 101: goto L14;
                case 102: goto L13;
                default: goto L12;
            };
        L13:
            r0.dashboard_tab_meta((DashboardTabMeta) DashboardTabMeta.ADAPTER.decode(r9));
            goto L3
        L14:
            r0.view_tab_meta((ViewTabMeta) ViewTabMeta.ADAPTER.decode(r9));
            goto L3
        L15:
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L22:
            r9.endMessage(r1);
            return r0.m2267build();
        }

        public int encodedSize(ContainerTab r6) {
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
            String r7 = r6.mname;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mversion;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(100, r10);
        L18:
            int r12 = r9 + r11;
            ViewTabMeta r13 = r6.mview_tab_meta;
            if (r13 == null) goto L21;
            int r14 = ViewTabMeta.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_PHONE_NUMBER, r13);
        L22:
            int r15 = r12 + r14;
            DashboardTabMeta r16 = r6.mdashboard_tab_meta;
            if (r16 == null) goto L26;
            r1 = DashboardTabMeta.ADAPTER.encodedSizeWithTag(BaseField.FIELD_TYPE_S_FRIEND_LINK, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2271decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ContainerTab) r1);
        }

        public void encode(ProtoWriter r4, ContainerTab r5) throws IOException {
            String r0 = r5.mguid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Type r1 = r5.mtype;
            if (r1 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mname;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mversion;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 100, r3);
        L14:
            ViewTabMeta r6 = r5.mview_tab_meta;
            if (r6 == null) goto L17;
            ViewTabMeta.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_S_PHONE_NUMBER, r6);
        L17:
            DashboardTabMeta r7 = r5.mdashboard_tab_meta;
            if (r7 == null) goto L20;
            DashboardTabMeta.ADAPTER.encodeWithTag(r4, BaseField.FIELD_TYPE_S_FRIEND_LINK, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ContainerTab) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ACTIVITY_RECORD = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type DASHBOARD = null;
        public static final Type UNKNOWN = null;
        public static final Type VIEW = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("VIEW", 1, 1);
            VIEW = r1;
            Type r3 = new Type("ACTIVITY_RECORD", 2, 2);
            ACTIVITY_RECORD = r3;
            Type r5 = new Type("DASHBOARD", 3, 3);
            DASHBOARD = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return DASHBOARD;
        L14:
            return ACTIVITY_RECORD;
        L16:
            return VIEW;
        L18:
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

    public static final class ViewTabMeta extends Message<ViewTabMeta, Builder> {
        public static final ProtoAdapter<ViewTabMeta> ADAPTER = null;
        public static final String DEFAULT_VIEW_GUID = "";
        private static final long serialVersionUID = 0;
        public final String mview_guid;

        public static final class Builder extends Message.Builder<ViewTabMeta, Builder> {
            public String mview_guid;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ViewTabMeta m2273build() {
                return new ViewTabMeta(this.mview_guid, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2273build();
            }

            public Builder view_guid(String r1) {
                this.mview_guid = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ViewTabMeta extends ProtoAdapter<ViewTabMeta> {
            public ProtoAdapter_ViewTabMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, ViewTabMeta.class);
            }

            public ViewTabMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mview_guid = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mview_guid = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2273build();
            }

            public int encodedSize(ViewTabMeta r4) {
                String r0 = r4.mview_guid;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2274decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ViewTabMeta) r1);
            }

            public void encode(ProtoWriter r4, ViewTabMeta r5) throws IOException {
                String r0 = r5.mview_guid;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ViewTabMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ViewTabMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2272newBuilder() {
            Builder r0 = new Builder();
            r0.mview_guid = this.mview_guid;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ViewTabMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2272newBuilder();
        }

        public ViewTabMeta(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public ViewTabMeta(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mview_guid = r2;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerTab();
        DEFAULT_VERSION = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2266newBuilder() {
        Builder r0 = new Builder();
        r0.mguid = this.mguid;
        r0.mtype = this.mtype;
        r0.mname = this.mname;
        r0.mversion = this.mversion;
        r0.mview_tab_meta = this.mview_tab_meta;
        r0.mdashboard_tab_meta = this.mdashboard_tab_meta;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ContainerTab.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2266newBuilder();
    }

    public ContainerTab(String r9, Type r10, String r11, Long r12, ViewTabMeta r13, DashboardTabMeta r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public ContainerTab(String r2, Type r3, String r4, Long r5, ViewTabMeta r6, DashboardTabMeta r7, ByteString r8) {
        super(ADAPTER, r8);
        if (Internal.countNonNull(r6, r7) > 1) goto L7;
        this.mguid = r2;
        this.mtype = r3;
        this.mname = r4;
        this.mversion = r5;
        this.mview_tab_meta = r6;
        this.mdashboard_tab_meta = r7;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mview_tab_meta, mdashboard_tab_meta may be non-null");
    }
}
