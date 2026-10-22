package i81;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.depend.share.IShareDirectTypeCallback;
import com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
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
    public final Boolean l;
    public final Dialog m;
    public final JSONObject n;
    public final IUgShareCallback o;
    public final IShareDirectTypeCallback p;
    public final boolean q;

    /* JADX INFO: renamed from: i81.a$a, reason: collision with other inner class name */
    public static final class C0251a {
        public Context a;
        public Activity b;
        public f c;
        public ShareParams d;
        public List<String> e;
        public List<String> f;
        public String g;
        public String h;
        public final Map<String, Object> i;
        public Function1<? super String, Unit> j;
        public String k;
        public boolean l;
        public Dialog m;
        public JSONObject n;
        public IUgShareCallback o;
        public IShareDirectTypeCallback p;
        public boolean q;

        public C0251a() {
            this(null);
        }

        public final a a() {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, Boolean.valueOf(this.l), this.m, this.n, this.o, this.p, this.q);
        }

        public C0251a(Object r2) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = false;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = false;
        }
    }

    public final String toString() {
        return "LiveShareParams(context=" + this.a + ", activity=" + this.b + ", contactUser=" + this.c + ", shareParams=" + this.d + ", fansGroupIdList=" + this.e + ", videoFilePathList=" + this.f + ", conversationId=" + this.g + ", text=" + this.h + ", activityParams=" + this.i + ", callback=" + this.j + ", reportType=" + this.k + ", sharePosterEnable=" + this.l + ')';
    }

    public final Activity getActivity() {
        return this.b;
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r3, Activity r4, f r5, ShareParams r6, List r7, List r8, String r9, String r10, Map r12, Function1 r13, String r14, Boolean r15, Dialog r16, JSONObject r17, IUgShareCallback r18, IShareDirectTypeCallback r19, boolean r110) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r110;
    }
}
