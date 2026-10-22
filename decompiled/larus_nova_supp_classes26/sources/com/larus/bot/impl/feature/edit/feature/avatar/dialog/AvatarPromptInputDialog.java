package com.larus.bot.impl.feature.edit.feature.avatar.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusDialogAvatarPromptInputBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.AvatarChooserFragment;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 02\u00020\u0001:\u00010B<\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012'\b\u0002\u0010\u0004\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\nH\u0016J?\u0010(\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\nH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0004\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/avatar/dialog/AvatarPromptInputDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "avatarPrompt", "", "avatarChooserListener", "Lkotlin/Function1;", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Lkotlin/ParameterName;", "name", "selectedAvatar", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogAvatarPromptInputBinding;", "avatarChooserFragment", "Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/AvatarChooserFragment;", "currentPrompt", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "isGenBg", "", "creationId", "createWay", "needUpdateBotInfo", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "setUp", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;)V", "setupView", "bindObservers", "disableSendAction", "enableSendAction", "showBgImageChooseDialog", "showAvatarChooserFragment", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarPromptInputDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int o = 0;
    public final String d;
    public final Function1<BotAvatarIconData, Unit> e;
    public LarusDialogAvatarPromptInputBinding f;
    public AvatarChooserFragment g;
    public String h;
    public x1 i;
    public boolean j;
    public String k;
    public String l;
    public boolean m;
    public BotModel n;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ AvatarPromptInputDialog a;

        public b(AvatarPromptInputDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L13;
            FLogger.a.i("AvatarPromptInputDialog", "dismiss when key back");
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return true;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L17;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return true;
        L17:
            return true;
        L13:
            return false;
        }
    }

    static {
    }

    public AvatarPromptInputDialog() {
        this(null, null);
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        LarusDialogAvatarPromptInputBinding r0 = this.f;
        if (r0 == null) goto L8;
        r0.c.requestFocus();
        x1 r1 = this.i;
        if (r1 == null) goto L9;
        x1.d(r1, 3);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarPromptInputDialog(String r1, Function1<? super BotAvatarIconData, Unit> r2) {
        this.d = r1;
        this.e = r2;
        this.h = "";
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        String r9 = this.d;
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        this.h = r9;
        Dialog r10 = getDialog();
        if (r10 == null) goto L8;
        r10.setOnKeyListener(new b(this));
    L8:
        Dialog r11 = getDialog();
        if (r11 == null) goto L11;
        r11.setOnCancelListener(new i());
    L11:
        LarusDialogAvatarPromptInputBinding r12 = this.f;
        if (r12 == null) goto L16;
        FrameLayout r13 = r12.a;
        if (r13 == null) goto L16;
        ViewExtKt.n(r13, null, null, new j(this), 3);
    L16:
        LarusDialogAvatarPromptInputBinding r14 = this.f;
        if (r14 == null) goto L36;
        String r0 = this.d;
        r14.c.setText(r0);
        e1.d(r14.b, new k(this));
        Editable r1 = r14.c.getText();
        if (r1 != null) goto L21;
    L24:
        boolean r2 = true;
    L25:
        if (r2 == false) goto L29;
        LarusDialogAvatarPromptInputBinding r3 = this.f;
        if (r3 == null) goto L29;
        r3.b.setEnabled(false);
        r3.b.setAlpha(0.3f);
    L29:
        r14.c.requestFocus();
        Dialog r4 = getDialog();
        if (r4 == null) goto L34;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L34;
        r5.setSoftInputMode(5);
    L34:
        r14.c.addTextChangedListener(new m(this, r14));
        goto L36
    L21:
        if (r1.length() == 0) goto L24;
        r2 = false;
    L36:
        if (this.j == false) goto L39;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AvatarPromptInputDialog$bindObservers$1(this, null), 3, null);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562033, r3, false);
        int r6 = 2131362132;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r5, 2131362132);
        if (r7 == null) goto L14;
        r6 = 2131383389;
        if (ViewBindings.findChildViewById(r5, 2131383389) == null) goto L14;
        r6 = 2131383390;
        AppCompatEditText r0 = ViewBindings.findChildViewById(r5, 2131383390);
        if (r0 == null) goto L14;
        this.f = new LarusDialogAvatarPromptInputBinding((FrameLayout) r5, r7, r0);
        this.i = new x1(r0);
        LarusDialogAvatarPromptInputBinding r8 = this.f;
        if (r8 != null) goto L15;
        return null;
    L15:
        return r8.a;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public static void S90(AvatarPromptInputDialog r0, boolean r1, String r2, String r3) {
        r0.j = r1;
        r0.k = r2;
        r0.l = r3;
        r0.m = false;
        r0.n = null;
    }
}
