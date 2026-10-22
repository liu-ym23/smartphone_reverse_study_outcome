package xr1;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final Context a;
    public final Activity b;
    public final f c;
    public final ShareParams d;
    public final List<String> e;
    public final List<String> f;
    public final String g;
    public final String h;
    public final Map<String, Object> i;
    public final Function1<String, Unit> j;
    public final String k;

    public final String toString() {
        return "LiveShareParams(context=" + this.a + ", activity=" + this.b + ", contactUser=" + this.c + ", shareParams=" + this.d + ", fansGroupIdList=" + this.e + ", videoFilePathList=" + this.f + ", conversationId=" + this.g + ", text=" + this.h + ", activityParams=" + this.i + ", callback=" + this.j + ", reportType=" + this.k + ')';
    }

    public final Activity getActivity() {
        return this.b;
    }

    public final Context getContext() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r1, Activity r2, f r3, ShareParams r4, List<String> r5, List<String> r6, String r7, String r8, Map<String, Object> r9, Function1<? super String, Unit> r10, String r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
