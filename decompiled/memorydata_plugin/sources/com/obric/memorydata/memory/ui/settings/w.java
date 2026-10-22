package com.obric.memorydata.memory.ui.settings;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", "", "<init>", "()V", "ToggleConfirmed", "ToggleSmartMemory", "SetPendingSmartMemory", "ToggleAppSetting", "SetPendingAppSetting", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$SetPendingAppSetting;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$SetPendingSmartMemory;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$ToggleAppSetting;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$ToggleConfirmed;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$ToggleSmartMemory;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class w {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$SetPendingAppSetting;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "pendingEnabled", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getPackageName", "()Ljava/lang/String;", "getPendingEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$SetPendingAppSetting;", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Boolean f11513b;

        public a(String r2, Boolean r3) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            super(null);
            this.f11512a = r2;
            this.f11513b = r3;
        }

        public final String a() {
            return this.f11512a;
        }

        public final Boolean b() {
            return this.f11513b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11512a, r6.f11512a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11513b, r6.f11513b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f11512a.hashCode() * 31;
            Boolean r1 = this.f11513b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "SetPendingAppSetting(packageName=" + this.f11512a + ", pendingEnabled=" + this.f11513b + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$SetPendingSmartMemory;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", "pendingEnabled", "", "<init>", "(Ljava/lang/Boolean;)V", "getPendingEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$SetPendingSmartMemory;", "equals", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f11514a;

        public b(Boolean r2) {
            super(null);
            this.f11514a = r2;
        }

        public final Boolean a() {
            return this.f11514a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11514a, r6.f11514a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.f11514a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "SetPendingSmartMemory(pendingEnabled=" + this.f11514a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$ToggleAppSetting;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "enabled", "", "<init>", "(Ljava/lang/String;Z)V", "getPackageName", "()Ljava/lang/String;", "getEnabled", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11516b;

        public c(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            super(null);
            this.f11515a = r2;
            this.f11516b = r3;
        }

        public final String a() {
            return this.f11515a;
        }

        public final boolean b() {
            return this.f11516b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11515a, r6.f11515a) == true) goto L12;
            return false;
        L12:
            if (this.f11516b == r6.f11516b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11515a.hashCode() * 31) + Boolean.hashCode(this.f11516b);
        }

        public String toString() {
            return "ToggleAppSetting(packageName=" + this.f11515a + ", enabled=" + this.f11516b + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$ToggleConfirmed;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", "hasConfirmed", "", "<init>", "(Z)V", "getHasConfirmed", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11517a;

        public d(boolean r2) {
            super(null);
            this.f11517a = r2;
        }

        public final boolean a() {
            return this.f11517a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (this.f11517a == r6.f11517a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f11517a);
        }

        public String toString() {
            return "ToggleConfirmed(hasConfirmed=" + this.f11517a + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent$ToggleSmartMemory;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11518a;

        public e(boolean r2) {
            super(null);
            this.f11518a = r2;
        }

        public final boolean a() {
            return this.f11518a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f11518a == r6.f11518a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f11518a);
        }

        public String toString() {
            return "ToggleSmartMemory(enabled=" + this.f11518a + ')';
        }
    }

    private w() {
    }

    public /* synthetic */ w(DefaultConstructorMarker r1) {
        this();
    }
}
