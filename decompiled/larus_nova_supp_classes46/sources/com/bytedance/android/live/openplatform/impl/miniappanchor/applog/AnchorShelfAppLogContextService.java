package com.bytedance.android.live.openplatform.impl.miniappanchor.applog;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0006\u0010\u000e\u001a\u00020\u0006J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/applog/AnchorShelfAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "openPlatformContext", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "reportAddShelfPageSuccess", "", "isBeforeStart", "", "shelfInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "reportPageShelfSubmitAudit", "reportShelfAuditResultEndLive", "reportShelfBindResultEndLive", "reportWhenEndLive", "tryReportCoexistStatusChanged", "prevShelfInfo", "currShelfInfo", "isMountedBeforeStart", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfAppLogContextService extends OpenPlatformContextService {
    private final void reportShelfAuditResultEndLive() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L23;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L31;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L32;
        List<ShelfCardInfo> r3 = r2.cardInfoList;
        if (r3 == null) goto L33;
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L34;
        ShelfCardInfo r5 = (ShelfCardInfo) r4.next();
        boolean r6 = true;
        if (r5.H0(1) == false) goto L12;
        String r7 = r5.D();
        if (r7 != null) goto L18;
    L21:
        if (r6 == true) goto L12;
        ((AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class)).reportPageShelfAuditResult(r5);
        goto L12
    L18:
        if (StringsKt.isBlank(r7) == true) goto L21;
        r6 = false;
        goto L21
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    private final void reportShelfBindResultEndLive() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L29;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L30;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L31;
        AnchorMiniAppAppLogContextService r3 = (AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class);
        ShelfMicroAppInfo r4 = r2.appInfo;
        String r5 = "";
        if (r4 == null) goto L12;
        String r6 = r4.appId;
        if (r6 == null) goto L12;
    L13:
        SchemaInfo.b r7 = SchemaInfo.s;
        List<ShelfCardInfo> r8 = r2.cardInfoList;
        if (r8 == null) goto L18;
        ShelfCardInfo r9 = (ShelfCardInfo) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L18;
        String r10 = r9.a0();
    L19:
        r7.getClass();
        SchemaInfo r11 = SchemaInfo.b.b(r10);
        if (r11 == null) goto L27;
        JSONObject r12 = r11.b();
        if (r12 == null) goto L27;
        String r13 = r12.optString("enter_position");
        if (r13 == null) goto L27;
        r5 = r13;
    L27:
        r3.reportAnchorExitBindSuccess(r6, r5, "end_live", "app");
        return;
    L18:
        r10 = null;
    L12:
        r6 = "";
        goto L13
    L31:
        return;
    L30:
        return;
    }

    public final void reportWhenEndLive() {
        reportShelfAuditResultEndLive();
        reportShelfBindResultEndLive();
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r0 = MiniAppDataContext.a.b();
        if (r0 == null) goto L6;
        tryReportCoexistStatusChanged(r0, r0, false);
        return;
    }

    public AnchorShelfAppLogContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final void reportPageShelfSubmitAudit(ShelfInfo r12) {
        Intrinsics.checkNotNullParameter(r12, "shelfInfo");
        List<ShelfCardInfo> r0 = r12.cardInfoList;
        if (r0 == null) goto L66;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L5:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        ShelfCardInfo r5 = (ShelfCardInfo) r4;
        if (r5.getCardId() != 0) goto L10;
    L11:
        r3 = true;
    L12:
        if (r3 == false) goto L5;
        r1.add(r4);
        goto L5
    L10:
        if (r5.I0() == false) goto L12;
    L14:
        Iterator r6 = r1.iterator();
    L16:
        if (r6.hasNext() == false) goto L75;
        ShelfCardInfo r7 = (ShelfCardInfo) r6.next();
        AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class);
        String r9 = r7.D();
        if (r9 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        String r11 = "1";
        if (r10 == true) goto L44;
        if (r7.G0(1) == false) goto L42;
        List<ImageModel> r13 = r7.L();
        if (r13 == null) goto L35;
        ImageModel r14 = (ImageModel) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L35;
        List r15 = r14.getUrls();
        if (r15 == null) goto L35;
        String r16 = (String) CollectionsKt.firstOrNull(r15);
    L37:
        if ((!Intrinsics.areEqual(r16, r7.F())) == true) goto L42;
        if (r7.w0() == true) goto L45;
    L46:
        String r17 = "0";
    L47:
        String r18 = r7.E();
        if (r18 != null) goto L50;
    L53:
        boolean r19 = true;
    L54:
        if (r19 == true) goto L57;
    L60:
        String r20 = r7.t();
        ShelfMicroAppInfo r21 = r12.appInfo;
        if (r21 == null) goto L64;
        String r22 = r21.appId;
        if (r22 == null) goto L64;
    L65:
        r8.reportPageShelfSubmitAudit(r17, r11, r20, r22);
    L64:
        r22 = "";
        goto L65
    L57:
        if (r7.y0() == false) goto L59;
        r11 = "2";
        goto L60
    L59:
        r11 = "0";
        goto L60
    L50:
        if (StringsKt.isBlank(r18) == true) goto L53;
        r19 = false;
    L45:
        r17 = "2";
    L35:
        r16 = null;
    L42:
        r17 = "1";
        goto L47
    L44:
        if (r7.w0() == false) goto L46;
    L20:
        if (StringsKt.isBlank(r9) == true) goto L23;
        r10 = false;
        goto L24
    L75:
        return;
    }

    public final void reportAddShelfPageSuccess(boolean r8, ShelfInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "shelfInfo");
        String r1 = "";
        String r2 = "auto";
        if (r8 == false) goto L5;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class);
        if (r9.isAutoMount == true) goto L21;
        r2 = r9.c();
    L21:
        ShelfMicroAppInfo r11 = r9.appInfo;
        if (r11 == null) goto L27;
        String r12 = r11.appId;
        if (r12 == null) goto L27;
        r1 = r12;
    L27:
        r10.reportAddShelfPageSuccess(r2, true, r1, "app");
        return;
    L5:
        if (r9.status != 1) goto L29;
        AnchorMiniAppAppLogContextService r13 = (AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class);
        if (r9.isAutoMount == true) goto L10;
        r2 = r9.c();
    L10:
        ShelfMicroAppInfo r14 = r9.appInfo;
        if (r14 == null) goto L16;
        String r15 = r14.appId;
        if (r15 == null) goto L16;
        r1 = r15;
    L16:
        r13.reportAddShelfPageSuccess(r2, false, r1, "app");
        return;
    }

    public final void tryReportCoexistStatusChanged(ShelfInfo r13, ShelfInfo r14, boolean r15) {
        if (g.c(r13) == true) goto L8;
        if (g.c(r14) == false) goto L8;
        Boolean r0 = Boolean.TRUE;
    L17:
        if (r0 != null) goto L19;
        return;
    L19:
        if (r14 != null) goto L21;
        ShelfInfo r1 = r13;
    L22:
        AnchorMiniAppAppLogContextService r3 = (AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class);
        boolean r4 = r0.booleanValue();
        if (r1 == null) goto L28;
        ShelfMicroAppInfo r5 = r1.appInfo;
        if (r5 == null) goto L28;
        String r6 = r5.appId;
        if (r6 == null) goto L28;
    L29:
        if (r1 != null) goto L31;
    L33:
        if (r1 == null) goto L35;
        String r7 = r1.c();
    L36:
        if (r1 != null) goto L38;
    L41:
        String r8 = "live_assistant";
    L42:
        String r9 = r8;
        if (r0.booleanValue() == true) goto L50;
        if (r13 != r14) goto L47;
        String r16 = "end_live";
    L46:
        String r10 = r16;
    L51:
        if (r1 == null) goto L55;
        List<ShelfCardInfo> r17 = r1.cardInfoList;
        if (r17 == null) goto L55;
        int r11 = r17.size();
    L56:
        r3.reportCoexistStatusChangedStart(r4, r6, r7, r15, r9, r10, r11);
        return;
    L55:
        r11 = 0;
        goto L56
    L47:
        if (r14 != null) goto L49;
        r16 = "mp_first";
        goto L46
    L49:
        r16 = "mp_after";
        goto L46
    L50:
        r10 = "";
        goto L51
    L38:
        if (r1.source != 0) goto L41;
        r8 = "app";
        goto L42
    L35:
        r7 = "";
        goto L36
    L31:
        if (r1.isAutoMount != true) goto L33;
        r7 = "auto";
    L28:
        r6 = "";
        goto L29
    L21:
        r1 = r14;
    L8:
        if (g.c(r13) == false) goto L13;
        if (g.c(r14) == true) goto L13;
        r0 = Boolean.FALSE;
    L13:
        if (g.c(r13) == false) goto L16;
        if (r13 != r14) goto L16;
        r0 = Boolean.FALSE;
    L16:
        r0 = null;
        goto L17
    }
}
