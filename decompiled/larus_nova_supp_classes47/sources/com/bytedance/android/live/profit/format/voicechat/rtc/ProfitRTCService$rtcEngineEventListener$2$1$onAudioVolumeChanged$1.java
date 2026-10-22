package com.bytedance.android.live.profit.format.voicechat.rtc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ProfitRTCService$rtcEngineEventListener$2$1$onAudioVolumeChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $speakers;
    final /* synthetic */ ProfitRTCService$rtcEngineEventListener$2.a this$0;

    public ProfitRTCService$rtcEngineEventListener$2$1$onAudioVolumeChanged$1(ProfitRTCService$rtcEngineEventListener$2.a r1, List r2) {
        this.this$0 = r1;
        this.$speakers = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m154invoke() {
        int r0 = this.$speakers.size();
        String[] r1 = new String[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        ((lu0.b) ListProtector.get(this.$speakers, r3)).getClass();
        r1[r3] = null;
        r3 = r3 + 1;
        goto L3
    L5:
        int r2 = this.$speakers.size();
        boolean[] r4 = new boolean[r2];
        int r5 = 0;
    L6:
        if (r5 >= r2) goto L8;
        ((lu0.b) ListProtector.get(this.$speakers, r5)).getClass();
        r4[r5] = false;
        r5 = r5 + 1;
        goto L6
    L8:
        int r6 = this.$speakers.size();
        int[] r7 = new int[r6];
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L11;
        ((lu0.b) ListProtector.get(this.$speakers, r8)).getClass();
        r7[r8] = 0;
        r8 = r8 + 1;
        goto L9
    L11:
        int r9 = this.$speakers.size();
        int[] r10 = new int[r9];
        int r12 = 0;
    L12:
        if (r12 >= r9) goto L14;
        ((lu0.b) ListProtector.get(this.$speakers, r12)).getClass();
        r10[r12] = 0;
        r12 = r12 + 1;
        goto L12
    L14:
        Iterator<a> r13 = this.this$0.a.this$0.b.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        r13.next().u();
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m154invoke();
        return Unit.INSTANCE;
    }
}
