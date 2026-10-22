package com.obric.memorydata.ui.settingpage.viewmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/ui/settingpage/viewmodel/SettingUIState;", "", "isInstantEntityIndexSwitchOn", "", "isOnScreenUseClientOcrSwitchOn", "isOnAvoidDataImportSwitchOn", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13024b;
    private final boolean c;

    public a() {
        this(false, false, false, 7, null);
    }

    public a(boolean r1, boolean r2, boolean r3) {
        this.f13023a = r1;
        this.f13024b = r2;
        this.c = r3;
    }

    public /* synthetic */ a(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ a a(a r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f13023a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f13024b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final a a(boolean r1, boolean r2, boolean r3) {
        return new a(r1, r2, r3);
    }

    public final boolean a() {
        return this.f13023a;
    }

    public final boolean b() {
        return this.f13024b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f13023a == r6.f13023a) goto L12;
        return false;
    L12:
        if (this.f13024b == r6.f13024b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f13023a) * 31) + Boolean.hashCode(this.f13024b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "SettingUIState(isInstantEntityIndexSwitchOn=" + this.f13023a + ", isOnScreenUseClientOcrSwitchOn=" + this.f13024b + ", isOnAvoidDataImportSwitchOn=" + this.c + ')';
    }
}
