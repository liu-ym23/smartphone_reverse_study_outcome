package p42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int c = 0;
    public final AbsPSHighlightComp a;
    public final IPSHighlightCompLifecycle$State b;

    /* JADX INFO: renamed from: p42.a$a, reason: collision with other inner class name */
    public static final class C0260a {
        @JvmStatic
        public static a a(AbsPSHighlightComp r2) {
            Intrinsics.checkNotNullParameter(r2, "comp");
            return new a(r2, (IPSHighlightCompLifecycle$State) r2.b.a);
        }
    }

    static {
    }

    public a(AbsPSHighlightComp r1, IPSHighlightCompLifecycle$State r2) {
        this.a = r1;
        this.b = r2;
    }
}
