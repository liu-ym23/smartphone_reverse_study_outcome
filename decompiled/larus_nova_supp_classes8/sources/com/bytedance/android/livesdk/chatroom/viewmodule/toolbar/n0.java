package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n0<T> implements SingleOnSubscribe {
    public final /* synthetic */ i0.e a;

    public n0(i0.e r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<JSONArray> r12) {
        Intrinsics.checkNotNullParameter(r12, "emitter");
        String r0 = FileUtils.readFromFile(new PolarisFileWrapper(this.a.e));
        int r1 = op1.c.a;
        int r2 = this.a.f;
        JSONArray r3 = null;
        int r4 = 0;
        if (r0 != null) goto L6;
    L47:
        List r5 = null;
    L73:
        if (r5 == null) goto L83;
        JSONArray r6 = new JSONArray();
        int r7 = r5.size();
    L76:
        if (r4 >= r7) goto L82;
        op1.d r8 = (op1.d) ListProtector.get(r5, r4);
        JSONObject r9 = new JSONObject();
        r9.put("text", op1.c.a(r8.a()));     // Catch: JSONException -> L80
        r9.put("timeId", String.valueOf(r8.b()));     // Catch: JSONException -> L80
        r6.put(r9);
        r4 = r4 + 1;
    L80:
        e = move-exception;
        e.printStackTrace();
        goto L83
    L82:
        r3 = r6;
    L83:
        if (r3 != null) goto L85;
        r3 = new JSONArray();
    L85:
        r12.onSuccess(r3);
        return;
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L47;
        if (r2 != 2) goto L49;
        BufferedReader r10 = new BufferedReader(new StringReader(r0));
        op1.e r11 = new op1.e();
        String r13 = r10.readLine();     // Catch: Throwable -> L41 IOException -> L44
    L12:
        if (r13 == null) goto L94;
        op1.e.a(r13);     // Catch: Throwable -> L41 IOException -> L44
        String r14 = r11.c(r13);     // Catch: Throwable -> L41 IOException -> L44
        int r15 = r14.length() - 1;     // Catch: Throwable -> L41 IOException -> L44
        int r16 = 0;
        boolean r17 = false;
    L14:
        if (r16 > r15) goto L29;
        if (r17 == true) goto L17;
        int r18 = r16;
    L19:
        if (Intrinsics.compare(r14.charAt(r18), 32) > 0) goto L21;
        boolean r19 = true;
    L22:
        if (r17 == false) goto L23;
        if (r19 == false) goto L29;
        r15 = r15 - 1;     // Catch: Throwable -> L41 IOException -> L44
        goto L14
    L23:
        if (r19 == false) goto L24;
        r16 = r16 + 1;     // Catch: Throwable -> L41 IOException -> L44
        goto L14
    L24:
        r17 = true;
        goto L14
    L21:
        r19 = false;
        goto L22
    L17:
        r18 = r15;
    L29:
        String r20 = r14.subSequence(r16, r15 + 1).toString();     // Catch: Throwable -> L41 IOException -> L44
        if (TextUtils.isEmpty(r20) == true) goto L32;
        r11.b(r20);     // Catch: Throwable -> L41 IOException -> L44
    L32:
        r13 = r10.readLine();     // Catch: Throwable -> L41 IOException -> L44
        goto L12
    L94:
        r10.close();     // Catch: IOException -> L36
    L38:
        if (r11.a.size() == 0) goto L47;
        r5 = r11.a;
    L44:
        r10.close();     // Catch: IOException -> L46
    L41:
        th = move-exception;
        r10.close();     // Catch: IOException -> L87
    L43:
        throw th;
    L49:
        if (r2 != 3) goto L70;
        op1.a r21 = new op1.a();
        Intrinsics.checkNotNullParameter(r0, "content");
        BufferedReader r22 = new BufferedReader(new StringReader(r0));
        ArrayList r23 = new ArrayList();
        String r24 = r22.readLine();     // Catch: IOException -> L62
    L52:
        if (r24 == null) goto L60;
        String r25 = StringsKt.trim(r24).toString();     // Catch: IOException -> L62
        if (r25.length() <= 0) goto L56;
        boolean r26 = true;
    L57:
        if (r26 == false) goto L59;
        r21.b(r23, r25);     // Catch: IOException -> L62
    L59:
        r24 = r22.readLine();     // Catch: IOException -> L62
        goto L52
    L56:
        r26 = false;
        goto L57
    L60:
        r22.close();     // Catch: IOException -> L62
    L64:
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r28 = r23.iterator();
    L66:
        if (r28.hasNext() == false) goto L68;
        op1.a.b r29 = (op1.a.b) r28.next();
        r27.add(new op1.d(r29.b / BubbleId.PadCast, r29.a));
        goto L66
    L68:
        r5 = CollectionsKt.toMutableList(r27);
    L62:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L64
    L70:
        if (r2 == 11) goto L72;
        r5 = (List) GsonProtectorUtils.fromJson(GsonHelper.get(), r0, new op1.b().getType());
        goto L73
    L72:
        op1.d r30 = new op1.d(0.0f, r0);
        ArrayList r31 = new ArrayList();
        r31.add(r30);
        r5 = r31;
        goto L73
    }
}
