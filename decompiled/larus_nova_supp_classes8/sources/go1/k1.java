package go1;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfoKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k1 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.e N() {
        return this;
    }

    public final e70.f O() {
        return this;
    }

    public final Class<? extends Widget> m() {
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public k1() {
    }

    public final Widget l(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r4);
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r5 = ho1.a.c(r4);
        if (r5 == null) goto L11;
        com.bytedance.android.live.pushstream.d r1 = r0.getLiveStream();
        j1 r2 = new j1(r5);
        IKtvService r6 = jc1.k.f(IKtvService.class);
        if (r6 == null) goto L11;
        return r6.getKtvControlWidget(r2, r1);
    L11:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.c0;
    }

    public final boolean r(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (KtvSettingHelper.e().a() == false) goto L11;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.livesdk.chatroom.utils.o3.f().getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        if (r1.isMergeVSRoom() != true) goto L11;
    L34:
        return false;
    L11:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.livesdk.chatroom.utils.o3.f().getRoom();
        LiveMode r3 = null;
        if (r2 == null) goto L14;
        IRoom r4 = (IRoom) r2.getValue();
    L16:
        if (com.bytedance.android.livesdk.config.setting.d.a(r4, "KtvControl") == true) goto L18;
    L20:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = ho1.a.d(r6);
        if (r7 == null) goto L24;
        r3 = r7.getLiveMode();
    L24:
        if (r3 == LiveMode.MEDIA) goto L34;
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.livesdk.chatroom.utils.o3.f().getRoom();
        if (r8 == null) goto L36;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L37;
        IRoomSpecificSceneTypeInfo r10 = r9.getSceneTypeInfo();
        if (r10 != null) goto L33;
        return true;
    L33:
        if (IRoomSpecificSceneTypeInfoKt.isLandscapeVertical(r10) == true) goto L34;
        return true;
    L37:
        return true;
    L36:
        return true;
    L18:
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.chatroom.utils.o3.f().isAnchor(), Boolean.FALSE) == false) goto L20;
    L14:
        r4 = null;
        goto L16
    }
}
