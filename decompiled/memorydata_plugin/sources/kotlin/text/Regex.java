package kotlin.text;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", XSDatatype.FACET_PATTERN, "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Regex implements Serializable {
    public static final Companion Companion = null;
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ int access$ensureUnicodeCase(Companion r0, int r1) {
            return r0.ensureUnicodeCase(r1);
        }

        private final int ensureUnicodeCase(int r1) {
            if ((r1 & 2) != 0) goto L5;
            return r1;
        L5:
            return r1 | 64;
        }

        public final String escape(String r1) {
            Intrinsics.checkNotNullParameter(r1, "literal");
            String r0 = Pattern.quote(r1);
            Intrinsics.checkNotNullExpressionValue(r0, "quote(...)");
            return r0;
        }

        public final String escapeReplacement(String r1) {
            Intrinsics.checkNotNullParameter(r1, "literal");
            String r0 = Matcher.quoteReplacement(r1);
            Intrinsics.checkNotNullExpressionValue(r0, "quoteReplacement(...)");
            return r0;
        }

        public final Regex fromLiteral(String r2) {
            Intrinsics.checkNotNullParameter(r2, "literal");
            return new Regex(r2, RegexOption.LITERAL);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", XSDatatype.FACET_PATTERN, "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Serialized(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, XSDatatype.FACET_PATTERN);
            this.pattern = r2;
            this.flags = r3;
        }

        private final Object readResolve() {
            Pattern r2 = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(r2, "compile(...)");
            return new Regex(r2);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ MatchResult invoke(MatchResult r3) {
            return invoke2((MatchResult) ZeusTransformUtils.preCheckCast(r3, MatchResult.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult r2) {
            MatchResult r1 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "p0");
            return r1.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    static final class C12811 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Regex this$0;

        C12811(Regex r3, CharSequence r4, int r5, Continuation<? super C12811> r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$input = r7;
            this.$limit = r5;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            C12811 r0 = new C12811(this.this$0, this.$input, this.$limit, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(SequenceScope<? super String> r3, Continuation<? super Unit> r4) {
            return invoke2((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super String> r3, Continuation<? super Unit> r4) {
            return ((C12811) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12811.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x008a -> B:21:0x008d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            int r2 = 0;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r11);
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r3 = this.I$0;
            Matcher r4 = (Matcher) ZeusTransformUtils.preCheckCast(this.L$1, Matcher.class, "com.obric.memorydata.plugin");
            SequenceScope r7 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            int r12 = r3;
            Matcher r5 = r4;
        L21:
            r2 = r5.end();
            r12 = r12 + 1;
            if (r12 != (this.$limit - 1)) goto L24;
        L25:
            CharSequence r13 = this.$input;
            String r14 = r13.subSequence(r2, r13.length()).toString();
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r7.yield(r14, r6) != r0) goto L29;
            return r0;
        L24:
            if (r5.find() == false) goto L25;
        L18:
            String r8 = this.$input.subSequence(r2, r5.start()).toString();
            Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r7;
            this.L$1 = r5;
            this.I$0 = r12;
            this.label = 2;
            if (r7.yield(r8, r9) != r0) goto L21;
            return r0;
        L11:
            ResultKt.throwOnFailure(r11);
        L34:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r11);
            SequenceScope r15 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            r5 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
            if (this.$limit != 1) goto L15;
        L30:
            String r10 = this.$input.toString();
            Continuation<? super Unit> r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r15.yield(r10, r16) != r0) goto L34;
            return r0;
        L15:
            if (r5.find() == false) goto L30;
            r7 = r15;
            r12 = 0;
            goto L18
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Regex(String r2) {
        Intrinsics.checkNotNullParameter(r2, XSDatatype.FACET_PATTERN);
        Pattern r3 = Pattern.compile(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "compile(...)");
        this(r3);
    }

    public Regex(String r4, Set<? extends RegexOption> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, XSDatatype.FACET_PATTERN);
        Intrinsics.checkNotNullParameter(r6, "options");
        Pattern r7 = Pattern.compile(r4, Companion.access$ensureUnicodeCase(Companion, RegexKt.access$toInt((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"))));
        Intrinsics.checkNotNullExpressionValue(r7, "compile(...)");
        this(r7);
    }

    public Regex(String r2, RegexOption r3) {
        Intrinsics.checkNotNullParameter(r2, XSDatatype.FACET_PATTERN);
        Intrinsics.checkNotNullParameter(r3, "option");
        Pattern r4 = Pattern.compile(r2, Companion.access$ensureUnicodeCase(Companion, r3.getValue()));
        Intrinsics.checkNotNullExpressionValue(r4, "compile(...)");
        this(r4);
    }

    public Regex(Pattern r2) {
        Intrinsics.checkNotNullParameter(r2, "nativePattern");
        this.nativePattern = r2;
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r0) {
        return r0.nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex r1, CharSequence r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return r1.find(r6, r3);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r1, CharSequence r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return r1.findAll(r6, r3);
    }

    public static /* synthetic */ List split$default(Regex r1, CharSequence r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return r1.split(r6, r3);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r1, CharSequence r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return r1.splitToSequence(r6, r3);
    }

    private final Object writeReplace() {
        String r1 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(r1, "pattern(...)");
        return new Serialized(r1, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "input");
        return this.nativePattern.matcher(r4).find();
    }

    public final MatchResult find(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "input");
        Matcher r2 = this.nativePattern.matcher(r5);
        Intrinsics.checkNotNullExpressionValue(r2, "matcher(...)");
        return RegexKt.access$findNext(r2, r4, r5);
    }

    public final Sequence<MatchResult> findAll(CharSequence r3, final int r4) {
        final CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "input");
        if (r4 < 0) goto L9;
        if (r4 > r5.length()) goto L9;
        return SequencesKt.generateSequence((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r5, r4), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r4 + ", input length: " + r5.length());
    }

    public final Set<RegexOption> getOptions() {
        Set r0 = this._options;
        if (r0 != null) goto L6;
        final int r1 = this.nativePattern.flags();
        EnumSet r2 = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull(r2);
        CollectionsKt.retainAll((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new Regex$special$$inlined$fromInt$1(r1), Function1.class, "com.obric.memorydata.plugin"));
        Set<RegexOption> r3 = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r3, "unmodifiableSet(...)");
        this._options = r3;
        return r3;
    L6:
        return r0;
    }

    public final String getPattern() {
        String r1 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(r1, "pattern(...)");
        return r1;
    }

    public final MatchResult matchAt(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "input");
        Matcher r2 = this.nativePattern.matcher(r5).useAnchoringBounds(false).useTransparentBounds(true).region(r4, r5.length());
        if (r2.lookingAt() == false) goto L5;
        Intrinsics.checkNotNull(r2);
        MatcherMatchResult r6 = new MatcherMatchResult(r2, r5);
    L7:
        return (MatchResult) ZeusTransformUtils.preCheckCast(r6, MatchResult.class, "com.obric.memorydata.plugin");
    L5:
        r6 = null;
        goto L7
    }

    public final MatchResult matchEntire(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "input");
        Matcher r2 = this.nativePattern.matcher(r4);
        Intrinsics.checkNotNullExpressionValue(r2, "matcher(...)");
        return RegexKt.access$matchEntire(r2, r4);
    }

    public final boolean matches(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "input");
        return this.nativePattern.matcher(r4).matches();
    }

    public final boolean matchesAt(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "input");
        return this.nativePattern.matcher(r5).useAnchoringBounds(false).useTransparentBounds(true).region(r4, r5.length()).lookingAt();
    }

    public final String replace(CharSequence r3, String r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r4, "replacement");
        String r2 = this.nativePattern.matcher(r5).replaceAll(r4);
        Intrinsics.checkNotNullExpressionValue(r2, "replaceAll(...)");
        return r2;
    }

    public final String replace(CharSequence r6, Function1<? super MatchResult, ? extends CharSequence> r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "input");
        Intrinsics.checkNotNullParameter(r9, "transform");
        int r0 = 0;
        MatchResult r5 = find$default(this, r8, 0, 2, null);
        if (r5 == null) goto L5;
        int r2 = r8.length();
        StringBuilder r3 = new StringBuilder(r2);
    L7:
        r3.append(r8, r0, r5.getRange().getStart().intValue());
        r3.append((CharSequence) ZeusTransformUtils.preCheckCast(r9.invoke(r5), CharSequence.class, "com.obric.memorydata.plugin"));
        r0 = r5.getRange().getEndInclusive().intValue() + 1;
        r5 = r5.next();
        if (r0 >= r2) goto L10;
        if (r5 != null) goto L7;
    L10:
        if (r0 >= r2) goto L12;
        r3.append(r8, r0, r2);
    L12:
        String r10 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return r10;
    L5:
        return r8.toString();
    }

    public final String replaceFirst(CharSequence r3, String r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r4, "replacement");
        String r2 = this.nativePattern.matcher(r5).replaceFirst(r4);
        Intrinsics.checkNotNullExpressionValue(r2, "replaceFirst(...)");
        return r2;
    }

    public final List<String> split(CharSequence r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "input");
        StringsKt.requireNonNegativeLimit(r6);
        Matcher r4 = this.nativePattern.matcher(r7);
        if (r6 == 1) goto L20;
        if (r4.find() == false) goto L20;
        int r3 = 10;
        if (r6 <= 0) goto L10;
        r3 = RangesKt.coerceAtMost(r6, 10);
    L10:
        ArrayList r2 = new ArrayList(r3);
        int r8 = 0;
        int r9 = r6 - 1;
    L11:
        r2.add(r7.subSequence(r8, r4.start()).toString());
        r8 = r4.end();
        if (r9 < 0) goto L16;
        if (r2.size() != r9) goto L16;
    L17:
        r2.add(r7.subSequence(r8, r7.length()).toString());
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L16:
        if (r4.find() == true) goto L11;
    L20:
        return CollectionsKt.listOf(r7.toString());
    }

    public final Sequence<String> splitToSequence(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "input");
        StringsKt.requireNonNegativeLimit(r5);
        return SequencesKt.sequence((Function2) ZeusTransformUtils.preCheckCast(new C12811(this, r6, r5, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String r1 = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }
}
