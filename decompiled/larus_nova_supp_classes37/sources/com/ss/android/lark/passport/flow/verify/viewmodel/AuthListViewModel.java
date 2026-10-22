package com.ss.android.lark.passport.flow.verify.viewmodel;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0004\u0017\u0018\u0019\u001aB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyBaseViewModel;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel$ViewState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel$ActionState;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel$UIEvent;", "verifyCommonViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "<init>", "(Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;)V", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "init", "", "initStateFLow", "reduce", "action", "switchVerify", "context", "Landroid/content/Context;", "authItem", "Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethod;", "Companion", "ViewState", "ActionState", "UIEvent", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AuthListViewModel extends VerifyBaseViewModel<d, a, c> {
    public static final b Companion = null;
    public static final String TAG = "CommonViewModel";
    private final VerifyCommonViewModel verifyCommonViewModel;

    public static abstract class a extends VerifyBaseViewModel.a {

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel$a$a, reason: collision with other inner class name */
        public static final class C0086a extends a {
            public static final C0086a a = null;

            static {
                a = new C0086a();
            }

            public C0086a() {
            }
        }

        public static final class b extends a {
            public final Context a;
            public final AuthMethod b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "SwitchAuth(context=" + this.a + ", authItem=" + this.b + ')';
            }

            public final Context getContext() {
                return this.a;
            }

            public b(Context r2, AuthMethod r3) {
                Intrinsics.checkNotNullParameter(r2, "context");
                Intrinsics.checkNotNullParameter(r3, "authItem");
                this.a = r2;
                this.b = r3;
            }
        }

        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static abstract class c extends VerifyBaseViewModel.b {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public c() {
        }
    }

    public static abstract class d extends VerifyBaseViewModel.c {

        public static final class a extends d {
            public final VerifyBean a;
            public final int b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            public final String toString() {
                return "AuthList(currAuth=" + this.a + ", currActionType=" + this.b + ')';
            }

            public a(VerifyBean r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, "currAuth");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public d() {
        }
    }

    static {
        Companion = new b();
    }

    public final xyb.a getRepo() {
        return (xyb.a) this.verifyCommonViewModel.getRepo().getValue();
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public d initStateFLow() {
        PassportLog.d(TAG, "initStateFlow, EmptyState");
        return d.b.a;
    }

    public final void init() {
        getViewStateFlow().setValue(new d.a(getRepo().e, getRepo().a));
        PassportLog.d(TAG, "cur AuthList: " + getViewStateFlow().getValue());
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ VerifyBaseViewModel.c initStateFLow() {
        return initStateFLow();
    }

    public AuthListViewModel(VerifyCommonViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "verifyCommonViewModel");
        this.verifyCommonViewModel = r2;
    }

    public void reduce(a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof a.b) == false) goto L6;
        a.b r3 = (a.b) r2;
        switchVerify(r3.getContext(), r3.b);
        return;
    L6:
        if ((r2 instanceof a.C0086a) == false) goto L10;
        emitEvent(c.a.a);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.passport.flow.verify.viewmodel.VerifyBaseViewModel
    public /* bridge */ /* synthetic */ void reduce(VerifyBaseViewModel.a r1) {
        reduce((a) r1);
    }

    private final void switchVerify(Context r4, AuthMethod r5) {
        if (getRepo().d(r5.getActionType()) == false) goto L8;
        String r6 = getRepo().a(r5.getActionType());
        if (r6 == null) goto L12;
        UDToast.show(r4, r6);
        return;
    L12:
        return;
    L8:
        xyb.a r7 = getRepo();
        int r0 = r5.getActionType();
        Map<Integer, VerifyBean> r8 = r7.d;
        LinkedHashMap r9 = (LinkedHashMap) r8;
        VerifyBean r10 = (VerifyBean) r9.get(Integer.valueOf(r0));
        if (r10 == null) goto L13;
        xyb.a r1 = getRepo();
        int r2 = r5.getActionType();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "newAuth");
        r1.a = r2;
        r1.e = r10;
        getViewStateFlow().setValue(new d.a(r10, r5.getActionType()));
        return;
    }
}
