package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.CommonProcessorDelegate;
import androidx.room.compiler.processing.XBasicAnnotationProcessor;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XProcessingEnvConfig;
import androidx.room.compiler.processing.XProcessingStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B)\b\u0007\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\nJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0!J\u0010\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%J\u001e\u0010&\u001a\u00020'2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacBasicAnnotationProcessor;", "Ljavax/annotation/processing/AbstractProcessor;", "Landroidx/room/compiler/processing/XBasicAnnotationProcessor;", "config", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "(Landroidx/room/compiler/processing/XProcessingEnvConfig;)V", "configureEnv", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "commonDelegate", "Landroidx/room/compiler/processing/CommonProcessorDelegate;", "getCommonDelegate", "()Landroidx/room/compiler/processing/CommonProcessorDelegate;", "commonDelegate$delegate", "Lkotlin/Lazy;", "steps", "", "Landroidx/room/compiler/processing/XProcessingStep;", "getSteps", "()Ljava/util/List;", "steps$delegate", "xEnv", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "getXEnv", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "xEnv$delegate", "xProcessingEnv", "Landroidx/room/compiler/processing/XProcessingEnv;", "getXProcessingEnv", "()Landroidx/room/compiler/processing/XProcessingEnv;", "getSupportedAnnotationTypes", "", "init", "", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "process", "", "annotations", "", "Ljavax/lang/model/element/TypeElement;", "roundEnv", "Ljavax/annotation/processing/RoundEnvironment;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacBasicAnnotationProcessor extends AbstractProcessor implements XBasicAnnotationProcessor {
    private final Lazy commonDelegate$delegate;
    private final Lazy steps$delegate;
    private final Lazy xEnv$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public JavacBasicAnnotationProcessor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ ProcessingEnvironment access$getProcessingEnv$p$s664453744(JavacBasicAnnotationProcessor r5) {
        return ((AbstractProcessor) r5).processingEnv;
    }

    public static final /* synthetic */ List access$getSteps(JavacBasicAnnotationProcessor r5) {
        return r5.getSteps();
    }

    public static final /* synthetic */ JavacProcessingEnv access$getXEnv(JavacBasicAnnotationProcessor r5) {
        return r5.getXEnv();
    }

    private final CommonProcessorDelegate getCommonDelegate() {
        return (CommonProcessorDelegate) this.commonDelegate$delegate.getValue();
    }

    private final List<XProcessingStep> getSteps() {
        return (List) this.steps$delegate.getValue();
    }

    private final JavacProcessingEnv getXEnv() {
        return (JavacProcessingEnv) this.xEnv$delegate.getValue();
    }

    public final Set<String> getSupportedAnnotationTypes() {
        List<XProcessingStep> r5 = getSteps();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        CollectionsKt.a(r10, ((XProcessingStep) r11.next()).annotations());
        goto L4
    L7:
        return CollectionsKt.toSet(r10);
    }

    @Override // androidx.room.compiler.processing.XBasicAnnotationProcessor
    public final XProcessingEnv getXProcessingEnv() {
        return getXEnv();
    }

    public final void init(ProcessingEnvironment r5) {
        super.init(r5);
        initialize(getXEnv());
    }

    public final boolean process(Set<? extends TypeElement> r5, RoundEnvironment r10) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Intrinsics.checkNotNullParameter(r10, "roundEnv");
        JavacRoundEnv r11 = new JavacRoundEnv(getXEnv(), r10);
        if (r10.processingOver() == false) goto L9;
        List<String> r12 = getCommonDelegate().processLastRound();
        postRound(getXEnv(), r11);
        if (getXProcessingEnv().getConfig().getDisableAnnotatedElementValidation() == false) goto L7;
        return false;
    L7:
        if (r10.errorRaised() == true) goto L13;
        getCommonDelegate().reportMissingElements(r12);
        return false;
    L13:
        return false;
    L9:
        getCommonDelegate().processRound(r11);
        postRound(getXEnv(), r11);
        getXEnv().clearCache$room_compiler_processing();
        return false;
    }

    public /* synthetic */ JavacBasicAnnotationProcessor(Function1 r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = AnonymousClass1.INSTANCE;
    L5:
        this(r5);
    }

    @JvmOverloads
    public JavacBasicAnnotationProcessor(final Function1<? super Map<String, String>, XProcessingEnvConfig> r5) {
        Intrinsics.checkNotNullParameter(r5, "configureEnv");
        this.xEnv$delegate = LazyKt.lazy(new JavacBasicAnnotationProcessor$xEnv$2(this, r5));
        this.steps$delegate = LazyKt.lazy(new JavacBasicAnnotationProcessor$steps$2(this));
        this.commonDelegate$delegate = LazyKt.lazy(new JavacBasicAnnotationProcessor$commonDelegate$2(this));
    }

    public JavacBasicAnnotationProcessor(final XProcessingEnvConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this(new AnonymousClass2(r5));
    }
}
