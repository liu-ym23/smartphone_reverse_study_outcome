package p82;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.w0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import r52.d4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends p82.a {
    public ImageView e;
    public TextView f;
    public final com.bytedance.android.livesdk.sharedpref.e<Boolean> g;
    public final String h;
    public final String i;
    public final long j;
    public CompositeDisposable k;
    public final DataCenter l;
    public final RoomContext m;
    public final Context n;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            TextView r3 = this.a.f;
            if (r3 == null) goto L6;
            UtilityKotlinExtentionsKt.t(r3);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ m a;

        public b(m r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            m r4 = this.a;
            String r0 = r4.i;
            if (r0 == null) goto L9;
            String r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.a(r0, "public_screen_panel");
            if (r1 == null) goto L9;
            IBaseLiveActionHandler r2 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r2 == null) goto L9;
            r2.handle(r4.n, r1);
        L9:
            TextView r5 = this.a.f;
            if (r5 == null) goto L13;
            UtilityKotlinExtentionsKt.t(r5);
            return;
        }
    }

    @Override // p82.a
    public final int e() {
        return 2131567221;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onDestroyView() {
        this.a = null;
        CompositeDisposable r1 = this.k;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.k = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        v0 r3 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.a;
        return com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.a(this.l, this.m);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r3) {
        super.onClick(r3);
        TextView r4 = this.f;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r4);
    L5:
        String r5 = this.h;
        if (r5 == null) goto L12;
        String r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.a(r5, "public_screen_panel");
        if (r6 == null) goto L12;
        IBaseLiveActionHandler r0 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r0 == null) goto L12;
        r0.handle(this.n, r6);
    L12:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r7 = this.c;
        if (r7 == null) goto L16;
        r7.dismissDialog();
        return;
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void c(com.bytedance.android.livesdk.interactivity.api.entity.l r3, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "bridge");
        super.c(r3, r4);
        this.k = new CompositeDisposable();
        View r5 = getView(r3.getContext());
        TextView r0 = null;
        if (r5 == null) goto L5;
        ImageView r6 = (ImageView) r5.findViewById(2131368193);
    L6:
        this.e = r6;
        View r7 = getView(r3.getContext());
        if (r7 == null) goto L9;
        r0 = (TextView) r7.findViewById(2131388723);
    L9:
        this.f = r0;
        Boolean r8 = (Boolean) this.g.getValue();
        Boolean r9 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r8, r9)) == false) goto L15;
        TextView r10 = this.f;
        if (r10 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r10);
    L14:
        RxUtilKt.c(RxUtilKt.h(Observable.timer(this.j, TimeUnit.MILLISECONDS)).subscribe(new a(this)), this.k);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r11 = this.g;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r9);
    L18:
        ImageView r13 = this.e;
        if (r13 == null) goto L22;
        r13.setOnClickListener(new b(this));
        return;
    L22:
        return;
    L15:
        TextView r14 = this.f;
        if (r14 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r14);
        goto L18
    L5:
        r6 = null;
        goto L6
    }

    public m(DataCenter r2, RoomContext r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        super(PanelItemSymbol.CREATE_CHAT_CHANNEL);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.g = new com.bytedance.android.livesdk.sharedpref.e("create_channel_bubble_" + ((User) r3.getUser().getValue()).getIdString(), Boolean.FALSE);
        d4 r5 = d4.a;
        this.h = ((w0) r5.getValue()).f();
        this.i = ((w0) r5.getValue()).n();
        this.j = 5000;
    }
}
