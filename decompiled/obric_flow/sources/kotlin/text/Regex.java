package kotlin.text;

import ai.j0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n22#2,3:398\n1#3:401\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n103#1:398,3\n*E\n"})
public final class Regex implements Serializable {
    public static final Companion Companion = null;
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ int access$ensureUnicodeCase(Companion r5, int r10) {
            return r5.ensureUnicodeCase(r10);
        }

        private final int ensureUnicodeCase(int r5) {
            if ((r5 & 2) != 0) goto L5;
            return r5;
        L5:
            return r5 | 64;
        }

        public final String escape(String r5) {
            Intrinsics.checkNotNullParameter(r5, "literal");
            return Pattern.quote(r5);
        }

        public final String escapeReplacement(String r5) {
            Intrinsics.checkNotNullParameter(r5, "literal");
            return Matcher.quoteReplacement(r5);
        }

        public final Regex fromLiteral(String r5) {
            Intrinsics.checkNotNullParameter(r5, "literal");
            return new Regex(r5, RegexOption.LITERAL);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Serialized(String r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "pattern");
            this.pattern = r5;
            this.flags = r10;
        }

        private final Object readResolve() {
            return new Regex(Pattern.compile(this.pattern, this.flags));
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
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return r5.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    public static final class C02721 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Regex this$0;

        public C02721(Regex r5, CharSequence r10, int r11, Continuation<? super C02721> r12) {
            this.this$0 = r5;
            this.$input = r10;
            this.$limit = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C02721 r11 = new C02721(this.this$0, this.$input, this.$limit, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super String> r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L12;
            if (r11 == 1) goto L11;
            if (r11 == 2) goto L10;
            if (r11 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r12 = this.I$0;
            Matcher r13 = (Matcher) this.L$1;
            SequenceScope r14 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            Matcher r15 = r13;
        L21:
            int r16 = r15.end();
            r12 = r12 + 1;
            if (r12 != (this.$limit - 1)) goto L24;
        L25:
            CharSequence r17 = this.$input;
            String r18 = r17.subSequence(r16, r17.length()).toString();
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r14.yield(r18, this) != r5) goto L29;
            return r5;
        L24:
            if (r15.find() == false) goto L25;
        L18:
            String r19 = this.$input.subSequence(r16, r15.start()).toString();
            this.L$0 = r14;
            this.L$1 = r15;
            this.I$0 = r12;
            this.label = 2;
            if (r14.yield(r19, this) != r5) goto L21;
            return r5;
        L11:
            ResultKt.throwOnFailure(r10);
        L34:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);
            SequenceScope r110 = (SequenceScope) this.L$0;
            Matcher r20 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
            if (this.$limit != 1) goto L15;
        L30:
            String r21 = this.$input.toString();
            this.label = 1;
            if (r110.yield(r21, this) != r5) goto L34;
            return r5;
        L15:
            if (r20.find() == false) goto L30;
            r16 = 0;
            r14 = r110;
            r15 = r20;
            r12 = 0;
            goto L18
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super String> r5, Continuation<? super Unit> r10) {
            return ((C02721) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @PublishedApi
    public Regex(Pattern r5) {
        Intrinsics.checkNotNullParameter(r5, "nativePattern");
        this.nativePattern = r5;
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r5) {
        return r5.nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex r5, CharSequence r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return r5.find(r10, r11);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r5, CharSequence r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return r5.findAll(r10, r11);
    }

    public static /* synthetic */ List split$default(Regex r5, CharSequence r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return r5.split(r10, r11);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r5, CharSequence r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return r5.splitToSequence(r10, r11);
    }

    private final Object writeReplace() {
        return new Serialized(this.nativePattern.pattern(), this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        return this.nativePattern.matcher(r5).find();
    }

    public final MatchResult find(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        return RegexKt.access$findNext(this.nativePattern.matcher(r5), r10, r5);
    }

    public final Sequence<MatchResult> findAll(final CharSequence r5, final int r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        if (r10 >= 0) goto L5;
    L8:
        StringBuilder r11 = j0.s(r10, "Start index out of bounds: ", ", input length: ");
        r11.append(r5.length());
        throw new IndexOutOfBoundsException(r11.toString());
    L5:
        if (r10 > r5.length()) goto L8;
        return SequencesKt.generateSequence(new AnonymousClass1(this, r5, r10), AnonymousClass2.INSTANCE);
    }

    public final Set<RegexOption> getOptions() {
        Set r5 = this._options;
        if (r5 != null) goto L6;
        final int r10 = this.nativePattern.flags();
        EnumSet r11 = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull(r11);
        CollectionsKt.C(r11, new Regex$special$$inlined$fromInt$1(r10));
        Set<RegexOption> r12 = Collections.unmodifiableSet(r11);
        this._options = r12;
        return r12;
    L6:
        return r5;
    }

    public final String getPattern() {
        return this.nativePattern.pattern();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final MatchResult matchAt(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Matcher r11 = this.nativePattern.matcher(r5).useAnchoringBounds(false).useTransparentBounds(true).region(r10, r5.length());
        if (r11.lookingAt() == false) goto L5;
        Intrinsics.checkNotNull(r11);
        return new MatcherMatchResult(r11, r5);
    L5:
        return null;
    }

    public final MatchResult matchEntire(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        return RegexKt.access$matchEntire(this.nativePattern.matcher(r5), r5);
    }

    public final boolean matches(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        return this.nativePattern.matcher(r5).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean matchesAt(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        return this.nativePattern.matcher(r5).useAnchoringBounds(false).useTransparentBounds(true).region(r10, r5.length()).lookingAt();
    }

    public final String replace(CharSequence r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        return this.nativePattern.matcher(r5).replaceAll(r10);
    }

    public final String replaceFirst(CharSequence r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "replacement");
        return this.nativePattern.matcher(r5).replaceFirst(r10);
    }

    public final List<String> split(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r10);
        Matcher r11 = this.nativePattern.matcher(r5);
        if (r10 == 1) goto L20;
        if (r11.find() == false) goto L20;
        int r12 = 10;
        if (r10 <= 0) goto L10;
        r12 = RangesKt.coerceAtMost(r10, 10);
    L10:
        ArrayList r13 = new ArrayList(r12);
        int r14 = r10 - 1;
        int r15 = 0;
    L11:
        r13.add(r5.subSequence(r15, r11.start()).toString());
        r15 = r11.end();
        if (r14 < 0) goto L16;
        if (r13.size() != r14) goto L16;
    L17:
        r13.add(r5.subSequence(r15, r5.length()).toString());
        return r13;
    L16:
        if (r11.find() == true) goto L11;
    L20:
        return CollectionsKt.listOf(r5.toString());
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final Sequence<String> splitToSequence(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r10);
        return SequencesKt.sequence(new C02721(this, r5, r10, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        return this.nativePattern.toString();
    }

    public final String replace(CharSequence r5, Function1<? super MatchResult, ? extends CharSequence> r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "transform");
        int r11 = 0;
        MatchResult r12 = find$default(this, r5, 0, 2, null);
        if (r12 == null) goto L5;
        int r13 = r5.length();
        StringBuilder r14 = new StringBuilder(r13);
    L7:
        r14.append(r5, r11, r12.getRange().getStart().intValue());
        r14.append(r10.invoke(r12));
        r11 = r12.getRange().getEndInclusive().intValue() + 1;
        r12 = r12.next();
        if (r11 >= r13) goto L10;
        if (r12 != null) goto L7;
    L10:
        if (r11 >= r13) goto L13;
        r14.append(r5, r11, r13);
    L13:
        return r14.toString();
    L5:
        return r5.toString();
    }

    public Regex(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pattern");
        this(Pattern.compile(r5));
    }

    public Regex(String r5, RegexOption r10) {
        Intrinsics.checkNotNullParameter(r5, "pattern");
        Intrinsics.checkNotNullParameter(r10, "option");
        this(Pattern.compile(r5, Companion.access$ensureUnicodeCase(Companion, r10.getValue())));
    }

    public Regex(String r5, Set<? extends RegexOption> r10) {
        Intrinsics.checkNotNullParameter(r5, "pattern");
        Intrinsics.checkNotNullParameter(r10, "options");
        this(Pattern.compile(r5, Companion.access$ensureUnicodeCase(Companion, RegexKt.access$toInt(r10))));
    }
}
