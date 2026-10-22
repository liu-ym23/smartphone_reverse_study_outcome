package je0;

import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final boolean a(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "linkMicMessage");
        Intrinsics.checkNotNullParameter(r3, "$this$validSceneExt");
        if (r3.getValidScene() != 4) goto L5;
        return true;
    L5:
        Intrinsics.checkNotNullParameter(r3, "$this$layoutExt");
        if (r3.getLayout() != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean b(z0 r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r3, "linkMicMessage");
        Intrinsics.checkNotNullParameter(r3, "$this$validSceneExt");
        int r0 = r3.getValidScene();
        if (r0 != 8) goto L5;
    L18:
        return true;
    L5:
        if (r0 == 12) goto L18;
        if (r0 != 16) goto L13;
        if (r4 == null) goto L13;
        if (r4.isLiveTypeAudio() == true) goto L13;
        return true;
    L13:
        Intrinsics.checkNotNullParameter(r3, "$this$layoutExt");
        if (r3.getLayout() != 16) goto L16;
        return true;
    L16:
        return false;
    }

    public static final boolean c(z0 r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r3, "linkMicMessage");
        Intrinsics.checkNotNullParameter(r3, "$this$validSceneExt");
        int r0 = r3.getValidScene();
        if (r0 != 5) goto L5;
    L20:
        return true;
    L5:
        if (r0 == 9) goto L20;
        if (r0 == 10) goto L20;
        if (r0 != 16) goto L15;
        if (r4 == null) goto L15;
        if (r4.isLiveTypeAudio() != true) goto L15;
        return true;
    L15:
        Intrinsics.checkNotNullParameter(r3, "$this$layoutExt");
        if (r3.getLayout() != 8) goto L18;
        return true;
    L18:
        return false;
    }
}
