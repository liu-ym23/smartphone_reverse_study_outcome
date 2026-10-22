package a72;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final int o() {
        return 2131250255;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        super.t(r2, r3);
        r3.F0();
    }

    public b(InputFunctionEnum r2, Context r3, InputSectionType r4) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "sectionType");
        super(r2, r3, r4);
    }
}
