package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.browser.jsbridge.base.OpenCustomEmojiPreviewResultModel;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.SelfEmoji;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openCustomEmojiPreview")
public final class q8 extends w20.g4<w20.fc, OpenCustomEmojiPreviewResultModel> {
    public final Activity a;

    public final Activity getActivity() {
        return this.a;
    }

    public q8(Activity r1) {
        this.a = r1;
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.fc r7 = (w20.fc) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        SelfEmoji r8 = new SelfEmoji();
        JsonObject r0 = r7.b();
        JsonArray r1 = null;
        if (r0 == null) goto L7;
        JsonElement r2 = r0.get("id");
        if (r2 == null) goto L7;
        String r3 = r2.getAsString();
    L8:
        r8.setId(r3);
        boolean r4 = false;
        if (r0 == null) goto L15;
        JsonElement r9 = r0.get("width");
        if (r9 == null) goto L15;
        String r11 = r9.getAsString();
        if (r11 == null) goto L15;
        int r12 = CastIntegerProtector.parseInt(r11);
    L16:
        r8.setViewWidth(r12);
        if (r0 == null) goto L23;
        JsonElement r13 = r0.get("height");
        if (r13 == null) goto L23;
        String r14 = r13.getAsString();
        if (r14 == null) goto L23;
        int r15 = CastIntegerProtector.parseInt(r14);
    L24:
        r8.setViewHeight(r15);
        if (r0 == null) goto L31;
        JsonElement r16 = r0.get("is_gif");
        if (r16 == null) goto L31;
        String r17 = r16.getAsString();
        if (r17 == null) goto L31;
        r4 = Boolean.parseBoolean(r17);
    L31:
        r8.setGif(r4);
        if (r0 == null) goto L36;
        JsonElement r18 = r0.get("web_uri");
        if (r18 == null) goto L36;
        String r19 = r18.getAsString();
    L37:
        r8.setWebUri(r19);
        if (r0 == null) goto L42;
        JsonElement r21 = r0.get("animate_type");
        if (r21 == null) goto L42;
        String r22 = r21.getAsString();
    L43:
        r8.setAnimateType(r22);
        if (r0 == null) goto L48;
        JsonElement r23 = r0.get("display_name");
        if (r23 == null) goto L48;
        String r24 = r23.getAsString();
    L49:
        r8.setDisplayName(r24);
        if (r0 == null) goto L54;
        JsonElement r25 = r0.get("url_list");
        if (r25 == null) goto L54;
        r1 = r25.getAsJsonArray();
    L54:
        ArrayList r26 = new ArrayList();
        if (r1 == null) goto L60;
        Iterator r27 = r1.iterator();
    L58:
        if (r27.hasNext() == false) goto L60;
        r26.add(((JsonElement) r27.next()).getAsString());
    L60:
        r8.setUrls(r26);
        ImageModel r28 = new ImageModel();
        r28.setUrls(r26);
        r28.width = r8.getViewWidth();
        r28.height = r8.getViewHeight();
        r28.setUri(r8.getWebUri());
        r8.setAnimatedImage(r28);
        r8.setStaticImage(r8.getAnimatedImage());
        String r29 = r7.a();
        if (r29 != null) goto L64;
    L69:
        jc1.k.n(IHostEmoji.class).previewSelfEmoji(this.a, r8);
        return;
    L64:
        if (r29.hashCode() != 96417) goto L69;
        if (r29.equals("add") == false) goto L69;
        jc1.k.n(IHostEmoji.class).addSelfEmoji(this.a, r8);
        return;
    L48:
        r24 = null;
    L42:
        r22 = null;
    L36:
        r19 = null;
    L23:
        r15 = 0;
    L15:
        r12 = 0;
    L7:
        r3 = null;
        goto L8
    }
}
