package com.ss.android.lark.forwardv3.configuration;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010 H\u0002J\b\u0010&\u001a\u0004\u0018\u00010 J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/ForwardTargetConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableChatPreview", "", "getEnableChatPreview", "()Z", "setEnableChatPreview", "(Z)V", "enableAIKnowledge", "getEnableAIKnowledge", "setEnableAIKnowledge", "enableExternalTarget", "getEnableExternalTarget", "setEnableExternalTarget", "includeConfig", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;", "getIncludeConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;", "setIncludeConfig", "(Lcom/ss/android/lark/forwardv3/configuration/targetconfig/IncludeConfig;)V", "disableConfig", "Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;", "getDisableConfig", "()Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;", "setDisableConfig", "(Lcom/ss/android/lark/forwardv3/configuration/targetconfig/DisableConfig;)V", "customDisableListener", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardTargetCustomDisableListener;", "customDisableListenerProxy", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardTargetCustomDisableListener;", "setOnForwardTargetCustomDisableListener", "", "listener", "getOnForwardTargetCustomDisableListener", "writeToParcel", "flags", "", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardTargetConfig implements Parcelable {
    public static final b CREATOR = null;
    public boolean a;
    public boolean b;
    public boolean c;
    public IncludeConfig d;
    public DisableConfig e;
    public f f;
    public RemoteOnForwardTargetCustomDisableListener g;

    public static final class a {
        public boolean a;
        public boolean b;
        public boolean c;
        public IncludeConfig d;
        public DisableConfig e;

        public final ForwardTargetConfig a() {
            ForwardTargetConfig r0 = new ForwardTargetConfig();
            r0.a = this.a;
            r0.b = this.b;
            r0.c = this.c;
            r0.d = this.d;
            r0.e = this.e;
            return r0;
        }

        public a() {
            this.a = true;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ForwardTargetConfig r1 = new ForwardTargetConfig();
            boolean r2 = true;
            if (r5.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            r1.a = r0;
            if (r5.readByte() == 0) goto L9;
            boolean r3 = true;
        L10:
            r1.b = r3;
            if (r5.readByte() != 0) goto L14;
            r2 = false;
        L14:
            r1.c = r2;
            r1.d = (IncludeConfig) r5.readParcelable(ForwardTargetConfig.class.getClassLoader());
            r1.e = (DisableConfig) r5.readParcelable(ForwardTargetConfig.class.getClassLoader());
            if (r5.readInt() <= 0) goto L17;
            r1.g = RemoteOnForwardTargetCustomDisableListener.Stub.asInterface(r5.readStrongBinder());
        L17:
            return r1;
        L9:
            r3 = false;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetConfig[] newArray(int r1) {
            return new ForwardTargetConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetConfig() {
        this.a = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeByte(this.a ? 1 : 0);
        r2.writeByte(this.b ? 1 : 0);
        r2.writeByte(this.c ? 1 : 0);
        r2.writeParcelable(this.d, r3);
        r2.writeParcelable(this.e, r3);
        if (this.g == null) goto L9;
        r2.writeInt(1);
        RemoteOnForwardTargetCustomDisableListener r4 = this.g;
        if (r4 == null) goto L7;
        IBinder r5 = r4.asBinder();
    L8:
        r2.writeStrongBinder(r5);
        return;
    L7:
        r5 = null;
        goto L8
    L9:
        r2.writeInt(0);
    }
}
