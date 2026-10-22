package androidx.room.parser.expansion;

import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.parser.SQLiteParser;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u0002H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0006"}, d2 = {"isCoreSelect", "", "Landroidx/room/jarjarred/org/antlr/v4/runtime/RuleContext;", "(Lorg/antlr/v4/runtime/RuleContext;)Z", "ancestors", "Lkotlin/sequences/Sequence;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExpandableSqlParserKt {
    private static final Sequence<RuleContext> ancestors(RuleContext r5) {
        return SequencesKt.generateSequence(r5.parent, AnonymousClass1.INSTANCE);
    }

    public static final boolean isCoreSelect(RuleContext r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof SQLiteParser.Select_or_valuesContext) == false) goto L11;
        Iterator<RuleContext> r10 = ancestors(r5).iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        if ((r10.next() instanceof SQLiteParser.Select_or_valuesContext) == false) goto L6;
    L10:
        return true;
    L11:
        return false;
    }
}
