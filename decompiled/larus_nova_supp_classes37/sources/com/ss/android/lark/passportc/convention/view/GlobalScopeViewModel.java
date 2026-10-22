package com.ss.android.lark.passportc.convention.view;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.picker.base.view.ItemViewType;
import f0c.b;
import f0c.e;
import f0c.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passportc/convention/view/GlobalScopeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/passportc/api/IGlobalScopeConvention;", "passport", "Lcom/ss/android/lark/passportc/api/IPassportGlobalService;", "<init>", "(Lcom/ss/android/lark/passportc/api/IPassportGlobalService;)V", "getPassport", "()Lcom/ss/android/lark/passportc/api/IPassportGlobalService;", "onCleared", "", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class GlobalScopeViewModel extends ViewModel implements g {
    private final j passport;

    @Override // com.ss.android.lark.passportc.api.n
    public void afterUserChanged(f0c.g r1, b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public void afterUserOffline(e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public void afterUserOnline(f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public void onUserChanged(f0c.g r1, b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public void onUserOffline(e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public void onUserOnline(f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public void onCleared() {
        super.onCleared();
        Intrinsics.checkNotNullParameter(this, "<this>");
        getPassport().h(this);
    }

    @Override // com.ss.android.lark.passportc.api.g
    public j getPassport() {
        return this.passport;
    }

    public GlobalScopeViewModel(j r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.passport = r2;
        h.a(this);
    }
}
