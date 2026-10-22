package com.bytedance.android.live.openplatform.impl.miniappaudience.launch;

import android.content.Context;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductJumpSetting;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.api.utils.OpenPlatformHostInfoPresenter;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.live.openplatform.impl.miniappaudience.cast.AudienceCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.debug.MiniAppAudienceDebugContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.g90;
import com.bytedance.android.livesdk.config.t;
import com.bytedance.android.livesdk.config.u;
import com.bytedance.android.livesdk.config.xd0;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0014\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J:\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0015H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0019H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0019H\u0002J,\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u001a\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0015J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\"\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/launch/AudienceLaunchContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/LaunchContextService;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "cardInfo", "Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$a;", "schemaInfoBuilder", "", "appendProductInfo", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "", "getMountedMiniAppSchema", "clickPosition", "getShelfPageCardSchema", "getExplainCardSchema", "getShelfPageCardActionButtonSchema", "getOtherPageSchema", "Lkotlin/Function0;", "onLoginSuccess", "openMiniAppWithLogin", "schema", "", "bdpLogExtra", "Lko0/b;", "getMiniAppLaunchParams", "", "getBdpLogExtra", "getQueryExtra", "", "fromShelf", "isDirectPay", "getCustomFieldExtra", "getExplainCardInfo", "isShelf", "openMiniApp", "location", "getLaunchSchema", "launchParams", "onSuccess", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLaunchContextService extends LaunchContextService {
    public static final a Companion = null;
    public static final String TAG = "AudienceLaunchContextService";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            qo0.a.c(AudienceLaunchContextService.TAG, "login success");
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            qo0.a.b(AudienceLaunchContextService.TAG, "login fail", (Throwable) r3);
        }
    }

    static {
        Companion = new a();
    }

    private final Map<String, String> getBdpLogExtra() {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = n.a;
        n.d(getOpenPlatformContext().getRoom(), r0);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        String r3 = "";
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L12;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L12;
        ShelfMicroAppInfo r6 = r5.appInfo;
        if (r6 == null) goto L12;
        String r7 = r6.appId;
        if (r7 == null) goto L12;
    L13:
        r0.put("program_id", r7);
        AudienceMiniAppDataContext r8 = AudienceMiniAppDataContext.a.a();
        if (r8 == null) goto L23;
        com.bytedance.live.datacontext.n<ShelfInfo> r9 = r8.m618getShelfInfo();
        if (r9 == null) goto L23;
        ShelfInfo r10 = (ShelfInfo) r9.getValue();
        if (r10 == null) goto L23;
        ShelfMicroAppInfo r11 = r10.appInfo;
        if (r11 == null) goto L23;
        String r12 = r11.name;
        if (r12 == null) goto L23;
    L24:
        r0.put("program_name", r12);
        if (((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn() == false) goto L27;
        String r13 = "guest";
    L28:
        r0.put("projection_user_type", r13);
        String r14 = am2.n.f().a();
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        r0.put("ad_id", r14);
        String r15 = am2.n.f().c();
        if (r15 != null) goto L34;
        r15 = "";
    L34:
        r0.put("cid", r15);
        String r16 = am2.n.f().d();
        if (r16 == null) goto L38;
        r3 = r16;
    L38:
        r0.put("log_extra", r3);
        AudienceMiniAppDataContext r17 = AudienceMiniAppDataContext.a.a();
        if (r17 == null) goto L47;
        com.bytedance.live.datacontext.n<lo0.a> r18 = r17.getPrivateMsgEntranceInfo();
        if (r18 == null) goto L47;
        lo0.a r19 = (lo0.a) r18.getValue();
        if (r19 == null) goto L47;
        Map<String, String> r20 = r19.b();
        if (r20 == null) goto L47;
        r0.putAll(r20);
    L47:
        return r0;
    L27:
        r13 = "audience";
    L23:
        r12 = "";
    L12:
        r7 = "";
        goto L13
    }

    private final ShelfCardInfo getExplainCardInfo() {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        ShelfCardInfo r1 = null;
        if (r0 == null) goto L26;
        com.bytedance.live.datacontext.n<ShelfInfo> r2 = r0.m618getShelfInfo();
        if (r2 == null) goto L27;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L28;
        List<ShelfCardInfo> r4 = r3.cardInfoList;
        if (r4 == null) goto L29;
        ListIterator<ShelfCardInfo> r5 = r4.listIterator(r4.size());
    L12:
        if (r5.hasPrevious() == false) goto L20;
        ShelfCardInfo r6 = r5.previous();
        if (r6.getStatus() != 1) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L12;
        r1 = r6;
        goto L20
    L16:
        r7 = false;
    L20:
        return r1;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    L26:
        return null;
    }

    private final Map<String, String> getQueryExtra() {
        LinkedHashMap r0 = new LinkedHashMap();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L10;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L10;
        Map<String, String> r4 = r3.startPageQuery;
        if (r4 == null) goto L10;
    L11:
        r0.putAll(r4);
        return r0;
    L10:
        r4 = MapsKt.emptyMap();
        goto L11
    }

    private final String getExplainCardSchema() {
        ShelfCardInfo r0 = getExplainCardInfo();
        Integer r1 = (Integer) g90.a.getValue();
        if (r1 != null) goto L6;
    L7:
        if (r1 != null) goto L10;
    L30:
        if (r0 == null) goto L33;
        String r2 = r0.a0();
        if (r2 == null) goto L33;
        return r2;
    L33:
        return "";
    L10:
        if (r1.intValue() != 2) goto L30;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r3 = AudienceMiniAppDataContext.a.a();
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.n<ShelfInfo> r4 = r3.m618getShelfInfo();
        if (r4 == null) goto L20;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
        if (r5 == null) goto L20;
        List<ShelfCardInfo> r6 = r5.cardInfoList;
        if (r6 == null) goto L20;
        int r7 = r6.size();
    L21:
        if (r7 <= 1) goto L30;
    L22:
        if (r0 == null) goto L30;
        ProductInfo r8 = r0.getProductInfo();
        if (r8 == null) goto L30;
        ProductJumpSetting r9 = r8.jumpSetting;
        if (r9 == null) goto L30;
        if (r9.isJumpToOtherPage != true) goto L30;
        return getOtherPageSchema(r0);
    L20:
        r7 = 0;
        goto L21
    L6:
        if (r1.intValue() == 1) goto L22;
        goto L7
    }

    public AudienceLaunchContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    private final String getOtherPageSchema(ShelfCardInfo r8) {
        if (r8 == null) goto L95;
        ProductInfo r1 = r8.getProductInfo();
        if (r1 == null) goto L95;
        ProductJumpSetting r2 = r1.jumpSetting;
        String r3 = null;
        if (r2 == null) goto L10;
        String r4 = r2.jumpToOtherPageAppId;
    L11:
        boolean r5 = false;
        if (r4 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L28;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r7 = AudienceMiniAppDataContext.a.a();
        if (r7 == null) goto L31;
        com.bytedance.live.datacontext.n<ShelfInfo> r9 = r7.m618getShelfInfo();
        if (r9 == null) goto L31;
        ShelfInfo r10 = (ShelfInfo) r9.getValue();
        if (r10 == null) goto L31;
        ShelfMicroAppInfo r11 = r10.appInfo;
        if (r11 == null) goto L31;
        String r12 = r11.appId;
    L32:
        if (r12 != null) goto L38;
        String r13 = r8.a0();
        if (r13 != null) goto L37;
        return "";
    L37:
        return r13;
    L38:
        SchemaInfo.a r14 = new SchemaInfo.a();
        r14.a(r12);
        ProductJumpSetting r15 = r1.jumpSetting;
        if (r15 == null) goto L42;
        String r16 = r15.jumpToOtherPagePath;
        if (r16 == null) goto L42;
    L43:
        if (r15 == null) goto L46;
        Map<String, String> r17 = r15.jumpToOtherPageQuery;
        if (r17 == null) goto L46;
    L47:
        r14.h(r16, r17);
        r14.b("if_shelf_direct", "1");
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r18 = AudienceMiniAppDataContext.a.a();
        if (r18 == null) goto L56;
        com.bytedance.live.datacontext.n<ShelfInfo> r19 = r18.m618getShelfInfo();
        if (r19 == null) goto L56;
        ShelfInfo r20 = (ShelfInfo) r19.getValue();
        if (r20 == null) goto L56;
        List<ShelfCardInfo> r21 = r20.cardInfoList;
        if (r21 == null) goto L56;
        int r22 = r21.size();
    L57:
        r14.b("shelf_card_num", String.valueOf(r22));
        String r23 = "view";
        r14.b("click_position", "view");
        ProductInfo r24 = r8.getProductInfo();
        if (r24 == null) goto L60;
        String r25 = r24.productId;
    L61:
        if (r25 != null) goto L63;
    L64:
        r5 = true;
    L65:
        if (r5 == true) goto L67;
        r23 = "go_purchase";
    L67:
        r14.b("click_icon_type", r23);
        ProductInfo r26 = r8.getProductInfo();
        if (r26 == null) goto L84;
        ProductJumpSetting r27 = r26.jumpSetting;
        if (r27 == null) goto L84;
        if (r27.isJumpToOtherPage != true) goto L84;
        g90 r28 = g90.a;
        Integer r29 = (Integer) r28.getValue();
        if (r29 != null) goto L77;
    L78:
        Integer r30 = (Integer) r28.getValue();
        if (r30 == null) goto L84;
        if (r30.intValue() != 2) goto L84;
    L83:
        String r31 = "confirm_payment_page";
    L85:
        r14.b("icon_link_type", r31);
        SchemaInfo r32 = r14.c();
        if (r32 == null) goto L88;
        r3 = r32.h();
    L88:
        if (r3 != null) goto L94;
        String r33 = r8.a0();
        if (r33 != null) goto L102;
        return "";
    L102:
        return r33;
    L94:
        return r3;
    L77:
        if (r29.intValue() == 1) goto L83;
    L84:
        r31 = "mp_page";
        goto L85
    L63:
        if (StringsKt.isBlank(r25) == false) goto L65;
    L60:
        r25 = null;
    L56:
        r22 = 0;
    L46:
        r17 = MapsKt.emptyMap();
    L42:
        r16 = "";
    L31:
        r12 = null;
        goto L32
    L28:
        ProductJumpSetting r34 = r1.jumpSetting;
        if (r34 == null) goto L31;
        r12 = r34.jumpToOtherPageAppId;
        goto L32
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r6 = false;
        goto L18
    L10:
        r4 = null;
    L95:
        if (r8 == null) goto L104;
        String r35 = r8.a0();
        if (r35 != null) goto L100;
        return "";
    L100:
        return r35;
    L104:
        return "";
    }

    private final String getShelfPageCardActionButtonSchema(ShelfCardInfo r4) {
        Integer r0 = (Integer) g90.a.getValue();
        if (r4 == null) goto L20;
        ProductInfo r1 = r4.getProductInfo();
        if (r1 == null) goto L20;
        ProductJumpSetting r2 = r1.jumpSetting;
        if (r2 == null) goto L20;
        if (r2.isJumpToOtherPage != true) goto L20;
        if (r0 != null) goto L13;
    L14:
        if (r0 == null) goto L20;
        if (r0.intValue() != 2) goto L20;
    L21:
        return getOtherPageSchema(r4);
    L13:
        if (r0.intValue() == 1) goto L21;
    L20:
        return getShelfPageCardSchema(r4, "view");
    }

    private final boolean isShelf(MountedMiniAppSource r3) {
        int r4 = com.bytedance.android.live.openplatform.impl.miniappaudience.launch.a.e[r3.ordinal()];
        if (r4 != 1) goto L5;
        return true;
    L5:
        if (r4 != 2) goto L7;
        return true;
    L7:
        if (r4 == 3) goto L12;
        return false;
    L12:
        return true;
    }

    private final void openMiniAppWithLogin(Function0<Unit> r5) {
        if (k.n(IUserService.class).user().isLogin() == true) goto L5;
        f r0 = k.n(IUserService.class).user();
        Context r1 = getOpenPlatformContext().getContext();
        l.a r2 = new l.a();
        r2.a = s1.B(2131915990);
        r2.d = "open_platform";
        r2.c = -1;
        autoDispose(r0.login(r1, new l(r2)).subscribe(new b(r5), c.a));
        return;
    L5:
        r5.invoke();
    }

    public final String getLaunchSchema(MountedMiniAppSource r11) {
        Intrinsics.checkNotNullParameter(r11, "source");
        return getLaunchSchema(getMountedMiniAppSchema$default(this, r11, null, 2, null), getMiniAppLaunchParams$default(this, getMountedMiniAppSchema$default(this, r11, null, 2, null), r11, null, null, 12, null));
    }

    public final void openMiniApp(String r11) {
        Intrinsics.checkNotNullParameter(r11, "location");
        MountedMiniAppSource r3 = MountedMiniAppSource.ToolbarDirectMicroApp;
        String r8 = getMountedMiniAppSchema$default(this, r3, null, 2, null);
        ko0.b r6 = getMiniAppLaunchParams$default(this, getMountedMiniAppSchema$default(this, r3, null, 2, null), r3, null, null, 12, null);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r6.c = r11;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r6.d = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r6.e = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r6.f = "";
        Unit r12 = Unit.INSTANCE;
        LaunchContextService.openMiniApp$default(this, r8, r6, null, 4, null);
    }

    public final String getLaunchSchema(ShelfCardInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "cardInfo");
        MountedMiniAppSource r3 = MountedMiniAppSource.ShelfPageCard;
        return getLaunchSchema(getMountedMiniAppSchema(r3, r9), getMiniAppLaunchParams$default(this, getMountedMiniAppSchema(r3, r9), r3, r9, null, 8, null));
    }

    private final void appendProductInfo(ShelfCardInfo r9, SchemaInfo.a r10) {
        com.bytedance.android.live.openplatform.api.utils.b r0 = com.bytedance.android.live.openplatform.api.utils.b.b;
        String r3 = "1";
        Object r5 = null;
        if (r0.c() == false) goto L17;
        ProductInfo r1 = r9.getProductInfo();
        if (r1 == null) goto L7;
        String r2 = r1.imgUrl;
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L17;
        String r6 = "1";
    L18:
        r10.b("has_product_pic", r6);
        if (r0.f() == false) goto L31;
        ProductInfo r7 = r9.getProductInfo();
        if (r7 == null) goto L23;
        String r8 = r7.title;
    L24:
        if (r8 != null) goto L26;
    L29:
        boolean r11 = true;
    L30:
        if (r11 == true) goto L31;
    L32:
        r10.b("has_product_title", r3);
        String r12 = "";
        if (r0.e() == false) goto L40;
        ProductInfo r13 = r9.getProductInfo();
        if (r13 == null) goto L40;
        ProductPriceInfo r14 = r13.price;
        if (r14 == null) goto L40;
        String r15 = r14.currentPrice;
        if (r15 == null) goto L40;
    L41:
        r10.b("price_tag", r15);
        if (r0.d() == false) goto L61;
        ProductInfo r16 = r9.getProductInfo();
        if (r16 == null) goto L61;
        List<ProductIntroductionInfo> r17 = r16.introductionList;
        if (r17 == null) goto L61;
        Iterator<T> r18 = r17.iterator();
    L49:
        if (r18.hasNext() == false) goto L56;
        Object r19 = r18.next();
        if (((ProductIntroductionInfo) r19).introductionType != 1) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == false) goto L49;
    L57:
        ProductIntroductionInfo r21 = (ProductIntroductionInfo) r19;
        if (r21 == null) goto L61;
        String r22 = r21.content;
        if (r22 == null) goto L61;
    L62:
        r10.b("category_rank", r22);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.g() == false) goto L82;
        ProductInfo r23 = r9.getProductInfo();
        if (r23 == null) goto L82;
        List<ProductLabelInfo> r24 = r23.labelList;
        if (r24 == null) goto L82;
        Iterator<T> r25 = r24.iterator();
    L70:
        if (r25.hasNext() == false) goto L77;
        Object r26 = r25.next();
        if (((ProductLabelInfo) r26).labelType != 3) goto L74;
        boolean r27 = true;
    L75:
        if (r27 == false) goto L70;
    L78:
        ProductLabelInfo r28 = (ProductLabelInfo) r26;
        if (r28 == null) goto L82;
        String r29 = r28.leftText;
        if (r29 == null) goto L82;
    L83:
        r10.b("expiration_date", r29);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.a() == false) goto L103;
        ProductInfo r30 = r9.getProductInfo();
        if (r30 == null) goto L103;
        List<ProductIntroductionInfo> r31 = r30.introductionList;
        if (r31 == null) goto L103;
        Iterator<T> r32 = r31.iterator();
    L91:
        if (r32.hasNext() == false) goto L98;
        Object r33 = r32.next();
        if (((ProductIntroductionInfo) r33).introductionType != 2) goto L95;
        boolean r34 = true;
    L96:
        if (r34 == false) goto L91;
    L99:
        ProductIntroductionInfo r35 = (ProductIntroductionInfo) r33;
        if (r35 == null) goto L103;
        String r36 = r35.content;
        if (r36 == null) goto L103;
    L104:
        r10.b("available_cnt", r36);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.b() == false) goto L123;
        ProductInfo r37 = r9.getProductInfo();
        if (r37 == null) goto L123;
        List<ProductLabelInfo> r38 = r37.labelList;
        if (r38 == null) goto L123;
        Iterator<T> r39 = r38.iterator();
    L112:
        if (r39.hasNext() == false) goto L119;
        Object r40 = r39.next();
        if (((ProductLabelInfo) r40).labelType != 2) goto L116;
        boolean r41 = true;
    L117:
        if (r41 == false) goto L112;
        r5 = r40;
        goto L119
    L116:
        r41 = false;
    L119:
        ProductLabelInfo r42 = (ProductLabelInfo) r5;
        if (r42 == null) goto L123;
        String r43 = r42.leftText;
        if (r43 == null) goto L123;
    L124:
        r10.b("has_complement", r43);
        if (com.bytedance.android.live.openplatform.api.utils.b.b.e() == false) goto L134;
        ProductInfo r44 = r9.getProductInfo();
        if (r44 == null) goto L134;
        ProductPriceInfo r45 = r44.price;
        if (r45 == null) goto L134;
        String r46 = r45.originalPrice;
        if (r46 == null) goto L134;
        r12 = r46;
    L134:
        r10.b("original_price", r12);
        return;
    L123:
        r43 = "";
        goto L124
    L95:
        r34 = false;
        goto L96
    L98:
        r33 = null;
    L103:
        r36 = "";
        goto L104
    L74:
        r27 = false;
        goto L75
    L77:
        r26 = null;
    L82:
        r29 = "";
        goto L83
    L53:
        r20 = false;
        goto L54
    L56:
        r19 = null;
    L61:
        r22 = "";
    L40:
        r15 = "";
        goto L41
    L26:
        if (StringsKt.isBlank(r8) == true) goto L29;
        r11 = false;
        goto L30
    L23:
        r8 = null;
    L31:
        r3 = "0";
        goto L32
    L10:
        if (StringsKt.isBlank(r2) == true) goto L13;
        r4 = false;
        goto L14
    L7:
        r2 = null;
    L17:
        r6 = "0";
        goto L18
    }

    private final String getMountedMiniAppSchema(MountedMiniAppSource r4, ShelfCardInfo r5) {
        switch(com.bytedance.android.live.openplatform.impl.miniappaudience.launch.a.a[r4.ordinal()]) {
            case 1: goto L27;
            case 2: goto L27;
            case 3: goto L27;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        String r0 = getShelfPageCardActionButtonSchema(r5);
    L38:
        SchemaInfo.a r2 = new SchemaInfo.a(r0);
        if (r4 != MountedMiniAppSource.ShelfPageLinkCast) goto L41;
        String r6 = "1";
    L42:
        r2.b("if_shelf_projection_position", r6);
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r7 = MiniAppDataContext.a.b();
        if (r7 == null) goto L45;
        String r8 = r7.b();
    L46:
        r2.b("coexist_module", r8);
        if (r5 == null) goto L49;
        appendProductInfo(r5, r2);
    L49:
        SchemaInfo r9 = r2.c();
        if (r9 == null) goto L56;
        String r10 = r9.h();
        if (r10 != null) goto L55;
        return "";
    L55:
        return r10;
    L56:
        return "";
    L45:
        r8 = "";
        goto L46
    L41:
        r6 = "0";
        goto L42
    L7:
        r0 = getShelfPageCardSchema(r5, "card");
        goto L38
    L8:
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r1 = AudienceMiniAppDataContext.a.a();
        if (r1 == null) goto L37;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r1.m618getShelfInfo();
        if (r3 == null) goto L37;
        ShelfInfo r11 = (ShelfInfo) r3.getValue();
        if (r11 == null) goto L37;
        List<ShelfCardInfo> r12 = r11.cardInfoList;
        if (r12 == null) goto L37;
        ShelfCardInfo r13 = (ShelfCardInfo) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L37;
        r0 = r13.a0();
        if (r0 != null) goto L38;
    L37:
        r0 = "";
        goto L38
    L21:
        r0 = getExplainCardSchema();
        goto L38
    L22:
        ShelfCardInfo r14 = getExplainCardInfo();
        if (r14 == null) goto L37;
        r0 = r14.a0();
        if (r0 != null) goto L38;
    L27:
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r15 = AudienceMiniAppDataContext.a.a();
        if (r15 == null) goto L37;
        com.bytedance.live.datacontext.n<ShelfInfo> r16 = r15.m618getShelfInfo();
        if (r16 == null) goto L37;
        ShelfInfo r17 = (ShelfInfo) r16.getValue();
        if (r17 == null) goto L37;
        ShelfMicroAppInfo r18 = r17.appInfo;
        if (r18 == null) goto L37;
        r0 = r18.schema;
        if (r0 != null) goto L38;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private final String getShelfPageCardSchema(ShelfCardInfo r5, String r6) {
        if (r5 != null) goto L4;
    L51:
        return "";
    L4:
        if (r5.a0() == null) goto L51;
        SchemaInfo.a r0 = new SchemaInfo.a(r5.a0());
        r0.b("click_position", r6);
        ProductInfo r7 = r5.getProductInfo();
        if (r7 == null) goto L9;
        String r8 = r7.productId;
    L10:
        int r2 = 0;
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L19;
        String r10 = "go_purchase";
    L20:
        r0.b("click_icon_type", r10);
        ProductInfo r11 = r5.getProductInfo();
        if (r11 == null) goto L37;
        ProductJumpSetting r12 = r11.jumpSetting;
        if (r12 == null) goto L37;
        if (r12.isJumpToOtherPage != true) goto L37;
        g90 r13 = g90.a;
        Integer r14 = (Integer) r13.getValue();
        if (r14 != null) goto L30;
    L31:
        Integer r15 = (Integer) r13.getValue();
        if (r15 == null) goto L37;
        if (r15.intValue() != 2) goto L37;
    L36:
        String r16 = "confirm_payment_page";
    L38:
        r0.b("icon_link_type", r16);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r17 = AudienceMiniAppDataContext.a.a();
        if (r17 == null) goto L47;
        com.bytedance.live.datacontext.n<ShelfInfo> r18 = r17.m618getShelfInfo();
        if (r18 == null) goto L47;
        ShelfInfo r19 = (ShelfInfo) r18.getValue();
        if (r19 == null) goto L47;
        List<ShelfCardInfo> r20 = r19.cardInfoList;
        if (r20 == null) goto L47;
        r2 = r20.size();
    L47:
        r0.b("shelf_card_num", String.valueOf(r2));
        SchemaInfo r21 = r0.c();
        if (r21 == null) goto L51;
        String r22 = r21.h();
        if (r22 == null) goto L51;
        return r22;
    L30:
        if (r14.intValue() == 1) goto L36;
    L37:
        r16 = "mp_page";
        goto L38
    L19:
        r10 = "view";
        goto L20
    L13:
        if (StringsKt.isBlank(r8) == true) goto L16;
        r9 = false;
        goto L17
    L9:
        r8 = null;
        goto L10
    }

    private final boolean isDirectPay(ShelfCardInfo r5, MountedMiniAppSource r6) {
        Integer r0 = (Integer) g90.a.getValue();
        int r7 = com.bytedance.android.live.openplatform.impl.miniappaudience.launch.a.d[r6.ordinal()];
        if (r7 == 1) goto L22;
        if (r7 != 2) goto L62;
        if (r5 == null) goto L51;
        ProductInfo r8 = r5.getProductInfo();
        if (r8 == null) goto L52;
        ProductJumpSetting r9 = r8.jumpSetting;
        if (r9 != null) goto L12;
        return false;
    L12:
        if (r9.isJumpToOtherPage != true) goto L54;
        if (r0 != null) goto L16;
    L17:
        if (r0 != null) goto L20;
        return false;
    L20:
        if (r0.intValue() != 2) goto L55;
    L49:
        return true;
    L55:
        return false;
    L16:
        if (r0.intValue() == 1) goto L49;
    L54:
        return false;
    L52:
        return false;
    L51:
        return false;
    L62:
        return false;
    L22:
        if (r0 != null) goto L25;
    L26:
        if (r0 != null) goto L29;
        return false;
    L29:
        if (r0.intValue() != 2) goto L56;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r10 = AudienceMiniAppDataContext.a.a();
        if (r10 == null) goto L39;
        com.bytedance.live.datacontext.n<ShelfInfo> r11 = r10.m618getShelfInfo();
        if (r11 == null) goto L39;
        ShelfInfo r12 = (ShelfInfo) r11.getValue();
        if (r12 == null) goto L39;
        List<ShelfCardInfo> r13 = r12.cardInfoList;
        if (r13 == null) goto L39;
        int r14 = r13.size();
    L40:
        if (r14 <= 1) goto L57;
    L41:
        ShelfCardInfo r15 = getExplainCardInfo();
        if (r15 == null) goto L58;
        ProductInfo r16 = r15.getProductInfo();
        if (r16 == null) goto L59;
        ProductJumpSetting r17 = r16.jumpSetting;
        if (r17 != null) goto L48;
        return false;
    L48:
        if (r17.isJumpToOtherPage == true) goto L49;
        return false;
    L59:
        return false;
    L58:
        return false;
    L57:
        return false;
    L39:
        r14 = 0;
        goto L40
    L56:
        return false;
    L25:
        if (r0.intValue() == 1) goto L41;
        goto L26
    }

    public final void openMiniApp(MountedMiniAppSource r11, ShelfCardInfo r12) {
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "cardInfo");
        LaunchContextService.openMiniApp$default(this, getMountedMiniAppSchema(r11, r12), getMiniAppLaunchParams$default(this, getMountedMiniAppSchema(r11, r12), r11, r12, null, 8, null), null, 4, null);
    }

    public final void openMiniApp(MountedMiniAppSource r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "bdpLogExtra");
        LaunchContextService.openMiniApp$default(this, getMountedMiniAppSchema$default(this, r12, null, 2, null), getMiniAppLaunchParams$default(this, getMountedMiniAppSchema$default(this, r12, null, 2, null), r12, null, r13, 4, null), null, 4, null);
    }

    private final Map<String, String> getCustomFieldExtra(String r10, boolean r11, boolean r12) {
        LinkedHashMap r0 = new LinkedHashMap();
        SchemaInfo.b r1 = SchemaInfo.s;
        r1.getClass();
        SchemaInfo r13 = SchemaInfo.b.b(r10);
        if (r13 == null) goto L6;
        Intrinsics.checkNotNullParameter("launch_config", "key");
        JSONObject r14 = SchemaInfo.b.a(r1, r13.c("launch_config"));
        if (r14 == null) goto L6;
    L7:
        JSONObject r3 = r14.optJSONObject("xscreen_config");
        if (r3 != null) goto L11;
        r3 = new JSONObject();
    L11:
        if (r11 == true) goto L13;
    L17:
        float r15 = 0.7f;
    L19:
        if (r15 == 0.7f) goto L21;
    L23:
        int r4 = 0;
    L24:
        int r7 = qo0.a.a;
        qo0.a.a(TAG, "x screen rate: " + r15 + ", " + r4);
        m.d(r3, "rate", Float.valueOf(r15));
        m.d(r3, "optimize_gesture", Integer.valueOf(r4));
        m.d(r3, "second_full_screen", Integer.valueOf(r4));
        m.d(r3, "capsule_button_type", 2);
        m.d(r3, "top_nav_bar", 0);
        m.d(r3, "top_radius", 12);
        if (r12 == false) goto L27;
        r3.put("capsule_button_type", 4);
    L27:
        r14.put("xscreen_config", r3);
        Unit r16 = Unit.INSTANCE;
        r0.put("launch_config", SchemaInfo.b.c(r14));
        JSONObject r17 = new JSONObject();
        Room r18 = getOpenPlatformContext().getRoom();
        String r19 = "";
        if (r18 == null) goto L31;
        String r110 = r18.buildPullUrl();
        if (r110 == null) goto L31;
    L32:
        r17.put("live_url", r110);
        Room r111 = getOpenPlatformContext().getRoom();
        if (r111 == null) goto L47;
        User r112 = r111.getOwner();
        if (r112 == null) goto L47;
        ImageModel r113 = r112.getAvatarThumb();
        if (r113 == null) goto L47;
        List r114 = r113.getUrls();
        if (r114 == null) goto L47;
        if ((!r114.isEmpty()) == true) goto L44;
        r114 = null;
    L44:
        if (r114 == null) goto L47;
        String r115 = (String) ListProtector.get(r114, 0);
        if (r115 == null) goto L47;
    L48:
        r17.put("live_user_avatar", r115);
        Room r116 = getOpenPlatformContext().getRoom();
        if (r116 == null) goto L56;
        User r117 = r116.getOwner();
        if (r117 == null) goto L56;
        String r118 = r117.getNickName();
        if (r118 == null) goto L56;
        r19 = r118;
    L56:
        r17.put("live_user_name", r19);
        r0.put("live_info", SchemaInfo.b.c(r17));
        return r0;
    L47:
        r115 = "";
    L31:
        r110 = "";
        goto L32
    L21:
        if (((Boolean) u.a.getValue()).booleanValue() == false) goto L23;
        r4 = 1;
        goto L24
    L13:
        if (OpenPlatformHostInfoPresenter.a() == false) goto L17;
        if (((Boolean) t.a.getValue()).booleanValue() == false) goto L17;
        r15 = 1.0f;
    L6:
        r14 = new JSONObject();
        goto L7
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService
    public void openMiniApp(final String r9, final ko0.b r10, final Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "schema");
        Intrinsics.checkNotNullParameter(r10, "launchParams");
        ((MiniAppAudienceDebugContextService) getOpenPlatformContext().getService(MiniAppAudienceDebugContextService.class)).getClass();
        Intrinsics.checkNotNullParameter(r9, "schema");
        boolean r2 = false;
        boolean r3 = true;
        if (r9.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L68;
        Intrinsics.checkNotNullParameter(r9, "schema");
        if (r9.length() != 0) goto L11;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L45;
        SchemaInfo.s.getClass();
        SchemaInfo r5 = SchemaInfo.b.b(r9);
        if (r5 == null) goto L45;
        if (r5.a != SchemaInfo.Host.MICROAPP) goto L45;
        String r6 = r5.c("inspect");
        if (r6 != null) goto L23;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == true) goto L45;
        String r8 = r5.c("ide_inspect_version");
        if (r8 != null) goto L31;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == true) goto L45;
        String r13 = r5.c("ide_config");
        if (r13 != null) goto L39;
    L42:
        boolean r14 = true;
    L43:
        if (r14 == true) goto L45;
        boolean r15 = true;
    L46:
        if (r15 == false) goto L68;
        SchemaInfo.s.getClass();
        SchemaInfo r16 = SchemaInfo.b.b(r9);
        if (r16 == null) goto L68;
        String r17 = r16.c("ide_config");
        if (r17 == null) goto L68;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L56
        Object r19 = Result.constructor-impl(new JSONObject(r17));     // Catch: Throwable -> L56
    L59:
        if (Result.isFailure-impl(r19) == false) goto L61;
        r19 = null;
    L61:
        JSONObject r20 = (JSONObject) r19;
        if (r20 == null) goto L68;
        if (r20.has("inspect_platform") != true) goto L68;
        if (Intrinsics.areEqual(r20.get("inspect_platform"), "iOS") == false) goto L68;
        f2.c("使用ios手机可进行观众端调试", 0);
    L56:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    L39:
        if (r13.length() == 0) goto L42;
        r14 = false;
        goto L43
    L31:
        if (r8.length() == 0) goto L34;
        r12 = false;
        goto L35
    L23:
        if (r6.length() == 0) goto L26;
        r7 = false;
    L45:
        r15 = false;
        goto L46
    L11:
        r4 = false;
    L68:
        MiniAppAudienceDebugContextService r22 = (MiniAppAudienceDebugContextService) getOpenPlatformContext().getService(MiniAppAudienceDebugContextService.class);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r9, "schema");
        if (Intrinsics.areEqual(r9, "") == true) goto L107;
        Intrinsics.checkNotNullParameter(r9, "schema");
        if (r9.length() != 0) goto L74;
        boolean r0 = true;
    L75:
        if (r0 == true) goto L89;
        SchemaInfo.s.getClass();
        SchemaInfo r23 = SchemaInfo.b.b(r9);
        if (r23 == null) goto L89;
        if (r23.a != SchemaInfo.Host.MICROAPP) goto L89;
        if (((SchemaInfo.VersionType) r23.c.getValue()) != SchemaInfo.VersionType.latest) goto L85;
    L88:
        boolean r24 = true;
    L90:
        if (r24 == false) goto L107;
        SchemaInfo.s.getClass();
        SchemaInfo r25 = SchemaInfo.b.b(r9);
        if (r25 == null) goto L107;
        if (r25.a == SchemaInfo.Host.MICROAPP) goto L98;
    L100:
        if (r2 == true) goto L102;
    L106:
        r3 = Intrinsics.areEqual(r25.a(), r22.b);
        goto L107
    L102:
        if (v.a() == false) goto L106;
        if (((Boolean) xd0.a.getValue()).booleanValue() == true) goto L106;
    L98:
        if (((SchemaInfo.VersionType) r25.c.getValue()) != SchemaInfo.VersionType.audit) goto L100;
        r2 = true;
        goto L100
    L85:
        if (((SchemaInfo.VersionType) r23.c.getValue()) == SchemaInfo.VersionType.audit) goto L88;
        if (((SchemaInfo.VersionType) r23.c.getValue()) == SchemaInfo.VersionType.preview) goto L88;
    L89:
        r24 = false;
        goto L90
    L74:
        r0 = false;
    L107:
        if (r3 == false) goto L109;
        openMiniAppWithLogin(new AnonymousClass2(this, r9, r10, r11));
        return;
    L109:
        qo0.a.b(TAG, "openMiniApp fail: audience can not open mini app", null);
        return;
    L5:
        r1 = false;
        goto L7
    }

    /* JADX INFO: renamed from: access$openMiniApp$s-1677379363, reason: not valid java name */
    public static final /* synthetic */ void m757access$openMiniApp$s1677379363(AudienceLaunchContextService r0, String r1, ko0.b r2, Function0 r3) {
        super.openMiniApp(r1, r2, r3);
    }

    private final ko0.b getMiniAppLaunchParams(String r23, MountedMiniAppSource r24, ShelfCardInfo r25, Map<String, String> r26) {
        String r3 = LaunchParamConstant$Scene.b;
        MiniAppDataContext.Companion.getClass();
        if (g.c(MiniAppDataContext.a.b()) == false) goto L5;
        String r6 = "coexist_live";
    L6:
        String r8 = "connection_panel";
        switch(com.bytedance.android.live.openplatform.impl.miniappaudience.launch.a.b[r24.ordinal()]) {
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        String r9 = "live_shelf_card";
    L16:
        if (g.c(MiniAppDataContext.a.b()) == false) goto L18;
        String r10 = "coexist_live";
    L19:
        String r2 = n.c();
        if (r2 != null) goto L22;
        String r11 = "";
    L24:
        switch(com.bytedance.android.live.openplatform.impl.miniappaudience.launch.a.c[r24.ordinal()]) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L27;
            case 7: goto L27;
            case 8: goto L27;
            default: goto L26;
        };
    L27:
        r8 = "live_shelf_card";
        goto L31
    L28:
        String r4 = "live_link";
    L30:
        r8 = r4;
        goto L31
    L29:
        r4 = "live_popup_card";
    L31:
        Map<String, String> r12 = getBdpLogExtra();
        r12.putAll(r26);
        Unit r5 = Unit.INSTANCE;
        ko0.b r7 = new ko0.b(r3, r6, r9, r10, r11, r8, r12, getQueryExtra(), getCustomFieldExtra(r23, isShelf(r24), isDirectPay(r25, r24)), false, false, null, 14656);
        if (r24 != MountedMiniAppSource.ConnectionPanel) goto L34;
    L35:
        uq0.a r1 = ((AudienceCastContextService) getOpenPlatformContext().getService(AudienceCastContextService.class)).a;
        if (r1 != null) goto L38;
    L77:
        return r7;
    L38:
        if ((!StringsKt.isBlank(r1.b)) == false) goto L77;
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L77;
        String r13 = r1.b;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r7.h = r13;
        r7.i.putAll(r1.c);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r14 = AudienceMiniAppDataContext.a.a();
        if (r14 == null) goto L70;
        com.bytedance.live.datacontext.n<ShelfInfo> r15 = r14.m618getShelfInfo();
        if (r15 == null) goto L70;
        ShelfInfo r16 = (ShelfInfo) r15.getValue();
        if (r16 == null) goto L70;
        List<ShelfCardInfo> r17 = r16.cardInfoList;
        if (r17 == null) goto L70;
        if ((!r17.isEmpty()) != true) goto L70;
        AudienceMiniAppDataContext r18 = AudienceMiniAppDataContext.a.a();
        String r19 = null;
        if (r18 == null) goto L60;
        com.bytedance.live.datacontext.n<ShelfInfo> r20 = r18.m618getShelfInfo();
        if (r20 == null) goto L60;
        ShelfInfo r21 = (ShelfInfo) r20.getValue();
        if (r21 == null) goto L60;
        List<ShelfCardInfo> r22 = r21.cardInfoList;
        if (r22 == null) goto L60;
        ShelfCardInfo r27 = (ShelfCardInfo) ListProtector.get(r22, 0);
    L61:
        Map<String, String> r28 = r7.j;
        SchemaInfo.b r29 = SchemaInfo.s;
        if (r27 == null) goto L64;
        r19 = r27.a0();
    L64:
        r29.getClass();
        SchemaInfo r30 = SchemaInfo.b.b(r19);
        if (r30 == null) goto L68;
        String r31 = r30.e();
        if (r31 == null) goto L68;
    L69:
        r28.put("anchor_mount_page", r31);
        return r7;
    L68:
        r31 = "";
    L60:
        r27 = null;
    L70:
        Map<String, String> r32 = r7.j;
        SchemaInfo.s.getClass();
        SchemaInfo r33 = SchemaInfo.b.b(r23);
        if (r33 == null) goto L74;
        String r34 = r33.e();
        if (r34 == null) goto L74;
    L75:
        r32.put("anchor_mount_page", r34);
        return r7;
    L74:
        r34 = "";
        goto L75
    L34:
        if (r24 != MountedMiniAppSource.ShelfPageLinkCast) goto L77;
    L26:
        throw new NoWhenBranchMatchedException();
    L22:
        r11 = r2;
        goto L24
    L18:
        r10 = "live";
        goto L19
    L11:
        String r35 = "in_live_link";
    L13:
        r9 = r35;
        goto L16
    L12:
        r35 = "in_live_card";
        goto L13
    L14:
        r9 = "connection_panel";
        goto L16
    L9:
        throw new NoWhenBranchMatchedException();
    L5:
        r6 = "live";
        goto L6
    }

    public static /* synthetic */ String getShelfPageCardActionButtonSchema$default(AudienceLaunchContextService r0, ShelfCardInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.getShelfPageCardActionButtonSchema(r1);
    }

    public static /* synthetic */ String getMountedMiniAppSchema$default(AudienceLaunchContextService r0, MountedMiniAppSource r1, ShelfCardInfo r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getMountedMiniAppSchema(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openMiniApp$default(AudienceLaunchContextService r0, MountedMiniAppSource r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        r0.openMiniApp(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ko0.b getMiniAppLaunchParams$default(AudienceLaunchContextService r0, String r1, MountedMiniAppSource r2, ShelfCardInfo r3, Map r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = MapsKt.emptyMap();
    L9:
        return r0.getMiniAppLaunchParams(r1, r2, r3, r4);
    }
}
