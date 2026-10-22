package com.larus.doc.impl.operation;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.doc.api.data.DeleteRequest;
import com.larus.doc.impl.DocumentApi;
import com.larus.doc.impl.download.DownloadTypeChooseDialog;
import com.larus.doc.sdk.api.IDocPermissionService;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.doc.sdk.api.model.MinutesInfoModel;
import com.larus.network.bean.BizResponse;
import com.larus.office.card.doc.content.OfficeCardDocContentServiceDelegate;
import com.larus.platform.api.IFlowOfficeThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocOpManager {
    public static final DocOpManager a = null;
    public static final MutableSharedFlow<Unit> b = null;
    public static final HashMap<String, Boolean> c = null;

    public static final class a implements n39.q {
        public final /* synthetic */ kotlinx.coroutines.i<dm9.a<? extends Object>> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        @Override // n39.q
        public final void onSuccess() {
            if (this.a.isActive() == false) goto L6;
            DocOpManager.c.put(this.b, Boolean.valueOf(this.c));
            kotlinx.coroutines.i<dm9.a<? extends Object>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new dm9.a.b(new BizResponse(0, null, null, null, 15, null), null)));
            return;
        }

        @Override // n39.q
        public final void onError(int r4, Throwable r5) {
            if (this.a.isActive() == false) goto L11;
            kotlinx.coroutines.i<dm9.a<? extends Object>> r0 = this.a;
            if (r5 == null) goto L8;
            String r2 = r5.getMessage();
            if (r2 == null) goto L8;
        L9:
            r0.resumeWith(Result.constructor-impl(new dm9.a.a(r4, r2, r5)));
            return;
        L8:
            r2 = "";
            goto L9
        }

        public a(kotlinx.coroutines.j r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public DocOpManager() {
    }

    static {
        a = new DocOpManager();
        b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        c = new HashMap();
    }

    public static Object f(String r6, Map r7, ContinuationImpl r8) {
        if (r7 == null) goto L5;
        Object r9 = r7.get("resource_type");
    L7:
        if (Intrinsics.areEqual(r9, Boxing.boxInt(10)) == false) goto L21;
        kotlinx.coroutines.j r10 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r8), 1);
        r10.C();
        FLogger r1 = FLogger.a;
        r1.i("DocOpManager", "getDocShareLink: " + r6 + " merge doc");
        IDocSdkServiceV2 r2 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r2 == null) goto L11;
        IDocPermissionService r3 = r2.getPermissionService();
    L12:
        if (r3 == null) goto L15;
        r3.getPermission(r6, new n(r10, r6));
    L17:
        Object r11 = r10.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L20:
        return r11;
    L15:
        if (r10.isActive() == false) goto L17;
        r1.i("DocOpManager", "getDocShareLink: " + r6 + " fail, service not found");
        Result.Companion r12 = Result.Companion;
        r10.resumeWith(Result.constructor-impl(new dm9.a.a(-1, "Service not found", null)));
        goto L17
    L11:
        r3 = null;
        goto L12
    L21:
        DocumentApi.a r13 = DocumentApi.a;
        DocOpManager$getDocShareLink$3 r4 = new DocOpManager$getDocShareLink$3(22, r6, null);
        r13.getClass();
        return DocumentApi.a.a(r4, r8);
    L5:
        r9 = null;
        goto L7
    }

    public static void l(String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "resourceId");
        FLogger r0 = FLogger.a;
        r0.i("DocOpManager", "[updateDocumentBrief] resourceId:" + r11 + " artifactVersionId:" + r12);
        if (r11.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        String r2 = p0.a(r12);
        if (r2 == null) goto L11;
        Long r3 = StringsKt.toLongOrNull(r2);
    L13:
        if (p0.a(r12) == null) goto L16;
        if (r3 != null) goto L16;
        r0.w("DocOpManager", "[updateDocumentBrief] invalid artifactVersionId, skip artifactVersionId in request, resourceId:" + r11 + " artifactVersionId:" + r12);
    L16:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DocOpManager$updateDocumentBrief$1(r11, r13, r3, null), 2, null);
        return;
    L11:
        r3 = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public final Object e(String r5, int r6, Continuation<? super com.larus.office.card.doc.content.a> r7) {
        if ((r7 instanceof DocOpManager$getDocContent$1) == false) goto L7;
        DocOpManager$getDocContent$1 r0 = (DocOpManager$getDocContent$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        com.larus.office.card.doc.content.a r9 = (com.larus.office.card.doc.content.a) r8;
        if (r9 != null) goto L21;
        return null;
    L21:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        int r10 = com.larus.office.card.doc.content.b.a;
        r0.label = 1;
        r8 = OfficeCardDocContentServiceDelegate.b.a(r5, r6, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new DocOpManager$getDocContent$1(this, r7);
        goto L8
    }

    public final Object g(String r5, Map<String, ? extends Object> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof DocOpManager$refreshDocPermission$1) == false) goto L7;
        DocOpManager$refreshDocPermission$1 r0 = (DocOpManager$refreshDocPermission$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == false) goto L23;
        p r10 = (p) r9.a.getData();
        if (r10 == null) goto L23;
        Boolean r11 = Boxing.boxBoolean(r10.b());
        c.put(r5, r11);
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;
        r0.label = 1;
        r8 = f(r5, r6, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new DocOpManager$refreshDocPermission$1(this, r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object b(DocOpManager r11, String r12, Map r13, Continuation r14) {
        r11.getClass();
        if ((r14 instanceof DocOpManager$getShareLink$1) == false) goto L7;
        DocOpManager$getShareLink$1 r0 = (DocOpManager$getShareLink$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r16 = (String) r0.L$1;
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        String r4 = r16;
    L51:
        dm9.a.b r17 = (dm9.a) r15;
        if ((r17 instanceof dm9.a.b) == true) goto L54;
    L56:
        FLogger.a.i("DocOpManager", "getShareLink: " + r12 + " set fail");
        return null;
    L54:
        if (r17.a.getCode() != 0) goto L56;
        c.put(r12, Boxing.boxBoolean(true));
        FLogger.a.i("DocOpManager", "getShareLink: " + r12 + " set success");
        return r4;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (Map) r0.L$1;
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        dm9.a.b r18 = (dm9.a) r15;
        boolean r8 = false;
        if ((r18 instanceof dm9.a.b) == false) goto L35;
        dm9.a.b r110 = r18;
        p r5 = (p) r110.a.getData();
        if (r5 == null) goto L24;
        String r6 = r5.a();
    L26:
        if (o0.d(r6) == false) goto L36;
        p r111 = (p) r110.a.getData();
        if (r111 != null) goto L30;
    L32:
        boolean r112 = false;
    L33:
        if (r112 == false) goto L36;
        c.put(r12, Boxing.boxBoolean(true));
        FLogger.a.i("DocOpManager", "getShareLink: " + r12 + " success");
    L58:
        return r6;
    L30:
        if (r111.b() != true) goto L32;
        r112 = true;
    L36:
        IFlowOfficeThemeConfigProvider r113 = (IFlowOfficeThemeConfigProvider) ServiceManager.get().getService(IFlowOfficeThemeConfigProvider.class);
        if (r113 != null) goto L39;
    L41:
        boolean r114 = false;
    L42:
        if (r13 == null) goto L44;
        r8 = Intrinsics.areEqual(r13.get("key_is_doc_owner"), Boxing.boxBoolean(false));
    L44:
        if (r8 == true) goto L58;
        if (r114 == true) goto L58;
        r0.L$0 = r12;
        r0.L$1 = r6;
        r0.label = 2;
        r15 = r11.i(r12, true, r13, r0);
        if (r15 == r2) goto L62;
        r4 = r6;
        goto L51
    L62:
        return r2;
    L39:
        if (r113.a(new com.larus.doc.impl.operation.a(), AdaptThemeFeatureKey.OFFICE_COPY_LINK_DIRECTLY) != true) goto L41;
        r114 = true;
        goto L42
    L24:
        r6 = null;
        goto L26
    L35:
        r6 = null;
        goto L36
    L16:
        ResultKt.throwOnFailure(r15);
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.label = 1;
        r15 = f(r12, r13, r0);
        if (r15 != r2) goto L19;
        return r2;
    L7:
        r0 = new DocOpManager$getShareLink$1(r11, r14);
        goto L8
    }

    public static void h(Context r7, LifecycleOwner r8, FragmentManager r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r9, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, "resourceId");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), null, null, new DocOpManager$reportDoc$1(r7, r10, r9, null), 3, null);
    }

    public final Object i(String r6, boolean r7, Map<String, ? extends Object> r8, Continuation<? super dm9.a<? extends Object>> r9) {
        if ((r9 instanceof DocOpManager$setDocPermission$1) == false) goto L7;
        DocOpManager$setDocPermission$1 r0 = (DocOpManager$setDocPermission$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r7 = r0.Z$0;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L40:
        dm9.a.b r11 = (dm9.a) r10;
        if ((r11 instanceof dm9.a.b) == true) goto L43;
    L45:
        return r11;
    L43:
        if (r11.a.getCode() != 0) goto L45;
        c.put(r6, Boxing.boxBoolean(r7));
        goto L45
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L36:
        return r10;
    L16:
        ResultKt.throwOnFailure(r10);
        if (r8 == null) goto L19;
        Object r13 = r8.get("resource_type");
    L21:
        if (Intrinsics.areEqual(r13, Boxing.boxInt(10)) == false) goto L37;
        r0.L$0 = r6;
        r0.Z$0 = r7;
        r0.label = 1;
        kotlinx.coroutines.j r14 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r14.C();
        IDocSdkServiceV2 r4 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r4 == null) goto L25;
        IDocPermissionService r5 = r4.getPermissionService();
    L26:
        if (r5 == null) goto L29;
        r5.updatePermission(r6, r7, new a(r14, r6, r7));
    L31:
        r10 = r14.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L34:
        if (r10 != r2) goto L36;
        return r2;
    L29:
        if (r14.isActive() == false) goto L31;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.constructor-impl(new dm9.a.a(-1, "Service not found", null)));
        goto L31
    L25:
        r5 = null;
        goto L26
    L37:
        DocumentApi.a r16 = DocumentApi.a;
        DocOpManager$setDocPermission$setResult$1 r17 = new DocOpManager$setDocPermission$setResult$1(r6, r7, null);
        r0.L$0 = r6;
        r0.Z$0 = r7;
        r0.label = 2;
        r16.getClass();
        r10 = DocumentApi.a.a(r17, r0);
        if (r10 != r2) goto L40;
        return r2;
    L19:
        r13 = null;
    L7:
        r0 = new DocOpManager$setDocPermission$1(this, r9);
        goto L8
    }

    public static final Object a(DocOpManager r10, Context r11, String r12, Map r13, Continuation r14) {
        r10.getClass();
        if ((r14 instanceof DocOpManager$deleteDocument$1) == false) goto L7;
        DocOpManager$deleteDocument$1 r0 = (DocOpManager$deleteDocument$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r15);
    L54:
        dm9.a.b r17 = (dm9.a) r15;
        if ((r17 instanceof dm9.a.b) == false) goto L60;
        if (r17.a.getCode() != 0) goto L60;
        FLogger.a.i("DocOpManager", "delete success v1: " + System.currentTimeMillis());
        return Boxing.boxInt(3);
    L60:
        return Boxing.boxInt(1);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r18 = r0.I$0;
        ResultKt.throwOnFailure(r15);
    L62:
        return Boxing.boxInt(r18);
    L18:
        l0 r110 = (l0) r0.L$1;
        String r111 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L46:
        int r112 = ((Number) r15).intValue();
        MainCoroutineDispatcher r113 = Dispatchers.getMain();
        DocOpManager$deleteDocument$2 r114 = new DocOpManager$deleteDocument$2(r110, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.I$0 = r112;
        r0.label = 3;
        if (BuildersKt.withContext(r113, r114, r0) == r16) goto L66;
        r18 = r112;
        goto L62
    L66:
        return r16;
    L19:
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L38:
        r110 = (l0) r15;
        r0.L$0 = r12;
        r0.L$1 = r110;
        r0.label = 2;
        kotlinx.coroutines.j r115 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r115.C();
        FLogger.a.i("DocOpManager", "delete begin v2: " + System.currentTimeMillis());
        IDocSdkServiceV2 r116 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r116 == null) goto L41;
        r116.deleteDoc(r12, new m(r115));
    L41:
        r15 = r115.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L44:
        if (r15 != r16) goto L46;
        return r16;
    L20:
        ResultKt.throwOnFailure(r15);
        if (r12 == null) goto L61;
        if (r13 == null) goto L25;
        Object r117 = r13.get("resource_type");
    L27:
        if ((r117 instanceof Integer) == false) goto L29;
        Integer r118 = (Integer) r117;
    L30:
        if (r118 == null) goto L32;
        int r119 = r118.intValue();
    L34:
        if (r119 != 10) goto L51;
        MainCoroutineDispatcher r120 = Dispatchers.getMain();
        DocOpManager$deleteDocument$loadingDialog$1 r121 = new DocOpManager$deleteDocument$loadingDialog$1(r11, null);
        r0.L$0 = r12;
        r0.label = 1;
        r15 = BuildersKt.withContext(r120, r121, r0);
        if (r15 != r16) goto L38;
        return r16;
    L51:
        DeleteRequest r122 = new DeleteRequest(CollectionsKt.listOf(r12), 2);
        FLogger.a.i("DocOpManager", "delete begin v1: " + System.currentTimeMillis());
        DocumentApi.a r123 = DocumentApi.a;
        DocOpManager$deleteDocument$result$2 r124 = new DocOpManager$deleteDocument$result$2(r122, null);
        r0.label = 4;
        r123.getClass();
        r15 = DocumentApi.a.a(r124, r0);
        if (r15 != r16) goto L54;
        return r16;
    L32:
        r119 = 3;
        goto L34
    L29:
        r118 = null;
        goto L30
    L25:
        r117 = null;
        goto L27
    L61:
        return Boxing.boxInt(1);
    L7:
        r0 = new DocOpManager$deleteDocument$1(r10, r14);
        goto L8
    }

    public static void m(MinutesInfoModel r11, final Fragment r12, final Function0 r13, final Function0 r14, final String r15) {
        final int r7 = 22;
        IDocSdkServiceV2 r0 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r0 == null) goto L5;
        IDocPermissionService r8 = r0.getPermissionService();
    L7:
        if (r8 != null) goto L10;
        FLogger.a.i("DocOpManager", "validateMinutesPermission: permissionService is null, fallback to granted");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new DocOpManager$validateMinutesPermission$1(r13, null), 3, null);
        return;
    L10:
        if (r11 != null) goto L18;
        FLogger r2 = FLogger.a;
        r2.w("DocOpManager", "validateMinutesPermission: minutesInfo is null, use fallback resourceId=" + r15 + ", docType=22");
        if (r15.length() <= 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        r8.validatePermission(r15, 22, "EXPORT", new h(r15, r7, r12, r13, r14));
        return;
    L17:
        r2.w("DocOpManager", "validateMinutesPermission: fallback resourceId is empty, fallback to granted");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new DocOpManager$validateMinutesPermission$2(r13, null), 3, null);
        return;
    L14:
        r3 = false;
        goto L15
    L18:
        final String r6 = r11.getMmToken();
        final int r9 = r11.getObjType();
        FLogger.a.i("DocOpManager", "validateMinutesPermission: mmToken=" + r6 + ", objtype=" + r9 + ", operation=EXPORT");
        r8.validatePermission(r6, r9, "EXPORT", new h(r6, r9, r12, r13, r14));
        return;
    L5:
        r8 = null;
        goto L7
    }

    public static final void c(Context r13, String r14, by7.e r15, FragmentActivity r16, int r17, String r18, String r110) {
        int r0 = com.larus.utils.i.d(AppHost.a.getApplication());
        int r9 = r0 - (((int) (((double) r0) * 0.1d)) * 2);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r16), null, null, new DocOpManager$showLongImageSharePanelInternal$1(r13, r15, r17, r18, r110, r14, r9, null), 3, null);
    }

    public static void k(Fragment r3, String r4, int r5, String r6, String r7, String r8, String r9, Map r10) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "resourceId");
        Intrinsics.checkNotNullParameter(r6, "showFrom");
        FLogger.a.i("DocOpManager", "[showDownloadFragment] resourceId:" + r4 + " from:" + r6);
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        s r1 = s.a;
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        r1.getClass();
        s.b(r2, 2131899540, false);
    L8:
        int r11 = com.larus.office.card.doc.download.i.a;
        com.larus.office.card.doc.download.i.a(r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void d(String r15, String r16, String r17, boolean r18, Context r110, String r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r15, "docId");
        Intrinsics.checkNotNullParameter(r16, "messageId");
        Intrinsics.checkNotNullParameter(r17, "conversationId");
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r20, "from");
        Intrinsics.checkNotNullParameter(r21, "currentPage");
        FLogger.a.i("DocOpManager", "[createDocByMessage] docId:" + r15 + " messageId:" + r16 + " current:" + r21 + ", from:" + r20);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new DocOpManager$createDocByMessage$1(r110, r15, r17, r18, r16, r20, r22, r23, r21, null), 3, null);
    }

    public static void j(final Fragment r13, final String r14, final String r15, final int r16, final String r17, final String r18, final Map r110, boolean r20, final MinutesInfoModel r21) {
        Intrinsics.checkNotNullParameter(r13, "fragment");
        Intrinsics.checkNotNullParameter(r15, "resourceId");
        Intrinsics.checkNotNullParameter("upper_right", "showFrom");
        FLogger.a.i("DocOpManager", "showAudioRecordDocDownloadFragment: hasAudio=" + r20);
        DownloadTypeChooseDialog r10 = new DownloadTypeChooseDialog();
        Bundle r1 = new Bundle();
        r1.putBoolean("arg_has_audio", r20);
        r10.setArguments(r1);
        r13.getChildFragmentManager().setFragmentResultListener("key_choose_result", r13, new c(r21, r13, r15, r16, r17, r18, r110, r14));
        FragmentManager r0 = r13.getChildFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "DownloadTypeChooseDialog", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r10, r2) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r10.show(r0, "DownloadTypeChooseDialog");
        return;
    }
}
