package n58;

import com.larus.audio.audiov3.asr.AsrCallBackType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r15, String r16, AsrCallBackType r17, String r19, String r110, long r20, String r22, String r23, int r24) {
            if ((r24 & 16) == 0) goto L5;
            long r8 = 0;
        L7:
            if ((r24 & 32) == 0) goto L9;
            String r10 = "";
        L11:
            if ((r24 & 512) == 0) goto L13;
            String r14 = null;
        L14:
            r15.a(r16, r17, r19, r110, r8, r10, 0, null, null, r14);
            return;
        L13:
            r14 = r23;
            goto L14
        L9:
            r10 = r22;
            goto L11
        L5:
            r8 = r20;
            goto L7
        }
    }

    void a(String r1, AsrCallBackType r2, String r3, String r4, long r5, String r7, int r8, String r9, String r10, String r11);

    void b(String r1, String r2);
}
