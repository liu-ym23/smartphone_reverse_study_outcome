package com.obric.memorydata.memory.ui.detail;

import android.view.ViewGroup;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u001f2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0002\u001f B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u001c\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\u00062\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J,\u0010\u0019\u001a\u00020\u00062\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0016J\u0014\u0010\u001e\u001a\u00020\u00062\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewHolder;", "onSendCapsuleEvent", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnSendCapsuleEvent", "()Lkotlin/jvm/functions/Function1;", EventBody.KEY_VALUE, "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "data", "getData", "()Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "submitData", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "onViewRecycled", "Companion", "CapsuleEvent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u extends RecyclerView.Adapter<x<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<a, Unit> f10878b;
    private com.obric.memorydata.memory.ui.data.a c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "", "<init>", "()V", "SourceEvent", "CalendarEvent", "UrlEvent", "AddressEvent", "PhoneEvent", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$AddressEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$CalendarEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$PhoneEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$SourceEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$UrlEvent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.u$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$AddressEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0555a extends a {
            public C0555a() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$CalendarEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends a {
            public b() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$PhoneEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c extends a {
            public c() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$SourceEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class d extends a {
            public d() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent$UrlEvent;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class e extends a {
            public e() {
                super(null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_GLOBAL_MEMORY", "", "TYPE_OBSERVATION", "PAYLOAD_BIND_CAPSULE", "Payload", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$Companion$Payload;", "", "key", "", EventBody.KEY_VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10879a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f10880b;

            public final String a() {
                return this.f10879a;
            }

            public final Object b() {
                return this.f10880b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10879a, r6.f10879a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10880b, r6.f10880b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f10879a.hashCode() * 31;
                Object r1 = this.f10880b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "Payload(key=" + this.f10879a + ", value=" + this.f10880b + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10877a = new b(null);
    }

    public u(Function1<? super a, Unit> r3) {
        Function1<a, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onSendCapsuleEvent");
        this.f10878b = r4;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r1) {
        return ZeusTransformUtils.instanceOf(this.c, com.obric.memorydata.memory.ui.data.a.i.class) ? 1 : 0;
    }

    public final com.obric.memorydata.memory.ui.data.a a() {
        return this.c;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public final void a(com.obric.memorydata.memory.ui.data.a r1) {
        this.c = r1;
        h();
    }

    public void a(x<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.b((RecyclerView.v) ZeusTransformUtils.preCheckCast(r3, RecyclerView.v.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r3, f.class) == false) goto L6;
        ((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin")).b();
        return;
    }

    public void a(x<?> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        r2.b(false);
        com.obric.memorydata.memory.ui.data.a r1 = this.c;
        if (r1 != null) goto L5;
        return;
    L5:
        r2.a(r1);
        if (ZeusTransformUtils.instanceOf(r2, f.class) == false) goto L9;
        ((f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.memorydata.plugin")).b(r1);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L13;
        ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin")).b(r1);
        return;
    }

    public void a(x<?> r12, int r13, List<? extends Object> r14) {
        List<Object> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "holder");
        Intrinsics.checkNotNullParameter(r15, "payloads");
        RunLog.INSTANCE.debug("MemoryDetailAdapter", "onBindViewHolder payloads: " + r15);
        if (r15.isEmpty() == false) goto L6;
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r12, RecyclerView.v.class, "com.obric.memorydata.plugin"), r13, r15);
        return;
    L6:
        com.obric.memorydata.memory.ui.data.a r11 = this.c;
        if (r11 != null) goto L9;
        return;
    L9:
        r12.a(r11);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r16.hasNext() == false) goto L23;
        Object r17 = r16.next();
        if (ZeusTransformUtils.instanceOf(r17, b.a.class) == false) goto L11;
        if (Intrinsics.areEqual(((b.a) ZeusTransformUtils.preCheckCast(r17, b.a.class, "com.obric.memorydata.plugin")).a(), "bind_capsule") == false) goto L11;
        Object r18 = ((b.a) ZeusTransformUtils.preCheckCast(r17, b.a.class, "com.obric.memorydata.plugin")).b();
        if (ZeusTransformUtils.instanceOf(r18, Pair.class) == false) goto L19;
        Pair r19 = (Pair) ZeusTransformUtils.preCheckCast(r18, Pair.class, "com.obric.memorydata.plugin");
    L20:
        if (r19 == null) goto L21;
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r19.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r19.component2(), Map.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("MemoryDetailAdapter", "bind capsule, item: " + r11 + ", showCalendar: " + r6 + ", keyInfoMap: " + r7);
        x.a(r12, r11, r6, r7, false, 8, null);
        goto L11
    L21:
        return;
    L19:
        r19 = null;
        goto L20
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    public x<?> b(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != 0) goto L6;
        return (x) ZeusTransformUtils.preCheckCast(x.f10883b.a(r2, this.f10878b), x.class, "com.obric.memorydata.plugin");
    L6:
        return x.f10883b.a(r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void b(RecyclerView.v r3) {
        a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        com.obric.memorydata.memory.ui.data.a r2 = this.c;
        if (r2 != null) goto L5;
        return 0;
    L5:
        ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.memory.ui.data.a.i.class);
        return 1;
    }
}
