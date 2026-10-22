package kr8;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.trace.m0;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r implements m0 {
    public final /* synthetic */ WeakReference<com.larus.bmhome.music.instructions.g> a;
    public final /* synthetic */ String b;

    @Override // com.larus.bmhome.chat.trace.m0
    public final void onReceive(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    public r(WeakReference<com.larus.bmhome.music.instructions.g> r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.bmhome.chat.trace.m0
    public final void a(Message r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "msg");
        Integer r1 = ic8.j.b(r19);
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.intValue() != 1) goto L24;
        LruCache<String, wc9.e> r2 = ko8.a.a;
        IAIChatControlTraceService.Companion r3 = IAIChatControlTraceService.a;
        String r11 = ko8.a.e(r3.gb());
        Map r4 = r19.getExt();
        if (r4 == null) goto L10;
        String r5 = (String) r4.get("action_bar_instruction_type");
    L11:
        boolean r6 = Intrinsics.areEqual(r5, "28");
        android.util.LruCache<String, Boolean> r7 = q.a;
        WeakReference<com.larus.bmhome.music.instructions.g> r8 = this.a;
        Intrinsics.checkNotNullParameter(r8, "createTypeManager");
        com.larus.bmhome.music.instructions.g r9 = r8.get();
        String r10 = "";
        if (r9 == null) goto L17;
        String r12 = r9.h;
        if (r12 == null) goto L17;
        String r13 = r12;
    L18:
        LruCache r14 = r3.kb();
        String r15 = r19.getLocalMessageId();
        if (r15 == null) goto L22;
        r10 = r15;
    L22:
        e2.a.b(new e("chat", this.b, (String) r14.get(r10), r3.nb(), r20, r11, r13, "1", "1", null, Boolean.valueOf(r6), 2177), null, 3);
        return;
    L17:
        r13 = "";
        goto L18
    L10:
        r5 = null;
        goto L11
    }
}
