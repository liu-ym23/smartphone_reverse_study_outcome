package com.obric.memorydata.ui.settingsharness;

import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsRowState;", "", "visible", "", "enabled", "pending", "checked", MemoryListActivity.JUMP_FROM_DETAIL, "Lcom/obric/memorydata/ui/settingsharness/SettingsText;", "<init>", "(ZZZLjava/lang/Boolean;Lcom/obric/memorydata/ui/settingsharness/SettingsText;)V", "getVisible", "()Z", "getEnabled", "getPending", "getChecked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDetail", "()Lcom/obric/memorydata/ui/settingsharness/SettingsText;", "component1", "component2", "component3", "component4", "component5", "copy", "(ZZZLjava/lang/Boolean;Lcom/obric/memorydata/ui/settingsharness/SettingsText;)Lcom/obric/memorydata/ui/settingsharness/SettingsRowState;", "equals", "other", "hashCode", "", "toString", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13059b;
    private final boolean c;
    private final Boolean d;
    private final q e;

    public o() {
        this(false, false, false, null, null, 31, null);
    }

    public o(boolean r3, boolean r4, boolean r5, Boolean r6, q r7) {
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r7, q.class, "com.obric.memorydata.plugin");
        this.f13058a = r3;
        this.f13059b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }

    public /* synthetic */ o(boolean r8, boolean r9, boolean r10, Boolean r11, q r12, int r13, DefaultConstructorMarker r14) {
        q r15 = (q) ZeusTransformUtils.wrapperContextForParams(r12, q.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r13 & 4) == 0) goto L13;
        r10 = false;
    L13:
        boolean r4 = r10;
        if ((r13 & 8) == 0) goto L16;
        Boolean r5 = null;
    L18:
        if ((r13 & 16) == 0) goto L20;
        q r6 = null;
    L21:
        this(r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r15;
        goto L21
    L16:
        r5 = r11;
        goto L18
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ o a(o r6, boolean r7, boolean r8, boolean r9, Boolean r10, q r11, int r12, Object r13) {
        q r14 = (q) ZeusTransformUtils.wrapperContextForParams(r11, q.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f13058a;
    L5:
        boolean r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.f13059b;
    L8:
        boolean r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.d;
    L14:
        Boolean r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.e;
    L18:
        return r6.a(r1, r2, r3, r4, r14);
    }

    public final o a(boolean r7, boolean r8, boolean r9, Boolean r10, q r11) {
        return new o(r7, r8, r9, r10, (q) ZeusTransformUtils.wrapperContextForParams(r11, q.class, "com.obric.memorydata.plugin"));
    }

    public final boolean a() {
        return this.f13058a;
    }

    public final boolean b() {
        return this.f13059b;
    }

    public final boolean c() {
        return this.c;
    }

    public final Boolean d() {
        return this.d;
    }

    public final q e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (this.f13058a == r6.f13058a) goto L12;
        return false;
    L12:
        if (this.f13059b == r6.f13059b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.f13058a) * 31) + Boolean.hashCode(this.f13059b)) * 31) + Boolean.hashCode(this.c)) * 31;
        Boolean r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        q r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SettingsRowState(visible=" + this.f13058a + ", enabled=" + this.f13059b + ", pending=" + this.c + ", checked=" + this.d + ", detail=" + this.e + ')';
    }
}
