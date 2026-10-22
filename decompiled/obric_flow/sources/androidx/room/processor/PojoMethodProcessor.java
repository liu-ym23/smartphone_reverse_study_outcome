package androidx.room.processor;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.vo.PojoMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/processor/PojoMethodProcessor;", "", "context", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XMethodElement;", "owner", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;)V", "process", "Landroidx/room/vo/PojoMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PojoMethodProcessor {
    private final Context context;
    private final XMethodElement element;
    private final XType owner;

    public PojoMethodProcessor(Context r5, XMethodElement r10, XType r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "owner");
        this.context = r5;
        this.element = r10;
        this.owner = r11;
    }

    public final PojoMethod process() {
        XMethodType r5 = this.element.asMemberOf(this.owner);
        return new PojoMethod(this.element, r5);
    }
}
