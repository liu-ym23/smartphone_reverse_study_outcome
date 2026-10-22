package od8;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.camera.command.e;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.canvas.service.bean.AlbumImage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedExt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.f;
import com.larus.utils.t0;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 implements com.larus.bmhome.chat.camera.command.d {
    public final e b;

    public final String a() {
        BotModel r0 = this.b.a();
        if (r0 == null) goto L6;
        String r1 = r0.getBotId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        e0 r2 = (e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L11;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L11;
        return r3.W();
    L11:
        return null;
    }

    public m0(e r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
    }

    public static String f(Uri r1) {
        if (Intrinsics.areEqual(r1.getScheme(), "file") == false) goto L5;
        return "shoot";
    L5:
        return "album";
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final void b(SuggestedAction r2) {
        this.b.b(r2);
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final Intent e(Uri r59) {
        Intrinsics.checkNotNullParameter(r59, "uri");
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        Activity r7 = (FragmentActivity) r1;
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        Pair<z0, Boolean> r2 = this.b.A7();
        if (r2 == null) goto L11;
        z0 r8 = (z0) r2.getFirst();
    L12:
        String r3 = f(r59);
        this.b.P8();
        if (r8 != null) goto L15;
        return null;
    L15:
        wc9.e r5 = this.b.O8();
        if (r5 == null) goto L18;
        String r21 = r5.a;
    L19:
        final ny9.b r4 = new ny9.b(false, r7, r8, new ChatParam(r21, a(), null, null, null, 252), false, false, null, null, null, null, null, null, null, null, null, null, null, r59.toString(), null, false, false, new l0("photo_preview_sug", r3), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -19005455, 262143);
        t0.e(new i0(r4));
        return null;
    L18:
        r21 = null;
        goto L19
    L11:
        r8 = null;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final Intent c(String r64, Uri r65) {
        Intrinsics.checkNotNullParameter(r64, "scene");
        Intrinsics.checkNotNullParameter(r65, "uri");
        Activity r3 = AppHost.a.a().getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L5;
        Activity r8 = (FragmentActivity) r3;
    L6:
        if (r8 != null) goto L8;
        return null;
    L8:
        String r4 = "click_camera_confirm_image_edit_button";
        if (z2.a.getCreationCanvasConfig().a() == false) goto L53;
        boolean r12 = false;
        AlbumImage r10 = new AlbumImage(r65, false, 6);
        Pair[] r11 = new Pair[5];
        r11[0] = TuplesKt.to("bot_id", a());
        BotModel r13 = this.b.a();
        if (r13 == null) goto L13;
        String r14 = r13.getChatType(AccountService.a.getUserId());
    L14:
        r11[1] = TuplesKt.to("chat_type", r14);
        r11[2] = TuplesKt.to("previous_page", "camera_confirm");
        if (Intrinsics.areEqual(r64, "from_icon") == true) goto L18;
        r4 = "photo_preview_sug";
    L18:
        r11[3] = TuplesKt.to("enter_method", r4);
        r11[4] = TuplesKt.to("content_source", f(r65));
        Bundle r1 = f.c(r11);
        wc9.e r2 = this.b.O8();
        if (r2 == null) goto L26;
        Integer r5 = r2.f;
        if (r5 == null) goto L26;
        if (r5.intValue() != 1) goto L26;
        boolean r6 = true;
    L28:
        if (r6 == false) goto L35;
        wc9.e r7 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r7 == null) goto L32;
        String r9 = r7.a;
    L33:
        if (r9 == null) goto L49;
    L50:
        String r15 = r9;
    L51:
        final ny8.e r16 = new ny8.e(r8, null, r10, r1, r15, 54);
        t0.e(new j0(r16));
        return null;
    L49:
        r15 = "";
        goto L51
    L32:
        r9 = null;
        goto L33
    L35:
        if (r2 == null) goto L37;
        r9 = r2.a;
    L38:
        if (r9 != null) goto L41;
        r9 = "";
    L41:
        if (r9.length() != 0) goto L43;
        r12 = true;
    L43:
        if (r12 == false) goto L50;
        wc9.e r17 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r17 == null) goto L47;
        r9 = r17.a;
    L48:
        if (r9 != null) goto L50;
    L47:
        r9 = null;
        goto L48
    L37:
        r9 = null;
    L26:
        r6 = false;
        goto L28
    L13:
        r14 = null;
        goto L14
    L53:
        Pair<z0, Boolean> r18 = this.b.N8();
        this.b.P8();
        if (r18 == null) goto L67;
        z0 r19 = (z0) r18.getFirst();
        if (r19 == null) goto L67;
        wc9.e r110 = this.b.O8();
        if (r110 == null) goto L61;
        String r111 = r110.a;
    L62:
        ChatParam r112 = new ChatParam(r111, a(), null, null, null, 252);
        String r59 = r65.toString();
        if (Intrinsics.areEqual(r64, "from_icon") == true) goto L66;
        r4 = "photo_preview_sug";
    L66:
        final ny9.b r113 = new ny9.b(false, r8, r19, r112, false, false, null, null, null, null, null, null, null, null, null, null, null, r59, null, false, false, new l0(r4, f(r65)), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -19005455, 262143);
        t0.e(new k0(r113));
        goto L67
    L61:
        r111 = null;
    L67:
        return null;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.camera.command.d
    public final void d(boolean r30, List<?> r31) {
        Intrinsics.checkNotNullParameter(r31, "data");
        Object r3 = CollectionsKt.getOrNull(r31, 0);
        String r5 = null;
        if ((r3 instanceof SuggestedAction) == false) goto L5;
        SuggestedAction r4 = (SuggestedAction) r3;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        Object r6 = CollectionsKt.getOrNull(r31, 1);
        if ((r6 instanceof Integer) == false) goto L11;
        Integer r7 = (Integer) r6;
    L12:
        if (r7 == null) goto L14;
        int r10 = r7.intValue();
    L15:
        Object r8 = CollectionsKt.getOrNull(r31, 2);
        if ((r8 instanceof Boolean) == false) goto L18;
        Boolean r9 = (Boolean) r8;
    L19:
        if (r9 == null) goto L21;
        boolean r11 = r9.booleanValue();
    L22:
        Object r2 = CollectionsKt.getOrNull(r31, 3);
        if ((r2 instanceof String) == false) goto L25;
        String r22 = (String) r2;
    L26:
        Object r1 = CollectionsKt.getOrNull(r31, 4);
        if ((r1 instanceof String) == false) goto L29;
        String r12 = (String) r1;
    L30:
        if (r12 != null) goto L32;
        r12 = "shoot_photo";
    L32:
        String r13 = r12;
        Pair<z0, Boolean> r14 = this.b.N8();
        ChatControlTrace r15 = ChatControlTrace.b;
        if (r15.gc(this.b.chatKey()) == null) goto L52;
        long r16 = this.b.chatKey();
        if (r14 == null) goto L43;
        z0 r17 = (z0) r14.getFirst();
        if (r17 == null) goto L43;
        com.larus.bmhome.actionbar.model.r r18 = r17.q;
        if (r18 == null) goto L43;
        Integer r19 = r18.a;
        if (r19 == null) goto L43;
        String r110 = r19.toString();
    L44:
        if (r14 == null) goto L50;
        z0 r20 = (z0) r14.getFirst();
        if (r20 == null) goto L50;
        com.larus.bmhome.actionbar.model.r r21 = r20.q;
        if (r21 == null) goto L50;
        String r23 = r21.g;
    L51:
        r15.b0(r30, r4, r16, "camera_confirm", r11, r13, 1, r10, 0, "shoot", "photo_preview_sug", 1, r110, r23, r22, null, null, new JSONObject());
        return;
    L50:
        r23 = null;
    L43:
        r110 = null;
        goto L44
    L52:
        if (r11 == false) goto L54;
        String r24 = "direct";
    L55:
        String r111 = r24;
        String r112 = String.valueOf(r10 + 1);
        BotModel r25 = this.b.a();
        if (r25 == null) goto L58;
        String r113 = r25.getChatType(AccountService.a.getUserId());
    L59:
        if (r30 == false) goto L65;
        SuggestedExt r26 = r4.getExt();
        if (r26 == null) goto L63;
        String r114 = r26.getDisplayNameStartlingKey();
    L64:
        t3.b("camera_confirm", r111, r13, r113, r114, "single_line", r112, "1", "shoot", 1, a(), r22, null, 12288);
    L71:
        if (Intrinsics.areEqual(r4.getSuggestedActionKey(), SuggestedActionKey.AIBeautify.getValue()) == false) goto L101;
        if (r14 == null) goto L81;
        z0 r27 = (z0) r14.getFirst();
        if (r27 == null) goto L81;
        com.larus.bmhome.actionbar.model.r r28 = r27.q;
        if (r28 == null) goto L81;
        Integer r29 = r28.a;
        if (r29 == null) goto L81;
        String r115 = r29.toString();
    L82:
        if (r14 == null) goto L88;
        z0 r32 = (z0) r14.getFirst();
        if (r32 == null) goto L88;
        com.larus.bmhome.actionbar.model.r r33 = r32.q;
        if (r33 == null) goto L88;
        String r116 = r33.g;
    L89:
        if (r30 == false) goto L94;
        hy9.d r34 = ICreationReportService.a.j();
        SuggestedExt r35 = r4.getExt();
        if (r35 == null) goto L93;
        r5 = r35.getDisplayNameStartlingKey();
    L93:
        hy9.d.a.b(r34, r5, null, null, "photo_preview_sug", "edit_entrance", null, "photo_preview_sug", r115, r116, "camera_confirm", null, null, null, null, null, null, null, null, 1047590);
        return;
    L94:
        hy9.d r36 = ICreationReportService.a.j();
        SuggestedExt r37 = r4.getExt();
        if (r37 == null) goto L97;
        r5 = r37.getDisplayNameStartlingKey();
    L97:
        hy9.d.a.a(r36, r5, null, null, "photo_preview_sug", "edit_entrance", null, "photo_preview_sug", r115, r116, "camera_confirm", null, null, null, null, null, null, null, null, null, null, null, 4193318);
        return;
    L88:
        r116 = null;
    L81:
        r115 = null;
        goto L82
    L101:
        return;
    L63:
        r114 = null;
        goto L64
    L65:
        SuggestedExt r38 = r4.getExt();
        if (r38 == null) goto L68;
        String r117 = r38.getDisplayNameStartlingKey();
    L69:
        t3.a("chat", r111, r13, r113, r117, "single_line", r112, "1", "shoot", 1, a(), r22, null, 12288);
        goto L71
    L68:
        r117 = null;
        goto L69
    L58:
        r113 = null;
        goto L59
    L54:
        r24 = "slide";
        goto L55
    L29:
        r12 = null;
        goto L30
    L25:
        r22 = null;
        goto L26
    L21:
        r11 = false;
        goto L22
    L18:
        r9 = null;
        goto L19
    L14:
        r10 = -1;
        goto L15
    L11:
        r7 = null;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
