package com.obric.memorydata.ui.settingsharness;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\n\u000b\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", "", OaidModel.KEY_ID, "", "getId", "()Ljava/lang/String;", "viewId", "", "getViewId", "()I", "Switch", "Navigation", "Selector", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Navigation;", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Selector;", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Switch;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface n {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Navigation;", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", OaidModel.KEY_ID, "", "viewId", "", "actionKey", "bindsDetail", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getViewId", "()I", "getActionKey", "getBindsDetail", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13053b;
        private final String c;
        private final boolean d;

        public a(String r2, int r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, "actionKey");
            this.f13052a = r2;
            this.f13053b = r3;
            this.c = r4;
            this.d = r5;
        }

        public /* synthetic */ a(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = false;
        L5:
            this(r1, r2, r3, r4);
        }

        @Override // com.obric.memorydata.ui.settingsharness.n
        public String a() {
            return this.f13052a;
        }

        @Override // com.obric.memorydata.ui.settingsharness.n
        public int b() {
            return this.f13053b;
        }

        public final String c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13052a, r6.f13052a) == true) goto L12;
            return false;
        L12:
            if (this.f13053b == r6.f13053b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f13052a.hashCode() * 31) + Integer.hashCode(this.f13053b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "Navigation(id=" + this.f13052a + ", viewId=" + this.f13053b + ", actionKey=" + this.c + ", bindsDetail=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Selector;", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", OaidModel.KEY_ID, "", "viewId", "", "selectorKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getViewId", "()I", "getSelectorKey", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13055b;
        private final String c;

        @Override // com.obric.memorydata.ui.settingsharness.n
        public String a() {
            return this.f13054a;
        }

        @Override // com.obric.memorydata.ui.settingsharness.n
        public int b() {
            return this.f13055b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13054a, r6.f13054a) == true) goto L12;
            return false;
        L12:
            if (this.f13055b == r6.f13055b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f13054a.hashCode() * 31) + Integer.hashCode(this.f13055b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Selector(id=" + this.f13054a + ", viewId=" + this.f13055b + ", selectorKey=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Switch;", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", OaidModel.KEY_ID, "", "viewId", "", "<init>", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getViewId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13057b;

        public c(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
            this.f13056a = r2;
            this.f13057b = r3;
        }

        @Override // com.obric.memorydata.ui.settingsharness.n
        public String a() {
            return this.f13056a;
        }

        @Override // com.obric.memorydata.ui.settingsharness.n
        public int b() {
            return this.f13057b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13056a, r6.f13056a) == true) goto L12;
            return false;
        L12:
            if (this.f13057b == r6.f13057b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f13056a.hashCode() * 31) + Integer.hashCode(this.f13057b);
        }

        public String toString() {
            return "Switch(id=" + this.f13056a + ", viewId=" + this.f13057b + ')';
        }
    }

    String a();

    int b();
}
