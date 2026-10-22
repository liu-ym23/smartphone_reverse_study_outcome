package com.ss.android.lark.feed.shared.openfeed;

import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.feed.AppFeedCardButtonCallbackRequest;
import com.ss.android.lark.pb.feed.AppFeedCardButtonCallbackResponse;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedCardButtonsParamsFactory {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jv\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122<\b\u0002\u0010\u0013\u001a6\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/feed/shared/openfeed/FeedCardButtonsParamsFactory$FeedCardButtonsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "webHookingBtnID", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "callbackFeedCardButtonWebHook", BuildConfig.FLAVOR, "rustClient", "Lcom/bytedance/lark/rustclient/api/IRustClient;", "uiFeedCard", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "btnID", "encryptBtnID", "onStart", "Lkotlin/Function0;", "onFinish", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", IPortraitService.NAME, "isSuccess", "toast", "getWebHookingBtnID", "saveWebHookingBtnID", "removeWebHookingBtnID", "key", "onCleared", "Companion", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedCardButtonsViewModel extends ViewModel {
        public static final a Companion = null;
        private final CompositeDisposable disposable;
        private final Map<String, String> webHookingBtnID;

        public static final class a {
            public a() {
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ String a;
            public final /* synthetic */ FeedCardButtonsViewModel b;
            public final /* synthetic */ UIFeedCard c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Function2<Boolean, String, Unit> e;

            /* JADX WARN: Multi-variable type inference failed */
            public b(String r1, FeedCardButtonsViewModel r2, UIFeedCard r3, String r4, Function2<? super Boolean, ? super String, Unit> r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void accept(Object r5) {
                AppFeedCardButtonCallbackResponse r6 = (AppFeedCardButtonCallbackResponse) ((x) r5).c;
                String r0 = null;
                if (r6 == null) goto L5;
                AppFeedCardButtonCallbackResponse.StatusCode r1 = r6.mstatus;
            L7:
                if (r1 != AppFeedCardButtonCallbackResponse.StatusCode.SUCCESS) goto L9;
                boolean r2 = true;
            L10:
                if (r6 == null) goto L12;
                r0 = r6.mtoast;
            L12:
                Log.i("FeedCardButtonsParamsFactory", "callbackFeedCardButtonWebHook ok, isSuccess: " + r2 + ", btnID: " + this.a);
                FeedCardButtonsViewModel.access$removeWebHookingBtnID(this.b, this.c, this.d);
                Function2<Boolean, String, Unit> r7 = this.e;
                if (r7 == null) goto L16;
                r7.invoke(Boolean.valueOf(r2), r0);
                return;
            L16:
                return;
            L9:
                r2 = false;
                goto L10
            L5:
                r1 = null;
                goto L7
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ String a;
            public final /* synthetic */ FeedCardButtonsViewModel b;
            public final /* synthetic */ UIFeedCard c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Function2<Boolean, String, Unit> e;

            /* JADX WARN: Multi-variable type inference failed */
            public c(String r1, FeedCardButtonsViewModel r2, UIFeedCard r3, String r4, Function2<? super Boolean, ? super String, Unit> r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                Intrinsics.checkNotNullParameter(r4, "err");
                Log.e("FeedCardButtonsParamsFactory", "callbackFeedCardButtonWebHook fail: " + r4 + ", btnID: " + this.a);
                FeedCardButtonsViewModel.access$removeWebHookingBtnID(this.b, this.c, this.d);
                Function2<Boolean, String, Unit> r5 = this.e;
                if (r5 == null) goto L6;
                r5.invoke(Boolean.FALSE, null);
                return;
            }
        }

        static {
            Companion = new a();
        }

        public void onCleared() {
            this.disposable.clear();
        }

        public FeedCardButtonsViewModel() {
            this.webHookingBtnID = new LinkedHashMap();
            this.disposable = new CompositeDisposable();
        }

        private final String key(UIFeedCard r3) {
            return r3.getId() + '-' + FeedCardButtonsParamsFactory.a(r3);
        }

        public final String getWebHookingBtnID(UIFeedCard r2) {
            Intrinsics.checkNotNullParameter(r2, "uiFeedCard");
            return this.webHookingBtnID.get(key(r2));
        }

        private final void removeWebHookingBtnID(UIFeedCard r1, String r2) {
            this.webHookingBtnID.remove(key(r1));
        }

        private final void saveWebHookingBtnID(UIFeedCard r2, String r3) {
            this.webHookingBtnID.put(key(r2), r3);
        }

        public static final /* synthetic */ void access$removeWebHookingBtnID(FeedCardButtonsViewModel r0, UIFeedCard r1, String r2) {
            r0.removeWebHookingBtnID(r1, r2);
        }

        public final void callbackFeedCardButtonWebHook(l r21, UIFeedCard r22, String r23, String r24, Function0<Unit> r25, Function2<? super Boolean, ? super String, Unit> r26) {
            Intrinsics.checkNotNullParameter(r21, "rustClient");
            Intrinsics.checkNotNullParameter(r22, "uiFeedCard");
            Intrinsics.checkNotNullParameter(r23, "btnID");
            Intrinsics.checkNotNullParameter(r24, "encryptBtnID");
            Log.i("FeedCardButtonsParamsFactory", "callbackFeedCardButtonWebHook, btnID: " + r24);
            saveWebHookingBtnID(r22, r23);
            if (r25 == null) goto L5;
            r25.invoke();
        L5:
            this.disposable.add(t.b(r21.h(new d(new AppFeedCardButtonCallbackRequest.Builder().button_id(r23), AppFeedCardButtonCallbackResponse.ADAPTER, Command.POST_GATEWAY, null, null, com.ss.android.lark.pb.improto.Command.APP_FEED_CARD_BUTTON_CALLBACK, null, 152)).a()).observeOn(LarkRxSchedulers.mainThread()).subscribe(new b(r24, this, r22, r23, r26), new c(r24, this, r22, r23, r26)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void callbackFeedCardButtonWebHook$default(FeedCardButtonsViewModel r9, l r10, UIFeedCard r11, String r12, String r13, Function0 r14, Function2 r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L5;
            Function0 r7 = null;
        L7:
            if ((r16 & 32) == 0) goto L9;
            Function2 r8 = null;
        L10:
            r9.callbackFeedCardButtonWebHook(r10, r11, r12, r13, r7, r8);
            return;
        L9:
            r8 = r15;
            goto L10
        L5:
            r7 = r14;
            goto L7
        }
    }

    static {
    }

    public static String a(UIFeedCard r9) {
        ArrayList<FeedCardButton> r0 = r9.getFeedCardButtons();
        if (r0 == null) goto L6;
        String r10 = CollectionsKt.joinToString$default(r0, "-", null, null, 0, null, FeedCardButtonsParamsFactory$getFeedCardButtonsID$1.INSTANCE, 30, null);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return BuildConfig.FLAVOR;
    }
}
