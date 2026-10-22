package com.obric.memorydata.ui.settingsharness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "", "rowId", "", "getRowId", "()Ljava/lang/String;", "SwitchChangeRequested", "NavigationRequested", "SelectorRequested", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction$NavigationRequested;", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction$SelectorRequested;", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction$SwitchChangeRequested;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsAction$NavigationRequested;", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "rowId", "", "actionKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRowId", "()Ljava/lang/String;", "getActionKey", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13029b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rowId");
            Intrinsics.checkNotNullParameter(r3, "actionKey");
            this.f13028a = r2;
            this.f13029b = r3;
        }

        @Override // com.obric.memorydata.ui.settingsharness.b
        public String a() {
            return this.f13028a;
        }

        public final String b() {
            return this.f13029b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13028a, r6.f13028a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13029b, r6.f13029b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f13028a.hashCode() * 31) + this.f13029b.hashCode();
        }

        public String toString() {
            return "NavigationRequested(rowId=" + this.f13028a + ", actionKey=" + this.f13029b + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.ui.settingsharness.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsAction$SelectorRequested;", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "rowId", "", "selectorKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRowId", "()Ljava/lang/String;", "getSelectorKey", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0715b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13031b;

        public C0715b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "rowId");
            Intrinsics.checkNotNullParameter(r3, "selectorKey");
            this.f13030a = r2;
            this.f13031b = r3;
        }

        @Override // com.obric.memorydata.ui.settingsharness.b
        public String a() {
            return this.f13030a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0715b.class) == true) goto L8;
            return false;
        L8:
            C0715b r6 = (C0715b) ZeusTransformUtils.preCheckCast(r5, C0715b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13030a, r6.f13030a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13031b, r6.f13031b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f13030a.hashCode() * 31) + this.f13031b.hashCode();
        }

        public String toString() {
            return "SelectorRequested(rowId=" + this.f13030a + ", selectorKey=" + this.f13031b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsAction$SwitchChangeRequested;", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "rowId", "", "targetChecked", "", "<init>", "(Ljava/lang/String;Z)V", "getRowId", "()Ljava/lang/String;", "getTargetChecked", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13033b;

        public c(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "rowId");
            this.f13032a = r2;
            this.f13033b = r3;
        }

        @Override // com.obric.memorydata.ui.settingsharness.b
        public String a() {
            return this.f13032a;
        }

        public final boolean b() {
            return this.f13033b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13032a, r6.f13032a) == true) goto L12;
            return false;
        L12:
            if (this.f13033b == r6.f13033b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f13032a.hashCode() * 31) + Boolean.hashCode(this.f13033b);
        }

        public String toString() {
            return "SwitchChangeRequested(rowId=" + this.f13032a + ", targetChecked=" + this.f13033b + ')';
        }
    }

    String a();
}
