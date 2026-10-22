package com.larus.drive.biz.impl.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceAskDoubaoItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceAskDoubaoRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.sdk.api.IDriveSdkServiceV2;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.model.OfficeAskDoubaoType;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wa8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveOfficeSpaceHelper {
    public static final Set<Integer> a = null;

    static {
        a = SetsKt.setOf(new Integer[]{12, 22, 3, 30, 8});
    }

    public static boolean c(OfficeSpaceAskDoubaoItem r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        if (r10.isFolder() == false) goto L5;
        return false;
    L5:
        if (StringsKt.isBlank(r10.getToken()) == false) goto L8;
        return false;
    L8:
        if (AppHost.a.isOversea() == false) goto L20;
        IActionBarService r0 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r0 == null) goto L17;
        Integer r1 = r0.a();
        int r3 = t0.a.getDeprecatedItemId();
        if (r1 == null) goto L17;
        if (r1.intValue() != r3) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        return false;
    L17:
        r2 = false;
    L20:
        Integer r4 = d(r10);
        if (r4 == null) goto L73;
        int r5 = r4.intValue();
        if (r5 != 8) goto L29;
        if (r10.getBaseBizType() != 1) goto L29;
        FLogger.a.i("DriveOfficeSpaceHelper", "hide ask doubao because item is base app, objType=" + r5 + ", baseBizType=" + r10.getBaseBizType());
        return false;
    L29:
        if (r5 == 3) goto L44;
        if (r5 != 8) goto L32;
        OfficeAskDoubaoType r6 = OfficeAskDoubaoType.BITABLE;
    L45:
        if (r6 != null) goto L47;
        return false;
    L47:
        z2 r7 = z2.a;
        if (r7.getLarkDriveConfigV2().f(r6) == true) goto L51;
        FLogger.a.i("DriveOfficeSpaceHelper", "hide ask doubao because type is disabled, askDoubaoType=" + r6);
        return false;
    L51:
        if (r5 == 12) goto L53;
        return true;
    L53:
        DriveFileItem r11 = e(r10);
        if (UploadFilePolicy.e(r11.d(false)) == false) goto L74;
        long r8 = r11.e();
        if (r8 > 0) goto L58;
    L65:
        FLogger.a.i("DriveOfficeSpaceHelper", "skip ask doubao because file size is invalid, name=" + r11.a + ", size=" + r8 + ", fileType=" + r11.j);
    L66:
        boolean r9 = false;
    L67:
        if (r9 == true) goto L69;
        return false;
    L69:
        if (r11.b() == true) goto L76;
        return true;
    L76:
        return false;
    L58:
        if (UploadFilePolicy.f(r8) == false) goto L65;
        if (r11.j != DriveFileType.IMAGE) goto L64;
        ImFileUtil.a.getClass();
        if (r8 > Math.min(ImFileUtil.j(), r7.getLarkDriveConfig().h())) goto L66;
    L64:
        r9 = true;
        goto L67
    L74:
        return false;
    L32:
        if (r5 != 22) goto L34;
        r6 = OfficeAskDoubaoType.DOC;
        goto L45
    L34:
        if (r5 != 30) goto L36;
        r6 = OfficeAskDoubaoType.PPT;
        goto L45
    L36:
        if (r5 == 11) goto L40;
        if (r5 == 12) goto L39;
        r6 = null;
        goto L45
    L39:
        r6 = OfficeAskDoubaoType.FILE;
        goto L45
    L40:
        r6 = OfficeAskDoubaoType.MINDNOTE;
        goto L45
    L44:
        r6 = OfficeAskDoubaoType.SHEET;
        goto L45
    L73:
        return false;
    }

    public static Integer d(OfficeSpaceAskDoubaoItem r4) {
        Integer r0 = r4.getRealType();
        Set<Integer> r1 = a;
        if (CollectionsKt.contains(r1, r0) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L11;
        Integer r5 = Integer.valueOf(r4.getObjType());
        if (r1.contains(Integer.valueOf(r5.intValue())) == true) goto L13;
        return null;
    L13:
        return r5;
    L11:
        return r0;
    }

    public static DriveFileItem e(OfficeSpaceAskDoubaoItem r17) {
        String r0 = r17.getTitle();
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (StringsKt.isBlank(r0) == false) goto L8;
        r0 = r17.getToken();
    L8:
        String r3 = r0;
        Integer r2 = d(r17);
        if (r2 == null) goto L11;
        int r4 = r2.intValue();
    L12:
        int r6 = r4;
        String r5 = r17.getFileExt();
        if (r6 != 0) goto L15;
        DriveFileType r7 = DriveFileType.FOLDER;
    L51:
        DriveFileType r14 = r7;
        String r8 = r17.getToken();
        String r9 = r17.getToken();
        String r10 = r17.getUrl();
        if (r10 == null) goto L55;
        r1 = r10;
    L55:
        int r12 = r14.getIconResId();
        LinkedHashMap r11 = r17.getExtra();
        if ((true ^ r11.isEmpty()) == true) goto L59;
        r11 = null;
    L59:
        if (r11 != null) goto L75;
        String r16 = null;
    L74:
        return new DriveFileItem(r3, r8, r9, r6, r1, 0, 0, r12, "", r14, 0, r16);
    L75:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L62
        Object r15 = Result.constructor-impl(new JSONObject(r11).toString());     // Catch: Throwable -> L62
    L65:
        if (Result.exceptionOrNull-impl(r15) == null) goto L68;
        FLogger.a.i("DriveOfficeSpaceHelper", "parse ask doubao extra failed, token=" + r17.getToken());
    L68:
        if (Result.isFailure-impl(r15) == false) goto L70;
        Object r18 = null;
    L71:
        r16 = (String) r18;
        goto L74
    L70:
        r18 = r15;
    L62:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L15:
        if (r6 != 8) goto L17;
        r7 = DriveFileType.BITABLE;
        goto L51
    L17:
        if (r6 != 12) goto L19;
        DriveFileType.a r21 = DriveFileType.Companion;
        if (r5 != null) goto L32;
    L42:
        String r22 = null;
    L43:
        if (r22 != null) goto L45;
    L47:
        String r23 = r3;
    L48:
        r21.getClass();
        r7 = DriveFileType.a.b(r23);
        goto L51
    L45:
        if (StringsKt.endsWith(r3, r22, true) == true) goto L47;
        r23 = r3 + r22;
        goto L48
    L32:
        if ((!StringsKt.isBlank(r5)) == true) goto L35;
        r5 = null;
    L35:
        if (r5 == null) goto L42;
        if (StringsKt.startsWith$default(r5, ".", false, 2, null) == true) goto L40;
        r5 = ".".concat(r5);
    L40:
        if (r5 == null) goto L42;
        r22 = r5.toLowerCase(Locale.ROOT);
        goto L43
    L19:
        if (r6 != 22) goto L21;
    L28:
        r7 = DriveFileType.AI_DOC;
        goto L51
    L21:
        if (r6 == 30) goto L27;
        if (r6 == 2) goto L28;
        if (r6 == 3) goto L26;
        r7 = DriveFileType.UNKNOWN;
        goto L51
    L26:
        r7 = DriveFileType.AI_SHEET;
        goto L51
    L27:
        r7 = DriveFileType.AI_SLIDES;
        goto L51
    L11:
        r4 = r17.getObjType();
        goto L12
    }

    public static OfficeSpaceActionResult a(final Fragment r5, OfficeSpaceAskDoubaoRequest r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "request");
        final Context r1 = r5.getContext();
        if (r1 != null) goto L5;
    L21:
        FLogger.a.i("DriveOfficeSpaceHelper", "skip ask doubao because fragment context or view is null");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L5:
        if (r5.getView() == null) goto L21;
        OfficeSpaceAskDoubaoItem r3 = r6.getCurrent();
        if (r3.isFolder() == false) goto L12;
        FLogger.a.i("DriveOfficeSpaceHelper", "skip ask doubao because item is folder");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L12:
        if (StringsKt.isBlank(r3.getToken()) == false) goto L15;
        FLogger.a.i("DriveOfficeSpaceHelper", "skip ask doubao because token is blank");
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L15:
        Intrinsics.checkNotNullParameter(r6, "request");
        if (c(r6.getCurrent()) == true) goto L19;
        FLogger.a.i("DriveOfficeSpaceHelper", "skip ask doubao because item is not allowed");
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L19:
        final DriveFileItem r7 = e(r3);
        DriveSdkService.a.C(r7, LifecycleOwnerKt.getLifecycleScope(r5.getViewLifecycleOwner()), new g(r7, r5, r1), new h(r1));
        return OfficeSpaceActionResult.Handled.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.larus.drive.biz.impl.utils.i] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.larus.drive.biz.impl.utils.j] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static OfficeSpaceActionResult b(final Fragment r22, final String r23, final int r24, OfficeSpaceHeaderEventSource r25, final Function1 r26) {
        Intrinsics.checkNotNullParameter(r22, "fragment");
        Intrinsics.checkNotNullParameter(r25, "source");
        final long r1 = System.currentTimeMillis();
        Context r16 = r22.getContext();
        if (r16 != null) goto L5;
    L13:
        FLogger.a.i("DriveOfficeSpaceHelper", "skip create document because fragment context or view is null, type=" + r24);
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L5:
        if (r22.getView() == null) goto L13;
        FLogger r0 = FLogger.a;
        r0.i("DriveOfficeSpaceHelper", "[OfficeCreatePerf] stage=helper_create_start type=" + r24 + " parent=" + r23 + " tab=" + r25.getCurrentTab().name() + " ts=" + r1);
        AtomicLong r8 = h79.b.a;
        final long r13 = h79.b.b(r22.getActivity(), r22, r22.getString(2131905382));
        if (IDriveSdkServiceV2.a.d(r16, r23, r24, r25, new i(r13, r24, r23, r1, r26), new j(r24, r23, r1, r13, r22)) != null) goto L10;
        h79.b.a(r13, null);
        OfficeSpaceActionResult.NotHandled r2 = OfficeSpaceActionResult.NotHandled.INSTANCE;
    L11:
        r0.i("DriveOfficeSpaceHelper", "[OfficeCreatePerf] stage=helper_create_request_registered type=" + r24 + " parent=" + r23 + " result=" + r2 + " elapsed=" + (System.currentTimeMillis() - r1));
        return r2;
    L10:
        r2 = OfficeSpaceActionResult.Handled.INSTANCE;
        goto L11
    }
}
