package com.bytedance.android.live.ktv.common.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.ktvapi.model.mv.a;
import com.bytedance.android.livesdk.ktvapi.model.mv.b;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.g;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.message.model.od;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002JG\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022-\b\u0002\u0010\f\u001a'\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006J&\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000fJ\b\u0010\u0012\u001a\u00020\u000bH\u0014R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00188\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR-\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u001fj\b\u0012\u0004\u0012\u00020\u001a` 0\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/ktv/common/viewmodel/OpusPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "", "isCurrentMvEmpty", "newRound", "loadMore", "Lkotlin/Function2;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/a;", "Lkotlin/ParameterName;", "name", "fromRequest", "", "mvListCallback", "requestMvList", "isRefresh", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/b;", "changeMvList", "onCleared", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/f;", "model", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/f;", "getModel", "()Lcom/bytedance/android/livesdk/ktvapi/model/mv/f;", "Landroidx/lifecycle/LiveData;", "", "Lcom/bytedance/android/livesdk/message/model/od;", "officialMvList", "Landroidx/lifecycle/LiveData;", "getOfficialMvList", "()Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "opusMvList", "getOpusMvList", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;", "songInfo", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;", "getSongInfo", "()Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "opusServie", "<init>", "(Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewViewModel extends ViewModel {
    private final f model;
    private final LiveData<List<od>> officialMvList;
    private final LiveData<ArrayList<od>> opusMvList;
    private final k songInfo;

    private final boolean isCurrentMvEmpty() {
        List r0 = (List) this.officialMvList.getValue();
        if (r0 != null) goto L5;
    L6:
        ArrayList r1 = (ArrayList) this.opusMvList.getValue();
        if (r1 != null) goto L9;
        return true;
    L9:
        if ((!r1.isEmpty()) != true) goto L14;
    L11:
        return false;
    L14:
        return true;
    L5:
        if ((!r0.isEmpty()) == true) goto L11;
        goto L6
    }

    public final f getModel() {
        return this.model;
    }

    public final LiveData<List<od>> getOfficialMvList() {
        return this.officialMvList;
    }

    public final LiveData<ArrayList<od>> getOpusMvList() {
        return this.opusMvList;
    }

    public final k getSongInfo() {
        return this.songInfo;
    }

    public void onCleared() {
        super.onCleared();
    }

    public OpusPreviewViewModel(g r3, k r4) {
        Intrinsics.checkNotNullParameter(r3, "opusServie");
        Intrinsics.checkNotNullParameter(r4, "songInfo");
        this.songInfo = r4;
        f r5 = r3.l(r4.e, r4.f);
        this.model = r5;
        this.officialMvList = r5.f();
        this.opusMvList = r5.j();
    }

    public final void changeMvList(boolean r2, Function1<? super b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "mvListCallback");
        this.model.b(r2, r3);
    }

    public final void requestMvList(boolean r2, boolean r3, final Function2<? super a, ? super Boolean, Unit> r4) {
        if (isCurrentMvEmpty() == false) goto L6;
        if (r2 == false) goto L6;
        this.model.k(true, new AnonymousClass1(r4));
        return;
    L6:
        if (r2 == false) goto L8;
        this.model.c(new AnonymousClass2(this, r4));
        return;
    L8:
        if (r3 == false) goto L13;
        this.model.k(false, AnonymousClass3.INSTANCE);
        return;
    }

    public static /* synthetic */ void changeMvList$default(OpusPreviewViewModel r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.changeMvList(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestMvList$default(OpusPreviewViewModel r0, boolean r1, boolean r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.requestMvList(r1, r2, r3);
    }
}
