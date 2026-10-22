package com.larus.camera.impl.result;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.camera.command.k;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.camera.impl.ui.activity.CameraCaptureFirstActivity;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;
    public static final ConcurrentHashMap<String, CameraResultFirstFlow.a> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new ConcurrentHashMap();
    }

    public static String d(InputParam r1) {
        if (r1 == null) goto L6;
        InputParamExtra r2 = r1.getExtra();
        if (r2 == null) goto L6;
        return (String) r2.get("extra_camera_capture_first_command_session_id");
    L6:
        return null;
    }

    public static boolean e(Activity r2) {
        InputParam r0 = null;
        if (r2 == null) goto L7;
        Intent r3 = r2.getIntent();
        if (r3 == null) goto L7;
        Serializable r4 = r3.getSerializableExtra("CAMERA_INPUT_PARAM");
    L9:
        if ((r4 instanceof InputParam) == false) goto L11;
        r0 = (InputParam) r4;
    L11:
        String r5 = d(r0);
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L19:
        return !r6;
    L14:
        if (r5.length() == 0) goto L17;
        r6 = false;
    L7:
        r4 = null;
        goto L9
    }

    public static void f(InputParam r2) {
        String r0 = d(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 == null) goto L9;
        InputParamExtra r3 = r2.getExtra();
        if (r3 == null) goto L9;
        String r4 = (String) r3.remove("extra_camera_capture_first_command_session_id");
    L9:
        g(r0);
    }

    public static void g(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        CameraResultFirstFlow.a r4 = b.remove(r3);
        if (r4 != null) goto L14;
        return;
    L14:
        if (FlowCameraImpl.c != r4.j) goto L16;
        FlowCameraImpl.c = r4.a;
    L16:
        r4.b(null);
        CoroutineScopeKt.cancel$default(r4.c, null, 1, null);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean a(FragmentActivity r4, CameraOutputContext r5) {
        Intrinsics.checkNotNullParameter(r5, "outputContext");
        SuggestedAction r0 = null;
        if (r4 == null) goto L7;
        Intent r6 = r4.getIntent();
        if (r6 == null) goto L7;
        Serializable r7 = r6.getSerializableExtra("CAMERA_INPUT_PARAM");
    L9:
        if ((r7 instanceof InputParam) == false) goto L11;
        InputParam r8 = (InputParam) r7;
    L12:
        String r1 = d(r8);
        if (r1 != null) goto L15;
        return false;
    L15:
        CameraResultFirstFlow.a r2 = b.get(r1);
        if (r2 == null) goto L20;
        r0 = r2.j.d;
        if (r0 != null) goto L20;
        r0 = r2.h;
    L20:
        f(r8);
        String r9 = k.a(r5, r0);
        ObricChatSPIServiceDelegate r10 = ObricChatSPIServiceDelegate.b;
        Bundle r3 = new Bundle();
        r3.putString("KEY_CAMERA_RESULT_PENDING_SESSION_ID", r9);
        if (r10.m(r3) == false) goto L23;
        FLogger.a.i("CameraCaptureFirstFlow", "open chat with capture pending result key=" + r9);
        return true;
    L23:
        FLogger.a.e("CameraCaptureFirstFlow", "open chat failed for capture-first");
        k.b(r9);
        return false;
    L11:
        r8 = null;
    L7:
        r7 = null;
        goto L9
    }

    public static boolean b(Activity r5, String r6) {
        Intent r7 = r5.getIntent();
        String r0 = null;
        if (r7 == null) goto L5;
        Serializable r8 = r7.getSerializableExtra("CAMERA_INPUT_PARAM");
    L7:
        if ((r8 instanceof InputParam) == false) goto L9;
        InputParam r9 = (InputParam) r8;
    L10:
        String r1 = d(r9);
        boolean r2 = true;
        if (r1 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        return false;
    L19:
        f(r9);
        ObricChatSPIServiceDelegate r10 = ObricChatSPIServiceDelegate.b;
        Bundle r4 = new Bundle();
        if (r6 != null) goto L22;
    L29:
        boolean r11 = r10.m(r4);
        if (r11 == false) goto L32;
        FLogger.a.i("CameraCaptureFirstFlow", "open chat for sent creation message, conversationId=" + r6);
    L33:
        return r11;
    L32:
        FLogger.a.e("CameraCaptureFirstFlow", "open chat failed for sent creation message, conversationId=" + r6);
        goto L33
    L22:
        if (r6.length() > 0) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        r0 = r6;
    L27:
        if (r0 == null) goto L29;
        r4.putString("argConversationId", r0);
        goto L29
    L13:
        if (r1.length() == 0) goto L16;
        r3 = false;
        goto L17
    L9:
        r9 = null;
        goto L10
    L5:
        r8 = null;
        goto L7
    }

    public static Intent c(Context r2, InputParam r3, Map r4) {
        Intent r0 = new Intent(r2, CameraCaptureFirstActivity.class);
        r0.putExtra("CAMERA_INPUT_PARAM", r3);
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r6 = (Map.Entry) r5.next();
        r0.putExtra((String) r6.getKey(), ((Boolean) r6.getValue()).booleanValue());
        goto L4
    L7:
        if ((r2 instanceof Activity) == true) goto L9;
        r0.addFlags(335577088);
    L9:
        return r0;
    }
}
