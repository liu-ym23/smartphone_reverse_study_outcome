package com.obric.memorydata.ui.settingsharness;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u0001:\u0003()*B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0010J,\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding;", "", "root", "Landroid/view/View;", "sections", "", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$BoundSection;", "<init>", "(Landroid/view/View;Ljava/util/List;)V", "getRoot", "()Landroid/view/View;", "rowsById", "", "", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$BoundRow;", "bindActions", "", "dispatch", "Lkotlin/Function1;", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "render", "state", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "pending", "Lcom/obric/memorydata/ui/settingsharness/SettingsPendingSnapshot;", "clearListeners", "bindSwitch", "row", "spec", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec$Switch;", "renderSection", "section", "renderRow", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowState;", "renderDetail", "validateState", "resolveOuiPosition", "", "index", "visibleRowCount", "Companion", "BoundSection", "BoundRow", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f13044b;
    private final List<b> c;
    private final Map<String, a> d;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$BoundRow;", "", "spec", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", "item", "Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "endSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "endDetail", "Landroid/widget/TextView;", "isRendering", "", "<init>", "(Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;Lcom/obric/oui/oswitch/OSwitch;Landroid/widget/TextView;Z)V", "getSpec", "()Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", "getItem", "()Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "getEndSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "getEndDetail", "()Landroid/widget/TextView;", "()Z", "setRendering", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f13045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DeviceAdaptiveCardListItem f13046b;
        private final OSwitch c;
        private final TextView d;
        private boolean e;

        public a(n r3, DeviceAdaptiveCardListItem r4, OSwitch r5, TextView r6, boolean r7) {
            n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "spec");
            Intrinsics.checkNotNullParameter(r4, "item");
            this.f13045a = r8;
            this.f13046b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        public /* synthetic */ a(n r7, DeviceAdaptiveCardListItem r8, OSwitch r9, TextView r10, boolean r11, int r12, DefaultConstructorMarker r13) {
            n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
            if ((r12 & 16) == 0) goto L5;
            r11 = false;
        L5:
            this(r1, r8, r9, r10, r11);
        }

        public final n a() {
            return this.f13045a;
        }

        public final void a(boolean r1) {
            this.e = r1;
        }

        public final DeviceAdaptiveCardListItem b() {
            return this.f13046b;
        }

        public final OSwitch c() {
            return this.c;
        }

        public final TextView d() {
            return this.d;
        }

        public final boolean e() {
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
            if (Intrinsics.areEqual(this.f13045a, r6.f13045a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13046b, r6.f13046b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f13045a.hashCode() * 31) + this.f13046b.hashCode()) * 31;
            OSwitch r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            TextView r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + Boolean.hashCode(this.e);
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "BoundRow(spec=" + this.f13045a + ", item=" + this.f13046b + ", endSwitch=" + this.c + ", endDetail=" + this.d + ", isRendering=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$BoundSection;", "", "title", "Landroid/view/View;", "supportiveText", "rows", "", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$BoundRow;", "<init>", "(Landroid/view/View;Landroid/view/View;Ljava/util/List;)V", "getTitle", "()Landroid/view/View;", "getSupportiveText", "getRows", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f13047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f13048b;
        private final List<a> c;

        public b(View r3, View r4, List<a> r5) {
            List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rows");
            this.f13047a = r3;
            this.f13048b = r4;
            this.c = r6;
        }

        public final View a() {
            return this.f13047a;
        }

        public final View b() {
            return this.f13048b;
        }

        public final List<a> c() {
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
            if (Intrinsics.areEqual(this.f13047a, r6.f13047a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13048b, r6.f13048b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            View r0 = this.f13047a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            View r4 = this.f13048b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((r3 + r1) * 31) + this.c.hashCode();
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "BoundSection(title=" + this.f13047a + ", supportiveText=" + this.f13048b + ", rows=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u001c\u0010\u0011\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding;", "root", "Landroid/view/View;", "spec", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageBindingSpec;", "validateSpec", "", "validateViewIds", "validateActionKey", "Lcom/obric/memorydata/ui/settingsharness/SettingsRowBindingSpec;", "resolveRow", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageViewBinding$BoundRow;", "requireView", "viewId", "", "role", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }

        private final View a(View r1, int r2, String r3) {
            if (r2 == (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L13;
            View r4 = r1.findViewById(r2);
            if (r4 == null) goto L10;
            return r4;
        L10:
            StringBuilder r5 = new StringBuilder().append("Missing ").append(r3).append(" View for id 0x");
            String r6 = Integer.toString(r2, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
            throw new IllegalArgumentException(r5.append(r6).toString().toString());
        L13:
            throw new IllegalArgumentException((r3 + " View id must be valid").toString());
        L5:
            r0 = false;
            goto L6
        }

        private final a a(View r11, n r12) {
            n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r12, n.class, "com.obric.memorydata.plugin");
            View r10 = a(r11, r3.b(), "settings row");
            if (ZeusTransformUtils.instanceOf(r10, DeviceAdaptiveCardListItem.class) == false) goto L43;
            OSwitch r5 = ((DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r10, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin")).getEndSwitch();
            OTextView r13 = ((DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r10, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin")).getEndDetail();
            if (ZeusTransformUtils.instanceOf(r3, n.c.class) == false) goto L10;
            if (r5 != null) goto L35;
            throw new IllegalArgumentException(("Switch row '" + ((n.c) ZeusTransformUtils.preCheckCast(r3, n.c.class, "com.obric.memorydata.plugin")).a() + "' must declare OCardListItem end_switch in XML").toString());
        L35:
            return new a(r3, (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r10, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin"), r5, (TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.memorydata.plugin"), false, 16, null);
        L10:
            boolean r2 = true;
            if (ZeusTransformUtils.instanceOf(r3, n.a.class) == false) goto L27;
            if (r5 == null) goto L16;
            r2 = false;
        L16:
            if (r2 == false) goto L25;
            if (((n.a) ZeusTransformUtils.preCheckCast(r3, n.a.class, "com.obric.memorydata.plugin")).d() == false) goto L23;
            if (r13 != null) goto L23;
            throw new IllegalArgumentException(("Navigation row '" + ((n.a) ZeusTransformUtils.preCheckCast(r3, n.a.class, "com.obric.memorydata.plugin")).a() + "' with bindsDetail must declare OCardListItem end_detail in XML").toString());
        L23:
            Unit r14 = Unit.INSTANCE;
            goto L35
        L25:
            throw new IllegalArgumentException(("Navigation row '" + ((n.a) ZeusTransformUtils.preCheckCast(r3, n.a.class, "com.obric.memorydata.plugin")).a() + "' must not declare OCardListItem end_switch").toString());
        L27:
            if (ZeusTransformUtils.instanceOf(r3, n.b.class) == false) goto L41;
            if (r5 == null) goto L32;
            r2 = false;
        L32:
            if (r2 == false) goto L39;
            if (r13 != null) goto L35;
            throw new IllegalArgumentException(("Selector row '" + ((n.b) ZeusTransformUtils.preCheckCast(r3, n.b.class, "com.obric.memorydata.plugin")).a() + "' must declare OCardListItem end_detail in XML").toString());
        L39:
            throw new IllegalArgumentException(("Selector row '" + ((n.b) ZeusTransformUtils.preCheckCast(r3, n.b.class, "com.obric.memorydata.plugin")).a() + "' must not declare OCardListItem end_switch").toString());
        L41:
            throw new NoWhenBranchMatchedException();
        L43:
            throw new IllegalArgumentException(("Settings row '" + r3.a() + "' must be a DeviceAdaptiveCardListItem").toString());
        }

        private final void a(g r9) {
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9.a(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(((p) ZeusTransformUtils.preCheckCast(r2.next(), p.class, "com.obric.memorydata.plugin")).a());
            goto L4
        L6:
            List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
            boolean r5 = false;
            if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L9;
        L11:
            Iterator r6 = r4.iterator();
        L13:
            if (r6.hasNext() == false) goto L10;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
            boolean r7 = false;
        L17:
            if (r7 == false) goto L59;
            if (CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).size() != r3.size()) goto L21;
            boolean r8 = true;
        L22:
            if (r8 == false) goto L57;
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9.a(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r12 = r10.iterator();
        L25:
            if (r12.hasNext() == false) goto L27;
            CollectionsKt.addAll(r11, (Iterable) ZeusTransformUtils.preCheckCast(((p) ZeusTransformUtils.preCheckCast(r12.next(), p.class, "com.obric.memorydata.plugin")).d(), Iterable.class, "com.obric.memorydata.plugin"));
            goto L25
        L27:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r14.iterator();
        L29:
            if (r16.hasNext() == false) goto L31;
            r15.add(((n) ZeusTransformUtils.preCheckCast(r16.next(), n.class, "com.obric.memorydata.plugin")).a());
            goto L29
        L31:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L34;
        L36:
            Iterator r19 = r18.iterator();
        L38:
            if (r19.hasNext() == false) goto L35;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L38;
            boolean r20 = false;
        L42:
            if (r20 == false) goto L55;
            if (CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).size() != r17.size()) goto L46;
            r5 = true;
        L46:
            if (r5 == false) goto L53;
            b(r9);
            Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L49:
            if (r21.hasNext() == false) goto L51;
            a((n) ZeusTransformUtils.preCheckCast(r21.next(), n.class, "com.obric.memorydata.plugin"));
            goto L49
        L51:
            return;
        L53:
            throw new IllegalArgumentException("Settings row ids must be unique".toString());
        L55:
            throw new IllegalArgumentException("Settings row id must not be blank".toString());
        L35:
            r20 = true;
            goto L42
        L34:
            if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L36;
        L57:
            throw new IllegalArgumentException("Settings section ids must be unique".toString());
        L21:
            r8 = false;
            goto L22
        L59:
            throw new IllegalArgumentException("Settings section id must not be blank".toString());
        L10:
            r7 = true;
            goto L17
        L9:
            if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
            goto L10
        }

        private final void a(n r2) {
            n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, n.c.class) == false) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, n.a.class) == false) goto L12;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((n.a) ZeusTransformUtils.preCheckCast(r1, n.a.class, "com.obric.memorydata.plugin")).c(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException("Navigation action key must not be blank".toString());
        L12:
            if (ZeusTransformUtils.instanceOf(r1, n.b.class) == false) goto L19;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((n.b) ZeusTransformUtils.preCheckCast(r1, n.b.class, "com.obric.memorydata.plugin")).c(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
            return;
        L17:
            throw new IllegalArgumentException("Selector key must not be blank".toString());
        L19:
            throw new NoWhenBranchMatchedException();
        }

        private final void b(g r6) {
            List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L16;
            p r0 = (p) ZeusTransformUtils.preCheckCast(r7.next(), p.class, "com.obric.memorydata.plugin");
            Integer r2 = r0.b();
            if (r2 == null) goto L8;
            r5.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue()));
        L8:
            Integer r3 = r0.c();
            if (r3 == null) goto L11;
            r5.add(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue()));
        L11:
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L13:
            if (r1.hasNext() == false) goto L15;
            ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).add(Integer.valueOf(((n) ZeusTransformUtils.preCheckCast(r1.next(), n.class, "com.obric.memorydata.plugin")).b()));
            goto L13
        L15:
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin");
            goto L4
        L16:
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
            boolean r9 = false;
            if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L19;
        L21:
            Iterator r10 = r8.iterator();
        L23:
            if (r10.hasNext() == false) goto L20;
            if (((Number) ZeusTransformUtils.preCheckCast(r10.next(), Number.class, "com.obric.memorydata.plugin")).intValue() != (-1)) goto L27;
            boolean r11 = true;
        L28:
            if (r11 == false) goto L23;
            boolean r12 = false;
        L30:
            if (r12 == false) goto L39;
            if (CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).size() != r5.size()) goto L34;
            r9 = true;
        L34:
            if (r9 == false) goto L37;
            return;
        L37:
            throw new IllegalArgumentException("Settings binding View ids must be unique across all sections and rows".toString());
        L39:
            throw new IllegalArgumentException("Settings binding View ids must be valid".toString());
        L27:
            r11 = false;
        L20:
            r12 = true;
            goto L30
        L19:
            if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L21;
            goto L20
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final j a(View r9, g r10) {
            Intrinsics.checkNotNullParameter(r9, "root");
            Intrinsics.checkNotNullParameter(r10, "spec");
            a(r10);
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r10.a(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r12 = r8.iterator();
        L3:
            View r3 = null;
            Object[] r4 = 0;
            if (r12.hasNext() == false) goto L18;
            p r2 = (p) ZeusTransformUtils.preCheckCast(r12.next(), p.class, "com.obric.memorydata.plugin");
            Integer r5 = r2.b();
            if (r5 == null) goto L8;
            View r6 = j.f13043a.a(r9, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue(), "section title");
        L9:
            Integer r7 = r2.c();
            if (r7 == null) goto L12;
            r3 = j.f13043a.a(r9, ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue(), "section supportive text");
        L12:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r2.d(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r13.iterator();
        L14:
            if (r15.hasNext() == false) goto L16;
            r14.add(j.f13043a.a(r9, (n) ZeusTransformUtils.preCheckCast(r15.next(), n.class, "com.obric.memorydata.plugin")));
            goto L14
        L16:
            r11.add(new b(r6, r3, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin")));
            goto L3
        L8:
            r6 = null;
            goto L9
        L18:
            return new j(r9, (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), r4 == true ? 1 : 0);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13049a = null;

        static {
            int[] r0 = new int[SettingsCardPosition.values().length];
            r0[SettingsCardPosition.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SettingsCardPosition.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SettingsCardPosition.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SettingsCardPosition.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f13049a = r0;
        }
    }

    static {
        f13043a = new c(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private j(View r4, List<b> r5) {
        List<b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.f13044b = r4;
        this.c = r6;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        CollectionsKt.addAll(r8, (Iterable) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, a> r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Object r0 = r12.next();
        r11.put(((a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin")).a().a(), r0);
        goto L8
    L10:
        this.d = r11;
    }

    public /* synthetic */ j(View r2, List r3, DefaultConstructorMarker r4) {
        this(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final int a(int r2, int r3) {
        SettingsCardPosition r1 = (SettingsCardPosition) ZeusTransformUtils.preCheckCast(e.f13036a.a(r3).get(r2), SettingsCardPosition.class, "com.obric.memorydata.plugin");
        int r4 = d.f13049a[r1.ordinal()];
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L15;
        if (r4 != 4) goto L10;
        return 3;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return 2;
    L16:
        return 1;
    L13:
        return 0;
    }

    private final void a(i r9) {
        if (Intrinsics.areEqual(r9.a().keySet(), this.d.keySet()) == false) goto L55;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L53;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");
        o r2 = (o) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r9.a(), r0.a().a()), o.class, "com.obric.memorydata.plugin");
        n r1 = r0.a();
        boolean r4 = true;
        if (ZeusTransformUtils.instanceOf(r1, n.c.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, n.a.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r1, n.b.class) == false) goto L52;
        if (r2.d() == null) goto L47;
        r4 = false;
    L47:
        if (r4 == true) goto L6;
        throw new IllegalArgumentException(("Selector row '" + ((n.b) ZeusTransformUtils.preCheckCast(r1, n.b.class, "com.obric.memorydata.plugin")).a() + "' does not support checked state").toString());
    L52:
        throw new NoWhenBranchMatchedException();
    L24:
        if (r2.d() != null) goto L26;
        boolean r3 = true;
    L28:
        if (r3 == false) goto L40;
        if (((n.a) ZeusTransformUtils.preCheckCast(r1, n.a.class, "com.obric.memorydata.plugin")).d() == false) goto L32;
    L35:
        if (r4 == true) goto L6;
        throw new IllegalArgumentException(("Navigation row '" + ((n.a) ZeusTransformUtils.preCheckCast(r1, n.a.class, "com.obric.memorydata.plugin")).a() + "' must enable bindsDetail to render detail state").toString());
    L32:
        if (r2.e() == null) goto L35;
        r4 = false;
        goto L35
    L40:
        throw new IllegalArgumentException(("Navigation row '" + ((n.a) ZeusTransformUtils.preCheckCast(r1, n.a.class, "com.obric.memorydata.plugin")).a() + "' does not support checked state").toString());
    L26:
        r3 = false;
        goto L28
    L10:
        if (r2.d() == null) goto L20;
        if (r2.e() == null) goto L15;
        r4 = false;
    L15:
        if (r4 == true) goto L6;
        throw new IllegalArgumentException(("Switch row '" + ((n.c) ZeusTransformUtils.preCheckCast(r1, n.c.class, "com.obric.memorydata.plugin")).a() + "' does not support detail state").toString());
    L20:
        throw new IllegalArgumentException(("Switch row '" + ((n.c) ZeusTransformUtils.preCheckCast(r1, n.c.class, "com.obric.memorydata.plugin")).a() + "' requires a checked state").toString());
    L53:
        return;
    L55:
        throw new IllegalArgumentException(("Settings state rows must exactly match the binding; missing=" + SetsKt.minus(this.d.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r9.a().keySet(), Iterable.class, "com.obric.memorydata.plugin")) + ", unexpected=" + SetsKt.minus(r9.a().keySet(), (Iterable) ZeusTransformUtils.preCheckCast(this.d.keySet(), Iterable.class, "com.obric.memorydata.plugin"))).toString());
    }

    private final void a(final a r3, final n.c r4, Function1<? super com.obric.memorydata.ui.settingsharness.b, Unit> r5) {
        final Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        final OSwitch r6 = r3.c();
        if (r6 == null) goto L7;
        r3.b().setOnContentClickListener(new $$Lambda$j$0MtBHFhzTfxb3IUWsuVjJde3gc8(r6));
        r6.setOnCheckedChangeListener(new $$Lambda$j$rV1LNUvuHVwyUo24a2vSp9gCOCA(r3, r2, r4));
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void a(a r4, o r5) {
        n r3 = r4.a();
        if (ZeusTransformUtils.instanceOf(r3, n.c.class) == false) goto L6;
        boolean r6 = false;
    L11:
        if (r6 == true) goto L13;
        return;
    L13:
        q r7 = r5.e();
        TextView r8 = r4.d();
        if (r7 != null) goto L20;
        if (r8 == null) goto L17;
        r8.setText(null);
    L17:
        if (r8 == null) goto L27;
        r8.setVisibility(8);
        return;
    L27:
        return;
    L20:
        if (r8 == null) goto L24;
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(m.a(r7, (View) ZeusTransformUtils.preCheckCast(r4.b(), View.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin"));
        r8.setVisibility(0);
        return;
    L24:
        throw new IllegalArgumentException(("Settings row '" + r4.a().a() + "' must declare OCardListItem end_detail in XML").toString());
    L6:
        if (ZeusTransformUtils.instanceOf(r3, n.a.class) == false) goto L9;
        r6 = ((n.a) ZeusTransformUtils.preCheckCast(r3, n.a.class, "com.obric.memorydata.plugin")).d();
        goto L11
    L9:
        if (ZeusTransformUtils.instanceOf(r3, n.b.class) == false) goto L26;
        r6 = true;
        goto L11
    L26:
        throw new NoWhenBranchMatchedException();
    }

    private final void a(a r6, o r7, k r8) {
        DeviceAdaptiveCardListItem r0 = r6.b();
        if (r7.a() == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        DeviceAdaptiveCardListItem r2 = r6.b();
        if (r7.b() == true) goto L9;
    L13:
        boolean r3 = false;
    L14:
        r2.setEnabled(r3);
        OSwitch r4 = r6.c();
        if (r4 == null) goto L30;
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r8.b().get(r6.a().a()), Boolean.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L19;
    L18:
        boolean r10 = r9.booleanValue();
        r6.a(true);
        r4.setChecked(r10);     // Catch: Throwable -> L25
        r6.a(false);
    L25:
        th = move-exception;
        r6.a(false);
        throw th;
    L19:
        r9 = r7.d();
        if (r9 != null) goto L18;
        throw new IllegalArgumentException(("Switch row '" + r6.a().a() + "' requires a checked state").toString());
    L30:
        a(r6, r7);
        return;
    L9:
        if (r7.c() == true) goto L13;
        if (r8.a().contains(r6.a().a()) == true) goto L13;
        r3 = true;
        goto L14
    L5:
        r1 = 8;
        goto L6
    }

    private static final void a(a r1, Function1 r2, n.c r3, CompoundButton r4, boolean r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if (r1.e() == true) goto L6;
        r6.invoke(new com.obric.memorydata.ui.settingsharness.b.c(r3.a(), r5));
        return;
    }

    private final void a(b r7, i r8, k r9) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((o) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r8.a(), ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).a().a()), o.class, "com.obric.memorydata.plugin")).a() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L11;
        int r5 = 8;
    L12:
        View r6 = r7.a();
        if (r6 == null) goto L15;
        r6.setVisibility(r5);
    L15:
        View r10 = r7.b();
        if (r10 == null) goto L18;
        r10.setVisibility(r5);
    L18:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r11.hasNext() == false) goto L22;
        a r12 = (a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin");
        a(r12, (o) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r8.a(), r12.a().a()), o.class, "com.obric.memorydata.plugin"), r9);
        goto L20
    L22:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r14 = 0;
    L24:
        if (r13.hasNext() == false) goto L29;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.memorydata.plugin")).b(), OCardListItem.class, "com.obric.memorydata.plugin"), a(r14, r4.size()), false, 2, null);
        r14 = r16;
        goto L24
    L29:
        return;
    L11:
        r5 = 0;
        goto L12
    }

    private static final void a(OSwitch r0, View r1) {
        r0.performClick();
    }

    private static final void a(Function1 r3, n r4, View r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        r6.invoke(new com.obric.memorydata.ui.settingsharness.b.a(((n.a) ZeusTransformUtils.preCheckCast(r7, n.a.class, "com.obric.memorydata.plugin")).a(), ((n.a) ZeusTransformUtils.preCheckCast(r7, n.a.class, "com.obric.memorydata.plugin")).c()));
    }

    private static final void b(Function1 r3, n r4, View r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        r6.invoke(new com.obric.memorydata.ui.settingsharness.b.C0715b(((n.b) ZeusTransformUtils.preCheckCast(r7, n.b.class, "com.obric.memorydata.plugin")).a(), ((n.b) ZeusTransformUtils.preCheckCast(r7, n.b.class, "com.obric.memorydata.plugin")).c()));
    }

    public static /* synthetic */ void lambda$0MtBHFhzTfxb3IUWsuVjJde3gc8(OSwitch r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$M5SSYTXzYirZaeEt1EHgOLNpn9E(Function1 r0, n r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$h4o3MUJOR2Ohm9sSkVn47bBhiUI(Function1 r0, n r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$rV1LNUvuHVwyUo24a2vSp9gCOCA(a r0, Function1 r1, n.c r2, CompoundButton r3, boolean r4) {
        a(r0, r1, r2, r3, r4);
    }

    public final View a() {
        return this.f13044b;
    }

    public final void a(i r5, k r6) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r6, "pending");
        a(r5);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin"), r5, r6);
        goto L4
    }

    public final void a(Function1<? super com.obric.memorydata.ui.settingsharness.b, Unit> r6) {
        final Function1<? super com.obric.memorydata.ui.settingsharness.b, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "dispatch");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin");
        final n r3 = r2.a();
        if (ZeusTransformUtils.instanceOf(r3, n.c.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r3, n.a.class) == false) goto L13;
        DeviceAdaptiveCardListItem r4 = r2.b();
        View.OnClickListener r5 = new $$Lambda$j$M5SSYTXzYirZaeEt1EHgOLNpn9E(r7, r3);
    L11:
        r4.setOnContentClickListener(r5);
        goto L4
    L13:
        if (ZeusTransformUtils.instanceOf(r3, n.b.class) == false) goto L16;
        r4 = r2.b();
        r5 = new $$Lambda$j$h4o3MUJOR2Ohm9sSkVn47bBhiUI(r7, r3);
        goto L11
    L16:
        throw new NoWhenBranchMatchedException();
    L7:
        a(r2, (n.c) ZeusTransformUtils.preCheckCast(r3, n.c.class, "com.obric.memorydata.plugin"), r7);
        goto L4
    }

    public final void b() {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
        r0.b().setOnContentClickListener(null);
        OSwitch r1 = r0.c();
        if (r1 == null) goto L4;
        r1.setOnCheckedChangeListener(null);
        goto L4
    }
}
