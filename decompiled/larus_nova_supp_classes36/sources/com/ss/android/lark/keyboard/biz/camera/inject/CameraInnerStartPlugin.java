package com.ss.android.lark.keyboard.biz.camera.inject;

import android.view.LayoutInflater;
import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wnb.b;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CameraInnerStartPlugin implements b<CameraInnerStartPlugin> {
    public static final a e = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public final Lazy b;
    public com.ss.android.lark.keyboard.b c;
    public c d;

    public static final class a implements b.a<CameraInnerStartPlugin> {
        public a() {
        }
    }

    static {
        e = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final /* synthetic */ void onDestroy() {
    }

    @Override // wnb.b
    public final View a() {
        View r0 = LayoutInflater.from(this.a.a.requireContext()).inflate(2131561608, null);
        r0.setOnClickListener(new CameraInnerStartPlugin$getPluginView$1$1(this));
        r0.setOnLongClickListener(new CameraInnerStartPlugin$getPluginView$1$2(this));
        return r0;
    }

    @Override // wnb.b
    public final e b() {
        return new e(UIHelper.dp2px(12.0f), 0, 0, 0);
    }

    @Override // wnb.b
    public final c h() {
        c r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.BOTTOM;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerStart;
    }

    @Override // wnb.b
    public final b.a<CameraInnerStartPlugin> getKey() {
        return e;
    }

    public CameraInnerStartPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.b = LazyKt.lazy(CameraInnerStartPlugin$cameraExtension$2.INSTANCE);
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public static final void f(CameraInnerStartPlugin r1, Function0 r2, String r3) {
        if (((xxa.a) r1.b.getValue()) != null) goto L7;
        Log.e("CameraInnerStartPlugin", "cameraExtension is null, failed to start camera or photo.");
        if (DevEnvUtil.isDevelopPackage(r1.a.a.requireContext()) == false) goto L9;
        UDToast.show(r1.a.a.requireContext(), r3);
        return;
    L9:
        return;
    L7:
        r2.invoke();
    }
}
