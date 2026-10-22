package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.event.ToolbarEvent;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductJumpSetting;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.g90;
import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdk.config.yc1;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.disposables.Disposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/toolbar/SnowToolbarContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SnowToolbarContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int d = 0;
    public com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.a a;
    public Disposable b;
    public final d c;

    public static final class a {
    }

    static {
    }

    public static void h() {
        qo0.a.c("SnowToolbarContextService", "do spread flowers anim");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L8;
        n<ToolbarEvent> r1 = r0.getToolbarEvent();
        if (r1 == null) goto L9;
        ToolbarEvent.EventType r2 = ToolbarEvent.EventType.ShowToolbarAnimation;
        ko0.e.e.getClass();
        r1.setValue(new ToolbarEvent(r2, new ko0.e(1, ((yc1) o90.a.getValue()).h(), SnowToolbarContextService$doSpreadFlowersAnim$1.INSTANCE)));
        return;
    L9:
        return;
    }

    public static boolean k() {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        List<ShelfCardInfo> r1 = null;
        if (r0 == null) goto L7;
        n<ShelfInfo> r2 = r0.m618getShelfInfo();
        if (r2 == null) goto L7;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
    L8:
        if (r3 == null) goto L11;
        r1 = r3.cardInfoList;
    L11:
        if (r1 == null) goto L13;
        int r4 = r1.size();
    L15:
        if (r4 <= 1) goto L17;
    L41:
        return true;
    L17:
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == true) goto L41;
        Integer r5 = (Integer) g90.a.getValue();
        if (r5 != null) goto L23;
    L40:
        return false;
    L23:
        if (r5.intValue() != 1) goto L40;
        if (r1 == null) goto L26;
        int r6 = r1.size();
    L27:
        if (r6 != 1) goto L40;
        if (r1 == null) goto L40;
        ShelfCardInfo r7 = (ShelfCardInfo) ListProtector.get(r1, 0);
        if (r7 == null) goto L40;
        ProductInfo r8 = r7.getProductInfo();
        if (r8 == null) goto L40;
        ProductJumpSetting r9 = r8.jumpSetting;
        if (r9 == null) goto L40;
        if (r9.isJumpToOtherPage != true) goto L40;
        if (g.c(r3) == true) goto L40;
        return true;
    L26:
        r6 = 0;
        goto L27
    L13:
        r4 = 0;
    L7:
        r3 = null;
        goto L8
    }

    public final void l() {
        if (k() == true) goto L5;
        ((AudienceMiniAppAppLogContextService) getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLiveLinkShow(MountedMiniAppSource.ToolbarDirectMicroApp);
        return;
    L5:
        ((AudienceMiniAppAppLogContextService) getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLiveLinkShow("live_shelf_card");
    }

    public SnowToolbarContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.c = new d(r2);
    }

    public static boolean f(boolean r3) {
        ko0.e.e.getClass();
        if (((yc1) o90.a.getValue()).f() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (r3 == false) goto L10;
    L20:
        return true;
    L10:
        if (ko0.e.a.b() == false) goto L20;
        if (ko0.e.a.a() == 1) goto L15;
        return false;
    L15:
        if (((IOpenPlatformFlavorService) ServiceManager.get().getService(IOpenPlatformFlavorService.class)).a() == 0) goto L21;
        return false;
    L21:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void i(boolean r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "onComplete");
        if (y3.m(getOpenPlatformContext().getDataCenter()).n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == true) goto L5;
        r6.invoke();
        return;
    L5:
        ko0.e.a r0 = ko0.e.e;
        r0.getClass();
        int r1 = ko0.e.a.a();
        r0.getClass();
        boolean r2 = false;
        if (ko0.e.a.b() == false) goto L16;
        AudienceMiniAppDataContext.Companion.getClass();
        ko0.d r3 = AudienceMiniAppDataContext.a.b();
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L16;
        if (r5 == true) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L20;
        if (r1 != 1) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L24;
        h();
    L24:
        if (f(r5) == false) goto L41;
        qo0.a.c("SnowToolbarContextService", "do small card hide anim");
        String r9 = ((yc1) o90.a.getValue()).a();
        if (ko0.e.a.b() == false) goto L35;
        if (r9 != null) goto L29;
    L32:
        boolean r10 = true;
    L33:
        if (r10 == true) goto L35;
        r2 = true;
        goto L35
    L29:
        if (r9.length() == 0) goto L32;
        r10 = false;
    L35:
        if (r2 == true) goto L38;
        r9 = null;
    L38:
        if (r9 != null) goto L40;
        r9 = "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_card_small_card_anim_hide.webp";
    L40:
        Pair r11 = TuplesKt.to(3, r9);
        g(((Number) r11.getFirst()).intValue(), (String) r11.getSecond(), r6);
        return;
    L41:
        r6.invoke();
        return;
    L20:
        r8 = false;
        goto L21
    L10:
        if (r3.a != true) goto L12;
        r4 = true;
    L16:
        r7 = false;
        goto L17
    }

    public static void g(int r5, final String r6, final Function0 r7) {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L8;
        n<ToolbarEvent> r1 = r0.getToolbarEvent();
        if (r1 == null) goto L9;
        r1.setValue(new ToolbarEvent(ToolbarEvent.EventType.ShowToolbarAnimation, new ko0.e(r5, r6, new SnowToolbarContextService$doSmallCardAnim$1(r6, r7))));
        return;
    L9:
        return;
    }

    public final void j(boolean r7, boolean r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "onComplete");
        if (y3.m(getOpenPlatformContext().getDataCenter()).n(ToolbarButton.OPEN_PLATFORM_MINI_APP) == true) goto L5;
        r9.invoke();
        return;
    L5:
        AudienceMiniAppDataContext.a r0 = AudienceMiniAppDataContext.Companion;
        r0.getClass();
        ko0.d r1 = AudienceMiniAppDataContext.a.b();
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
        qo0.a.c("SnowToolbarContextService", "spread flowers anim is running, skip linked anim");
        r9.invoke();
        return;
    L15:
        ko0.e.a r4 = ko0.e.e;
        r4.getClass();
        if (ko0.e.a.b() == false) goto L26;
        r0.getClass();
        ko0.d r5 = AudienceMiniAppDataContext.a.b();
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == true) goto L26;
        if (r8 == true) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L36;
        r4.getClass();
        if (ko0.e.a.a() != 1) goto L36;
        float r11 = z0.b(false);
        if (r7 == true) goto L34;
    L35:
        boolean r12 = true;
    L37:
        if (r12 == false) goto L39;
        h();
    L39:
        float r13 = z0.b(false);
        if (r7 == true) goto L42;
    L44:
        boolean r14 = f(r8);
    L45:
        if (r14 == false) goto L90;
        qo0.a.c("SnowToolbarContextService", "do small card show anim");
        r4.getClass();
        o90 r15 = o90.a;
        String r16 = ((yc1) r15.getValue()).c();
        de0 r17 = de0.a;
        if (((wc1) r17.getValue()).i() == 0) goto L60;
        if (r16 != null) goto L50;
    L53:
        boolean r18 = true;
    L54:
        if (r18 == true) goto L60;
        if (((wc1) r17.getValue()).j() == true) goto L61;
        r7 = true;
    L61:
        Pair r19 = null;
        if (r7 == true) goto L66;
        r16 = null;
    L66:
        if (r16 == null) goto L71;
        Pair r20 = TuplesKt.to(4, r16);
        if (r20 == null) goto L71;
        r19 = r20;
    L87:
        if (r19 != null) goto L89;
        r19 = TuplesKt.to(2, "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_card_small_card_anim_show.webp");
    L89:
        g(((Number) r19.getFirst()).intValue(), (String) r19.getSecond(), r9);
        return;
    L71:
        String r21 = ((yc1) r15.getValue()).b();
        if (ko0.e.a.b() == false) goto L81;
        if (r21 != null) goto L75;
    L78:
        boolean r22 = true;
    L79:
        if (r22 == true) goto L81;
    L82:
        if (r2 == true) goto L85;
        r21 = null;
    L85:
        if (r21 == null) goto L87;
        r19 = TuplesKt.to(2, r21);
        goto L87
    L75:
        if (r21.length() == 0) goto L78;
        r22 = false;
    L81:
        r2 = false;
        goto L82
    L50:
        if (r16.length() == 0) goto L53;
        r18 = false;
    L60:
        r7 = false;
        goto L61
    L90:
        r9.invoke();
        return;
    L42:
        if (r13 > ((wc1) de0.a.getValue()).p()) goto L44;
        r14 = false;
        goto L45
    L34:
        if (r11 > ((wc1) de0.a.getValue()).r()) goto L35;
    L36:
        r12 = false;
        goto L37
    L20:
        if (r5.a != true) goto L22;
        r6 = true;
    L26:
        r10 = false;
        goto L27
    L8:
        if (r1.a != true) goto L10;
        r3 = true;
        goto L12
    }
}
