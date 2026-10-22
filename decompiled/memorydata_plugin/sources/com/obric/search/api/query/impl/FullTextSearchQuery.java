package com.obric.search.api.query.impl;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000b\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "Lcom/obric/search/api/query/intf/IQuery;", "inputMatchClause", "", "(Ljava/lang/String;)V", "matchClause", "getMatchClause", "()Ljava/lang/String;", "matchClauseStringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addColumnFilter", "colName", "", "isExcluded", "", "and", ChatMessage.TYPE_QUERY, "mergeQuery", "booleanOperator", "not", "or", "Companion", "Operator", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f14940b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/query/impl/FullTextSearchQuery$Operator;", "", "(Ljava/lang/String;I)V", "AND", "OR", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Operator extends Enum<Operator> {
        private static final /* synthetic */ Operator[] $VALUES = null;
        public static final Operator AND = null;
        public static final Operator OR = null;

        private static final /* synthetic */ Operator[] $values() {
            return new Operator[]{AND, OR};
        }

        static {
            AND = new Operator("AND", 0);
            OR = new Operator("OR", 1);
            $VALUES = $values();
        }

        private Operator(String r1, int r2) {
            super(r1, r2);
        }

        public static Operator valueOf(String r2) {
            return (Operator) ZeusTransformUtils.preCheckCast(Enum.valueOf(Operator.class, r2), Operator.class, "com.obric.memorydata.plugin");
        }

        public static Operator[] values() {
            return (Operator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Operator[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006J\u001c\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J&\u0010\u0012\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0004J>\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0014J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0014Jn\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$2\u0006\u0010%\u001a\u00020\u00042\n\u0010&\u001a\u00060'j\u0002`(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u00102\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0016\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0010\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/search/api/query/impl/FullTextSearchQuery$Companion;", "", "()V", "DEFAULT_SPLIT_PINYIN_MAX_LEN", "", "SAME_PINYIN_CONTROL_SEQUENCE", "", "SYNONYM_PHRASE_CONTROL_SEQUENCE", "TAG", "buildEndWithLetterOrDigitPhraseQuery", "Lcom/obric/search/api/query/impl/FullTextSearchQuery;", Params.CONTENT, "buildInitialTokenQuery", "phrase", "buildNearQuery", "phraseList", "", "n", "buildPhraseQuery", "isPrefixQuery", "", "operator", "Lcom/obric/search/api/query/impl/FullTextSearchQuery$Operator;", "buildPinyinQuery", "maxLen", "buildSamePinyinQuery", "excludedMap", "", "numberLimit", "isInitialTokenQuery", "buildSynonymPhraseQuery", "buildSynonymPhraseQueryForTest", "buildTokenizerSamePinyinQuery", "getAllSamePinyinPhrase", "", "result", "", "pos", "currentString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "codePoints", "pinyin", "parse", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "input", "parseOTokenizer1", "parseOTokenizer2", "sqliteEscape", "keyWord", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ FullTextSearchQuery a(a r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.a(r1, r2);
        }

        private final String a(String r7) {
            return StringsKt.replace$default(r7, "\"", "\"\"", false, 4, null);
        }

        public static /* synthetic */ FullTextSearchQuery b(a r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.b(r1, r2);
        }

        public static /* synthetic */ FullTextSearchQuery c(a r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.c(r1, r2);
        }

        public final FullTextSearchQuery a(String r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r6, "phrase");
            DefaultConstructorMarker r0 = null;
            if (r7 == false) goto L6;
            return new FullTextSearchQuery(Typography.quote + a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString()) + "\"*", r0);
        L6:
            return new FullTextSearchQuery(Typography.quote + a(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString()) + Typography.quote, r0);
        }

        public final FullTextSearchQuery b(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "phrase");
            String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            List<String> r0 = SQLiteFts5Extension.f14967a.a(r12);
            if (r0.isEmpty() == true) goto L5;
            DefaultConstructorMarker r3 = null;
            if (r11 == false) goto L19;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            StringBuilder r1 = new StringBuilder();
            Iterator r14 = r13.iterator();
        L10:
            if (r14.hasNext() == false) goto L18;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
            boolean r7 = true;
        L15:
            if (r7 == false) goto L17;
            r1.append(" OR ");
        L17:
            r1 = r1.append(Typography.quote + FullTextSearchQuery.f14939a.a(r6) + "\"*");
            Intrinsics.checkNotNullExpressionValue(r1, "sb.append(\"\\\"${sqliteEscape(w)}\\\"*\")");
            goto L10
        L14:
            r7 = false;
            goto L15
        L18:
            String r15 = r1.toString();
            Intrinsics.checkNotNullExpressionValue(r15, "sb.toString()");
            return new FullTextSearchQuery(r15, r3);
        L19:
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            StringBuilder r2 = new StringBuilder();
            Iterator r17 = r16.iterator();
        L21:
            if (r17.hasNext() == false) goto L29;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L25;
            boolean r9 = true;
        L26:
            if (r9 == false) goto L28;
            r2.append(" OR ");
        L28:
            r2 = r2.append(Typography.quote + FullTextSearchQuery.f14939a.a(r8) + Typography.quote);
            Intrinsics.checkNotNullExpressionValue(r2, "sb.append(\"\\\"${sqliteEscape(w)}\\\"\")");
            goto L21
        L25:
            r9 = false;
            goto L26
        L29:
            String r18 = r2.toString();
            Intrinsics.checkNotNullExpressionValue(r18, "sb.toString()");
            return new FullTextSearchQuery(r18, r3);
        L5:
            return a(r12, r11);
        }

        public final FullTextSearchQuery c(String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
            String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            DefaultConstructorMarker r0 = null;
            if (r6 == false) goto L7;
            return new FullTextSearchQuery("^\"\t1\t" + a(r7) + Typography.quote, r0);
        L7:
            return new FullTextSearchQuery("\"\t1\t" + a(r7) + Typography.quote, r0);
        }
    }

    static {
        f14939a = new a(null);
    }

    private FullTextSearchQuery(String r2) {
        this.f14940b = new StringBuilder(r2);
    }

    public /* synthetic */ FullTextSearchQuery(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private final FullTextSearchQuery a(FullTextSearchQuery r4, String r5) {
        this.f14940b.insert(0, '(');
        this.f14940b.append(") " + r5 + " (" + r4.a() + ')');
        return this;
    }

    public final FullTextSearchQuery a(FullTextSearchQuery r2) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        return a(r2, "AND");
    }

    public final FullTextSearchQuery a(List<String> r8, boolean r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "colName");
        int r2 = 1;
        if (r10.size() == 1) goto L5;
        if (r9 == false) goto L10;
        StringBuilder r11 = new StringBuilder("- {" + ((String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.memorydata.plugin")));
    L11:
        int r0 = r10.size();
    L12:
        if (r2 >= r0) goto L14;
        r11.append(' ' + ((String) ZeusTransformUtils.preCheckCast(r10.get(r2), String.class, "com.obric.memorydata.plugin")));
        r2 = r2 + 1;
        goto L12
    L14:
        r11.append("} : ");
    L15:
        r11.append("(");
        this.f14940b.insert(0, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        this.f14940b.append(")");
        return this;
    L10:
        r11 = new StringBuilder('{' + ((String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.memorydata.plugin")));
        goto L11
    L5:
        if (r9 == false) goto L7;
        r11 = new StringBuilder("- " + ((String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.memorydata.plugin")) + " : ");
        goto L15
    L7:
        r11 = new StringBuilder(((String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.memorydata.plugin")) + " : ");
        goto L15
    }

    public final String a() {
        String r1 = this.f14940b.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "matchClauseStringBuilder.toString()");
        return r1;
    }

    public final FullTextSearchQuery b(FullTextSearchQuery r2) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        return a(r2, "OR");
    }
}
