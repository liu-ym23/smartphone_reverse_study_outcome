package com.obric.miniapp.lynx;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.calendar.MaterialCalendarView;
import com.obric.oui.calendar.ODatePickerView;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u007f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u007f\u0080\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020-H\u0002J\n\u00104\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u00105\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u000107H\u0007J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u000107H\u0007J\u0012\u0010:\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u000107H\u0007J\u0012\u0010;\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u000107H\u0007J\u0017\u0010<\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010A\u001a\u00020-2\b\u0010B\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0012\u0010C\u001a\u00020-2\b\u0010D\u001a\u0004\u0018\u000107H\u0007J\u0012\u0010E\u001a\u00020-2\b\u0010D\u001a\u0004\u0018\u000107H\u0007J\u0017\u0010F\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010H\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010I\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010J\u001a\u00020-2\b\u0010K\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010L\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010M\u001a\u00020-2\b\u0010N\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010O\u001a\u00020-2\b\u0010N\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010>J\u0017\u0010P\u001a\u00020-2\b\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020-H\u0016J\n\u0010T\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010U\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010V\u001a\u00020-H\u0002J\b\u0010W\u001a\u00020-H\u0002J\b\u0010X\u001a\u00020-H\u0002J\b\u0010Y\u001a\u00020\u000bH\u0002J\b\u0010Z\u001a\u00020\u001aH\u0002J\b\u0010[\u001a\u00020-H\u0002J\u001a\u0010\\\u001a\u00020-2\u0006\u0010/\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\u000bH\u0002J\u001a\u0010^\u001a\u00020-2\u0006\u0010/\u001a\u00020\t2\b\b\u0002\u0010]\u001a\u00020\u000bH\u0002J\u0010\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010b\u001a\u00020-2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u0010c\u001a\u00020-2\u0006\u0010d\u001a\u00020%H\u0002J\b\u0010e\u001a\u00020-H\u0002J\u0010\u0010f\u001a\u00020-2\u0006\u0010d\u001a\u00020%H\u0002J\u0010\u0010g\u001a\u0002072\u0006\u0010h\u001a\u000207H\u0002J\u0012\u0010i\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010jH\u0002J\u0010\u0010k\u001a\u00020-2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u0010l\u001a\u00020-2\u0006\u0010m\u001a\u00020nH\u0002J$\u0010o\u001a\u00020-2\u0006\u0010p\u001a\u00020j2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020-0rH\u0002J\u0018\u0010s\u001a\u00020-2\u0006\u0010t\u001a\u00020j2\u0006\u0010p\u001a\u00020\tH\u0002J\u0018\u0010u\u001a\u00020v2\u0006\u0010\u0003\u001a\u00020*2\u0006\u0010w\u001a\u00020\u0016H\u0002J\u0018\u0010x\u001a\u00020-2\u0006\u0010m\u001a\u00020n2\u0006\u0010y\u001a\u00020\u0016H\u0002J\u0019\u0010z\u001a\u0004\u0018\u00010\u000f2\b\u00109\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010{J\u0010\u0010|\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u0018\u0010}\u001a\u00020-2\u0006\u0010~\u001a\u0002072\u0006\u00109\u001a\u00020\u0013H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010 \u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIDatePickerViewUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "datePickerView", "Lcom/obric/oui/calendar/ODatePickerView;", "suppressEvent", "", "optionsJson", "Lorg/json/JSONObject;", "minDateMillis", "", "Ljava/lang/Long;", "maxDateMillis", "selectedDate", "Ljava/time/LocalDate;", "selectedDateMillis", "headerPaddingLeft", "", "Ljava/lang/Integer;", "headerPaddingRight", "presentation", "Lcom/obric/miniapp/lynx/LynxOUIDatePickerViewUI$DatePickerPresentation;", "explicitHeightDp", "explicitContentHeightDp", "tileWidthDp", "tileHeightDp", "tileHSpacingDp", "tileVSpacingDp", "clipToBounds", "Ljava/lang/Boolean;", "boundDatePickerView", "headerTitleView", "Landroid/widget/TextView;", "headerTitleWatcher", "Landroid/text/TextWatcher;", "normalizingHeaderTitle", "createView", "Landroid/content/Context;", "createDatePickerView", "rebuildDatePickerView", "", "bindDatePickerView", "view", "updatePropertiesInterval", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "ensureDatePickerViewReady", "createDatePickerViewIfNeeded", "setOptions", "options", "", "setDate", "date", "setMinDate", "setMaxDate", "setHeaderPaddingLeft", "paddingLeft", "(Ljava/lang/Integer;)V", "setHeaderPaddingRight", "paddingRight", "setHeaderPaddingHorizontal", "paddingHorizontal", "setPresentation", "value", "setMode", "setHeight", "height", "setMinHeight", "setContentHeight", "setTileWidth", "width", "setTileHeight", "setTileHSpacing", "spacing", "setTileVSpacing", "setClipToBounds", "clip", "(Ljava/lang/Boolean;)V", "destroy", "currentRootView", "currentDatePickerView", "applySelectedDateToView", "applyDatePickerHeight", "applyDatePickerClipping", "shouldUseCompactDatePickerBounds", "currentPresentation", "applyDatePickerContainerPadding", "applyDatePickerHeaderLayout", "patchCalendarMetrics", "patchDatePickerHeaderLayout", "patchDatePickerHeaderControls", "monthHeaderContainer", "Landroid/view/ViewGroup;", "compactDatePickerHeaderTitle", "bindDatePickerHeaderTitleNormalizer", "titleView", "unbindDatePickerHeaderTitleNormalizer", "normalizeDatePickerHeaderTitle", "compactDatePickerHeaderTitleText", "rawText", "clearHorizontalMargins", "Landroid/view/View;", "patchDatePickerCalendarMetrics", "relaxDatePickerCalendarClipping", "calendarView", "Lcom/obric/oui/calendar/MaterialCalendarView;", "forEachDescendant", "root", "visitor", "Lkotlin/Function1;", "relaxClippingToDatePickerRoot", "start", "resolveDatePickerCalendarMetrics", "Lcom/obric/miniapp/lynx/DatePickerCalendarMetrics;", "availableWidth", "applyDatePickerPagerWidth", "pagerWidth", "parseDateMillis", "(Ljava/lang/String;)Ljava/lang/Long;", "clampDateMillis", "sendEvent", "type", "Companion", "DatePickerPresentation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIDatePickerViewUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int w = 0;
    public FrameLayout a;
    public ODatePickerView b;
    public boolean c;
    public JSONObject d;
    public Long e;
    public Long f;
    public LocalDate g;
    public Long h;
    public Integer i;
    public Integer j;
    public DatePickerPresentation k;
    public Integer l;
    public Integer m;
    public Integer n;
    public Integer o;
    public Integer p;
    public Integer q;
    public Boolean r;
    public ODatePickerView s;
    public TextView t;
    public k2 u;
    public boolean v;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0082\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIDatePickerViewUI$DatePickerPresentation;", "", "mode", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "defaultHeightDp", "", "clipToBounds", "", "tileHSpacingDp", "", "tileVSpacingDp", "defaultHeaderPaddingHorizontalDp", "<init>", "(Ljava/lang/String;ILcom/obric/oui/calendar/ODatePickerView$DatePickerMode;IZFFF)V", "getMode", "()Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "getDefaultHeightDp", "()I", "getClipToBounds", "()Z", "getTileHSpacingDp", "()F", "getTileVSpacingDp", "getDefaultHeaderPaddingHorizontalDp", "BOARD_SHEET", "NARROW_SHEET", "SELECT_DATE_SHEET", "EVENT_INLINE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DatePickerPresentation extends Enum<DatePickerPresentation> {
        public static final DatePickerPresentation BOARD_SHEET = null;
        public static final a Companion = null;
        public static final DatePickerPresentation EVENT_INLINE = null;
        public static final DatePickerPresentation NARROW_SHEET = null;
        public static final DatePickerPresentation SELECT_DATE_SHEET = null;
        public static final /* synthetic */ DatePickerPresentation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final boolean clipToBounds;
        private final float defaultHeaderPaddingHorizontalDp;
        private final int defaultHeightDp;
        private final ODatePickerView.DatePickerMode mode;
        private final float tileHSpacingDp;
        private final float tileVSpacingDp;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DatePickerPresentation> getEntries() {
            return b;
        }

        static {
            ODatePickerView.DatePickerMode r23 = ODatePickerView.DatePickerMode.BOARD_SHEET;
            DatePickerPresentation r11 = new DatePickerPresentation("BOARD_SHEET", 0, r23, 392, false, 6.0f, 4.0f, 0.0f, 32, null);
            BOARD_SHEET = r11;
            DatePickerPresentation r0 = new DatePickerPresentation("NARROW_SHEET", 1, r23, 392, false, 6.0f, 4.0f, 0.0f, 32, null);
            NARROW_SHEET = r0;
            DatePickerPresentation r7 = new DatePickerPresentation("SELECT_DATE_SHEET", 2, r23, 392, false, 6.0f, 4.0f, 3.0f);
            SELECT_DATE_SHEET = r7;
            DatePickerPresentation r2 = new DatePickerPresentation("EVENT_INLINE", 3, r23, 392, true, 6.0f, 4.0f, 0.0f, 32, null);
            EVENT_INLINE = r2;
            DatePickerPresentation[] r1 = {r11, r0, r7, r2};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
            Companion = new a();
        }

        public static DatePickerPresentation[] values() {
            return (DatePickerPresentation[]) a.clone();
        }

        public final boolean getClipToBounds() {
            return this.clipToBounds;
        }

        public final float getDefaultHeaderPaddingHorizontalDp() {
            return this.defaultHeaderPaddingHorizontalDp;
        }

        public final int getDefaultHeightDp() {
            return this.defaultHeightDp;
        }

        public final ODatePickerView.DatePickerMode getMode() {
            return this.mode;
        }

        public final float getTileHSpacingDp() {
            return this.tileHSpacingDp;
        }

        public final float getTileVSpacingDp() {
            return this.tileVSpacingDp;
        }

        public static DatePickerPresentation valueOf(String r1) {
            return (DatePickerPresentation) r27.a.a(DatePickerPresentation.class, r1);
        }

        public DatePickerPresentation(String r1, int r2, ODatePickerView.DatePickerMode r3, int r4, boolean r5, float r6, float r7, float r8) {
            super(r1, r2);
            this.mode = r3;
            this.defaultHeightDp = r4;
            this.clipToBounds = r5;
            this.tileHSpacingDp = r6;
            this.tileVSpacingDp = r7;
            this.defaultHeaderPaddingHorizontalDp = r8;
        }

        public /* synthetic */ DatePickerPresentation(String r11, int r12, ODatePickerView.DatePickerMode r13, int r14, boolean r15, float r16, float r17, float r18, int r19, DefaultConstructorMarker r20) {
            if ((r19 & 32) == 0) goto L5;
            float r9 = 0.0f;
        L6:
            this(r11, r12, r13, r14, r15, r16, r17, r9);
            return;
        L5:
            r9 = r18;
            goto L6
        }
    }

    public static final class a {
    }

    static {
    }

    public final void M() {
        Boolean r0 = this.r;
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        FrameLayout r2 = T();
        if (r2 == null) goto L9;
        r2.setClipChildren(r1);
        r2.setClipToPadding(r1);
    L9:
        ConstraintLayout r3 = S();
        if (r3 == null) goto L12;
        r3.setClipChildren(r1);
        r3.setClipToPadding(r1);
    L12:
        FrameLayout r4 = T();
        if (r4 == null) goto L42;
        Boolean r5 = this.r;
        if (r5 == null) goto L18;
        boolean r6 = r5.booleanValue();
    L19:
        if (r6 == true) goto L21;
        int r7 = o1.s(r4.getContext(), 16.0f);
        int r8 = o1.s(r4.getContext(), 6.0f);
        int r9 = o1.s(r4.getContext(), 16.0f);
        if (r4.getPaddingLeft() == r7) goto L32;
    L37:
        r4.setPadding(r7, r8, r7, r9);
        return;
    L32:
        if (r4.getPaddingTop() != r8) goto L37;
        if (r4.getPaddingRight() != r7) goto L37;
        if (r4.getPaddingBottom() != r9) goto L37;
        return;
    L21:
        if (r4.getPaddingLeft() == 0) goto L23;
    L28:
        r4.setPadding(0, 0, 0, 0);
        return;
    L23:
        if (r4.getPaddingTop() != 0) goto L28;
        if (r4.getPaddingRight() != 0) goto L28;
        if (r4.getPaddingBottom() != 0) goto L28;
        return;
    L18:
        r6 = this.k.getClipToBounds();
        goto L19
    L42:
        return;
    L5:
        r1 = this.k.getClipToBounds();
        goto L6
    }

    public final ODatePickerView S() {
        ODatePickerView r0 = this.b;
        if (r0 != null) goto L16;
        FrameLayout r1 = T();
        if (r1 == null) goto L7;
        Object r2 = r1.getChildAt(0);
    L9:
        if ((r2 instanceof ODatePickerView) == false) goto L11;
        ODatePickerView r3 = (ODatePickerView) r2;
    L12:
        if (r3 == null) goto L15;
        this.b = r3;
        return r3;
    L15:
        return null;
    L11:
        r3 = null;
        goto L12
    L7:
        r2 = null;
        goto L9
    L16:
        return r0;
    }

    public final FrameLayout T() {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L9;
        FrameLayout r1 = (FrameLayout) getView();
        if (r1 == null) goto L7;
        this.a = r1;
        return r1;
    L7:
        return null;
    L9:
        return r0;
    }

    public final void Y() {
        TextView r0 = this.t;
        k2 r1 = this.u;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r0.removeTextChangedListener(r1);
    L6:
        this.t = null;
        this.u = null;
        this.v = false;
    }

    public final void O() {
        FrameLayout r0 = T();
        if (r0 != null) goto L5;
        return;
    L5:
        Context r1 = r0.getContext();
        Integer r2 = this.l;
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        int r4 = o1.s(r1, r3);
        FrameLayout.LayoutParams r5 = null;
        if ((r0 instanceof e) == false) goto L12;
        e r6 = (e) r0;
    L13:
        if (r6 == null) goto L19;
        if (r4 <= 0) goto L19;
        if (r6.a == r4) goto L19;
        r6.a = r4;
        r6.requestLayout();
    L19:
        ConstraintLayout r7 = S();
        if (r7 != null) goto L22;
        return;
    L22:
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof FrameLayout.LayoutParams) == false) goto L26;
        r5 = (FrameLayout.LayoutParams) r8;
    L26:
        if (r5 != null) goto L28;
        r5 = new FrameLayout.LayoutParams(-1, -1);
    L28:
        r5.width = -1;
        Integer r9 = this.m;
        if (r9 == null) goto L31;
        int r10 = o1.s(r7.getContext(), r9.intValue());
    L32:
        r5.height = r10;
        r7.setLayoutParams(r5);
        r7.setMinimumHeight(0);
        M();
        return;
    L31:
        r10 = -2;
        goto L32
    L12:
        r6 = null;
        goto L13
    L8:
        r3 = this.k.getDefaultHeightDp();
        goto L9
    }

    public final void destroy() {
        Y();
        this.a = null;
        this.b = null;
        this.s = null;
        this.g = null;
        this.h = null;
        super.destroy();
    }

    public LynxOUIDatePickerViewUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.k = DatePickerPresentation.BOARD_SHEET;
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public static void Q(View r3) {
        ViewGroup.MarginLayoutParams r0 = null;
        if (r3 == null) goto L5;
        ViewGroup.LayoutParams r1 = r3.getLayoutParams();
    L7:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r0 = (ViewGroup.MarginLayoutParams) r1;
    L9:
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.leftMargin == 0) goto L14;
    L20:
        r0.leftMargin = 0;
        r0.rightMargin = 0;
        r0.setMarginStart(0);
        r0.setMarginEnd(0);
        r3.setLayoutParams(r0);
        return;
    L14:
        if (r0.rightMargin != 0) goto L20;
        if (r0.getMarginStart() != 0) goto L20;
        if (r0.getMarginEnd() != 0) goto L20;
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final long P(long r6) {
        Long r0 = this.e;
        Long r1 = this.f;
        if (r0 != null) goto L5;
    L7:
        if (r1 != null) goto L9;
        return r6;
    L9:
        if (r6 > r1.longValue()) goto L11;
        return r6;
    L11:
        return r1.longValue();
    L5:
        if (r6 >= r0.longValue()) goto L7;
        return r0.longValue();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.ViewGroup, com.obric.oui.calendar.ODatePickerView] */
    public final ODatePickerView R(Context r8) {
        ?? r6 = new ODatePickerView(r8, null, 0, this.k.getMode(), 16);
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        r6.setOutOfMonthVisibility(ODatePickerView.OutOfMonthVisibility.GREY);
        return r6;
    }

    public final Long V(String r4) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.miniapp.lynx.d2] */
    public final void W(ODatePickerView r3) {
        final MaterialCalendarView r4 = (MaterialCalendarView) r3.findViewById(2131365080);
        if (r4 != null) goto L5;
        return;
    L5:
        U(r4, new j2());
        final ?? r0 = new d2(r4, this);
        r4.addOnLayoutChangeListener(new e2(r0));
        r4.post(new f2(r0));
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        e r1 = new e(r3, o1.s(r3, 392.0f));
        r1.setId(2131367812);
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r1.setClipToOutline(false);
        r1.setBackground(new ColorDrawable(0));
        return r1;
    }

    @LynxProp(name = "clipToBounds")
    public final void setClipToBounds(Boolean r1) {
        this.r = r1;
        M();
    }

    @LynxProp(name = "contentHeight")
    public final void setContentHeight(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.m = r3;
        O();
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    @LynxProp(name = "date")
    public final void setDate(String r4) {
        Long r5 = V(r4);
        if (r5 == null) goto L9;
        long r0 = P(r5.longValue());
        this.g = Instant.ofEpochMilli(r0).atZone(ZoneId.systemDefault()).toLocalDate();
        this.h = Long.valueOf(r0);
        ODatePickerView r6 = S();
        if (r6 != null) goto L7;
        return;
    L7:
        this.c = true;
        r6.setCurrentTimeMillis(r0);
        this.c = false;
        N(r6, false);
        return;
    }

    @LynxProp(name = "headerPaddingHorizontal")
    public final void setHeaderPaddingHorizontal(Integer r2) {
        this.i = r2;
        this.j = r2;
        ODatePickerView r3 = S();
        if (r3 == null) goto L6;
        N(r3, false);
        return;
    }

    @LynxProp(name = "headerPaddingLeft")
    public final void setHeaderPaddingLeft(Integer r2) {
        this.i = r2;
        ODatePickerView r3 = S();
        if (r3 == null) goto L6;
        N(r3, false);
        return;
    }

    @LynxProp(name = "headerPaddingRight")
    public final void setHeaderPaddingRight(Integer r2) {
        this.j = r2;
        ODatePickerView r3 = S();
        if (r3 == null) goto L6;
        N(r3, false);
        return;
    }

    @LynxProp(name = "height")
    public final void setHeight(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.l = r3;
        O();
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    @LynxProp(name = "maxDate")
    public final void setMaxDate(String r1) {
        this.f = V(r1);
    }

    @LynxProp(name = "minDate")
    public final void setMinDate(String r1) {
        this.e = V(r1);
    }

    @LynxProp(name = "minHeight")
    public final void setMinHeight(Integer r1) {
        setHeight(r1);
    }

    @LynxProp(name = "mode")
    public final void setMode(String r1) {
        setPresentation(r1);
    }

    @LynxProp(name = "options")
    public final void setOptions(String r4) {
        JSONObject r5 = o1.G(r4);
        this.d = r5;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.has("minDate") == false) goto L9;
        setMinDate(r5.optString("minDate"));
    L9:
        if (r5.has("maxDate") == false) goto L12;
        setMaxDate(r5.optString("maxDate"));
    L12:
        if (r5.has("headerPaddingLeft") == false) goto L15;
        setHeaderPaddingLeft(Integer.valueOf(r5.optInt("headerPaddingLeft")));
    L15:
        if (r5.has("headerPaddingRight") == false) goto L18;
        setHeaderPaddingRight(Integer.valueOf(r5.optInt("headerPaddingRight")));
    L18:
        if (r5.has("headerPaddingHorizontal") == false) goto L20;
        setHeaderPaddingHorizontal(Integer.valueOf(r5.optInt("headerPaddingHorizontal")));
    L20:
        String r0 = o1.C(r5, new String[]{"presentation", "mode"});
        if (r0 == null) goto L23;
        setPresentation(r0);
    L23:
        Integer r1 = o1.f(r5, new String[]{"height", "minHeight", "minHeightDp"});
        if (r1 == null) goto L26;
        setHeight(r1.intValue());
    L26:
        Integer r2 = o1.f(r5, new String[]{"contentHeight", "contentHeightDp"});
        if (r2 == null) goto L29;
        setContentHeight(Integer.valueOf(r2.intValue()));
    L29:
        Integer r3 = o1.f(r5, new String[]{"tileWidth", "tileWidthDp"});
        if (r3 == null) goto L32;
        setTileWidth(Integer.valueOf(r3.intValue()));
    L32:
        Integer r6 = o1.f(r5, new String[]{"tileHeight", "tileHeightDp"});
        if (r6 == null) goto L35;
        setTileHeight(Integer.valueOf(r6.intValue()));
    L35:
        Integer r7 = o1.f(r5, new String[]{"tileHSpacing", "tileHSpacingDp"});
        if (r7 == null) goto L38;
        setTileHSpacing(Integer.valueOf(r7.intValue()));
    L38:
        Integer r8 = o1.f(r5, new String[]{"tileVSpacing", "tileVSpacingDp"});
        if (r8 == null) goto L41;
        setTileVSpacing(Integer.valueOf(r8.intValue()));
    L41:
        Boolean r9 = o1.B(r5, new String[]{"clipToBounds", "clip"});
        if (r9 == null) goto L44;
        setClipToBounds(Boolean.valueOf(r9.booleanValue()));
    L44:
        setDate(o1.C(r5, new String[]{"date", "value"}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View, com.obric.oui.calendar.ODatePickerView] */
    @LynxProp(name = "presentation")
    public final void setPresentation(String r5) {
        DatePickerPresentation.Companion.getClass();
        if (r5 == null) goto L7;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L7;
        String r7 = r6.toLowerCase(Locale.US);
    L8:
        if (r7 != null) goto L10;
    L42:
        DatePickerPresentation r8 = DatePickerPresentation.BOARD_SHEET;
    L44:
        if (this.k != r8) goto L46;
        return;
    L46:
        this.k = r8;
        FrameLayout r9 = T();
        if (r9 == 0) goto L57;
        ?? r1 = R(r9.getContext());
        Y();
        r9.removeAllViews();
        r9.addView(r1);
        this.b = r1;
        this.s = null;
        r1.setOnDateChangedListener(new h2(this, r1));
        r1.setOnMonthChangedListener(new i2(this, r1));
        this.s = r1;
        O();
        ODatePickerView r10 = S();
        if (r10 == null) goto L55;
        Long r2 = this.h;
        if (r2 == null) goto L55;
        long r3 = r2.longValue();
        this.c = true;
        r10.setCurrentTimeMillis(r3);
        this.c = false;
    L55:
        N(r1, true);
        return;
    L57:
        return;
    L10:
        switch(r7.hashCode()) {
            case -1807624732: goto L39;
            case -1655486806: goto L35;
            case -1183997287: goto L31;
            case -1052669861: goto L28;
            case -764127109: goto L25;
            case 731265459: goto L22;
            case 768076766: goto L19;
            case 1516613877: goto L16;
            case 1846747313: goto L13;
            default: goto L42;
        };
    L13:
        if (r7.equals("select_date_sheet") == false) goto L42;
    L37:
        r8 = DatePickerPresentation.SELECT_DATE_SHEET;
        goto L44
    L16:
        if (r7.equals("selectdatesheet") == true) goto L37;
    L19:
        if (r7.equals("event_inline") == false) goto L42;
    L33:
        r8 = DatePickerPresentation.EVENT_INLINE;
        goto L44
    L22:
        if (r7.equals("eventinline") == true) goto L33;
    L25:
        if (r7.equals("narrow_sheet") == false) goto L42;
    L41:
        r8 = DatePickerPresentation.NARROW_SHEET;
        goto L44
    L28:
        if (r7.equals("narrow") == true) goto L41;
    L31:
        if (r7.equals("inline") == true) goto L33;
    L35:
        if (r7.equals("selectdate") == true) goto L37;
    L39:
        if (r7.equals("narrowsheet") == true) goto L41;
    L7:
        r7 = null;
        goto L8
    }

    @LynxProp(name = "tileHSpacing")
    public final void setTileHSpacing(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.p = r3;
        ODatePickerView r4 = S();
        if (r4 == null) goto L15;
        W(r4);
        return;
    L15:
        return;
    L5:
        if (r3.intValue() < 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    @LynxProp(name = "tileHeight")
    public final void setTileHeight(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.o = r3;
        ODatePickerView r4 = S();
        if (r4 == null) goto L15;
        W(r4);
        return;
    L15:
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    @LynxProp(name = "tileVSpacing")
    public final void setTileVSpacing(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.q = r3;
        ODatePickerView r4 = S();
        if (r4 == null) goto L15;
        W(r4);
        return;
    L15:
        return;
    L5:
        if (r3.intValue() < 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    @LynxProp(name = "tileWidth")
    public final void setTileWidth(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.n = r3;
        ODatePickerView r4 = S();
        if (r4 == null) goto L15;
        W(r4);
        return;
    L15:
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.lynx.tasm.behavior.ui.LynxBaseUI, com.obric.miniapp.lynx.LynxOUIDatePickerViewUI] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.obric.oui.calendar.ODatePickerView] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, com.obric.oui.calendar.ODatePickerView] */
    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r20) {
        Intrinsics.checkNotNullParameter(r20, "props");
        ?? r5 = 0;
        ODatePickerView r6 = null;
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r20, this.d, new String[]{"date", "value", "minDate", "maxDate", "headerPaddingLeft", "headerPaddingRight", "headerPaddingHorizontal", "presentation", "mode", "minHeight", "contentHeight", "tileWidth", "tileHeight", "tileHSpacing", "tileVSpacing", "clipToBounds"}, null, 10));
        ODatePickerView r1 = S();
        ?? r2 = r1;
        if (r1 != null) goto L17;
        ?? r3 = T();
        if (r3 == 0) goto L13;
        Object r4 = r3.getChildAt(0);
        if ((r4 instanceof ODatePickerView) == false) goto L10;
        r6 = (ODatePickerView) r4;
    L10:
        if (r6 == null) goto L12;
        this.b = r6;
        r5 = r6;
        goto L13
    L12:
        ?? r7 = R(r3.getContext());
        r3.addView(r7);
        this.b = r7;
        r5 = r7;
    L13:
        if (r5 == 0) goto L27;
        r2 = r5;
        goto L17
    L27:
        return;
    L17:
        if (this.s == r2) goto L28;
        r2.setOnDateChangedListener(new h2(this, r2));
        r2.setOnMonthChangedListener(new i2(this, r2));
        this.s = r2;
        O();
        ODatePickerView r8 = S();
        if (r8 == null) goto L25;
        Long r9 = this.h;
        if (r9 == null) goto L25;
        long r10 = r9.longValue();
        this.c = true;
        r8.setCurrentTimeMillis(r10);
        this.c = false;
    L25:
        N(r2, true);
        return;
    }

    public static void U(View r3, j2 r4) {
        r4.invoke(r3);
        if ((r3 instanceof ViewGroup) == false) goto L5;
        ViewGroup r5 = (ViewGroup) r3;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        int r0 = r5.getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L11;
        U(r5.getChildAt(r1), r4);
        r1 = r1 + 1;
        goto L9
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(final ODatePickerView r1, boolean r2) {
        X(r1, r2);
        r1.post(new g2(this, r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X(ODatePickerView r9, boolean r10) {
        View r0 = r9.findViewById(2131378776);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        ConstraintLayout.LayoutParams r3 = null;
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        float r4 = this.k.getDefaultHeaderPaddingHorizontalDp();
        Context r5 = r9.getContext();
        Integer r6 = this.i;
        if (r6 == null) goto L14;
        float r7 = r6.intValue();
    L15:
        int r8 = o1.s(r5, r7);
        Context r11 = r9.getContext();
        Integer r12 = this.j;
        if (r12 == null) goto L18;
        int r13 = r12.intValue();
    L21:
        r4 = r13;
    L22:
        r2.setPadding(r8, r2.getPaddingTop(), o1.s(r11, r4), r2.getPaddingBottom());
        r0.setPadding(0, r0.getPaddingTop(), 0, r0.getPaddingBottom());
        Q(r0);
        View r14 = r2.findViewById(2131382996);
        View r15 = r2.findViewById(2131380888);
        Q(r14);
        Q(r15);
        if (r14 == null) goto L25;
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
    L27:
        if ((r16 instanceof ConstraintLayout.LayoutParams) == false) goto L29;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r16;
    L31:
        if (r17 == null) goto L33;
        r17.startToStart = -1;
        r17.startToEnd = -1;
        r17.endToEnd = -1;
        r17.endToStart = 2131380888;
        r14.setLayoutParams(r17);
    L33:
        if (r15 == null) goto L35;
        ViewGroup.LayoutParams r18 = r15.getLayoutParams();
    L37:
        if ((r18 instanceof ConstraintLayout.LayoutParams) == false) goto L39;
        r3 = (ConstraintLayout.LayoutParams) r18;
    L39:
        if (r3 == null) goto L41;
        r3.startToStart = -1;
        r3.startToEnd = -1;
        r3.endToStart = -1;
        r3.endToEnd = 0;
        r15.setLayoutParams(r3);
    L41:
        r2.requestLayout();
        TextView r19 = (TextView) r9.findViewById(2131368324);
        if (r19 != null) goto L45;
    L63:
        if (r10 == false) goto L68;
        W(r9);
        return;
    L68:
        return;
    L45:
        if (this.t == r19) goto L47;
    L49:
        Y();
        k2 r20 = new k2(this);
        this.t = r19;
        this.u = r20;
        r19.addTextChangedListener(r20);
    L50:
        CharSequence r21 = r19.getText();
        if (r21 == null) goto L63;
        String r22 = r21.toString();
        if (r22 == null) goto L63;
        String r23 = new Regex("\\s*月\\s*").replace(new Regex("\\s*年\\s*").replace(r22, "年"), "月");
        if (Intrinsics.areEqual(r23, r22) == true) goto L63;
        this.v = true;
        r19.setText(r23);     // Catch: Throwable -> L60
        this.v = false;
    L60:
        th = move-exception;
        this.v = false;
        throw th;
    L47:
        if (this.u == null) goto L49;
    L35:
        r18 = null;
        goto L37
    L29:
        r17 = null;
        goto L31
    L25:
        r16 = null;
        goto L27
    L18:
        Integer r24 = this.i;
        if (r24 == null) goto L22;
        r13 = r24.intValue();
        goto L21
    L14:
        r7 = r4;
        goto L15
    L8:
        r2 = null;
        goto L9
    }
}
