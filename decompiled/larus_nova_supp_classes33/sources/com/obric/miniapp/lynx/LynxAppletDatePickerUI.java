package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.memorydata.sdk.entity.search.SearchError;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\b\u0007\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003abcB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\bH\u0007J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\bH\u0002JE\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010+Je\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010/2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00102JT\u00103\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\u00132\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001052\b\u0010%\u001a\u0004\u0018\u00010\n2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010/2\u0006\u00100\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020'H\u0002J \u00106\u001a\u0004\u0018\u00010\n2\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u000105H\u0002J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020)H\u0002J5\u0010;\u001a\u0004\u0018\u0001082\u0006\u0010-\u001a\u00020\u00132\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001052\u0006\u00100\u001a\u00020\bH\u0002¢\u0006\u0002\u0010<J \u0010=\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010>\u001a\u0002082\u0006\u00100\u001a\u00020\bH\u0002J*\u0010?\u001a\u00020@2\u0006\u0010-\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u00100\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0002J\u0014\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010B\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010C\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010\u0011H\u0002J\u0014\u0010G\u001a\u0004\u0018\u00010\u00112\b\u0010H\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010I\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010J\u001a\u0002082\u0006\u0010B\u001a\u00020\u0011H\u0002J\u0010\u0010K\u001a\u00020@2\u0006\u0010L\u001a\u000208H\u0002J\u0010\u0010M\u001a\u00020\u00112\u0006\u0010L\u001a\u000208H\u0002JD\u0010N\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001052\u0006\u0010-\u001a\u00020\u00132\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001052\u0006\u00100\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0002J \u0010O\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00132\u0006\u0010>\u001a\u0002082\u0006\u00100\u001a\u00020\bH\u0002J \u0010P\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020@2\u0006\u00100\u001a\u00020\bH\u0002J\u0012\u0010R\u001a\u00020'2\b\u0010S\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010T\u001a\u00020E2\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020'H\u0002J&\u0010U\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0V2\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020'H\u0002J\u0019\u0010W\u001a\u0004\u0018\u0001082\b\u0010H\u001a\u0004\u0018\u00010XH\u0002¢\u0006\u0002\u0010YJ\u0010\u0010Z\u001a\u0002082\u0006\u0010Q\u001a\u00020@H\u0002J\u0018\u0010[\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\\\u001a\u00020)H\u0002J(\u0010]\u001a\u00020\u00182\b\u0010^\u001a\u0004\u0018\u00010\n2\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u000105H\u0002J&\u0010_\u001a\u00020\u00182\u0006\u0010`\u001a\u00020\u00132\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u000105H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/obric/miniapp/lynx/LynxAppletDatePickerUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "visible", "", "optionsJson", "Lorg/json/JSONObject;", "picker", "Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "pickerContainer", "calendarView", "Landroid/widget/CalendarView;", "selectedDate", "Ljava/time/LocalDate;", "currentType", "", "suppressChangeEvent", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setVisible", "v", "setOptions", "options", "destroy", "rebuildIfPossible", "forceRecreate", "buildDateCalendar", "container", "defaultValue", "yearRange", "timestampBounds", "Lcom/obric/miniapp/lynx/LynxAppletDatePickerUI$TimestampBounds;", "widthDp", "", "heightDp", "(Landroid/widget/FrameLayout;Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/obric/miniapp/lynx/LynxAppletDatePickerUI$TimestampBounds;Ljava/lang/Integer;Ljava/lang/Integer;)V", "buildPicker", "type", "customOptions", "", "is24Hour", "showTimeLabels", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/util/List;ZZLcom/obric/miniapp/lynx/LynxAppletDatePickerUI$TimestampBounds;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/oui/picker/reels/pickers/OReelDynamicPicker;", "buildConfirmValue", "selections", "", "buildEventValue", "buildTimestamp", "", "hour", "minute", "buildSelectionTimestamp", "(Ljava/lang/String;Ljava/util/Map;Z)Ljava/lang/Long;", "buildTimeValue", "timestamp", "resolveInitialTimeDateTime", "Ljava/time/LocalDateTime;", "buildDateValue", "date", "resolveCalendarDate", "dateBounds", "Lcom/obric/miniapp/lynx/LynxAppletDatePickerUI$DateBounds;", "resolveBaseDate", "parseLocalDate", "raw", "resolveDateFromValue", "localDateToMillis", "millisToLocalDateTime", "millis", "millisToLocalDate", "clampTimeSelectionsIfNeeded", "applyClampedTimeSelection", "syncDefaultValueWithDateTime", "dateTime", "resolveTimestampBounds", "json", "resolveDateBounds", "resolveYearBounds", "Lkotlin/Pair;", "parseTimestamp", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "timestampFromDateTime", "dpToPx", "dp", "sendConfirmEvent", "value", "sendSelectionsEvent", "eventName", "Companion", "TimestampBounds", "DateBounds", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxAppletDatePickerUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int h = 0;
    public boolean a;
    public JSONObject b;
    public hma.c c;
    public FrameLayout d;
    public CalendarView e;
    public LocalDate f;
    public boolean g;

    public static final class a {
    }

    public static final class b {
        public final LocalDate a;
        public final LocalDate b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            LocalDate r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            LocalDate r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DateBounds(minDate=" + this.a + ", maxDate=" + this.b + ')';
        }

        public b(LocalDate r1, LocalDate r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final Long a;
        public final Long b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "TimestampBounds(minTimestamp=" + this.a + ", maxTimestamp=" + this.b + ')';
        }

        public final long a(long r4) {
            Long r0 = this.a;
            if (r0 != null) goto L5;
        L7:
            Long r1 = this.b;
            if (r1 != null) goto L10;
            return r4;
        L10:
            if (r4 > r1.longValue()) goto L12;
            return r4;
        L12:
            return this.b.longValue();
        L5:
            if (r4 >= r0.longValue()) goto L7;
            return this.a.longValue();
        }

        public c(Long r1, Long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void destroy() {
        this.c = null;
        this.e = null;
        this.f = null;
        super.destroy();
    }

    public final LocalDate X() {
        LocalDate r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        JSONObject r1 = this.b;
        if (r1 == null) goto L12;
        String r2 = r1.optString("date");
        if (r2 == null) goto L12;
        LocalDate r3 = U(r2);
        if (r3 == null) goto L12;
        return r3;
    L12:
        JSONObject r4 = this.b;
        if (r4 == null) goto L19;
        JSONObject r5 = r4.optJSONObject("defaultValue");
        if (r5 != null) goto L18;
        return null;
    L18:
        return a0(r5);
    L19:
        return null;
    }

    public LynxAppletDatePickerUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static JSONObject M(LocalDate r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        long r0 = R(r5);
        JSONObject r2 = new JSONObject();
        r2.put("date", r5.toString());
        r2.put("year", r5.getYear());
        r2.put("month", r5.getMonthValue());
        r2.put("day", r5.getDayOfMonth());
        r2.put("timestamp", r0);
        r2.put("formatted", r5.toString());
        return r2;
    }

    public static long R(LocalDate r2) {
        return r2.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.time.LocalDateTime] */
    public static LocalDateTime T(long r0) {
        return Instant.ofEpochMilli(r0).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate U(String r2) {
        Object r0 = null;
        if (r2 == null) goto L5;
        String r3 = StringsKt.trim(r2).toString();
    L6:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        if (r3.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L24;
        return null;
    L24:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        Object r5 = Result.constructor-impl(LocalDate.parse(r3));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r5) == true) goto L23;
        r0 = r5;
    L23:
        return (LocalDate) r0;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L11:
        r1 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static Long V(Object r7) {
        boolean r1 = false;
        if ((r7 instanceof Number) == false) goto L6;
        Long r8 = Long.valueOf(((Number) r7).longValue());
    L17:
        if (r8 == null) goto L27;
        long r3 = r8.longValue();
        if ((-9999999999L) <= r3) goto L21;
    L23:
        if (r1 == false) goto L26;
        r3 = r3 * ((long) SearchError.ERR_UNKNOWN);
    L26:
        return Long.valueOf(r3);
    L21:
        if (r3 >= 10000000000L) goto L23;
        r1 = true;
        goto L23
    L27:
        return null;
    L6:
        if ((r7 instanceof String) == false) goto L16;
        String r9 = StringsKt.trim((String) r7).toString();
        if (r9.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r9 = null;
    L14:
        if (r9 == null) goto L16;
        r8 = StringsKt.toLongOrNull(r9);
        goto L17
    L10:
        r0 = false;
    L16:
        r8 = null;
        goto L17
    }

    public static c c0(JSONObject r6) {
        Object r0 = null;
        if (r6 == null) goto L5;
        Object r1 = r6.opt("minTimestamp");
    L6:
        if (r6 == null) goto L8;
        r0 = r6.opt("maxTimestamp");
    L8:
        Long r7 = V(r1);
        Long r2 = V(r0);
        if (r7 == null) goto L15;
        if (r2 == null) goto L15;
        if (r7.longValue() <= r2.longValue()) goto L15;
        FLogger.a.w("LynxAppletDatePickerUI", "minTimestamp is greater than maxTimestamp, collapsing to minTimestamp");
        r2 = r7;
    L15:
        return new c(r7, r2);
    L5:
        r1 = null;
        goto L6
    }

    public final LocalDate S(long r1) {
        return Instant.ofEpochMilli(r1).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public final void W(boolean r31) {
        JSONObject r2 = this.b;
        if (r2 != null) goto L6;
        FLogger.a.w("LynxAppletDatePickerUI", "show blocked: options is null");
        return;
    L6:
        FrameLayout r4 = this.d;
        if (r4 != null) goto L9;
        return;
    L9:
        String r5 = StringsKt.trim(r2.optString("type")).toString().toLowerCase(Locale.ROOT);
        if (StringsKt.isBlank(r5) == false) goto L13;
        FLogger.a.w("LynxAppletDatePickerUI", "show blocked: type is blank");
        return;
    L13:
        int r8 = 1;
        if (Intrinsics.areEqual(r5, "date") == true) goto L22;
        if (Intrinsics.areEqual(r5, "calendar") == true) goto L22;
        if (this.c != null) goto L23;
    L24:
        boolean r7 = false;
    L25:
        if (r31 == true) goto L28;
        if (r7 == false) goto L28;
        return;
    L28:
        Long r9 = null;
        this.c = null;
        this.e = null;
        this.f = null;
        r4.removeAllViews();
        FLogger.a.i("LynxAppletDatePickerUI", "rebuild picker, type=" + r5 + " forceRecreate=" + r31);
        JSONObject r0 = r2.optJSONObject("defaultValue");
        JSONObject r3 = r2.optJSONObject("yearRange");
        JSONArray r11 = r2.optJSONArray("customOptions");
        if (r11 == null) goto L33;
        ArrayList r12 = new ArrayList(r11.length());
        int r13 = r11.length();
        int r14 = 0;
    L31:
        if (r14 >= r13) goto L34;
        r12.add(r11.optString(r14));
        r14 = r14 + 1;
    L34:
        Boolean r15 = StringsKt.toBooleanStrictOrNull(r2.optString("is24Hour"));
        if (r15 == null) goto L37;
        boolean r16 = r15.booleanValue();
    L38:
        Boolean r17 = StringsKt.toBooleanStrictOrNull(r2.optString("showTimeLabels"));
        if (r17 == null) goto L41;
        boolean r18 = r17.booleanValue();
    L42:
        Integer r19 = StringsKt.toIntOrNull(r2.optString("width"));
        Integer r20 = StringsKt.toIntOrNull(r2.optString("height"));
        c r6 = c0(r2);
        if (Intrinsics.areEqual(r5, "date") == false) goto L45;
    L119:
        this.g = true;
        Context r10 = r4.getContext();
        b r21 = Z(r3, r6);
        LocalDate r22 = Y(r0, r21);
        LocalDate r1 = r21.a;
        if (r1 == null) goto L122;
        Long r110 = Long.valueOf(R(r1));
    L123:
        LocalDate r23 = r21.b;
        if (r23 == null) goto L126;
        r9 = Long.valueOf(R(r23));
    L126:
        if (r19 == null) goto L128;
        int r24 = r19.intValue();
        Intrinsics.checkNotNull(r10);
        int r111 = Q(r10, r24);
    L129:
        if (r20 == null) goto L131;
        int r25 = r20.intValue();
        Intrinsics.checkNotNull(r10);
        int r112 = Q(r10, r25);
    L132:
        FrameLayout.LayoutParams r26 = new FrameLayout.LayoutParams(r111, r112);
        r26.gravity = 1;
        CalendarView r27 = new CalendarView(r10);
        r27.setLayoutParams(r26);
        Intrinsics.checkNotNull(r10);
        r27.setMinimumHeight(Q(r10, 260));
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L135
        r27.setSelectedWeekBackgroundColor(0);     // Catch: Throwable -> L135
        r27.setFocusedMonthDateColor(Color.parseColor("#FF1D2129"));     // Catch: Throwable -> L135
        r27.setUnfocusedMonthDateColor(Color.parseColor("#4D1D2129"));     // Catch: Throwable -> L135
        r27.setWeekSeparatorLineColor(0);     // Catch: Throwable -> L135
        r27.setSelectedDateVerticalBar(Color.parseColor("#FF2BA471"));     // Catch: Throwable -> L135
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L135
    L137:
        if (r110 == null) goto L139;
        r27.setMinDate(r110.longValue());
    L139:
        if (r9 == null) goto L141;
        r27.setMaxDate(r9.longValue());
    L141:
        r27.setDate(R(r22));
        r27.setOnDateChangeListener(new j(this));
        this.f = r22;
        this.e = r27;
        r4.addView(r27);
        this.g = false;
        return;
    L135:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L137
    L131:
        r112 = -2;
        goto L132
    L128:
        r111 = -1;
        goto L129
    L122:
        r110 = null;
        goto L123
    L45:
        if (Intrinsics.areEqual(r5, "calendar") == true) goto L119;
        this.g = true;
        hma.c.a r30 = new hma.c.a();
        boolean r113 = r18;
        int r114 = 12;
        switch(r5.hashCode()) {
            case -930218263: goto L96;
            case 99228: goto L88;
            case 3560141: goto L78;
            case 3704893: goto L69;
            case 104080000: goto L61;
            case 1126698537: goto L50;
            default: goto L49;
        };
    L49:
        int r32 = -2;
        int r115 = -1;
    L109:
        r30.g(SearchError.ERR_PACKAGE_RUN_TIMEOUT, CollectionsKt.listOf("Unsupported: ".concat(r5)), null, 0, 1.0f, null, null, ((LynxBaseUI) this).mContext);
    L110:
        if (r19 == null) goto L112;
        r30.b = Integer.valueOf(Q(((LynxBaseUI) this).mContext, r19.intValue()));
    L112:
        if (r20 == null) goto L114;
        r30.c = Integer.valueOf(Q(((LynxBaseUI) this).mContext, r20.intValue()));
    L114:
        Consumer r33 = new i(this);
        Intrinsics.checkNotNullParameter(r33, "listener");
        r30.a = r33;
        hma.c r34 = (hma.c) hma.d.a.a(r30, ((LynxBaseUI) this).mContext);
        View r35 = r34.a();
        if (r35 == null) goto L117;
        r4.addView(r35, new FrameLayout.LayoutParams(r115, r32));
    L117:
        this.c = r34;
        this.g = false;
        return;
    L50:
        List r116 = r12;
        if (r5.equals("custom_repeat") == false) goto L49;
        if (r12 != null) goto L55;
        r116 = CollectionsKt.emptyList();
    L55:
        List r210 = r116;
        Integer r36 = N(r0, "customIndex");
        if (r36 == null) goto L58;
        int r37 = r36.intValue();
    L59:
        r30.g(SearchError.ERR_PACKAGE_RUN_TIMEOUT, r210, null, RangesKt.coerceIn(r37, 0, RangesKt.coerceAtLeast(r210.size() - 1, 0)), 1.0f, null, null, ((LynxBaseUI) this).mContext);
    L76:
        r32 = -2;
        r115 = -1;
        goto L110
    L58:
        r37 = 0;
        goto L59
    L88:
        r32 = -2;
        r115 = -1;
        if (r5.equals("day") == false) goto L109;
        Integer r38 = N(r0, "day");
        if (r38 == null) goto L94;
        int r39 = r38.intValue();
    L95:
        hma.c.a.c(r30, ((LynxBaseUI) this).mContext, 1003, Integer.valueOf(RangesKt.coerceIn(r39, 1, 31)));
        goto L110
    L94:
        r39 = LocalDate.now().getDayOfMonth();
        goto L95
    L96:
        r32 = -2;
        r115 = -1;
        if (r5.equals("time_with_am_pm") == false) goto L109;
        LocalDateTime r40 = b0(r5, r0, r16, r6);
        this.f = r40.toLocalDate();
        f0(r5, r40, r16);
        if (r16 == false) goto L102;
        int r41 = r40.getHour();
    L105:
        hma.c.a.d(r30, ((LynxBaseUI) this).mContext, SearchError.ERR_INTERNAL_ERROR, r16, r113, Integer.valueOf(r41));
        hma.c.a.e(r30, ((LynxBaseUI) this).mContext, SearchError.ERR_MODEL_NOT_READY, r113, Integer.valueOf(r40.getMinute()));
        LynxContext r42 = ((LynxBaseUI) this).mContext;
        if (r40.getHour() >= 12) goto L108;
        r8 = 0;
    L108:
        hma.c.a.b(r30, r42, SearchError.ERR_PACKAGE_FAILED, Integer.valueOf(r8));
        goto L110
    L102:
        r41 = r40.getHour() % 12;
        if (r41 != 0) goto L105;
        r41 = 12;
        goto L105
    L61:
        if (r5.equals("month") == false) goto L49;
        Integer r43 = N(r0, "month");
        if (r43 == null) goto L66;
        int r44 = r43.intValue();
    L67:
        r30.f(((LynxBaseUI) this).mContext, 1002, Integer.valueOf(RangesKt.coerceIn(r44, 1, 12)), null);
        goto L76
    L66:
        r44 = LocalDate.now().getMonthValue();
        goto L67
    L69:
        if (r5.equals("year") == false) goto L49;
        Pair<Integer, Integer> r45 = d0(r3, r6);
        int r46 = ((Number) r45.component1()).intValue();
        int r47 = ((Number) r45.component2()).intValue();
        Integer r48 = N(r0, "year");
        if (r48 == null) goto L74;
        int r49 = r48.intValue();
    L75:
        hma.c.a.j(r30, ((LynxBaseUI) this).mContext, 1001, r46, r47, Integer.valueOf(RangesKt.coerceIn(r49, r46, r47)));
        goto L76
    L74:
        r49 = LocalDate.now().getYear();
        goto L75
    L78:
        if (r5.equals("time") == false) goto L49;
        LocalDateTime r50 = b0(r5, r0, r16, r6);
        this.f = r50.toLocalDate();
        f0(r5, r50, r16);
        if (r16 == false) goto L83;
        r114 = r50.getHour();
    L87:
        r115 = -1;
        r32 = -2;
        hma.c.a.d(r30, ((LynxBaseUI) this).mContext, SearchError.ERR_INTERNAL_ERROR, r16, r113, Integer.valueOf(r114));
        hma.c.a.e(r30, ((LynxBaseUI) this).mContext, SearchError.ERR_MODEL_NOT_READY, r113, Integer.valueOf(r50.getMinute()));
        goto L110
    L83:
        int r51 = r50.getHour() % 12;
        if (r51 == 0) goto L87;
        r114 = r51;
        goto L87
    L41:
        r18 = true;
        goto L42
    L37:
        r16 = false;
        goto L38
    L33:
        r12 = null;
    L23:
        r7 = true;
    L22:
        if (this.e == null) goto L24;
        goto L23
    }

    public final LocalDate a0(JSONObject r5) {
        Object r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.optString("date");
    L6:
        LocalDate r2 = U(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        if (r5 == null) goto L16;
        Object r3 = r5.opt("timestamp");
        if (r3 == null) goto L16;
        Long r4 = V(r3);
        if (r4 == null) goto L16;
        return S(r4.longValue());
    L16:
        if (r5 == null) goto L20;
        String r6 = r5.optString("year");
        if (r6 == null) goto L20;
        Integer r7 = StringsKt.toIntOrNull(r6);
    L21:
        if (r5 == null) goto L25;
        String r8 = r5.optString("month");
        if (r8 == null) goto L25;
        Integer r9 = StringsKt.toIntOrNull(r8);
    L26:
        if (r5 == null) goto L30;
        String r10 = r5.optString("day");
        if (r10 == null) goto L30;
        Integer r11 = StringsKt.toIntOrNull(r10);
    L31:
        if (r7 == null) goto L47;
        if (r9 == null) goto L48;
        if (r11 == null) goto L49;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L37
        Object r13 = Result.constructor-impl(LocalDate.of(r7.intValue(), r9.intValue(), r11.intValue()));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r13) == true) goto L44;
        r0 = r13;
    L44:
        return (LocalDate) r0;
    L37:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    L30:
        r11 = null;
    L25:
        r9 = null;
    L20:
        r7 = null;
        goto L21
    L5:
        r1 = null;
        goto L6
    }

    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        FrameLayout r0 = new FrameLayout(r6);
        r0.setVisibility(8);
        FrameLayout r1 = new FrameLayout(r6);
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r1.setMinimumHeight(Q(r6, 260));
        this.d = r1;
        r0.addView(r1);
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r5) {
        JSONObject r1 = null;
        Object r2 = null;
        r1 = null;
        if (r5 != null) goto L5;
    L18:
        this.b = r1;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("setOptions len=");
        if (r5 == null) goto L21;
        int r6 = r5.length();
    L22:
        r4.append(r6);
        r4.append(" parsed=");
        if (this.b == null) goto L25;
        boolean r7 = true;
    L26:
        r4.append(r7);
        r3.i("LynxAppletDatePickerUI", r4.toString());
        if (this.a == false) goto L32;
        W(true);
        return;
    L32:
        return;
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = -1;
        goto L22
    L5:
        if ((!StringsKt.isBlank(r5)) == false) goto L7;
        String r8 = r5;
    L8:
        if (r8 == null) goto L18;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(new JSONObject(r8));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r10) == true) goto L17;
        r2 = r10;
    L17:
        r1 = (JSONObject) r2;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L7:
        r8 = null;
        goto L8
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r4) {
        if (this.a != r4) goto L5;
        return;
    L5:
        this.a = r4;
        FLogger.a.i("LynxAppletDatePickerUI", "setVisible=" + r4);
        FrameLayout r0 = (FrameLayout) getView();
        if (r0 == null) goto L11;
        if (r4 == false) goto L9;
        int r2 = 0;
    L10:
        r0.setVisibility(r2);
        goto L11
    L9:
        r2 = 8;
    L11:
        if (r4 == false) goto L14;
        W(false);
        return;
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r13, this.b, new String[]{"type", "title", "defaultValue", "yearRange", "customOptions", "is24Hour", "showTimeLabels", "width", "height", "minTimestamp", "maxTimestamp"}, new String[]{"defaultValue", "yearRange", "customOptions"}, 2));
    }

    public static final Integer N(JSONObject r0, String r1) {
        if (r0 == null) goto L6;
        String r2 = r0.optString(r1);
        if (r2 == null) goto L6;
        return StringsKt.toIntOrNull(r2);
    L6:
        return null;
    }

    public final int Q(Context r2, int r3) {
        Resources r4 = r2.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }

    public final LocalDate Y(JSONObject r6, b r7) {
        if (r6 == null) goto L8;
        String r1 = r6.optString("date");
        if (r1 == null) goto L8;
        LocalDate r2 = U(r1);
        if (r2 == null) goto L8;
    L49:
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "date");
        LocalDate r8 = r7.a;
        if (r8 != null) goto L52;
    L54:
        LocalDate r9 = r7.b;
        if (r9 != null) goto L57;
        return r2;
    L57:
        if (r2.isAfter(r9) == true) goto L59;
        return r2;
    L59:
        return r7.b;
    L52:
        if (r2.isBefore(r8) == false) goto L54;
        r2 = r7.a;
    L8:
        r2 = null;
        Object r3 = null;
        r2 = null;
        r2 = null;
        if (r6 == null) goto L15;
        Object r4 = r6.opt("timestamp");
        if (r4 == null) goto L15;
        Long r5 = V(r4);
        if (r5 == null) goto L15;
        LocalDate r10 = S(r5.longValue());
    L16:
        if (r10 != null) goto L48;
        if (r6 == null) goto L21;
        String r11 = r6.optString("year");
        if (r11 == null) goto L21;
        Integer r12 = StringsKt.toIntOrNull(r11);
    L22:
        if (r6 == null) goto L26;
        String r13 = r6.optString("month");
        if (r13 == null) goto L26;
        Integer r14 = StringsKt.toIntOrNull(r13);
    L27:
        if (r6 == null) goto L31;
        String r15 = r6.optString("day");
        if (r15 == null) goto L31;
        Integer r16 = StringsKt.toIntOrNull(r15);
    L32:
        if (r12 == null) goto L44;
        if (r14 == null) goto L44;
        if (r16 == null) goto L44;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L37
        Object r18 = Result.constructor-impl(LocalDate.of(r12.intValue(), r14.intValue(), r16.intValue()));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r18) == true) goto L43;
        r3 = r18;
    L43:
        r2 = (LocalDate) r3;
    L37:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        if (r2 != null) goto L49;
        r2 = X();
        if (r2 != null) goto L49;
        r2 = LocalDate.now();
    L31:
        r16 = null;
    L26:
        r14 = null;
    L21:
        r12 = null;
        goto L22
    L48:
        r2 = r10;
    L15:
        r10 = null;
        goto L16
    }

    public final b Z(JSONObject r5, c r6) {
        LocalDate r0 = null;
        if (r5 == null) goto L9;
        String r1 = r5.optString("from");
        if (r1 == null) goto L9;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L9;
        LocalDate r3 = LocalDate.of(r2.intValue(), 1, 1);
    L10:
        if (r5 == null) goto L16;
        String r7 = r5.optString("to");
        if (r7 == null) goto L16;
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L16;
        r0 = LocalDate.of(r8.intValue(), 12, 31);
    L16:
        Long r9 = r6.a;
        if (r9 == null) goto L24;
        LocalDate r10 = S(r9.longValue());
        if (r3 != null) goto L22;
    L23:
        r3 = r10;
        goto L24
    L22:
        if (r10.isAfter(r3) == true) goto L23;
    L24:
        Long r11 = r6.b;
        if (r11 == null) goto L32;
        LocalDate r12 = S(r11.longValue());
        if (r0 != null) goto L30;
    L31:
        r0 = r12;
        goto L32
    L30:
        if (r12.isBefore(r0) == true) goto L31;
    L32:
        if (r3 == null) goto L38;
        if (r0 == null) goto L38;
        if (r3.isAfter(r0) == false) goto L38;
        r0 = r3;
    L38:
        return new b(r3, r0);
    L9:
        r3 = null;
        goto L10
    }

    public final Pair<Integer, Integer> d0(JSONObject r4, c r5) {
        if (r4 == null) goto L8;
        String r0 = r4.optString("from");
        if (r0 == null) goto L8;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L9:
        if (r4 == null) goto L15;
        String r6 = r4.optString("to");
        if (r6 == null) goto L15;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L15;
        int r8 = r7.intValue();
    L16:
        Long r3 = r5.a;
        if (r3 == null) goto L19;
        r2 = Math.max(r2, S(r3.longValue()).getYear());
    L19:
        Long r9 = r5.b;
        if (r9 == null) goto L22;
        r8 = Math.min(r8, S(r9.longValue()).getYear());
    L22:
        if (r2 <= r8) goto L25;
        r8 = r2;
    L25:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r8));
    L15:
        r8 = 2030;
    L8:
        r2 = 2000;
        goto L9
    }

    public final void e0(JSONObject r5, Map<Integer, Integer> r6) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L21;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L22;
        m7a.a r2 = new m7a.a(getSign(), "confirm");
        if (r5 == null) goto L12;
        Map<String, Object> r7 = k.b(r5);
        r2.a("value", r7);
        Object r8 = ((HashMap) r7).get("timestamp");
        if (r8 == null) goto L12;
        r2.a("timestamp", r8);
    L12:
        if (r6 == null) goto L18;
        HashMap r9 = new HashMap(r6.size());
        Iterator<Map.Entry<Integer, Integer>> r10 = r6.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Map.Entry<Integer, Integer> r3 = r10.next();
        int r4 = r3.getKey().intValue();
        Integer r11 = Integer.valueOf(r3.getValue().intValue());
        r9.put(String.valueOf(r4), r11);
        goto L15
    L17:
        r2.a("selections", r9);
    L18:
        r1.sendCustomEvent(r2);
        return;
    L22:
        return;
    }

    public static JSONObject P(String r8, long r9, boolean r11) {
        LocalDateTime r0 = T(r9);
        if (r11 == false) goto L5;
        int r12 = r0.getHour();
    L8:
        int r2 = r0.getMinute();
        if (r0.getHour() >= 12) goto L11;
        boolean r1 = true;
    L12:
        JSONObject r3 = new JSONObject();
        r3.put("date", r0.toLocalDate().toString());
        r3.put("year", r0.getYear());
        r3.put("month", r0.getMonthValue());
        r3.put("day", r0.getDayOfMonth());
        r3.put("hour", r12);
        r3.put("minute", r2);
        r3.put("timestamp", r9);
        r3.put("isAm", r1);
        if (Intrinsics.areEqual(r8, "time_with_am_pm") == false) goto L19;
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        Object[] r4 = new Object[3];
        r4[0] = Integer.valueOf(r12);
        r4[1] = Integer.valueOf(r2);
        if (r1 == false) goto L17;
        String r13 = "上午";
    L18:
        r4[2] = r13;
        r3.put("formatted", String.format("%02d:%02d %s", Arrays.copyOf(r4, 3)));
    L20:
        return r3;
    L17:
        r13 = "下午";
        goto L18
    L19:
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        r3.put("formatted", String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r12), Integer.valueOf(r2)}, 2)));
        goto L20
    L11:
        r1 = false;
        goto L12
    L5:
        r12 = r0.getHour() % 12;
        if (r12 != 0) goto L8;
        r12 = 12;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [java.time.ZonedDateTime] */
    public final Long O(String r6, Map<Integer, Integer> r7, boolean r8) {
        Integer r0 = null;
        if (r7 == null) goto L5;
        Integer r1 = r7.get(Integer.valueOf(SearchError.ERR_INTERNAL_ERROR));
    L6:
        if (r7 == null) goto L8;
        Integer r2 = r7.get(Integer.valueOf(SearchError.ERR_MODEL_NOT_READY));
    L9:
        if (r1 == null) goto L51;
        if (r2 == null) goto L51;
        if (Intrinsics.areEqual(r6, "time_with_am_pm") == false) goto L18;
        Integer r9 = r7.get(Integer.valueOf(SearchError.ERR_PACKAGE_FAILED));
        if (r9 == null) goto L17;
        r0 = Integer.valueOf(r9.intValue());
        goto L18
    L17:
        return null;
    L18:
        int r10 = r1.intValue();
        if (r8 == true) goto L23;
        r10 = r10 + 1;
    L23:
        if (Intrinsics.areEqual(r6, "time_with_am_pm") == false) goto L40;
        if (r0 != null) goto L27;
    L29:
        boolean r11 = false;
    L30:
        if (r8 == true) goto L44;
        if (r11 == false) goto L35;
        if (r10 != 12) goto L35;
    L43:
        r10 = 0;
    L35:
        if (r11 == true) goto L44;
        if (r10 != 12) goto L39;
        r10 = 12;
        goto L44
    L39:
        r10 = r10 + 12;
    L44:
        int r12 = r2.intValue();
        LocalDate r13 = this.f;
        if (r13 != null) goto L50;
        r13 = X();
        if (r13 != null) goto L50;
        r13 = LocalDate.now();
    L50:
        return Long.valueOf(r13.atTime(r10, r12).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    L27:
        if (r0.intValue() != 0) goto L29;
        r11 = true;
        goto L30
    L40:
        if (r8 == true) goto L44;
        if (r10 != 12) goto L44;
    L51:
        return null;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v7, types: [java.time.ZonedDateTime] */
    public final void f0(String r6, LocalDateTime r7, boolean r8) {
        JSONObject r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r2 = r0.optJSONObject("defaultValue");
        if (r2 != null) goto L9;
        r2 = new JSONObject();
        r0.put("defaultValue", r2);
    L9:
        if (r8 == false) goto L11;
        int r9 = r7.getHour();
    L14:
        r2.put("date", r7.toLocalDate().toString());
        r2.put("year", r7.getYear());
        r2.put("month", r7.getMonthValue());
        r2.put("day", r7.getDayOfMonth());
        r2.put("hour", r9);
        r2.put("minute", r7.getMinute());
        r2.put("timestamp", r7.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        if (Intrinsics.areEqual(r6, "time_with_am_pm") == true) goto L17;
        return;
    L17:
        if (r7.getHour() >= 12) goto L19;
        boolean r10 = true;
    L20:
        r2.put("isAm", r10);
        return;
    L19:
        r10 = false;
        goto L20
    L11:
        r9 = r7.getHour() % 12;
        if (r9 != 0) goto L14;
        r9 = 12;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [java.time.ZonedDateTime] */
    public final LocalDateTime b0(String r9, JSONObject r10, boolean r11, c r12) {
        Boolean r0 = null;
        if (r10 == null) goto L7;
        String r1 = r10.optString("hour");
        if (r1 == null) goto L7;
        Integer r2 = StringsKt.toIntOrNull(r1);
    L8:
        int r3 = 0;
        if (r10 == null) goto L15;
        String r4 = r10.optString("minute");
        if (r4 == null) goto L15;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 == null) goto L15;
        int r6 = r5.intValue();
    L16:
        int r7 = RangesKt.coerceIn(r6, 0, 59);
        if (r10 == null) goto L21;
        String r8 = r10.optString("isAm");
        if (r8 == null) goto L21;
        r0 = StringsKt.toBooleanStrictOrNull(r8);
    L21:
        boolean r13 = true;
        if (r11 == false) goto L27;
        if (r2 == null) goto L25;
        int r14 = r2.intValue();
    L26:
        int r15 = RangesKt.coerceIn(r14, 0, 23);
    L47:
        if (r0 != null) goto L49;
        if (r2 != null) goto L53;
    L54:
        r13 = false;
    L55:
        LocalDate r16 = a0(r10);
        if (r16 != null) goto L60;
        r16 = X();
        if (r16 != null) goto L60;
        r16 = LocalDate.now();
    L60:
        if (r11 == true) goto L64;
        r15 = r15 + 1;
    L64:
        if (Intrinsics.areEqual(r9, "time_with_am_pm") == false) goto L75;
        if (r11 == true) goto L79;
        if (r13 == true) goto L70;
        if (r15 != 12) goto L70;
    L81:
        return T(r12.a(r16.atTime(r3, r7).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
    L70:
        if (r13 == false) goto L79;
        if (r15 != 12) goto L74;
        r3 = 12;
        goto L81
    L74:
        r3 = r15 + 12;
    L79:
        r3 = r15;
        goto L81
    L75:
        if (r11 == true) goto L79;
        if (r15 != 12) goto L79;
    L53:
        if (r2.intValue() >= 12) goto L55;
    L49:
        if (r0.booleanValue() == false) goto L55;
    L25:
        r14 = LocalDateTime.now().getHour();
        goto L26
    L27:
        if (r2 == null) goto L29;
        int r17 = r2.intValue();
    L30:
        if (1 <= r17) goto L32;
    L34:
        boolean r18 = false;
    L35:
        if (r18 == true) goto L46;
        if (r17 >= 0) goto L39;
    L41:
        boolean r19 = false;
    L42:
        if (r19 == false) goto L45;
        r17 = r17 % 12;
        if (r17 != 0) goto L46;
    L45:
        r17 = 12;
        goto L46
    L39:
        if (r17 >= 24) goto L41;
        r19 = true;
    L46:
        r15 = RangesKt.coerceAtLeast(r17 - 1, 0);
        goto L47
    L32:
        if (r17 >= 13) goto L34;
        r18 = true;
        goto L35
    L29:
        r17 = 12;
    L15:
        r6 = 0;
    L7:
        r2 = null;
        goto L8
    }
}
