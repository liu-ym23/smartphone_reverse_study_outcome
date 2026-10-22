package com.obric.memorydata.utils;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/utils/OcrLineResult;", "", Api.KEY_REGION, "", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "text_word", "Lcom/obric/memorydata/utils/TextWord;", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getRegion", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getText_word", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OcrLineResult {
    private final List<List<Integer>> region;
    private final String text;
    private final List<TextWord> text_word;

    public OcrLineResult(List<? extends List<Integer>> r3, String r4, List<TextWord> r5) {
        List<List<Integer>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<TextWord> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, Api.KEY_REGION);
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r7, "text_word");
        this.region = r6;
        this.text = r4;
        this.text_word = r7;
    }

    public static /* synthetic */ OcrLineResult copy$default(OcrLineResult r1, List r2, String r3, List r4, int r5, Object r6) {
        List<List<Integer>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<TextWord> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.region;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.text;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.text_word;
    L12:
        return r1.copy(r7, r3, r8);
    }

    public final List<List<Integer>> component1() {
        return this.region;
    }

    public final String component2() {
        return this.text;
    }

    public final List<TextWord> component3() {
        return this.text_word;
    }

    public final OcrLineResult copy(List<? extends List<Integer>> r2, String r3, List<TextWord> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, Api.KEY_REGION);
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r5, "text_word");
        return new OcrLineResult(r1, r3, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OcrLineResult.class) == true) goto L8;
        return false;
    L8:
        OcrLineResult r6 = (OcrLineResult) ZeusTransformUtils.preCheckCast(r5, OcrLineResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.region, r6.region) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text_word, r6.text_word) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final List<List<Integer>> getRegion() {
        return this.region;
    }

    public final String getText() {
        return this.text;
    }

    public final List<TextWord> getText_word() {
        return this.text_word;
    }

    public int hashCode() {
        return (((this.region.hashCode() * 31) + this.text.hashCode()) * 31) + this.text_word.hashCode();
    }

    public String toString() {
        return "OcrLineResult(region=" + this.region + ", text=" + this.text + ", text_word=" + this.text_word + ')';
    }
}
