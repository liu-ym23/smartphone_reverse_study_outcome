package rl8;

import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.gallery.api.DisplayGravity;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.gallery.api.t;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.h0;
import com.larus.platform.service.z2;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new b());
    }

    public static void a(FragmentManager r24, ty8.a r25, List r26, PreviewScene r27, int r28, Function1 r29, JSONObject r30, HybridEventParams r31) {
        Intrinsics.checkNotNullParameter(r25, "galleryContext");
        Intrinsics.checkNotNullParameter(r26, "images");
        Intrinsics.checkNotNullParameter(r27, "scene");
        z2 r3 = z2.a;
        int r4 = r3.getCreationDetailLayoutConfig().c();
        q0 r5 = r25.e;
        if (r5 == null) goto L11;
        q0.a r6 = r5.getProvider();
        if (r6 == null) goto L11;
        y r7 = r6.u0();
        if (r7 == null) goto L11;
        wc9.e r8 = r7.h();
        if (r8 == null) goto L11;
        Integer r9 = r8.v;
    L12:
        IChatGalleryService.Companion r10 = IChatGalleryService.a;
        boolean r11 = false;
        if (r10.n(r27, false) == false) goto L15;
    L20:
        Message r12 = r25.b;
        if (r12 == null) goto L23;
        String r13 = r12.getConversationId();
    L24:
        r3.w3();
        if (com.larus.bmhome.utils.i.e(r13, r9) == false) goto L39;
        Message r14 = r25.b;
        if (r14 == null) goto L29;
        String r15 = r14.getConversationId();
    L30:
        if (r14 == null) goto L32;
        String r16 = r14.getMessageId();
    L33:
        if (r15 == null) goto L38;
        if (r16 == null) goto L38;
        if (r24 == null) goto L38;
        IChatGalleryService.a.a(r10, r25.getContext(), r24, r15, r16, r14, r25.e, r25.f, r25.h, r27, 768);
        return;
    L38:
        FLogger.a.e("MainBotGalleryHelper", "独立实验参数转换失败, 降级走 MainBotGallery");
        goto L39
    L32:
        r16 = null;
        goto L33
    L29:
        r15 = null;
    L39:
        Pair<Integer, Integer> r17 = r10.a(r25.getContext());
        GalleryBuilder r18 = new GalleryBuilder(r25.getContext());
        a r19 = new a(r25, r26, r30);
        Intrinsics.checkNotNullParameter(r19, "dataSource");
        r18.b = r19;
        r18.a(ProviderType.TOP, new l(r25, r26, r28, r29, r31));
        r18.a(ProviderType.NON_UI, new d());
        int r1 = r25.f;
        if (r1 < 0) goto L42;
        r18.c = r1;
    L42:
        com.larus.gallery.api.b r2 = new com.larus.gallery.api.b(new com.larus.gallery.api.a(((Number) r17.getFirst()).intValue(), ((Number) r17.getSecond()).intValue(), DisplayGravity.TOP, new com.larus.gallery.adapter.ui.i(i5.Z())), false, null, ((h0) a.getValue()).b.b, false, false, false, null, null, false, 32510);
        Intrinsics.checkNotNullParameter(r2, "displayConfig");
        r18.d = r2;
        Intrinsics.checkNotNullParameter("MainBotGalleryDialog", "tag");
        r18.m = "MainBotGalleryDialog";
        r18.l = r25.h;
        t<ty8.b> r0 = r10.m(r25);
        if (r0 == null) goto L45;
        r18.a(ProviderType.BOTTOM, r0);
    L45:
        r18.b(r24);
        return;
    L23:
        r13 = null;
        goto L24
    L15:
        if (1 <= r4) goto L17;
    L19:
        if (r11 == false) goto L39;
    L17:
        if (r4 >= 7) goto L19;
        r11 = true;
    L11:
        r9 = null;
        goto L12
    }
}
