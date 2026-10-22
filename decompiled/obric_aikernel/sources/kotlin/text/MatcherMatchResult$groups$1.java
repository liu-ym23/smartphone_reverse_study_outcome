package kotlin.text;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult this$0;

    MatcherMatchResult$groups$1(MatcherMatchResult r10) {
        this.this$0 = r10;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if (r10 != null) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == true) goto L9;
        return false;
    L9:
        return contains((MatchGroup) r10);
    L4:
        r11 = r10 instanceof MatchGroup;
        goto L5
    }

    public /* bridge */ boolean contains(MatchGroup r10) {
        return super.contains(r10);
    }

    @Override // kotlin.text.MatchGroupCollection
    public MatchGroup get(int r10) {
        IntRange r11 = RegexKt.access$range(MatcherMatchResult.access$getMatchResult(this.this$0), r10);
        if (r11.getStart().intValue() < 0) goto L5;
        String r12 = MatcherMatchResult.access$getMatchResult(this.this$0).group(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "matchResult.group(index)");
        return new MatchGroup(r12, r11);
    L5:
        return null;
    }

    @Override // kotlin.text.MatchNamedGroupCollection
    public MatchGroup get(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(MatcherMatchResult.access$getMatchResult(this.this$0), r10);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }
}
