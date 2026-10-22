package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/schema/vo/LynxHybridParamVo;", "Landroid/os/Parcelable;", "", "fallbackSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFallbackSchema", "(Ljava/lang/String;)V", "", "lynxThreadStrategy", "I", "c", "()I", "setLynxThreadStrategy", "(I)V", "", "isEnableLynxBg", "Z", "d", "()Z", "setEnableLynxBg", "(Z)V", "abandonCoordinate", "a", "setAbandonCoordinate", "isSlideCenter", "e", "setSlideCenter", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<LynxHybridParamVo> CREATOR = null;
    public final int a;

    @SerializedName("abandon_coordinate")
    private boolean abandonCoordinate;
    public final BaseHybridParamVo b;

    @SerializedName("fallback_url")
    private String fallbackSchema;

    @SerializedName("enable_lynx_bg")
    private boolean isEnableLynxBg;

    @SerializedName("is_slide_center")
    private boolean isSlideCenter;

    @SerializedName("lynx_thread")
    private int lynxThreadStrategy;

    public static class a implements Parcelable.Creator<LynxHybridParamVo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LynxHybridParamVo createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "in");
            String r2 = r12.readString();
            int r3 = r12.readInt();
            if (r12.readInt() == 0) goto L5;
            boolean r6 = true;
        L6:
            int r7 = r12.readInt();
            if (r12.readInt() == 0) goto L9;
            boolean r8 = true;
        L11:
            if (r12.readInt() == 0) goto L13;
            boolean r9 = true;
        L15:
            if (r12.readInt() == 0) goto L17;
            BaseHybridParamVo r13 = BaseHybridParamVo.CREATOR.createFromParcel(r12);
        L19:
            return new LynxHybridParamVo(r2, r3, r6, r7, r8, r9, r13);
        L17:
            r13 = null;
            goto L19
        L13:
            r9 = false;
            goto L15
        L9:
            r8 = false;
            goto L11
        L5:
            r6 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LynxHybridParamVo[] newArray(int r1) {
            return new LynxHybridParamVo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public LynxHybridParamVo() {
        this(null, 0, false, false, false, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.fallbackSchema);
        r3.writeInt(this.lynxThreadStrategy);
        r3.writeInt(this.isEnableLynxBg ? 1 : 0);
        r3.writeInt(this.a);
        r3.writeInt(this.abandonCoordinate ? 1 : 0);
        r3.writeInt(this.isSlideCenter ? 1 : 0);
        BaseHybridParamVo r5 = this.b;
        if (r5 == null) goto L5;
        r3.writeInt(1);
        r5.writeToParcel(r3, 0);
        return;
    L5:
        r3.writeInt(0);
    }

    public final String toString() {
        return "LynxHybridParamVo(fallbackSchema=" + this.fallbackSchema + ", lynxThreadStrategy=" + this.lynxThreadStrategy + ", isEnableLynxBg=" + this.isEnableLynxBg + ", presetWidth=" + this.a + ", commonHybridParam=" + this.b;
    }

    public final boolean a() {
        return this.abandonCoordinate;
    }

    public final String b() {
        return this.fallbackSchema;
    }

    public final int c() {
        return this.lynxThreadStrategy;
    }

    public final boolean d() {
        return this.isEnableLynxBg;
    }

    public final boolean e() {
        return this.isSlideCenter;
    }

    public /* synthetic */ LynxHybridParamVo(String r9, int r10, boolean r12, boolean r13, boolean r14, BaseHybridParamVo r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        r9 = "";
    L5:
        String r1 = r9;
        if ((r16 & 2) == 0) goto L8;
        int r2 = 0;
    L10:
        if ((r16 & 4) == 0) goto L12;
        boolean r3 = false;
    L14:
        if ((r16 & 16) == 0) goto L16;
        boolean r5 = false;
    L18:
        if ((r16 & 32) == 0) goto L20;
        boolean r6 = false;
    L22:
        if ((r16 & 64) == 0) goto L24;
        r15 = null;
    L24:
        this(r1, r2, r3, 0, r5, r6, r15);
        return;
    L20:
        r6 = r14;
        goto L22
    L16:
        r5 = r13;
        goto L18
    L12:
        r3 = r12;
        goto L14
    L8:
        r2 = r10;
        goto L10
    }

    public LynxHybridParamVo(String r1, int r2, boolean r3, int r4, boolean r5, boolean r6, BaseHybridParamVo r7) {
        this.fallbackSchema = r1;
        this.lynxThreadStrategy = r2;
        this.isEnableLynxBg = r3;
        this.a = r4;
        this.abandonCoordinate = r5;
        this.isSlideCenter = r6;
        this.b = r7;
    }
}
