package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/settings/provider/LynxThreadStrategy;", "", "asyncCreateView", "", "threadStrategy", "widgets", "", "", "<init>", "(IILjava/util/List;)V", "getAsyncCreateView", "()I", "getThreadStrategy", "getWidgets", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxThreadStrategy {

    @SerializedName("async_create_view")
    private final int asyncCreateView;

    @SerializedName("thread_strategy")
    private final int threadStrategy;

    @SerializedName("widgets")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> widgets;

    public LynxThreadStrategy() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxThreadStrategy copy$default(LynxThreadStrategy r0, int r1, int r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.asyncCreateView;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.threadStrategy;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.widgets;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final int component1() {
        return this.asyncCreateView;
    }

    public final int component2() {
        return this.threadStrategy;
    }

    public final List<String> component3() {
        return this.widgets;
    }

    public final LynxThreadStrategy copy(int r10, int r11, List<String> r12) {
        return new LynxThreadStrategy(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LynxThreadStrategy) == true) goto L8;
        return false;
    L8:
        LynxThreadStrategy r11 = (LynxThreadStrategy) r10;
        if (this.asyncCreateView == r11.asyncCreateView) goto L12;
        return false;
    L12:
        if (this.threadStrategy == r11.threadStrategy) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgets, r11.widgets) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.asyncCreateView * 31) + this.threadStrategy) * 31;
        List<String> r1 = this.widgets;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LynxThreadStrategy(asyncCreateView=" + this.asyncCreateView + ", threadStrategy=" + this.threadStrategy + ", widgets=" + this.widgets + ')';
    }

    public final int getAsyncCreateView() {
        return this.asyncCreateView;
    }

    public final int getThreadStrategy() {
        return this.threadStrategy;
    }

    public final List<String> getWidgets() {
        return this.widgets;
    }

    public LynxThreadStrategy(int r1, int r10, List<String> r11) {
        this.asyncCreateView = r1;
        this.threadStrategy = r10;
        this.widgets = r11;
    }

    public /* synthetic */ LynxThreadStrategy(int r10, int r11, List r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = CollectionsKt.emptyList();
    L11:
        this(r10, r11, r12);
    }
}
