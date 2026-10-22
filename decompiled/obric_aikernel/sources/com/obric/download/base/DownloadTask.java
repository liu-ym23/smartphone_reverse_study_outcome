package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0010\u0018\u0000 T2\u00020\u0001:\u0001UBõ\u0001\u0012\u0006\u00101\u001a\u00020\t\u0012\u0006\u0010/\u001a\u00020\t\u0012\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010?\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010-\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d\u0012\b\u00107\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010D\u001a\u00020\u0010\u0012\u0006\u00103\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\t\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0010\u0012\b\b\u0002\u0010K\u001a\u00020\u0004\u0012\b\u0010N\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010&\u001a\u00020\u0010¢\u0006\u0004\bQ\u0010RB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bQ\u0010SJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0017\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR'\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010(R\u0019\u0010)\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\rR\u001b\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\rR\u0019\u0010-\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014R\u0019\u0010/\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\rR\u0019\u00101\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\rR\u0019\u00103\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0018\u001a\u0004\b4\u0010\u001aR\u001b\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\rR\u001b\u00107\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\"\u00109\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0012\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010(R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0018\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010>R!\u0010@\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010D\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0012\u001a\u0004\bE\u0010\u0014R\u001b\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\"\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0018\u001a\u0004\bL\u0010\u001a\"\u0004\bM\u0010>R$\u0010N\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000f¨\u0006V"}, d2 = {"Lcom/obric/download/base/DownloadTask;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "hostPkgName", "Ljava/lang/String;", "getHostPkgName", "()Ljava/lang/String;", "setHostPkgName", "(Ljava/lang/String;)V", "", "showNotification", "Z", "getShowNotification", "()Z", "iconUrl", "getIconUrl", "retryCount", "I", "getRetryCount", "()I", "segmentNum", "getSegmentNum", "", "extraHeaders", "Ljava/util/Map;", "getExtraHeaders", "()Ljava/util/Map;", "autoResumed", "getAutoResumed", "versionName", "getVersionName", "isForceDownload", "setForceDownload", "(Z)V", "savePath", "getSavePath", "title", "getTitle", "onlyWifi", "getOnlyWifi", ActivityLifecycle.NAME, "getName", "url", "getUrl", "versionCode", "getVersionCode", "apkPackageName", "getApkPackageName", "md5", "getMd5", "isPriorityDownload", "setPriorityDownload", OaidModel.KEY_ID, "getId", "setId", "(I)V", "", "backupUrls", "Ljava/util/List;", "getBackupUrls", "()Ljava/util/List;", "needRetryDelay", "getNeedRetryDelay", "", "retryDelayTimeArray", "[J", "getRetryDelayTimeArray", "()[J", "minProgressInterval", "getMinProgressInterval", "setMinProgressInterval", "extraInfo", "getExtraInfo", "setExtraInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Ljava/lang/String;ZIZILjava/lang/String;[JLjava/lang/String;IZILjava/lang/String;Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class DownloadTask implements Parcelable {
    public static final a CREATOR = null;
    private final String apkPackageName;
    private final boolean autoResumed;
    private final List<String> backupUrls;
    private final Map<String, String> extraHeaders;
    private String extraInfo;
    private String hostPkgName;
    private final String iconUrl;
    private int id;
    private boolean isForceDownload;
    private boolean isPriorityDownload;
    private final String md5;
    private int minProgressInterval;
    private final String name;
    private final boolean needRetryDelay;
    private final boolean onlyWifi;
    private final int retryCount;
    private final long[] retryDelayTimeArray;
    private final String savePath;
    private final int segmentNum;
    private final boolean showNotification;
    private final String title;
    private final String url;
    private final int versionCode;
    private final String versionName;

    public static final class a implements Parcelable.Creator<DownloadTask> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public DownloadTask a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new DownloadTask(r10);
        }

        public DownloadTask[] b(int r10) {
            return new DownloadTask[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DownloadTask createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DownloadTask[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public DownloadTask(Parcel r32) {
        Intrinsics.checkNotNullParameter(r32, "parcel");
        String r10 = r32.readString();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullExpressionValue(r10, "parcel.readString()!!");
        String r11 = r32.readString();
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNullExpressionValue(r11, "parcel.readString()!!");
        ArrayList<String> r12 = r32.createStringArrayList();
        String r13 = r32.readString();
        String r14 = r32.readString();
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNullExpressionValue(r14, "parcel.readString()!!");
        int r15 = r32.readInt();
        String r16 = r32.readString();
        String r17 = r32.readString();
        byte r18 = (byte) 0;
        if (r32.readByte() == r18) goto L5;
        boolean r19 = true;
    L7:
        if (r32.readByte() == r18) goto L9;
        boolean r110 = true;
    L10:
        HashMap r20 = r32.readHashMap(HashMap.class.getClassLoader());
        if ((r20 instanceof Map) == true) goto L13;
        r20 = null;
    L13:
        HashMap r111 = r20;
        String r27 = r32.readString();
        if (r32.readByte() == r18) goto L16;
        boolean r28 = true;
    L17:
        int r29 = r32.readInt();
        if (r32.readByte() == r18) goto L20;
        boolean r30 = true;
    L21:
        int r112 = r32.readInt();
        String r21 = r32.readString();
        Intrinsics.checkNotNull(r21);
        Intrinsics.checkNotNullExpressionValue(r21, "parcel.readString()!!");
        long[] r22 = r32.createLongArray();
        String r23 = r32.readString();
        Intrinsics.checkNotNull(r23);
        Intrinsics.checkNotNullExpressionValue(r23, "parcel.readString()!!");
        this(r10, r11, r12, r13, r14, r15, r16, r17, r19, r110, r111, r27, r28, r29, r30, r112, r21, r22, r23, r32.readInt(), r32.readBoolean(), r32.readInt(), r32.readString(), r32.readBoolean());
        return;
    L20:
        r30 = false;
        goto L21
    L16:
        r28 = false;
        goto L17
    L9:
        r110 = false;
        goto L10
    L5:
        r19 = false;
        goto L7
    }

    public DownloadTask(String r10, String r11, List<String> r12, String r13, String r14, int r15, String r16, String r17, boolean r18, boolean r19, Map<String, String> r110, String r111, boolean r20, int r21, boolean r22, int r23, String r24, long[] r25, String r26, int r27, boolean r28, int r29, String r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r14, "savePath");
        Intrinsics.checkNotNullParameter(r24, "versionName");
        Intrinsics.checkNotNullParameter(r26, "hostPkgName");
        this.url = r10;
        this.name = r11;
        this.backupUrls = r12;
        this.title = r13;
        this.savePath = r14;
        this.segmentNum = r15;
        this.apkPackageName = r16;
        this.iconUrl = r17;
        this.onlyWifi = r18;
        this.showNotification = r19;
        this.extraHeaders = r110;
        this.md5 = r111;
        this.autoResumed = r20;
        this.retryCount = r21;
        this.needRetryDelay = r22;
        this.versionCode = r23;
        this.versionName = r24;
        this.retryDelayTimeArray = r25;
        this.hostPkgName = r26;
        this.id = r27;
        this.isPriorityDownload = r28;
        this.minProgressInterval = r29;
        this.extraInfo = r30;
        this.isForceDownload = r31;
    }

    public /* synthetic */ DownloadTask(String r29, String r30, List r31, String r32, String r33, int r34, String r35, String r36, boolean r37, boolean r38, Map r39, String r40, boolean r41, int r42, boolean r43, int r44, String r45, long[] r46, String r47, int r48, boolean r49, int r50, String r51, boolean r52, int r53, DefaultConstructorMarker r54) {
        if ((r53 & 8192) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((262144 & r53) == 0) goto L9;
        String r22 = "";
    L11:
        if ((524288 & r53) == 0) goto L13;
        int r23 = -1;
    L15:
        if ((1048576 & r53) == 0) goto L17;
        boolean r24 = false;
    L19:
        if ((2097152 & r53) == 0) goto L21;
        int r25 = 500;
    L23:
        if ((r53 & 8388608) == 0) goto L25;
        boolean r27 = false;
    L26:
        this(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r17, r43, r44, r45, r46, r22, r23, r24, r25, r51, r27);
        return;
    L25:
        r27 = r52;
        goto L26
    L21:
        r25 = r50;
        goto L23
    L17:
        r24 = r49;
        goto L19
    L13:
        r23 = r48;
        goto L15
    L9:
        r22 = r47;
        goto L11
    L5:
        r17 = r42;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getApkPackageName() {
        return this.apkPackageName;
    }

    public final boolean getAutoResumed() {
        return this.autoResumed;
    }

    public final List<String> getBackupUrls() {
        return this.backupUrls;
    }

    public final Map<String, String> getExtraHeaders() {
        return this.extraHeaders;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final String getHostPkgName() {
        return this.hostPkgName;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final int getMinProgressInterval() {
        return this.minProgressInterval;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedRetryDelay() {
        return this.needRetryDelay;
    }

    public final boolean getOnlyWifi() {
        return this.onlyWifi;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final long[] getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    public final String getSavePath() {
        return this.savePath;
    }

    public final int getSegmentNum() {
        return this.segmentNum;
    }

    public final boolean getShowNotification() {
        return this.showNotification;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isForceDownload() {
        return this.isForceDownload;
    }

    public final boolean isPriorityDownload() {
        return this.isPriorityDownload;
    }

    public final void setExtraInfo(String r10) {
        this.extraInfo = r10;
    }

    public final void setForceDownload(boolean r10) {
        this.isForceDownload = r10;
    }

    public final void setHostPkgName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.hostPkgName = r10;
    }

    public final void setId(int r10) {
        this.id = r10;
    }

    public final void setMinProgressInterval(int r10) {
        this.minProgressInterval = r10;
    }

    public final void setPriorityDownload(boolean r10) {
        this.isPriorityDownload = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeString(this.url);
        r10.writeString(this.name);
        r10.writeStringList(this.backupUrls);
        r10.writeString(this.title);
        r10.writeString(this.savePath);
        r10.writeInt(this.segmentNum);
        r10.writeString(this.apkPackageName);
        r10.writeString(this.iconUrl);
        r10.writeByte(this.onlyWifi ? 1 : 0);
        r10.writeByte(this.showNotification ? 1 : 0);
        r10.writeMap(this.extraHeaders);
        r10.writeString(this.md5);
        r10.writeByte(this.autoResumed ? 1 : 0);
        r10.writeInt(this.retryCount);
        r10.writeByte(this.needRetryDelay ? 1 : 0);
        r10.writeInt(this.versionCode);
        r10.writeString(this.versionName);
        r10.writeLongArray(this.retryDelayTimeArray);
        r10.writeString(this.hostPkgName);
        r10.writeInt(this.id);
        r10.writeBoolean(this.isPriorityDownload);
        r10.writeInt(this.minProgressInterval);
        r10.writeString(this.extraInfo);
        r10.writeBoolean(this.isForceDownload);
    }
}
