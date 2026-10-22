package ot0;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfilePoiInfo;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.view.ProfilePoiTagView;
import com.bytedance.android.livehostapi.business.depend.IShowPoiSearchCallback;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements IShowPoiSearchCallback {
    public final /* synthetic */ e a;
    public final /* synthetic */ long b;
    public final /* synthetic */ o c;
    public final /* synthetic */ NewProfileUser d;
    public final /* synthetic */ View e;
    public final /* synthetic */ f f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ gz.b b;

        public a(d r1, gz.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            qs0.d.a r9 = (qs0.d.a) r8;
            boolean r0 = false;
            f2.b(2131915320, 0);
            d r10 = this.a;
            e r1 = r10.a;
            gz.b r2 = this.b;
            View r3 = r10.e;
            NewProfileUser r4 = r10.d;
            f r12 = r10.f;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "poiInfo");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "user");
            Intrinsics.checkNotNullParameter(r12, Constants.Keys.DATA);
            if (r2.a == true) goto L5;
        L17:
            ProfilePoiInfo r13 = r4.baseProfileInfo.poiInfo;
            if (r13 == null) goto L20;
            r13.setPoiId(0);
            r13.setPoiIdStr("");
            r13.setContent("");
        L20:
            r3.setVisibility(8);
            return;
        L5:
            if (r2.c.length() <= 0) goto L7;
            r0 = true;
        L7:
            if (r0 == false) goto L17;
            r12.b = s1.B(2131915342) + r4.baseProfileInfo.poiInfo.getCity() + " | " + r2.b;
            ProfilePoiInfo r5 = r4.baseProfileInfo.poiInfo;
            if (r5 == null) goto L12;
            r5.setPoiId(CastLongProtector.parseLong(r2.c));
            r5.setPoiIdStr(r2.c);
            r5.setContent(r12.b);
        L12:
            if ((r3 instanceof ProfilePoiTagView) == true) goto L14;
            r3 = null;
        L14:
            ProfilePoiTagView r6 = (ProfilePoiTagView) r3;
            if (r6 == null) goto L22;
            r6.b(r12, r4);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final void onSearchFinish(gz.b r7) {
        Intrinsics.checkNotNullParameter(r7, "poiInfo");
        boolean r1 = false;
        if (r7.a == true) goto L5;
    L8:
        o r0 = this.c;
        Observable<qs0.d.a> r2 = null;
        if (r0 == null) goto L15;
        m r3 = r0.getRoom();
        if (r3 == null) goto L15;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L15;
        Long r5 = Long.valueOf(r4.getRoomId());
    L16:
        qs0.d r6 = os0.b.c().getIBroadcastService();
        if (r6 == null) goto L28;
        if (r5 == null) goto L20;
        long r8 = r5.longValue();
    L22:
        if (r7.c.length() <= 0) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L26;
        long r9 = CastLongProtector.parseLong(r7.c);
    L27:
        r2 = r6.f(r8, r9);
        goto L28
    L26:
        r9 = -1;
        goto L27
    L20:
        r8 = this.d.getLiveRoomId();
    L28:
        if (r2 == null) goto L35;
        Observable r10 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r10 == null) goto L36;
        ObservableSubscribeProxy r12 = (ObservableSubscribeProxy) r10.as(AutoDispose.bind(this.a.a));
        if (r12 == null) goto L37;
        r12.subscribe(new a(this, r7), b.a);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L15:
        r5 = null;
        goto L16
    L5:
        if (TextUtils.equals(String.valueOf(this.b), r7.c) == false) goto L8;
        f2.b(2131915319, 0);
    }

    public d(e r1, long r2, o r4, NewProfileUser r5, View r6, f r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
