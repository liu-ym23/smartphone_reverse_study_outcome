package com.larus.bot.impl.feature.edit.feature.avatar;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.databinding.LarusLayoutBotEditAvatarBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarGenActionSheet;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarPromptInputDialog;
import com.larus.platform.model.EditPos;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotAvatarEditView implements u {
    public static final /* synthetic */ int n = 0;
    public final TraceFragment a;
    public final LarusLayoutBotEditAvatarBinding b;
    public final v c;
    public final dv8.b d;
    public final x1 e;
    public final LifecycleCoroutineScope f;
    public AvatarGenActionSheet g;
    public Dialog h;
    public ActivityResultLauncher<String> i;
    public ActivityResultLauncher<Intent> j;
    public ActivityResultLauncher<Intent> k;
    public String l;
    public AvatarPromptInputDialog m;

    public static final class a {
    }

    static {
    }

    public static void b(Dialog r3) {
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

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.u
    public final void a(EditPos r12) {
        LarusLayoutBotEditAvatarBinding r0 = this.b;
        this.c.dispatchUIAction(com.larus.bot.impl.feature.edit.feature.avatar.a.C0055a.a);
        this.i = this.a.registerForActivityResult(new ActivityResultContracts.GetContent(), new f(this));
        this.j = this.a.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g(this));
        this.k = this.a.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this));
        e1.d(r0.e, new d(this));
        e1.d(r0.b, new j(this));
        e1.d(r0.d, new k(this));
        if (r12 == null) goto L16;
        v r4 = this.c;
        if ((r4 instanceof BotAvatarEditViewModel) == false) goto L7;
        BotAvatarEditViewModel r5 = (BotAvatarEditViewModel) r4;
    L8:
        if (r5 == null) goto L16;
        if (r5.getScene() != 1) goto L16;
        r0.e.setClickable(r12.g());
        AppCompatImageView r6 = r0.d;
        if (r12.g() == false) goto L14;
        int r13 = 0;
    L15:
        r6.setVisibility(r13);
        goto L16
    L14:
        r13 = 8;
        goto L15
    L7:
        r5 = null;
    L16:
        BuildersKt.launch$default(this.f, null, null, new BotAvatarEditView$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.c.getUiEvent(), new BotAvatarEditView$bindObservers$2(this, null)), this.f);
        e10 r14 = e10.a;
        if (e10.B0() == false) goto L20;
        r0.d.setVisibility(8);
        r0.c.setEnabled(false);
        return;
    }

    public final void c(Uri r9) {
        if (r9 == null) goto L9;
        FLogger.a.i("BotAvatarEditView", "onActivityResult called, icon_uri = " + r9.toString().length());
        ActivityResultLauncher<Intent> r0 = this.k;
        if (r0 == null) goto L10;
        FragmentActivity r1 = this.a.getActivity();
        if (r1 == null) goto L11;
        BuildersKt.launch$default(this.f, null, null, new BotAvatarEditView$handlePhotoPickerResult$1$1$1$1(r1, r9, r0, null), 3, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.u
    public final void onResult(int r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
    }

    public BotAvatarEditView(TraceFragment r2, LarusLayoutBotEditAvatarBinding r3, v r4, dv8.b r5, x1 r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner());
    }
}
