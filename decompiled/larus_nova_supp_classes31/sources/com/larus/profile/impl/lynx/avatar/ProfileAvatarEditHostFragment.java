package com.larus.profile.impl.lynx.avatar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import com.yalantis.ucrop.UCropActivity;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001bH\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0014\u0010$\u001a\u00020\u00132\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010*\u001a\u00020+*\u00020\u001b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/profile/impl/lynx/avatar/ProfileAvatarEditHostFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callback", "Lcom/larus/profile/impl/lynx/avatar/ProfileAvatarEditHostFragment$Callback;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSdkLauncher", "Landroid/content/Intent;", "cropLauncher", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startEdit", "initLaunchers", "launchPick", "handlePhotoPickerResult", "uri", "Landroid/net/Uri;", "handleCropResult", "result", "Landroidx/activity/result/ActivityResult;", "uploadCroppedAvatar", "imageFileUri", "uploadAvatarSuccess", "fileUri", "url", "uploadAvatarFail", "message", "dismissLoadingDialogSafely", "notifyFail", "isCommonImageType", "", "copyToJpgFile", "Ljava/io/File;", "activity", "Landroidx/fragment/app/FragmentActivity;", "dst", "Callback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileAvatarEditHostFragment extends Fragment {
    public static final /* synthetic */ int i = 0;
    public a d;
    public final Lazy e;
    public ActivityResultLauncher<String> f;
    public ActivityResultLauncher<Intent> g;
    public ActivityResultLauncher<Intent> h;

    public interface a {
        void a(Uri r1, String r2);

        void onFail(String r1);
    }

    public static final class b {
    }

    static {
    }

    public final void T90() {
        l0 r0 = (l0) this.e.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isShowing() == false) goto L31;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L18;
        View r2 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L14:
        if (r2 == null) goto L18;
        boolean r4 = true;
        if (r2.isAttachedToWindow() != true) goto L18;
    L19:
        if (r4 == false) goto L33;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L23
        S90(r0);     // Catch: Throwable -> L23
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L32;
        FLogger.a.e("ProfileAvatarEditHost", "dismiss loading dialog failed: " + r7.getMessage());
        return;
    L32:
        return;
    L23:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L33:
        return;
    L18:
        r4 = false;
        goto L19
    }

    public ProfileAvatarEditHostFragment() {
        this.e = LazyKt.lazy(new d(this));
    }

    public static void S90(l0 r3) {
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

    public final void U90(Uri r13) {
        ActivityResultLauncher<Intent> r0 = null;
        if (r13 != null) goto L6;
        this.d = null;
        return;
    L6:
        FragmentActivity r5 = getActivity();
        if (r5 != null) goto L10;
        this.d = null;
        return;
    L10:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r5.getCacheDir(), "profile");
        if (r2.exists() == true) goto L13;
        r2.mkdirs();
    L13:
        FragmentActivity r1 = getActivity();
        boolean r3 = false;
        if (r1 == null) goto L59;
        String r4 = r1.getContentResolver().getType(r13);
        if (r4 != null) goto L19;
    L25:
        String r6 = MimeTypeMap.getFileExtensionFromUrl(r13.toString());
        if (r6 == null) goto L28;
        String r7 = r6.toLowerCase(Locale.getDefault());
    L29:
        if (r7 != null) goto L31;
    L34:
        boolean r8 = true;
    L35:
        if (r8 == true) goto L59;
        if (r7 == null) goto L52;
        int r9 = r7.hashCode();
        if (r9 == 105441) goto L51;
        if (r9 == 111145) goto L48;
        if (r9 != 3268712) goto L52;
        if (r7.equals("jpeg") == false) goto L52;
    L58:
        r3 = true;
        goto L59
    L48:
        if (r7.equals("png") == true) goto L58;
    L51:
        if (r7.equals("jpg") == true) goto L58;
    L52:
        String r10 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r7);
        if (r10 == null) goto L59;
        if (StringsKt.equals(r10, "image/jpeg", true) == true) goto L58;
        if (StringsKt.equals(r10, "image/png", true) == false) goto L59;
    L31:
        if (r7.length() == 0) goto L34;
        r8 = false;
        goto L35
    L28:
        r7 = null;
        goto L29
    L19:
        if (StringsKt.equals(r4, "image/jpeg", true) == true) goto L58;
        if (StringsKt.equals(r4, "image/png", true) == true) goto L58;
        if (StringsKt.equals(r4, "image/jpg", true) == false) goto L25;
    L59:
        if (r3 == false) goto L66;
        Uri r11 = Uri.fromFile(new PolarisFileWrapper(r2, "crop_user_avatar.jpg"));
        Intent r12 = new Intent();
        Bundle r14 = new Bundle();
        r14.putParcelable("com.yalantis.ucrop.InputUri", r13);
        r14.putParcelable("com.yalantis.ucrop.OutputUri", r11);
        r14.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r14.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        ActivityResultLauncher<Intent> r15 = this.h;
        if (r15 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
    L64:
        r12.setClass(r5, UCropActivity.class);
        r12.putExtras(r14);
        r0.launch(r12);
        return;
    L63:
        r0 = r15;
        goto L64
    L66:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ProfileAvatarEditHostFragment$handlePhotoPickerResult$1(r2, this, r13, r5, null), 2, null);
    }

    public final void V90(String r4) {
        T90();
        Context r0 = getContext();
        if (r0 != null) goto L5;
    L14:
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        a r1 = this.d;
        this.d = null;
        if (r1 == null) goto L20;
        r1.onFail(r4);
        return;
    L20:
        return;
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        s.a.getClass();
        s.b(r0, 2131900249, false);
        goto L14
    L13:
        s.a.getClass();
        s.c(r0, r4);
        goto L14
    L7:
        if (r4.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = registerForActivityResult(new ActivityResultContracts.GetContent(), new com.larus.profile.impl.lynx.avatar.a(this));
        this.g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.profile.impl.lynx.avatar.b(this));
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
    }
}
