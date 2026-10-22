package com.larus.bmhome.chat.layout.holder.image;

import android.net.Uri;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.kmp.chat.TemplateInfo;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface g0 {

    public static final class a {
        public static /* synthetic */ void a(g0 r7, SimpleDraweeView r8, Uri r9, Uri r10, int r11, boolean r12) {
            r7.a(r8, r9, r10, r11, r12, null);
        }
    }

    void a(SimpleDraweeView r1, Uri r2, Uri r3, int r4, boolean r5, n0 r6);

    void e(SimpleDraweeView r1, ImageItem r2, TemplateInfo.TemplateInfo r3, String r4, String r5, int r6, BotModel r7, com.larus.bmhome.chat.api.q0 r8, CoroutineScope r9, Function1 r10);

    ResizeOptions getImageSize();
}
