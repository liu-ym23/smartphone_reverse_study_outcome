package com.ss.android.lark.pb.todo_entities;

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
public final class ContainerMetaData extends Message<ContainerMetaData, Builder> {
    public static final ProtoAdapter<ContainerMetaData> ADAPTER = null;
    public static final Boolean DEFAULT_ASYNC_LOAD = null;
    private static final long serialVersionUID = 0;
    public final List<TaskField> mall_fields;
    public final Boolean masync_load;
    public final TaskContainer mcontainer;
    public final ContainerTabs mcontainer_tabs;
    public final List<TaskField> mfields;
    public final List<TaskSection> msections;
    public final List<TaskView> mviews;

    public static final class Builder extends Message.Builder<ContainerMetaData, Builder> {
        public List<TaskField> mall_fields;
        public Boolean masync_load;
        public TaskContainer mcontainer;
        public ContainerTabs mcontainer_tabs;
        public List<TaskField> mfields;
        public List<TaskSection> msections;
        public List<TaskView> mviews;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ContainerMetaData m2264build() {
            return new ContainerMetaData(this.mcontainer, this.mfields, this.msections, this.mviews, this.mall_fields, this.mcontainer_tabs, this.masync_load, super.buildUnknownFields());
        }

        public Builder() {
            this.mfields = Internal.newMutableList();
            this.msections = Internal.newMutableList();
            this.mviews = Internal.newMutableList();
            this.mall_fields = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2264build();
        }

        public Builder all_fields(List<TaskField> r1) {
            Internal.checkElementsNotNull(r1);
            this.mall_fields = r1;
            return this;
        }

        public Builder async_load(Boolean r1) {
            this.masync_load = r1;
            return this;
        }

        public Builder container(TaskContainer r1) {
            this.mcontainer = r1;
            return this;
        }

        public Builder container_tabs(ContainerTabs r1) {
            this.mcontainer_tabs = r1;
            return this;
        }

        public Builder fields(List<TaskField> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfields = r1;
            return this;
        }

        public Builder sections(List<TaskSection> r1) {
            Internal.checkElementsNotNull(r1);
            this.msections = r1;
            return this;
        }

        public Builder views(List<TaskView> r1) {
            Internal.checkElementsNotNull(r1);
            this.mviews = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerMetaData extends ProtoAdapter<ContainerMetaData> {
        public ProtoAdapter_ContainerMetaData() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerMetaData.class);
        }

        public ContainerMetaData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.masync_load = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.masync_load = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mcontainer_tabs = (ContainerTabs) ContainerTabs.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.mall_fields.add((TaskField) TaskField.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.mviews.add((TaskView) TaskView.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.msections.add((TaskSection) TaskSection.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.mfields.add((TaskField) TaskField.ADAPTER.decode(r7));
            goto L3
        L13:
            r0.mcontainer = (TaskContainer) TaskContainer.ADAPTER.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m2264build();
        }

        public int encodedSize(ContainerMetaData r7) {
            TaskContainer r0 = r7.mcontainer;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = TaskContainer.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ProtoAdapter<TaskField> r3 = TaskField.ADAPTER;
            int r4 = (((r2 + r3.asRepeated().encodedSizeWithTag(2, r7.mfields)) + TaskSection.ADAPTER.asRepeated().encodedSizeWithTag(3, r7.msections)) + TaskView.ADAPTER.asRepeated().encodedSizeWithTag(4, r7.mviews)) + r3.asRepeated().encodedSizeWithTag(5, r7.mall_fields);
            ContainerTabs r5 = r7.mcontainer_tabs;
            if (r5 == null) goto L9;
            int r6 = ContainerTabs.ADAPTER.encodedSizeWithTag(6, r5);
        L10:
            int r8 = r4 + r6;
            Boolean r9 = r7.masync_load;
            if (r9 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r9);
        L14:
            return (r8 + r1) + r7.unknownFields().size();
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2265decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ContainerMetaData) r1);
        }

        public void encode(ProtoWriter r5, ContainerMetaData r6) throws IOException {
            TaskContainer r0 = r6.mcontainer;
            if (r0 == null) goto L5;
            TaskContainer.ADAPTER.encodeWithTag(r5, 1, r0);
        L5:
            ProtoAdapter<TaskField> r1 = TaskField.ADAPTER;
            r1.asRepeated().encodeWithTag(r5, 2, r6.mfields);
            TaskSection.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.msections);
            TaskView.ADAPTER.asRepeated().encodeWithTag(r5, 4, r6.mviews);
            r1.asRepeated().encodeWithTag(r5, 5, r6.mall_fields);
            ContainerTabs r2 = r6.mcontainer_tabs;
            if (r2 == null) goto L8;
            ContainerTabs.ADAPTER.encodeWithTag(r5, 6, r2);
        L8:
            Boolean r3 = r6.masync_load;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 7, r3);
        L11:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ContainerMetaData) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerMetaData();
        DEFAULT_ASYNC_LOAD = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2263newBuilder() {
        Builder r0 = new Builder();
        r0.mcontainer = this.mcontainer;
        r0.mfields = Internal.copyOf("mfields", this.mfields);
        r0.msections = Internal.copyOf("msections", this.msections);
        r0.mviews = Internal.copyOf("mviews", this.mviews);
        r0.mall_fields = Internal.copyOf("mall_fields", this.mall_fields);
        r0.mcontainer_tabs = this.mcontainer_tabs;
        r0.masync_load = this.masync_load;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ContainerMetaData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2263newBuilder();
    }

    public ContainerMetaData(TaskContainer r10, List<TaskField> r11, List<TaskSection> r12, List<TaskView> r13, List<TaskField> r14, ContainerTabs r15, Boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ContainerMetaData(TaskContainer r2, List<TaskField> r3, List<TaskSection> r4, List<TaskView> r5, List<TaskField> r6, ContainerTabs r7, Boolean r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mcontainer = r2;
        this.mfields = Internal.immutableCopyOf("mfields", r3);
        this.msections = Internal.immutableCopyOf("msections", r4);
        this.mviews = Internal.immutableCopyOf("mviews", r5);
        this.mall_fields = Internal.immutableCopyOf("mall_fields", r6);
        this.mcontainer_tabs = r7;
        this.masync_load = r8;
    }
}
