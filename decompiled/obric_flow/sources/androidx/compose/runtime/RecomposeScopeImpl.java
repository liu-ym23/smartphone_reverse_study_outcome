package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u00104\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u000eJ\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0010\u0018\u0001082\u0006\u0010:\u001a\u00020\u000fJ\b\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020=2\b\u0010\u0016\u001a\u0004\u0018\u00010,J\u0016\u0010>\u001a\u00020\u00122\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010@J\u000e\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020,J\u0006\u0010C\u001a\u00020\u0010J\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010E\u001a\u00020\u0010J\u000e\u0010F\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u000fJ\"\u0010G\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u001aR$\u0010#\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u001aR$\u0010&\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u001aR\"\u0010)\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030+\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010/\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u001aR\u0011\u00102\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b3\u0010\u0014¨\u0006I"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "isConditional", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "recordRead", "instance", "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecomposeScopeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecomposeScopeImpl.kt\nandroidx/compose/runtime/RecomposeScopeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 IdentityArrayIntMap.kt\nandroidx/compose/runtime/collection/IdentityArrayIntMap\n*L\n1#1,388:1\n1#2:389\n1726#3,3:390\n172#4,8:393\n161#4,8:401\n*S KotlinDebug\n*F\n+ 1 RecomposeScopeImpl.kt\nandroidx/compose/runtime/RecomposeScopeImpl\n*L\n297#1:390,3\n315#1:393,8\n338#1:401,8\n*E\n"})
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    public static final Companion Companion = null;
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    private IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;
    private IdentityArrayIntMap trackedInstances;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime_release", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRecomposeScopeImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecomposeScopeImpl.kt\nandroidx/compose/runtime/RecomposeScopeImpl$Companion\n+ 2 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,388:1\n33#2,6:389\n93#2,2:395\n33#2,4:397\n95#2,2:401\n38#2:403\n97#2:404\n*S KotlinDebug\n*F\n+ 1 RecomposeScopeImpl.kt\nandroidx/compose/runtime/RecomposeScopeImpl$Companion\n*L\n373#1:389,6\n383#1:395,2\n383#1:397,4\n383#1:401,2\n383#1:403\n383#1:404\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter r5, List<Anchor> r10, RecomposeScopeOwner r11) {
            Intrinsics.checkNotNullParameter(r5, "slots");
            Intrinsics.checkNotNullParameter(r10, "anchors");
            Intrinsics.checkNotNullParameter(r11, "newOwner");
            if (r10.isEmpty() == true) goto L13;
            int r12 = r10.size();
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L17;
            Object r14 = r5.slot(r10.get(r13), 0);
            if ((r14 instanceof RecomposeScopeImpl) == false) goto L9;
            RecomposeScopeImpl r15 = (RecomposeScopeImpl) r14;
        L10:
            if (r15 == null) goto L12;
            r15.adoptedBy(r11);
        L12:
            r13 = r13 + 1;
            goto L5
        L9:
            r15 = null;
            goto L10
        L17:
            return;
        }

        public final boolean hasAnchoredRecomposeScopes$runtime_release(SlotTable r5, List<Anchor> r10) {
            Intrinsics.checkNotNullParameter(r5, "slots");
            Intrinsics.checkNotNullParameter(r10, "anchors");
            if (r10.isEmpty() == true) goto L12;
            int r11 = r10.size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L18;
            Anchor r13 = r10.get(r12);
            if (r5.ownsAnchor(r13) == false) goto L11;
            if ((r5.slot$runtime_release(r5.anchorIndex(r13), 0) instanceof RecomposeScopeImpl) == false) goto L11;
            return true;
        L11:
            r12 = r12 + 1;
            goto L5
        L18:
            return false;
        L12:
            return false;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RecomposeScopeImpl(RecomposeScopeOwner r5) {
        this.owner = r5;
    }

    public static final /* synthetic */ int access$getCurrentToken$p(RecomposeScopeImpl r5) {
        return r5.currentToken;
    }

    public static final /* synthetic */ IdentityArrayMap access$getTrackedDependencies$p(RecomposeScopeImpl r5) {
        return r5.trackedDependencies;
    }

    public static final /* synthetic */ IdentityArrayIntMap access$getTrackedInstances$p(RecomposeScopeImpl r5) {
        return r5.trackedInstances;
    }

    public static final /* synthetic */ void access$setTrackedDependencies$p(RecomposeScopeImpl r5, IdentityArrayMap r10) {
        r5.trackedDependencies = r10;
    }

    public static final /* synthetic */ void access$setTrackedInstances$p(RecomposeScopeImpl r5, IdentityArrayIntMap r10) {
        r5.trackedInstances = r10;
    }

    private final boolean getRereading() {
        if ((this.flags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setRereading(boolean r5) {
        if (r5 == false) goto L4;
        this.flags |= 32;
        return;
    L4:
        this.flags &= -33;
    }

    private final void setSkipped(boolean r5) {
        if (r5 == false) goto L4;
        this.flags |= 16;
        return;
    L4:
        this.flags &= -17;
    }

    public final void adoptedBy(RecomposeScopeOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        this.owner = r5;
    }

    public final void compose(Composer r5) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Function2<? super Composer, ? super Integer, Unit> r10 = this.block;
        if (r10 == null) goto L5;
        r10.mo2invoke(r5, 1);
        Unit r11 = Unit.INSTANCE;
    L6:
        if (r11 == null) goto L9;
        return;
    L9:
        throw new IllegalStateException("Invalid restart scope");
    L5:
        r11 = null;
        goto L6
    }

    public final Function1<Composition, Unit> end(final int r10) {
        final IdentityArrayIntMap r5 = this.trackedInstances;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (getSkipped$runtime_release() == true) goto L15;
        Object[] r11 = r5.getKeys();
        int[] r12 = r5.getValues();
        int r13 = r5.getSize();
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L17;
        Intrinsics.checkNotNull(r11[r14], "null cannot be cast to non-null type kotlin.Any");
        if (r12[r14] != r10) goto L16;
        r14 = r14 + 1;
        goto L7
    L16:
        return new RecomposeScopeImpl$end$1$2(this, r10, r5);
    L17:
        return null;
    L15:
        return null;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        if (this.block == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getDefaultsInScope() {
        if ((this.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getDefaultsInvalid() {
        if ((this.flags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getRequiresRecompose() {
        if ((this.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getSkipped$runtime_release() {
        if ((this.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getUsed() {
        if ((this.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean getValid() {
        if (this.owner == null) goto L11;
        Anchor r5 = this.anchor;
        if (r5 == null) goto L7;
        boolean r10 = r5.getValid();
    L8:
        if (r10 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r10 = false;
        goto L8
    L11:
        return false;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner r5 = this.owner;
        if (r5 == null) goto L6;
        r5.invalidate(this, null);
        return;
    }

    public final InvalidationResult invalidateForResult(Object r5) {
        RecomposeScopeOwner r10 = this.owner;
        if (r10 == null) goto L7;
        InvalidationResult r11 = r10.invalidate(this, r5);
        if (r11 == null) goto L7;
        return r11;
    L7:
        return InvalidationResult.IGNORED;
    }

    public final boolean isConditional() {
        if (this.trackedDependencies == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInvalidFor(IdentityArraySet<Object> r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        IdentityArrayMap<DerivedState<?>, Object> r10 = this.trackedDependencies;
        if (r10 != null) goto L9;
        return true;
    L9:
        if (r5.isNotEmpty() == true) goto L11;
    L26:
        return true;
    L11:
        if (r5.isEmpty() == true) goto L24;
        Iterator<Object> r11 = r5.iterator();
    L15:
        if (r11.hasNext() == false) goto L31;
        Object r12 = r11.next();
        if ((r12 instanceof DerivedState) == false) goto L26;
        DerivedState<?> r13 = (DerivedState) r12;
        SnapshotMutationPolicy<?> r14 = r13.getPolicy();
        if (r14 != null) goto L22;
        r14 = SnapshotStateKt.structuralEqualityPolicy();
    L22:
        if (r14.equivalent(r13.getCurrentRecord().getCurrentValue(), r10.get(r13)) == false) goto L26;
    L31:
        return false;
    L24:
        return false;
    }

    public final boolean recordRead(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "instance");
        int r10 = 0;
        if (getRereading() == false) goto L5;
        return false;
    L5:
        IdentityArrayIntMap r11 = this.trackedInstances;
        if (r11 != null) goto L8;
        r11 = new IdentityArrayIntMap();
        this.trackedInstances = r11;
    L8:
        int r12 = 1;
        if (r11.add(r5, this.currentToken) != this.currentToken) goto L12;
        return true;
    L12:
        if ((r5 instanceof DerivedState) == false) goto L17;
        IdentityArrayMap<DerivedState<?>, Object> r13 = this.trackedDependencies;
        if (r13 != null) goto L16;
        r13 = new IdentityArrayMap(r10, r12, null);
        this.trackedDependencies = r13;
    L16:
        r13.set(r5, ((DerivedState) r5).getCurrentRecord().getCurrentValue());
    L17:
        return false;
    }

    public final void release() {
        RecomposeScopeOwner r5 = this.owner;
        if (r5 == null) goto L5;
        r5.recomposeScopeReleased(this);
    L5:
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void rereadTrackedInstances() {
        RecomposeScopeOwner r5 = this.owner;
        if (r5 == null) goto L16;
        IdentityArrayIntMap r10 = this.trackedInstances;
        if (r10 == null) goto L20;
        setRereading(true);
        Object[] r11 = r10.getKeys();     // Catch: Throwable -> L11
        int[] r12 = r10.getValues();     // Catch: Throwable -> L11
        int r13 = r10.getSize();     // Catch: Throwable -> L11
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        Object r15 = r11[r14];     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L11
        int r16 = r12[r14];     // Catch: Throwable -> L11
        r5.recordReadOf(r15);     // Catch: Throwable -> L11
        r14 = r14 + 1;
        goto L8
    L13:
        setRereading(false);
        return;
    L11:
        th = move-exception;
        setRereading(false);
        throw th;
    L20:
        return;
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final void setAnchor(Anchor r5) {
        this.anchor = r5;
    }

    public final void setDefaultsInScope(boolean r5) {
        if (r5 == false) goto L4;
        this.flags |= 2;
        return;
    L4:
        this.flags &= -3;
    }

    public final void setDefaultsInvalid(boolean r5) {
        if (r5 == false) goto L4;
        this.flags |= 4;
        return;
    L4:
        this.flags &= -5;
    }

    public final void setRequiresRecompose(boolean r5) {
        if (r5 == false) goto L4;
        this.flags |= 8;
        return;
    L4:
        this.flags &= -9;
    }

    public final void setUsed(boolean r5) {
        if (r5 == false) goto L4;
        this.flags |= 1;
        return;
    L4:
        this.flags &= -2;
    }

    public final void start(int r5) {
        this.currentToken = r5;
        setSkipped(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        this.block = r5;
    }
}
