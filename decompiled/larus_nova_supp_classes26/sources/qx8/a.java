package qx8;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import gx8.d;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends gx8.a {
    public static final a b = null;
    public static b c;
    public static int d;
    public static int e;
    public static boolean f;
    public static boolean g;
    public static boolean h;
    public static String i;
    public static boolean j;

    static {
        b = new a();
        e = 1;
        j = true;
    }

    @Override // gx8.a
    public final d b() {
        b r0 = new b();
        c = r0;
        return r0;
    }

    public final void i() {
        ((LinkedHashMap) this.a.b).clear();
        e = 1;
        d = 0;
        b r1 = c;
        if (r1 == null) goto L5;
        r1.a = null;
        r1.b = "";
    L5:
        f = false;
        g = false;
        h = false;
        i = null;
    }

    public a() {
    }

    public final void d(ICameraEventExt r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        i();
        if (r3 != null) goto L5;
        return;
    L5:
        b r1 = c;
        if (r1 == null) goto L9;
        JSONObject r5 = r3.enterPageEventExt();
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        r1.a = r5;
        r1.b = b.b(r4);
        return;
    }

    public final void e(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        gx8.b r0 = this.a;
        CameraEvent r1 = CameraEvent.CAPTURE_RESULT;
        JSONObject r2 = new JSONObject();
        r2.put("is_success", TriggerSendLoading.NO_LOADING);
        r2.put("error_msg", r7);
        r2.put("error_code", r6);
        Unit r8 = Unit.INSTANCE;
        r0.b(r1, r2);
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
    public final void g(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        FLogger.a.i("CameraMonitor", "[onRecordFail] from: " + i + ", hasReportRecordResult: " + g + ", triggerRecord: " + f + ", code:" + r6 + ", reason:" + r7);
        if (f == true) goto L5;
        return;
    L5:
        if (g == true) goto L10;
        gx8.b r0 = this.a;
        CameraEvent r1 = CameraEvent.RECORD_RESULT;
        JSONObject r2 = new JSONObject();
        r2.put("is_success", TriggerSendLoading.NO_LOADING);
        r2.put("error_msg", r7);
        r2.put("error_code", r6);
        r2.putOpt("record_mode", i);
        r2.put("enable_audio", h ? 1 : 0);
        Unit r8 = Unit.INSTANCE;
        r0.b(r1, r2);
        g = true;
        f = false;
        return;
    }

    public final void h(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        if (r5 > 0) goto L5;
        return;
    L5:
        gx8.b r0 = this.a;
        CameraEvent r1 = CameraEvent.PREVIEW_RENDER_FPS;
        JSONObject r2 = new JSONObject();
        r2.put("value", r5);
        r2.put("trigger_from", r6);
        Unit r7 = Unit.INSTANCE;
        r0.b(r1, r2);
    }

    public final void f(int r6, String r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        gx8.b r0 = this.a;
        CameraEvent r1 = CameraEvent.SAVE_LOCAL_RESULT;
        JSONObject r2 = new JSONObject();
        r2.put("is_success", TriggerSendLoading.NO_LOADING);
        r2.put("error_msg", r7);
        r2.put("error_code", r6);
        r2.put("multi_question", r8);
        r2.put("from_album", r9 ? 1 : 0);
        Unit r10 = Unit.INSTANCE;
        r0.b(r1, r2);
    }
}
