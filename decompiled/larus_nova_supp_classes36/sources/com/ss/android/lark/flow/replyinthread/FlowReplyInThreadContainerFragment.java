package com.ss.android.lark.flow.replyinthread;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.replyinthread.pages.ThreadPageInitViewModel;
import com.ss.android.lark.replyinthread.pages.f;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/FlowReplyInThreadContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInitViewModel;", "mFragment", "Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;)V", "closePageObserver", "Landroidx/lifecycle/Observer;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupInitViewModel", "setupFragment", "pageInfo", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowReplyInThreadContainerFragment extends Hilt_FlowReplyInThreadContainerFragment implements c, d {
    public static final /* synthetic */ int i = 0;
    public ThreadPageInitViewModel f;

    @Inject
    public FlowReplyInThreadFragment g;
    public final b h;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ FlowReplyInThreadContainerFragment a;

        public b(FlowReplyInThreadContainerFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L9;
            FragmentActivity r3 = this.a.getActivity();
            if (r3 == null) goto L7;
            FlowToast.c(r3, 2131891714);
        L7:
            zab.a.a(this.a);
            return;
        }
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Inject
    public FlowReplyInThreadContainerFragment() {
        this.h = new b(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        ThreadPageInitViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.getClosePageInfo().removeObserver(this.h);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        CodeBlockV2ThemeManager.a();     // Catch: Throwable -> L8
        TableUtils.a = null;     // Catch: Throwable -> L8
        ColumnsUtils.a = null;     // Catch: Throwable -> L8
        TextLayoutBuilder.b();     // Catch: Throwable -> L8
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L8
        u.a.a.a();     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m478provideComponent() {
        return provideComponent();
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        ThreadPageInitViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        f r1 = (f) r0.getThreadPageLiveData().getValue();
        if (r1 == null) goto L9;
        String r3 = r1.a();
        if (r3 == null) goto L9;
    L11:
        return t0.b(r2, r3);
    L9:
        r3 = "";
        goto L11
    }

    public final void onCreate(Bundle r2) {
        if (r2 == null) goto L4;
        r2.remove("android:support:fragments");
    L4:
        super.onCreate(r2);
        v4b.a.a(requireContext());
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        Log.i("FlowReplyInThreadContainer", "container Fragment created");
        ThreadPageInitViewModel r5 = new ViewModelProvider(this).get(ThreadPageInitViewModel.class);
        this.f = r5;
        ThreadPageInitViewModel r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L5:
        r5.onCreate(getArguments());
        ThreadPageInitViewModel r7 = this.f;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L8:
        r7.getClosePageInfo().observe(this, this.h);
        ThreadPageInitViewModel r8 = this.f;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r6.getThreadPageLiveData(), this, new whb.b(this));
        return;
    L11:
        r6 = r8;
        goto L12
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        Fragment r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r0 = null;
    L6:
        r0.onActivityResult(r2, r3, r4);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setId(2131373275);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
