package androidx.room.compiler.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0000J<\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H$J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J.\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J<\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/room/compiler/processing/XMessager;", "", "()V", "watchers", "", "addMessageWatcher", "", "watcher", "onPrintMessage", "kind", "Ljavax/tools/Diagnostic$Kind;", "msg", "", "element", "Landroidx/room/compiler/processing/XElement;", "annotation", "Landroidx/room/compiler/processing/XAnnotation;", "annotationValue", "Landroidx/room/compiler/processing/XAnnotationValue;", "printMessage", "printMsg", "removeMessageWatcher", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class XMessager {
    private final List<XMessager> watchers;

    public XMessager() {
        this.watchers = new ArrayList();
    }

    public static /* synthetic */ void onPrintMessage$default(XMessager r10, Diagnostic.Kind r11, String r12, XElement r13, XAnnotation r14, XAnnotationValue r15, int r16, Object r17) {
        if (r17 != null) goto L18;
        if ((r16 & 4) == 0) goto L6;
        XElement r5 = null;
    L8:
        if ((r16 & 8) == 0) goto L10;
        XAnnotation r18 = null;
    L12:
        if ((r16 & 16) == 0) goto L14;
        XAnnotationValue r19 = null;
    L15:
        r10.onPrintMessage(r11, r12, r5, r18, r19);
        return;
    L14:
        r19 = r15;
        goto L15
    L10:
        r18 = r14;
        goto L12
    L6:
        r5 = r13;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPrintMessage");
    }

    private final void printMsg(Diagnostic.Kind r10, String r11, XElement r12, XAnnotation r13, XAnnotationValue r14) {
        Iterator<T> r5 = this.watchers.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((XMessager) r5.next()).printMsg(r10, r11, r12, r13, r14);
        goto L4
    L6:
        onPrintMessage(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void printMsg$default(XMessager r10, Diagnostic.Kind r11, String r12, XElement r13, XAnnotation r14, XAnnotationValue r15, int r16, Object r17) {
        if (r17 != null) goto L18;
        if ((r16 & 4) == 0) goto L6;
        XElement r5 = null;
    L8:
        if ((r16 & 8) == 0) goto L10;
        XAnnotation r18 = null;
    L12:
        if ((r16 & 16) == 0) goto L14;
        XAnnotationValue r19 = null;
    L15:
        r10.printMsg(r11, r12, r5, r18, r19);
        return;
    L14:
        r19 = r15;
        goto L15
    L10:
        r18 = r14;
        goto L12
    L6:
        r5 = r13;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: printMsg");
    }

    public final void addMessageWatcher(XMessager r5) {
        Intrinsics.checkNotNullParameter(r5, "watcher");
        this.watchers.add(r5);
    }

    public abstract void onPrintMessage(Diagnostic.Kind r5, String r10, XElement r11, XAnnotation r12, XAnnotationValue r13);

    public final void printMessage(Diagnostic.Kind r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "msg");
        printMsg$default(this, r10, r11, null, null, null, 28, null);
    }

    public final void removeMessageWatcher(XMessager r5) {
        Intrinsics.checkNotNullParameter(r5, "watcher");
        this.watchers.remove(r5);
    }

    public final void printMessage(Diagnostic.Kind r10, String r11, XElement r12) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "element");
        printMsg$default(this, r10, r11, r12, null, null, 24, null);
    }

    public final void printMessage(Diagnostic.Kind r10, String r11, XElement r12, XAnnotation r13) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "element");
        Intrinsics.checkNotNullParameter(r13, "annotation");
        printMsg$default(this, r10, r11, r12, r13, null, 16, null);
    }

    public final void printMessage(Diagnostic.Kind r5, String r10, XElement r11, XAnnotation r12, XAnnotationValue r13) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "annotation");
        Intrinsics.checkNotNullParameter(r13, "annotationValue");
        printMsg(r5, r10, r11, r12, r13);
    }
}
