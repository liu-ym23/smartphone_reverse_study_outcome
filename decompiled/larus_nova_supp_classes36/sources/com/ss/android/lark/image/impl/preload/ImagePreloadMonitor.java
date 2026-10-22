package com.ss.android.lark.image.impl.preload;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;
import xwa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ImagePreloadMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_IMAGE_PRELOAD", "onPreloadFinish", "", "isSuccess", "", "latency", "", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImagePreloadMonitor {
    public static final ImagePreloadMonitor INSTANCE = null;

    static {
        INSTANCE = new ImagePreloadMonitor();
    }

    private ImagePreloadMonitor() {
    }

    @JvmStatic
    public static final void onPreloadFinish(boolean r5, int r6) {
        boolean r0 = NetworkUtils.d(LarkContext.getApplication());
        boolean r1 = ActivityLifeObserver.getInstance().isForeground();
        boolean r2 = ((b) k.a(LarkContext.getApplication(), b.class)).a();
        if (r5 == false) goto L5;
        String r7 = "success";
    L6:
        String r3 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
        if (r0 == false) goto L9;
        Object r4 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
    L10:
        if (r1 == false) goto L12;
        Object r8 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
    L13:
        if (r2 == true) goto L16;
        r3 = "0";
    L16:
        JSONObject r9 = new JSONObject().put("result", r7).put("latency", r6).put("net_state", r4).put("app_is_front", r8).put("is_in_doze", r3);
        Log.i("ImagePreloadMonitor", "onPreloadFinish, params:" + r9);
        Statistics.sendEvent("image_preload_result_dev", r9);
        return;
    L12:
        r8 = "0";
        goto L13
    L9:
        r4 = "0";
        goto L10
    L5:
        r7 = "failed";
        goto L6
    }
}
