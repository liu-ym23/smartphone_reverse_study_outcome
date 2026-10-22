package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/MsgPromptConf;", "", "placeholder", "", "promptList", "", "Lcom/larus/canvas/service/bean/PromptItem;", "noLimitPromptFormat", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getPlaceholder", "()Ljava/lang/String;", "getPromptList", "()Ljava/util/List;", "getNoLimitPromptFormat", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MsgPromptConf {

    @SerializedName("no_limit_prompt_format")
    private final String noLimitPromptFormat;

    @SerializedName("placeholder")
    private final String placeholder;

    @SerializedName("prompt_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<PromptItem> promptList;

    public MsgPromptConf() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgPromptConf copy$default(MsgPromptConf r0, String r1, List r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.placeholder;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.promptList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.noLimitPromptFormat;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.placeholder;
    }

    public final List<PromptItem> component2() {
        return this.promptList;
    }

    public final String component3() {
        return this.noLimitPromptFormat;
    }

    public final MsgPromptConf copy(String r2, List<PromptItem> r3, String r4) {
        return new MsgPromptConf(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MsgPromptConf) == true) goto L8;
        return false;
    L8:
        MsgPromptConf r6 = (MsgPromptConf) r5;
        if (Intrinsics.areEqual(this.placeholder, r6.placeholder) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promptList, r6.promptList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.noLimitPromptFormat, r6.noLimitPromptFormat) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.placeholder;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<PromptItem> r4 = this.promptList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.noLimitPromptFormat;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MsgPromptConf(placeholder=" + this.placeholder + ", promptList=" + this.promptList + ", noLimitPromptFormat=" + this.noLimitPromptFormat + ')';
    }

    public final String getNoLimitPromptFormat() {
        return this.noLimitPromptFormat;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final List<PromptItem> getPromptList() {
        return this.promptList;
    }

    public MsgPromptConf(String r1, List<PromptItem> r2, String r3) {
        this.placeholder = r1;
        this.promptList = r2;
        this.noLimitPromptFormat = r3;
    }

    public /* synthetic */ MsgPromptConf(String r2, List r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
