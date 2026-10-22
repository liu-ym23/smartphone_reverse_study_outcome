package k68;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.sami.v2.b0;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements SAMICoreCallBackListener {
    public TtsTracer a;
    public long b;
    public final StringBuilder c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SAMICoreCallBackEventType.values().length];
            r0[SAMICoreCallBackEventType.TTSSentenceStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SAMICoreCallBackEventType.TTSSentenceEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SAMICoreCallBackEventType.TTSResponse.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SAMICoreCallBackEventType.ChatResponse.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public c() {
        this.c = new StringBuilder();
    }

    public final void onMessageReceived(SAMICoreCallBackEventType r3, SAMICoreBlock r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "data");
        int r5 = b.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        return;
    L5:
        if (r5 == 2) goto L38;
        SAMICoreServerEvent r1 = null;
        if (r5 != 3) goto L9;
        Object r6 = ArraysKt.firstOrNull(r4.audioData);
        if ((r6 instanceof SAMICoreServerEvent) == false) goto L26;
        r1 = (SAMICoreServerEvent) r6;
    L26:
        if (r1 == null) goto L30;
        byte[] r7 = r1.binaryData;
        if (r7 == null) goto L30;
        int r8 = r7.length;
    L31:
        this.b += (long) r8;
        TtsTracer r9 = this.a;
        if (r9 == null) goto L43;
        r9.updateParams(new k68.a(this));
        return;
    L43:
        return;
    L30:
        r8 = 0;
        goto L31
    L9:
        if (r5 != 4) goto L44;
        Object r10 = ArraysKt.firstOrNull(r4.audioData);     // Catch: Exception -> L21
        if ((r10 instanceof SAMICoreServerEvent) == false) goto L14;
        r1 = (SAMICoreServerEvent) r10;     // Catch: Exception -> L21
    L14:
        if (r1 == null) goto L39;
        String r11 = r1.textMsg;     // Catch: Exception -> L21
        if (r11 == null) goto L40;
        this.c.append(new JSONObject(r11).optString("raw_content"));     // Catch: Exception -> L21
        final int r12 = this.c.length();     // Catch: Exception -> L21
        TtsTracer r0 = this.a;     // Catch: Exception -> L21
        if (r0 == null) goto L41;
        r0.updateParams(new k68.b(r12));     // Catch: Exception -> L21
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L21
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L21:
        e = move-exception;
        int r2 = c68.b.a;
        c68.b.c("TtsRespChecker", this + " ChatResponse parse raw_content failed. " + b0.b(r4), e);
        Unit r14 = Unit.INSTANCE;
        return;
    L44:
        return;
    }
}
