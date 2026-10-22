package androidx.room.processor;

import androidx.room.DatabaseView;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.QueryType;
import androidx.room.parser.SqlParser;
import androidx.room.preconditions.Checks;
import androidx.room.vo.EntityOrView;
import androidx.room.vo.Pojo;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/room/processor/DatabaseViewProcessor;", "Landroidx/room/processor/EntityOrViewProcessor;", "baseContext", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Ljava/util/LinkedHashSet;)V", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "process", "Landroidx/room/vo/DatabaseView;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseViewProcessor implements EntityOrViewProcessor {
    public static final Companion Companion = null;
    private final Context context;
    private final XTypeElement element;
    private final LinkedHashSet<String> referenceStack;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/room/processor/DatabaseViewProcessor$Companion;", "", "()V", "extractViewName", "", "element", "Landroidx/room/compiler/processing/XTypeElement;", "annotation", "Landroidx/room/DatabaseView;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final String extractViewName(XTypeElement r5, DatabaseView r10) {
            Intrinsics.checkNotNullParameter(r5, "element");
            Intrinsics.checkNotNullParameter(r10, "annotation");
            if (Intrinsics.areEqual(r10.viewName(), "") == false) goto L6;
            return r5.getName();
        L6:
            return r10.viewName();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DatabaseViewProcessor(Context r5, XTypeElement r10, LinkedHashSet<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "referenceStack");
        this.element = r10;
        this.referenceStack = r11;
        this.context = Context.fork$default(r5, r10, null, 2, null);
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    @Override // androidx.room.processor.EntityOrViewProcessor
    public /* bridge */ /* synthetic */ EntityOrView process() {
        return process();
    }

    @Override // androidx.room.processor.EntityOrViewProcessor
    public androidx.room.vo.DatabaseView process() {
        Checks r5 = this.context.getChecker();
        XTypeElement r10 = this.element;
        KClass<? extends Annotation> r11 = Reflection.getOrCreateKotlinClass(DatabaseView.class);
        ProcessorErrors r12 = ProcessorErrors.INSTANCE;
        r5.hasAnnotation(r10, r11, r12.getVIEW_MUST_BE_ANNOTATED_WITH_DATABASE_VIEW(), new Object[0]);
        XAnnotationBox r13 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(DatabaseView.class));
        if (r13 == null) goto L6;
        String r14 = Companion.extractViewName(this.element, (DatabaseView) r13.getValue());
    L5:
        String r15 = r14;
        if (r13 == null) goto L15;
        ParsedQuery r16 = SqlParser.Companion.parse(((DatabaseView) r13.getValue()).value());
        this.context.getChecker().check(r16.getErrors().isEmpty(), this.element, CollectionsKt.q(r16.getErrors(), "\n", null, null, 0, null, null, 62), new Object[0]);
        Checks r17 = this.context.getChecker();
        if (r16.getType() != QueryType.SELECT) goto L12;
        boolean r18 = true;
    L13:
        r17.check(r18, this.element, r12.getVIEW_QUERY_MUST_BE_SELECT(), new Object[0]);
        this.context.getChecker().check(r16.getBindSections().isEmpty(), this.element, r12.getVIEW_QUERY_CANNOT_TAKE_ARGUMENTS(), new Object[0]);
    L14:
        ParsedQuery r19 = r16;
        this.context.getChecker().notBlank(r15, this.element, r12.getVIEW_NAME_CANNOT_BE_EMPTY(), new Object[0]);
        this.context.getChecker().check(true ^ StringsKt.M(r15, "sqlite_"), this.element, r12.getVIEW_NAME_CANNOT_START_WITH_SQLITE(), new Object[0]);
        Pojo r20 = PojoProcessor.Companion.createFor(this.context, this.element, FieldProcessor.BindingScope.READ_FROM_CURSOR, null, this.referenceStack).process();
        return new androidx.room.vo.DatabaseView(this.element, r15, r19, r20.getType(), r20.getFields(), r20.getEmbeddedFields(), r20.getConstructor());
    L12:
        r18 = false;
        goto L13
    L15:
        r16 = ParsedQuery.Companion.getMISSING();
        goto L14
    L6:
        r14 = this.element.getName();
        goto L5
    }

    public /* synthetic */ DatabaseViewProcessor(Context r5, XTypeElement r10, LinkedHashSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = new LinkedHashSet();
    L5:
        this(r5, r10, r11);
    }
}
