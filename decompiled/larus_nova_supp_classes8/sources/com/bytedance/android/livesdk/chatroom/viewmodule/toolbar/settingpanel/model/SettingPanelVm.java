package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.model;

import android.content.Context;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.Unit;
import np1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/model/SettingPanelVm;", "Lcom/bytedance/live/datacontext/DataContext;", "Lnp1/c;", "", "closeSettingPanel", "", "position", "notifyListDataChange", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_closeDialog", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "closeDialog", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getCloseDialog", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "_listDataChange", "listDataChange", "getListDataChange", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingPanelVm extends DataContext implements c {
    private final PropertyOwner<Unit> _closeDialog;
    private final PropertyOwner<Integer> _listDataChange;
    private final CompositeDisposable cd;
    private final d<Unit> closeDialog;
    private Context context;
    private final DataCenter dataCenter;
    private final d<Integer> listDataChange;

    public static final class a implements Action {
        public final /* synthetic */ SettingPanelVm a;

        public a(SettingPanelVm r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.getCd().clear();
        }
    }

    @Override // np1.c
    public void closeSettingPanel() {
        this._closeDialog.a(Unit.INSTANCE);
    }

    @Override // np1.c
    public CompositeDisposable getCd() {
        return this.cd;
    }

    public d<Unit> getCloseDialog() {
        return this.closeDialog;
    }

    @Override // np1.c
    public Context getContext() {
        return this.context;
    }

    @Override // np1.c
    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public d<Integer> getListDataChange() {
        return this.listDataChange;
    }

    @Override // np1.c
    public void notifyListDataChange(int r2) {
        this._listDataChange.a(Integer.valueOf(r2));
    }

    public void setContext(Context r1) {
        this.context = r1;
    }

    public SettingPanelVm(Context r1, DataCenter r2) {
        this.context = r1;
        this.dataCenter = r2;
        this.cd = new CompositeDisposable();
        PropertyOwner<Unit> r3 = new PropertyOwner(Unit.INSTANCE);
        this._closeDialog = r3;
        this.closeDialog = r3;
        PropertyOwner<Integer> r4 = new PropertyOwner(-1);
        this._listDataChange = r4;
        this.listDataChange = r4;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), getCd());
    }
}
