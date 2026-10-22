package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnCloseForwardListener;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010$H\u0002J\b\u00100\u001a\u0004\u0018\u00010$J\u0018\u00101\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00066"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardCommonConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "resultCode", "", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "showTitleBar", "", "getShowTitleBar", "()Z", "setShowTitleBar", "(Z)V", "enableCreateGroupChat", "getEnableCreateGroupChat", "setEnableCreateGroupChat", "enableRecentForward", "getEnableRecentForward", "setEnableRecentForward", "titleBarText", "", "getTitleBarText", "()Ljava/lang/String;", "setTitleBarText", "(Ljava/lang/String;)V", "enableBackOriginalApplication", "getEnableBackOriginalApplication", "setEnableBackOriginalApplication", "onCloseForwardListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCloseForwardListener;", "onCloseForwardListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnCloseForwardListener;", "forwardContentListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "getForwardContentListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "setForwardContentListener", "(Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;)V", "setOnCloseForwardListener", "", "listener", "getOnCloseForwardListener", "writeToParcel", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardCommonConfig implements Parcelable {
    public static final b CREATOR = null;
    public Integer a;
    public boolean b;
    public boolean c;
    public boolean d;
    public String e;
    public boolean f;
    public c g;
    public RemoteOnCloseForwardListener h;
    public OnForwardContentListener i;

    public static final class a {
        public final boolean a;
        public boolean b;
        public boolean c;
        public String d;
        public oib.b e;
        public OnForwardContentListener f;

        public final ForwardCommonConfig a() {
            ForwardCommonConfig r0 = new ForwardCommonConfig();
            r0.a = null;
            r0.b = this.a;
            r0.c = this.b;
            r0.d = this.c;
            String r1 = this.d;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.e = r1;
            r0.f = false;
            final oib.b r2 = this.e;
            if (r2 == null) goto L6;
            r0.h = new ForwardCommonConfig$setOnCloseForwardListener$1(r2);
        L6:
            r0.i = this.f;
            return r0;
        }

        public a() {
            this.a = true;
            this.b = true;
            this.c = true;
            this.d = "";
        }
    }

    public static final class b implements Parcelable.Creator<ForwardCommonConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardCommonConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ForwardCommonConfig r1 = new ForwardCommonConfig();
            if (r5.readInt() != (-10000)) goto L5;
            Integer r0 = null;
        L6:
            r1.a = r0;
            boolean r2 = true;
            if (r5.readByte() == 0) goto L9;
            boolean r3 = true;
        L10:
            r1.b = r3;
            if (r5.readByte() == 0) goto L13;
            boolean r4 = true;
        L14:
            r1.c = r4;
            if (r5.readByte() == 0) goto L17;
            boolean r6 = true;
        L18:
            r1.d = r6;
            String r7 = r5.readString();
            if (r7 != null) goto L21;
            r7 = "";
        L21:
            r1.e = r7;
            if (r5.readByte() != 0) goto L25;
            r2 = false;
        L25:
            r1.f = r2;
            if (r5.readInt() <= 0) goto L28;
            r1.h = RemoteOnCloseForwardListener.Stub.asInterface(r5.readStrongBinder());
        L28:
            r1.i = (OnForwardContentListener) r5.readParcelable(ForwardCommonConfig.class.getClassLoader());
            return r1;
        L17:
            r6 = false;
            goto L18
        L13:
            r4 = false;
            goto L14
        L9:
            r3 = false;
            goto L10
        L5:
            r0 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardCommonConfig[] newArray(int r1) {
            return new ForwardCommonConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardCommonConfig() {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        Integer r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        r2.writeInt(r1);
        r2.writeByte(this.b ? 1 : 0);
        r2.writeByte(this.c ? 1 : 0);
        r2.writeByte(this.d ? 1 : 0);
        r2.writeString(this.e);
        r2.writeByte(this.f ? 1 : 0);
        if (this.h == null) goto L13;
        r2.writeInt(1);
        RemoteOnCloseForwardListener r4 = this.h;
        if (r4 == null) goto L11;
        IBinder r5 = r4.asBinder();
    L12:
        r2.writeStrongBinder(r5);
    L14:
        r2.writeParcelable(this.i, r3);
        return;
    L11:
        r5 = null;
        goto L12
    L13:
        r2.writeInt(0);
        goto L14
    L5:
        r1 = -10000;
        goto L6
    }
}
