package co;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e {
    public a(HashMap r10) {
        super(r10);
        if (r10.get("identifier") == null) goto L6;
        String r11 = (String) r10.get("identifier");
    L6:
        if (r10.get("pipelineStart") == null) goto L9;
        ((Double) r10.get("pipelineStart")).getClass();
    L9:
        if (r10.get("pipelineEnd") == null) goto L12;
        ((Double) r10.get("pipelineEnd")).getClass();
    L12:
        if (r10.get("mtsRenderStart") == null) goto L15;
        ((Double) r10.get("mtsRenderStart")).getClass();
    L15:
        if (r10.get("mtsRenderEnd") == null) goto L18;
        ((Double) r10.get("mtsRenderEnd")).getClass();
    L18:
        if (r10.get("resolveStart") == null) goto L21;
        ((Double) r10.get("resolveStart")).getClass();
    L21:
        if (r10.get("resolveEnd") == null) goto L24;
        ((Double) r10.get("resolveEnd")).getClass();
    L24:
        if (r10.get("layoutStart") == null) goto L27;
        ((Double) r10.get("layoutStart")).getClass();
    L27:
        if (r10.get("layoutEnd") == null) goto L30;
        ((Double) r10.get("layoutEnd")).getClass();
    L30:
        if (r10.get("paintingUiOperationExecuteStart") == null) goto L33;
        ((Double) r10.get("paintingUiOperationExecuteStart")).getClass();
    L33:
        if (r10.get("paintingUiOperationExecuteEnd") == null) goto L36;
        ((Double) r10.get("paintingUiOperationExecuteEnd")).getClass();
    L36:
        if (r10.get("layoutUiOperationExecuteStart") == null) goto L39;
        ((Double) r10.get("layoutUiOperationExecuteStart")).getClass();
    L39:
        if (r10.get("layoutUiOperationExecuteEnd") == null) goto L42;
        ((Double) r10.get("layoutUiOperationExecuteEnd")).getClass();
    L42:
        if (r10.get("paintEnd") == null) goto L45;
        ((Double) r10.get("paintEnd")).getClass();
    L45:
        if (r10.get("frameworkRenderingTiming") == null) goto L47;
        HashMap r5 = (HashMap) r10.get("frameworkRenderingTiming");
    L49:
        if (r10.get("hostPlatformTiming") == null) goto L72;
        HashMap r12 = (HashMap) r10.get("hostPlatformTiming");
        if (r12.get("hostPlatformType") == null) goto L54;
        String r13 = (String) r12.get("hostPlatformType");
    L54:
        if (r12.get("measureStart") == null) goto L57;
        ((Double) r12.get("measureStart")).getClass();
    L57:
        if (r12.get("measureEnd") == null) goto L60;
        ((Double) r12.get("measureEnd")).getClass();
    L60:
        if (r12.get("layoutStart") == null) goto L63;
        ((Double) r12.get("layoutStart")).getClass();
    L63:
        if (r12.get("layoutEnd") == null) goto L66;
        ((Double) r12.get("layoutEnd")).getClass();
    L66:
        if (r12.get("drawStart") == null) goto L69;
        ((Double) r12.get("drawStart")).getClass();
    L69:
        if (r12.get("drawEnd") == null) goto L94;
        ((Double) r12.get("drawEnd")).getClass();
        return;
    L94:
        return;
    L72:
        HashMap r14 = new HashMap();
        if (r14.get("hostPlatformType") == null) goto L76;
        String r15 = (String) r14.get("hostPlatformType");
    L76:
        if (r14.get("measureStart") == null) goto L79;
        ((Double) r14.get("measureStart")).getClass();
    L79:
        if (r14.get("measureEnd") == null) goto L82;
        ((Double) r14.get("measureEnd")).getClass();
    L82:
        if (r14.get("layoutStart") == null) goto L85;
        ((Double) r14.get("layoutStart")).getClass();
    L85:
        if (r14.get("layoutEnd") == null) goto L88;
        ((Double) r14.get("layoutEnd")).getClass();
    L88:
        if (r14.get("drawStart") == null) goto L91;
        ((Double) r14.get("drawStart")).getClass();
    L91:
        if (r14.get("drawEnd") == null) goto L95;
        ((Double) r14.get("drawEnd")).getClass();
        return;
    L95:
        return;
    L47:
        new HashMap();
        goto L49
    }
}
