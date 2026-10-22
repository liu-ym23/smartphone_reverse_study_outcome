package com.larus.voice_setting.voice.dialog;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusDialogEditUserVoiceInfoBinding;
import com.larus.voice_setting.voice.ImageUploadViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0002J\b\u0010@\u001a\u000209H\u0002J\b\u0010A\u001a\u000209H\u0002J\b\u0010B\u001a\u000209H\u0002J\b\u0010C\u001a\u000209H\u0002J\u0012\u0010D\u001a\u0002092\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\b\u0010G\u001a\u000209H\u0002J\b\u0010H\u001a\u000209H\u0002J\u0010\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u0013H\u0002J\u0012\u0010K\u001a\u0002092\b\u0010L\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010M\u001a\u0002092\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001c\u0010+\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u000e\u0010.\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/UgcVoiceInfoEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogEditUserVoiceInfoBinding;", "uploadViewModel", "Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", NameKeys.UnloadStrategy_No_Strategy, "pickSDKLauncher", "Landroid/content/Intent;", "cropLauncher", "needModifyInfo", NameKeys.UnloadStrategy_No_Strategy, "currentAvatarUrl", "getCurrentAvatarUrl", "()Ljava/lang/String;", "setCurrentAvatarUrl", "(Ljava/lang/String;)V", "currentAvatarUri", "getCurrentAvatarUri", "setCurrentAvatarUri", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "voiceName", "getVoiceName", "setVoiceName", "isPublic", "()Z", "setPublic", "(Z)V", "enterFrom", "getEnterFrom", "setEnterFrom", "voiceId", "getVoiceId", "setVoiceId", "isDefaultAvatar", "isDefaultName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", NameKeys.UnloadStrategy_No_Strategy, "view", "initView", "initTitleBar", "initAvatar", "openPhoto", "showImagePreviewDialog", "initName", "initPermission", "updatePermissionStatus", "initCompleteButton", "handlePhotoPickerResult", LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "initResultLauncher", "initViewModel", "changeCompleteButtonStatus", "enable", "setAvatarUrl", LynxEventReporter.PROP_NAME_URL, "uploadAvatarFail", "message", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceInfoEditDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int r = 0;
    public LarusDialogEditUserVoiceInfoBinding d;
    public final Lazy e;
    public ActivityResultLauncher<String> f;
    public ActivityResultLauncher<Intent> g;
    public ActivityResultLauncher<Intent> h;
    public boolean i;
    public String j;
    public String k;
    public final Lazy l;
    public String m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;

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

    public final void W90() {
        LarusDialogEditUserVoiceInfoBinding r0 = this.d;
        if (r0 == null) goto L25;
        AppCompatImageView r1 = r0.i;
        int r3 = 0;
        if (this.n == false) goto L7;
        int r2 = 0;
    L8:
        r1.setVisibility(r2);
        AppCompatImageView r4 = r0.h;
        if ((!this.n) == false) goto L11;
        int r5 = 0;
    L12:
        r4.setVisibility(r5);
        Context r6 = getContext();
        if (r6 == null) goto L19;
        TextView r7 = r0.e;
        if (this.n == false) goto L17;
        String r8 = r6.getString(2131910774);
    L18:
        r7.setText(r8);
        goto L19
    L17:
        r8 = r6.getString(2131901060);
    L19:
        TextView r9 = r0.g;
        if (this.n == true) goto L23;
        r3 = 8;
    L23:
        r9.setVisibility(r3);
        return;
    L11:
        r5 = 8;
        goto L12
    L7:
        r2 = 8;
        goto L8
    }

    public UgcVoiceInfoEditDialog() {
        final Function0<Fragment> r0 = new UgcVoiceInfoEditDialog$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ImageUploadViewModel.class), new UgcVoiceInfoEditDialog$special$$inlined$viewModels$default$2(r0), new UgcVoiceInfoEditDialog$special$$inlined$viewModels$default$3(r0, this));
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.k = NameKeys.UnloadStrategy_No_Strategy;
        this.l = LazyKt.lazy(new y(this));
        this.m = NameKeys.UnloadStrategy_No_Strategy;
        this.o = NameKeys.UnloadStrategy_No_Strategy;
        this.p = true;
        this.q = true;
    }

    public static void S90(UgcVoiceInfoEditDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void T90(com.larus.common_ui.dialog.l0 r3) {
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

    public final void U90(boolean r3) {
        LarusDialogEditUserVoiceInfoBinding r0 = this.d;
        if (r0 == null) goto L10;
        r0.e.setClickable(r3);
        TextView r1 = r0.e;
        if (r3 == false) goto L7;
        float r4 = 1.0f;
    L8:
        r1.setAlpha(r4);
        return;
    L7:
        r4 = 0.3f;
        goto L8
    }

    public final void V90(Uri r5) {
        if (r5 == null) goto L8;
        FLogger.a.i("UgcVoiceInfoOptimizeDialog", "onActivityResult called, icon_uri = " + r5);
        Uri r0 = Uri.fromFile(new PolarisFileWrapper(requireActivity().getCacheDir(), "crop_voice_avatar"));
        Intent r1 = new Intent();
        Bundle r2 = new Bundle();
        r2.putParcelable("com.yalantis.ucrop.InputUri", r5);
        r2.putParcelable("com.yalantis.ucrop.OutputUri", r0);
        r2.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r2.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        ActivityResultLauncher<Intent> r6 = this.h;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
        r6 = null;
    L6:
        r1.setClass(requireActivity(), UCropActivity.class);
        r1.putExtras(r2);
        r6.launch(r1);
        return;
    }

    public final void X90(String r4) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.common_ui.dialog.l0 r1 = (com.larus.common_ui.dialog.l0) this.l.getValue();
        if (r1 == null) goto L9;
        T90(r1);
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

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        BottomSheetDialog r7 = getDialog();
        View r0 = null;
        if ((r7 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r8 = r7;
    L6:
        if (r8 == null) goto L8;
        r0 = r8.findViewById(2131368870);
    L8:
        if (r0 == null) goto L10;
        BottomSheetBehavior r9 = BottomSheetBehavior.from(r0);
        r0.setBackgroundResource(R.color.transparent);
        r9.setState(3);
    L10:
        LarusDialogEditUserVoiceInfoBinding r10 = this.d;
        if (r10 == null) goto L15;
        AppCompatImageView r11 = r10.d;
        if (r11 == null) goto L15;
        e1.d(r11, new x(this));
    L15:
        LarusDialogEditUserVoiceInfoBinding r12 = this.d;
        if (r12 == null) goto L21;
        String r13 = this.j;
        if (r12 == null) goto L20;
        ImageLoaderKt.y(r12.j, r13, "settings_edit.avatar_default", new v(r12), 4);
    L20:
        e1.d(r12.j, new a0(this));
        e1.d(r12.b, new b0(this));
    L21:
        final Context r14 = getContext();
        if (r14 == null) goto L27;
        final LarusDialogEditUserVoiceInfoBinding r15 = this.d;
        if (r15 == null) goto L27;
        r15.k.setText(this.m);
        e1.d(r15.f, new r(r14, r15, this));
    L27:
        W90();
        LarusDialogEditUserVoiceInfoBinding r16 = this.d;
        if (r16 == null) goto L30;
        e1.d(r16.m, new f0(this));
        e1.d(r16.l, new s(this));
    L30:
        LarusDialogEditUserVoiceInfoBinding r17 = this.d;
        if (r17 == null) goto L33;
        e1.d(r17.e, new z(this));
    L33:
        this.f = registerForActivityResult(new ActivityResultContracts.GetContent(), new c0(this));
        this.g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d0(this));
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e0(this));
        ((ImageUploadViewModel) this.e.getValue()).getUpload().c.observe(getViewLifecycleOwner(), new b(new t(this)));
        UgcVoiceLoader.B.observe(getViewLifecycleOwner(), new b(new u(this)));
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        NestedScrollView r0 = r18.inflate(2131562067, r19, false);
        int r1 = 2131363642;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r0, 2131363642);
        if (r5 == null) goto L33;
        r1 = 2131363643;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131363643);
        if (r6 == null) goto L33;
        r1 = 2131366972;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r0, 2131366972);
        if (r7 == null) goto L33;
        r1 = 2131367598;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131367598);
        if (r8 == null) goto L33;
        r1 = 2131371409;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r0, 2131371409);
        if (r9 == null) goto L33;
        r1 = 2131382163;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131382163)) == null) goto L33;
        r1 = 2131382167;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131382167);
        if (r10 == null) goto L33;
        r1 = 2131383065;
        AppCompatImageView r11 = ViewBindings.findChildViewById(r0, 2131383065);
        if (r11 == null) goto L33;
        r1 = 2131383417;
        AppCompatImageView r12 = ViewBindings.findChildViewById(r0, 2131383417);
        if (r12 == null) goto L33;
        r1 = 2131392648;
        SimpleDraweeView r13 = ViewBindings.findChildViewById(r0, 2131392648);
        if (r13 == null) goto L33;
        r1 = 2131392710;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131392710)) == null) goto L33;
        r1 = 2131392733;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131392733);
        if (r14 == null) goto L33;
        r1 = 2131392736;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392736);
        if (r15 == null) goto L33;
        r1 = 2131392737;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392737);
        if (r16 == null) goto L33;
        NestedScrollView r2 = r0;
        this.d = new LarusDialogEditUserVoiceInfoBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return r2;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
