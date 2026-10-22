package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.api.IAiBrokerAbilityApi;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ga2.d;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/RequestViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityTextViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RequestViewHolder extends QuickAbilityTextViewHolder {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RequestViewHolder a;
        public final /* synthetic */ ia2.b b;

        public a(RequestViewHolder r1, ia2.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
            ia2.b r6 = this.b;
            if (r6 == null) goto L5;
            r6.b = false;
        L5:
            this.a.W3();
            this.a.X3("success", this.b, null);
            d.a("RequestViewHolder request success");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RequestViewHolder a;
        public final /* synthetic */ ia2.b b;

        public b(RequestViewHolder r1, ia2.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            ia2.b r0 = this.b;
            if (r0 == null) goto L5;
            r0.b = false;
        L5:
            this.a.W3();
            int r1 = d.a;
            StringBuilder r2 = new StringBuilder("RequestViewHolder request error: ");
            String r3 = null;
            if (r6 == null) goto L8;
            String r4 = r6.getMessage();
        L9:
            r2.append(r4);
            String r7 = r2.toString();
            Intrinsics.checkNotNullParameter(r7, "msg");
            ALogger.e("PSSelectedAiAgent", r7);
            if ((r6 instanceof ApiServerException) == true) goto L12;
            r6 = null;
        L12:
            ApiServerException r8 = (ApiServerException) r6;
            if (r8 == null) goto L15;
            r3 = r8.getPrompt();
        L15:
            if (r3 == null) goto L17;
            f2.c(r3, 0);
        L17:
            this.a.X3("fail#2", this.b, r3);
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    public RequestViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityTextViewHolder, com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public final boolean V3(ia2.b r8) {
        CompositeDisposable r0 = null;
        if (r8 != null) goto L5;
    L8:
        if (r8 == null) goto L10;
        r8.b = true;
    L10:
        TextView r2 = this.d;
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.u(r2);
    L13:
        LottieAnimationView r3 = this.e;
        if (r3 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r3);
    L16:
        LottieAnimationView r4 = this.e;
        if (r4 == null) goto L19;
        r4.playAnimation();
    L19:
        IAiBrokerAbilityApi r5 = (IAiBrokerAbilityApi) c.b().e(IAiBrokerAbilityApi.class);
        if (r5 == null) goto L47;
        ia2.a r6 = this.a;
        if (r6 == null) goto L24;
        long r7 = r6.getRoomId();
    L25:
        ia2.a r9 = this.a;
        if (r9 == null) goto L29;
        String r10 = r9.getAnchorId();
        if (r10 == null) goto L29;
    L30:
        if (r8 == null) goto L34;
        Ability r11 = r8.a;
        if (r11 == null) goto L34;
        Map<String, String> r13 = r11.getParams();
    L35:
        Single<com.bytedance.android.live.network.response.a> r14 = r5.request(r7, r10, r13);
        if (r14 == null) goto L47;
        Single r15 = r14.subscribeOn(Schedulers.io());
        if (r15 == null) goto L47;
        Single r16 = r15.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L47;
        Disposable r17 = r16.subscribe(new a(this, r8), new b(this, r8));
        if (r17 == null) goto L47;
        ia2.a r18 = this.a;
        if (r18 == null) goto L46;
        r0 = r18.getCompositeDisposable();
    L46:
        RxUtilKt.c(r17, r0);
    L34:
        r13 = null;
    L29:
        r10 = BuildConfig.FLAVOR;
        goto L30
    L24:
        r7 = 0;
    L47:
        return true;
    L5:
        if (r8.b != true) goto L8;
        X3("fail#1", r8, null);
        d.a("RequestViewHolder onItemClick isLoading");
        return false;
    }

    public final void X3(String r5, ia2.b r6, String r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        ia2.a r1 = this.a;
        if (r1 != null) goto L5;
    L7:
        String r2 = "expand#1";
    L8:
        r0.put("show_type", r2);
        if (r6 == null) goto L14;
        Ability r8 = r6.a;
        if (r8 == null) goto L14;
        String r9 = r8.getText();
        if (r9 == null) goto L14;
    L15:
        r0.put("hotkey_text", r9);
        r0.put("result_name", r5);
        if (r7 == null) goto L18;
        r0.put("fail_toast_text", r7);
    L18:
        r0.put("msg_show_area", "ai_assistant");
        int r10 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a;
        ia2.a r11 = this.a;
        if (r11 == null) goto L23;
        WeakReference<DataCenter> r13 = r11.getDataCenter();
        if (r13 == null) goto L23;
        DataCenter r14 = r13.get();
    L24:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r0, r14);
        j0.l().sendLog("livesdk_public_screen_ai_assistant_hotkey_result", r0, new Object[]{Room.class});
        return;
    L23:
        r14 = null;
    L14:
        r9 = BuildConfig.FLAVOR;
        goto L15
    L5:
        if (r1.isMessageListEmpty() != true) goto L7;
        r2 = "expand#0";
        goto L8
    }
}
