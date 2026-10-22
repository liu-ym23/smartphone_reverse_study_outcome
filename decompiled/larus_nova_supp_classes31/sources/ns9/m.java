package ns9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c\u0012\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\tHÆ\u0003J\u0013\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010M\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u00107J\u0019\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001cHÆ\u0003J\u0019\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001cHÆ\u0003J°\u0002\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t2\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c2\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001cHÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\u0003HÖ\u0001J\t\u0010V\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b5\u0010!R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:¨\u0006W"}, d2 = {"Lcom/larus/reach/api/ReachNotify;", "", "appId", "", "type", "", "pushId", "pushScene", "notificationGroup", "", "position", "reachTarget", "Lcom/larus/reach/api/ReachNotifyTarget;", "layout", "templateId", "title", "level", "desc", "iconUrl", "buttons", "Lcom/larus/reach/api/ReachNotifyButton;", "actions", "Lcom/larus/reach/api/ReachNotifyAction;", "dismissal", "priority", "duration", "", "passThrough", "", "extra", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/reach/api/ReachNotifyTarget;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)V", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "getPushId", "getPushScene", "getNotificationGroup", "()Ljava/util/List;", "getPosition", "getReachTarget", "()Lcom/larus/reach/api/ReachNotifyTarget;", "getLayout", "getTemplateId", "getTitle", "getLevel", "getDesc", "getIconUrl", "getButtons", "getActions", "getDismissal", "getPriority", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPassThrough", "()Ljava/util/Map;", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/reach/api/ReachNotifyTarget;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)Lcom/larus/reach/api/ReachNotify;", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class m {

    @SerializedName("actions")
    private final List<n> actions;

    @SerializedName("app_id")
    private final Integer appId;

    @SerializedName("buttons")
    private final List<o> buttons;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("dismissal")
    private final String dismissal;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("layout")
    private final Integer layout;

    @SerializedName("level")
    private final String level;

    @SerializedName("notification_group")
    private final List<Integer> notificationGroup;

    @SerializedName("pass_through")
    private final Map<String, String> passThrough;

    @SerializedName("position")
    private final String position;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("push_id")
    private final String pushId;

    @SerializedName("push_scene")
    private final String pushScene;

    @SerializedName("reach_target")
    private final q reachTarget;

    @SerializedName("template_id")
    private final String templateId;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final String type;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pushId, r6.pushId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pushScene, r6.pushScene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.notificationGroup, r6.notificationGroup) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reachTarget, r6.reachTarget) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.layout, r6.layout) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.templateId, r6.templateId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.level, r6.level) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.buttons, r6.buttons) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.dismissal, r6.dismissal) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.priority, r6.priority) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.passThrough, r6.passThrough) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.appId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.pushId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.pushScene;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<Integer> r13 = this.notificationGroup;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.position;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        q r19 = this.reachTarget;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.layout;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.templateId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.title;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.level;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.desc;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.iconUrl;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<o> r40 = this.buttons;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        List<n> r43 = this.actions;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.dismissal;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Integer r49 = this.priority;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Long r52 = this.duration;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Map<String, String> r55 = this.passThrough;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        Map<String, String> r58 = this.extra;
        if (r58 == null) goto L83;
        r1 = r58.hashCode();
    L83:
        return r57 + r1;
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
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
        return "ReachNotify(appId=" + this.appId + ", type=" + this.type + ", pushId=" + this.pushId + ", pushScene=" + this.pushScene + ", notificationGroup=" + this.notificationGroup + ", position=" + this.position + ", reachTarget=" + this.reachTarget + ", layout=" + this.layout + ", templateId=" + this.templateId + ", title=" + this.title + ", level=" + this.level + ", desc=" + this.desc + ", iconUrl=" + this.iconUrl + ", buttons=" + this.buttons + ", actions=" + this.actions + ", dismissal=" + this.dismissal + ", priority=" + this.priority + ", duration=" + this.duration + ", passThrough=" + this.passThrough + ", extra=" + this.extra + ')';
    }

    public m() {
        this.appId = null;
        this.type = null;
        this.pushId = null;
        this.pushScene = null;
        this.notificationGroup = null;
        this.position = null;
        this.reachTarget = null;
        this.layout = null;
        this.templateId = null;
        this.title = null;
        this.level = null;
        this.desc = null;
        this.iconUrl = null;
        this.buttons = null;
        this.actions = null;
        this.dismissal = null;
        this.priority = null;
        this.duration = null;
        this.passThrough = null;
        this.extra = null;
    }

    public final List<n> a() {
        return this.actions;
    }

    public final Integer b() {
        return this.appId;
    }

    public final List<o> c() {
        return this.buttons;
    }

    public final String d() {
        return this.desc;
    }

    public final String e() {
        return this.dismissal;
    }

    public final Long f() {
        return this.duration;
    }

    public final Map<String, String> g() {
        return this.extra;
    }

    public final String getType() {
        return this.type;
    }

    public final String h() {
        return this.iconUrl;
    }

    public final Integer i() {
        return this.layout;
    }

    public final String j() {
        return this.level;
    }

    public final List<Integer> k() {
        return this.notificationGroup;
    }

    public final Map<String, String> l() {
        return this.passThrough;
    }

    public final String m() {
        return this.position;
    }

    public final Integer n() {
        return this.priority;
    }

    public final String o() {
        return this.pushId;
    }

    public final String p() {
        return this.pushScene;
    }

    public final q q() {
        return this.reachTarget;
    }

    public final String r() {
        return this.templateId;
    }

    public final String s() {
        return this.title;
    }
}
