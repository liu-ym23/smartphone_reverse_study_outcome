package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Extend extends Message<Extend, Builder> {
    public static final ProtoAdapter<Extend> ADAPTER = null;
    public static final Long DEFAULT_CREATEGROUP = null;
    public static final Long DEFAULT_DISMISSGROUP = null;
    private static final long serialVersionUID = 0;
    public final AppDetail mAppDetail;
    public final CommentType mCommentType;
    public final CommonDrawer mCommonDrawer;
    public final Long mCreateGroup;
    public final Long mDismissGroup;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<Extend, Builder> {
        public AppDetail mAppDetail;
        public CommentType mCommentType;
        public CommonDrawer mCommonDrawer;
        public Long mCreateGroup;
        public Long mDismissGroup;
        public Status mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Extend m2174build() {
            return new Extend(this.mCommentType, this.mAppDetail, this.mCreateGroup, this.mDismissGroup, this.mCommonDrawer, this.mstatus, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2174build();
        }

        public Builder AppDetail(AppDetail r1) {
            this.mAppDetail = r1;
            return this;
        }

        public Builder CommentType(CommentType r1) {
            this.mCommentType = r1;
            return this;
        }

        public Builder CommonDrawer(CommonDrawer r1) {
            this.mCommonDrawer = r1;
            return this;
        }

        public Builder CreateGroup(Long r1) {
            this.mCreateGroup = r1;
            return this;
        }

        public Builder DismissGroup(Long r1) {
            this.mDismissGroup = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Extend extends ProtoAdapter<Extend> {
        public ProtoAdapter_Extend() {
            super(FieldEncoding.LENGTH_DELIMITED, Extend.class);
        }

        public Extend decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mCreateGroup = 0L;
            r0.mDismissGroup = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L33;
            if (r3 != 1) goto L8;
            r0.mCommentType = (CommentType) CommentType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mAppDetail = (AppDetail) AppDetail.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mCreateGroup = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mDismissGroup = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L14:
            if (r3 != 100) goto L16;
            r0.mCommonDrawer = (CommonDrawer) CommonDrawer.ADAPTER.decode(r9);
            goto L3
        L16:
            if (r3 != 9000001) goto L17;
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L33:
            r9.endMessage(r1);
            return r0.m2174build();
        }

        public int encodedSize(Extend r6) {
            CommentType r0 = r6.mCommentType;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = CommentType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            AppDetail r3 = r6.mAppDetail;
            if (r3 == null) goto L9;
            int r4 = AppDetail.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.mCreateGroup;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mDismissGroup;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            CommonDrawer r13 = r6.mCommonDrawer;
            if (r13 == null) goto L21;
            int r14 = CommonDrawer.ADAPTER.encodedSizeWithTag(100, r13);
        L22:
            int r15 = r12 + r14;
            Status r16 = r6.mstatus;
            if (r16 == null) goto L26;
            r1 = Status.ADAPTER.encodedSizeWithTag(9000001, r16);
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
        public /* bridge */ /* synthetic */ Object m2175decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Extend) r1);
        }

        public void encode(ProtoWriter r4, Extend r5) throws IOException {
            CommentType r0 = r5.mCommentType;
            if (r0 == null) goto L5;
            CommentType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            AppDetail r1 = r5.mAppDetail;
            if (r1 == null) goto L8;
            AppDetail.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.mCreateGroup;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mDismissGroup;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            CommonDrawer r6 = r5.mCommonDrawer;
            if (r6 == null) goto L17;
            CommonDrawer.ADAPTER.encodeWithTag(r4, 100, r6);
        L17:
            Status r7 = r5.mstatus;
            if (r7 == null) goto L20;
            Status.ADAPTER.encodeWithTag(r4, 9000001, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Extend) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Extend();
        DEFAULT_CREATEGROUP = 0L;
        DEFAULT_DISMISSGROUP = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2173newBuilder() {
        Builder r0 = new Builder();
        r0.mCommentType = this.mCommentType;
        r0.mAppDetail = this.mAppDetail;
        r0.mCreateGroup = this.mCreateGroup;
        r0.mDismissGroup = this.mDismissGroup;
        r0.mCommonDrawer = this.mCommonDrawer;
        r0.mstatus = this.mstatus;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Extend.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2173newBuilder();
    }

    public Extend(CommentType r9, AppDetail r10, Long r11, Long r12, CommonDrawer r13, Status r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public Extend(CommentType r2, AppDetail r3, Long r4, Long r5, CommonDrawer r6, Status r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mCommentType = r2;
        this.mAppDetail = r3;
        this.mCreateGroup = r4;
        this.mDismissGroup = r5;
        this.mCommonDrawer = r6;
        this.mstatus = r7;
    }
}
