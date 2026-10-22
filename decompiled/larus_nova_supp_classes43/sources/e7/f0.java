package e7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00100\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010!\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R$\u00103\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010!\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%¨\u00068"}, d2 = {"Le7/f0;", "", "", "identifier", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "", "startDate", "Ljava/lang/Long;", "i", "()Ljava/lang/Long;", "setStartDate", "(Ljava/lang/Long;)V", "endDate", "c", "setEndDate", "title", "j", "setTitle", "notes", "e", "setNotes", com.bytedance.android.ec.core.event.a.KEY_URL, "k", "setUrl", com.bytedance.android.ec.core.event.a.KEY_LOCATION, "d", "setLocation", "", "alarmOffset", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setAlarmOffset", "(Ljava/lang/Integer;)V", "", "allDay", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setAllDay", "(Ljava/lang/Boolean;)V", "repeatFrequency", "g", "setRepeatFrequency", "repeatInterval", "h", "setRepeatInterval", "repeatCount", "f", "setRepeatCount", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class f0 {

    @SerializedName("alarmOffset")
    private Integer alarmOffset;

    @SerializedName("allDay")
    private Boolean allDay;

    @SerializedName("endDate")
    private Long endDate;

    @SerializedName("identifier")
    private String identifier;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LOCATION)
    private String location;

    @SerializedName("notes")
    private String notes;

    @SerializedName("repeatCount")
    private Integer repeatCount;

    @SerializedName("repeatFrequency")
    private String repeatFrequency;

    @SerializedName("repeatInterval")
    private Integer repeatInterval;

    @SerializedName("startDate")
    private Long startDate;

    @SerializedName("title")
    private String title;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    public f0() {
    }

    public final Integer a() {
        return this.alarmOffset;
    }

    public final Boolean b() {
        return this.allDay;
    }

    public final Long c() {
        return this.endDate;
    }

    public final String d() {
        return this.location;
    }

    public final String e() {
        return this.notes;
    }

    public final Integer f() {
        return this.repeatCount;
    }

    public final String g() {
        return this.repeatFrequency;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Integer h() {
        return this.repeatInterval;
    }

    public final Long i() {
        return this.startDate;
    }

    public final String j() {
        return this.title;
    }

    public final String k() {
        return this.url;
    }
}
