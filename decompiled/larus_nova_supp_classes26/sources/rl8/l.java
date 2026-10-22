package rl8;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.b0;
import com.larus.platform.service.i2;
import com.larus.platform.service.o;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.e1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends com.larus.chat.gallery.api.g<ty8.b> {
    public final ty8.a g;
    public final List<List<com.larus.bmhome.bigimg.l>> h;
    public final int i;
    public final Function1<Integer, Unit> j;
    public final HybridEventParams k;

    public static final class a {
    }

    static {
    }

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
        q0 r7 = this.g.e;
        if (r7 == null) goto L17;
        q0.a r8 = r7.getProvider();
        if (r8 == null) goto L17;
        y r9 = r8.u0();
        if (r9 == null) goto L17;
        wc9.e r10 = r9.h();
    L18:
        q0 r11 = this.g.e;
        if (r11 == null) goto L26;
        q0.a r12 = r11.getProvider();
        if (r12 == null) goto L26;
        y r13 = r12.u0();
        if (r13 == null) goto L26;
        r3 = r13.j0();
    L26:
        return new bb9.a(r4, r6, r10, r3);
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
        String r1 = null;
        if (r0 == null) goto L5;
        GalleryType r2 = r0.e;
    L7:
        if (r2 == GalleryType.Video) goto L21;
        ShareServiceDelegate r3 = ShareServiceDelegate.b;
        if (r0 == null) goto L13;
        JSONObject r4 = r0.f;
        if (r4 == null) goto L13;
        r4.put("click_method", MusicAppletPage.KEY_SOURCE);
    L14:
        r3.w(r4);
        ty8.b r5 = (ty8.b) ((t) this).d;
        if (r5 == null) goto L19;
        m1 r6 = r5.b;
        if (r6 == null) goto L19;
        r1 = r6.a;
    L19:
        H(this, String.valueOf(r1), true, MusicAppletPage.KEY_SOURCE, null, 8);
        return;
    L13:
        r4 = null;
        goto L14
    L21:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.chat.gallery.api.g
    public final View z() {
        boolean r2 = false;
        List r6 = CollectionsKt.mutableListOf(new l0[]{new l0(2131906512, 2131906512, null, null, null, 2131103298, null, 2131242074, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127), new l0(2131906511, 2131906511, null, null, null, 2131103298, null, 2131241236, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)});
        ty8.b r1 = (ty8.b) ((t) this).d;
        if (r1 == null) goto L9;
        ConcurrentHashMap<String, String> r3 = r1.j;
        if (r3 == null) goto L9;
        if (r3.containsKey("chat_gallery_data_source_url") != true) goto L9;
        r2 = true;
    L9:
        if (r2 == false) goto L11;
        r6.add(new l0(2131906360, 2131906360, null, null, null, 2131103298, null, Integer.valueOf(com.larus.bmhome.bigimg.f.a()), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
    L11:
        Context r4 = getContext();
        if (r4 != null) goto L15;
        r4 = AppHost.a.getApplication();
    L15:
        return CreateMenu.f(new CreateMenu(r4), r6, 0, true, null, null, null, null, new i(this), 502);
    }

    @Override // com.larus.chat.gallery.api.g
    public final void G() {
        FragmentActivity r0 = getContext();
        if (r0 == null) goto L119;
        ty8.b r1 = (ty8.b) ((t) this).d;
        final Function3 r2 = null;
        if (r1 == null) goto L7;
        GalleryType r3 = r1.e;
    L9:
        if (r3 == GalleryType.Video) goto L120;
        String r5 = "";
        if (r1 == null) goto L121;
        Message r6 = r1.a;
        if (r6 == null) goto L122;
        o r7 = o.a;
        JSONObject r4 = r1.f;
        if (r4 == null) goto L64;
        r4.put("click_method", "detail_click");
        r4.put("click_from", "click_download");
        Map r8 = r6.getExt();
        if (r8 == null) goto L19;
        String r9 = (String) r8.get("creativity_scene");
    L21:
        if (Intrinsics.areEqual(r9, CreativeScene.AVATAR_IMAGE) == false) goto L23;
        String r10 = "replica";
    L24:
        r4.put("is_replica_gen", r10);
        Map r11 = r6.getExt();
        if (r11 == null) goto L27;
        String r12 = (String) r11.get("creativity_scene");
    L28:
        r4.put("is_image_edit", Intrinsics.areEqual(r12, CreativeScene.AI_BEAUTIFY_IMAGE) ? 1 : 0);
        r4.put("download_method", "click_icon");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L37
        Map r14 = r6.getExt();     // Catch: Throwable -> L37
        if (r14 == null) goto L34;
        String r15 = (String) r14.get("bot_state");     // Catch: Throwable -> L37
        if (r15 == null) goto L34;
        String r16 = new JSONObject(r15).optString("agent_id", "");     // Catch: Throwable -> L37
    L35:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r17) == false) goto L42;
        r17 = null;
    L42:
        String r18 = (String) r17;
        if (r18 != null) goto L45;
        r18 = "";
    L45:
        r4.put("agent_id", r18);
        Map r19 = r6.getExt();     // Catch: Throwable -> L54
        if (r19 == null) goto L51;
        String r20 = (String) r19.get("fpa_common_param");     // Catch: Throwable -> L54
        if (r20 == null) goto L51;
        String r21 = new JSONObject(r20).optString("agent_tool", "");     // Catch: Throwable -> L54
    L52:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L54
    L57:
        if (Result.isFailure-impl(r22) == false) goto L59;
        r22 = null;
    L59:
        String r23 = (String) r22;
        if (r23 == null) goto L63;
        r5 = r23;
    L63:
        r4.put("agent_tool", r5);
        Unit r24 = Unit.INSTANCE;
    L65:
        r7.reportEvent("picture_download", r4);
        ty8.b r25 = (ty8.b) ((t) this).d;
        if (r25 == null) goto L70;
        m1 r26 = r25.b;
        if (r26 == null) goto L70;
        String r27 = r26.c;
    L72:
        if (r27 == null) goto L92;
        if (r25 == null) goto L77;
        m1 r28 = r25.b;
        if (r28 == null) goto L77;
        String r29 = r28.a;
    L78:
        if (r25 == null) goto L82;
        m1 r30 = r25.b;
        if (r30 == null) goto L82;
        String r31 = r30.c;
    L84:
        if (Intrinsics.areEqual(r29, r31) == true) goto L92;
        ty8.b r32 = (ty8.b) ((t) this).d;
        if (r32 == null) goto L99;
        m1 r33 = r32.b;
        if (r33 == null) goto L99;
        String r34 = r33.c;
        if (r34 == null) goto L99;
        Uri r35 = b0.a(r34, "send.photo_dialog_download", false, false, 6);
    L100:
        if (r35 == null) goto L124;
        final String r36 = r35.toString();
        if (Build.VERSION.SDK_INT <= 29) goto L105;
    L113:
        H(this, r36, false, null, null, 4);
        return;
    L105:
        if (ContextCompat.checkSelfPermission(r0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L113;
        if ((r0 instanceof FragmentActivity) == false) goto L109;
        FragmentActivity r37 = r0;
    L110:
        if (r37 == null) goto L125;
        i2.b.a(r37, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new k(this, r36, r2));
        return;
    L125:
        return;
    L109:
        r37 = null;
        goto L110
    L124:
        return;
    L99:
        r35 = null;
    L82:
        r31 = null;
    L77:
        r29 = null;
    L92:
        ty8.b r38 = (ty8.b) ((t) this).d;
        if (r38 == null) goto L99;
        m1 r39 = r38.b;
        if (r39 == null) goto L99;
        String r40 = r39.a;
        if (r40 == null) goto L99;
        r35 = b0.a(r40, "send.photo_dialog_download", false, false, 6);
    L70:
        r27 = null;
    L51:
        r21 = null;
    L54:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        r16 = null;
    L37:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L27:
        r12 = null;
        goto L28
    L23:
        r10 = ReeditType.IMAGE;
        goto L24
    L19:
        r9 = null;
        goto L21
    L64:
        r4 = null;
        goto L65
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.larus.chat.gallery.api.g
    public final View p(ViewGroup r3) {
        View r4 = super.p(r3);
        LarusGalleryChatTitleBinding r0 = this.f;
        if (r0 == null) goto L7;
        ImageView r1 = r0.c;
        if (r1 == null) goto L7;
        e1.x(r1);
    L7:
        LarusGalleryChatTitleBinding r2 = this.f;
        if (r2 == null) goto L12;
        ConstraintLayout r5 = r2.e;
        if (r5 == null) goto L12;
        r5.setOnClickListener(null);
    L12:
        return r4;
    }

    public final void x(p r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof p.e) == false) goto L6;
        F();
        return;
    }

    @Override // com.larus.chat.gallery.api.g
    public final void w(ty8.b r6, int r7) {
        ty8.b r8 = r6;
        Intrinsics.checkNotNullParameter(r8, "data");
        super.w(r8, r7);
        int r9 = this.h.size();
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L8;
        if (r7 < ((List) ListProtector.get(this.h, r1)).size()) goto L10;
        r7 = r7 - ((List) ListProtector.get(this.h, r1)).size();
        r1 = r1 + 1;
    L10:
        if ((!this.h.isEmpty()) == false) goto L12;
        int r10 = ((List) ListProtector.get(this.h, r1)).size();
    L13:
        int r2 = r7 + 1;
        LarusGalleryChatTitleBinding r3 = this.f;
        if (r3 == null) goto L21;
        TextView r4 = r3.g;
        if (r4 == null) goto L21;
        if (r10 <= 0) goto L19;
        String r11 = r2 + " / " + r10;
    L20:
        r4.setText(r11);
        goto L21
    L19:
        r11 = String.valueOf(r2);
    L21:
        int r12 = this.i;
        if (r1 != r12) goto L26;
        Function1<Integer, Unit> r13 = this.j;
        if (r13 == null) goto L36;
        r13.invoke(Integer.valueOf(r7));
        return;
    L36:
        return;
    L26:
        if (r1 <= r12) goto L30;
        Function1<Integer, Unit> r14 = this.j;
        if (r14 == null) goto L38;
        r14.invoke(Integer.valueOf(((List) ListProtector.get(this.h, r12)).size() - 1));
        return;
    L38:
        return;
    L30:
        Function1<Integer, Unit> r15 = this.j;
        if (r15 == null) goto L40;
        r15.invoke(0);
        return;
    L40:
        return;
    L12:
        r10 = 0;
        goto L13
    L8:
        r1 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(ty8.a r2, List<? extends List<com.larus.bmhome.bigimg.l>> r3, int r4, Function1<? super Integer, Unit> r5, HybridEventParams r6) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        Intrinsics.checkNotNullParameter(r3, "images");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
    }

    public static void H(final l r17, String r18, boolean r19, String r20, Function3 r21, int r22) {
        if ((r22 & 2) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r22 & 4) == 0) goto L9;
        final String r1 = "detail_click";
    L11:
        if ((r22 & 8) == 0) goto L13;
        Function3 r6 = null;
    L14:
        r17.getClass();
        if (r0 == false) goto L17;
        ImageSave.z(ImageSave.a, r18, null, null, null, false, true, null, new h(r17, r1), 94);
        return;
    L17:
        ImageSave.x(ImageSave.a, r18, null, r6, null, false, 58);
        return;
    L13:
        r6 = r21;
        goto L14
    L9:
        r1 = r20;
        goto L11
    L5:
        r0 = r19;
        goto L7
    }
}
