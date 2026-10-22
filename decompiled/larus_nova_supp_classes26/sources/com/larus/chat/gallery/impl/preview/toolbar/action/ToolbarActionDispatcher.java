package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ToolbarActionDispatcher implements PreviewToolbarView.b {
    public final CoroutineScope a;
    public final Function0<l0> b;
    public final Map<ToolbarButtonType, o> c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public final void c(ToolbarButtonType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        b(r3, false, true);
    }

    public ToolbarActionDispatcher(CoroutineScope r2, com.larus.chat.gallery.impl.preview.toolbar.b r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r3, "contextProvider");
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashMap();
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView.b
    public final void a(ToolbarButtonType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        b(r2, r3, false);
    }

    public final void d(ToolbarButtonType r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "action");
        this.c.put(r2, r3);
    }

    public final void b(ToolbarButtonType r21, boolean r22, boolean r23) {
        String r3 = null;
        if (r21 != ToolbarButtonType.MORE) goto L52;
        l0 r1 = (l0) this.b.invoke();
        if (r1 == null) goto L62;
        xy8.d r2 = r1.a;
        xy8.e r4 = r2.m;
        if (r4 == null) goto L11;
        String r5 = r4.e;
        if (r5 == null) goto L11;
    L14:
        if (r4 == null) goto L19;
        String r6 = r4.c;
        if (r6 == null) goto L19;
        r3 = r6;
    L22:
        int r7 = r2.q;
        if (r2.a != SourceType.USER_SEND) goto L25;
        String r8 = "user";
    L26:
        boolean r9 = true;
        if (b.a[r2.e.ordinal()] != 1) goto L29;
        String r10 = "video_detail";
    L30:
        JSONObject r11 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r12 = r2.f.entrySet().iterator();
    L32:
        if (r12.hasNext() == false) goto L35;
        Map.Entry<String, Object> r13 = r12.next();
        r11.put(r13.getKey(), r13.getValue());
        goto L32
    L35:
        if (r5 != null) goto L37;
    L40:
        boolean r14 = true;
    L41:
        if (r14 == true) goto L43;
        r11.put("creation_task_id", r5);
    L43:
        if (r3 != null) goto L45;
    L48:
        if (r9 == true) goto L50;
        r11.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
    L50:
        r11.put("position", r7);
        r11.put("user_type", r8);
        r11.put("current_page", r10);
        FLogger.a.i("ToolbarActionDispatcher", "reportClickMore: click_detail_page_more_button, params=" + r11);
        com.larus.platform.service.o.a.reportEvent("click_detail_page_more_button", r11);
        return;
    L45:
        if (r3.length() == 0) goto L48;
        r9 = false;
        goto L48
    L37:
        if (r5.length() == 0) goto L40;
        r14 = false;
        goto L41
    L29:
        r10 = "picture_detail";
        goto L30
    L25:
        r8 = "bot";
    L19:
        xy8.f r15 = r2.l;
        if (r15 == null) goto L22;
        r3 = r15.a;
    L11:
        if (r4 == null) goto L13;
        r5 = r4.a;
        goto L14
    L13:
        r5 = null;
        goto L14
    L62:
        return;
    L52:
        o r16 = (o) ((LinkedHashMap) this.c).get(r21);
        if (r16 == null) goto L59;
        l0 r17 = (l0) this.b.invoke();
        if (r17 != null) goto L58;
        FLogger.a.w("ToolbarActionDispatcher", "contextProvider returned null, ignoring action " + r21);
        return;
    L58:
        xy8.d r18 = r17.a;
        CoroutineScope r19 = r17.b;
        FragmentManager r20 = r17.c;
        Context r24 = r17.d;
        com.larus.gallery.api.w r110 = r17.e;
        PreviewToolbarView r111 = r17.f;
        boolean r112 = r17.g;
        xy8.a r113 = r17.h;
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r19, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r20, "fragmentManager");
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r110, "mediator");
        BuildersKt.launch$default(this.a, null, null, new ToolbarActionDispatcher$dispatchAction$1(r16, new l0(r18, r19, r20, r24, r110, r111, r112, r113, r22, r23), r21, null), 3, null);
        return;
    L59:
        FLogger.a.w("ToolbarActionDispatcher", "No action registered for " + r21 + " and no fallback available");
    }
}
