package com.bytedance.pia.core.worker.network;

import ai.j0;
import android.net.Uri;
import bi.c;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.resource.core.net.a;
import com.bytedance.crash.upload.l;
import com.bytedance.pia.core.utils.f;
import com.bytedance.pia.core.utils.j;
import com.bytedance.ttnet.utils.d;
import com.bytedance.vmsdk.net.Request;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lk.b;
import okhttp3.h0;
import okhttp3.q0;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pia/core/worker/network/WorkerDelegate;", "Llk/b;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nWorkerDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerDelegate.kt\ncom/bytedance/pia/core/worker/network/WorkerDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,157:1\n1#2:158\n95#3:159\n122#3,3:160\n*E\n*S KotlinDebug\n*F\n+ 1 WorkerDelegate.kt\ncom/bytedance/pia/core/worker/network/WorkerDelegate\n*L\n79#1:159\n79#1,3:160\n*E\n"})
public final class WorkerDelegate implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f7167c;
    public final f d;

    public WorkerDelegate(String r5, String r10, a r11, f r12) {
        Intrinsics.checkNotNullParameter(r5, "logTag");
        Intrinsics.checkNotNullParameter(r10, "userAgent");
        Intrinsics.checkNotNullParameter(r11, "retrofit");
        Intrinsics.checkNotNullParameter(r12, "resourceLoader");
        this.f7165a = r5;
        this.f7166b = r10;
        this.f7167c = r11;
        this.d = r12;
    }

    public final void a(Request r10, l r11) {
        StringBuilder r5 = new StringBuilder();
        String r12 = this.f7165a;
        r5.append(r12);
        r5.append("Begin to fetch (URL: ");
        r5.append(r10.getUrl());
        r5.append(')');
        j.y(r5.toString(), null);
        String r13 = r10.getHeaders().remove("pia-fetch-params");
        if (r13 != null) goto L101;
        JSONObject r14 = null;
    L13:
        j.y(r12 + "Read fetch parameter (Params: " + r14 + ')', null);
        if (r14 == null) goto L17;
        r14.optBoolean("needCommonParams", false);
    L17:
        if (r10.getHeaders().containsKey("User-Agent") == true) goto L19;
        StringBuilder r15 = j0.w(r12, "Append 'User-Agent' for fetch (URL: ");
        r15.append(r10.getUrl());
        r15.append(')');
        j.y(r15.toString(), null);
        r10.getHeaders().put("User-Agent", this.f7166b);
    L19:
        Uri r16 = Uri.parse(r10.getUrl());
        if (r16 == null) goto L22;
        String r17 = r16.getHost();
    L23:
        if (r17 != null) goto L25;
    L27:
        String r18 = null;
    L29:
        if (r18 != null) goto L33;
        j.w(6, r12 + "Fetch failed (Reason: Invalid url!)", null);
        r11.a(new Error("Invalid url!"));
        return;
    L33:
        switch(this.f7167c.f2675a) {
            case 16: goto L35;
            default: goto L35;
        };
    L35:
        if (d.c(uh.a.class, r18) != null) goto L100;
        Map<String, String> r19 = r10.getHeaders();
        ArrayList r20 = new ArrayList(r19.size());
        Iterator<Map.Entry<String, String>> r21 = r19.entrySet().iterator();
    L38:
        if (r21.hasNext() == false) goto L40;
        Map.Entry<String, String> r22 = r21.next();
        r20.add(new c(r22.getKey(), r22.getValue()));
        goto L38
    L40:
        Iterator r23 = CollectionsKt.toList(r20).iterator();
    L42:
        if (r23.hasNext() == false) goto L50;
        Object r24 = r23.next();
        String r25 = ((c) r24).f915a;
        Locale r26 = Locale.ROOT;
        if (r25 == null) goto L49;
        if (Intrinsics.areEqual(r25.toLowerCase(r26), "content-type") == false) goto L42;
    L51:
        c r27 = (c) r24;
        if (r27 == null) goto L54;
        String r28 = r27.f916b;
    L55:
        if (r28 != null) goto L57;
        r28 = "application/json";
    L57:
        Pattern r29 = h0.e;
        h0 r30 = z.j(r28);
        InputStream r31 = r10.getBody();
        if (r31 == null) goto L60;
        q0.create(r30, ByteStreamsKt.readBytes(r31));
    L60:
        String r32 = r10.getMethod().toLowerCase(Locale.ROOT);
        switch(r32.hashCode()) {
            case -1335458389: goto L94;
            case -1249474914: goto L89;
            case 102230: goto L84;
            case 111375: goto L79;
            case 3198432: goto L74;
            case 3446944: goto L69;
            case 106438728: goto L64;
            default: goto L95;
        };
    L95:
        j.w(6, r12 + "Fetch failed (Reason: Invalid method!)", null);
        r11.a(new Error("Invalid method!"));
        return;
    L64:
        if (r32.equals("patch") == false) goto L95;
        r16.toString();
        throw null;
    L69:
        if (r32.equals("post") == false) goto L95;
        r16.toString();
        throw null;
    L74:
        if (r32.equals("head") == false) goto L95;
        r16.toString();
        throw null;
    L79:
        if (r32.equals("put") == false) goto L95;
        r16.toString();
        throw null;
    L84:
        if (r32.equals("get") == false) goto L95;
        r16.toString();
        throw null;
    L89:
        if (r32.equals("options") == false) goto L95;
        r16.toString();
        throw null;
    L94:
        if (r32.equals(Constant.ClientMessageType.DELETE) == false) goto L95;
        r16.toString();
        throw null;
    L54:
        r28 = null;
        goto L55
    L49:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L50:
        r24 = null;
        goto L51
    L100:
        throw new ClassCastException();
    L25:
        if (r16.getScheme() == null) goto L27;
        r18 = r16.getScheme() + "://" + r16.getHost() + "/";
        goto L29
    L22:
        r17 = null;
        goto L23
    L101:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L6
        Object r34 = Result.m124constructorimpl(new JSONObject(r13));     // Catch: Throwable -> L6
    L9:
        if (Result.m130isFailureimpl(r34) == false) goto L11;
        r34 = null;
    L11:
        r14 = (JSONObject) r34;
    L6:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r34 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
