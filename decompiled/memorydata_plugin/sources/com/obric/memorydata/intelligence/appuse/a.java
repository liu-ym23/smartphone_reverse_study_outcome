package com.obric.memorydata.intelligence.appuse;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.rpc.model.ListAppCategoryMsgData;
import com.bytedance.rpc.model.ListAppCategoryMsgReq;
import com.bytedance.rpc.model.rpc.IntentGatewayService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/intelligence/appuse/AppCategoryHelper;", "", "<init>", "()V", "TAG", "", "APP_CATEGORY_DATA_KEY", "appMsgList", "", "Lcom/obric/memorydata/intelligence/appuse/AppCategoryMsg;", "appMsgCacheMap", "", "syncGetAppCategoryMsg", ObricMemoryConstants.KEY_PACKAGE_NAME, "addMsg", "", NotificationCompat.CATEGORY_MESSAGE, "save", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<AppCategoryMsg> f9934b;
    private static final Map<String, AppCategoryMsg> c = null;

    static {
        f9933a = new a();
        f9934b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (((Unit) ZeusTransformUtils.preCheckCast(y.a(null, $$Lambda$a$ADnqXnVEHWGtodBHXsB_BfbGkw.INSTANCE, 1, null), Unit.class, "com.obric.memorydata.plugin")) != null) goto L6;
        Boolean.valueOf(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"app_category_date_key"}));
        return;
    }

    private a() {
    }

    private final void a() {
        boolean r0 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(f9934b, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
        String r5 = u.a(f9934b);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L12;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("app_category_date_key", r5);
        return;
    L12:
        return;
    }

    private final void a(AppCategoryMsg r3) {
        Map<String, AppCategoryMsg> r0 = c;
        if (r0.get(r3.getPackageName()) != null) goto L6;
        f9934b.add(r3);
        r0.put(r3.getPackageName(), r3);
        a();
        return;
    }

    private static final Unit b() {
        boolean r3 = false;
        String r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("app_category_date_key");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L6:
        r3 = true;
    L7:
        if (r3 == true) goto L22;
        JsonArray r2 = JsonParser.parseString(r0).getAsJsonArray();
        if (r2 == null) goto L22;
        if (r2.isEmpty() == true) goto L22;
        Iterator<JsonElement> r4 = r2.iterator();
        Intrinsics.checkNotNullExpressionValue(r4, "iterator(...)");
    L14:
        if (r4.hasNext() == false) goto L22;
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(r4.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r5.isJsonObject() == false) goto L14;
        AppCategoryMsg r6 = (AppCategoryMsg) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r5, AppCategoryMsg.class), AppCategoryMsg.class, "com.obric.memorydata.plugin");
        Map<String, AppCategoryMsg> r7 = c;
        if (r7.get(r6.getPackageName()) == null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppCategoryHelper", "应用分类信息中存在重复信息", null, 4, null);
        goto L14
    L19:
        List<AppCategoryMsg> r8 = f9934b;
        Intrinsics.checkNotNull(r6);
        r8.add(r6);
        r7.put(r6.getPackageName(), r6);
    L22:
        return Unit.INSTANCE;
    L5:
        if (r1.length() != 0) goto L7;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$ADnqXnVEHWGtodBHXsB_Bfb-Gkw, reason: not valid java name */
    public static /* synthetic */ Unit m671lambda$ADnqXnVEHWGtodBHXsB_BfbGkw() {
        return b();
    }

    public final AppCategoryMsg a(String r18) {
        Intrinsics.checkNotNullParameter(r18, ObricMemoryConstants.KEY_PACKAGE_NAME);
        boolean r5 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L10;
        return null;
    L10:
        if (NetworkController.INSTANCE.isNetworkPolicySatisfied() == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppCategoryHelper", "ignore get app category msg, network policy not satisfied", null, 4, null);
        return null;
    L13:
        AppCategoryMsg r4 = (AppCategoryMsg) ZeusTransformUtils.preCheckCast(c.get(r18), AppCategoryMsg.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L16;
        return r4;
    L16:
        ListAppCategoryMsgReq r6 = new ListAppCategoryMsgReq();
        r6.packageNameList = CollectionsKt.listOf(r18);
        ListAppCategoryMsgData r0 = IntentGatewayService.listAppCategoryMsgSync(r6).data;     // Catch: Exception -> L29
        if (r0 == null) goto L28;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r0.categoryMsgList, Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        if (r7 != null) goto L22;
    L25:
        if (r5 == true) goto L28;
        List<com.bytedance.rpc.model.AppCategoryMsg> r1 = r0.categoryMsgList;     // Catch: Exception -> L29
        Intrinsics.checkNotNullExpressionValue(r1, "categoryMsgList");     // Catch: Exception -> L29
        com.bytedance.rpc.model.AppCategoryMsg r2 = (com.bytedance.rpc.model.AppCategoryMsg) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r1), com.bytedance.rpc.model.AppCategoryMsg.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        String r9 = r2.packageName;     // Catch: Exception -> L29
        Intrinsics.checkNotNullExpressionValue(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Exception -> L29
        int r10 = r2.category.type;     // Catch: Exception -> L29
        String r11 = r2.category.name;     // Catch: Exception -> L29
        Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);     // Catch: Exception -> L29
        long r12 = r2.category.id;     // Catch: Exception -> L29
        String r14 = r2.subCategory.name;     // Catch: Exception -> L29
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);     // Catch: Exception -> L29
        AppCategoryMsg r8 = new AppCategoryMsg(r9, r10, r11, r12, r14, r2.subCategory.id);     // Catch: Exception -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppCategoryHelper", r8.getPackageName() + ' ' + r8.getCategory() + ' ' + r8.getCategoryId() + ' ' + r8.getSubCategory() + ' ' + r8.getSubCategoryId() + ' ' + r8.getAppType(), false, 4, null);     // Catch: Exception -> L29
        a(r8);     // Catch: Exception -> L29
        return r8;
    L22:
        if (r7.isEmpty() == true) goto L25;
        r5 = false;
    L28:
        return null;
    L29:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AppCategoryHelper", "listAppCategoryMsgAsync error: " + e, null, 4, null);
        return null;
    L5:
        r3 = false;
        goto L7
    }
}
