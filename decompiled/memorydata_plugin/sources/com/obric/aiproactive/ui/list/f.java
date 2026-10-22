package com.obric.aiproactive.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/ui/list/NowSummaryActionUiState;", "", "actionIndex", "", "action", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "<init>", "(ILcom/obric/aiproactive/api/AiProactiveActionExecuteItem;)V", "getActionIndex", "()I", "getAction", "()Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "displayText", "", "getDisplayText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiproactive.api.b f6709b;

    public f(int r2, com.obric.aiproactive.api.b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        this.f6708a = r2;
        this.f6709b = r3;
    }

    public final int a() {
        return this.f6708a;
    }

    public final com.obric.aiproactive.api.b b() {
        return this.f6709b;
    }

    public final String c() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.f6709b.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.f6709b.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (this.f6708a == r6.f6708a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6709b, r6.f6709b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f6708a) * 31) + this.f6709b.hashCode();
    }

    public String toString() {
        return "NowSummaryActionUiState(actionIndex=" + this.f6708a + ", action=" + this.f6709b + ')';
    }
}
