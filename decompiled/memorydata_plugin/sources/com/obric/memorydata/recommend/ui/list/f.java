package com.obric.memorydata.recommend.ui.list;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.obric.memory.model.MemoryData;
import com.bytedance.obric.memory.model.UserTodo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "", "type", "Lcom/obric/memorydata/recommend/ui/list/MemoryItemType;", "<init>", "(Lcom/obric/memorydata/recommend/ui/list/MemoryItemType;)V", "getType", "()Lcom/obric/memorydata/recommend/ui/list/MemoryItemType;", "Category", "MemoryEntity", "PortraitEntity", "TodoEntity", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$Category;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$MemoryEntity;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$PortraitEntity;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$TodoEntity;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryItemType f12700a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryItem$Category;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", EventBody.KEY_CATEGORY, "", "<init>", "(Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12701a;

        public a(String r3) {
            Intrinsics.checkNotNullParameter(r3, EventBody.KEY_CATEGORY);
            super(MemoryItemType.MEMORY_CATEGORY, null);
            this.f12701a = r3;
        }

        public final String a() {
            return this.f12701a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12701a, r6.f12701a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f12701a.hashCode();
        }

        public String toString() {
            return "Category(category=" + this.f12701a + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryItem$MemoryEntity;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "memoryEntity", "Lcom/bytedance/obric/memory/model/MemoryData;", "isPast", "", "isExpanded", "<init>", "(Lcom/bytedance/obric/memory/model/MemoryData;ZZ)V", "getMemoryEntity", "()Lcom/bytedance/obric/memory/model/MemoryData;", "()Z", "setExpanded", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MemoryData f12702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12703b;
        private boolean c;

        public b(MemoryData r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "memoryEntity");
            super(MemoryItemType.MEMORY_ENTITY, null);
            this.f12702a = r3;
            this.f12703b = r4;
            this.c = r5;
        }

        public /* synthetic */ b(MemoryData r1, boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = false;
        L5:
            this(r1, r2, r3);
        }

        public final MemoryData a() {
            return this.f12702a;
        }

        public final void a(boolean r1) {
            this.c = r1;
        }

        public final boolean b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12702a, r6.f12702a) == true) goto L12;
            return false;
        L12:
            if (this.f12703b == r6.f12703b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12702a.hashCode() * 31) + Boolean.hashCode(this.f12703b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "MemoryEntity(memoryEntity=" + this.f12702a + ", isPast=" + this.f12703b + ", isExpanded=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryItem$PortraitEntity;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "portraitEntity", "Lcom/bytedance/obric/memory/model/MemoryData;", "isPast", "", "<init>", "(Lcom/bytedance/obric/memory/model/MemoryData;Z)V", "getPortraitEntity", "()Lcom/bytedance/obric/memory/model/MemoryData;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MemoryData f12704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12705b;

        public c(MemoryData r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "portraitEntity");
            super(MemoryItemType.PORTRAIT_ENTITY, null);
            this.f12704a = r3;
            this.f12705b = r4;
        }

        public final MemoryData a() {
            return this.f12704a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12704a, r6.f12704a) == true) goto L12;
            return false;
        L12:
            if (this.f12705b == r6.f12705b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12704a.hashCode() * 31) + Boolean.hashCode(this.f12705b);
        }

        public String toString() {
            return "PortraitEntity(portraitEntity=" + this.f12704a + ", isPast=" + this.f12705b + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryItem$TodoEntity;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "todoEntity", "Lcom/bytedance/obric/memory/model/UserTodo;", "isPast", "", "<init>", "(Lcom/bytedance/obric/memory/model/UserTodo;Z)V", "getTodoEntity", "()Lcom/bytedance/obric/memory/model/UserTodo;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UserTodo f12706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12707b;

        public d(UserTodo r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "todoEntity");
            super(MemoryItemType.TODO_ENTITY, null);
            this.f12706a = r3;
            this.f12707b = r4;
        }

        public final UserTodo a() {
            return this.f12706a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12706a, r6.f12706a) == true) goto L12;
            return false;
        L12:
            if (this.f12707b == r6.f12707b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12706a.hashCode() * 31) + Boolean.hashCode(this.f12707b);
        }

        public String toString() {
            return "TodoEntity(todoEntity=" + this.f12706a + ", isPast=" + this.f12707b + ')';
        }
    }

    private f(MemoryItemType r1) {
        this.f12700a = r1;
    }

    public /* synthetic */ f(MemoryItemType r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public MemoryItemType getType() {
        return this.f12700a;
    }
}
