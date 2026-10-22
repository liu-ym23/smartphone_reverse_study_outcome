package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.bytedance.timon.permission.storage.constant.ResultCode;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SaveVideoHandler$saveVideo$1<T> implements ObservableOnSubscribe {
    public final /* synthetic */ p a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.n b;

    public static final class a implements xg7.a<Unit> {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void a(int r3, Object r4, String r5) {
            Unit r6 = (Unit) r4;
            if (r3 == ResultCode.RESULT_OK.getValue()) goto L6;
            this.a.onError(new IllegalStateException("未获取权限，" + r5));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ObservableEmitter a;

        public b(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ObservableEmitter r0 = this.a;
            r0.onNext((Uri) r2);
            this.a.onComplete();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ObservableEmitter a;

        public c(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ObservableEmitter r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public SaveVideoHandler$saveVideo$1(p r1, com.bytedance.android.livesdk.interactivity.comment.record.guide.n r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(final ObservableEmitter<Uri> r11) {
        Intrinsics.checkNotNullParameter(r11, "emmit");
        final Context r6 = this.b.getContext();
        DataCenter r0 = this.b.b;
        if (r0 == null) goto L14;
        Room r1 = z.o(r0);
        if (r1 == null) goto L14;
        final long r4 = r1.id;
        if (Build.VERSION.SDK_INT < 33) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(p.c(this.a, this.b, r4, r6).subscribe(new b(r11), new c(r11)), this.a.a);
        return;
    L9:
        Activity r2 = ContextUtil.contextToActivity(r6);
        if (r2 == null) goto L12;
        TimonMedia.withWritePermission(r2, new TimonMedia.ExtraInfo("bpea-live_LiveRecordPreviewDialog_doSaveVideoBefore", true, true, 24), new a(r11), new SaveVideoHandler$saveVideo$1$$special$$inlined$also$lambda$2(this, r11, r4, r6));
        return;
    L12:
        r11.onError(new IllegalArgumentException("context is null"));
        Unit r13 = Unit.INSTANCE;
        return;
    L14:
        r11.onError(new IllegalArgumentException("saveVideo fail, roomId is null"));
    }
}
