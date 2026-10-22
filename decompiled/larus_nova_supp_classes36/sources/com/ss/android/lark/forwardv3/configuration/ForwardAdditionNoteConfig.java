package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardAdditionNoteConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableAdditionNote", "", "getEnableAdditionNote", "()Z", "setEnableAdditionNote", "(Z)V", "enableAdditionNoteAT", "getEnableAdditionNoteAT", "setEnableAdditionNoteAT", "forwardNoteListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardNoteListener;", "forwardNoteListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardNoteListener;", "setForwardNoteListener", "", "listener", "getForwardNoteListener", "writeToParcel", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardAdditionNoteConfig implements Parcelable {
    public static final b CREATOR = null;
    public boolean a;
    public boolean b;
    public com.ss.android.lark.forwardv3.configuration.b c;
    public RemoteOnForwardNoteListener d;

    public static final class a {
        public boolean a;
        public boolean b;

        public final ForwardAdditionNoteConfig a() {
            ForwardAdditionNoteConfig r0 = new ForwardAdditionNoteConfig();
            r0.a = this.a;
            r0.b = this.b;
            return r0;
        }

        public a() {
            this.a = true;
            this.b = true;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardAdditionNoteConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardAdditionNoteConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ForwardAdditionNoteConfig r1 = new ForwardAdditionNoteConfig();
            boolean r2 = true;
            if (r5.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            r1.a = r0;
            if (r5.readByte() != 0) goto L10;
            r2 = false;
        L10:
            r1.b = r2;
            if (r5.readInt() <= 0) goto L13;
            r1.d = RemoteOnForwardNoteListener.Stub.asInterface(r5.readStrongBinder());
        L13:
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardAdditionNoteConfig[] newArray(int r1) {
            return new ForwardAdditionNoteConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardAdditionNoteConfig() {
        this.a = true;
        this.b = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeByte(this.a ? 1 : 0);
        r1.writeByte(this.b ? 1 : 0);
        if (this.d == null) goto L9;
        r1.writeInt(1);
        RemoteOnForwardNoteListener r3 = this.d;
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
