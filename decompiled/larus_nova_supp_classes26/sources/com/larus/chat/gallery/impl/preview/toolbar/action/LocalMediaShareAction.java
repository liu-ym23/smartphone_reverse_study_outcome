package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.gallery.api.GalleryType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LocalMediaShareAction implements o {

    public static final class a {
    }

    static {
    }

    public LocalMediaShareAction() {
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r11, Continuation<? super Unit> r12) {
        xy8.d r13 = r11.a;
        if (r13.p == null) goto L5;
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L9;
    L11:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L28;
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        r4.put("action", ShareChannel.SHARE);
        r4.put("entry", "local_media_gallery");
        r4.put("channel", ShareChannel.MORE);
        if (r13.e != GalleryType.Video) goto L17;
        String r14 = "video";
    L18:
        r4.put("content_type", r14);
        Unit r15 = Unit.INSTANCE;
        r3.reportEvent("flow_enterprise_file_egress_block", r4);
        String r16 = r0.A0();
        if (r16 == null) goto L27;
        if ((!StringsKt.isBlank(r16)) == false) goto L23;
        String r6 = r16;
    L24:
        if (r6 == null) goto L27;
        t19.s.j(t19.s.a, r11.getContext(), r6, null, false, 28);
        goto L27
    L23:
        r6 = null;
    L27:
        return Unit.INSTANCE;
    L17:
        r14 = "image";
        goto L18
    L28:
        BuildersKt.launch$default(r11.b, null, null, new LocalMediaShareAction$execute$5(r11, r13, null), 3, null);
        return Unit.INSTANCE;
    L9:
        if (r0.I0() != true) goto L11;
        r2 = true;
        goto L13
    L5:
        return Unit.INSTANCE;
    }
}
