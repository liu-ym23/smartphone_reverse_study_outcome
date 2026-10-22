package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import android.content.Intent;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.api.ScreenshotRestrictControllerViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.params.FlagState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RestrictScreenPlugin extends d {
    public c a;
    public ScreenshotRestrictControllerViewModel b;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ RestrictScreenPlugin a;
        public final /* synthetic */ c b;

        public b(RestrictScreenPlugin r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            Chat r5 = (Chat) r4;
            if (ForsetiConfig.b() == true) goto L5;
            RestrictScreenPlugin.b(this.a, !y0.e(r5));
            return;
        L5:
            FragmentActivity r0 = this.b.b.getActivity();
            if (r0 != null) goto L8;
        L10:
            boolean r1 = false;
        L11:
            if (r1 == true) goto L13;
            return;
        L13:
            if (y0.e(r5) == true) goto L15;
            this.a.c(false);
            return;
        L15:
            this.a.c(true);
            return;
        L8:
            if (ForsetiConfig.a(r0) != true) goto L10;
            r1 = true;
            goto L11
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.d, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.d, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.d, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void onStart() {
        c r0 = this.a;
        c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        r0 = null;
    L5:
        FragmentActivity r2 = r0.b.getActivity();
        if (r2 == null) goto L10;
        boolean r4 = true;
        if (ForsetiConfig.a(r2) != true) goto L10;
    L11:
        if (r4 == false) goto L20;
        c r3 = this.a;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L17:
        if (y0.e((Chat) r1.c.getChatLiveData().getValue()) == true) goto L21;
        c(false);
        return;
    L21:
        return;
    L15:
        r1 = r3;
        goto L17
    L20:
        return;
    L10:
        r4 = false;
        goto L11
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.d, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void onStop() {
        c r0 = this.a;
        c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        r0 = null;
    L5:
        FragmentActivity r2 = r0.b.getActivity();
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L20;
        c r4 = this.a;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L17:
        if (y0.e((Chat) r1.c.getChatLiveData().getValue()) == true) goto L21;
        c(true);
        return;
    L21:
        return;
    L15:
        r1 = r4;
        goto L17
    L20:
        return;
    L8:
        if (ForsetiConfig.a(r2) != true) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.d, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void onDestroy() {
        if (ForsetiConfig.b() == false) goto L14;
        c r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        r0 = null;
    L7:
        FragmentActivity r1 = r0.b.getActivity();
        if (r1 != null) goto L10;
        return;
    L10:
        ScreenshotRestrictControllerViewModel r2 = this.b;
        if (r2 == null) goto L15;
        r2.unregisterRestrictControllerListener(r1);
        return;
    L15:
        return;
    }

    public RestrictScreenPlugin() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void a(c r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        this.a = r4;
        Fragment r0 = r4.b;
        r4.c.getChatLiveData().observe(r0, new b(this, r4));
        if (ForsetiConfig.b() == false) goto L9;
        ScreenshotRestrictControllerViewModel r5 = new ViewModelProvider(r0).get(ScreenshotRestrictControllerViewModel.class);
        FragmentActivity r1 = r0.getActivity();
        if (r1 != null) goto L7;
        return;
    L7:
        r5.registerRestrictControllerListener(r1, new RestrictScreenPlugin$onCreate$2$1(this));
        this.b = r5;
        return;
    }

    public final void c(boolean r4) {
        c r0 = this.a;
        DesktopCompatFragment r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        r0 = null;
    L5:
        Fragment r2 = r0.b;
        if ((r2 instanceof DesktopCompatFragment) == false) goto L8;
        r1 = (DesktopCompatFragment) r2;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        if (r4 == false) goto L14;
        FragmentActivity r5 = r1.getActivity();
        if (r5 == null) goto L18;
        new ViewModelProvider(r5).get(ScreenshotRestrictControllerViewModel.class).decrementScreenshotFlagCount(r1.getFragmentInfoId(), r1.getLifecycle().getCurrentState());
        return;
    L18:
        return;
    L14:
        FragmentActivity r6 = r1.getActivity();
        if (r6 == null) goto L20;
        new ViewModelProvider(r6).get(ScreenshotRestrictControllerViewModel.class).incrementScreenshotFlagCount(r1.getFragmentInfoId(), r1.getLifecycle().getCurrentState());
        return;
    }

    public static final void b(RestrictScreenPlugin r4, boolean r5) {
        c r6 = r4.a;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        r6 = null;
    L5:
        FragmentActivity r7 = r6.b.getActivity();
        if (r7 != null) goto L8;
        return;
    L8:
        if (UIUtils.isActivityRunning(r7) == false) goto L24;
        Window r0 = r7.getWindow();
        if (r5 == true) goto L16;
        Log.i("Full_RestrictScreen", "secret chat screen security is off");
        if (ChatCoreModule.a().getSecurityComplianceDependency().a() == true) goto L15;
        Log.i("Full_RestrictScreen", "admin screen security is off");
        r0.clearFlags(8192);
        return;
    L15:
        Log.i("Full_RestrictScreen", "admin screen security is on, banned screenshot");
        return;
    L16:
        Intent r8 = r7.getIntent();
        if (r8 == null) goto L19;
        r8.putExtra("SCS_FLAG_STATE", FlagState.Ban.getValue());
    L19:
        Log.i("Full_RestrictScreen", "secret chat screen security is on, banned screenshot");
        r0.setFlags(8192, 8192);
        return;
    }
}
