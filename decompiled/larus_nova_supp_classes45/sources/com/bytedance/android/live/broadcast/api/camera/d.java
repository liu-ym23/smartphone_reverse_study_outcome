package com.bytedance.android.live.broadcast.api.camera;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l00.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;

    public d(a r1) {
        this.a = r1;
        this.b = "live_take_page";
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        a r8 = this.a;
        String r0 = this.b;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "enterFrom");
        ALogger.i("CameraDirtyCheckController", "startCheckDirty from:" + r0);
        if (r8.d.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        c r2 = new c(r8);
        int r9 = l00.d.a;
        Intrinsics.checkNotNullParameter("TaintSceneDetectModel", "requirement");
        Intrinsics.checkNotNullParameter("lens_taint_scene_detect", "modelName");
        Intrinsics.checkNotNullParameter(r2, "listener");
        DownloadableModelSupport.getInstance().fetchResourcesByRequirementsAndModelNames(new String[]{"TaintSceneDetectModel"}, MapsKt.mutableMapOf(new Pair[]{new Pair("TaintSceneDetectModel", CollectionsKt.mutableListOf(new String[]{"lens_taint_scene_detect"}))}), new e(r2));
        return;
    L8:
        r8.e.O0(r8.b, r8.d);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
