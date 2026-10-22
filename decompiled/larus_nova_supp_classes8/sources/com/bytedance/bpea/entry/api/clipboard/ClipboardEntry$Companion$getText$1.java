package com.bytedance.bpea.entry.api.clipboard;

import android.content.ClipboardManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import f06.b;
import f06.c;
import f06.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class ClipboardEntry$Companion$getText$1 extends Lambda implements Function0<CharSequence> {
    final /* synthetic */ ClipboardManager $this_getText;

    public ClipboardEntry$Companion$getText$1(ClipboardManager r1) {
        this.$this_getText = r1;
        super(0);
    }

    public final CharSequence invoke() {
        ClipboardManager r8 = this.$this_getText;
        c r9 = new c();
        Object[] r10 = new Object[0];
        b r11 = new b();
        d r12 = r9.b(101804, "android/content/ClipboardManager", "getText", r8, r10, "java.lang.CharSequence", r11);
        if (r12.a == false) goto L5;
        r9.a(101804, "android/content/ClipboardManager", "getText", r8, r10, null, r11, false);
        return (CharSequence) r12.b;
    L5:
        CharSequence r13 = r8.getText();
        r9.a(101804, "android/content/ClipboardManager", "getText", r8, r10, r13, r11, true);
        return r13;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1570invoke() {
        return invoke();
    }
}
