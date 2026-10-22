package com.bytedance.android.livesdk.chatroom.vs_impl.message;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import f52.d;
import f52.j;
import fq1.t;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import pm1.f;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BizAdMsgPanelViewManager implements d {
    public static final /* synthetic */ int n = 0;
    public final String a;
    public LinkedList<BusinessConfigure> b;
    public final CompositeDisposable c;
    public boolean d;
    public final Lazy<BusinessMsgView> e;
    public final Lazy f;
    public final b g;
    public int h;
    public final c i;
    public f52.b j;
    public final DataCenter k;
    public final Context l;
    public final ViewGroup m;

    public final class BizAdMsgTopView extends j<BusinessConfigure> {
        public final BusinessConfigure n;
        public final /* synthetic */ BizAdMsgPanelViewManager o;

        public final void a(DiscardReason r4) {
            Intrinsics.checkNotNullParameter(r4, "reason");
            BizAdMsgPanelViewManager r0 = this.o;
            int r1 = BizAdMsgPanelViewManager.n;
            r0.getClass();
            ALogger.w("BizAdMsgPannelView", "discard by " + r4);
            BizAdMsgPanelViewManager.d(this.o);
        }

        public final void h(f52.b r5) {
            Intrinsics.checkNotNullParameter(r5, "container");
            BizAdMsgPanelViewManager r0 = this.o;
            int r1 = BizAdMsgPanelViewManager.n;
            ViewParent r2 = r0.g().getParent();
            Long r3 = null;
            if ((r2 instanceof ViewGroup) == true) goto L5;
            r2 = null;
        L5:
            ViewGroup r4 = (ViewGroup) r2;
            if (r4 == null) goto L8;
            r4.removeView(this.o.g());
        L8:
            r5.b(this, this.o.g(), new ViewGroup.LayoutParams(-1, -1));
            BusinessResourceConfigure r6 = this.n.resourceConfig;
            if (r6 != null) goto L11;
            return;
        L11:
            if (r6.barrageConfig == null) goto L23;
            this.o.g().b(this.n, "business_info_portrait");
            BizAdMsgPanelViewManager r7 = this.o;
            BusinessMsgView r8 = r7.g();
            BusinessResourceConfigure r9 = this.n.resourceConfig;
            if (r9 == null) goto L16;
            r3 = Long.valueOf(r9.resourceId);
        L16:
            boolean r10 = r8.e(String.valueOf(r3), new BizAdMsgPanelViewManager$BizAdMsgTopView$onShow$1(this, r5));
            boolean r11 = true;
            if (r10 == true) goto L20;
            r11 = false;
        L20:
            r7.d = r11;
            return;
        }

        public final CleanStrategy i(f52.b r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            BizAdMsgPanelViewManager.d(this.o);
            return CleanStrategy.REMOVE_VIEWS;
        }

        public BizAdMsgTopView(BizAdMsgPanelViewManager r18, BusinessConfigure r19) {
            Intrinsics.checkNotNullParameter(r19, "nextShowMsg");
            this.o = r18;
            String r1 = "_bizad_" + System.currentTimeMillis() + r19.businessId;
            NativePSTopViewType r2 = NativePSTopViewType.BusinessMsg;
            ConflictStrategy r11 = ConflictStrategy.QUEUE;
            super(r1, r2, 0, 0, 0, 0, 0, r11, r11, ConflictStrategy.INTERRUPT, false, null, r19, 3072);
            this.n = r19;
        }

        public final CleanStrategy b(f52.b r2, f52.c r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            BizAdMsgPanelViewManager r4 = this.o;
            int r5 = BizAdMsgPanelViewManager.n;
            r4.getClass();
            ALogger.w("BizAdMsgPannelView", "interrupted");
            this.o.g().c(false, new BizAdMsgPanelViewManager$BizAdMsgTopView$onInterrupt$1(this));
            this.o.d = false;
            return CleanStrategy.REMOVE_VIEWS;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BizAdMsgPanelViewManager a;

        public b(BizAdMsgPanelViewManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.k();
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ BizAdMsgPanelViewManager a;

        public c(BizAdMsgPanelViewManager r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            BizAdMsgPanelViewManager r0 = this.a;
            if (r0.h > 0) goto L5;
            return;
        L5:
            if (r0.m.getWidth() <= (this.a.h + s1.f(5.0f))) goto L9;
            this.a.g().e.cancelMarquee();
            return;
        }
    }

    static {
    }

    public final BusinessMsgView g() {
        return (BusinessMsgView) this.f.getValue();
    }

    public final void k() {
        BusinessConfigure r1 = null;
        if (this.b != null) goto L13;
        u r0 = r.u(this.k, null, 2);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j<cq1.a> r2 = r0.f0();
        if (r2 == null) goto L11;
        cq1.a r3 = (cq1.a) r2.getValue();
        if (r3 == null) goto L11;
        LinkedList<BusinessConfigure> r4 = r3.b;
    L12:
        this.b = r4;
    L11:
        r4 = null;
    L13:
        LinkedList<BusinessConfigure> r5 = this.b;
        if (r5 != null) goto L16;
        return;
    L16:
        if (r5.isEmpty() == false) goto L18;
        return;
    L18:
        if (this.d == true) goto L53;
        LinkedList<BusinessConfigure> r6 = this.b;     // Catch: Exception -> L24
        if (r6 == null) goto L26;
        r1 = r6.removeFirst();     // Catch: Exception -> L24
    L26:
        if (r1 != null) goto L28;
        return;
    L28:
        BusinessResourceConfigure r7 = r1.resourceConfig;
        if (r7 != null) goto L31;
        return;
    L31:
        if (r7.barrageConfig == null) goto L51;
        String r8 = t.a().getCurrentUserId();
        dq1.c r9 = f.k();
        if (r9 != null) goto L35;
    L36:
        dq1.c r10 = f.k();
        if (r10 != null) goto L39;
    L42:
        f52.b r11 = this.j;
        if (r11 == null) goto L52;
        r11.a(new BizAdMsgTopView(this, r1));
        return;
    L52:
        return;
    L39:
        if (r10.c(r8, r1) == true) goto L42;
    L40:
        k();
        return;
    L35:
        if (r9.a(r1) == true) goto L40;
    L51:
        return;
    L24:
        e = move-exception;
        ALogger.i("BusinessConfigure", "try get next show msg fail, " + e.getMessage());
        goto L26
    }

    public final void onUnload() {
        u r0 = r.u(this.k, null, 2);
        if (r0 == null) goto L9;
        m<MutableLiveData<Boolean>> r1 = r0.B1();
        if (r1 == null) goto L9;
        MutableLiveData r2 = (MutableLiveData) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeObserver(this.g);
    L9:
        this.b = null;
        this.c.dispose();
        if (this.e.isInitialized() == false) goto L12;
        g().c(false, new AnonymousClass1(this));
    L12:
        this.d = false;
    }

    public final Context getContext() {
        return this.l;
    }

    public final String getId() {
        return this.a;
    }

    public static final void d(BizAdMsgPanelViewManager r1) {
        r1.h = -1;
        ViewTreeObserver r0 = r1.m.getViewTreeObserver();
        if (r0 == null) goto L6;
        r0.removeOnGlobalLayoutListener(r1.i);
        return;
    }

    public final void j(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        this.j = r3;
        k();
        u r4 = r.u(this.k, null, 2);
        if (r4 == null) goto L10;
        m<MutableLiveData<Boolean>> r5 = r4.B1();
        if (r5 == null) goto L11;
        MutableLiveData r6 = (MutableLiveData) r5.getValue();
        if (r6 == null) goto L12;
        r6.observeForever(this.g);
        return;
    L12:
        return;
    L11:
        return;
    }

    public BizAdMsgPanelViewManager(DataCenter r2, Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.a = "BizAdMsgPanelViewManager";
        this.c = new CompositeDisposable();
        Lazy<BusinessMsgView> r5 = LazyKt.lazy(new BizAdMsgPanelViewManager$businessMsgViewDelegate$1(this));
        this.e = r5;
        this.f = r5;
        this.g = new b(this);
        this.h = -1;
        this.i = new c(this);
    }
}
