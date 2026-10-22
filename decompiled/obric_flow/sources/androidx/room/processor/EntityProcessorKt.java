package androidx.room.processor;

import androidx.room.Fts3;
import androidx.room.Fts4;
import androidx.room.compiler.processing.XTypeElement;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¨\u0006\n"}, d2 = {"EntityProcessor", "Landroidx/room/processor/EntityProcessor;", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EntityProcessorKt {
    public static final EntityProcessor EntityProcessor(Context r5, XTypeElement r10, LinkedHashSet<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "referenceStack");
        if (r10.hasAnyAnnotation(new KClass[]{Reflection.getOrCreateKotlinClass(Fts3.class), Reflection.getOrCreateKotlinClass(Fts4.class)}) == false) goto L6;
        return new FtsTableEntityProcessor(r5, r10, r11);
    L6:
        return new TableEntityProcessor(r5, r10, r11);
    }

    public static /* synthetic */ EntityProcessor EntityProcessor$default(Context r5, XTypeElement r10, LinkedHashSet r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = new LinkedHashSet();
    L6:
        return EntityProcessor(r5, r10, r11);
    }
}
