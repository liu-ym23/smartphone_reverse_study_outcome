package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LandscapeTopMoreAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.schema.event.OpenNativePanelEvent;
import com.bytedance.android.livesdk.schema.event.OpenVsPanelEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements yr1.r, com.bytedance.android.scope.o {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((OpenNativePanelEvent) r1).getType() != 0) goto L6;
            this.a.invoke();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function3 a;

        public b(Function3 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            OpenVsPanelEvent r5 = (OpenVsPanelEvent) r4;
            this.a.invoke(r5.getUri(), Integer.valueOf(r5.getType()), r5.getDismissListener());
        }
    }

    public y() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.r
    public final void k() {
        xs2.b.a().post(new do1.b());
    }

    @Override // yr1.r
    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        return b4.c.a.e(r2);
    }

    @Override // yr1.r
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        b4.c.a.b(r2);
    }

    @Override // yr1.r
    public final boolean h(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        return h3.a(r2);
    }

    @Override // yr1.r
    public final boolean i(boolean r1) {
        return u40.a.c(r1);
    }

    @Override // yr1.r
    public final void j(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "allButtonKey");
        b4.c.a.f(r2);
    }

    @Override // yr1.r
    public final void a(LifecycleOwner r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((ObservableSubscribeProxy) xs2.b.a().b(OpenNativePanelEvent.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r3))).subscribe(new a(r4));
    }

    @Override // yr1.r
    public final void f(LifecycleOwner r3, Function3<? super Uri, ? super Integer, ? super DialogInterface.OnDismissListener, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((ObservableSubscribeProxy) xs2.b.a().b(OpenVsPanelEvent.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r3))).subscribe(new b(r4));
    }

    @Override // yr1.r
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e n(ExtendedToolbarButton r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "extendedToolbarButton");
        Intrinsics.checkNotNullParameter("活动", LiveEndPageData.TAG_TITLE);
        Intrinsics.checkNotNullParameter(r4, "iconUrl");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r0 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(r3);
        Intrinsics.checkNotNullParameter("活动", "<set-?>");
        r0.f = "活动";
        r0.c = r4;
        r0.a = true;
        r0.i = 1;
        return r0;
    }

    @Override // yr1.r
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z<pp1.c> createToolbarBubble(DataCenter r2, Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "view");
        return new q2(r2, r3, r4);
    }

    @Override // yr1.r
    public final LandscapeTopMoreAdapter c(Context r9, DataCenter r10, List r11, int r12, int r13, final Function1 r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r11, "buttonList");
        Intrinsics.checkNotNullParameter(r14, "onClickListener");
        return new LandscapeTopMoreAdapter(r9, r10, r11, r12, r13, new VSToolbarService$createLandscapeTopMoreAdapter$1(r14));
    }
}
