package androidx.room.processor;

import androidx.room.DatabaseView;
import androidx.room.Entity;
import androidx.room.compiler.processing.XTypeElement;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¨\u0006\n"}, d2 = {"EntityOrViewProcessor", "Landroidx/room/processor/EntityOrViewProcessor;", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EntityOrViewProcessorKt {
    public static final EntityOrViewProcessor EntityOrViewProcessor(Context r10, XTypeElement r11, LinkedHashSet<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "referenceStack");
        if (r11.hasAnnotation(Reflection.getOrCreateKotlinClass(Entity.class)) == false) goto L6;
        return EntityProcessorKt.EntityProcessor(r10, r11, r12);
    L6:
        if (r11.hasAnnotation(Reflection.getOrCreateKotlinClass(DatabaseView.class)) == false) goto L9;
        return new DatabaseViewProcessor(r10, r11, null, 4, null);
    L9:
        return new NonEntityOrViewProcessor(r10, r11, r12);
    }

    public static /* synthetic */ EntityOrViewProcessor EntityOrViewProcessor$default(Context r5, XTypeElement r10, LinkedHashSet r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = new LinkedHashSet();
    L6:
        return EntityOrViewProcessor(r5, r10, r11);
    }
}
