package com.obric.memorydata.personalcontext;

import android.content.Context;
import android.os.Build;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.model.BaseResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0014J&\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010*\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006."}, d2 = {"Lcom/obric/memorydata/personalcontext/EntitySecurity;", "", "<init>", "()V", "TAG", "", "ACTION_MESSAGE", "ACTION_CONTACT", "ACTION_CALL_HISTORY", "ACTION_PHOTO", "ACTION_ALBUM", "ACTION_PHOTO_FACE", "ACTION_NOTE", "ACTION_ALARM", "ACTION_RECORDING", "ACTION_BOOKMARK", "ACTION_SCHEDULE", "ACTION_COUNTDOWN", "ACTION_AUDITORY_RECORDING", "POLICY_OK", "", "AUTH_CATEGORY", "authPolicyManager", "Lcom/obric/aiagent/authentication/AuthPolicyManager;", "getAuthPolicyManager", "()Lcom/obric/aiagent/authentication/AuthPolicyManager;", "authPolicyManager$delegate", "Lkotlin/Lazy;", "authLicenseManager", "Lcom/obric/aiagent/authentication/license/AuthLicenseManager;", "getAuthLicenseManager", "()Lcom/obric/aiagent/authentication/license/AuthLicenseManager;", "authLicenseManager$delegate", "entityTypeActionsMap", "", "", "enableIndexEntityTypes", "", "getEnableIndexEntityTypes", "()Ljava/util/Set;", "check", "Lcom/obric/memorydata/model/BaseResponse;", "subject", "entityType", "checkPolicy", "actions", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12226b = null;
    private static final Lazy c = null;
    private static final Map<Integer, List<String>> d = null;
    private static final Set<Integer> e = null;

    static {
        f12225a = new j();
        f12226b = LazyKt.lazy($$Lambda$j$pxJUE7ruUw9G0g7aFqolXbKCBgU.INSTANCE);
        c = LazyKt.lazy($$Lambda$j$ng65809LEzDLNqNFnjEbUUIi6c.INSTANCE);
        Map<Integer, List<String>> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(201, CollectionsKt.listOf("Contact")), TuplesKt.to(101, CollectionsKt.listOf(new String[]{"Message", "Contact"})), TuplesKt.to(202, CollectionsKt.listOf(new String[]{"CallHistory", "Contact"})), TuplesKt.to(301, CollectionsKt.listOf(new String[]{"Photo", "Album", "PhotoFace"})), TuplesKt.to(303, CollectionsKt.listOf("PhotoFace")), TuplesKt.to(302, CollectionsKt.listOf("Album")), TuplesKt.to(601, CollectionsKt.listOf(com.tom_roush.pdfbox.pdmodel.a.d.i.H)), TuplesKt.to(701, CollectionsKt.listOf("Alarm")), TuplesKt.to(501, CollectionsKt.listOf("Recording")), TuplesKt.to(902, CollectionsKt.listOf("BrowserBookmark")), TuplesKt.to(401, CollectionsKt.listOf("Schedule")), TuplesKt.to(402, CollectionsKt.listOf("Schedule")), TuplesKt.to(702, CollectionsKt.listOf("Countdown")), TuplesKt.to(502, CollectionsKt.listOf("AuditoryRecording"))});
        d = r0;
        Set<Integer> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(Integer.valueOf(EntityType.DOUBAO_ACCOUNT));
        r2.add(402);
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r0.keySet(), Collection.class, "com.obric.memorydata.plugin"));
        r2.remove(401);
        e = r2;
    }

    private j() {
    }

    private final List<String> a(String r11, List<String> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
    L4:
        if (r13.hasNext() == false) goto L21;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        j r3 = f12225a;     // Catch: Throwable -> L22
        boolean r9 = true;
        if (r3.c().a(r11, "data_donate", r2) == true) goto L18;
        Object r4 = r3.a().a("data_donate", r11, AppContext.INSTANCE.getPackageName(), r2, null);     // Catch: Throwable -> L22
        if (Result.m1427isFailureimpl(r4) == false) goto L12;
        r4 = null;
    L12:
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r5 != null) goto L15;
    L17:
        r9 = false;
        goto L18
    L15:
        if (r5.intValue() != 0) goto L17;
    L18:
        if (r9 == false) goto L4;
        r1.add(r2);     // Catch: Throwable -> L22
        goto L4
    L21:
        return r1;
    L22:
        th = move-exception;
        RunLog.INSTANCE.error("EntitySecurity", "checkPolicy binder failed", th);
        return null;
    }

    private final com.obric.aiagent.authentication.license.a c() {
        return (com.obric.aiagent.authentication.license.a) ZeusTransformUtils.preCheckCast(c.getValue(), com.obric.aiagent.authentication.license.a.class, "com.obric.memorydata.plugin");
    }

    private static final com.obric.aiagent.authentication.a d() {
        com.obric.aiagent.authentication.a r0 = new com.obric.aiagent.authentication.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (com.obric.aiagent.authentication.b) ZeusTransformUtils.preCheckCast(defpackage.c.f115a, com.obric.aiagent.authentication.b.class, "com.obric.memorydata.plugin"));
        String r1 = DeviceInfoState.INSTANCE.getDeviceModel();
        if (Intrinsics.areEqual(Build.TAGS, "test-keys") == false) goto L20;
        int r3 = r1.hashCode();
        if (r3 == (-1048984789)) goto L17;
        if (r3 == 3440915) goto L13;
        if (r3 == 1328894480) goto L10;
    L18:
        String r4 = "security_policies/test-keys_authorized_apps.json";
    L36:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntitySecurity", "load " + r4 + ", product: " + r1, false, 4, null);
        r0.a(CollectionsKt.listOf("security_policies/data_donate.json"), r4);
        return r0;
    L10:
        if (r1.equals("nerida-lite") == false) goto L18;
    L19:
        r4 = "security_policies/test-keys_n1_authorized_apps.json";
        goto L36
    L13:
        if (r1.equals("pike") == false) goto L18;
        r4 = "security_policies/test-keys_pike_authorized_apps.json";
        goto L36
    L17:
        if (r1.equals("nerida") == true) goto L19;
    L20:
        int r5 = r1.hashCode();
        if (r5 == (-1048984789)) goto L33;
        if (r5 == 3440915) goto L29;
        if (r5 == 1328894480) goto L26;
    L34:
        r4 = "security_policies/release-keys_authorized_apps.json";
        goto L36
    L26:
        if (r1.equals("nerida-lite") == false) goto L34;
    L35:
        r4 = "security_policies/release-keys_n1_authorized_apps.json";
        goto L36
    L29:
        if (r1.equals("pike") == false) goto L34;
        r4 = "security_policies/release-keys_pike_authorized_apps.json";
        goto L36
    L33:
        if (r1.equals("nerida") == true) goto L35;
        goto L34
    }

    private static final com.obric.aiagent.authentication.license.a e() {
        return new com.obric.aiagent.authentication.license.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$ng65809-LEzDLNqNFnjEbUUIi6c, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.authentication.license.a m1082lambda$ng65809LEzDLNqNFnjEbUUIi6c() {
        return e();
    }

    public static /* synthetic */ com.obric.aiagent.authentication.a lambda$pxJUE7ruUw9G0g7aFqolXbKCBgU() {
        return d();
    }

    public final com.obric.aiagent.authentication.a a() {
        return (com.obric.aiagent.authentication.a) ZeusTransformUtils.preCheckCast(f12226b.getValue(), com.obric.aiagent.authentication.a.class, "com.obric.memorydata.plugin");
    }

    public final BaseResponse a(String r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "subject");
        if (Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), r19) == false) goto L7;
        return new BaseResponse(0, "success");
    L7:
        if (r20 == 1301) goto L11;
        if (r20 == 402) goto L11;
    L14:
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(d.get(Integer.valueOf(r20)), List.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
        List<String> r7 = a(r19, r2);
        if (r7 == null) goto L28;
        Set r3 = CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
        return new BaseResponse(111, r19 + " donate entity type " + r20 + " without permission of actions: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L33:
        return new BaseResponse(0, "success");
    L28:
        return new BaseResponse(501, "check policy failed");
    L24:
        return new BaseResponse(111, "unsupported permission for entity type " + r20);
    L17:
        if (r5.isEmpty() == true) goto L20;
        r6 = false;
    L11:
        if (Intrinsics.areEqual(r19, AppInfo.OAssistant.getPackageName()) == false) goto L14;
        return new BaseResponse(0, "success");
    }

    public final Set<Integer> b() {
        return e;
    }
}
