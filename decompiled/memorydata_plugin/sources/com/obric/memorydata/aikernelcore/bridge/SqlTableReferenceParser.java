package com.obric.memorydata.aikernelcore.bridge;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser;", "", "<init>", "()V", "parse", "", "", "sql", "TokenType", "Token", "Lexer", "TableScanner", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SqlTableReferenceParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SqlTableReferenceParser f8457a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TokenType;", "", "<init>", "(Ljava/lang/String;I)V", "WORD", "DOT", "COMMA", "LEFT_PAREN", "RIGHT_PAREN", "OTHER", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum TokenType extends Enum<TokenType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TokenType[] $VALUES = null;
        public static final TokenType COMMA = null;
        public static final TokenType DOT = null;
        public static final TokenType LEFT_PAREN = null;
        public static final TokenType OTHER = null;
        public static final TokenType RIGHT_PAREN = null;
        public static final TokenType WORD = null;

        private static final /* synthetic */ TokenType[] $values() {
            return new TokenType[]{WORD, DOT, COMMA, LEFT_PAREN, RIGHT_PAREN, OTHER};
        }

        static {
            WORD = new TokenType("WORD", 0);
            DOT = new TokenType("DOT", 1);
            COMMA = new TokenType("COMMA", 2);
            LEFT_PAREN = new TokenType("LEFT_PAREN", 3);
            RIGHT_PAREN = new TokenType("RIGHT_PAREN", 4);
            OTHER = new TokenType("OTHER", 5);
            TokenType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private TokenType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<TokenType> getEntries() {
            return $ENTRIES;
        }

        public static TokenType valueOf(String r2) {
            return (TokenType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TokenType.class, r2), TokenType.class, "com.obric.memorydata.plugin");
        }

        public static TokenType[] values() {
            return (TokenType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TokenType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$Lexer;", "", "sql", "", "<init>", "(Ljava/lang/String;)V", "tokens", "", "Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$Token;", "index", "", "depth", "tokenizeFirstStatement", "", "skipSingleQuotedString", "", "readQuotedIdentifier", "delimiter", "", "readBracketIdentifier", "skipLineComment", "", "skipBlockComment", "readBareWord", "addToken", "type", "Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TokenType;", "isIdentifierStart", "char", "isIdentifierPart", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<c> f8459b;
        private int c;
        private int d;

        public a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "sql");
            this.f8458a = r3;
            this.f8459b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        private final void a(TokenType r10) {
            this.f8459b.add(new c(r10, null, false, this.d, 6, null));
            this.c++;
        }

        private final boolean a(char r6) {
            this.c++;
            StringBuilder r0 = new StringBuilder();
        L4:
            if (this.c >= this.f8458a.length()) goto L16;
            char r2 = this.f8458a.charAt(this.c);
            if (r2 == r6) goto L10;
            r0.append(r2);
            int r3 = this.c + 1;
        L8:
            this.c = r3;
            goto L4
        L10:
            if ((this.c + 1) >= this.f8458a.length()) goto L14;
            if (this.f8458a.charAt(this.c + 1) != r6) goto L14;
            r0.append(r6);
            r3 = this.c + 2;
        L14:
            this.c++;
            List<c> r7 = this.f8459b;
            TokenType r4 = TokenType.WORD;
            String r1 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
            r7.add(new c(r4, r1, true, this.d));
            return true;
        L16:
            return false;
        }

        private final boolean b() {
            int r0 = this.c;
        L3:
            int r1 = r0 + 1;
        L4:
            this.c = r1;
            if (this.c >= this.f8458a.length()) goto L16;
            if (this.f8458a.charAt(this.c) != '\'') goto L8;
            if ((this.c + 1) >= this.f8458a.length()) goto L14;
            if (this.f8458a.charAt(this.c + 1) != '\'') goto L14;
            r1 = this.c + 2;
        L14:
            this.c++;
            return true;
        L8:
            r0 = this.c;
            goto L3
        L16:
            return false;
        }

        private final boolean b(char r1) {
            if (r1 != '_') goto L5;
        L12:
            return true;
        L5:
            if (r1 == '$') goto L12;
            if (Character.isLetter(r1) == true) goto L12;
            if (r1 >= 128) goto L12;
            return false;
        }

        private final boolean c() {
            this.c++;
            int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.f8458a, CharSequence.class, "com.obric.memorydata.plugin"), ']', this.c, false, 4, null);
            if (r0 >= 0) goto L6;
            return false;
        L6:
            List<c> r2 = this.f8459b;
            TokenType r4 = TokenType.WORD;
            String r5 = this.f8458a.substring(this.c, r0);
            Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
            r2.add(new c(r4, r5, true, this.d));
            this.c = r0 + 1;
            return true;
        }

        private final boolean c(char r1) {
            if (b(r1) == false) goto L5;
        L8:
            return true;
        L5:
            if (Character.isDigit(r1) == true) goto L8;
            return false;
        }

        private final void d() {
            int r0 = this.c + 2;
        L3:
            this.c = r0;
            if (this.c >= this.f8458a.length()) goto L10;
            if (this.f8458a.charAt(this.c) == '\n') goto L14;
            if (this.f8458a.charAt(this.c) == '\r') goto L15;
            r0 = this.c + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }

        private final boolean e() {
            int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.f8458a, CharSequence.class, "com.obric.memorydata.plugin"), "*/", this.c + 2, false, 4, null);
            if (r0 >= 0) goto L6;
            return false;
        L6:
            this.c = r0 + 2;
            return true;
        }

        private final void f() {
            int r0 = this.c;
            int r1 = r0 + 1;
        L3:
            this.c = r1;
            if (this.c >= this.f8458a.length()) goto L8;
            if (c(this.f8458a.charAt(this.c)) == false) goto L8;
            r1 = this.c + 1;
        L8:
            List<c> r2 = this.f8459b;
            TokenType r3 = TokenType.WORD;
            String r4 = this.f8458a.substring(r0, this.c);
            Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
            r2.add(new c(r3, r4, false, this.d, 4, null));
        }

        public final List<c> a() {
        L2:
            boolean r2 = true;
            if (this.c >= this.f8458a.length()) goto L62;
            if (CharsKt.isWhitespace(this.f8458a.charAt(this.c)) == true) goto L6;
            if (this.f8458a.charAt(this.c) == '\'') goto L10;
            if (this.f8458a.charAt(this.c) == '\"') goto L15;
            if (this.f8458a.charAt(this.c) == '`') goto L20;
            if (this.f8458a.charAt(this.c) == '[') goto L25;
            if (StringsKt.startsWith$default(this.f8458a, "--", this.c, false, 4, null) == true) goto L29;
            if (StringsKt.startsWith$default(this.f8458a, "/*", this.c, false, 4, null) == true) goto L33;
            if (this.f8458a.charAt(this.c) == '(') goto L37;
            if (this.f8458a.charAt(this.c) == ')') goto L40;
            if (this.f8458a.charAt(this.c) == ';') goto L48;
            if (this.f8458a.charAt(this.c) == '.') goto L54;
            if (this.f8458a.charAt(this.c) == ',') goto L57;
            if (b(this.f8458a.charAt(this.c)) == false) goto L61;
            f();
            goto L2
        L61:
            TokenType r0 = TokenType.OTHER;
        L44:
            a(r0);
            goto L2
        L57:
            r0 = TokenType.COMMA;
            goto L44
        L54:
            r0 = TokenType.DOT;
            goto L44
        L48:
            if (this.d == 0) goto L51;
            return null;
        L51:
            return this.f8459b;
        L40:
            int r1 = this.d;
            if (r1 == 0) goto L42;
            this.d = r1 - 1;
            r0 = TokenType.RIGHT_PAREN;
            goto L44
        L42:
            return null;
        L37:
            a(TokenType.LEFT_PAREN);
            this.d++;
            goto L2
        L33:
            if (e() == true) goto L2;
            return null;
        L29:
            d();
            goto L2
        L25:
            if (c() == true) goto L2;
            return null;
        L20:
            if (a('`') == true) goto L2;
            return null;
        L15:
            if (a(Typography.quote) == true) goto L2;
            return null;
        L10:
            if (b() == true) goto L2;
            return null;
        L6:
            this.c++;
            goto L2
        L62:
            List<c> r3 = this.f8459b;
            if (this.d == 0) goto L66;
            r2 = false;
        L66:
            if (r2 == true) goto L68;
            return null;
        L68:
            return r3;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J \u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\tH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TableScanner;", "", "tokens", "", "Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$Token;", "<init>", "(Ljava/util/List;)V", "tablesByNormalizedName", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "cteNames", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "scan", "", "parseMainStatementStart", "", "()Ljava/lang/Integer;", "indexAfterParenthesized", "leftParenIndex", "(I)Ljava/lang/Integer;", "collectWriteTarget", "", CommonConsts.APM_INNER_EVENT_COST_START, "skipConflictClause", "collectReadSources", "addTableAt", "skipTableValuedFunction", "parseQualifiedIdentifier", "Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TableScanner$ParsedIdentifier;", "isKeywordAtDepth", "index", "keyword", "depth", "isKeyword", "wordAt", "typeAt", "Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TokenType;", "normalize", EventBody.KEY_VALUE, "ParsedIdentifier", "Companion", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8460a = null;
        private static final Set<String> e = null;
        private static final Set<String> f = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<c> f8461b;
        private final LinkedHashMap<String, String> c;
        private final LinkedHashSet<String> d;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TableScanner$Companion;", "", "<init>", "()V", "CONFLICT_ACTIONS", "", "", "FROM_CLAUSE_END_KEYWORDS", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.bridge.SqlTableReferenceParser$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TableScanner$ParsedIdentifier;", "", ActivityLifecycle.NAME, "", "nextIndex", "", "qualified", "", "<init>", "(Ljava/lang/String;IZ)V", "getName", "()Ljava/lang/String;", "getNextIndex", "()I", "getQualified", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final class C0426b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f8462a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f8463b;
            private final boolean c;

            public C0426b(String r2, int r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
                this.f8462a = r2;
                this.f8463b = r3;
                this.c = r4;
            }

            public final String a() {
                return this.f8462a;
            }

            public final int b() {
                return this.f8463b;
            }

            public final boolean c() {
                return this.c;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0426b.class) == true) goto L8;
                return false;
            L8:
                C0426b r6 = (C0426b) ZeusTransformUtils.preCheckCast(r5, C0426b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f8462a, r6.f8462a) == true) goto L12;
                return false;
            L12:
                if (this.f8463b == r6.f8463b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f8462a.hashCode() * 31) + Integer.hashCode(this.f8463b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "ParsedIdentifier(name=" + this.f8462a + ", nextIndex=" + this.f8463b + ", qualified=" + this.c + ')';
            }
        }

        static {
            f8460a = new a(null);
            e = SetsKt.setOf(new String[]{"ROLLBACK", "ABORT", "REPLACE", "FAIL", "IGNORE"});
            f = SetsKt.setOf(new String[]{"WHERE", "GROUP", "HAVING", "ORDER", "LIMIT", "OFFSET", "WINDOW", "UNION", "INTERSECT", "EXCEPT", "RETURNING"});
        }

        public b(List<c> r3) {
            List<c> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "tokens");
            this.f8461b = r4;
            this.c = new LinkedHashMap();
            this.d = new LinkedHashSet();
        }

        private final Integer a(int r6) {
            int r0 = ((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r6), c.class, "com.obric.memorydata.plugin")).c();
            int r7 = r6 + 1;
            int r1 = this.f8461b.size();
        L3:
            if (r7 >= r1) goto L11;
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r7), c.class, "com.obric.memorydata.plugin")).getType() != TokenType.RIGHT_PAREN) goto L10;
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r7), c.class, "com.obric.memorydata.plugin")).c() != r0) goto L10;
            return Integer.valueOf(r7 + 1);
        L10:
            r7 = r7 + 1;
            goto L3
        L11:
            return null;
        }

        private final String a(String r2) {
            Locale r1 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(r1, "ROOT");
            String r3 = r2.toLowerCase(r1);
            Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
            return r3;
        }

        private final boolean a(int r4, String r5) {
            c r3 = (c) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f8461b, r4), c.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L6;
            return false;
        L6:
            if (r3.getType() == TokenType.WORD) goto L8;
            return false;
        L8:
            if (r3.b() == false) goto L10;
            return false;
        L10:
            if (StringsKt.equals(r3.a(), r5, true) == true) goto L12;
            return false;
        L12:
            return true;
        }

        private final boolean a(int r1, String r2, int r3) {
            if (a(r1, r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r1), c.class, "com.obric.memorydata.plugin")).c() != r3) goto L7;
            return true;
        }

        private final boolean a(int r5, boolean r6) {
            if (f(r5) != TokenType.LEFT_PAREN) goto L13;
            int r7 = r5 + 1;
            if (e(r7) != null) goto L7;
        L12:
            return true;
        L7:
            if (a(r7, "SELECT") == true) goto L12;
            if (a(r7, "WITH") == true) goto L12;
            return a(r7, r6);
        L13:
            C0426b r8 = d(r5);
            boolean r0 = false;
            if (r8 != null) goto L16;
            return false;
        L16:
            if (r6 == false) goto L21;
            if (f(r8.b()) != TokenType.LEFT_PAREN) goto L21;
            return true;
        L21:
            if (r8.c() == false) goto L23;
        L25:
            String r9 = a(r8.a());
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L28;
            r0 = true;
        L28:
            if (r0 == false) goto L30;
            this.c.putIfAbsent(r9, r8.a());
        L30:
            return true;
        L23:
            if (this.d.contains(a(r8.a())) == false) goto L25;
            return true;
        }

        static /* synthetic */ boolean a(b r0, int r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = true;
        L6:
            return r0.a(r1, r2);
        }

        private static final boolean a(c r0, int r1) {
            if (r1 <= r0.c()) goto L5;
            return true;
        L5:
            return false;
        }

        private final Integer b() {
            boolean r0 = false;
            if (a(0, "WITH") == true) goto L18;
            ((Number) ZeusTransformUtils.preCheckCast(0, Number.class, "com.obric.memorydata.plugin")).intValue();
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(this.f8461b, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L7;
        L9:
            Iterator r7 = r6.iterator();
        L11:
            if (r7.hasNext() == false) goto L8;
            if (a(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt(), "WITH") == false) goto L11;
        L14:
            if (r0 == true) goto L16;
            return null;
        L16:
            return 0;
        L8:
            r0 = true;
            goto L14
        L7:
            if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        L18:
            if (a(1, "RECURSIVE") == false) goto L20;
            int r2 = 2;
        L22:
            if (r2 >= this.f8461b.size()) goto L62;
            String r8 = e(r2);
            if (r8 == null) goto L25;
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r2), c.class, "com.obric.memorydata.plugin")).c() != 0) goto L28;
            this.d.add(a(r8));
            int r3 = r2 + 1;
            if (f(r3) != TokenType.LEFT_PAREN) goto L38;
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r3), c.class, "com.obric.memorydata.plugin")).c() != 0) goto L38;
            Integer r4 = a(r3);
            if (r4 == null) goto L36;
            r3 = r4.intValue();
            goto L38
        L36:
            return null;
        L38:
            if (a(r3, "AS", 0) == false) goto L39;
            int r5 = r3 + 1;
            if (a(r5, "NOT", 0) == false) goto L46;
            if (a(r5 + 1, "MATERIALIZED", 0) == false) goto L46;
            r5 = r5 + 2;
        L49:
            if (f(r5) != TokenType.LEFT_PAREN) goto L61;
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r5), c.class, "com.obric.memorydata.plugin")).c() != 0) goto L61;
            Integer r9 = a(r5);
            if (r9 == null) goto L61;
            r2 = r9.intValue();
            if (f(r2) != TokenType.COMMA) goto L62;
            if (((c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r2), c.class, "com.obric.memorydata.plugin")).c() != 0) goto L62;
            r2 = r2 + 1;
        L61:
            return null;
        L46:
            if (a(r5, "MATERIALIZED", 0) == false) goto L49;
            r5 = r5 + 1;
            goto L49
        L39:
            return null;
        L28:
            return null;
        L25:
            return null;
        L62:
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(this.f8461b, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 1), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L65;
        L67:
            Iterator r11 = r10.iterator();
        L69:
            if (r11.hasNext() == false) goto L73;
            if (a(((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue(), "WITH") == false) goto L69;
            r0 = true;
        L73:
            if (r0 == false) goto L76;
            return null;
        L76:
            return Integer.valueOf(r2);
        L65:
            if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L67;
        L20:
            r2 = 1;
            goto L22
        }

        private final boolean b(int r4) {
            if (a(r4, "SELECT") == false) goto L6;
            return true;
        L6:
            if (a(r4, "INSERT") == false) goto L8;
        L20:
            Integer r5 = c(r4 + 1);
            if (r5 == null) goto L28;
            int r6 = r5.intValue();
            if (a(r6, "INTO") == true) goto L25;
            return false;
        L25:
            int r7 = r6 + 1;
        L27:
            return a(r7, false);
        L28:
            return false;
        L8:
            if (a(r4, "REPLACE") == true) goto L20;
            if (a(r4, "UPDATE") == false) goto L17;
            Integer r8 = c(r4 + 1);
            if (r8 == null) goto L15;
            r7 = r8.intValue();
            goto L27
        L15:
            return false;
        L17:
            if (a(r4, HttpMethodContrants.DELETE) == false) goto L30;
            return a(r4 + 1, "FROM");
        L30:
            return false;
        }

        private final Integer c(int r6) {
            if (a(r6, "OR") == false) goto L5;
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin");
            boolean r3 = true;
            if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L9;
        L11:
            Iterator r1 = r0.iterator();
        L13:
            if (r1.hasNext() == false) goto L17;
            int r4 = r6 + 1;
            if (a(r4, (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L13;
            r3 = false;
        L17:
            if (r3 == false) goto L21;
            return null;
        L21:
            return Integer.valueOf(r6 + 2);
        L9:
            if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        L5:
            return Integer.valueOf(r6);
        }

        private final boolean c() {
            Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(this.f8461b, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L3:
            boolean r4 = true;
            if (r1.hasNext() == false) goto L33;
            int r3 = ((IntIterator) ZeusTransformUtils.preCheckCast(r1, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
            final c r5 = (c) ZeusTransformUtils.preCheckCast(this.f8461b.get(r3), c.class, "com.obric.memorydata.plugin");
            CollectionsKt.removeAll((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), new $$Lambda$SqlTableReferenceParser$b$x_0RKqvQ3rgoRRPgxibj_0CmY(r5));
            if (a(r3, "FROM") == true) goto L30;
            if (a(r3, "JOIN") == true) goto L30;
            if (r5.getType() != TokenType.COMMA) goto L17;
            if (r0.contains(Integer.valueOf(r5.c())) == false) goto L17;
            if (a(this, r3 + 1, false, 2, null) == true) goto L3;
            return false;
        L17:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L20;
        L22:
            Iterator r7 = r6.iterator();
        L24:
            if (r7.hasNext() == false) goto L21;
            if (a(r3, (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L24;
        L27:
            if (r4 == false) goto L3;
            r0.remove(Integer.valueOf(r5.c()));
        L21:
            r4 = false;
            goto L27
        L20:
            if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L22;
        L30:
            if (a(this, r3 + 1, false, 2, null) == false) goto L31;
            r0.add(Integer.valueOf(r5.c()));
            goto L3
        L31:
            return false;
        L33:
            return true;
        }

        private final C0426b d(int r6) {
            String r0 = e(r6);
            if (r0 != null) goto L6;
            return null;
        L6:
            boolean r1 = false;
            int r7 = r6 + 1;
            if (f(r7) != TokenType.DOT) goto L12;
            int r3 = r7 + 1;
            if (e(r3) == null) goto L12;
            r0 = e(r3);
            Intrinsics.checkNotNull(r0);
            r7 = r7 + 2;
            r1 = true;
        L12:
            return new C0426b(r0, r7, r1);
        }

        private final String e(int r3) {
            c r2 = (c) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f8461b, r3), c.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L5;
            return null;
        L5:
            String r0 = r2.a();
            if (r2.getType() != TokenType.WORD) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == true) goto L11;
            return null;
        L11:
            return r0;
        L8:
            r4 = false;
            goto L9
        }

        private final TokenType f(int r2) {
            c r1 = (c) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f8461b, r2), c.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.getType();
        }

        /* JADX INFO: renamed from: lambda$x_0RKqvQ3rgoRRPgxibj_-0Cm-Y, reason: not valid java name */
        public static /* synthetic */ boolean m467lambda$x_0RKqvQ3rgoRRPgxibj_0CmY(c r0, int r1) {
            return a(r0, r1);
        }

        public final Set<String> a() {
            Integer r0 = b();
            if (r0 != null) goto L5;
            return null;
        L5:
            if (b(r0.intValue()) == true) goto L8;
            return null;
        L8:
            if (c() == true) goto L10;
            return null;
        L10:
            Collection<String> r3 = this.c.values();
            Intrinsics.checkNotNullExpressionValue(r3, "<get-values>(...)");
            return (Set) ZeusTransformUtils.preCheckCast(CollectionsKt.toCollection((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$Token;", "", "type", "Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TokenType;", EventBody.KEY_VALUE, "", "quoted", "", "depth", "", "<init>", "(Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TokenType;Ljava/lang/String;ZI)V", "getType", "()Lcom/obric/memorydata/aikernelcore/bridge/SqlTableReferenceParser$TokenType;", "getValue", "()Ljava/lang/String;", "getQuoted", "()Z", "getDepth", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TokenType f8464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8465b;
        private final boolean c;
        private final int d;

        public c(TokenType r2, String r3, boolean r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
            this.f8464a = r2;
            this.f8465b = r3;
            this.c = r4;
            this.d = r5;
        }

        public /* synthetic */ c(TokenType r1, String r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 4) == 0) goto L8;
            r3 = false;
        L8:
            this(r1, r2, r3, r4);
        }

        public final String a() {
            return this.f8465b;
        }

        public final boolean b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f8464a == r6.f8464a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8465b, r6.f8465b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final TokenType getType() {
            return this.f8464a;
        }

        public int hashCode() {
            return (((((this.f8464a.hashCode() * 31) + this.f8465b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "Token(type=" + this.f8464a + ", value=" + this.f8465b + ", quoted=" + this.c + ", depth=" + this.d + ')';
        }
    }

    static {
        f8457a = new SqlTableReferenceParser();
    }

    private SqlTableReferenceParser() {
    }

    public final Set<String> a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "sql");
        List<c> r0 = new a(r1).a();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.isEmpty() == false) goto L11;
        return SetsKt.emptySet();
    L11:
        return new b(r0).a();
    }
}
