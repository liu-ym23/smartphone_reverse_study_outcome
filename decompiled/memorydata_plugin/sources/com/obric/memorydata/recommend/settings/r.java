package com.obric.memorydata.recommend.settings;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "", "<init>", "()V", "ToggleProactiveMemory", "ToggleAppSetting", "BulkToggleAppSetting", "ToggleCellular", "ToggleNewMemorySetting", "ToggleEnableCategories", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$BulkToggleAppSetting;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleAppSetting;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleCellular;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleEnableCategories;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleNewMemorySetting;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleProactiveMemory;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class r {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$BulkToggleAppSetting;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "packageNames", "", "", "enabled", "", "<init>", "(Ljava/util/Set;Z)V", "getPackageNames", "()Ljava/util/Set;", "getEnabled", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f12621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12622b;

        public a(Set<String> r3, boolean r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "packageNames");
            super(null);
            this.f12621a = r5;
            this.f12622b = r4;
        }

        public final Set<String> a() {
            return this.f12621a;
        }

        public final boolean b() {
            return this.f12622b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12621a, r6.f12621a) == true) goto L12;
            return false;
        L12:
            if (this.f12622b == r6.f12622b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12621a.hashCode() * 31) + Boolean.hashCode(this.f12622b);
        }

        public String toString() {
            return "BulkToggleAppSetting(packageNames=" + this.f12621a + ", enabled=" + this.f12622b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleAppSetting;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "enabled", "", "<init>", "(Ljava/lang/String;Z)V", "getPackageName", "()Ljava/lang/String;", "getEnabled", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12624b;

        public final String a() {
            return this.f12623a;
        }

        public final boolean b() {
            return this.f12624b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12623a, r6.f12623a) == true) goto L12;
            return false;
        L12:
            if (this.f12624b == r6.f12624b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12623a.hashCode() * 31) + Boolean.hashCode(this.f12624b);
        }

        public String toString() {
            return "ToggleAppSetting(packageName=" + this.f12623a + ", enabled=" + this.f12624b + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleCellular;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12625a;

        public final boolean a() {
            return this.f12625a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f12625a == r6.f12625a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f12625a);
        }

        public String toString() {
            return "ToggleCellular(enabled=" + this.f12625a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleEnableCategories;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "categoryCode", "", "isAdd", "", "<init>", "(IZ)V", "getCategoryCode", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12627b;

        public d(int r2, boolean r3) {
            super(null);
            this.f12626a = r2;
            this.f12627b = r3;
        }

        public final int a() {
            return this.f12626a;
        }

        public final boolean b() {
            return this.f12627b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (this.f12626a == r6.f12626a) goto L12;
            return false;
        L12:
            if (this.f12627b == r6.f12627b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f12626a) * 31) + Boolean.hashCode(this.f12627b);
        }

        public String toString() {
            return "ToggleEnableCategories(categoryCode=" + this.f12626a + ", isAdd=" + this.f12627b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleNewMemorySetting;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "setting", "", "<init>", "(I)V", "getSetting", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12628a;

        public e(int r2) {
            super(null);
            this.f12628a = r2;
        }

        public final int a() {
            return this.f12628a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f12628a == r6.f12628a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f12628a);
        }

        public String toString() {
            return "ToggleNewMemorySetting(setting=" + this.f12628a + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent$ToggleProactiveMemory;", "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12629a;

        public f(boolean r2) {
            super(null);
            this.f12629a = r2;
        }

        public final boolean a() {
            return this.f12629a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (this.f12629a == r6.f12629a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f12629a);
        }

        public String toString() {
            return "ToggleProactiveMemory(enabled=" + this.f12629a + ')';
        }
    }

    private r() {
    }

    public /* synthetic */ r(DefaultConstructorMarker r1) {
        this();
    }
}
