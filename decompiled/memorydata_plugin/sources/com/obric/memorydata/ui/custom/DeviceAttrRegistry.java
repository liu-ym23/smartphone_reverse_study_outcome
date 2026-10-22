package com.obric.memorydata.ui.custom;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry;", "", "<init>", "()V", "ALL", "", "Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Entry;", "getALL", "()Ljava/util/List;", "Kind", "Entry", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceAttrRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceAttrRegistry f12995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f12996b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "DIMEN", "COLOR", "INT", "BOOLEAN", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind BOOLEAN = null;
        public static final Kind COLOR = null;
        public static final Kind DIMEN = null;
        public static final Kind INT = null;

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{DIMEN, COLOR, INT, BOOLEAN};
        }

        static {
            DIMEN = new Kind("DIMEN", 0);
            COLOR = new Kind("COLOR", 1);
            INT = new Kind("INT", 2);
            BOOLEAN = new Kind("BOOLEAN", 3);
            Kind[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String r2) {
            return (Kind) ZeusTransformUtils.preCheckCast(Enum.valueOf(Kind.class, r2), Kind.class, "com.obric.memorydata.plugin");
        }

        public static Kind[] values() {
            return (Kind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Kind[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0001HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0001HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0001HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Entry;", "", ActivityLifecycle.NAME, "", "attrRes", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Kind;", "genesisR", "nerida", "pacific", "<init>", "(Ljava/lang/String;ILcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Kind;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getAttrRes", "()I", "getKind", "()Lcom/obric/memorydata/ui/custom/DeviceAttrRegistry$Kind;", "getGenesisR", "()Ljava/lang/Object;", "getNerida", "getPacific", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12998b;
        private final Kind c;
        private final Object d;
        private final Object e;
        private final Object f;

        public a(String r2, int r3, Kind r4, Object r5, Object r6, Object r7) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r4, MemoryInfoSectionEditActivity.EXTRA_KIND);
            Intrinsics.checkNotNullParameter(r5, "genesisR");
            Intrinsics.checkNotNullParameter(r6, "nerida");
            Intrinsics.checkNotNullParameter(r7, "pacific");
            this.f12997a = r2;
            this.f12998b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final String a() {
            return this.f12997a;
        }

        public final int b() {
            return this.f12998b;
        }

        public final Kind c() {
            return this.c;
        }

        public final Object d() {
            return this.d;
        }

        public final Object e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12997a, r6.f12997a) == true) goto L12;
            return false;
        L12:
            if (this.f12998b == r6.f12998b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final Object f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((this.f12997a.hashCode() * 31) + Integer.hashCode(this.f12998b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "Entry(name=" + this.f12997a + ", attrRes=" + this.f12998b + ", kind=" + this.c + ", genesisR=" + this.d + ", nerida=" + this.e + ", pacific=" + this.f + ')';
        }
    }

    static {
        f12995a = new DeviceAttrRegistry();
        f12996b = CollectionsKt.listOf(new a[]{new a("MemoryListGroupGap", ZeusTransformUtils.mapRes(R.attr.MemoryListGroupGap, "attr", "MemoryListGroupGap"), Kind.DIMEN, 12, 16, 16), new a("MemoryListGroupRadius", ZeusTransformUtils.mapRes(R.attr.MemoryListGroupRadius, "attr", "MemoryListGroupRadius"), Kind.DIMEN, 16, 20, 20), new a("OCardLisItemPadding", ZeusTransformUtils.mapRes(R.attr.OCardLisItemPadding, "attr", "OCardLisItemPadding"), Kind.DIMEN, 4, 8, 8), new a("OCardLisItemTitleTextFontWeight", ZeusTransformUtils.mapRes(R.attr.OCardLisItemTitleTextFontWeight, "attr", "OCardLisItemTitleTextFontWeight"), Kind.INT, 500, 400, 400), new a("OCardLisItemRadius", ZeusTransformUtils.mapRes(R.attr.OCardLisItemRadius, "attr", "OCardLisItemRadius"), Kind.DIMEN, 16, 20, 20), new a("OBannerRadius", ZeusTransformUtils.mapRes(R.attr.OBannerRadius, "attr", "OBannerRadius"), Kind.DIMEN, 16, 20, 20), new a("OBannerDividerMarginHorizontal", ZeusTransformUtils.mapRes(R.attr.OBannerDividerMarginHorizontal, "attr", "OBannerDividerMarginHorizontal"), Kind.DIMEN, 16, 20, 20), new a("OFloatingTitleBarStartButtonGroupBgVisible", ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarStartButtonGroupBgVisible, "attr", "OFloatingTitleBarStartButtonGroupBgVisible"), Kind.BOOLEAN, false, true, true), new a("OFloatingTitleBarCutoffAreaColor", ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"), Kind.COLOR, "opaque", "transparent", "transparent"), new a("OFloatingTitleBarMemorySettingsBottomGap", ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarMemorySettingsBottomGap, "attr", "OFloatingTitleBarMemorySettingsBottomGap"), Kind.DIMEN, 16, 16, 16), new a("OBottomNavigationBarBgVisible", ZeusTransformUtils.mapRes(R.attr.OBottomNavigationBarBgVisible, "attr", "OBottomNavigationBarBgVisible"), Kind.BOOLEAN, false, true, true), new a("FlowTabHorizontalSpacing", ZeusTransformUtils.mapRes(R.attr.FlowTabHorizontalSpacing, "attr", "FlowTabHorizontalSpacing"), Kind.DIMEN, 16, 8, 8), new a("FlowTabHorizontalPadding", ZeusTransformUtils.mapRes(R.attr.FlowTabHorizontalPadding, "attr", "FlowTabHorizontalPadding"), Kind.DIMEN, 16, 12, 12)});
    }

    private DeviceAttrRegistry() {
    }

    public final List<a> a() {
        return f12996b;
    }
}
