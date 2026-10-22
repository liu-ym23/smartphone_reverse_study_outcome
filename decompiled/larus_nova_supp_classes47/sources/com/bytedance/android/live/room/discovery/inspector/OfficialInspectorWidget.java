package com.bytedance.android.live.room.discovery.inspector;

import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/discovery/inspector/OfficialInspectorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OfficialInspectorWidget extends LiveRecyclableWidget {
    public static final /* synthetic */ int l = 0;
    public LinearLayout a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public boolean e;
    public Disposable f;
    public Disposable g;
    public int h;
    public AnimatorSet i;
    public AnimatorSet j;
    public boolean k;

    public static final class a {
    }

    public final class b implements Observer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.inspector.OfficialInspectorWidget$onLoad$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/ies/sdk/widgets/KVData;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<KVData, Unit> {
        public AnonymousClass1(OfficialInspectorWidget r8) {
            super(1, r8, OfficialInspectorWidget.class, "onChange", "onChange(Lcom/bytedance/ies/sdk/widgets/KVData;)V", 0);
        }

        public final void invoke(KVData r5) {
            OfficialInspectorWidget r0 = (OfficialInspectorWidget) ((CallableReference) this).receiver;
            int r1 = OfficialInspectorWidget.l;
            r0.getClass();
            if (r5 == null) goto L64;
            String r2 = r5.getKey();
            if (r2.hashCode() == (-738124344)) goto L9;
            return;
        L9:
            if (r2.equals("cmd_official_inspector") == false) goto L60;
            com.bytedance.android.live.room.discovery.inspector.a r6 = (com.bytedance.android.live.room.discovery.inspector.a) r5.getData();
            if (r6 != null) goto L14;
            return;
        L14:
            if (r6.getType() != 0) goto L67;
            l r7 = r6.b;
            if (r7 != null) goto L19;
            return;
        L19:
            if (r0.isViewValid() == true) goto L22;
            return;
        L22:
            if (r0.e == false) goto L24;
            ALogger.e("OfficialInspectorWidget", "widget is showing when onShowStart");
            return;
        L24:
            r0.e = true;
            r0.wq();
            LinearLayout r3 = r0.a;
            if (r3 == null) goto L27;
            r3.setAlpha(0.0f);
        L27:
            LinearLayout r4 = r0.a;
            if (r4 == null) goto L30;
            r4.setVisibility(0);
        L30:
            ImageView r8 = r0.b;
            if (r8 == null) goto L33;
            r8.setVisibility(0);
        L33:
            TextView r9 = r0.c;
            if (r9 == null) goto L36;
            r9.setVisibility(0);
        L36:
            TextView r10 = r0.d;
            if (r10 == null) goto L39;
            r10.setVisibility(0);
        L39:
            ImageView r12 = r0.b;
            if (r12 == null) goto L42;
            r12.setImageBitmap(null);
        L42:
            r0.yq();
            if (r7.a == false) goto L50;
            TextView r13 = r0.c;
            if (r13 == null) goto L47;
            r13.setVisibility(0);
        L47:
            TextView r14 = r0.c;
            if (r14 == null) goto L53;
            r14.setText(r7.e);
        L53:
            TextView r15 = r0.d;
            if (r15 == null) goto L56;
            r15.setText(r7.f);
        L56:
            r0.f = a1.k(r7.b).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.discovery.inspector.b(r0, r7), new c(r0, r7));
            r0.g = Observable.timer(r7.d, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(-1L).subscribe(new d(r0));
            LinearLayout r16 = r0.a;
            if (r16 == null) goto L63;
            r16.setOnClickListener(new f(new OfficialInspectorWidget$onShowStart$4(r0)));
            return;
        L63:
            return;
        L50:
            TextView r17 = r0.c;
            if (r17 == null) goto L53;
            r17.setVisibility(8);
            goto L53
        L67:
            return;
        L60:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((KVData) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131568022;
    }

    public final void onUnload() {
        Disposable r0 = this.f;
        if (r0 != null) goto L5;
    L6:
        Disposable r1 = this.f;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        Disposable r2 = this.g;
        if (r2 != null) goto L12;
    L13:
        Disposable r3 = this.g;
        if (r3 == null) goto L16;
        r3.dispose();
    L16:
        this.e = false;
        this.k = false;
        wq();
        LinearLayout r4 = this.a;
        if (r4 == null) goto L20;
        r4.setOnClickListener(null);
        return;
    L20:
        return;
    L12:
        if (r2.isDisposed() == true) goto L16;
    L5:
        if (r0.isDisposed() == true) goto L9;
        goto L6
    }

    public final void wq() {
        AnimatorSet r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        AnimatorSet r1 = this.j;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.i = null;
        this.j = null;
    }

    public final void yq() {
        TextView r0 = this.c;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if (r1 == null) goto L9;
        r1.width = -2;
    L9:
        if (r1 == null) goto L11;
        r1.height = -2;
    L11:
        TextView r2 = this.c;
        if (r2 == null) goto L14;
        r2.setLayoutParams(r1);
    L14:
        TextView r3 = this.c;
        if (r3 == null) goto L17;
        r3.setText("");
    L17:
        TextView r4 = this.c;
        if (r4 == null) goto L20;
        r4.setAlpha(1.0f);
    L20:
        TextView r5 = this.c;
        if (r5 == null) goto L24;
        r5.clearAnimation();
        return;
    L24:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void xq() {
        yq();
        LinearLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.setAlpha(0.0f);
    L5:
        LinearLayout r1 = this.a;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        this.k = false;
        this.e = false;
        wq();
        ((Widget) this).dataCenter.put("cmd_official_inspector", new com.bytedance.android.live.room.discovery.inspector.a(2, null));
    }

    public OfficialInspectorWidget() {
    }

    public final void onInit(Object[] r1) {
        this.a = (LinearLayout) findViewById(2131375444);
        this.b = (ImageView) findViewById(2131375445);
        this.c = (TextView) findViewById(2131375443);
        this.d = (TextView) findViewById(2131375446);
    }

    public final void onLoad(Object[] r3) {
        ViewGroup r4 = ((Widget) this).containerView;
        if (r4 == null) goto L9;
        WidgetInfo r0 = getWidgetInfo(((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(getDataCenter()));
        if (r0 == null) goto L7;
        int r1 = r0.getContentViewHeight();
    L8:
        com.bytedance.android.live.core.utils.a1.o(r4, r1);
        goto L9
    L7:
        r1 = 156;
    L9:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L13;
        r5.observe("cmd_official_inspector", new b(new AnonymousClass1(this)));
        return;
    }
}
