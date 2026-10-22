package com.obric.memorydata.personalcontext;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.search.entity.SearchType;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.obric.memorydata.sdk.entity.search.ParamItem;
import com.obric.memorydata.sdk.entity.search.QuAction;
import com.obric.memorydata.sdk.entity.search.RewriteQuery;
import com.obric.memorydata.sdk.service.PermissionCheckResult;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/personalcontext/DomainPermissionCheck;", "", "<init>", "()V", "TAG", "", "CONTACT_SEARCH_ACTION_NAME", "CALL_HISTORY_SEARCH_ACTION_NAME", "SEARCH_APP_ENTITY_INTENT_NAME", "GLOBAL_SEARCH_INTENT_NAME", "CONTACT_IN_APP_SEARCH_INTENT_NAME", "CALL_HISTORY_IN_APP_SEARCH_INTENT_NAME", "KEY_IS_PERMISSION_CHECK", "KEY_IS_QUERY_RELATED_TO_CONTACT", "SLOT_NAME_CONTACT_NAME", "assistantGrantedPermissions", "", "actionNameToPermission", "", "", "domainToPermission", "permissionToString", "checkDependencyPermissionForSearchIntent", "Lcom/obric/memorydata/sdk/MemoryResponse;", "Lcom/obric/memorydata/sdk/service/PermissionCheckResult;", "pcSearchIntent", "quResultJson", "isDomainGranted", "", "domain", "callHistoryDomainNeedContactPermission", ChatMessage.TYPE_QUERY, "action", "Lcom/obric/memorydata/sdk/entity/search/QuAction;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12179a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Set<String> f12180b;
    private static final Map<String, List<String>> c = null;
    private static final Map<String, List<String>> d = null;
    private static final Map<String, String> e = null;

    static {
        f12179a = new f();
        f12180b = SetsKt.emptySet();
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("SearchContact", CollectionsKt.listOf("android.permission.READ_CONTACTS")), TuplesKt.to("SearchCallHistory", CollectionsKt.listOf(new String[]{"android.permission.READ_CALL_LOG", "android.permission.READ_CONTACTS"}))});
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to("Contact", CollectionsKt.listOf("android.permission.READ_CONTACTS")), TuplesKt.to("CallHistory", CollectionsKt.listOf(new String[]{"android.permission.READ_CALL_LOG", "android.permission.READ_CONTACTS"}))});
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.READ_CONTACTS", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.contact, TypedValues.Custom.S_STRING, "contact"))), TuplesKt.to("android.permission.READ_CALL_LOG", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.call_history, TypedValues.Custom.S_STRING, "call_history")))});
    }

    private f() {
    }

    private final boolean a(QuAction r3) {
        if (Intrinsics.areEqual(r3.getActionName(), "SearchCallHistory") == false) goto L13;
        Map<String, ParamItem> r2 = r3.getInputParams();
        if (r2 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L13;
        return true;
    L7:
        if (r2.containsKey("contactName") != true) goto L9;
        r4 = true;
    L13:
        return false;
    }

    private final boolean b(String r9) {
        JsonObject r8 = ab.a(u.a(new InAppSearchRequest(r9, 0, false, false, 0, 30, null)));
        TaskRequest.Builder r10 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("in_app_search_call_history").setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setForegroundCallerPkg(AppInfo.OAssistant.getPackageName()), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        JSONObject r1 = new JSONObject();
        r1.put("search_params", u.a(r8));
        r1.put("search_type", SearchType.IN_APP.getValue());
        r1.put("is_permission_check", true);
        TaskResult r11 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r10.setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r11.getCode() != 0) goto L6;
        boolean r12 = r11.getOutput().optBoolean("is_query_related_to_contact");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainPermissionCheck", "in_app_search_call_history success, isRelatedToContact: " + r12, false, 4, null);
        return r12;
    L6:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainPermissionCheck", "in_app_search_call_history failed, error code: " + r11.getCode() + ", error message: " + r11.getMsg(), null, 4, null);
        return false;
    }

    public final MemoryResponse<PermissionCheckResult> a(String r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "pcSearchIntent");
        Intrinsics.checkNotNullParameter(r25, "quResultJson");
        MemoryResponse<PermissionCheckResult> r9 = new MemoryResponse(0, null, null, 7, null);
        f12180b = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(ak.f13164a.g(AppInfo.OAssistant.getPackageName()), Iterable.class, "com.obric.memorydata.plugin"));
        List r11 = null;
        switch(r24.hashCode()) {
            case -1780906473: goto L65;
            case -1236136487: goto L49;
            case -713435600: goto L11;
            case 1567240980: goto L6;
            default: goto L94;
        };
    L94:
        List r0 = CollectionsKt.emptyList();
    L95:
        if (r0 == null) goto L97;
        r11 = CollectionsKt.minus((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(f12180b, Iterable.class, "com.obric.memorydata.plugin"));
    L97:
        if (r11 != null) goto L99;
    L101:
        boolean r1 = false;
    L102:
        if (r1 == false) goto L122;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L105:
        if (r4.hasNext() == false) goto L112;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        Map<String, String> r6 = e;
        if (r6.containsKey(r5) == false) goto L109;
        r5 = (String) ZeusTransformUtils.preCheckCast(r6.get(r5), String.class, "com.obric.memorydata.plugin");
    L110:
        if (r5 == null) goto L105;
        r3.add(r5);
        goto L105
    L109:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainPermissionCheck", "permission toString not found, permission: " + r5, null, 4, null);
        goto L110
    L112:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        String r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.and, TypedValues.Custom.S_STRING, "and"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        if (r7.size() <= 2) goto L120;
        String r10 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.dropLast(r7, 2), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r12 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.takeLast(r7, 2), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L117;
        boolean r13 = true;
    L118:
        if (r13 == false) goto L121;
        r12 = r10 + ", " + r12;
    L121:
        String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.need_permission_place_holder, TypedValues.Custom.S_STRING, "need_permission_place_holder"), new Object[]{r12});
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        r9.setData(new PermissionCheckResult(r11, r14));
    L123:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DomainPermissionCheck", "DomainPermissionCheck finished, pcSearchIntent: " + r24 + ", missedPermissionList: " + r11, false, 4, null);
        return r9;
    L117:
        r13 = false;
        goto L118
    L120:
        r12 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        goto L121
    L122:
        r9.setData(new PermissionCheckResult(CollectionsKt.emptyList(), ""));
        goto L123
    L99:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L101;
        r1 = true;
        goto L102
    L6:
        if (r24.equals("Contacts_Search") == false) goto L94;
        List<String> r15 = d.get("Contact");
    L9:
        r0 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        goto L95
    L11:
        if (r24.equals("PC_SearchAppEntity") == false) goto L94;
        Object r16 = u.a().fromJson(r25, AssistantQuResult.class);     // Catch: Exception -> L15
    L17:
        AssistantQuResult r17 = (AssistantQuResult) ZeusTransformUtils.preCheckCast(r16, AssistantQuResult.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L46;
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r17.getActions(), Collection.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L22;
    L25:
        boolean r19 = true;
    L26:
        if (r19 == true) goto L46;
        List<QuAction> r20 = r17.getActions();
        if (r20 == null) goto L93;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L32:
        if (r23.hasNext() == false) goto L43;
        QuAction r26 = (QuAction) ZeusTransformUtils.preCheckCast(r23.next(), QuAction.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r26.getActionName(), "SearchCallHistory") == true) goto L36;
    L40:
        List r27 = (List) ZeusTransformUtils.preCheckCast(c.get(r26.getActionName()), List.class, "com.obric.memorydata.plugin");
    L41:
        if (r27 == null) goto L32;
        r22.add(r27);
        goto L32
    L36:
        if (f12180b.contains("android.permission.READ_CONTACTS") == true) goto L40;
        if (f12179a.a(r26) == true) goto L40;
        r27 = CollectionsKt.listOf("android.permission.READ_CALL_LOG");
        goto L41
    L43:
        List r28 = CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r28 == null) goto L93;
    L92:
        r0 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin"));
    L93:
        r0 = null;
        goto L95
    L22:
        if (r18.isEmpty() == true) goto L25;
        r19 = false;
    L46:
        r9.setCode(400);
        r9.setMessage("PC_SearchAppEntity quResultJson error: " + r25);
        return r9;
    L15:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r25 + " toObj error : " + e, null, 4, null);
        r16 = null;
        goto L17
    L49:
        if (r24.equals("Phone_Search") == false) goto L94;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L54;
        boolean r29 = true;
    L55:
        if (r29 == false) goto L59;
        r9.setCode(400);
        r9.setMessage("Contacts_Search query is empty");
        return r9;
    L59:
        if (f12180b.contains("android.permission.READ_CONTACTS") == false) goto L61;
    L63:
        r15 = d.get("CallHistory");
        goto L9
    L61:
        if (b(r25) == true) goto L63;
        r0 = CollectionsKt.listOf("android.permission.READ_CALL_LOG");
        goto L95
    L54:
        r29 = false;
        goto L55
    L65:
        if (r24.equals("PC_GlobalSearch") == false) goto L94;
        Object r30 = u.a().fromJson(r25, GlobalQUResult.class);     // Catch: Exception -> L69
    L71:
        GlobalQUResult r31 = (GlobalQUResult) ZeusTransformUtils.preCheckCast(r30, GlobalQUResult.class, "com.obric.memorydata.plugin");
        if (r31 != null) goto L75;
        r9.setCode(400);
        r9.setMessage("PC_GlobalSearch quResultJson error: " + r25);
        return r9;
    L75:
        List<RewriteQuery> r32 = r31.getQuery_rewrite();
        if (r32 == null) goto L93;
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin");
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r35 = r33.iterator();
    L79:
        if (r35.hasNext() == false) goto L90;
        RewriteQuery r36 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r35.next(), RewriteQuery.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r36.getDomain(), "CallHistory") == true) goto L83;
    L87:
        List r37 = (List) ZeusTransformUtils.preCheckCast(d.get(r36.getDomain()), List.class, "com.obric.memorydata.plugin");
    L88:
        if (r37 == null) goto L79;
        r34.add(r37);
        goto L79
    L83:
        if (f12180b.contains("android.permission.READ_CONTACTS") == true) goto L87;
        if (f12179a.b(r36.getQuery()) == true) goto L87;
        r37 = CollectionsKt.listOf("android.permission.READ_CALL_LOG");
        goto L88
    L90:
        r28 = CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r28 == null) goto L93;
    L69:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r25 + " toObj error : " + e, null, 4, null);
        r30 = null;
        goto L71
    }

    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "domain");
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L5;
        return true;
    L5:
        List r4 = (List) ZeusTransformUtils.preCheckCast(d.get(r5), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L10;
    L12:
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L11;
        if (f12180b.contains((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L14;
        boolean r8 = false;
    L18:
        if (r8 == false) goto L20;
        return true;
    L11:
        r8 = true;
        goto L18
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
    L20:
        return false;
    }
}
