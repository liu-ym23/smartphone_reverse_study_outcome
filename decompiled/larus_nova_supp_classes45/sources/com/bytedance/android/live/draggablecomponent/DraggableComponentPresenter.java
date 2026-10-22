package com.bytedance.android.live.draggablecomponent;

import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.q;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.message.model.InfoBoxBackGround;
import com.bytedance.android.livesdk.message.model.InfoBoxMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableComponentPresenter;", "Lq46/b;", "Lcom/bytedance/android/live/draggablecomponent/DraggableComponentPresenter$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "a", "b", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableComponentPresenter extends q46.b<b> implements Observer<KVData>, l {
    public final CompositeDisposable b;
    public Disposable c;
    public vlc.d d;
    public final List<Integer> e;
    public final DataCenter f;

    public static final class a {
    }

    public interface b extends q46.a {
        void Qk(com.bytedance.android.live.draggablecomponent.f r1);
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DraggableComponentPresenter a;
        public final /* synthetic */ tlc.d b;

        public c(DraggableComponentPresenter r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Integer r6 = (Integer) r5;
            b r7 = (b) ((q46.b) this.a).a;
            int r0 = com.bytedance.android.live.draggablecomponent.f.c;
            InfoBoxMessage r1 = this.b;
            Intrinsics.checkNotNullParameter(r1, "draggableData");
            r7.Qk(new com.bytedance.android.live.draggablecomponent.f(1, r1));
        }
    }

    public static final class d implements q {
        public d() {
        }

        public final void a(py.k r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        public final void b(SpannableString r2, q.a r3) {
            Intrinsics.checkNotNullParameter(r2, "spannable");
            Intrinsics.checkNotNullParameter(r3, "info");
            LiveAnchorTeleprompterVm.Companion.getClass();
            LiveAnchorTeleprompterVm r4 = LiveAnchorTeleprompterVm.a.a();
            if (r4 == null) goto L8;
            n<Spannable> r5 = r4.getTitle();
            if (r5 == null) goto L9;
            r5.setValue(r2);
            return;
        L9:
            return;
        }
    }

    public static final class e implements q {
        public e() {
        }

        public final void a(py.k r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        public final void b(SpannableString r2, q.a r3) {
            Intrinsics.checkNotNullParameter(r2, "spannable");
            Intrinsics.checkNotNullParameter(r3, "info");
            LiveAnchorTeleprompterVm.Companion.getClass();
            LiveAnchorTeleprompterVm r4 = LiveAnchorTeleprompterVm.a.a();
            if (r4 == null) goto L8;
            n<Spannable> r5 = r4.getFoldTitle();
            if (r5 == null) goto L9;
            r5.setValue(r2);
            return;
        L9:
            return;
        }
    }

    public static final class f implements q {
        public f() {
        }

        public final void a(py.k r2) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r2, "model");
        }

        public final void b(SpannableString r2, q.a r3) {
            Intrinsics.checkNotNullParameter(r2, "spannable");
            Intrinsics.checkNotNullParameter(r3, "info");
            LiveAnchorTeleprompterVm.Companion.getClass();
            LiveAnchorTeleprompterVm r4 = LiveAnchorTeleprompterVm.a.a();
            if (r4 == null) goto L8;
            n<Spannable> r5 = r4.getContent();
            if (r5 == null) goto L9;
            r5.setValue(r2);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.b.clear();
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        vlc.d r1 = this.d;
        if (r1 == null) goto L9;
        r1.removeMessageListener(this);
        return;
    }

    public DraggableComponentPresenter(DataCenter r1) {
        this.f = r1;
        this.b = new CompositeDisposable();
        this.e = CollectionsKt.listOf(Integer.valueOf(MessageType.INFO_BOX_MESSAGE.getIntType()));
    }

    public static void c0(InfoBoxMessage r6) {
        Intrinsics.checkNotNullParameter(r6, "infoBoxSyncData");
        Long r0 = r6.scene;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.longValue() != 0) goto L22;
        Text r1 = r6.title;
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r1, null, new y(0.0f), new d());
    L10:
        Text r2 = r6.foldTitle;
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r2, null, new y(0.0f), new e());
    L13:
        Text r3 = r6.content;
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r3, null, new y(0.0f), new f());
    L16:
        LiveAnchorTeleprompterVm.Companion.getClass();
        LiveAnchorTeleprompterVm r4 = LiveAnchorTeleprompterVm.a.a();
        if (r4 == null) goto L23;
        n<InfoBoxBackGround> r5 = r4.getBackground();
        if (r5 == null) goto L24;
        r5.setValue(r6.background);
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r0.equals("data_message_manager") == false) goto L22;
        vlc.d r6 = (vlc.d) r5.getData();
        if (r6 == null) goto L30;
        this.d = r6;
        Iterator<T> r7 = this.e.iterator();
    L18:
        if (r7.hasNext() == false) goto L31;
        int r1 = ((Number) r7.next()).intValue();
        vlc.d r2 = this.d;
        if (r2 == null) goto L18;
        r2.addMessageListener(r1, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r9) {
        if ((r9 instanceof InfoBoxMessage) == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("组件消息触达 消息类型: ");
        InfoBoxMessage r1 = (InfoBoxMessage) r9;
        r0.append(r1.action);
        ALogger.i("DraggableComponentPresenter", r0.toString());
        Long r2 = r1.action;
        long r3 = 0;
        if (r2 != null) goto L9;
    L11:
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.longValue() != 1) goto L24;
        Disposable r4 = this.c;
        if (r4 == null) goto L18;
        r4.dispose();
    L18:
        Observable r5 = Observable.just(1);
        Long r6 = r1.delay;
        if (r6 == null) goto L21;
        r3 = r6.longValue();
    L21:
        this.c = r5.delay(r3, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r9));
        return;
    L24:
        return;
    L9:
        if (r2.longValue() != 0) goto L11;
        b r11 = (b) ((q46.b) this).a;
        int r7 = com.bytedance.android.live.draggablecomponent.f.c;
        Intrinsics.checkNotNullParameter(r1, "draggableData");
        r11.Qk(new com.bytedance.android.live.draggablecomponent.f(0, r1));
    }
}
