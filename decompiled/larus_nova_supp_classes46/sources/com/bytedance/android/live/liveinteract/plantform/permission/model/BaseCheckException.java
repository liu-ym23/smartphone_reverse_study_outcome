package com.bytedance.android.live.liveinteract.plantform.permission.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0017B3\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\nH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "linkType", "", "operateType", "Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "checkType", "Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;", "detailMessage", "", "throwable", "", "(ILcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCheckType", "()Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;", "getDetailMessage", "()Ljava/lang/String;", "getLinkType", "()I", "getOperateType", "()Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "toString", "CheckType", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseCheckException extends RuntimeException {
    private final CheckType checkType;
    private final String detailMessage;
    private final int linkType;
    private final OperateType operateType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/model/BaseCheckException$CheckType;", "", "", "checkTypeStr", "Ljava/lang/String;", "getCheckTypeStr", "()Ljava/lang/String;", "Login", "HostOperate", "AndroidPermission", "VideoShortPlugin", "InteractPlugin", "BroadcastPlugin", "ServerPermission", "Shield", "DeviceSupported", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum CheckType extends Enum<CheckType> {
        public static final CheckType AndroidPermission = null;
        public static final CheckType BroadcastPlugin = null;
        public static final CheckType DeviceSupported = null;
        public static final CheckType HostOperate = null;
        public static final CheckType InteractPlugin = null;
        public static final CheckType Login = null;
        public static final CheckType ServerPermission = null;
        public static final CheckType Shield = null;
        public static final CheckType VideoShortPlugin = null;
        public static final /* synthetic */ CheckType[] a = null;
        private final String checkTypeStr;

        public static CheckType valueOf(String r1) {
            return (CheckType) a.a(CheckType.class, r1);
        }

        public static CheckType[] values() {
            return (CheckType[]) a.clone();
        }

        static {
            CheckType r1 = new CheckType("Login", 0, "login");
            Login = r1;
            CheckType r2 = new CheckType("HostOperate", 1, "host_operate");
            HostOperate = r2;
            CheckType r3 = new CheckType("AndroidPermission", 2, "android_permission");
            AndroidPermission = r3;
            CheckType r4 = new CheckType("VideoShortPlugin", 3, "video_short_plugin");
            VideoShortPlugin = r4;
            CheckType r5 = new CheckType("InteractPlugin", 4, "interact_plugin");
            InteractPlugin = r5;
            CheckType r6 = new CheckType("BroadcastPlugin", 5, "broadcast_plugin");
            BroadcastPlugin = r6;
            CheckType r7 = new CheckType("ServerPermission", 6, "server_permission");
            ServerPermission = r7;
            CheckType r8 = new CheckType("Shield", 7, "shield");
            Shield = r8;
            CheckType r9 = new CheckType("DeviceSupported", 8, "device_supported");
            DeviceSupported = r9;
            a = new CheckType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }

        public final String getCheckTypeStr() {
            return this.checkTypeStr;
        }

        public CheckType(String r1, int r2, String r3) {
            super(r1, r2);
            this.checkTypeStr = r3;
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseCheckException(linkType=" + this.linkType + ", operateType=" + this.operateType + ", checkType=" + this.checkType + ", detailMessage='" + this.detailMessage + "')";
    }

    public final CheckType getCheckType() {
        return this.checkType;
    }

    public final String getDetailMessage() {
        return this.detailMessage;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final OperateType getOperateType() {
        return this.operateType;
    }

    public BaseCheckException(int r2, OperateType r3, CheckType r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r3, "operateType");
        Intrinsics.checkNotNullParameter(r4, "checkType");
        Intrinsics.checkNotNullParameter(r5, "detailMessage");
        super(r5, r6);
        this.linkType = r2;
        this.operateType = r3;
        this.checkType = r4;
        this.detailMessage = r5;
    }

    public /* synthetic */ BaseCheckException(int r7, OperateType r8, CheckType r9, String r10, Throwable r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
