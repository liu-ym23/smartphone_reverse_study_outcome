package e58;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import hq9.g1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ISettingRepoService r0 = RepoDispatcherDelegate.b.c();
        r5.put("uid", AccountService.a.getSecUserId());
        r5.put("did", o.a.getDeviceId());
        r5.put("app_version", String.valueOf(AppHost.a.getUpdateVersionCode()));
        r5.put("speech_language", r0.Q0());
        r5.put("asr_language", r0.S0());
        r5.put("model", r0.Z(r0.r0()));
        r5.put("os", "Android");
        r5.put("dumpRate", r0.B() ? 1 : 0);
        r5.put("send_mq", r0.B());
        ObricAsrDelegate r1 = ObricAsrDelegate.b;
        if (r1.q() == false) goto L14;
        g1 r2 = z2.a.getAsrCheckAudioConfig();
        boolean r3 = false;
        if (r2 == null) goto L7;
        int r4 = r2.a();
    L8:
        r5.put("check_audio_tag", r4);
        String r6 = r1.r();
        if (r6.length() <= 0) goto L11;
        r3 = true;
    L11:
        if (r3 == false) goto L15;
        boolean r7 = r1.j();
        r5.put("enable_update_nonstream_context", true);
        r5.put("personal_ctx", new JSONArray(r6));
        r5.put("update_nonstream_context_finish", r7);
        return;
    L15:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public static final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (AccountService.a.isEnterpriseAccount() == false) goto L6;
        r2.put("biz_type", "larkAt.Group");
        return;
    }

    public static final void c(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        AccountService r0 = AccountService.a;
        if (r0.isEnterpriseAccount() == false) goto L13;
        String r1 = r0.getTenantId();
        if (r1 != null) goto L7;
        return;
    L7:
        if (o0.d(r1) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L15;
        r2.put("tenant_id", r1);
        return;
    L15:
        return;
    }

    public static final void d(JSONObject r10, List<String> r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (z2.a.enableAsrWithImageQueryInfo() == true) goto L6;
        return;
    L6:
        if (r11 == null) goto L8;
        List r13 = CollectionsKt.toList(r11);
    L9:
        if (r12 == null) goto L11;
        List r14 = CollectionsKt.toList(r12);
    L12:
        List r1 = r13;
        boolean r2 = true;
        int r3 = 0;
        if (r1 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L28;
        List r5 = r14;
        if (r5 != null) goto L23;
    L26:
        if (r2 == false) goto L28;
        return;
    L23:
        if (r5.isEmpty() == true) goto L26;
        r2 = false;
    L28:
        if (r13 == null) goto L30;
        int r6 = r13.size();
    L31:
        if (r14 == null) goto L33;
        int r7 = r14.size();
    L34:
        int r8 = Math.max(r6, r7);
        if (r8 != 0) goto L37;
        return;
    L37:
        JSONArray r9 = new JSONArray();
    L38:
        if (r3 >= r8) goto L53;
        if (r3 >= r6) goto L42;
        if (r13 == null) goto L42;
        String r15 = (String) ListProtector.get(r13, r3);
    L43:
        if (r3 >= r7) goto L46;
        if (r14 == null) goto L46;
        String r16 = (String) ListProtector.get(r14, r3);
    L47:
        JSONObject r17 = new JSONObject();
        if (r16 == null) goto L50;
        r17.put("image_uri", r16);
    L50:
        if (r15 == null) goto L52;
        r17.put("image_url", r15);
    L52:
        r9.put(r17);
        r3 = r3 + 1;
    L46:
        r16 = null;
    L42:
        r15 = null;
        goto L43
    L53:
        r10.put("upload_data_list_info", r9);
        return;
    L33:
        r7 = 0;
        goto L34
    L30:
        r6 = 0;
        goto L31
    L15:
        if (r1.isEmpty() == true) goto L18;
        r4 = false;
        goto L19
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = null;
        goto L9
    }
}
