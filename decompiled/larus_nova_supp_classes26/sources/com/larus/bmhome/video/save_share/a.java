package com.larus.bmhome.video.save_share;

import android.content.Context;
import com.larus.bmhome.utils.c4;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.video.save_share.a$a, reason: collision with other inner class name */
    public static final class C0044a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r15, Context r16, nr9.g r17, c4 r18, String r19, CoroutineScope r20, boolean r21, boolean r22, JSONObject r23, Map r24, String r25, boolean r26, Function4 r27, int r28) {
            if ((r28 & 32) == 0) goto L5;
            boolean r8 = true;
        L7:
            if ((r28 & 64) == 0) goto L9;
            boolean r9 = false;
        L11:
            if ((r28 & 128) == 0) goto L13;
            JSONObject r10 = null;
        L15:
            if ((r28 & 256) == 0) goto L17;
            Map r11 = null;
        L19:
            if ((r28 & 512) == 0) goto L21;
            String r12 = null;
        L23:
            if ((r28 & 1024) == 0) goto L25;
            boolean r13 = false;
        L26:
            r15.b(r16, r17, r18, r19, r20, r8, r9, r10, r11, r12, r13, r27);
            return;
        L25:
            r13 = r26;
            goto L26
        L21:
            r12 = r25;
            goto L23
        L17:
            r11 = r24;
            goto L19
        L13:
            r10 = r23;
            goto L15
        L9:
            r9 = r22;
            goto L11
        L5:
            r8 = r21;
            goto L7
        }
    }

    void b(Context r1, nr9.g r2, c4 r3, String r4, CoroutineScope r5, boolean r6, boolean r7, JSONObject r8, Map<String, String> r9, String r10, boolean r11, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r12);
}
