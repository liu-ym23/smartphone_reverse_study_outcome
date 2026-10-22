package com.ss.android.lark.keyboard.plugin.tool.face;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.sticker.StickerSet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import qsb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/keyboard/plugin/tool/face/FaceKBPlugin$loadLocalStickers$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/chat/entity/sticker/StickerSet;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FaceKBPlugin$loadLocalStickers$1 implements IGetDataCallback<List<? extends StickerSet>> {
    final /* synthetic */ long $startTime;
    final /* synthetic */ FaceKBPlugin this$0;

    public void onError(ErrorResult r6) {
        Intrinsics.checkNotNullParameter(r6, "err");
        long r0 = SystemClock.elapsedRealtime() - this.$startTime;
        int r2 = qsb.c.a;
        int r3 = r6.getCode();
        if (r3 != 0) goto L5;
        r3 = -1;
    L5:
        String r7 = r6.getDebugMsg();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new g(r7, r0, r3));
        List<StickerSet> r8 = FaceKBPlugin.d;
        throw null;
    }

    public void onSuccess(List<? extends StickerSet> r8) {
        long r0 = SystemClock.elapsedRealtime() - this.$startTime;
        int r2 = qsb.c.a;
        boolean r5 = false;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new g(null, r0, 0));
        if (r8 == null) goto L23;
        boolean r3 = true;
        if (FaceKBPlugin.d.size() != r8.size()) goto L18;
        Iterator<T> r1 = FaceKBPlugin.d.iterator();
        int r4 = 0;
    L9:
        if (r1.hasNext() == false) goto L17;
        Object r6 = r1.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        if (Intrinsics.areEqual((StickerSet) r6, ListProtector.get(r8, r4)) == true) goto L16;
        r5 = true;
    L16:
        r4 = r7;
        goto L9
    L17:
        r3 = r5;
    L18:
        Log.d("FaceKBPluginNew", "loadLocalStickers: onSticker ready, need update is " + r3);
        if (r3 == false) goto L27;
        List<StickerSet> r9 = FaceKBPlugin.d;
        FaceKBPlugin.d = TypeIntrinsics.asMutableList(r8);
        throw null;
    L27:
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((List) r1);
    }

    public FaceKBPlugin$loadLocalStickers$1(long r1, FaceKBPlugin r3) {
        this.$startTime = r1;
    }
}
