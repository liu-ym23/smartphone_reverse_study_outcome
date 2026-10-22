package com.bytedance.android.live.revlink.impl.multianchor.precisefind;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.service.RingDrawable;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.live.revlink.impl.precisefind.FindPeopleStatus;
import com.bytedance.android.live.revlink.impl.precisefind.MultiPkPreciseFindContext;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import d51.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import zy0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/precisefind/MultiPkPreciseFindWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/precisefind/a;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiPkPreciseFindWidget extends LiveWidget implements com.bytedance.android.live.revlink.impl.precisefind.a {
    public final CompositeDisposable a;
    public d b;
    public final String c;
    public Disposable d;
    public Disposable e;
    public FindPeopleStatus f;
    public IBaseUser g;
    public List<? extends IBaseUser> h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiPkPreciseFindWidget a;
        public final /* synthetic */ int b;

        public b(MultiPkPreciseFindWidget r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            if (((int) r6.longValue()) != this.b) goto L10;
            i r7 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r7 == null) goto L7;
            r7.setText("");
        L7:
            i r8 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r8 == null) goto L17;
            r8.Z2(this.a.c);
            return;
        L17:
            return;
        L10:
            i r0 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r0 == null) goto L13;
            r0.i3();
        L13:
            i r1 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r1 == null) goto L19;
            r1.setText(String.valueOf(this.b - ((int) r6.longValue())));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.precisefind.a
    public final void lp() {
        c r0 = c.A0;
        String r1 = r0.r().S6() + "&url=" + r0.r().Y8();
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        ALogger.i("MultiPkPreciseFindWidget", "openFindPeopleInvitePanel openDialogSchema=".concat(r1));
        this.b = ((vy0.b) f.a(vy0.c.class)).U0(((Widget) this).context, new x0(r1).c(), null);
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.precisefind.a
    public final boolean nl() {
        FindPeopleStatus r0 = this.f;
        if (r0 != FindPeopleStatus.SELECT) goto L5;
    L8:
        return true;
    L5:
        if (r0 == FindPeopleStatus.INVITE) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.precisefind.a
    public final void so() {
        c r0 = c.A0;
        String r1 = r0.r().V4() + "&url=" + r0.r().f6();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("source", "circle_select_entry");
        String r3 = u.b(r1, r2);
        if (r3.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return;
    L8:
        ALogger.i("MultiPkPreciseFindWidget", "openFindPeopleSettingPanel openDialogSchema=".concat(r3));
        this.b = ((vy0.b) f.a(vy0.c.class)).U0(((Widget) this).context, new x0(r3).c(), null);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public MultiPkPreciseFindWidget() {
        this.a = new CompositeDisposable();
        StringBuilder r0 = new StringBuilder("https://");
        String r1 = k0.a;
        r0.append(k0.a);
        r0.append("/obj/live-android/ttlive_anim_pk_random_point.webp");
        this.c = r0.toString();
        this.f = FindPeopleStatus.UNKNOWN;
        new ArrayList();
    }

    @Override // com.bytedance.android.live.revlink.impl.precisefind.a
    public final boolean Ip() {
        return com.bytedance.android.live.revlink.impl.utils.u.b();
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiPkPreciseFindWidget$initDataContext$pair$1.INSTANCE);
        MultiPkPreciseFindContext r1 = (MultiPkPreciseFindContext) r0.getFirst();
        r1.getService().d(this);
        com.bytedance.live.datacontext.b.a(r1, Reflection.getOrCreateKotlinClass(MultiPkPreciseFindContext.class));
        this.a.add((Disposable) r0.getSecond());
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L6;
        r2.put("data_ignore_precise_invite_error_toast", Boolean.valueOf(c.A0.r().v5()));
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.dispose();
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.e;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public static List wq(JSONObject r8) {
        ArrayList r1 = new ArrayList();
        if (r8 != null) goto L12;
        return r1;
    L12:
        JSONArray r2 = JSONObjectProtectorUtils.getJSONArray(r8, "selectUserInfos");     // Catch: Exception -> L9
        int r3 = r2.length();     // Catch: Exception -> L9
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        r1.add((IBaseUser) l97.a.a.fromJson(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(JSONArrayProtectorUtils.getJSONObject(r2, r4), "user"), "user").toString(), TypesJVMKt.getJavaType(Reflection.typeOf(IBaseUser.class))));     // Catch: Exception -> L9
        r4 = r4 + 1;
    L11:
        return r1;
    L9:
        e = move-exception;
        ALogger.e("MultiPkPreciseFindWidget", "params=" + r8 + " exception=" + e);
        goto L11
    }

    @Override // com.bytedance.android.live.revlink.impl.precisefind.a
    public final void ro(JSONObject r12) {
        List<? extends IBaseUser> r3 = CollectionsKt.emptyList();
        FindPeopleStatus r4 = FindPeopleStatus.UNKNOWN;
        IBaseUser r6 = null;
        int r7 = 10;
    L36:
        e = move-exception;
        List<? extends IBaseUser> r1 = r3;
        Exception e = e;
    L38:
        ALogger.e("MultiPkPreciseFindWidget", "params=" + r12 + " exception=" + e);
        IBaseUser r0 = r6;
    L39:
        ALogger.i("MultiPkPreciseFindWidget", "updateFindPeopleStatus currentUser=" + r0 + " newStatus=" + r4 + ", duration=" + r7);
        if (r4 != FindPeopleStatus.SELECT) goto L52;
        this.h = r1;
        if (r1.isEmpty() == true) goto L87;
        i r13 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r13 == null) goto L47;
        r13.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
    L47:
        Ref.IntRef r14 = new Ref.IntRef();
        r14.element = 0;
        int r2 = ((r1.size() + r7) - 1) / r1.size();
        Disposable r5 = this.e;
        if (r5 == null) goto L50;
        r5.dispose();
    L50:
        this.e = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) r7) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.multianchor.precisefind.a(r2, r1, r14));
        xq(r7);
        this.f = r4;
        return;
    L87:
        return;
    L52:
        if (r4 != FindPeopleStatus.INVITE) goto L65;
        Disposable r15 = this.e;
        if (r15 == null) goto L56;
        r15.dispose();
    L56:
        this.g = r0;
        if (r0 == null) goto L83;
        i r16 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r16 == null) goto L61;
        r16.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
    L61:
        i r17 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r17 == null) goto L64;
        r17.e3(r0.getAvatarThumbKt());
    L64:
        xq(r7);
        this.f = r4;
        return;
    L83:
        return;
    L65:
        Disposable r18 = this.e;
        if (r18 == null) goto L68;
        r18.dispose();
    L68:
        Disposable r19 = this.d;
        if (r19 == null) goto L72;
        r19.dispose();
    L72:
        if (nl() == false) goto L85;
        this.f = FindPeopleStatus.UNKNOWN;
        i r110 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r110 == null) goto L86;
        r110.n3(!y.d());
        return;
    L86:
        return;
    L85:
        return;
    L4:
        if (StringsKt.contains$default(String.valueOf(r12), "currentInviteUserInfo", false, 2, null) == false) goto L17;
        if (r12 == null) goto L14;
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r12, "currentInviteUserInfo");     // Catch: Exception -> L36
        if (r8 == null) goto L14;
        JSONObject r9 = JSONObjectProtectorUtils.getJSONObject(r8, "user");     // Catch: Exception -> L36
        if (r9 == null) goto L14;
        JSONObject r10 = JSONObjectProtectorUtils.getJSONObject(r9, "user");     // Catch: Exception -> L36
        if (r10 == null) goto L14;
        String r20 = r10.toString();     // Catch: Exception -> L36
        if (r20 == null) goto L14;
    L15:
        r0 = (IBaseUser) l97.a.a.fromJson(r20, TypesJVMKt.getJavaType(Reflection.typeOf(IBaseUser.class)));     // Catch: Exception -> L36
    L79:
        r1 = wq(r12);     // Catch: Exception -> L33
        if (r12 != null) goto L81;
    L23:
        if (r12 == null) goto L26;
        r6 = r12.optString("status");     // Catch: Exception -> L21
    L26:
        if (Intrinsics.areEqual(r6, DataType.TRUE) == false) goto L30;
        FindPeopleStatus r111 = FindPeopleStatus.SELECT;     // Catch: Exception -> L21
    L28:
        r4 = r111;
        goto L39
    L30:
        if (Intrinsics.areEqual(r6, "2") == false) goto L39;
        r111 = FindPeopleStatus.INVITE;     // Catch: Exception -> L21
        goto L28
    L81:
        r7 = r12.optInt(Constants.Keys.duration);     // Catch: Exception -> L21
    L21:
        e = e;
    L35:
        r6 = r0;
    L33:
        e = move-exception;
        e = e;
        r1 = r3;
    L14:
        r20 = "";
        goto L15
    L17:
        r0 = null;
        goto L79
    }

    public final void xq(int r6) {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) r6) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6));
    }
}
