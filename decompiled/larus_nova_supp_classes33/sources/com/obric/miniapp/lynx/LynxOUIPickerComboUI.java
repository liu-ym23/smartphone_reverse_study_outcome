package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.memorydata.sdk.entity.search.SearchError;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004UVWXB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0013H\u0007J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0002J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0018H\u0002J(\u0010-\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J0\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J(\u00104\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J8\u00105\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u0001012\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J8\u00107\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u0001012\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J8\u00108\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u0001012\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J\u0019\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020:H\u0002J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0019\u0010E\u001a\u0004\u0018\u00010\u00132\b\u0010F\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0018\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020&H\u0002J\u001f\u0010L\u001a\u00020&2\b\u0010;\u001a\u0004\u0018\u00010&2\u0006\u0010M\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010NJ.\u0010O\u001a\u00020P2\u0006\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020&2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J\u0010\u0010Q\u001a\u00020&2\u0006\u0010J\u001a\u00020BH\u0002J'\u0010R\u001a\u0004\u0018\u00010:2\b\u0010.\u001a\u0004\u0018\u00010/2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020P0AH\u0002¢\u0006\u0002\u0010TR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIPickerComboUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "contentContainer", "Landroid/widget/LinearLayout;", "actionBarView", "calendarView", "Landroid/widget/CalendarView;", "pickerContainer", "picker", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "optionsJson", "Lorg/json/JSONObject;", "visible", "", "suppressChangeEvent", "currentConfig", "Lcom/obric/miniapp/lynx/LynxOUIPickerComboUI$PickerComboConfig;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setVisible", "v", "setOptions", "options", "", "destroy", "rebuildContent", "buildCalendarView", "heightDp", "", "buildLegacyDateTimePicker", "json", "buildConfiguredReelsPicker", "config", "applyDateRange", "buildActionBar", "sendConfirmEvent", "date", "Ljava/time/LocalDate;", "selections", "", "sendSelectionsEvent", "type", "sendChangeEvent", "buildValue", "", "buildLegacyValue", "buildConfiguredValue", "parseDateMillis", "", "raw", "(Ljava/lang/String;)Ljava/lang/Long;", "millisToLocalDate", "millis", "parseConfig", "parseReels", "", "Lcom/obric/miniapp/lynx/LynxOUIPickerComboUI$PickerComboReelConfig;", "array", "Lorg/json/JSONArray;", "parseBooleanValue", "value", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "resolveRootHeightDp", "resolveReelId", "reel", "index", "resolveHourSelectedValue", "is24Hour", "(Ljava/lang/Integer;Z)I", "buildPickedReelValue", "Lcom/obric/miniapp/lynx/LynxOUIPickerComboUI$PickedReelValue;", "defaultSelectionIndex", "buildTimestampFromPickedReels", "pickedReels", "(Ljava/time/LocalDate;Ljava/util/List;)Ljava/lang/Long;", "Companion", "PickerComboConfig", "PickerComboReelConfig", "PickedReelValue", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIPickerComboUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int j = 0;
    public FrameLayout a;
    public LinearLayout b;
    public LinearLayout c;
    public CalendarView d;
    public hma.c e;
    public JSONObject f;
    public boolean g;
    public boolean h;
    public c i;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final String b;
        public final int c;
        public final String d;
        public final Integer e;
        public final String f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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

        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
            Integer r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "PickedReelValue(id=" + this.a + ", type=" + this.b + ", selectedIndex=" + this.c + ", selectedValue=" + this.d + ", selectedNumber=" + this.e + ", tag=" + this.f + ')';
        }

        public final String getType() {
            return this.b;
        }

        public b(int r2, String r3, int r4, String r5, Integer r6, String r7) {
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r5, "selectedValue");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class c {
        public final String a;
        public final boolean b;
        public final boolean c;
        public final int d;
        public final int e;
        public final boolean f;
        public final boolean g;
        public final List<d> h;

        public c() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
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
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (((((r3 + r4) * 31) + this.d) * 31) + this.e) * 31;
            if (this.f == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (r5 + r6) * 31;
            if (this.g == true) goto L19;
            r2 = 1237;
        L19:
            return ((r7 + r2) * 31) + this.h.hashCode();
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PickerComboConfig(mode=" + this.a + ", showCalendar=" + this.b + ", showActionBar=" + this.c + ", calendarHeightDp=" + this.d + ", pickerHeightDp=" + this.e + ", is24Hour=" + this.f + ", showTimeLabels=" + this.g + ", reels=" + this.h + ')';
        }

        public /* synthetic */ c(int r10) {
            this("legacy_datetime", true, true, 260, 220, false, true, CollectionsKt.emptyList());
        }

        public c(String r2, boolean r3, boolean r4, int r5, int r6, boolean r7, boolean r8, List<d> r9) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r9, "reels");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public static final class d {
        public final Integer a;
        public final String b;
        public final List<String> c;
        public final Integer d;
        public final Integer e;
        public final String f;
        public final Float g;
        public final Integer h;
        public final Integer i;
        public final Boolean j;
        public final Boolean k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            Integer r4 = this.d;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.e;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.f;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Float r13 = this.g;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.h;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            Integer r19 = this.i;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            Boolean r22 = this.j;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            Boolean r25 = this.k;
            if (r25 == null) goto L39;
            r1 = r25.hashCode();
        L39:
            return r24 + r1;
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PickerComboReelConfig(id=" + this.a + ", type=" + this.b + ", entries=" + this.c + ", selected=" + this.d + ", selectedIndex=" + this.e + ", tag=" + this.f + ", widthWeight=" + this.g + ", widthDp=" + this.h + ", tagGapDp=" + this.i + ", is24Hour=" + this.j + ", showTag=" + this.k + ')';
        }

        public final String getType() {
            return this.b;
        }

        public d(Integer r2, String r3, List<String> r4, Integer r5, Integer r6, String r7, Float r8, Integer r9, Integer r10, Boolean r11, Boolean r12) {
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "entries");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }
    }

    static {
    }

    public final void destroy() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.i = new c(0);
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R() {
        FrameLayout r1 = this.a;
        if (r1 != null) goto L5;
        return;
    L5:
        LinearLayout r2 = this.b;
        if (r2 != null) goto L8;
        return;
    L8:
        JSONObject r3 = this.f;
        if (r3 != null) goto L11;
        r3 = new JSONObject();
    L11:
        JSONArray r5 = r3.optJSONArray("reels");
        int r8 = 0;
        if (r5 != null) goto L15;
        List r6 = CollectionsKt.emptyList();
    L14:
        List r18 = r6;
        String r7 = o1.C(r3, new String[]{"mode", "pickerMode"});
        if (r7 == null) goto L52;
        String r9 = StringsKt.trim(r7).toString();
        if (r9 == null) goto L52;
        String r10 = r9.toLowerCase(Locale.ROOT);
        if (r10 == null) goto L52;
        if ((!StringsKt.isBlank(r10)) == false) goto L52;
    L54:
        if (Intrinsics.areEqual(r10, "reels") == false) goto L57;
    L61:
        String r11 = "reels";
    L63:
        Boolean r12 = P(r3.opt("showCalendar"));
        if (r12 == null) goto L67;
        boolean r13 = r12.booleanValue();
    L70:
        Boolean r14 = o1.B(r3, new String[]{"showActionBar", "showFooter"});
        if (r14 == null) goto L74;
        boolean r15 = r14.booleanValue();
    L77:
        Integer r16 = o1.i(r3.opt("calendarHeightDp"));
        if (r16 == null) goto L80;
        int r17 = r16.intValue();
    L81:
        Integer r19 = o1.i(r3.opt("pickerHeightDp"));
        if (r19 == null) goto L84;
        int r110 = r19.intValue();
    L85:
        Boolean r111 = P(r3.opt("is24Hour"));
        if (r111 == null) goto L88;
        boolean r112 = r111.booleanValue();
    L89:
        Boolean r113 = P(r3.opt("showTimeLabels"));
        if (r113 == null) goto L92;
        boolean r114 = r113.booleanValue();
    L93:
        c r20 = new c(r11, r13, r15, r17, r110, r112, r114, r18);
        this.i = r20;
        this.h = true;
        r2.removeAllViews();
        this.d = null;
        this.e = null;
        if (r20.b == false) goto L96;
        Context r115 = r2.getContext();
        int r116 = r20.d;
        CalendarView r117 = new CalendarView(r115);
        r117.setLayoutParams(new LinearLayout.LayoutParams(-1, o1.t(r115, r116)));
        r117.setMinimumHeight(o1.t(r115, r116));
        r117.setOnDateChangeListener(new h3(this));
        this.d = r117;
        r2.addView(r117);
    L96:
        FrameLayout r118 = new FrameLayout(r2.getContext());
        r118.setLayoutParams(new LinearLayout.LayoutParams(-1, o1.t(r2.getContext(), r20.e)));
        r118.setMinimumHeight(o1.t(r2.getContext(), r20.e));
        r2.addView(r118);
        if (Intrinsics.areEqual(r20.a, "reels") == false) goto L99;
    L102:
        boolean r4 = true;
    L104:
        if (r4 == true) goto L106;
    L199:
        FrameLayout r29 = r1;
        Boolean r21 = P(r3.opt("is24Hour"));
        if (r21 == null) goto L202;
        boolean r22 = r21.booleanValue();
    L203:
        Boolean r23 = P(r3.opt("showTimeLabels"));
        if (r23 == null) goto L206;
        boolean r24 = r23.booleanValue();
    L207:
        JSONObject r25 = r3.optJSONObject("defaultTime");
        if (r25 == null) goto L212;
        String r26 = r25.optString("hour");
        if (r26 == null) goto L212;
        Integer r27 = StringsKt.toIntOrNull(r26);
    L213:
        if (r25 == null) goto L219;
        String r28 = r25.optString("minute");
        if (r28 == null) goto L219;
        Integer r30 = StringsKt.toIntOrNull(r28);
        if (r30 == null) goto L219;
        int r31 = r30.intValue();
    L220:
        if (r25 == null) goto L224;
        String r32 = r25.optString("isAm");
        if (r32 == null) goto L224;
        Boolean r33 = StringsKt.toBooleanStrictOrNull(r32);
    L225:
        if (r22 == false) goto L231;
        if (r27 == null) goto L228;
        int r34 = r27.intValue();
    L229:
        int r35 = RangesKt.coerceIn(r34, 0, 23);
    L251:
        int r36 = RangesKt.coerceIn(r31, 0, 59);
        hma.c.a r37 = new hma.c.a();
        hma.c.a.d(r37, ((LynxBaseUI) this).mContext, SearchError.ERR_INTERNAL_ERROR, r22, r24, Integer.valueOf(r35));
        hma.c.a.e(r37, ((LynxBaseUI) this).mContext, SearchError.ERR_MODEL_NOT_READY, r24, Integer.valueOf(r36));
        if (r22 == true) goto L257;
        if (r33 == null) goto L255;
        boolean r38 = r33.booleanValue();
    L256:
        hma.c.a.b(r37, ((LynxBaseUI) this).mContext, SearchError.ERR_PACKAGE_FAILED, Integer.valueOf(!r38));
        goto L257
    L255:
        r38 = 1;
    L257:
        Consumer r39 = new e3(this);
        Intrinsics.checkNotNullParameter(r39, "listener");
        r37.a = r39;
        hma.c r40 = (hma.c) hma.d.a.a(r37, ((LynxBaseUI) this).mContext);
    L258:
        this.e = r40;
        View r41 = r40.a();
        if (r41 == null) goto L261;
        FrameLayout.LayoutParams r42 = new FrameLayout.LayoutParams(-1, -2);
        r42.gravity = 1;
        r41.setLayoutParams(r42);
        r118.addView(r41);
    L261:
        CalendarView r43 = this.d;
        if (r43 == null) goto L273;
        Long r44 = Q(r3.optString("minDate"));
        if (r44 == null) goto L267;
        r43.setMinDate(r44.longValue());
    L267:
        Long r45 = Q(r3.optString("maxDate"));
        if (r45 == null) goto L270;
        r43.setMaxDate(r45.longValue());
    L270:
        Long r46 = Q(r3.optString("date"));
        if (r46 == null) goto L273;
        r43.setDate(r46.longValue());
    L273:
        LinearLayout r47 = this.c;
        if (r47 != null) goto L276;
    L280:
        Context r48 = r29.getContext();
        int r49 = r20.e;
        boolean r50 = r20.b;
        if (r50 == false) goto L283;
        int r51 = r20.d;
    L284:
        int r52 = r51 + r49;
        boolean r53 = r20.c;
        if (r53 == false) goto L287;
        int r54 = 56;
    L288:
        if (r50 == false) goto L290;
        r49 = 520;
    L292:
        int r55 = o1.t(r48, Math.max(r49, r52 + r54));
        FrameLayout r56 = r29;
        r56.setMinimumHeight(r55);
        if (this.g == false) goto L295;
        int r57 = 0;
    L296:
        r56.setVisibility(r57);
        this.h = false;
        return;
    L295:
        r57 = 8;
        goto L296
    L290:
        if (r53 == false) goto L292;
        r49 = 320;
        goto L292
    L287:
        r54 = 0;
        goto L288
    L283:
        r51 = 0;
        goto L284
    L276:
        if (r20.c == false) goto L278;
        int r58 = 0;
    L279:
        r47.setVisibility(r58);
        goto L280
    L278:
        r58 = 8;
        goto L279
    L228:
        r34 = LocalDateTime.now().getHour();
        goto L229
    L231:
        if (r27 == null) goto L233;
        r35 = r27.intValue();
    L235:
        if (1 <= r35) goto L237;
    L239:
        boolean r119 = false;
    L240:
        if (r119 == true) goto L251;
        if (r35 >= 0) goto L244;
    L246:
        boolean r120 = false;
    L247:
        if (r120 == false) goto L250;
        r35 = r35 % 12;
        if (r35 != 0) goto L251;
    L250:
        r35 = 12;
        goto L251
    L244:
        if (r35 >= 24) goto L246;
        r120 = true;
        goto L247
    L237:
        if (r35 >= 13) goto L239;
        r119 = true;
        goto L240
    L233:
        r35 = 12;
    L224:
        r33 = null;
    L219:
        r31 = 0;
    L212:
        r27 = null;
        goto L213
    L206:
        r24 = true;
        goto L207
    L202:
        r22 = false;
        goto L203
    L106:
        if ((!r20.h.isEmpty()) == false) goto L199;
        hma.c.a r59 = new hma.c.a();
        Iterator r60 = r20.h.iterator();
        int r61 = 0;
    L109:
        if (r60.hasNext() == false) goto L198;
        Object r121 = r60.next();
        int r210 = r61 + 1;
        if (r61 >= 0) goto L113;
        CollectionsKt.throwIndexOverflow();
    L113:
        d r122 = (d) r121;
        int r62 = T(r122, r61);
        String r63 = r122.getType();
        switch(r63.hashCode()) {
            case -1074026988: goto L162;
            case -906279820: goto L141;
            case 2998057: goto L129;
            case 3208676: goto L117;
            default: goto L115;
        };
    L115:
        FrameLayout r211 = r1;
        Iterator r212 = r60;
    L174:
        List<String> r64 = r122.c;
        if (r64.isEmpty() == false) goto L177;
        r64 = CollectionsKt.listOf("-");
    L177:
        List<String> r123 = r64;
        String r65 = r122.f;
        Integer r66 = r122.e;
        if (r66 != null) goto L182;
        r66 = r122.d;
        if (r66 != null) goto L182;
        int r67 = 0;
    L184:
        int r213 = RangesKt.coerceIn(r67, 0, RangesKt.coerceAtLeast(r123.size() - 1, 0));
        Float r68 = r122.g;
        if (r68 == null) goto L187;
        float r214 = r68.floatValue();
    L188:
        Integer r69 = r122.h;
        if (r69 == null) goto L191;
        Integer r215 = Integer.valueOf(o1.t(((LynxBaseUI) this).mContext, r69.intValue()));
    L192:
        Integer r70 = r122.i;
        if (r70 == null) goto L195;
        Integer r216 = Integer.valueOf(o1.t(((LynxBaseUI) this).mContext, r70.intValue()));
    L196:
        r59.g(r62, r123, r65, r213, r214, r215, r216, ((LynxBaseUI) this).mContext);
    L197:
        r61 = r210;
        r60 = r212;
        r1 = r211;
        r8 = 0;
        goto L109
    L195:
        r216 = null;
        goto L196
    L191:
        r215 = null;
        goto L192
    L187:
        r214 = 1.0f;
    L182:
        r67 = r66.intValue();
        goto L184
    L162:
        r211 = r1;
        r212 = r60;
        if (r63.equals("minute") == false) goto L174;
        LynxContext r71 = ((LynxBaseUI) this).mContext;
        Boolean r72 = r122.k;
        if (r72 == null) goto L168;
        boolean r73 = r72.booleanValue();
    L169:
        Integer r74 = r122.d;
        if (r74 == null) goto L172;
        int r75 = r74.intValue();
    L173:
        hma.c.a.e(r59, r71, r62, r73, Integer.valueOf(RangesKt.coerceIn(r75, 0, 59)));
        goto L197
    L172:
        r75 = 0;
        goto L173
    L168:
        r73 = r20.g;
        goto L169
    L117:
        if (r63.equals("hour") == false) goto L115;
        Boolean r76 = r122.j;
        if (r76 == null) goto L122;
        boolean r77 = r76.booleanValue();
    L123:
        LynxContext r124 = ((LynxBaseUI) this).mContext;
        Boolean r78 = r122.k;
        if (r78 == null) goto L126;
        boolean r79 = r78.booleanValue();
    L127:
        hma.c.a.d(r59, r124, r62, r77, r79, Integer.valueOf(S(r122.d, r77)));
    L139:
        r211 = r1;
        r212 = r60;
        goto L197
    L126:
        r79 = r20.g;
        goto L127
    L122:
        r77 = r20.f;
        goto L123
    L129:
        if (r63.equals("ampm") == false) goto L115;
        LynxContext r80 = ((LynxBaseUI) this).mContext;
        Integer r81 = r122.e;
        if (r81 != null) goto L136;
        r81 = r122.d;
        if (r81 != null) goto L136;
        int r82 = 0;
    L138:
        hma.c.a.b(r59, r80, r62, Integer.valueOf(RangesKt.coerceIn(r82, r8, 1)));
    L136:
        r82 = r81.intValue();
        goto L138
    L141:
        if (r63.equals("second") == false) goto L115;
        LynxContext r83 = ((LynxBaseUI) this).mContext;
        Boolean r84 = r122.k;
        if (r84 == null) goto L146;
        boolean r85 = r84.booleanValue();
    L147:
        Integer r125 = r122.d;
        if (r125 == null) goto L150;
        int r126 = r125.intValue();
    L151:
        Integer r127 = Integer.valueOf(RangesKt.coerceIn(r126, r8, 59));
        Intrinsics.checkNotNullParameter(r83, "context");
        r211 = r1;
        r212 = r60;
        List r128 = hma.h.d(0, 59, "", 0, 8);
        if (r85 == false) goto L154;
        String r129 = r83.getString(2131912889);
    L155:
        if (r85 == false) goto L157;
        Integer r217 = Integer.valueOf(pla.d.c(r83, 2));
    L158:
        if (r127 != null) goto L160;
        int r218 = 0;
    L161:
        hma.c.a.h(r59, r62, r128, r129, r218, null, r217, r83, 16);
        goto L197
    L160:
        r218 = Math.max(0, Math.min(r127.intValue(), 59));
        goto L161
    L157:
        r217 = null;
        goto L158
    L154:
        r129 = null;
        goto L155
    L150:
        r126 = 0;
        goto L151
    L146:
        r85 = r20.g;
        goto L147
    L198:
        r29 = r1;
        Consumer r86 = new d3(this);
        Intrinsics.checkNotNullParameter(r86, "listener");
        r59.a = r86;
        r40 = (hma.c) hma.d.a.a(r59, ((LynxBaseUI) this).mContext);
        goto L258
    L99:
        if ((!r20.h.isEmpty()) == true) goto L102;
        r4 = false;
        goto L104
    L92:
        r114 = true;
        goto L93
    L88:
        r112 = false;
        goto L89
    L84:
        r110 = 220;
        goto L85
    L80:
        r17 = 260;
        goto L81
    L74:
        if (Intrinsics.areEqual(r11, "reels") == true) goto L76;
        r15 = true;
        goto L77
    L76:
        r15 = false;
        goto L77
    L67:
        if (Intrinsics.areEqual(r11, "reels") == true) goto L69;
        r13 = true;
        goto L70
    L69:
        r13 = false;
        goto L70
    L57:
        if (Intrinsics.areEqual(r10, "legacy_datetime") == false) goto L60;
    L62:
        r11 = "legacy_datetime";
        goto L63
    L60:
        if ((!r18.isEmpty()) == false) goto L62;
    L52:
        r10 = null;
        goto L54
    L15:
        List r130 = CollectionsKt.createListBuilder();
        int r131 = r5.length();
        int r132 = 0;
    L16:
        if (r132 >= r131) goto L42;
        JSONObject r133 = r5.optJSONObject(r132);
        if (r133 == null) goto L41;
        String r134 = o1.C(r133, new String[]{"type", "kind"});
        if (r134 == null) goto L41;
        String r135 = StringsKt.trim(r134).toString();
        if (r135 == null) goto L41;
        String r136 = r135.toLowerCase(Locale.ROOT);
        if (r136 == null) goto L41;
        if ((!StringsKt.isBlank(r136)) == false) goto L29;
        String r137 = r136;
    L30:
        if (r137 == null) goto L41;
        Object r138 = r133.opt("entries");
        if (r138 != null) goto L36;
        r138 = r133.opt("options");
        if (r138 != null) goto L36;
        r138 = r133.opt("items");
    L36:
        List<String> r139 = o1.H(r138);
        Integer r140 = o1.i(r133.opt("id"));
        Integer r219 = o1.i(r133.opt("selected"));
        Integer r220 = o1.i(r133.opt("selectedIndex"));
        String r141 = r133.optString("tag");
        Intrinsics.checkNotNull(r141);
        if ((!StringsKt.isBlank(r141)) == false) goto L39;
        String r221 = r141;
    L40:
        r130.add(new d(r140, r137, r139, r219, r220, r221, o1.F(r133.opt("widthWeight")), o1.i(r133.opt("widthDp")), o1.i(r133.opt("tagGapDp")), P(r133.opt("is24Hour")), P(r133.opt("showTag"))));
        goto L41
    L39:
        r221 = null;
        goto L40
    L29:
        r137 = null;
    L41:
        r132 = r132 + 1;
        goto L16
    L42:
        r6 = CollectionsKt.build(r130);
        goto L14
    }

    public LynxOUIPickerComboUI(LynxContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.g = true;
        this.i = new c(0);
        if (r3.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public static Boolean P(Object r1) {
        if ((r1 instanceof Boolean) == false) goto L6;
        return (Boolean) r1;
    L6:
        if ((r1 instanceof Number) == false) goto L13;
        if (((Number) r1).intValue() == 0) goto L10;
        boolean r2 = true;
    L52:
        return Boolean.valueOf(r2);
    L10:
        r2 = false;
        goto L52
    L13:
        if ((r1 instanceof String) == false) goto L49;
        String r3 = StringsKt.trim((String) r1).toString().toLowerCase(Locale.ROOT);
        switch(r3.hashCode()) {
            case 48: goto L46;
            case 49: goto L42;
            case 110: goto L39;
            case 121: goto L36;
            case 3521: goto L33;
            case 3551: goto L30;
            case 109935: goto L27;
            case 119527: goto L24;
            case 3569038: goto L21;
            case 97196323: goto L18;
            default: goto L49;
        };
    L18:
        if (r3.equals("false") == false) goto L49;
    L54:
        return Boolean.FALSE;
    L21:
        if (r3.equals("true") == false) goto L49;
    L53:
        return Boolean.TRUE;
    L24:
        if (r3.equals("yes") == true) goto L53;
    L27:
        if (r3.equals("off") == true) goto L54;
    L30:
        if (r3.equals("on") == false) goto L49;
    L33:
        if (r3.equals("no") == true) goto L54;
    L36:
        if (r3.equals("y") == true) goto L53;
    L39:
        if (r3.equals("n") == true) goto L54;
    L42:
        if (r3.equals("1") == true) goto L53;
    L46:
        if (r3.equals("0") == true) goto L54;
    L49:
        return null;
    }

    public final LocalDate O(long r1) {
        return Instant.ofEpochMilli(r1).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public final Long Q(String r4) {
        Object r0 = null;
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim(r4).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (r5.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return null;
    L14:
        Long r2 = StringsKt.toLongOrNull(r5);
        if (r2 != null) goto L17;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        Object r6 = Result.constructor-impl(Long.valueOf(LocalDate.parse(r5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()));     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r6) == true) goto L27;
        r0 = r6;
    L27:
        return (Long) r0;
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L17:
        return Long.valueOf(r2.longValue());
    L11:
        r1 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public final View createView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        FrameLayout r0 = new FrameLayout(r9);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout r1 = new LinearLayout(r9);
        r1.setOrientation(1);
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout r5 = new LinearLayout(r9);
        r5.setOrientation(1);
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.b = r5;
        LinearLayout r4 = new LinearLayout(r9);
        r4.setOrientation(0);
        r4.setGravity(8388613);
        r4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r4.setPadding(o1.t(r9, 12), o1.t(r9, 8), o1.t(r9, 12), o1.t(r9, 8));
        TextView r2 = M(r9, "取消");
        r2.setOnClickListener(new f3(this));
        TextView r10 = M(r9, "确定");
        r10.setOnClickListener(new g3(this));
        r4.addView(r2);
        r4.addView(r10);
        this.c = r4;
        r1.addView(r5);
        r1.addView(r4);
        r0.addView(r1);
        this.a = r0;
        R();
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r1) {
        this.f = o1.G(r1);
        R();
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r2) {
        this.g = r2;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r15) {
        Intrinsics.checkNotNullParameter(r15, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r15, this.f, new String[]{"date", "minDate", "maxDate", "defaultTime", "is24Hour", "showTimeLabels", "mode", "showCalendar", "showActionBar", "showFooter", "calendarHeightDp", "pickerHeightDp", "reels"}, new String[]{"defaultTime", "reels"}, 2));
    }

    public static final TextView M(Context r4, String r5) {
        TextView r0 = new TextView(r4);
        r0.setText(r5);
        r0.setTextSize(14.0f);
        r0.setPadding(o1.t(r4, 12), o1.t(r4, 8), o1.t(r4, 12), o1.t(r4, 8));
        return r0;
    }

    public static int S(Integer r3, boolean r4) {
        boolean r0 = false;
        if (r4 == false) goto L10;
        if (r3 == null) goto L6;
        int r5 = r3.intValue();
    L8:
        return RangesKt.coerceIn(r5, 0, 23);
    L6:
        r5 = LocalDateTime.now().getHour();
        goto L8
    L10:
        if (r3 == null) goto L12;
        int r6 = r3.intValue();
    L14:
        if (1 <= r6) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L28;
        if (r6 >= 0) goto L23;
    L25:
        if (r0 == false) goto L29;
        r6 = r6 % 12;
        if (r6 != 0) goto L28;
        return 12;
    L29:
        return 12;
    L23:
        if (r6 >= 24) goto L25;
        r0 = true;
    L28:
        return r6;
    L16:
        if (r6 >= 13) goto L18;
        r2 = true;
        goto L19
    L12:
        r6 = 12;
        goto L14
    }

    public static int T(d r1, int r2) {
        Integer r0 = r1.a;
        if (r0 != null) goto L26;
        String r3 = r1.getType();
        switch(r3.hashCode()) {
            case -1074026988: goto L21;
            case -906279820: goto L17;
            case 2998057: goto L13;
            case 3208676: goto L9;
            default: goto L25;
        };
    L9:
        if (r3.equals("hour") == false) goto L25;
        return SearchError.ERR_INTERNAL_ERROR;
    L13:
        if (r3.equals("ampm") == false) goto L25;
        return SearchError.ERR_PACKAGE_FAILED;
    L17:
        if (r3.equals("second") == false) goto L25;
        return 1008;
    L21:
        if (r3.equals("minute") == false) goto L25;
        return SearchError.ERR_MODEL_NOT_READY;
    L25:
        return r2 + 2000;
    L26:
        return r0.intValue();
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.time.ZonedDateTime] */
    public final Map<String, Object> N(LocalDate r37, Map<Integer, Integer> r38) {
        c r3 = this.i;
        if (Intrinsics.areEqual(r3.a, "reels") == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        String r13 = "formatted";
        String r15 = "isAm";
        Boolean r20 = null;
        Long r21 = null;
        Boolean r22 = null;
        if (r4 == false) goto L315;
        if ((!this.i.h.isEmpty()) == false) goto L315;
        if (this.i.h.isEmpty() == true) goto L412;
        List<d> r5 = this.i.h;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
        int r14 = 0;
    L17:
        String r8 = "ampm";
        String r24 = r13;
        if (r7.hasNext() == false) goto L128;
        Object r23 = r7.next();
        int r25 = r14 + 1;
        if (r14 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        Iterator r26 = r7;
        d r9 = (d) r23;
        int r28 = T(r9, r14);
        if (r38 == 0) goto L28;
        Integer r16 = r38.get(Integer.valueOf(r28));
        if (r16 == null) goto L28;
        int r2 = r16.intValue();
    L27:
        String r27 = r15;
    L72:
        String r17 = r9.getType();
        switch(r17.hashCode()) {
            case -1074026988: goto L113;
            case -906279820: goto L102;
            case 2998057: goto L94;
            case 3208676: goto L76;
            default: goto L123;
        };
    L123:
        List<String> r10 = r9.c;
        int r11 = RangesKt.coerceIn(r2, 0, RangesKt.coerceAtLeast(r10.size() - 1, 0));
        String r12 = (String) CollectionsKt.getOrNull(r10, r11);
        if (r12 != null) goto L126;
        r12 = "";
    L126:
        String r31 = r12;
        b r18 = new b(r28, r9.getType(), r11, r31, o1.i(r31), r9.f);
    L127:
        r6.add(r18);
        r15 = r27;
        r13 = r24;
        r14 = r25;
        r7 = r26;
        goto L17
    L76:
        if (r17.equals("hour") == false) goto L123;
        Boolean r19 = r9.j;
        if (r19 == null) goto L81;
        boolean r29 = r19.booleanValue();
    L82:
        if (r29 == false) goto L84;
        int r30 = RangesKt.coerceIn(r2, 0, 23);
    L85:
        String r210 = r9.getType();
        String r32 = String.valueOf(r30);
        Integer r33 = Integer.valueOf(r30);
        Boolean r34 = r9.k;
        if (r34 == null) goto L88;
        boolean r35 = r34.booleanValue();
    L89:
        if (r35 == false) goto L91;
        String r36 = "时";
    L92:
        r18 = new b(r28, r210, r2, r32, r33, r36);
        goto L127
    L91:
        r36 = null;
        goto L92
    L88:
        r35 = this.i.g;
        goto L89
    L84:
        r30 = RangesKt.coerceIn(r2 + 1, 1, 12);
        goto L85
    L81:
        r29 = this.i.f;
        goto L82
    L94:
        if (r17.equals("ampm") == false) goto L123;
        int r39 = RangesKt.coerceIn(r2, 0, 1);
        String r211 = r9.getType();
        if (r39 != 0) goto L99;
        String r310 = "上午";
    L100:
        r18 = new b(r28, r211, r39, r310, Integer.valueOf(r39), null);
        goto L127
    L99:
        r310 = "下午";
        goto L100
    L102:
        if (r17.equals("second") == false) goto L123;
        int r40 = RangesKt.coerceIn(r2, 0, 59);
        String r212 = r9.getType();
        String r311 = String.valueOf(r40);
        Integer r312 = Integer.valueOf(r40);
        Boolean r41 = r9.k;
        if (r41 == null) goto L107;
        boolean r42 = r41.booleanValue();
    L108:
        if (r42 == false) goto L110;
        String r313 = "秒";
    L111:
        r18 = new b(r28, r212, r2, r311, r312, r313);
        goto L127
    L110:
        r313 = null;
        goto L111
    L107:
        r42 = this.i.g;
        goto L108
    L113:
        if (r17.equals("minute") == false) goto L123;
        int r43 = RangesKt.coerceIn(r2, 0, 59);
        String r213 = r9.getType();
        String r314 = String.valueOf(r43);
        Integer r315 = Integer.valueOf(r43);
        Boolean r44 = r9.k;
        if (r44 == null) goto L118;
        boolean r45 = r44.booleanValue();
    L119:
        if (r45 == false) goto L121;
        String r316 = "分";
    L122:
        r18 = new b(r28, r213, r2, r314, r315, r316);
        goto L127
    L121:
        r316 = null;
        goto L122
    L118:
        r45 = this.i.g;
    L28:
        String r110 = r9.getType();
        switch(r110.hashCode()) {
            case -1074026988: goto L56;
            case -906279820: goto L53;
            case 2998057: goto L42;
            case 3208676: goto L32;
            default: goto L30;
        };
    L30:
        r27 = r15;
    L64:
        List<String> r46 = r9.c;
        Integer r111 = r9.e;
        if (r111 != null) goto L69;
        r111 = r9.d;
        if (r111 != null) goto L69;
        int r112 = 0;
    L71:
        r2 = RangesKt.coerceIn(r112, 0, RangesKt.coerceAtLeast(r46.size() - 1, 0));
    L69:
        r112 = r111.intValue();
        goto L71
    L42:
        r27 = r15;
        if (r110.equals("ampm") == false) goto L64;
        Integer r47 = r9.e;
        if (r47 != null) goto L50;
        r47 = r9.d;
        if (r47 != null) goto L50;
        int r48 = 0;
    L52:
        r2 = RangesKt.coerceIn(r48, 0, 1);
    L50:
        r48 = r47.intValue();
        goto L52
    L53:
        r27 = r15;
        if (r110.equals("second") == false) goto L64;
    L59:
        Integer r49 = r9.d;
        if (r49 == null) goto L62;
        int r50 = r49.intValue();
    L63:
        r2 = RangesKt.coerceIn(r50, 0, 59);
        goto L72
    L62:
        r50 = 0;
        goto L63
    L56:
        r27 = r15;
        if (r110.equals("minute") == true) goto L59;
    L32:
        if (r110.equals("hour") == false) goto L30;
        Boolean r113 = r9.j;
        if (r113 == null) goto L37;
        boolean r114 = r113.booleanValue();
    L38:
        r2 = S(r9.d, r114);
        if (r114 == true) goto L27;
        r27 = r15;
        r2 = RangesKt.coerceIn(r2 - 1, 0, 11);
        goto L72
    L37:
        r114 = this.i.f;
        goto L38
    L128:
        String r214 = r15;
        ArrayList r51 = new ArrayList();
        Iterator r52 = r6.iterator();
    L130:
        if (r52.hasNext() == false) goto L147;
        b r115 = (b) r52.next();
        String r116 = r115.d;
        if ((!StringsKt.isBlank(r116)) == true) goto L135;
        r116 = null;
    L135:
        if (r116 != null) goto L137;
        r116 = null;
    L145:
        if (r116 == null) goto L130;
        r51.add(r116);
        goto L130
    L137:
        String r117 = r115.f;
        if (r117 != null) goto L140;
    L142:
        r117 = null;
    L143:
        if (r117 == null) goto L145;
        r116 = r116.concat(r117);
        goto L145
    L140:
        if ((!StringsKt.isBlank(r117)) == false) goto L142;
    L147:
        List r53 = CollectionsKt.createListBuilder();
        if (r37 == null) goto L153;
        String r118 = r37.toString();
        if (r118 == null) goto L153;
        r53.add(r118);
    L153:
        if ((!r51.isEmpty()) == false) goto L155;
        r53.add(CollectionsKt.joinToString$default(r51, " ", null, null, 0, null, null, 62, null));
    L155:
        String r54 = CollectionsKt.joinToString$default(CollectionsKt.build(r53), " ", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r54)) == true) goto L159;
        r54 = null;
    L159:
        Pair[] r55 = new Pair[1];
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r120 = r6.iterator();
    L161:
        if (r120.hasNext() == false) goto L163;
        Iterator r317 = r120;
        b r121 = (b) r120.next();
        r119.add(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("id", Integer.valueOf(r121.a)), TuplesKt.to("type", r121.b), TuplesKt.to("selectedIndex", Integer.valueOf(r121.c)), TuplesKt.to("selectedValue", r121.d), TuplesKt.to("selectedNumber", r121.e), TuplesKt.to("tag", r121.f)}));
        r120 = r317;
        r54 = r54;
        r8 = r8;
        goto L161
    L163:
        String r122 = r54;
        String r215 = r8;
        r55[0] = TuplesKt.to("reels", r119);
        LinkedHashMap r0 = MapsKt.linkedMapOf(r55);
        if (r37 == null) goto L166;
        r0.put("date", r37.toString());
        r0.put("year", Integer.valueOf(r37.getYear()));
        r0.put("month", Integer.valueOf(r37.getMonthValue()));
        r0.put("day", Integer.valueOf(r37.getDayOfMonth()));
    L166:
        Iterator r56 = r6.iterator();
    L168:
        if (r56.hasNext() == false) goto L172;
        Object r57 = r56.next();
        if (Intrinsics.areEqual(((b) r57).getType(), "hour") == false) goto L168;
    L173:
        b r58 = (b) r57;
        if (r58 == null) goto L178;
        Integer r59 = r58.e;
        if (r59 == null) goto L178;
        r0.put("hour", Integer.valueOf(r59.intValue()));
    L178:
        Iterator r60 = r6.iterator();
    L180:
        if (r60.hasNext() == false) goto L184;
        Object r61 = r60.next();
        if (Intrinsics.areEqual(((b) r61).getType(), "minute") == false) goto L180;
    L185:
        b r62 = (b) r61;
        if (r62 == null) goto L190;
        Integer r63 = r62.e;
        if (r63 == null) goto L190;
        r0.put("minute", Integer.valueOf(r63.intValue()));
    L190:
        Iterator r64 = r6.iterator();
    L192:
        if (r64.hasNext() == false) goto L196;
        Object r65 = r64.next();
        if (Intrinsics.areEqual(((b) r65).getType(), "second") == false) goto L192;
    L197:
        b r66 = (b) r65;
        if (r66 == null) goto L202;
        Integer r67 = r66.e;
        if (r67 == null) goto L202;
        r0.put("second", Integer.valueOf(r67.intValue()));
    L202:
        Iterator r68 = r6.iterator();
    L204:
        if (r68.hasNext() == false) goto L209;
        Object r69 = r68.next();
        String r70 = r215;
        if (Intrinsics.areEqual(((b) r69).getType(), r70) == true) goto L210;
        r215 = r70;
    L210:
        b r71 = (b) r69;
        if (r71 != null) goto L213;
    L217:
        if (r122 == null) goto L219;
        r0.put(r24, r122);
    L219:
        if (r37 == null) goto L311;
        Iterator r72 = r6.iterator();
    L223:
        if (r72.hasNext() == false) goto L227;
        Object r73 = r72.next();
        if (Intrinsics.areEqual(((b) r73).getType(), "hour") == false) goto L223;
    L228:
        b r74 = (b) r73;
        if (r74 == null) goto L311;
        Integer r75 = r74.e;
        if (r75 == null) goto L311;
        int r76 = r75.intValue();
        Iterator r77 = r6.iterator();
    L234:
        if (r77.hasNext() == false) goto L238;
        Object r78 = r77.next();
        if (Intrinsics.areEqual(((b) r78).getType(), "minute") == false) goto L234;
    L239:
        b r79 = (b) r78;
        if (r79 == null) goto L244;
        Integer r80 = r79.e;
        if (r80 == null) goto L244;
        int r81 = r80.intValue();
    L245:
        Iterator r82 = r6.iterator();
    L247:
        if (r82.hasNext() == false) goto L251;
        Object r83 = r82.next();
        if (Intrinsics.areEqual(((b) r83).getType(), "second") == false) goto L247;
    L252:
        b r84 = (b) r83;
        if (r84 == null) goto L257;
        Integer r85 = r84.e;
        if (r85 == null) goto L257;
        int r86 = r85.intValue();
    L258:
        Iterator r87 = r6.iterator();
    L260:
        if (r87.hasNext() == false) goto L264;
        Object r88 = r87.next();
        if (Intrinsics.areEqual(((b) r88).getType(), r70) == false) goto L260;
    L265:
        b r89 = (b) r88;
        if (r89 == null) goto L268;
        Integer r90 = Integer.valueOf(r89.c);
    L269:
        Iterator r91 = r6.iterator();
    L271:
        if (r91.hasNext() == false) goto L275;
        Object r92 = r91.next();
        if (Intrinsics.areEqual(((b) r92).getType(), "hour") == false) goto L271;
    L276:
        b r93 = (b) r92;
        if (r93 == null) goto L293;
        Iterator<T> r94 = this.i.h.iterator();
    L280:
        if (r94.hasNext() == false) goto L287;
        Object r95 = r94.next();
        d r123 = (d) r95;
        if (T(r123, this.i.h.indexOf(r123)) != r93.a) goto L284;
        boolean r124 = true;
    L285:
        if (r124 == false) goto L280;
    L288:
        d r96 = (d) r95;
        if (r96 == null) goto L291;
        r22 = r96.j;
    L291:
        if (r22 == null) goto L293;
        boolean r97 = r22.booleanValue();
    L294:
        if (r97 == true) goto L309;
        if (r90 == null) goto L309;
        if (r90.intValue() != 0) goto L302;
        int r98 = 12;
        if (r76 != 12) goto L304;
        int r99 = 23;
        int r100 = 0;
        int r125 = 0;
    L310:
        r21 = Long.valueOf(r37.atTime(RangesKt.coerceIn(r125, r100, r99), RangesKt.coerceIn(r81, r100, 59), RangesKt.coerceIn(r86, r100, 59)).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    L304:
        if (r90.intValue() == 0) goto L309;
        if (r76 != r98) goto L308;
        r99 = 23;
        r100 = 0;
        r125 = 12;
        goto L310
    L308:
        r76 = r76 + 12;
        goto L309
    L302:
        r98 = 12;
    L309:
        r125 = r76;
        r99 = 23;
        r100 = 0;
        goto L310
    L284:
        r124 = false;
        goto L285
    L287:
        r95 = null;
    L293:
        r97 = this.i.f;
        goto L294
    L275:
        r92 = null;
        goto L276
    L268:
        r90 = null;
        goto L269
    L264:
        r88 = null;
    L257:
        r86 = 0;
        goto L258
    L251:
        r83 = null;
    L244:
        r81 = 0;
        goto L245
    L238:
        r78 = null;
        goto L239
    L227:
        r73 = null;
    L311:
        if (r21 == null) goto L408;
        r0.put("timestamp", Long.valueOf(r21.longValue()));
    L408:
        return r0;
    L213:
        if (r71.c != 0) goto L215;
        boolean r101 = true;
    L216:
        r0.put(r214, Boolean.valueOf(r101));
        goto L217
    L215:
        r101 = false;
        goto L216
    L209:
        r70 = r215;
        r69 = null;
        goto L210
    L196:
        r65 = null;
        goto L197
    L184:
        r61 = null;
        goto L185
    L172:
        r57 = null;
        goto L173
    L412:
        return null;
    L315:
        if (r37 != null) goto L317;
        return null;
    L317:
        if (r38 == null) goto L413;
        Integer r102 = r38.get(Integer.valueOf(SearchError.ERR_INTERNAL_ERROR));
        if (r102 == null) goto L410;
        int r103 = r102.intValue();
        Integer r126 = r38.get(Integer.valueOf(SearchError.ERR_MODEL_NOT_READY));
        if (r126 == null) goto L411;
        int r127 = r126.intValue();
        Integer r1 = r38.get(Integer.valueOf(SearchError.ERR_PACKAGE_FAILED));
        JSONObject r128 = this.f;
        if (r128 == null) goto L326;
        Object r129 = r128.opt("is24Hour");
    L327:
        Boolean r130 = P(r129);
        if (r130 == null) goto L330;
        boolean r131 = r130.booleanValue();
    L331:
        if (r131 == true) goto L334;
        r103 = r103 + 1;
    L334:
        if (r131 == false) goto L336;
    L335:
        Boolean r104 = r20;
        if (r131 == true) goto L351;
        Boolean r132 = Boolean.TRUE;
        int r105 = 12;
        if (Intrinsics.areEqual(r104, r132) == false) goto L350;
        if (r103 != 12) goto L350;
        r105 = 0;
    L355:
        long r216 = r37.atTime(r105, r127).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        String r106 = r37.toString();
        StringCompanionObject r133 = StringCompanionObject.INSTANCE;
        String r107 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r103), Integer.valueOf(r127)}, 2));
        if (r131 == false) goto L359;
        String r108 = r106 + ' ' + r107;
    L364:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("date", r106), TuplesKt.to("year", Integer.valueOf(r37.getYear())), TuplesKt.to("month", Integer.valueOf(r37.getMonthValue())), TuplesKt.to("day", Integer.valueOf(r37.getDayOfMonth())), TuplesKt.to("hour", Integer.valueOf(r103)), TuplesKt.to("minute", Integer.valueOf(r127)), TuplesKt.to("isAm", r104), TuplesKt.to("timestamp", Long.valueOf(r216)), TuplesKt.to("formatted", r108)});
    L359:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L361;
        String r134 = "上午";
    L362:
        r108 = r106 + ' ' + r107 + ' ' + r134;
        goto L364
    L361:
        r134 = "下午";
    L350:
        if (Intrinsics.areEqual(r104, r132) == true) goto L351;
        if (r103 == 12) goto L355;
        r105 = r103 + 12;
    L351:
        r105 = r103;
        goto L355
    L336:
        if (r1 != null) goto L339;
    L341:
        boolean r109 = false;
    L342:
        r20 = Boolean.valueOf(r109);
        goto L335
    L339:
        if (r1.intValue() != 0) goto L341;
        r109 = true;
        goto L342
    L330:
        r131 = false;
        goto L331
    L326:
        r129 = null;
        goto L327
    L411:
        return null;
    L410:
        return null;
    L413:
        return null;
    L5:
        if ((!r3.h.isEmpty()) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void U(String r4, LocalDate r5, Map<Integer, Integer> r6) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L16;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L17;
        m7a.a r2 = new m7a.a(getSign(), r4);
        Map<String, Object> r7 = N(r5, r6);
        if (r7 == null) goto L12;
        r2.a("value", r7);
        Object r8 = r7.get("timestamp");
        if (r8 == null) goto L12;
        r2.a("timestamp", r8);
    L12:
        if (r6 == null) goto L14;
        r2.a("selections", o1.o(r6));
    L14:
        r1.sendCustomEvent(r2);
        return;
    L17:
        return;
    }
}
