package com.obric.aiagent.authentication;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.a.c;
import com.bytedance.a.d;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00112\u0006\u0010\u0017\u001a\u00020\u0010J?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b \u0010!J$\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100%H\u0002J\u001c\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u00102\b\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fj\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/aiagent/authentication/AuthPolicyManager;", "", "context", "Landroid/content/Context;", "controller", "Lcom/obric/aiagent/authentication/IPolicyController;", "<init>", "(Landroid/content/Context;Lcom/obric/aiagent/authentication/IPolicyController;)V", "hasLoaded", "", "appAuthUtil", "Lcom/bytedance/aisecurity/AuthorizedApps;", "gson", "Lcom/google/gson/Gson;", "categoryPolicies", "Ljava/util/HashMap;", "", "", "Lcom/obric/aiagent/authentication/ProcessPolicies;", "Lkotlin/collections/HashMap;", "loadFromAssets", "", "policyFiles", "authorizedAppsFile", "getAuthPolicy", "Lkotlin/Result;", "", EventBody.KEY_CATEGORY, "subject", TypedValues.AttributesType.S_TARGET, "action", "subAction", "getAuthPolicy-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "replacePlaceholders", "jsonString", "values", "", "checkSignature", Params.CONTENT, "signature", "Companion", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0228a f5907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5908b;
    private final b c;
    private boolean d;
    private final com.bytedance.a.a e;
    private final Gson f;
    private final HashMap<String, List<ProcessPolicies>> g;

    /* JADX INFO: renamed from: com.obric.aiagent.authentication.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/authentication/AuthPolicyManager$Companion;", "", "<init>", "()V", "POLICIES_DIR", "", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0228a {
        private C0228a() {
        }

        public /* synthetic */ C0228a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5907a = new C0228a(null);
    }

    public a(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f5908b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r6;
        this.e = new com.bytedance.a.a();
        this.f = new Gson();
        this.g = new HashMap();
    }

    private final String a(String r8, Map<String, String> r9) {
        Iterator r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        String r1 = r8;
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");
        r1 = StringsKt.replace$default(r1, "{{" + r11 + "}}", (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.memorydata.plugin"), false, 4, null);
        goto L4
    L6:
        return r1;
    }

    private final boolean a(String r4, String r5) {
        if (r4 == null) goto L16;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L17;
        c r3 = new c();
        byte[] r6 = r4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r6, "getBytes(...)");
        if (r3.a(r6, d.a(r5), 1) == 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L16:
        return false;
    }

    public final Object a(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r9, "subject");
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r11, "action");
        List r13 = (List) ZeusTransformUtils.preCheckCast(this.g.get(r8), List.class, "com.obric.memorydata.plugin");
        Object r0 = null;
        if (r13 == null) goto L27;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r14.hasNext() == false) goto L25;
        Object r4 = r14.next();
        ProcessPolicies r5 = (ProcessPolicies) ZeusTransformUtils.preCheckCast(r4, ProcessPolicies.class, "com.obric.memorydata.plugin");
        List<String> r6 = r5.getSubject();
        if (r6 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L22;
        List<String> r15 = r5.getTarget();
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        if (r16 == false) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L6;
    L26:
        ProcessPolicies r18 = (ProcessPolicies) ZeusTransformUtils.preCheckCast(r4, ProcessPolicies.class, "com.obric.memorydata.plugin");
    L28:
        if (r18 == null) goto L71;
        Map<String, ActionPolicy> r19 = r18.getActions();
        if (r19 == null) goto L71;
        Set<Map.Entry<String, ActionPolicy>> r20 = r19.entrySet();
        if (r20 == null) goto L71;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r21.hasNext() == false) goto L45;
        Object r22 = r21.next();
        Map.Entry r23 = (Map.Entry) ZeusTransformUtils.preCheckCast(r22, Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r23.getKey(), r11) == false) goto L39;
    L42:
        boolean r24 = true;
    L43:
        if (r24 == false) goto L35;
        r0 = r22;
        goto L45
    L39:
        if (Intrinsics.areEqual(r23.getKey(), "*") == true) goto L42;
        r24 = false;
    L45:
        Map.Entry r25 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L71;
        ActionPolicy r26 = (ActionPolicy) ZeusTransformUtils.preCheckCast(r25.getValue(), ActionPolicy.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L71;
        if (r12 != null) goto L51;
        r12 = "";
    L51:
        String r110 = r12.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r110, "toLowerCase(...)");
        PolicyItem r27 = r26.getSubActionPolicy(r110);
        if (r27 == null) goto L71;
        if (this.e.a(r9) == true) goto L60;
        Result.Companion r28 = Result.Companion;
        RuntimeException r29 = new RuntimeException("Subject app authentication error");
    L56:
        Object r30 = ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(r29, Throwable.class, "com.obric.memorydata.plugin"));
    L58:
        return Result.m1421constructorimpl(r30);
    L60:
        if (this.e.b(r10) == true) goto L63;
        Result.Companion r31 = Result.Companion;
        r29 = new RuntimeException("Target app authentication error");
        goto L56
    L63:
        if (r27.getSettingKey() == null) goto L70;
        b r32 = this.c;
        if (r32 == null) goto L70;
        if (r32.a(r27.getSettingKey()) == false) goto L70;
        Result.Companion r33 = Result.Companion;
        int r34 = this.c.b(r27.getSettingKey());
    L69:
        r30 = Integer.valueOf(r34);
    L70:
        Result.Companion r35 = Result.Companion;
        r34 = r27.getType();
    L71:
        Result.Companion r36 = Result.Companion;
        r29 = new RuntimeException("No applicable policy");
        goto L56
    L17:
        if (r15.contains(r10) != true) goto L19;
        r16 = true;
    L22:
        r17 = false;
        goto L23
    L10:
        if (r6.contains(r9) != true) goto L12;
        r7 = true;
        goto L13
    L25:
        r4 = null;
        goto L26
    L27:
        r18 = null;
        goto L28
    }

    public final void a(List<String> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "policyFiles");
        Intrinsics.checkNotNullParameter(r10, "authorizedAppsFile");
        if (this.d == true) goto L55;
        File r2 = new File(new File(this.f5908b.getFilesDir(), "authentication_policies"), r10);
        File r0 = r2.getParentFile();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L14;
        File r3 = r2.getParentFile();
        if (r3 == null) goto L14;
        r3.mkdirs();
    L14:
        InputStream r12 = this.f5908b.getAssets().open(r10);
        Intrinsics.checkNotNull(r12);
        ByteStreamsKt.copyTo$default(r12, (OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);
        this.e.a(this.f5908b, r2.getPath(), 1);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r13.hasNext() == false) goto L52;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        InputStream r4 = this.f5908b.getAssets().open(r14);
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L49
        JSONObject r5 = new JSONObject(StringsKt.decodeToString(ByteStreamsKt.readBytes(r4)));     // Catch: Throwable -> L49
        JSONObject r6 = r5.optJSONObject(Params.CONTENT);     // Catch: Throwable -> L49
        String r7 = r5.optString("signature");     // Catch: Throwable -> L49
        if (r6 == null) goto L21;
        String r8 = r6.toString();     // Catch: Throwable -> L49
    L23:
        if (a(r8, r7) == false) goto L16;
        if (r6 == null) goto L26;
        Integer r15 = Integer.valueOf(r6.optInt("version"));     // Catch: Throwable -> L49
    L27:
        if (r15 == null) goto L16;
        if (r15.intValue() != 1) goto L16;
        Gson r16 = this.f;     // Catch: Throwable -> L49
        String r17 = r6.toString();     // Catch: Throwable -> L49
        Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");     // Catch: Throwable -> L49
        V1PolicyContent r18 = (V1PolicyContent) ZeusTransformUtils.preCheckCast(r16.fromJson(a(r17, MapsKt.mapOf(TuplesKt.to("currentPackageName", this.f5908b.getPackageName()))), V1PolicyContent.class), V1PolicyContent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18.getCategory(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        if (r19 != null) goto L34;
    L37:
        boolean r20 = true;
    L38:
        if (r20 == true) goto L16;
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(r18.getPolicies(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        if (r21 != null) goto L42;
    L45:
        boolean r22 = true;
    L46:
        if (r22 == true) goto L16;
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).put(r18.getCategory(), r18.getPolicies());     // Catch: Throwable -> L49
        goto L16
    L42:
        if (r21.isEmpty() == true) goto L45;
        r22 = false;
        goto L46
    L34:
        if (r19.length() == 0) goto L37;
        r20 = false;
        goto L38
    L26:
        r15 = null;
        goto L27
    L21:
        r8 = null;
    L49:
        th = move-exception;
        throw new RuntimeException("parse policy file " + r14 + " failed", th);
    L52:
        this.d = true;
        return;
    L7:
        if (r0.exists() != true) goto L9;
        r1 = true;
        goto L10
    L55:
        throw new IllegalStateException("authentication policies has been loaded");
    }
}
