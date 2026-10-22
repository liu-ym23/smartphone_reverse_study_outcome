package com.obric.memorydata.memory.ui.settings;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0003H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AppSettingItem;", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "description", "isEnabled", "", "isChecked", "installed", "pendingChecked", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/Boolean;)V", "getAppName", "()Ljava/lang/String;", "getPackageName", "getDescription", "()Z", "getInstalled", "getPendingChecked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "displayChecked", "getDisplayChecked", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/Boolean;)Lcom/obric/memorydata/memory/ui/settings/AppSettingItem;", "equals", "other", "hashCode", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11431b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final Boolean g;

    public c(String r2, String r3, String r4, boolean r5, boolean r6, boolean r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "description");
        this.f11430a = r2;
        this.f11431b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ c(String r10, String r11, String r12, boolean r13, boolean r14, boolean r15, Boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r17 & 16) == 0) goto L9;
        boolean r6 = true;
    L11:
        if ((r17 & 64) == 0) goto L13;
        Boolean r8 = null;
    L14:
        this(r10, r11, r12, r5, r6, r15, r8);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ c a(c r5, String r6, String r7, String r8, boolean r9, boolean r10, boolean r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.f11430a;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.f11431b;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.c;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.d;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.e;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.f;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.g;
    L23:
        String r16 = r6;
        return r5.a(r16, r15, r0, r1, r2, r3, r12);
    }

    public final c a(String r9, String r10, String r11, boolean r12, boolean r13, boolean r14, Boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "appName");
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "description");
        return new c(r9, r10, r11, r12, r13, r14, r15);
    }

    public final String a() {
        return this.f11430a;
    }

    public final String b() {
        return this.f11431b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11430a, r6.f11430a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11431b, r6.f11431b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public final Boolean g() {
        return this.g;
    }

    public final boolean h() {
        Boolean r0 = this.g;
        if (r0 == null) goto L6;
        return r0.booleanValue();
    L6:
        return this.e;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f11430a.hashCode() * 31) + this.f11431b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31;
        Boolean r2 = this.g;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AppSettingItem(name=" + this.f11430a + ", package=" + this.f11431b + ", checked=" + this.e + ", pending=" + this.g + ", enabled=" + this.d + ')';
    }
}
