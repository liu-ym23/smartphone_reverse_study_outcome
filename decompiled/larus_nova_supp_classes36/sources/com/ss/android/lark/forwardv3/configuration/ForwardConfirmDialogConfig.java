package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnForwardConfirmDialogListener;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010 H\u0002J\b\u0010&\u001a\u0004\u0018\u00010 J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardConfirmDialogConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "titleBarText", "", "getTitleBarText", "()Ljava/lang/String;", "setTitleBarText", "(Ljava/lang/String;)V", "confirmButtonText", "getConfirmButtonText", "setConfirmButtonText", "cancelButtonText", "getCancelButtonText", "setCancelButtonText", "dialogContentConfig", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "getDialogContentConfig", "()Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "setDialogContentConfig", "(Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;)V", "customConfirmDialogContentView", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "getCustomConfirmDialogContentView", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "setCustomConfirmDialogContentView", "(Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;)V", "confirmDialogListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardConfirmDialogListener;", "confirmDialogListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardConfirmDialogListener;", "setConfirmDialogListener", "", "listener", "getConfirmDialogListener", "writeToParcel", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardConfirmDialogConfig implements Parcelable {
    public static final b CREATOR = null;
    public String a;
    public String b;
    public String c;
    public BasicDialogContentConfig d;
    public OnCustomForwardConfirmDialogContentView e;
    public d f;
    public RemoteOnForwardConfirmDialogListener g;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public BasicDialogContentConfig d;
        public OnCustomForwardConfirmDialogContentView e;

        public final ForwardConfirmDialogConfig a() {
            ForwardConfirmDialogConfig r0 = new ForwardConfirmDialogConfig();
            String r1 = this.a;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.a = r1;
            String r2 = this.b;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.b = r2;
            String r3 = this.c;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.c = r3;
            r0.d = this.d;
            r0.e = this.e;
            return r0;
        }

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
        }
    }

    public static final class b implements Parcelable.Creator<ForwardConfirmDialogConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardConfirmDialogConfig createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            ForwardConfirmDialogConfig r1 = new ForwardConfirmDialogConfig();
            String r0 = r4.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.a = r0;
            String r3 = r4.readString();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r1.b = r3;
            String r5 = r4.readString();
            if (r5 == null) goto L12;
            r2 = r5;
        L12:
            r1.c = r2;
            r1.d = (BasicDialogContentConfig) r4.readParcelable(ForwardConfirmDialogConfig.class.getClassLoader());
            if (r4.readInt() <= 0) goto L15;
            r1.g = RemoteOnForwardConfirmDialogListener.Stub.asInterface(r4.readStrongBinder());
        L15:
            r1.e = (OnCustomForwardConfirmDialogContentView) r4.readParcelable(ForwardConfirmDialogConfig.class.getClassLoader());
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardConfirmDialogConfig[] newArray(int r1) {
            return new ForwardConfirmDialogConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardConfirmDialogConfig() {
        this.a = "";
        this.b = "";
        this.c = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeParcelable(this.d, r3);
        if (this.g == null) goto L9;
        r2.writeInt(1);
        RemoteOnForwardConfirmDialogListener r0 = this.g;
        if (r0 == null) goto L7;
        IBinder r1 = r0.asBinder();
    L8:
        r2.writeStrongBinder(r1);
    L10:
        r2.writeParcelable(this.e, r3);
        return;
    L7:
        r1 = null;
        goto L8
    L9:
        r2.writeInt(0);
        goto L10
    }
}
