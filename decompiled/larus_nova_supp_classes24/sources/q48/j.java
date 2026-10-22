package q48;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;
import tr3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements f {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function3 b;

    public /* synthetic */ j(Function1 r1, Function3 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(boolean r10, JSONObject r11) {
        Function1 r0 = this.a;
        Function3 r1 = this.b;
        Objects.toString(r11);
        boolean r2 = true;
        if (r10 == true) goto L5;
        if (r11 == null) goto L50;
        int r12 = r11.optInt("code", 0);
        if (r12 != (-1)) goto L43;
    L46:
        if (r0 == null) goto L48;
        r0.invoke(Boolean.valueOf(r2));
    L48:
        if (r1 == null) goto L65;
        r1.invoke(Boolean.valueOf(r2), Integer.valueOf(r12), r11.toString());
        return;
    L65:
        return;
    L43:
        if (r12 == 5) goto L46;
        r2 = false;
        goto L46
    L50:
        if (r0 == null) goto L52;
        r0.invoke(Boolean.FALSE);
    L52:
        if (r1 == null) goto L67;
        r1.invoke(Boolean.FALSE, 0, "log config is null");
        return;
    L67:
        return;
    L5:
        if (ObricAlogServiceDelegate.b.f() == true) goto L35;
        File r13 = new PolarisFileWrapper(ALog.sConfig.getLogDirPath());
        if (r13.exists() == true) goto L9;
    L11:
        boolean r14 = false;
    L12:
        if (r14 == true) goto L15;
        r13 = null;
    L15:
        if (r13 == null) goto L35;
        File[] r15 = r13.listFiles();
        if (r15 == null) goto L35;
        ArrayList r16 = new ArrayList();
        int r5 = r15.length;
        int r6 = 0;
    L19:
        if (r6 >= r5) goto L29;
        File r7 = r15[r6];
        if (r7.exists() == true) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L28;
        r16.add(r7);
    L28:
        r6 = r6 + 1;
        goto L19
    L23:
        if (r7.isFile() == false) goto L25;
        r8 = true;
        goto L26
    L29:
        Iterator r17 = r16.iterator();
    L31:
        if (r17.hasNext() == false) goto L35;
        File r19 = (File) r17.next();
        if (r19 == null) goto L31;
        r19.delete();
        goto L31
    L9:
        if (r13.listFiles() == null) goto L11;
        r14 = true;
    L35:
        if (r0 == null) goto L37;
        r0.invoke(Boolean.TRUE);
    L37:
        if (r1 == null) goto L63;
        r1.invoke(Boolean.TRUE, -1, "");
        return;
    }
}
