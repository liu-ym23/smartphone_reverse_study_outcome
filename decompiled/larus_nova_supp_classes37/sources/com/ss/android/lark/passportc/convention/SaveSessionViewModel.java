package com.ss.android.lark.passportc.convention;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.passportc.api.y;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import dagger.hilt.android.internal.Contexts;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/passportc/convention/SaveSessionViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "outerSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/passportc/entity/UserSession;Landroidx/lifecycle/SavedStateHandle;)V", "refinedSession", "userSession", "getUserSession", "()Lcom/ss/android/lark/passportc/entity/UserSession;", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SaveSessionViewModel extends ViewModel {
    private final UserSession outerSession;
    private final UserSession refinedSession;
    private final SavedStateHandle savedStateHandle;

    public final UserSession getUserSession() {
        UserSession r0 = this.outerSession;
        SavedStateHandle r1 = this.savedStateHandle;
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("saved:iji.convention.user_id");
    L6:
        SavedStateHandle r3 = this.savedStateHandle;
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("saved:iji.convention.session_key");
    L10:
        UserSession r5 = this.refinedSession;
        if (r5 != null) goto L13;
    L15:
        if (r0 != null) goto L22;
        if (r2 == null) goto L20;
        if (r4 == null) goto L20;
        return new UserSession(r4, r2);
    L20:
        return null;
    L22:
        return r0;
    L13:
        if (y.a(r5.b) == true) goto L15;
        return this.refinedSession;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public SaveSessionViewModel(Context r4, UserSession r5, SavedStateHandle r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.outerSession = r5;
        this.savedStateHandle = r6;
        if (r5 == null) goto L6;
        if (r6 == null) goto L6;
        r6.set("saved:iji.convention.user_id", r5.b);
        r6.set("saved:iji.convention.session_key", r5.a);
    L6:
        UserSession r1 = null;
        if (r5 == null) goto L10;
        String r7 = r5.b;
        if (r7 == null) goto L10;
    L13:
        if (r7 == null) goto L15;
        Application r8 = Contexts.getApplication(r4.getApplicationContext());
        Intrinsics.checkNotNull(r8);
        r1 = ((a) k.a(r8, a.class)).c(r7);
    L15:
        this.refinedSession = r1;
        return;
    L10:
        if (r6 == null) goto L12;
        r7 = (String) r6.get("saved:iji.convention.user_id");
        goto L13
    L12:
        r7 = null;
        goto L13
    }

    public /* synthetic */ SaveSessionViewModel(Context r1, UserSession r2, SavedStateHandle r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
