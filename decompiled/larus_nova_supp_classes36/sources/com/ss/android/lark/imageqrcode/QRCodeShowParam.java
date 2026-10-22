package com.ss.android.lark.imageqrcode;

import android.graphics.Bitmap;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u00060"}, d2 = {"Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "Ljava/io/Serializable;", "<init>", "()V", "from", "", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "scaleType", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;", "getScaleType", "()Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;", "setScaleType", "(Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;)V", "contentList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/imageqrcode/QRCodeContentInfo;", "Lkotlin/collections/ArrayList;", "getContentList", "()Ljava/util/ArrayList;", "setContentList", "(Ljava/util/ArrayList;)V", "requestCode", "", "getRequestCode", "()Ljava/lang/Integer;", "setRequestCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "scanType", "getScanType", "setScanType", "isInValid", "", "toString", "Builder", "ScaleType", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QRCodeShowParam implements Serializable {
    public transient Bitmap a;
    private ArrayList<QRCodeContentInfo> contentList;
    private String from;
    private String path;
    private Integer requestCode;
    private ScaleType scaleType;
    private String scanType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/imageqrcode/QRCodeShowParam$ScaleType;", "", "<init>", "(Ljava/lang/String;I)V", "FIT_CENTER", "CENTER_CROP", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ScaleType extends Enum<ScaleType> {
        public static final ScaleType CENTER_CROP = null;
        public static final ScaleType FIT_CENTER = null;
        public static final /* synthetic */ ScaleType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScaleType> getEntries() {
            return b;
        }

        static {
            ScaleType r0 = new ScaleType("FIT_CENTER", 0);
            FIT_CENTER = r0;
            ScaleType r1 = new ScaleType("CENTER_CROP", 1);
            CENTER_CROP = r1;
            ScaleType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) a.clone();
        }

        public static ScaleType valueOf(String r1) {
            return (ScaleType) a.a(ScaleType.class, r1);
        }

        public ScaleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ QRCodeShowParam(DefaultConstructorMarker r1) {
        this();
    }

    public final boolean isInValid() {
        if (FileUtils.r(this.path) == true) goto L7;
        int r0 = com.ss.android.lark.imageqrcode.utils.a.a;
        if (com.ss.android.lark.imageqrcode.utils.a.c(this.a) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.contentList.isEmpty() == true) goto L8;
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("from:");
        r0.append(this.from);
        r0.append(",path:");
        r0.append(this.path);
        r0.append(",bitmap is null:");
        if (this.a != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(",scaleType:");
        r0.append(this.scaleType);
        r0.append(",resultList:");
        r0.append(this.contentList);
        r0.append(",requestCode:");
        r0.append(this.requestCode);
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    private QRCodeShowParam() {
        this.from = LocationHitPoint$ResultType.DEFAULT;
        this.scaleType = ScaleType.FIT_CENTER;
        this.contentList = new ArrayList();
        this.scanType = INotificationHitPoint.NoticeType.OTHER;
    }

    public final Bitmap getBitmap() {
        return this.a;
    }

    public final ArrayList<QRCodeContentInfo> getContentList() {
        return this.contentList;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getRequestCode() {
        return this.requestCode;
    }

    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    public final String getScanType() {
        return this.scanType;
    }

    public final void setBitmap(Bitmap r1) {
        this.a = r1;
    }

    public final void setContentList(ArrayList<QRCodeContentInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentList = r2;
    }

    public final void setFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.from = r2;
    }

    public final void setPath(String r1) {
        this.path = r1;
    }

    public final void setRequestCode(Integer r1) {
        this.requestCode = r1;
    }

    public final void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scaleType = r2;
    }

    public final void setScanType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scanType = r2;
    }
}
