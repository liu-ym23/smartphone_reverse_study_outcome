package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c1 {
    public static final Regex m = null;
    public final ICoreInputAbility a;
    public final com.larus.bmhome.chat.component.cvs.y b;
    public final com.larus.bmhome.instruction.h c;
    public final fx9.a d;
    public Map<String, String> e;
    public Map<String, String> f;
    public String g;
    public boolean h;
    public Message i;
    public final d j;
    public final c k;
    public final b l;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.c {
        public final /* synthetic */ c1 a;

        public b(c1 r1) {
            this.a = r1;
        }

        public final String a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "asrResult");
            return r2;
        }

        public final String b(String r15) {
            Intrinsics.checkNotNullParameter(r15, "content");
            String r16 = StringsKt.replace$default(r15, "￼", "", false, 4, null);
            String r0 = this.a.g;
            if (r0 != null) goto L5;
            return r16;
        L5:
            if ((!StringsKt.isBlank(r0)) == true) goto L8;
            r0 = null;
        L8:
            if (r0 != null) goto L11;
            return r16;
        L11:
            if (StringsKt.startsWith$default(r16, r0, false, 2, null) == false) goto L13;
            return r16;
        L13:
            StringBuilder r4 = new StringBuilder();
            r4.append(r0);
            this.a.getClass();
            r4.append(StringsKt.removePrefix(r16, SequencesKt.joinToString$default(SequencesKt.mapNotNull(Regex.findAll$default(c1.m, r0, 0, 2, null), new z0()), "", null, null, 0, null, new a1(), 30, null)));
            return r4.toString();
        }
    }

    public static final class c implements ICoreInputAbility.d {
        public final /* synthetic */ c1 a;

        public final void a() {
        }

        public final void c() {
        }

        public c(c1 r1) {
            this.a = r1;
        }

        public final void b(ICoreInputAbility.OnSendParams r7) {
            Intrinsics.checkNotNullParameter(r7, "params");
            c1 r8 = this.a;
            Map<String, String> r0 = r8.e;
            if (r0 == null) goto L8;
            IAIChatRenderTraceService.Companion r1 = IAIChatRenderTraceService.a;
            Map r2 = r1.d(r8.a());
            FLogger.a.d("WcbFillInputMgr", "onSendMsg recordParams=" + r0 + " currentExt=" + r2);
            if (r2 != null) goto L7;
            r1.c(r8.a(), r0);
            goto L8
        L7:
            r1.e(r8.a(), r0);
        L8:
            c1 r9 = this.a;
            Message r3 = r9.i;
            if (r3 != null) goto L11;
        L13:
            r3 = null;
        L14:
            c1 r10 = this.a;
            r10.e = null;
            r10.g = null;
            r10.i = null;
            com.larus.bmhome.instruction.h r4 = r10.c;
            if (r4 == null) goto L17;
            r4.nT("PromptFillInputManager.clearRecordParams");
        L17:
            com.larus.utils.t0.a.post(new b1(r10));
            if (r3 == null) goto L23;
            fx9.a r11 = this.a.d;
            if (r11 == null) goto L24;
            r11.yT(r3);
            return;
        L24:
            return;
        L23:
            return;
        L11:
            if (Intrinsics.areEqual(r3.getConversationId(), r9.a()) == false) goto L13;
            goto L13
        }
    }

    public static final class d implements ICoreInputAbility.e {
        public final /* synthetic */ c1 a;

        public d(c1 r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            if (r5.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L13;
            c1 r2 = this.a;
            if (r2.e == null) goto L13;
            r2.e = null;
            r2.g = null;
            r2.i = null;
            com.larus.bmhome.instruction.h r3 = r2.c;
            if (r3 == null) goto L12;
            r3.nT("PromptFillInputManager.clearRecordParams");
        L12:
            com.larus.utils.t0.a.post(new b1(r2));
        L13:
            Intrinsics.checkNotNullParameter(r5, "content");
            return;
        L5:
            r1 = false;
            goto L6
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    static {
        m = new Regex("(?<!\\\\)\\[(?:\\\\[^\\r\\n]|[^\\x5D\\\\\\r\\n])+]\\((skill://[^\\s)]+)\\)", RegexOption.IGNORE_CASE);
    }

    public final String a() {
        com.larus.bmhome.chat.component.cvs.y r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.Y1();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public c1(ICoreInputAbility r1, com.larus.bmhome.chat.component.cvs.y r2, com.larus.bmhome.instruction.h r3, fx9.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.j = new d(this);
        this.k = new c(this);
        this.l = new b(this);
    }
}
