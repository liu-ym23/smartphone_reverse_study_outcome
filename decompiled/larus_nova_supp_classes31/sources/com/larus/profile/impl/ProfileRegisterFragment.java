package com.larus.profile.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.profile.impl.databinding.LarusAccountRegisterUserInfoPageBinding;
import com.larus.profile.impl.viewmodel.ProfileRegisterViewModel;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.trace.tracknode.a$a;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import com.yalantis.ucrop.UCropActivity;
import java.security.SecureRandom;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020\"H\u0002J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000f\u00101\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00102J\u000f\u00103\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00102J\u0017\u00104\u001a\u0004\u0018\u00010\"2\u0006\u00105\u001a\u00020\u0016H\u0002¢\u0006\u0002\u00106J\u001a\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000f\u00109\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00102J\u000f\u0010:\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00102J\b\u0010;\u001a\u00020\u0014H\u0002J\u000f\u0010<\u001a\u0004\u0018\u00010\"H\u0003¢\u0006\u0002\u00102J\u000f\u0010=\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00102J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020\"H\u0002J\u0018\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\u0014H\u0002J\u0014\u0010D\u001a\u00020\"2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020?H\u0002J\u0016\u0010H\u001a\u00020\"2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\"0JH\u0002J\b\u0010K\u001a\u00020\"H\u0016J\u000f\u0010L\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00102J\b\u0010M\u001a\u00020\"H\u0016J\b\u0010N\u001a\u00020\"H\u0016J\b\u0010O\u001a\u00020\u0014H\u0016J\u0010\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020?H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/profile/impl/ProfileRegisterFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusAccountRegisterUserInfoPageBinding;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "viewModel", "Lcom/larus/profile/impl/viewmodel/ProfileRegisterViewModel;", "getViewModel", "()Lcom/larus/profile/impl/viewmodel/ProfileRegisterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "initialUserName", "", "mainContentBottom", "", "getMainContentBottom", "()I", "mainContentBottom$delegate", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "pickSDKLauncher", "Landroid/content/Intent;", "cropLauncher", "decorViewRect", "Landroid/graphics/Rect;", "onAttach", "", "context", "Landroid/content/Context;", "handlePhotoPickerResult", "uri", "Landroid/net/Uri;", "initResultLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initUI", "()Lkotlin/Unit;", "setImeHeightListener", "adjustUIWithIMEHeight", "imeHeight", "(I)Lkotlin/Unit;", "onViewCreated", "view", "loadThirdPlatformInfo", "checkUserName", "localGenerateUserName", "registerObservations", "checkConfirmBtnState", "isUserNameAvailable", "", "logProfileSettingComplete", "uploadAvatarSuccess", "fileUri", "url", "uploadAvatarFail", "message", "checkAddAvatarIcon", "isDefaultAvatar", "checkRecordPermission", "doNext", "Lkotlin/Function0;", "onPause", "resetUI", "onDestroyView", "onDestroy", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileRegisterFragment extends TraceFragment {
    public static final /* synthetic */ int o = 0;
    public LarusAccountRegisterUserInfoPageBinding e;
    public FragmentExtKt$addOnBackPressed$callback$1 f;
    public final Lazy g;
    public final Lazy h;
    public String i;
    public final Lazy j;
    public ActivityResultLauncher<String> k;
    public ActivityResultLauncher<Intent> l;
    public ActivityResultLauncher<Intent> m;
    public final Rect n;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "registration_process";
    }

    public static String da0() {
        SecureRandom r0 = new SecureRandom();
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L4:
        if (r2 >= 9) goto L7;
        r1.append(r0.nextInt(10));
        r2 = r2 + 1;
        goto L4
    L7:
        if (AppHost.a.isOversea() == false) goto L10;
        return "cici_" + r1;
    L10:
        return "doubao_" + r1;
    }

    public final Unit Y90() {
        LarusAccountRegisterUserInfoPageBinding r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (ca0() == false) goto L16;
        Editable r1 = r0.h.getText();
        boolean r2 = false;
        if (r1 != null) goto L9;
    L14:
        if (r2 == false) goto L16;
        r0.f.setAlpha(1.0f);
    L20:
        return Unit.INSTANCE;
    L9:
        if (r1.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L14;
        r2 = true;
        goto L14
    L11:
        r3 = false;
    L16:
        r0.f.setAlpha(0.3f);
        goto L20
    }

    public final com.larus.common_ui.dialog.l0 Z90() {
        return (com.larus.common_ui.dialog.l0) this.h.getValue();
    }

    public final ProfileRegisterViewModel aa0() {
        return (ProfileRegisterViewModel) this.g.getValue();
    }

    public final boolean ca0() {
        LarusAccountRegisterUserInfoPageBinding r0 = this.e;
        if (r0 == null) goto L12;
        AppCompatImageView r1 = r0.k;
        if (r1 == null) goto L12;
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L25;
        LarusAccountRegisterUserInfoPageBinding r4 = this.e;
        if (r4 == null) goto L19;
        AppCompatEditText r5 = r4.l;
        if (r5 == null) goto L19;
        Editable r6 = r5.getText();
    L21:
        if (Intrinsics.areEqual(String.valueOf(r6), this.i) == true) goto L26;
        return false;
    L26:
        return true;
    L19:
        r6 = null;
        goto L21
    L25:
        return true;
    L9:
        r2 = false;
    L12:
        r3 = false;
        goto L13
    }

    public final void ea0() {
        LarusAccountRegisterUserInfoPageBinding r0 = this.e;
        if (r0 == null) goto L12;
        ConstraintLayout.LayoutParams r1 = r0.f.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r2 = r1;
    L8:
        if (r2 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = i5.i0();
    L10:
        r0.f.setLayoutParams(r2);
        r0.g.setTranslationY(0.0f);
        Unit r3 = Unit.INSTANCE;
        return;
    L7:
        r2 = null;
        goto L8
    }

    public ProfileRegisterFragment() {
        final Function0<Fragment> r0 = new ProfileRegisterFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileRegisterViewModel.class), new ProfileRegisterFragment$special$$inlined$viewModels$default$2(r0), new ProfileRegisterFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = LazyKt.lazy(new t1(this));
        this.j = LazyKt.lazy(new u1(this));
        this.n = new Rect();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ActivityResultLauncher<String> r0 = this.k;
        ActivityResultLauncher<Intent> r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pickLauncher");
        r0 = null;
    L5:
        r0.unregister();
        ActivityResultLauncher<Intent> r2 = this.l;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pickSDKLauncher");
        r2 = null;
    L8:
        r2.unregister();
        ActivityResultLauncher<Intent> r3 = this.m;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
    L12:
        r1.unregister();
        FragmentExtKt$addOnBackPressed$callback$1 r4 = this.f;
        if (r4 == null) goto L16;
        r4.remove();
        return;
    L16:
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        ea0();
        return;
    }

    public static void U90(com.larus.common_ui.dialog.l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void V90(com.larus.common_ui.dialog.l0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void W90(int r8) {
        LarusAccountRegisterUserInfoPageBinding r0 = this.e;
        if (r0 == null) goto L25;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L23;
        ConstraintLayout.LayoutParams r2 = r0.f.getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L10;
        ConstraintLayout.LayoutParams r3 = r2;
    L12:
        if (r8 >= (i5.i0() - i5.E())) goto L16;
        if (r3 == null) goto L15;
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = i5.i0();
    L15:
        r0.g.setTranslationY(0.0f);
    L22:
        r0.f.setLayoutParams(r3);
        goto L23
    L16:
        if (r3 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = i5.E() + r8;
    L18:
        int r4 = i5.e() + r8;
        int r5 = com.larus.utils.w0.a;
        if (r4 <= (com.larus.utils.w0.c(r1) - ((Number) this.j.getValue()).intValue())) goto L21;
        r0.g.setTranslationY((com.larus.utils.w0.c(r1) - ((Number) this.j.getValue()).intValue()) - (r8 + i5.e()));
        goto L22
    L21:
        r0.g.setTranslationY(0.0f);
        goto L22
    L10:
        r3 = null;
    L23:
        Unit r9 = Unit.INSTANCE;
        return;
    }

    public final void X90(boolean r3) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        LarusAccountRegisterUserInfoPageBinding r1 = this.e;
        if (r1 == null) goto L14;
        AppCompatImageView r2 = r1.c;
        if (r2 == null) goto L15;
        if (r3 == false) goto L11;
        int r4 = 2131240799;
    L12:
        r2.setImageDrawable(AppCompatResources.getDrawable(r0, r4));
        return;
    L11:
        r4 = 2131240883;
        goto L12
    L15:
        return;
    }

    public final void ba0(Uri r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Context r0 = getActivity();
        if (r0 != null) goto L7;
        return;
    L7:
        Uri r1 = Uri.fromFile(new PolarisFileWrapper(requireActivity().getCacheDir(), "crop_user_avatar.jpg"));
        Intent r2 = new Intent();
        Bundle r3 = new Bundle();
        r3.putParcelable("com.yalantis.ucrop.InputUri", r6);
        r3.putParcelable("com.yalantis.ucrop.OutputUri", r1);
        r3.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r3.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        ActivityResultLauncher<Intent> r7 = this.m;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
        r7 = null;
    L10:
        r2.setClass(r0, UCropActivity.class);
        r2.putExtras(r3);
        r7.launch(r2);
    }

    public final void fa0(String r4) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.common_ui.dialog.l0 r1 = Z90();
        if (r1 == null) goto L9;
        U90(r1);
    L9:
        if (r4 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        t19.s.a.getClass();
        t19.s.b(r0, 2131900249, false);
        return;
    L17:
        t19.s.a.getClass();
        t19.s.c(r0, r4);
        return;
    L11:
        if (r4.length() == 0) goto L14;
        r2 = false;
        goto L15
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        a$a.a(this, r3);
        r3.putIfNull("enter_from", "registration_process");
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.k = registerForActivityResult(new ActivityResultContracts.GetContent(), new g1(this));
        this.l = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h1(this));
        this.m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i1(this));
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        LarusAccountRegisterUserInfoPageBinding r11 = this.e;
        if (r11 == null) goto L53;
        ILoginService.Companion r12 = ILoginService.a;
        String r0 = r12.getAccountInfo().b;
        boolean r4 = false;
        String r6 = null;
        String r7 = "";
        if (Intrinsics.areEqual(r0, "GOOGLE") == false) goto L29;
        q38.l r13 = r12.p(LoginPlatform.GOOGLE);
        RoundAvatarImageView r1 = r11.b;
        if (r13 == null) goto L9;
        String r2 = r13.b;
    L10:
        RoundAvatarImageView.f(r1, r2, "register.avatar", false, 12);
        AppCompatEditText r14 = r11.h;
        if (r13 == null) goto L13;
        String r3 = r13.a;
    L14:
        r14.setText(r3);
        ProfileRegisterViewModel r15 = aa0();
        if (r13 == null) goto L20;
        String r5 = r13.b;
        if (r5 == null) goto L20;
        r7 = r5;
    L20:
        r15.setUploadAvatarUrl(r7);
        if (r13 == null) goto L23;
        r6 = r13.b;
    L23:
        if (r6 != null) goto L25;
    L26:
        r4 = true;
    L27:
        X90(r4);
    L52:
        Unit r16 = Unit.INSTANCE;
        goto L53
    L25:
        if (r6.length() != 0) goto L27;
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L29:
        if (Intrinsics.areEqual(r0, "DOUYIN") == false) goto L52;
        q38.l r17 = r12.p(LoginPlatform.DOUYIN);
        RoundAvatarImageView r8 = r11.b;
        if (r17 == null) goto L33;
        String r18 = r17.b;
    L34:
        RoundAvatarImageView.f(r8, r18, "register.avatar", false, 12);
        AppCompatEditText r19 = r11.h;
        if (r17 == null) goto L37;
        String r20 = r17.a;
    L38:
        r19.setText(r20);
        ProfileRegisterViewModel r21 = aa0();
        if (r17 == null) goto L44;
        String r22 = r17.b;
        if (r22 == null) goto L44;
        r7 = r22;
    L44:
        r21.setUploadAvatarUrl(r7);
        if (r17 == null) goto L47;
        r6 = r17.b;
    L47:
        if (r6 != null) goto L49;
    L50:
        r4 = true;
    L51:
        X90(r4);
        goto L52
    L49:
        if (r6.length() != 0) goto L51;
    L37:
        r20 = null;
        goto L38
    L33:
        r18 = null;
    L53:
        final LarusAccountRegisterUserInfoPageBinding r23 = this.e;
        if (r23 == null) goto L56;
        aa0().getInitProfileState().observe(getViewLifecycleOwner(), new b(new b1(this, r23)));
        aa0().getEditProfileState().observe(getViewLifecycleOwner(), new b(new m1(this)));
        aa0().getUserNameAvailable().observe(getViewLifecycleOwner(), new b(new s1(r23, this)));
        Unit r24 = Unit.INSTANCE;
    L56:
        aa0().initUserInfo();
        com.larus.platform.service.u.a.d();
    }

    public final View onCreateView(LayoutInflater r29, ViewGroup r30, Bundle r31) {
        Intrinsics.checkNotNullParameter(r29, "inflater");
        ConstraintLayout r1 = getLayoutInflater().inflate(2131561775, r30, false);
        int r2 = 2131384162;
        RoundAvatarImageView r3 = ViewBindings.findChildViewById(r1, 2131384162);
        if (r3 == null) goto L118;
        r2 = 2131384163;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r1, 2131384163);
        if (r7 == null) goto L118;
        r2 = 2131384164;
        AppCompatImageView r15 = ViewBindings.findChildViewById(r1, 2131384164);
        if (r15 == null) goto L118;
        r2 = 2131384165;
        AppCompatImageView r14 = ViewBindings.findChildViewById(r1, 2131384165);
        if (r14 == null) goto L118;
        r2 = 2131384166;
        AppCompatTextView r13 = ViewBindings.findChildViewById(r1, 2131384166);
        if (r13 == null) goto L118;
        r2 = 2131384167;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r1, 2131384167);
        if (r11 == null) goto L118;
        r2 = 2131384168;
        AppCompatEditText r12 = ViewBindings.findChildViewById(r1, 2131384168);
        if (r12 == null) goto L118;
        r2 = 2131384169;
        Group r16 = ViewBindings.findChildViewById(r1, 2131384169);
        if (r16 == null) goto L118;
        r2 = 2131384170;
        if (ViewBindings.findChildViewById(r1, 2131384170) == null) goto L118;
        r2 = 2131384171;
        if (ViewBindings.findChildViewById(r1, 2131384171) == null) goto L118;
        r2 = 2131384172;
        if (ViewBindings.findChildViewById(r1, 2131384172) == null) goto L118;
        r2 = 2131384173;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r1, 2131384173);
        if (r10 == null) goto L118;
        r2 = 2131384174;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131384174)) == null) goto L118;
        r2 = 2131384175;
        View r17 = ViewBindings.findChildViewById(r1, 2131384175);
        if (r17 == null) goto L118;
        r2 = 2131384176;
        AppCompatImageView r18 = ViewBindings.findChildViewById(r1, 2131384176);
        if (r18 == null) goto L118;
        r2 = 2131384177;
        AppCompatEditText r9 = ViewBindings.findChildViewById(r1, 2131384177);
        if (r9 == null) goto L118;
        r2 = 2131384178;
        Group r19 = ViewBindings.findChildViewById(r1, 2131384178);
        if (r19 == null) goto L118;
        r2 = 2131384179;
        AppCompatTextView r20 = ViewBindings.findChildViewById(r1, 2131384179);
        if (r20 == null) goto L118;
        r2 = 2131384180;
        if (ViewBindings.findChildViewById(r1, 2131384180) == null) goto L118;
        r2 = 2131384181;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r1, 2131384181);
        if (r8 == null) goto L118;
        r2 = 2131384182;
        ProgressBar r21 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131384182);
        if (r21 == null) goto L118;
        r2 = 2131384183;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r1, 2131384183);
        if (r6 == null) goto L118;
        ConstraintLayout r4 = r1;
        final LarusAccountRegisterUserInfoPageBinding r5 = new LarusAccountRegisterUserInfoPageBinding(r4, r3, r7, r15, r14, r13, r11, r12, r16, r10, r17, r18, r9, r19, r20, r8, r21, r6);
        this.e = r5;
        Context r22 = getContext();
        if (r22 == null) goto L108;
        ViewGroup.LayoutParams r23 = r10.getLayoutParams();
        if ((r23 instanceof ConstraintLayout.LayoutParams) == false) goto L52;
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
    L53:
        if (r24 == null) goto L55;
        ((ViewGroup.MarginLayoutParams) r24).topMargin = UIUtils.getStatusBarHeight(r22);
    L55:
        r10.setLayoutParams(r24);
        r4.setOnClickListener(new v1());
        r12.addTextChangedListener(new a2(r5, this));
        r12.setOnFocusChangeListener(new w1(r5));
        r15.setOnClickListener(new x1(r5));
        final LarusAccountRegisterUserInfoPageBinding r25 = this.e;
        if (r25 != null) goto L58;
    L77:
        com.larus.utils.e1.d(r13, new y1(this, r5));
        this.f = com.larus.utils.v.a(this, new z1());
        com.larus.utils.e1.d(r3, new c1(this));
        com.larus.utils.e1.d(r10, new d1(this));
        AppHost.Companion r26 = AppHost.a;
        if (r26.isOversea() == false) goto L82;
        Context r27 = getContext();
        if (r27 == null) goto L86;
        String r28 = r27.getString(2131900867);
    L87:
        r6.setText(r28);
        if (r26.isOversea() == false) goto L92;
        Context r32 = getContext();
        if (r32 == null) goto L96;
        String r33 = r32.getString(2131900865);
    L97:
        r31.setHint(r33);
        if (r26.isOversea() == false) goto L102;
        Context r34 = getContext();
        if (r34 == null) goto L106;
        String r35 = r34.getString(2131900866);
    L107:
        r8.setText(r35);
        r31.addTextChangedListener(new b2(this, r5));
        r9.setOnFocusChangeListener(new e1(r5));
        r14.setOnClickListener(new f1(r5));
    L106:
        r35 = null;
        goto L107
    L102:
        Context r36 = getContext();
        if (r36 == null) goto L106;
        r35 = r36.getString(2131909235);
    L96:
        r33 = null;
        goto L97
    L92:
        Context r37 = getContext();
        if (r37 == null) goto L96;
        r33 = r37.getString(2131909234);
    L86:
        r28 = null;
        goto L87
    L82:
        Context r38 = getContext();
        if (r38 == null) goto L86;
        r28 = r38.getString(2131909236);
        goto L87
    L58:
        if (Build.VERSION.SDK_INT >= 30) goto L75;
        final FragmentActivity r39 = getActivity();
        if (r39 == null) goto L76;
        Window r40 = r39.getWindow();
        if (r40 == null) goto L76;
        final View r41 = r40.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L69;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r42 = ThreadMethodProxy.currentThread();
        if (r42 == com.larus.home.impl.utils.c.a) goto L69;
        com.larus.home.impl.utils.c.a(r42, "getDecorView");
    L69:
        if (r41 == null) goto L76;
        View r43 = r41.findViewById(R.id.content);
        if (r43 == null) goto L76;
        r43.getViewTreeObserver().addOnGlobalLayoutListener(new k1(r41, this, r39));
    L76:
        Unit r44 = Unit.INSTANCE;
        goto L77
    L75:
        ViewExtKt.m(r25.f, null, new l1(this), new n1(r25, this));
        goto L76
    L52:
        r24 = null;
    L108:
        Unit r45 = Unit.INSTANCE;
        if (AuthModelDelegate.b.z() == false) goto L111;
        com.larus.platform.service.u.a.d();
    L111:
        LarusAccountRegisterUserInfoPageBinding r46 = this.e;
        if (r46 == null) goto L119;
        ConstraintLayout r47 = r46.a;
        if (r47 == null) goto L120;
        r47.setTag(2131377847, this);
        return r47;
    L120:
        return null;
    L119:
        return null;
    L118:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
