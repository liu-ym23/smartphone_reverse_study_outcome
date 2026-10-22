package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.sticker_office.OfficeStickerModule;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v implements StickerDependency {
    public v() {
    }

    public final void p0() {
    }

    public final Sticker y(String r2) {
        Lazy r0 = OfficeStickerModule.a;
        return com.ss.android.lark.sticker.core.di.c.a().y(r2);
    }

    public final void n0(List<Sticker> r2, IGetDataCallback<Boolean> r3) {
        Lazy r0 = OfficeStickerModule.a;
        com.ss.android.lark.sticker.core.di.c.a().n0(r2, r3);
    }

    public final void saveImage2Stickers(String r2, String r3, IGetDataCallback<Boolean> r4) {
        Lazy r0 = OfficeStickerModule.a;
        com.ss.android.lark.sticker.core.di.c.a().saveImage2Stickers(r2, r3, r4);
    }

    public final void o0(Context r14, int r15, int r16, String r17, ChatImageView r18, String r19, PerfLoadPicMonitor.MonitorRequestListener r20, int r21, int r22, int r23) {
        b6c.a.a.a.a(r14, r15, r16, r17, r18, 2131233569, 2131233586, r20, r21, r22, r23, 0);
    }
}
