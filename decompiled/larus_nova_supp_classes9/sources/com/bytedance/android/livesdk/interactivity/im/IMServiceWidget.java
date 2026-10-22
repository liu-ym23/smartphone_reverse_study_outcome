package com.bytedance.android.livesdk.interactivity.im;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.im.ConsultInfo;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ev1.q;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/im/IMServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMServiceWidget extends RoomRecyclableWidget {
    public final int a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ IMServiceWidget a;

        public a(IMServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            y3.m(((Widget) this.a).dataCenter).k(ToolbarButton.LIVE_IM_ENTRANCE, new IMToolbarBehavior(new BitmapDrawable((Bitmap) r5)));
        }
    }

    public static final class b implements ToolbarComponentCheckInterface {
        public final /* synthetic */ IMServiceWidget a;
        public final /* synthetic */ Room b;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ ToolbarMatchInterface a;
            public final /* synthetic */ Function0 b;
            public final /* synthetic */ Function1 c;

            public a(ToolbarMatchInterface r1, Function0 r2, Function1 r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r3) {
                Bitmap r4 = (Bitmap) r3;
                if (r4 == null) goto L6;
                this.a.setExtraDataAfterCheck(new BitmapDrawable(r4));
                this.b.invoke();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.im.IMServiceWidget$b$b, reason: collision with other inner class name */
        public static final class C0162b<T> implements Consumer {
            public final /* synthetic */ ToolbarMatchInterface a;
            public final /* synthetic */ Function0 b;
            public final /* synthetic */ Function1 c;

            public C0162b(ToolbarMatchInterface r1, Function0 r2, Function1 r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                this.c.invoke(" load im icon failed.");
            }
        }

        public b(IMServiceWidget r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r9, Function0<Unit> r10, Function1<? super String, Unit> r11) {
            Intrinsics.checkNotNullParameter(r9, "model");
            Intrinsics.checkNotNullParameter(r10, "loadButton");
            Intrinsics.checkNotNullParameter(r11, "stopLoadCallback");
            IHostBusiness r0 = k.f(IHostBusiness.class);
            if (r0 == null) goto L7;
            IHostIMService r1 = r0.getHostIMService();
            if (r1 == null) goto L7;
            Boolean r2 = Boolean.valueOf(r1.isEnable());
        L9:
            if ((!Intrinsics.areEqual(r2, Boolean.TRUE)) == false) goto L12;
            r11.invoke(" im is not enabled.");
            return true;
        L12:
            Ref.ObjectRef r3 = new Ref.ObjectRef();
            Room r4 = this.b;
            if (r4 == null) goto L17;
            IMIndustryServiceInfo r5 = r4.getImIndustryServiceInfo();
            if (r5 == null) goto L17;
            ImageModel r6 = r5.get_icon();
        L18:
            r3.element = r6;
            if (((Boolean) q.d.getValue()).booleanValue() == false) goto L35;
            Room r7 = this.b;
            if (r7 == null) goto L29;
            IMIndustryServiceInfo r8 = r7.getImIndustryServiceInfo();
            if (r8 == null) goto L29;
            ConsultInfo r13 = r8.get_consultInfo();
            if (r13 == null) goto L29;
            if (r13.get_roles() != 2) goto L29;
            boolean r14 = true;
        L31:
            if (r14 == false) goto L33;
            List r15 = CollectionsKt.listOf(new String[]{q.a + "live_toolbar_ic_v2_im_clientservice_static_3.png", q.b + "live_toolbar_ic_v2_im_clientservice_static_3.png", q.c + "live_toolbar_ic_v2_im_clientservice_static_3.png"});
        L34:
            r3.element = ImageModel.genBy(BuildConfig.FLAVOR, r15);
            goto L35
        L33:
            r15 = CollectionsKt.listOf(new String[]{q.a + "live_toolbar_ic_v2_im_normaluser_static_3.png", q.b + "live_toolbar_ic_v2_im_normaluser_static_3.png", q.c + "live_toolbar_ic_v2_im_normaluser_static_3.png"});
        L29:
            r14 = false;
        L35:
            ImageModel r16 = (ImageModel) r3.element;
            if (r16 == null) goto L39;
            int r17 = this.a.a;
            if (((ObservableSubscribeProxy) a1.l(r16, r17, r17, true, null).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this.a))).subscribe(new a(r9, r10, r11), new C0162b(r9, r10, r11)) == null) goto L39;
        L40:
            return true;
        L39:
            r11.invoke(" im icon is null.");
        L17:
            r6 = null;
        L7:
            r2 = null;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            b82.a.a("load icon failed : ", (Throwable) r2);
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public IMServiceWidget() {
        this.a = s1.f(20.0f);
    }

    public final void onLoad(Object[] r6) {
        DataCenter r7 = ((Widget) this).dataCenter;
        IMIndustryServiceInfo r0 = null;
        if (r7 == null) goto L8;
        Object r8 = r7.get("data_room", null);
        if ((r8 instanceof Room) == true) goto L7;
        r8 = null;
    L7:
        Room r9 = (Room) r8;
    L10:
        if (u40.a.b() == false) goto L13;
        Lazy r1 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(((Widget) this).dataCenter, NewToolbarButtonConstants.ToolbarIM.INSTANCE, new b(this, r9));
        return;
    L13:
        IHostBusiness r2 = k.f(IHostBusiness.class);
        if (r2 == null) goto L18;
        IHostIMService r3 = r2.getHostIMService();
        if (r3 == null) goto L18;
        Boolean r4 = Boolean.valueOf(r3.isEnable());
    L20:
        if (r9 == null) goto L45;
        IMIndustryServiceInfo r5 = r9.getImIndustryServiceInfo();
        if (r5 == null) goto L45;
        if (r5.get_isEntranceOpen() != true) goto L45;
        IMIndustryServiceInfo r10 = r9.getImIndustryServiceInfo();
        if (r10 == null) goto L28;
        ImageModel r11 = r10.get_icon();
    L29:
        if (r11 == null) goto L45;
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L45;
        IMIndustryServiceInfo r13 = r9.getImIndustryServiceInfo();
        if (r13 == null) goto L38;
        ConsultInfo r14 = r13.getConsultInfo();
        if (r14 == null) goto L38;
        if (r14.get_roles() != 2) goto L38;
    L44:
        boolean r15 = true;
    L46:
        if (r15 == false) goto L54;
        if (r9 == null) goto L51;
        IMIndustryServiceInfo r16 = r9.getImIndustryServiceInfo();
        if (r16 == null) goto L51;
        ImageModel r17 = r16.get_icon();
    L52:
        if (r17 == null) goto L59;
        int r18 = this.a;
        ((ObservableSubscribeProxy) a1.l(r17, r18, r18, true, null).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(this))).subscribe(new a(this), c.a);
        return;
    L59:
        return;
    L51:
        r17 = null;
        goto L52
    L54:
        int r19 = b82.a.a;
        StringBuilder r20 = new StringBuilder("IM entrance disabled, ");
        if (r9 == null) goto L57;
        r0 = r9.imIndustryServiceInfo;
    L57:
        r20.append(r0);
        r20.append(", service state : ");
        r20.append(r4);
        String r21 = r20.toString();
        Intrinsics.checkNotNullParameter(r21, "msg");
        ALogger.d("TTLIVE_IM_INDUSTRY", r21);
        return;
    L38:
        IMIndustryServiceInfo r23 = r9.getImIndustryServiceInfo();
        if (r23 == null) goto L45;
        ConsultInfo r24 = r23.getConsultInfo();
        if (r24 == null) goto L45;
        if (r24.get_roles() != 1) goto L45;
    L28:
        r11 = null;
    L45:
        r15 = false;
    L18:
        r4 = null;
        goto L20
    L8:
        r9 = null;
        goto L10
    }
}
