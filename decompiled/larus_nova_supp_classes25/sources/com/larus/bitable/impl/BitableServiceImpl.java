package com.larus.bitable.impl;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bitable.api.IBitableService;
import com.larus.bitable.sdk.api.IBitableSdkService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.utils.f;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\rH\u0002¨\u0006\u0017"}, d2 = {"Lcom/larus/bitable/impl/BitableServiceImpl;", "Lcom/larus/bitable/api/IBitableService;", "<init>", "()V", "initSdkIfNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openBitable", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "page", "", "tryPrefetchData", "", "clearReference", "getBitableToken", "buildOfficeAppletUrl", "token", "buildBitableOfficeInputParam", "Lcom/larus/office/OfficeInputParam;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BitableServiceImpl implements IBitableService {

    public static final class a {
    }

    static {
    }

    public BitableServiceImpl() {
    }

    @Override // com.larus.bitable.api.IBitableService
    public final boolean c(Bundle r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        String r0 = r7.getString("base_token");
        if (r0 != null) goto L8;
        r0 = r7.getString("resource_id");
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (StringsKt.isBlank(r0) == false) goto L11;
        FLogger.a.i("BitableServiceImpl", "tryPrefetchData skipped, token is empty");
        return false;
    L11:
        FLogger r1 = FLogger.a;
        StringBuilder r4 = new StringBuilder("tryPrefetchData, token=");
        int r5 = f.a;
        r4.append(f.b(r0));
        r1.i("BitableServiceImpl", r4.toString());
        IBitableSdkService r2 = (IBitableSdkService) ServiceManager.get().getService(IBitableSdkService.class);
        if (r2 == null) goto L30;
        OfficeInputParam r3 = new OfficeInputParam();
        r3.setType("base");
        r3.setResourceId(r0);
        r3.setSlidesToken(r0);
        r3.setResourceType(r7.getInt("resource_type", 15));
        r3.setResourceVersion(r7.getInt("resource_version", -1));
        String r6 = r7.getString("artifact_meta_id");
        if (r6 == null) goto L16;
        r3.setArtifactMetaId(r6);
    L16:
        String r8 = r7.getString("artifact_version_id");
        if (r8 == null) goto L19;
        r3.setArtifactVersionId(r8);
    L19:
        r3.setConversationId(r7.getString("conversation_id"));
        String r9 = r7.getString("section_id");
        if (r9 == null) goto L22;
        r3.setSectionId(r9);
    L22:
        r3.setMessageId(r7.getString("message_id"));
        r3.setBotId(r7.getString("bot_id"));
        String r10 = r7.getString("enter_from");
        if (r10 == null) goto L25;
        r3.setEnterFrom(r10);
    L25:
        String r11 = r7.getString("enter_method");
        if (r11 == null) goto L28;
        r3.setEnterMethod(r11);
    L28:
        r3.setPreviousPage(r7.getString("previous_page"));
        r3.setClickTimestamp(r7.getLong("click_timestamp", 0));
        r3.setCotRefArtifacts(r7.getString("cot_ref_artifacts"));
        r3.setSourceUrlForParams(r7.getString("key_source_url_for_params"));
        r3.setApplyPermissionConversationId(r7.getString("apply_permission_conversation_id"));
        r3.setApplyPermissionMessageId(r7.getString("apply_permission_message_id"));
        return r2.c(r3);
    L30:
        return false;
    }

    @Override // com.larus.bitable.api.IBitableService
    public final void d(Context r21, Bundle r22, String r23) {
        String r2 = r23;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "params");
        Intrinsics.checkNotNullParameter(r2, "page");
        String r4 = r22.getString("base_token");
        if (r4 != null) goto L8;
        r4 = r22.getString("resource_id");
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        if (StringsKt.isBlank(r4) == false) goto L11;
        FLogger.a.w("BitableServiceImpl", "openBitable skipped, token is empty, page=".concat(r2));
        return;
    L11:
        FLogger r6 = FLogger.a;
        StringBuilder r8 = new StringBuilder("openBitable, page=");
        r8.append(r2);
        r8.append(", token=");
        int r9 = f.a;
        r8.append(f.b(r4));
        r6.i("BitableServiceImpl", r8.toString());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new BitableServiceImpl$openBitable$1(null), 3, null);
        StringBuilder r7 = new StringBuilder("sslocal://doubao_apps?app_id=db_1JOlsY6&path=detail");
        r7.append("&route_mode=" + ApplicationRouter.Mode.NAVIGATE.getValue());
        List r10 = CollectionsKt.createListBuilder();
        r10.add(TuplesKt.to("biz", "base"));
        r10.add(TuplesKt.to("base_token", r4));
        r10.add(TuplesKt.to("resource_id", r4));
        r10.add(TuplesKt.to("doc_title", r22.getString("doc_title")));
        r10.add(TuplesKt.to("resource_type", String.valueOf(r22.getInt("resource_type", 15))));
        Integer r3 = Integer.valueOf(r22.getInt("resource_version", -1));
        if (r3.intValue() < 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        String r11 = r3.toString();
    L21:
        r10.add(TuplesKt.to("resource_version", r11));
        r10.add(TuplesKt.to("artifact_meta_id", r22.getString("artifact_meta_id")));
        r10.add(TuplesKt.to("artifact_version_id", r22.getString("artifact_version_id")));
        r10.add(TuplesKt.to("conversation_id", r22.getString("conversation_id")));
        r10.add(TuplesKt.to("section_id", r22.getString("section_id")));
        r10.add(TuplesKt.to("message_id", r22.getString("message_id")));
        r10.add(TuplesKt.to("bot_id", r22.getString("bot_id")));
        r10.add(TuplesKt.to("enter_from", r22.getString("enter_from")));
        r10.add(TuplesKt.to("enter_method", r22.getString("enter_method")));
        Long r12 = Long.valueOf(r22.getLong("click_timestamp", 0));
        if (r12.longValue() <= 0) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == true) goto L28;
        r12 = null;
    L28:
        if (r12 == null) goto L30;
        String r14 = r12.toString();
    L31:
        r10.add(TuplesKt.to("click_timestamp", r14));
        r10.add(TuplesKt.to("cot_ref_artifacts", r22.getString("cot_ref_artifacts")));
        String r15 = r22.getString("previous_page");
        if (r15 == null) goto L35;
        r2 = r15;
    L35:
        r10.add(TuplesKt.to("previous_page", r2));
        r10.add(TuplesKt.to("key_source_url_for_params", r22.getString("key_source_url_for_params")));
        ArrayList r16 = com.larus.office.base.preview.a.a(r22, "doc_list_to_apply_permission");
        if (r16 == null) goto L38;
        String r17 = GsonProtectorUtils.toJson(new Gson(), r16);
    L39:
        r10.add(TuplesKt.to("doc_list_to_apply_permission", r17));
        r10.add(TuplesKt.to("apply_permission_conversation_id", r22.getString("apply_permission_conversation_id")));
        r10.add(TuplesKt.to("apply_permission_message_id", r22.getString("apply_permission_message_id")));
        List r1 = CollectionsKt.build(r10);
        ArrayList r18 = new ArrayList();
        Iterator r19 = r1.iterator();
    L41:
        if (r19.hasNext() == false) goto L54;
        Pair r20 = (Pair) r19.next();
        String r24 = (String) r20.component1();
        String r25 = (String) r20.component2();
        if (r25 != null) goto L45;
    L48:
        boolean r26 = true;
    L49:
        if (r26 == false) goto L51;
        String r27 = null;
    L52:
        if (r27 == null) goto L41;
        r18.add(r27);
        goto L41
    L51:
        r27 = r24 + '=' + URLEncoder.encode(r25, "UTF-8");
        goto L52
    L45:
        if (r25.length() == 0) goto L48;
        r26 = false;
        goto L49
    L54:
        r7.append("&query=" + URLEncoder.encode(CollectionsKt.joinToString$default(r18, "&", null, null, 0, null, null, 62, null), "UTF-8"));
        SmartRouter.buildRoute(r21, r7.toString()).d();
        return;
    L38:
        r17 = null;
        goto L39
    L30:
        r14 = null;
        goto L31
    L24:
        r13 = false;
        goto L25
    L20:
        r11 = null;
        goto L21
    L14:
        r5 = false;
        goto L15
    }
}
