package com.obric.capabilitykit.common;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J<\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/DispatchContext;", "", "context", "Landroid/content/Context;", "questionId", "", "ext", "", "", "(Landroid/content/Context;Ljava/lang/Long;Ljava/util/Map;)V", "getContext", "()Landroid/content/Context;", "getExt", "()Ljava/util/Map;", "getQuestionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Landroid/content/Context;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/capabilitykit/common/DispatchContext;", "equals", "", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DispatchContext {
    private final Context context;
    private final Map<String, String> ext;
    private final Long questionId;

    public DispatchContext(Context r3, Long r4, Map<String, String> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.questionId = r4;
        this.ext = r7;
    }

    public /* synthetic */ DispatchContext(Context r2, Long r3, Map r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = null;
    L5:
        this(r7, r3, r8);
    }

    public static /* synthetic */ DispatchContext copy$default(DispatchContext r1, Context r2, Long r3, Map r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.context;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.questionId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.ext;
    L12:
        return r1.copy(r7, r3, r8);
    }

    public final Context component1() {
        return this.context;
    }

    public final Long component2() {
        return this.questionId;
    }

    public final Map<String, String> component3() {
        return this.ext;
    }

    public final DispatchContext copy(Context r2, Long r3, Map<String, String> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return new DispatchContext(r1, r3, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DispatchContext.class) == true) goto L8;
        return false;
    L8:
        DispatchContext r6 = (DispatchContext) ZeusTransformUtils.preCheckCast(r5, DispatchContext.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.questionId, r6.questionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        int r0 = this.context.hashCode() * 31;
        Long r1 = this.questionId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Map<String, String> r5 = this.ext;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DispatchContext(context=" + this.context + ", questionId=" + this.questionId + ", ext=" + this.ext + ')';
    }
}
