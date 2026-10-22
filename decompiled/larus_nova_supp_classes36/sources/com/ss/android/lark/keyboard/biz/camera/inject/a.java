package com.ss.android.lark.keyboard.biz.camera.inject;

import com.ss.android.lark.biz.im.api.extension.chat_window.b;
import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements d<CameraInnerStartPlugin> {
    public final v a;
    public final b b;

    public final String getName() {
        return "camera_inner_start_view";
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        return new CameraInnerStartPlugin(this.b);
    }

    public a(v r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.a = r2;
        this.b = r3;
    }
}
