package androidx.room.log;

import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMessager;
import androidx.room.processor.Context;
import androidx.room.vo.Warning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0003 !\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ/\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u0017J'\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u0018J/\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u0017J'\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u0018J;\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u001cJ/\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u001dJ%\u0010\u001e\u001a\u00020\u0014*\u00020\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Landroidx/room/log/RLog;", "", "messager", "Landroidx/room/compiler/processing/XMessager;", "suppressedWarnings", "", "Landroidx/room/vo/Warning;", "defaultElement", "Landroidx/room/compiler/processing/XElement;", "(Landroidx/room/compiler/processing/XMessager;Ljava/util/Set;Landroidx/room/compiler/processing/XElement;)V", "getDefaultElement", "()Landroidx/room/compiler/processing/XElement;", "getMessager", "()Landroidx/room/compiler/processing/XMessager;", "getSuppressedWarnings", "()Ljava/util/Set;", "d", "", "element", "msg", "", "args", "", "(Landroidx/room/compiler/processing/XElement;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/String;[Ljava/lang/Object;)V", "e", "w", "warning", "(Landroidx/room/vo/Warning;Landroidx/room/compiler/processing/XElement;Ljava/lang/String;[Ljava/lang/Object;)V", "(Landroidx/room/vo/Warning;Ljava/lang/String;[Ljava/lang/Object;)V", "safeFormat", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "CollectingMessager", "Companion", "DiagnosticMessage", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RLog {
    public static final Companion Companion = null;
    public static final String MISSING_TYPE_PREFIX = "[MissingType]";
    private static final Function2<Diagnostic.Kind, String, Boolean> MissingTypeErrorFilter = null;
    private final XElement defaultElement;
    private final XMessager messager;
    private final Set<Warning> suppressedWarnings;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ6\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J*\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u001a\b\u0002\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u001aR \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/room/log/RLog$CollectingMessager;", "Landroidx/room/compiler/processing/XMessager;", "()V", "messages", "", "Ljavax/tools/Diagnostic$Kind;", "", "Landroidx/room/log/RLog$DiagnosticMessage;", "hasErrors", "", "hasMissingTypeErrors", "onPrintMessage", "", "kind", "msg", "", "element", "Landroidx/room/compiler/processing/XElement;", "annotation", "Landroidx/room/compiler/processing/XAnnotation;", "annotationValue", "Landroidx/room/compiler/processing/XAnnotationValue;", "writeTo", "context", "Landroidx/room/processor/Context;", "filterPredicate", "Lkotlin/Function2;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CollectingMessager extends XMessager {
        private final Map<Diagnostic.Kind, List<DiagnosticMessage>> messages;

        public CollectingMessager() {
            this.messages = new LinkedHashMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void writeTo$default(CollectingMessager r5, Context r10, Function2 r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L5;
            r11 = RLog$CollectingMessager$writeTo$1.INSTANCE;
        L5:
            r5.writeTo(r10, r11);
        }

        public final boolean hasErrors() {
            return this.messages.containsKey(Diagnostic.Kind.ERROR);
        }

        public final boolean hasMissingTypeErrors() {
            List<DiagnosticMessage> r5 = this.messages.get(Diagnostic.Kind.ERROR);
            if (r5 != null) goto L5;
            r5 = CollectionsKt.emptyList();
        L5:
            List<DiagnosticMessage> r10 = r5;
            if ((r10 instanceof Collection) == true) goto L8;
        L10:
            Iterator<T> r11 = r10.iterator();
        L12:
            if (r11.hasNext() == false) goto L21;
            if (StringsKt.P(((DiagnosticMessage) r11.next()).getMsg(), RLog.MISSING_TYPE_PREFIX) == false) goto L12;
            return true;
        L21:
            return false;
        L8:
            if (r10.isEmpty() == false) goto L10;
            return false;
        }

        @Override // androidx.room.compiler.processing.XMessager
        public void onPrintMessage(Diagnostic.Kind r5, String r10, XElement r11, XAnnotation r12, XAnnotationValue r13) {
            Intrinsics.checkNotNullParameter(r5, "kind");
            Intrinsics.checkNotNullParameter(r10, "msg");
            Map<Diagnostic.Kind, List<DiagnosticMessage>> r14 = this.messages;
            List<DiagnosticMessage> r15 = r14.get(r5);
            if (r15 != null) goto L5;
            r15 = new ArrayList();
            r14.put(r5, r15);
        L5:
            r15.add(new DiagnosticMessage(r10, r11, r12, r13));
        }

        public final void writeTo(Context r10, Function2<? super Diagnostic.Kind, ? super String, Boolean> r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "filterPredicate");
            Iterator<Map.Entry<Diagnostic.Kind, List<DiagnosticMessage>>> r12 = this.messages.entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L15;
            Map.Entry<Diagnostic.Kind, List<DiagnosticMessage>> r5 = r12.next();
            Diagnostic.Kind r13 = r5.getKey();
            List<DiagnosticMessage> r14 = r5.getValue();
            ArrayList r15 = new ArrayList();
            Iterator<T> r16 = r14.iterator();
        L7:
            if (r16.hasNext() == false) goto L11;
            Object r17 = r16.next();
            if (r11.mo2invoke(r13, ((DiagnosticMessage) r17).getMsg()).booleanValue() == false) goto L7;
            r15.add(r17);
            goto L7
        L11:
            Iterator r18 = r15.iterator();
        L13:
            if (r18.hasNext() == false) goto L4;
            DiagnosticMessage r19 = (DiagnosticMessage) r18.next();
            Companion.access$printToMessager(RLog.Companion, r10.getLogger().getMessager(), r13, r19.getMsg(), r19.getElement(), r19.getAnnotation(), r19.getAnnotationValue());
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/room/log/RLog$Companion;", "", "()V", "MISSING_TYPE_PREFIX", "", "MissingTypeErrorFilter", "Lkotlin/Function2;", "Ljavax/tools/Diagnostic$Kind;", "", "getMissingTypeErrorFilter", "()Lkotlin/jvm/functions/Function2;", "printToMessager", "", "messager", "Landroidx/room/compiler/processing/XMessager;", "kind", "msg", "element", "Landroidx/room/compiler/processing/XElement;", "annotation", "Landroidx/room/compiler/processing/XAnnotation;", "annotationValue", "Landroidx/room/compiler/processing/XAnnotationValue;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ void access$printToMessager(Companion r5, XMessager r10, Diagnostic.Kind r11, String r12, XElement r13, XAnnotation r14, XAnnotationValue r15) {
            r5.printToMessager(r10, r11, r12, r13, r14, r15);
        }

        private final void printToMessager(XMessager r5, Diagnostic.Kind r10, String r11, XElement r12, XAnnotation r13, XAnnotationValue r14) {
            if (r12 != null) goto L8;
            if (r13 != null) goto L7;
            if (r14 != null) goto L7;
            r5.printMessage(r10, r11);
            return;
        L7:
            throw new IllegalStateException("If element is null, annotation and annotationValue must also be null.");
        L8:
            if (r13 != null) goto L13;
            if (r14 != null) goto L12;
            r5.printMessage(r10, r11, r12);
            return;
        L12:
            throw new IllegalStateException("If annotation is null, annotationValue must also be null.");
        L13:
            if (r14 != null) goto L15;
            r5.printMessage(r10, r11, r12, r13);
            return;
        L15:
            r5.printMessage(r10, r11, r12, r13, r14);
        }

        public static /* synthetic */ void printToMessager$default(Companion r10, XMessager r11, Diagnostic.Kind r12, String r13, XElement r14, XAnnotation r15, XAnnotationValue r16, int r17, Object r18) {
            if ((r17 & 8) == 0) goto L5;
            XElement r19 = null;
        L7:
            if ((r17 & 16) == 0) goto L9;
            XAnnotation r20 = null;
        L11:
            if ((r17 & 32) == 0) goto L13;
            XAnnotationValue r21 = null;
        L14:
            r10.printToMessager(r11, r12, r13, r19, r20, r21);
            return;
        L13:
            r21 = r16;
            goto L14
        L9:
            r20 = r15;
            goto L11
        L5:
            r19 = r14;
            goto L7
        }

        public final Function2<Diagnostic.Kind, String, Boolean> getMissingTypeErrorFilter() {
            return RLog.access$getMissingTypeErrorFilter$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/room/log/RLog$DiagnosticMessage;", "", "msg", "", "element", "Landroidx/room/compiler/processing/XElement;", "annotation", "Landroidx/room/compiler/processing/XAnnotation;", "annotationValue", "Landroidx/room/compiler/processing/XAnnotationValue;", "(Ljava/lang/String;Landroidx/room/compiler/processing/XElement;Landroidx/room/compiler/processing/XAnnotation;Landroidx/room/compiler/processing/XAnnotationValue;)V", "getAnnotation", "()Landroidx/room/compiler/processing/XAnnotation;", "getAnnotationValue", "()Landroidx/room/compiler/processing/XAnnotationValue;", "getElement", "()Landroidx/room/compiler/processing/XElement;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DiagnosticMessage {
        private final XAnnotation annotation;
        private final XAnnotationValue annotationValue;
        private final XElement element;
        private final String msg;

        public DiagnosticMessage(String r5, XElement r10, XAnnotation r11, XAnnotationValue r12) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            this.msg = r5;
            this.element = r10;
            this.annotation = r11;
            this.annotationValue = r12;
        }

        public static /* synthetic */ DiagnosticMessage copy$default(DiagnosticMessage r5, String r10, XElement r11, XAnnotation r12, XAnnotationValue r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = r5.msg;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = r5.element;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = r5.annotation;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r13 = r5.annotationValue;
        L15:
            return r5.copy(r10, r11, r12, r13);
        }

        public final String component1() {
            return this.msg;
        }

        public final XElement component2() {
            return this.element;
        }

        public final XAnnotation component3() {
            return this.annotation;
        }

        public final XAnnotationValue component4() {
            return this.annotationValue;
        }

        public final DiagnosticMessage copy(String r5, XElement r10, XAnnotation r11, XAnnotationValue r12) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            return new DiagnosticMessage(r5, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DiagnosticMessage) == true) goto L8;
            return false;
        L8:
            DiagnosticMessage r10 = (DiagnosticMessage) r5;
            if (Intrinsics.areEqual(this.msg, r10.msg) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.element, r10.element) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.annotation, r10.annotation) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.annotationValue, r10.annotationValue) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final XAnnotation getAnnotation() {
            return this.annotation;
        }

        public final XAnnotationValue getAnnotationValue() {
            return this.annotationValue;
        }

        public final XElement getElement() {
            return this.element;
        }

        public final String getMsg() {
            return this.msg;
        }

        public int hashCode() {
            int r5 = this.msg.hashCode() * 31;
            XElement r10 = this.element;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r5 + r12) * 31;
            XAnnotation r14 = this.annotation;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            XAnnotationValue r17 = this.annotationValue;
            if (r17 == null) goto L15;
            r11 = r17.hashCode();
        L15:
            return r16 + r11;
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public String toString() {
            return "DiagnosticMessage(msg=" + this.msg + ", element=" + this.element + ", annotation=" + this.annotation + ", annotationValue=" + this.annotationValue + ")";
        }
    }

    static {
        Companion = new Companion(null);
        MissingTypeErrorFilter = RLog$Companion$MissingTypeErrorFilter$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RLog(XMessager r5, Set<? extends Warning> r10, XElement r11) {
        Intrinsics.checkNotNullParameter(r5, "messager");
        Intrinsics.checkNotNullParameter(r10, "suppressedWarnings");
        this.messager = r5;
        this.suppressedWarnings = r10;
        this.defaultElement = r11;
    }

    public static final /* synthetic */ Function2 access$getMissingTypeErrorFilter$cp() {
        return MissingTypeErrorFilter;
    }

    private final String safeFormat(String r5, Object... r10) {
        return String.format(r5, Arrays.copyOf(new Object[]{r10}, 1));
    L4:
        return r5;
    }

    public static /* synthetic */ void w$default(RLog r5, Warning r10, XElement r11, String r12, Object[] r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r11 = null;
    L5:
        r5.w(r10, r11, r12, r13);
    }

    public final void d(XElement r11, String r12, Object... r13) {
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(r13, "args");
        Companion.printToMessager$default(Companion, this.messager, Diagnostic.Kind.NOTE, safeFormat(r12, new Object[]{r13}), r11, null, null, 48, null);
    }

    public final void e(XElement r11, String r12, Object... r13) {
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(r13, "args");
        Companion.printToMessager$default(Companion, this.messager, Diagnostic.Kind.ERROR, safeFormat(r12, new Object[]{r13}), r11, null, null, 48, null);
    }

    public final XElement getDefaultElement() {
        return this.defaultElement;
    }

    public final XMessager getMessager() {
        return this.messager;
    }

    public final Set<Warning> getSuppressedWarnings() {
        return this.suppressedWarnings;
    }

    public final void w(Warning r10, XElement r11, String r12, Object... r13) {
        Intrinsics.checkNotNullParameter(r10, "warning");
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(r13, "args");
        if (this.suppressedWarnings.contains(r10) == false) goto L5;
        return;
    L5:
        Companion r5 = Companion;
        XMessager r14 = this.messager;
        Diagnostic.Kind r15 = Diagnostic.Kind.WARNING;
        String r16 = safeFormat(r12, new Object[]{r13});
        if (r11 != null) goto L8;
        r11 = this.defaultElement;
    L8:
        Companion.printToMessager$default(r5, r14, r15, r16, r11, null, null, 48, null);
    }

    public final void d(String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "args");
        Companion.printToMessager$default(Companion, this.messager, Diagnostic.Kind.NOTE, safeFormat(r11, new Object[]{r12}), null, null, null, 56, null);
    }

    public final void e(String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "args");
        Companion.printToMessager$default(Companion, this.messager, Diagnostic.Kind.ERROR, safeFormat(r11, new Object[]{r12}), this.defaultElement, null, null, 48, null);
    }

    public final void w(Warning r10, String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r10, "warning");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "args");
        if (this.suppressedWarnings.contains(r10) == false) goto L5;
        return;
    L5:
        Companion.printToMessager$default(Companion, this.messager, Diagnostic.Kind.WARNING, safeFormat(r11, new Object[]{r12}), this.defaultElement, null, null, 48, null);
    }
}
