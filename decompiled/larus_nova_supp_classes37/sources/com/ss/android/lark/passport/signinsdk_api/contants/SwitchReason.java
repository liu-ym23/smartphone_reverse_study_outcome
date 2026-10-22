package com.ss.android.lark.passport.signinsdk_api.contants;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u0001:\t\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\t\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "Ljava/io/Serializable;", "value", "", "desc", "", "<init>", "(ILjava/lang/String;)V", "getValue", "()I", "getDesc", "()Ljava/lang/String;", "isActiveReason", "", "toString", "Unknown", "SessionInvalid", "Logout", "EnterApp", "Applink", "OperationCenter", "LogoutWithoutIntercept", "LogoutWithoutInterceptAndAnimation", "Companion", "Lcom/ss/android/lark/passport/signinsdk_api/contants/ExternalSwitchReason;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$Applink;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$EnterApp;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$Logout;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$LogoutWithoutIntercept;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$LogoutWithoutInterceptAndAnimation;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$OperationCenter;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$SessionInvalid;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$Unknown;", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class SwitchReason implements Serializable {
    public static final int APPLINK = 5;
    public static final a Companion = null;
    public static final int OPERATION_CENTER = 7;
    public static final Set<Integer> a = null;
    private final String desc;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$Applink;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Applink extends SwitchReason {
        public static final Applink INSTANCE = null;

        static {
            INSTANCE = new Applink();
        }

        private Applink() {
            super(5, "applink", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$EnterApp;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class EnterApp extends SwitchReason {
        public static final EnterApp INSTANCE = null;

        static {
            INSTANCE = new EnterApp();
        }

        private EnterApp() {
            super(3, "enter_app", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$Logout;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Logout extends SwitchReason {
        public static final Logout INSTANCE = null;

        static {
            INSTANCE = new Logout();
        }

        private Logout() {
            super(2, "logout", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$LogoutWithoutIntercept;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class LogoutWithoutIntercept extends SwitchReason {
        public static final LogoutWithoutIntercept INSTANCE = null;

        static {
            INSTANCE = new LogoutWithoutIntercept();
        }

        private LogoutWithoutIntercept() {
            super(8, "LogoutWithoutIntercept", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$LogoutWithoutInterceptAndAnimation;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class LogoutWithoutInterceptAndAnimation extends SwitchReason {
        public static final LogoutWithoutInterceptAndAnimation INSTANCE = null;

        static {
            INSTANCE = new LogoutWithoutInterceptAndAnimation();
        }

        private LogoutWithoutInterceptAndAnimation() {
            super(9, "LogoutWithoutInterceptAndAnimation", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$OperationCenter;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class OperationCenter extends SwitchReason {
        public static final OperationCenter INSTANCE = null;

        static {
            INSTANCE = new OperationCenter();
        }

        private OperationCenter() {
            super(7, "operation_center", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$SessionInvalid;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class SessionInvalid extends SwitchReason {
        public static final SessionInvalid INSTANCE = null;

        static {
            INSTANCE = new SessionInvalid();
        }

        private SessionInvalid() {
            super(1, "session_invalid", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason$Unknown;", "Lcom/ss/android/lark/passport/signinsdk_api/contants/SwitchReason;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Unknown extends SwitchReason {
        public static final Unknown INSTANCE = null;

        static {
            INSTANCE = new Unknown();
        }

        private Unknown() {
            super(0, "unknown", null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        a = SetsKt.setOf(new Integer[]{5, 7});
    }

    public final boolean isActiveReason() {
        if (a.contains(Integer.valueOf(this.value)) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof ExternalSwitchReason) == true) goto L8;
        return false;
    }

    public String toString() {
        return "SwitchReason(" + this.value + ',' + this.desc + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public SwitchReason(int r1, String r2, DefaultConstructorMarker r3) {
        this.value = r1;
        this.desc = r2;
    }
}
