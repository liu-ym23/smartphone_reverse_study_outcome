package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.MentionChatApi;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ MentionSectionController a;

    public h(MentionSectionController r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        CharSequence r11 = (CharSequence) r10;
        Intrinsics.checkNotNullParameter(r11, "keyword");
        if (Intrinsics.areEqual(r11, BuildConfig.FLAVOR) == false) goto L6;
        return null;
    L6:
        if (this.a.l == false) goto L8;
        MainThreadPostUtils.b(new g(this));
    L8:
        MentionSectionController r1 = this.a;
        boolean r4 = true;
        CharSequence r13 = r11.subSequence(1, r11.length());
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c> r3 = r1.o;
        if (Intrinsics.areEqual(r13.toString(), BuildConfig.FLAVOR) == false) goto L19;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.c> r5 = r3;
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d r14 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d();
        r14.b(r3);
        r14.a = BuildConfig.FLAVOR;
        Response r0 = new Response();
        ((BaseResponse) r0).data = r14;
        return Observable.just(r0);
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
    L19:
        com.bytedance.android.live.network.c r2 = com.bytedance.android.live.network.c.b();
        if (r2 == null) goto L32;
        MentionChatApi r7 = (MentionChatApi) r2.e(MentionChatApi.class);
        if (r7 == null) goto L33;
        long r8 = r1.b.Z();
        if (r13.length() > 0) goto L27;
        r4 = false;
    L27:
        Observable<Response<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d>> r9 = r7.getMentionUsers(r8, r4, r13.toString());
        if (r9 != null) goto L30;
        return null;
    L30:
        return r9.map(new b(r13));
    L33:
        return null;
    L32:
        return null;
    }
}
