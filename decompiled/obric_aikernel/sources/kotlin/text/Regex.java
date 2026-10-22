package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,396:1\n22#2,3:397\n1#3:400\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n102#1:397,3\n*E\n"})
public final class Regex implements Serializable {
    public static final Companion Companion = null;
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int access$ensureUnicodeCase(Companion r10, int r11) {
            return r10.ensureUnicodeCase(r11);
        }

        private final int ensureUnicodeCase(int r10) {
            if ((r10 & 2) != 0) goto L5;
            return r10;
        L5:
            return r10 | 64;
        }

        public final String escape(String r10) {
            Intrinsics.checkNotNullParameter(r10, "literal");
            String r11 = Pattern.quote(r10);
            Intrinsics.checkNotNullExpressionValue(r11, "quote(literal)");
            return r11;
        }

        public final String escapeReplacement(String r10) {
            Intrinsics.checkNotNullParameter(r10, "literal");
            String r11 = Matcher.quoteReplacement(r10);
            Intrinsics.checkNotNullExpressionValue(r11, "quoteReplacement(literal)");
            return r11;
        }

        public final Regex fromLiteral(String r10) {
            Intrinsics.checkNotNullParameter(r10, "literal");
            return new Regex(r10, RegexOption.LITERAL);
        }
    }

    private static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Serialized(String r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "pattern");
            this.pattern = r10;
            this.flags = r11;
        }

        private final Object readResolve() {
            Pattern r10 = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(r10, "compile(pattern, flags)");
            return new Regex(r10);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return r10.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {274, 282, 286}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    static final class C04631 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Regex this$0;

        C04631(Regex r10, CharSequence r11, int r12, Continuation<? super C04631> r13) {
            this.this$0 = r10;
            this.$input = r11;
            this.$limit = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04631 r12 = new C04631(this.this$0, this.$input, this.$limit, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super String> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super String> r10, Continuation<? super Unit> r11) {
            return ((C04631) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            int r13 = 0;
            if (r12 == 0) goto L12;
            if (r12 == 1) goto L11;
            if (r12 == 2) goto L10;
            if (r12 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r14 = this.I$0;
            Matcher r15 = (Matcher) this.L$1;
            SequenceScope r16 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            int r17 = r14;
            Matcher r18 = r15;
        L21:
            r13 = r18.end();
            r17 = r17 + 1;
            if (r17 != (this.$limit - 1)) goto L24;
        L25:
            CharSequence r19 = this.$input;
            String r110 = r19.subSequence(r13, r19.length()).toString();
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r16.yield(r110, this) != r11) goto L29;
            return r11;
        L24:
            if (r18.find() == false) goto L25;
        L18:
            String r20 = this.$input.subSequence(r13, r18.start()).toString();
            this.L$0 = r16;
            this.L$1 = r18;
            this.I$0 = r17;
            this.label = 2;
            if (r16.yield(r20, this) != r11) goto L21;
            return r11;
        L11:
            ResultKt.throwOnFailure(r10);
        L34:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);
            SequenceScope r111 = (SequenceScope) this.L$0;
            r18 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
            if (this.$limit != 1) goto L15;
        L30:
            String r21 = this.$input.toString();
            this.label = 1;
            if (r111.yield(r21, this) != r11) goto L34;
            return r11;
        L15:
            if (r18.find() == false) goto L30;
            r16 = r111;
            r17 = 0;
            goto L18
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Regex(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pattern");
        Pattern r11 = Pattern.compile(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "compile(pattern)");
        this(r11);
    }

    public Regex(String r10, Set<? extends RegexOption> r11) {
        Intrinsics.checkNotNullParameter(r10, "pattern");
        Intrinsics.checkNotNullParameter(r11, "options");
        Pattern r12 = Pattern.compile(r10, Companion.access$ensureUnicodeCase(Companion, RegexKt.access$toInt(r11)));
        Intrinsics.checkNotNullExpressionValue(r12, "compile(pattern, ensureU…odeCase(options.toInt()))");
        this(r12);
    }

    public Regex(String r10, RegexOption r11) {
        Intrinsics.checkNotNullParameter(r10, "pattern");
        Intrinsics.checkNotNullParameter(r11, "option");
        Pattern r12 = Pattern.compile(r10, Companion.access$ensureUnicodeCase(Companion, r11.getValue()));
        Intrinsics.checkNotNullExpressionValue(r12, "compile(pattern, ensureUnicodeCase(option.value))");
        this(r12);
    }

    @PublishedApi
    public Regex(Pattern r10) {
        Intrinsics.checkNotNullParameter(r10, "nativePattern");
        this.nativePattern = r10;
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r10) {
        return r10.nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.find(r11, r12);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.findAll(r11, r12);
    }

    public static /* synthetic */ List split$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.split(r11, r12);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r10, CharSequence r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.splitToSequence(r11, r12);
    }

    private final Object writeReplace() {
        String r10 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(r10, "nativePattern.pattern()");
        return new Serialized(r10, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        return this.nativePattern.matcher(r10).find();
    }

    public final MatchResult find(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Matcher r12 = this.nativePattern.matcher(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "nativePattern.matcher(input)");
        return RegexKt.access$findNext(r12, r11, r10);
    }

    public final Sequence<MatchResult> findAll(final CharSequence r10, final int r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        if (r11 < 0) goto L9;
        if (r11 > r10.length()) goto L9;
        return SequencesKt.generateSequence(new AnonymousClass1(this, r10, r11), AnonymousClass2.INSTANCE);
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r11 + ", input length: " + r10.length());
    }

    public final Set<RegexOption> getOptions() {
        Set r10 = this._options;
        if (r10 != null) goto L6;
        final int r11 = this.nativePattern.flags();
        EnumSet r12 = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNullExpressionValue(r12, "fromInt$lambda$1");
        CollectionsKt.retainAll(r12, new Regex$special$$inlined$fromInt$1(r11));
        Set<RegexOption> r13 = Collections.unmodifiableSet(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this._options = r13;
        return r13;
    L6:
        return r10;
    }

    public final String getPattern() {
        String r10 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(r10, "nativePattern.pattern()");
        return r10;
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final MatchResult matchAt(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Matcher r12 = this.nativePattern.matcher(r10).useAnchoringBounds(false).useTransparentBounds(true).region(r11, r10.length());
        if (r12.lookingAt() == false) goto L5;
        Intrinsics.checkNotNullExpressionValue(r12, "this");
        return new MatcherMatchResult(r12, r10);
    L5:
        return null;
    }

    public final MatchResult matchEntire(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Matcher r11 = this.nativePattern.matcher(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "nativePattern.matcher(input)");
        return RegexKt.access$matchEntire(r11, r10);
    }

    public final boolean matches(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        return this.nativePattern.matcher(r10).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean matchesAt(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        return this.nativePattern.matcher(r10).useAnchoringBounds(false).useTransparentBounds(true).region(r11, r10.length()).lookingAt();
    }

    public final String replace(CharSequence r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "replacement");
        String r12 = this.nativePattern.matcher(r10).replaceAll(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "nativePattern.matcher(in…).replaceAll(replacement)");
        return r12;
    }

    public final String replace(CharSequence r10, Function1<? super MatchResult, ? extends CharSequence> r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "transform");
        int r12 = 0;
        MatchResult r13 = find$default(this, r10, 0, 2, null);
        if (r13 == null) goto L5;
        int r14 = r10.length();
        StringBuilder r15 = new StringBuilder(r14);
    L7:
        r15.append(r10, r12, r13.getRange().getStart().intValue());
        r15.append(r11.invoke(r13));
        r12 = r13.getRange().getEndInclusive().intValue() + 1;
        r13 = r13.next();
        if (r12 >= r14) goto L10;
        if (r13 != null) goto L7;
    L10:
        if (r12 >= r14) goto L12;
        r15.append(r10, r12, r14);
    L12:
        String r16 = r15.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "sb.toString()");
        return r16;
    L5:
        return r10.toString();
    }

    public final String replaceFirst(CharSequence r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "replacement");
        String r12 = this.nativePattern.matcher(r10).replaceFirst(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "nativePattern.matcher(in…replaceFirst(replacement)");
        return r12;
    }

    public final List<String> split(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r11);
        Matcher r12 = this.nativePattern.matcher(r10);
        if (r11 == 1) goto L20;
        if (r12.find() == false) goto L20;
        int r13 = 10;
        if (r11 <= 0) goto L10;
        r13 = RangesKt.coerceAtMost(r11, 10);
    L10:
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
        int r16 = r11 - 1;
    L11:
        r14.add(r10.subSequence(r15, r12.start()).toString());
        r15 = r12.end();
        if (r16 < 0) goto L16;
        if (r14.size() != r16) goto L16;
    L17:
        r14.add(r10.subSequence(r15, r10.length()).toString());
        return r14;
    L16:
        if (r12.find() == true) goto L11;
    L20:
        return CollectionsKt.listOf(r10.toString());
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final Sequence<String> splitToSequence(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r11);
        return SequencesKt.sequence(new C04631(this, r10, r11, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String r10 = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "nativePattern.toString()");
        return r10;
    }
}
