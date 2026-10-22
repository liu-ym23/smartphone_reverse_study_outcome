package com.larus.chat.gallery.impl.providers;

import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.utils.c4;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.api.w;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.b0;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.i2;
import com.larus.platform.service.o;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationShareService;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends com.larus.chat.gallery.api.g<ty8.b> implements j {
    public final ty8.a g;

    @Override // com.larus.chat.gallery.api.g
    public final String B() {
        ty8.b r0 = (ty8.b) ((t) this).d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i;
    }

    @Override // com.larus.chat.gallery.api.g
    public final bb9.a C() {
        Object r1 = ((t) this).d;
        ty8.b r2 = (ty8.b) r1;
        BotModel r3 = null;
        if (r2 == null) goto L5;
        Message r4 = r2.a;
    L6:
        ty8.b r5 = (ty8.b) r1;
        if (r5 == null) goto L9;
        String r6 = r5.i;
    L10:
        this.g.getClass();
        q0 r7 = this.g.e;
        if (r7 == null) goto L17;
        q0.a r8 = r7.getProvider();
        if (r8 == null) goto L17;
        y r9 = r8.u0();
        if (r9 == null) goto L17;
        wc9.e r10 = r9.h();
    L18:
        ty8.a r11 = this.g;
        BotModel r12 = r11.a;
        if (r12 != null) goto L27;
        q0 r13 = r11.e;
        if (r13 == null) goto L29;
        q0.a r14 = r13.getProvider();
        if (r14 == null) goto L29;
        y r15 = r14.u0();
        if (r15 == null) goto L29;
        r3 = r15.j0();
    L29:
        return new bb9.a(r4, r6, r10, r3);
    L27:
        r3 = r12;
    L17:
        r10 = null;
        goto L18
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.chat.gallery.api.g
    public final by7.e D() {
        return this.g.c;
    }

    @Override // com.larus.chat.gallery.api.g
    public final void F() {
        ty8.b r0 = (ty8.b) ((t) this).d;
        Message r1 = null;
        if (r0 == null) goto L5;
        GalleryType r2 = r0.e;
    L7:
        if (r2 != GalleryType.Video) goto L54;
        if (r0 == null) goto L10;
        c4 r11 = r0.g;
    L11:
        if (r11 == null) goto L13;
        wc9.e r13 = r11.e;
    L14:
        if (r11 == null) goto L16;
        BotModel r14 = r11.d;
    L17:
        if (r11 == null) goto L19;
        String r15 = r11.c;
    L20:
        LruCache<String, wc9.e> r3 = ko8.a.a;
        String r17 = ko8.a.e(ko8.a.e);
        if (r11 == null) goto L23;
        String r18 = r11.a;
    L24:
        if (r11 == null) goto L26;
        String r19 = r11.b;
    L27:
        if (r11 == null) goto L29;
        String r43 = r11.j;
    L30:
        if (r11 == null) goto L32;
        String r41 = r11.h;
    L33:
        if (r11 == null) goto L35;
        Boolean r44 = r11.k;
    L36:
        if (r11 == null) goto L38;
        Integer r42 = r11.i;
    L39:
        ty8.b r4 = (ty8.b) ((t) this).d;
        if (r4 == null) goto L42;
        Message r51 = r4.a;
    L43:
        com.larus.bmhome.share.panel.h r8 = new com.larus.bmhome.share.panel.h(r13, r14, r15, "video_detail", r17, r18, r19, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r41, r42, r43, r44, null, null, null, null, null, null, r51, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741572, -260, 1023);
        ICreationShareService.Companion r5 = ICreationShareService.a;
        CoroutineScope r9 = r();
        ty8.b r6 = (ty8.b) ((t) this).d;
        if (r6 == null) goto L46;
        nr9.g r10 = r6.c;
    L47:
        LarusGalleryChatTitleBinding r7 = this.f;
        if (r7 == null) goto L50;
        View r12 = r7.a;
    L51:
        if (r6 == null) goto L53;
        r1 = r6.a;
    L53:
        r5.o(new com.larus.uaigc.creation.f(r8, r9, r10, r11, r12, r1));
        return;
    L50:
        r12 = null;
        goto L51
    L46:
        r10 = null;
        goto L47
    L42:
        r51 = null;
        goto L43
    L38:
        r42 = null;
        goto L39
    L35:
        r44 = null;
        goto L36
    L32:
        r41 = null;
        goto L33
    L29:
        r43 = null;
        goto L30
    L26:
        r19 = null;
        goto L27
    L23:
        r18 = null;
        goto L24
    L19:
        r15 = null;
        goto L20
    L16:
        r14 = null;
        goto L17
    L13:
        r13 = null;
        goto L14
    L10:
        r11 = null;
        goto L11
    L54:
        ShareServiceDelegate r16 = ShareServiceDelegate.b;
        if (r0 == null) goto L59;
        JSONObject r20 = r0.f;
        if (r20 == null) goto L59;
        r20.put("click_method", MusicAppletPage.KEY_SOURCE);
    L60:
        r16.w(r20);
        ty8.b r21 = (ty8.b) ((t) this).d;
        if (r21 == null) goto L65;
        m1 r22 = r21.b;
        if (r22 == null) goto L65;
        r1 = r22.a;
    L65:
        H(this, String.valueOf(r1), true, MusicAppletPage.KEY_SOURCE, null, 8);
        return;
    L59:
        r20 = null;
        goto L60
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.chat.gallery.api.g
    public final void G() {
        final FragmentActivity r9 = getContext();
        if (r9 == null) goto L155;
        ty8.b r0 = (ty8.b) ((t) this).d;
        FragmentActivity r1 = null;
        if (r0 == null) goto L7;
        GalleryType r2 = r0.e;
    L9:
        if (r2 != GalleryType.Video) goto L37;
        IAIChatUgcAIGCService.Companion r8 = IAIChatUgcAIGCService.a;
        if (r0 == null) goto L13;
        nr9.g r10 = r0.c;
    L15:
        if (r0 == null) goto L19;
        c4 r3 = r0.g;
        if (r3 == null) goto L19;
        String r12 = r3.a;
    L20:
        if (r0 == null) goto L24;
        Message r4 = r0.a;
        if (r4 == null) goto L24;
        String r13 = r4.getMessageId();
    L25:
        ty8.b r5 = (ty8.b) ((t) this).d;
        if (r5 == null) goto L30;
        c4 r6 = r5.g;
        if (r6 == null) goto L30;
        String r14 = r6.c;
    L32:
        if (r5 == null) goto L36;
        c4 r7 = r5.g;
        if (r7 == null) goto L36;
        r1 = r7.g;
    L36:
        IAIChatUgcAIGCService.a.e(r8, r9, r10, new c4(r12, r13, r14, null, null, null, r1, null, null, null, null, null, null, null, 16312), "detail_click", r(), null, null, null, false, new b(this, r9), 2016);
        return;
    L30:
        r14 = null;
    L24:
        r13 = null;
    L19:
        r12 = null;
        goto L20
    L13:
        r10 = null;
        goto L15
    L37:
        String r11 = "";
        if (r0 == null) goto L157;
        Message r15 = r0.a;
        if (r15 == null) goto L158;
        ICreationMetadataService.Companion r16 = ICreationMetadataService.a;
        m1 r17 = r0.b;
        if (r17 == null) goto L44;
        String r18 = r17.f;
    L45:
        UserCreationFromIM r19 = r16.I(r15, r18, r0.h);
        if (r19 == null) goto L48;
        String r20 = r19.getCreationId();
    L49:
        final ChatTopBarProvider$downloadImage$1$checkBlock$1 r21 = new ChatTopBarProvider$downloadImage$1$checkBlock$1(r20, this, r15, null);
        o r110 = o.a;
        ty8.b r22 = (ty8.b) ((t) this).d;
        if (r22 == null) goto L101;
        JSONObject r111 = r22.f;
        if (r111 == null) goto L101;
        r111.put("click_method", "detail_click");
        r111.put("click_from", "click_download");
        Map r23 = r15.getExt();
        if (r23 == null) goto L56;
        String r24 = (String) r23.get("creativity_scene");
    L58:
        if (Intrinsics.areEqual(r24, CreativeScene.AVATAR_IMAGE) == false) goto L60;
        String r25 = "replica";
    L61:
        r111.put("is_replica_gen", r25);
        Map r26 = r15.getExt();
        if (r26 == null) goto L64;
        String r27 = (String) r26.get("creativity_scene");
    L65:
        r111.put("is_image_edit", Intrinsics.areEqual(r27, CreativeScene.AI_BEAUTIFY_IMAGE) ? 1 : 0);
        r111.put("download_method", "click_icon");
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L74
        Map r29 = r15.getExt();     // Catch: Throwable -> L74
        if (r29 == null) goto L71;
        String r30 = (String) r29.get("bot_state");     // Catch: Throwable -> L74
        if (r30 == null) goto L71;
        String r31 = new JSONObject(r30).optString("agent_id", "");     // Catch: Throwable -> L74
    L72:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L74
    L77:
        if (Result.isFailure-impl(r32) == false) goto L79;
        r32 = null;
    L79:
        String r33 = (String) r32;
        if (r33 != null) goto L82;
        r33 = "";
    L82:
        r111.put("agent_id", r33);
        Map r34 = r15.getExt();     // Catch: Throwable -> L91
        if (r34 == null) goto L88;
        String r35 = (String) r34.get("fpa_common_param");     // Catch: Throwable -> L91
        if (r35 == null) goto L88;
        String r36 = new JSONObject(r35).optString("agent_tool", "");     // Catch: Throwable -> L91
    L89:
        Object r37 = Result.constructor-impl(r36);     // Catch: Throwable -> L91
    L94:
        if (Result.isFailure-impl(r37) == false) goto L96;
        r37 = null;
    L96:
        String r38 = (String) r37;
        if (r38 == null) goto L100;
        r11 = r38;
    L100:
        r111.put("agent_tool", r11);
        r111.put("creation_id", r20);
        Unit r39 = Unit.INSTANCE;
    L102:
        r110.reportEvent("picture_download", r111);
        ty8.b r40 = (ty8.b) ((t) this).d;
        if (r40 == null) goto L107;
        m1 r41 = r40.b;
        if (r41 == null) goto L107;
        String r42 = r41.c;
    L109:
        if (r42 == null) goto L129;
        if (r40 == null) goto L114;
        m1 r43 = r40.b;
        if (r43 == null) goto L114;
        String r44 = r43.a;
    L115:
        if (r40 == null) goto L119;
        m1 r45 = r40.b;
        if (r45 == null) goto L119;
        String r46 = r45.c;
    L121:
        if (Intrinsics.areEqual(r44, r46) == true) goto L129;
        ty8.b r47 = (ty8.b) ((t) this).d;
        if (r47 == null) goto L136;
        m1 r48 = r47.b;
        if (r48 == null) goto L136;
        String r49 = r48.c;
        if (r49 == null) goto L136;
        Uri r50 = b0.a(r49, "send.photo_dialog_download", false, false, 6);
    L137:
        if (r50 == null) goto L160;
        final String r51 = r50.toString();
        if (Build.VERSION.SDK_INT <= 29) goto L142;
    L149:
        H(this, r51, false, null, r21, 4);
        return;
    L142:
        if (ContextCompat.checkSelfPermission(r9, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L149;
        if ((r9 instanceof FragmentActivity) == false) goto L146;
        r1 = r9;
    L146:
        if (r1 == null) goto L161;
        i2.b.a(r1, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new c(this, r51, r21));
        return;
    L161:
        return;
    L160:
        return;
    L136:
        r50 = null;
    L119:
        r46 = null;
    L114:
        r44 = null;
    L129:
        ty8.b r52 = (ty8.b) ((t) this).d;
        if (r52 == null) goto L136;
        m1 r53 = r52.b;
        if (r53 == null) goto L136;
        String r54 = r53.a;
        if (r54 == null) goto L136;
        r50 = b0.a(r54, "send.photo_dialog_download", false, false, 6);
    L107:
        r42 = null;
    L88:
        r36 = null;
    L91:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L71:
        r31 = null;
    L74:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L64:
        r27 = null;
        goto L65
    L60:
        r25 = ReeditType.IMAGE;
        goto L61
    L56:
        r24 = null;
    L101:
        r111 = null;
        goto L102
    L48:
        r20 = null;
        goto L49
    L44:
        r18 = null;
        goto L45
    L158:
        return;
    L157:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void t() {
        w r0 = ((t) this).e;
        if (r0 == null) goto L6;
        r0.Op(Reflection.getOrCreateKotlinClass(j.class), this);
        return;
    }

    @Override // com.larus.chat.gallery.impl.providers.j
    public final void a() {
        F();
    }

    public d(ty8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.g = r2;
    }

    public final void x(p r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof p.e) == false) goto L6;
        F();
        return;
    }

    @Override // com.larus.chat.gallery.api.g
    public final void w(ty8.b r2, int r3) {
        ty8.b r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "data");
        super.w(r4, r3);
    }

    public static void H(final d r18, String r19, boolean r20, String r21, Function1 r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r23 & 4) == 0) goto L9;
        final String r1 = "detail_click";
    L11:
        if ((r23 & 8) == 0) goto L13;
        Function1 r7 = null;
    L14:
        r18.getClass();
        if (r0 == false) goto L17;
        ImageSave.z(ImageSave.a, r19, null, null, null, false, true, null, new a(r18, r1), 94);
        return;
    L17:
        ImageSave.x(ImageSave.a, r19, null, null, r7, false, 54);
        return;
    L13:
        r7 = r22;
        goto L14
    L9:
        r1 = r21;
        goto L11
    L5:
        r0 = r20;
        goto L7
    }
}
