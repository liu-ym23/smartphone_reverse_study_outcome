package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/keyboard/plugin/tool/face/sticker/FacePageNewFragment2$forceLoadStickers$1", "Lcom/larksuite/framework/callback/UIGetDataCallback;", "", "Lcom/ss/android/lark/chat/entity/sticker/Sticker;", "onSuccessed", "", "data", "onErrored", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FacePageNewFragment2$forceLoadStickers$1 extends UIGetDataCallback<List<? extends Sticker>> {
    final /* synthetic */ FacePageNewFragment2 this$0;

    public FacePageNewFragment2$forceLoadStickers$1(FacePageNewFragment2 r1) {
        this.this$0 = r1;
    }

    public void onErrored(ErrorResult r3) {
        Log.e("FacePageNewFragment2", "forceLoadStickers error", r3);
    }

    public void onSuccessed(List<? extends Sticker> r2) {
        if (r2 != null) goto L5;
        onErrored(new ErrorResult("data is null"));
        return;
    L5:
        FacePageNewFragment2.S90(this.this$0, r2);
        int r3 = com.ss.android.lark.keyboard.plugin.tool.face.a.a;
        Statistics.sendEvent("sticker_add");
    }

    public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
        onSuccessed((List) r1);
    }
}
