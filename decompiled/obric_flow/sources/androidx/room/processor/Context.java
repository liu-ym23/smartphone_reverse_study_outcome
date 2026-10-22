package androidx.room.processor;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.log.RLog;
import androidx.room.preconditions.Checks;
import androidx.room.processor.cache.Cache;
import androidx.room.solver.TypeAdapterStore;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.vo.BuiltInConverterFlags;
import androidx.room.vo.Warning;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u0001:\u0004NOPQB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010;\u001a\u00020<2\u0006\u0010\"\u001a\u00020!J,\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u00020@0>\"\u0004\b\u0000\u0010?2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H?0BJ\u001e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GJ\u000e\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020/J\u000e\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020/J\f\u0010M\u001a\u00020\u000e*\u00020EH\u0002R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u001f\u001a\u0004\b4\u00105R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001f\u001a\u0004\b8\u00109¨\u0006R"}, d2 = {"Landroidx/room/processor/Context;", "", "processingEnv", "Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XProcessingEnv;)V", "logger", "Landroidx/room/log/RLog;", "typeConverters", "Landroidx/room/processor/CustomConverterProcessor$ProcessResult;", "inheritedAdapterStore", "Landroidx/room/solver/TypeAdapterStore;", "cache", "Landroidx/room/processor/cache/Cache;", "canRewriteQueriesToDropUnusedColumns", "", "(Landroidx/room/compiler/processing/XProcessingEnv;Landroidx/room/log/RLog;Landroidx/room/processor/CustomConverterProcessor$ProcessResult;Landroidx/room/solver/TypeAdapterStore;Landroidx/room/processor/cache/Cache;Z)V", "COMMON_TYPES", "Landroidx/room/processor/Context$CommonTypes;", "getCOMMON_TYPES", "()Landroidx/room/processor/Context$CommonTypes;", "getCache", "()Landroidx/room/processor/cache/Cache;", "checker", "Landroidx/room/preconditions/Checks;", "getChecker", "()Landroidx/room/preconditions/Checks;", "codeLanguage", "Landroidx/room/compiler/codegen/CodeLanguage;", "getCodeLanguage", "()Landroidx/room/compiler/codegen/CodeLanguage;", "codeLanguage$delegate", "Lkotlin/Lazy;", "<set-?>", "Landroidx/room/verifier/DatabaseVerifier;", "databaseVerifier", "getDatabaseVerifier", "()Landroidx/room/verifier/DatabaseVerifier;", "getLogger", "()Landroidx/room/log/RLog;", "getProcessingEnv", "()Landroidx/room/compiler/processing/XProcessingEnv;", "queryRewriter", "Landroidx/room/processor/QueryRewriter;", "getQueryRewriter", "()Landroidx/room/processor/QueryRewriter;", "queryRewriter$delegate", "schemaOutFolderPath", "", "getSchemaOutFolderPath", "()Ljava/lang/String;", "schemaOutFolderPath$delegate", "typeAdapterStore", "getTypeAdapterStore", "()Landroidx/room/solver/TypeAdapterStore;", "typeAdapterStore$delegate", "useNullAwareConverter", "getUseNullAwareConverter", "()Z", "useNullAwareConverter$delegate", "attachDatabaseVerifier", "", "collectLogs", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/log/RLog$CollectingMessager;", "handler", "Lkotlin/Function1;", "fork", "element", "Landroidx/room/compiler/processing/XElement;", "forceSuppressedWarnings", "", "Landroidx/room/vo/Warning;", "reportMissingType", "typeName", "reportMissingTypeReference", "containerName", "hasRemoveUnusedColumnsAnnotation", "BooleanProcessorOptions", "CommonTypes", "Companion", "ProcessorOptions", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Context {
    private static final Lazy<List<String>> ARG_OPTIONS$delegate = null;
    public static final Companion Companion = null;
    private final CommonTypes COMMON_TYPES;
    private final Cache cache;
    private final boolean canRewriteQueriesToDropUnusedColumns;
    private final Checks checker;
    private final Lazy codeLanguage$delegate;
    private DatabaseVerifier databaseVerifier;
    private final TypeAdapterStore inheritedAdapterStore;
    private final RLog logger;
    private final XProcessingEnv processingEnv;
    private final Lazy queryRewriter$delegate;
    private final Lazy schemaOutFolderPath$delegate;
    private final Lazy typeAdapterStore$delegate;
    private final CustomConverterProcessor.ProcessResult typeConverters;
    private final Lazy useNullAwareConverter$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/processor/Context$BooleanProcessorOptions;", "", "argName", "", "defaultValue", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getArgName", "()Ljava/lang/String;", "getInputValue", "processingEnv", "Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XProcessingEnv;)Ljava/lang/Boolean;", "getValue", "INCREMENTAL", "EXPAND_PROJECTION", "USE_NULL_AWARE_CONVERTER", "GENERATE_KOTLIN", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum BooleanProcessorOptions extends Enum<BooleanProcessorOptions> {
        private static final /* synthetic */ BooleanProcessorOptions[] $VALUES = null;
        public static final BooleanProcessorOptions EXPAND_PROJECTION = null;
        public static final BooleanProcessorOptions GENERATE_KOTLIN = null;
        public static final BooleanProcessorOptions INCREMENTAL = null;
        public static final BooleanProcessorOptions USE_NULL_AWARE_CONVERTER = null;
        private final String argName;
        private final boolean defaultValue;

        private static final /* synthetic */ BooleanProcessorOptions[] $values() {
            return new BooleanProcessorOptions[]{INCREMENTAL, EXPAND_PROJECTION, USE_NULL_AWARE_CONVERTER, GENERATE_KOTLIN};
        }

        static {
            INCREMENTAL = new BooleanProcessorOptions("INCREMENTAL", 0, "room.incremental", true);
            EXPAND_PROJECTION = new BooleanProcessorOptions("EXPAND_PROJECTION", 1, "room.expandProjection", false);
            USE_NULL_AWARE_CONVERTER = new BooleanProcessorOptions("USE_NULL_AWARE_CONVERTER", 2, "room.useNullAwareTypeAnalysis", false);
            GENERATE_KOTLIN = new BooleanProcessorOptions("GENERATE_KOTLIN", 3, "room.generateKotlin", false);
            $VALUES = $values();
        }

        private BooleanProcessorOptions(String r5, int r10, String r11, boolean r12) {
            super(r5, r10);
            this.argName = r11;
            this.defaultValue = r12;
        }

        public static BooleanProcessorOptions valueOf(String r5) {
            return (BooleanProcessorOptions) Enum.valueOf(BooleanProcessorOptions.class, r5);
        }

        public static BooleanProcessorOptions[] values() {
            return (BooleanProcessorOptions[]) $VALUES.clone();
        }

        public final String getArgName() {
            return this.argName;
        }

        public final Boolean getInputValue(XProcessingEnv r5) {
            Intrinsics.checkNotNullParameter(r5, "processingEnv");
            String r10 = r5.getOptions().get(this.argName);
            if (r10 != null) goto L5;
            return null;
        L5:
            if (StringsKt.isBlank(r10) == false) goto L8;
            r10 = null;
        L8:
            if (r10 != null) goto L10;
            return null;
        L10:
            return Boolean.valueOf(Boolean.parseBoolean(r10));
        }

        public final boolean getValue(XProcessingEnv r5) {
            Intrinsics.checkNotNullParameter(r5, "processingEnv");
            Boolean r10 = getInputValue(r5);
            if (r10 == null) goto L6;
            return r10.booleanValue();
        L6:
            return this.defaultValue;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/processor/Context$CommonTypes;", "", "processingEnv", "Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XProcessingEnv;)V", "READONLY_COLLECTION", "Landroidx/room/compiler/processing/XType;", "getREADONLY_COLLECTION", "()Landroidx/room/compiler/processing/XType;", "READONLY_COLLECTION$delegate", "Lkotlin/Lazy;", "STRING", "getSTRING", "STRING$delegate", "VOID", "getVOID", "VOID$delegate", "getProcessingEnv", "()Landroidx/room/compiler/processing/XProcessingEnv;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CommonTypes {
        private final Lazy READONLY_COLLECTION$delegate;
        private final Lazy STRING$delegate;
        private final Lazy VOID$delegate;
        private final XProcessingEnv processingEnv;

        public CommonTypes(XProcessingEnv r5) {
            Intrinsics.checkNotNullParameter(r5, "processingEnv");
            this.processingEnv = r5;
            this.VOID$delegate = LazyKt.lazy(new Context$CommonTypes$VOID$2(this));
            this.STRING$delegate = LazyKt.lazy(new Context$CommonTypes$STRING$2(this));
            this.READONLY_COLLECTION$delegate = LazyKt.lazy(new Context$CommonTypes$READONLY_COLLECTION$2(this));
        }

        public final XProcessingEnv getProcessingEnv() {
            return this.processingEnv;
        }

        public final XType getREADONLY_COLLECTION() {
            return (XType) this.READONLY_COLLECTION$delegate.getValue();
        }

        public final XType getSTRING() {
            return (XType) this.STRING$delegate.getValue();
        }

        public final XType getVOID() {
            return (XType) this.VOID$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/room/processor/Context$Companion;", "", "()V", "ARG_OPTIONS", "", "", "getARG_OPTIONS", "()Ljava/util/List;", "ARG_OPTIONS$delegate", "Lkotlin/Lazy;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<String> getARG_OPTIONS() {
            return (List) Context.access$getARG_OPTIONS$delegate$cp().getValue();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/room/processor/Context$ProcessorOptions;", "", "argName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getArgName", "()Ljava/lang/String;", "OPTION_SCHEMA_FOLDER", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum ProcessorOptions extends Enum<ProcessorOptions> {
        private static final /* synthetic */ ProcessorOptions[] $VALUES = null;
        public static final ProcessorOptions OPTION_SCHEMA_FOLDER = null;
        private final String argName;

        private static final /* synthetic */ ProcessorOptions[] $values() {
            return new ProcessorOptions[]{OPTION_SCHEMA_FOLDER};
        }

        static {
            OPTION_SCHEMA_FOLDER = new ProcessorOptions("OPTION_SCHEMA_FOLDER", 0, "room.schemaLocation");
            $VALUES = $values();
        }

        private ProcessorOptions(String r5, int r10, String r11) {
            super(r5, r10);
            this.argName = r11;
        }

        public static ProcessorOptions valueOf(String r5) {
            return (ProcessorOptions) Enum.valueOf(ProcessorOptions.class, r5);
        }

        public static ProcessorOptions[] values() {
            return (ProcessorOptions[]) $VALUES.clone();
        }

        public final String getArgName() {
            return this.argName;
        }
    }

    static {
        Companion = new Companion(null);
        ARG_OPTIONS$delegate = LazyKt.lazy(Context$Companion$ARG_OPTIONS$2.INSTANCE);
    }

    private Context(XProcessingEnv r5, RLog r10, CustomConverterProcessor.ProcessResult r11, TypeAdapterStore r12, Cache r13, boolean r14) {
        this.processingEnv = r5;
        this.logger = r10;
        this.typeConverters = r11;
        this.inheritedAdapterStore = r12;
        this.cache = r13;
        this.canRewriteQueriesToDropUnusedColumns = r14;
        this.checker = new Checks(r10);
        this.COMMON_TYPES = new CommonTypes(r5);
        this.useNullAwareConverter$delegate = LazyKt.lazy(new Context$useNullAwareConverter$2(this));
        this.typeAdapterStore$delegate = LazyKt.lazy(new Context$typeAdapterStore$2(this));
        this.queryRewriter$delegate = LazyKt.lazy(new Context$queryRewriter$2(this));
        this.codeLanguage$delegate = LazyKt.lazy(new Context$codeLanguage$2(this));
        this.schemaOutFolderPath$delegate = LazyKt.lazy(new Context$schemaOutFolderPath$2(this));
    }

    public static final /* synthetic */ Lazy access$getARG_OPTIONS$delegate$cp() {
        return ARG_OPTIONS$delegate;
    }

    public static final /* synthetic */ boolean access$getCanRewriteQueriesToDropUnusedColumns$p(Context r5) {
        return r5.canRewriteQueriesToDropUnusedColumns;
    }

    public static final /* synthetic */ TypeAdapterStore access$getInheritedAdapterStore$p(Context r5) {
        return r5.inheritedAdapterStore;
    }

    public static final /* synthetic */ CustomConverterProcessor.ProcessResult access$getTypeConverters$p(Context r5) {
        return r5.typeConverters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context fork$default(Context r5, XElement r10, Set r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = SetsKt.emptySet();
    L6:
        return r5.fork(r10, r11);
    }

    private final boolean hasRemoveUnusedColumnsAnnotation(XElement r5) {
        boolean r10 = r5.hasAnnotation(Reflection.getOrCreateKotlinClass(RewriteQueriesToDropUnusedColumns.class));
        if (r10 == true) goto L5;
    L7:
        return r10;
    L5:
        if (BooleanProcessorOptions.EXPAND_PROJECTION.getValue(this.processingEnv) == false) goto L7;
        this.logger.w(Warning.EXPAND_PROJECTION_WITH_REMOVE_UNUSED_COLUMNS, r5, ProcessorErrors.INSTANCE.getEXPAND_PROJECTION_ALONG_WITH_REMOVE_UNUSED(), new Object[0]);
        goto L7
    }

    public final void attachDatabaseVerifier(DatabaseVerifier r5) {
        Intrinsics.checkNotNullParameter(r5, "databaseVerifier");
        if (this.databaseVerifier != null) goto L7;
        this.databaseVerifier = r5;
        return;
    L7:
        throw new IllegalStateException("database verifier is already set");
    }

    public final <T> Pair<T, RLog.CollectingMessager> collectLogs(Function1<? super Context, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "handler");
        RLog.CollectingMessager r5 = new RLog.CollectingMessager();
        Context r11 = new Context(this.processingEnv, new RLog(r5, this.logger.getSuppressedWarnings(), this.logger.getDefaultElement()), this.typeConverters, getTypeAdapterStore(), this.cache, this.canRewriteQueriesToDropUnusedColumns);
        r11.databaseVerifier = this.databaseVerifier;
        return new Pair(r10.invoke(r11), r5);
    }

    public final Context fork(XElement r14, Set<? extends Warning> r15) {
        Intrinsics.checkNotNullParameter(r14, "element");
        Intrinsics.checkNotNullParameter(r15, "forceSuppressedWarnings");
        Set<Warning> r5 = SuppressWarningProcessor.INSTANCE.getSuppressedWarnings(r14);
        CustomConverterProcessor.ProcessResult r10 = CustomConverterProcessor.Companion.findConverters(this, r14);
        BuiltInConverterFlags r11 = this.typeConverters.getBuiltInConverterFlags().withNext(r10.getBuiltInConverterFlags());
        if (Intrinsics.areEqual(r11, this.typeConverters.getBuiltInConverterFlags()) == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L11;
        CustomConverterProcessor.ProcessResult r13 = this.typeConverters;
    L10:
        CustomConverterProcessor.ProcessResult r16 = r13;
        Set r17 = SetsKt.plus(SetsKt.plus(r15, r5), this.logger.getSuppressedWarnings());
        Cache r18 = new Cache(this.cache, r16.getClasses(), r17, r11);
        if (this.canRewriteQueriesToDropUnusedColumns == false) goto L15;
    L18:
        boolean r19 = true;
    L19:
        XProcessingEnv r20 = this.processingEnv;
        RLog r21 = new RLog(this.logger.getMessager(), r17, r14);
        if (r12 == false) goto L23;
        TypeAdapterStore r110 = getTypeAdapterStore();
    L24:
        Context r22 = new Context(r20, r21, r16, r110, r18, r19);
        r22.databaseVerifier = this.databaseVerifier;
        return r22;
    L23:
        r110 = null;
        goto L24
    L15:
        if (hasRemoveUnusedColumnsAnnotation(r14) == true) goto L18;
        r19 = false;
        goto L19
    L11:
        r13 = r10.plus(this.typeConverters);
        goto L10
    L5:
        if (r10.getClasses().isEmpty() == false) goto L7;
        r12 = true;
        goto L8
    }

    public final CommonTypes getCOMMON_TYPES() {
        return this.COMMON_TYPES;
    }

    public final Cache getCache() {
        return this.cache;
    }

    public final Checks getChecker() {
        return this.checker;
    }

    public final CodeLanguage getCodeLanguage() {
        return (CodeLanguage) this.codeLanguage$delegate.getValue();
    }

    public final DatabaseVerifier getDatabaseVerifier() {
        return this.databaseVerifier;
    }

    public final RLog getLogger() {
        return this.logger;
    }

    public final XProcessingEnv getProcessingEnv() {
        return this.processingEnv;
    }

    public final QueryRewriter getQueryRewriter() {
        return (QueryRewriter) this.queryRewriter$delegate.getValue();
    }

    public final String getSchemaOutFolderPath() {
        return (String) this.schemaOutFolderPath$delegate.getValue();
    }

    public final TypeAdapterStore getTypeAdapterStore() {
        return (TypeAdapterStore) this.typeAdapterStore$delegate.getValue();
    }

    public final boolean getUseNullAwareConverter() {
        return ((Boolean) this.useNullAwareConverter$delegate.getValue()).booleanValue();
    }

    public final void reportMissingType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        this.logger.e(j0.k("[MissingType]: Type '", r5, "' is not present"), new Object[0]);
    }

    public final void reportMissingTypeReference(String r5) {
        Intrinsics.checkNotNullParameter(r5, "containerName");
        this.logger.e(j0.k("[MissingType]: Element '", r5, "' references a type that is not present"), new Object[0]);
    }

    public Context(XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r10, "processingEnv");
        this(r10, new RLog(r10.getMessager(), SetsKt.emptySet(), null), CustomConverterProcessor.ProcessResult.EMPTY.INSTANCE, null, new Cache(null, new LinkedHashSet(), SetsKt.emptySet(), BuiltInConverterFlags.Companion.getDEFAULT()), false);
    }
}
