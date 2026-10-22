package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ClipPrimaryUtil;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 implements n56.c {
    public final WeakReference<Context> a;
    public TokenCert b;

    public class a implements SingleObserver<i81.b> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ f0 c;

        public final void onSubscribe(Disposable r1) {
        }

        public final void onError(Throwable r2) {
            ALogger.e("ClipboardMethod", r2);
        }

        public final void onSuccess(Object r6) {
            f0 r0 = this.c;
            Context r1 = r0.a.get();
            String r7 = ((i81.b) r6).a;
            String r2 = this.a;
            boolean r3 = this.b;
            if (r2 != null) goto L15;
        L6:
            r2 = r1.getString(2131915939);     // Catch: Exception -> L12
        L7:
            String r8 = r2 + r7;     // Catch: Exception -> L12
            ClipPrimaryUtil.setPrimaryText(r8, r0.b);     // Catch: Exception -> L12
            if (r3 == false) goto L10;
            jc1.k.f(IMiddlewareHostAction.class).markLocalCommand(r1, r8);     // Catch: Exception -> L12
        L10:
            com.bytedance.android.live.core.utils.f2.b(2131914624, 0);     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            Logger.e(f0.class.getSimpleName(), e.getMessage());
            return;
        L15:
            if (r2.isEmpty() == false) goto L7;
            goto L6
        }

        public a(f0 r1, String r2, boolean r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public f0(WeakReference<Context> r2) {
        this.b = TokenCert.with("bpea-clipboardmethod_clipboard");
        this.a = r2;
    }

    public void call(n56.f r8, JSONObject r9) throws Exception {
        JSONObject r0 = r8.d;
        JSONObject r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.optString("content");
    L6:
        JSONObject r3 = r8.d;
        if (r3 == null) goto L9;
        String r4 = r3.optString("type");
    L10:
        JSONObject r5 = r8.d;
        if (r5 == null) goto L13;
        String r6 = r5.optString("token");
    L14:
        JSONObject r7 = r8.d;
        int r10 = 0;
        if (r7 == null) goto L17;
        boolean r11 = r7.optBoolean("markLocalCommand");
    L18:
        if (r6 == null) goto L23;
        if (r6.isEmpty() == true) goto L23;
        this.b = TokenCert.with(r6);
    L23:
        if ("live_room".equals(r4) == false) goto L62;
        JSONObject r13 = r8.d;
        if (r13 == null) goto L27;
        r1 = r13.optJSONObject("url_extra");
    L27:
        HashMap r14 = new HashMap();
        if (r1 == null) goto L52;
        Iterator<String> r15 = r1.keys();
    L32:
        if (r15.hasNext() == false) goto L52;
        String r16 = r15.next();
        Object r17 = r1.get(r16);
        if ((r17 instanceof Boolean) == true) goto L51;
        if ((r17 instanceof Byte) == true) goto L51;
        if ((r17 instanceof Character) == true) goto L51;
        if ((r17 instanceof Double) == true) goto L51;
        if ((r17 instanceof Float) == true) goto L51;
        if ((r17 instanceof Integer) == true) goto L51;
        if ((r17 instanceof Long) == true) goto L51;
        if ((r17 instanceof Short) == true) goto L51;
        if ((r17 instanceof String) == false) goto L32;
    L51:
        r14.put(r16, String.valueOf(r17));
    L52:
        Room r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r18 != null) goto L55;
        return;
    L55:
        if (r18.getShareUrl() == null) goto L98;
        Uri.Builder r19 = UriProtector.parse(r18.getShareUrl()).buildUpon();
        Iterator r20 = r14.entrySet().iterator();
    L58:
        if (r20.hasNext() == false) goto L60;
        Map.Entry r21 = (Map.Entry) r20.next();
        r19.appendQueryParameter((String) r21.getKey(), (String) r21.getValue());
        goto L58
    L60:
        r19.appendQueryParameter("share_ht_uid", jc1.k.f(IMiddlewareUserService.class).user().n());
        jc1.k.f(ILiveMiddlewareShareService.class).getShortUrl(r19.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r2, r11));
        return;
    L98:
        return;
    L62:
        Context r23 = this.a.get();
        if (r23 != null) goto L80;
    L78:
        r9.put("code", r10);
        return;
    L80:
        TokenCert r24 = this.b;     // Catch: BPEAException -> L76
        int r25 = g80.c.a;     // Catch: BPEAException -> L76
        if (r2 != null) goto L81;
    L71:
        if (r11 == false) goto L73;
        jc1.k.f(IMiddlewareHostAction.class).markLocalCommand(r23, r2);     // Catch: BPEAException -> L76
    L73:
        r10 = 1;
        goto L78
    L81:
        g80.d.c(ClipData.newPlainText(BuildConfig.FLAVOR, r2), r24);     // Catch: Throwable -> L69 BPEAException -> L74
    L74:
        e = move-exception;
        throw e;     // Catch: BPEAException -> L76
    L69:
        th = move-exception;
        ALogger.e("ClipboardCompat", th);     // Catch: BPEAException -> L76
    L76:
        e = move-exception;
        ALogger.e("ClipboardMethod", e);
        goto L78
    L17:
        r11 = false;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
