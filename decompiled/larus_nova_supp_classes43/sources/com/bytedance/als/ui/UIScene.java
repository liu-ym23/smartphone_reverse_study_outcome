package com.bytedance.als.ui;

import android.os.Bundle;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import com.bytedance.scene.group.UserVisibleHintGroupScene;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/als/ui/UIScene;", "", "STATE", "ACTION", "Lcom/bytedance/scene/group/UserVisibleHintGroupScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class UIScene<STATE, ACTION> extends UserVisibleHintGroupScene {
    public boolean z;

    public void onResume() {
        super/*com.bytedance.scene.Scene*/.onResume();
        if (this.z == false) goto L6;
        this.z = false;
        return;
    }

    public UIScene() {
    }

    public final void W(Bundle r10) {
        super.W(r10);
        Iterator r11 = CollectionsKt.toList(((GroupScene) this).q.g()).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        y0((Scene) r11.next());
        goto L4
    }
}
