package t22;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdkapi.depend.model.live.TopicCommentTip;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements com.bytedance.android.livesdk.interactivity.c {
    public int a;
    public com.bytedance.android.livesdk.interactivity.e b;
    public Disposable c;
    public boolean d;
    public HintType e;
    public final String f;
    public final TopicCommentTip g;

    @Override // com.bytedance.android.livesdk.interactivity.c
    public final x22.a a() {
        if (this.d == true) goto L7;
        return null;
    L7:
        return new x22.a(this.g.getContent(), this.e);
    }

    public g(TopicCommentTip r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.g = r2;
        this.e = HintType.NORMAL;
        this.f = "TopicTipManager";
    }

    @Override // com.bytedance.android.livesdk.interactivity.c
    public final void b(com.bytedance.android.livesdk.interactivity.e r1) {
        this.b = r1;
    }

    public final void c(boolean r4) {
        ALogger.i(this.f, "底纹词可见性：" + r4);
        this.d = r4;
        com.bytedance.android.livesdk.interactivity.e r5 = this.b;
        if (r5 == null) goto L6;
        r5.update();
        return;
    }
}
