package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000e\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$Builder;Lokio/ByteString;)V", "biz_data", "", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$BizData;", "getBiz_data", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "ResourceApprovalInfo", "ApprovalRequest", "ApprovalTrigger", "CustomizationType", "ResourceCustomization", "CustomizationData", "CustomizationOption", "OptionCondition", "ResourceStrategy", "ResourceRequisition", "BizData", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SchemaExtraData extends Message<SchemaExtraData, a> {
    public static final ProtoAdapter<SchemaExtraData> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<BizData> biz_data;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalRequest;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalRequest$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalRequest$Builder;Lokio/ByteString;)V", "reason", "", "getReason", "()Ljava/lang/String;", "approver_user_ids", "", "getApprover_user_ids", "()Ljava/util/List;", "create_chatter_id", "getCreate_chatter_id", "trigger", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger;", "getTrigger", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ApprovalRequest extends Message<ApprovalRequest, a> {
        public static final ProtoAdapter<ApprovalRequest> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> approver_user_ids;
        private final String create_chatter_id;
        private final String reason;
        private final ApprovalTrigger trigger;

        public static final class a extends Message.a<ApprovalRequest, a> {
            public String d;
            public List<String> e;
            public String f;
            public ApprovalTrigger g;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ApprovalRequest(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ApprovalRequest> {
            @Override // com.lark.wire.ProtoAdapter
            public final ApprovalRequest c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L18;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L8:
                if (r5 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L10:
                if (r5 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.f = r8.i();
                goto L3
            L12:
                if (r5 != 4) goto L13;
                r1.g = ApprovalTrigger.ADAPTER.c(r8);
                goto L3
            L13:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L18:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "approver_user_ids");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new ApprovalRequest(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ApprovalRequest r6) {
                ApprovalRequest r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r7.getReason())) + r1.a().l(2, r7.getApprover_user_ids())) + r1.l(3, r7.getCreate_chatter_id())) + ApprovalTrigger.ADAPTER.l(4, r7.getTrigger());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ApprovalRequest r6) {
                ApprovalRequest r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getReason());
                r0.a().i(r5, 2, r7.getApprover_user_ids());
                r0.i(r5, 3, r7.getCreate_chatter_id());
                ApprovalTrigger.ADAPTER.i(r5, 4, r7.getTrigger());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ApprovalRequest r6) {
                ApprovalRequest r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ApprovalTrigger.ADAPTER.j(r5, 4, r7.getTrigger());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 3, r7.getCreate_chatter_id());
                r0.a().j(r5, 2, r7.getApprover_user_ids());
                r0.j(r5, 1, r7.getReason());
            }

            public b(FieldEncoding r7, KClass<ApprovalRequest> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.ApprovalRequest", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ApprovalRequest(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ApprovalRequest.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.reason;
            r0.e = this.approver_user_ids;
            r0.f = this.create_chatter_id;
            r0.g = this.trigger;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ApprovalRequest.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getApprover_user_ids() {
            return this.approver_user_ids;
        }

        public final String getCreate_chatter_id() {
            return this.create_chatter_id;
        }

        public final String getReason() {
            return this.reason;
        }

        public final ApprovalTrigger getTrigger() {
            return this.trigger;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ApprovalRequest(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.reason = r2.d;
            this.approver_user_ids = com.lark.wire.internal.a.c("approver_user_ids", r2.e);
            this.create_chatter_id = r2.f;
            this.trigger = r2.g;
        }

        public /* synthetic */ ApprovalRequest(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger$Builder;Lokio/ByteString;)V", "duration_trigger", "", "getDuration_trigger", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ApprovalTrigger extends Message<ApprovalTrigger, a> {
        public static final ProtoAdapter<ApprovalTrigger> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long duration_trigger;

        public static final class a extends Message.a<ApprovalTrigger, a> {
            public Long d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ApprovalTrigger(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ApprovalTrigger> {
            @Override // com.lark.wire.ProtoAdapter
            public final ApprovalTrigger c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L10:
                return new ApprovalTrigger(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ApprovalTrigger r4) {
                ApprovalTrigger r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.k.l(1, r5.getDuration_trigger());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ApprovalTrigger r5) {
                ApprovalTrigger r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 1, r6.getDuration_trigger());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ApprovalTrigger r4) {
                ApprovalTrigger r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.k.j(r3, 1, r5.getDuration_trigger());
            }

            public b(FieldEncoding r7, KClass<ApprovalTrigger> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.ApprovalTrigger", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ApprovalTrigger(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ApprovalTrigger.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.duration_trigger;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ApprovalTrigger.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getDuration_trigger() {
            return this.duration_trigger;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ApprovalTrigger(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.duration_trigger = r2.d;
        }

        public /* synthetic */ ApprovalTrigger(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$BizData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$BizData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$BizData$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$Type;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$Type;", "resource_approval_info", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceApprovalInfo;", "getResource_approval_info", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceApprovalInfo;", "approval_request", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalRequest;", "getApproval_request", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalRequest;", "resource_strategy", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy;", "getResource_strategy", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy;", "resource_requisition", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceRequisition;", "getResource_requisition", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceRequisition;", "resource_customization", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceCustomization;", "getResource_customization", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceCustomization;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BizData extends Message<BizData, a> {
        public static final ProtoAdapter<BizData> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ApprovalRequest approval_request;
        private final ResourceApprovalInfo resource_approval_info;
        private final ResourceCustomization resource_customization;
        private final ResourceRequisition resource_requisition;
        private final ResourceStrategy resource_strategy;
        private final Type type;

        public static final class a extends Message.a<BizData, a> {
            public Type d;
            public ResourceApprovalInfo e;
            public ApprovalRequest f;
            public ResourceStrategy g;
            public ResourceRequisition h;
            public ResourceCustomization i;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new BizData(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<BizData> {
            @Override // com.lark.wire.ProtoAdapter
            public final BizData c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                DefaultConstructorMarker r5 = null;
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L7;
                Type r4 = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                Intrinsics.checkNotNullParameter(r4, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                r0.d = r4;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L7:
                switch(r3) {
                    case 100: goto L13;
                    case 101: goto L12;
                    case 102: goto L11;
                    case 103: goto L10;
                    case 104: goto L9;
                    default: goto L8;
                };
            L9:
                r0.i = ResourceCustomization.ADAPTER.c(r9);
                r0.e = null;
                r0.f = null;
                r0.g = null;
                r0.h = null;
                goto L3
            L10:
                r0.h = ResourceRequisition.ADAPTER.c(r9);
                r0.e = null;
                r0.f = null;
                r0.g = null;
                r0.i = null;
                goto L3
            L11:
                r0.g = ResourceStrategy.ADAPTER.c(r9);
                r0.e = null;
                r0.f = null;
                r0.h = null;
                r0.i = null;
                goto L3
            L12:
                r0.f = ApprovalRequest.ADAPTER.c(r9);
                r0.e = null;
                r0.g = null;
                r0.h = null;
                r0.i = null;
                goto L3
            L13:
                r0.e = ResourceApprovalInfo.ADAPTER.c(r9);
                r0.f = null;
                r0.g = null;
                r0.h = null;
                r0.i = null;
                goto L3
            L8:
                r9.j(r3);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L19:
                return new BizData(r0, r9.d(r1), r5);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(BizData r5) {
                BizData r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((((r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + ResourceApprovalInfo.ADAPTER.l(100, r6.getResource_approval_info())) + ApprovalRequest.ADAPTER.l(101, r6.getApproval_request())) + ResourceStrategy.ADAPTER.l(102, r6.getResource_strategy())) + ResourceRequisition.ADAPTER.l(103, r6.getResource_requisition())) + ResourceCustomization.ADAPTER.l(104, r6.getResource_customization());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, BizData r5) {
                BizData r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getType());
                ResourceApprovalInfo.ADAPTER.i(r4, 100, r6.getResource_approval_info());
                ApprovalRequest.ADAPTER.i(r4, 101, r6.getApproval_request());
                ResourceStrategy.ADAPTER.i(r4, 102, r6.getResource_strategy());
                ResourceRequisition.ADAPTER.i(r4, 103, r6.getResource_requisition());
                ResourceCustomization.ADAPTER.i(r4, 104, r6.getResource_customization());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, BizData r5) {
                BizData r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ResourceCustomization.ADAPTER.j(r4, 104, r6.getResource_customization());
                ResourceRequisition.ADAPTER.j(r4, 103, r6.getResource_requisition());
                ResourceStrategy.ADAPTER.j(r4, 102, r6.getResource_strategy());
                ApprovalRequest.ADAPTER.j(r4, 101, r6.getApproval_request());
                ResourceApprovalInfo.ADAPTER.j(r4, 100, r6.getResource_approval_info());
                Type.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<BizData> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.BizData", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ BizData(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BizData.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.resource_approval_info;
            r0.f = this.approval_request;
            r0.g = this.resource_strategy;
            r0.h = this.resource_requisition;
            r0.i = this.resource_customization;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(BizData.class).getSimpleName() + '@' + hashCode();
        }

        public final ApprovalRequest getApproval_request() {
            return this.approval_request;
        }

        public final ResourceApprovalInfo getResource_approval_info() {
            return this.resource_approval_info;
        }

        public final ResourceCustomization getResource_customization() {
            return this.resource_customization;
        }

        public final ResourceRequisition getResource_requisition() {
            return this.resource_requisition;
        }

        public final ResourceStrategy getResource_strategy() {
            return this.resource_strategy;
        }

        public final Type getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public BizData(a r7, ByteString r8) {
            super(ADAPTER, r8);
            Type r9 = r7.d;
            Intrinsics.checkNotNull(r9);
            this.type = r9;
            ResourceApprovalInfo r10 = r7.e;
            this.resource_approval_info = r10;
            ApprovalRequest r0 = r7.f;
            this.approval_request = r0;
            ResourceStrategy r1 = r7.g;
            this.resource_strategy = r1;
            ResourceRequisition r2 = r7.h;
            this.resource_requisition = r2;
            ResourceCustomization r11 = r7.i;
            this.resource_customization = r11;
            boolean r3 = true;
            if (com.lark.wire.internal.a.b(r10, r0, r1, r2, new Object[]{r11}) <= 1) goto L6;
            r3 = false;
        L6:
            if (r3 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("At most one of resource_approval_info, approval_request, resource_strategy, resource_requisition, resource_customization may be non-null".toString());
        }

        public /* synthetic */ BizData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010 \u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationData$Builder;Lokio/ByteString;)V", "customization_type", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationType;", "getCustomization_type", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationType;", "is_required", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "label", "", "getLabel", "()Ljava/lang/String;", "index_key", "getIndex_key", "options", "", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationOption;", "getOptions", "()Ljava/util/List;", "conditions", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$OptionCondition;", "getConditions", "input_content", "getInput_content", "place_holder", "getPlace_holder", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CustomizationData extends Message<CustomizationData, a> {
        public static final ProtoAdapter<CustomizationData> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<OptionCondition> conditions;
        private final CustomizationType customization_type;
        private final String index_key;
        private final String input_content;
        private final Boolean is_required;
        private final String label;
        private final List<CustomizationOption> options;
        private final String place_holder;

        public static final class a extends Message.a<CustomizationData, a> {
            public CustomizationType d;
            public Boolean e;
            public String f;
            public String g;
            public List<CustomizationOption> h;
            public List<OptionCondition> i;
            public String j;
            public String k;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CustomizationData(this, c(), null);
            }

            public a() {
                this.h = CollectionsKt.emptyList();
                this.i = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<CustomizationData> {
            @Override // com.lark.wire.ProtoAdapter
            public final CustomizationData c(g0 r12) {
                Intrinsics.checkNotNullParameter(r12, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r12.c();
            L3:
                int r6 = r12.e();
                if (r6 == (-1)) goto L18;
                switch(r6) {
                    case 1: goto L20;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L20:
                r1.d = CustomizationType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.k = r12.i();
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.j = r12.i();
                goto L3
            L9:
                r3.add(OptionCondition.ADAPTER.c(r12));
                goto L3
            L10:
                r2.add(CustomizationOption.ADAPTER.c(r12));
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.g = r12.i();
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r12, "reader");
                r1.f = r12.i();
                goto L3
            L13:
                r1.e = (Boolean) ProtoAdapter.g.c(r12);
                goto L3
            L6:
                r12.j(r6);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L18:
                ByteString r13 = r12.d(r4);
                Intrinsics.checkNotNullParameter(r2, "options");
                com.lark.wire.internal.a.a(r2);
                r1.h = r2;
                Intrinsics.checkNotNullParameter(r3, "conditions");
                com.lark.wire.internal.a.a(r3);
                r1.i = r3;
                return new CustomizationData(r1, r13, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CustomizationData r6) {
                CustomizationData r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = (r7.unknownFields().size() + CustomizationType.ADAPTER.l(1, r7.getCustomization_type())) + ProtoAdapter.g.l(2, r7.is_required());
                w r1 = ProtoAdapter.q;
                return (((((r0 + r1.l(3, r7.getLabel())) + r1.l(4, r7.getIndex_key())) + CustomizationOption.ADAPTER.a().l(5, r7.getOptions())) + OptionCondition.ADAPTER.a().l(6, r7.getConditions())) + r1.l(7, r7.getInput_content())) + r1.l(8, r7.getPlace_holder());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, CustomizationData r6) {
                CustomizationData r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                CustomizationType.ADAPTER.i(r5, 1, r7.getCustomization_type());
                ProtoAdapter.g.i(r5, 2, r7.is_required());
                w r0 = ProtoAdapter.q;
                r0.i(r5, 3, r7.getLabel());
                r0.i(r5, 4, r7.getIndex_key());
                CustomizationOption.ADAPTER.a().i(r5, 5, r7.getOptions());
                OptionCondition.ADAPTER.a().i(r5, 6, r7.getConditions());
                r0.i(r5, 7, r7.getInput_content());
                r0.i(r5, 8, r7.getPlace_holder());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, CustomizationData r6) {
                CustomizationData r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 8, r7.getPlace_holder());
                r0.j(r5, 7, r7.getInput_content());
                OptionCondition.ADAPTER.a().j(r5, 6, r7.getConditions());
                CustomizationOption.ADAPTER.a().j(r5, 5, r7.getOptions());
                r0.j(r5, 4, r7.getIndex_key());
                r0.j(r5, 3, r7.getLabel());
                ProtoAdapter.g.j(r5, 2, r7.is_required());
                CustomizationType.ADAPTER.j(r5, 1, r7.getCustomization_type());
            }

            public b(FieldEncoding r7, KClass<CustomizationData> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.CustomizationData", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CustomizationData(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CustomizationData.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.customization_type;
            r0.e = this.is_required;
            r0.f = this.label;
            r0.g = this.index_key;
            r0.h = this.options;
            r0.i = this.conditions;
            r0.j = this.input_content;
            r0.k = this.place_holder;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CustomizationData.class).getSimpleName() + '@' + hashCode();
        }

        public final List<OptionCondition> getConditions() {
            return this.conditions;
        }

        public final CustomizationType getCustomization_type() {
            return this.customization_type;
        }

        public final String getIndex_key() {
            return this.index_key;
        }

        public final String getInput_content() {
            return this.input_content;
        }

        public final String getLabel() {
            return this.label;
        }

        public final List<CustomizationOption> getOptions() {
            return this.options;
        }

        public final String getPlace_holder() {
            return this.place_holder;
        }

        public final Boolean is_required() {
            return this.is_required;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CustomizationData(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.customization_type = r2.d;
            this.is_required = r2.e;
            this.label = r2.f;
            this.index_key = r2.g;
            this.options = com.lark.wire.internal.a.c("options", r2.h);
            this.conditions = com.lark.wire.internal.a.c("conditions", r2.i);
            this.input_content = r2.j;
            this.place_holder = r2.k;
        }

        public /* synthetic */ CustomizationData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0016\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationOption;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationOption$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationOption$Builder;Lokio/ByteString;)V", "is_others", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "others_content", "", "getOthers_content", "()Ljava/lang/String;", "option_label", "getOption_label", "option_image_url", "getOption_image_url", "option_key", "getOption_key", "is_selected", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CustomizationOption extends Message<CustomizationOption, a> {
        public static final ProtoAdapter<CustomizationOption> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean is_others;
        private final Boolean is_selected;
        private final String option_image_url;
        private final String option_key;
        private final String option_label;
        private final String others_content;

        public static final class a extends Message.a<CustomizationOption, a> {
            public Boolean d;
            public String e;
            public String f;
            public String g;
            public String h;
            public Boolean i;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CustomizationOption(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CustomizationOption> {
            @Override // com.lark.wire.ProtoAdapter
            public final CustomizationOption c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L14;
                switch(r4) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L12:
                r1.d = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L14:
                return new CustomizationOption(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CustomizationOption r6) {
                CustomizationOption r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                l r1 = ProtoAdapter.g;
                int r2 = r0 + r1.l(1, r7.is_others());
                w r3 = ProtoAdapter.q;
                return ((((r2 + r3.l(2, r7.getOthers_content())) + r3.l(3, r7.getOption_label())) + r3.l(4, r7.getOption_image_url())) + r3.l(5, r7.getOption_key())) + r1.l(6, r7.is_selected());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, CustomizationOption r6) {
                CustomizationOption r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r5, 1, r7.is_others());
                w r1 = ProtoAdapter.q;
                r1.i(r5, 2, r7.getOthers_content());
                r1.i(r5, 3, r7.getOption_label());
                r1.i(r5, 4, r7.getOption_image_url());
                r1.i(r5, 5, r7.getOption_key());
                r0.i(r5, 6, r7.is_selected());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, CustomizationOption r6) {
                CustomizationOption r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r5, 6, r7.is_selected());
                w r1 = ProtoAdapter.q;
                r1.j(r5, 5, r7.getOption_key());
                r1.j(r5, 4, r7.getOption_image_url());
                r1.j(r5, 3, r7.getOption_label());
                r1.j(r5, 2, r7.getOthers_content());
                r0.j(r5, 1, r7.is_others());
            }

            public b(FieldEncoding r7, KClass<CustomizationOption> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.CustomizationOption", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CustomizationOption(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CustomizationOption.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.is_others;
            r0.e = this.others_content;
            r0.f = this.option_label;
            r0.g = this.option_image_url;
            r0.h = this.option_key;
            r0.i = this.is_selected;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CustomizationOption.class).getSimpleName() + '@' + hashCode();
        }

        public final String getOption_image_url() {
            return this.option_image_url;
        }

        public final String getOption_key() {
            return this.option_key;
        }

        public final String getOption_label() {
            return this.option_label;
        }

        public final String getOthers_content() {
            return this.others_content;
        }

        public final Boolean is_others() {
            return this.is_others;
        }

        public final Boolean is_selected() {
            return this.is_selected;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CustomizationOption(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.is_others = r2.d;
            this.others_content = r2.e;
            this.option_label = r2.f;
            this.option_image_url = r2.g;
            this.option_key = r2.h;
            this.is_selected = r2.i;
        }

        public /* synthetic */ CustomizationOption(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SingleSelect", "MultipleSelect", "Input", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CustomizationType extends Enum<CustomizationType> implements o0 {
        public static final ProtoAdapter<CustomizationType> ADAPTER = null;
        public static final b Companion = null;
        public static final CustomizationType Input = null;
        public static final CustomizationType MultipleSelect = null;
        public static final CustomizationType SingleSelect = null;
        public static final /* synthetic */ CustomizationType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CustomizationType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CustomizationType.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return CustomizationType.Input;
            L15:
                return CustomizationType.MultipleSelect;
            L12:
                return CustomizationType.SingleSelect;
            }

            public a(KClass<CustomizationType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<CustomizationType> getEntries() {
            return b;
        }

        static {
            CustomizationType r0 = new CustomizationType("SingleSelect", 0, 1);
            SingleSelect = r0;
            CustomizationType r1 = new CustomizationType("MultipleSelect", 1, 2);
            MultipleSelect = r1;
            CustomizationType r4 = new CustomizationType("Input", 2, 3);
            Input = r4;
            CustomizationType[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CustomizationType.class), Syntax.PROTO_2);
        }

        public static CustomizationType[] values() {
            return (CustomizationType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CustomizationType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return Input;
        L15:
            return MultipleSelect;
        L12:
            return SingleSelect;
        }

        public static CustomizationType valueOf(String r1) {
            return (CustomizationType) r27.a.a(CustomizationType.class, r1);
        }

        public CustomizationType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$OptionCondition;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$OptionCondition$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$OptionCondition$Builder;Lokio/ByteString;)V", "custom_key", "", "getCustom_key", "()Ljava/lang/String;", "option_keys", "", "getOption_keys", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OptionCondition extends Message<OptionCondition, a> {
        public static final ProtoAdapter<OptionCondition> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String custom_key;
        private final List<String> option_keys;

        public static final class a extends Message.a<OptionCondition, a> {
            public String d;
            public List<String> e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new OptionCondition(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<OptionCondition> {
            @Override // com.lark.wire.ProtoAdapter
            public final OptionCondition c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L12;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L8:
                if (r5 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L9:
                r8.j(r5);
                goto L3
            L12:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "option_keys");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new OptionCondition(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OptionCondition r5) {
                OptionCondition r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getCustom_key())) + r1.a().l(2, r6.getOption_keys());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OptionCondition r5) {
                OptionCondition r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getCustom_key());
                r0.a().i(r4, 2, r6.getOption_keys());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, OptionCondition r6) {
                OptionCondition r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.a().j(r5, 2, r7.getOption_keys());
                r0.j(r5, 1, r7.getCustom_key());
            }

            public b(FieldEncoding r7, KClass<OptionCondition> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.OptionCondition", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OptionCondition(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OptionCondition.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.custom_key;
            r0.e = this.option_keys;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OptionCondition.class).getSimpleName() + '@' + hashCode();
        }

        public final String getCustom_key() {
            return this.custom_key;
        }

        public final List<String> getOption_keys() {
            return this.option_keys;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public OptionCondition(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.custom_key = r2.d;
            this.option_keys = com.lark.wire.internal.a.c("option_keys", r2.e);
        }

        public /* synthetic */ OptionCondition(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceApprovalInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceApprovalInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceApprovalInfo$Builder;Lokio/ByteString;)V", "approver_user_ids", "", "", "getApprover_user_ids", "()Ljava/util/List;", "trigger", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger;", "getTrigger", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ApprovalTrigger;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ResourceApprovalInfo extends Message<ResourceApprovalInfo, a> {
        public static final ProtoAdapter<ResourceApprovalInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> approver_user_ids;
        private final ApprovalTrigger trigger;

        public static final class a extends Message.a<ResourceApprovalInfo, a> {
            public List<String> d;
            public ApprovalTrigger e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ResourceApprovalInfo(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ResourceApprovalInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final ResourceApprovalInfo c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L12;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L8:
                if (r5 != 2) goto L9;
                r1.e = ApprovalTrigger.ADAPTER.c(r8);
                goto L3
            L9:
                r8.j(r5);
                goto L3
            L12:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "approver_user_ids");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                return new ResourceApprovalInfo(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ResourceApprovalInfo r5) {
                ResourceApprovalInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.a().l(1, r6.getApprover_user_ids())) + ApprovalTrigger.ADAPTER.l(2, r6.getTrigger());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ResourceApprovalInfo r5) {
                ResourceApprovalInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.a().i(r4, 1, r6.getApprover_user_ids());
                ApprovalTrigger.ADAPTER.i(r4, 2, r6.getTrigger());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ResourceApprovalInfo r5) {
                ResourceApprovalInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ApprovalTrigger.ADAPTER.j(r4, 2, r6.getTrigger());
                ProtoAdapter.q.a().j(r4, 1, r6.getApprover_user_ids());
            }

            public b(FieldEncoding r7, KClass<ResourceApprovalInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.ResourceApprovalInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ResourceApprovalInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceApprovalInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.approver_user_ids;
            r0.e = this.trigger;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ResourceApprovalInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getApprover_user_ids() {
            return this.approver_user_ids;
        }

        public final ApprovalTrigger getTrigger() {
            return this.trigger;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ResourceApprovalInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.approver_user_ids = com.lark.wire.internal.a.c("approver_user_ids", r2.d);
            this.trigger = r2.e;
        }

        public /* synthetic */ ResourceApprovalInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceCustomization;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceCustomization$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceCustomization$Builder;Lokio/ByteString;)V", "customization_data", "", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$CustomizationData;", "getCustomization_data", "()Ljava/util/List;", "contact_ids", "", "getContact_ids", "preparation_time", "", "getPreparation_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ResourceCustomization extends Message<ResourceCustomization, a> {
        public static final ProtoAdapter<ResourceCustomization> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> contact_ids;
        private final List<CustomizationData> customization_data;
        private final Long preparation_time;

        public static final class a extends Message.a<ResourceCustomization, a> {
            public List<CustomizationData> d;
            public List<String> e;
            public Long f;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ResourceCustomization(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ResourceCustomization> {
            @Override // com.lark.wire.ProtoAdapter
            public final ResourceCustomization c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                ArrayList r3 = new ArrayList();
                long r4 = r9.c();
            L3:
                int r6 = r9.e();
                if (r6 == (-1)) goto L15;
                if (r6 != 1) goto L8;
                r2.add(CustomizationData.ADAPTER.c(r9));
                goto L3
            L8:
                if (r6 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r9, "reader");
                r3.add(r9.i());
                goto L3
            L10:
                if (r6 != 3) goto L11;
                r1.f = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L11:
                r9.j(r6);
                goto L3
            L15:
                ByteString r10 = r9.d(r4);
                Intrinsics.checkNotNullParameter(r2, "customization_data");
                com.lark.wire.internal.a.a(r2);
                r1.d = r2;
                Intrinsics.checkNotNullParameter(r3, "contact_ids");
                com.lark.wire.internal.a.a(r3);
                r1.e = r3;
                return new ResourceCustomization(r1, r10, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ResourceCustomization r5) {
                ResourceCustomization r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + CustomizationData.ADAPTER.a().l(1, r6.getCustomization_data())) + ProtoAdapter.q.a().l(2, r6.getContact_ids())) + ProtoAdapter.k.l(3, r6.getPreparation_time());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ResourceCustomization r5) {
                ResourceCustomization r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                CustomizationData.ADAPTER.a().i(r4, 1, r6.getCustomization_data());
                ProtoAdapter.q.a().i(r4, 2, r6.getContact_ids());
                ProtoAdapter.k.i(r4, 3, r6.getPreparation_time());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ResourceCustomization r5) {
                ResourceCustomization r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 3, r6.getPreparation_time());
                ProtoAdapter.q.a().j(r4, 2, r6.getContact_ids());
                CustomizationData.ADAPTER.a().j(r4, 1, r6.getCustomization_data());
            }

            public b(FieldEncoding r7, KClass<ResourceCustomization> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.ResourceCustomization", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ResourceCustomization(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceCustomization.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.customization_data;
            r0.e = this.contact_ids;
            r0.f = this.preparation_time;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ResourceCustomization.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getContact_ids() {
            return this.contact_ids;
        }

        public final List<CustomizationData> getCustomization_data() {
            return this.customization_data;
        }

        public final Long getPreparation_time() {
            return this.preparation_time;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ResourceCustomization(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.customization_data = com.lark.wire.internal.a.c("customization_data", r2.d);
            this.contact_ids = com.lark.wire.internal.a.c("contact_ids", r2.e);
            this.preparation_time = r2.f;
        }

        public /* synthetic */ ResourceCustomization(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceRequisition;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceRequisition$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceRequisition$Builder;Lokio/ByteString;)V", "start_time", "", "getStart_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end_time", "getEnd_time", "contact_ids", "", "", "getContact_ids", "()Ljava/util/List;", "reason", "getReason", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ResourceRequisition extends Message<ResourceRequisition, a> {
        public static final ProtoAdapter<ResourceRequisition> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> contact_ids;
        private final Long end_time;
        private final String reason;
        private final Long start_time;

        public static final class a extends Message.a<ResourceRequisition, a> {
            public Long d;
            public Long e;
            public List<String> f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ResourceRequisition(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<ResourceRequisition> {
            @Override // com.lark.wire.ProtoAdapter
            public final ResourceRequisition c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L18;
                if (r5 != 1) goto L8;
                r1.d = (Long) ProtoAdapter.k.c(r8);
                goto L3
            L8:
                if (r5 != 2) goto L10;
                r1.e = (Long) ProtoAdapter.k.c(r8);
                goto L3
            L10:
                if (r5 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L12:
                if (r5 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.g = r8.i();
                goto L3
            L13:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L18:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "contact_ids");
                com.lark.wire.internal.a.a(r2);
                r1.f = r2;
                return new ResourceRequisition(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ResourceRequisition r6) {
                ResourceRequisition r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                t r1 = ProtoAdapter.k;
                int r2 = (r0 + r1.l(1, r7.getStart_time())) + r1.l(2, r7.getEnd_time());
                w r3 = ProtoAdapter.q;
                return (r2 + r3.a().l(3, r7.getContact_ids())) + r3.l(4, r7.getReason());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ResourceRequisition r6) {
                ResourceRequisition r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r5, 1, r7.getStart_time());
                r0.i(r5, 2, r7.getEnd_time());
                w r1 = ProtoAdapter.q;
                r1.a().i(r5, 3, r7.getContact_ids());
                r1.i(r5, 4, r7.getReason());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ResourceRequisition r5) {
                ResourceRequisition r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getReason());
                r0.a().j(r4, 3, r6.getContact_ids());
                t r1 = ProtoAdapter.k;
                r1.j(r4, 2, r6.getEnd_time());
                r1.j(r4, 1, r6.getStart_time());
            }

            public b(FieldEncoding r7, KClass<ResourceRequisition> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.ResourceRequisition", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ResourceRequisition(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceRequisition.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.start_time;
            r0.e = this.end_time;
            r0.f = this.contact_ids;
            r0.g = this.reason;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ResourceRequisition.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getContact_ids() {
            return this.contact_ids;
        }

        public final Long getEnd_time() {
            return this.end_time;
        }

        public final String getReason() {
            return this.reason;
        }

        public final Long getStart_time() {
            return this.start_time;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ResourceRequisition(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.start_time = r2.d;
            this.end_time = r2.e;
            this.contact_ids = com.lark.wire.internal.a.c("contact_ids", r2.f);
            this.reason = r2.g;
        }

        public /* synthetic */ ResourceRequisition(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001c\u0010\u000bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001e\u0010\u000bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy$Builder;Lokio/ByteString;)V", "single_max_duration", "", "getSingle_max_duration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "until_max_duration", "getUntil_max_duration", "daily_start_time", "getDaily_start_time", "daily_end_time", "getDaily_end_time", "timezone", "", "getTimezone", "()Ljava/lang/String;", "is_enable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "earliest_book_time", "getEarliest_book_time", "max_workday", "getMax_workday", "max_reservable_type", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy$MaxReservableType;", "getMax_reservable_type", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy$MaxReservableType;", "newBuilder", "toString", "Builder", "Companion", "MaxReservableType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ResourceStrategy extends Message<ResourceStrategy, a> {
        public static final ProtoAdapter<ResourceStrategy> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer daily_end_time;
        private final Integer daily_start_time;
        private final Integer earliest_book_time;
        private final Boolean is_enable;
        private final MaxReservableType max_reservable_type;
        private final Integer max_workday;
        private final Integer single_max_duration;
        private final String timezone;
        private final Integer until_max_duration;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$ResourceStrategy$MaxReservableType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DAY", "WORK_DAY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum MaxReservableType extends Enum<MaxReservableType> implements o0 {
            public static final ProtoAdapter<MaxReservableType> ADAPTER = null;
            public static final b Companion = null;
            public static final MaxReservableType DAY = null;
            public static final MaxReservableType UNKNOWN = null;
            public static final MaxReservableType WORK_DAY = null;
            public static final /* synthetic */ MaxReservableType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<MaxReservableType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    MaxReservableType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return MaxReservableType.WORK_DAY;
                L15:
                    return MaxReservableType.DAY;
                L12:
                    return MaxReservableType.UNKNOWN;
                }

                public a(KClass<MaxReservableType> r1, Syntax r2, MaxReservableType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<MaxReservableType> getEntries() {
                return b;
            }

            static {
                MaxReservableType r0 = new MaxReservableType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                MaxReservableType r1 = new MaxReservableType("DAY", 1, 1);
                DAY = r1;
                MaxReservableType r3 = new MaxReservableType("WORK_DAY", 2, 2);
                WORK_DAY = r3;
                MaxReservableType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(MaxReservableType.class), Syntax.PROTO_2, r0);
            }

            public static MaxReservableType[] values() {
                return (MaxReservableType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final MaxReservableType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return WORK_DAY;
            L15:
                return DAY;
            L12:
                return UNKNOWN;
            }

            public static MaxReservableType valueOf(String r1) {
                return (MaxReservableType) r27.a.a(MaxReservableType.class, r1);
            }

            public MaxReservableType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends Message.a<ResourceStrategy, a> {
            public Integer d;
            public Integer e;
            public Integer f;
            public Integer g;
            public String h;
            public Boolean i;
            public Integer j;
            public Integer k;
            public MaxReservableType l;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ResourceStrategy(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ResourceStrategy> {
            @Override // com.lark.wire.ProtoAdapter
            public final ResourceStrategy c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L20;
                switch(r4) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L21;
                    default: goto L6;
                };
            L21:
                r1.l = MaxReservableType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L11:
                r1.k = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L12:
                r1.j = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L13:
                r1.i = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.h = r10.i();
                goto L3
            L15:
                r1.g = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L16:
                r1.f = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L17:
                r1.e = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L18:
                r1.d = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L6:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L20:
                return new ResourceStrategy(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ResourceStrategy r6) {
                ResourceStrategy r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                s r1 = ProtoAdapter.h;
                return ((((((((r0 + r1.l(1, r7.getSingle_max_duration())) + r1.l(2, r7.getUntil_max_duration())) + r1.l(3, r7.getDaily_start_time())) + r1.l(4, r7.getDaily_end_time())) + ProtoAdapter.q.l(5, r7.getTimezone())) + ProtoAdapter.g.l(6, r7.is_enable())) + r1.l(7, r7.getEarliest_book_time())) + r1.l(8, r7.getMax_workday())) + MaxReservableType.ADAPTER.l(9, r7.getMax_reservable_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ResourceStrategy r6) {
                ResourceStrategy r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                s r0 = ProtoAdapter.h;
                r0.i(r5, 1, r7.getSingle_max_duration());
                r0.i(r5, 2, r7.getUntil_max_duration());
                r0.i(r5, 3, r7.getDaily_start_time());
                r0.i(r5, 4, r7.getDaily_end_time());
                ProtoAdapter.q.i(r5, 5, r7.getTimezone());
                ProtoAdapter.g.i(r5, 6, r7.is_enable());
                r0.i(r5, 7, r7.getEarliest_book_time());
                r0.i(r5, 8, r7.getMax_workday());
                MaxReservableType.ADAPTER.i(r5, 9, r7.getMax_reservable_type());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ResourceStrategy r6) {
                ResourceStrategy r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                MaxReservableType.ADAPTER.j(r5, 9, r7.getMax_reservable_type());
                s r0 = ProtoAdapter.h;
                r0.j(r5, 8, r7.getMax_workday());
                r0.j(r5, 7, r7.getEarliest_book_time());
                ProtoAdapter.g.j(r5, 6, r7.is_enable());
                ProtoAdapter.q.j(r5, 5, r7.getTimezone());
                r0.j(r5, 4, r7.getDaily_end_time());
                r0.j(r5, 3, r7.getDaily_start_time());
                r0.j(r5, 2, r7.getUntil_max_duration());
                r0.j(r5, 1, r7.getSingle_max_duration());
            }

            public b(FieldEncoding r7, KClass<ResourceStrategy> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData.ResourceStrategy", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ResourceStrategy(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ResourceStrategy.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.single_max_duration;
            r0.e = this.until_max_duration;
            r0.f = this.daily_start_time;
            r0.g = this.daily_end_time;
            r0.h = this.timezone;
            r0.i = this.is_enable;
            r0.j = this.earliest_book_time;
            r0.k = this.max_workday;
            r0.l = this.max_reservable_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ResourceStrategy.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getDaily_end_time() {
            return this.daily_end_time;
        }

        public final Integer getDaily_start_time() {
            return this.daily_start_time;
        }

        public final Integer getEarliest_book_time() {
            return this.earliest_book_time;
        }

        public final MaxReservableType getMax_reservable_type() {
            return this.max_reservable_type;
        }

        public final Integer getMax_workday() {
            return this.max_workday;
        }

        public final Integer getSingle_max_duration() {
            return this.single_max_duration;
        }

        public final String getTimezone() {
            return this.timezone;
        }

        public final Integer getUntil_max_duration() {
            return this.until_max_duration;
        }

        public final Boolean is_enable() {
            return this.is_enable;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ResourceStrategy(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.single_max_duration = r2.d;
            this.until_max_duration = r2.e;
            this.daily_start_time = r2.f;
            this.daily_end_time = r2.g;
            this.timezone = r2.h;
            this.is_enable = r2.i;
            this.earliest_book_time = r2.j;
            this.max_workday = r2.k;
            this.max_reservable_type = r2.l;
        }

        public /* synthetic */ ResourceStrategy(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "RESOURCE_APPROVAL_INFO", "APPROVAL_REQUEST", "RESOURCE_STRATEGY", "RESOURCE_REQUISITION", "RESOURCE_CUSTOMIZATION", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APPROVAL_REQUEST = null;
        public static final b Companion = null;
        public static final Type RESOURCE_APPROVAL_INFO = null;
        public static final Type RESOURCE_CUSTOMIZATION = null;
        public static final Type RESOURCE_REQUISITION = null;
        public static final Type RESOURCE_STRATEGY = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return Type.RESOURCE_CUSTOMIZATION;
            L23:
                return Type.RESOURCE_REQUISITION;
            L24:
                return Type.RESOURCE_STRATEGY;
            L25:
                return Type.APPROVAL_REQUEST;
            L26:
                return Type.RESOURCE_APPROVAL_INFO;
            L20:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("RESOURCE_APPROVAL_INFO", 1, 1);
            RESOURCE_APPROVAL_INFO = r1;
            Type r3 = new Type("APPROVAL_REQUEST", 2, 2);
            APPROVAL_REQUEST = r3;
            Type r5 = new Type("RESOURCE_STRATEGY", 3, 3);
            RESOURCE_STRATEGY = r5;
            Type r7 = new Type("RESOURCE_REQUISITION", 4, 4);
            RESOURCE_REQUISITION = r7;
            Type r9 = new Type("RESOURCE_CUSTOMIZATION", 5, 5);
            RESOURCE_CUSTOMIZATION = r9;
            Type[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<SchemaExtraData, a> {
        public List<BizData> d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new SchemaExtraData(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<SchemaExtraData> {
        @Override // com.lark.wire.ProtoAdapter
        public final SchemaExtraData c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L9;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            r1.add(BizData.ADAPTER.c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "biz_data");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new SchemaExtraData(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SchemaExtraData r4) {
            SchemaExtraData r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + BizData.ADAPTER.a().l(1, r5.getBiz_data());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, SchemaExtraData r5) {
            SchemaExtraData r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            BizData.ADAPTER.a().i(r4, 1, r6.getBiz_data());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, SchemaExtraData r4) {
            SchemaExtraData r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            BizData.ADAPTER.a().j(r3, 1, r5.getBiz_data());
        }

        public b(FieldEncoding r7, KClass<SchemaExtraData> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.SchemaExtraData", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SchemaExtraData(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SchemaExtraData.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.biz_data;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SchemaExtraData.class).getSimpleName() + '@' + hashCode();
    }

    public final List<BizData> getBiz_data() {
        return this.biz_data;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public SchemaExtraData(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.biz_data = com.lark.wire.internal.a.c("biz_data", r2.d);
    }

    public /* synthetic */ SchemaExtraData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
