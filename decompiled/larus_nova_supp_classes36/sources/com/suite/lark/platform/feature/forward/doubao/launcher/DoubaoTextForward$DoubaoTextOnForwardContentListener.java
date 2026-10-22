package com.suite.lark.platform.feature.forward.doubao.launcher;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "callback", "Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextForwardCallback;", "<init>", "(Lcom/suite/lark/platform/feature/forward/doubao/launcher/DoubaoTextForward$DoubaoTextForwardCallback;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
final class DoubaoTextForward$DoubaoTextOnForwardContentListener implements OnForwardContentListener {
    public static final a CREATOR = null;
    public final DoubaoTextForward$DoubaoTextForwardCallback a;

    public static final class a implements Parcelable.Creator<DoubaoTextForward$DoubaoTextOnForwardContentListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoTextForward$DoubaoTextOnForwardContentListener createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new DoubaoTextForward$DoubaoTextOnForwardContentListener(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoTextForward$DoubaoTextOnForwardContentListener[] newArray(int r1) {
            return new DoubaoTextForward$DoubaoTextOnForwardContentListener[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoTextForward$DoubaoTextOnForwardContentListener(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        Serializable r3 = r2.readSerializable();
        if ((r3 instanceof DoubaoTextForward$DoubaoTextForwardCallback) == false) goto L5;
        DoubaoTextForward$DoubaoTextForwardCallback r4 = (DoubaoTextForward$DoubaoTextForwardCallback) r3;
    L6:
        this.a = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r3) {
        DoubaoTextForward$DoubaoTextForwardCallback r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFailed(null, r3);
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeSerializable(this.a);
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r1, Map<String, ? extends ForwardTargetBaseInfoNew> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        DoubaoTextForward$DoubaoTextForwardCallback r4 = this.a;
        if (r4 == null) goto L7;
        r4.onSuccess(r2);
        return true;
    L7:
        return true;
    }
}
