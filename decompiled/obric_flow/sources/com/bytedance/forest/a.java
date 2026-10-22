package com.bytedance.forest;

import android.net.Uri;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.r;
import com.bytedance.forest.model.s;
import com.bytedance.forest.model.t;
import com.bytedance.forest.model.w;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.utils.e;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.behavior.v0;
import com.lynx.tasm.ui.image.f0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Forest f4227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f4229c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Function1 g;

    public a(Forest r5, String r10, t r11, String r12, String r13, boolean r14, Function1 r15) {
        this.f4227a = r5;
        this.f4228b = r10;
        this.f4229c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.forest.preload.d r5 = Forest.access$getPreLoader$p(this.f4227a);
        String r10 = this.f4228b;
        t r11 = this.f4229c;
        String r12 = this.d;
        if (r12 != null) goto L6;
        r12 = "";
    L6:
        r11.getClass();
        r11.f4419t = r12;
        r11.f4420u = this.e;
        r5.d(r10, r11);
        e r13 = new e(this.f4227a.getApplication());
        if (this.f == true) goto L10;
        com.bytedance.forest.utils.d.c(r13.g, 3, "PreloadAPI", null, null, new Forest$preload$task$1$2(this), 28);
        return;
    L10:
        Request r14 = v0.b(this.f4228b, this.f4227a, this.f4229c, false, r13);
        if (r14.getGeckoModel().a() == false) goto L13;
        com.bytedance.forest.utils.d.c(r13.g, 6, "PreloadAPI", null, null, new Forest$preload$task$1$3(this), 28);
    L13:
        Forest r15 = this.f4227a;
        t r16 = new t(Scene.f4353m);
        String r17 = this.d;
        if (r17 != null) goto L17;
        r17 = "";
    L17:
        r16.f4419t = r17;
        r16.f4420u = this.e;
        ((Map) r16.f4421v.getValue()).put("rl_container_uuid", r16.f4419t);
        r16.f4407c = r14.getGeckoModel().f4390b;
        r16.d = "preload.json";
        r16.f4406b = r14.getGeckoModel().f4389a;
        boolean r18 = true;
        r16.f4412l = true;
        r16.f4411k = true;
        r16.f4415o = true;
        s r19 = r15.createSyncRequest("", r16);
        if (r19 != null) goto L21;
        com.bytedance.forest.utils.d.b(r13.g, 6, "PreloadAPI", "Can not build RequestOperation for preload.json", false, null, null, 56);
        return;
    L21:
        w r20 = r19.a();
        com.bytedance.forest.model.c r21 = null;
        Object r22 = null;
        r r23 = null;
        if (r20 != null) goto L24;
    L95:
        com.bytedance.forest.utils.d r24 = r13.g;
        StringBuilder r25 = new StringBuilder("Getting preload.json failed, msg: ");
        if (r20 == null) goto L98;
        r21 = r20.s;
    L98:
        r25.append(r21);
        com.bytedance.forest.utils.d.b(r24, 6, "PreloadAPI", r25.toString(), false, null, null, 56);
        return;
    L24:
        if (r20.f4442r == false) goto L95;
        Uri r26 = Uri.parse(this.f4228b);     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(r26.getScheme(), "http") == false) goto L30;
    L35:
        LinkedHashMap r110 = com.lynx.tasm.utils.b.k(r26);     // Catch: Throwable -> L33
        if (r18 == false) goto L48;
        String r27 = this.f4228b;     // Catch: Throwable -> L33
        if (StringsKt.r("?", 0, 6, r27) == (-1)) goto L41;
        r27 = null;
    L41:
        if (r27 != null) goto L49;
        String r28 = this.f4228b;     // Catch: Throwable -> L33
        int r29 = StringsKt.r("?", 0, 6, r28);     // Catch: Throwable -> L33
        if (r28 == null) goto L47;
        r27 = r28.substring(0, r29);     // Catch: Throwable -> L33
        goto L49
    L47:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L33
    L49:
        byte[] r30 = r20.k();     // Catch: Throwable -> L33
        if (r30 != null) goto L52;
        Intrinsics.throwNpe();     // Catch: Throwable -> L33
    L52:
        JSONObject r31 = new JSONObject(new String(r30, Charsets.UTF_8)).getJSONObject(r27);     // Catch: Throwable -> L33
        if (r31 != null) goto L55;
        JSONObject r111 = null;
    L56:
        if (r111 == null) goto L88;
        int r32 = this.f4229c.H.ordinal();     // Catch: Throwable -> L33
        if (r32 != 3) goto L60;
        PreloadType r33 = PreloadType.f4333a;     // Catch: Throwable -> L33
    L76:
        Forest r112 = this.f4227a;     // Catch: Throwable -> L33
        t r34 = this.f4229c;     // Catch: Throwable -> L33
        boolean r113 = r34.f4411k;     // Catch: Throwable -> L33
        NetWorker r35 = r34.A;     // Catch: Throwable -> L33
        if (r35 != null) goto L80;
        r35 = NetWorker.f4466b;     // Catch: Throwable -> L33
    L80:
        r r36 = new r(r33, Forest.access$parseSubResourceConfig(r112, r111, r110, r113, r35, r34.C, this.g));     // Catch: Throwable -> L33
        Object r37 = ((Map) this.f4229c.f4421v.getValue()).get("x-forest-preload-from");     // Catch: Throwable -> L33
        if ((r37 instanceof String) == true) goto L83;
        r37 = null;
    L83:
        r36.f4399a = (String) r37;     // Catch: Throwable -> L33
        Object r38 = ((Map) this.f4229c.f4421v.getValue()).get("x-forest-injected-ua");     // Catch: Throwable -> L33
        if ((r38 instanceof String) == false) goto L87;
        r22 = r38;
    L87:
        r36.f4400b = (String) r22;     // Catch: Throwable -> L33
        r23 = r36;
        goto L88
    L60:
        if (r32 != 10) goto L62;
    L74:
        r33 = PreloadType.f4334b;     // Catch: Throwable -> L33
        goto L76
    L62:
        if (r32 == 11) goto L74;
        Object r39 = r111.remove("type");     // Catch: Throwable -> L33
        if ((r39 instanceof String) == true) goto L66;
        r39 = null;
    L66:
        String r40 = (String) r39;     // Catch: Throwable -> L33
        if (r40 != null) goto L69;
    L72:
        String r41 = "LYNX";
    L73:
        r33 = PreloadType.valueOf(r41);     // Catch: Throwable -> L33
        goto L76
    L69:
        if (r40.length() == 0) goto L72;
        r41 = r40.toUpperCase();     // Catch: Throwable -> L33
    L88:
        if (r23 != null) goto L91;
        f0.n(4, "PreloadAPI", "Building PreloadConfig for " + this.f4228b + " failed, no matched item in preload.json");     // Catch: Throwable -> L33
        return;
    L91:
        this.f4227a.preload(r23, this.d, this.e);     // Catch: Throwable -> L33
        return;
    L55:
        r111 = r31;
        goto L56
    L48:
        r27 = this.f4228b;     // Catch: Throwable -> L33
        goto L49
    L30:
        if (Intrinsics.areEqual(r26.getScheme(), IIvyAIPackageResourceService.SCHEMA) == true) goto L35;
        r18 = false;
    L33:
        th = move-exception;
        f0.n(4, "PreloadAPI", "Building PreloadConfig for " + this.f4228b + " failed, " + th);
    }
}
