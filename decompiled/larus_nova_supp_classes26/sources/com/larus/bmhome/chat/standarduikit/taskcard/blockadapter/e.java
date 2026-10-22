package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.TaskCardBlock;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMCallbackExt;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.service.x;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements IIMCallbackExt<List<? extends Message>> {
    public final /* synthetic */ vn8.a a;

    public static final class a implements IIMCallback<Boolean> {
        public a() {
        }

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            ((Boolean) r1).booleanValue();
        }
    }

    public final boolean mustInMain() {
        return !y0.a();
    }

    public e(vn8.a r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        x.a.getClass();
        x r6 = x.a.a();
        TaskCardBlock r0 = this.a.d;
        if (r0 == null) goto L6;
        String r1 = r0.threadId;
        if (r1 == null) goto L6;
    L7:
        r6.b(r1, CollectionsKt.emptyList(), true, new a());
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final /* bridge */ /* synthetic */ void onLocalFinish(Object r1) {
        List r2 = (List) r1;
    }

    public final void onSuccess(Object r5) {
        List r6 = (List) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        FLogger.a.d("CotDetailMessageListComponent", "pullThreadMessageList, onSuccess: " + r6);
        x.a.getClass();
        x r0 = x.a.a();
        TaskCardBlock r1 = this.a.d;
        if (r1 == null) goto L6;
        String r2 = r1.threadId;
        if (r2 == null) goto L6;
    L7:
        r0.b(r2, r6, true, new f());
        return;
    L6:
        r2 = "";
        goto L7
    }
}
