package com.obric.memorydata.utils;

import com.bytedance.bdinstall.Api;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/utils/TextWord;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", Api.KEY_REGION, "", "", "textType", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getRegion", "()Ljava/util/List;", "getTextType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextWord {
    private final List<List<Integer>> region;
    private final String text;

    @SerializedName("text_type")
    private final String textType;

    public TextWord(String r3, List<? extends List<Integer>> r4, String r5) {
        List<List<Integer>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, Api.KEY_REGION);
        Intrinsics.checkNotNullParameter(r5, "textType");
        this.text = r3;
        this.region = r6;
        this.textType = r5;
    }

    public static /* synthetic */ TextWord copy$default(TextWord r1, String r2, List r3, String r4, int r5, Object r6) {
        List<List<Integer>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.region;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.textType;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final List<List<Integer>> component2() {
        return this.region;
    }

    public final String component3() {
        return this.textType;
    }

    public final TextWord copy(String r2, List<? extends List<Integer>> r3, String r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r1, Api.KEY_REGION);
        Intrinsics.checkNotNullParameter(r4, "textType");
        return new TextWord(r2, r1, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TextWord.class) == true) goto L8;
        return false;
    L8:
        TextWord r6 = (TextWord) ZeusTransformUtils.preCheckCast(r5, TextWord.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.region, r6.region) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textType, r6.textType) == true) goto L17;
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

    public final String getTextType() {
        return this.textType;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.region.hashCode()) * 31) + this.textType.hashCode();
    }

    public String toString() {
        return "TextWord(text=" + this.text + ", region=" + this.region + ", textType=" + this.textType + ')';
    }
}
