package com.bytedance.android.livesdk.gift.vs.panel.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.z3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import uz0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/viewmodel/VSGiftDialogViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "roomId", "episodeId", BuildConfig.FLAVOR, "giftScene", BuildConfig.FLAVOR, "syncVSGuestList", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/gift/model/z3;", "info", "Landroidx/lifecycle/MutableLiveData;", "getInfo", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", BuildConfig.FLAVOR, "fadingEdge", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getFadingEdge", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftDialogViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final NextLiveData<Boolean> fadingEdge;
    private final MutableLiveData<z3> info;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ VSGiftDialogViewModel a;

        public a(VSGiftDialogViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            if (r3 == null) goto L8;
            z3 r4 = (z3) r3.data;
            if (r4 == null) goto L9;
            this.a.getInfo().setValue(r4);
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

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public VSGiftDialogViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.info = new MutableLiveData();
        this.fadingEdge = new NextLiveData();
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final NextLiveData<Boolean> getFadingEdge() {
        return this.fadingEdge;
    }

    public final MutableLiveData<z3> getInfo() {
        return this.info;
    }

    public final void syncVSGuestList(long r15, long r17, int r19) {
        tz0.b r1 = tz0.b.a;
        e r2 = new e();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map r3 = r2.e;
        Intrinsics.checkNotNullParameter(r3, "fieldsMap");
        String r4 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L5;
        r3.put("room_id", r4);
    L5:
        String r5 = Long.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("episode_id", "$this$setTo");
        if (r5 == null) goto L8;
        r3.put("episode_id", r5);
    L8:
        String r6 = Integer.valueOf(r19).toString();
        Intrinsics.checkNotNullParameter("gift_scene", "$this$setTo");
        if (r6 == null) goto L11;
        r3.put("gift_scene", r6);
    L11:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        RxUtilKt.c(f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/show/gift/guests/", TypesJVMKt.getJavaType(Reflection.typeOf(z3.class)), Extra.class, ((uz0.a) r2).d, ((uz0.a) r2).a, ((uz0.a) r2).b, ((uz0.a) r2).c, r2.e, r2.f, r2.g).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a), this.compositeDisposable);
    }
}
