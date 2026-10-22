package c9;

import android.content.Context;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.service.debug.DebugTatPosition;
import com.bytedance.android.live.browser.AnnieNGInitHelper;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface d extends com.bytedance.android.annie.service.a {
    void E0(DebugTatPosition r1, AnnieNGInitHelper.a r10);

    void c0(Context r1, AnnieCard r10);

    void registerMethod(String r1, f.b r10);

    <P, R> void registerMethod(String r1, g<P, R> r10);
}
