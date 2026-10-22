package com.obric.memorydata.dc;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/dc/PageContextResult;", "", "state", "Lcom/obric/memorydata/dc/PageContextState;", "data", "Lcom/obric/memorydata/dc/PageContextData;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "<init>", "(Lcom/obric/memorydata/dc/PageContextState;Lcom/obric/memorydata/dc/PageContextData;Landroid/content/Intent;)V", "getState", "()Lcom/obric/memorydata/dc/PageContextState;", "getData", "()Lcom/obric/memorydata/dc/PageContextData;", "getIntent", "()Landroid/content/Intent;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deep_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PageContextResult {
    private final PageContextData data;
    private final Intent intent;
    private final PageContextState state;

    public PageContextResult(PageContextState r2, PageContextData r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.state = r2;
        this.data = r3;
        this.intent = r4;
    }

    public static /* synthetic */ PageContextResult copy$default(PageContextResult r0, PageContextState r1, PageContextData r2, Intent r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.intent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final PageContextState component1() {
        return this.state;
    }

    public final PageContextData component2() {
        return this.data;
    }

    public final Intent component3() {
        return this.intent;
    }

    public final PageContextResult copy(PageContextState r1, PageContextData r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r1, "state");
        return new PageContextResult(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PageContextResult.class) == true) goto L8;
        return false;
    L8:
        PageContextResult r6 = (PageContextResult) ZeusTransformUtils.preCheckCast(r5, PageContextResult.class, "com.obric.memorydata.plugin");
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final PageContextData getData() {
        return this.data;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final PageContextState getState() {
        return this.state;
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        PageContextData r1 = this.data;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Intent r5 = this.intent;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PageContextResult(state=" + this.state + ", data=" + this.data + ", intent=" + this.intent + ')';
    }
}
