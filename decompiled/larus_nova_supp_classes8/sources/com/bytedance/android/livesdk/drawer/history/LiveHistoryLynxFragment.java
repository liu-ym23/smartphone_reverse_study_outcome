package com.bytedance.android.livesdk.drawer.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.jsbridge.base.CloseLiveHistoryPageResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.g8;
import w20.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/history/LiveHistoryLynxFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHistoryLynxFragment extends BaseFragment {
    public static boolean j;
    public static int k;
    public e d;
    public boolean e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final b i;

    public static final class a {
    }

    public static final class b extends y<g8, CloseLiveHistoryPageResultModel> {
        public final /* synthetic */ LiveHistoryLynxFragment b;

        public b(LiveHistoryLynxFragment r1) {
            this.b = r1;
        }

        public final void invoke(Object r2, CallContext r3) {
            g8 r4 = (g8) r2;
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            if (LiveEndPageData.TAG_AVATAR.equals(r4.a()) == false) goto L10;
            LiveHistoryLynxFragment r5 = this.b;
            if (r5.e == false) goto L20;
            e r6 = r5.d;
            if (r6 == null) goto L18;
            r6.c();
            return;
        L18:
            return;
        L20:
            return;
        L10:
            LiveHistoryLynxFragment r7 = this.b;
            if (r7.e == false) goto L21;
            e r8 = r7.d;
            if (r8 == null) goto L16;
            r8.a(false);
        L16:
            r7.f = false;
            return;
        }
    }

    public static final class c implements IHybridComponent.a {
        public final /* synthetic */ LiveHistoryLynxFragment a;

        public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return this.a.a.i;
            }
        }

        public c(LiveHistoryLynxFragment r1) {
            this.a = r1;
        }

        public final void onJSBridgeCreated(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            r3.registerMethod(((y) this.a.i).a, new a(this));
        }
    }

    static {
    }

    public final HybridCard T90() {
        return (HybridCard) this.h.getValue();
    }

    public final void S90() {
        if (this.e == false) goto L5;
        return;
    L5:
        e r0 = this.d;
        if (r0 == null) goto L9;
        r0.a(true);
    L9:
        if (this.f == true) goto L12;
        k.n(IExternalBrowserService.class).enqueueEvent("webcast.history.refresh", new JSONObject());
        ALogger.i("LiveHistoryLynxFragment", "send webcast.history.refresh event");
        return;
    }

    public LiveHistoryLynxFragment() {
        this.f = true;
        this.g = LazyKt.lazy(LiveHistoryLynxFragment$uri$2.INSTANCE);
        this.h = LazyKt.lazy(new LiveHistoryLynxFragment$lynxView$2(this));
        this.i = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        HybridCard r0 = T90();
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.f = true;
    }

    public final void onPause() {
        super.onPause();
        HybridCard r0 = T90();
        if (r0 == null) goto L6;
        r0.g(false, "page");
        return;
    }

    public final void onResume() {
        super.onResume();
        HybridCard r0 = T90();
        if (r0 == null) goto L6;
        r0.g(true, "page");
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        k = r3;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        HybridCard r5 = T90();
        if (r5 == null) goto L5;
        r5.setJSBridgeListener(new c(this));
    L5:
        HybridCard r6 = T90();
        if (r6 == null) goto L9;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("entrance", "drawer_hot");
        Unit r8 = Unit.INSTANCE;
        r6.load(null, r7);
    L9:
        return T90();
    }
}
