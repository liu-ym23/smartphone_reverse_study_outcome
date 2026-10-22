package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0006LMNOPQBa\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0012HÆ\u0003Jc\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010E\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020KHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006R"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "timeZoneType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;", "formatType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;", "timePrecisionType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;", "timeStyle", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;", "datePrecisionType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;", "dateStatusType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;", "startTimeStamp", BuildConfig.FLAVOR, "endTimeStamp", "enableGmt", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;JJZ)V", "getTimeZoneType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;", "setTimeZoneType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;)V", "getFormatType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;", "setFormatType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;)V", "getTimePrecisionType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;", "setTimePrecisionType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;)V", "getTimeStyle", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;", "setTimeStyle", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;)V", "getDatePrecisionType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;", "setDatePrecisionType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;)V", "getDateStatusType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;", "setDateStatusType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;)V", "getStartTimeStamp", "()J", "setStartTimeStamp", "(J)V", "getEndTimeStamp", "setEndTimeStamp", "getEnableGmt", "()Z", "setEnableGmt", "(Z)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "TimeZoneType", "FormatType", "TimePrecisionType", "TimeStyle", "DatePrecisionType", "DateStatusType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeZoneProperty extends BaseProperty {
    private DatePrecisionType datePrecisionType;
    private DateStatusType dateStatusType;
    private boolean enableGmt;
    private long endTimeStamp;
    private FormatType formatType;
    private long startTimeStamp;
    private TimePrecisionType timePrecisionType;
    private TimeStyle timeStyle;
    private TimeZoneType timeZoneType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DAY_TYPE", "MONTH_TYPE", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DatePrecisionType extends Enum<DatePrecisionType> {
        public static final a Companion = null;
        public static final DatePrecisionType DAY_TYPE = null;
        public static final DatePrecisionType MONTH_TYPE = null;
        public static final /* synthetic */ DatePrecisionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DatePrecisionType> getEntries() {
            return b;
        }

        static {
            DatePrecisionType r0 = new DatePrecisionType("DAY_TYPE", 0, 0);
            DAY_TYPE = r0;
            DatePrecisionType r1 = new DatePrecisionType("MONTH_TYPE", 1, 1);
            MONTH_TYPE = r1;
            DatePrecisionType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static DatePrecisionType[] values() {
            return (DatePrecisionType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static DatePrecisionType valueOf(String r1) {
            return (DatePrecisionType) r27.a.a(DatePrecisionType.class, r1);
        }

        public DatePrecisionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ABSOLUTE", "RELATIVE", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DateStatusType extends Enum<DateStatusType> {
        public static final DateStatusType ABSOLUTE = null;
        public static final a Companion = null;
        public static final DateStatusType RELATIVE = null;
        public static final /* synthetic */ DateStatusType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DateStatusType> getEntries() {
            return b;
        }

        static {
            DateStatusType r0 = new DateStatusType("ABSOLUTE", 0, 0);
            ABSOLUTE = r0;
            DateStatusType r1 = new DateStatusType("RELATIVE", 1, 1);
            RELATIVE = r1;
            DateStatusType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static DateStatusType[] values() {
            return (DateStatusType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static DateStatusType valueOf(String r1) {
            return (DateStatusType) r27.a.a(DateStatusType.class, r1);
        }

        public DateStatusType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SHORT", "LONG", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FormatType extends Enum<FormatType> {
        public static final a Companion = null;
        public static final FormatType LONG = null;
        public static final FormatType SHORT = null;
        public static final /* synthetic */ FormatType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FormatType> getEntries() {
            return b;
        }

        static {
            FormatType r0 = new FormatType("SHORT", 0, 0);
            SHORT = r0;
            FormatType r1 = new FormatType("LONG", 1, 1);
            LONG = r1;
            FormatType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
        }

        public static FormatType[] values() {
            return (FormatType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static FormatType valueOf(String r1) {
            return (FormatType) r27.a.a(FormatType.class, r1);
        }

        public FormatType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SECOND", "MINUTE", "HOUR", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimePrecisionType extends Enum<TimePrecisionType> {
        public static final a Companion = null;
        public static final TimePrecisionType HOUR = null;
        public static final TimePrecisionType MINUTE = null;
        public static final TimePrecisionType SECOND = null;
        public static final /* synthetic */ TimePrecisionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TimePrecisionType> getEntries() {
            return b;
        }

        static {
            TimePrecisionType r0 = new TimePrecisionType("SECOND", 0, 0);
            SECOND = r0;
            TimePrecisionType r1 = new TimePrecisionType("MINUTE", 1, 1);
            MINUTE = r1;
            TimePrecisionType r3 = new TimePrecisionType("HOUR", 2, 2);
            HOUR = r3;
            TimePrecisionType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static TimePrecisionType[] values() {
            return (TimePrecisionType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static TimePrecisionType valueOf(String r1) {
            return (TimePrecisionType) r27.a.a(TimePrecisionType.class, r1);
        }

        public TimePrecisionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "BY_12_HOUR", "BY_24_HOUR", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeStyle extends Enum<TimeStyle> {
        public static final TimeStyle BY_12_HOUR = null;
        public static final TimeStyle BY_24_HOUR = null;
        public static final a Companion = null;
        public static final TimeStyle DEFAULT = null;
        public static final /* synthetic */ TimeStyle[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TimeStyle> getEntries() {
            return b;
        }

        static {
            TimeStyle r0 = new TimeStyle("DEFAULT", 0, 0);
            DEFAULT = r0;
            TimeStyle r1 = new TimeStyle("BY_12_HOUR", 1, 1);
            BY_12_HOUR = r1;
            TimeStyle r3 = new TimeStyle("BY_24_HOUR", 2, 2);
            BY_24_HOUR = r3;
            TimeStyle[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static TimeStyle[] values() {
            return (TimeStyle[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static TimeStyle valueOf(String r1) {
            return (TimeStyle) r27.a.a(TimeStyle.class, r1);
        }

        public TimeStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MERIDIEM", "WEEK", "MONTH", "TIME", "DATE", "FULL_DATE", "DATE_TIME", "FULL_DATE_TIME", "DATE_RANGE", "DATE_TIME_RANGE", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeZoneType extends Enum<TimeZoneType> {
        public static final a Companion = null;
        public static final TimeZoneType DATE = null;
        public static final TimeZoneType DATE_RANGE = null;
        public static final TimeZoneType DATE_TIME = null;
        public static final TimeZoneType DATE_TIME_RANGE = null;
        public static final TimeZoneType FULL_DATE = null;
        public static final TimeZoneType FULL_DATE_TIME = null;
        public static final TimeZoneType MERIDIEM = null;
        public static final TimeZoneType MONTH = null;
        public static final TimeZoneType TIME = null;
        public static final TimeZoneType WEEK = null;
        public static final /* synthetic */ TimeZoneType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static TimeZoneType a(int r0) {
                switch(r0) {
                    case 0: goto L14;
                    case 1: goto L24;
                    case 2: goto L23;
                    case 3: goto L22;
                    case 4: goto L21;
                    case 5: goto L20;
                    case 6: goto L19;
                    case 7: goto L18;
                    case 8: goto L17;
                    case 9: goto L16;
                    default: goto L15;
                };
            L15:
                return TimeZoneType.FULL_DATE_TIME;
            L16:
                return TimeZoneType.DATE_TIME_RANGE;
            L17:
                return TimeZoneType.DATE_RANGE;
            L18:
                return TimeZoneType.FULL_DATE_TIME;
            L19:
                return TimeZoneType.DATE_TIME;
            L20:
                return TimeZoneType.FULL_DATE;
            L21:
                return TimeZoneType.DATE;
            L22:
                return TimeZoneType.TIME;
            L23:
                return TimeZoneType.MONTH;
            L24:
                return TimeZoneType.WEEK;
            L14:
                return TimeZoneType.MERIDIEM;
            }
        }

        public static EnumEntries<TimeZoneType> getEntries() {
            return b;
        }

        static {
            TimeZoneType r0 = new TimeZoneType("MERIDIEM", 0, 0);
            MERIDIEM = r0;
            TimeZoneType r1 = new TimeZoneType("WEEK", 1, 1);
            WEEK = r1;
            TimeZoneType r3 = new TimeZoneType("MONTH", 2, 2);
            MONTH = r3;
            TimeZoneType r5 = new TimeZoneType("TIME", 3, 3);
            TIME = r5;
            TimeZoneType r7 = new TimeZoneType("DATE", 4, 4);
            DATE = r7;
            TimeZoneType r9 = new TimeZoneType("FULL_DATE", 5, 5);
            FULL_DATE = r9;
            TimeZoneType r11 = new TimeZoneType("DATE_TIME", 6, 6);
            DATE_TIME = r11;
            TimeZoneType r13 = new TimeZoneType("FULL_DATE_TIME", 7, 7);
            FULL_DATE_TIME = r13;
            TimeZoneType r15 = new TimeZoneType("DATE_RANGE", 8, 8);
            DATE_RANGE = r15;
            TimeZoneType r14 = new TimeZoneType("DATE_TIME_RANGE", 9, 9);
            DATE_TIME_RANGE = r14;
            TimeZoneType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
            Companion = new a();
        }

        public static TimeZoneType[] values() {
            return (TimeZoneType[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static TimeZoneType valueOf(String r1) {
            return (TimeZoneType) r27.a.a(TimeZoneType.class, r1);
        }

        public TimeZoneType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public TimeZoneProperty() {
        this(null, null, null, null, null, null, 0, 0, false, 511, null);
    }

    public static /* synthetic */ TimeZoneProperty copy$default(TimeZoneProperty r12, TimeZoneType r13, FormatType r14, TimePrecisionType r15, TimeStyle r16, DatePrecisionType r17, DateStatusType r18, long r19, long r21, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        TimeZoneType r2 = r12.timeZoneType;
    L7:
        if ((r24 & 2) == 0) goto L9;
        FormatType r3 = r12.formatType;
    L11:
        if ((r24 & 4) == 0) goto L13;
        TimePrecisionType r4 = r12.timePrecisionType;
    L15:
        if ((r24 & 8) == 0) goto L17;
        TimeStyle r5 = r12.timeStyle;
    L19:
        if ((r24 & 16) == 0) goto L21;
        DatePrecisionType r6 = r12.datePrecisionType;
    L23:
        if ((r24 & 32) == 0) goto L25;
        DateStatusType r7 = r12.dateStatusType;
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r8 = r12.startTimeStamp;
    L31:
        if ((r24 & 128) == 0) goto L33;
        long r10 = r12.endTimeStamp;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r1 = r12.enableGmt;
    L39:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r10, r1);
    L37:
        r1 = r23;
        goto L39
    L33:
        r10 = r21;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final TimeZoneType component1() {
        return this.timeZoneType;
    }

    public final FormatType component2() {
        return this.formatType;
    }

    public final TimePrecisionType component3() {
        return this.timePrecisionType;
    }

    public final TimeStyle component4() {
        return this.timeStyle;
    }

    public final DatePrecisionType component5() {
        return this.datePrecisionType;
    }

    public final DateStatusType component6() {
        return this.dateStatusType;
    }

    public final long component7() {
        return this.startTimeStamp;
    }

    public final long component8() {
        return this.endTimeStamp;
    }

    public final boolean component9() {
        return this.enableGmt;
    }

    public final TimeZoneProperty copy(TimeZoneType r14, FormatType r15, TimePrecisionType r16, TimeStyle r17, DatePrecisionType r18, DateStatusType r19, long r20, long r22, boolean r24) {
        Intrinsics.checkNotNullParameter(r14, "timeZoneType");
        Intrinsics.checkNotNullParameter(r15, "formatType");
        Intrinsics.checkNotNullParameter(r16, "timePrecisionType");
        Intrinsics.checkNotNullParameter(r17, "timeStyle");
        Intrinsics.checkNotNullParameter(r18, "datePrecisionType");
        Intrinsics.checkNotNullParameter(r19, "dateStatusType");
        return new TimeZoneProperty(r14, r15, r16, r17, r18, r19, r20, r22, r24);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TimeZoneProperty) == true) goto L8;
        return false;
    L8:
        TimeZoneProperty r9 = (TimeZoneProperty) r8;
        if (this.timeZoneType == r9.timeZoneType) goto L12;
        return false;
    L12:
        if (this.formatType == r9.formatType) goto L15;
        return false;
    L15:
        if (this.timePrecisionType == r9.timePrecisionType) goto L18;
        return false;
    L18:
        if (this.timeStyle == r9.timeStyle) goto L21;
        return false;
    L21:
        if (this.datePrecisionType == r9.datePrecisionType) goto L24;
        return false;
    L24:
        if (this.dateStatusType == r9.dateStatusType) goto L27;
        return false;
    L27:
        if (this.startTimeStamp == r9.startTimeStamp) goto L30;
        return false;
    L30:
        if (this.endTimeStamp == r9.endTimeStamp) goto L33;
        return false;
    L33:
        if (this.enableGmt == r9.enableGmt) goto L35;
        return false;
    L35:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = ((((((((((this.timeZoneType.hashCode() * 31) + this.formatType.hashCode()) * 31) + this.timePrecisionType.hashCode()) * 31) + this.timeStyle.hashCode()) * 31) + this.datePrecisionType.hashCode()) * 31) + this.dateStatusType.hashCode()) * 31;
        long r1 = this.startTimeStamp;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.endTimeStamp;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.enableGmt == false) goto L5;
        int r5 = 1231;
    L7:
        return r4 + r5;
    L5:
        r5 = 1237;
        goto L7
    }

    public String toString() {
        return "TimeZoneProperty(timeZoneType=" + this.timeZoneType + ", formatType=" + this.formatType + ", timePrecisionType=" + this.timePrecisionType + ", timeStyle=" + this.timeStyle + ", datePrecisionType=" + this.datePrecisionType + ", dateStatusType=" + this.dateStatusType + ", startTimeStamp=" + this.startTimeStamp + ", endTimeStamp=" + this.endTimeStamp + ", enableGmt=" + this.enableGmt + ')';
    }

    public final DatePrecisionType getDatePrecisionType() {
        return this.datePrecisionType;
    }

    public final DateStatusType getDateStatusType() {
        return this.dateStatusType;
    }

    public final boolean getEnableGmt() {
        return this.enableGmt;
    }

    public final long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public final FormatType getFormatType() {
        return this.formatType;
    }

    public final long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public final TimePrecisionType getTimePrecisionType() {
        return this.timePrecisionType;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final TimeZoneType getTimeZoneType() {
        return this.timeZoneType;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r8 = r7.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L115;
        Map.Entry<Integer, PreviewData> r0 = r8.next();
        int r1 = r0.getKey().intValue();
        if (r1 == ComponentAttribute.time_zone_type.getValue()) goto L9;
        boolean r3 = true;
        if (r1 == ComponentAttribute.format_type.getValue()) goto L18;
        if (r1 == ComponentAttribute.time_precision_type.getValue()) goto L33;
        int r5 = 0;
        if (r1 == ComponentAttribute.time_style.getValue()) goto L50;
        if (r1 == ComponentAttribute.date_precision_type.getValue()) goto L64;
        if (r1 == ComponentAttribute.date_status_type.getValue()) goto L78;
        long r4 = 0;
        if (r1 == ComponentAttribute.start_time_stamp.getValue()) goto L93;
        if (r1 == ComponentAttribute.end_time_stamp.getValue()) goto L101;
        if (r1 != ComponentAttribute.enable_gmt.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L114;
        Boolean r6 = r2.getBoolean();
        if (r6 == null) goto L114;
        r3 = r6.booleanValue();
    L114:
        this.enableGmt = r3;
        goto L6
    L101:
        PreviewData r9 = r0.getValue();
        if (r9 == null) goto L106;
        Long r10 = r9.getLong();
        if (r10 == null) goto L106;
        r4 = r10.longValue();
    L106:
        this.endTimeStamp = r4;
        goto L6
    L93:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L98;
        Long r12 = r11.getLong();
        if (r12 == null) goto L98;
        r4 = r12.longValue();
    L98:
        this.startTimeStamp = r4;
        goto L6
    L78:
        DateStatusType.a r13 = DateStatusType.Companion;
        PreviewData r14 = r0.getValue();
        if (r14 == null) goto L83;
        Integer r15 = r14.getInt();
        if (r15 == null) goto L83;
        int r16 = r15.intValue();
    L84:
        r13.getClass();
        if (r16 == 0) goto L89;
        if (r16 == 1) goto L88;
        DateStatusType r17 = DateStatusType.RELATIVE;
    L90:
        this.dateStatusType = r17;
        goto L6
    L88:
        r17 = DateStatusType.RELATIVE;
        goto L90
    L89:
        r17 = DateStatusType.ABSOLUTE;
    L83:
        r16 = 1;
        goto L84
    L64:
        DatePrecisionType.a r18 = DatePrecisionType.Companion;
        PreviewData r19 = r0.getValue();
        if (r19 == null) goto L69;
        Integer r20 = r19.getInt();
        if (r20 == null) goto L69;
        r5 = r20.intValue();
    L69:
        r18.getClass();
        if (r5 == 0) goto L74;
        if (r5 == 1) goto L73;
        DatePrecisionType r21 = DatePrecisionType.DAY_TYPE;
    L75:
        this.datePrecisionType = r21;
        goto L6
    L73:
        r21 = DatePrecisionType.MONTH_TYPE;
        goto L75
    L74:
        r21 = DatePrecisionType.DAY_TYPE;
        goto L75
    L50:
        TimeStyle.a r22 = TimeStyle.Companion;
        PreviewData r23 = r0.getValue();
        if (r23 == null) goto L55;
        Integer r24 = r23.getInt();
        if (r24 == null) goto L55;
        r5 = r24.intValue();
    L55:
        r22.getClass();
        if (r5 == 1) goto L60;
        if (r5 == 2) goto L59;
        TimeStyle r25 = TimeStyle.DEFAULT;
    L61:
        this.timeStyle = r25;
        goto L6
    L59:
        r25 = TimeStyle.BY_24_HOUR;
        goto L61
    L60:
        r25 = TimeStyle.BY_12_HOUR;
        goto L61
    L33:
        TimePrecisionType.a r26 = TimePrecisionType.Companion;
        PreviewData r27 = r0.getValue();
        if (r27 == null) goto L38;
        Integer r28 = r27.getInt();
        if (r28 == null) goto L38;
        int r29 = r28.intValue();
    L39:
        r26.getClass();
        if (r29 == 0) goto L46;
        if (r29 == 1) goto L45;
        if (r29 == 2) goto L44;
        TimePrecisionType r30 = TimePrecisionType.MINUTE;
    L47:
        this.timePrecisionType = r30;
        goto L6
    L44:
        r30 = TimePrecisionType.HOUR;
        goto L47
    L45:
        r30 = TimePrecisionType.MINUTE;
        goto L47
    L46:
        r30 = TimePrecisionType.SECOND;
    L38:
        r29 = 1;
        goto L39
    L18:
        FormatType.a r31 = FormatType.Companion;
        PreviewData r32 = r0.getValue();
        if (r32 == null) goto L23;
        Integer r33 = r32.getInt();
        if (r33 == null) goto L23;
        int r34 = r33.intValue();
    L24:
        r31.getClass();
        if (r34 == 0) goto L29;
        if (r34 == 1) goto L28;
        FormatType r35 = FormatType.LONG;
    L30:
        this.formatType = r35;
        goto L6
    L28:
        r35 = FormatType.LONG;
        goto L30
    L29:
        r35 = FormatType.SHORT;
    L23:
        r34 = 1;
        goto L24
    L9:
        TimeZoneType.a r36 = TimeZoneType.Companion;
        PreviewData r37 = r0.getValue();
        if (r37 == null) goto L14;
        Integer r38 = r37.getInt();
        if (r38 == null) goto L14;
        int r39 = r38.intValue();
    L15:
        r36.getClass();
        this.timeZoneType = TimeZoneType.a.a(r39);
    L14:
        r39 = 7;
        goto L15
    }

    public final void setDatePrecisionType(DatePrecisionType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.datePrecisionType = r2;
    }

    public final void setDateStatusType(DateStatusType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dateStatusType = r2;
    }

    public final void setEnableGmt(boolean r1) {
        this.enableGmt = r1;
    }

    public final void setEndTimeStamp(long r1) {
        this.endTimeStamp = r1;
    }

    public final void setFormatType(FormatType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.formatType = r2;
    }

    public final void setStartTimeStamp(long r1) {
        this.startTimeStamp = r1;
    }

    public final void setTimePrecisionType(TimePrecisionType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timePrecisionType = r2;
    }

    public final void setTimeStyle(TimeStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timeStyle = r2;
    }

    public final void setTimeZoneType(TimeZoneType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timeZoneType = r2;
    }

    public TimeZoneProperty(TimeZoneType r2, FormatType r3, TimePrecisionType r4, TimeStyle r5, DatePrecisionType r6, DateStatusType r7, long r8, long r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "timeZoneType");
        Intrinsics.checkNotNullParameter(r3, "formatType");
        Intrinsics.checkNotNullParameter(r4, "timePrecisionType");
        Intrinsics.checkNotNullParameter(r5, "timeStyle");
        Intrinsics.checkNotNullParameter(r6, "datePrecisionType");
        Intrinsics.checkNotNullParameter(r7, "dateStatusType");
        super(Type.TIME_ZONE);
        this.timeZoneType = r2;
        this.formatType = r3;
        this.timePrecisionType = r4;
        this.timeStyle = r5;
        this.datePrecisionType = r6;
        this.dateStatusType = r7;
        this.startTimeStamp = r8;
        this.endTimeStamp = r10;
        this.enableGmt = r12;
    }

    public /* synthetic */ TimeZoneProperty(TimeZoneType r13, FormatType r14, TimePrecisionType r15, TimeStyle r16, DatePrecisionType r17, DateStatusType r18, long r19, long r21, boolean r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        TimeZoneType r1 = TimeZoneType.FULL_DATE_TIME;
    L7:
        if ((r24 & 2) == 0) goto L9;
        FormatType r2 = FormatType.LONG;
    L11:
        if ((r24 & 4) == 0) goto L13;
        TimePrecisionType r3 = TimePrecisionType.MINUTE;
    L15:
        if ((r24 & 8) == 0) goto L17;
        TimeStyle r4 = TimeStyle.DEFAULT;
    L19:
        if ((r24 & 16) == 0) goto L21;
        DatePrecisionType r5 = DatePrecisionType.DAY_TYPE;
    L23:
        if ((r24 & 32) == 0) goto L25;
        DateStatusType r6 = DateStatusType.RELATIVE;
    L26:
        long r8 = 0;
        if ((r24 & 64) == 0) goto L29;
        long r10 = 0;
    L31:
        if ((r24 & 128) != 0) goto L35;
        r8 = r21;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r0 = true;
    L38:
        this(r1, r2, r3, r4, r5, r6, r10, r8, r0);
        return;
    L37:
        r0 = r23;
        goto L38
    L29:
        r10 = r19;
        goto L31
    L25:
        r6 = r18;
        goto L26
    L21:
        r5 = r17;
        goto L23
    L17:
        r4 = r16;
        goto L19
    L13:
        r3 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
