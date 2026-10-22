package io.noties.markwon.html;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class v {

    static class a extends v {
        a() {
        }

        @Override // io.noties.markwon.html.v
        <T extends Appendable & CharSequence> void a(T r9, String r10) {
            Appendable r8 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r9, Appendable.class, "com.obric.memorydata.plugin");
            int r11 = ((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length();
            int r1 = r10.length();
            int r3 = 0;
            boolean r4 = false;
        L4:
            if (r3 >= r1) goto L16;
            char r6 = r10.charAt(r3);
            if (Character.isWhitespace(r6) == false) goto L8;
            r4 = true;
        L15:
            r3 = r3 + 1;
            goto L4
        L8:
            if (r4 == false) goto L14;
            int r5 = ((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length();
            if (r5 <= 0) goto L14;
            if (Character.isWhitespace(((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).charAt(r5 - 1)) == true) goto L14;
            io.noties.markwon.html.a.a(r8, ' ');
        L14:
            io.noties.markwon.html.a.a(r8, r6);
            r4 = false;
            goto L15
        L16:
            if (r4 == true) goto L18;
            return;
        L18:
            if (r11 >= ((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length()) goto L25;
            io.noties.markwon.html.a.a(r8, ' ');
            return;
        }
    }

    v() {
    }

    static v a() {
        return new a();
    }

    abstract <T extends Appendable & CharSequence> void a(T r1, String r2);
}
