package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapePreviewControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapePreviewControlWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public final Lazy a;
    public boolean b;
    public boolean c;
    public final Set<Integer> d;
    public final SparseArray<View> e;
    public Room f;
    public final a g;
    public final View h;

    public static final class a implements Runnable {
        public final /* synthetic */ LandscapePreviewControlWidget a;

        public a(LandscapePreviewControlWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LandscapePreviewControlWidget r0 = this.a;     // Catch: Throwable -> L6
            if (r0.c == false) goto L9;
            r0.wq();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LandscapePreviewControlWidget a;

        public b(LandscapePreviewControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            UserProfileEvent r3 = (UserProfileEvent) r2;
            LandscapePreviewControlWidget r0 = this.a;
            if (r3 != null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.wq();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LandscapePreviewControlWidget a;

        public c(LandscapePreviewControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            o3 r3 = (o3) r2;
            LandscapePreviewControlWidget r0 = this.a;
            if (r3 != null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.wq();
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        ((Handler) this.a.getValue()).removeCallbacksAndMessages(null);
    }

    public final void wq() {
        if (this.c == true) goto L5;
        return;
    L5:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.put("need_hide_landscape_in_live_widget", Boolean.TRUE);
    L8:
        xq(true);
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L11;
        r1.put("data_is_hiding_landscape_buttons_in_preview", Boolean.TRUE);
    L11:
        this.b = true;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public LandscapePreviewControlWidget(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.h = r4;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LandscapePreviewControlWidget$mHandler$2.INSTANCE);
        this.c = true;
        this.d = SetsKt.mutableSetOf(new Integer[]{2131377131, 2131392032, 2131377127, 2131389813, 2131389816, 2131374770});
        this.e = new SparseArray();
        this.g = new a(this);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (isViewValid() == false) goto L27;
        String r0 = null;
        if (r4 == null) goto L7;
        String r1 = r4.getKey();
    L8:
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L29;
        if (r4 == null) goto L18;
        r0 = r4.getKey();
    L18:
        if (r0 != null) goto L21;
        return;
    L21:
        if (r0.hashCode() == (-2059899161)) goto L24;
        return;
    L24:
        if (r0.equals("cmd_show_landscape_rank_info_dialog") == false) goto L28;
        wq();
        return;
    L28:
        return;
    L29:
        return;
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
        goto L14
    L7:
        r1 = null;
        goto L8
    }

    public final void onLoad(Object[] r4) {
        DataCenter r5 = ((Widget) this).dataCenter;
        Room r0 = null;
        if (r5 == null) goto L5;
        r0 = (Room) r5.get("data_room", null);
    L5:
        this.f = r0;
        Iterator<T> r6 = this.d.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        int r1 = ((Number) r6.next()).intValue();
        this.e.put(r1, this.h.findViewById(r1));
        goto L7
    L9:
        L7(UserProfileEvent.class, new b(this));
        L7(o3.class, new c(this));
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L12;
        r7.observe("cmd_show_landscape_rank_info_dialog", this);
    L12:
        ((Handler) this.a.getValue()).postDelayed(this.g, 5000);
    }

    public final void xq(boolean r7) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Room r0 = this.f;
        if (r0 != null) goto L8;
    L10:
        int r1 = UtilityKotlinExtentionsKt.i(92);
    L12:
        if (this.b == r7) goto L39;
        Iterator<T> r2 = this.d.iterator();
    L15:
        if (r2.hasNext() == false) goto L53;
        int r3 = ((Number) r2.next()).intValue();
        SparseArray<View> r4 = this.e;
        View r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L26
        if (r4 == null) goto L20;
        View r8 = r4.get(r3);     // Catch: Throwable -> L26
    L21:
        if (r8 != null) goto L25;
        r8 = this.h.findViewById(r3);     // Catch: Throwable -> L26
        if (r4 == null) goto L25;
        r4.put(r3, r8);     // Catch: Throwable -> L26
    L25:
        r5 = r8;
    L28:
        if (r7 == false) goto L30;
        int r9 = -r1;
    L31:
        if (r5 == null) goto L15;
        ViewPropertyAnimator r10 = r5.animate();
        if (r10 == null) goto L15;
        ViewPropertyAnimator r11 = r10.setDuration(200);
        if (r11 == null) goto L15;
        ViewPropertyAnimator r12 = r11.translationY(r9);
        if (r12 == null) goto L15;
        r12.start();
        goto L15
    L30:
        r9 = 0;
        goto L31
    L20:
        r8 = null;
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L53:
        return;
    L39:
        return;
    L8:
        if (r0.isMediaRoom() != true) goto L10;
        r1 = UtilityKotlinExtentionsKt.i(100);
        goto L12
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }
}
