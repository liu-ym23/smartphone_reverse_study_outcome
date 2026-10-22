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
public final class ContainerTabs extends Message<ContainerTabs, Builder> {
    public static final ProtoAdapter<ContainerTabs> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_TAB_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mdefault_tab_guid;
    public final List<ContainerTab> mtabs;

    public static final class Builder extends Message.Builder<ContainerTabs, Builder> {
        public String mdefault_tab_guid;
        public List<ContainerTab> mtabs;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ContainerTabs m2276build() {
            return new ContainerTabs(this.mtabs, this.mdefault_tab_guid, super.buildUnknownFields());
        }

        public Builder() {
            this.mtabs = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2276build();
        }

        public Builder default_tab_guid(String r1) {
            this.mdefault_tab_guid = r1;
            return this;
        }

        public Builder tabs(List<ContainerTab> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtabs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerTabs extends ProtoAdapter<ContainerTabs> {
        public ProtoAdapter_ContainerTabs() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerTabs.class);
        }

        public ContainerTabs decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdefault_tab_guid = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtabs.add((ContainerTab) ContainerTab.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mdefault_tab_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2276build();
        }

        public int encodedSize(ContainerTabs r5) {
            int r0 = ContainerTab.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mtabs);
            String r1 = r5.mdefault_tab_guid;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2277decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ContainerTabs) r1);
        }

        public void encode(ProtoWriter r4, ContainerTabs r5) throws IOException {
            ContainerTab.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mtabs);
            String r0 = r5.mdefault_tab_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ContainerTabs) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerTabs();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2275newBuilder() {
        Builder r0 = new Builder();
        r0.mtabs = Internal.copyOf("mtabs", this.mtabs);
        r0.mdefault_tab_guid = this.mdefault_tab_guid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ContainerTabs.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2275newBuilder();
    }

    public ContainerTabs(List<ContainerTab> r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ContainerTabs(List<ContainerTab> r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtabs = Internal.immutableCopyOf("mtabs", r2);
        this.mdefault_tab_guid = r3;
    }
}
