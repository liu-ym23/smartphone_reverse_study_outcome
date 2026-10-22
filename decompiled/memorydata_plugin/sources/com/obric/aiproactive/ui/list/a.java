package com.obric.aiproactive.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/obric/aiproactive/ui/list/HistoryRecommendationActionUiState;", "", "actionIndex", "", "action", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", BuildConfig.FLAVOR, "", "enabled", "<init>", "(ILcom/obric/aiproactive/api/AiProactiveActionExecuteItem;ZZ)V", "getActionIndex", "()I", "getAction", "()Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "getSelected", "()Z", "getEnabled", "displayText", "", "getDisplayText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiproactive.api.b f6703b;
    private final boolean c;
    private final boolean d;

    public a(int r2, com.obric.aiproactive.api.b r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        this.f6702a = r2;
        this.f6703b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static /* synthetic */ a a(a r0, int r1, com.obric.aiproactive.api.b r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f6702a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f6703b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final int a() {
        return this.f6702a;
    }

    public final a a(int r1, com.obric.aiproactive.api.b r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return new a(r1, r2, r3, r4);
    }

    public final com.obric.aiproactive.api.b b() {
        return this.f6703b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.f6703b.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.f6703b.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f6702a == r6.f6702a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6703b, r6.f6703b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f6702a) * 31) + this.f6703b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "HistoryRecommendationActionUiState(actionIndex=" + this.f6702a + ", action=" + this.f6703b + ", selected=" + this.c + ", enabled=" + this.d + ')';
    }
}
