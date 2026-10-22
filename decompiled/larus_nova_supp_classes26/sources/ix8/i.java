package ix8;

import com.larus.camera.api.vlm.VLMIntentScene;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    static {
    }

    public static h a(d r2) {
        if ((r2 instanceof d.b) == false) goto L5;
        d.b r3 = (d.b) r2;
    L6:
        if (r3 == null) goto L8;
        List r0 = CollectionsKt.createListBuilder();
        r0.add(VLMIntentScene.COMMON);
        r0.add(VLMIntentScene.QUESTION_SOLVING);
        f r4 = r3.h;
        if (r4 == null) goto L12;
        boolean r5 = Intrinsics.areEqual(r4.a(), Boolean.TRUE);
    L13:
        if (r5 == false) goto L16;
        r0.add(VLMIntentScene.HOMEWORK_CORRECTION);
    L16:
        return new h(CollectionsKt.build(r0));
    L12:
        r5 = false;
        goto L13
    L8:
        return new h(CollectionsKt.listOf(VLMIntentScene.COMMON));
    L5:
        r3 = null;
        goto L6
    }
}
