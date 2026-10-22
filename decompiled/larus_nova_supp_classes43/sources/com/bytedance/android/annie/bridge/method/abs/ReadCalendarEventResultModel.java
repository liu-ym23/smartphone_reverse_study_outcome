package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b9\u0010:R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR$\u00103\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR$\u00106\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019¨\u0006<"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReadCalendarEventResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/abs/ReadCalendarEventResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/abs/ReadCalendarEventResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/abs/ReadCalendarEventResultModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/method/abs/ReadCalendarEventResultModel$Code;)V", "", "startDate", "Ljava/lang/Number;", "getStartDate", "()Ljava/lang/Number;", "g", "(Ljava/lang/Number;)V", "endDate", "getEndDate", "c", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "notes", "getNotes", "f", a.KEY_URL, "getUrl", "i", a.KEY_LOCATION, "getLocation", "d", "alarmOffset", "getAlarmOffset", "a", "", "allDay", "Ljava/lang/Boolean;", "getAllDay", "()Ljava/lang/Boolean;", "setAllDay", "(Ljava/lang/Boolean;)V", "repeatFrequency", "getRepeatFrequency", "setRepeatFrequency", "repeatInterval", "getRepeatInterval", "setRepeatInterval", "repeatCount", "getRepeatCount", "setRepeatCount", MessageIndication.MESSAGE_TYPE_MSG, "getMsg", "e", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class ReadCalendarEventResultModel implements k0 {

    @SerializedName("alarmOffset")
    private Number alarmOffset;

    @SerializedName("allDay")
    private Boolean allDay;

    @SerializedName("code")
    private Code code;

    @SerializedName("endDate")
    private Number endDate;

    @SerializedName(a.KEY_LOCATION)
    private String location;

    @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
    private String msg;

    @SerializedName("notes")
    private String notes;

    @SerializedName("repeatCount")
    private Number repeatCount;

    @SerializedName("repeatFrequency")
    private String repeatFrequency;

    @SerializedName("repeatInterval")
    private Number repeatInterval;

    @SerializedName("startDate")
    private Number startDate;

    @SerializedName("title")
    private String title;

    @SerializedName(a.KEY_URL)
    private String url;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReadCalendarEventResultModel$Code;", "", "Le7/j0;", "", "getCode", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "Success", "Failed", "NoPermission", "InvalidParam", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code InvalidParam = null;
        public static final Code NoPermission = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        public static Code valueOf(String r1) {
            return (Code) r27.a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        static {
            Code r0 = new Code("Success", 0, 1);
            Success = r0;
            Code r1 = new Code("Failed", 1, 0);
            Failed = r1;
            Code r10 = new Code("NoPermission", 2, 2);
            NoPermission = r10;
            Code r11 = new Code("InvalidParam", 3, -3);
            InvalidParam = r11;
            a = new Code[]{r0, r1, r10, r11};
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r10, int r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public ReadCalendarEventResultModel() {
    }

    public final void a(Number r1) {
        this.alarmOffset = r1;
    }

    public final void b(Code r1) {
        this.code = r1;
    }

    public final void c(Number r1) {
        this.endDate = r1;
    }

    public final void d(String r1) {
        this.location = r1;
    }

    public final void e(String r1) {
        this.msg = r1;
    }

    public final void f(String r1) {
        this.notes = r1;
    }

    public final void g(Number r1) {
        this.startDate = r1;
    }

    public final void h(String r1) {
        this.title = r1;
    }

    public final void i(String r1) {
        this.url = r1;
    }
}
