package com.larus.profile.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ProgressBar;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.profile.impl.databinding.LarusPageProfileEditBinding;
import com.larus.profile.impl.view.ProfileEditPerfRootLayout;
import com.larus.profile.impl.viewmodel.ProfileEditViewModel;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import com.yalantis.ucrop.UCropActivity;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0002J\u0014\u00103\u001a\u000204*\u0002012\u0006\u00105\u001a\u000204H\u0002J\b\u00106\u001a\u00020)H\u0002J\b\u00107\u001a\u00020)H\u0002J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u000f\u0010>\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010?J\u001a\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u0002092\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010B\u001a\u00020)H\u0002J\b\u0010C\u001a\u00020)H\u0002J\u0016\u0010D\u001a\u00020)2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020)0FH\u0002J\u000f\u0010G\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010?J\u000f\u0010H\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010?J\u0018\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020\u001eH\u0002J\u0014\u0010L\u001a\u00020)2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010N\u001a\u00020$H\u0002J\u000f\u0010O\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010?J\b\u0010P\u001a\u00020$H\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020)H\u0002J\b\u0010T\u001a\u00020)H\u0002J\b\u0010U\u001a\u00020)H\u0016J\b\u0010V\u001a\u00020)H\u0016J\b\u0010W\u001a\u00020\u001eH\u0016J\b\u0010X\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&¨\u0006Z"}, d2 = {"Lcom/larus/profile/impl/ProfileEditFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/profile/impl/databinding/LarusPageProfileEditBinding;", "viewModel", "Lcom/larus/profile/impl/viewmodel/ProfileEditViewModel;", "getViewModel", "()Lcom/larus/profile/impl/viewmodel/ProfileEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "perfTracer", "Lcom/larus/profile/impl/ProfileEditPerfTracer;", "getPerfTracer", "()Lcom/larus/profile/impl/ProfileEditPerfTracer;", "perfTracer$delegate", "loadTemplateStartMs", "", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "cropLauncher", "enterFrom", "isFromH5AccountSetting", "", "isEnterpriseAccount", "()Z", "isEnterpriseAccount$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handlePhotoPickerResult", "uri", "Landroid/net/Uri;", "isCommonImageType", "copyToJpgFile", "Ljava/io/File;", "dst", "initResultLauncher", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initView", "()Lkotlin/Unit;", "onViewCreated", "view", "logProfileSettingComplete", "loadUserInfo", "checkRecordPermission", "doNext", "Lkotlin/Function0;", "checkUserName", "registerObservations", "uploadAvatarSuccess", "fileUri", "url", "uploadAvatarFail", "message", "isUserInfoEdited", "checkConfirmBtn", "isUserNameAvailable", "checkAddAvatarIcon", "isDefaultAvatar", "showCancelConfirmDialog", "goBack", "onDestroyView", "onDestroy", "getCurrentPageName", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileEditFragment extends TraceFragment {
    public static final Pattern r = null;
    public LarusPageProfileEditBinding e;
    public final Lazy f;
    public final Lazy g;
    public long h;
    public final Lazy i;
    public final r38.b j;
    public FragmentExtKt$addOnBackPressed$callback$1 k;
    public ActivityResultLauncher<String> l;
    public ActivityResultLauncher<Intent> m;
    public ActivityResultLauncher<Intent> n;
    public String o;
    public boolean p;
    public final Lazy q;

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

    public static final class c implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ ProfileEditFragment a;

        public final void confirm() {
            ProfileEditFragment r0 = this.a;
            Pattern r1 = ProfileEditFragment.r;
            FragmentActivity r2 = r0.getActivity();
            if (r2 == null) goto L6;
            r2.finish();
            return;
        }

        public c(ProfileEditFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public d() {
        }

        public final void cancel() {
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "profile_setting";
    }

    static {
        r = PatternProtector.compile("^[a-zA-Z0-9_]+$");
        PatternProtector.compile("(?!^\\d+$)^.+$");
    }

    public final Unit W90() {
        LarusPageProfileEditBinding r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (ca0() == false) goto L18;
        Editable r1 = r0.i.getText();
        boolean r2 = false;
        if (r1 != null) goto L9;
    L14:
        if (r2 == false) goto L18;
        if (ba0() == false) goto L18;
        r0.g.setAlpha(1.0f);
    L22:
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
    L18:
        r0.g.setAlpha(0.3f);
        goto L22
    }

    public final com.larus.common_ui.dialog.l0 X90() {
        return (com.larus.common_ui.dialog.l0) this.i.getValue();
    }

    public final ProfileEditViewModel Y90() {
        return (ProfileEditViewModel) this.f.getValue();
    }

    public final boolean aa0() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    public final boolean ba0() {
        r38.b r0 = this.j;
        if (r0 != null) goto L5;
        return true;
    L5:
        Editable r2 = null;
        if (r0 == null) goto L8;
        String r1 = r0.g();
    L9:
        LarusPageProfileEditBinding r3 = this.e;
        if (r3 == null) goto L14;
        AppCompatEditText r4 = r3.n;
        if (r4 == null) goto L14;
        Editable r5 = r4.getText();
    L16:
        if (Intrinsics.areEqual(r1, String.valueOf(r5)) == false) goto L36;
        r38.b r6 = this.j;
        if (r6 == null) goto L20;
        String r7 = r6.d();
    L21:
        LarusPageProfileEditBinding r8 = this.e;
        if (r8 == null) goto L27;
        AppCompatEditText r9 = r8.i;
        if (r9 == null) goto L27;
        r2 = r9.getText();
    L27:
        if (Intrinsics.areEqual(r7, String.valueOf(r2)) == true) goto L29;
        return true;
    L29:
        if (Y90().getUploadAvatarUrl().length() <= 0) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == true) goto L38;
        return false;
    L38:
        return true;
    L31:
        r10 = false;
        goto L32
    L20:
        r7 = null;
        goto L21
    L36:
        return true;
    L14:
        r5 = null;
        goto L16
    L8:
        r1 = null;
        goto L9
    }

    public final boolean ca0() {
        LarusPageProfileEditBinding r0 = this.e;
        if (r0 == null) goto L12;
        AppCompatImageView r1 = r0.l;
        if (r1 == null) goto L12;
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L28;
        LarusPageProfileEditBinding r4 = this.e;
        String r5 = null;
        if (r4 == null) goto L19;
        AppCompatEditText r6 = r4.n;
        if (r6 == null) goto L19;
        Editable r7 = r6.getText();
    L20:
        String r8 = String.valueOf(r7);
        r38.b r9 = this.j;
        if (r9 == null) goto L24;
        r5 = r9.g();
    L24:
        if (Intrinsics.areEqual(r8, r5) == true) goto L29;
        return false;
    L29:
        return true;
    L19:
        r7 = null;
        goto L20
    L28:
        return true;
    L9:
        r2 = false;
    L12:
        r3 = false;
        goto L13
    }

    public ProfileEditFragment() {
        final Function0<Fragment> r0 = new ProfileEditFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileEditViewModel.class), new ProfileEditFragment$special$$inlined$viewModels$default$2(r0), new ProfileEditFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = LazyKt.lazy(new x(this));
        this.i = LazyKt.lazy(new i0(this));
        this.j = IAccountService.a.getUserInfo();
        this.o = "setting";
        this.q = LazyKt.lazy(new o0());
    }

    public final void da0() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(r0.getString(2131909224));
        CommonDialog.a.f(r1, new c(this), r0.getString(2131909222), false, 12);
        CommonDialog.a.e(r1, new d(), r0.getString(2131909223), 4);
        CommonDialog r2 = r1.c();
        FragmentManager r3 = getChildFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r4) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r2.show(r3, null);
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ActivityResultLauncher<String> r0 = this.l;
        ActivityResultLauncher<Intent> r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pickLauncher");
        r0 = null;
    L5:
        r0.unregister();
        ActivityResultLauncher<Intent> r2 = this.m;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pickSDKLauncher");
        r2 = null;
    L8:
        r2.unregister();
        ActivityResultLauncher<Intent> r3 = this.n;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
    L12:
        r1.unregister();
        FragmentExtKt$addOnBackPressed$callback$1 r4 = this.k;
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

    public final void V90(boolean r3) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        LarusPageProfileEditBinding r1 = this.e;
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

    public final void Z90(Uri r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        FragmentActivity r4 = getActivity();
        if (r4 != null) goto L7;
        return;
    L7:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4.getCacheDir(), "profile");
        if (r1.exists() == true) goto L10;
        r1.mkdirs();
    L10:
        FragmentActivity r0 = getActivity();
        boolean r2 = false;
        ActivityResultLauncher<Intent> r3 = null;
        if (r0 == null) goto L56;
        String r5 = r0.getContentResolver().getType(r12);
        if (r5 != null) goto L16;
    L22:
        String r6 = MimeTypeMap.getFileExtensionFromUrl(r12.toString());
        if (r6 == null) goto L25;
        String r7 = r6.toLowerCase(Locale.getDefault());
    L26:
        if (r7 != null) goto L28;
    L31:
        boolean r8 = true;
    L32:
        if (r8 == true) goto L56;
        if (r7 == null) goto L49;
        int r9 = r7.hashCode();
        if (r9 == 105441) goto L48;
        if (r9 == 111145) goto L45;
        if (r9 != 3268712) goto L49;
        if (r7.equals("jpeg") == false) goto L49;
    L55:
        r2 = true;
        goto L56
    L45:
        if (r7.equals("png") == true) goto L55;
    L48:
        if (r7.equals("jpg") == true) goto L55;
    L49:
        String r10 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r7);
        if (r10 == null) goto L56;
        if (StringsKt.equals(r10, "image/jpeg", true) == true) goto L55;
        if (StringsKt.equals(r10, "image/png", true) == false) goto L56;
    L28:
        if (r7.length() == 0) goto L31;
        r8 = false;
        goto L32
    L25:
        r7 = null;
        goto L26
    L16:
        if (StringsKt.equals(r5, "image/jpeg", true) == true) goto L55;
        if (StringsKt.equals(r5, "image/png", true) == true) goto L55;
        if (StringsKt.equals(r5, "image/jpg", true) == false) goto L22;
    L56:
        if (r2 == false) goto L62;
        Uri r11 = Uri.fromFile(new PolarisFileWrapper(r1, "crop_user_avatar.jpg"));
        Intent r13 = new Intent();
        Bundle r14 = new Bundle();
        r14.putParcelable("com.yalantis.ucrop.InputUri", r12);
        r14.putParcelable("com.yalantis.ucrop.OutputUri", r11);
        r14.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r14.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        ActivityResultLauncher<Intent> r15 = this.n;
        if (r15 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
    L61:
        r13.setClass(r4, UCropActivity.class);
        r13.putExtras(r14);
        r3.launch(r13);
        return;
    L60:
        r3 = r15;
        goto L61
    L62:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ProfileEditFragment$handlePhotoPickerResult$1(r1, this, r12, r4, null), 3, null);
    }

    public final void ea0(String r4) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.common_ui.dialog.l0 r1 = X90();
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
    L18:
        W90();
        return;
    L17:
        t19.s.a.getClass();
        t19.s.c(r0, r4);
        goto L18
    L11:
        if (r4.length() == 0) goto L14;
        r2 = false;
        goto L15
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.l = registerForActivityResult(new ActivityResultContracts.GetContent(), new p0(this));
        this.m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new q0(this));
        this.n = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new r0(this));
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L12;
        String r4 = r3.getString("enter_from");
        if (r4 == null) goto L12;
        if (r4.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        this.o = r4;
        goto L12
    L9:
        r0 = false;
    L12:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L19;
        Intent r6 = r5.getIntent();
        if (r6 == null) goto L19;
        Uri r7 = r6.getData();
        if (r7 == null) goto L19;
        String r8 = UriProtector.getQueryParameter(r7, "scene");
    L20:
        this.p = Intrinsics.areEqual(r8, "account");
        return;
    L19:
        r8 = null;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(final View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        final LarusPageProfileEditBinding r9 = this.e;
        ProfileEditPerfRootLayout r1 = null;
        if (r9 != null) goto L5;
    L43:
        final LarusPageProfileEditBinding r10 = this.e;
        if (r10 == null) goto L46;
        Y90().getUserNameAvailable().observe(getViewLifecycleOwner(), new b(new t0(r10, this)));
        Y90().getEditProfileState().observe(getViewLifecycleOwner(), new b(new u0(this)));
        Unit r11 = Unit.INSTANCE;
    L46:
        r38.b r12 = this.j;
        if (r12 == null) goto L66;
        LarusPageProfileEditBinding r2 = this.e;
        if (r2 == null) goto L66;
        RoundAvatarImageView r3 = r2.b;
        AvatarInfo r13 = r12.a();
        if (r13 == null) goto L54;
        String r14 = r13.a();
    L55:
        RoundAvatarImageView.f(r3, r14, "settings_edit.avatar_default", false, 12);
        AppCompatEditText r15 = r2.i;
        r38.b r0 = this.j;
        if (r0 == null) goto L58;
        String r4 = r0.d();
    L59:
        r15.setText(r4);
        AppCompatEditText r16 = r2.n;
        r38.b r5 = this.j;
        if (r5 == null) goto L62;
        String r6 = r5.g();
    L63:
        r16.setText(r6);
        r38.b r17 = this.j;
        if (r17 == null) goto L66;
        V90(r17.i());
        goto L66
    L62:
        r6 = null;
        goto L63
    L58:
        r4 = null;
        goto L59
    L54:
        r14 = null;
    L66:
        a1 r18 = (a1) this.g.getValue();
        AtomicBoolean r19 = a1.l;
        long r20 = System.currentTimeMillis() - this.h;
        if (r20 < 0) goto L69;
        r18.f = r20;
    L71:
        if ((r7 instanceof ProfileEditPerfRootLayout) == false) goto L73;
        r1 = (ProfileEditPerfRootLayout) r7;
    L73:
        if (r1 == null) goto L76;
        r1.setOnFirstDispatchDrawEndListener$impl_mainlandRelease(new s0(this, r7));
        return;
    L76:
        return;
    L69:
        r18.getClass();
        goto L71
    L5:
        if (this.p == false) goto L7;
        r9.k.setTextSize(0, i5.x0(v19.c.b(2130972277, null, 2131167624)));
    L7:
        r9.d.setOnClickListener(new v0(this));
        r9.a.setOnClickListener(new z());
        r9.i.addTextChangedListener(new w0(r9, this));
        r9.i.setOnFocusChangeListener(new a0(r9));
        r9.e.setOnClickListener(new b0(r9));
        AppCompatTextView r21 = r9.s;
        int r22 = y0.a;
        if (aa0() == false) goto L10;
        int r23 = 2131905545;
    L11:
        r21.setText(r23);
        AppCompatEditText r24 = r9.n;
        AppHost.Companion r25 = AppHost.a;
        if (r25.isOversea() == false) goto L16;
        Context r26 = getContext();
        if (r26 == null) goto L19;
        String r27 = r26.getString(2131900865);
    L20:
        r24.setHint(r27);
        AppCompatTextView r28 = r9.q;
        if (r25.isOversea() == false) goto L25;
        Context r29 = getContext();
        if (r29 == null) goto L28;
        String r30 = r29.getString(2131900866);
    L29:
        r28.setText(r30);
        r9.n.addTextChangedListener(new x0(this, r9));
        r9.n.setOnFocusChangeListener(new c0(r9));
        r9.f.setOnClickListener(new d0(r9));
        com.larus.utils.e1.d(r9.b, new e0(this));
        com.larus.utils.e1.d(r9.g, new f0(this, r9));
        this.k = com.larus.utils.v.a(this, new g0(this));
        if (aa0() == false) goto L42;
        r9.n.setHint(null);
        com.larus.utils.e1.o(r9.q);
        com.larus.utils.e1.q(r9.i);
        com.larus.utils.e1.x(r9.h);
        AppCompatTextView r31 = r9.h;
        r38.b r32 = this.j;
        if (r32 == null) goto L34;
        String r33 = r32.d();
    L35:
        r31.setText(r33);
        com.larus.utils.e1.d(r9.h, new h0(this));
        com.larus.utils.e1.q(r9.n);
        com.larus.utils.e1.x(r9.m);
        AppCompatTextView r34 = r9.m;
        r38.b r35 = this.j;
        if (r35 == null) goto L40;
        r38.a r36 = r35.e();
        if (r36 == null) goto L40;
        String r37 = r36.b();
    L41:
        r34.setText(r37);
        com.larus.utils.e1.d(r9.m, new y(this));
        com.larus.utils.e1.o(r9.c);
    L40:
        r37 = null;
        goto L41
    L34:
        r33 = null;
    L42:
        Unit r38 = Unit.INSTANCE;
    L28:
        r30 = null;
        goto L29
    L25:
        Context r39 = getContext();
        if (r39 == null) goto L28;
        r30 = r39.getString(2131909235);
    L19:
        r27 = null;
        goto L20
    L16:
        Context r40 = getContext();
        if (r40 == null) goto L19;
        r27 = r40.getString(2131909234);
        goto L20
    L10:
        r23 = 2131909236;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View, com.larus.profile.impl.view.ProfileEditPerfRootLayout, java.lang.Object] */
    public final View onCreateView(LayoutInflater r25, ViewGroup r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r25, "inflater");
        AtomicBoolean r2 = a1.l;
        this.h = System.currentTimeMillis();
        View r1 = r25.inflate(2131563058, r26, false);
        int r3 = 2131371433;
        RoundAvatarImageView r6 = ViewBindings.findChildViewById(r1, 2131371433);
        if (r6 == null) goto L49;
        r3 = 2131371434;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r1, 2131371434);
        if (r7 == null) goto L49;
        r3 = 2131371435;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r1, 2131371435);
        if (r8 == null) goto L49;
        r3 = 2131371436;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r1, 2131371436);
        if (r9 == null) goto L49;
        r3 = 2131371437;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r1, 2131371437);
        if (r10 == null) goto L49;
        r3 = 2131371438;
        AppCompatTextView r11 = ViewBindings.findChildViewById(r1, 2131371438);
        if (r11 == null) goto L49;
        r3 = 2131371439;
        AppCompatTextView r12 = ViewBindings.findChildViewById(r1, 2131371439);
        if (r12 == null) goto L49;
        r3 = 2131371440;
        AppCompatEditText r13 = ViewBindings.findChildViewById(r1, 2131371440);
        if (r13 == null) goto L49;
        r3 = 2131371441;
        Group r14 = ViewBindings.findChildViewById(r1, 2131371441);
        if (r14 == null) goto L49;
        r3 = 2131371442;
        if (ViewBindings.findChildViewById(r1, 2131371442) == null) goto L49;
        r3 = 2131371443;
        if (ViewBindings.findChildViewById(r1, 2131371443) == null) goto L49;
        r3 = 2131371444;
        if (ViewBindings.findChildViewById(r1, 2131371444) == null) goto L49;
        r3 = 2131371445;
        AppCompatTextView r15 = ViewBindings.findChildViewById(r1, 2131371445);
        if (r15 == null) goto L49;
        r3 = 2131371446;
        AppCompatImageView r16 = ViewBindings.findChildViewById(r1, 2131371446);
        if (r16 == null) goto L49;
        r3 = 2131371447;
        AppCompatTextView r17 = ViewBindings.findChildViewById(r1, 2131371447);
        if (r17 == null) goto L49;
        r3 = 2131371448;
        AppCompatEditText r18 = ViewBindings.findChildViewById(r1, 2131371448);
        if (r18 == null) goto L49;
        r3 = 2131371449;
        Group r19 = ViewBindings.findChildViewById(r1, 2131371449);
        if (r19 == null) goto L49;
        r3 = 2131371450;
        AppCompatTextView r20 = ViewBindings.findChildViewById(r1, 2131371450);
        if (r20 == null) goto L49;
        r3 = 2131371451;
        if (ViewBindings.findChildViewById(r1, 2131371451) == null) goto L49;
        r3 = 2131371452;
        AppCompatTextView r21 = ViewBindings.findChildViewById(r1, 2131371452);
        if (r21 == null) goto L49;
        r3 = 2131371453;
        ProgressBar r22 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131371453);
        if (r22 == null) goto L49;
        r3 = 2131371454;
        AppCompatTextView r23 = ViewBindings.findChildViewById(r1, 2131371454);
        if (r23 == null) goto L49;
        ?? r4 = (ProfileEditPerfRootLayout) r1;
        this.e = new LarusPageProfileEditBinding(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        Intrinsics.checkNotNull(r4);
        r4.setTag(2131377847, this);
        return r4;
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    }
}
