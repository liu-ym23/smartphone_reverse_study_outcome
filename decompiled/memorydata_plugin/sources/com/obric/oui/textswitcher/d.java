package com.obric.oui.textswitcher;

import android.widget.ViewSwitcher;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/obric/oui/textswitcher/TextSwitcherSpec;", "", "textSpec", "Lcom/obric/oui/textswitcher/TextSpec;", "animationSpec", "Lcom/obric/oui/textswitcher/AnimationSpec;", "triggerSpec", "Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;", "dataSpec", "Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;", "viewFactory", "Landroid/widget/ViewSwitcher$ViewFactory;", "isSupportMarquee", "", "(Lcom/obric/oui/textswitcher/TextSpec;Lcom/obric/oui/textswitcher/AnimationSpec;Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;Landroid/widget/ViewSwitcher$ViewFactory;Z)V", "getAnimationSpec", "()Lcom/obric/oui/textswitcher/AnimationSpec;", "getDataSpec", "()Lcom/obric/oui/textswitcher/TextSwitcherDataSpec;", "()Z", "getTextSpec", "()Lcom/obric/oui/textswitcher/TextSpec;", "getTriggerSpec", "()Lcom/obric/oui/textswitcher/TextSwitcherTriggerSpec;", "getViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f14724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f14725b;
    private final e c;
    private final c d;
    private final ViewSwitcher.ViewFactory e;
    private final boolean f;

    public d() {
        this(null, null, null, null, null, false, 63, null);
    }

    public d(b r3, a r4, e r5, c r6, ViewSwitcher.ViewFactory r7, boolean r8) {
        ViewSwitcher.ViewFactory r9 = (ViewSwitcher.ViewFactory) ZeusTransformUtils.wrapperContextForParams(r7, ViewSwitcher.ViewFactory.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "textSpec");
        Intrinsics.checkNotNullParameter(r4, "animationSpec");
        Intrinsics.checkNotNullParameter(r5, "triggerSpec");
        this.f14724a = r3;
        this.f14725b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r9;
        this.f = r8;
    }

    public /* synthetic */ d(b r14, a r15, e r16, c r17, ViewSwitcher.ViewFactory r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        ViewSwitcher.ViewFactory r0 = (ViewSwitcher.ViewFactory) ZeusTransformUtils.wrapperContextForParams(r18, ViewSwitcher.ViewFactory.class, "com.obric.memorydata.plugin");
        if ((r20 & 1) == 0) goto L5;
        b r1 = new b(null, null, null, 7, null);
    L7:
        if ((r20 & 2) == 0) goto L9;
        a r2 = new a(null, null, 3, null);
    L11:
        if ((r20 & 4) == 0) goto L13;
        e r4 = new e(0, 0, false, 7, null);
    L15:
        if ((r20 & 8) == 0) goto L17;
        c r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L22;
        r0 = null;
    L22:
        if ((r20 & 32) == 0) goto L24;
        boolean r3 = false;
    L25:
        this(r1, r2, r4, r5, r0, r3);
        return;
    L24:
        r3 = r19;
        goto L25
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }

    public final b a() {
        return this.f14724a;
    }

    public final boolean b() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14724a, r6.f14724a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14725b, r6.f14725b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((((this.f14724a.hashCode() * 31) + this.f14725b.hashCode()) * 31) + this.c.hashCode()) * 31;
        c r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ViewSwitcher.ViewFactory r5 = this.e;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.f;
        ?? r8 = r7;
        if (r7 == false) goto L14;
        r8 = 1;
    L14:
        return r6 + r8;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TextSwitcherSpec(textSpec=" + this.f14724a + ", animationSpec=" + this.f14725b + ", triggerSpec=" + this.c + ", dataSpec=" + this.d + ", viewFactory=" + this.e + ", isSupportMarquee=" + this.f + ')';
    }
}
