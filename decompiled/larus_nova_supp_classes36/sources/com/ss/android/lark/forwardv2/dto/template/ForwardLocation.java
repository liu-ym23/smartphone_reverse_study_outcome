package com.ss.android.lark.forwardv2.dto.template;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "OTHER", "FILE", "PIN", "CHAT", "IMAGE", "LOCATION", "FAVOURITE", "THREAD", "THREAD_DETAIL", "MSG_THREAD", "Companion", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ForwardLocation extends Enum<ForwardLocation> {
    public static final ForwardLocation CHAT = null;
    public static final a Companion = null;
    public static final ForwardLocation FAVOURITE = null;
    public static final ForwardLocation FILE = null;
    public static final ForwardLocation IMAGE = null;
    public static final ForwardLocation LOCATION = null;
    public static final ForwardLocation MSG_THREAD = null;
    public static final ForwardLocation OTHER = null;
    public static final ForwardLocation PIN = null;
    public static final ForwardLocation THREAD = null;
    public static final ForwardLocation THREAD_DETAIL = null;
    public static final /* synthetic */ ForwardLocation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ForwardLocation a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "value");
            switch(r1.hashCode()) {
                case -1442714871: goto L42;
                case -874443254: goto L38;
                case -855114483: goto L34;
                case -689102712: goto L30;
                case 110997: goto L26;
                case 3052376: goto L22;
                case 106069776: goto L18;
                case 1050790300: goto L14;
                case 1901043637: goto L10;
                case 2062274776: goto L6;
                default: goto L46;
            };
        L6:
            if (r1.equals("in_file_page") == false) goto L46;
            return ForwardLocation.FILE;
        L10:
            if (r1.equals("location") == false) goto L46;
            return ForwardLocation.LOCATION;
        L14:
            if (r1.equals("favorite") == false) goto L46;
            return ForwardLocation.FAVOURITE;
        L18:
            if (r1.equals(INotificationHitPoint.NoticeType.OTHER) == false) goto L46;
            return ForwardLocation.OTHER;
        L22:
            if (r1.equals("chat") == false) goto L46;
            return ForwardLocation.CHAT;
        L26:
            if (r1.equals("pin") == false) goto L46;
            return ForwardLocation.PIN;
        L30:
            if (r1.equals("msg_thread") == false) goto L46;
            return ForwardLocation.MSG_THREAD;
        L34:
            if (r1.equals("thread_details") == false) goto L46;
            return ForwardLocation.THREAD_DETAIL;
        L38:
            if (r1.equals(IOfflineExtraParser.ParserType.THREAD) == false) goto L46;
            return ForwardLocation.THREAD;
        L42:
            if (r1.equals("image_view") == false) goto L46;
            return ForwardLocation.IMAGE;
        L46:
            return ForwardLocation.OTHER;
        }
    }

    @JvmStatic
    public static final ForwardLocation forNumber(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<ForwardLocation> getEntries() {
        return b;
    }

    static {
        ForwardLocation r0 = new ForwardLocation("OTHER", 0, INotificationHitPoint.NoticeType.OTHER);
        OTHER = r0;
        ForwardLocation r1 = new ForwardLocation("FILE", 1, "in_file_page");
        FILE = r1;
        ForwardLocation r3 = new ForwardLocation("PIN", 2, "pin");
        PIN = r3;
        ForwardLocation r5 = new ForwardLocation("CHAT", 3, "chat");
        CHAT = r5;
        ForwardLocation r7 = new ForwardLocation("IMAGE", 4, "image_view");
        IMAGE = r7;
        ForwardLocation r9 = new ForwardLocation("LOCATION", 5, "location");
        LOCATION = r9;
        ForwardLocation r11 = new ForwardLocation("FAVOURITE", 6, "favorite");
        FAVOURITE = r11;
        ForwardLocation r13 = new ForwardLocation("THREAD", 7, IOfflineExtraParser.ParserType.THREAD);
        THREAD = r13;
        ForwardLocation r12 = new ForwardLocation("THREAD_DETAIL", 8, "thread_details");
        THREAD_DETAIL = r12;
        ForwardLocation r10 = new ForwardLocation("MSG_THREAD", 9, "msg_thread");
        MSG_THREAD = r10;
        ForwardLocation[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static ForwardLocation[] values() {
        return (ForwardLocation[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ForwardLocation valueOf(String r1) {
        return (ForwardLocation) r27.a.a(ForwardLocation.class, r1);
    }

    public final void setValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.value = r2;
    }

    public ForwardLocation(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
