package com.larus.bmhome.music.edit;

import android.R;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.music.databinding.LarusDialogFragmentMusicNameEditBinding;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.platform.service.e0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 82\u00020\u0001:\u00018Bv\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016¢\u0006\u0004\b\u0013\u0010\u0015J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0002J\b\u00100\u001a\u00020\u0012H\u0002J?\u00101\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052%\b\u0002\u00102\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0002J=\u00103\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00052%\b\u0002\u00102\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0082@¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/larus/bmhome/music/edit/MusicNameEditSheetDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "musicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "messageId", "", "creationId", "originMusicName", "currentPage", "isMusicAppletScene", "", "musicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "editMusicName", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newTitle", "", "<init>", "(Lcom/larus/im/bean/message/block/MusicCreationContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/bmhome/music/mob/MusicAppletMobContext;Lkotlin/jvm/functions/Function1;)V", "()V", "binding", "Lcom/larus/bmhome/music/databinding/LarusDialogFragmentMusicNameEditBinding;", "isClickConfirm", "onDismissListener", "getOnDismissListener", "()Lkotlin/jvm/functions/Function1;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "onResume", "onPause", "onDestroyView", "initDialog", "initView", "editName", "editNameCallback", "editCreationName", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toastError", "errorString", "releaseImeFocus", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicNameEditSheetDialogFragment extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public final MusicCreationContent d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final kr8.o j;
    public final Function1<String, Unit> k;
    public LarusDialogFragmentMusicNameEditBinding l;
    public boolean m;
    public Function1<? super Boolean, Unit> n;

    public static final class a {
    }

    static {
    }

    public MusicNameEditSheetDialogFragment() {
        this(new MusicCreationContent(), "", "", "", "", false, null, new y());
        T90(this);     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("MusicNameEditSheetDialogFragment", "fallback by dismiss failed");
    }

    public final void V90() {
        if (this.i == true) goto L5;
        return;
    L5:
        LarusDialogFragmentMusicNameEditBinding r0 = this.l;
        if (r0 != null) goto L8;
        return;
    L8:
        InputMethodManager r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        EditText r2 = r0.e;
        IBinder r3 = r2.getWindowToken();
        if (r3 != null) goto L30;
        Dialog r4 = getDialog();
        if (r4 == null) goto L20;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L20;
        View r6 = S90(r5);
        if (r6 == null) goto L20;
        r3 = r6.getWindowToken();
    L21:
        if (r3 != null) goto L30;
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L29;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L29;
        View r9 = S90(r8);
        if (r9 == null) goto L29;
        r3 = r9.getWindowToken();
    L29:
        r3 = null;
    L20:
        r3 = null;
    L30:
        Context r10 = getContext();
        if (r10 == null) goto L33;
        Object r11 = r10.getSystemService("input_method");
    L35:
        if ((r11 instanceof InputMethodManager) == false) goto L37;
        r1 = (InputMethodManager) r11;
    L37:
        if (r3 == null) goto L40;
        if (r1 == null) goto L40;
        r1.hideSoftInputFromWindow(r3, 0);
    L40:
        r2.clearFocus();
        Dialog r12 = getDialog();
        if (r12 == null) goto L48;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L49;
        View r14 = S90(r13);
        if (r14 == null) goto L50;
        r14.clearFocus();
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L33:
        r11 = null;
        goto L35
    }

    public final void onDestroyView() {
        V90();
        super.onDestroyView();
    }

    public final void onPause() {
        V90();
        super/*androidx.fragment.app.Fragment*/.onPause();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setSoftInputMode(2);
        return;
    L9:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L10;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r2.width = r4;
        if (r4 <= i5.L()) goto L9;
        r2.width = i5.L();
    L9:
        r1.setAttributes(r2);
    L10:
        LarusDialogFragmentMusicNameEditBinding r5 = this.l;
        LarusDialogFragmentMusicNameEditBinding r6 = null;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L13:
        r5.e.postDelayed(new w(this), 100);
        LarusDialogFragmentMusicNameEditBinding r7 = this.l;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L16:
        r7.e.postDelayed(new x(this), 100);
        LarusDialogFragmentMusicNameEditBinding r8 = this.l;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        r6.e.requestFocus();
        return;
    L19:
        r6 = r8;
        goto L20
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void T90(MusicNameEditSheetDialogFragment r1) {
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

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        V90();
        super.onCancel(r2);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        V90();     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        Function1<? super Boolean, Unit> r3 = this.n;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.invoke(Boolean.valueOf(this.m));     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        Dialog r8 = getDialog();
        if (r8 == null) goto L5;
        View r9 = r8.findViewById(2131368870);
    L6:
        if (r9 == null) goto L8;
        r9.setBackgroundResource(R.color.transparent);
    L8:
        LarusDialogFragmentMusicNameEditBinding r10 = this.l;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L11:
        r10.e.setText(this.g);
        LarusDialogFragmentMusicNameEditBinding r11 = this.l;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L14:
        e1.d(r11.b, new z(this));
        LarusDialogFragmentMusicNameEditBinding r12 = this.l;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L17:
        e1.d(r12.c, new a0(this));
        LarusDialogFragmentMusicNameEditBinding r13 = this.l;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L20:
        r13.e.addTextChangedListener(new b0(this));
        String r0 = this.h;
        String r1 = this.d.getVid();
        String r2 = this.h;
        if (Intrinsics.areEqual(r2, "chat") == false) goto L24;
        String r3 = "click_music_card";
    L27:
        kr8.b r14 = new kr8.b(r0, r1, r3, 1);
        if (this.i == false) goto L30;
        kr8.n r4 = kr8.n.a;
        kr8.o r5 = this.j;
        String r15 = this.h;
        String r16 = this.g;
        Intrinsics.checkNotNullParameter(r15, "currentPage");
        JSONObject r17 = kr8.n.c(r5, r15, true);
        kr8.n.f(r17, "old_title", r16);
        kr8.n.f(r17, "new_title", null);
        kr8.l.a.b(r14, r17, 1);
        return;
    L30:
        kr8.l.a.b(r14, null, 3);
        return;
    L24:
        if (Intrinsics.areEqual(r2, "music_detail") == false) goto L26;
        r3 = "click_music_detail";
        goto L27
    L26:
        r3 = "";
        goto L27
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562076, r9, false);
        int r12 = 2131365114;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131365114);
        if (r3 == null) goto L23;
        r12 = 2131367639;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131367639);
        if (r4 == null) goto L23;
        r12 = 2131368982;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131368982)) == null) goto L23;
        r12 = 2131369197;
        View r5 = ViewBindings.findChildViewById(r11, 2131369197);
        if (r5 == null) goto L23;
        r12 = 2131380503;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r11, 2131380503);
        if (r6 == null) goto L23;
        this.l = new LarusDialogFragmentMusicNameEditBinding((LinearLayout) r11, r3, r4, r5, r6);
        Dialog r13 = getDialog();
        if (r13 == null) goto L17;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L17;
        r14.setBackgroundDrawable(new ColorDrawable(0));
    L17:
        LarusDialogFragmentMusicNameEditBinding r15 = this.l;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L21:
        return r15.a;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public static final Object U90(MusicNameEditSheetDialogFragment r5, String r6, Function1 r7, Continuation r8) {
        r5.getClass();
        if ((r8 instanceof MusicNameEditSheetDialogFragment$editCreationName$1) == false) goto L7;
        MusicNameEditSheetDialogFragment$editCreationName$1 r0 = (MusicNameEditSheetDialogFragment$editCreationName$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (Function1) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L20:
        Pair r10 = (Pair) r9;
        if (r10 == null) goto L23;
        ModifiedUserCreationResponse r4 = (ModifiedUserCreationResponse) r10.getFirst();
    L24:
        if (r4 == null) goto L26;
        T90(r5);
        r7.invoke(r6);
    L35:
        return Unit.INSTANCE;
    L26:
        int r11 = p0.a;
        if (r10 == null) goto L29;
        String r12 = (String) r10.getSecond();
    L30:
        String r13 = p0.a(r12);
        if (r13 != null) goto L33;
        r13 = AppHost.a.getApplication().getString(2131907952);
    L33:
        t19.s r14 = t19.s.a;
        Application r15 = AppHost.a.getApplication();
        r14.getClass();
        t19.s.c(r15, r13);
        T90(r5);
        r7.invoke(null);
        goto L35
    L29:
        r12 = null;
        goto L30
    L23:
        r4 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        e0 r16 = e0.a;
        String r17 = r5.f;
        if (r17 != null) goto L17;
        r17 = "";
    L17:
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.label = 1;
        r9 = r16.k(r17, r6, null, r0);
        if (r9 != r2) goto L20;
        return r2;
    L7:
        r0 = new MusicNameEditSheetDialogFragment$editCreationName$1(r5, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MusicNameEditSheetDialogFragment(MusicCreationContent r2, String r3, String r4, String r5, String r6, boolean r7, kr8.o r8, Function1<? super String, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "musicContent");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r5, "originMusicName");
        Intrinsics.checkNotNullParameter(r6, "currentPage");
        Intrinsics.checkNotNullParameter(r9, "editMusicName");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
    }
}
