package qbb;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class b implements qbb.a {
    public static final /* synthetic */ int b = 0;
    public final l a;

    public static final class a {
    }

    /* JADX INFO: renamed from: qbb.b$b, reason: collision with other inner class name */
    public static final class C0282b<T> implements FlowableOnSubscribe {
        public final /* synthetic */ obb.b a;
        public final /* synthetic */ b b;

        /* JADX INFO: renamed from: qbb.b$b$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;
            public final /* synthetic */ FlowableEmitter<obb.b> b;

            public a(b r1, FlowableEmitter<obb.b> r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r20) {
                s r0 = (s) r20;
                String r3 = BuildConfig.FLAVOR;
                Intrinsics.checkNotNull(r0);
                String r5 = null;
                SendHttpResponse r1 = (SendHttpResponse) t.c(r0, null);
                Log.i("DOCS_ICON_RustMetaFetcher", "fetchMetaInfo success");
            L34:
                e = move-exception;
                Log.e("DOCS_ICON_RustMetaFetcher", "parse fail " + e.getMessage());
                this.b.onError(new Exception("parse fail " + e));
                return;
            L4:
                if (r1 == null) goto L6;
                String r8 = r1.json_body;     // Catch: Exception -> L34
            L7:
                JSONObject r6 = new JSONObject(r8).optJSONObject(Keys.API_RETURN_KEY_DATA);     // Catch: Exception -> L34
                String r9 = r6.optString("title");     // Catch: Exception -> L34
                String r10 = r6.optString("icon_info", BuildConfig.FLAVOR);     // Catch: Exception -> L34
                sbb.c.a.getClass();     // Catch: Exception -> L34
                obb.b r11 = sbb.c.c(null, r10);     // Catch: Exception -> L34
                if (r11 == null) goto L10;
                r11.h = r9;     // Catch: Exception -> L34
            L10:
                if (r11 != null) goto L22;
                if (TextUtils.isEmpty(r6.optString("token")) == true) goto L22;
                b r12 = this.a;     // Catch: Exception -> L34
                Intrinsics.checkNotNull(r9);     // Catch: Exception -> L34
                int r13 = b.b;     // Catch: Exception -> L34
                r12.getClass();     // Catch: Exception -> L34
                if (TextUtils.isEmpty(r9) == true) goto L20;
                int r14 = StringsKt.lastIndexOf$default(r9, '.', 0, false, 6, null);     // Catch: Exception -> L34
                if (r14 <= (-1)) goto L20;
                r3 = r9.substring(r14 + 1);     // Catch: Exception -> L34
            L20:
                r11 = new obb.b(r6.optInt("obj_type", -1), r6.optString("token"), r3, null, null, Integer.valueOf(r6.optInt(Keys.API_RETURN_KEY_VERSION)), r9, null, 256);     // Catch: Exception -> L34
            L22:
                if (this.b.isCancelled() == true) goto L38;
                if (r11 == null) goto L25;
                this.b.onNext(r11);     // Catch: Exception -> L34
                return;
            L25:
                StringBuilder r2 = new StringBuilder("parse fail ");     // Catch: Exception -> L34
                if (r1 == null) goto L28;
                String r4 = r1.json_body;     // Catch: Exception -> L34
            L29:
                r2.append(r4);     // Catch: Exception -> L34
                Log.i("DOCS_ICON_RustMetaFetcher", r2.toString());     // Catch: Exception -> L34
                FlowableEmitter<obb.b> r7 = this.b;     // Catch: Exception -> L34
                StringBuilder r15 = new StringBuilder("parse fail ");     // Catch: Exception -> L34
                if (r1 == null) goto L32;
                r5 = r1.json_body;     // Catch: Exception -> L34
            L32:
                r15.append(r5);     // Catch: Exception -> L34
                r7.onError(new Exception(r15.toString()));     // Catch: Exception -> L34
                return;
            L28:
                r4 = null;
                goto L29
            L38:
                return;
            L6:
                r8 = null;
                goto L7
            }
        }

        /* JADX INFO: renamed from: qbb.b$b$b, reason: collision with other inner class name */
        public static final class C0283b<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<obb.b> a;

            public C0283b(FlowableEmitter<obb.b> r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                this.a.onError(r4);
                Log.i("DOCS_ICON_RustMetaFetcher", "fetchMetaInfo fail " + r4);
            }
        }

        public C0282b(obb.b r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(FlowableEmitter<obb.b> r12) {
            Intrinsics.checkNotNullParameter(r12, "emit");
            String r0 = "https://" + jcb.b.c().a("docs_api") + "/space/api/icon/pack/?token=" + this.a.b + "&type=" + this.a.getType();
            HashMap r1 = new HashMap();
            r1.put("Cookie", "session=" + ((xzb.a) ApiUtils.getApi(xzb.a.class)).getSession());
            SendHttpRequest.Builder r3 = new SendHttpRequest.Builder().method(SendHttpRequest.Method.GET).url(r0).headers(r1);
            l r2 = this.b.a;
            Command r5 = Command.SEND_HTTP;
            Intrinsics.checkNotNull(r3);
            r2.h(new com.bytedance.lark.rustclient.api.d(r3, SendHttpResponse.ADAPTER, r5, null, null, null, null, 248)).a().subscribe(new a(this.b, r12), new C0283b(r12));
        }
    }

    static {
    }

    @Inject
    public b(l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // qbb.a
    public final Flowable<obb.b> a(obb.b r6) {
        Intrinsics.checkNotNullParameter(r6, "meta");
        if (TextUtils.isEmpty(r6.b) == true) goto L20;
        if (r6.getType() == 0) goto L20;
        if (r6.getType() == 12) goto L20;
        String r0 = r6.b;
        boolean r1 = false;
        if (r0 != null) goto L11;
    L15:
        if (r1 == true) goto L20;
        return Flowable.create(new C0282b(r6, this), BackpressureStrategy.BUFFER);
    L11:
        if (TextUtils.isEmpty(r0) == true) goto L15;
        if (StringsKt.startsWith$default(r0.toLowerCase(Locale.getDefault()), "fake_", false, 2, null) == false) goto L15;
        r1 = true;
    L20:
        return Flowable.empty();
    }
}
