package com.ss.android.lark.richtextmd.parse.impl;

import android.content.Context;
import b3c.d;
import com.ss.android.lark.coremd.utils.BISURelocator;
import com.ss.android.lark.coremd.utils.NodeBISUUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.richtextmd.RichTextBISUUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.e;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements d {
    public static final /* synthetic */ int f = 0;
    public final Context a;
    public final ConcurrentHashMap<RichTextElement.RichTextTag, b3c.a> b;
    public final List<b3c.c> c;
    public final BISURelocator d;
    public final C0130b e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.parse.impl.b$b, reason: collision with other inner class name */
    public static final class C0130b implements b3c.a {
        public C0130b() {
        }

        @Override // b3c.a
        public final boolean a() {
            return true;
        }

        @Override // b3c.a
        public final s b(b3c.b r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }
    }

    static {
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new ConcurrentHashMap();
        this.c = new ArrayList();
        this.d = new BISURelocator();
        this.e = new C0130b();
    }

    public final s b(Object r6) {
        RichText r7 = (RichText) r6;
        if (r7 != null) goto L5;
        r7 = com.ss.android.lark.widget.richtext.c.a();
    L5:
        Intrinsics.checkNotNull(r7);
        Iterator r0 = ((ArrayList) this.c).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((b3c.c) r0.next()).onParseStart();
        goto L7
    L9:
        e r1 = new e();
        List r2 = r7.getElementIds();
        RichText.RichTextElements r3 = r7.getElements();
        if (r3 == null) goto L25;
        Map r4 = r3.getDictionary();
        if (r4 == null) goto L25;
        Intrinsics.checkNotNull(r2);
        Iterator r5 = r2.iterator();
    L16:
        if (r5.hasNext() == false) goto L21;
        RichTextElement r8 = (RichTextElement) r4.get((String) r5.next());
        if (r8 == null) goto L16;
        c(r4, r8, r1, r7.getExtraInfo());
        goto L16
    L21:
        this.d.d(r1);
        Iterator r9 = ((ArrayList) this.c).iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        ((b3c.c) r9.next()).onParseEnd();
    L25:
        return r1;
    }

    @Override // b3c.d
    public final d a(RichTextElement.RichTextTag r2, b3c.a r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "nodeMapper");
        this.b.put(r2, r3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void c(Map r8, RichTextElement r9, s r10, RichTextExtraInfo r11) {
        c r6 = new c(this.a, r9, this, r11, r8);
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b3c.c) r0.next()).a();
        goto L4
    L6:
        b3c.a r1 = this.b.get(r9.getTag());
        if (r1 != null) goto L9;
        r1 = this.e;
    L9:
        s r2 = r1.b(r6);
        if (r2 == null) goto L26;
        Lazy r3 = RichTextBISUUtils.a;
        Map r4 = r9.getStyle();
        if (r4 != null) goto L14;
        r4 = MapsKt.emptyMap();
    L14:
        Intrinsics.checkNotNullParameter(r4, "styles");
        NodeBISUUtils r5 = NodeBISUUtils.c;
        boolean r7 = RichTextBISUUtils.a(r4);
        boolean r12 = RichTextBISUUtils.b(r4);
        boolean r13 = RichTextBISUUtils.d(r4);
        boolean r14 = RichTextBISUUtils.c(r4);
        r5.getClass();
        ?? r15 = r7;
        if (r12 == false) goto L17;
        r15 = (r7 ? 1 : 0) | 2;
    L17:
        if (r13 == false) goto L19;
        r15 = (r15 == true ? 1 : 0) | '\b';
    L19:
        if (r14 == false) goto L21;
        r15 = (r15 == true ? 1 : 0) | 4;
    L21:
        Intrinsics.checkNotNullParameter(r2, "node");
        NodeBISUUtils.b(r2, r15);
        r10.e(r2);     // Catch: Exception -> L24
    L24:
        Log.e("RichTextToNodeGenerator", "parent node type is " + r10.getClass().getSimpleName() + ", node type is " + r2.getClass().getSimpleName());
    L26:
        if (r1.a() == false) goto L39;
        if (r2 == null) goto L30;
        r10 = r2;
    L30:
        List r16 = r9.getChildIds();
        if (r16 == null) goto L39;
        Iterator r17 = r16.iterator();
    L34:
        if (r17.hasNext() == false) goto L39;
        RichTextElement r18 = (RichTextElement) r8.get((String) r17.next());
        if (r18 == null) goto L34;
        c(r8, r18, r10, r11);
    L39:
        Iterator r19 = ((ArrayList) this.c).iterator();
    L41:
        if (r19.hasNext() == false) goto L43;
        ((b3c.c) r19.next()).b();
        goto L41
    }
}
