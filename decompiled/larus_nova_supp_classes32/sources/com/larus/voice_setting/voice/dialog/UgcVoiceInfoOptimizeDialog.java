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
import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusDialogOptUserVoiceInfoBinding;
import com.larus.voice_setting.voice.ImageUploadViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.lottieadapter.LottieAdapterView;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.yalantis.ucrop.UCropActivity;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020\u001dH\u0002J\b\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020\u001dH\u0002J\b\u0010>\u001a\u00020\u0013H\u0002J\b\u0010?\u001a\u00020\u001dH\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\b\u0010D\u001a\u00020\u001dH\u0002J\b\u0010E\u001a\u00020\u001dH\u0016J\b\u0010F\u001a\u00020\u001dH\u0002J\u0012\u0010G\u001a\u00020\u001d2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\b\u0010J\u001a\u00020\u001dH\u0002J\b\u0010K\u001a\u00020\u001dH\u0002J\u0010\u0010L\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020\u0013H\u0002J\u0012\u0010N\u001a\u00020\u001d2\b\u0010O\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010P\u001a\u00020\u001d2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/UgcVoiceInfoOptimizeDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogOptUserVoiceInfoBinding;", "uploadViewModel", "Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "getUploadViewModel", "()Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "uploadViewModel$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", NameKeys.UnloadStrategy_No_Strategy, "pickSDKLauncher", "Landroid/content/Intent;", "cropLauncher", "needModifyInfo", NameKeys.UnloadStrategy_No_Strategy, "isVoicePlay", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "jumpToCreateVoice", "Lkotlin/Function2;", "Lcom/larus/voice_setting/voice/bean/UgcVoiceInfo;", NameKeys.UnloadStrategy_No_Strategy, "getJumpToCreateVoice", "()Lkotlin/jvm/functions/Function2;", "setJumpToCreateVoice", "(Lkotlin/jvm/functions/Function2;)V", "currentAvatarUrl", "voiceName", "isPublic", "currentAvatarUri", "cloneFail", "value", "originalVoiceInfo", "getOriginalVoiceInfo", "()Lcom/larus/voice_setting/voice/bean/UgcVoiceInfo;", "setOriginalVoiceInfo", "(Lcom/larus/voice_setting/voice/bean/UgcVoiceInfo;)V", "currentVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "initTitleBar", "initAvatar", "openPhoto", "showImagePreviewDialog", "isDefaultAvatar", "initName", "initPermission", "updatePermissionStatus", "initCompleteButton", "initVoiceCheckBar", "updateVoicePlayStatus", "onStop", "updatePlayIcon", "handlePhotoPickerResult", LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "initResultLauncher", "initViewModel", "changeCompleteButtonStatus", "enable", "setAvatarUrl", LynxEventReporter.PROP_NAME_URL, "uploadAvatarFail", "message", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceInfoOptimizeDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int t = 0;
    public LarusDialogOptUserVoiceInfoBinding d;
    public final Lazy e;
    public ActivityResultLauncher<String> f;
    public ActivityResultLauncher<Intent> g;
    public ActivityResultLauncher<Intent> h;
    public boolean i;
    public boolean j;
    public final Lazy k;
    public Function2<? super Boolean, ? super r2a.f, Unit> l;
    public String m;
    public String n;
    public boolean o;
    public String p;
    public boolean q;
    public r2a.f r;
    public SpeakerVoice s;

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

    public static final class c implements p68.e {
        public final /* synthetic */ UgcVoiceInfoOptimizeDialog a;

        public final void onBegin() {
        }

        public final void onError() {
        }

        public final void onEnd() {
            UgcVoiceInfoOptimizeDialog r0 = this.a;
            r0.j = false;
            r0.X90();
        }

        public c(UgcVoiceInfoOptimizeDialog r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void W90() {
        LarusDialogOptUserVoiceInfoBinding r0 = this.d;
        if (r0 == null) goto L25;
        AppCompatImageView r1 = r0.k;
        int r3 = 0;
        if (this.o == false) goto L7;
        int r2 = 0;
    L8:
        r1.setVisibility(r2);
        AppCompatImageView r4 = r0.j;
        if ((!this.o) == false) goto L11;
        int r5 = 0;
    L12:
        r4.setVisibility(r5);
        Context r6 = getContext();
        if (r6 == null) goto L19;
        TextView r7 = r0.d;
        if (this.o == false) goto L17;
        String r8 = r6.getString(2131910774);
    L18:
        r7.setText(r8);
        goto L19
    L17:
        r8 = r6.getString(2131901060);
    L19:
        TextView r9 = r0.h;
        if (this.o == true) goto L23;
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

    public final void X90() {
        if (this.j == false) goto L9;
        LarusDialogOptUserVoiceInfoBinding r0 = this.d;
        if (r0 == null) goto L15;
        LottieAdapterView r1 = r0.i;
        if (r1 == null) goto L16;
        r1.playAnimation();
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusDialogOptUserVoiceInfoBinding r2 = this.d;
        if (r2 == null) goto L18;
        LottieAdapterView r3 = r2.i;
        if (r3 == null) goto L19;
        r3.cancelAnimation();
        r3.setProgress(0.0f);
        return;
    L19:
        return;
    }

    public final void Y90() {
        this.j = !this.j;
        X90();
        SpeakerVoice r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.j == false) goto L15;
        p2a.q.a().stopAudio();
        com.larus.audio.s0 r2 = p2a.q.a();
        String r3 = r0.getStyleId();
        AudioPreview r1 = r0.getPreview();
        if (r1 == null) goto L9;
        String r4 = r1.getPreviewAudio();
    L10:
        AudioPreview r5 = r0.getPreview();
        if (r5 == null) goto L13;
        String r6 = r5.getMd5();
    L14:
        com.larus.audio.s0.a.a(r2, r3, r4, r6, new c(this), null, null, 48);
        return;
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L15:
        p2a.q.a().stopAudio();
    }

    public final void onStop() {
        if (this.j == false) goto L5;
        Y90();
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public UgcVoiceInfoOptimizeDialog() {
        final Function0<Fragment> r0 = new UgcVoiceInfoOptimizeDialog$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ImageUploadViewModel.class), new UgcVoiceInfoOptimizeDialog$special$$inlined$viewModels$default$2(r0), new UgcVoiceInfoOptimizeDialog$special$$inlined$viewModels$default$3(r0, this));
        this.k = LazyKt.lazy(new m0(this));
        this.m = NameKeys.UnloadStrategy_No_Strategy;
        this.n = NameKeys.UnloadStrategy_No_Strategy;
        this.o = true;
        this.p = NameKeys.UnloadStrategy_No_Strategy;
    }

    public static void S90(UgcVoiceInfoOptimizeDialog r1) {
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
        LarusDialogOptUserVoiceInfoBinding r0 = this.d;
        if (r0 == null) goto L10;
        r0.d.setClickable(r3);
        TextView r1 = r0.d;
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

    public final void Z90(String r4) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.common_ui.dialog.l0 r1 = (com.larus.common_ui.dialog.l0) this.k.getValue();
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
        LarusDialogOptUserVoiceInfoBinding r10 = this.d;
        if (r10 == null) goto L15;
        AppCompatImageView r11 = r10.c;
        if (r11 == null) goto L15;
        e1.d(r11, new n0(this));
    L15:
        LarusDialogOptUserVoiceInfoBinding r12 = this.d;
        if (r12 == null) goto L21;
        String r13 = this.m;
        if (r12 == null) goto L20;
        ImageLoaderKt.y(r12.l, r13, "settings_edit.avatar_default", new p0(r12), 4);
    L20:
        e1.d(r12.l, new s0(this));
        e1.d(r12.b, new t0(this));
    L21:
        LarusDialogOptUserVoiceInfoBinding r14 = this.d;
        if (r14 == null) goto L24;
        e1.d(r14.m, new k0(this));
        e1.d(r14.q, new l0(this));
    L24:
        final Context r15 = getContext();
        if (r15 == null) goto L30;
        final LarusDialogOptUserVoiceInfoBinding r16 = this.d;
        if (r16 == null) goto L30;
        r16.n.setText(this.n);
        e1.d(r16.e, new u0(r15, r16, this));
    L30:
        W90();
        LarusDialogOptUserVoiceInfoBinding r17 = this.d;
        if (r17 == null) goto L33;
        e1.d(r17.p, new i0(this));
        e1.d(r17.o, new j0(this));
    L33:
        LarusDialogOptUserVoiceInfoBinding r18 = this.d;
        if (r18 == null) goto L36;
        e1.d(r18.d, new y0(this));
    L36:
        this.f = registerForActivityResult(new ActivityResultContracts.GetContent(), new v0(this));
        this.g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new w0(this));
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new x0(this));
        ((ImageUploadViewModel) this.e.getValue()).getUpload().c.observe(getViewLifecycleOwner(), new b(new h0(this)));
        UgcVoiceLoader.x.observe(getViewLifecycleOwner(), new b(new q0(this)));
        UgcVoiceLoader.z.observe(getViewLifecycleOwner(), new b(new r0(this)));
        JSONObject r19 = new JSONObject();
        Intrinsics.checkNotNullParameter(r19, LynxResourceModule.PARAMS_KEY);
        TrackParams r20 = new TrackParams().merge(r19);
        by7.a r21 = new by7.a("popup_voice_edit_function_show");
        r21.a.merge(r20);
        r21.b();
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r23, ViewGroup r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        NestedScrollView r0 = r23.inflate(2131562091, r24, false);
        int r1 = 2131363642;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r0, 2131363642);
        if (r5 == null) goto L43;
        r1 = 2131363762;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r0, 2131363762);
        if (r6 == null) goto L43;
        r1 = 2131367598;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131367598);
        if (r7 == null) goto L43;
        r1 = 2131371409;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r0, 2131371409);
        if (r8 == null) goto L43;
        r1 = 2131371757;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r0, 2131371757);
        if (r9 == null) goto L43;
        r1 = 2131371771;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r0, 2131371771);
        if (r10 == null) goto L43;
        r1 = 2131382163;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131382163)) == null) goto L43;
        r1 = 2131382167;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131382167);
        if (r11 == null) goto L43;
        r1 = 2131382437;
        LottieAdapterView r12 = ViewBindings.findChildViewById(r0, 2131382437);
        if (r12 == null) goto L43;
        r1 = 2131383065;
        AppCompatImageView r13 = ViewBindings.findChildViewById(r0, 2131383065);
        if (r13 == null) goto L43;
        r1 = 2131383417;
        AppCompatImageView r14 = ViewBindings.findChildViewById(r0, 2131383417);
        if (r14 == null) goto L43;
        r1 = 2131392648;
        SimpleDraweeView r15 = ViewBindings.findChildViewById(r0, 2131392648);
        if (r15 == null) goto L43;
        r1 = 2131392710;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131392710)) == null) goto L43;
        r1 = 2131392721;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392721);
        if (r16 == null) goto L43;
        r1 = 2131392733;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r0, 2131392733);
        if (r17 == null) goto L43;
        r1 = 2131392736;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392736);
        if (r18 == null) goto L43;
        r1 = 2131392737;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392737);
        if (r19 == null) goto L43;
        r1 = 2131392738;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392738);
        if (r20 == null) goto L43;
        r1 = 2131392745;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131392745);
        if (r21 == null) goto L43;
        NestedScrollView r2 = r0;
        this.d = new LarusDialogOptUserVoiceInfoBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        return r2;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
