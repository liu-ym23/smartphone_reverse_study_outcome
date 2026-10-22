package com.larus.bmhome;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/SideBarPage;", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface SideBarPage {
    public static final int APP_SETTING = 7;
    public static final int BOT_DISCOVER = 2;
    public static final int CASE_DETAIL = 12;
    public static final int CASE_LIST = 11;
    public static final int CASE_LIST_MORE = 13;
    public static final int CHAT = 1;
    public static final int CHAT_DOUBLE_TAB = 10;
    public static final int CHAT_IMMERS = 8;
    public static final int CHAT_JOB = 21;
    public static final int CHAT_MULTI_TAB = 15;
    public static final int COMMUNITY_CREATE = 3;
    public static final a Companion = null;
    public static final int DRIVE_LIST = 16;
    public static final int LARK_ADDRESS_BOOK = 18;
    public static final int LARK_CHAT = 19;
    public static final int LARK_SOCIAL_IM = 17;
    public static final int MULTI_TASK_MANAGE = 22;
    public static final int NOTIFY = 6;
    public static final int PROFILE_MINE = 5;
    public static final int RICH_CONTENT_FEED = 4;
    public static final int SKILL_MANAGEMENT = 20;
    public static final int UNKNOWN = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static boolean a(Integer r2) {
            if (r2 != null) goto L5;
        L6:
            if (r2 != null) goto L9;
        L10:
            if (r2 != null) goto L13;
        L15:
            return false;
        L13:
            if (r2.intValue() != 12) goto L15;
        L16:
            return true;
        L9:
            if (r2.intValue() == 13) goto L16;
        L5:
            if (r2.intValue() == 11) goto L16;
            goto L6
        }

        public static boolean b(Integer r1) {
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.intValue() != 12) goto L7;
            return true;
        }

        public static boolean c(Integer r3) {
            if (r3 != null) goto L6;
        L7:
            if (r3 != null) goto L10;
        L11:
            if (r3 != null) goto L14;
        L15:
            if (r3 != null) goto L18;
        L20:
            return false;
        L18:
            if (r3.intValue() != 15) goto L20;
            return true;
        L14:
            if (r3.intValue() != 10) goto L15;
            return true;
        L10:
            if (r3.intValue() != 8) goto L11;
            return true;
        L6:
            if (r3.intValue() != 1) goto L7;
            return true;
        }
    }

    static {
        Companion = a.a;
    }
}
