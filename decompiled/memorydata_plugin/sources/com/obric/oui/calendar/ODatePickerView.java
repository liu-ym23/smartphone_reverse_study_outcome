package com.obric.oui.calendar;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 Ñ\u00012\u00020\u0001:\u0006Ñ\u0001Ò\u0001Ó\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010F\u001a\u00020/2\b\u0010G\u001a\u0004\u0018\u00010HJ\u001f\u0010I\u001a\u00020/2\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0K\"\u00020H¢\u0006\u0002\u0010LJ\u0016\u0010I\u001a\u00020/2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010MJ\u0006\u0010N\u001a\u00020\u000bJ\b\u0010O\u001a\u00020/H\u0002J\u0006\u0010P\u001a\u00020/J\u0018\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020\u001aH\u0002J\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020\u0013J\u0006\u0010W\u001a\u00020XJ\b\u0010Y\u001a\u0004\u0018\u00010XJ\b\u0010Z\u001a\u00020\u0007H\u0002J\b\u0010[\u001a\u0004\u0018\u00010XJ\b\u0010\\\u001a\u00020\u0007H\u0002J\u0006\u0010]\u001a\u00020'J\b\u0010^\u001a\u0004\u0018\u00010XJ\f\u0010_\u001a\b\u0012\u0004\u0012\u00020X0;J\b\u0010`\u001a\u00020\u0007H\u0007J\u0006\u0010a\u001a\u00020\u0007J\u0006\u0010b\u001a\u00020\u0007J\u0006\u0010c\u001a\u00020\u0007J\u0006\u0010d\u001a\u00020\u0007J\u0006\u0010e\u001a\u00020\u0007J\u0006\u0010f\u001a\u00020\u0007J\u0006\u0010g\u001a\u00020\u0007J\b\u0010h\u001a\u00020/H\u0002J\b\u0010i\u001a\u00020/H\u0002J\b\u0010j\u001a\u00020/H\u0002J\u0006\u0010k\u001a\u00020/J\u0006\u0010l\u001a\u00020\u000bJ\u0006\u0010m\u001a\u00020\u000bJ\u0006\u0010n\u001a\u00020\u000bJ\b\u0010o\u001a\u00020/H\u0014J\u0012\u0010p\u001a\u00020/2\b\u0010q\u001a\u0004\u0018\u00010rH\u0014J\b\u0010s\u001a\u00020/H\u0014J0\u0010t\u001a\u00020/2\u0006\u0010u\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007H\u0014J\u0018\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0007H\u0014J\u0010\u0010}\u001a\u00020/2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0006\u0010~\u001a\u00020/J\u0018\u0010\u007f\u001a\u00020/2\u0007\u0010\u0080\u0001\u001a\u00020X2\u0007\u0010\u0081\u0001\u001a\u00020XJ\u0010\u0010\u0082\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020\u000bJ\u001b\u0010\u0084\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u00020U2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u000bJ\u001d\u0010\u0087\u0001\u001a\u00020/2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010X2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000bJ\u0010\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020'J\u001d\u0010\u008c\u0001\u001a\u00020/2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010X2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010XJ\u001b\u0010\u008f\u0001\u001a\u00020/2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010X2\u0007\u0010\u0091\u0001\u001a\u00020\u000bJ\u0012\u0010\u0092\u0001\u001a\u00020/2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u0013\u0010\u0094\u0001\u001a\u00020/2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020/2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001J\t\u0010\u0098\u0001\u001a\u00020/H\u0002J\u0010\u0010\u0099\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020\u000bJ\u0013\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0007J\u0012\u0010\u009d\u0001\u001a\u00020/2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010XJ\u0011\u0010\u009e\u0001\u001a\u00020/2\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020/2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010XJ\u0010\u0010 \u0001\u001a\u00020/2\u0007\u0010¡\u0001\u001a\u00020@J\u0010\u0010¢\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020\u000bJ\u0011\u0010£\u0001\u001a\u00020/2\u0006\u0010C\u001a\u00020\u0007H\u0002J\u0012\u0010¤\u0001\u001a\u00020/2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010XJ\u0012\u0010¥\u0001\u001a\u00020/2\t\b\u0001\u0010¦\u0001\u001a\u00020\u0007J\u0010\u0010§\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u00020\u0007J\u0010\u0010¨\u0001\u001a\u00020/2\u0007\u0010©\u0001\u001a\u00020\u0007J\u0010\u0010ª\u0001\u001a\u00020/2\u0007\u0010«\u0001\u001a\u00020\u000bJ\u0010\u0010¬\u0001\u001a\u00020/2\u0007\u0010\u00ad\u0001\u001a\u00020\u0007J\u0010\u0010®\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u0010\u0010°\u0001\u001a\u00020/2\u0007\u0010±\u0001\u001a\u00020\u0007J\u0010\u0010²\u0001\u001a\u00020/2\u0007\u0010³\u0001\u001a\u00020\u0007J\u0010\u0010´\u0001\u001a\u00020/2\u0007\u0010µ\u0001\u001a\u00020\u0007J\u0010\u0010¶\u0001\u001a\u00020/2\u0007\u0010\u00ad\u0001\u001a\u00020\u0007J\u0010\u0010·\u0001\u001a\u00020/2\u0007\u0010¸\u0001\u001a\u00020\u0007J\u0010\u0010¹\u0001\u001a\u00020/2\u0007\u0010º\u0001\u001a\u00020\u0007J\u0013\u0010»\u0001\u001a\u00020/2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010¼\u0001J\u001d\u0010½\u0001\u001a\u00020/2\u000e\u0010¾\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010K¢\u0006\u0003\u0010À\u0001J\u0012\u0010½\u0001\u001a\u00020/2\t\b\u0001\u0010Á\u0001\u001a\u00020\u0007J\u0012\u0010Â\u0001\u001a\u00020/2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u0010\u0010Ã\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u0010\u0010Ä\u0001\u001a\u00020/2\u0007\u0010±\u0001\u001a\u00020\u0007J)\u0010Å\u0001\u001a\u00020/2\b\u0010Æ\u0001\u001a\u00030Ç\u00012\t\u0010È\u0001\u001a\u0004\u0018\u00010%2\t\u0010É\u0001\u001a\u0004\u0018\u00010%H\u0002J\u001d\u0010Ê\u0001\u001a\u00020/2\b\u0010Ë\u0001\u001a\u00030Ç\u00012\b\u0010Ì\u0001\u001a\u00030Ç\u0001H\u0002J\u0012\u0010Í\u0001\u001a\u00020/2\u0007\u0010Î\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010Ï\u0001\u001a\u00020/2\u0007\u0010\u0088\u0001\u001a\u00020XH\u0002J\r\u0010Ð\u0001\u001a\u00020'*\u00020XH\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010*\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R7\u00104\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R7\u00107\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R=\u0010:\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0;¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00101\"\u0004\b>\u00103R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ô\u0001"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "datePickerMode", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "selectDateOnMonthChange", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/calendar/ODatePickerView$DatePickerMode;Z)V", "alphaInAnimator", "Landroid/animation/ObjectAnimator;", "alphaOutAnimator", "arrowAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "calendarView", "Lcom/obric/oui/calendar/MaterialCalendarView;", "currentDateTextView", "Landroid/widget/TextView;", "currentDayOfMonth", "currentMonth", "currentYear", "dateFormat", "", "fadeInAnimator", "fadeOutAnimator", "flCalendarContainer", "Landroid/widget/FrameLayout;", "isSyncingFromCalendar", "isSyncingFromPicker", "isYearMonthOpen", "ivOpenYearMonth", "Landroid/widget/ImageView;", "llOpenYearMonth", "Landroid/view/View;", "mSelectTime", "", "millisecond", "nextBtn", "onDateChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, OaidModel.KEY_TIME, "", "getOnDateChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnDateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onDateLongClickListener", "getOnDateLongClickListener", "setOnDateLongClickListener", "onMonthChangedListener", "getOnMonthChangedListener", "setOnMonthChangedListener", "onRangeSelectedListener", "", "times", "getOnRangeSelectedListener", "setOnRangeSelectedListener", "outOfMonthVisibility", "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "pickerView", "previousBtn", "second", "syncCalendarRunnable", "Ljava/lang/Runnable;", "addDecorator", "decorator", "Lcom/obric/oui/calendar/DayViewDecorator;", "addDecorators", "decorators", "", "([Lcom/obric/oui/calendar/DayViewDecorator;)V", "", "allowClickDaysOutsideCurrentMonth", "applyOutOfMonthVisibility", "clearSelection", "formatDate13", "timestamp", "format", "getCalendarMode", "Lcom/obric/oui/calendar/CalendarMode;", "getCalendarView", "getCurrentDate", "Lcom/obric/oui/calendar/CalendarDay;", "getMaximumDate", "getMillisecond", "getMinimumDate", "getSecond", "getSelectTimestamp", "getSelectedDate", "getSelectedDates", "getSelectionColor", "getSelectionMode", "getShowOtherDates", "getTileHSpacing", "getTileHeight", "getTileVSpacing", "getTileWidth", "getWeekDaysHeight", "initCalendar", "initView", "initYearAndMonthPickerView", "invalidateDecorators", "isDynamicHeightEnabled", "isPagingEnabled", "isShowWeekDays", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeDecorator", "removeDecorators", "selectRange", "firstDay", "lastDay", "setAllowClickDaysOutsideCurrentMonth", "enabled", "setCalendarDisplayMode", "mode", "cacheCurrentPosition", "setCurrentDate", "date", "useSmoothScroll", "setCurrentTimeMillis", "selectedTime", "setDateRange", "minDate", "maxDate", "setDateSelected", "day", BuildConfig.FLAVOR, "setDateTextAppearance", "resourceId", "setDayFormatter", "formatter", "Lcom/obric/oui/calendar/format/DayFormatter;", "setDayFormatterContentDescription", "setDefaultDate", "setDynamicHeightEnabled", "setFirstDayOfWeek", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "setMaximumDate", "setMillisecond", "setMinimumDate", "setOutOfMonthVisibility", "visibility", "setPagingEnabled", "setSecond", "setSelectedDate", "setSelectionColor", TypedValues.Custom.S_COLOR, "setSelectionMode", "setShowOtherDates", "showOtherDates", "setShowWeekDays", "showWeekDays", "setTileHSpacing", "spacingPx", "setTileHeight", "heightPx", "setTileHeightDp", "heightDp", "setTileSize", "sizePx", "setTileSizeDp", "sizeDp", "setTileVSpacing", "setTileWidth", "widthPx", "setTileWidthDp", "widthDp", "setWeekDayFormatter", "Lcom/obric/oui/calendar/format/WeekDayFormatter;", "setWeekDayLabels", "weekDayLabels", "", "([Ljava/lang/CharSequence;)V", "arrayRes", "setWeekDayTextAppearance", "setWeekDaysHeight", "setWeekDaysHeightDp", "showAlphaAnimation", "hideStart", "", "toHide", "toShow", "showRotateAnimation", "from", TypedValues.TransitionType.S_TO, "syncCalendar", "yearReal", "syncPicker", "toTimestamp", "Companion", "DatePickerMode", "OutOfMonthVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODatePickerView extends ConstraintLayout {
    public static final a Companion = null;
    public static final int MONTH_ID = 1002;
    private static final long SYNC_CALENDAR_DEBOUNCE_MS = 100;
    public static final String TAG = "DatePickerView";
    public static final int YEAR_FROM = 1900;
    public static final int YEAR_ID = 1001;
    public static final int YEAR_TO = 2100;
    private ObjectAnimator alphaInAnimator;
    private ObjectAnimator alphaOutAnimator;
    private com.obric.common.oea.foundation.animation.d.d arrowAnimator;
    private MaterialCalendarView calendarView;
    private TextView currentDateTextView;
    private int currentDayOfMonth;
    private int currentMonth;
    private int currentYear;
    private String dateFormat;
    private DatePickerMode datePickerMode;
    private com.obric.common.oea.foundation.animation.d.d fadeInAnimator;
    private com.obric.common.oea.foundation.animation.d.d fadeOutAnimator;
    private FrameLayout flCalendarContainer;
    private boolean isSyncingFromCalendar;
    private boolean isSyncingFromPicker;
    private boolean isYearMonthOpen;
    private ImageView ivOpenYearMonth;
    private View llOpenYearMonth;
    private long mSelectTime;
    private int millisecond;
    private ImageView nextBtn;
    private Function1<? super Long, Unit> onDateChangedListener;
    private Function1<? super Long, Unit> onDateLongClickListener;
    private Function1<? super Long, Unit> onMonthChangedListener;
    private Function1<? super List<Long>, Unit> onRangeSelectedListener;
    private OutOfMonthVisibility outOfMonthVisibility;
    private View pickerView;
    private ImageView previousBtn;
    private int second;
    private boolean selectDateOnMonthChange;
    private Runnable syncCalendarRunnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "(Ljava/lang/String;I)V", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        private static final /* synthetic */ DatePickerMode[] $VALUES = null;
        public static final DatePickerMode BOARD_SHEET = null;

        @Deprecated(message = "this mode is deprecated, please use BOARD_SHEET")
        public static final DatePickerMode NARROW_SHEET = null;

        private static final /* synthetic */ DatePickerMode[] $values() {
            return new DatePickerMode[]{BOARD_SHEET, NARROW_SHEET};
        }

        static {
            BOARD_SHEET = new DatePickerMode("BOARD_SHEET", 0);
            NARROW_SHEET = new DatePickerMode("NARROW_SHEET", 1);
            $VALUES = $values();
        }

        private DatePickerMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DatePickerMode valueOf(String r2) {
            return (DatePickerMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(DatePickerMode.class, r2), DatePickerMode.class, "com.obric.memorydata.plugin");
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DatePickerMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "", "(Ljava/lang/String;I)V", "GREY", "HIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OutOfMonthVisibility extends Enum<OutOfMonthVisibility> {
        private static final /* synthetic */ OutOfMonthVisibility[] $VALUES = null;
        public static final OutOfMonthVisibility GREY = null;
        public static final OutOfMonthVisibility HIDE = null;

        private static final /* synthetic */ OutOfMonthVisibility[] $values() {
            return new OutOfMonthVisibility[]{GREY, HIDE};
        }

        static {
            GREY = new OutOfMonthVisibility("GREY", 0);
            HIDE = new OutOfMonthVisibility("HIDE", 1);
            $VALUES = $values();
        }

        private OutOfMonthVisibility(String r1, int r2) {
            super(r1, r2);
        }

        public static OutOfMonthVisibility valueOf(String r2) {
            return (OutOfMonthVisibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(OutOfMonthVisibility.class, r2), OutOfMonthVisibility.class, "com.obric.memorydata.plugin");
        }

        public static OutOfMonthVisibility[] values() {
            return (OutOfMonthVisibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutOfMonthVisibility[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$Companion;", "", "()V", "MONTH_ID", "", "SYNC_CALENDAR_DEBOUNCE_MS", "", "TAG", "", "YEAR_FROM", "YEAR_ID", "YEAR_TO", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13422a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13423b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[OutOfMonthVisibility.values().length];
            r0[OutOfMonthVisibility.HIDE.ordinal()] = 1;
            r0[OutOfMonthVisibility.GREY.ordinal()] = 2;
            f13422a = r0;
            int[] r1 = new int[DayOfWeek.values().length];
            r1[DayOfWeek.SUNDAY.ordinal()] = 1;
            r1[DayOfWeek.MONDAY.ordinal()] = 2;
            r1[DayOfWeek.TUESDAY.ordinal()] = 3;
            r1[DayOfWeek.WEDNESDAY.ordinal()] = 4;
            r1[DayOfWeek.THURSDAY.ordinal()] = 5;
            r1[DayOfWeek.FRIDAY.ordinal()] = 6;
            r1[DayOfWeek.SATURDAY.ordinal()] = 7;
            f13423b = r1;
            int[] r2 = new int[DatePickerMode.values().length];
            r2[DatePickerMode.BOARD_SHEET.ordinal()] = 1;
            r2[DatePickerMode.NARROW_SHEET.ordinal()] = 2;
            c = r2;
        }
    }

    static {
        Companion = new a(null);
    }

    public ODatePickerView(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, null, false, 30, null);
    }

    public ODatePickerView(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, null, false, 28, null);
    }

    public ODatePickerView(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, null, false, 24, null);
    }

    public ODatePickerView(Context r11, AttributeSet r12, int r13, DatePickerMode r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r14, "datePickerMode");
        this(r3, r4, r13, r14, false, 16, null);
    }

    public ODatePickerView(Context r3, AttributeSet r4, int r5, DatePickerMode r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "datePickerMode");
        super(r8, r9, r5);
        this.datePickerMode = r6;
        this.selectDateOnMonthChange = r7;
        this.currentDayOfMonth = CalendarDay.today().getDay();
        this.currentYear = CalendarDay.today().getYear();
        this.currentMonth = CalendarDay.today().getMonth();
        this.outOfMonthVisibility = OutOfMonthVisibility.GREY;
        ConstraintLayout.inflate(r8, ZeusTransformUtils.mapRes(R.layout.o_date_picker_view_default, "layout", "o_date_picker_view_default"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        String r10 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_date_picker_date_format, TypedValues.Custom.S_STRING, "oui_date_picker_date_format"));
        Intrinsics.checkNotNullExpressionValue(r10, "resources.getString(R.st…_date_picker_date_format)");
        this.dateFormat = r10;
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.calendarView, OaidModel.KEY_ID, "calendarView"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.calendarView)");
        this.calendarView = (MaterialCalendarView) ZeusTransformUtils.preCheckCast(r11, MaterialCalendarView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.previousBtn, OaidModel.KEY_ID, "previousBtn"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.previousBtn)");
        this.previousBtn = (ImageView) ZeusTransformUtils.preCheckCast(r12, ImageView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.nextBtn, OaidModel.KEY_ID, "nextBtn"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.nextBtn)");
        this.nextBtn = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.currentDateTextView, OaidModel.KEY_ID, "currentDateTextView"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.currentDateTextView)");
        this.currentDateTextView = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_open_year_month, OaidModel.KEY_ID, "ll_open_year_month"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.ll_open_year_month)");
        this.llOpenYearMonth = r15;
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_open_year_month, OaidModel.KEY_ID, "iv_open_year_month"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.iv_open_year_month)");
        this.ivOpenYearMonth = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_calendar_container, OaidModel.KEY_ID, "fl_calendar_container"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.fl_calendar_container)");
        this.flCalendarContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.memorydata.plugin");
        initView();
    }

    public /* synthetic */ ODatePickerView(Context r4, AttributeSet r5, int r6, DatePickerMode r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        boolean r0 = false;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) == 0) goto L12;
        r7 = DatePickerMode.BOARD_SHEET;
    L12:
        DatePickerMode r2 = r7;
        if ((r9 & 16) != 0) goto L16;
        r0 = r8;
    L16:
        this(r11, r13, r1, r2, r0);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    public static final /* synthetic */ ImageView access$getIvOpenYearMonth$p(ODatePickerView r0) {
        return r0.ivOpenYearMonth;
    }

    private final void applyOutOfMonthVisibility() {
        int r0 = b.f13422a[this.outOfMonthVisibility.ordinal()];
        boolean r1 = false;
        if (r0 != 1) goto L5;
        int r2 = 0;
    L10:
        this.calendarView.setShowOtherDates(r2);
        MaterialCalendarView r3 = this.calendarView;
        if (this.outOfMonthVisibility != OutOfMonthVisibility.GREY) goto L13;
        r1 = true;
    L13:
        r3.setAllowClickDaysOutsideCurrentMonth(r1);
        return;
    L5:
        if (r0 != 2) goto L8;
        r2 = 7;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final String formatDate13(long r1, String r3) {
        Date r0 = new Date(r1);
        SimpleDateFormat r2 = new SimpleDateFormat(r3, Locale.getDefault());
        r2.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        String r4 = r2.format(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "format1.format(date)");
        return r4;
    }

    private final int getMillisecond() {
        return this.millisecond;
    }

    private final int getSecond() {
        return this.second;
    }

    private final void initCalendar() {
        final Calendar r0 = Calendar.getInstance();
        this.calendarView.setTopbarVisible(false);
        this.previousBtn.setOnClickListener(new $$Lambda$ODatePickerView$PjwFp7ztrWfHVo5hBjL95r48(this));
        this.nextBtn.setOnClickListener(new $$Lambda$ODatePickerView$fshZPTFAoiUO8u5XABDEjwHNus(this));
        this.calendarView.setOnMonthChangedListener(new $$Lambda$ODatePickerView$FvnkrZI5HUuLVyHgyYvwOSki6c(r0, this));
        this.calendarView.setOnDateChangedListener(new $$Lambda$ODatePickerView$GGLDul4TvEAvNG979BvkKkFcGxk(r0, this));
        this.calendarView.setOnDateLongClickListener(new $$Lambda$ODatePickerView$zhlqzHHj5T8IgJHhRDEWJMVLFXE(this));
        this.calendarView.setOnRangeSelectedListener(new $$Lambda$ODatePickerView$LOqJ8s4D6PtXdkxcOgLeO0gxyM(this));
        applyOutOfMonthVisibility();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-0, reason: not valid java name */
    private static final void m1258initCalendar$lambda0(ODatePickerView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.calendarView.a();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-1, reason: not valid java name */
    private static final void m1259initCalendar$lambda1(ODatePickerView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.calendarView.b();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-2, reason: not valid java name */
    private static final void m1260initCalendar$lambda2(Calendar r5, ODatePickerView r6, MaterialCalendarView r7, CalendarDay r8) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        com.obric.oui.common.util.f.f13501a.b(TAG, "setOnMonthChangedListener widget:" + r7 + ",date:" + r8);
        r5.set(r8.getYear(), r8.getMonth() - 1, 1);
        long r2 = r5.getTimeInMillis();
        r6.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6.formatDate13(r2, r6.dateFormat), CharSequence.class, "com.obric.memorydata.plugin"));
        r6.currentYear = r8.getYear();
        r6.currentMonth = r8.getMonth();
        if (r6.selectDateOnMonthChange == false) goto L5;
        r6.calendarView.setSelectedDate(CalendarDay.from(r8.getYear(), r8.getMonth(), 1));
    L5:
        Intrinsics.checkNotNullExpressionValue(r8, "date");
        r6.syncPicker(r8);
        Function1<? super Long, Unit> r9 = r6.onMonthChangedListener;
        if (r9 == null) goto L10;
        r9.invoke(Long.valueOf(r2));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-3, reason: not valid java name */
    private static final void m1261initCalendar$lambda3(Calendar r3, ODatePickerView r4, MaterialCalendarView r5, CalendarDay r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "widget");
        Intrinsics.checkNotNullParameter(r6, "date");
        com.obric.oui.common.util.f.f13501a.b(TAG, "setOnDateChangedListener widget:" + r5 + ",date:" + r6 + ",selected:" + r7);
        r3.set(r6.getYear(), r6.getMonth() - 1, r6.getDay());
        long r0 = r3.getTimeInMillis();
        r4.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.formatDate13(r0, r4.dateFormat), CharSequence.class, "com.obric.memorydata.plugin"));
        r4.currentDayOfMonth = r6.getDay();
        r4.currentYear = r6.getYear();
        r4.currentMonth = r6.getMonth();
        Function1<? super Long, Unit> r8 = r4.onDateChangedListener;
        if (r8 == null) goto L7;
        r8.invoke(Long.valueOf(r0));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-4, reason: not valid java name */
    private static final void m1262initCalendar$lambda4(ODatePickerView r2, MaterialCalendarView r3, CalendarDay r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "date");
        Function1<? super Long, Unit> r5 = r2.onDateLongClickListener;
        if (r5 == null) goto L7;
        r5.invoke(Long.valueOf(r2.toTimestamp(r4)));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-6, reason: not valid java name */
    private static final void m1263initCalendar$lambda6(ODatePickerView r4, MaterialCalendarView r5, List r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "widget");
        Intrinsics.checkNotNullParameter(r7, "dates");
        Function1<? super List<Long>, Unit> r8 = r4.onRangeSelectedListener;
        if (r8 == null) goto L12;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        CalendarDay r2 = (CalendarDay) ZeusTransformUtils.preCheckCast(r10.next(), CalendarDay.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r0.add(Long.valueOf(r4.toTimestamp(r2)));
        goto L7
    L9:
        r8.invoke((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"));
        return;
    }

    private final void initView() {
        initCalendar();
        initYearAndMonthPickerView();
    }

    private final void initYearAndMonthPickerView() {
        com.obric.oui.picker.reels.a.a.C0763a r1 = new com.obric.oui.picker.reels.a.a.C0763a();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        com.obric.oui.picker.reels.a.a.C0763a r13 = com.obric.oui.picker.reels.a.a.C0763a.a(r1, r2, 1001, YEAR_FROM, YEAR_TO, Integer.valueOf(this.currentYear), null, 0.0f, 96, null);
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        com.obric.oui.picker.reels.a.a.C0763a r3 = com.obric.oui.picker.reels.a.a.C0763a.a(r13, r14, 1002, Integer.valueOf(this.currentMonth), null, 0.0f, 24, null).a(0.85f).a(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 258));
        r3.a(new $$Lambda$ODatePickerView$G3N90oRQy4n0zhYEij4d2SMVD8M(this));
        com.obric.oui.picker.reels.a.b r4 = (com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.picker.reels.a.b.class, "com.obric.memorydata.plugin");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        View r6 = ((com.obric.oui.picker.reels.a.a) ZeusTransformUtils.preCheckCast(com.obric.oui.picker.reels.a.b.a.a(r4, r5, null, 0, 6, null), com.obric.oui.picker.reels.a.a.class, "com.obric.memorydata.plugin")).a();
        if (r6 != null) goto L5;
        r6 = null;
    L6:
        this.pickerView = r6;
        this.llOpenYearMonth.setOnClickListener(new $$Lambda$ODatePickerView$rX7eTU5wEBxzaBoxLjuCFb7oKTA(this));
        return;
    L5:
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, r6.getLayoutParams().height);
        r7.gravity = 17;
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.setAlpha(0.0f);
        r6.setVisibility(4);
        this.flCalendarContainer.addView(r6);
        goto L6
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-13$lambda-12, reason: not valid java name */
    private static final void m1264initYearAndMonthPickerView$lambda13$lambda12(final ODatePickerView r5, com.obric.oui.picker.reels.a.a.b r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "it");
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r6.a().get(1001), Integer.class, "com.obric.memorydata.plugin");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r6.a().get(1002), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        int r1 = r5.currentYear;
    L6:
        r5.currentYear = r1;
        if (r7 != null) goto L9;
        int r8 = r5.currentMonth;
    L10:
        r5.currentMonth = r8;
        Calendar r9 = Calendar.getInstance();
        final int r2 = r5.currentYear + YEAR_FROM;
        r9.set(r2, RangesKt.coerceAtLeast(r5.currentMonth, 0), 1);
        String r10 = r5.formatDate13(r9.getTimeInMillis(), r5.dateFormat);
        r5.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r5.isSyncingFromCalendar == false) goto L13;
        return;
    L13:
        Runnable r11 = r5.syncCalendarRunnable;
        if (r11 == null) goto L17;
        r5.removeCallbacks(r11);
    L17:
        Runnable r12 = new $$Lambda$ODatePickerView$lWzDrVUB06jCiHrTVrXnF5reZXU(r5, r2);
        r5.syncCalendarRunnable = r12;
        r5.postDelayed(r12, 100);
        return;
    L9:
        r8 = r7.intValue();
        goto L10
    L5:
        r1 = r0.intValue();
        goto L6
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-13$lambda-12$lambda-11, reason: not valid java name */
    private static final void m1265initYearAndMonthPickerView$lambda13$lambda12$lambda11(ODatePickerView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.syncCalendar(r2);
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-15, reason: not valid java name */
    private static final void m1266initYearAndMonthPickerView$lambda15(ODatePickerView r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        com.obric.common.oea.foundation.animation.d.d r9 = r7.arrowAnimator;
        if (r9 == null) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a(r9, false, 1, null);
    L6:
        float r10 = r7.ivOpenYearMonth.getRotation();
        float r4 = 0.0f;
        if (r7.isYearMonthOpen == true) goto L9;
        float r3 = 90.0f;
    L10:
        r7.showRotateAnimation(r10, r3);
        if (r7.isYearMonthOpen == true) goto L13;
        View r11 = r7.pickerView;
    L15:
        if (r7.isYearMonthOpen == true) goto L17;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r7.calendarView, View.class, "com.obric.memorydata.plugin");
    L18:
        com.obric.common.oea.foundation.animation.d.d r6 = r7.fadeOutAnimator;
        if (r6 == null) goto L22;
        com.obric.common.oea.foundation.animation.d.d.a(r6, false, 1, null);
    L22:
        com.obric.common.oea.foundation.animation.d.d r12 = r7.fadeInAnimator;
        if (r12 == null) goto L26;
        com.obric.common.oea.foundation.animation.d.d.a(r12, false, 1, null);
    L26:
        ObjectAnimator r0 = r7.alphaOutAnimator;
        if (r0 == null) goto L30;
        r0.cancel();
    L30:
        ObjectAnimator r1 = r7.alphaInAnimator;
        if (r1 == null) goto L34;
        r1.cancel();
    L34:
        if (r5 != null) goto L36;
        float r2 = 1.0f;
    L37:
        if (r11 == null) goto L40;
        r4 = r11.getAlpha();
    L40:
        if (r11 == null) goto L43;
        r11.setAlpha(r4);
    L43:
        if (r5 == null) goto L46;
        r5.setAlpha(r2);
    L46:
        r7.showAlphaAnimation(r2, r5, r11);
        r7.isYearMonthOpen = !r7.isYearMonthOpen;
        return;
    L36:
        r2 = r5.getAlpha();
        goto L37
    L17:
        r5 = r7.pickerView;
        goto L18
    L13:
        r11 = (View) ZeusTransformUtils.preCheckCast(r7.calendarView, View.class, "com.obric.memorydata.plugin");
        goto L15
    L9:
        r3 = 0.0f;
        goto L10
    }

    /* JADX INFO: renamed from: lambda$-Pj-wFp7ztrW-fHVo5hBjL95r48, reason: not valid java name */
    public static /* synthetic */ void m1267lambda$PjwFp7ztrWfHVo5hBjL95r48(ODatePickerView r0, View r1) {
        m1258initCalendar$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$-fshZPTFAoiUO8u5XABDEjwHNus, reason: not valid java name */
    public static /* synthetic */ void m1268lambda$fshZPTFAoiUO8u5XABDEjwHNus(ODatePickerView r0, View r1) {
        m1259initCalendar$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$FvnkrZI5-HUuLVyHgyYvwOSki6c, reason: not valid java name */
    public static /* synthetic */ void m1269lambda$FvnkrZI5HUuLVyHgyYvwOSki6c(Calendar r0, ODatePickerView r1, MaterialCalendarView r2, CalendarDay r3) {
        m1260initCalendar$lambda2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$G3N90oRQy4n0zhYEij4d2SMVD8M(ODatePickerView r0, com.obric.oui.picker.reels.a.a.b r1) {
        m1264initYearAndMonthPickerView$lambda13$lambda12(r0, r1);
    }

    public static /* synthetic */ void lambda$GGLDul4TvEAvNG979BvkKkFcGxk(Calendar r0, ODatePickerView r1, MaterialCalendarView r2, CalendarDay r3, boolean r4) {
        m1261initCalendar$lambda3(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$LOqJ8s4D6PtXdkxcOgLeO0gx-yM, reason: not valid java name */
    public static /* synthetic */ void m1270lambda$LOqJ8s4D6PtXdkxcOgLeO0gxyM(ODatePickerView r0, MaterialCalendarView r1, List r2) {
        m1263initCalendar$lambda6(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$lWzDrVUB06jCiHrTVrXnF5reZXU(ODatePickerView r0, int r1) {
        m1265initYearAndMonthPickerView$lambda13$lambda12$lambda11(r0, r1);
    }

    public static /* synthetic */ void lambda$rX7eTU5wEBxzaBoxLjuCFb7oKTA(ODatePickerView r0, View r1) {
        m1266initYearAndMonthPickerView$lambda15(r0, r1);
    }

    public static /* synthetic */ void lambda$zhlqzHHj5T8IgJHhRDEWJMVLFXE(ODatePickerView r0, MaterialCalendarView r1, CalendarDay r2) {
        m1262initCalendar$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void setCalendarDisplayMode$default(ODatePickerView r0, CalendarMode r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setCalendarDisplayMode(r1, r2);
    }

    public static /* synthetic */ void setCurrentDate$default(ODatePickerView r0, CalendarDay r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setCurrentDate(r1, r2);
    }

    private final void setDefaultDate() {
        Calendar r0 = Calendar.getInstance();
        com.obric.oui.common.util.f.f13501a.b(TAG, "默认选中的时间:" + this.mSelectTime + " , mSelectTime:" + this.mSelectTime);
        r0.setTimeInMillis(this.mSelectTime);
        int r2 = r0.get(1);
        int r4 = r0.get(2) + 1;
        int r1 = r0.get(5);
        int r5 = r0.get(11);
        int r6 = r0.get(12);
        int r7 = r0.get(13);
        int r3 = r0.get(14);
        this.currentDayOfMonth = r1;
        com.obric.oui.common.util.f.f13501a.b(TAG, "转化时间year:" + r2 + ",month:" + r4 + ",day:" + r1 + ",hour:" + r5 + ",minute:" + r6 + ", selectDate:" + CalendarDay.from(r2, r4, r1));
        String r8 = formatDate13(this.mSelectTime, this.dateFormat);
        this.calendarView.setCurrentDate(CalendarDay.from(r2, r4, r1));
        this.calendarView.setSelectedDate(CalendarDay.from(r2, r4, r1));
        this.currentDateTextView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
        setSecond(r7);
        setMillisecond(r3);
    }

    private final void setMillisecond(int r1) {
        this.millisecond = r1;
    }

    private final void setSecond(int r1) {
        this.second = r1;
    }

    private final void showAlphaAnimation(float r26, final View r27, final View r28) {
        final float r6 = 1.0f;
        PathInterpolator r3 = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        if (r27 == null) goto L6;
        r27.setVisibility(0);
    L6:
        if (r28 == null) goto L9;
        r28.setVisibility(0);
    L9:
        com.obric.common.oea.foundation.animation.d.d r13 = null;
        if (r27 == null) goto L16;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r27, "alpha", new float[]{r26, 0.0f});
        r15.setDuration(50);
        r15.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r3, TimeInterpolator.class, "com.obric.memorydata.plugin"));
        this.alphaOutAnimator = r15;
        if (r27 != this.pickerView) goto L14;
        final float r8 = 1.05f;
    L15:
        com.obric.common.oea.foundation.animation.builder.c.a r18 = new com.obric.common.oea.foundation.animation.builder.c.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r9 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r9.a(0.001f);
        Unit r10 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.c r1 = com.obric.common.oea.foundation.animation.builder.c.a.a(r18, 1.0f, r8, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r9, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r27), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r27, r8), Function2.class, "com.obric.memorydata.plugin")).a();
    L17:
        if (r28 == null) goto L23;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r28, "alpha", new float[]{r28.getAlpha(), 1.0f});
        r11.setDuration(200);
        r11.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r3, TimeInterpolator.class, "com.obric.memorydata.plugin"));
        this.alphaInAnimator = r11;
        if (r28 != this.pickerView) goto L21;
        float r4 = 1.05f;
    L22:
        r28.setScaleX(r4);
        r28.setScaleY(r4);
        com.obric.common.oea.foundation.animation.builder.c.a r17 = new com.obric.common.oea.foundation.animation.builder.c.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r5 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r5.a(0.001f);
        Unit r7 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.c r2 = com.obric.common.oea.foundation.animation.builder.c.a.a(r17, r4, 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r5, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass7(r28), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass8(r28, r6), Function2.class, "com.obric.memorydata.plugin")).a();
    L24:
        if (r1 != null) goto L26;
        com.obric.common.oea.foundation.animation.d.d r12 = null;
    L27:
        this.fadeOutAnimator = r12;
        if (r2 == null) goto L31;
        r13 = r2.a();
    L31:
        this.fadeInAnimator = r13;
        ObjectAnimator r14 = this.alphaOutAnimator;
        if (r14 == null) goto L35;
        r14.start();
    L35:
        ObjectAnimator r0 = this.alphaInAnimator;
        if (r0 == null) goto L40;
        r0.start();
        return;
    L40:
        return;
    L26:
        r12 = r1.a();
        goto L27
    L21:
        r4 = 0.95f;
        goto L22
    L23:
        r2 = null;
        goto L24
    L14:
        r8 = 0.95f;
        goto L15
    L16:
        r1 = null;
        goto L17
    }

    private final void showRotateAnimation(float r9, float r10) {
        this.arrowAnimator = com.obric.common.oea.foundation.animation.builder.c.a.a(new com.obric.common.oea.foundation.animation.builder.c.a(), r9, r10, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    private final void syncCalendar(int r5) {
        if (this.isSyncingFromCalendar == false) goto L5;
        return;
    L5:
        int r0 = this.currentMonth + 1;
        CalendarDay r2 = this.calendarView.getCurrentDate();
        if (r2.getYear() == r5) goto L8;
    L9:
        this.isSyncingFromPicker = true;
        this.calendarView.setCurrentDate(CalendarDay.from(r5, r0, 1));
        return;
    L8:
        if (r2.getMonth() != r0) goto L9;
    }

    private final void syncPicker(CalendarDay r7) {
        if (this.isSyncingFromPicker == false) goto L6;
        this.isSyncingFromPicker = false;
        return;
    L6:
        View r0 = this.pickerView;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.picker.reels.a.class) == false) goto L9;
        com.obric.oui.picker.reels.a r1 = (com.obric.oui.picker.reels.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.picker.reels.a.class, "com.obric.memorydata.plugin");
    L10:
        if (r1 == null) goto L26;
        int r2 = RangesKt.coerceAtLeast(r7.getYear() - 1900, 0);
        int r8 = RangesKt.coerceIn(r7.getMonth() - 1, 0, 11);
        this.isSyncingFromCalendar = true;
        WheelView r4 = r1.getReelView(0);
        if (r4 != null) goto L16;
    L18:
        WheelView r3 = r1.getReelView(1);
        if (r3 != null) goto L22;
    L24:
        this.isSyncingFromCalendar = false;
        return;
    L22:
        if (r3.getCurrentIndex() == r8) goto L24;
        r3.a(r8, false);
        goto L24
    L16:
        if (r4.getCurrentIndex() == r2) goto L18;
        r4.a(r2, false);
        goto L18
    L26:
        return;
    L9:
        r1 = null;
        goto L10
    }

    private final long toTimestamp(CalendarDay r8) {
        Calendar r7 = Calendar.getInstance();
        r7.set(r8.getYear(), r8.getMonth() - 1, r8.getDay(), 0, 0, 0);
        r7.set(14, 0);
        return r7.getTimeInMillis();
    }

    public final void addDecorator(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.calendarView.a(r4);
    }

    public final void addDecorators(Collection<? extends d> r3) {
        Collection<? extends d> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this.calendarView.a(r4);
    }

    public final void addDecorators(d... r3) {
        Intrinsics.checkNotNullParameter(r3, "decorators");
        this.calendarView.a((d[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), d[].class, "com.obric.memorydata.plugin"));
    }

    public final boolean allowClickDaysOutsideCurrentMonth() {
        return this.calendarView.f();
    }

    public final void clearSelection() {
        this.calendarView.e();
    }

    public final CalendarMode getCalendarMode() {
        CalendarMode r1 = this.calendarView.getCalendarMode();
        Intrinsics.checkNotNullExpressionValue(r1, "calendarView.calendarMode");
        return r1;
    }

    public final MaterialCalendarView getCalendarView() {
        return this.calendarView;
    }

    public final CalendarDay getCurrentDate() {
        CalendarDay r1 = this.calendarView.getCurrentDate();
        Intrinsics.checkNotNullExpressionValue(r1, "calendarView.currentDate");
        return r1;
    }

    public final CalendarDay getMaximumDate() {
        return this.calendarView.getMaximumDate();
    }

    public final CalendarDay getMinimumDate() {
        return this.calendarView.getMinimumDate();
    }

    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.onDateChangedListener;
    }

    public final Function1<Long, Unit> getOnDateLongClickListener() {
        return this.onDateLongClickListener;
    }

    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.onMonthChangedListener;
    }

    public final Function1<List<Long>, Unit> getOnRangeSelectedListener() {
        return this.onRangeSelectedListener;
    }

    public final long getSelectTimestamp() {
        Calendar r6 = Calendar.getInstance();
        CalendarDay r0 = (CalendarDay) ZeusTransformUtils.preCheckCast(this.calendarView.getSelectedDates().get(0), CalendarDay.class, "com.obric.memorydata.plugin");
        int r1 = r0.getYear();
        int r2 = r0.getMonth() - 1;
        int r3 = r0.getDay();
        r6.set(13, getSecond());
        r6.set(14, getMillisecond());
        r6.set(r1, r2, r3, 0, 0);
        return r6.getTimeInMillis();
    }

    public final CalendarDay getSelectedDate() {
        return this.calendarView.getSelectedDate();
    }

    public final List<CalendarDay> getSelectedDates() {
        List<CalendarDay> r1 = this.calendarView.getSelectedDates();
        Intrinsics.checkNotNullExpressionValue(r1, "calendarView.selectedDates");
        return r1;
    }

    public final int getSelectionColor() {
        return this.calendarView.getSelectionColor();
    }

    public final int getSelectionMode() {
        return this.calendarView.getSelectionMode();
    }

    public final int getShowOtherDates() {
        return this.calendarView.getShowOtherDates();
    }

    public final int getTileHSpacing() {
        return this.calendarView.getTileHSpacing();
    }

    public final int getTileHeight() {
        return this.calendarView.getTileHeight();
    }

    public final int getTileVSpacing() {
        return this.calendarView.getTileVSpacing();
    }

    public final int getTileWidth() {
        return this.calendarView.getTileWidth();
    }

    public final int getWeekDaysHeight() {
        return this.calendarView.getWeekDaysHeight();
    }

    public final void invalidateDecorators() {
        this.calendarView.j();
    }

    public final boolean isDynamicHeightEnabled() {
        return this.calendarView.h();
    }

    public final boolean isPagingEnabled() {
        return this.calendarView.k();
    }

    public final boolean isShowWeekDays() {
        return this.calendarView.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
        ViewParent r1 = getParent();
        if (r1 != null) goto L6;
    L4:
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, OSheetContentFrameLayout.class) == true) goto L10;
        return;
    L10:
        if (((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).getId() != ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container")) goto L36;
        int r3 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).getPaddingLeft();
        int r4 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).getPaddingTop();
        int r5 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).getPaddingRight();
        int r6 = ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).getPaddingBottom();
        int r7 = b.c[this.datePickerMode.ordinal()];
        if (r7 == 1) goto L26;
        if (r7 == 2) goto L17;
        return;
    L17:
        if (r3 == com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0)) goto L19;
    L24:
        com.obric.oui.c.a.b.b(TAG, "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r3 + ", " + r4 + ", " + r5 + ", " + r6 + ']');
        ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r4 != com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0)) goto L24;
        if (r5 != com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0)) goto L24;
        if (r6 != com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0)) goto L24;
        return;
    L26:
        if (r3 == com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16)) goto L28;
    L33:
        com.obric.oui.c.a.b.b(TAG, "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r3 + ", " + r4 + ", " + r5 + ", " + r6 + ']');
        ((OSheetContentFrameLayout) ZeusTransformUtils.preCheckCast(r2, OSheetContentFrameLayout.class, "com.obric.memorydata.plugin")).setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16));
        return;
    L28:
        if (r4 != com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6)) goto L33;
        if (r5 != com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16)) goto L33;
        if (r6 != com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16)) goto L33;
        return;
    L36:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L4;
        goto L4
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        String r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_date_picker_date_format, TypedValues.Custom.S_STRING, "oui_date_picker_date_format"));
        Intrinsics.checkNotNullExpressionValue(r5, "resources.getString(R.st…_date_picker_date_format)");
        this.dateFormat = r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r0 = this.syncCalendarRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.syncCalendarRunnable = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void removeDecorator(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.calendarView.b(r4);
    }

    public final void removeDecorators() {
        this.calendarView.i();
    }

    public final void selectRange(CalendarDay r2, CalendarDay r3) {
        Intrinsics.checkNotNullParameter(r2, "firstDay");
        Intrinsics.checkNotNullParameter(r3, "lastDay");
        this.calendarView.a(r2, r3);
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.calendarView.setAllowClickDaysOutsideCurrentMonth(r1);
    }

    public final void setCalendarDisplayMode(CalendarMode r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.calendarView.l().a().a(r2).b(r3).a();
    }

    public final void setCurrentDate(CalendarDay r1, boolean r2) {
        this.calendarView.b(r1, r2);
    }

    public final void setCurrentTimeMillis(long r1) {
        this.mSelectTime = r1;
        setDefaultDate();
    }

    public final void setDateRange(CalendarDay r1, CalendarDay r2) {
        this.calendarView.l().a().a(r1).b(r2).a();
    }

    public final void setDateSelected(CalendarDay r1, boolean r2) {
        this.calendarView.a(r1, r2);
    }

    public final void setDateTextAppearance(int r1) {
        this.calendarView.setDateTextAppearance(r1);
    }

    public final void setDayFormatter(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin");
        this.calendarView.setDayFormatter(r4);
    }

    public final void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin");
        this.calendarView.setDayFormatterContentDescription(r4);
    }

    public final void setDynamicHeightEnabled(boolean r1) {
        this.calendarView.setDynamicHeightEnabled(r1);
    }

    public final void setFirstDayOfWeek(DayOfWeek r2) {
        Intrinsics.checkNotNullParameter(r2, "firstDayOfWeek");
        switch(b.f13423b[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        org.threeten.bp.DayOfWeek r3 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        this.calendarView.l().a().a(r3).a();
        return;
    L7:
        r3 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r3 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r3 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r3 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r3 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r3 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void setMaximumDate(CalendarDay r1) {
        this.calendarView.l().a().b(r1).a();
    }

    public final void setMinimumDate(CalendarDay r1) {
        this.calendarView.l().a().a(r1).a();
    }

    public final void setOnDateChangedListener(Function1<? super Long, Unit> r3) {
        this.onDateChangedListener = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setOnDateLongClickListener(Function1<? super Long, Unit> r3) {
        this.onDateLongClickListener = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setOnMonthChangedListener(Function1<? super Long, Unit> r3) {
        this.onMonthChangedListener = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setOnRangeSelectedListener(Function1<? super List<Long>, Unit> r3) {
        this.onRangeSelectedListener = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setOutOfMonthVisibility(OutOfMonthVisibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        this.outOfMonthVisibility = r2;
        applyOutOfMonthVisibility();
    }

    public final void setPagingEnabled(boolean r1) {
        this.calendarView.setPagingEnabled(r1);
    }

    public final void setSelectedDate(CalendarDay r1) {
        this.calendarView.setSelectedDate(r1);
    }

    public final void setSelectionColor(int r1) {
        this.calendarView.setSelectionColor(r1);
    }

    public final void setSelectionMode(int r1) {
        this.calendarView.setSelectionMode(r1);
    }

    public final void setShowOtherDates(int r1) {
        this.calendarView.setShowOtherDates(r1);
    }

    public final void setShowWeekDays(boolean r1) {
        this.calendarView.l().a().a(r1).a();
    }

    public final void setTileHSpacing(int r1) {
        this.calendarView.setTileHSpacing(r1);
    }

    public final void setTileHeight(int r1) {
        this.calendarView.setTileHeight(r1);
    }

    public final void setTileHeightDp(int r1) {
        this.calendarView.setTileHeightDp(r1);
    }

    public final void setTileSize(int r1) {
        this.calendarView.setTileSize(r1);
    }

    public final void setTileSizeDp(int r1) {
        this.calendarView.setTileSizeDp(r1);
    }

    public final void setTileVSpacing(int r1) {
        this.calendarView.setTileVSpacing(r1);
    }

    public final void setTileWidth(int r1) {
        this.calendarView.setTileWidth(r1);
    }

    public final void setTileWidthDp(int r1) {
        this.calendarView.setTileWidthDp(r1);
    }

    public final void setWeekDayFormatter(com.obric.oui.calendar.a.h r3) {
        com.obric.oui.calendar.a.h r4 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.memorydata.plugin");
        this.calendarView.setWeekDayFormatter(r4);
    }

    public final void setWeekDayLabels(int r1) {
        this.calendarView.setWeekDayLabels(r1);
    }

    public final void setWeekDayLabels(CharSequence[] r2) {
        Intrinsics.checkNotNullParameter(r2, "weekDayLabels");
        this.calendarView.setWeekDayLabels(r2);
    }

    public final void setWeekDayTextAppearance(int r1) {
        this.calendarView.setWeekDayTextAppearance(r1);
    }

    public final void setWeekDaysHeight(int r1) {
        this.calendarView.setWeekDaysHeight(r1);
    }

    public final void setWeekDaysHeightDp(int r1) {
        this.calendarView.setWeekDaysHeightDp(r1);
    }
}
