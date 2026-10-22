package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\tR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/schema/vo/WebHybridParamVo;", "Landroid/os/Parcelable;", "", "referer", "Ljava/lang/String;", "getReferer", "()Ljava/lang/String;", "setReferer", "(Ljava/lang/String;)V", "a", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<WebHybridParamVo> CREATOR = null;
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final BaseHybridParamVo h;
    public boolean i;

    @SerializedName("referer")
    private String referer;

    public static final class a {
    }

    public static class b implements Parcelable.Creator<WebHybridParamVo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final WebHybridParamVo createFromParcel(Parcel r14) {
            Intrinsics.checkNotNullParameter(r14, "in");
            int r2 = r14.readInt();
            if (r14.readInt() == 0) goto L5;
            boolean r5 = true;
        L7:
            if (r14.readInt() == 0) goto L9;
            boolean r6 = true;
        L11:
            if (r14.readInt() == 0) goto L13;
            boolean r7 = true;
        L14:
            String r8 = r14.readString();
            if (r14.readInt() == 0) goto L17;
            boolean r9 = true;
        L19:
            if (r14.readInt() == 0) goto L21;
            boolean r10 = true;
        L22:
            String r12 = r14.readString();
            if (r14.readInt() == 0) goto L25;
            BaseHybridParamVo r1 = BaseHybridParamVo.CREATOR.createFromParcel(r14);
        L26:
            BaseHybridParamVo r13 = r1;
            if (r14.readInt() == 0) goto L29;
            boolean r15 = true;
        L31:
            return new WebHybridParamVo(r2, r5, r6, r7, r8, r9, r10, r12, r13, r15);
        L29:
            r15 = false;
            goto L31
        L25:
            r1 = null;
            goto L26
        L21:
            r10 = false;
            goto L22
        L17:
            r9 = false;
            goto L19
        L13:
            r7 = false;
            goto L14
        L9:
            r6 = false;
            goto L11
        L5:
            r5 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final WebHybridParamVo[] newArray(int r1) {
            return new WebHybridParamVo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.a);
        r3.writeInt(this.b ? 1 : 0);
        r3.writeInt(this.c ? 1 : 0);
        r3.writeInt(this.d ? 1 : 0);
        r3.writeString(this.e);
        r3.writeInt(this.f ? 1 : 0);
        r3.writeInt(this.g ? 1 : 0);
        r3.writeString(this.referer);
        BaseHybridParamVo r5 = this.h;
        if (r5 == null) goto L5;
        r3.writeInt(1);
        r5.writeToParcel(r3, 0);
    L6:
        r3.writeInt(this.i ? 1 : 0);
        return;
    L5:
        r3.writeInt(0);
        goto L6
    }

    public final String toString() {
        return "WebHybridParamVo(saleShowStatus=" + this.a + ", noHardwareAccelerated=" + this.b + ", enableAppCache=" + this.c + ", useReceivedTitle=" + this.d + ", headStr=" + this.e + ", loadNoCache=" + this.f + ", OfflineEnable=" + this.g + ", referer=" + this.referer + ", commonHybridParam=" + this.h + ')';
    }

    public WebHybridParamVo(int r1, boolean r2, boolean r3, boolean r4, String r5, boolean r6, boolean r7, String r8, BaseHybridParamVo r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.referer = r8;
        this.h = r9;
        this.i = r10;
    }
}
