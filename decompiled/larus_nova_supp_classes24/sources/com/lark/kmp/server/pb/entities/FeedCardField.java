package com.lark.kmp.server.pb.entities;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010+\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedCardField;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/server/pb/entities/FeedCardField$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/server/pb/entities/FeedCardField$Builder;Lokio/ByteString;)V", "temp_top", "Lcom/lark/kmp/server/pb/entities/FeedTempTop;", "getTemp_top", "()Lcom/lark/kmp/server/pb/entities/FeedTempTop;", "button_data", "Lcom/lark/kmp/server/pb/entities/FeedButtonData;", "getButton_data", "()Lcom/lark/kmp/server/pb/entities/FeedButtonData;", "buttons_action", "", "", "Lcom/lark/kmp/server/pb/entities/FeedButtonActions;", "getButtons_action", "()Ljava/util/Map;", "button_app_id", "", "getButton_app_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "mark_as_unread", "Lcom/lark/kmp/server/pb/entities/FeedMarkAsUnread;", "getMark_as_unread", "()Lcom/lark/kmp/server/pb/entities/FeedMarkAsUnread;", "priority_info", "Lcom/lark/kmp/server/pb/entities/PriorityInfo;", "getPriority_info", "()Lcom/lark/kmp/server/pb/entities/PriorityInfo;", "chat_info", "Lcom/lark/kmp/server/pb/entities/ChatInfo;", "getChat_info", "()Lcom/lark/kmp/server/pb/entities/ChatInfo;", "doubao_info", "Lcom/lark/kmp/server/pb/entities/DoubaoInfo;", "getDoubao_info", "()Lcom/lark/kmp/server/pb/entities/DoubaoInfo;", "subtype", "", "getSubtype", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FeedCardField extends Message<FeedCardField, a> {
    public static final ProtoAdapter<FeedCardField> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long button_app_id;
    private final FeedButtonData button_data;
    private final Map<String, FeedButtonActions> buttons_action;
    private final ChatInfo chat_info;
    private final DoubaoInfo doubao_info;
    private final FeedMarkAsUnread mark_as_unread;
    private final PriorityInfo priority_info;
    private final Integer subtype;
    private final FeedTempTop temp_top;

    public static final class a extends Message.a<FeedCardField, a> {
        public FeedTempTop d;
        public FeedButtonData e;
        public Map<String, FeedButtonActions> f;
        public Long g;
        public FeedMarkAsUnread h;
        public PriorityInfo i;
        public ChatInfo j;
        public DoubaoInfo k;
        public Integer l;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new FeedCardField(this, c(), null);
        }

        public a() {
            this.f = MapsKt.emptyMap();
        }
    }

    public static final class b extends ProtoAdapter<FeedCardField> {
        public final Lazy v;

        @Override // com.lark.wire.ProtoAdapter
        public final FeedCardField c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            LinkedHashMap r1 = new LinkedHashMap();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r0.l = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L8:
            r0.k = DoubaoInfo.ADAPTER.c(r7);
            goto L3
        L9:
            r0.j = ChatInfo.ADAPTER.c(r7);
            goto L3
        L10:
            r0.i = PriorityInfo.ADAPTER.c(r7);
            goto L3
        L11:
            r0.h = FeedMarkAsUnread.ADAPTER.c(r7);
            goto L3
        L12:
            r0.g = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L13:
            r1.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r7));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L14:
            r0.e = FeedButtonData.ADAPTER.c(r7);
            goto L3
        L15:
            r0.d = FeedTempTop.ADAPTER.c(r7);
            goto L3
        L6:
            r7.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L16:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "buttons_action");
            r0.f = r1;
            return new FeedCardField(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(FeedCardField r5) {
            FeedCardField r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((((((r6.unknownFields().size() + FeedTempTop.ADAPTER.l(1, r6.getTemp_top())) + FeedButtonData.ADAPTER.l(2, r6.getButton_data())) + ((ProtoAdapter) this.v.getValue()).l(3, r6.getButtons_action())) + ProtoAdapter.k.l(4, r6.getButton_app_id())) + FeedMarkAsUnread.ADAPTER.l(5, r6.getMark_as_unread())) + PriorityInfo.ADAPTER.l(6, r6.getPriority_info())) + ChatInfo.ADAPTER.l(7, r6.getChat_info())) + DoubaoInfo.ADAPTER.l(8, r6.getDoubao_info())) + ProtoAdapter.h.l(9, r6.getSubtype());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, FeedCardField r5) {
            FeedCardField r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            FeedTempTop.ADAPTER.i(r4, 1, r6.getTemp_top());
            FeedButtonData.ADAPTER.i(r4, 2, r6.getButton_data());
            ((ProtoAdapter) this.v.getValue()).i(r4, 3, r6.getButtons_action());
            ProtoAdapter.k.i(r4, 4, r6.getButton_app_id());
            FeedMarkAsUnread.ADAPTER.i(r4, 5, r6.getMark_as_unread());
            PriorityInfo.ADAPTER.i(r4, 6, r6.getPriority_info());
            ChatInfo.ADAPTER.i(r4, 7, r6.getChat_info());
            DoubaoInfo.ADAPTER.i(r4, 8, r6.getDoubao_info());
            ProtoAdapter.h.i(r4, 9, r6.getSubtype());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, FeedCardField r5) {
            FeedCardField r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.h.j(r4, 9, r6.getSubtype());
            DoubaoInfo.ADAPTER.j(r4, 8, r6.getDoubao_info());
            ChatInfo.ADAPTER.j(r4, 7, r6.getChat_info());
            PriorityInfo.ADAPTER.j(r4, 6, r6.getPriority_info());
            FeedMarkAsUnread.ADAPTER.j(r4, 5, r6.getMark_as_unread());
            ProtoAdapter.k.j(r4, 4, r6.getButton_app_id());
            ((ProtoAdapter) this.v.getValue()).j(r4, 3, r6.getButtons_action());
            FeedButtonData.ADAPTER.j(r4, 2, r6.getButton_data());
            FeedTempTop.ADAPTER.j(r4, 1, r6.getTemp_top());
        }

        public b(FieldEncoding r7, KClass<FeedCardField> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/entities.FeedCardField", r9, null);
            this.v = LazyKt.lazy(new ky7.c());
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ FeedCardField(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FeedCardField.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.temp_top;
        r0.e = this.button_data;
        r0.f = this.buttons_action;
        r0.g = this.button_app_id;
        r0.h = this.mark_as_unread;
        r0.i = this.priority_info;
        r0.j = this.chat_info;
        r0.k = this.doubao_info;
        r0.l = this.subtype;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(FeedCardField.class).getSimpleName() + "@" + hashCode();
    }

    public final Long getButton_app_id() {
        return this.button_app_id;
    }

    public final FeedButtonData getButton_data() {
        return this.button_data;
    }

    public final Map<String, FeedButtonActions> getButtons_action() {
        return this.buttons_action;
    }

    public final ChatInfo getChat_info() {
        return this.chat_info;
    }

    public final DoubaoInfo getDoubao_info() {
        return this.doubao_info;
    }

    public final FeedMarkAsUnread getMark_as_unread() {
        return this.mark_as_unread;
    }

    public final PriorityInfo getPriority_info() {
        return this.priority_info;
    }

    public final Integer getSubtype() {
        return this.subtype;
    }

    public final FeedTempTop getTemp_top() {
        return this.temp_top;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public FeedCardField(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.temp_top = r2.d;
        this.button_data = r2.e;
        this.buttons_action = com.lark.wire.internal.a.d("buttons_action", r2.f);
        this.button_app_id = r2.g;
        this.mark_as_unread = r2.h;
        this.priority_info = r2.i;
        this.chat_info = r2.j;
        this.doubao_info = r2.k;
        this.subtype = r2.l;
    }

    public /* synthetic */ FeedCardField(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
