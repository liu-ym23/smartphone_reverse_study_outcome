package com.ss.android.lark.feed.shared.data.utils;

import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.h.b, peb.b.h {
    public static e b;
    public final Map<Integer, Drawable> a;

    public class a implements MemoryCallbackManager.MemoryCallback {
        public final /* synthetic */ e a;

        public final void onTrimMemory(int r1, int r2, int r3, int r4) {
        }

        public final void onJavaMemoryReachTop() {
            if (((ConcurrentHashMap) this.a.a).size() <= 1000) goto L8;
            Map<Integer, Drawable> r0 = this.a.a;
            if (r0 == null) goto L9;
            ((ConcurrentHashMap) r0).clear();
            return;
        L9:
            return;
        }

        public a(e r1) {
            this.a = r1;
        }
    }

    public e() {
        this.a = new ConcurrentHashMap();
        peb.b r0 = heb.a.a;
        r0.getSettingDependency().d();
        r0.getSettingDependency().c(this);
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a(this));
    }

    public final void a(String r3, LarkNameTag r4, com.larksuite.component.ui.tag.d r5) {
        if (r3 == null) goto L7;
        if (r5 == null) goto L8;
        ((ConcurrentHashMap) this.a).put(Integer.valueOf((r4.hashCode() * 31) + r3.hashCode()), r5);
        Log.d("FeedTagHelper", "setTagCache:" + r4.hashCode() + "/false");
        return;
    L8:
        return;
    }
}
