package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.graphics.Bitmap;
import com.larus.bot.impl.bean.BotGenBgImageDescPromptResponse;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AIGenBgImageRepository {
    public int a;

    public AIGenBgImageRepository() {
    }

    public final Object a(String r9, String r10, Function1<? super Boolean, Unit> r11, Continuation<? super Bitmap> r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AIGenBgImageRepository$cropAvatarFromImage$3(this, r9, r11, r10, null), r12);
    }

    public final Object c(String r9, GenBotImageRequest r10, String r11, Continuation<? super com.larus.network.http.a<BotGenBgImageDescPromptResponse>> r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AIGenBgImageRepository$generateBgImageDescPrompt$2(r9, r11, r10, this, null), r12);
    }

    public static Object d(AIGenBgImageRepository r2, String r3, String r4, String r5, ContinuationImpl r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r5 = null;
    L11:
        r2.getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new AIGenBgImageRepository$reviewBotInfo$2(r3, r4, r5, null), r6);
    }

    public final Object b(String r11, int r12, GenBotImageRequest r13, String r14, String r15, Continuation<? super com.larus.network.http.a<BotGenBgImageResponse>> r16) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AIGenBgImageRepository$generateBgImage$2(r14, r11, r12, r15, r13, this, null), r16);
    }
}
