package zk8;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.bmhome.chat.cotdetail.preview.FileDownloadPreviewActivity;
import com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.utils.z2;
import com.larus.bmhome.video.bean.VideoType;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.model.office.AiFilePreviewScene;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.i2;
import com.larus.platform.service.p1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.h1;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements lc8.a {
    public final Fragment a;
    public final String b;
    public final AiFilePreviewScene c;
    public final by7.e d;
    public final List<String> e;

    public static final class a {
    }

    static {
    }

    public final void a(final Context r23, final FileCardVMData r24) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "data");
        String r8 = h1.b(r24.getType());
        if (r8 == null) goto L9;
        String r5 = r24.k();
        String r6 = r24.c();
        Map r0 = r24.j();
        if (r0 == null) goto L7;
        String r7 = (String) r0.get("chat_id");
    L8:
        by7.e r9 = this.d;
        Intrinsics.checkNotNullParameter(r8, "contentSecType");
        h1.a("general_agent_artifact_result_card_click", r5, r6, r7, r8, r9);
        goto L9
    L7:
        r7 = null;
    L9:
        Map r1 = r24.j();
        if (r1 == null) goto L12;
        String r2 = (String) r1.get("drive_uplink_info");
    L13:
        boolean r4 = false;
        if (r2 != null) goto L16;
    L19:
        boolean r10 = true;
    L20:
        if (r10 == true) goto L25;
        FlowDriveSdkService r11 = FlowDriveSdkService.a;
        String r12 = r24.c();
        String r13 = r24.b();
        r11.getClass();
        if (FlowDriveSdkService.B(r23, r2, r12, r13) == true) goto L104;
        c(r23, r24);
        return;
    L104:
        return;
    L25:
        String r3 = this.b;
        if (r3 != null) goto L28;
    L30:
        String r14 = null;
    L102:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L39
        Fragment r16 = this.a;     // Catch: Throwable -> L39
        if (r16 == null) goto L36;
        LifecycleOwner r17 = r16.getViewLifecycleOwner();     // Catch: Throwable -> L39
        if (r17 == null) goto L36;
        LifecycleCoroutineScope r18 = LifecycleOwnerKt.getLifecycleScope(r17);     // Catch: Throwable -> L39
    L37:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r19) == false) goto L44;
        r19 = null;
    L44:
        LifecycleCoroutineScope r20 = (LifecycleCoroutineScope) r19;
        if (r14 == null) goto L100;
        if (r20 == null) goto L100;
        int r21 = bq9.a.a;
        Map r22 = r24.j();
        if (r22 == null) goto L50;
        String r25 = (String) r22.get("originFileTypeString");
    L52:
        if (l1.k(r25) == true) goto L100;
        String r26 = r24.getType();
        String r27 = r24.e();
        if (r26 != null) goto L56;
        r26 = "";
    L56:
        String r28 = StringsKt.trim(r26).toString().toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r28, "image") == false) goto L59;
    L71:
        r4 = true;
    L72:
        if (r4 == true) goto L100;
        FlowDriveSdkService r29 = FlowDriveSdkService.a;
        AiFilePreviewScene r110 = this.c;
        String r111 = r24.e();
        String r112 = r24.getType();
        String r30 = r24.t();
        if (r30 != null) goto L77;
    L79:
        String r113 = null;
    L80:
        String r31 = r24.c();
        if (r31 != null) goto L83;
    L85:
        String r114 = null;
    L86:
        String r32 = r24.b();
        if (r32 != null) goto L89;
    L91:
        String r115 = null;
    L92:
        String r33 = r24.k();
        if (r33 != null) goto L95;
    L97:
        String r210 = null;
    L98:
        r29.j(r23, r20, new cr9.a(r14, r110, r111, r112, r113, null, r114, r115, r210, 32), new r(this, r23, r24));
        return;
    L95:
        if ((true ^ StringsKt.isBlank(r33)) == false) goto L97;
        r210 = r33;
        goto L98
    L89:
        if ((!StringsKt.isBlank(r32)) == false) goto L91;
        r115 = r32;
        goto L92
    L83:
        if ((!StringsKt.isBlank(r31)) == false) goto L85;
        r114 = r31;
        goto L86
    L77:
        if ((!StringsKt.isBlank(r30)) == false) goto L79;
        r113 = r30;
        goto L80
    L59:
        if (Intrinsics.areEqual(r28, "video") == true) goto L71;
        if (StringsKt.startsWith$default(r28, "image/", false, 2, null) == true) goto L71;
        if (StringsKt.startsWith$default(r28, "video/", false, 2, null) == true) goto L71;
        String r34 = StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(r28, '/', null, 2, null), '.', null, 2, null);
        h19.b.a.getClass();
        CommonFileIconType r35 = h19.b.d(r34);
        CommonFileIconType r36 = h19.b.c(r27);
        CommonFileIconType r37 = CommonFileIconType.IMAGE;
        if (r35 == r37) goto L71;
        CommonFileIconType r38 = CommonFileIconType.VIDEO;
        if (r35 == r38) goto L71;
        if (r36 == r37) goto L71;
        if (r36 != r38) goto L72;
    L50:
        r25 = null;
    L100:
        c(r23, r24);
        return;
    L36:
        r18 = null;
    L39:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L28:
        if ((!StringsKt.isBlank(r3)) == false) goto L30;
        r14 = r3;
        goto L102
    L16:
        if (StringsKt.isBlank(r2) == true) goto L19;
        r10 = false;
        goto L20
    L12:
        r2 = null;
        goto L13
    }

    public final void b(final Context r7, final FileCardVMData r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "data");
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L19;
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("action", "download");
        r1.put("entry", "file_block_card");
        r1.put("content_type", ShareType.FILE);
        Unit r4 = Unit.INSTANCE;
        r9.reportEvent("flow_enterprise_file_egress_block", r1);
        String r10 = r0.H0();
        if (r10 != null) goto L12;
        return;
    L12:
        if ((!StringsKt.isBlank(r10)) == true) goto L15;
        r10 = null;
    L15:
        String r2 = r10;
        if (r2 == null) goto L35;
        t19.s.j(t19.s.a, r7, r2, null, false, 28);
        return;
    L35:
        return;
    L19:
        final Fragment r5 = this.a;
        if (r5 != null) goto L22;
    L32:
        t19.s.a.getClass();
        t19.s.b(r7, 2131910881, false);
        return;
    L22:
        if (r5.isAdded() == false) goto L32;
        if (Build.VERSION.SDK_INT <= 28) goto L27;
    L30:
        d(r7, r8, r5);
        return;
    L27:
        if (ContextCompat.checkSelfPermission(r7, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L30;
        i2 r6 = i2.b;
        i2.q(r5, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new s(this, r7, r8, r5));
        return;
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void c(final Context r4, final FileCardVMData r5) {
        String r1 = "";
        if (p1.a.e() == true) goto L11;
        String r0 = r5.getType();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (this.e.contains(r0) == true) goto L11;
        Intent r2 = new Intent(r4, FileDownloadPreviewActivity.class);
        r2.putExtra("arg_file_data", r5);
        r4.startActivity(r2);
        return;
    L11:
        Keva r3 = z2.a;
        String r6 = r5.t();
        if (r6 == null) goto L15;
        r1 = r6;
    L15:
        z2.b(r1, new t(r4, r5));
    }

    public final void d(Context r6, FileCardVMData r7, Fragment r8) {
        FragmentManager r9 = r8.getChildFragmentManager();
        if (r9.isStateSaved() == false) goto L7;
        t19.s.a.getClass();
        t19.s.b(r6, 2131910881, false);
        return;
    L7:
        if (r9.findFragmentByTag("FileCardDownloadDialog") == null) goto L9;
        return;
    L9:
        int r0 = FileCardDownloadDialogFragment.j;
        String r1 = r7.t();
        String r2 = this.b;
        String r10 = r7.e();
        FileCardDownloadDialogFragment r3 = new FileCardDownloadDialogFragment();
        Bundle r4 = new Bundle();
        r4.putString(ShareType.FILE_URL, r1);
        r4.putString("resource_uri", r2);
        r4.putString("file_name", r10);
        r3.setArguments(r4);
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "FileCardDownloadDialog", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r3, r11) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r3.show(r9, "FileCardDownloadDialog");
        return;
    }

    public u(Fragment r2, String r3, AiFilePreviewScene r4, by7.e r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = CollectionsKt.listOf(new String[]{VideoType.MP4, "mp3", "jpg", "jpeg", "png"});
    }
}
