package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.model.u0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.s2;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardSettingContextService extends OpenPlatformContextService {

    public static final class a {
    }

    static {
    }

    public ExplainCardSettingContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final void g(final u0 r40) {
        Intrinsics.checkNotNullParameter(r40, "mountInfo");
        HashMap<String, zo0.f> r0 = zo0.g.a;
        zo0.h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG).o();
        int r1 = np0.a.a;
        np0.a.a(getOpenPlatformContext().isInLive());
        String r2 = r40.f();
        if (r2 == null) goto L5;
        String r8 = com.bytedance.android.live.openplatform.api.utils.h.a(r2);
    L6:
        String r9 = r40.a();
        u0.a r3 = r40.d();
        if (r3 == null) goto L9;
        String r4 = r3.a();
    L10:
        u0.a r5 = r40.d();
        if (r5 == null) goto L13;
        String r6 = r5.b();
    L14:
        ImageModel r10 = new ImageModel(r4, CollectionsKt.listOf(r6));
        SchemaInfo.a r7 = new SchemaInfo.a();
        String r11 = r40.f();
        if (r11 == null) goto L17;
        String r12 = com.bytedance.android.live.openplatform.api.utils.h.a(r11);
    L18:
        r7.a(r12);
        SchemaInfo r13 = r7.c();
        if (r13 == null) goto L21;
        String r14 = r13.h();
    L22:
        ShelfMicroAppInfo r15 = new ShelfMicroAppInfo(r8, r9, r10, r14, 0, 48);
        ShelfCardInfo[] r16 = new ShelfCardInfo[1];
        String r17 = r40.f();
        String r18 = r40.a();
        String r20 = r40.g();
        u0.a r19 = r40.d();
        if (r19 == null) goto L25;
        String r110 = r19.b();
    L26:
        u0.a r21 = r40.d();
        if (r21 == null) goto L29;
        String r34 = r21.b();
    L30:
        u0.a r22 = r40.b();
        if (r22 == null) goto L33;
        String r23 = r22.b();
    L34:
        r16[0] = new ShelfCardInfo(r17, r18, r110, r20, r23, null, false, 0, 0, null, null, null, null, null, null, null, r34, 0, 0, -8381, 6);
        List r24 = CollectionsKt.mutableListOf(r16);
        JsonObject r25 = r40.c();
        if (r25 == null) goto L39;
        String r26 = r25.toString();
        if (r26 == null) goto L39;
        JSONObject r27 = s2.a(r26).optJSONObject("from_open_taskbox");
    L40:
        if (r27 == null) goto L42;
        ShelfInfo.MountType r28 = ShelfInfo.MountType.TalentMount;
    L43:
        int r111 = r28.getValue();
        JsonObject r29 = r40.c();
        if (r29 == null) goto L46;
        String r112 = r29.toString();
    L47:
        final ShelfInfo r113 = new ShelfInfo(r15, r24, r111, r112, null, r40.e(), 393148);
        List<ShelfCardInfo> r30 = r113.cardInfoList;
        if (r30 == null) goto L50;
        final ShelfCardInfo r31 = (ShelfCardInfo) CollectionsKt.firstOrNull(r30);
    L51:
        if (r31 == null) goto L56;
        String r32 = r31.I();
        if (r32 == null) goto L56;
        String r33 = r32;
    L57:
        qo0.a.c("ExplainCardSettingContextService", "on handle card cover based on mountInfo");
        int r35 = TextPosterHelper.a;
        Context r36 = getOpenPlatformContext().getContext();
        ShelfMicroAppInfo r37 = r113.appInfo;
        if (r37 == null) goto L63;
        String r38 = r37.appId;
        if (r38 == null) goto L63;
        String r39 = r38;
    L64:
        final String r41 = r33;
        TextPosterHelper.c(r36, r39, r33, new ExplainCardSettingContextService$openExplainCardSettingDialog$1(this, r113, r31, r41, r40), new ExplainCardSettingContextService$openExplainCardSettingDialog$2(this, r113, r40));
        return;
    L63:
        r39 = "";
    L56:
        r33 = "";
        goto L57
    L50:
        r31 = null;
        goto L51
    L46:
        r112 = null;
        goto L47
    L42:
        r28 = ShelfInfo.MountType.UnsetMount;
    L39:
        r27 = null;
        goto L40
    L33:
        r23 = null;
        goto L34
    L29:
        r34 = null;
        goto L30
    L25:
        r110 = null;
        goto L26
    L21:
        r14 = null;
        goto L22
    L17:
        r12 = "";
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public final void h(ExplainCardSettingsInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "explainCardSettingsInfo");
        if (r4.i() == true) goto L5;
        int r1 = np0.a.a;
        np0.a.a(getOpenPlatformContext().isInLive());
        BridgeContextService.g((BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class), "kill_miniapp");
    L5:
        Context r2 = getOpenPlatformContext().getContext();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "explainCardSettingsInfo");
        Intent r0 = new Intent(r2, ExplainCardSettingDialog.class);
        r0.putExtra("explain_card_info", r4);
        Unit r5 = Unit.INSTANCE;
        r2.startActivity(r0);
    }

    public static final void f(ExplainCardSettingContextService r30, ShelfInfo r31, u0 r32) {
        r30.getClass();
        HashMap<String, zo0.f> r0 = zo0.g.a;
        zo0.f r1 = zo0.h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);
        if (r31.e() == false) goto L5;
        String r2 = "promotion";
    L6:
        zo0.h.a(r1, r2);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        ShelfCardInfo r4 = null;
        if (r3 == null) goto L47;
        com.bytedance.live.datacontext.n<ShelfInfo> r5 = r3.m618getShelfInfo();
        if (r5 == null) goto L47;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L47;
        if (r6.e() == false) goto L45;
        String r7 = r6.openExtra;
        if (r7 == null) goto L19;
        JSONObject r8 = s2.a(r7).optJSONObject("from_open_taskbox");
        if (r8 == null) goto L19;
        String r9 = r8.optString("course_id");
    L20:
        JsonObject r10 = r32.c();
        if (r10 == null) goto L27;
        String r11 = r10.toString();
        if (r11 == null) goto L27;
        JSONObject r12 = s2.a(r11).optJSONObject("from_open_taskbox");
        if (r12 == null) goto L27;
        String r13 = r12.optString("course_id");
    L28:
        if (r9 != null) goto L30;
    L33:
        boolean r14 = true;
    L34:
        if (r14 == true) goto L45;
        if (r13 != null) goto L37;
    L40:
        boolean r15 = true;
    L41:
        if (r15 == true) goto L45;
        if (Intrinsics.areEqual(r13, r9) == false) goto L45;
    L46:
        ShelfInfo r16 = r6;
    L48:
        List<ShelfCardInfo> r17 = r16.cardInfoList;
        if (r17 == null) goto L61;
        ShelfCardInfo r18 = (ShelfCardInfo) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L61;
        if (r2.a(r18.D()) == false) goto L56;
        int r24 = 4;
        int r25 = 1;
    L60:
        r16 = ShelfInfo.a(r16, null, CollectionsKt.mutableListOf(new ShelfCardInfo[]{ShelfCardInfo.g(r18, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, r24, r25, -1, 1)}), false, null, null, null, 1048573);
        goto L61
    L56:
        if (r2.a(r18.o0()) == false) goto L58;
        int r19 = 2;
    L59:
        r24 = r19;
        r25 = 0;
        goto L60
    L58:
        r19 = 3;
    L61:
        Parcelable.Creator<ExplainCardSettingsInfo> r20 = ExplainCardSettingsInfo.CREATOR;
        Intrinsics.checkNotNullParameter(r16, "shelfInfo");
        ShelfMicroAppInfo r21 = r16.appInfo;
        List<ShelfCardInfo> r22 = r16.cardInfoList;
        if (r22 == null) goto L64;
        r4 = (ShelfCardInfo) CollectionsKt.firstOrNull(r22);
    L64:
        r30.h(new ExplainCardSettingsInfo(r21, r4, r16.entryPagePath, false, false, r16.mountType, r16.openExtra, r16.mpLiveChannel, 0, 272));
        return;
    L37:
        if (StringsKt.isBlank(r13) == true) goto L40;
        r15 = false;
        goto L41
    L30:
        if (StringsKt.isBlank(r9) == true) goto L33;
        r14 = false;
    L27:
        r13 = null;
    L19:
        r9 = null;
    L45:
        r6 = r31;
    L47:
        r16 = r31;
        goto L48
    L5:
        r2 = PbRequest.SwitchType.OTHER;
        goto L6
    }
}
