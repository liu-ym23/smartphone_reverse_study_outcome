package com.larus.bmhome.chat.component.camera;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zb8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatCameraComponent$e implements IIMCallback<List<? extends BotModel>> {
    public final /* synthetic */ ChatCameraComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ HashMap<String, Object> c;
    public final /* synthetic */ a d;
    public final /* synthetic */ String e;
    public final /* synthetic */ CameraResultRoute f;
    public final /* synthetic */ CameraOutputContext g;
    public final /* synthetic */ boolean h;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r11) {
        Intrinsics.checkNotNullParameter(r11, "error");
        Intrinsics.checkNotNullParameter(r11, "error");
        ChatCameraComponent r1 = this.a;
        String r2 = this.b;
        HashMap<String, Object> r3 = this.c;
        a r4 = this.d;
        int r0 = ChatCameraComponent.S;
        r1.e4(r2, r3, r4, r1.U2(), this.e, this.f, this.g, this.h);
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("startCameraSync onFailure code=");
        r6.append(r11.getCode());
        r6.append(" tips=");
        r6.append(r11.getTips());
        r6.append(" err=");
        Throwable r12 = r11.getException();
        if (r12 == null) goto L5;
        r12.printStackTrace();
        Unit r13 = Unit.INSTANCE;
    L6:
        r6.append(r13);
        r5.i("ChatCameraComponent", r6.toString());
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final void onSuccess(Object r11) {
        List r12 = (List) r11;
        Intrinsics.checkNotNullParameter(r12, "result");
        BotModel r5 = (BotModel) CollectionsKt.firstOrNull(r12);
        ChatCameraComponent r1 = this.a;
        String r2 = this.b;
        HashMap<String, Object> r3 = this.c;
        a r4 = this.d;
        String r6 = this.e;
        CameraResultRoute r7 = this.f;
        CameraOutputContext r8 = this.g;
        boolean r9 = this.h;
        int r0 = ChatCameraComponent.S;
        r1.e4(r2, r3, r4, r5, r6, r7, r8, r9);
        FLogger.a.i("ChatCameraComponent", "startCameraSync onSuccess size=" + r12.size());
    }

    public ChatCameraComponent$e(ChatCameraComponent r1, String r2, HashMap<String, Object> r3, a r4, String r5, CameraResultRoute r6, CameraOutputContext r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
