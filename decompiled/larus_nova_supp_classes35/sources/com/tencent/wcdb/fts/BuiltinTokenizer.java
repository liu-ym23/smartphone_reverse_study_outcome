package com.tencent.wcdb.fts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BuiltinTokenizer {
    public static final String ICU = "icu";
    public static final String MMICU = "mmicu";
    public static final String OneOrBinary = "wcdb_one_or_binary";
    public static final String Pinyin = "wcdb_pinyin";
    public static final String Porter = "porter";
    public static final String Simple = "simple";
    public static final String Unicode61 = "unicode61";
    public static final String Verbatim = "wcdb_verbatim";

    public static class Parameter {
        public static final String SimplifyChinese = "chinese_traditional_to_simplified";
        public static final String SkipStemming = "skip_stemming";

        public Parameter() {
        }
    }

    public BuiltinTokenizer() {
    }
}
