package zf0;

import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.TalkRoomSearchResultViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.c0;
import com.bytedance.android.live.liveinteract.plantform.model.d0;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements q {
    public final /* synthetic */ TalkRoomSearchResultViewBinder.ResultViewHolder a;
    public final /* synthetic */ c0 b;
    public final /* synthetic */ Ref.ObjectRef c;

    public final void a(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
    }

    public final void b(SpannableString r2, q.a r3) {
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r3, "info");
        Spannable r4 = d0.a(this.b, r2, (String) this.c.element);
        if (r4.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        UtilityKotlinExtentionsKt.w(this.a.d);
        this.a.d.setText(r4);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public n(TalkRoomSearchResultViewBinder.ResultViewHolder r1, c0 r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
