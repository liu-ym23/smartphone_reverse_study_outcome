package com.ss.android.lark.forwardv3.doubao;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteDoubaoForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.feature.forward.doubao.api.entity.DoubaoForwardCommonConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/forwardv3/doubao/DoubaoOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "callback", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;", "<init>", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoForwardCommonConfig$ForwardContentListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbackProxy", "Lcom/ss/android/lark/forwardv3/RemoteDoubaoForwardContentListener;", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
final class DoubaoOnForwardContentListener implements OnForwardContentListener {
    public static final a CREATOR = null;
    public final RemoteDoubaoForwardContentListener a;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.doubao.DoubaoOnForwardContentListener$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"com/ss/android/lark/forwardv3/doubao/DoubaoOnForwardContentListener$1", "Lcom/ss/android/lark/forwardv3/RemoteDoubaoForwardContentListener$Stub;", "onSuccess", "", "result", "Landroid/os/Bundle;", "onFailed", "", "errorTitle", "", "errorMessage", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public final class AnonymousClass1 extends RemoteDoubaoForwardContentListener.Stub {
        final /* synthetic */ DoubaoForwardCommonConfig.ForwardContentListener $callback;

        public AnonymousClass1(DoubaoForwardCommonConfig.ForwardContentListener r1) {
            this.$callback = r1;
        }

        @Override // com.ss.android.lark.forwardv3.RemoteDoubaoForwardContentListener
        public boolean onSuccess(Bundle r18) {
            DoubaoForwardCommonConfig.ForwardContentListener r2 = this.$callback;
            if (r18 != null) goto L5;
            Map<String, npc.c> r1 = MapsKt.emptyMap();
        L54:
            return r2.onSuccess(r1);
        L5:
            Iterable r3 = r18.getStringArrayList("doubao_forward_result_message_ids");
            if (r3 != null) goto L8;
            r3 = CollectionsKt.emptyList();
        L8:
            List r4 = r18.getStringArrayList("doubao_forward_result_target_ids");
            if (r4 != null) goto L11;
            r4 = CollectionsKt.emptyList();
        L11:
            List r5 = r18.getStringArrayList("doubao_forward_result_avatar_keys");
            if (r5 != null) goto L14;
            r5 = CollectionsKt.emptyList();
        L14:
            List r6 = r18.getStringArrayList("doubao_forward_result_names");
            if (r6 != null) goto L17;
            r6 = CollectionsKt.emptyList();
        L17:
            List r7 = r18.getStringArrayList("doubao_forward_result_thread_ids");
            if (r7 != null) goto L20;
            r7 = CollectionsKt.emptyList();
        L20:
            List r8 = r18.getIntegerArrayList("doubao_forward_result_target_types");
            if (r8 != null) goto L23;
            r8 = CollectionsKt.emptyList();
        L23:
            List r9 = r18.getStringArrayList("doubao_forward_result_p2p_chat_ids");
            if (r9 != null) goto L26;
            r9 = CollectionsKt.emptyList();
        L26:
            LinkedHashMap r10 = new LinkedHashMap();
            Iterator r11 = r3.iterator();
            int r12 = 0;
        L28:
            if (r11.hasNext() == false) goto L52;
            Object r13 = r11.next();
            int r14 = r12 + 1;
            if (r12 >= 0) goto L32;
            CollectionsKt.throwIndexOverflow();
        L32:
            String r15 = (String) r13;
            npc.c r16 = new npc.c();
            String r17 = (String) CollectionsKt.getOrNull(r4, r12);
            if (r17 != null) goto L35;
            r17 = "";
        L35:
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            r16.a = r17;
            String r19 = (String) CollectionsKt.getOrNull(r5, r12);
            if (r19 != null) goto L38;
            r19 = "";
        L38:
            Intrinsics.checkNotNullParameter(r19, "<set-?>");
            r16.b = r19;
            String r110 = (String) CollectionsKt.getOrNull(r6, r12);
            if (r110 != null) goto L41;
            r110 = "";
        L41:
            Intrinsics.checkNotNullParameter(r110, "<set-?>");
            r16.c = r110;
            String r111 = (String) CollectionsKt.getOrNull(r7, r12);
            if (r111 != null) goto L44;
            r111 = "";
        L44:
            Intrinsics.checkNotNullParameter(r111, "<set-?>");
            r16.d = r111;
            Integer r112 = (Integer) CollectionsKt.getOrNull(r8, r12);
            if (r112 == null) goto L47;
            int r113 = r112.intValue();
        L48:
            r16.e = r113;
            String r114 = (String) CollectionsKt.getOrNull(r9, r12);
            if (r114 != null) goto L51;
            r114 = "";
        L51:
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r16.f = r114;
            r10.put(r15, r16);
            r12 = r14;
            goto L28
        L47:
            r113 = 0;
            goto L48
        L52:
            r1 = r10;
            goto L54
        }

        @Override // com.ss.android.lark.forwardv3.RemoteDoubaoForwardContentListener
        public void onFailed(String r2, String r3) {
            this.$callback.onFailed(r2, r3);
        }
    }

    public static final class a implements Parcelable.Creator<DoubaoOnForwardContentListener> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoOnForwardContentListener createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new DoubaoOnForwardContentListener(r2);
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

    public DoubaoOnForwardContentListener(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this.a = RemoteDoubaoForwardContentListener.Stub.asInterface(r2.readStrongBinder());
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final void onFailed(String r5) {
        StringBuilder r0 = new StringBuilder("doubao forward content listener onFailed: hasErrorTitle=");
        boolean r1 = false;
        r0.append(false);
        r0.append(", hasErrorMessage=");
        if (r5 != null) goto L5;
    L6:
        r1 = true;
    L7:
        r0.append(!r1);
        Log.w("NewForward", r0.toString());
        RemoteDoubaoForwardContentListener r2 = this.a;     // Catch: RemoteException -> L12
        if (r2 == null) goto L17;
        r2.onFailed(null, r5);     // Catch: RemoteException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        Log.e("NewForward", "onFailed doubao forward content listener error", e);
        return;
    L5:
        if (StringsKt.isBlank(r5) == false) goto L7;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        RemoteDoubaoForwardContentListener r3 = this.a;
        if (r3 == null) goto L5;
        IBinder r4 = r3.asBinder();
    L6:
        r1.writeStrongBinder(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
    public final boolean m(Activity r2, Map<String, ? extends ForwardTargetBaseInfoNew> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        Log.i("NewForward", "doubao forward content listener onSuccess: resultCount=" + r3.size() + ", allowToast=" + r4);
        RemoteDoubaoForwardContentListener r0 = this.a;     // Catch: RemoteException -> L7
        if (r0 == null) goto L12;
        return r0.onSuccess(g.a(r3));
    L12:
        return true;
    L7:
        e = move-exception;
        Log.e("NewForward", "onSuccess doubao forward content listener error", e);
        return true;
    }
}
