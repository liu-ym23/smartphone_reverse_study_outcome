package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.audio;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements z {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ Function0<Unit> d;

    public final void a() {
        Function0<Unit> r0 = this.d;
        if (r0 == null) goto L5;
        r0.invoke();
        return;
    L5:
        FragmentActivity r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");     // Catch: Exception -> L8
        WindowInsetsUtils.c(r1).i(d.c(r1, 2131100549));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("Extensions", "[setNavigationBarColor] error", e);
    }

    public final void b() {
        if (this.a == true) goto L5;
        StatusBarUtil.setTransparent(this.b);
        return;
    L5:
        final FragmentActivity r0 = this.c.getActivity();
        if (r0 == null) goto L15;
        Function0<ViewModelProvider.Factory> r1 = new AudioKBPluginExtension$setupStatusBar$1$onVoiceKeyboardPopup$$inlined$viewModels$default$1(r0);
        final Function0 r6 = null;
        Integer r2 = (Integer) ((BottomSheetViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new AudioKBPluginExtension$setupStatusBar$1$onVoiceKeyboardPopup$$inlined$viewModels$default$2(r0), r1, new AudioKBPluginExtension$setupStatusBar$1$onVoiceKeyboardPopup$$inlined$viewModels$default$3(r6, r0)).getValue()).getState().getValue();
        if (r2 != null) goto L11;
    L12:
        StatusBarUtil.setTransparent(this.b);
        return;
    L11:
        if (r2.intValue() != 1) goto L12;
        return;
    }

    public a(boolean r1, FragmentActivity r2, Fragment r3, Function0<Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
