package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BuildResource extends Message<BuildResource, Builder> {
    public static final ProtoAdapter<BuildResource> ADAPTER = null;
    public static final String DEFAULT_RESOURCE_URL = "";
    public static final String DEFAULT_TASK_ID = "";
    private static final long serialVersionUID = 0;
    public final Platform mplatform;
    public final String mresource_url;
    public final String mtask_id;

    public static final class Builder extends Message.Builder<BuildResource, Builder> {
        public Platform mplatform;
        public String mresource_url;
        public String mtask_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BuildResource m2402build() {
            String r0 = this.mresource_url;
            if (r0 == null) goto L11;
            if (this.mtask_id == null) goto L11;
            if (this.mplatform == null) goto L11;
            return new BuildResource(this.mresource_url, this.mtask_id, this.mplatform, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mresource_url", this.mtask_id, "mtask_id", this.mplatform, "mplatform"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2402build();
        }

        public Builder platform(Platform r1) {
            this.mplatform = r1;
            return this;
        }

        public Builder resource_url(String r1) {
            this.mresource_url = r1;
            return this;
        }

        public Builder task_id(String r1) {
            this.mtask_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BuildResource extends ProtoAdapter<BuildResource> {
        public ProtoAdapter_BuildResource() {
            super(FieldEncoding.LENGTH_DELIMITED, BuildResource.class);
        }

        public BuildResource decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mresource_url = "";
            r0.mtask_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mresource_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtask_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mplatform = (Platform) Platform.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2402build();
        }

        public int encodedSize(BuildResource r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return ((r0.encodedSizeWithTag(1, r5.mresource_url) + r0.encodedSizeWithTag(2, r5.mtask_id)) + Platform.ADAPTER.encodedSizeWithTag(3, r5.mplatform)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2403decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BuildResource) r1);
        }

        public void encode(ProtoWriter r4, BuildResource r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mresource_url);
            r0.encodeWithTag(r4, 2, r5.mtask_id);
            Platform.ADAPTER.encodeWithTag(r4, 3, r5.mplatform);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BuildResource) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BuildResource();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2401newBuilder() {
        Builder r0 = new Builder();
        r0.mresource_url = this.mresource_url;
        r0.mtask_id = this.mtask_id;
        r0.mplatform = this.mplatform;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BuildResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2401newBuilder();
    }

    public BuildResource(String r2, String r3, Platform r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public BuildResource(String r2, String r3, Platform r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mresource_url = r2;
        this.mtask_id = r3;
        this.mplatform = r4;
    }
}
