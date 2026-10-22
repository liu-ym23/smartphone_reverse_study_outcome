package com.ss.android.lark.pb.security_event;

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
public final class CommonDrawer extends Message<CommonDrawer, Builder> {
    public static final ProtoAdapter<CommonDrawer> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<RenderItem> mItemList;

    public static final class Builder extends Message.Builder<CommonDrawer, Builder> {
        public List<RenderItem> mItemList;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CommonDrawer m2156build() {
            return new CommonDrawer(this.mItemList, super.buildUnknownFields());
        }

        public Builder() {
            this.mItemList = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2156build();
        }

        public Builder ItemList(List<RenderItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mItemList = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CommonDrawer extends ProtoAdapter<CommonDrawer> {
        public ProtoAdapter_CommonDrawer() {
            super(FieldEncoding.LENGTH_DELIMITED, CommonDrawer.class);
        }

        public CommonDrawer decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mItemList.add((RenderItem) RenderItem.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2156build();
        }

        public int encodedSize(CommonDrawer r4) {
            return RenderItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mItemList) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2157decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CommonDrawer) r1);
        }

        public void encode(ProtoWriter r4, CommonDrawer r5) throws IOException {
            RenderItem.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mItemList);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CommonDrawer) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CommonDrawer();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2155newBuilder() {
        Builder r0 = new Builder();
        r0.mItemList = Internal.copyOf("mItemList", this.mItemList);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CommonDrawer.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2155newBuilder();
    }

    public CommonDrawer(List<RenderItem> r2) {
        this(r2, ByteString.EMPTY);
    }

    public CommonDrawer(List<RenderItem> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mItemList = Internal.immutableCopyOf("mItemList", r2);
    }
}
