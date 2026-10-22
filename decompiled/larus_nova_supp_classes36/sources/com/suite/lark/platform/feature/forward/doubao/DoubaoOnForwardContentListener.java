package com.suite.lark.platform.feature.forward.doubao;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.suite.lark.platform.feature.forward.doubao.api.entity.DoubaoForwardCommonConfig;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "callback", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;", "<init>", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
final class DoubaoOnForwardContentListener implements OnForwardContentListener {
    public static final a CREATOR = null;
    public final DoubaoForwardCommonConfig.ForwardContentListener a;

    public static final class a implements Parcelable.Creator<DoubaoOnForwardContentListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoOnForwardContentListener createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Serializable r4 = r3.readSerializable();
            if ((r4 instanceof DoubaoForwardCommonConfig.ForwardContentListener) == false) goto L5;
            DoubaoForwardCommonConfig.ForwardContentListener r5 = (DoubaoForwardCommonConfig.ForwardContentListener) r4;
        L6:
            if (r5 == null) goto L10;
            return new DoubaoOnForwardContentListener(r5);
        L10:
            throw new IllegalArgumentException("Required value was null.".toString());
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoOnForwardContentListener[] newArray(int r1) {
            return new DoubaoOnForwardContentListener[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoOnForwardContentListener(DoubaoForwardCommonConfig.ForwardContentListener r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r3) {
        this.a.onFailed(null, r3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeSerializable(this.a);
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r7, Map<String, ? extends ForwardTargetBaseInfoNew> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "result");
        DoubaoForwardCommonConfig.ForwardContentListener r10 = this.a;
        LinkedHashMap r11 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));
        Iterator<T> r12 = r8.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) r12.next();
        Object r1 = r0.getKey();
        ForwardTargetBaseInfoNew r2 = (ForwardTargetBaseInfoNew) r0.getValue();
        npc.c r3 = new npc.c();
        String r4 = r2.a;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.a = r4;
        String r5 = r2.c;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.b = r5;
        String r6 = r2.b;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.c = r6;
        if ((r2 instanceof ForwardTargetChatterInfo) == false) goto L9;
        r3.e = 1;
    L17:
        r11.put(r1, r3);
        goto L4
    L9:
        if ((r2 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L12;
        r3.e = 1;
        goto L17
    L12:
        if ((r2 instanceof ForwardTargetGroupChatInfo) == false) goto L15;
        r3.e = 2;
        goto L17
    L15:
        if ((r2 instanceof ForwardTargetThreadInfo) == false) goto L17;
        r3.e = 3;
        String r13 = ((ForwardTargetThreadInfo) r2).h;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r3.d = r13;
        goto L17
    L19:
        return r10.onSuccess(r11);
    }
}
