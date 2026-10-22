package com.bytedance.android.live.search.impl.search.model;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\t¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/model/LiveSearchResultParam;", "Ljava/io/Serializable;", "", "()V", "enterFrom", "", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "extra", "Ljava/util/HashMap;", "getExtra", "()Ljava/util/HashMap;", "setExtra", "(Ljava/util/HashMap;)V", "isHintSearch", "", "()Z", "setHintSearch", "(Z)V", "keyword", "getKeyword", "setKeyword", "logExtra", "getLogExtra", "setLogExtra", "rankInList", "", "getRankInList", "()I", "setRankInList", "(I)V", "realSearchWord", "getRealSearchWord", "setRealSearchWord", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultParam implements Serializable, Cloneable {
    private String enterFrom;
    private String enterMethod;
    private HashMap<String, String> extra;
    private boolean isHintSearch;
    private String keyword;
    private HashMap<String, String> logExtra;
    private int rankInList;
    private String realSearchWord;

    public LiveSearchResultParam() {
        this.enterMethod = "normal_search";
        this.enterFrom = "";
        this.extra = new HashMap();
        this.logExtra = new HashMap();
        this.keyword = "";
    }

    public Object clone() {
        return super.clone();
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final HashMap<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final int getRankInList() {
        return this.rankInList;
    }

    public final String getRealSearchWord() {
        return this.realSearchWord;
    }

    public final boolean isHintSearch() {
        return this.isHintSearch;
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFrom = r2;
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setExtra(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.extra = r2;
    }

    public final void setHintSearch(boolean r1) {
        this.isHintSearch = r1;
    }

    public final void setKeyword(String r1) {
        this.keyword = r1;
    }

    public final void setLogExtra(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.logExtra = r2;
    }

    public final void setRankInList(int r1) {
        this.rankInList = r1;
    }

    public final void setRealSearchWord(String r1) {
        this.realSearchWord = r1;
    }
}
