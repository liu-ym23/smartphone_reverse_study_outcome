package rb8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.block.base.config.BlockDetailRequest;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kc8.w0;
import kc8.y;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [T extends jc8.a, java.lang.Object, jc8.a] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object, jc8.a] */
    /* JADX WARN: Type inference failed for: r12v5, types: [jc8.a] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public static final <T extends jc8.a> void a(jc8.b<T> r11, T r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "blockModel");
        final kc8.b r0 = (kc8.b) jc8.c.a(r11, kc8.b.class);
        View r14 = r11.c;
        if (r14 == null) goto L6;
        Context r15 = r14.getContext();
        if (r15 == null) goto L6;
    L15:
        if (r0 == null) goto L21;
        w0 r2 = r0.v;
        if (r2 == null) goto L21;
        kc8.d r3 = r2.c;
        if (r3 == null) goto L21;
    L27:
        Message r1 = r12.j();
        Message r4 = r12.b;
        boolean r5 = true;
        if (r4 == null) goto L95;
        String r6 = r12.h();
        if (r6.length() <= 0) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == true) goto L37;
        r6 = null;
    L37:
        if (r6 == null) goto L95;
        List r8 = r4.getContentBlock();
        if (r8 != null) goto L43;
        r8 = CollectionsKt.emptyList();
    L43:
        if (r8.isEmpty() == true) goto L95;
        LinkedHashMap r9 = new LinkedHashMap(r8.size());
        Iterator r10 = r8.iterator();
    L47:
        if (r10.hasNext() == false) goto L62;
        Block r16 = (Block) r10.next();
        String r17 = r16.getBlockId();
        if (r17 == null) goto L47;
        if (r17.length() <= 0) goto L53;
        boolean r18 = true;
    L54:
        if (r18 == true) goto L57;
        r17 = null;
    L57:
        if (r17 == null) goto L47;
        if (r9.get(r17) != null) goto L47;
        r9.put(r17, r16);
        goto L47
    L53:
        r18 = false;
        goto L54
    L62:
        Block r19 = (Block) r9.get(r6);
        if (r19 == null) goto L95;
        ArrayList r20 = new ArrayList();
        LinkedHashSet r21 = new LinkedHashSet();
    L66:
        if (r19 == null) goto L93;
        String r22 = r19.getBlockId();
        if (r22 == null) goto L93;
        if (r22.length() <= 0) goto L72;
        boolean r110 = true;
    L73:
        if (r110 == true) goto L76;
        r22 = null;
    L76:
        if (r22 == null) goto L93;
        if (r21.add(r22) == false) goto L93;
        ListProtector.add(r20, 0, r19);
        String r23 = r19.getParentId();
        if (r23 == null) goto L91;
        if (r23.length() <= 0) goto L85;
        boolean r24 = true;
    L86:
        if (r24 == true) goto L89;
        r23 = null;
    L89:
        if (r23 == null) goto L91;
        r19 = (Block) r9.get(r23);
        goto L66
    L85:
        r24 = false;
    L91:
        r19 = null;
        goto L66
    L72:
        r110 = false;
    L93:
        if ((!r20.isEmpty()) == false) goto L95;
    L96:
        if (r20 != null) goto L106;
        r20 = new ArrayList();
        LinkedHashSet r25 = new LinkedHashSet();
    L99:
        if (r12 == 0) goto L106;
        if (r25.add(r12) == false) goto L106;
        ListProtector.add(r20, 0, r12.a);
        jc8.f r111 = r12.d;
        if (r111 != null) goto L104;
        r12 = (T) null;
        goto L99
    L104:
        r12 = r111.c;
    L106:
        if (r13 != null) goto L108;
    L115:
        r13 = r15.getString(2131906598);
    L116:
        r3.a(new BlockDetailRequest(r1, r20, r13));
        return;
    L108:
        if (r13.length() > 0) goto L111;
        r5 = false;
    L111:
        if (r5 == true) goto L114;
        r13 = null;
    L114:
        if (r13 != null) goto L116;
    L33:
        r7 = false;
    L95:
        r20 = null;
    L21:
        if (r0 == null) goto L25;
        y r26 = r0.a;
        if (r26 == null) goto L25;
        Fragment r27 = r26.a;
    L26:
        r3 = new com.larus.bmhome.block.presentation.a(r27, new f(r0));
    L25:
        r27 = null;
    L6:
        if (r0 == null) goto L12;
        y r112 = r0.a;
        if (r112 == null) goto L12;
        Fragment r113 = r112.a;
        if (r113 == null) goto L12;
        r15 = r113.getContext();
    L13:
        if (r15 != null) goto L15;
        r15 = FlowRuntime.a().getApplication();
    L12:
        r15 = null;
        goto L13
    }
}
