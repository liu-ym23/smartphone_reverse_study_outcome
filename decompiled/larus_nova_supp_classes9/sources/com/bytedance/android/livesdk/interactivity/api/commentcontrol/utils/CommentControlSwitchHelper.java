package com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.api.CommentControlRetrofitApi;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentControlSwitchHelper {
    public static final e<Long> a = null;
    public static final e<Long> b = null;
    public static BaseDisplayText c;
    public static AdvancedDisplayText d;
    public static com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b e;
    public static Disposable f;
    public static Disposable g;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/utils/CommentControlSwitchHelper$AdvancedDisplayText;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/a;", "text", BuildConfig.FLAVOR, "updateAdvancedDisplayText", "Landroidx/lifecycle/MutableLiveData;", "_advancedDisplayText", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "getAdvancedDisplayText", "()Landroidx/lifecycle/LiveData;", "advancedDisplayText", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AdvancedDisplayText extends ViewModel {
        private final MutableLiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> _advancedDisplayText;

        public AdvancedDisplayText() {
            this._advancedDisplayText = new MutableLiveData();
        }

        public final LiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> getAdvancedDisplayText() {
            return this._advancedDisplayText;
        }

        public final void updateAdvancedDisplayText(com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this._advancedDisplayText.setValue(r2);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/utils/CommentControlSwitchHelper$BaseDisplayText;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/a;", "text", BuildConfig.FLAVOR, "updateBaseDisplayText", "Landroidx/lifecycle/MutableLiveData;", "_baseDisplayText", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "getBaseDisplayText", "()Landroidx/lifecycle/LiveData;", "baseDisplayText", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BaseDisplayText extends ViewModel {
        private final MutableLiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> _baseDisplayText;

        public BaseDisplayText() {
            this._baseDisplayText = new MutableLiveData();
        }

        public final LiveData<com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a> getBaseDisplayText() {
            return this._baseDisplayText;
        }

        public final void updateBaseDisplayText(com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this._baseDisplayText.setValue(r2);
        }
    }

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r1) {
            Response r2 = (Response) r1;
            if (r2 == null) goto L8;
            com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r3 = (com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b) ((BaseResponse) r2).data;
            if (r3 == null) goto L9;
            CommentControlSwitchHelper.e = r3;
            return;
        L9:
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

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "e");
            CommentControlSwitchHelper.e = null;
            ALogger.w("CommentControlSwitchHelper", "fetchCommentControlStatus error " + r4.getMessage());
        }
    }

    static {
        a = new e("live_comment_control_base_reddot", 0L);
        b = new e("live_comment_control_advanced_reddot", 0L);
        e = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    }

    @JvmStatic
    public static final long b() {
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b r0 = e;
        if (r0 != null) goto L6;
        r0 = new com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b();
    L6:
        return r0.b();
    }

    @JvmStatic
    public static final Long c() {
        long r0 = b();
        if (r0 != 0) goto L6;
        return (Long) a.getValue();
    L6:
        if (r0 == 1) goto L11;
        return null;
    L11:
        return (Long) b.getValue();
    }

    @JvmStatic
    public static final void d() {
        long r0 = b();
        if (r0 != 0) goto L6;
        e<Long> r1 = a;
        r1.getClass();
        f.d(r1, 1L);
        return;
    L6:
        if (r0 != 1) goto L10;
        e<Long> r2 = b;
        r2.getClass();
        f.d(r2, 1L);
        return;
    }

    public static void a(long r2) {
        f = ((CommentControlRetrofitApi) c.b().e(CommentControlRetrofitApi.class)).getCommentControlStatusRequest(r2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(a.a, b.a);
    }
}
