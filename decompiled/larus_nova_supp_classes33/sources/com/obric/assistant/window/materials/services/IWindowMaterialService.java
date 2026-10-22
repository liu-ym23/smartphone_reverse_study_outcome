package com.obric.assistant.window.materials.services;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.assistant.window.materials.MaterialSceneType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J2\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/window/materials/services/IWindowMaterialService;", "", "isMaterialEnabled", "", "context", "Landroid/content/Context;", "setupMaterials", "", "view", "Landroid/view/View;", "materialSceneType", "Lcom/obric/assistant/window/materials/MaterialSceneType;", "processWindowBottomMenu", "bgViews", "", "iconViews", "Landroid/widget/ImageView;", "textViews", "Landroid/widget/TextView;", "isBlurEnabled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWindowMaterialService {
    void a(View r1, MaterialSceneType r2);

    boolean b(Context r1);

    void c(List<? extends View> r1, List<? extends ImageView> r2, List<? extends TextView> r3);
}
