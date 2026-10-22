package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0005H\u0014J\t\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\r\u0010\u0016\u001a\u00020\u0005*\u00020\u0013H\u0096\u0001R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00178\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u00178\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00178\u0006¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/CommonShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/a;", "T", "Landroidx/lifecycle/ViewModel;", "", "", "initData", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "notifyShelfInfoChange", "source", "", "buildDisplayItemInfoList", "(Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/a;)Ljava/util/List;", "openLinkCastPage", "", "getLinkCastTips", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "shelfMicroAppInfo", "Landroidx/lifecycle/MutableLiveData;", "getShelfMicroAppInfo", "()Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "shelfCardInfoList", "getShelfCardInfoList", "displayItemInfoList", "getDisplayItemInfoList", "", "dismiss", "getDismiss", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CommonShelfDisplayViewModel<T extends a> extends ViewModel {
    private final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a $$delegate_0;
    private final MutableLiveData<Boolean> dismiss;
    private final MutableLiveData<List<Object>> displayItemInfoList;
    private final MutableLiveData<List<ShelfCardInfo>> shelfCardInfoList;
    private final MutableLiveData<ShelfMicroAppInfo> shelfMicroAppInfo;

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public abstract String getLinkCastTips();

    public abstract void openLinkCastPage();

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.$$delegate_0.c(r2);
    }

    public void initData() {
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r0 = MiniAppDataContext.a.a();
        if (r0 == null) goto L10;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L11;
        Disposable r2 = i80.a.b(r1, new AnonymousClass1(this));
        if (r2 == null) goto L12;
        autoDispose(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public CommonShelfDisplayViewModel() {
        this.$$delegate_0 = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.shelfMicroAppInfo = new MutableLiveData();
        this.shelfCardInfoList = new MutableLiveData();
        this.displayItemInfoList = new MutableLiveData();
        this.dismiss = new MutableLiveData();
    }

    public void onCleared() {
        super.onCleared();
        dispose();
    }

    public final MutableLiveData<Boolean> getDismiss() {
        return this.dismiss;
    }

    public final MutableLiveData<List<Object>> getDisplayItemInfoList() {
        return this.displayItemInfoList;
    }

    public final MutableLiveData<List<ShelfCardInfo>> getShelfCardInfoList() {
        return this.shelfCardInfoList;
    }

    public final MutableLiveData<ShelfMicroAppInfo> getShelfMicroAppInfo() {
        return this.shelfMicroAppInfo;
    }

    public List<Object> buildDisplayItemInfoList(T r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ArrayList r4 = new ArrayList();
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L5;
        r4.add(new wq0.a(getLinkCastTips()));
    L5:
        return r4;
    }

    public void notifyShelfInfoChange(ShelfInfo r2) {
        MutableLiveData<List<ShelfCardInfo>> r0 = this.shelfCardInfoList;
        if (r2 == null) goto L5;
        List<ShelfCardInfo> r3 = r2.cardInfoList;
    L6:
        r0.setValue(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
