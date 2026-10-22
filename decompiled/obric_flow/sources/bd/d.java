package bd;

import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.gkfs.cdc.CDCWindow;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.google.gson.Gson;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import il.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ym.j;
import z2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements g, a1.b, v, ReadableMapKeySetIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f905a;

    public /* synthetic */ d(Object r5) {
        this.f905a = r5;
    }

    public SSWebView a(MutableContextWrapper r5) {
        AttributeSet r10 = null;
        if (((com.lynx.tasm.utils.c) ((j) this.f905a).f23302a) != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "context");
        int r11 = 6;
        com.bytedance.ies.bullet.service.base.b.a(6, "DefaultWebKitServiceConfig precreate webview", null);
        nk.a.a();     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L9:
        return new SSWebView(r5, r10, r11, 0);
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        PageInfo r10 = (PageInfo) this.f905a;
        String r11 = r10.getMessageId();
        if (r11 == null) goto L5;
        r5.c("message_id", r11);
    L5:
        JSONObject r12 = new JSONObject(new Gson().toJson(r10));
        Intrinsics.checkNotNullParameter("pageInfo", STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r12, "value");
        if (r12.length() <= 0) goto L8;
        r5.b("pageInfo", r12);
    L8:
        Intrinsics.checkNotNullParameter("success", STGroup.DICT_KEY);
        r5.b("success", Boolean.TRUE);
    }

    @Override // a1.b
    public void d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ((t0.d) this.f905a).d(r5, r10);
    }

    @Override // a1.b
    public void e(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ((t0.d) this.f905a).e(r5, r10, r11);
    }

    @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
    public boolean hasNextKey() {
        return ((Iterator) this.f905a).hasNext();
    }

    @Override // a1.b
    public void i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ((t0.d) this.f905a).i(r5, r10);
    }

    @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
    public String nextKey() {
        return (String) ((Iterator) this.f905a).next();
    }

    @Override // a1.b
    public void w(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ((t0.d) this.f905a).w(r5, r10, null);
    }

    public d(int r5) {
        switch(r5) {
            case 5: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        this.f905a = new CDCWindow();
        return;
    L5:
        this.f905a = new ArrayList();
        return;
    L7:
        this.f905a = new LinkedHashMap();
    }

    public d(JavaOnlyMap r5) {
        this.f905a = r5.keySet().iterator();
    }

    public d(JSONObject r5) {
        if (r5 == null) goto L5;
        r5.optString("development");
    L5:
        if (r5 == null) goto L7;
        r5.optString("production");
    L7:
        if (r5 == null) goto L9;
        String r10 = r5.optString("module");
    L10:
        this.f905a = r10;
        return;
    L9:
        r10 = null;
        goto L10
    }

    public d(t0.d r5) {
        Intrinsics.checkNotNullParameter(r5, "logger");
        this.f905a = r5;
    }

    public d(Function2 r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        this.f905a = r5;
    }
}
