package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnCancelMultiSelectListener;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardSelectConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableSwitchSelectMode", "", "getEnableSwitchSelectMode", "()Z", "setEnableSwitchSelectMode", "(Z)V", "defaultSingleSelectMode", "getDefaultSingleSelectMode", "setDefaultSingleSelectMode", "maxLimitSelectNum", "", "getMaxLimitSelectNum", "()I", "setMaxLimitSelectNum", "(I)V", "cancelMultiSelectListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCancelMultiSelectListener;", "cancelMultiSelectListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnCancelMultiSelectListener;", "setCancelMultiSelectListener", "", "listener", "getCancelMultiSelectListener", "writeToParcel", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardSelectConfig implements Parcelable {
    public static final b CREATOR = null;
    public boolean a;
    public boolean b;
    public int c;
    public e d;
    public RemoteOnCancelMultiSelectListener e;

    public static final class a {
        public boolean a;
        public boolean b;
        public int c;

        public final ForwardSelectConfig a() {
            ForwardSelectConfig r0 = new ForwardSelectConfig();
            r0.a = this.a;
            r0.b = this.b;
            r0.c = this.c;
            final e r1 = r0.d;
            if (r1 == null) goto L6;
            r0.e = new ForwardSelectConfig$setCancelMultiSelectListener$1(r1);
        L6:
            return r0;
        }

        public a() {
            this.a = true;
            this.b = true;
            this.c = 10;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardSelectConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardSelectConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ForwardSelectConfig r1 = new ForwardSelectConfig();
            boolean r2 = true;
            if (r5.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            r1.a = r0;
            if (r5.readByte() != 0) goto L10;
            r2 = false;
        L10:
            r1.b = r2;
            r1.c = r5.readInt();
            if (r5.readInt() <= 0) goto L13;
            r1.e = RemoteOnCancelMultiSelectListener.Stub.asInterface(r5.readStrongBinder());
        L13:
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardSelectConfig[] newArray(int r1) {
            return new ForwardSelectConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardSelectConfig() {
        this.a = true;
        this.b = true;
        this.c = 10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeByte(this.a ? 1 : 0);
        r1.writeByte(this.b ? 1 : 0);
        r1.writeInt(this.c);
        if (this.e == null) goto L9;
        r1.writeInt(1);
        RemoteOnCancelMultiSelectListener r3 = this.e;
        if (r3 == null) goto L7;
        IBinder r4 = r3.asBinder();
    L8:
        r1.writeStrongBinder(r4);
        return;
    L7:
        r4 = null;
        goto L8
    L9:
        r1.writeInt(0);
    }
}
