package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GroupedManagedDepartments extends Message<GroupedManagedDepartments, Builder> {
    public static final ProtoAdapter<GroupedManagedDepartments> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Group> mgroups;

    public static final class Builder extends Message.Builder<GroupedManagedDepartments, Builder> {
        public List<Group> mgroups;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GroupedManagedDepartments m2987build() {
            return new GroupedManagedDepartments(this.mgroups, super.buildUnknownFields());
        }

        public Builder() {
            this.mgroups = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2987build();
        }

        public Builder groups(List<Group> r1) {
            Internal.checkElementsNotNull(r1);
            this.mgroups = r1;
            return this;
        }
    }

    public static final class DepartmentInfo extends Message<DepartmentInfo, Builder> {
        public static final ProtoAdapter<DepartmentInfo> ADAPTER = null;
        public static final String DEFAULT_CODE = "";
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_LARK_ID = "";
        private static final long serialVersionUID = 0;
        public final String mcode;
        public final String mid;
        public final String mlark_id;
        public final I18nVal mname;

        public static final class Builder extends Message.Builder<DepartmentInfo, Builder> {
            public String mcode;
            public String mid;
            public String mlark_id;
            public I18nVal mname;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DepartmentInfo m2989build() {
                return new DepartmentInfo(this.mid, this.mname, this.mlark_id, this.mcode, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2989build();
            }

            public Builder code(String r1) {
                this.mcode = r1;
                return this;
            }

            public Builder id(String r1) {
                this.mid = r1;
                return this;
            }

            public Builder lark_id(String r1) {
                this.mlark_id = r1;
                return this;
            }

            public Builder name(I18nVal r1) {
                this.mname = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DepartmentInfo extends ProtoAdapter<DepartmentInfo> {
            public ProtoAdapter_DepartmentInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DepartmentInfo.class);
            }

            public DepartmentInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mid = "";
                r0.mlark_id = "";
                r0.mcode = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mid = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mname = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mlark_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mcode = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m2989build();
            }

            public int encodedSize(DepartmentInfo r6) {
                String r0 = r6.mid;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                I18nVal r3 = r6.mname;
                if (r3 == null) goto L9;
                int r4 = I18nVal.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mlark_id;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mcode;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                return (r9 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m2990decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DepartmentInfo) r1);
            }

            public void encode(ProtoWriter r4, DepartmentInfo r5) throws IOException {
                String r0 = r5.mid;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                I18nVal r1 = r5.mname;
                if (r1 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mlark_id;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mcode;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DepartmentInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DepartmentInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2988newBuilder() {
            Builder r0 = new Builder();
            r0.mid = this.mid;
            r0.mname = this.mname;
            r0.mlark_id = this.mlark_id;
            r0.mcode = this.mcode;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DepartmentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2988newBuilder();
        }

        public DepartmentInfo(String r7, I18nVal r8, String r9, String r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public DepartmentInfo(String r2, I18nVal r3, String r4, String r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mid = r2;
            this.mname = r3;
            this.mlark_id = r4;
            this.mcode = r5;
        }
    }

    public static final class Group extends Message<Group, Builder> {
        public static final ProtoAdapter<Group> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Item> mitems;
        public final SourceType msource_type;
        public final VisibilityType mvisibility_type;

        public static final class Builder extends Message.Builder<Group, Builder> {
            public List<Item> mitems;
            public SourceType msource_type;
            public VisibilityType mvisibility_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Group m2992build() {
                return new Group(this.msource_type, this.mvisibility_type, this.mitems, super.buildUnknownFields());
            }

            public Builder() {
                this.mitems = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2992build();
            }

            public Builder items(List<Item> r1) {
                Internal.checkElementsNotNull(r1);
                this.mitems = r1;
                return this;
            }

            public Builder source_type(SourceType r1) {
                this.msource_type = r1;
                return this;
            }

            public Builder visibility_type(VisibilityType r1) {
                this.mvisibility_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Group extends ProtoAdapter<Group> {
            public ProtoAdapter_Group() {
                super(FieldEncoding.LENGTH_DELIMITED, Group.class);
            }

            public Group decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.msource_type = (SourceType) SourceType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mvisibility_type = (VisibilityType) VisibilityType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mitems.add((Item) Item.ADAPTER.decode(r9));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m2992build();
            }

            public int encodedSize(Group r5) {
                SourceType r0 = r5.msource_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = SourceType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                VisibilityType r3 = r5.mvisibility_type;
                if (r3 == null) goto L10;
                r1 = VisibilityType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return ((r2 + r1) + Item.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mitems)) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2993decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Group) r1);
            }

            public void encode(ProtoWriter r4, Group r5) throws IOException {
                SourceType r0 = r5.msource_type;
                if (r0 == null) goto L5;
                SourceType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                VisibilityType r1 = r5.mvisibility_type;
                if (r1 == null) goto L8;
                VisibilityType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Item.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mitems);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Group) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Group();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2991newBuilder() {
            Builder r0 = new Builder();
            r0.msource_type = this.msource_type;
            r0.mvisibility_type = this.mvisibility_type;
            r0.mitems = Internal.copyOf("mitems", this.mitems);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Group.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2991newBuilder();
        }

        public Group(SourceType r2, VisibilityType r3, List<Item> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Group(SourceType r2, VisibilityType r3, List<Item> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.msource_type = r2;
            this.mvisibility_type = r3;
            this.mitems = Internal.immutableCopyOf("mitems", r4);
        }
    }

    public static final class Item extends Message<Item, Builder> {
        public static final ProtoAdapter<Item> ADAPTER = null;
        public static final Boolean DEFAULT_ACCESSIBLE = null;
        public static final String DEFAULT_MANAGER_ID = "";
        public static final String DEFAULT_REDIRECT_LINK = "";
        private static final long serialVersionUID = 0;
        public final Boolean maccessible;
        public final DepartmentInfo mdepartment;
        public final String mmanager_id;
        public final String mredirect_link;

        public static final class Builder extends Message.Builder<Item, Builder> {
            public Boolean maccessible;
            public DepartmentInfo mdepartment;
            public String mmanager_id;
            public String mredirect_link;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Item m2995build() {
                return new Item(this.mdepartment, this.maccessible, this.mredirect_link, this.mmanager_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2995build();
            }

            public Builder accessible(Boolean r1) {
                this.maccessible = r1;
                return this;
            }

            public Builder department(DepartmentInfo r1) {
                this.mdepartment = r1;
                return this;
            }

            public Builder manager_id(String r1) {
                this.mmanager_id = r1;
                return this;
            }

            public Builder redirect_link(String r1) {
                this.mredirect_link = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
            public ProtoAdapter_Item() {
                super(FieldEncoding.LENGTH_DELIMITED, Item.class);
            }

            public Item decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.maccessible = Boolean.FALSE;
                r0.mredirect_link = "";
                r0.mmanager_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mdepartment = (DepartmentInfo) DepartmentInfo.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.maccessible = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mredirect_link = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mmanager_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m2995build();
            }

            public int encodedSize(Item r6) {
                DepartmentInfo r0 = r6.mdepartment;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = DepartmentInfo.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.maccessible;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mredirect_link;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mmanager_id;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                return (r9 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m2996decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Item) r1);
            }

            public void encode(ProtoWriter r4, Item r5) throws IOException {
                DepartmentInfo r0 = r5.mdepartment;
                if (r0 == null) goto L5;
                DepartmentInfo.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.maccessible;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mredirect_link;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mmanager_id;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Item) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Item();
            DEFAULT_ACCESSIBLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2994newBuilder() {
            Builder r0 = new Builder();
            r0.mdepartment = this.mdepartment;
            r0.maccessible = this.maccessible;
            r0.mredirect_link = this.mredirect_link;
            r0.mmanager_id = this.mmanager_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Item.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2994newBuilder();
        }

        public Item(DepartmentInfo r7, Boolean r8, String r9, String r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public Item(DepartmentInfo r2, Boolean r3, String r4, String r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mdepartment = r2;
            this.maccessible = r3;
            this.mredirect_link = r4;
            this.mmanager_id = r5;
        }
    }

    public static final class ProtoAdapter_GroupedManagedDepartments extends ProtoAdapter<GroupedManagedDepartments> {
        public ProtoAdapter_GroupedManagedDepartments() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupedManagedDepartments.class);
        }

        public GroupedManagedDepartments decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mgroups.add((Group) Group.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2987build();
        }

        public int encodedSize(GroupedManagedDepartments r4) {
            return Group.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mgroups) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2997decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GroupedManagedDepartments) r1);
        }

        public void encode(ProtoWriter r4, GroupedManagedDepartments r5) throws IOException {
            Group.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mgroups);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GroupedManagedDepartments) r2);
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType OTHER_MANAGED = null;
        public static final SourceType SELF_MANAGED = null;
        public static final SourceType SOURCE_TYPE_UNKNOWN = null;
        public static final SourceType SUBORDINATE_MANAGED = null;
        private final int value;

        static {
            SourceType r0 = new SourceType("SOURCE_TYPE_UNKNOWN", 0, 0);
            SOURCE_TYPE_UNKNOWN = r0;
            SourceType r1 = new SourceType("SELF_MANAGED", 1, 1);
            SELF_MANAGED = r1;
            SourceType r3 = new SourceType("SUBORDINATE_MANAGED", 2, 2);
            SUBORDINATE_MANAGED = r3;
            SourceType r5 = new SourceType("OTHER_MANAGED", 3, 3);
            OTHER_MANAGED = r5;
            $VALUES = new SourceType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return OTHER_MANAGED;
        L14:
            return SUBORDINATE_MANAGED;
        L16:
            return SELF_MANAGED;
        L18:
            return SOURCE_TYPE_UNKNOWN;
        }

        public static SourceType valueOf(String r1) {
            return (SourceType) a.a(SourceType.class, r1);
        }

        private SourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum VisibilityType extends Enum<VisibilityType> implements WireEnum {
        private static final /* synthetic */ VisibilityType[] $VALUES = null;
        public static final ProtoAdapter<VisibilityType> ADAPTER = null;
        public static final VisibilityType EXTERNAL_HIDDEN = null;
        public static final VisibilityType EXTERNAL_VISIBLE = null;
        public static final VisibilityType VISIBILITY_TYPE_UNKNOWN = null;
        private final int value;

        static {
            VisibilityType r0 = new VisibilityType("VISIBILITY_TYPE_UNKNOWN", 0, 0);
            VISIBILITY_TYPE_UNKNOWN = r0;
            VisibilityType r1 = new VisibilityType("EXTERNAL_VISIBLE", 1, 1);
            EXTERNAL_VISIBLE = r1;
            VisibilityType r3 = new VisibilityType("EXTERNAL_HIDDEN", 2, 2);
            EXTERNAL_HIDDEN = r3;
            $VALUES = new VisibilityType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(VisibilityType.class);
        }

        public static VisibilityType[] values() {
            return (VisibilityType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static VisibilityType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return EXTERNAL_HIDDEN;
        L12:
            return EXTERNAL_VISIBLE;
        L14:
            return VISIBILITY_TYPE_UNKNOWN;
        }

        public static VisibilityType valueOf(String r1) {
            return (VisibilityType) a.a(VisibilityType.class, r1);
        }

        private VisibilityType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupedManagedDepartments();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2986newBuilder() {
        Builder r0 = new Builder();
        r0.mgroups = Internal.copyOf("mgroups", this.mgroups);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GroupedManagedDepartments.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2986newBuilder();
    }

    public GroupedManagedDepartments(List<Group> r2) {
        this(r2, ByteString.EMPTY);
    }

    public GroupedManagedDepartments(List<Group> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mgroups = Internal.immutableCopyOf("mgroups", r2);
    }
}
