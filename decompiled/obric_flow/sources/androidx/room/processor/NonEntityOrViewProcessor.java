package androidx.room.processor;

import androidx.room.compiler.processing.XTypeElement;
import androidx.room.vo.EntityOrView;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/processor/NonEntityOrViewProcessor;", "Landroidx/room/processor/EntityOrViewProcessor;", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Ljava/util/LinkedHashSet;)V", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "process", "Landroidx/room/vo/EntityOrView;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class NonEntityOrViewProcessor implements EntityOrViewProcessor {
    private final Context context;
    private final XTypeElement element;
    private final LinkedHashSet<String> referenceStack;

    public NonEntityOrViewProcessor(Context r5, XTypeElement r10, LinkedHashSet<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "referenceStack");
        this.context = r5;
        this.element = r10;
        this.referenceStack = r11;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    @Override // androidx.room.processor.EntityOrViewProcessor
    public EntityOrView process() {
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getNOT_ENTITY_OR_VIEW(), new Object[0]);
        PojoProcessor.Companion.createFor(this.context, this.element, FieldProcessor.BindingScope.READ_FROM_CURSOR, null, this.referenceStack).process();
        return new AnonymousClass1(this);
    }
}
