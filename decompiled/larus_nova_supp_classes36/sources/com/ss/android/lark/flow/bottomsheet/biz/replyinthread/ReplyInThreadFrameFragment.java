package com.ss.android.lark.flow.bottomsheet.biz.replyinthread;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bgb.d;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.replyinthread.pages.ThreadPageInitViewModel;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\"\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u0012\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0018H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/flow/bottomsheet/biz/replyinthread/ReplyInThreadFrameFragment;", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;)V", "container", "Landroid/widget/FrameLayout;", "bizViewModel", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInitViewModel;", "radiusTopContainer", "", "getRadiusTopContainer", "()F", "setRadiusTopContainer", "(F)V", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initContentContainer", "", "contentContainer", "savedInstanceState", "Landroid/os/Bundle;", "closePageObserver", "Landroidx/lifecycle/Observer;", "", "setupInitViewModel", "setupFragment", "pageInfo", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "updateTitleBar", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleBack", "onNewIntent", "intent", "notifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "onDestroyView", "OnTitleBarActionClickListener", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ReplyInThreadFrameFragment extends Hilt_ReplyInThreadFrameFragment implements c {
    public static final /* synthetic */ int q = 0;

    @Inject
    public FlowReplyInThreadFragment l;
    public FrameLayout m;
    public ThreadPageInitViewModel n;
    public final float o;
    public final a p;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ReplyInThreadFrameFragment a;

        public a(ReplyInThreadFrameFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L9;
            Context r3 = this.a.getContext();
            if (r3 == null) goto L7;
            UDToast.show(r3, 2131891714);
        L7:
            this.a.finish();
            return;
        }
    }

    public final void A0(Intent r1) {
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
        return b.a(this);
    }

    public final boolean l1() {
        return false;
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final FlowReplyInThreadFragment V90() {
        FlowReplyInThreadFragment r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        return null;
    }

    public ReplyInThreadFrameFragment() {
        this.o = 24.0f;
        this.p = new a(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final void onDestroyView() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroyView();
        ThreadPageInitViewModel r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
        r0 = null;
    L5:
        r0.getClosePageInfo().removeObserver(this.p);
        CodeBlockV2ThemeManager.a();
        TableUtils.a = null;
        ColumnsUtils.a = null;
        TextLayoutBuilder.b();
        ChatCoreModule.a().getChatDependency().r();
        u.a.a.a();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m4provideComponent() {
        return provideComponent();
    }

    public final float S90() {
        return this.o;
    }

    public final boolean y30(Notice r3) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("key_params_thread_id");
    L6:
        if (r1 != null) goto L10;
        return true;
    L10:
        return t0.b(r3, r1);
    L5:
        r1 = null;
        goto L6
    }

    public final void T90(FrameLayout r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "contentContainer");
        this.m = r3;
        ThreadPageInitViewModel r5 = new ViewModelProvider(this).get(ThreadPageInitViewModel.class);
        this.n = r5;
        ThreadPageInitViewModel r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
        r5 = null;
    L5:
        r5.onCreate(getArguments());
        ThreadPageInitViewModel r7 = this.n;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
        r7 = null;
    L8:
        r7.getClosePageInfo().observe(this, this.p);
        ThreadPageInitViewModel r8 = this.n;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bizViewModel");
    L12:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r6.getThreadPageLiveData(), this, new bgb.b(this));
        V90().w.observe(getViewLifecycleOwner(), new d(this));
        return;
    L11:
        r6 = r8;
        goto L12
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        V90().onActivityResult(r2, r3, r4);
    }
}
