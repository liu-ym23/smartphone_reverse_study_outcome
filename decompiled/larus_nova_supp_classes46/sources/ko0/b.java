package ko0;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final Map<String, String> g;
    public String h;
    public final Map<String, String> i;
    public final Map<String, String> j;
    public final boolean k;
    public final boolean l;
    public final List<String> m;

    public b(String r17, String r18, String r19, String r20, String r21, String r22, Map r23, Map r24, Map r25, boolean r26, boolean r27, List r28, int r29) {
        String r6 = "";
        if ((r29 & 8) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r29 & 16) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r29 & 32) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r29 & 64) == 0) goto L17;
        Object r9 = "";
    L19:
        if ((r29 & 128) == 0) goto L21;
        Map r11 = new LinkedHashMap();
    L23:
        if ((r29 & 256) != 0) goto L27;
        r6 = null;
    L27:
        if ((r29 & 512) == 0) goto L29;
        Map r10 = new LinkedHashMap();
    L31:
        if ((r29 & 1024) == 0) goto L33;
        Map r12 = new LinkedHashMap();
    L34:
        boolean r14 = false;
        if ((r29 & 2048) == 0) goto L37;
        boolean r13 = false;
    L39:
        if ((r29 & 4096) != 0) goto L43;
        r14 = r27;
    L43:
        if ((r29 & 8192) == 0) goto L45;
        List r4 = new ArrayList();
    L46:
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r18, "launchFrom");
        Intrinsics.checkNotNullParameter(r19, "location");
        Intrinsics.checkNotNullParameter(r5, "entranceForm");
        Intrinsics.checkNotNullParameter(r7, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r8, "enterPosition");
        Intrinsics.checkNotNullParameter(r9, "anchorAction");
        Intrinsics.checkNotNullParameter(r11, "bdpLogExtra");
        Intrinsics.checkNotNullParameter(r6, "path");
        Intrinsics.checkNotNullParameter(r10, "queryExtra");
        Intrinsics.checkNotNullParameter(r12, "customFieldExtra");
        Intrinsics.checkNotNullParameter(r4, "serverScenes");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r11;
        this.h = r6;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r4;
        return;
    L45:
        r4 = r28;
        goto L46
    L37:
        r13 = r26;
        goto L39
    L33:
        r12 = r25;
        goto L34
    L29:
        r10 = r24;
        goto L31
    L21:
        r11 = r23;
        goto L23
    L17:
        r9 = null;
        goto L19
    L13:
        r8 = r22;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }
}
