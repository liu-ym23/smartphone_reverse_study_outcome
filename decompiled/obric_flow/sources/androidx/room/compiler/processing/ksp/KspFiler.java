package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.compiler.processing.XFiler;
import androidx.room.compiler.processing.XMessager;
import androidx.room.compiler.processing.util.ErrorMessagesKt;
import com.bytedance.keva.KevaImpl;
import com.squareup.javapoet.o;
import com.squareup.kotlinpoet.i;
import com.squareup.kotlinpoet.r;
import hl.b;
import il.c;
import il.f;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"¨\u0006$"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspFiler;", "Landroidx/room/compiler/processing/XFiler;", "Lhl/a;", "delegate", "Landroidx/room/compiler/processing/XMessager;", "messager", "<init>", "(Lhl/a;Landroidx/room/compiler/processing/XMessager;)V", "Landroidx/room/compiler/processing/ksp/KspFiler$OriginatingElements;", "originatingElements", "", "packageName", "fileName", "extensionName", "", "aggregating", "Ljava/io/OutputStream;", "createNewFile", "(Landroidx/room/compiler/processing/ksp/KspFiler$OriginatingElements;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/io/OutputStream;", "", "Ljavax/lang/model/element/Element;", "toOriginatingElements", "(Ljava/util/List;)Landroidx/room/compiler/processing/ksp/KspFiler$OriginatingElements;", "Lcom/squareup/javapoet/o;", "javaFile", "Landroidx/room/compiler/processing/XFiler$Mode;", "mode", "", "write", "(Lcom/squareup/javapoet/o;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Lcom/squareup/kotlinpoet/i;", "fileSpec", "(Lcom/squareup/kotlinpoet/i;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Lhl/a;", "Landroidx/room/compiler/processing/XMessager;", "OriginatingElements", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspFiler implements XFiler {
    private final hl.a delegate;
    private final XMessager messager;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ0\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspFiler$OriginatingElements;", "", "", "Lil/f;", KevaImpl.PrivateConstants.FILES_DIR_NAME, "Lil/c;", "classes", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "isEmpty", "()Z", "component1", "()Ljava/util/List;", "component2", "copy", "(Ljava/util/List;Ljava/util/List;)Landroidx/room/compiler/processing/ksp/KspFiler$OriginatingElements;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFiles", "getClasses", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class OriginatingElements {
        private final List<c> classes;
        private final List<f> files;

        /* JADX WARN: Multi-variable type inference failed */
        public OriginatingElements(List<? extends f> r5, List<? extends c> r10) {
            Intrinsics.checkNotNullParameter(r5, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            Intrinsics.checkNotNullParameter(r10, "classes");
            this.files = r5;
            this.classes = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OriginatingElements copy$default(OriginatingElements r5, List r10, List r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.files;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.classes;
        L9:
            return r5.copy(r10, r11);
        }

        public final List<f> component1() {
            return this.files;
        }

        public final List<c> component2() {
            return this.classes;
        }

        public final OriginatingElements copy(List<? extends f> r5, List<? extends c> r10) {
            Intrinsics.checkNotNullParameter(r5, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            Intrinsics.checkNotNullParameter(r10, "classes");
            return new OriginatingElements(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof OriginatingElements) == true) goto L8;
            return false;
        L8:
            OriginatingElements r10 = (OriginatingElements) r5;
            if (Intrinsics.areEqual(this.files, r10.files) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.classes, r10.classes) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final List<c> getClasses() {
            return this.classes;
        }

        public final List<f> getFiles() {
            return this.files;
        }

        public int hashCode() {
            int r5 = this.files.hashCode() * 31;
            return this.classes.hashCode() + r5;
        }

        public final boolean isEmpty() {
            if (this.files.isEmpty() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.classes.isEmpty() == false) goto L7;
            return true;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("OriginatingElements(files=");
            r5.append(this.files);
            r5.append(", classes=");
            return androidx.constraintlayout.motion.widget.a.v(r5, this.classes, ')');
        }
    }

    public KspFiler(hl.a r5, XMessager r10) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r10, "messager");
        this.messager = r10;
    }

    private final OutputStream createNewFile(OriginatingElements r5, String r10, String r11, String r12, boolean r13) {
        if (r5.isEmpty() == false) goto L5;
        XMessager r14 = this.messager;
        Diagnostic.Kind r15 = Diagnostic.Kind.WARNING;
        StringBuilder r16 = j0.x("\n                    No dependencies are reported for ", r11, " which will prevent\n                    incremental compilation.\n                    Please file a bug at ");
        r16.append(ErrorMessagesKt.getISSUE_TRACKER_LINK());
        r16.append(".\n                ");
        r14.printMessage(r15, StringsKt.trimIndent(r16.toString()));
        int r17 = b.f17337b;
        wn.f.i();
    L7:
        if (r5.getClasses().isEmpty() == true) goto L10;
        r5.getClasses();
        throw null;
    L10:
        throw null;
    L5:
        Object[] r18 = CollectionsKt.distinct(r5.getFiles()).toArray(new f[0]);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        f[] r19 = (f[]) r18;
        new b(r13, (f[]) Arrays.copyOf(r19, r19.length));
        goto L7
    }

    private final OriginatingElements toOriginatingElements(List<? extends Element> r5) {
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        Element r13 = (Element) r12.next();
        if ((r13 instanceof KSFileAsOriginatingElement) == true) goto L7;
        if ((r13 instanceof KSClassDeclarationAsOriginatingElement) == false) goto L12;
        ((KSClassDeclarationAsOriginatingElement) r13).getKsClassDeclaration();
        r11.add(null);
        goto L4
    L12:
        throw new IllegalStateException(("Unexpected element type in originating elements. " + r13).toString());
    L7:
        ((KSFileAsOriginatingElement) r13).getKsFile();
        r10.add(null);
        goto L4
    L14:
        return new OriginatingElements(r10, r11);
    }

    @Override // androidx.room.compiler.processing.XFiler
    public void write(o r10, XFiler.Mode r11) {
        Intrinsics.checkNotNullParameter(r10, "javaFile");
        Intrinsics.checkNotNullParameter(r11, "mode");
        OriginatingElements r5 = toOriginatingElements(r10.f14996c.f15065q);
        String r12 = r10.f14996c.f15054b;
        if (r11 != XFiler.Mode.Aggregating) goto L6;
        boolean r13 = true;
    L5:
        boolean r14 = r13;
        OutputStream r15 = createNewFile(r5, r10.f14995b, r12, "java", r14);
        BufferedWriter r16 = new BufferedWriter(new OutputStreamWriter(r15, Charsets.UTF_8), 8192);     // Catch: Throwable -> L14
        r10.c(r16);     // Catch: Throwable -> L16
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L11:
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r15, null);
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L6:
        r13 = false;
        goto L5
    }

    @Override // androidx.room.compiler.processing.XFiler
    public void write(i r10, XFiler.Mode r11) {
        Intrinsics.checkNotNullParameter(r10, "fileSpec");
        Intrinsics.checkNotNullParameter(r11, "mode");
        List r5 = r10.e;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if ((r14 instanceof r) == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r12.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        CollectionsKt.a(r15, ((r) r16.next()).a());
        goto L10
    L12:
        OriginatingElements r17 = toOriginatingElements(r15);
        if (r11 != XFiler.Mode.Aggregating) goto L16;
        boolean r18 = true;
    L15:
        boolean r19 = r18;
        String r20 = r10.d;
        OutputStream r21 = createNewFile(r17, r10.f15155c, r20, "kt", r19);
        BufferedWriter r22 = new BufferedWriter(new OutputStreamWriter(r21, Charsets.UTF_8), 8192);     // Catch: Throwable -> L24
        r10.b(r22);     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L21:
        CloseableKt.closeFinally(r22, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r21, null);
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r22, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r21, th);
        throw th;
    L16:
        r18 = false;
        goto L15
    }
}
