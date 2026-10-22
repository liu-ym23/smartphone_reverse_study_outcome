package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.chatroom.view.CommonIconEntryView;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements IShortTouchLifeCycle {
    public final e a;
    public vo1.i b;
    public Disposable c;
    public boolean d;
    public final Context e;
    public final com.bytedance.android.live.base.model.n f;
    public final DataCenter g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a$a, reason: collision with other inner class name */
    public static final class C0055a implements f.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ a b;
        public final /* synthetic */ Ref.ObjectRef c;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.b
        public final void b() {
            a r0 = this.b;
            if (r0.d == true) goto L14;
            Disposable r1 = r0.c;
            if (r1 == null) goto L7;
            r1.dispose();
        L7:
            CommonIconEntryView r2 = (CommonIconEntryView) this.c.element;
            if (r2 == null) goto L10;
            r2.removeAllViews();
        L10:
            CommonIconEntryView r3 = (CommonIconEntryView) this.c.element;
            if (r3 == null) goto L15;
            com.bytedance.android.live.base.model.q r4 = this.b.f.shortTouchInfo;
            r3.a(r4.imageUrl, r4.imgLayers);
            return;
        L15:
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.b
        public final void onLoadSuccess() {
            a r0 = this.b;
            if (r0.d == true) goto L28;
            vo1.i r1 = r0.b;
            if (r1 == null) goto L14;
            View r2 = r1.c();
            if (r2 == null) goto L14;
            CommonIconEntryView r3 = (CommonIconEntryView) this.c.element;
            if (r3 == null) goto L11;
            r3.removeView(r2);
        L11:
            r2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            CommonIconEntryView r4 = (CommonIconEntryView) this.c.element;
            if (r4 == null) goto L14;
            r4.addView(r2, 0);
        L14:
            a r5 = this.b;
            com.bytedance.android.live.base.model.n r6 = r5.f;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "info");
            JSONObject r7 = new JSONObject();
            r7.put("type", "init");
            int r8 = q.a;     // Catch: Throwable -> L17
            Intrinsics.checkNotNullParameter(r6, "$this$toJSONObject");     // Catch: Throwable -> L17
            JSONObject r9 = tv5.a.b(r6);     // Catch: Throwable -> L17
            r9.put("current_time", String.valueOf(p6.b()));     // Catch: Throwable -> L17
        L19:
            r7.put("data", r9);
            vo1.i r10 = r5.b;
            if (r10 == null) goto L22;
            r10.sendJsEvent("H5_shortTouchMessage", r7);
        L22:
            Disposable r11 = this.b.c;
            if (r11 == null) goto L29;
            r11.dispose();
            return;
        L29:
            return;
        L17:
            th = move-exception;
            ALogger.e("BigCardComponent", th);
            r9 = new JSONObject();
            goto L19
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.b
        public final void c(vo1.i r6) {
            Intrinsics.checkNotNullParameter(r6, "component");
            a r0 = this.b;
            r0.b = r6;
            if (r6 == null) goto L13;
            String r1 = this.a;
            com.bytedance.android.live.base.model.n r2 = r0.f;
            int r3 = q.a;     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r2, "$this$toJSONObject");     // Catch: Throwable -> L7
            JSONObject r4 = tv5.a.b(r2);     // Catch: Throwable -> L7
            r4.put("current_time", String.valueOf(p6.b()));     // Catch: Throwable -> L7
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
            Map<String, ? extends Object> r7 = q.c(r4);     // Catch: Throwable -> L7
        L9:
            r6.a(r1, r7);
            return;
        L7:
            th = move-exception;
            ALogger.e("BigCardComponent", th);
            r7 = null;
            goto L9
        }

        public C0055a(String r1, a r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ Ref.ObjectRef b;

        public b(a r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            this.a.d = true;
            CommonIconEntryView r5 = (CommonIconEntryView) this.b.element;
            if (r5 == null) goto L5;
            r5.removeAllViews();
        L5:
            CommonIconEntryView r6 = (CommonIconEntryView) this.b.element;
            if (r6 == null) goto L9;
            com.bytedance.android.live.base.model.q r0 = this.a.f.shortTouchInfo;
            r6.a(r0.imageUrl, r0.imgLayers);
            return;
        }
    }

    public final CommonIconEntryView a() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        CommonIconEntryView r1 = null;
        r0.element = null;
        com.bytedance.android.live.base.model.o r2 = this.f.shortTouchBigCard;
        if (r2 == null) goto L48;
        String r4 = r2.bigCardUrl;
        if (r4 != null) goto L7;
        String r5 = "";
    L30:
        e r6 = this.a;
        int r3 = r2.containerType;
        C0055a r7 = new C0055a(r5, this, r0);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r7, "callback");
        CommonIconEntryView r8 = new CommonIconEntryView(r6.a, null, 6, 0);
        if (r3 != 1) goto L39;
        int r9 = vo1.e.a;
        vo1.a r10 = new vo1.a();
        Context r11 = r6.a;
        if (r11 == null) goto L38;
        Activity r12 = (Activity) r11;
        i2.c(UriProtector.parse(r5), "load_taro", 1);     // Catch: Exception -> L50
    L36:
        r10.f(r12, r5, LynxThreadStrategy.ALL_ON_UI, new d(r6, r7, r5));
        r7.c(r10);
        r1 = r8;
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L39:
        r0.element = r1;
        if (r1 == null) goto L48;
        Intrinsics.checkNotNullParameter(r1, "container");
        com.bytedance.android.live.base.model.o r13 = this.f.shortTouchBigCard;
        if (r13 == null) goto L48;
        if (r13.width <= 0) goto L48;
        if (r13.height <= 0) goto L48;
        ViewGroup.LayoutParams r14 = r1.getLayoutParams();
        r14.width = UtilityKotlinExtentionsKt.i(r13.width);
        r14.height = UtilityKotlinExtentionsKt.i(r13.height);
        goto L48
    L7:
        IRoom r15 = (IRoom) this.g.get("data_room", null);
        Uri.Builder r16 = UriProtector.parse(r4).buildUpon().appendQueryParameter("request_page", "top").appendQueryParameter("enter_from_merge", k1.c()).appendQueryParameter("enter_method", k1.d()).appendQueryParameter("action_type", k1.b());
        if (r15 == null) goto L11;
        String r17 = r15.getRequestId();
        if (r17 == null) goto L11;
    L12:
        Uri.Builder r18 = r16.appendQueryParameter("request_id", r17);
        if (r15 == null) goto L16;
        String r19 = r15.getIdStr();
        if (r19 == null) goto L16;
    L17:
        Uri.Builder r20 = r18.appendQueryParameter("room_id", r19);
        if (r15 == null) goto L23;
        IBaseUser r21 = r15.getOwner();
        if (r21 == null) goto L23;
        String r22 = r21.getIdString();
        if (r22 == null) goto L23;
    L24:
        Uri.Builder r23 = r20.appendQueryParameter("anchor_id", r22);
        com.bytedance.android.livesdk.user.e r24 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r24 == null) goto L28;
        String r25 = r24.n();
        if (r25 == null) goto L28;
    L29:
        r5 = r23.appendQueryParameter("user_id", r25).appendQueryParameter("mix_container_bid", "live_short_touch_entrance").toString();
    L28:
        r25 = "";
    L23:
        r22 = "";
    L16:
        r19 = "";
    L11:
        r17 = "";
    L48:
        this.c = Observable.just("").delay(((Long) c5.a.getValue()).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r0));
        return (CommonIconEntryView) r0.element;
    }

    public final void onPause() {
        IShortTouchLifeCycle.DefaultImpls.onPause(this);
        this.a.onPause();
    }

    public final void onResume() {
        IShortTouchLifeCycle.DefaultImpls.onResume(this);
        this.a.onResume();
    }

    public final Context getContext() {
        return this.e;
    }

    public a(Context r2, com.bytedance.android.live.base.model.n r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = new e(r2, r3.type);
    }
}
