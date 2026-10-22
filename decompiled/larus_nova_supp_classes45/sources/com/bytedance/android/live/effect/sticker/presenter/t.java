package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.CommitAigcBackgroundImageGenerateTaskResponse;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel;
import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ long b;
    public final /* synthetic */ j c;
    public final /* synthetic */ boolean d;

    public t(s r1, long r2, StickerAigcViewModel.b.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = true;
    }

    public final void accept(Object r6) {
        BaseResponse r7 = (BaseResponse) r6;
        if (r7.statusCode != 0) goto L16;
        AigcBackgroundImageGenerateTask r0 = ((CommitAigcBackgroundImageGenerateTaskResponse) r7.data).getTask();
        Map<Long, g> r1 = this.a.b;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        if (r2.get(Long.valueOf(this.b)) != null) goto L7;
        this.a.b.put(Long.valueOf(this.b), new g(MapsKt.emptyMap()));
    L7:
        Map<Long, g> r3 = this.a.b;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        g r5 = (g) r4.get(Long.valueOf(this.b));
        if (r5 == null) goto L10;
        r5.a(r0.getTaskID(), r0);
    L10:
        j r8 = this.c;
        if (r8 == null) goto L14;
        r8.a(((CommitAigcBackgroundImageGenerateTaskResponse) r7.data).getTask());
    L14:
        if (this.d == false) goto L20;
        s.a(this.a, this.b, r0.getTaskID());
        return;
    L20:
        return;
    L16:
        j r9 = this.c;
        if (r9 == null) goto L22;
        r9.onFail();
        return;
    }
}
