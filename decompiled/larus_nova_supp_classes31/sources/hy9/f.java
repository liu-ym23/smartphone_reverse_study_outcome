package hy9;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.view.AttachmentInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ny9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final Fragment a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final u f;
    public final Map<String, String> g;
    public final String h;
    public final u7 i;
    public final IChatDoubleTabAbility j;
    public final ICoreInputAbility k;
    public final String l;
    public final AttachmentInfo m;
    public final List<String> n;
    public final String o;

    public f(Fragment r11, String r12, String r13, String r14, String r15, u r16, Map r17, String r18, u7 r19, IChatDoubleTabAbility r20, ICoreInputAbility r21, AttachmentInfo r22, String r23, int r24) {
        String r6 = null;
        if ((r24 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r24 & 4096) == 0) goto L9;
        AttachmentInfo r7 = null;
    L11:
        if ((r24 & 16384) == 0) goto L13;
        ArrayList r8 = new ArrayList();
    L15:
        if ((r24 & 32768) != 0) goto L18;
        r6 = r23;
    L18:
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r13, "cvsId");
        Intrinsics.checkNotNullParameter(r14, "prompt");
        Intrinsics.checkNotNullParameter("coco_instruction", "actionBarKey");
        Intrinsics.checkNotNullParameter(r8, "inputFilePaths");
        this.a = r11;
        this.b = r5;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = "coco_instruction";
        this.m = r7;
        this.n = r8;
        this.o = r6;
        return;
    L13:
        r8 = null;
        goto L15
    L9:
        r7 = r22;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
