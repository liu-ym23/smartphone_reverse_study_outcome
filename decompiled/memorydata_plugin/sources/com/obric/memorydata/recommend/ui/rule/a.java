package com.obric.memorydata.recommend.ui.rule;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", "", "<init>", "()V", "Title", "Default", TypedValues.Custom.NAME, "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Custom;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Default;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Title;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.rule.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Custom;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", "entity", "Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "isFirstItem", "", "isLastItem", "<init>", "(Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;ZZ)V", "getEntity", "()Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "()Z", "setFirstItem", "(Z)V", "setLastItem", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0686a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BlockMemoryContentEntity f12735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12736b;
        private boolean c;

        public C0686a(BlockMemoryContentEntity r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "entity");
            super(null);
            this.f12735a = r2;
            this.f12736b = r3;
            this.c = r4;
        }

        public /* synthetic */ C0686a(BlockMemoryContentEntity r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = false;
        L8:
            this(r2, r3, r4);
        }

        public static /* synthetic */ C0686a a(C0686a r0, BlockMemoryContentEntity r1, boolean r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.f12735a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.f12736b;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.c;
        L12:
            return r0.a(r1, r2, r3);
        }

        public final BlockMemoryContentEntity a() {
            return this.f12735a;
        }

        public final C0686a a(BlockMemoryContentEntity r1, boolean r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "entity");
            return new C0686a(r1, r2, r3);
        }

        public final boolean b() {
            return this.f12736b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0686a.class) == true) goto L8;
            return false;
        L8:
            C0686a r6 = (C0686a) ZeusTransformUtils.preCheckCast(r5, C0686a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12735a, r6.f12735a) == true) goto L12;
            return false;
        L12:
            if (this.f12736b == r6.f12736b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12735a.hashCode() * 31) + Boolean.hashCode(this.f12736b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Custom(entity=" + this.f12735a + ", isFirstItem=" + this.f12736b + ", isLastItem=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Default;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", Params.CONTENT, "", "isFirstItem", "", "isLastItem", "<init>", "(Ljava/lang/String;ZZ)V", "getContent", "()Ljava/lang/String;", "()Z", "setFirstItem", "(Z)V", "setLastItem", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12738b;
        private boolean c;

        public b(String r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
            super(null);
            this.f12737a = r2;
            this.f12738b = r3;
            this.c = r4;
        }

        public /* synthetic */ b(String r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = false;
        L8:
            this(r2, r3, r4);
        }

        public static /* synthetic */ b a(b r0, String r1, boolean r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.f12737a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.f12738b;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.c;
        L12:
            return r0.a(r1, r2, r3);
        }

        public final b a(String r1, boolean r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, Params.CONTENT);
            return new b(r1, r2, r3);
        }

        public final String a() {
            return this.f12737a;
        }

        public final boolean b() {
            return this.f12738b;
        }

        public final boolean c() {
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
            if (Intrinsics.areEqual(this.f12737a, r6.f12737a) == true) goto L12;
            return false;
        L12:
            if (this.f12738b == r6.f12738b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12737a.hashCode() * 31) + Boolean.hashCode(this.f12738b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Default(content=" + this.f12737a + ", isFirstItem=" + this.f12738b + ", isLastItem=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem$Title;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", "title", "", "<init>", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12739a;

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            super(null);
            this.f12739a = r2;
        }

        public final String a() {
            return this.f12739a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12739a, r6.f12739a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f12739a.hashCode();
        }

        public String toString() {
            return "Title(title=" + this.f12739a + ')';
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker r1) {
        this();
    }
}
