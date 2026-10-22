package com.ss.android.lark.forwardv3.forward.mediaforward;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/mediaforward/MediaForward$MediaForwardOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "forwardContent", "Lcom/ss/android/lark/forwardv3/forward/mediaforward/MediaForwardContent;", "<init>", "(Lcom/ss/android/lark/forwardv3/forward/mediaforward/MediaForwardContent;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getForwardContent", "()Lcom/ss/android/lark/forwardv3/forward/mediaforward/MediaForwardContent;", "writeToParcel", "", "flags", "", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "errorTitle", "errorMessage", "describeContents", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
final class MediaForward$MediaForwardOnForwardContentListener implements OnForwardContentListener {
    public static final a CREATOR = null;
    public final MediaForwardContent a;

    public static final class a implements Parcelable.Creator<MediaForward$MediaForwardOnForwardContentListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaForward$MediaForwardOnForwardContentListener createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new MediaForward$MediaForwardOnForwardContentListener(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaForward$MediaForwardOnForwardContentListener[] newArray(int r1) {
            return new MediaForward$MediaForwardOnForwardContentListener[r1];
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Activity a;

        public b(Activity r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.a, y9c.d.h(2131892247), 2131256306);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public MediaForward$MediaForwardOnForwardContentListener(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this.a = (MediaForwardContent) r2.readParcelable(MediaForward$MediaForwardOnForwardContentListener.class.getClassLoader());
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r2) {
        Log.e("MediaForward", "forward failed error title: null");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.a, r3);
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r2, Map<String, ? extends ForwardTargetBaseInfoNew> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r4 == false) goto L7;
        UICallbackExecutor.execute(new b(r2));
    L7:
        return true;
    }
}
