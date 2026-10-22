package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.CommonProcessorDelegate;
import androidx.room.compiler.processing.XBasicAnnotationProcessor;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XProcessingEnvConfig;
import androidx.room.compiler.processing.XProcessingStep;
import hl.c;
import hl.d;
import hl.e;
import hl.f;
import il.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0011\u0010)\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspBasicAnnotationProcessor;", "Lhl/e;", "Landroidx/room/compiler/processing/XBasicAnnotationProcessor;", "Lhl/f;", "symbolProcessorEnvironment", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "config", "<init>", "(Lhl/f;Landroidx/room/compiler/processing/XProcessingEnvConfig;)V", "Lhl/d;", "resolver", "", "Lil/a;", "process", "(Lhl/d;)Ljava/util/List;", "", "finish", "()V", "Landroidx/room/compiler/processing/ksp/KspBasicAnnotationProcessor$DelegateLogger;", "logger", "Landroidx/room/compiler/processing/ksp/KspBasicAnnotationProcessor$DelegateLogger;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "xEnv", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/XProcessingStep;", "steps$delegate", "Lkotlin/Lazy;", "getSteps", "()Ljava/util/List;", "steps", "Landroidx/room/compiler/processing/CommonProcessorDelegate;", "commonDelegate$delegate", "getCommonDelegate", "()Landroidx/room/compiler/processing/CommonProcessorDelegate;", "commonDelegate", "", "initialized", "Z", "Landroidx/room/compiler/processing/XProcessingEnv;", "getXProcessingEnv", "()Landroidx/room/compiler/processing/XProcessingEnv;", "xProcessingEnv", "DelegateLogger", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspBasicAnnotationProcessor implements e, XBasicAnnotationProcessor {
    private final Lazy commonDelegate$delegate;
    private boolean initialized;
    private final DelegateLogger logger;
    private final Lazy steps$delegate;
    private final KspProcessingEnv xEnv;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ$\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000bJ!\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspBasicAnnotationProcessor$DelegateLogger;", "Lhl/c;", "delegate", "<init>", "(Lhl/c;)V", "", "message", "Lil/j;", "symbol", "", "info", "(Ljava/lang/String;Lil/j;)V", "logging", "warn", "error", "", "e", "exception", "(Ljava/lang/Throwable;)V", "Lhl/c;", "getDelegate", "()Lhl/c;", "", "hasError", "Z", "getHasError", "()Z", "setHasError", "(Z)V", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DelegateLogger implements c {
        private final c delegate;
        private boolean hasError;

        public DelegateLogger(c r5) {
            Intrinsics.checkNotNullParameter(r5, "delegate");
            this.delegate = r5;
        }

        @Override // hl.c
        public void error(String r5, j r10) {
            Intrinsics.checkNotNullParameter(r5, "message");
            this.hasError = true;
            this.delegate.error(r5, r10);
        }

        @Override // hl.c
        public void exception(Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "e");
            this.hasError = true;
            this.delegate.exception(r5);
        }

        public final c getDelegate() {
            return this.delegate;
        }

        public final boolean getHasError() {
            return this.hasError;
        }

        @Override // hl.c
        public void info(String r5, j r10) {
            Intrinsics.checkNotNullParameter(r5, "message");
            this.delegate.info(r5, r10);
        }

        @Override // hl.c
        public void logging(String r5, j r10) {
            Intrinsics.checkNotNullParameter(r5, "message");
            this.delegate.logging(r5, r10);
        }

        public final void setHasError(boolean r5) {
            this.hasError = r5;
        }

        @Override // hl.c
        public void warn(String r5, j r10) {
            Intrinsics.checkNotNullParameter(r5, "message");
            this.delegate.warn(r5, r10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KspBasicAnnotationProcessor(f r5) {
        Intrinsics.checkNotNullParameter(r5, "symbolProcessorEnvironment");
        this(r5, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ List access$getSteps(KspBasicAnnotationProcessor r5) {
        return r5.getSteps();
    }

    public static final /* synthetic */ KspProcessingEnv access$getXEnv$p(KspBasicAnnotationProcessor r5) {
        return r5.xEnv;
    }

    private final CommonProcessorDelegate getCommonDelegate() {
        return (CommonProcessorDelegate) this.commonDelegate$delegate.getValue();
    }

    private final List<XProcessingStep> getSteps() {
        return (List) this.steps$delegate.getValue();
    }

    public final void finish() {
        KspRoundEnv r5 = new KspRoundEnv(this.xEnv, true);
        List<String> r10 = getCommonDelegate().processLastRound();
        postRound(this.xEnv, r5);
        if (getXProcessingEnv().getConfig().getDisableAnnotatedElementValidation() == false) goto L5;
        return;
    L5:
        if (this.logger.getHasError() == true) goto L9;
        getCommonDelegate().reportMissingElements(r10);
        return;
    }

    @Override // androidx.room.compiler.processing.XBasicAnnotationProcessor
    public final XProcessingEnv getXProcessingEnv() {
        return this.xEnv;
    }

    public /* bridge */ /* synthetic */ void onError() {
    }

    public final List<il.a> process(d r5) {
        Intrinsics.checkNotNullParameter(r5, "resolver");
        this.xEnv.setResolver$room_compiler_processing(r5);
        if (this.initialized == true) goto L5;
        initialize(this.xEnv);
        this.initialized = true;
    L5:
        KspRoundEnv r10 = new KspRoundEnv(this.xEnv, false);
        getCommonDelegate().processRound(r10);
        postRound(this.xEnv, r10);
        this.xEnv.clearCache$room_compiler_processing();
        return CollectionsKt.emptyList();
    }

    @JvmOverloads
    public KspBasicAnnotationProcessor(f r5, XProcessingEnvConfig r10) {
        Intrinsics.checkNotNullParameter(r5, "symbolProcessorEnvironment");
        Intrinsics.checkNotNullParameter(r10, "config");
        throw null;
    }

    public /* synthetic */ KspBasicAnnotationProcessor(f r5, XProcessingEnvConfig r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = XProcessingEnvConfig.Companion.getDEFAULT();
    L5:
        this(r5, r10);
    }
}
