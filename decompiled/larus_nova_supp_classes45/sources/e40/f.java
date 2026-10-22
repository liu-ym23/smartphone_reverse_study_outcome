package e40;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.cloudgrouplive.core.CloudGroupLiveManager;
import com.bytedance.android.live.cloudgrouplive.rtc.CloudGroupLiveRTCManager;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public ViewGroup a;
    public ViewGroup b;
    public e40.a c;
    public final Context d;
    public final DataCenter e;
    public final ViewGroup f;
    public final CloudGroupLiveRTCManager g;
    public final CloudGroupLiveManager h;

    public static final class a {
    }

    static {
    }

    public final void a() {
        ALogger.i("CloudGroupLiveWindowManager", "receive dismissView");
        int r0 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "dismissView", 0, null, 28);
        e40.a r1 = this.c;
        if (r1 == null) goto L13;
        ALogger.i("CloudGroupLivePreviewView", "destroy");
        ViewGroup r2 = r1.a;
        if (r2 == null) goto L7;
        r2.removeAllViews();
    L7:
        ImageView r3 = r1.b;
        if (r3 == null) goto L10;
        r3.setImageResource(2131248994);
    L10:
        TextView r4 = r1.c;
        if (r4 == null) goto L13;
        r4.setText(2131915860);
    L13:
        c(8);
        ViewGroup r5 = this.a;
        if (r5 == null) goto L16;
        r5.removeAllViews();
    L16:
        b(12);
    }

    public final void b(int r5) {
        DataCenter r0 = this.e;
        if (r0 == null) goto L5;
        r0.put("data_common_talk_room_match_screen", Integer.valueOf(r5));
    L5:
        int r1 = f40.a.a;
        f40.a.d(CloudGroupLiveTraceEvent.WINDOW_MANAGER, "refreshMatchScreenWidth", 0, "new match screen width = " + r5, 20);
    }

    public final void c(int r7) {
        StringBuilder r0 = new StringBuilder("updateCloudGroupLiveContainerVisible oldVisible=");
        ViewGroup r1 = this.f;
        ViewParent r2 = null;
        if (r1 == null) goto L5;
        ViewParent r3 = r1.getParent();
    L7:
        if ((r3 instanceof ViewGroup) == true) goto L9;
        r3 = null;
    L9:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L12;
        Integer r5 = Integer.valueOf(r4.getVisibility());
    L13:
        r0.append(r5);
        r0.append(", newVisible=");
        r0.append(r7);
        ALogger.i("CloudGroupLiveWindowManager", r0.toString());
        int r6 = f40.a.a;
        CloudGroupLiveTraceEvent r8 = CloudGroupLiveTraceEvent.WINDOW_MANAGER;
        StringBuilder r9 = new StringBuilder("oldVisible=");
        ViewGroup r11 = this.f;
        if (r11 == null) goto L16;
        ViewParent r12 = r11.getParent();
    L18:
        if ((r12 instanceof ViewGroup) == true) goto L20;
        r12 = null;
    L20:
        ViewGroup r13 = (ViewGroup) r12;
        if (r13 == null) goto L23;
        Integer r14 = Integer.valueOf(r13.getVisibility());
    L24:
        r9.append(r14);
        r9.append(", newVisible = ");
        r9.append(r7);
        f40.a.d(r8, "updateCloudGroupLiveContainerVisible", 0, r9.toString(), 20);
        ViewGroup r15 = this.f;
        if (r15 == null) goto L27;
        ViewParent r16 = r15.getParent();
    L29:
        if ((r16 instanceof ViewGroup) == true) goto L31;
        r16 = null;
    L31:
        ViewGroup r17 = (ViewGroup) r16;
        if (r17 != null) goto L34;
    L35:
        ViewGroup r18 = this.f;
        if (r18 == null) goto L38;
        ViewParent r19 = r18.getParent();
    L40:
        if ((r19 instanceof ViewGroup) == false) goto L43;
        r2 = r19;
    L43:
        ViewGroup r21 = (ViewGroup) r2;
        if (r21 == null) goto L48;
        r21.setVisibility(r7);
        return;
    L48:
        return;
    L38:
        r19 = null;
        goto L40
    L34:
        if (r17.getVisibility() != r7) goto L35;
        return;
    L27:
        r16 = null;
        goto L29
    L23:
        r14 = null;
        goto L24
    L16:
        r12 = null;
        goto L18
    L12:
        r5 = null;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    public f(Context r2, DataCenter r3, ViewGroup r4, CloudGroupLiveRTCManager r5, CloudGroupLiveManager r6) {
        Intrinsics.checkNotNullParameter(r6, "cloudGroupLiveService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
    }
}
