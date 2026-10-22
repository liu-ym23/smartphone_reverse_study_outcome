package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.databinding.LarusPageBotEditAvatarPreviewBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarGenActionSheet;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.BotBgImagePreviewView;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.widget.FixedAspectRatioConstraintLayout;
import com.larus.common_ui.dialog.l0;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u000e\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\"J\b\u00100\u001a\u00020 H\u0002J\u0012\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\rH\u0002J\u000f\u00103\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u00104J\n\u00105\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020 H\u0016J\u0010\u00108\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u00109\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u0004\u0018\u00010\r2\u0006\u0010<\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u0004\u0018\u00010\r2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010:J\u0018\u0010C\u001a\u0004\u0018\u00010\r2\u0006\u0010<\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010=J\u0018\u0010D\u001a\u0004\u0018\u00010\r2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\b\u0010E\u001a\u00020 H\u0002J½\u0001\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010\u00132\b\u0010L\u001a\u0004\u0018\u00010\u00132\b\u0010M\u001a\u0004\u0018\u00010\u00132\b\u0010N\u001a\u0004\u0018\u00010\u00132\b\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010\u00132\b\u0010S\u001a\u0004\u0018\u00010\u00132\b\u0010T\u001a\u0004\u0018\u00010\u00132\b\u0010U\u001a\u0004\u0018\u00010\u001c2\b\u0010V\u001a\u0004\u0018\u00010\u00132\b\u0010W\u001a\u0004\u0018\u00010\u00132\b\u0010X\u001a\u0004\u0018\u00010\u00132\b\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u0010Z\u001a\u00020\u001c2\b\u0010[\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\\Jg\u0010]\u001a\u00020 2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010^2\b\u0010K\u001a\u0004\u0018\u00010\u00132\b\u0010L\u001a\u0004\u0018\u00010\u00132\b\u0010M\u001a\u0004\u0018\u00010\u00132\b\u0010N\u001a\u0004\u0018\u00010\u00132\b\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010_\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020 H\u0002J\u0010\u0010b\u001a\u00020 2\u0006\u0010c\u001a\u00020dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/BotEditAvatarPreviewFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotEditAvatarPreviewBinding;", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/IBotEditAvatarPreviewViewModel;", "getViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/IBotEditAvatarPreviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bgLocalUri", "Landroid/net/Uri;", "avatarLocalUri", "cropLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pickLauncher", "", "pickSDKLauncher", "cropLauncherForChangeAvatar", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "routedToUCrop", "", "avatarActionSheet", "Lcom/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarGenActionSheet;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "onResult", "bundle", "initLauncher", "handlePhotoPickerResult", "uri", "initView", "()Lkotlin/Unit;", "getHitEnterFromString", "onStop", "onStart", "isLocalFile", "getBgBitmapUri", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndSaveBgBitmap", ShareType.URL, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBgBitmap", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvatarBitmapUri", "getAndSaveAvatarBitmap", "saveAvatarBitmap", "bindObservers", "reopen", "avatarInfo", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "bgImageInfo", "Lcom/larus/im/bean/bot/BgImage;", "botName", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "creationId", "createWay", "clickFrom", "ifBaseImage", "visualStyleStatus", "descriptionStatus", "originalImageUriLocal", "originalAvatarImageUri", "hasOriginAvatar", "originalBackgroundImageUri", "(Lcom/larus/bot/impl/bean/BotAvatarIconData;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "showAvatarActionSheet", "Lcom/larus/im/bean/bot/BgImageInfo;", "enterMethod", "(Lcom/larus/bot/impl/bean/BotAvatarIconData;Lcom/larus/im/bean/bot/BgImageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;)V", "openSystemAlbum", "refreshState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/preview/PreviewUIState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEditAvatarPreviewFragment extends TraceFragment {
    public static final /* synthetic */ int p = 0;
    public LarusPageBotEditAvatarPreviewBinding e;
    public final Lazy f;
    public volatile Uri g;
    public volatile Uri h;
    public ActivityResultLauncher<Intent> i;
    public ActivityResultLauncher<String> j;
    public ActivityResultLauncher<Intent> k;
    public ActivityResultLauncher<Intent> l;
    public final Lazy m;
    public boolean n;
    public AvatarGenActionSheet o;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "avatar_preview_page";
    }

    public final u X90() {
        return (u) this.f.getValue();
    }

    public BotEditAvatarPreviewFragment() {
        final Function0<Fragment> r0 = new BotEditAvatarPreviewFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotEditAvatarPreviewViewModel.class), new BotEditAvatarPreviewFragment$special$$inlined$viewModels$default$2(r0), new BotEditAvatarPreviewFragment$special$$inlined$viewModels$default$3(r0, this));
        this.m = LazyKt.lazy(new f(this));
    }

    public final String W90() {
        if (((y) X90().getUiState().getValue()).f == false) goto L5;
    L8:
        return "ai_generate";
    L5:
        if (X90().getBotCreateTrace().b == true) goto L8;
        return "upload";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        l0 r0 = (l0) this.m.getValue();
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        if (this.n == false) goto L28;
        LarusPageBotEditAvatarPreviewBinding r0 = this.e;
        if (r0 == null) goto L15;
        SimpleDraweeView r5 = r0.b;
        if (r5 == null) goto L15;
        Uri r6 = ((y) X90().getUiState().getValue()).b.a;
        Uri r1 = ((y) X90().getUiState().getValue()).b.a;
        if (r1 == null) goto L13;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (true != Intrinsics.areEqual(r1.getScheme(), ShareType.FILE)) goto L13;
        boolean r8 = true;
    L14:
        com.larus.bot.impl.common.util.h.b(r5, r6, "bot_edit_avatar_preview_start", r8, null, null, null, 120);
    L13:
        r8 = false;
    L15:
        LarusPageBotEditAvatarPreviewBinding r2 = this.e;
        if (r2 == null) goto L26;
        BotBgImagePreviewView r3 = r2.e;
        if (r3 == null) goto L26;
        Uri r7 = ((y) X90().getUiState().getValue()).c.a;
        Uri r9 = ((y) X90().getUiState().getValue()).c.a;
        if (r9 == null) goto L24;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (true != Intrinsics.areEqual(r9.getScheme(), ShareType.FILE)) goto L24;
        boolean r10 = true;
    L25:
        int r4 = BotBgImagePreviewView.e;
        com.larus.bot.impl.common.util.h.a(r3.d.e, r7, "bot_bg_image_preview", r10, null, null, false, null);
    L24:
        r10 = false;
    L26:
        this.n = false;
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        if (this.n == false) goto L15;
        LarusPageBotEditAvatarPreviewBinding r0 = this.e;
        if (r0 == null) goto L9;
        SimpleDraweeView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.setImageBitmap(null);
    L9:
        LarusPageBotEditAvatarPreviewBinding r2 = this.e;
        if (r2 == null) goto L16;
        BotBgImagePreviewView r3 = r2.e;
        if (r3 == null) goto L17;
        int r4 = BotBgImagePreviewView.e;
        com.larus.bot.impl.common.util.h.a(r3.d.e, null, "bot_bg_image_preview", false, null, null, false, null);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static boolean Y90(Uri r2) {
        if (Intrinsics.areEqual(ShareType.FILE, r2.getScheme()) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual("content", r2.getScheme()) == true) goto L8;
        return false;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        X90().dispatchUIAction(new w.d(getArguments()));
    }

    public final Object Z90(Bitmap r5, Continuation<? super Uri> r6) {
        if ((r6 instanceof BotEditAvatarPreviewFragment$saveAvatarBitmap$1) == false) goto L7;
        BotEditAvatarPreviewFragment$saveAvatarBitmap$1 r0 = (BotEditAvatarPreviewFragment$saveAvatarBitmap$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L19:
        File r8 = (File) r7;
        if (r8 == null) goto L22;
        FLogger.a.i("BotEditAvatarPreviewFragment", "save bitmap file is " + r8);
        return Uri.fromFile(r8);
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Context r9 = getContext();
        if (r9 == null) goto L22;
        r0.label = 1;
        r7 = BitmapHelperKt.g(r9, r5, "bot_edit_avatar_initial.jpg", r0);
        if (r7 != r2) goto L19;
        return r2;
    L7:
        r0 = new BotEditAvatarPreviewFragment$saveAvatarBitmap$1(this, r6);
        goto L8
    }

    public final Object aa0(Bitmap r5, Continuation<? super Uri> r6) {
        if ((r6 instanceof BotEditAvatarPreviewFragment$saveBgBitmap$1) == false) goto L7;
        BotEditAvatarPreviewFragment$saveBgBitmap$1 r0 = (BotEditAvatarPreviewFragment$saveBgBitmap$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L19:
        File r8 = (File) r7;
        if (r8 == null) goto L22;
        FLogger.a.i("BotEditAvatarPreviewFragment", "save bg bitmap file is " + r8);
        return Uri.fromFile(r8);
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Context r9 = getContext();
        if (r9 == null) goto L22;
        r0.label = 1;
        r7 = BitmapHelperKt.g(r9, r5, "bot_edit_bg_initial.jpg", r0);
        if (r7 != r2) goto L19;
        return r2;
    L7:
        r0 = new BotEditAvatarPreviewFragment$saveBgBitmap$1(this, r6);
        goto L8
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        this.i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new p(this));
        this.l = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new q(this));
        this.j = registerForActivityResult(new ActivityResultContracts.GetContent(), new r(this));
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        final LarusPageBotEditAvatarPreviewBinding r15 = this.e;
        String r16 = null;
        if (r15 == null) goto L5;
        NovaTitleBarEx.Y5(r15.j, r15.a.getContext().getString(2131901082), null, null, 6);
        NovaTitleBarEx.b6(r15.j, 2131241477, false, null, null, new b(this), 14);
        e1.d(r15.h, new j(r15));
        r15.g.setOnCheckedChangeListener(new k(this));
        e1.d(r15.b, new l(this));
        e1.d(r15.e, new m(this));
        e1.d(r15.f, new n(this));
        e1.d(r15.i, new o(this));
        Unit r17 = Unit.INSTANCE;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new BotEditAvatarPreviewFragment$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(X90().getUiEvent(), new BotEditAvatarPreviewFragment$bindObservers$2(this, null)), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.a, new BotEditAvatarPreviewFragment$bindObservers$3(this, null)), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
        if (X90().getBotCreateTrace().c() == null) goto L55;
        String r18 = X90().getBotCreateTrace().c();
        String r0 = X90().getBotCreateTrace().b();
        String r1 = W90();
        Boolean r2 = Boolean.valueOf(((y) X90().getUiState().getValue()).e);
        Boolean r3 = Boolean.valueOf(X90().getBotCreateTrace().a.getBoolean("if_base_image"));
        String r5 = X90().getBotCreateTrace().a.getString("visual_style_status");
        boolean r7 = true;
        if (r5 != null) goto L10;
    L14:
        r5 = null;
    L15:
        String r9 = X90().getBotCreateTrace().a.getString("description_status");
        if (r9 != null) goto L18;
    L24:
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r18 != null) goto L53;
    L29:
        if (r0 == null) goto L31;
        r8.put("create_way", r0);     // Catch: JSONException -> L27
    L31:
        r8.put("enter_method", r1);     // Catch: JSONException -> L27
        String r19 = "1";
        if (r3 != null) goto L35;
    L39:
        if (r5 == null) goto L41;
        r8.put("visual_style_status", r5);     // Catch: JSONException -> L27
    L41:
        if (r16 == null) goto L43;
        r8.put("description_status", r16);     // Catch: JSONException -> L27
    L43:
        if (r2 != null) goto L45;
    L51:
        TrackParams r110 = new TrackParams().merge(r8);
        by7.a r111 = new by7.a("bot_image_preview_page_enter");
        r111.a.merge(r110);
        r111.b();
        return;
    L45:
        if (r2.booleanValue() == true) goto L48;
        r19 = TriggerSendLoading.NO_LOADING;
    L48:
        r8.put("background_status", r19);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_preview_page_enter " + e.getLocalizedMessage());
        goto L51
    L35:
        if (r3.booleanValue() == false) goto L37;
        Object r4 = "1";
    L38:
        r8.put("if_base_image", r4);     // Catch: JSONException -> L27
        goto L39
    L37:
        r4 = TriggerSendLoading.NO_LOADING;
        goto L38
    L53:
        r8.put("creation_id", r18);     // Catch: JSONException -> L27
        goto L29
    L18:
        if (r9.length() == 0) goto L21;
        r7 = false;
    L21:
        if (r7 == true) goto L24;
        r16 = r9;
        goto L24
    L10:
        if (r5.length() != 0) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
    L12:
        r10 = false;
        goto L13
    }

    public static final Object U90(BotEditAvatarPreviewFragment r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1) == false) goto L7;
        BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1 r0 = (BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r5 = null;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        BotEditAvatarPreviewFragment r11 = (BotEditAvatarPreviewFragment) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L37
    L32:
        Uri r12 = (Uri) r10;     // Catch: Throwable -> L37
        if (r12 != null) goto L35;
    L34:
        FLogger.a.i("BotEditAvatarPreviewFragment", "bitmap is null");     // Catch: Throwable -> L37
        r12 = null;
    L35:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L37
    L39:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 != null) goto L42;
        r5 = r13;
    L43:
        r5 = (Uri) r5;
    L45:
        return r5;
    L42:
        FLogger.a.e("BotEditAvatarPreviewFragment", "get avatar Bitmap error", r14);
        goto L43
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r7 = (BotEditAvatarPreviewFragment) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L37
    L27:
        Bitmap r15 = (Bitmap) r10;     // Catch: Throwable -> L37
        if (r15 == null) goto L34;
        FLogger.a.i("BotEditAvatarPreviewFragment", "getBitmap end");     // Catch: Throwable -> L37
        r0.L$0 = r7;     // Catch: Throwable -> L37
        r0.label = 2;     // Catch: Throwable -> L37
        r10 = r7.Z90(r15, r0);     // Catch: Throwable -> L37
        if (r10 != r2) goto L32;
        return r2;
    L20:
        ResultKt.throwOnFailure(r10);
        LarusPageBotEditAvatarPreviewBinding r16 = r7.e;
        if (r16 == null) goto L45;
        if (r16.b == null) goto L45;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L37
        FLogger.a.i("BotEditAvatarPreviewFragment", "getBitmap start");     // Catch: Throwable -> L37
        r0.L$0 = r7;     // Catch: Throwable -> L37
        r0.label = 1;     // Catch: Throwable -> L37
        r10 = BitmapHelperKt.c(r8, r0);     // Catch: Throwable -> L37
        if (r10 != r2) goto L27;
        return r2;
    L37:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new BotEditAvatarPreviewFragment$getAndSaveAvatarBitmap$1(r7, r9);
        goto L8
    }

    public static final Object V90(BotEditAvatarPreviewFragment r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof BotEditAvatarPreviewFragment$getAndSaveBgBitmap$1) == false) goto L7;
        BotEditAvatarPreviewFragment$getAndSaveBgBitmap$1 r0 = (BotEditAvatarPreviewFragment$getAndSaveBgBitmap$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r5 = null;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        BotEditAvatarPreviewFragment r11 = (BotEditAvatarPreviewFragment) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L37
    L32:
        Uri r12 = (Uri) r10;     // Catch: Throwable -> L37
        if (r12 != null) goto L35;
    L34:
        FLogger.a.i("BotEditAvatarPreviewFragment", "bitmap is null");     // Catch: Throwable -> L37
        r12 = null;
    L35:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L37
    L39:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 != null) goto L42;
        r5 = r13;
    L43:
        r5 = (Uri) r5;
    L45:
        return r5;
    L42:
        FLogger.a.e("BotEditAvatarPreviewFragment", "get avatar Bitmap error", r14);
        goto L43
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r7 = (BotEditAvatarPreviewFragment) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L37
    L27:
        Bitmap r15 = (Bitmap) r10;     // Catch: Throwable -> L37
        if (r15 == null) goto L34;
        FLogger.a.i("BotEditAvatarPreviewFragment", "getBitmap end");     // Catch: Throwable -> L37
        r0.L$0 = r7;     // Catch: Throwable -> L37
        r0.label = 2;     // Catch: Throwable -> L37
        r10 = r7.aa0(r15, r0);     // Catch: Throwable -> L37
        if (r10 != r2) goto L32;
        return r2;
    L20:
        ResultKt.throwOnFailure(r10);
        LarusPageBotEditAvatarPreviewBinding r16 = r7.e;
        if (r16 == null) goto L45;
        if (r16.b == null) goto L45;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L37
        FLogger.a.i("BotEditAvatarPreviewFragment", "getBitmap start");     // Catch: Throwable -> L37
        r0.L$0 = r7;     // Catch: Throwable -> L37
        r0.label = 1;     // Catch: Throwable -> L37
        r10 = BitmapHelperKt.c(r8, r0);     // Catch: Throwable -> L37
        if (r10 != r2) goto L27;
        return r2;
    L37:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new BotEditAvatarPreviewFragment$getAndSaveBgBitmap$1(r7, r9);
        goto L8
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        ConstraintLayout r15 = r12.inflate(2131563003, r13, false);
        int r16 = 2131363623;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r15, 2131363623);
        if (r2 == null) goto L33;
        r16 = 2131363659;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131363659);
        if (r3 == null) goto L33;
        r16 = 2131363713;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r15, 2131363713);
        if (r4 == null) goto L33;
        r16 = 2131363723;
        if (((FixedAspectRatioConstraintLayout) ViewBindings.findChildViewById(r15, 2131363723)) == null) goto L33;
        r16 = 2131364138;
        BotBgImagePreviewView r5 = (BotBgImagePreviewView) ViewBindings.findChildViewById(r15, 2131364138);
        if (r5 == null) goto L33;
        r16 = 2131365457;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r15, 2131365457);
        if (r6 == null) goto L33;
        r16 = 2131365640;
        ChatCheckBox r7 = ViewBindings.findChildViewById(r15, 2131365640);
        if (r7 == null) goto L33;
        r16 = 2131365642;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131365642);
        if (r8 == null) goto L33;
        r16 = 2131367647;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131367647);
        if (r9 == null) goto L33;
        r16 = 2131374968;
        if (ViewBindings.findChildViewById(r15, 2131374968) == null) goto L33;
        r16 = 2131387023;
        if (ViewBindings.findChildViewById(r15, 2131387023) == null) goto L33;
        r16 = 2131387033;
        if (((Space) ViewBindings.findChildViewById(r15, 2131387033)) == null) goto L33;
        r16 = 2131387036;
        if (((Space) ViewBindings.findChildViewById(r15, 2131387036)) == null) goto L33;
        r16 = 2131388772;
        NovaTitleBarEx r10 = (NovaTitleBarEx) ViewBindings.findChildViewById(r15, 2131388772);
        if (r10 == null) goto L33;
        ConstraintLayout r17 = r15;
        this.e = new LarusPageBotEditAvatarPreviewBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return r17;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
