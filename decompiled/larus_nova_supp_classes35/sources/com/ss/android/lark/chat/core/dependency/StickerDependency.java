package com.ss.android.lark.chat.core.dependency;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface StickerDependency {

    public static class UISticker implements Serializable {
        public final String filePath;
        public final int selected;
        public final Sticker sticker;

        public UISticker() {
            this.selected = -1;
            this.sticker = null;
            this.filePath = BuildConfig.FLAVOR;
        }

        public UISticker(Sticker r1) {
            this.sticker = r1;
            this.selected = -1;
            this.filePath = BuildConfig.FLAVOR;
        }

        public UISticker(Sticker r1, int r2, String r3) {
            this.sticker = r1;
            this.selected = r2;
            this.filePath = r3;
        }
    }

    void n0(List<Sticker> r1, IGetDataCallback<Boolean> r2);

    void o0(Context r1, int r2, int r3, String r4, ChatImageView r5, String r6, PerfLoadPicMonitor.MonitorRequestListener r7, int r8, int r9, int r10);

    void p0();

    void saveImage2Stickers(String r1, String r2, IGetDataCallback<Boolean> r3);

    Sticker y(String r1);
}
