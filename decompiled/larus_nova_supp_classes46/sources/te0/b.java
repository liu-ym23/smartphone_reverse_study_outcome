package te0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import yz0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements IPreviewMultiLinkEffectService, o {
    public ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider a;
    public final j b;

    public static final class a {
    }

    static {
    }

    public final IRoomBase a() {
        j r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoom();
    }

    public final void onStart() {
        StringBuilder r0 = new StringBuilder("onStart, roomId: ");
        IRoomBase r1 = a();
        if (r1 == null) goto L5;
        String r2 = r1.getIdStr();
    L6:
        r0.append(r2);
        ALogger.i("PreviewMultiLinkEffectService", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onStop() {
        ALogger.i("PreviewMultiLinkEffectService", "onStop");
        this.a = null;
    }

    public final void removeEffectView() {
        ALogger.i("PreviewMultiLinkEffectService", "removeEffectView, provider: " + this.a);
        ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeEffectView();
        return;
    }

    public b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.b = r2;
    }

    public final void setFeedViewProvider(ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r4) {
        StringBuilder r0 = new StringBuilder("setFeedViewProvider, roomId: ");
        IRoomBase r1 = a();
        Boolean r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getIdStr();
    L6:
        r0.append(r3);
        r0.append(", ");
        IRoomBase r5 = a();
        if (r5 == null) goto L9;
        r2 = Boolean.valueOf(r5.isLiveTypeAudio());
    L9:
        r0.append(r2.booleanValue());
        r0.append(", provider: ");
        r0.append(r4);
        ALogger.i("PreviewMultiLinkEffectService", r0.toString());
        IRoomBase r6 = a();
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.isLiveTypeAudio() != true) goto L16;
        this.a = r4;
        return;
    L16:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void insertEffectView(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        StringBuilder r0 = new StringBuilder("insertEffectView, roomId: ");
        IRoomBase r1 = a();
        if (r1 == null) goto L5;
        String r2 = r1.getIdStr();
    L6:
        r0.append(r2);
        r0.append(", provider: ");
        r0.append(this.a);
        ALogger.i("PreviewMultiLinkEffectService", r0.toString());
        ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r5 = this.a;
        if (r5 == null) goto L10;
        r5.insertEffectView(r3, r4);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
