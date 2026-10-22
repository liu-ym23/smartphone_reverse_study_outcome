package com.bytedance.android.ec.core.widget.liveboxview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m8a.d;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J`\u0010\u001a\u001a\u00020\u000e2&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016JL\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u001d2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\"H\u0016JH\u0010&\u001a\u00020\u000e2&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/core/widget/liveboxview/HybridLynxHostServiceImpl;", "Lyj/t;", "Landroid/content/Context;", "context", "Lcom/bytedance/android/ec/hybrid/ui/IHybridLiveBoxView;", "getHybridLiveBoxView", "", "reUse", "getHybridLiveBoxViewWithReUse", "isNative", "Lcom/bytedance/android/ec/hybrid/ui/IHybridVideoBoxView;", "getHybridVideoBoxView", "", "roomID", "", "createPlayViewAndSave", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Landroid/view/View;", "view", "mediaType", "liveData", "videoData", "aweme", "enterDetailByMediaWrapper", "bizTag", "sceneTag", "", "monitorParams", com.bytedance.android.ec.core.event.a.KEY_URL, "supportAsyncCreateView", "enableImageAutoSize", "", "getImageBehaviors", "getBehaviorsFromXelemet", "newAnim", "videoEnterDetailByCover", "", "getSplitWidth", "()Ljava/lang/Integer;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridLynxHostServiceImpl implements t {
    public HybridLynxHostServiceImpl() {
    }

    public void createPlayViewAndSave(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "roomID");
    }

    public void enterDetailByMediaWrapper(HashMap<String, Object> r10, View r11, Context r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "mediaType");
        Intrinsics.checkNotNullParameter(r14, "liveData");
        Intrinsics.checkNotNullParameter(r15, "videoData");
        Intrinsics.checkNotNullParameter(r16, "aweme");
    }

    public List<Object> getBehaviorsFromXelemet() {
        return null;
    }

    public IHybridVideoBoxView getHybridVideoBoxView(Context r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return null;
    }

    public List<Object> getImageBehaviors(String r1, String r10, Map<String, ? extends Object> r11, String r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r1, "bizTag");
        Intrinsics.checkNotNullParameter(r10, "sceneTag");
        Intrinsics.checkNotNullParameter(r11, "monitorParams");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        return null;
    }

    public Integer getSplitWidth() {
        return null;
    }

    public boolean isOptProductCardTransition() {
        return false;
    }

    public void videoEnterDetailByCover(HashMap<String, Object> r1, View r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "videoData");
    }

    public void forbidExitAnima(String r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r10, "type");
    }

    public IHybridLiveBoxView getHybridLiveBoxView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return new HybridLiveBoxView(r10);
    }

    public IHybridLiveBoxView getHybridLiveBoxViewWithReUse(Context r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return getHybridLiveBoxView(r1);
    }

    public void setGylActivityBitmap(Bitmap r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "type");
    }

    public void setGylItemViewBitmap(Bitmap r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "type");
    }

    public boolean drawBigImage(d r10, Context r11, Canvas r12, ImageRequest r13, d.a r14, DisplayMetrics r15) {
        Intrinsics.checkNotNullParameter(r10, "bigImageDrawHelper");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "canvas");
        Intrinsics.checkNotNullParameter(r10, "bigImageDrawHelper");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "canvas");
        return r10.g(r11, r12, r13, r14);
    }
}
