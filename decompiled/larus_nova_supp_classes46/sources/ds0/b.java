package ds0;

import android.app.Dialog;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public LivePanelType a;
    public String b;
    public int c;
    public WeakReference<Dialog> d;
    public int e;
    public long f;
    public long g;
    public boolean h;
    public String i;

    public static final class a {
        public static LivePanelType a(String r2) {
            LivePanelType r0 = LivePanelType.AUDIENCE_LIST;
            if (Intrinsics.areEqual(r2, r0.getIdentifier()) == true) goto L25;
            LivePanelType r1 = LivePanelType.HOUR_RANK_LIST;
            if (Intrinsics.areEqual(r2, r1.getIdentifier()) == true) goto L26;
            LivePanelType r3 = LivePanelType.SHOPPING_RANK_LIST;
            if (Intrinsics.areEqual(r2, r3.getIdentifier()) == true) goto L27;
            LivePanelType r4 = LivePanelType.SHOPPING_CAT;
            if (Intrinsics.areEqual(r2, r4.getIdentifier()) == true) goto L28;
            LivePanelType r5 = LivePanelType.RECOGNITION_CONTAINER;
            if (Intrinsics.areEqual(r2, r5.getIdentifier()) == true) goto L29;
            LivePanelType r6 = LivePanelType.LOTTERY;
            if (Intrinsics.areEqual(r2, r6.getIdentifier()) == true) goto L30;
            LivePanelType r7 = LivePanelType.PREDICTOR;
            if (Intrinsics.areEqual(r2, r7.getIdentifier()) == false) goto L24;
            return r7;
        L24:
            return LivePanelType.UN_KNOW;
        L30:
            return r6;
        L29:
            return r5;
        L28:
            return r4;
        L27:
            return r3;
        L26:
            return r1;
        L25:
            return r0;
        }
    }

    static {
    }

    public b() {
        this.a = LivePanelType.UN_KNOW;
        this.b = "undefine";
        this.d = new WeakReference(null);
        this.e = -1;
        this.f = 248;
        this.i = "";
    }

    public final LivePanelType getType() {
        return this.a;
    }

    public final void a(LivePanelType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
