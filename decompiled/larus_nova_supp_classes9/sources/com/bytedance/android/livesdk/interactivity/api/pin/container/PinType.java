package com.bytedance.android.livesdk.interactivity.api.pin.container;

import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/pin/container/PinType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "dataType", "I", "getDataType", "()I", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "All", "Unknown", "Answer", "Comment", "Video", "MicroApp", "Im", "CommonPictureText", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PinType extends Enum<PinType> {
    public static final PinType All = null;
    public static final PinType Answer = null;
    public static final PinType Comment = null;
    public static final PinType CommonPictureText = null;
    public static final PinType Im = null;
    public static final PinType MicroApp = null;
    public static final PinType Unknown = null;
    public static final PinType Video = null;
    public static final /* synthetic */ PinType[] a = null;
    private final int dataType;
    private final String desc;

    public static PinType valueOf(String r1) {
        return (PinType) a.a(PinType.class, r1);
    }

    public static PinType[] values() {
        return (PinType[]) a.clone();
    }

    static {
        PinType r2 = new PinType("All", 0, -1, "all");
        All = r2;
        PinType r3 = new PinType("Unknown", 1, 0, CardLockInfo.sUNKNOWN);
        Unknown = r3;
        PinType r4 = new PinType("Answer", 2, 3, "answer");
        Answer = r4;
        PinType r5 = new PinType("Comment", 3, 4, "comment");
        Comment = r5;
        PinType r6 = new PinType("Video", 4, 5, "video");
        Video = r6;
        PinType r7 = new PinType("MicroApp", 5, 6, "microapp");
        MicroApp = r7;
        PinType r8 = new PinType("Im", 6, 7, "im");
        Im = r8;
        PinType r9 = new PinType("CommonPictureText", 7, 8, "common_picture_text");
        CommonPictureText = r9;
        a = new PinType[]{r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final String getDesc() {
        return this.desc;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }

    public PinType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.dataType = r3;
        this.desc = r4;
    }
}
